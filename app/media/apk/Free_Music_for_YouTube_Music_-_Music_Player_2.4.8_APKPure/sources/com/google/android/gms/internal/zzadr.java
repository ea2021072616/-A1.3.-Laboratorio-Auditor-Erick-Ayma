package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
@zzzt
/* loaded from: classes.dex */
public final class zzadr implements RewardedVideoAd {
    private final Context mContext;
    private final Object mLock = new Object();
    private final zzade zzcvx;
    private RewardedVideoAdListener zzgs;

    public zzadr(Context context, zzade zzadeVar) {
        this.zzcvx = zzadeVar;
        this.mContext = context;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy() {
        destroy(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy(Context context) {
        synchronized (this.mLock) {
            if (this.zzcvx == null) {
                return;
            }
            try {
                this.zzcvx.zzh(com.google.android.gms.dynamic.zzn.zzw(context));
            } catch (RemoteException e) {
                zzaji.zzc("Could not forward destroy to RewardedVideoAd", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getMediationAdapterClassName() {
        try {
            if (this.zzcvx != null) {
                return this.zzcvx.getMediationAdapterClassName();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.mLock) {
            rewardedVideoAdListener = this.zzgs;
        }
        return rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getUserId() {
        zzaji.zzcs("RewardedVideoAd.getUserId() is deprecated. Please do not call this method.");
        return null;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final boolean isLoaded() {
        boolean z = false;
        synchronized (this.mLock) {
            if (this.zzcvx != null) {
                try {
                    z = this.zzcvx.isLoaded();
                } catch (RemoteException e) {
                    zzaji.zzc("Could not forward isLoaded to RewardedVideoAd", e);
                }
            }
        }
        return z;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, AdRequest adRequest) {
        zzlg zzaz = adRequest.zzaz();
        synchronized (this.mLock) {
            if (this.zzcvx == null) {
                return;
            }
            try {
                this.zzcvx.zza(new zzadp(zzja.zza(this.mContext, zzaz), str));
            } catch (RemoteException e) {
                zzaji.zzc("Could not forward loadAd to RewardedVideoAd", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause() {
        pause(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause(Context context) {
        synchronized (this.mLock) {
            if (this.zzcvx == null) {
                return;
            }
            try {
                this.zzcvx.zzf(com.google.android.gms.dynamic.zzn.zzw(context));
            } catch (RemoteException e) {
                zzaji.zzc("Could not forward pause to RewardedVideoAd", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume() {
        resume(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume(Context context) {
        synchronized (this.mLock) {
            if (this.zzcvx == null) {
                return;
            }
            try {
                this.zzcvx.zzg(com.google.android.gms.dynamic.zzn.zzw(context));
            } catch (RemoteException e) {
                zzaji.zzc("Could not forward resume to RewardedVideoAd", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setImmersiveMode(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcvx != null) {
                try {
                    this.zzcvx.setImmersiveMode(z);
                } catch (RemoteException e) {
                    zzaji.zzc("Could not forward setImmersiveMode to RewardedVideoAd", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.mLock) {
            this.zzgs = rewardedVideoAdListener;
            if (this.zzcvx != null) {
                try {
                    this.zzcvx.zza(new zzado(rewardedVideoAdListener));
                } catch (RemoteException e) {
                    zzaji.zzc("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setUserId(String str) {
        zzaji.zzcs("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void show() {
        synchronized (this.mLock) {
            if (this.zzcvx == null) {
                return;
            }
            try {
                this.zzcvx.show();
            } catch (RemoteException e) {
                zzaji.zzc("Could not forward show to RewardedVideoAd", e);
            }
        }
    }
}
