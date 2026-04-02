package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzyx extends zzyr {
    private /* synthetic */ zzrn zzcmd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyx(zzys zzysVar, zzrn zzrnVar) {
        this.zzcmd = zzrnVar;
    }

    @Override // com.google.android.gms.internal.zzyr
    public final void zzd(com.google.android.gms.ads.internal.js.zzai zzaiVar) {
        zzaiVar.zza("/nativeAdCustomClick", this.zzcmd);
    }
}
