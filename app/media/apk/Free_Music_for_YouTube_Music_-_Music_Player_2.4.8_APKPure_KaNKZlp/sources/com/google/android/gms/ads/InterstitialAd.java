package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzlk;
/* loaded from: classes.dex */
public final class InterstitialAd {
    private final zzlk zzala;

    public InterstitialAd(Context context) {
        this.zzala = new zzlk(context);
        zzbp.zzb(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzala.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzala.getAdUnitId();
    }

    public final String getMediationAdapterClassName() {
        return this.zzala.getMediationAdapterClassName();
    }

    public final boolean isLoaded() {
        return this.zzala.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzala.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdRequest adRequest) {
        this.zzala.zza(adRequest.zzaz());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzala.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zzis)) {
            this.zzala.zza((zzis) adListener);
        } else if (adListener == null) {
            this.zzala.zza((zzis) null);
        }
    }

    public final void setAdUnitId(String str) {
        this.zzala.setAdUnitId(str);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzala.setImmersiveMode(z);
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzala.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public final void show() {
        this.zzala.show();
    }

    public final void zza(boolean z) {
        this.zzala.zza(true);
    }
}
