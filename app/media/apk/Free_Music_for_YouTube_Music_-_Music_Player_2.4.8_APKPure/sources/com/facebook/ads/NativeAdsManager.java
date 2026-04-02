package com.facebook.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.adapters.v;
import com.facebook.ads.internal.b;
import com.facebook.ads.internal.c;
import com.facebook.ads.internal.c.a;
import com.facebook.ads.internal.e;
import com.facebook.ads.internal.i;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
/* loaded from: classes.dex */
public class NativeAdsManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1097a = NativeAdsManager.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final c f1098b = c.ADS;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1099c;
    private final String d;
    private final int e;
    private final List<NativeAd> f;
    private int g;
    private Listener h;
    private i i;
    private boolean j;
    private boolean k;

    /* loaded from: classes.dex */
    public interface Listener {
        void onAdError(AdError adError);

        void onAdsLoaded();
    }

    public NativeAdsManager(Context context, String str, int i) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        this.f1099c = context;
        this.d = str;
        this.e = Math.max(i, 0);
        this.f = new ArrayList(i);
        this.g = -1;
        this.k = false;
        this.j = false;
        try {
            CookieManager.getInstance();
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(context);
            }
        } catch (Exception e) {
            Log.w(f1097a, "Failed to initialize CookieManager.", e);
        }
    }

    public void disableAutoRefresh() {
        this.j = true;
        if (this.i != null) {
            this.i.c();
        }
    }

    public int getUniqueNativeAdCount() {
        return this.f.size();
    }

    public boolean isLoaded() {
        return this.k;
    }

    public void loadAds() {
        loadAds(EnumSet.of(NativeAd.MediaCacheFlag.NONE));
    }

    public void loadAds(final EnumSet<NativeAd.MediaCacheFlag> enumSet) {
        e eVar = e.NATIVE_UNKNOWN;
        int i = this.e;
        if (this.i != null) {
            this.i.b();
        }
        this.i = new i(this.f1099c, this.d, eVar, null, f1098b, i, enumSet);
        if (this.j) {
            this.i.c();
        }
        this.i.a(new i.a() { // from class: com.facebook.ads.NativeAdsManager.1
            @Override // com.facebook.ads.internal.i.a
            public void a(b bVar) {
                if (NativeAdsManager.this.h != null) {
                    NativeAdsManager.this.h.onAdError(bVar.b());
                }
            }

            @Override // com.facebook.ads.internal.i.a
            public void a(final List<v> list) {
                com.facebook.ads.internal.c.b bVar = new com.facebook.ads.internal.c.b(NativeAdsManager.this.f1099c);
                for (v vVar : list) {
                    if (enumSet.contains(NativeAd.MediaCacheFlag.ICON) && vVar.k() != null) {
                        bVar.a(vVar.k().getUrl());
                    }
                    if (enumSet.contains(NativeAd.MediaCacheFlag.IMAGE) && vVar.l() != null) {
                        bVar.a(vVar.l().getUrl());
                    }
                    if (enumSet.contains(NativeAd.MediaCacheFlag.VIDEO) && !TextUtils.isEmpty(vVar.w())) {
                        bVar.b(vVar.w());
                    }
                }
                bVar.a(new a() { // from class: com.facebook.ads.NativeAdsManager.1.1
                    @Override // com.facebook.ads.internal.c.a
                    public void a() {
                        NativeAdsManager.this.k = true;
                        NativeAdsManager.this.f.clear();
                        NativeAdsManager.this.g = 0;
                        for (v vVar2 : list) {
                            NativeAdsManager.this.f.add(new NativeAd(NativeAdsManager.this.f1099c, vVar2, null));
                        }
                        if (NativeAdsManager.this.h != null) {
                            NativeAdsManager.this.h.onAdsLoaded();
                        }
                    }
                });
            }
        });
        this.i.a();
    }

    public NativeAd nextNativeAd() {
        if (this.f.size() == 0) {
            return null;
        }
        int i = this.g;
        this.g = i + 1;
        NativeAd nativeAd = this.f.get(i % this.f.size());
        return i >= this.f.size() ? new NativeAd(nativeAd) : nativeAd;
    }

    public void setListener(Listener listener) {
        this.h = listener;
    }
}
