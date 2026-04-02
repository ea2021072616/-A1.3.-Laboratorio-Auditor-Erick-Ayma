package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
import java.util.List;
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f1849a;

    public d0(b0 b0Var) {
        Charset charset = s0.f1953a;
        this.f1849a = b0Var;
        b0Var.f1842u = this;
    }

    public final void a(int i5, int i6) {
        this.f1849a.n0(i5, (i6 >> 31) ^ (i6 + i6));
    }

    public final void b(long j5, int i5) {
        this.f1849a.p0((j5 >> 63) ^ (j5 + j5), i5);
    }

    public final void c(int i5, List list) {
        boolean z4 = list instanceof x0;
        int i6 = 0;
        b0 b0Var = this.f1849a;
        if (!z4) {
            while (i6 < list.size()) {
                b0Var.l0(i5, (String) list.get(i6));
                i6++;
            }
            return;
        }
        x0 x0Var = (x0) list;
        while (i6 < list.size()) {
            Object d5 = x0Var.d(i6);
            if (d5 instanceof String) {
                b0Var.l0(i5, (String) d5);
            } else {
                b0Var.e0(i5, (z) d5);
            }
            i6++;
        }
    }

    public final void d(int i5, int i6) {
        this.f1849a.n0(i5, i6);
    }

    public final void e(long j5, int i5) {
        this.f1849a.p0(j5, i5);
    }

    public final void f(int i5, boolean z4) {
        b0 b0Var = this.f1849a;
        b0Var.o0(i5 << 3);
        b0Var.c0(z4 ? (byte) 1 : (byte) 0);
    }

    public final void g(int i5, z zVar) {
        this.f1849a.e0(i5, zVar);
    }

    public final void h(int i5, List list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.f1849a.e0(i5, (z) list.get(i6));
        }
    }

    public final void i(int i5, double d5) {
        this.f1849a.h0(Double.doubleToRawLongBits(d5), i5);
    }

    public final void j(int i5, int i6) {
        this.f1849a.j0(i5, i6);
    }

    public final void k(int i5, int i6) {
        this.f1849a.f0(i5, i6);
    }

    public final void l(long j5, int i5) {
        this.f1849a.h0(j5, i5);
    }

    public final void m(int i5, float f5) {
        this.f1849a.f0(i5, Float.floatToRawIntBits(f5));
    }

    public final void n(int i5, t1 t1Var, Object obj) {
        b0 b0Var = this.f1849a;
        b0Var.m0(i5, 3);
        t1Var.c((j1) obj, b0Var.f1842u);
        b0Var.m0(i5, 4);
    }

    public final void o(int i5, int i6) {
        this.f1849a.j0(i5, i6);
    }

    public final void p(long j5, int i5) {
        this.f1849a.p0(j5, i5);
    }

    public final void q(int i5, t1 t1Var, Object obj) {
        j1 j1Var = (j1) obj;
        b0 b0Var = this.f1849a;
        b0Var.o0((i5 << 3) | 2);
        b0Var.o0(((r) j1Var).a(t1Var));
        t1Var.c(j1Var, b0Var.f1842u);
    }

    public final void r(int i5, int i6) {
        this.f1849a.f0(i5, i6);
    }

    public final void s(long j5, int i5) {
        this.f1849a.h0(j5, i5);
    }
}
