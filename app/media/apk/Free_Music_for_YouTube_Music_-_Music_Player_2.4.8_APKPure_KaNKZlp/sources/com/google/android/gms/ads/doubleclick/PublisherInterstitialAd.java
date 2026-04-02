package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzlk;
/* loaded from: classes.dex */
public final class PublisherInterstitialAd {
    private final zzlk zzala;

    public PublisherInterstitialAd(Context context) {
        this.zzala = new zzlk(context, this);
        zzbp.zzb(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzala.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzala.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzala.getAppEventListener();
    }

    public final String getMediationAdapterClassName() {
        return this.zzala.getMediationAdapterClassName();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzala.getOnCustomRenderedAdLoadedListener();
    }

    public final boolean isLoaded() {
        return this.zzala.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzala.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzala.zza(publisherAdRequest.zzaz());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzala.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.zzala.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzala.setAppEventListener(appEventListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzala.setCorrelator(correlator);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzala.setImmersiveMode(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzala.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void show() {
        this.zzala.show();
    }
}
