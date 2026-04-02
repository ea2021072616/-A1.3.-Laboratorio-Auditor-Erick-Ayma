package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzaji;
@KeepForSdkWithMembers
@KeepName
/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    private CustomEventBanner zzdin;
    private CustomEventInterstitial zzdio;
    private CustomEventNative zzdip;
    private View zzhf;

    /* loaded from: classes.dex */
    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzdiq;
        private final MediationBannerListener zzgx;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzdiq = customEventAdapter;
            this.zzgx = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzaji.zzcb("Custom event adapter called onAdClicked.");
            this.zzgx.onAdClicked(this.zzdiq);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzaji.zzcb("Custom event adapter called onAdClosed.");
            this.zzgx.onAdClosed(this.zzdiq);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzaji.zzcb("Custom event adapter called onAdFailedToLoad.");
            this.zzgx.onAdFailedToLoad(this.zzdiq, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzaji.zzcb("Custom event adapter called onAdLeftApplication.");
            this.zzgx.onAdLeftApplication(this.zzdiq);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener
        public final void onAdLoaded(View view) {
            zzaji.zzcb("Custom event adapter called onAdLoaded.");
            this.zzdiq.zza(view);
            this.zzgx.onAdLoaded(this.zzdiq);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzaji.zzcb("Custom event adapter called onAdOpened.");
            this.zzgx.onAdOpened(this.zzdiq);
        }
    }

    /* loaded from: classes.dex */
    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzdiq;
        private final MediationInterstitialListener zzgy;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzdiq = customEventAdapter;
            this.zzgy = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzaji.zzcb("Custom event adapter called onAdClicked.");
            this.zzgy.onAdClicked(this.zzdiq);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzaji.zzcb("Custom event adapter called onAdClosed.");
            this.zzgy.onAdClosed(this.zzdiq);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzaji.zzcb("Custom event adapter called onFailedToReceiveAd.");
            this.zzgy.onAdFailedToLoad(this.zzdiq, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzaji.zzcb("Custom event adapter called onAdLeftApplication.");
            this.zzgy.onAdLeftApplication(this.zzdiq);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener
        public final void onAdLoaded() {
            zzaji.zzcb("Custom event adapter called onReceivedAd.");
            this.zzgy.onAdLoaded(CustomEventAdapter.this);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzaji.zzcb("Custom event adapter called onAdOpened.");
            this.zzgy.onAdOpened(this.zzdiq);
        }
    }

    /* loaded from: classes.dex */
    static class zzc implements CustomEventNativeListener {
        private final CustomEventAdapter zzdiq;
        private final MediationNativeListener zzgz;

        public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.zzdiq = customEventAdapter;
            this.zzgz = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzaji.zzcb("Custom event adapter called onAdClicked.");
            this.zzgz.onAdClicked(this.zzdiq);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzaji.zzcb("Custom event adapter called onAdClosed.");
            this.zzgz.onAdClosed(this.zzdiq);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzaji.zzcb("Custom event adapter called onAdFailedToLoad.");
            this.zzgz.onAdFailedToLoad(this.zzdiq, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdImpression() {
            zzaji.zzcb("Custom event adapter called onAdImpression.");
            this.zzgz.onAdImpression(this.zzdiq);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzaji.zzcb("Custom event adapter called onAdLeftApplication.");
            this.zzgz.onAdLeftApplication(this.zzdiq);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdLoaded(NativeAdMapper nativeAdMapper) {
            zzaji.zzcb("Custom event adapter called onAdLoaded.");
            this.zzgz.onAdLoaded(this.zzdiq, nativeAdMapper);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzaji.zzcb("Custom event adapter called onAdOpened.");
            this.zzgz.onAdOpened(this.zzdiq);
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

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.zzhf;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        if (this.zzdin != null) {
            this.zzdin.onDestroy();
        }
        if (this.zzdio != null) {
            this.zzdio.onDestroy();
        }
        if (this.zzdip != null) {
            this.zzdip.onDestroy();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        if (this.zzdin != null) {
            this.zzdin.onPause();
        }
        if (this.zzdio != null) {
            this.zzdio.onPause();
        }
        if (this.zzdip != null) {
            this.zzdip.onPause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        if (this.zzdin != null) {
            this.zzdin.onResume();
        }
        if (this.zzdio != null) {
            this.zzdio.onResume();
        }
        if (this.zzdip != null) {
            this.zzdip.onResume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdin = (CustomEventBanner) zzh(bundle.getString("class_name"));
        if (this.zzdin == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzdin.requestBannerAd(context, new zza(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdio = (CustomEventInterstitial) zzh(bundle.getString("class_name"));
        if (this.zzdio == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzdio.requestInterstitialAd(context, new zzb(this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.zzdip = (CustomEventNative) zzh(bundle.getString("class_name"));
        if (this.zzdip == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzdip.requestNativeAd(context, new zzc(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.zzdio.showInterstitial();
    }
}
