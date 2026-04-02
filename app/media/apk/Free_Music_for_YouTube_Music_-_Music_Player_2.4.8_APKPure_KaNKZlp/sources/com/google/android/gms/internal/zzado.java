package com.google.android.gms.internal;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;
@zzzt
/* loaded from: classes.dex */
public final class zzado extends zzadk {
    private final RewardedVideoAdListener zzgs;

    public zzado(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzgs = rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdClosed() {
        if (this.zzgs != null) {
            this.zzgs.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdFailedToLoad(int i) {
        if (this.zzgs != null) {
            this.zzgs.onRewardedVideoAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdLeftApplication() {
        if (this.zzgs != null) {
            this.zzgs.onRewardedVideoAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdLoaded() {
        if (this.zzgs != null) {
            this.zzgs.onRewardedVideoAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoAdOpened() {
        if (this.zzgs != null) {
            this.zzgs.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void onRewardedVideoStarted() {
        if (this.zzgs != null) {
            this.zzgs.onRewardedVideoStarted();
        }
    }

    @Override // com.google.android.gms.internal.zzadj
    public final void zza(zzadb zzadbVar) {
        if (this.zzgs != null) {
            this.zzgs.onRewarded(new zzadm(zzadbVar));
        }
    }
}
