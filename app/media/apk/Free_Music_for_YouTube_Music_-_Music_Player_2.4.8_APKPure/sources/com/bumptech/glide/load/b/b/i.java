package com.bumptech.glide.load.b.b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
/* compiled from: MemorySizeCalculator.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final int f813a;

    /* renamed from: b  reason: collision with root package name */
    private final int f814b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f815c;

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    interface b {
        int a();

        int b();
    }

    public i(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new a(context.getResources().getDisplayMetrics()));
    }

    i(Context context, ActivityManager activityManager, b bVar) {
        this.f815c = context;
        int a2 = a(activityManager);
        int a3 = bVar.a() * bVar.b() * 4;
        int i = a3 * 4;
        int i2 = a3 * 2;
        if (i2 + i <= a2) {
            this.f814b = i2;
            this.f813a = i;
        } else {
            int round = Math.round(a2 / 6.0f);
            this.f814b = round * 2;
            this.f813a = round * 4;
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Log.d("MemorySizeCalculator", "Calculated memory cache size: " + a(this.f814b) + " pool size: " + a(this.f813a) + " memory class limited? " + (i2 + i > a2) + " max size: " + a(a2) + " memoryClass: " + activityManager.getMemoryClass() + " isLowMemoryDevice: " + b(activityManager));
        }
    }

    public int a() {
        return this.f814b;
    }

    public int b() {
        return this.f813a;
    }

    private static int a(ActivityManager activityManager) {
        boolean b2 = b(activityManager);
        return Math.round((b2 ? 0.33f : 0.4f) * activityManager.getMemoryClass() * 1024 * 1024);
    }

    private String a(int i) {
        return Formatter.formatFileSize(this.f815c, i);
    }

    @TargetApi(19)
    private static boolean b(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return Build.VERSION.SDK_INT < 11;
    }

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    private static class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f816a;

        public a(DisplayMetrics displayMetrics) {
            this.f816a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.b.b.i.b
        public int a() {
            return this.f816a.widthPixels;
        }

        @Override // com.bumptech.glide.load.b.b.i.b
        public int b() {
            return this.f816a.heightPixels;
        }
    }
}
