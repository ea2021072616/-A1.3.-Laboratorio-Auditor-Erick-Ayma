package com.google.android.exoplayer2.util;
/* loaded from: classes.dex */
public final class StandaloneMediaClock implements MediaClock {
    private long deltaUs;
    private long positionUs;
    private boolean started;

    public void start() {
        if (!this.started) {
            this.started = true;
            this.deltaUs = elapsedRealtimeMinus(this.positionUs);
        }
    }

    public void stop() {
        if (this.started) {
            this.positionUs = elapsedRealtimeMinus(this.deltaUs);
            this.started = false;
        }
    }

    public void setPositionUs(long j) {
        this.positionUs = j;
        this.deltaUs = elapsedRealtimeMinus(j);
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        return this.started ? elapsedRealtimeMinus(this.deltaUs) : this.positionUs;
    }

    private long elapsedRealtimeMinus(long j) {
        return (android.os.SystemClock.elapsedRealtime() * 1000) - j;
    }
}
