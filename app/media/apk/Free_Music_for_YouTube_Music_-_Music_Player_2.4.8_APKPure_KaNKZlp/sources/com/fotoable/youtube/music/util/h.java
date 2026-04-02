package com.fotoable.youtube.music.util;

import android.util.Log;
/* compiled from: LogUtil.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4866a = false;

    public static void a(String str) {
        if (f4866a) {
            Log.e("Free Music", str);
        }
    }

    public static void a(String str, String str2) {
        if (f4866a) {
            Log.e(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (f4866a) {
            Log.d(str, str2);
        }
    }
}
