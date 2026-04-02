package com.facebook.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.ads.AdSettings;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.DefaultLoadControl;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private static String f1565a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f1566b = new HashSet(1);

    /* renamed from: c  reason: collision with root package name */
    private static final Set<String> f1567c = new HashSet(2);

    /* loaded from: classes.dex */
    public enum a {
        UNKNOWN(0),
        NONE(0),
        MOBILE_INTERNET(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        MOBILE_4G(4);
        
        public final int g;

        a(int i) {
            this.g = i;
        }
    }

    static {
        f1566b.add("1ww8E0AYsR2oX5lndk2hwp2Uosk=\n");
        f1567c.add("toZ2GRnRjC9P5VVUdCpOrFH8lfQ=\n");
        f1567c.add("3lKvjNsfmrn+WmfDhvr2iVh/yRs=\n");
        f1567c.add("B08QtE4yLCdli4rptyqAEczXOeA=\n");
        f1567c.add("XZXI6anZbdKf+taURdnyUH5ipgM=\n");
    }

    public static com.facebook.ads.internal.i.a.a a(Context context) {
        return a(context, null);
    }

    public static com.facebook.ads.internal.i.a.a a(Context context, com.facebook.ads.internal.e eVar) {
        com.facebook.ads.internal.i.a.a aVar = new com.facebook.ads.internal.i.a.a();
        a(context, aVar, eVar);
        return aVar;
    }

    private static String a(Context context, String str, String str2) {
        Class<?> cls = Class.forName(str);
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Context.class, Class.forName(str2));
        declaredConstructor.setAccessible(true);
        try {
            return (String) cls.getMethod("getUserAgentString", new Class[0]).invoke(declaredConstructor.newInstance(context, null), new Object[0]);
        } finally {
            declaredConstructor.setAccessible(false);
        }
    }

    private static void a(Context context, com.facebook.ads.internal.i.a.a aVar, com.facebook.ads.internal.e eVar) {
        aVar.c(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS);
        aVar.b(3);
        aVar.a("user-agent", c(context, eVar) + " [FBAN/AudienceNetworkForAndroid;FBSN/Android;FBSV/" + com.facebook.ads.internal.f.i.f1345a + ";FBAB/" + com.facebook.ads.internal.f.i.d + ";FBAV/" + com.facebook.ads.internal.f.i.f + ";FBBV/" + com.facebook.ads.internal.f.i.g + ";FBVS/4.23.0;FBLC/" + Locale.getDefault().toString() + "]");
    }

    public static boolean a() {
        String urlPrefix = AdSettings.getUrlPrefix();
        return !TextUtils.isEmpty(urlPrefix) && urlPrefix.endsWith(".sb");
    }

    public static com.facebook.ads.internal.i.a.a b() {
        return a(null);
    }

    public static com.facebook.ads.internal.i.a.a b(Context context) {
        return b(context, null);
    }

    public static com.facebook.ads.internal.i.a.a b(Context context, com.facebook.ads.internal.e eVar) {
        com.facebook.ads.internal.i.a.a aVar = new com.facebook.ads.internal.i.a.a();
        a(context, aVar, eVar);
        if (!a()) {
            aVar.b(f1567c);
            aVar.a(f1566b);
        }
        return aVar;
    }

    public static a c(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return a.UNKNOWN;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return a.NONE;
        }
        if (activeNetworkInfo.getType() == 0) {
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return a.MOBILE_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return a.MOBILE_3G;
                case 13:
                    return a.MOBILE_4G;
                default:
                    return a.UNKNOWN;
            }
        }
        return a.MOBILE_INTERNET;
    }

    private static String c(Context context, com.facebook.ads.internal.e eVar) {
        if (context == null) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        if (eVar == com.facebook.ads.internal.e.NATIVE_250 || eVar == com.facebook.ads.internal.e.NATIVE_UNKNOWN || eVar == null) {
            return System.getProperty("http.agent");
        }
        if (f1565a != null) {
            return f1565a;
        }
        synchronized (w.class) {
            if (f1565a != null) {
                return f1565a;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    f1565a = d(context);
                    return f1565a;
                } catch (Exception e) {
                }
            }
            try {
                f1565a = a(context, "android.webkit.WebSettings", "android.webkit.WebView");
            } catch (Exception e2) {
                try {
                    f1565a = a(context, "android.webkit.WebSettingsClassic", "android.webkit.WebViewClassic");
                } catch (Exception e3) {
                    WebView webView = new WebView(context.getApplicationContext());
                    f1565a = webView.getSettings().getUserAgentString();
                    webView.destroy();
                }
            }
            return f1565a;
        }
    }

    @TargetApi(17)
    private static String d(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }
}
