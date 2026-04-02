package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
@zzzt
/* loaded from: classes.dex */
public final class zzwn implements MediationInterstitialAdapter {
    private Uri mUri;
    private Activity zzcdi;
    private MediationInterstitialListener zzcdj;

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        zzaji.zzcb("Destroying AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        zzaji.zzcb("Pausing AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        zzaji.zzcb("Resuming AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzcdj = mediationInterstitialListener;
        if (this.zzcdj == null) {
            zzaji.zzcs("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzaji.zzcs("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzcdj.onAdFailedToLoad(this, 0);
        } else {
            if (!(com.google.android.gms.common.util.zzp.zzald() && zznr.zzk(context))) {
                zzaji.zzcs("Default browser does not support custom tabs. Bailing out.");
                this.zzcdj.onAdFailedToLoad(this, 0);
                return;
            }
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzaji.zzcs("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzcdj.onAdFailedToLoad(this, 0);
                return;
            }
            this.zzcdi = (Activity) context;
            this.mUri = Uri.parse(string);
            this.zzcdj.onAdLoaded(this);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setData(this.mUri);
        zzahf.zzdbo.post(new zzwp(this, new AdOverlayInfoParcel(new com.google.android.gms.ads.internal.overlay.zzc(build.intent), null, new zzwo(this), null, new zzajk(0, 0, false))));
        com.google.android.gms.ads.internal.zzbv.zzee().zzqg();
    }
}
