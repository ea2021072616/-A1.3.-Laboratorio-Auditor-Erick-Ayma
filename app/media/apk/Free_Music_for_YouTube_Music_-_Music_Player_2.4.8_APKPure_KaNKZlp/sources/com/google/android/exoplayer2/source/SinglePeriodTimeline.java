package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;
/* loaded from: classes.dex */
public final class SinglePeriodTimeline extends Timeline {
    private static final Object ID = new Object();
    private final boolean isDynamic;
    private final boolean isSeekable;
    private final long periodDurationUs;
    private final long windowDefaultStartPositionUs;
    private final long windowDurationUs;
    private final long windowPositionInPeriodUs;

    public SinglePeriodTimeline(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.periodDurationUs = j;
        this.windowDurationUs = j2;
        this.windowPositionInPeriodUs = j3;
        this.windowDefaultStartPositionUs = j4;
        this.isSeekable = z;
        this.isDynamic = z2;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Window getWindow(int i, Timeline.Window window, boolean z) {
        Assertions.checkIndex(i, 0, 1);
        return window.set(z ? ID : null, C.TIME_UNSET, C.TIME_UNSET, this.isSeekable, this.isDynamic, this.windowDefaultStartPositionUs, this.windowDurationUs, 0, 0, this.windowPositionInPeriodUs);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        Assertions.checkIndex(i, 0, 1);
        Object obj = z ? ID : null;
        return period.set(obj, obj, 0, this.periodDurationUs, -this.windowPositionInPeriodUs);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(Object obj) {
        return ID.equals(obj) ? 0 : -1;
    }
}
