package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.CompositeSequenceableLoader;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
/* loaded from: classes.dex */
final class HlsMediaPeriod implements MediaPeriod, HlsSampleStreamWrapper.Callback, Loader.Callback<ParsingLoadable<HlsPlaylist>> {
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    private final DataSource.Factory dataSourceFactory;
    private long durationUs;
    private HlsSampleStreamWrapper[] enabledSampleStreamWrappers;
    private final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    private boolean isLive;
    private final Uri manifestUri;
    private final int minLoadableRetryCount;
    private int pendingPrepareCount;
    private HlsPlaylist playlist;
    private final long preparePositionUs;
    private HlsSampleStreamWrapper[] sampleStreamWrappers;
    private boolean seenFirstTrackSelection;
    private CompositeSequenceableLoader sequenceableLoader;
    private final MediaSource.Listener sourceListener;
    private TrackGroupArray trackGroups;
    private final IdentityHashMap<SampleStream, Integer> streamWrapperIndices = new IdentityHashMap<>();
    private final TimestampAdjusterProvider timestampAdjusterProvider = new TimestampAdjusterProvider();
    private final HlsPlaylistParser manifestParser = new HlsPlaylistParser();
    private final Handler continueLoadingHandler = new Handler();
    private final Loader manifestFetcher = new Loader("Loader:ManifestFetcher");
    private final Runnable continueLoadingRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.HlsMediaPeriod.1
        @Override // java.lang.Runnable
        public void run() {
            HlsMediaPeriod.this.callback.onContinueLoadingRequested(HlsMediaPeriod.this);
        }
    };

    public HlsMediaPeriod(Uri uri, DataSource.Factory factory, int i, AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher, MediaSource.Listener listener, Allocator allocator, long j) {
        this.manifestUri = uri;
        this.dataSourceFactory = factory;
        this.minLoadableRetryCount = i;
        this.eventDispatcher = eventDispatcher;
        this.sourceListener = listener;
        this.allocator = allocator;
        this.preparePositionUs = j;
    }

    public void release() {
        this.continueLoadingHandler.removeCallbacksAndMessages(null);
        this.manifestFetcher.release();
        if (this.sampleStreamWrappers != null) {
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
                hlsSampleStreamWrapper.release();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback) {
        this.callback = callback;
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.dataSourceFactory.createDataSource(), this.manifestUri, 4, this.manifestParser);
        this.eventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.manifestFetcher.startLoading(parsingLoadable, this, this.minLoadableRetryCount));
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        if (this.sampleStreamWrappers == null) {
            this.manifestFetcher.maybeThrowError();
            return;
        }
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        boolean z;
        int[] iArr = new int[trackSelectionArr.length];
        int[] iArr2 = new int[trackSelectionArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= trackSelectionArr.length) {
                break;
            }
            iArr[i2] = sampleStreamArr[i2] == null ? -1 : this.streamWrapperIndices.get(sampleStreamArr[i2]).intValue();
            iArr2[i2] = -1;
            if (trackSelectionArr[i2] != null) {
                TrackGroup trackGroup = trackSelectionArr[i2].getTrackGroup();
                int i3 = 0;
                while (true) {
                    if (i3 < this.sampleStreamWrappers.length) {
                        if (this.sampleStreamWrappers[i3].getTrackGroups().indexOf(trackGroup) == -1) {
                            i3++;
                        } else {
                            iArr2[i2] = i3;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            i = i2 + 1;
        }
        boolean z2 = false;
        this.streamWrapperIndices.clear();
        SampleStream[] sampleStreamArr2 = new SampleStream[trackSelectionArr.length];
        SampleStream[] sampleStreamArr3 = new SampleStream[trackSelectionArr.length];
        TrackSelection[] trackSelectionArr2 = new TrackSelection[trackSelectionArr.length];
        ArrayList arrayList = new ArrayList(this.sampleStreamWrappers.length);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            z = z2;
            if (i5 >= this.sampleStreamWrappers.length) {
                break;
            }
            for (int i6 = 0; i6 < trackSelectionArr.length; i6++) {
                sampleStreamArr3[i6] = iArr[i6] == i5 ? sampleStreamArr[i6] : null;
                trackSelectionArr2[i6] = iArr2[i6] == i5 ? trackSelectionArr[i6] : null;
            }
            z2 = z | this.sampleStreamWrappers[i5].selectTracks(trackSelectionArr2, zArr, sampleStreamArr3, zArr2, !this.seenFirstTrackSelection);
            boolean z3 = false;
            for (int i7 = 0; i7 < trackSelectionArr.length; i7++) {
                if (iArr2[i7] == i5) {
                    Assertions.checkState(sampleStreamArr3[i7] != null);
                    sampleStreamArr2[i7] = sampleStreamArr3[i7];
                    z3 = true;
                    this.streamWrapperIndices.put(sampleStreamArr3[i7], Integer.valueOf(i5));
                } else if (iArr[i7] == i5) {
                    Assertions.checkState(sampleStreamArr3[i7] == null);
                }
            }
            if (z3) {
                arrayList.add(this.sampleStreamWrappers[i5]);
            }
            i4 = i5 + 1;
        }
        System.arraycopy(sampleStreamArr2, 0, sampleStreamArr, 0, sampleStreamArr2.length);
        this.enabledSampleStreamWrappers = new HlsSampleStreamWrapper[arrayList.size()];
        arrayList.toArray(this.enabledSampleStreamWrappers);
        this.sequenceableLoader = new CompositeSequenceableLoader(this.enabledSampleStreamWrappers);
        if (this.seenFirstTrackSelection && z) {
            seekToUs(j);
            for (int i8 = 0; i8 < trackSelectionArr.length; i8++) {
                if (sampleStreamArr[i8] != null) {
                    zArr2[i8] = true;
                }
            }
        }
        this.seenFirstTrackSelection = true;
        return j;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        return this.sequenceableLoader.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.sequenceableLoader.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getBufferedPositionUs() {
        long j = Long.MAX_VALUE;
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.enabledSampleStreamWrappers) {
            long bufferedPositionUs = hlsSampleStreamWrapper.getBufferedPositionUs();
            if (bufferedPositionUs != Long.MIN_VALUE) {
                j = Math.min(j, bufferedPositionUs);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        if (this.isLive) {
            j = 0;
        }
        this.timestampAdjusterProvider.reset();
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.enabledSampleStreamWrappers) {
            hlsSampleStreamWrapper.seekTo(j);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2) {
        this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
        this.playlist = parsingLoadable.getResult();
        buildAndPrepareSampleStreamWrappers();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2, boolean z) {
        this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.eventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded(), iOException, z);
        return z ? 3 : 0;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
    public void onPrepared() {
        int i = this.pendingPrepareCount - 1;
        this.pendingPrepareCount = i;
        if (i <= 0) {
            this.durationUs = this.sampleStreamWrappers[0].getDurationUs();
            this.isLive = this.sampleStreamWrappers[0].isLive();
            int i2 = 0;
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
                i2 += hlsSampleStreamWrapper.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i2];
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.sampleStreamWrappers;
            int length = hlsSampleStreamWrapperArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                HlsSampleStreamWrapper hlsSampleStreamWrapper2 = hlsSampleStreamWrapperArr[i3];
                int i5 = hlsSampleStreamWrapper2.getTrackGroups().length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    trackGroupArr[i6] = hlsSampleStreamWrapper2.getTrackGroups().get(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.trackGroups = new TrackGroupArray(trackGroupArr);
            this.callback.onPrepared(this);
            this.sourceListener.onSourceInfoRefreshed(new SinglePeriodTimeline(this.durationUs, this.durationUs, 0L, 0L, this.isLive ? false : true, this.isLive), this.playlist);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
    public void onContinueLoadingRequiredInMs(HlsSampleStreamWrapper hlsSampleStreamWrapper, long j) {
        this.continueLoadingHandler.postDelayed(this.continueLoadingRunnable, j);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        if (this.trackGroups != null) {
            this.callback.onContinueLoadingRequested(this);
        }
    }

    private void buildAndPrepareSampleStreamWrappers() {
        ArrayList arrayList;
        int i;
        String str = this.playlist.baseUri;
        if (this.playlist instanceof HlsMediaPlaylist) {
            this.sampleStreamWrappers = new HlsSampleStreamWrapper[]{buildSampleStreamWrapper(0, str, new HlsMasterPlaylist.HlsUrl[]{HlsMasterPlaylist.HlsUrl.createMediaPlaylistHlsUrl(this.playlist.baseUri)}, null, null)};
            this.pendingPrepareCount = 1;
            this.sampleStreamWrappers[0].continuePreparing();
            return;
        }
        HlsMasterPlaylist hlsMasterPlaylist = (HlsMasterPlaylist) this.playlist;
        ArrayList arrayList2 = new ArrayList(hlsMasterPlaylist.variants);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            HlsMasterPlaylist.HlsUrl hlsUrl = (HlsMasterPlaylist.HlsUrl) arrayList2.get(i2);
            if (hlsUrl.format.height > 0 || variantHasExplicitCodecWithPrefix(hlsUrl, "avc")) {
                arrayList3.add(hlsUrl);
            } else if (variantHasExplicitCodecWithPrefix(hlsUrl, "mp4a")) {
                arrayList4.add(hlsUrl);
            }
        }
        if (arrayList3.isEmpty()) {
            if (arrayList4.size() < arrayList2.size()) {
                arrayList2.removeAll(arrayList4);
            }
            arrayList = arrayList2;
        } else {
            arrayList = arrayList3;
        }
        List<HlsMasterPlaylist.HlsUrl> list = hlsMasterPlaylist.audios;
        List<HlsMasterPlaylist.HlsUrl> list2 = hlsMasterPlaylist.subtitles;
        this.sampleStreamWrappers = new HlsSampleStreamWrapper[(arrayList.isEmpty() ? 0 : 1) + list.size() + list2.size()];
        this.pendingPrepareCount = this.sampleStreamWrappers.length;
        if (arrayList.isEmpty()) {
            i = 0;
        } else {
            HlsMasterPlaylist.HlsUrl[] hlsUrlArr = new HlsMasterPlaylist.HlsUrl[arrayList.size()];
            arrayList.toArray(hlsUrlArr);
            HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper(0, str, hlsUrlArr, hlsMasterPlaylist.muxedAudioFormat, hlsMasterPlaylist.muxedCaptionFormat);
            this.sampleStreamWrappers[0] = buildSampleStreamWrapper;
            buildSampleStreamWrapper.continuePreparing();
            i = 1;
        }
        int i3 = 0;
        int i4 = i;
        while (i3 < list.size()) {
            HlsSampleStreamWrapper buildSampleStreamWrapper2 = buildSampleStreamWrapper(1, str, new HlsMasterPlaylist.HlsUrl[]{list.get(i3)}, null, null);
            this.sampleStreamWrappers[i4] = buildSampleStreamWrapper2;
            buildSampleStreamWrapper2.continuePreparing();
            i3++;
            i4++;
        }
        int i5 = 0;
        while (i5 < list2.size()) {
            HlsMasterPlaylist.HlsUrl hlsUrl2 = list2.get(i5);
            HlsSampleStreamWrapper buildSampleStreamWrapper3 = buildSampleStreamWrapper(3, str, new HlsMasterPlaylist.HlsUrl[]{hlsUrl2}, null, null);
            buildSampleStreamWrapper3.prepareSingleTrack(hlsUrl2.format);
            this.sampleStreamWrappers[i4] = buildSampleStreamWrapper3;
            i5++;
            i4++;
        }
    }

    private HlsSampleStreamWrapper buildSampleStreamWrapper(int i, String str, HlsMasterPlaylist.HlsUrl[] hlsUrlArr, Format format, Format format2) {
        return new HlsSampleStreamWrapper(i, this, new HlsChunkSource(str, hlsUrlArr, this.dataSourceFactory.createDataSource(), this.timestampAdjusterProvider), this.allocator, this.preparePositionUs, format, format2, this.minLoadableRetryCount, this.eventDispatcher);
    }

    private static boolean variantHasExplicitCodecWithPrefix(HlsMasterPlaylist.HlsUrl hlsUrl, String str) {
        String str2 = hlsUrl.format.codecs;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        String[] split = str2.split("(\\s*,\\s*)|(\\s*$)");
        for (String str3 : split) {
            if (str3.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
