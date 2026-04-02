package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
/* loaded from: classes.dex */
public final class HlsMediaSource implements MediaSource {
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    private final DataSource.Factory dataSourceFactory;
    private final AdaptiveMediaSourceEventListener.EventDispatcher eventDispatcher;
    private final Uri manifestUri;
    private final int minLoadableRetryCount;
    private MediaSource.Listener sourceListener;

    public HlsMediaSource(Uri uri, DataSource.Factory factory, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this(uri, factory, 3, handler, adaptiveMediaSourceEventListener);
    }

    public HlsMediaSource(Uri uri, DataSource.Factory factory, int i, Handler handler, AdaptiveMediaSourceEventListener adaptiveMediaSourceEventListener) {
        this.manifestUri = uri;
        this.dataSourceFactory = factory;
        this.minLoadableRetryCount = i;
        this.eventDispatcher = new AdaptiveMediaSourceEventListener.EventDispatcher(handler, adaptiveMediaSourceEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(MediaSource.Listener listener) {
        this.sourceListener = listener;
        listener.onSourceInfoRefreshed(new SinglePeriodTimeline(C.TIME_UNSET, false), null);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(int i, Allocator allocator, long j) {
        Assertions.checkArgument(i == 0);
        return new HlsMediaPeriod(this.manifestUri, this.dataSourceFactory, this.minLoadableRetryCount, this.eventDispatcher, this.sourceListener, allocator, j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((HlsMediaPeriod) mediaPeriod).release();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        this.sourceListener = null;
    }
}
