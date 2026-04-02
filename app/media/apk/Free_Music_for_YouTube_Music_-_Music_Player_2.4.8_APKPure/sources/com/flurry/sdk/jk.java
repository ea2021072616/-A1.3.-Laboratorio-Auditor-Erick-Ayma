package com.flurry.sdk;

import android.content.Context;
/* loaded from: classes.dex */
public class jk implements kp {
    public static synchronized jk a() {
        jk jkVar;
        synchronized (jk.class) {
            jkVar = (jk) jy.a().a(jk.class);
        }
        return jkVar;
    }

    @Override // com.flurry.sdk.kp
    public final void a(Context context) {
        lk.a(jx.class);
        ki.a();
        lt.a();
        lp.a();
        ka.a();
        jr.a();
        jl.a();
        js.a();
        jp.a();
        jl.a();
        ju.a();
        jo.a();
        jw.a();
    }

    public static String b() {
        jx c2 = c();
        if (c2 == null) {
            return null;
        }
        return Long.toString(c2.f2017c);
    }

    public static jx c() {
        lk b2 = lm.a().b();
        if (b2 == null) {
            return null;
        }
        return (jx) b2.b(jx.class);
    }

    public static long d() {
        jx c2 = c();
        if (c2 == null) {
            return 0L;
        }
        return c2.f2017c;
    }

    public static long e() {
        jx c2 = c();
        if (c2 == null) {
            return 0L;
        }
        return c2.d;
    }

    public static long f() {
        jx c2 = c();
        if (c2 == null) {
            return -1L;
        }
        return c2.e;
    }

    public static long g() {
        jx c2 = c();
        if (c2 == null) {
            return 0L;
        }
        return c2.c();
    }

    public static int h() {
        return jr.a().b();
    }
}
