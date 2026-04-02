package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
/* loaded from: classes.dex */
final class zzap implements Runnable {
    private /* synthetic */ AdOverlayInfoParcel zzapw;
    private /* synthetic */ zzao zzapx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzap(zzao zzaoVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzapx = zzaoVar;
        this.zzapw = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbv.zzdy();
        com.google.android.gms.ads.internal.overlay.zzu.zza(this.zzapx.zzapu.zzams.zzaie, this.zzapw, true);
    }
}
