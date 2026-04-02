package com.flurry.sdk;

import android.content.Context;
import com.flurry.sdk.lq;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.lang.Thread;
/* loaded from: classes.dex */
public class md implements kp, lq.a, Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2191a = md.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private boolean f2192b;

    @Override // com.flurry.sdk.kp
    public final void a(Context context) {
        lp a2 = lp.a();
        this.f2192b = ((Boolean) a2.a("CaptureUncaughtExceptions")).booleanValue();
        a2.a("CaptureUncaughtExceptions", (lq.a) this);
        km.a(4, f2191a, "initSettings, CrashReportingEnabled = " + this.f2192b);
        me a3 = me.a();
        synchronized (a3.f2195b) {
            a3.f2195b.put(this, null);
        }
    }

    @Override // com.flurry.sdk.lq.a
    public final void a(String str, Object obj) {
        if (str.equals("CaptureUncaughtExceptions")) {
            this.f2192b = ((Boolean) obj).booleanValue();
            km.a(4, f2191a, "onSettingUpdate, CrashReportingEnabled = " + this.f2192b);
            return;
        }
        km.a(6, f2191a, "onSettingUpdate internal error!");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ThrowableExtension.printStackTrace(th);
        if (this.f2192b) {
            String str = "";
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                StringBuilder sb = new StringBuilder();
                if (th.getMessage() != null) {
                    sb.append(" (").append(th.getMessage()).append(")\n");
                }
                str = sb.toString();
            } else if (th.getMessage() != null) {
                str = th.getMessage();
            }
            hr.a();
            hr.a("uncaught", str, th);
        }
        lm.a().d();
        jp.a().f();
    }
}
