package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class SsMediaSource implements MediaSource, Loader.Callback<ParsingLoadable<SsManifest>> {
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    private static final int MINIMUM_MANIFEST_REFRESH_PERIOD_MS = 5000;
    private static final long MIN_LIVE_DEFAULT_START_POSITION_US = 5000000;
    private final SsChunkSource.Factory chunkSourceFactory;
    private final DataSource.Factory dataSourceFactory;
    private final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    private final long livePresentationDelayMs;
    private SsManifest manifest;
    private DataSource manifestDataSource;
    private long manifestLoadStartTimestamp;
    private Loader manifestLoader;
    private final SsManifestParser manifestParser;
    private Handler manifestRefreshHandler;
    private final Uri manifestUri;
    private final ArrayList<SsMediaPeriod> mediaPeriods;
    private final int minLoadableRetryCount;
    private MediaSource.Listener sourceListener;

    public SsMediaSource(Uri uri, DataSource.Factory factory, SsChunkSource.Factory factory2, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, factory2, 3, 30000L, handler, adaptiveMediaSourceEventListener);
    }

    public SsMediaSource(Uri uri, DataSource.Factory factory, SsChunkSource.Factory factory2, int i, long j, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this.manifestUri = Util.toLowerInvariant(uri.getLastPathSegment()).equals("manifest") ? uri : Uri.withAppendedPath(uri, "Manifest");
        this.dataSourceFactory = factory;
        this.chunkSourceFactory = factory2;
        this.minLoadableRetryCount = i;
        this.livePresentationDelayMs = j;
        this.eventDispatcher = new AdaptiveMediaSourceEventListener.EventDispatcher(handler, adaptiveMediaSourceEventListener);
        this.manifestParser = new SsManifestParser();
        this.mediaPeriods = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(MediaSource.Listener listener) {
        this.sourceListener = listener;
        this.manifestDataSource = this.dataSourceFactory.createDataSource();
        this.manifestLoader = new Loader("Loader:Manifest");
        this.manifestRefreshHandler = new Handler();
        startLoadingManifest();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.manifestLoader.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(int i, Allocator allocator, long j) {
        Assertions.checkArgument(i == 0);
        SsMediaPeriod ssMediaPeriod = new SsMediaPeriod(this.manifest, this.chunkSourceFactory, this.minLoadableRetryCount, this.eventDispatcher, this.manifestLoader, allocator);
        this.mediaPeriods.add(ssMediaPeriod);
        return ssMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((SsMediaPeriod) mediaPeriod).release();
        this.mediaPeriods.remove(mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        this.sourceListener = null;
        this.manifest = null;
        this.manifestDataSource = null;
        this.manifestLoadStartTimestamp = 0L;
        if (this.manifestLoader != null) {
            this.manifestLoader.release();
            this.manifestLoader = null;
        }
        if (this.manifestRefreshHandler != null) {
            this.manifestRefreshHandler.removeCallbacksAndMessages(null);
            this.manifestRefreshHandler = null;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ParsingLoadable<SsManifest> parsingLoadable, long j, long j2) {
        SinglePeriodTimeline singlePeriodTimeline;
        this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
        this.manifest = parsingLoadable.getResult();
        this.manifestLoadStartTimestamp = j - j2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mediaPeriods.size()) {
                break;
            }
            this.mediaPeriods.get(i2).updateManifest(this.manifest);
            i = i2 + 1;
        }
        if (this.manifest.isLive) {
            long j3 = Long.MAX_VALUE;
            long j4 = Long.MIN_VALUE;
            for (int i3 = 0; i3 < this.manifest.streamElements.length; i3++) {
                SsManifest.StreamElement streamElement = this.manifest.streamElements[i3];
                if (streamElement.chunkCount > 0) {
                    j3 = Math.min(j3, streamElement.getStartTimeUs(0));
                    j4 = Math.max(j4, streamElement.getStartTimeUs(streamElement.chunkCount - 1) + streamElement.getChunkDurationUs(streamElement.chunkCount - 1));
                }
            }
            if (j3 == Long.MAX_VALUE) {
                singlePeriodTimeline = new SinglePeriodTimeline(C.TIME_UNSET, false);
            } else {
                long max = (this.manifest.dvrWindowLengthUs == C.TIME_UNSET || this.manifest.dvrWindowLengthUs <= 0) ? j3 : Math.max(j3, j4 - this.manifest.dvrWindowLengthUs);
                long j5 = j4 - max;
                long msToUs = j5 - C.msToUs(this.livePresentationDelayMs);
                if (msToUs < MIN_LIVE_DEFAULT_START_POSITION_US) {
                    msToUs = Math.min((long) MIN_LIVE_DEFAULT_START_POSITION_US, j5 / 2);
                }
                singlePeriodTimeline = new SinglePeriodTimeline(C.TIME_UNSET, j5, max, msToUs, true, true);
            }
        } else {
            singlePeriodTimeline = new SinglePeriodTimeline(this.manifest.durationUs, this.manifest.durationUs != C.TIME_UNSET);
        }
        this.sourceListener.onSourceInfoRefreshed(singlePeriodTimeline, this.manifest);
        scheduleManifestRefresh();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ParsingLoadable<SsManifest> parsingLoadable, long j, long j2, boolean z) {
        this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(ParsingLoadable<SsManifest> parsingLoadable, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.eventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.type, j, j2, parsingLoadable.bytesLoaded(), iOException, z);
        return z ? 3 : 0;
    }

    private void scheduleManifestRefresh() {
        if (this.manifest.isLive) {
            this.manifestRefreshHandler.postDelayed(new Runnable() { // from class: com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.1
                @Override // java.lang.Runnable
                public void run() {
                    SsMediaSource.this.startLoadingManifest();
                }
            }, Math.max(0L, (this.manifestLoadStartTimestamp + ExoPlayerFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) - SystemClock.elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingManifest() {
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.manifestDataSource, this.manifestUri, 4, this.manifestParser);
        this.eventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.manifestLoader.startLoading(parsingLoadable, this, this.minLoadableRetryCount));
    }
}
