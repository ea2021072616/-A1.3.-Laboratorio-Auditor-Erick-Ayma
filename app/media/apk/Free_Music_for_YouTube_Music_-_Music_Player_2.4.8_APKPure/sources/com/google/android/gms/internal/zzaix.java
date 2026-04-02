package com.google.android.gms.internal;
@zzzt
/* loaded from: classes.dex */
public final class zzaix {
    private long zzddr;
    private long zzdds = Long.MIN_VALUE;
    private Object mLock = new Object();

    public zzaix(long j) {
        this.zzddr = j;
    }

    public final boolean tryAcquire() {
        boolean z;
        synchronized (this.mLock) {
            long elapsedRealtime = com.google.android.gms.ads.internal.zzbv.zzeg().elapsedRealtime();
            if (this.zzdds + this.zzddr > elapsedRealtime) {
                z = false;
            } else {
                this.zzdds = elapsedRealtime;
                z = true;
            }
        }
        return z;
    }
}
