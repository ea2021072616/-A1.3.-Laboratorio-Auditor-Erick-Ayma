package n;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: p  reason: collision with root package name */
    public static boolean f4008p = false;

    /* renamed from: q  reason: collision with root package name */
    public static int f4009q = 1000;

    /* renamed from: c  reason: collision with root package name */
    public final g f4012c;

    /* renamed from: f  reason: collision with root package name */
    public c[] f4015f;

    /* renamed from: l  reason: collision with root package name */
    public final g.f f4021l;
    public c o;

    /* renamed from: a  reason: collision with root package name */
    public boolean f4010a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f4011b = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f4013d = 32;

    /* renamed from: e  reason: collision with root package name */
    public int f4014e = 32;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4016g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean[] f4017h = new boolean[32];

    /* renamed from: i  reason: collision with root package name */
    public int f4018i = 1;

    /* renamed from: j  reason: collision with root package name */
    public int f4019j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f4020k = 32;

    /* renamed from: m  reason: collision with root package name */
    public i[] f4022m = new i[f4009q];

    /* renamed from: n  reason: collision with root package name */
    public int f4023n = 0;

    public d() {
        this.f4015f = null;
        this.f4015f = new c[32];
        s();
        g.f fVar = new g.f(2);
        this.f4021l = fVar;
        this.f4012c = new g(fVar);
        this.o = new c(fVar);
    }

    public static int n(p.d dVar) {
        i iVar = dVar.f4157i;
        if (iVar != null) {
            return (int) (iVar.f4037f + 0.5f);
        }
        return 0;
    }

    public final i a(int i5) {
        i iVar = (i) ((e) this.f4021l.f2879c).a();
        if (iVar == null) {
            iVar = new i(i5);
            iVar.f4044m = i5;
        } else {
            iVar.c();
            iVar.f4044m = i5;
        }
        int i6 = this.f4023n;
        int i7 = f4009q;
        if (i6 >= i7) {
            int i8 = i7 * 2;
            f4009q = i8;
            this.f4022m = (i[]) Arrays.copyOf(this.f4022m, i8);
        }
        i[] iVarArr = this.f4022m;
        int i9 = this.f4023n;
        this.f4023n = i9 + 1;
        iVarArr[i9] = iVar;
        return iVar;
    }

    public final void b(i iVar, i iVar2, int i5, float f5, i iVar3, i iVar4, int i6, int i7) {
        c l5 = l();
        if (iVar2 == iVar3) {
            l5.f4006d.g(iVar, 1.0f);
            l5.f4006d.g(iVar4, 1.0f);
            l5.f4006d.g(iVar2, -2.0f);
        } else if (f5 == 0.5f) {
            l5.f4006d.g(iVar, 1.0f);
            l5.f4006d.g(iVar2, -1.0f);
            l5.f4006d.g(iVar3, -1.0f);
            l5.f4006d.g(iVar4, 1.0f);
            if (i5 > 0 || i6 > 0) {
                l5.f4004b = (-i5) + i6;
            }
        } else if (f5 <= 0.0f) {
            l5.f4006d.g(iVar, -1.0f);
            l5.f4006d.g(iVar2, 1.0f);
            l5.f4004b = i5;
        } else if (f5 >= 1.0f) {
            l5.f4006d.g(iVar4, -1.0f);
            l5.f4006d.g(iVar3, 1.0f);
            l5.f4004b = -i6;
        } else {
            float f6 = 1.0f - f5;
            l5.f4006d.g(iVar, f6 * 1.0f);
            l5.f4006d.g(iVar2, f6 * (-1.0f));
            l5.f4006d.g(iVar3, (-1.0f) * f5);
            l5.f4006d.g(iVar4, 1.0f * f5);
            if (i5 > 0 || i6 > 0) {
                l5.f4004b = (i6 * f5) + ((-i5) * f6);
            }
        }
        if (i7 != 8) {
            l5.a(this, i7);
        }
        c(l5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b9, code lost:
        if (r4.f4043l <= 1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c2, code lost:
        if (r4.f4043l <= 1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c5, code lost:
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e0, code lost:
        if (r4.f4043l <= 1) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00e9, code lost:
        if (r4.f4043l <= 1) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00ec, code lost:
        r14 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(n.c r17) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.d.c(n.c):void");
    }

    public final void d(i iVar, int i5) {
        int i6 = iVar.f4035d;
        if (i6 == -1) {
            iVar.d(this, i5);
            for (int i7 = 0; i7 < this.f4011b + 1; i7++) {
                i iVar2 = ((i[]) this.f4021l.f2880d)[i7];
            }
        } else if (i6 == -1) {
            c l5 = l();
            l5.f4003a = iVar;
            float f5 = i5;
            iVar.f4037f = f5;
            l5.f4004b = f5;
            l5.f4007e = true;
            c(l5);
        } else {
            c cVar = this.f4015f[i6];
            if (cVar.f4007e) {
                cVar.f4004b = i5;
            } else if (cVar.f4006d.k() == 0) {
                cVar.f4007e = true;
                cVar.f4004b = i5;
            } else {
                c l6 = l();
                if (i5 < 0) {
                    l6.f4004b = i5 * (-1);
                    l6.f4006d.g(iVar, 1.0f);
                } else {
                    l6.f4004b = i5;
                    l6.f4006d.g(iVar, -1.0f);
                }
                c(l6);
            }
        }
    }

    public final void e(i iVar, i iVar2, int i5, int i6) {
        if (i6 == 8 && iVar2.f4038g && iVar.f4035d == -1) {
            iVar.d(this, iVar2.f4037f + i5);
            return;
        }
        c l5 = l();
        boolean z4 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z4 = true;
            }
            l5.f4004b = i5;
        }
        if (z4) {
            l5.f4006d.g(iVar, 1.0f);
            l5.f4006d.g(iVar2, -1.0f);
        } else {
            l5.f4006d.g(iVar, -1.0f);
            l5.f4006d.g(iVar2, 1.0f);
        }
        if (i6 != 8) {
            l5.a(this, i6);
        }
        c(l5);
    }

    public final void f(i iVar, i iVar2, int i5, int i6) {
        c l5 = l();
        i m5 = m();
        m5.f4036e = 0;
        l5.b(iVar, iVar2, m5, i5);
        if (i6 != 8) {
            l5.f4006d.g(j(i6), (int) (l5.f4006d.b(m5) * (-1.0f)));
        }
        c(l5);
    }

    public final void g(i iVar, i iVar2, int i5, int i6) {
        c l5 = l();
        i m5 = m();
        m5.f4036e = 0;
        l5.c(iVar, iVar2, m5, i5);
        if (i6 != 8) {
            l5.f4006d.g(j(i6), (int) (l5.f4006d.b(m5) * (-1.0f)));
        }
        c(l5);
    }

    public final void h(c cVar) {
        int i5;
        if (cVar.f4007e) {
            cVar.f4003a.d(this, cVar.f4004b);
        } else {
            c[] cVarArr = this.f4015f;
            int i6 = this.f4019j;
            cVarArr[i6] = cVar;
            i iVar = cVar.f4003a;
            iVar.f4035d = i6;
            this.f4019j = i6 + 1;
            iVar.e(this, cVar);
        }
        if (this.f4010a) {
            int i7 = 0;
            while (i7 < this.f4019j) {
                if (this.f4015f[i7] == null) {
                    System.out.println("WTF");
                }
                c cVar2 = this.f4015f[i7];
                if (cVar2 != null && cVar2.f4007e) {
                    cVar2.f4003a.d(this, cVar2.f4004b);
                    ((e) this.f4021l.f2878b).b(cVar2);
                    this.f4015f[i7] = null;
                    int i8 = i7 + 1;
                    int i9 = i8;
                    while (true) {
                        i5 = this.f4019j;
                        if (i8 >= i5) {
                            break;
                        }
                        c[] cVarArr2 = this.f4015f;
                        int i10 = i8 - 1;
                        c cVar3 = cVarArr2[i8];
                        cVarArr2[i10] = cVar3;
                        i iVar2 = cVar3.f4003a;
                        if (iVar2.f4035d == i8) {
                            iVar2.f4035d = i10;
                        }
                        i9 = i8;
                        i8++;
                    }
                    if (i9 < i5) {
                        this.f4015f[i9] = null;
                    }
                    this.f4019j = i5 - 1;
                    i7--;
                }
                i7++;
            }
            this.f4010a = false;
        }
    }

    public final void i() {
        for (int i5 = 0; i5 < this.f4019j; i5++) {
            c cVar = this.f4015f[i5];
            cVar.f4003a.f4037f = cVar.f4004b;
        }
    }

    public final i j(int i5) {
        if (this.f4018i + 1 >= this.f4014e) {
            o();
        }
        i a5 = a(4);
        int i6 = this.f4011b + 1;
        this.f4011b = i6;
        this.f4018i++;
        a5.f4034c = i6;
        a5.f4036e = i5;
        ((i[]) this.f4021l.f2880d)[i6] = a5;
        g gVar = this.f4012c;
        gVar.f4032i.f2321h = a5;
        float[] fArr = a5.f4040i;
        Arrays.fill(fArr, 0.0f);
        fArr[a5.f4036e] = 1.0f;
        gVar.j(a5);
        return a5;
    }

    public final i k(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f4018i + 1 >= this.f4014e) {
            o();
        }
        if (obj instanceof p.d) {
            p.d dVar = (p.d) obj;
            iVar = dVar.f4157i;
            if (iVar == null) {
                dVar.k();
                iVar = dVar.f4157i;
            }
            int i5 = iVar.f4034c;
            g.f fVar = this.f4021l;
            if (i5 == -1 || i5 > this.f4011b || ((i[]) fVar.f2880d)[i5] == null) {
                if (i5 != -1) {
                    iVar.c();
                }
                int i6 = this.f4011b + 1;
                this.f4011b = i6;
                this.f4018i++;
                iVar.f4034c = i6;
                iVar.f4044m = 1;
                ((i[]) fVar.f2880d)[i6] = iVar;
            }
        }
        return iVar;
    }

    public final c l() {
        g.f fVar = this.f4021l;
        c cVar = (c) ((e) fVar.f2878b).a();
        if (cVar == null) {
            return new c(fVar);
        }
        cVar.f4003a = null;
        cVar.f4006d.clear();
        cVar.f4004b = 0.0f;
        cVar.f4007e = false;
        return cVar;
    }

    public final i m() {
        if (this.f4018i + 1 >= this.f4014e) {
            o();
        }
        i a5 = a(3);
        int i5 = this.f4011b + 1;
        this.f4011b = i5;
        this.f4018i++;
        a5.f4034c = i5;
        ((i[]) this.f4021l.f2880d)[i5] = a5;
        return a5;
    }

    public final void o() {
        int i5 = this.f4013d * 2;
        this.f4013d = i5;
        this.f4015f = (c[]) Arrays.copyOf(this.f4015f, i5);
        g.f fVar = this.f4021l;
        fVar.f2880d = (i[]) Arrays.copyOf((i[]) fVar.f2880d, this.f4013d);
        int i6 = this.f4013d;
        this.f4017h = new boolean[i6];
        this.f4014e = i6;
        this.f4020k = i6;
    }

    public final void p() {
        g gVar = this.f4012c;
        if (gVar.e()) {
            i();
        } else if (!this.f4016g) {
            q(gVar);
        } else {
            boolean z4 = false;
            int i5 = 0;
            while (true) {
                if (i5 >= this.f4019j) {
                    z4 = true;
                    break;
                } else if (!this.f4015f[i5].f4007e) {
                    break;
                } else {
                    i5++;
                }
            }
            if (z4) {
                i();
            } else {
                q(gVar);
            }
        }
    }

    public final void q(g gVar) {
        float f5;
        int i5;
        boolean z4;
        int i6 = 0;
        while (true) {
            f5 = 0.0f;
            i5 = 1;
            if (i6 >= this.f4019j) {
                z4 = false;
                break;
            }
            c cVar = this.f4015f[i6];
            if (cVar.f4003a.f4044m != 1 && cVar.f4004b < 0.0f) {
                z4 = true;
                break;
            }
            i6++;
        }
        if (z4) {
            boolean z5 = false;
            int i7 = 0;
            while (!z5) {
                i7 += i5;
                float f6 = Float.MAX_VALUE;
                int i8 = -1;
                int i9 = -1;
                int i10 = 0;
                int i11 = 0;
                while (i10 < this.f4019j) {
                    c cVar2 = this.f4015f[i10];
                    if (cVar2.f4003a.f4044m != i5 && !cVar2.f4007e && cVar2.f4004b < f5) {
                        int k5 = cVar2.f4006d.k();
                        int i12 = 0;
                        while (i12 < k5) {
                            i f7 = cVar2.f4006d.f(i12);
                            float b5 = cVar2.f4006d.b(f7);
                            if (b5 > f5) {
                                for (int i13 = 0; i13 < 9; i13++) {
                                    float f8 = f7.f4039h[i13] / b5;
                                    if ((f8 < f6 && i13 == i11) || i13 > i11) {
                                        i9 = f7.f4034c;
                                        i11 = i13;
                                        f6 = f8;
                                        i8 = i10;
                                    }
                                }
                            }
                            i12++;
                            f5 = 0.0f;
                        }
                    }
                    i10++;
                    f5 = 0.0f;
                    i5 = 1;
                }
                if (i8 != -1) {
                    c cVar3 = this.f4015f[i8];
                    cVar3.f4003a.f4035d = -1;
                    cVar3.g(((i[]) this.f4021l.f2880d)[i9]);
                    i iVar = cVar3.f4003a;
                    iVar.f4035d = i8;
                    iVar.e(this, cVar3);
                } else {
                    z5 = true;
                }
                if (i7 > this.f4018i / 2) {
                    z5 = true;
                }
                f5 = 0.0f;
                i5 = 1;
            }
        }
        r(gVar);
        i();
    }

    public final void r(c cVar) {
        for (int i5 = 0; i5 < this.f4018i; i5++) {
            this.f4017h[i5] = false;
        }
        boolean z4 = false;
        int i6 = 0;
        while (!z4) {
            i6++;
            if (i6 >= this.f4018i * 2) {
                return;
            }
            i iVar = cVar.f4003a;
            if (iVar != null) {
                this.f4017h[iVar.f4034c] = true;
            }
            i d5 = cVar.d(this.f4017h);
            if (d5 != null) {
                boolean[] zArr = this.f4017h;
                int i7 = d5.f4034c;
                if (zArr[i7]) {
                    return;
                }
                zArr[i7] = true;
            }
            if (d5 != null) {
                float f5 = Float.MAX_VALUE;
                int i8 = -1;
                for (int i9 = 0; i9 < this.f4019j; i9++) {
                    c cVar2 = this.f4015f[i9];
                    if (cVar2.f4003a.f4044m != 1 && !cVar2.f4007e && cVar2.f4006d.e(d5)) {
                        float b5 = cVar2.f4006d.b(d5);
                        if (b5 < 0.0f) {
                            float f6 = (-cVar2.f4004b) / b5;
                            if (f6 < f5) {
                                i8 = i9;
                                f5 = f6;
                            }
                        }
                    }
                }
                if (i8 > -1) {
                    c cVar3 = this.f4015f[i8];
                    cVar3.f4003a.f4035d = -1;
                    cVar3.g(d5);
                    i iVar2 = cVar3.f4003a;
                    iVar2.f4035d = i8;
                    iVar2.e(this, cVar3);
                }
            } else {
                z4 = true;
            }
        }
    }

    public final void s() {
        for (int i5 = 0; i5 < this.f4019j; i5++) {
            c cVar = this.f4015f[i5];
            if (cVar != null) {
                ((e) this.f4021l.f2878b).b(cVar);
            }
            this.f4015f[i5] = null;
        }
    }

    public final void t() {
        g.f fVar;
        int i5 = 0;
        while (true) {
            fVar = this.f4021l;
            i[] iVarArr = (i[]) fVar.f2880d;
            if (i5 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i5];
            if (iVar != null) {
                iVar.c();
            }
            i5++;
        }
        e eVar = (e) fVar.f2879c;
        i[] iVarArr2 = this.f4022m;
        int i6 = this.f4023n;
        eVar.getClass();
        if (i6 > iVarArr2.length) {
            i6 = iVarArr2.length;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            i iVar2 = iVarArr2[i7];
            int i8 = eVar.f4026c;
            Object[] objArr = eVar.f4025b;
            if (i8 < objArr.length) {
                objArr[i8] = iVar2;
                eVar.f4026c = i8 + 1;
            }
        }
        this.f4023n = 0;
        Arrays.fill((i[]) fVar.f2880d, (Object) null);
        this.f4011b = 0;
        g gVar = this.f4012c;
        gVar.f4031h = 0;
        gVar.f4004b = 0.0f;
        this.f4018i = 1;
        for (int i9 = 0; i9 < this.f4019j; i9++) {
            c cVar = this.f4015f[i9];
        }
        s();
        this.f4019j = 0;
        this.o = new c(fVar);
    }
}
