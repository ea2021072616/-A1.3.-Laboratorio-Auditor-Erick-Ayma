package com.flurry.sdk;

import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class kt {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2082a = kt.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Timer f2083b;

    /* renamed from: c  reason: collision with root package name */
    private a f2084c;
    private ku d;

    public kt(ku kuVar) {
        this.d = kuVar;
    }

    public final synchronized void a(long j) {
        synchronized (this) {
            if (this.f2083b != null) {
                a();
            }
            this.f2083b = new Timer("HttpRequestTimeoutTimer");
            this.f2084c = new a(this, (byte) 0);
            this.f2083b.schedule(this.f2084c, j);
            km.a(3, f2082a, "HttpRequestTimeoutTimer started: " + j + "MS");
        }
    }

    public final synchronized void a() {
        if (this.f2083b != null) {
            this.f2083b.cancel();
            this.f2083b = null;
            km.a(3, f2082a, "HttpRequestTimeoutTimer stopped.");
        }
        this.f2084c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends TimerTask {
        private a() {
        }

        /* synthetic */ a(kt ktVar, byte b2) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            km.a(3, kt.f2082a, "HttpRequest timed out. Cancelling.");
            ku kuVar = kt.this.d;
            km.a(3, ku.e, "Timeout (" + (System.currentTimeMillis() - kuVar.n) + "MS) for url: " + kuVar.g);
            kuVar.q = 629;
            kuVar.t = true;
            kuVar.e();
            kuVar.f();
        }
    }
}
