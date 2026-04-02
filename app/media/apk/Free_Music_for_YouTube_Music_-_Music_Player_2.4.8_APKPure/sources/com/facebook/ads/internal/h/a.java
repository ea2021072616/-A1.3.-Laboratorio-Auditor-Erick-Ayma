package com.facebook.ads.internal.h;

import com.facebook.ads.internal.adapters.e;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f1371a = {"com.flurry.android.FlurryAgent", "com.flurry.android.ads.FlurryAdErrorType", "com.flurry.android.ads.FlurryAdNative", "com.flurry.android.ads.FlurryAdNativeAsset", "com.flurry.android.ads.FlurryAdNativeListener"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f1372b = {"com.inmobi.ads.InMobiNative", "com.inmobi.sdk.InMobiSdk"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f1373c = {"com.google.android.gms.ads.formats.NativeAdView"};

    public static boolean a(e eVar) {
        switch (eVar) {
            case AN:
                return true;
            case YAHOO:
                return a(f1371a);
            case INMOBI:
                return a(f1372b);
            case ADMOB:
                return a(f1373c);
            default:
                return false;
        }
    }

    private static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean a(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if (!a(str)) {
                return false;
            }
        }
        return true;
    }
}
