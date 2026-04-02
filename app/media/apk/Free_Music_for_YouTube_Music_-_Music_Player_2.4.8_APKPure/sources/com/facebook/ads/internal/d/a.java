package com.facebook.ads.internal.d;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.h;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static a f1279b;
    private Context d;

    /* renamed from: a  reason: collision with root package name */
    private static final String f1278a = a.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f1280c = false;

    private a(Context context) {
        this.d = context;
    }

    public static a a(Context context) {
        if (f1279b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f1279b == null) {
                    f1279b = new a(applicationContext);
                }
            }
        }
        return f1279b;
    }

    public synchronized void a() {
        if (!f1280c) {
            if (h.e(this.d)) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(new b(Thread.getDefaultUncaughtExceptionHandler(), this.d));
                } catch (SecurityException e) {
                    Log.e(f1278a, "No permissions to set the default uncaught exception handler", e);
                }
            }
            f1280c = true;
        }
    }
}
