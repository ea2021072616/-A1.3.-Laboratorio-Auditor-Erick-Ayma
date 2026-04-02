package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzafp {
    private final Object mLock;
    private volatile int zzdad;
    private volatile long zzdae;

    private zzafp() {
        this.mLock = new Object();
        this.zzdad = zzafq.zzdaf;
        this.zzdae = 0L;
    }

    private final void zzg(int i, int i2) {
        zzqo();
        long currentTimeMillis = com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis();
        synchronized (this.mLock) {
            if (this.zzdad != i) {
                return;
            }
            this.zzdad = i2;
            if (this.zzdad == zzafq.zzdah) {
                this.zzdae = currentTimeMillis;
            }
        }
    }

    private final void zzqo() {
        long currentTimeMillis = com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis();
        synchronized (this.mLock) {
            if (this.zzdad == zzafq.zzdah) {
                if (this.zzdae + ((Long) com.google.android.gms.ads.internal.zzbv.zzen().zzd(zzmu.zzbpu)).longValue() <= currentTimeMillis) {
                    this.zzdad = zzafq.zzdaf;
                }
            }
        }
    }

    public final void zzaa(boolean z) {
        if (z) {
            zzg(zzafq.zzdaf, zzafq.zzdag);
        } else {
            zzg(zzafq.zzdag, zzafq.zzdaf);
        }
    }

    public final boolean zzqe() {
        zzqo();
        return this.zzdad == zzafq.zzdag;
    }

    public final boolean zzqf() {
        zzqo();
        return this.zzdad == zzafq.zzdah;
    }

    public final void zzqg() {
        zzg(zzafq.zzdag, zzafq.zzdah);
    }
}
