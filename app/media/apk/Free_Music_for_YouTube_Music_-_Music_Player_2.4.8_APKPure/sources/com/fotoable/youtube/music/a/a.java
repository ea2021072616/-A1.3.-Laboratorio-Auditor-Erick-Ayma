package com.fotoable.youtube.music.a;

import android.content.Context;
import android.util.Log;
import com.fotoable.youtube.music.util.h;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* compiled from: AdmobManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2222b = false;
    private static volatile a d;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0055a f2224c;
    private Context e;
    private InterstitialAd f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2223a = true;
    private AdListener g = new AdListener() { // from class: com.fotoable.youtube.music.a.a.1
        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(int i) {
            h.a("TestLoading", "....admob onAdFailedToLoad");
            Log.e("adsManager", "error....." + i);
            a.this.f2223a = false;
            if (!a.f2222b || b.a(a.this.e).c()) {
                a.this.a();
                a.f2222b = true;
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            h.a("TestLoading", "....admob onAdLoaded");
            c.a("广告_Admob用户第一次安装的开屏广告加载成功");
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            super.onAdClosed();
            a.this.f2223a = false;
            if (a.this.f2224c != null) {
                a.this.f2224c.a();
            }
        }
    };

    /* compiled from: AdmobManager.java */
    /* renamed from: com.fotoable.youtube.music.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0055a {
        void a();
    }

    public static a a(Context context) {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a(context.getApplicationContext());
                }
            }
        }
        return d;
    }

    private a(Context context) {
        try {
            this.e = context;
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public void a() {
        try {
            this.f = new InterstitialAd(this.e);
            this.f.setAdListener(this.g);
            this.f.setAdUnitId("ca-app-pub-6568668249868621/3794238198");
            this.f.loadAd(new AdRequest.Builder().build());
            c.a("广告_Admob 加载开屏广告");
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public boolean b() {
        if (this.f.isLoaded()) {
            this.f.show();
            return true;
        }
        return false;
    }

    public boolean c() {
        return this.f != null && this.f.isLoaded();
    }

    public void a(InterfaceC0055a interfaceC0055a, int i) {
        switch (i) {
            case 1:
                this.f2224c = interfaceC0055a;
                return;
            default:
                return;
        }
    }
}
