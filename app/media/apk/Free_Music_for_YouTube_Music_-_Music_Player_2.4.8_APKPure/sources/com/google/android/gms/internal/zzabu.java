package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzabu implements zzakc<com.google.android.gms.ads.internal.js.zzai> {
    private /* synthetic */ zznf zzcsd;
    private /* synthetic */ zzabt zzcse;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabu(zzabt zzabtVar, zznf zznfVar) {
        this.zzcse = zzabtVar;
        this.zzcsd = zznfVar;
    }

    @Override // com.google.android.gms.internal.zzakc
    public final /* synthetic */ void zzc(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        com.google.android.gms.ads.internal.js.zzai zzaiVar2 = zzaiVar;
        this.zzcse.zzang.zza(this.zzcsd, "jsf");
        this.zzcse.zzang.zziv();
        zzaiVar2.zza("/invalidRequest", this.zzcse.zzcsa.zzcso);
        zzaiVar2.zza("/loadAdURL", this.zzcse.zzcsa.zzcsp);
        zzaiVar2.zza("/loadAd", this.zzcse.zzcsa.zzcsq);
        try {
            zzaiVar2.zzi("AFMA_getAd", this.zzcse.zzcsc);
        } catch (Exception e) {
            zzafx.zzb("Error requesting an ad url", e);
        }
    }
}
