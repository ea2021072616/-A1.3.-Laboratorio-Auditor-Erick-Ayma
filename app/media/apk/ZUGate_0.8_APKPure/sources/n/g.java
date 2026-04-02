package n;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class g extends c {

    /* renamed from: f  reason: collision with root package name */
    public i[] f4029f;

    /* renamed from: g  reason: collision with root package name */
    public i[] f4030g;

    /* renamed from: h  reason: collision with root package name */
    public int f4031h;

    /* renamed from: i  reason: collision with root package name */
    public final d.e f4032i;

    public g(g.f fVar) {
        super(fVar);
        this.f4029f = new i[128];
        this.f4030g = new i[128];
        this.f4031h = 0;
        this.f4032i = new d.e(this, this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
        if (r9 < r8) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        r5 = false;
     */
    @Override // n.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final n.i d(boolean[] r12) {
        /*
            r11 = this;
            r0 = -1
            r1 = 0
            r3 = r0
            r2 = r1
        L4:
            int r4 = r11.f4031h
            if (r2 >= r4) goto L5b
            n.i[] r4 = r11.f4029f
            r5 = r4[r2]
            int r6 = r5.f4034c
            boolean r6 = r12[r6]
            if (r6 == 0) goto L13
            goto L58
        L13:
            d.e r6 = r11.f4032i
            r6.f2321h = r5
            r5 = 1
            r7 = 8
            if (r3 != r0) goto L38
        L1c:
            if (r7 < 0) goto L34
            java.lang.Object r4 = r6.f2321h
            n.i r4 = (n.i) r4
            float[] r4 = r4.f4040i
            r4 = r4[r7]
            r8 = 0
            int r9 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r9 <= 0) goto L2c
            goto L34
        L2c:
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 >= 0) goto L31
            goto L35
        L31:
            int r7 = r7 + (-1)
            goto L1c
        L34:
            r5 = r1
        L35:
            if (r5 == 0) goto L58
            goto L57
        L38:
            r4 = r4[r3]
        L3a:
            if (r7 < 0) goto L54
            float[] r8 = r4.f4040i
            r8 = r8[r7]
            java.lang.Object r9 = r6.f2321h
            n.i r9 = (n.i) r9
            float[] r9 = r9.f4040i
            r9 = r9[r7]
            int r10 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r10 != 0) goto L4f
            int r7 = r7 + (-1)
            goto L3a
        L4f:
            int r4 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r4 >= 0) goto L54
            goto L55
        L54:
            r5 = r1
        L55:
            if (r5 == 0) goto L58
        L57:
            r3 = r2
        L58:
            int r2 = r2 + 1
            goto L4
        L5b:
            if (r3 != r0) goto L5f
            r12 = 0
            return r12
        L5f:
            n.i[] r12 = r11.f4029f
            r12 = r12[r3]
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: n.g.d(boolean[]):n.i");
    }

    @Override // n.c
    public final boolean e() {
        return this.f4031h == 0;
    }

    @Override // n.c
    public final void i(d dVar, c cVar, boolean z4) {
        boolean z5;
        i iVar = cVar.f4003a;
        if (iVar == null) {
            return;
        }
        b bVar = cVar.f4006d;
        int k5 = bVar.k();
        for (int i5 = 0; i5 < k5; i5++) {
            i f5 = bVar.f(i5);
            float a5 = bVar.a(i5);
            d.e eVar = this.f4032i;
            eVar.f2321h = f5;
            boolean z6 = f5.f4033b;
            float[] fArr = iVar.f4040i;
            if (z6) {
                boolean z7 = true;
                for (int i6 = 0; i6 < 9; i6++) {
                    float[] fArr2 = ((i) eVar.f2321h).f4040i;
                    float f6 = (fArr[i6] * a5) + fArr2[i6];
                    fArr2[i6] = f6;
                    if (Math.abs(f6) < 1.0E-4f) {
                        ((i) eVar.f2321h).f4040i[i6] = 0.0f;
                    } else {
                        z7 = false;
                    }
                }
                if (z7) {
                    ((g) eVar.f2323j).k((i) eVar.f2321h);
                }
                z5 = false;
            } else {
                for (int i7 = 0; i7 < 9; i7++) {
                    float f7 = fArr[i7];
                    if (f7 != 0.0f) {
                        float f8 = f7 * a5;
                        if (Math.abs(f8) < 1.0E-4f) {
                            f8 = 0.0f;
                        }
                        ((i) eVar.f2321h).f4040i[i7] = f8;
                    } else {
                        ((i) eVar.f2321h).f4040i[i7] = 0.0f;
                    }
                }
                z5 = true;
            }
            if (z5) {
                j(f5);
            }
            this.f4004b = (cVar.f4004b * a5) + this.f4004b;
        }
        k(iVar);
    }

    public final void j(i iVar) {
        int i5;
        int i6 = this.f4031h + 1;
        i[] iVarArr = this.f4029f;
        if (i6 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f4029f = iVarArr2;
            this.f4030g = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f4029f;
        int i7 = this.f4031h;
        iVarArr3[i7] = iVar;
        int i8 = i7 + 1;
        this.f4031h = i8;
        if (i8 > 1 && iVarArr3[i8 - 1].f4034c > iVar.f4034c) {
            int i9 = 0;
            while (true) {
                i5 = this.f4031h;
                if (i9 >= i5) {
                    break;
                }
                this.f4030g[i9] = this.f4029f[i9];
                i9++;
            }
            Arrays.sort(this.f4030g, 0, i5, new f(0, this));
            for (int i10 = 0; i10 < this.f4031h; i10++) {
                this.f4029f[i10] = this.f4030g[i10];
            }
        }
        iVar.f4033b = true;
        iVar.a(this);
    }

    public final void k(i iVar) {
        int i5 = 0;
        while (i5 < this.f4031h) {
            if (this.f4029f[i5] == iVar) {
                while (true) {
                    int i6 = this.f4031h;
                    if (i5 >= i6 - 1) {
                        this.f4031h = i6 - 1;
                        iVar.f4033b = false;
                        return;
                    }
                    i[] iVarArr = this.f4029f;
                    int i7 = i5 + 1;
                    iVarArr[i5] = iVarArr[i7];
                    i5 = i7;
                }
            } else {
                i5++;
            }
        }
    }

    @Override // n.c
    public final String toString() {
        String str = " goal -> (" + this.f4004b + ") : ";
        for (int i5 = 0; i5 < this.f4031h; i5++) {
            i iVar = this.f4029f[i5];
            d.e eVar = this.f4032i;
            eVar.f2321h = iVar;
            str = str + eVar + " ";
        }
        return str;
    }
}
