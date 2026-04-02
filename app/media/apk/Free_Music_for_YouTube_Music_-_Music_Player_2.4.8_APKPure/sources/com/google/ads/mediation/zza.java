package com.google.ads.mediation;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zza implements RewardedVideoAdListener {
    private /* synthetic */ AbstractAdViewAdapter zzgt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzgt = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewarded(RewardItem rewardItem) {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.zzgt.zzgr;
        mediationRewardedVideoAdListener.onRewarded(this.zzgt, rewardItem);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdClosed() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.zzgt.zzgr;
        mediationRewardedVideoAdListener.onAdClosed(this.zzgt);
        AbstractAdViewAdapter.zza(this.zzgt, (InterstitialAd) null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdFailedToLoad(int i) {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.zzgt.zzgr;
        mediationRewardedVideoAdListener.onAdFailedToLoad(this.zzgt, i);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdLeftApplication() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.zzgt.zzgr;
        mediationRewardedVideoAdListener.onAdLeftApplication(this.zzgt);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdLoaded() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.zzgt.zzgr;
        mediationRewardedVideoAdListener.onAdLoaded(this.zzgt);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdOpened() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.zzgt.zzgr;
        mediationRewardedVideoAdListener.onAdOpened(this.zzgt);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoStarted() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.zzgt.zzgr;
        mediationRewardedVideoAdListener.onVideoStarted(this.zzgt);
    }
}
