package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaks implements com.google.android.gms.ads.internal.overlay.zzw {
    private com.google.android.gms.ads.internal.overlay.zzw zzdfq;
    private zzakk zzdgk;

    public zzaks(zzakk zzakkVar, com.google.android.gms.ads.internal.overlay.zzw zzwVar) {
        this.zzdgk = zzakkVar;
        this.zzdfq = zzwVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzw
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzw
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzw
    public final void zzbz() {
        this.zzdfq.zzbz();
        this.zzdgk.zzrv();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzw
    public final void zzca() {
        this.zzdfq.zzca();
        this.zzdgk.zzms();
    }
}
