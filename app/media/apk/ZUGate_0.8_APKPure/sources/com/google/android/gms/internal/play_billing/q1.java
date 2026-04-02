package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class q1 {

    /* renamed from: c  reason: collision with root package name */
    public static final q1 f1939c = new q1();

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap f1941b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public final d1 f1940a = new d1();

    public final t1 a(Class cls) {
        m1 m1Var;
        Class cls2;
        Charset charset = s0.f1953a;
        if (cls != null) {
            ConcurrentHashMap concurrentHashMap = this.f1941b;
            t1 t1Var = (t1) concurrentHashMap.get(cls);
            if (t1Var == null) {
                d1 d1Var = this.f1940a;
                d1Var.getClass();
                Class cls3 = u1.f1962a;
                if (!l0.class.isAssignableFrom(cls) && (cls2 = u1.f1962a) != null && !cls2.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
                }
                h1 a5 = d1Var.f1851a.a(cls);
                s1 s1Var = (s1) a5;
                if ((s1Var.f1958d & 2) == 2) {
                    boolean isAssignableFrom = l0.class.isAssignableFrom(cls);
                    j1 j1Var = s1Var.f1955a;
                    if (isAssignableFrom) {
                        m1Var = new m1(u1.f1964c, g0.f1871a, j1Var);
                    } else {
                        x1 x1Var = u1.f1963b;
                        f0 f0Var = g0.f1872b;
                        if (f0Var == null) {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                        m1Var = new m1(x1Var, f0Var, j1Var);
                    }
                    t1Var = m1Var;
                } else if (l0.class.isAssignableFrom(cls)) {
                    if (s1Var.b() + (-1) != 1) {
                        int i5 = o1.f1937a;
                        z0 z0Var = a1.f1835b;
                        x1 x1Var2 = u1.f1964c;
                        f0 f0Var2 = g0.f1871a;
                        int i6 = g1.f1873a;
                        t1Var = l1.v(a5, z0Var, x1Var2, f0Var2);
                    } else {
                        int i7 = o1.f1937a;
                        z0 z0Var2 = a1.f1835b;
                        x1 x1Var3 = u1.f1964c;
                        int i8 = g1.f1873a;
                        t1Var = l1.v(a5, z0Var2, x1Var3, null);
                    }
                } else {
                    if (s1Var.b() + (-1) != 1) {
                        int i9 = o1.f1937a;
                        y0 y0Var = a1.f1834a;
                        x1 x1Var4 = u1.f1963b;
                        f0 f0Var3 = g0.f1872b;
                        if (f0Var3 == null) {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                        int i10 = g1.f1873a;
                        t1Var = l1.v(a5, y0Var, x1Var4, f0Var3);
                    } else {
                        int i11 = o1.f1937a;
                        y0 y0Var2 = a1.f1834a;
                        x1 x1Var5 = u1.f1963b;
                        int i12 = g1.f1873a;
                        t1Var = l1.v(a5, y0Var2, x1Var5, null);
                    }
                }
                t1 t1Var2 = (t1) concurrentHashMap.putIfAbsent(cls, t1Var);
                if (t1Var2 != null) {
                    return t1Var2;
                }
            }
            return t1Var;
        }
        throw new NullPointerException("messageType");
    }
}
