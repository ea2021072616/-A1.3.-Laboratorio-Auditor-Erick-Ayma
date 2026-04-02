package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
/* loaded from: classes.dex */
public final class ExtractorMediaSource implements MediaSource, MediaSource.Listener {
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_LIVE = 6;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_ON_DEMAND = 3;
    public static final int MIN_RETRY_COUNT_DEFAULT_FOR_MEDIA = -1;
    private final DataSource.Factory dataSourceFactory;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private final ExtractorsFactory extractorsFactory;
    private final int minLoadableRetryCount;
    private final Timeline.Period period;
    private MediaSource.Listener sourceListener;
    private Timeline timeline;
    private boolean timelineHasDuration;
    private final Uri uri;

    /* loaded from: classes.dex */
    public interface EventListener {
        void onLoadError(IOException iOException);
    }

    /* loaded from: classes.dex */
    public static final class UnrecognizedInputFormatException extends ParserException {
        public UnrecognizedInputFormatException(Extractor[] extractorArr) {
            super("None of the available extractors (" + Util.getCommaDelimitedSimpleClassNames(extractorArr) + ") could read the stream.");
        }
    }

    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, Handler handler, EventListener eventListener) {
        this(uri, factory, extractorsFactory, -1, handler, eventListener);
    }

    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, int i, Handler handler, EventListener eventListener) {
        this.uri = uri;
        this.dataSourceFactory = factory;
        this.extractorsFactory = extractorsFactory;
        this.minLoadableRetryCount = i;
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.period = new Timeline.Period();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(MediaSource.Listener listener) {
        this.sourceListener = listener;
        this.timeline = new SinglePeriodTimeline(C.TIME_UNSET, false);
        listener.onSourceInfoRefreshed(this.timeline, null);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(int i, Allocator allocator, long j) {
        Assertions.checkArgument(i == 0);
        return new ExtractorMediaPeriod(this.uri, this.dataSourceFactory.createDataSource(), this.extractorsFactory.createExtractors(), this.minLoadableRetryCount, this.eventHandler, this.eventListener, this, allocator);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((ExtractorMediaPeriod) mediaPeriod).release();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        this.sourceListener = null;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Listener
    public void onSourceInfoRefreshed(Timeline timeline, Object obj) {
        boolean z = timeline.getPeriod(0, this.period).getDurationUs() != C.TIME_UNSET;
        if (!this.timelineHasDuration || z) {
            this.timeline = timeline;
            this.timelineHasDuration = z;
            this.sourceListener.onSourceInfoRefreshed(this.timeline, null);
        }
    }
}
