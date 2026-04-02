package com.facebook.ads.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.BuildConfig;
import java.util.Iterator;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static h f1369a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f1370b;

    public h(Context context) {
        this.f1370b = context.getApplicationContext().getSharedPreferences("com.facebook.ads.FEATURE_CONFIG", 0);
    }

    public static boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 14 && com.facebook.ads.internal.util.g.a(BuildConfig.APPLICATION_ID, "ExoPlayer") && o(context).a("adnw_enable_exoplayer", false);
    }

    public static boolean b(Context context) {
        return o(context).a("adnw_block_lockscreen", false);
    }

    public static boolean c(Context context) {
        return o(context).a("show_metadata_rewarded_video", false);
    }

    public static boolean d(Context context) {
        return Build.VERSION.SDK_INT >= 19 && o(context).a("adnw_enable_iab", false);
    }

    public static boolean e(Context context) {
        return o(context).a("adnw_debug_logging", false);
    }

    public static long f(Context context) {
        return o(context).a("unified_logging_immediate_delay_ms", 500L);
    }

    public static long g(Context context) {
        return o(context).a("unified_logging_dispatch_interval_seconds", IjkMediaCodecInfo.RANK_SECURE) * 1000;
    }

    public static int h(Context context) {
        return o(context).a("unified_logging_event_limit", -1);
    }

    public static boolean i(Context context) {
        return o(context).a("video_and_endcard_autorotate", "autorotate_disabled").equals("autorotate_enabled");
    }

    public static boolean j(Context context) {
        return o(context).a("show_play_pause_rewarded_video", false);
    }

    public static int k(Context context) {
        return o(context).a("minimum_elapsed_time_after_impression", -1);
    }

    public static int l(Context context) {
        return o(context).a("ad_viewability_tap_margin", 0);
    }

    public static boolean m(Context context) {
        return o(context).a("visible_area_check_enabled", false);
    }

    public static int n(Context context) {
        return o(context).a("visible_area_percentage", 50);
    }

    private static h o(Context context) {
        if (f1369a == null) {
            synchronized (h.class) {
                if (f1369a == null) {
                    f1369a = new h(context);
                }
            }
        }
        return f1369a;
    }

    public int a(String str, int i) {
        String string = this.f1370b.getString(str, String.valueOf(i));
        return (string == null || string.equals("null")) ? i : Integer.valueOf(string).intValue();
    }

    public long a(String str, long j) {
        String string = this.f1370b.getString(str, String.valueOf(j));
        return (string == null || string.equals("null")) ? j : Long.valueOf(string).longValue();
    }

    @Nullable
    public String a(String str, String str2) {
        String string = this.f1370b.getString(str, str2);
        return (string == null || string.equals("null")) ? str2 : string;
    }

    public void a(@Nullable String str) {
        if (str == null || str.isEmpty() || str.equals("[]")) {
            return;
        }
        SharedPreferences.Editor edit = this.f1370b.edit();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            edit.putString(next, jSONObject.getString(next));
        }
        edit.commit();
    }

    public boolean a(String str, boolean z) {
        String string = this.f1370b.getString(str, String.valueOf(z));
        return (string == null || string.equals("null")) ? z : Boolean.valueOf(string).booleanValue();
    }
}
