package com.google.android.gms.internal;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
/* loaded from: classes2.dex */
final class zzwp implements Runnable {
    private /* synthetic */ AdOverlayInfoParcel zzapw;
    private /* synthetic */ zzwn zzcdk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwp(zzwn zzwnVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzcdk = zzwnVar;
        this.zzapw = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        com.google.android.gms.ads.internal.zzbv.zzdy();
        activity = this.zzcdk.zzcdi;
        com.google.android.gms.ads.internal.overlay.zzu.zza(activity, this.zzapw, true);
    }
}
