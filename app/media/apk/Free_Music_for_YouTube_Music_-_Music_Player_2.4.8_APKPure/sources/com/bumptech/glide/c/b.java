package com.bumptech.glide.c;

import android.support.v4.app.FrameMetricsAggregator;
import android.support.v4.internal.view.SupportMenu;
import com.flurry.android.Constants;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: LZWEncoder.java */
/* loaded from: classes.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    int f638a;

    /* renamed from: c  reason: collision with root package name */
    int f640c;
    int j;
    int k;
    int l;
    int p;
    private int r;
    private int s;
    private byte[] t;
    private int u;
    private int v;
    private int w;

    /* renamed from: b  reason: collision with root package name */
    int f639b = 12;
    int d = 4096;
    int[] e = new int[5003];
    int[] f = new int[5003];
    int g = 5003;
    int h = 0;
    boolean i = false;
    int m = 0;
    int n = 0;
    int[] o = {0, 1, 3, 7, 15, 31, 63, 127, 255, FrameMetricsAggregator.EVERY_DURATION, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] q = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.r = i;
        this.s = i2;
        this.t = bArr;
        this.u = Math.max(2, i3);
    }

    void a(byte b2, OutputStream outputStream) throws IOException {
        byte[] bArr = this.q;
        int i = this.p;
        this.p = i + 1;
        bArr[i] = b2;
        if (this.p >= 254) {
            c(outputStream);
        }
    }

    void a(OutputStream outputStream) throws IOException {
        a(this.g);
        this.h = this.k + 2;
        this.i = true;
        b(this.k, outputStream);
    }

    void a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.e[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.j = i;
        this.i = false;
        this.f638a = this.j;
        this.f640c = b(this.f638a);
        this.k = 1 << (i - 1);
        this.l = this.k + 1;
        this.h = this.k + 2;
        this.p = 0;
        int a2 = a();
        for (int i3 = this.g; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.g;
        a(i5);
        b(this.k, outputStream);
        while (true) {
            int a3 = a();
            if (a3 != -1) {
                int i6 = (a3 << this.f639b) + a2;
                int i7 = (a3 << i4) ^ a2;
                if (this.e[i7] == i6) {
                    a2 = this.f[i7];
                } else {
                    if (this.e[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.e[i7] == i6) {
                                a2 = this.f[i7];
                                break;
                            }
                        } while (this.e[i7] >= 0);
                    }
                    b(a2, outputStream);
                    if (this.h < this.d) {
                        int[] iArr = this.f;
                        int i9 = this.h;
                        this.h = i9 + 1;
                        iArr[i7] = i9;
                        this.e[i7] = i6;
                        a2 = a3;
                    } else {
                        a(outputStream);
                        a2 = a3;
                    }
                }
            } else {
                b(a2, outputStream);
                b(this.l, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(OutputStream outputStream) throws IOException {
        outputStream.write(this.u);
        this.v = this.r * this.s;
        this.w = 0;
        a(this.u + 1, outputStream);
        outputStream.write(0);
    }

    void c(OutputStream outputStream) throws IOException {
        if (this.p > 0) {
            outputStream.write(this.p);
            outputStream.write(this.q, 0, this.p);
            this.p = 0;
        }
    }

    final int b(int i) {
        return (1 << i) - 1;
    }

    private int a() {
        if (this.v == 0) {
            return -1;
        }
        this.v--;
        byte[] bArr = this.t;
        int i = this.w;
        this.w = i + 1;
        return bArr[i] & Constants.UNKNOWN;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.m &= this.o[this.n];
        if (this.n > 0) {
            this.m |= i << this.n;
        } else {
            this.m = i;
        }
        this.n += this.f638a;
        while (this.n >= 8) {
            a((byte) (this.m & 255), outputStream);
            this.m >>= 8;
            this.n -= 8;
        }
        if (this.h > this.f640c || this.i) {
            if (this.i) {
                int i2 = this.j;
                this.f638a = i2;
                this.f640c = b(i2);
                this.i = false;
            } else {
                this.f638a++;
                if (this.f638a == this.f639b) {
                    this.f640c = this.d;
                } else {
                    this.f640c = b(this.f638a);
                }
            }
        }
        if (i == this.l) {
            while (this.n > 0) {
                a((byte) (this.m & 255), outputStream);
                this.m >>= 8;
                this.n -= 8;
            }
            c(outputStream);
        }
    }
}
