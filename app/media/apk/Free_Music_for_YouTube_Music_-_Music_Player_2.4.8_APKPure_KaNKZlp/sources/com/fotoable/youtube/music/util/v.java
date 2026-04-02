package com.fotoable.youtube.music.util;

import android.content.Context;
import android.content.SharedPreferences;
/* compiled from: SharedPreferencesUtil.java */
/* loaded from: classes.dex */
public class v {
    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("sysconfig", 0);
    }

    public static String a(Context context, String str, String str2) {
        return a(context).getString(str, str2);
    }

    public static void b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = a(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static boolean a(Context context, String str, boolean z) {
        return a(context).getBoolean(str, z);
    }

    public static void b(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = a(context).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static int a(Context context, String str, int i) {
        return a(context).getInt(str, i);
    }

    public static void b(Context context, String str, int i) {
        SharedPreferences.Editor edit = a(context).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static long a(Context context, String str, long j) {
        return a(context).getLong(str, j);
    }

    public static void b(Context context, String str, long j) {
        SharedPreferences.Editor edit = a(context).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static boolean a(Context context, String str, String str2, boolean z) {
        return context.getSharedPreferences(str, 0).getBoolean(str2, z);
    }

    public static boolean c(Context context, String str, boolean z) {
        return a(context, "sysconfig", str, z);
    }
}
