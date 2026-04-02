package com.google.android.gms.internal.play_billing;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;
/* loaded from: classes.dex */
public final class l1 implements t1 {

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f1909k = new int[0];

    /* renamed from: l  reason: collision with root package name */
    public static final Unsafe f1910l = f2.k();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f1911a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f1912b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1913c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1914d;

    /* renamed from: e  reason: collision with root package name */
    public final j1 f1915e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f1916f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1917g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1918h;

    /* renamed from: i  reason: collision with root package name */
    public final a1 f1919i;

    /* renamed from: j  reason: collision with root package name */
    public final x1 f1920j;

    public l1(int[] iArr, Object[] objArr, int i5, int i6, j1 j1Var, int[] iArr2, int i7, int i8, a1 a1Var, x1 x1Var, f0 f0Var) {
        this.f1911a = iArr;
        this.f1912b = objArr;
        this.f1913c = i5;
        this.f1914d = i6;
        this.f1916f = iArr2;
        this.f1917g = i7;
        this.f1918h = i8;
        this.f1919i = a1Var;
        this.f1920j = x1Var;
        this.f1915e = j1Var;
    }

    public static Field D(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static boolean s(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof l0) {
            return ((l0) obj).k();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0286  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.play_billing.l1 v(com.google.android.gms.internal.play_billing.h1 r33, com.google.android.gms.internal.play_billing.a1 r34, com.google.android.gms.internal.play_billing.x1 r35, com.google.android.gms.internal.play_billing.f0 r36) {
        /*
            Method dump skipped, instructions count: 1031
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.l1.v(com.google.android.gms.internal.play_billing.h1, com.google.android.gms.internal.play_billing.a1, com.google.android.gms.internal.play_billing.x1, com.google.android.gms.internal.play_billing.f0):com.google.android.gms.internal.play_billing.l1");
    }

    public static int w(long j5, Object obj) {
        return ((Integer) f2.j(j5, obj)).intValue();
    }

    public static long z(long j5, Object obj) {
        return ((Long) f2.j(j5, obj)).longValue();
    }

    public final t1 A(int i5) {
        int i6 = i5 / 3;
        int i7 = i6 + i6;
        Object[] objArr = this.f1912b;
        t1 t1Var = (t1) objArr[i7];
        if (t1Var != null) {
            return t1Var;
        }
        t1 a5 = q1.f1939c.a((Class) objArr[i7 + 1]);
        objArr[i7] = a5;
        return a5;
    }

    public final Object B(int i5, Object obj) {
        t1 A = A(i5);
        int y5 = y(i5) & 1048575;
        if (q(i5, obj)) {
            Object object = f1910l.getObject(obj, y5);
            if (s(object)) {
                return object;
            }
            l0 a5 = A.a();
            if (object != null) {
                A.f(a5, object);
            }
            return a5;
        }
        return A.a();
    }

    public final Object C(int i5, int i6, Object obj) {
        t1 A = A(i6);
        if (t(i5, i6, obj)) {
            Object object = f1910l.getObject(obj, y(i6) & 1048575);
            if (s(object)) {
                return object;
            }
            l0 a5 = A.a();
            if (object != null) {
                A.f(a5, object);
            }
            return a5;
        }
        return A.a();
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final l0 a() {
        return (l0) ((l0) this.f1915e).l(4);
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final void b(Object obj) {
        if (!s(obj)) {
            return;
        }
        int i5 = 0;
        if (obj instanceof l0) {
            l0 l0Var = (l0) obj;
            l0Var.i();
            l0Var.zza = 0;
            l0Var.g();
        }
        while (true) {
            int[] iArr = this.f1911a;
            if (i5 >= iArr.length) {
                this.f1920j.getClass();
                x1.c(obj);
                return;
            }
            int y5 = y(i5);
            int i6 = 1048575 & y5;
            int i7 = (y5 >>> 20) & 255;
            long j5 = i6;
            Unsafe unsafe = f1910l;
            if (i7 != 9) {
                if (i7 != 60 && i7 != 68) {
                    switch (i7) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.f1919i.a(j5, obj);
                            break;
                        case 50:
                            Object object = unsafe.getObject(obj, j5);
                            if (object == null) {
                                break;
                            } else {
                                ((e1) object).c();
                                unsafe.putObject(obj, j5, object);
                                break;
                            }
                    }
                } else if (t(iArr[i5], i5, obj)) {
                    A(i5).b(unsafe.getObject(obj, j5));
                }
                i5 += 3;
            }
            if (q(i5, obj)) {
                A(i5).b(unsafe.getObject(obj, j5));
            }
            i5 += 3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.t1
    public final void c(Object obj, d0 d0Var) {
        int i5;
        int i6;
        int i7;
        int i8 = 1048575;
        boolean z4 = 0;
        int i9 = 1048575;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = this.f1911a;
            if (i11 >= iArr.length) {
                this.f1920j.getClass();
                x1.d(x1.b(obj), d0Var);
                return;
            }
            int y5 = y(i11);
            int i12 = (y5 >>> 20) & 255;
            int i13 = iArr[i11];
            Unsafe unsafe = f1910l;
            if (i12 <= 17) {
                int i14 = iArr[i11 + 2];
                int i15 = i14 & i8;
                if (i15 != i9) {
                    i10 = i15 == i8 ? z4 : unsafe.getInt(obj, i15);
                    i9 = i15;
                }
                i6 = i10;
                i7 = 1 << (i14 >>> 20);
                i5 = i9;
            } else {
                i5 = i9;
                i6 = i10;
                i7 = z4;
            }
            long j5 = y5 & i8;
            switch (i12) {
                case 0:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.i(i13, f2.e(j5, obj));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.m(i13, f2.f(j5, obj));
                        break;
                    } else {
                        break;
                    }
                case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.p(unsafe.getLong(obj, j5), i13);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.e(unsafe.getLong(obj, j5), i13);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.o(i13, unsafe.getInt(obj, j5));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.l(unsafe.getLong(obj, j5), i13);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.k(i13, unsafe.getInt(obj, j5));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.f(i13, f2.v(j5, obj));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (r(obj, i11, i5, i6, i7)) {
                        Object object = unsafe.getObject(obj, j5);
                        if (object instanceof String) {
                            d0Var.f1849a.l0(i13, (String) object);
                            break;
                        } else {
                            d0Var.g(i13, (z) object);
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.q(i13, A(i11), unsafe.getObject(obj, j5));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.g(i13, (z) unsafe.getObject(obj, j5));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.d(i13, unsafe.getInt(obj, j5));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.j(i13, unsafe.getInt(obj, j5));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.r(i13, unsafe.getInt(obj, j5));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.s(unsafe.getLong(obj, j5), i13);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.a(i13, unsafe.getInt(obj, j5));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.b(unsafe.getLong(obj, j5), i13);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (r(obj, i11, i5, i6, i7)) {
                        d0Var.n(i13, A(i11), unsafe.getObject(obj, j5));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    u1.w(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, z4);
                    break;
                case 19:
                    u1.A(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, z4);
                    break;
                case 20:
                    u1.C(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, z4);
                    break;
                case 21:
                    u1.f(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, z4);
                    break;
                case 22:
                    u1.B(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, z4);
                    break;
                case 23:
                    u1.z(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, z4);
                    break;
                case 24:
                    u1.y(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, z4);
                    break;
                case 25:
                    u1.v(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, z4);
                    break;
                case 26:
                    int i16 = iArr[i11];
                    List list = (List) unsafe.getObject(obj, j5);
                    Class cls = u1.f1962a;
                    if (list != null && !list.isEmpty()) {
                        d0Var.c(i16, list);
                        break;
                    }
                    break;
                case 27:
                    int i17 = iArr[i11];
                    List list2 = (List) unsafe.getObject(obj, j5);
                    t1 A = A(i11);
                    Class cls2 = u1.f1962a;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i18 = z4; i18 < list2.size(); i18++) {
                            d0Var.q(i17, A, list2.get(i18));
                        }
                        break;
                    }
                    break;
                case 28:
                    int i19 = iArr[i11];
                    List list3 = (List) unsafe.getObject(obj, j5);
                    Class cls3 = u1.f1962a;
                    if (list3 != null && !list3.isEmpty()) {
                        d0Var.h(i19, list3);
                        break;
                    }
                    break;
                case 29:
                    u1.e(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, z4);
                    break;
                case 30:
                    u1.x(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, z4);
                    break;
                case 31:
                    u1.a(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, z4);
                    break;
                case 32:
                    u1.b(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, z4);
                    break;
                case 33:
                    u1.c(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, z4);
                    break;
                case 34:
                    u1.d(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, z4);
                    break;
                case 35:
                    u1.w(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, true);
                    break;
                case 36:
                    u1.A(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, true);
                    break;
                case 37:
                    u1.C(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, true);
                    break;
                case 38:
                    u1.f(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, true);
                    break;
                case 39:
                    u1.B(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, true);
                    break;
                case 40:
                    u1.z(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, true);
                    break;
                case 41:
                    u1.y(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, true);
                    break;
                case 42:
                    u1.v(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, true);
                    break;
                case 43:
                    u1.e(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, true);
                    break;
                case 44:
                    u1.x(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, true);
                    break;
                case 45:
                    u1.a(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, true);
                    break;
                case 46:
                    u1.b(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, true);
                    break;
                case 47:
                    u1.c(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, true);
                    break;
                case 48:
                    u1.d(iArr[i11], (List) unsafe.getObject(obj, j5), d0Var, true);
                    break;
                case 49:
                    int i20 = iArr[i11];
                    List list4 = (List) unsafe.getObject(obj, j5);
                    t1 A2 = A(i11);
                    Class cls4 = u1.f1962a;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i21 = z4; i21 < list4.size(); i21++) {
                            d0Var.n(i20, A2, list4.get(i21));
                        }
                        break;
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j5) != null) {
                        int i22 = i11 / 3;
                        androidx.appcompat.widget.b0.n(this.f1912b[i22 + i22]);
                        throw null;
                    }
                    break;
                case 51:
                    if (t(i13, i11, obj)) {
                        d0Var.i(i13, ((Double) f2.j(j5, obj)).doubleValue());
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (t(i13, i11, obj)) {
                        d0Var.m(i13, ((Float) f2.j(j5, obj)).floatValue());
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (t(i13, i11, obj)) {
                        d0Var.p(z(j5, obj), i13);
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (t(i13, i11, obj)) {
                        d0Var.e(z(j5, obj), i13);
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (t(i13, i11, obj)) {
                        d0Var.o(i13, w(j5, obj));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (t(i13, i11, obj)) {
                        d0Var.l(z(j5, obj), i13);
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (t(i13, i11, obj)) {
                        d0Var.k(i13, w(j5, obj));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (t(i13, i11, obj)) {
                        d0Var.f(i13, ((Boolean) f2.j(j5, obj)).booleanValue());
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (t(i13, i11, obj)) {
                        Object object2 = unsafe.getObject(obj, j5);
                        if (object2 instanceof String) {
                            d0Var.f1849a.l0(i13, (String) object2);
                            break;
                        } else {
                            d0Var.g(i13, (z) object2);
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (t(i13, i11, obj)) {
                        d0Var.q(i13, A(i11), unsafe.getObject(obj, j5));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (t(i13, i11, obj)) {
                        d0Var.g(i13, (z) unsafe.getObject(obj, j5));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (t(i13, i11, obj)) {
                        d0Var.d(i13, w(j5, obj));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (t(i13, i11, obj)) {
                        d0Var.j(i13, w(j5, obj));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (t(i13, i11, obj)) {
                        d0Var.r(i13, w(j5, obj));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (t(i13, i11, obj)) {
                        d0Var.s(z(j5, obj), i13);
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (t(i13, i11, obj)) {
                        d0Var.a(i13, w(j5, obj));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (t(i13, i11, obj)) {
                        d0Var.b(z(j5, obj), i13);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (t(i13, i11, obj)) {
                        d0Var.n(i13, A(i11), unsafe.getObject(obj, j5));
                        break;
                    } else {
                        break;
                    }
            }
            i11 += 3;
            i9 = i5;
            i10 = i6;
            i8 = 1048575;
            z4 = 0;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final void d(Object obj, byte[] bArr, int i5, int i6, v vVar) {
        u(obj, bArr, i5, i6, 0, vVar);
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final int e(Object obj) {
        int i5;
        int i6;
        int i7;
        int u02;
        int u03;
        int u04;
        int v02;
        int u05;
        int u06;
        int i8;
        int u07;
        int o;
        int u08;
        int size;
        int s5;
        int u09;
        int u010;
        int i9;
        int i10 = 1048575;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 1048575;
        while (true) {
            int[] iArr = this.f1911a;
            if (i11 >= iArr.length) {
                this.f1920j.getClass();
                return x1.a(x1.b(obj)) + i12;
            }
            int y5 = y(i11);
            int i15 = (y5 >>> 20) & 255;
            int i16 = iArr[i11];
            int i17 = iArr[i11 + 2];
            int i18 = i17 & i10;
            Unsafe unsafe = f1910l;
            if (i15 <= 17) {
                if (i18 != i14) {
                    i13 = i18 == i10 ? 0 : unsafe.getInt(obj, i18);
                    i14 = i18;
                }
                i5 = 1 << (i17 >>> 20);
            } else {
                i5 = 0;
            }
            int i19 = i14;
            int i20 = i13;
            int i21 = i5;
            int i22 = i10 & y5;
            if (i15 >= h0.f1877c.a()) {
                h0.f1878d.getClass();
            }
            long j5 = i22;
            switch (i15) {
                case 0:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        u02 = b0.u0(i16 << 3);
                        o = u02 + 8;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 1:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        u03 = b0.u0(i16 << 3);
                        o = u03 + 4;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        long j6 = unsafe.getLong(obj, j5);
                        u04 = b0.u0(i16 << 3);
                        v02 = b0.v0(j6);
                        i12 = v02 + u04 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 3:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        long j7 = unsafe.getLong(obj, j5);
                        u04 = b0.u0(i16 << 3);
                        v02 = b0.v0(j7);
                        i12 = v02 + u04 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 4:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        u04 = b0.u0(i16 << 3);
                        v02 = b0.v0(unsafe.getInt(obj, j5));
                        i12 = v02 + u04 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 5:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        u02 = b0.u0(i16 << 3);
                        o = u02 + 8;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 6:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        u03 = b0.u0(i16 << 3);
                        o = u03 + 4;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 7:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        u05 = b0.u0(i16 << 3);
                        o = u05 + 1;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 8:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        int i23 = i16 << 3;
                        Object object = unsafe.getObject(obj, j5);
                        if (object instanceof z) {
                            u06 = b0.u0(i23);
                            i8 = ((z) object).i();
                            u07 = b0.u0(i8);
                            i12 = u07 + i8 + u06 + i6;
                            i11 += 3;
                            i10 = 1048575;
                            i13 = i20;
                            i14 = i7;
                        } else {
                            u04 = b0.u0(i23);
                            v02 = b0.t0((String) object);
                            i12 = v02 + u04 + i6;
                            i11 += 3;
                            i10 = 1048575;
                            i13 = i20;
                            i14 = i7;
                        }
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 9:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        o = u1.o(i16, A(i11), unsafe.getObject(obj, j5));
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 10:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        u06 = b0.u0(i16 << 3);
                        i8 = ((z) unsafe.getObject(obj, j5)).i();
                        u07 = b0.u0(i8);
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 11:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        int i24 = unsafe.getInt(obj, j5);
                        u04 = b0.u0(i16 << 3);
                        v02 = b0.u0(i24);
                        i12 = v02 + u04 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 12:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        u04 = b0.u0(i16 << 3);
                        v02 = b0.v0(unsafe.getInt(obj, j5));
                        i12 = v02 + u04 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 13:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        u03 = b0.u0(i16 << 3);
                        o = u03 + 4;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 14:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        u02 = b0.u0(i16 << 3);
                        o = u02 + 8;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 15:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        int i25 = unsafe.getInt(obj, j5);
                        u04 = b0.u0(i16 << 3);
                        v02 = b0.u0((i25 >> 31) ^ (i25 + i25));
                        i12 = v02 + u04 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 16:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i7, i20, i21)) {
                        long j8 = unsafe.getLong(obj, j5);
                        u04 = b0.u0(i16 << 3);
                        v02 = b0.v0((j8 >> 63) ^ (j8 + j8));
                        i12 = v02 + u04 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 17:
                    i6 = i12;
                    i7 = i19;
                    if (r(obj, i11, i19, i20, i21)) {
                        o = b0.r0(i16, (j1) unsafe.getObject(obj, j5), A(i11));
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 18:
                    o = u1.k(i16, (List) unsafe.getObject(obj, j5));
                    i6 = i12;
                    i7 = i19;
                    i12 = i6 + o;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 19:
                    o = u1.i(i16, (List) unsafe.getObject(obj, j5));
                    i6 = i12;
                    i7 = i19;
                    i12 = i6 + o;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 20:
                    List list = (List) unsafe.getObject(obj, j5);
                    Class cls = u1.f1962a;
                    if (list.size() != 0) {
                        u08 = (b0.u0(i16 << 3) * list.size()) + u1.n(list);
                        i12 += u08;
                        i7 = i19;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    u08 = 0;
                    i12 += u08;
                    i7 = i19;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j5);
                    Class cls2 = u1.f1962a;
                    size = list2.size();
                    if (size != 0) {
                        s5 = u1.s(list2);
                        u09 = b0.u0(i16 << 3);
                        u010 = (u09 * size) + s5;
                        i12 += u010;
                        i7 = i19;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    u010 = 0;
                    i12 += u010;
                    i7 = i19;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j5);
                    Class cls3 = u1.f1962a;
                    size = list3.size();
                    if (size != 0) {
                        s5 = u1.m(list3);
                        u09 = b0.u0(i16 << 3);
                        u010 = (u09 * size) + s5;
                        i12 += u010;
                        i7 = i19;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    u010 = 0;
                    i12 += u010;
                    i7 = i19;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 23:
                    o = u1.k(i16, (List) unsafe.getObject(obj, j5));
                    i6 = i12;
                    i7 = i19;
                    i12 = i6 + o;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 24:
                    o = u1.i(i16, (List) unsafe.getObject(obj, j5));
                    i6 = i12;
                    i7 = i19;
                    i12 = i6 + o;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 25:
                    Class cls4 = u1.f1962a;
                    int size2 = ((List) unsafe.getObject(obj, j5)).size();
                    if (size2 != 0) {
                        u08 = (b0.u0(i16 << 3) + 1) * size2;
                        i12 += u08;
                        i7 = i19;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    u08 = 0;
                    i12 += u08;
                    i7 = i19;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 26:
                    List list4 = (List) unsafe.getObject(obj, j5);
                    Class cls5 = u1.f1962a;
                    int size3 = list4.size();
                    if (size3 != 0) {
                        u010 = b0.u0(i16 << 3) * size3;
                        if (list4 instanceof x0) {
                            x0 x0Var = (x0) list4;
                            for (int i26 = 0; i26 < size3; i26++) {
                                Object d5 = x0Var.d(i26);
                                if (d5 instanceof z) {
                                    int i27 = ((z) d5).i();
                                    u010 = b0.u0(i27) + i27 + u010;
                                } else {
                                    u010 = b0.t0((String) d5) + u010;
                                }
                            }
                        } else {
                            for (int i28 = 0; i28 < size3; i28++) {
                                Object obj2 = list4.get(i28);
                                if (obj2 instanceof z) {
                                    int i29 = ((z) obj2).i();
                                    u010 = b0.u0(i29) + i29 + u010;
                                } else {
                                    u010 = b0.t0((String) obj2) + u010;
                                }
                            }
                        }
                        i12 += u010;
                        i7 = i19;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    u010 = 0;
                    i12 += u010;
                    i7 = i19;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 27:
                    List list5 = (List) unsafe.getObject(obj, j5);
                    t1 A = A(i11);
                    Class cls6 = u1.f1962a;
                    int size4 = list5.size();
                    if (size4 != 0) {
                        int u011 = b0.u0(i16 << 3) * size4;
                        for (int i30 = 0; i30 < size4; i30++) {
                            u011 += b0.s0((j1) list5.get(i30), A);
                        }
                        i9 = u011;
                        i12 += i9;
                        i7 = i19;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i9 = 0;
                    i12 += i9;
                    i7 = i19;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 28:
                    List list6 = (List) unsafe.getObject(obj, j5);
                    Class cls7 = u1.f1962a;
                    int size5 = list6.size();
                    if (size5 != 0) {
                        u010 = b0.u0(i16 << 3) * size5;
                        for (int i31 = 0; i31 < list6.size(); i31++) {
                            int i32 = ((z) list6.get(i31)).i();
                            u010 += b0.u0(i32) + i32;
                        }
                        i12 += u010;
                        i7 = i19;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    u010 = 0;
                    i12 += u010;
                    i7 = i19;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 29:
                    List list7 = (List) unsafe.getObject(obj, j5);
                    Class cls8 = u1.f1962a;
                    size = list7.size();
                    if (size != 0) {
                        s5 = u1.r(list7);
                        u09 = b0.u0(i16 << 3);
                        u010 = (u09 * size) + s5;
                        i12 += u010;
                        i7 = i19;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    u010 = 0;
                    i12 += u010;
                    i7 = i19;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 30:
                    List list8 = (List) unsafe.getObject(obj, j5);
                    Class cls9 = u1.f1962a;
                    size = list8.size();
                    if (size != 0) {
                        s5 = u1.h(list8);
                        u09 = b0.u0(i16 << 3);
                        u010 = (u09 * size) + s5;
                        i12 += u010;
                        i7 = i19;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    u010 = 0;
                    i12 += u010;
                    i7 = i19;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 31:
                    o = u1.i(i16, (List) unsafe.getObject(obj, j5));
                    i6 = i12;
                    i7 = i19;
                    i12 = i6 + o;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 32:
                    o = u1.k(i16, (List) unsafe.getObject(obj, j5));
                    i6 = i12;
                    i7 = i19;
                    i12 = i6 + o;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 33:
                    List list9 = (List) unsafe.getObject(obj, j5);
                    Class cls10 = u1.f1962a;
                    size = list9.size();
                    if (size != 0) {
                        s5 = u1.p(list9);
                        u09 = b0.u0(i16 << 3);
                        u010 = (u09 * size) + s5;
                        i12 += u010;
                        i7 = i19;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    u010 = 0;
                    i12 += u010;
                    i7 = i19;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 34:
                    List list10 = (List) unsafe.getObject(obj, j5);
                    Class cls11 = u1.f1962a;
                    size = list10.size();
                    if (size != 0) {
                        s5 = u1.q(list10);
                        u09 = b0.u0(i16 << 3);
                        u010 = (u09 * size) + s5;
                        i12 += u010;
                        i7 = i19;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    u010 = 0;
                    i12 += u010;
                    i7 = i19;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 35:
                    u06 = u1.l((List) unsafe.getObject(obj, j5));
                    if (u06 > 0) {
                        i8 = b0.u0(i16 << 3);
                        u07 = b0.u0(u06);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 36:
                    u06 = u1.j((List) unsafe.getObject(obj, j5));
                    if (u06 > 0) {
                        i8 = b0.u0(i16 << 3);
                        u07 = b0.u0(u06);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 37:
                    u06 = u1.n((List) unsafe.getObject(obj, j5));
                    if (u06 > 0) {
                        i8 = b0.u0(i16 << 3);
                        u07 = b0.u0(u06);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 38:
                    u06 = u1.s((List) unsafe.getObject(obj, j5));
                    if (u06 > 0) {
                        i8 = b0.u0(i16 << 3);
                        u07 = b0.u0(u06);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 39:
                    u06 = u1.m((List) unsafe.getObject(obj, j5));
                    if (u06 > 0) {
                        i8 = b0.u0(i16 << 3);
                        u07 = b0.u0(u06);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 40:
                    u06 = u1.l((List) unsafe.getObject(obj, j5));
                    if (u06 > 0) {
                        i8 = b0.u0(i16 << 3);
                        u07 = b0.u0(u06);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 41:
                    u06 = u1.j((List) unsafe.getObject(obj, j5));
                    if (u06 > 0) {
                        i8 = b0.u0(i16 << 3);
                        u07 = b0.u0(u06);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 42:
                    Class cls12 = u1.f1962a;
                    u06 = ((List) unsafe.getObject(obj, j5)).size();
                    if (u06 > 0) {
                        i8 = b0.u0(i16 << 3);
                        u07 = b0.u0(u06);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 43:
                    u06 = u1.r((List) unsafe.getObject(obj, j5));
                    if (u06 > 0) {
                        i8 = b0.u0(i16 << 3);
                        u07 = b0.u0(u06);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 44:
                    u06 = u1.h((List) unsafe.getObject(obj, j5));
                    if (u06 > 0) {
                        i8 = b0.u0(i16 << 3);
                        u07 = b0.u0(u06);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 45:
                    u06 = u1.j((List) unsafe.getObject(obj, j5));
                    if (u06 > 0) {
                        i8 = b0.u0(i16 << 3);
                        u07 = b0.u0(u06);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 46:
                    u06 = u1.l((List) unsafe.getObject(obj, j5));
                    if (u06 > 0) {
                        i8 = b0.u0(i16 << 3);
                        u07 = b0.u0(u06);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 47:
                    u06 = u1.p((List) unsafe.getObject(obj, j5));
                    if (u06 > 0) {
                        i8 = b0.u0(i16 << 3);
                        u07 = b0.u0(u06);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 48:
                    u06 = u1.q((List) unsafe.getObject(obj, j5));
                    if (u06 > 0) {
                        i8 = b0.u0(i16 << 3);
                        u07 = b0.u0(u06);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 49:
                    List list11 = (List) unsafe.getObject(obj, j5);
                    t1 A2 = A(i11);
                    Class cls13 = u1.f1962a;
                    int size6 = list11.size();
                    if (size6 != 0) {
                        int i33 = 0;
                        for (int i34 = 0; i34 < size6; i34++) {
                            i33 += b0.r0(i16, (j1) list11.get(i34), A2);
                        }
                        i9 = i33;
                        i12 += i9;
                        i7 = i19;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i9 = 0;
                    i12 += i9;
                    i7 = i19;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 50:
                    int i35 = i11 / 3;
                    e1 e1Var = (e1) unsafe.getObject(obj, j5);
                    androidx.appcompat.widget.b0.n(this.f1912b[i35 + i35]);
                    if (!e1Var.isEmpty()) {
                        Iterator it = e1Var.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 51:
                    if (t(i16, i11, obj)) {
                        u02 = b0.u0(i16 << 3);
                        i6 = i12;
                        i7 = i19;
                        o = u02 + 8;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 52:
                    if (t(i16, i11, obj)) {
                        u03 = b0.u0(i16 << 3);
                        i6 = i12;
                        i7 = i19;
                        o = u03 + 4;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 53:
                    if (t(i16, i11, obj)) {
                        long z4 = z(j5, obj);
                        u04 = b0.u0(i16 << 3);
                        v02 = b0.v0(z4);
                        i6 = i12;
                        i7 = i19;
                        i12 = v02 + u04 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 54:
                    if (t(i16, i11, obj)) {
                        long z5 = z(j5, obj);
                        u04 = b0.u0(i16 << 3);
                        v02 = b0.v0(z5);
                        i6 = i12;
                        i7 = i19;
                        i12 = v02 + u04 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 55:
                    if (t(i16, i11, obj)) {
                        u04 = b0.u0(i16 << 3);
                        v02 = b0.v0(w(j5, obj));
                        i6 = i12;
                        i7 = i19;
                        i12 = v02 + u04 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 56:
                    if (t(i16, i11, obj)) {
                        u02 = b0.u0(i16 << 3);
                        i6 = i12;
                        i7 = i19;
                        o = u02 + 8;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 57:
                    if (t(i16, i11, obj)) {
                        u03 = b0.u0(i16 << 3);
                        i6 = i12;
                        i7 = i19;
                        o = u03 + 4;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 58:
                    if (t(i16, i11, obj)) {
                        u05 = b0.u0(i16 << 3);
                        i6 = i12;
                        i7 = i19;
                        o = u05 + 1;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 59:
                    if (t(i16, i11, obj)) {
                        int i36 = i16 << 3;
                        Object object2 = unsafe.getObject(obj, j5);
                        if (object2 instanceof z) {
                            u06 = b0.u0(i36);
                            i8 = ((z) object2).i();
                            u07 = b0.u0(i8);
                            i6 = i12;
                            i7 = i19;
                            i12 = u07 + i8 + u06 + i6;
                            i11 += 3;
                            i10 = 1048575;
                            i13 = i20;
                            i14 = i7;
                        } else {
                            u04 = b0.u0(i36);
                            v02 = b0.t0((String) object2);
                            i6 = i12;
                            i7 = i19;
                            i12 = v02 + u04 + i6;
                            i11 += 3;
                            i10 = 1048575;
                            i13 = i20;
                            i14 = i7;
                        }
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 60:
                    if (t(i16, i11, obj)) {
                        o = u1.o(i16, A(i11), unsafe.getObject(obj, j5));
                        i6 = i12;
                        i7 = i19;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 61:
                    if (t(i16, i11, obj)) {
                        u06 = b0.u0(i16 << 3);
                        i8 = ((z) unsafe.getObject(obj, j5)).i();
                        u07 = b0.u0(i8);
                        i6 = i12;
                        i7 = i19;
                        i12 = u07 + i8 + u06 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 62:
                    if (t(i16, i11, obj)) {
                        int w5 = w(j5, obj);
                        u04 = b0.u0(i16 << 3);
                        v02 = b0.u0(w5);
                        i6 = i12;
                        i7 = i19;
                        i12 = v02 + u04 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 63:
                    if (t(i16, i11, obj)) {
                        u04 = b0.u0(i16 << 3);
                        v02 = b0.v0(w(j5, obj));
                        i6 = i12;
                        i7 = i19;
                        i12 = v02 + u04 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 64:
                    if (t(i16, i11, obj)) {
                        u03 = b0.u0(i16 << 3);
                        i6 = i12;
                        i7 = i19;
                        o = u03 + 4;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 65:
                    if (t(i16, i11, obj)) {
                        u02 = b0.u0(i16 << 3);
                        i6 = i12;
                        i7 = i19;
                        o = u02 + 8;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 66:
                    if (t(i16, i11, obj)) {
                        int w6 = w(j5, obj);
                        u04 = b0.u0(i16 << 3);
                        v02 = b0.u0((w6 >> 31) ^ (w6 + w6));
                        i6 = i12;
                        i7 = i19;
                        i12 = v02 + u04 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 67:
                    if (t(i16, i11, obj)) {
                        long z6 = z(j5, obj);
                        u04 = b0.u0(i16 << 3);
                        v02 = b0.v0((z6 >> 63) ^ (z6 + z6));
                        i6 = i12;
                        i7 = i19;
                        i12 = v02 + u04 + i6;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                case 68:
                    if (t(i16, i11, obj)) {
                        o = b0.r0(i16, (j1) unsafe.getObject(obj, j5), A(i11));
                        i6 = i12;
                        i7 = i19;
                        i12 = i6 + o;
                        i11 += 3;
                        i10 = 1048575;
                        i13 = i20;
                        i14 = i7;
                    }
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
                default:
                    i6 = i12;
                    i7 = i19;
                    i12 = i6;
                    i11 += 3;
                    i10 = 1048575;
                    i13 = i20;
                    i14 = i7;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final void f(Object obj, Object obj2) {
        if (!s(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
        obj2.getClass();
        int i5 = 0;
        while (true) {
            int[] iArr = this.f1911a;
            if (i5 >= iArr.length) {
                u1.u(this.f1920j, obj, obj2);
                return;
            }
            int y5 = y(i5);
            int i6 = 1048575 & y5;
            int i7 = (y5 >>> 20) & 255;
            int i8 = iArr[i5];
            long j5 = i6;
            switch (i7) {
                case 0:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.n(obj, j5, f2.e(j5, obj2));
                        l(i5, obj);
                        break;
                    }
                case 1:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.o(obj, j5, f2.f(j5, obj2));
                        l(i5, obj);
                        break;
                    }
                case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.q(obj, j5, f2.h(j5, obj2));
                        l(i5, obj);
                        break;
                    }
                case 3:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.q(obj, j5, f2.h(j5, obj2));
                        l(i5, obj);
                        break;
                    }
                case 4:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.p(f2.g(j5, obj2), j5, obj);
                        l(i5, obj);
                        break;
                    }
                case 5:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.q(obj, j5, f2.h(j5, obj2));
                        l(i5, obj);
                        break;
                    }
                case 6:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.p(f2.g(j5, obj2), j5, obj);
                        l(i5, obj);
                        break;
                    }
                case 7:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.m(obj, j5, f2.v(j5, obj2));
                        l(i5, obj);
                        break;
                    }
                case 8:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.r(j5, obj, f2.j(j5, obj2));
                        l(i5, obj);
                        break;
                    }
                case 9:
                    j(obj, i5, obj2);
                    break;
                case 10:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.r(j5, obj, f2.j(j5, obj2));
                        l(i5, obj);
                        break;
                    }
                case 11:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.p(f2.g(j5, obj2), j5, obj);
                        l(i5, obj);
                        break;
                    }
                case 12:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.p(f2.g(j5, obj2), j5, obj);
                        l(i5, obj);
                        break;
                    }
                case 13:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.p(f2.g(j5, obj2), j5, obj);
                        l(i5, obj);
                        break;
                    }
                case 14:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.q(obj, j5, f2.h(j5, obj2));
                        l(i5, obj);
                        break;
                    }
                case 15:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.p(f2.g(j5, obj2), j5, obj);
                        l(i5, obj);
                        break;
                    }
                case 16:
                    if (!q(i5, obj2)) {
                        break;
                    } else {
                        f2.q(obj, j5, f2.h(j5, obj2));
                        l(i5, obj);
                        break;
                    }
                case 17:
                    j(obj, i5, obj2);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.f1919i.b(j5, obj, obj2);
                    break;
                case 50:
                    Class cls = u1.f1962a;
                    f2.r(j5, obj, f1.a(f2.j(j5, obj), f2.j(j5, obj2)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!t(i8, i5, obj2)) {
                        break;
                    } else {
                        f2.r(j5, obj, f2.j(j5, obj2));
                        m(i8, i5, obj);
                        break;
                    }
                case 60:
                    k(obj, i5, obj2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!t(i8, i5, obj2)) {
                        break;
                    } else {
                        f2.r(j5, obj, f2.j(j5, obj2));
                        m(i8, i5, obj);
                        break;
                    }
                case 68:
                    k(obj, i5, obj2);
                    break;
            }
            i5 += 3;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final boolean g(Object obj, Object obj2) {
        boolean g5;
        int i5 = 0;
        while (true) {
            int[] iArr = this.f1911a;
            if (i5 >= iArr.length) {
                this.f1920j.getClass();
                return ((l0) obj).zzc.equals(((l0) obj2).zzc);
            }
            int y5 = y(i5);
            long j5 = y5 & 1048575;
            switch ((y5 >>> 20) & 255) {
                case 0:
                    if (p(obj, i5, obj2) && Double.doubleToLongBits(f2.e(j5, obj)) == Double.doubleToLongBits(f2.e(j5, obj2))) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 1:
                    if (p(obj, i5, obj2) && Float.floatToIntBits(f2.f(j5, obj)) == Float.floatToIntBits(f2.f(j5, obj2))) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                    if (p(obj, i5, obj2) && f2.h(j5, obj) == f2.h(j5, obj2)) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 3:
                    if (p(obj, i5, obj2) && f2.h(j5, obj) == f2.h(j5, obj2)) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 4:
                    if (p(obj, i5, obj2) && f2.g(j5, obj) == f2.g(j5, obj2)) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 5:
                    if (p(obj, i5, obj2) && f2.h(j5, obj) == f2.h(j5, obj2)) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 6:
                    if (p(obj, i5, obj2) && f2.g(j5, obj) == f2.g(j5, obj2)) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 7:
                    if (p(obj, i5, obj2) && f2.v(j5, obj) == f2.v(j5, obj2)) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 8:
                    if (p(obj, i5, obj2) && u1.g(f2.j(j5, obj), f2.j(j5, obj2))) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 9:
                    if (p(obj, i5, obj2) && u1.g(f2.j(j5, obj), f2.j(j5, obj2))) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 10:
                    if (p(obj, i5, obj2) && u1.g(f2.j(j5, obj), f2.j(j5, obj2))) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 11:
                    if (p(obj, i5, obj2) && f2.g(j5, obj) == f2.g(j5, obj2)) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 12:
                    if (p(obj, i5, obj2) && f2.g(j5, obj) == f2.g(j5, obj2)) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 13:
                    if (p(obj, i5, obj2) && f2.g(j5, obj) == f2.g(j5, obj2)) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 14:
                    if (p(obj, i5, obj2) && f2.h(j5, obj) == f2.h(j5, obj2)) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 15:
                    if (p(obj, i5, obj2) && f2.g(j5, obj) == f2.g(j5, obj2)) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 16:
                    if (p(obj, i5, obj2) && f2.h(j5, obj) == f2.h(j5, obj2)) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 17:
                    if (p(obj, i5, obj2) && u1.g(f2.j(j5, obj), f2.j(j5, obj2))) {
                        continue;
                        i5 += 3;
                    }
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    g5 = u1.g(f2.j(j5, obj), f2.j(j5, obj2));
                    break;
                case 50:
                    g5 = u1.g(f2.j(j5, obj), f2.j(j5, obj2));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long j6 = iArr[i5 + 2] & 1048575;
                    if (f2.g(j6, obj) == f2.g(j6, obj2) && u1.g(f2.j(j5, obj), f2.j(j5, obj2))) {
                        continue;
                        i5 += 3;
                    }
                    break;
                default:
                    i5 += 3;
            }
            if (g5) {
                i5 += 3;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final boolean h(Object obj) {
        int i5;
        int i6;
        int i7 = 0;
        int i8 = 0;
        int i9 = 1048575;
        while (i8 < this.f1917g) {
            int i10 = this.f1916f[i8];
            int[] iArr = this.f1911a;
            int i11 = iArr[i10];
            int y5 = y(i10);
            int i12 = iArr[i10 + 2];
            int i13 = i12 & 1048575;
            int i14 = 1 << (i12 >>> 20);
            if (i13 != i9) {
                if (i13 != 1048575) {
                    i7 = f1910l.getInt(obj, i13);
                }
                i6 = i7;
                i5 = i13;
            } else {
                i5 = i9;
                i6 = i7;
            }
            if ((268435456 & y5) != 0 && !r(obj, i10, i5, i6, i14)) {
                return false;
            }
            int i15 = (y5 >>> 20) & 255;
            if (i15 != 9 && i15 != 17) {
                if (i15 != 27) {
                    if (i15 == 60 || i15 == 68) {
                        if (t(i11, i10, obj) && !A(i10).h(f2.j(y5 & 1048575, obj))) {
                            return false;
                        }
                    } else if (i15 != 49) {
                        if (i15 == 50 && !((e1) f2.j(y5 & 1048575, obj)).isEmpty()) {
                            int i16 = i10 / 3;
                            androidx.appcompat.widget.b0.n(this.f1912b[i16 + i16]);
                            throw null;
                        }
                    }
                }
                List list = (List) f2.j(y5 & 1048575, obj);
                if (list.isEmpty()) {
                    continue;
                } else {
                    t1 A = A(i10);
                    for (int i17 = 0; i17 < list.size(); i17++) {
                        if (!A.h(list.get(i17))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (r(obj, i10, i5, i6, i14) && !A(i10).h(f2.j(y5 & 1048575, obj))) {
                return false;
            }
            i8++;
            i9 = i5;
            i7 = i6;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d7, code lost:
        if (r2 != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01e1, code lost:
        if (r2 != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01e4, code lost:
        r6 = 1237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01e5, code lost:
        r2 = r6;
     */
    @Override // com.google.android.gms.internal.play_billing.t1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 724
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.l1.i(java.lang.Object):int");
    }

    public final void j(Object obj, int i5, Object obj2) {
        if (q(i5, obj2)) {
            long y5 = y(i5) & 1048575;
            Unsafe unsafe = f1910l;
            Object object = unsafe.getObject(obj2, y5);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f1911a[i5] + " is present but null: " + obj2.toString());
            }
            t1 A = A(i5);
            if (!q(i5, obj)) {
                if (s(object)) {
                    l0 a5 = A.a();
                    A.f(a5, object);
                    unsafe.putObject(obj, y5, a5);
                } else {
                    unsafe.putObject(obj, y5, object);
                }
                l(i5, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, y5);
            if (!s(object2)) {
                l0 a6 = A.a();
                A.f(a6, object2);
                unsafe.putObject(obj, y5, a6);
                object2 = a6;
            }
            A.f(object2, object);
        }
    }

    public final void k(Object obj, int i5, Object obj2) {
        int[] iArr = this.f1911a;
        int i6 = iArr[i5];
        if (t(i6, i5, obj2)) {
            long y5 = y(i5) & 1048575;
            Unsafe unsafe = f1910l;
            Object object = unsafe.getObject(obj2, y5);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i5] + " is present but null: " + obj2.toString());
            }
            t1 A = A(i5);
            if (!t(i6, i5, obj)) {
                if (s(object)) {
                    l0 a5 = A.a();
                    A.f(a5, object);
                    unsafe.putObject(obj, y5, a5);
                } else {
                    unsafe.putObject(obj, y5, object);
                }
                m(i6, i5, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, y5);
            if (!s(object2)) {
                l0 a6 = A.a();
                A.f(a6, object2);
                unsafe.putObject(obj, y5, a6);
                object2 = a6;
            }
            A.f(object2, object);
        }
    }

    public final void l(int i5, Object obj) {
        int i6 = this.f1911a[i5 + 2];
        long j5 = 1048575 & i6;
        if (j5 == 1048575) {
            return;
        }
        f2.p((1 << (i6 >>> 20)) | f2.g(j5, obj), j5, obj);
    }

    public final void m(int i5, int i6, Object obj) {
        f2.p(i5, this.f1911a[i6 + 2] & 1048575, obj);
    }

    public final void n(Object obj, int i5, Object obj2) {
        f1910l.putObject(obj, y(i5) & 1048575, obj2);
        l(i5, obj);
    }

    public final void o(int i5, int i6, Object obj, Object obj2) {
        f1910l.putObject(obj, y(i6) & 1048575, obj2);
        m(i5, i6, obj);
    }

    public final boolean p(Object obj, int i5, Object obj2) {
        return q(i5, obj) == q(i5, obj2);
    }

    public final boolean q(int i5, Object obj) {
        int i6 = this.f1911a[i5 + 2];
        long j5 = i6 & 1048575;
        if (j5 != 1048575) {
            return ((1 << (i6 >>> 20)) & f2.g(j5, obj)) != 0;
        }
        int y5 = y(i5);
        long j6 = y5 & 1048575;
        switch ((y5 >>> 20) & 255) {
            case 0:
                return Double.doubleToRawLongBits(f2.e(j6, obj)) != 0;
            case 1:
                return Float.floatToRawIntBits(f2.f(j6, obj)) != 0;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                return f2.h(j6, obj) != 0;
            case 3:
                return f2.h(j6, obj) != 0;
            case 4:
                return f2.g(j6, obj) != 0;
            case 5:
                return f2.h(j6, obj) != 0;
            case 6:
                return f2.g(j6, obj) != 0;
            case 7:
                return f2.v(j6, obj);
            case 8:
                Object j7 = f2.j(j6, obj);
                if (j7 instanceof String) {
                    return !((String) j7).isEmpty();
                } else if (j7 instanceof z) {
                    return !z.f1994c.equals(j7);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return f2.j(j6, obj) != null;
            case 10:
                return !z.f1994c.equals(f2.j(j6, obj));
            case 11:
                return f2.g(j6, obj) != 0;
            case 12:
                return f2.g(j6, obj) != 0;
            case 13:
                return f2.g(j6, obj) != 0;
            case 14:
                return f2.h(j6, obj) != 0;
            case 15:
                return f2.g(j6, obj) != 0;
            case 16:
                return f2.h(j6, obj) != 0;
            case 17:
                return f2.j(j6, obj) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean r(Object obj, int i5, int i6, int i7, int i8) {
        return i6 == 1048575 ? q(i5, obj) : (i7 & i8) != 0;
    }

    public final boolean t(int i5, int i6, Object obj) {
        return f2.g((long) (this.f1911a[i6 + 2] & 1048575), obj) == i5;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:300:0x07dd  */
    /* JADX WARN: Removed duplicated region for block: B:700:0x080d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0241  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:262:0x06e4 -> B:263:0x06e5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:298:0x07da -> B:299:0x07db). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int u(java.lang.Object r41, byte[] r42, int r43, int r44, int r45, com.google.android.gms.internal.play_billing.v r46) {
        /*
            Method dump skipped, instructions count: 3932
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.l1.u(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.v):int");
    }

    public final int x(int i5, int i6) {
        int[] iArr = this.f1911a;
        int length = (iArr.length / 3) - 1;
        while (i6 <= length) {
            int i7 = (length + i6) >>> 1;
            int i8 = i7 * 3;
            int i9 = iArr[i8];
            if (i5 == i9) {
                return i8;
            }
            if (i5 < i9) {
                length = i7 - 1;
            } else {
                i6 = i7 + 1;
            }
        }
        return -1;
    }

    public final int y(int i5) {
        return this.f1911a[i5 + 1];
    }
}
