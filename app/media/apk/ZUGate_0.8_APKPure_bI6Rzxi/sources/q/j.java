package q;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class j extends o {

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f4398k = new int[2];

    public j(p.e eVar) {
        super(eVar);
        this.f4424h.f4389e = 4;
        this.f4425i.f4389e = 5;
        this.f4422f = 0;
    }

    public static void m(int[] iArr, int i5, int i6, int i7, int i8, float f5, int i9) {
        int i10 = i6 - i5;
        int i11 = i8 - i7;
        if (i9 != -1) {
            if (i9 == 0) {
                iArr[0] = (int) ((i11 * f5) + 0.5f);
                iArr[1] = i11;
                return;
            } else if (i9 != 1) {
                return;
            } else {
                iArr[0] = i10;
                iArr[1] = (int) ((i10 * f5) + 0.5f);
                return;
            }
        }
        int i12 = (int) ((i11 * f5) + 0.5f);
        int i13 = (int) ((i10 / f5) + 0.5f);
        if (i12 <= i10) {
            iArr[0] = i12;
            iArr[1] = i11;
        } else if (i13 <= i11) {
            iArr[0] = i10;
            iArr[1] = i13;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0243, code lost:
        if (r3 != 1) goto L127;
     */
    @Override // q.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(q.d r24) {
        /*
            Method dump skipped, instructions count: 894
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.j.a(q.d):void");
    }

    @Override // q.o
    public final void d() {
        p.e eVar;
        p.e eVar2;
        int i5;
        p.e eVar3;
        p.e eVar4;
        int i6;
        p.e eVar5 = this.f4418b;
        boolean z4 = eVar5.f4158a;
        g gVar = this.f4421e;
        if (z4) {
            gVar.d(eVar5.r());
        }
        boolean z5 = gVar.f4394j;
        f fVar = this.f4425i;
        f fVar2 = this.f4424h;
        if (!z5) {
            p.e eVar6 = this.f4418b;
            int i7 = eVar6.f4188p0[0];
            this.f4420d = i7;
            if (i7 != 3) {
                if (i7 == 4 && (eVar4 = eVar6.T) != null && ((i6 = eVar4.f4188p0[0]) == 1 || i6 == 4)) {
                    int r5 = (eVar4.r() - this.f4418b.I.e()) - this.f4418b.K.e();
                    o.b(fVar2, eVar4.f4164d.f4424h, this.f4418b.I.e());
                    o.b(fVar, eVar4.f4164d.f4425i, -this.f4418b.K.e());
                    gVar.d(r5);
                    return;
                } else if (i7 == 1) {
                    gVar.d(eVar6.r());
                }
            }
        } else if (this.f4420d == 4 && (eVar2 = (eVar = this.f4418b).T) != null && ((i5 = eVar2.f4188p0[0]) == 1 || i5 == 4)) {
            o.b(fVar2, eVar2.f4164d.f4424h, eVar.I.e());
            o.b(fVar, eVar2.f4164d.f4425i, -this.f4418b.K.e());
            return;
        }
        if (gVar.f4394j) {
            p.e eVar7 = this.f4418b;
            if (eVar7.f4158a) {
                p.d[] dVarArr = eVar7.Q;
                p.d dVar = dVarArr[0];
                p.d dVar2 = dVar.f4154f;
                if (dVar2 != null && dVarArr[1].f4154f != null) {
                    if (eVar7.y()) {
                        fVar2.f4390f = this.f4418b.Q[0].e();
                        fVar.f4390f = -this.f4418b.Q[1].e();
                        return;
                    }
                    f h5 = o.h(this.f4418b.Q[0]);
                    if (h5 != null) {
                        o.b(fVar2, h5, this.f4418b.Q[0].e());
                    }
                    f h6 = o.h(this.f4418b.Q[1]);
                    if (h6 != null) {
                        o.b(fVar, h6, -this.f4418b.Q[1].e());
                    }
                    fVar2.f4386b = true;
                    fVar.f4386b = true;
                    return;
                } else if (dVar2 != null) {
                    f h7 = o.h(dVar);
                    if (h7 != null) {
                        o.b(fVar2, h7, this.f4418b.Q[0].e());
                        o.b(fVar, fVar2, gVar.f4391g);
                        return;
                    }
                    return;
                } else {
                    p.d dVar3 = dVarArr[1];
                    if (dVar3.f4154f != null) {
                        f h8 = o.h(dVar3);
                        if (h8 != null) {
                            o.b(fVar, h8, -this.f4418b.Q[1].e());
                            o.b(fVar2, fVar, -gVar.f4391g);
                            return;
                        }
                        return;
                    } else if ((eVar7 instanceof p.j) || eVar7.T == null || eVar7.j(p.c.CENTER).f4154f != null) {
                        return;
                    } else {
                        p.e eVar8 = this.f4418b;
                        o.b(fVar2, eVar8.T.f4164d.f4424h, eVar8.s());
                        o.b(fVar, fVar2, gVar.f4391g);
                        return;
                    }
                }
            }
        }
        if (this.f4420d == 3) {
            p.e eVar9 = this.f4418b;
            int i8 = eVar9.f4190r;
            ArrayList arrayList = gVar.f4395k;
            ArrayList arrayList2 = gVar.f4396l;
            if (i8 == 2) {
                p.e eVar10 = eVar9.T;
                if (eVar10 != null) {
                    g gVar2 = eVar10.f4166e.f4421e;
                    arrayList2.add(gVar2);
                    gVar2.f4395k.add(gVar);
                    gVar.f4386b = true;
                    arrayList.add(fVar2);
                    arrayList.add(fVar);
                }
            } else if (i8 == 3) {
                if (eVar9.f4191s == 3) {
                    fVar2.f4385a = this;
                    fVar.f4385a = this;
                    l lVar = eVar9.f4166e;
                    lVar.f4424h.f4385a = this;
                    lVar.f4425i.f4385a = this;
                    gVar.f4385a = this;
                    if (eVar9.z()) {
                        arrayList2.add(this.f4418b.f4166e.f4421e);
                        this.f4418b.f4166e.f4421e.f4395k.add(gVar);
                        l lVar2 = this.f4418b.f4166e;
                        lVar2.f4421e.f4385a = this;
                        arrayList2.add(lVar2.f4424h);
                        arrayList2.add(this.f4418b.f4166e.f4425i);
                        this.f4418b.f4166e.f4424h.f4395k.add(gVar);
                        this.f4418b.f4166e.f4425i.f4395k.add(gVar);
                    } else if (this.f4418b.y()) {
                        this.f4418b.f4166e.f4421e.f4396l.add(gVar);
                        arrayList.add(this.f4418b.f4166e.f4421e);
                    } else {
                        this.f4418b.f4166e.f4421e.f4396l.add(gVar);
                    }
                } else {
                    g gVar3 = eVar9.f4166e.f4421e;
                    arrayList2.add(gVar3);
                    gVar3.f4395k.add(gVar);
                    this.f4418b.f4166e.f4424h.f4395k.add(gVar);
                    this.f4418b.f4166e.f4425i.f4395k.add(gVar);
                    gVar.f4386b = true;
                    arrayList.add(fVar2);
                    arrayList.add(fVar);
                    fVar2.f4396l.add(gVar);
                    fVar.f4396l.add(gVar);
                }
            }
        }
        p.e eVar11 = this.f4418b;
        p.d[] dVarArr2 = eVar11.Q;
        p.d dVar4 = dVarArr2[0];
        p.d dVar5 = dVar4.f4154f;
        if (dVar5 != null && dVarArr2[1].f4154f != null) {
            if (eVar11.y()) {
                fVar2.f4390f = this.f4418b.Q[0].e();
                fVar.f4390f = -this.f4418b.Q[1].e();
                return;
            }
            f h9 = o.h(this.f4418b.Q[0]);
            f h10 = o.h(this.f4418b.Q[1]);
            if (h9 != null) {
                h9.b(this);
            }
            if (h10 != null) {
                h10.b(this);
            }
            this.f4426j = 4;
        } else if (dVar5 != null) {
            f h11 = o.h(dVar4);
            if (h11 != null) {
                o.b(fVar2, h11, this.f4418b.Q[0].e());
                c(fVar, fVar2, 1, gVar);
            }
        } else {
            p.d dVar6 = dVarArr2[1];
            if (dVar6.f4154f != null) {
                f h12 = o.h(dVar6);
                if (h12 != null) {
                    o.b(fVar, h12, -this.f4418b.Q[1].e());
                    c(fVar2, fVar, -1, gVar);
                }
            } else if ((eVar11 instanceof p.j) || (eVar3 = eVar11.T) == null) {
            } else {
                o.b(fVar2, eVar3.f4164d.f4424h, eVar11.s());
                c(fVar, fVar2, 1, gVar);
            }
        }
    }

    @Override // q.o
    public final void e() {
        f fVar = this.f4424h;
        if (fVar.f4394j) {
            this.f4418b.Y = fVar.f4391g;
        }
    }

    @Override // q.o
    public final void f() {
        this.f4419c = null;
        this.f4424h.c();
        this.f4425i.c();
        this.f4421e.c();
        this.f4423g = false;
    }

    @Override // q.o
    public final boolean k() {
        return this.f4420d != 3 || this.f4418b.f4190r == 0;
    }

    public final void n() {
        this.f4423g = false;
        f fVar = this.f4424h;
        fVar.c();
        fVar.f4394j = false;
        f fVar2 = this.f4425i;
        fVar2.c();
        fVar2.f4394j = false;
        this.f4421e.f4394j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f4418b.f4173h0;
    }
}
