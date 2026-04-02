package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.DefaultTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes.dex */
final class ExtractorMediaPeriod implements DefaultTrackOutput.UpstreamFormatChangedListener, ExtractorOutput, MediaPeriod, Loader.Callback<ExtractingLoadable> {
    private static final long DEFAULT_LAST_SAMPLE_DURATION_US = 10000;
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    private final DataSource dataSource;
    private long durationUs;
    private int enabledTrackCount;
    private final Handler eventHandler;
    private final ExtractorMediaSource.EventListener eventListener;
    private int extractedSamplesCountAtStartOfLoad;
    private final ExtractorHolder extractorHolder;
    private long lastSeekPositionUs;
    private boolean loadingFinished;
    private final int minLoadableRetryCount;
    private boolean notifyReset;
    private boolean prepared;
    private boolean released;
    private SeekMap seekMap;
    private boolean seenFirstTrackSelection;
    private final MediaSource.Listener sourceListener;
    private boolean[] trackEnabledStates;
    private TrackGroupArray tracks;
    private boolean tracksBuilt;
    private final Uri uri;
    private final Loader loader = new Loader("Loader:ExtractorMediaPeriod");
    private final ConditionVariable loadCondition = new ConditionVariable();
    private final Runnable maybeFinishPrepareRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.ExtractorMediaPeriod.1
        @Override // java.lang.Runnable
        public void run() {
            ExtractorMediaPeriod.this.maybeFinishPrepare();
        }
    };
    private final Runnable onContinueLoadingRequestedRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.ExtractorMediaPeriod.2
        @Override // java.lang.Runnable
        public void run() {
            if (!ExtractorMediaPeriod.this.released) {
                ExtractorMediaPeriod.this.callback.onContinueLoadingRequested(ExtractorMediaPeriod.this);
            }
        }
    };
    private final Handler handler = new Handler();
    private long pendingResetPositionUs = C.TIME_UNSET;
    private final SparseArray<DefaultTrackOutput> sampleQueues = new SparseArray<>();
    private long length = -1;

    public ExtractorMediaPeriod(Uri uri, DataSource dataSource, Extractor[] extractorArr, int i, Handler handler, ExtractorMediaSource.EventListener eventListener, MediaSource.Listener listener, Allocator allocator) {
        this.uri = uri;
        this.dataSource = dataSource;
        this.minLoadableRetryCount = i;
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.sourceListener = listener;
        this.allocator = allocator;
        this.extractorHolder = new ExtractorHolder(extractorArr, this);
    }

    public void release() {
        final ExtractorHolder extractorHolder = this.extractorHolder;
        this.loader.release(new Runnable() { // from class: com.google.android.exoplayer2.source.ExtractorMediaPeriod.3
            @Override // java.lang.Runnable
            public void run() {
                extractorHolder.release();
                int size = ExtractorMediaPeriod.this.sampleQueues.size();
                for (int i = 0; i < size; i++) {
                    ((DefaultTrackOutput) ExtractorMediaPeriod.this.sampleQueues.valueAt(i)).disable();
                }
            }
        });
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback) {
        this.callback = callback;
        this.loadCondition.open();
        startLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        Assertions.checkState(this.prepared);
        for (int i = 0; i < trackSelectionArr.length; i++) {
            if (sampleStreamArr[i] != null && (trackSelectionArr[i] == null || !zArr[i])) {
                int i2 = ((SampleStreamImpl) sampleStreamArr[i]).track;
                Assertions.checkState(this.trackEnabledStates[i2]);
                this.enabledTrackCount--;
                this.trackEnabledStates[i2] = false;
                this.sampleQueues.valueAt(i2).disable();
                sampleStreamArr[i] = null;
            }
        }
        boolean z = false;
        for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
            if (sampleStreamArr[i3] == null && trackSelectionArr[i3] != null) {
                TrackSelection trackSelection = trackSelectionArr[i3];
                Assertions.checkState(trackSelection.length() == 1);
                Assertions.checkState(trackSelection.getIndexInTrackGroup(0) == 0);
                int indexOf = this.tracks.indexOf(trackSelection.getTrackGroup());
                Assertions.checkState(!this.trackEnabledStates[indexOf]);
                this.enabledTrackCount++;
                this.trackEnabledStates[indexOf] = true;
                sampleStreamArr[i3] = new SampleStreamImpl(indexOf);
                zArr2[i3] = true;
                z = true;
            }
        }
        if (!this.seenFirstTrackSelection) {
            int size = this.sampleQueues.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!this.trackEnabledStates[i4]) {
                    this.sampleQueues.valueAt(i4).disable();
                }
            }
        }
        if (this.enabledTrackCount == 0) {
            this.notifyReset = false;
            if (this.loader.isLoading()) {
                this.loader.cancelLoading();
            }
        } else if (!this.seenFirstTrackSelection ? j != 0 : z) {
            j = seekToUs(j);
            for (int i5 = 0; i5 < sampleStreamArr.length; i5++) {
                if (sampleStreamArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.seenFirstTrackSelection = true;
        return j;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.loadingFinished) {
            return false;
        }
        boolean open = this.loadCondition.open();
        if (!this.loader.isLoading()) {
            startLoading();
            return true;
        }
        return open;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (this.notifyReset) {
            this.notifyReset = false;
            return this.lastSeekPositionUs;
        }
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long largestQueuedTimestampUs = getLargestQueuedTimestampUs();
        return largestQueuedTimestampUs == Long.MIN_VALUE ? this.lastSeekPositionUs : largestQueuedTimestampUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        if (!this.seekMap.isSeekable()) {
            j = 0;
        }
        this.lastSeekPositionUs = j;
        int size = this.sampleQueues.size();
        boolean z = !isPendingReset();
        for (int i = 0; z && i < size; i++) {
            if (this.trackEnabledStates[i]) {
                z = this.sampleQueues.valueAt(i).skipToKeyframeBefore(j);
            }
        }
        if (!z) {
            this.pendingResetPositionUs = j;
            this.loadingFinished = false;
            if (this.loader.isLoading()) {
                this.loader.cancelLoading();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.sampleQueues.valueAt(i2).reset(this.trackEnabledStates[i2]);
                }
            }
        }
        this.notifyReset = false;
        return j;
    }

    boolean isReady(int i) {
        return this.loadingFinished || !(isPendingReset() || this.sampleQueues.valueAt(i).isEmpty());
    }

    void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
    }

    int readData(int i, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer) {
        if (this.notifyReset || isPendingReset()) {
            return -3;
        }
        return this.sampleQueues.valueAt(i).readData(formatHolder, decoderInputBuffer, this.loadingFinished, this.lastSeekPositionUs);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ExtractingLoadable extractingLoadable, long j, long j2) {
        copyLengthFromLoader(extractingLoadable);
        this.loadingFinished = true;
        if (this.durationUs == C.TIME_UNSET) {
            long largestQueuedTimestampUs = getLargestQueuedTimestampUs();
            this.durationUs = largestQueuedTimestampUs == Long.MIN_VALUE ? 0L : largestQueuedTimestampUs + DEFAULT_LAST_SAMPLE_DURATION_US;
            this.sourceListener.onSourceInfoRefreshed(new SinglePeriodTimeline(this.durationUs, this.seekMap.isSeekable()), null);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ExtractingLoadable extractingLoadable, long j, long j2, boolean z) {
        copyLengthFromLoader(extractingLoadable);
        if (!z && this.enabledTrackCount > 0) {
            int size = this.sampleQueues.size();
            for (int i = 0; i < size; i++) {
                this.sampleQueues.valueAt(i).reset(this.trackEnabledStates[i]);
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(ExtractingLoadable extractingLoadable, long j, long j2, IOException iOException) {
        copyLengthFromLoader(extractingLoadable);
        notifyLoadError(iOException);
        if (isLoadableExceptionFatal(iOException)) {
            return 3;
        }
        boolean z = getExtractedSamplesCount() > this.extractedSamplesCountAtStartOfLoad;
        configureRetry(extractingLoadable);
        this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
        return !z ? 0 : 1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int i) {
        DefaultTrackOutput defaultTrackOutput = this.sampleQueues.get(i);
        if (defaultTrackOutput == null) {
            DefaultTrackOutput defaultTrackOutput2 = new DefaultTrackOutput(this.allocator);
            defaultTrackOutput2.setUpstreamFormatChangeListener(this);
            this.sampleQueues.put(i, defaultTrackOutput2);
            return defaultTrackOutput2;
        }
        return defaultTrackOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.tracksBuilt = true;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        this.seekMap = seekMap;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override // com.google.android.exoplayer2.extractor.DefaultTrackOutput.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFinishPrepare() {
        if (!this.released && !this.prepared && this.seekMap != null && this.tracksBuilt) {
            int size = this.sampleQueues.size();
            for (int i = 0; i < size; i++) {
                if (this.sampleQueues.valueAt(i).getUpstreamFormat() == null) {
                    return;
                }
            }
            this.loadCondition.close();
            TrackGroup[] trackGroupArr = new TrackGroup[size];
            this.trackEnabledStates = new boolean[size];
            this.durationUs = this.seekMap.getDurationUs();
            for (int i2 = 0; i2 < size; i2++) {
                trackGroupArr[i2] = new TrackGroup(this.sampleQueues.valueAt(i2).getUpstreamFormat());
            }
            this.tracks = new TrackGroupArray(trackGroupArr);
            this.prepared = true;
            this.sourceListener.onSourceInfoRefreshed(new SinglePeriodTimeline(this.durationUs, this.seekMap.isSeekable()), null);
            this.callback.onPrepared(this);
        }
    }

    private void copyLengthFromLoader(ExtractingLoadable extractingLoadable) {
        if (this.length != -1) {
            return;
        }
        this.length = extractingLoadable.length;
    }

    private void startLoading() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.uri, this.dataSource, this.extractorHolder, this.loadCondition);
        if (this.prepared) {
            Assertions.checkState(isPendingReset());
            if (this.durationUs != C.TIME_UNSET && this.pendingResetPositionUs >= this.durationUs) {
                this.loadingFinished = true;
                this.pendingResetPositionUs = C.TIME_UNSET;
                return;
            }
            extractingLoadable.setLoadPosition(this.seekMap.getPosition(this.pendingResetPositionUs));
            this.pendingResetPositionUs = C.TIME_UNSET;
        }
        this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
        int i = this.minLoadableRetryCount;
        if (i == -1) {
            i = (this.prepared && this.length == -1 && (this.seekMap == null || this.seekMap.getDurationUs() == C.TIME_UNSET)) ? 6 : 3;
        }
        this.loader.startLoading(extractingLoadable, this, i);
    }

    private void configureRetry(ExtractingLoadable extractingLoadable) {
        if (this.length == -1) {
            if (this.seekMap == null || this.seekMap.getDurationUs() == C.TIME_UNSET) {
                this.lastSeekPositionUs = 0L;
                this.notifyReset = this.prepared;
                int size = this.sampleQueues.size();
                for (int i = 0; i < size; i++) {
                    this.sampleQueues.valueAt(i).reset(!this.prepared || this.trackEnabledStates[i]);
                }
                extractingLoadable.setLoadPosition(0L);
            }
        }
    }

    private int getExtractedSamplesCount() {
        int size = this.sampleQueues.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.sampleQueues.valueAt(i2).getWriteIndex();
        }
        return i;
    }

    private long getLargestQueuedTimestampUs() {
        long j = Long.MIN_VALUE;
        int size = this.sampleQueues.size();
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.sampleQueues.valueAt(i).getLargestQueuedTimestampUs());
        }
        return j;
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != C.TIME_UNSET;
    }

    private boolean isLoadableExceptionFatal(IOException iOException) {
        return iOException instanceof ExtractorMediaSource.UnrecognizedInputFormatException;
    }

    private void notifyLoadError(final IOException iOException) {
        if (this.eventHandler != null && this.eventListener != null) {
            this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ExtractorMediaPeriod.4
                @Override // java.lang.Runnable
                public void run() {
                    ExtractorMediaPeriod.this.eventListener.onLoadError(iOException);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    private final class SampleStreamImpl implements SampleStream {
        private final int track;

        public SampleStreamImpl(int i) {
            this.track = i;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return ExtractorMediaPeriod.this.isReady(this.track);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            ExtractorMediaPeriod.this.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer) {
            return ExtractorMediaPeriod.this.readData(this.track, formatHolder, decoderInputBuffer);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void skipToKeyframeBefore(long j) {
            ((DefaultTrackOutput) ExtractorMediaPeriod.this.sampleQueues.valueAt(this.track)).skipToKeyframeBefore(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class ExtractingLoadable implements Loader.Loadable {
        private static final int CONTINUE_LOADING_CHECK_INTERVAL_BYTES = 1048576;
        private final DataSource dataSource;
        private final ExtractorHolder extractorHolder;
        private volatile boolean loadCanceled;
        private final ConditionVariable loadCondition;
        private final Uri uri;
        private final PositionHolder positionHolder = new PositionHolder();
        private boolean pendingExtractorSeek = true;
        private long length = -1;

        public ExtractingLoadable(Uri uri, DataSource dataSource, ExtractorHolder extractorHolder, ConditionVariable conditionVariable) {
            this.uri = (Uri) Assertions.checkNotNull(uri);
            this.dataSource = (DataSource) Assertions.checkNotNull(dataSource);
            this.extractorHolder = (ExtractorHolder) Assertions.checkNotNull(extractorHolder);
            this.loadCondition = conditionVariable;
        }

        public void setLoadPosition(long j) {
            this.positionHolder.position = j;
            this.pendingExtractorSeek = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
            this.loadCanceled = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public boolean isLoadCanceled() {
            return this.loadCanceled;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException, InterruptedException {
            DefaultExtractorInput defaultExtractorInput;
            int i;
            int i2;
            int i3 = 0;
            while (i3 == 0 && !this.loadCanceled) {
                try {
                    long j = this.positionHolder.position;
                    this.length = this.dataSource.open(new DataSpec(this.uri, j, -1L, Util.sha1(this.uri.toString())));
                    if (this.length != -1) {
                        this.length += j;
                    }
                    DefaultExtractorInput defaultExtractorInput2 = new DefaultExtractorInput(this.dataSource, j, this.length);
                    try {
                        Extractor selectExtractor = this.extractorHolder.selectExtractor(defaultExtractorInput2);
                        if (this.pendingExtractorSeek) {
                            selectExtractor.seek(j);
                            this.pendingExtractorSeek = false;
                        }
                        long j2 = j;
                        int i4 = i3;
                        while (i4 == 0) {
                            try {
                                if (this.loadCanceled) {
                                    break;
                                }
                                this.loadCondition.block();
                                i = selectExtractor.read(defaultExtractorInput2, this.positionHolder);
                                try {
                                    if (defaultExtractorInput2.getPosition() > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED + j2) {
                                        j2 = defaultExtractorInput2.getPosition();
                                        this.loadCondition.close();
                                        ExtractorMediaPeriod.this.handler.post(ExtractorMediaPeriod.this.onContinueLoadingRequestedRunnable);
                                        i4 = i;
                                    } else {
                                        i4 = i;
                                    }
                                } catch (Throwable th) {
                                    defaultExtractorInput = defaultExtractorInput2;
                                    th = th;
                                    if (i != 1 && defaultExtractorInput != null) {
                                        this.positionHolder.position = defaultExtractorInput.getPosition();
                                    }
                                    this.dataSource.close();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                i = i4;
                                defaultExtractorInput = defaultExtractorInput2;
                                th = th2;
                            }
                        }
                        if (i4 == 1) {
                            i2 = 0;
                        } else {
                            if (defaultExtractorInput2 != null) {
                                this.positionHolder.position = defaultExtractorInput2.getPosition();
                            }
                            i2 = i4;
                        }
                        this.dataSource.close();
                        i3 = i2;
                    } catch (Throwable th3) {
                        i = i3;
                        th = th3;
                        defaultExtractorInput = defaultExtractorInput2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    defaultExtractorInput = null;
                    i = i3;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ExtractorHolder {
        private Extractor extractor;
        private final ExtractorOutput extractorOutput;
        private final Extractor[] extractors;

        public ExtractorHolder(Extractor[] extractorArr, ExtractorOutput extractorOutput) {
            this.extractors = extractorArr;
            this.extractorOutput = extractorOutput;
        }

        public Extractor selectExtractor(ExtractorInput extractorInput) throws IOException, InterruptedException {
            if (this.extractor != null) {
                return this.extractor;
            }
            Extractor[] extractorArr = this.extractors;
            int length = extractorArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Extractor extractor = extractorArr[i];
                try {
                } catch (EOFException e) {
                } finally {
                    extractorInput.resetPeekPosition();
                }
                if (!extractor.sniff(extractorInput)) {
                    i++;
                } else {
                    this.extractor = extractor;
                    break;
                }
            }
            if (this.extractor == null) {
                throw new ExtractorMediaSource.UnrecognizedInputFormatException(this.extractors);
            }
            this.extractor.init(this.extractorOutput);
            return this.extractor;
        }

        public void release() {
            if (this.extractor != null) {
                this.extractor.release();
                this.extractor = null;
            }
        }
    }
}
