package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.internal.zzaje;
import com.google.android.gms.internal.zzaji;
import com.google.android.gms.internal.zzalt;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzzt;
import java.util.Date;
import java.util.Set;
@zzzt
/* loaded from: classes.dex */
public abstract class AbstractAdViewAdapter implements com.google.android.gms.ads.mediation.MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, com.google.android.gms.ads.mediation.zza, MediationRewardedVideoAdAdapter, zzalt {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzgm;
    private InterstitialAd zzgn;
    private AdLoader zzgo;
    private Context zzgp;
    private InterstitialAd zzgq;
    private MediationRewardedVideoAdListener zzgr;
    private RewardedVideoAdListener zzgs = new com.google.ads.mediation.zza(this);

    /* loaded from: classes.dex */
    static class zza extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd zzgu;

        public zza(NativeAppInstallAd nativeAppInstallAd) {
            this.zzgu = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzgu);
            }
        }
    }

    /* loaded from: classes.dex */
    static class zzb extends NativeContentAdMapper {
        private final NativeContentAd zzgv;

        public zzb(NativeContentAd nativeContentAd) {
            this.zzgv = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeContentAd.getVideoController());
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzgv);
            }
        }
    }

    /* loaded from: classes.dex */
    static final class zzc extends AdListener implements AppEventListener, zzis {
        private AbstractAdViewAdapter zzgw;
        private com.google.android.gms.ads.mediation.MediationBannerListener zzgx;

        public zzc(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.MediationBannerListener mediationBannerListener) {
            this.zzgw = abstractAdViewAdapter;
            this.zzgx = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.zzis
        public final void onAdClicked() {
            this.zzgx.onAdClicked(this.zzgw);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.zzgx.onAdClosed(this.zzgw);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i) {
            this.zzgx.onAdFailedToLoad(this.zzgw, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.zzgx.onAdLeftApplication(this.zzgw);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
            this.zzgx.onAdLoaded(this.zzgw);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.zzgx.onAdOpened(this.zzgw);
        }

        @Override // com.google.android.gms.ads.doubleclick.AppEventListener
        public final void onAppEvent(String str, String str2) {
            this.zzgx.zza(this.zzgw, str, str2);
        }
    }

    /* loaded from: classes.dex */
    static final class zzd extends AdListener implements zzis {
        private AbstractAdViewAdapter zzgw;
        private com.google.android.gms.ads.mediation.MediationInterstitialListener zzgy;

        public zzd(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.MediationInterstitialListener mediationInterstitialListener) {
            this.zzgw = abstractAdViewAdapter;
            this.zzgy = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.zzis
        public final void onAdClicked() {
            this.zzgy.onAdClicked(this.zzgw);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.zzgy.onAdClosed(this.zzgw);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i) {
            this.zzgy.onAdFailedToLoad(this.zzgw, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.zzgy.onAdLeftApplication(this.zzgw);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
            this.zzgy.onAdLoaded(this.zzgw);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.zzgy.onAdOpened(this.zzgw);
        }
    }

    /* loaded from: classes.dex */
    static final class zze extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener {
        private AbstractAdViewAdapter zzgw;
        private MediationNativeListener zzgz;

        public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.zzgw = abstractAdViewAdapter;
            this.zzgz = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.zzis
        public final void onAdClicked() {
            this.zzgz.onAdClicked(this.zzgw);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.zzgz.onAdClosed(this.zzgw);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i) {
            this.zzgz.onAdFailedToLoad(this.zzgw, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdImpression() {
            this.zzgz.onAdImpression(this.zzgw);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.zzgz.onAdLeftApplication(this.zzgw);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.zzgz.onAdOpened(this.zzgw);
        }

        @Override // com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener
        public final void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.zzgz.onAdLoaded(this.zzgw, new zza(nativeAppInstallAd));
        }

        @Override // com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener
        public final void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.zzgz.onAdLoaded(this.zzgw, new zzb(nativeContentAd));
        }

        @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener
        public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            this.zzgz.zza(this.zzgw, nativeCustomTemplateAd, str);
        }

        @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener
        public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
            this.zzgz.zza(this.zzgw, nativeCustomTemplateAd);
        }
    }

    private final AdRequest zza(Context context, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String str : keywords) {
                builder.addKeyword(str);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            zzjo.zzhu();
            builder.addTestDevice(zzaje.zzay(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            builder.tagForChildDirectedTreatment(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InterstitialAd zza(AbstractAdViewAdapter abstractAdViewAdapter, InterstitialAd interstitialAd) {
        abstractAdViewAdapter.zzgq = null;
        return null;
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.zzgm;
    }

    @Override // com.google.android.gms.internal.zzalt
    public Bundle getInterstitialAdapterInfo() {
        return new MediationAdapter.zza().zzaf(1).zztm();
    }

    @Override // com.google.android.gms.ads.mediation.zza
    public zzky getVideoController() {
        VideoController videoController;
        if (this.zzgm == null || (videoController = this.zzgm.getVideoController()) == null) {
            return null;
        }
        return videoController.zzbc();
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void initialize(Context context, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzgp = context.getApplicationContext();
        this.zzgr = mediationRewardedVideoAdListener;
        this.zzgr.onInitializationSucceeded(this);
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public boolean isInitialized() {
        return this.zzgr != null;
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void loadAd(com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        if (this.zzgp == null || this.zzgr == null) {
            zzaji.e("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzgq = new InterstitialAd(this.zzgp);
        this.zzgq.zza(true);
        this.zzgq.setAdUnitId(getAdUnitId(bundle));
        this.zzgq.setRewardedVideoAdListener(this.zzgs);
        this.zzgq.loadAd(zza(this.zzgp, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        if (this.zzgm != null) {
            this.zzgm.destroy();
            this.zzgm = null;
        }
        if (this.zzgn != null) {
            this.zzgn = null;
        }
        if (this.zzgo != null) {
            this.zzgo = null;
        }
        if (this.zzgq != null) {
            this.zzgq = null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener
    public void onImmersiveModeUpdated(boolean z) {
        if (this.zzgn != null) {
            this.zzgn.setImmersiveMode(z);
        }
        if (this.zzgq != null) {
            this.zzgq.setImmersiveMode(z);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
        if (this.zzgm != null) {
            this.zzgm.pause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
        if (this.zzgm != null) {
            this.zzgm.resume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(Context context, com.google.android.gms.ads.mediation.MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzgm = new AdView(context);
        this.zzgm.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzgm.setAdUnitId(getAdUnitId(bundle));
        this.zzgm.setAdListener(new zzc(this, mediationBannerListener));
        this.zzgm.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, com.google.android.gms.ads.mediation.MediationInterstitialListener mediationInterstitialListener, Bundle bundle, com.google.android.gms.ads.mediation.MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzgn = new InterstitialAd(context);
        this.zzgn.setAdUnitId(getAdUnitId(bundle));
        this.zzgn.setAdListener(new zzd(this, mediationInterstitialListener));
        this.zzgn.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        zze zzeVar = new zze(this, mediationNativeListener);
        AdLoader.Builder withAdListener = new AdLoader.Builder(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener(zzeVar);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(zzeVar);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(zzeVar);
        }
        if (nativeMediationAdRequest.zzmc()) {
            for (String str : nativeMediationAdRequest.zzmd().keySet()) {
                withAdListener.forCustomTemplateAd(str, zzeVar, nativeMediationAdRequest.zzmd().get(str).booleanValue() ? zzeVar : null);
            }
        }
        this.zzgo = withAdListener.build();
        this.zzgo.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        this.zzgn.show();
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void showVideo() {
        this.zzgq.show();
    }

    protected abstract Bundle zza(Bundle bundle, Bundle bundle2);
}
