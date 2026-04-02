package com.flurry.sdk;
/* loaded from: classes.dex */
public final class lt {

    /* renamed from: a  reason: collision with root package name */
    private static long f2177a = 100;

    /* renamed from: b  reason: collision with root package name */
    private static lt f2178b = null;

    /* renamed from: c  reason: collision with root package name */
    private final lu f2179c = new lu();

    public lt() {
        this.f2179c.f2180a = f2177a;
        this.f2179c.f2181b = true;
    }

    public static synchronized lt a() {
        lt ltVar;
        synchronized (lt.class) {
            if (f2178b == null) {
                f2178b = new lt();
            }
            ltVar = f2178b;
        }
        return ltVar;
    }

    public final synchronized void a(kh<ls> khVar) {
        ki.a().a("com.flurry.android.sdk.TickEvent", khVar);
        if (ki.a().a("com.flurry.android.sdk.TickEvent") > 0) {
            this.f2179c.a();
        }
    }

    public final synchronized void b(kh<ls> khVar) {
        ki.a().b("com.flurry.android.sdk.TickEvent", khVar);
        if (ki.a().a("com.flurry.android.sdk.TickEvent") == 0) {
            this.f2179c.b();
        }
    }
}
