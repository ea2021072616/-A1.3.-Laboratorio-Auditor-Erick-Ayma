package com.google.android.gms.internal;

import android.support.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzty {
    com.google.android.gms.ads.internal.zzam zzbxo;
    @Nullable
    zzix zzbxp;
    zzst zzbxq;
    long zzbxr;
    boolean zzbxs;
    boolean zzbxt;
    private /* synthetic */ zztx zzbxu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzty(zztx zztxVar, zzss zzssVar) {
        String str;
        this.zzbxu = zztxVar;
        str = zztxVar.zzapb;
        this.zzbxo = zzssVar.zzax(str);
        this.zzbxq = new zzst();
        zzst zzstVar = this.zzbxq;
        com.google.android.gms.ads.internal.zzam zzamVar = this.zzbxo;
        zzamVar.zza(new zzsu(zzstVar));
        zzamVar.zza(new zztc(zzstVar));
        zzamVar.zza(new zzte(zzstVar));
        zzamVar.zza(new zztg(zzstVar));
        zzamVar.zza(new zzti(zzstVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzty(zztx zztxVar, zzss zzssVar, zzix zzixVar) {
        this(zztxVar, zzssVar);
        this.zzbxp = zzixVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean load() {
        if (this.zzbxs) {
            return false;
        }
        this.zzbxt = this.zzbxo.zzb(zztv.zzj(this.zzbxp != null ? this.zzbxp : this.zzbxu.zzbxl));
        this.zzbxs = true;
        this.zzbxr = com.google.android.gms.ads.internal.zzbv.zzeg().currentTimeMillis();
        return true;
    }
}
