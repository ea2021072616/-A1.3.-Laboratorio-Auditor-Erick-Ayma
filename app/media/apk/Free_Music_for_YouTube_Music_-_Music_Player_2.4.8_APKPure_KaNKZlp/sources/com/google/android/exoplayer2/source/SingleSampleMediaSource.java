package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
/* loaded from: classes.dex */
public final class SingleSampleMediaSource implements MediaSource {
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    private final DataSource.Factory dataSourceFactory;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private final int eventSourceId;
    private final Format format;
    private final int minLoadableRetryCount;
    private final Timeline timeline;
    private final Uri uri;

    /* loaded from: classes.dex */
    public interface EventListener {
        void onLoadError(int i, IOException iOException);
    }

    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format, long j) {
        this(uri, factory, format, j, 3);
    }

    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format, long j, int i) {
        this(uri, factory, format, j, i, null, null, 0);
    }

    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format, long j, int i, Handler handler, EventListener eventListener, int i2) {
        this.uri = uri;
        this.dataSourceFactory = factory;
        this.format = format;
        this.minLoadableRetryCount = i;
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.eventSourceId = i2;
        this.timeline = new SinglePeriodTimeline(j, true);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(MediaSource.Listener listener) {
        listener.onSourceInfoRefreshed(this.timeline, null);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(int i, Allocator allocator, long j) {
        Assertions.checkArgument(i == 0);
        return new SingleSampleMediaPeriod(this.uri, this.dataSourceFactory, this.format, this.minLoadableRetryCount, this.eventHandler, this.eventListener, this.eventSourceId);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((SingleSampleMediaPeriod) mediaPeriod).release();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
    }
}
