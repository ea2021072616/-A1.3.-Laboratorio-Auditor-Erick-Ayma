package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzln;
/* loaded from: classes.dex */
public class MobileAds {

    /* loaded from: classes.dex */
    public static final class Settings {
        private final zzln zzalb = new zzln();

        @Deprecated
        public final String getTrackingId() {
            return null;
        }

        @Deprecated
        public final boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        @Deprecated
        public final Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public final Settings setTrackingId(String str) {
            return this;
        }

        final zzln zzbb() {
            return this.zzalb;
        }
    }

    private MobileAds() {
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzll.zzif().getRewardedVideoAdInstance(context);
    }

    public static void initialize(Context context) {
        initialize(context, null, null);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzll.zzif().zza(context, str, settings == null ? null : settings.zzbb());
    }

    public static void openDebugMenu(Context context, String str) {
        zzll.zzif().openDebugMenu(context, str);
    }

    public static void setAppMuted(boolean z) {
        zzll.zzif().setAppMuted(z);
    }

    public static void setAppVolume(float f) {
        zzll.zzif().setAppVolume(f);
    }
}
