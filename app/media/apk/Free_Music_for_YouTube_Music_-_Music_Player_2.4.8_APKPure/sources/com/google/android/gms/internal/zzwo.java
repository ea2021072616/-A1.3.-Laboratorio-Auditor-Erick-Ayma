package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;
/* loaded from: classes2.dex */
final class zzwo implements com.google.android.gms.ads.internal.overlay.zzw {
    private /* synthetic */ zzwn zzcdk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwo(zzwn zzwnVar) {
        this.zzcdk = zzwnVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzw
    public final void onPause() {
        zzaji.zzcb("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzw
    public final void onResume() {
        zzaji.zzcb("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzw
    public final void zzbz() {
        MediationInterstitialListener mediationInterstitialListener;
        zzaji.zzcb("AdMobCustomTabsAdapter overlay is closed.");
        mediationInterstitialListener = this.zzcdk.zzcdj;
        mediationInterstitialListener.onAdClosed(this.zzcdk);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzw
    public final void zzca() {
        MediationInterstitialListener mediationInterstitialListener;
        zzaji.zzcb("Opening AdMobCustomTabsAdapter overlay.");
        mediationInterstitialListener = this.zzcdk.zzcdj;
        mediationInterstitialListener.onAdOpened(this.zzcdk);
    }
}
