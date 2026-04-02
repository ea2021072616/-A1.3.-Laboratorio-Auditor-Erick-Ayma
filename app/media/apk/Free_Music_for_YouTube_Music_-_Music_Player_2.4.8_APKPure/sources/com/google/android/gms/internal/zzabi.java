package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzabi implements zzakc<com.google.android.gms.ads.internal.js.zzai> {
    private /* synthetic */ zzabh zzcrf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabi(zzabh zzabhVar) {
        this.zzcrf = zzabhVar;
    }

    @Override // com.google.android.gms.internal.zzakc
    public final /* synthetic */ void zzc(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        zzrx zzrxVar;
        try {
            zzaiVar.zza("AFMA_getAdapterLessMediationAd", this.zzcrf.zzcrd);
        } catch (Exception e) {
            zzafx.zzb("Error requesting an ad url", e);
            zzrxVar = zzabf.zzcqz;
            zzrxVar.zzat(this.zzcrf.zzcre);
        }
    }
}
