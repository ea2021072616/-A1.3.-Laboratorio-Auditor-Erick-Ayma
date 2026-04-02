package com.google.android.gms.internal.play_billing;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
/* loaded from: classes.dex */
public abstract class f2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Unsafe f1860a;

    /* renamed from: b  reason: collision with root package name */
    public static final Class f1861b;

    /* renamed from: c  reason: collision with root package name */
    public static final e2 f1862c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f1863d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f1864e;

    /* renamed from: f  reason: collision with root package name */
    public static final long f1865f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f1866g;

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012d  */
    static {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.f2.<clinit>():void");
    }

    public static void a(Class cls) {
        if (f1864e) {
            f1862c.f1858a.arrayIndexScale(cls);
        }
    }

    public static Field b() {
        Field field;
        Field field2;
        int i5 = u.f1960a;
        try {
            field = Buffer.class.getDeclaredField("effectiveDirectAddress");
        } catch (Throwable unused) {
            field = null;
        }
        if (field == null) {
            try {
                field2 = Buffer.class.getDeclaredField("address");
            } catch (Throwable unused2) {
                field2 = null;
            }
            if (field2 == null || field2.getType() != Long.TYPE) {
                return null;
            }
            return field2;
        }
        return field;
    }

    public static void c(Object obj, long j5, byte b5) {
        e2 e2Var = f1862c;
        long j6 = (-4) & j5;
        int i5 = e2Var.f1858a.getInt(obj, j6);
        int i6 = ((~((int) j5)) & 3) << 3;
        e2Var.f1858a.putInt(obj, j6, ((255 & b5) << i6) | (i5 & (~(255 << i6))));
    }

    public static void d(Object obj, long j5, byte b5) {
        e2 e2Var = f1862c;
        long j6 = (-4) & j5;
        int i5 = (((int) j5) & 3) << 3;
        e2Var.f1858a.putInt(obj, j6, ((255 & b5) << i5) | (e2Var.f1858a.getInt(obj, j6) & (~(255 << i5))));
    }

    public static double e(long j5, Object obj) {
        return f1862c.a(j5, obj);
    }

    public static float f(long j5, Object obj) {
        return f1862c.b(j5, obj);
    }

    public static int g(long j5, Object obj) {
        return f1862c.f1858a.getInt(obj, j5);
    }

    public static long h(long j5, Object obj) {
        return f1862c.f1858a.getLong(obj, j5);
    }

    public static Object i(Class cls) {
        try {
            return f1860a.allocateInstance(cls);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(e5);
        }
    }

    public static Object j(long j5, Object obj) {
        return f1862c.f1858a.getObject(obj, j5);
    }

    public static Unsafe k() {
        try {
            return (Unsafe) AccessController.doPrivileged(new b2());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void l(Throwable th) {
        Logger.getLogger(f2.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static void m(Object obj, long j5, boolean z4) {
        f1862c.c(obj, j5, z4);
    }

    public static void n(Object obj, long j5, double d5) {
        f1862c.e(obj, j5, d5);
    }

    public static void o(Object obj, long j5, float f5) {
        f1862c.f(obj, j5, f5);
    }

    public static void p(int i5, long j5, Object obj) {
        f1862c.f1858a.putInt(obj, j5, i5);
    }

    public static void q(Object obj, long j5, long j6) {
        f1862c.f1858a.putLong(obj, j5, j6);
    }

    public static void r(long j5, Object obj, Object obj2) {
        f1862c.f1858a.putObject(obj, j5, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean s(long j5, Object obj) {
        return ((byte) ((f1862c.f1858a.getInt(obj, (-4) & j5) >>> ((int) (((~j5) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean t(long j5, Object obj) {
        return ((byte) ((f1862c.f1858a.getInt(obj, (-4) & j5) >>> ((int) ((j5 & 3) << 3))) & 255)) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean u(Class cls) {
        int i5 = u.f1960a;
        try {
            Class cls2 = f1861b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean v(long j5, Object obj) {
        return f1862c.g(j5, obj);
    }

    public static int w(Class cls) {
        if (f1864e) {
            return f1862c.f1858a.arrayBaseOffset(cls);
        }
        return -1;
    }
}
