package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzaka;
import com.google.android.gms.internal.zzakc;
import com.google.android.gms.internal.zzakd;
/* loaded from: classes.dex */
public final class zzah extends zzakd<zzai> {
    private zzy zzbzt;

    public zzah(zzy zzyVar) {
        this.zzbzt = zzyVar;
    }

    public final void finalize() {
        this.zzbzt.release();
        this.zzbzt = null;
    }

    @Override // com.google.android.gms.internal.zzakd
    public final int getStatus() {
        return this.zzbzt.getStatus();
    }

    @Override // com.google.android.gms.internal.zzakd
    public final void reject() {
        this.zzbzt.reject();
    }

    @Override // com.google.android.gms.internal.zzakd, com.google.android.gms.internal.zzajz
    public final void zza(zzakc<zzai> zzakcVar, zzaka zzakaVar) {
        this.zzbzt.zza(zzakcVar, zzakaVar);
    }

    @Override // com.google.android.gms.internal.zzakd, com.google.android.gms.internal.zzajz
    public final /* synthetic */ void zzf(Object obj) {
        this.zzbzt.zzf((zzai) obj);
    }
}
