package com.fotoable.youtube.music;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.fotoable.youtube.music.newplayer.service.PlayerService;
import com.fotoable.youtube.music.util.h;
import com.fotoable.youtube.music.util.v;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* compiled from: AppSetting.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f2221a = new HashSet<String>() { // from class: com.fotoable.youtube.music.a.1
        {
            add("BR");
            add("JP");
        }
    };

    public static boolean a() {
        try {
            String displayLanguage = Locale.getDefault().getDisplayLanguage();
            String language = Locale.getDefault().getLanguage();
            h.a(a.class.getSimpleName(), "displayLanguage:" + displayLanguage + ",language:" + language);
            if (!TextUtils.isEmpty(displayLanguage) && TextUtils.equals(displayLanguage.toLowerCase(), "english") && !TextUtils.isEmpty(language)) {
                if (TextUtils.equals(language.toLowerCase(), "en")) {
                    return true;
                }
            }
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
        return false;
    }

    public static String b() {
        String a2 = v.a(MusicApplication.c(), "country_code", (String) null);
        if (TextUtils.isEmpty(a2)) {
            return Locale.getDefault().getCountry();
        }
        return a2;
    }

    public static boolean c() {
        String a2 = v.a(MusicApplication.c(), "country_code", (String) null);
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        return TextUtils.equals(a2.toLowerCase(), "IN".toLowerCase());
    }

    public static boolean d() {
        String a2 = v.a(MusicApplication.c(), "country_code", (String) null);
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        return TextUtils.equals(a2.toLowerCase(), "JP".toLowerCase());
    }

    public static boolean e() {
        String a2 = v.a(MusicApplication.c(), "country_code", (String) null);
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        return TextUtils.equals(a2.toLowerCase(), "BR".toLowerCase());
    }

    public static boolean f() {
        String a2 = v.a(MusicApplication.c(), "country_code", (String) null);
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        return TextUtils.equals(a2.toLowerCase(), "MX".toLowerCase());
    }

    public static boolean g() {
        String a2 = v.a(MusicApplication.c(), "country_code", (String) null);
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        return TextUtils.equals(a2.toLowerCase(), "US".toLowerCase());
    }

    public static boolean h() {
        return v.a((Context) MusicApplication.c(), "HAS_PAY_AD", false);
    }

    public static void a(boolean z) {
        v.b(MusicApplication.c(), "HAS_PAY_AD", z);
    }

    public static boolean i() {
        return v.a((Context) MusicApplication.c(), "feature_charging_lock_screen", false);
    }

    public static void b(boolean z) {
        v.b(MusicApplication.c(), "feature_charging_lock_screen", z);
    }

    public static void c(boolean z) {
        v.b(MusicApplication.c(), "sleep_timer_end_state", z);
    }

    public static boolean j() {
        return v.c(MusicApplication.c(), "sleep_timer_end_state", false);
    }

    public static void d(boolean z) {
        v.b(MusicApplication.c(), "show_youtube_player", z);
    }

    public static boolean k() {
        return v.c(MusicApplication.c(), "show_youtube_player", true);
    }

    public static void e(boolean z) {
        v.b(MusicApplication.c(), "make_post_red_tip", z);
    }

    public static void f(boolean z) {
        v.b(MusicApplication.c(), "youtube_commit_red_tip", z);
    }

    public static boolean l() {
        return v.c(MusicApplication.c(), "youtube_commit_red_tip", true);
    }

    public static void g(boolean z) {
        v.b(MusicApplication.c(), "small_player_red_tip", z);
    }

    public static boolean m() {
        return v.c(MusicApplication.c(), "small_player_red_tip", true);
    }

    public static void h(boolean z) {
        try {
            v.b(MusicApplication.c(), "feature_music_locker", z);
            Intent intent = new Intent(MusicApplication.c(), PlayerService.class);
            intent.setAction("action_music_locker_state_change");
            intent.putExtra(ServerProtocol.DIALOG_PARAM_STATE, z);
            MusicApplication.c().startService(intent);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }

    public static boolean n() {
        return v.c(MusicApplication.c(), "feature_music_locker", true);
    }

    public static void i(boolean z) {
        v.b(MusicApplication.c(), "bottom_quick_tool", z);
    }

    public static boolean o() {
        return v.c(MusicApplication.c(), "bottom_quick_tool", false);
    }

    public static void j(boolean z) {
        v.b(MusicApplication.c(), "auto_rotate_screen_tip", z);
    }

    public static boolean p() {
        return v.c(MusicApplication.c(), "auto_rotate_screen_tip", false);
    }

    public static void k(boolean z) {
        v.b(MusicApplication.c(), "you_tube_got_it_tip", z);
    }

    public static boolean q() {
        return v.c(MusicApplication.c(), "you_tube_got_it_tip", true);
    }

    public static void l(boolean z) {
        v.b(MusicApplication.c(), "feature_power_model", z);
    }

    public static void m(boolean z) {
        v.b(MusicApplication.c(), "feature_float_window_tip", z);
    }

    public static void n(boolean z) {
        v.b(MusicApplication.c(), "feature_youtube_warn_tip", z);
    }

    public static boolean r() {
        return v.c(MusicApplication.c(), "feature_youtube_warn_tip", false);
    }

    public static void a(int i) {
        v.b((Context) MusicApplication.c(), "feature_popup_size", i);
    }

    public static int s() {
        return v.a((Context) MusicApplication.c(), "feature_popup_size", 1);
    }

    public static void o(boolean z) {
        v.b(MusicApplication.c(), "feature_wifi_only", z);
    }

    public static boolean t() {
        return v.c(MusicApplication.c(), "feature_wifi_only", false);
    }

    public static void p(boolean z) {
        v.b(MusicApplication.c(), "feature_show_pop_action_bar", z);
    }

    public static boolean u() {
        return v.c(MusicApplication.c(), "feature_show_pop_action_bar", true);
    }

    public static void q(boolean z) {
        v.b(MusicApplication.c(), "feature_auto_play", z);
    }

    public static boolean v() {
        return v.c(MusicApplication.c(), "feature_auto_play", true);
    }

    public static void b(int i) {
        v.b((Context) MusicApplication.c(), "feature_loop_model", i);
    }

    public static int w() {
        return v.a((Context) MusicApplication.c(), "feature_loop_model", 0);
    }

    public static String x() {
        return v.a(MusicApplication.c(), "USER_TOKEN", "");
    }

    public static boolean y() {
        return v.a((Context) MusicApplication.c(), "remind_local_music_update", true);
    }

    public static void r(boolean z) {
        if (z) {
            com.fotoable.youtube.music.util.b.b("设置页面--打开本地音乐新增提醒开关");
        } else {
            com.fotoable.youtube.music.util.b.b("设置页面--关闭本地音乐新增提醒开关");
        }
        v.b(MusicApplication.c(), "remind_local_music_update", z);
    }

    public static boolean z() {
        return v.a((Context) MusicApplication.c(), "only_download_artist_pic_wifi", false);
    }

    public static void s(boolean z) {
        if (z) {
            com.fotoable.youtube.music.util.b.b("设置页面--打开仅使用WIFI下载歌手头像开关");
        } else {
            com.fotoable.youtube.music.util.b.b("设置页面--关闭仅使用WIFI下载歌手头像开关");
        }
        v.b(MusicApplication.c(), "only_download_artist_pic_wifi", z);
    }
}
