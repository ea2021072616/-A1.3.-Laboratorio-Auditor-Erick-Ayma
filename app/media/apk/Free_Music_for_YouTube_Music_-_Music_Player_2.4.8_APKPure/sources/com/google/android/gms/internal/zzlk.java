package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzjf;
@zzzt
/* loaded from: classes.dex */
public final class zzlk {
    private final Context mContext;
    private final zzja zzakp;
    private AppEventListener zzalv;
    private String zzapb;
    private boolean zzapq;
    private zzis zzbbj;
    private AdListener zzbbk;
    private final zzuz zzbdz;
    private Correlator zzbed;
    private zzkf zzbee;
    private OnCustomRenderedAdLoadedListener zzbef;
    private PublisherInterstitialAd zzbej;
    private boolean zzbek;
    private RewardedVideoAdListener zzgs;

    public zzlk(Context context) {
        this(context, zzja.zzbcp, null);
    }

    public zzlk(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzja.zzbcp, publisherInterstitialAd);
    }

    private zzlk(Context context, zzja zzjaVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzbdz = new zzuz();
        this.mContext = context;
        this.zzakp = zzjaVar;
        this.zzbej = publisherInterstitialAd;
    }

    private final void zzaj(String str) {
        if (this.zzbee == null) {
            throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 63).append("The ad unit ID must be set on InterstitialAd before ").append(str).append(" is called.").toString());
        }
    }

    public final AdListener getAdListener() {
        return this.zzbbk;
    }

    public final String getAdUnitId() {
        return this.zzapb;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzalv;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbee != null) {
                return this.zzbee.zzch();
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzbef;
    }

    public final boolean isLoaded() {
        try {
            if (this.zzbee == null) {
                return false;
            }
            return this.zzbee.isReady();
        } catch (RemoteException e) {
            zzaji.zzc("Failed to check if ad is ready.", e);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.zzbee == null) {
                return false;
            }
            return this.zzbee.isLoading();
        } catch (RemoteException e) {
            zzaji.zzc("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.zzbbk = adListener;
            if (this.zzbee != null) {
                this.zzbee.zza(adListener != null ? new zziu(adListener) : null);
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to set the AdListener.", e);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.zzapb != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.zzapb = str;
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzalv = appEventListener;
            if (this.zzbee != null) {
                this.zzbee.zza(appEventListener != null ? new zzjd(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to set the AppEventListener.", e);
        }
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzbed = correlator;
        try {
            if (this.zzbee != null) {
                this.zzbee.zza(this.zzbed == null ? null : this.zzbed.zzba());
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to set correlator.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzapq = z;
            if (this.zzbee != null) {
                this.zzbee.setImmersiveMode(z);
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to set immersive mode", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzbef = onCustomRenderedAdLoadedListener;
            if (this.zzbee != null) {
                this.zzbee.zza(onCustomRenderedAdLoadedListener != null ? new zznq(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzgs = rewardedVideoAdListener;
            if (this.zzbee != null) {
                this.zzbee.zza(rewardedVideoAdListener != null ? new zzado(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to set the AdListener.", e);
        }
    }

    public final void show() {
        try {
            zzaj("show");
            this.zzbee.showInterstitial();
        } catch (RemoteException e) {
            zzaji.zzc("Failed to show interstitial.", e);
        }
    }

    public final void zza(zzis zzisVar) {
        try {
            this.zzbbj = zzisVar;
            if (this.zzbee != null) {
                this.zzbee.zza(zzisVar != null ? new zzit(zzisVar) : null);
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to set the AdClickListener.", e);
        }
    }

    public final void zza(zzlg zzlgVar) {
        try {
            if (this.zzbee == null) {
                if (this.zzapb == null) {
                    zzaj("loadAd");
                }
                zzjb zzhm = this.zzbek ? zzjb.zzhm() : new zzjb();
                zzjf zzhv = zzjo.zzhv();
                Context context = this.mContext;
                this.zzbee = (zzkf) zzjf.zza(context, false, (zzjf.zza<Object>) new zzji(zzhv, context, zzhm, this.zzapb, this.zzbdz));
                if (this.zzbbk != null) {
                    this.zzbee.zza(new zziu(this.zzbbk));
                }
                if (this.zzbbj != null) {
                    this.zzbee.zza(new zzit(this.zzbbj));
                }
                if (this.zzalv != null) {
                    this.zzbee.zza(new zzjd(this.zzalv));
                }
                if (this.zzbef != null) {
                    this.zzbee.zza(new zznq(this.zzbef));
                }
                if (this.zzbed != null) {
                    this.zzbee.zza(this.zzbed.zzba());
                }
                if (this.zzgs != null) {
                    this.zzbee.zza(new zzado(this.zzgs));
                }
                this.zzbee.setImmersiveMode(this.zzapq);
            }
            if (this.zzbee.zzb(zzja.zza(this.mContext, zzlgVar))) {
                this.zzbdz.zzh(zzlgVar.zzib());
            }
        } catch (RemoteException e) {
            zzaji.zzc("Failed to load ad.", e);
        }
    }

    public final void zza(boolean z) {
        this.zzbek = true;
    }
}
