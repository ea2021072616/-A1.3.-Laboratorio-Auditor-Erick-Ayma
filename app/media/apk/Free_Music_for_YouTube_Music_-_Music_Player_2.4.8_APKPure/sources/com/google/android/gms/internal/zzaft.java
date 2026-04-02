package com.google.android.gms.internal;

import android.os.Bundle;
@zzzt
/* loaded from: classes.dex */
public final class zzaft {
    private final Object mLock;
    private final zzafn zzasi;
    private final String zzcys;
    private int zzdap;
    private int zzdaq;

    private zzaft(zzafn zzafnVar, String str) {
        this.mLock = new Object();
        this.zzasi = zzafnVar;
        this.zzcys = str;
    }

    public zzaft(String str) {
        this(com.google.android.gms.ads.internal.zzbv.zzee(), str);
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.zzdap);
            bundle.putInt("pmnll", this.zzdaq);
        }
        return bundle;
    }

    public final void zzh(int i, int i2) {
        synchronized (this.mLock) {
            this.zzdap = i;
            this.zzdaq = i2;
            this.zzasi.zza(this.zzcys, this);
        }
    }
}
