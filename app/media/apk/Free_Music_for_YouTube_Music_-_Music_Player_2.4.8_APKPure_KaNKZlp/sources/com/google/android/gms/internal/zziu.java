package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
@zzzt
/* loaded from: classes.dex */
public final class zziu extends zzjv {
    private final AdListener zzbbk;

    public zziu(AdListener adListener) {
        this.zzbbk = adListener;
    }

    public final AdListener getAdListener() {
        return this.zzbbk;
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdClicked() {
        this.zzbbk.onAdClicked();
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdClosed() {
        this.zzbbk.onAdClosed();
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdFailedToLoad(int i) {
        this.zzbbk.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdImpression() {
        this.zzbbk.onAdImpression();
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdLeftApplication() {
        this.zzbbk.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdLoaded() {
        this.zzbbk.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.zzju
    public final void onAdOpened() {
        this.zzbbk.onAdOpened();
    }
}
