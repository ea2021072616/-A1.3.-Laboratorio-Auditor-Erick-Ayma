package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.common.internal.zzbp;
@zzzt
/* loaded from: classes.dex */
public final class zzvu implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzvg zzccw;
    private NativeAdMapper zzccx;
    private NativeCustomTemplateAd zzccy;

    public zzvu(zzvg zzvgVar) {
        this.zzccw = zzvgVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        zzbp.zzfx("onAdClicked must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdClicked.");
        try {
            this.zzccw.onAdClicked();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzbp.zzfx("onAdClicked must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdClicked.");
        try {
            this.zzccw.onAdClicked();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        zzbp.zzfx("onAdClicked must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.zzccx;
        if (this.zzccy == null) {
            if (nativeAdMapper == null) {
                zzaji.zzcs("Could not call onAdClicked since NativeAdMapper is null.");
                return;
            } else if (!nativeAdMapper.getOverrideClickHandling()) {
                zzaji.zzcb("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        zzaji.zzcb("Adapter called onAdClicked.");
        try {
            this.zzccw.onAdClicked();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        zzbp.zzfx("onAdClosed must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdClosed.");
        try {
            this.zzccw.onAdClosed();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzbp.zzfx("onAdClosed must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdClosed.");
        try {
            this.zzccw.onAdClosed();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        zzbp.zzfx("onAdClosed must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdClosed.");
        try {
            this.zzccw.onAdClosed();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        zzbp.zzfx("onAdFailedToLoad must be called on the main UI thread.");
        zzaji.zzcb(new StringBuilder(55).append("Adapter called onAdFailedToLoad with error. ").append(i).toString());
        try {
            this.zzccw.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        zzbp.zzfx("onAdFailedToLoad must be called on the main UI thread.");
        zzaji.zzcb(new StringBuilder(55).append("Adapter called onAdFailedToLoad with error ").append(i).append(".").toString());
        try {
            this.zzccw.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        zzbp.zzfx("onAdFailedToLoad must be called on the main UI thread.");
        zzaji.zzcb(new StringBuilder(55).append("Adapter called onAdFailedToLoad with error ").append(i).append(".").toString());
        try {
            this.zzccw.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        zzbp.zzfx("onAdImpression must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.zzccx;
        if (this.zzccy == null) {
            if (nativeAdMapper == null) {
                zzaji.zzcs("Could not call onAdImpression since NativeAdMapper is null. ");
                return;
            } else if (!nativeAdMapper.getOverrideImpressionRecording()) {
                zzaji.zzcb("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        zzaji.zzcb("Adapter called onAdImpression.");
        try {
            this.zzccw.onAdImpression();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdImpression.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        zzbp.zzfx("onAdLeftApplication must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdLeftApplication.");
        try {
            this.zzccw.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzbp.zzfx("onAdLeftApplication must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdLeftApplication.");
        try {
            this.zzccw.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        zzbp.zzfx("onAdLeftApplication must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdLeftApplication.");
        try {
            this.zzccw.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        zzbp.zzfx("onAdLoaded must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdLoaded.");
        try {
            this.zzccw.onAdLoaded();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzbp.zzfx("onAdLoaded must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdLoaded.");
        try {
            this.zzccw.onAdLoaded();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper) {
        zzbp.zzfx("onAdLoaded must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdLoaded.");
        this.zzccx = nativeAdMapper;
        try {
            this.zzccw.onAdLoaded();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        zzbp.zzfx("onAdOpened must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdOpened.");
        try {
            this.zzccw.onAdOpened();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzbp.zzfx("onAdOpened must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdOpened.");
        try {
            this.zzccw.onAdOpened();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        zzbp.zzfx("onAdOpened must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAdOpened.");
        try {
            this.zzccw.onAdOpened();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void zza(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        zzbp.zzfx("onAppEvent must be called on the main UI thread.");
        zzaji.zzcb("Adapter called onAppEvent.");
        try {
            this.zzccw.onAppEvent(str, str2);
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAppEvent.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd) {
        zzbp.zzfx("onAdLoaded must be called on the main UI thread.");
        String valueOf = String.valueOf(nativeCustomTemplateAd.getCustomTemplateId());
        zzaji.zzcb(valueOf.length() != 0 ? "Adapter called onAdLoaded with template id ".concat(valueOf) : new String("Adapter called onAdLoaded with template id "));
        this.zzccy = nativeCustomTemplateAd;
        try {
            this.zzccw.onAdLoaded();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        if (!(nativeCustomTemplateAd instanceof zzpw)) {
            zzaji.zzcs("Unexpected native custom template ad type.");
            return;
        }
        try {
            this.zzccw.zzb(((zzpw) nativeCustomTemplateAd).zzjz(), str);
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onCustomClick.", e);
        }
    }

    public final NativeAdMapper zzma() {
        return this.zzccx;
    }

    public final NativeCustomTemplateAd zzmb() {
        return this.zzccy;
    }
}
