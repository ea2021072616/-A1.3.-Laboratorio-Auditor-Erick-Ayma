package com.facebook.ads.internal.d;

import android.content.Context;
import android.os.Process;
import android.support.annotation.Nullable;
import com.facebook.ads.BuildConfig;
import com.facebook.ads.internal.f.g;
import com.facebook.ads.internal.f.i;
import com.facebook.ads.internal.g.p;
import com.facebook.ads.internal.util.ae;
import com.facebook.ads.internal.util.m;
import com.facebook.ads.internal.util.n;
import java.lang.Thread;
/* loaded from: classes.dex */
public class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f1281a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f1282b;

    public b(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        this.f1281a = uncaughtExceptionHandler;
        if (context == null) {
            throw new IllegalArgumentException("Missing Context");
        }
        this.f1282b = context.getApplicationContext();
    }

    private void a(Thread thread, Throwable th) {
        if (this.f1281a != null) {
            this.f1281a.uncaughtException(thread, th);
            return;
        }
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable th2) {
        }
        try {
            System.exit(10);
        } catch (Throwable th3) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String a2 = ae.a(th);
        if (a2 != null && a2.contains(BuildConfig.APPLICATION_ID)) {
            n.a(new p(g.b(), g.c(), new m(a2, i.f)), this.f1282b);
        }
        a(thread, th);
    }
}
