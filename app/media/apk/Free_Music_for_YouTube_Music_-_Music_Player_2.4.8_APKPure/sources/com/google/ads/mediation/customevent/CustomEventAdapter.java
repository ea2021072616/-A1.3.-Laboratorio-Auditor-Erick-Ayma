package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzaji;
@KeepName
/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zzhf;
    private CustomEventBanner zzhg;
    private CustomEventInterstitial zzhh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzhi;
        private final MediationBannerListener zzhj;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzhi = customEventAdapter;
            this.zzhj = mediationBannerListener;
        }

        @Override // com.google.ads.mediation.customevent.CustomEventBannerListener
        public final void onClick() {
            zzaji.zzcb("Custom event adapter called onFailedToReceiveAd.");
            this.zzhj.onClick(this.zzhi);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onDismissScreen() {
            zzaji.zzcb("Custom event adapter called onFailedToReceiveAd.");
            this.zzhj.onDismissScreen(this.zzhi);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onFailedToReceiveAd() {
            zzaji.zzcb("Custom event adapter called onFailedToReceiveAd.");
            this.zzhj.onFailedToReceiveAd(this.zzhi, AdRequest.ErrorCode.NO_FILL);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onLeaveApplication() {
            zzaji.zzcb("Custom event adapter called onFailedToReceiveAd.");
            this.zzhj.onLeaveApplication(this.zzhi);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onPresentScreen() {
            zzaji.zzcb("Custom event adapter called onFailedToReceiveAd.");
            this.zzhj.onPresentScreen(this.zzhi);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventBannerListener
        public final void onReceivedAd(View view) {
            zzaji.zzcb("Custom event adapter called onReceivedAd.");
            this.zzhi.zza(view);
            this.zzhj.onReceivedAd(this.zzhi);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzhi;
        private final MediationInterstitialListener zzhk;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzhi = customEventAdapter;
            this.zzhk = mediationInterstitialListener;
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onDismissScreen() {
            zzaji.zzcb("Custom event adapter called onDismissScreen.");
            this.zzhk.onDismissScreen(this.zzhi);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onFailedToReceiveAd() {
            zzaji.zzcb("Custom event adapter called onFailedToReceiveAd.");
            this.zzhk.onFailedToReceiveAd(this.zzhi, AdRequest.ErrorCode.NO_FILL);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onLeaveApplication() {
            zzaji.zzcb("Custom event adapter called onLeaveApplication.");
            this.zzhk.onLeaveApplication(this.zzhi);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventListener
        public final void onPresentScreen() {
            zzaji.zzcb("Custom event adapter called onPresentScreen.");
            this.zzhk.onPresentScreen(this.zzhi);
        }

        @Override // com.google.ads.mediation.customevent.CustomEventInterstitialListener
        public final void onReceivedAd() {
            zzaji.zzcb("Custom event adapter called onReceivedAd.");
            this.zzhk.onReceivedAd(CustomEventAdapter.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(View view) {
        this.zzhf = view;
    }

    private static <T> T zzh(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            zzaji.zzcs(new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(message).toString());
            return null;
        }
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public final void destroy() {
        if (this.zzhg != null) {
            this.zzhg.destroy();
        }
        if (this.zzhh != null) {
            this.zzhh.destroy();
        }
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.zzhf;
    }

    @Override // com.google.ads.mediation.MediationAdapter
    public final Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzhg = (CustomEventBanner) zzh(customEventServerParameters.className);
        if (this.zzhg == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzhg.requestBannerAd(new zza(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzhh = (CustomEventInterstitial) zzh(customEventServerParameters.className);
        if (this.zzhh == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzhh.requestInterstitialAd(new zzb(this, mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.zzhh.showInterstitial();
    }
}
