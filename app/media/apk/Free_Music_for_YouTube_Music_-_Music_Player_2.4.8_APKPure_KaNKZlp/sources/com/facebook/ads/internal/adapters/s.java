package com.facebook.ads.internal.adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.ads.AdError;
/* loaded from: classes.dex */
public class s extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private String f1229a;

    /* renamed from: b  reason: collision with root package name */
    private Context f1230b;

    /* renamed from: c  reason: collision with root package name */
    private InterstitialAdapterListener f1231c;
    private InterstitialAdapter d;

    public s(Context context, String str, InterstitialAdapter interstitialAdapter, InterstitialAdapterListener interstitialAdapterListener) {
        this.f1230b = context;
        this.f1229a = str;
        this.f1231c = interstitialAdapterListener;
        this.d = interstitialAdapter;
    }

    public void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.impression.logged:" + this.f1229a);
        intentFilter.addAction("com.facebook.ads.interstitial.displayed:" + this.f1229a);
        intentFilter.addAction("com.facebook.ads.interstitial.dismissed:" + this.f1229a);
        intentFilter.addAction("com.facebook.ads.interstitial.clicked:" + this.f1229a);
        intentFilter.addAction("com.facebook.ads.interstitial.error:" + this.f1229a);
        LocalBroadcastManager.getInstance(this.f1230b).registerReceiver(this, intentFilter);
    }

    public void b() {
        try {
            LocalBroadcastManager.getInstance(this.f1230b).unregisterReceiver(this);
        } catch (Exception e) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str = intent.getAction().split(":")[0];
        if (this.f1231c == null || str == null) {
            return;
        }
        if ("com.facebook.ads.interstitial.clicked".equals(str)) {
            this.f1231c.onInterstitialAdClicked(this.d, null, true);
        } else if ("com.facebook.ads.interstitial.dismissed".equals(str)) {
            this.f1231c.onInterstitialAdDismissed(this.d);
        } else if ("com.facebook.ads.interstitial.displayed".equals(str)) {
            this.f1231c.onInterstitialAdDisplayed(this.d);
        } else if ("com.facebook.ads.interstitial.impression.logged".equals(str)) {
            this.f1231c.onInterstitialLoggingImpression(this.d);
        } else if ("com.facebook.ads.interstitial.error".equals(str)) {
            this.f1231c.onInterstitialError(this.d, AdError.INTERNAL_ERROR);
        }
    }
}
