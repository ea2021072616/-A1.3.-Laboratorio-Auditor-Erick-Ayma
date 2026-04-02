package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.zzbp;
@zzzt
/* loaded from: classes.dex */
public final class zzaej implements MediationRewardedVideoAdListener {
    private final zzaeg zzcwv;

    public zzaej(zzaeg zzaegVar) {
        this.zzcwv = zzaegVar;
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbp.zzfx("onAdClicked must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdClicked.");
        try {
            this.zzcwv.zzv(com.google.android.gms.dynamic.zzn.zzw(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbp.zzfx("onAdClosed must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdClosed.");
        try {
            this.zzcwv.zzu(com.google.android.gms.dynamic.zzn.zzw(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        zzbp.zzfx("onAdFailedToLoad must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdFailedToLoad.");
        try {
            this.zzcwv.zzd(com.google.android.gms.dynamic.zzn.zzw(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbp.zzfx("onAdLeftApplication must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdLeftApplication.");
        try {
            this.zzcwv.zzw(com.google.android.gms.dynamic.zzn.zzw(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbp.zzfx("onAdLoaded must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdLoaded.");
        try {
            this.zzcwv.zzr(com.google.android.gms.dynamic.zzn.zzw(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbp.zzfx("onAdOpened must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdOpened.");
        try {
            this.zzcwv.zzs(com.google.android.gms.dynamic.zzn.zzw(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        zzbp.zzfx("onInitializationFailed must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onInitializationFailed.");
        try {
            this.zzcwv.zzc(com.google.android.gms.dynamic.zzn.zzw(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onInitializationFailed.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbp.zzfx("onInitializationSucceeded must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onInitializationSucceeded.");
        try {
            this.zzcwv.zzq(com.google.android.gms.dynamic.zzn.zzw(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onInitializationSucceeded.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        zzbp.zzfx("onRewarded must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onRewarded.");
        try {
            if (rewardItem != null) {
                this.zzcwv.zza(com.google.android.gms.dynamic.zzn.zzw(mediationRewardedVideoAdAdapter), new zzaek(rewardItem));
            } else {
                this.zzcwv.zza(com.google.android.gms.dynamic.zzn.zzw(mediationRewardedVideoAdAdapter), new zzaek("", 1));
            }
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onRewarded.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzbp.zzfx("onVideoStarted must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onVideoStarted.");
        try {
            this.zzcwv.zzt(com.google.android.gms.dynamic.zzn.zzw(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onVideoStarted.", e);
        }
    }
}
