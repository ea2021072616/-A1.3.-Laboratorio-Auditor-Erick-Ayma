package com.flurry.sdk;

import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public abstract class ma implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2187a = ma.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private PrintStream f2188b;

    /* renamed from: c  reason: collision with root package name */
    private PrintWriter f2189c;

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            if (this.f2188b != null) {
                ThrowableExtension.printStackTrace(th, this.f2188b);
            } else if (this.f2189c != null) {
                ThrowableExtension.printStackTrace(th, this.f2189c);
            } else {
                ThrowableExtension.printStackTrace(th);
            }
            km.a(6, f2187a, "", th);
        }
    }
}
