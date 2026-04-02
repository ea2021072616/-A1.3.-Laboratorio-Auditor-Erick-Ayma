package com.google.android.exoplayer2.source;

import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
/* loaded from: classes.dex */
public final class LoopingMediaSource implements MediaSource {
    private static final String TAG = "LoopingMediaSource";
    private int childPeriodCount;
    private final MediaSource childSource;
    private final int loopCount;

    public LoopingMediaSource(MediaSource mediaSource) {
        this(mediaSource, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public LoopingMediaSource(MediaSource mediaSource, int i) {
        Assertions.checkArgument(i > 0);
        this.childSource = mediaSource;
        this.loopCount = i;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(final MediaSource.Listener listener) {
        this.childSource.prepareSource(new MediaSource.Listener() { // from class: com.google.android.exoplayer2.source.LoopingMediaSource.1
            @Override // com.google.android.exoplayer2.source.MediaSource.Listener
            public void onSourceInfoRefreshed(Timeline timeline, Object obj) {
                LoopingMediaSource.this.childPeriodCount = timeline.getPeriodCount();
                listener.onSourceInfoRefreshed(new LoopingTimeline(timeline, LoopingMediaSource.this.loopCount), obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.childSource.maybeThrowSourceInfoRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(int i, Allocator allocator, long j) {
        return this.childSource.createPeriod(i % this.childPeriodCount, allocator, j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        this.childSource.releasePeriod(mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        this.childSource.releaseSource();
    }

    /* loaded from: classes.dex */
    private static final class LoopingTimeline extends Timeline {
        private final int childPeriodCount;
        private final Timeline childTimeline;
        private final int childWindowCount;
        private final int loopCount;

        public LoopingTimeline(Timeline timeline, int i) {
            this.childTimeline = timeline;
            this.childPeriodCount = timeline.getPeriodCount();
            this.childWindowCount = timeline.getWindowCount();
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED / this.childPeriodCount;
            if (i > i2) {
                if (i != Integer.MAX_VALUE) {
                    Log.w(LoopingMediaSource.TAG, "Capped loops to avoid overflow: " + i + " -> " + i2);
                }
                this.loopCount = i2;
                return;
            }
            this.loopCount = i;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.childWindowCount * this.loopCount;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, boolean z) {
            this.childTimeline.getWindow(i % this.childWindowCount, window, z);
            int i2 = (i / this.childWindowCount) * this.childPeriodCount;
            window.firstPeriodIndex += i2;
            window.lastPeriodIndex = i2 + window.lastPeriodIndex;
            return window;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.childPeriodCount * this.loopCount;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            this.childTimeline.getPeriod(i % this.childPeriodCount, period, z);
            int i2 = i / this.childPeriodCount;
            period.windowIndex += this.childWindowCount * i2;
            if (z) {
                period.uid = Pair.create(Integer.valueOf(i2), period.uid);
            }
            return period;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                if (pair.first instanceof Integer) {
                    return (((Integer) pair.first).intValue() * this.childPeriodCount) + this.childTimeline.getIndexOfPeriod(pair.second);
                }
                return -1;
            }
            return -1;
        }
    }
}
