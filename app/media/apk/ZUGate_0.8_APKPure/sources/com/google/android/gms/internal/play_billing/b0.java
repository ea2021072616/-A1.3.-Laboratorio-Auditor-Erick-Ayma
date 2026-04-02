package com.google.android.gms.internal.play_billing;

import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class b0 extends p2.a {

    /* renamed from: y  reason: collision with root package name */
    public static final Logger f1840y = Logger.getLogger(b0.class.getName());

    /* renamed from: z  reason: collision with root package name */
    public static final boolean f1841z = f2.f1864e;

    /* renamed from: u  reason: collision with root package name */
    public d0 f1842u;

    /* renamed from: v  reason: collision with root package name */
    public final byte[] f1843v;

    /* renamed from: w  reason: collision with root package name */
    public final int f1844w;

    /* renamed from: x  reason: collision with root package name */
    public int f1845x;

    public b0(byte[] bArr, int i5) {
        int length = bArr.length;
        if (((length - i5) | i5) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i5)));
        }
        this.f1843v = bArr;
        this.f1845x = 0;
        this.f1844w = i5;
    }

    public static int r0(int i5, j1 j1Var, t1 t1Var) {
        int u02 = u0(i5 << 3);
        return ((r) j1Var).a(t1Var) + u02 + u02;
    }

    public static int s0(j1 j1Var, t1 t1Var) {
        int a5 = ((r) j1Var).a(t1Var);
        return u0(a5) + a5;
    }

    public static int t0(String str) {
        int length;
        try {
            length = h2.c(str);
        } catch (g2 unused) {
            length = str.getBytes(s0.f1953a).length;
        }
        return u0(length) + length;
    }

    public static int u0(int i5) {
        return (352 - (Integer.numberOfLeadingZeros(i5) * 9)) >>> 6;
    }

    public static int v0(long j5) {
        return (640 - (Long.numberOfLeadingZeros(j5) * 9)) >>> 6;
    }

    public final void c0(byte b5) {
        try {
            byte[] bArr = this.f1843v;
            int i5 = this.f1845x;
            this.f1845x = i5 + 1;
            bArr[i5] = b5;
        } catch (IndexOutOfBoundsException e5) {
            throw new c0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1845x), Integer.valueOf(this.f1844w), 1), e5);
        }
    }

    public final void d0(byte[] bArr, int i5) {
        try {
            System.arraycopy(bArr, 0, this.f1843v, this.f1845x, i5);
            this.f1845x += i5;
        } catch (IndexOutOfBoundsException e5) {
            throw new c0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1845x), Integer.valueOf(this.f1844w), Integer.valueOf(i5)), e5);
        }
    }

    public final void e0(int i5, z zVar) {
        o0((i5 << 3) | 2);
        o0(zVar.i());
        a0 a0Var = (a0) zVar;
        d0(a0Var.f1833d, a0Var.i());
    }

    public final void f0(int i5, int i6) {
        o0((i5 << 3) | 5);
        g0(i6);
    }

    public final void g0(int i5) {
        try {
            byte[] bArr = this.f1843v;
            int i6 = this.f1845x;
            int i7 = i6 + 1;
            bArr[i6] = (byte) (i5 & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((i5 >> 8) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) ((i5 >> 16) & 255);
            this.f1845x = i9 + 1;
            bArr[i9] = (byte) ((i5 >> 24) & 255);
        } catch (IndexOutOfBoundsException e5) {
            throw new c0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1845x), Integer.valueOf(this.f1844w), 1), e5);
        }
    }

    public final void h0(long j5, int i5) {
        o0((i5 << 3) | 1);
        i0(j5);
    }

    public final void i0(long j5) {
        try {
            byte[] bArr = this.f1843v;
            int i5 = this.f1845x;
            int i6 = i5 + 1;
            bArr[i5] = (byte) (((int) j5) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) (((int) (j5 >> 8)) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) (((int) (j5 >> 16)) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) (((int) (j5 >> 24)) & 255);
            int i10 = i9 + 1;
            bArr[i9] = (byte) (((int) (j5 >> 32)) & 255);
            int i11 = i10 + 1;
            bArr[i10] = (byte) (((int) (j5 >> 40)) & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) (((int) (j5 >> 48)) & 255);
            this.f1845x = i12 + 1;
            bArr[i12] = (byte) (((int) (j5 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e5) {
            throw new c0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1845x), Integer.valueOf(this.f1844w), 1), e5);
        }
    }

    public final void j0(int i5, int i6) {
        o0(i5 << 3);
        k0(i6);
    }

    public final void k0(int i5) {
        if (i5 >= 0) {
            o0(i5);
        } else {
            q0(i5);
        }
    }

    public final void l0(int i5, String str) {
        o0((i5 << 3) | 2);
        int i6 = this.f1845x;
        try {
            int u02 = u0(str.length() * 3);
            int u03 = u0(str.length());
            int i7 = this.f1844w;
            byte[] bArr = this.f1843v;
            if (u03 == u02) {
                int i8 = i6 + u03;
                this.f1845x = i8;
                int b5 = h2.b(str, bArr, i8, i7 - i8);
                this.f1845x = i6;
                o0((b5 - i6) - u03);
                this.f1845x = b5;
            } else {
                o0(h2.c(str));
                int i9 = this.f1845x;
                this.f1845x = h2.b(str, bArr, i9, i7 - i9);
            }
        } catch (g2 e5) {
            this.f1845x = i6;
            f1840y.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e5);
            byte[] bytes = str.getBytes(s0.f1953a);
            try {
                int length = bytes.length;
                o0(length);
                d0(bytes, length);
            } catch (IndexOutOfBoundsException e6) {
                throw new c0(e6);
            }
        } catch (IndexOutOfBoundsException e7) {
            throw new c0(e7);
        }
    }

    public final void m0(int i5, int i6) {
        o0((i5 << 3) | i6);
    }

    public final void n0(int i5, int i6) {
        o0(i5 << 3);
        o0(i6);
    }

    public final void o0(int i5) {
        while (true) {
            int i6 = i5 & (-128);
            byte[] bArr = this.f1843v;
            if (i6 == 0) {
                int i7 = this.f1845x;
                this.f1845x = i7 + 1;
                bArr[i7] = (byte) i5;
                return;
            }
            try {
                int i8 = this.f1845x;
                this.f1845x = i8 + 1;
                bArr[i8] = (byte) ((i5 | 128) & 255);
                i5 >>>= 7;
            } catch (IndexOutOfBoundsException e5) {
                throw new c0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1845x), Integer.valueOf(this.f1844w), 1), e5);
            }
            throw new c0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1845x), Integer.valueOf(this.f1844w), 1), e5);
        }
    }

    public final void p0(long j5, int i5) {
        o0(i5 << 3);
        q0(j5);
    }

    public final void q0(long j5) {
        boolean z4 = f1841z;
        int i5 = this.f1844w;
        byte[] bArr = this.f1843v;
        if (!z4 || i5 - this.f1845x < 10) {
            while ((j5 & (-128)) != 0) {
                try {
                    int i6 = this.f1845x;
                    this.f1845x = i6 + 1;
                    bArr[i6] = (byte) ((((int) j5) | 128) & 255);
                    j5 >>>= 7;
                } catch (IndexOutOfBoundsException e5) {
                    throw new c0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1845x), Integer.valueOf(i5), 1), e5);
                }
            }
            int i7 = this.f1845x;
            this.f1845x = i7 + 1;
            bArr[i7] = (byte) j5;
            return;
        }
        while (true) {
            int i8 = (int) j5;
            if ((j5 & (-128)) == 0) {
                int i9 = this.f1845x;
                this.f1845x = i9 + 1;
                long j6 = f2.f1865f + i9;
                f2.f1862c.d(bArr, j6, (byte) i8);
                return;
            }
            int i10 = this.f1845x;
            this.f1845x = i10 + 1;
            long j7 = f2.f1865f + i10;
            f2.f1862c.d(bArr, j7, (byte) ((i8 | 128) & 255));
            j5 >>>= 7;
        }
    }
}
