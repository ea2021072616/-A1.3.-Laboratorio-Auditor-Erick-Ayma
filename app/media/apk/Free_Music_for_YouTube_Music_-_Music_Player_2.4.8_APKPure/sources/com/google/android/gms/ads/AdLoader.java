package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzaji;
import com.google.android.gms.internal.zziu;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzjx;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzlg;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.internal.zzqo;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqr;
import com.google.android.gms.internal.zzuz;
/* loaded from: classes.dex */
public class AdLoader {
    private final Context mContext;
    private final zzja zzakp;
    private final zzjx zzakq;

    /* loaded from: classes.dex */
    public static class Builder {
        private final Context mContext;
        private final zzka zzakr;

        private Builder(Context context, zzka zzkaVar) {
            this.mContext = context;
            this.zzakr = zzkaVar;
        }

        public Builder(Context context, String str) {
            this((Context) zzbp.zzb(context, "context cannot be null"), zzjo.zzhv().zzb(context, str, new zzuz()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.mContext, this.zzakr.zzcy());
            } catch (RemoteException e) {
                zzaji.zzb("Failed to build AdLoader.", e);
                return null;
            }
        }

        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzakr.zza(new zzqn(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzaji.zzc("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzakr.zza(new zzqo(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzaji.zzc("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            try {
                this.zzakr.zza(str, new zzqq(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new zzqp(onCustomClickListener));
            } catch (RemoteException e) {
                zzaji.zzc("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzakr.zza(new zzqr(onPublisherAdViewLoadedListener), new zzjb(this.mContext, adSizeArr));
            } catch (RemoteException e) {
                zzaji.zzc("Failed to add publisher banner ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzakr.zzb(new zziu(adListener));
            } catch (RemoteException e) {
                zzaji.zzc("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withCorrelator(@NonNull Correlator correlator) {
            zzbp.zzu(correlator);
            try {
                this.zzakr.zzb(correlator.zzba());
            } catch (RemoteException e) {
                zzaji.zzc("Failed to set correlator.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzakr.zza(new zzot(nativeAdOptions));
            } catch (RemoteException e) {
                zzaji.zzc("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.zzakr.zza(publisherAdViewOptions);
            } catch (RemoteException e) {
                zzaji.zzc("Failed to specify DFP banner ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, zzjx zzjxVar) {
        this(context, zzjxVar, zzja.zzbcp);
    }

    private AdLoader(Context context, zzjx zzjxVar, zzja zzjaVar) {
        this.mContext = context;
        this.zzakq = zzjxVar;
        this.zzakp = zzjaVar;
    }

    private final void zza(zzlg zzlgVar) {
        try {
            this.zzakq.zzd(zzja.zza(this.mContext, zzlgVar));
        } catch (RemoteException e) {
            zzaji.zzb("Failed to load ad.", e);
        }
    }

    public String getMediationAdapterClassName() {
        try {
            return this.zzakq.zzch();
        } catch (RemoteException e) {
            zzaji.zzc("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzakq.isLoading();
        } catch (RemoteException e) {
            zzaji.zzc("Failed to check if ad is loading.", e);
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzaz());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzaz());
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzakq.zza(zzja.zza(this.mContext, adRequest.zzaz()), i);
        } catch (RemoteException e) {
            zzaji.zzb("Failed to load ads.", e);
        }
    }
}
