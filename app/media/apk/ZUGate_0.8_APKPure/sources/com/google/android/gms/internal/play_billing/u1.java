package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public abstract class u1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class f1962a;

    /* renamed from: b  reason: collision with root package name */
    public static final x1 f1963b;

    /* renamed from: c  reason: collision with root package name */
    public static final x1 f1964c;

    static {
        Class<?> cls;
        Class<?> cls2;
        x1 x1Var = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f1962a = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                x1Var = (x1) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        f1963b = x1Var;
        f1964c = new x1();
    }

    public static void A(int i5, List list, d0 d0Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b0 b0Var = d0Var.f1849a;
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                b0Var.f0(i5, Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
                i6++;
            }
            return;
        }
        b0Var.m0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((Float) list.get(i8)).floatValue();
            i7 += 4;
        }
        b0Var.o0(i7);
        while (i6 < list.size()) {
            b0Var.g0(Float.floatToRawIntBits(((Float) list.get(i6)).floatValue()));
            i6++;
        }
    }

    public static void B(int i5, List list, d0 d0Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d0Var.getClass();
        boolean z5 = list instanceof m0;
        b0 b0Var = d0Var.f1849a;
        int i6 = 0;
        if (!z5) {
            if (!z4) {
                while (i6 < list.size()) {
                    b0Var.j0(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            b0Var.m0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += b0.v0(((Integer) list.get(i8)).intValue());
            }
            b0Var.o0(i7);
            while (i6 < list.size()) {
                b0Var.k0(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        m0 m0Var = (m0) list;
        if (!z4) {
            while (i6 < m0Var.f1926d) {
                b0Var.j0(i5, m0Var.g(i6));
                i6++;
            }
            return;
        }
        b0Var.m0(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < m0Var.f1926d; i10++) {
            i9 += b0.v0(m0Var.g(i10));
        }
        b0Var.o0(i9);
        while (i6 < m0Var.f1926d) {
            b0Var.k0(m0Var.g(i6));
            i6++;
        }
    }

    public static void C(int i5, List list, d0 d0Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b0 b0Var = d0Var.f1849a;
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                b0Var.p0(((Long) list.get(i6)).longValue(), i5);
                i6++;
            }
            return;
        }
        b0Var.m0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += b0.v0(((Long) list.get(i8)).longValue());
        }
        b0Var.o0(i7);
        while (i6 < list.size()) {
            b0Var.q0(((Long) list.get(i6)).longValue());
            i6++;
        }
    }

    public static void a(int i5, List list, d0 d0Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d0Var.getClass();
        boolean z5 = list instanceof m0;
        b0 b0Var = d0Var.f1849a;
        int i6 = 0;
        if (!z5) {
            if (!z4) {
                while (i6 < list.size()) {
                    b0Var.f0(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            b0Var.m0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Integer) list.get(i8)).intValue();
                i7 += 4;
            }
            b0Var.o0(i7);
            while (i6 < list.size()) {
                b0Var.g0(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        m0 m0Var = (m0) list;
        if (!z4) {
            while (i6 < m0Var.f1926d) {
                b0Var.f0(i5, m0Var.g(i6));
                i6++;
            }
            return;
        }
        b0Var.m0(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < m0Var.f1926d; i10++) {
            m0Var.g(i10);
            i9 += 4;
        }
        b0Var.o0(i9);
        while (i6 < m0Var.f1926d) {
            b0Var.g0(m0Var.g(i6));
            i6++;
        }
    }

    public static void b(int i5, List list, d0 d0Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b0 b0Var = d0Var.f1849a;
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                b0Var.h0(((Long) list.get(i6)).longValue(), i5);
                i6++;
            }
            return;
        }
        b0Var.m0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((Long) list.get(i8)).longValue();
            i7 += 8;
        }
        b0Var.o0(i7);
        while (i6 < list.size()) {
            b0Var.i0(((Long) list.get(i6)).longValue());
            i6++;
        }
    }

    public static void c(int i5, List list, d0 d0Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d0Var.getClass();
        boolean z5 = list instanceof m0;
        b0 b0Var = d0Var.f1849a;
        int i6 = 0;
        if (!z5) {
            if (!z4) {
                while (i6 < list.size()) {
                    int intValue = ((Integer) list.get(i6)).intValue();
                    b0Var.n0(i5, (intValue >> 31) ^ (intValue + intValue));
                    i6++;
                }
                return;
            }
            b0Var.m0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                int intValue2 = ((Integer) list.get(i8)).intValue();
                i7 += b0.u0((intValue2 >> 31) ^ (intValue2 + intValue2));
            }
            b0Var.o0(i7);
            while (i6 < list.size()) {
                int intValue3 = ((Integer) list.get(i6)).intValue();
                b0Var.o0((intValue3 >> 31) ^ (intValue3 + intValue3));
                i6++;
            }
            return;
        }
        m0 m0Var = (m0) list;
        if (!z4) {
            while (i6 < m0Var.f1926d) {
                int g5 = m0Var.g(i6);
                b0Var.n0(i5, (g5 >> 31) ^ (g5 + g5));
                i6++;
            }
            return;
        }
        b0Var.m0(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < m0Var.f1926d; i10++) {
            int g6 = m0Var.g(i10);
            i9 += b0.u0((g6 >> 31) ^ (g6 + g6));
        }
        b0Var.o0(i9);
        while (i6 < m0Var.f1926d) {
            int g7 = m0Var.g(i6);
            b0Var.o0((g7 >> 31) ^ (g7 + g7));
            i6++;
        }
    }

    public static void d(int i5, List list, d0 d0Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b0 b0Var = d0Var.f1849a;
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                long longValue = ((Long) list.get(i6)).longValue();
                b0Var.p0((longValue >> 63) ^ (longValue + longValue), i5);
                i6++;
            }
            return;
        }
        b0Var.m0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            long longValue2 = ((Long) list.get(i8)).longValue();
            i7 += b0.v0((longValue2 >> 63) ^ (longValue2 + longValue2));
        }
        b0Var.o0(i7);
        while (i6 < list.size()) {
            long longValue3 = ((Long) list.get(i6)).longValue();
            b0Var.q0((longValue3 >> 63) ^ (longValue3 + longValue3));
            i6++;
        }
    }

    public static void e(int i5, List list, d0 d0Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d0Var.getClass();
        boolean z5 = list instanceof m0;
        b0 b0Var = d0Var.f1849a;
        int i6 = 0;
        if (!z5) {
            if (!z4) {
                while (i6 < list.size()) {
                    b0Var.n0(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            b0Var.m0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += b0.u0(((Integer) list.get(i8)).intValue());
            }
            b0Var.o0(i7);
            while (i6 < list.size()) {
                b0Var.o0(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        m0 m0Var = (m0) list;
        if (!z4) {
            while (i6 < m0Var.f1926d) {
                b0Var.n0(i5, m0Var.g(i6));
                i6++;
            }
            return;
        }
        b0Var.m0(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < m0Var.f1926d; i10++) {
            i9 += b0.u0(m0Var.g(i10));
        }
        b0Var.o0(i9);
        while (i6 < m0Var.f1926d) {
            b0Var.o0(m0Var.g(i6));
            i6++;
        }
    }

    public static void f(int i5, List list, d0 d0Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b0 b0Var = d0Var.f1849a;
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                b0Var.p0(((Long) list.get(i6)).longValue(), i5);
                i6++;
            }
            return;
        }
        b0Var.m0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += b0.v0(((Long) list.get(i8)).longValue());
        }
        b0Var.o0(i7);
        while (i6 < list.size()) {
            b0Var.q0(((Long) list.get(i6)).longValue());
            i6++;
        }
    }

    public static boolean g(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int h(List list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof m0) {
            m0 m0Var = (m0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += b0.v0(m0Var.g(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += b0.v0(((Integer) list.get(i6)).intValue());
                i6++;
            }
        }
        return i5;
    }

    public static int i(int i5, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (b0.u0(i5 << 3) + 4) * size;
    }

    public static int j(List list) {
        return list.size() * 4;
    }

    public static int k(int i5, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (b0.u0(i5 << 3) + 8) * size;
    }

    public static int l(List list) {
        return list.size() * 8;
    }

    public static int m(List list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof m0) {
            m0 m0Var = (m0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += b0.v0(m0Var.g(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += b0.v0(((Integer) list.get(i6)).intValue());
                i6++;
            }
        }
        return i5;
    }

    public static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += b0.v0(((Long) list.get(i6)).longValue());
        }
        return i5;
    }

    public static int o(int i5, t1 t1Var, Object obj) {
        return b0.s0((j1) obj, t1Var) + b0.u0(i5 << 3);
    }

    public static int p(List list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof m0) {
            m0 m0Var = (m0) list;
            i5 = 0;
            while (i6 < size) {
                int g5 = m0Var.g(i6);
                i5 += b0.u0((g5 >> 31) ^ (g5 + g5));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                int intValue = ((Integer) list.get(i6)).intValue();
                i5 += b0.u0((intValue >> 31) ^ (intValue + intValue));
                i6++;
            }
        }
        return i5;
    }

    public static int q(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            long longValue = ((Long) list.get(i6)).longValue();
            i5 += b0.v0((longValue >> 63) ^ (longValue + longValue));
        }
        return i5;
    }

    public static int r(List list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof m0) {
            m0 m0Var = (m0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += b0.u0(m0Var.g(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += b0.u0(((Integer) list.get(i6)).intValue());
                i6++;
            }
        }
        return i5;
    }

    public static int s(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += b0.v0(((Long) list.get(i6)).longValue());
        }
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r5 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object t(java.lang.Object r2, int r3, int r4, java.lang.Object r5, com.google.android.gms.internal.play_billing.x1 r6) {
        /*
            if (r5 != 0) goto L13
            r6.getClass()
            com.google.android.gms.internal.play_billing.l0 r2 = (com.google.android.gms.internal.play_billing.l0) r2
            com.google.android.gms.internal.play_billing.w1 r5 = r2.zzc
            com.google.android.gms.internal.play_billing.w1 r0 = com.google.android.gms.internal.play_billing.w1.f1985f
            if (r5 != r0) goto L13
            com.google.android.gms.internal.play_billing.w1 r5 = com.google.android.gms.internal.play_billing.w1.b()
            r2.zzc = r5
        L13:
            long r0 = (long) r4
            r6.getClass()
            int r2 = r3 << 3
            java.lang.Long r3 = java.lang.Long.valueOf(r0)
            r4 = r5
            com.google.android.gms.internal.play_billing.w1 r4 = (com.google.android.gms.internal.play_billing.w1) r4
            r4.c(r2, r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.u1.t(java.lang.Object, int, int, java.lang.Object, com.google.android.gms.internal.play_billing.x1):java.lang.Object");
    }

    public static void u(x1 x1Var, Object obj, Object obj2) {
        x1Var.getClass();
        l0 l0Var = (l0) obj;
        w1 w1Var = l0Var.zzc;
        w1 w1Var2 = ((l0) obj2).zzc;
        w1 w1Var3 = w1.f1985f;
        if (!w1Var3.equals(w1Var2)) {
            if (w1Var3.equals(w1Var)) {
                int i5 = w1Var.f1986a + w1Var2.f1986a;
                int[] copyOf = Arrays.copyOf(w1Var.f1987b, i5);
                System.arraycopy(w1Var2.f1987b, 0, copyOf, w1Var.f1986a, w1Var2.f1986a);
                Object[] copyOf2 = Arrays.copyOf(w1Var.f1988c, i5);
                System.arraycopy(w1Var2.f1988c, 0, copyOf2, w1Var.f1986a, w1Var2.f1986a);
                w1Var = new w1(i5, copyOf, copyOf2, true);
            } else {
                w1Var.getClass();
                if (!w1Var2.equals(w1Var3)) {
                    if (!w1Var.f1990e) {
                        throw new UnsupportedOperationException();
                    }
                    int i6 = w1Var.f1986a + w1Var2.f1986a;
                    w1Var.e(i6);
                    System.arraycopy(w1Var2.f1987b, 0, w1Var.f1987b, w1Var.f1986a, w1Var2.f1986a);
                    System.arraycopy(w1Var2.f1988c, 0, w1Var.f1988c, w1Var.f1986a, w1Var2.f1986a);
                    w1Var.f1986a = i6;
                }
            }
        }
        l0Var.zzc = w1Var;
    }

    public static void v(int i5, List list, d0 d0Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b0 b0Var = d0Var.f1849a;
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                boolean booleanValue = ((Boolean) list.get(i6)).booleanValue();
                b0Var.o0(i5 << 3);
                b0Var.c0(booleanValue ? (byte) 1 : (byte) 0);
                i6++;
            }
            return;
        }
        b0Var.m0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((Boolean) list.get(i8)).booleanValue();
            i7++;
        }
        b0Var.o0(i7);
        while (i6 < list.size()) {
            b0Var.c0(((Boolean) list.get(i6)).booleanValue() ? (byte) 1 : (byte) 0);
            i6++;
        }
    }

    public static void w(int i5, List list, d0 d0Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b0 b0Var = d0Var.f1849a;
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                b0Var.h0(Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()), i5);
                i6++;
            }
            return;
        }
        b0Var.m0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((Double) list.get(i8)).doubleValue();
            i7 += 8;
        }
        b0Var.o0(i7);
        while (i6 < list.size()) {
            b0Var.i0(Double.doubleToRawLongBits(((Double) list.get(i6)).doubleValue()));
            i6++;
        }
    }

    public static void x(int i5, List list, d0 d0Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d0Var.getClass();
        boolean z5 = list instanceof m0;
        b0 b0Var = d0Var.f1849a;
        int i6 = 0;
        if (!z5) {
            if (!z4) {
                while (i6 < list.size()) {
                    b0Var.j0(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            b0Var.m0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += b0.v0(((Integer) list.get(i8)).intValue());
            }
            b0Var.o0(i7);
            while (i6 < list.size()) {
                b0Var.k0(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        m0 m0Var = (m0) list;
        if (!z4) {
            while (i6 < m0Var.f1926d) {
                b0Var.j0(i5, m0Var.g(i6));
                i6++;
            }
            return;
        }
        b0Var.m0(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < m0Var.f1926d; i10++) {
            i9 += b0.v0(m0Var.g(i10));
        }
        b0Var.o0(i9);
        while (i6 < m0Var.f1926d) {
            b0Var.k0(m0Var.g(i6));
            i6++;
        }
    }

    public static void y(int i5, List list, d0 d0Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d0Var.getClass();
        boolean z5 = list instanceof m0;
        b0 b0Var = d0Var.f1849a;
        int i6 = 0;
        if (!z5) {
            if (!z4) {
                while (i6 < list.size()) {
                    b0Var.f0(i5, ((Integer) list.get(i6)).intValue());
                    i6++;
                }
                return;
            }
            b0Var.m0(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                ((Integer) list.get(i8)).intValue();
                i7 += 4;
            }
            b0Var.o0(i7);
            while (i6 < list.size()) {
                b0Var.g0(((Integer) list.get(i6)).intValue());
                i6++;
            }
            return;
        }
        m0 m0Var = (m0) list;
        if (!z4) {
            while (i6 < m0Var.f1926d) {
                b0Var.f0(i5, m0Var.g(i6));
                i6++;
            }
            return;
        }
        b0Var.m0(i5, 2);
        int i9 = 0;
        for (int i10 = 0; i10 < m0Var.f1926d; i10++) {
            m0Var.g(i10);
            i9 += 4;
        }
        b0Var.o0(i9);
        while (i6 < m0Var.f1926d) {
            b0Var.g0(m0Var.g(i6));
            i6++;
        }
    }

    public static void z(int i5, List list, d0 d0Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b0 b0Var = d0Var.f1849a;
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                b0Var.h0(((Long) list.get(i6)).longValue(), i5);
                i6++;
            }
            return;
        }
        b0Var.m0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((Long) list.get(i8)).longValue();
            i7 += 8;
        }
        b0Var.o0(i7);
        while (i6 < list.size()) {
            b0Var.i0(((Long) list.get(i6)).longValue());
            i6++;
        }
    }
}
