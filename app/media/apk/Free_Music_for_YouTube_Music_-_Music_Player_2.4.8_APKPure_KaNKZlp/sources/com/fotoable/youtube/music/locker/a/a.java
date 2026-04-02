package com.fotoable.youtube.music.locker.a;

import android.provider.Settings;
import com.fotoable.youtube.music.MusicApplication;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
/* compiled from: TimeUtils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f2754a = new SimpleDateFormat("", Locale.getDefault());

    /* renamed from: b  reason: collision with root package name */
    private static Calendar f2755b = Calendar.getInstance();

    public static String a(long j) {
        if (a()) {
            try {
                f2754a.applyLocalizedPattern("h:mm");
                f2754a.setTimeZone(TimeZone.getDefault());
                return f2754a.format(Long.valueOf(j));
            } catch (Exception e) {
            }
        }
        f2754a.applyLocalizedPattern("HH:mm");
        f2754a.setTimeZone(TimeZone.getDefault());
        return f2754a.format(Long.valueOf(j));
    }

    public static String b(long j) {
        try {
            f2755b.setTimeInMillis(j);
            f2755b.setTimeZone(TimeZone.getDefault());
            return f2755b.getDisplayName(7, 1, Locale.getDefault());
        } catch (Exception e) {
            return "";
        }
    }

    public static String c(long j) {
        try {
            f2754a.applyLocalizedPattern("MM.dd");
            f2754a.setTimeZone(TimeZone.getDefault());
            return f2754a.format(Long.valueOf(j));
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean a() {
        if ("12".equals(Settings.System.getString(MusicApplication.c().getContentResolver(), "time_12_24"))) {
            try {
                f2754a.applyLocalizedPattern("h:mm");
                f2754a.setTimeZone(TimeZone.getDefault());
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }
}
