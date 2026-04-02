package com.flurry.sdk;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes.dex */
public final class km {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2066a = false;

    /* renamed from: b  reason: collision with root package name */
    private static int f2067b = 5;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2068c = false;

    public static void a() {
        f2066a = true;
    }

    public static void b() {
        f2066a = false;
    }

    public static int c() {
        return f2067b;
    }

    public static void a(int i) {
        f2067b = i;
    }

    public static boolean d() {
        return f2068c;
    }

    private static void b(int i, String str, String str2) {
        if (!f2066a && f2067b <= i) {
            c(i, str, str2);
        }
    }

    private static void c(int i, String str, String str2) {
        if (!f2068c) {
            str = "FlurryAgent";
        }
        int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = 4000 > length - i2 ? length : i2 + 4000;
            if (Log.println(i, str, str2.substring(i2, i3)) <= 0) {
                return;
            }
            i2 = i3;
        }
    }

    public static void a(String str, String str2) {
        b(3, str, str2);
    }

    public static void b(String str, String str2) {
        b(6, str, str2);
    }

    public static void c(String str, String str2) {
        b(4, str, str2);
    }

    public static void d(String str, String str2) {
        b(2, str, str2);
    }

    public static void e(String str, String str2) {
        b(5, str, str2);
    }

    private static void d(int i, String str, String str2) {
        if (f2068c) {
            c(i, str, str2);
        }
    }

    public static void a(int i, String str, String str2) {
        d(i, str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        b(6, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    public static void a(int i, String str, String str2, Throwable th) {
        d(i, str, str2 + '\n' + Log.getStackTraceString(th));
    }
}
