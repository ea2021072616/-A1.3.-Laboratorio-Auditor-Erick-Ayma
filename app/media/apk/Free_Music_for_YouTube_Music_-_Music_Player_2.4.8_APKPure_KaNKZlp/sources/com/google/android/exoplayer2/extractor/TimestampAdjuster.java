package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.C;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    private static final long MAX_PTS_PLUS_ONE = 8589934592L;
    private final long firstSampleTimestampUs;
    private volatile long lastSampleTimestamp = C.TIME_UNSET;
    private long timestampOffsetUs;

    public TimestampAdjuster(long j) {
        this.firstSampleTimestampUs = j;
    }

    public void reset() {
        this.lastSampleTimestamp = C.TIME_UNSET;
    }

    public long adjustTsTimestamp(long j) {
        long j2;
        if (this.lastSampleTimestamp != C.TIME_UNSET) {
            long usToPts = usToPts(this.lastSampleTimestamp);
            long j3 = (IjkMediaMeta.AV_CH_WIDE_RIGHT + usToPts) / 8589934592L;
            j2 = ((j3 - 1) * 8589934592L) + j;
            long j4 = (j3 * 8589934592L) + j;
            if (Math.abs(j2 - usToPts) >= Math.abs(j4 - usToPts)) {
                j2 = j4;
            }
        } else {
            j2 = j;
        }
        return adjustSampleTimestamp(ptsToUs(j2));
    }

    public long adjustSampleTimestamp(long j) {
        if (this.lastSampleTimestamp != C.TIME_UNSET) {
            this.lastSampleTimestamp = j;
        } else {
            if (this.firstSampleTimestampUs != Long.MAX_VALUE) {
                this.timestampOffsetUs = this.firstSampleTimestampUs - j;
            }
            synchronized (this) {
                this.lastSampleTimestamp = j;
                notifyAll();
            }
        }
        return this.timestampOffsetUs + j;
    }

    public synchronized void waitUntilInitialized() throws InterruptedException {
        while (this.lastSampleTimestamp == C.TIME_UNSET) {
            wait();
        }
    }

    public static long ptsToUs(long j) {
        return (C.MICROS_PER_SECOND * j) / 90000;
    }

    public static long usToPts(long j) {
        return (90000 * j) / C.MICROS_PER_SECOND;
    }
}
