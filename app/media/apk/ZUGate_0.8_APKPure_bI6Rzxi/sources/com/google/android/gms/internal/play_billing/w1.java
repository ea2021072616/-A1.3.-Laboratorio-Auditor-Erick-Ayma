package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class w1 {

    /* renamed from: f  reason: collision with root package name */
    public static final w1 f1985f = new w1(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f1986a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f1987b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f1988c;

    /* renamed from: d  reason: collision with root package name */
    public int f1989d = -1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1990e;

    public w1(int i5, int[] iArr, Object[] objArr, boolean z4) {
        this.f1986a = i5;
        this.f1987b = iArr;
        this.f1988c = objArr;
        this.f1990e = z4;
    }

    public static w1 b() {
        return new w1(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int u02;
        int v02;
        int u03;
        int i5 = this.f1989d;
        if (i5 == -1) {
            int i6 = 0;
            for (int i7 = 0; i7 < this.f1986a; i7++) {
                int i8 = this.f1987b[i7];
                int i9 = i8 >>> 3;
                int i10 = i8 & 7;
                if (i10 != 0) {
                    if (i10 == 1) {
                        ((Long) this.f1988c[i7]).longValue();
                        u03 = b0.u0(i9 << 3) + 8;
                    } else if (i10 == 2) {
                        int u04 = b0.u0(i9 << 3);
                        int i11 = ((z) this.f1988c[i7]).i();
                        i6 = b0.u0(i11) + i11 + u04 + i6;
                    } else if (i10 == 3) {
                        int u05 = b0.u0(i9 << 3);
                        u02 = u05 + u05;
                        v02 = ((w1) this.f1988c[i7]).a();
                    } else if (i10 != 5) {
                        int i12 = u0.f1961b;
                        throw new IllegalStateException(new t0());
                    } else {
                        ((Integer) this.f1988c[i7]).intValue();
                        u03 = b0.u0(i9 << 3) + 4;
                    }
                    i6 = u03 + i6;
                } else {
                    int i13 = i9 << 3;
                    long longValue = ((Long) this.f1988c[i7]).longValue();
                    u02 = b0.u0(i13);
                    v02 = b0.v0(longValue);
                }
                i6 = v02 + u02 + i6;
            }
            this.f1989d = i6;
            return i6;
        }
        return i5;
    }

    public final void c(int i5, Object obj) {
        if (!this.f1990e) {
            throw new UnsupportedOperationException();
        }
        e(this.f1986a + 1);
        int[] iArr = this.f1987b;
        int i6 = this.f1986a;
        iArr[i6] = i5;
        this.f1988c[i6] = obj;
        this.f1986a = i6 + 1;
    }

    public final void d(d0 d0Var) {
        if (this.f1986a != 0) {
            for (int i5 = 0; i5 < this.f1986a; i5++) {
                int i6 = this.f1987b[i5];
                Object obj = this.f1988c[i5];
                int i7 = i6 & 7;
                int i8 = i6 >>> 3;
                if (i7 == 0) {
                    d0Var.p(((Long) obj).longValue(), i8);
                } else if (i7 == 1) {
                    d0Var.l(((Long) obj).longValue(), i8);
                } else if (i7 == 2) {
                    d0Var.g(i8, (z) obj);
                } else if (i7 == 3) {
                    d0Var.f1849a.m0(i8, 3);
                    ((w1) obj).d(d0Var);
                    d0Var.f1849a.m0(i8, 4);
                } else if (i7 != 5) {
                    int i9 = u0.f1961b;
                    throw new RuntimeException(new t0());
                } else {
                    d0Var.k(i8, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final void e(int i5) {
        int[] iArr = this.f1987b;
        if (i5 > iArr.length) {
            int i6 = this.f1986a;
            int i7 = (i6 / 2) + i6;
            if (i7 >= i5) {
                i5 = i7;
            }
            if (i5 < 8) {
                i5 = 8;
            }
            this.f1987b = Arrays.copyOf(iArr, i5);
            this.f1988c = Arrays.copyOf(this.f1988c, i5);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof w1)) {
            w1 w1Var = (w1) obj;
            int i5 = this.f1986a;
            if (i5 == w1Var.f1986a) {
                int[] iArr = this.f1987b;
                int[] iArr2 = w1Var.f1987b;
                int i6 = 0;
                while (true) {
                    if (i6 >= i5) {
                        Object[] objArr = this.f1988c;
                        Object[] objArr2 = w1Var.f1988c;
                        int i7 = this.f1986a;
                        for (int i8 = 0; i8 < i7; i8++) {
                            if (objArr[i8].equals(objArr2[i8])) {
                            }
                        }
                        return true;
                    } else if (iArr[i6] != iArr2[i6]) {
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i5 = this.f1986a;
        int i6 = i5 + 527;
        int[] iArr = this.f1987b;
        int i7 = 17;
        int i8 = 17;
        for (int i9 = 0; i9 < i5; i9++) {
            i8 = (i8 * 31) + iArr[i9];
        }
        int i10 = ((i6 * 31) + i8) * 31;
        Object[] objArr = this.f1988c;
        int i11 = this.f1986a;
        for (int i12 = 0; i12 < i11; i12++) {
            i7 = (i7 * 31) + objArr[i12].hashCode();
        }
        return i10 + i7;
    }
}
