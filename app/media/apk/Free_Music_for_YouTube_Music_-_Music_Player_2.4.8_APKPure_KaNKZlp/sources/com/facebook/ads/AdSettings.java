package com.facebook.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.util.AdInternalSettings;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.s;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;
/* loaded from: classes.dex */
public class AdSettings {
    public static final boolean DEBUG = false;

    /* renamed from: a  reason: collision with root package name */
    static volatile boolean f1023a;
    private static String e;
    private static boolean f;
    private static boolean g;
    private static String h;
    private static boolean i;
    private static String j;

    /* renamed from: b  reason: collision with root package name */
    private static final String f1024b = AdSettings.class.getSimpleName();
    private static TestAdType k = TestAdType.DEFAULT;

    /* renamed from: c  reason: collision with root package name */
    private static final Collection<String> f1025c = new HashSet();
    private static final Collection<String> d = new HashSet();

    /* loaded from: classes.dex */
    public enum TestAdType {
        DEFAULT(MessengerShareContentUtility.PREVIEW_DEFAULT),
        IMG_16_9_APP_INSTALL("IMG_16_9_APP_INSTALL"),
        IMG_16_9_LINK("IMG_16_9_LINK"),
        VIDEO_HD_16_9_46S_APP_INSTALL("VID_HD_16_9_46S_APP_INSTALL"),
        VIDEO_HD_16_9_46S_LINK("VID_HD_16_9_46S_LINK"),
        VIDEO_HD_16_9_15S_APP_INSTALL("VID_HD_16_9_15S_APP_INSTALL"),
        VIDEO_HD_16_9_15S_LINK("VID_HD_16_9_15S_LINK"),
        VIDEO_HD_9_16_39S_APP_INSTALL("VID_HD_9_16_39S_APP_INSTALL"),
        VIDEO_HD_9_16_39S_LINK("VID_HD_9_16_39S_LINK"),
        CAROUSEL_IMG_SQUARE_APP_INSTALL("CAROUSEL_IMG_SQUARE_APP_INSTALL"),
        CAROUSEL_IMG_SQUARE_LINK("CAROUSEL_IMG_SQUARE_LINK");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1027a;

        TestAdType(String str) {
            this.f1027a = str;
        }

        public String getAdTypeString() {
            return this.f1027a;
        }
    }

    static {
        d.add(ServerProtocol.DIALOG_PARAM_SDK_VERSION);
        d.add("google_sdk");
        d.add("vbox86p");
        d.add("vbox86tp");
        f1023a = false;
    }

    private static void a(String str) {
        if (f1023a) {
            return;
        }
        f1023a = true;
        Log.d(f1024b, "Test mode device hash: " + str);
        Log.d(f1024b, "When testing your app with Facebook's ad units you must specify the device hashed ID to ensure the delivery of test ads, add the following code before loading an ad: AdSettings.addTestDevice(\"" + str + "\");");
    }

    public static void addTestDevice(String str) {
        f1025c.add(str);
    }

    public static void addTestDevices(Collection<String> collection) {
        f1025c.addAll(collection);
    }

    public static void clearTestDevices() {
        f1025c.clear();
    }

    public static String getMediationService() {
        return h;
    }

    public static TestAdType getTestAdType() {
        return k;
    }

    public static String getUrlPrefix() {
        return e;
    }

    public static boolean isChildDirected() {
        return i;
    }

    public static boolean isTestMode(Context context) {
        if (AdInternalSettings.f1469a || d.contains(Build.PRODUCT)) {
            return true;
        }
        if (j == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("FBAdPrefs", 0);
            j = sharedPreferences.getString("deviceIdHash", null);
            if (TextUtils.isEmpty(j)) {
                g.a a2 = g.a(context.getContentResolver());
                if (!TextUtils.isEmpty(a2.f1531b)) {
                    j = s.a(a2.f1531b);
                } else if (TextUtils.isEmpty(a2.f1530a)) {
                    j = s.a(UUID.randomUUID().toString());
                } else {
                    j = s.a(a2.f1530a);
                }
                sharedPreferences.edit().putString("deviceIdHash", j).apply();
            }
        }
        if (f1025c.contains(j)) {
            return true;
        }
        a(j);
        return false;
    }

    public static boolean isVideoAutoplay() {
        return f;
    }

    public static boolean isVideoAutoplayOnMobile() {
        return g;
    }

    public static void setIsChildDirected(boolean z) {
        i = z;
    }

    public static void setMediationService(String str) {
        h = str;
    }

    public static void setTestAdType(TestAdType testAdType) {
        k = testAdType;
    }

    public static void setUrlPrefix(String str) {
        e = str;
    }

    public static void setVideoAutoplay(boolean z) {
        f = z;
    }

    public static void setVideoAutoplayOnMobile(boolean z) {
        g = z;
    }
}
