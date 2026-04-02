package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
@zzzt
/* loaded from: classes.dex */
public final class zzvz<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzvg zzccw;

    public zzvz(zzvg zzvgVar) {
        this.zzccw = zzvgVar;
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaji.zzcb("Adapter called onClick.");
        zzjo.zzhu();
        if (!zzaje.zzrq()) {
            zzaji.zzcs("onClick must be called on the main UI thread.");
            zzaje.zzdee.post(new zzwa(this));
            return;
        }
        try {
            this.zzccw.onAdClicked();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaji.zzcb("Adapter called onDismissScreen.");
        zzjo.zzhu();
        if (!zzaje.zzrq()) {
            zzaji.zzcs("onDismissScreen must be called on the main UI thread.");
            zzaje.zzdee.post(new zzwd(this));
            return;
        }
        try {
            this.zzccw.onAdClosed();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaji.zzcb("Adapter called onDismissScreen.");
        zzjo.zzhu();
        if (!zzaje.zzrq()) {
            zzaji.zzcs("onDismissScreen must be called on the main UI thread.");
            zzaje.zzdee.post(new zzwi(this));
            return;
        }
        try {
            this.zzccw.onAdClosed();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        zzaji.zzcb(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error. ").append(valueOf).toString());
        zzjo.zzhu();
        if (!zzaje.zzrq()) {
            zzaji.zzcs("onFailedToReceiveAd must be called on the main UI thread.");
            zzaje.zzdee.post(new zzwe(this, errorCode));
            return;
        }
        try {
            this.zzccw.onAdFailedToLoad(zzwl.zza(errorCode));
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        zzaji.zzcb(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error ").append(valueOf).append(".").toString());
        zzjo.zzhu();
        if (!zzaje.zzrq()) {
            zzaji.zzcs("onFailedToReceiveAd must be called on the main UI thread.");
            zzaje.zzdee.post(new zzwj(this, errorCode));
            return;
        }
        try {
            this.zzccw.onAdFailedToLoad(zzwl.zza(errorCode));
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaji.zzcb("Adapter called onLeaveApplication.");
        zzjo.zzhu();
        if (!zzaje.zzrq()) {
            zzaji.zzcs("onLeaveApplication must be called on the main UI thread.");
            zzaje.zzdee.post(new zzwf(this));
            return;
        }
        try {
            this.zzccw.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaji.zzcb("Adapter called onLeaveApplication.");
        zzjo.zzhu();
        if (!zzaje.zzrq()) {
            zzaji.zzcs("onLeaveApplication must be called on the main UI thread.");
            zzaje.zzdee.post(new zzwk(this));
            return;
        }
        try {
            this.zzccw.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaji.zzcb("Adapter called onPresentScreen.");
        zzjo.zzhu();
        if (!zzaje.zzrq()) {
            zzaji.zzcs("onPresentScreen must be called on the main UI thread.");
            zzaje.zzdee.post(new zzwg(this));
            return;
        }
        try {
            this.zzccw.onAdOpened();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaji.zzcb("Adapter called onPresentScreen.");
        zzjo.zzhu();
        if (!zzaje.zzrq()) {
            zzaji.zzcs("onPresentScreen must be called on the main UI thread.");
            zzaje.zzdee.post(new zzwb(this));
            return;
        }
        try {
            this.zzccw.onAdOpened();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaji.zzcb("Adapter called onReceivedAd.");
        zzjo.zzhu();
        if (!zzaje.zzrq()) {
            zzaji.zzcs("onReceivedAd must be called on the main UI thread.");
            zzaje.zzdee.post(new zzwh(this));
            return;
        }
        try {
            this.zzccw.onAdLoaded();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaji.zzcb("Adapter called onReceivedAd.");
        zzjo.zzhu();
        if (!zzaje.zzrq()) {
            zzaji.zzcs("onReceivedAd must be called on the main UI thread.");
            zzaje.zzdee.post(new zzwc(this));
            return;
        }
        try {
            this.zzccw.onAdLoaded();
        } catch (RemoteException e) {
            zzaji.zzc("Could not call onAdLoaded.", e);
        }
    }
}
