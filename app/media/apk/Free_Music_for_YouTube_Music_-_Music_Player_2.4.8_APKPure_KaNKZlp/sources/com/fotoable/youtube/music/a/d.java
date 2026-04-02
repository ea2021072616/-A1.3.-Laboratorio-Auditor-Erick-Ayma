package com.fotoable.youtube.music.a;

import android.content.Context;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;
import com.fotoable.youtube.music.util.h;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: FacebookManager.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2229b = false;
    private static volatile d d;

    /* renamed from: c  reason: collision with root package name */
    public a f2231c;
    private Context e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2230a = true;
    private InterstitialAdListener f = new InterstitialAdListener() { // from class: com.fotoable.youtube.music.a.d.1
        @Override // com.facebook.ads.InterstitialAdListener
        public void onInterstitialDisplayed(Ad ad) {
        }

        @Override // com.facebook.ads.InterstitialAdListener
        public void onInterstitialDismissed(Ad ad) {
            d.this.f2230a = false;
            if (d.this.f2231c != null) {
                d.this.f2231c.a();
            }
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad, AdError adError) {
            h.a("TestLoading", "....fb AdError");
            d.this.f2230a = false;
            if (!d.f2229b) {
                com.fotoable.youtube.music.a.a.a(d.this.e).a();
                d.f2229b = true;
            }
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad) {
            h.a("TestLoading", "....fb onAdLoaded");
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad) {
            if (d.this.f2231c != null) {
                d.this.f2231c.a();
            }
        }

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad) {
        }
    };

    /* compiled from: FacebookManager.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public static d a(Context context) {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d(context.getApplicationContext());
                }
            }
        }
        return d;
    }

    private d(Context context) {
        try {
            this.e = context;
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void a(a aVar, int i) {
        switch (i) {
            case 1:
                this.f2231c = aVar;
                return;
            default:
                return;
        }
    }
}
