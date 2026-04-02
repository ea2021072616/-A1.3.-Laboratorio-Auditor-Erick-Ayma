package com.google.android.exoplayer2.source.hls;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.DefaultTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class HlsSampleStreamWrapper implements DefaultTrackOutput.UpstreamFormatChangedListener, ExtractorOutput, SequenceableLoader, Loader.Callback<Chunk> {
    private static final int PRIMARY_TYPE_AUDIO = 2;
    private static final int PRIMARY_TYPE_NONE = 0;
    private static final int PRIMARY_TYPE_TEXT = 1;
    private static final int PRIMARY_TYPE_VIDEO = 3;
    private final Allocator allocator;
    private final Callback callback;
    private final HlsChunkSource chunkSource;
    private Format downstreamTrackFormat;
    private int enabledTrackCount;
    private final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    private boolean[] groupEnabledStates;
    private long lastSeekPositionUs;
    private boolean loadingFinished;
    private final int minLoadableRetryCount;
    private final Format muxedAudioFormat;
    private final Format muxedCaptionFormat;
    private long pendingResetPositionUs;
    private boolean prepared;
    private int primaryTrackGroupIndex;
    private boolean released;
    private boolean sampleQueuesBuilt;
    private TrackGroupArray trackGroups;
    private final int trackType;
    private int upstreamChunkUid;
    private final Loader loader = new Loader("Loader:HlsSampleStreamWrapper");
    private final HlsChunkSource.HlsChunkHolder nextChunkHolder = new HlsChunkSource.HlsChunkHolder();
    private final SparseArray<DefaultTrackOutput> sampleQueues = new SparseArray<>();
    private final LinkedList<HlsMediaChunk> mediaChunks = new LinkedList<>();
    private final Runnable maybeFinishPrepareRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.1
        @Override // java.lang.Runnable
        public void run() {
            HlsSampleStreamWrapper.this.maybeFinishPrepare();
        }
    };
    private final Handler handler = new Handler();

    /* loaded from: classes.dex */
    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void onContinueLoadingRequiredInMs(HlsSampleStreamWrapper hlsSampleStreamWrapper, long j);

        void onPrepared();
    }

    public HlsSampleStreamWrapper(int i, Callback callback, HlsChunkSource hlsChunkSource, Allocator allocator, long j, Format format, Format format2, int i2, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher) {
        this.trackType = i;
        this.callback = callback;
        this.chunkSource = hlsChunkSource;
        this.allocator = allocator;
        this.muxedAudioFormat = format;
        this.muxedCaptionFormat = format2;
        this.minLoadableRetryCount = i2;
        this.eventDispatcher = eventDispatcher;
        this.lastSeekPositionUs = j;
        this.pendingResetPositionUs = j;
    }

    public void continuePreparing() {
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
        }
    }

    public void prepareSingleTrack(Format format) {
        track(0).format(format);
        this.sampleQueuesBuilt = true;
        maybeFinishPrepare();
    }

    public void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
    }

    public long getDurationUs() {
        return this.chunkSource.getDurationUs();
    }

    public boolean isLive() {
        return this.chunkSource.isLive();
    }

    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public boolean selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, boolean z) {
        Assertions.checkState(this.prepared);
        for (int i = 0; i < trackSelectionArr.length; i++) {
            if (sampleStreamArr[i] != null && (trackSelectionArr[i] == null || !zArr[i])) {
                int i2 = ((HlsSampleStream) sampleStreamArr[i]).group;
                setTrackGroupEnabledState(i2, false);
                this.sampleQueues.valueAt(i2).disable();
                sampleStreamArr[i] = null;
            }
        }
        boolean z2 = false;
        for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
            if (sampleStreamArr[i3] == null && trackSelectionArr[i3] != null) {
                TrackSelection trackSelection = trackSelectionArr[i3];
                int indexOf = this.trackGroups.indexOf(trackSelection.getTrackGroup());
                setTrackGroupEnabledState(indexOf, true);
                if (indexOf == this.primaryTrackGroupIndex) {
                    this.chunkSource.selectTracks(trackSelection);
                }
                sampleStreamArr[i3] = new HlsSampleStream(this, indexOf);
                zArr2[i3] = true;
                z2 = true;
            }
        }
        if (z) {
            int size = this.sampleQueues.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!this.groupEnabledStates[i4]) {
                    this.sampleQueues.valueAt(i4).disable();
                }
            }
        }
        if (this.enabledTrackCount == 0) {
            this.chunkSource.reset();
            this.downstreamTrackFormat = null;
            this.mediaChunks.clear();
            if (this.loader.isLoading()) {
                this.loader.cancelLoading();
            }
        }
        return z2;
    }

    public void seekTo(long j) {
        this.lastSeekPositionUs = j;
        this.pendingResetPositionUs = j;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
            return;
        }
        int size = this.sampleQueues.size();
        for (int i = 0; i < size; i++) {
            this.sampleQueues.valueAt(i).reset(this.groupEnabledStates[i]);
        }
    }

    public long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long j = this.lastSeekPositionUs;
        HlsMediaChunk last = this.mediaChunks.getLast();
        if (!last.isLoadCompleted()) {
            last = this.mediaChunks.size() > 1 ? this.mediaChunks.get(this.mediaChunks.size() - 2) : null;
        }
        long max = last != null ? Math.max(j, last.endTimeUs) : j;
        int size = this.sampleQueues.size();
        long j2 = max;
        for (int i = 0; i < size; i++) {
            j2 = Math.max(j2, this.sampleQueues.valueAt(i).getLargestQueuedTimestampUs());
        }
        return j2;
    }

    public void release() {
        int size = this.sampleQueues.size();
        for (int i = 0; i < size; i++) {
            this.sampleQueues.valueAt(i).disable();
        }
        this.loader.release();
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    public long getLargestQueuedTimestampUs() {
        long j = Long.MIN_VALUE;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.sampleQueues.size()) {
                j = Math.max(j, this.sampleQueues.valueAt(i2).getLargestQueuedTimestampUs());
                i = i2 + 1;
            } else {
                return j;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isReady(int i) {
        return this.loadingFinished || !(isPendingReset() || this.sampleQueues.valueAt(i).isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        this.chunkSource.maybeThrowError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int readData(int i, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer) {
        if (isPendingReset()) {
            return -3;
        }
        while (this.mediaChunks.size() > 1 && finishedReadingChunk(this.mediaChunks.getFirst())) {
            this.mediaChunks.removeFirst();
        }
        HlsMediaChunk first = this.mediaChunks.getFirst();
        Format format = first.trackFormat;
        if (!format.equals(this.downstreamTrackFormat)) {
            this.eventDispatcher.downstreamFormatChanged(this.trackType, format, first.trackSelectionReason, first.trackSelectionData, first.startTimeUs);
        }
        this.downstreamTrackFormat = format;
        return this.sampleQueues.valueAt(i).readData(formatHolder, decoderInputBuffer, this.loadingFinished, this.lastSeekPositionUs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void skipToKeyframeBefore(int i, long j) {
        this.sampleQueues.valueAt(i).skipToKeyframeBefore(j);
    }

    private boolean finishedReadingChunk(HlsMediaChunk hlsMediaChunk) {
        int i = hlsMediaChunk.uid;
        for (int i2 = 0; i2 < this.sampleQueues.size(); i2++) {
            if (this.groupEnabledStates[i2] && this.sampleQueues.valueAt(i2).peekSourceId() == i) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.loader.isLoading()) {
            return false;
        }
        HlsChunkSource hlsChunkSource = this.chunkSource;
        HlsMediaChunk last = this.mediaChunks.isEmpty() ? null : this.mediaChunks.getLast();
        if (this.pendingResetPositionUs != C.TIME_UNSET) {
            j = this.pendingResetPositionUs;
        }
        hlsChunkSource.getNextChunk(last, j, this.nextChunkHolder);
        boolean z = this.nextChunkHolder.endOfStream;
        Chunk chunk = this.nextChunkHolder.chunk;
        long j2 = this.nextChunkHolder.retryInMs;
        this.nextChunkHolder.clear();
        if (z) {
            this.loadingFinished = true;
            return true;
        } else if (chunk == null) {
            if (j2 != C.TIME_UNSET) {
                Assertions.checkState(this.chunkSource.isLive());
                this.callback.onContinueLoadingRequiredInMs(this, j2);
            }
            return false;
        } else {
            if (isMediaChunk(chunk)) {
                this.pendingResetPositionUs = C.TIME_UNSET;
                HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) chunk;
                hlsMediaChunk.init(this);
                this.mediaChunks.add(hlsMediaChunk);
            } else if (chunk instanceof HlsInitializationChunk) {
                ((HlsInitializationChunk) chunk).init(this);
            }
            this.eventDispatcher.loadStarted(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.loader.startLoading(chunk, this, this.minLoadableRetryCount));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return this.mediaChunks.getLast().endTimeUs;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(Chunk chunk, long j, long j2) {
        this.chunkSource.onChunkLoadCompleted(chunk);
        this.eventDispatcher.loadCompleted(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded());
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
        } else {
            this.callback.onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(Chunk chunk, long j, long j2, boolean z) {
        this.eventDispatcher.loadCanceled(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded());
        if (!z) {
            int size = this.sampleQueues.size();
            for (int i = 0; i < size; i++) {
                this.sampleQueues.valueAt(i).reset(this.groupEnabledStates[i]);
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(Chunk chunk, long j, long j2, IOException iOException) {
        long bytesLoaded = chunk.bytesLoaded();
        boolean isMediaChunk = isMediaChunk(chunk);
        boolean z = false;
        if (this.chunkSource.onChunkLoadError(chunk, !isMediaChunk || bytesLoaded == 0, iOException)) {
            if (isMediaChunk) {
                Assertions.checkState(this.mediaChunks.removeLast() == chunk);
                if (this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                }
            }
            z = true;
        }
        this.eventDispatcher.loadError(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j, j2, chunk.bytesLoaded(), iOException, z);
        if (z) {
            if (!this.prepared) {
                continueLoading(this.lastSeekPositionUs);
            } else {
                this.callback.onContinueLoadingRequested(this);
            }
            return 2;
        }
        return 0;
    }

    public void init(int i, boolean z) {
        this.upstreamChunkUid = i;
        for (int i2 = 0; i2 < this.sampleQueues.size(); i2++) {
            this.sampleQueues.valueAt(i2).sourceId(i);
        }
        if (z) {
            for (int i3 = 0; i3 < this.sampleQueues.size(); i3++) {
                this.sampleQueues.valueAt(i3).splice();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public DefaultTrackOutput track(int i) {
        if (this.sampleQueues.indexOfKey(i) >= 0) {
            return this.sampleQueues.get(i);
        }
        DefaultTrackOutput defaultTrackOutput = new DefaultTrackOutput(this.allocator);
        defaultTrackOutput.setUpstreamFormatChangeListener(this);
        defaultTrackOutput.sourceId(this.upstreamChunkUid);
        this.sampleQueues.put(i, defaultTrackOutput);
        return defaultTrackOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.sampleQueuesBuilt = true;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
    }

    @Override // com.google.android.exoplayer2.extractor.DefaultTrackOutput.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFinishPrepare() {
        if (!this.released && !this.prepared && this.sampleQueuesBuilt) {
            int size = this.sampleQueues.size();
            for (int i = 0; i < size; i++) {
                if (this.sampleQueues.valueAt(i).getUpstreamFormat() == null) {
                    return;
                }
            }
            buildTracks();
            this.prepared = true;
            this.callback.onPrepared();
        }
    }

    private void buildTracks() {
        char c2;
        int i;
        char c3;
        int size = this.sampleQueues.size();
        int i2 = 0;
        int i3 = -1;
        char c4 = 0;
        while (i2 < size) {
            String str = this.sampleQueues.valueAt(i2).getUpstreamFormat().sampleMimeType;
            if (MimeTypes.isVideo(str)) {
                c2 = 3;
            } else if (MimeTypes.isAudio(str)) {
                c2 = 2;
            } else {
                c2 = MimeTypes.isText(str) ? (char) 1 : (char) 0;
            }
            if (c2 > c4) {
                c3 = c2;
                i = i2;
            } else if (c2 != c4 || i3 == -1) {
                i = i3;
                c3 = c4;
            } else {
                i = -1;
                c3 = c4;
            }
            i2++;
            c4 = c3;
            i3 = i;
        }
        TrackGroup trackGroup = this.chunkSource.getTrackGroup();
        int i4 = trackGroup.length;
        this.primaryTrackGroupIndex = -1;
        this.groupEnabledStates = new boolean[size];
        TrackGroup[] trackGroupArr = new TrackGroup[size];
        for (int i5 = 0; i5 < size; i5++) {
            Format upstreamFormat = this.sampleQueues.valueAt(i5).getUpstreamFormat();
            if (i5 == i3) {
                Format[] formatArr = new Format[i4];
                for (int i6 = 0; i6 < i4; i6++) {
                    formatArr[i6] = deriveFormat(trackGroup.getFormat(i6), upstreamFormat);
                }
                trackGroupArr[i5] = new TrackGroup(formatArr);
                this.primaryTrackGroupIndex = i5;
            } else {
                Format format = null;
                if (c4 == 3) {
                    if (MimeTypes.isAudio(upstreamFormat.sampleMimeType)) {
                        format = this.muxedAudioFormat;
                    } else if (MimeTypes.APPLICATION_CEA608.equals(upstreamFormat.sampleMimeType)) {
                        format = this.muxedCaptionFormat;
                    }
                }
                trackGroupArr[i5] = new TrackGroup(deriveFormat(format, upstreamFormat));
            }
        }
        this.trackGroups = new TrackGroupArray(trackGroupArr);
    }

    private void setTrackGroupEnabledState(int i, boolean z) {
        Assertions.checkState(this.groupEnabledStates[i] != z);
        this.groupEnabledStates[i] = z;
        this.enabledTrackCount += z ? 1 : -1;
    }

    private static Format deriveFormat(Format format, Format format2) {
        if (format != null) {
            String str = null;
            int trackType = MimeTypes.getTrackType(format2.sampleMimeType);
            if (trackType == 1) {
                str = getAudioCodecs(format.codecs);
            } else if (trackType == 2) {
                str = getVideoCodecs(format.codecs);
            }
            return format2.copyWithContainerInfo(format.id, str, format.bitrate, format.width, format.height, format.selectionFlags, format.language);
        }
        return format2;
    }

    private boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof HlsMediaChunk;
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != C.TIME_UNSET;
    }

    private static String getAudioCodecs(String str) {
        return getCodecsOfType(str, 1);
    }

    private static String getVideoCodecs(String str) {
        return getCodecsOfType(str, 2);
    }

    private static String getCodecsOfType(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (i == MimeTypes.getTrackTypeOfCodec(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}
