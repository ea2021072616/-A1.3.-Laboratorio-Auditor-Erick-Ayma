package q;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class l extends o {

    /* renamed from: k  reason: collision with root package name */
    public final f f4401k;

    /* renamed from: l  reason: collision with root package name */
    public a f4402l;

    public l(p.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f4401k = fVar;
        this.f4402l = null;
        this.f4424h.f4389e = 6;
        this.f4425i.f4389e = 7;
        fVar.f4389e = 8;
        this.f4422f = 1;
    }

    @Override // q.d
    public final void a(d dVar) {
        g gVar;
        float f5;
        float f6;
        float f7;
        int i5;
        if (n.h.b(this.f4426j) == 3) {
            p.e eVar = this.f4418b;
            l(eVar.J, eVar.L, 1);
            return;
        }
        g gVar2 = this.f4421e;
        if (gVar2.f4387c && !gVar2.f4394j && this.f4420d == 3) {
            p.e eVar2 = this.f4418b;
            int i6 = eVar2.f4191s;
            if (i6 == 2) {
                p.e eVar3 = eVar2.T;
                if (eVar3 != null) {
                    if (eVar3.f4166e.f4421e.f4394j) {
                        gVar2.d((int) ((gVar.f4391g * eVar2.f4198z) + 0.5f));
                    }
                }
            } else if (i6 == 3) {
                g gVar3 = eVar2.f4164d.f4421e;
                if (gVar3.f4394j) {
                    int i7 = eVar2.X;
                    if (i7 == -1) {
                        f5 = gVar3.f4391g;
                        f6 = eVar2.W;
                    } else if (i7 == 0) {
                        f7 = gVar3.f4391g * eVar2.W;
                        i5 = (int) (f7 + 0.5f);
                        gVar2.d(i5);
                    } else if (i7 != 1) {
                        i5 = 0;
                        gVar2.d(i5);
                    } else {
                        f5 = gVar3.f4391g;
                        f6 = eVar2.W;
                    }
                    f7 = f5 / f6;
                    i5 = (int) (f7 + 0.5f);
                    gVar2.d(i5);
                }
            }
        }
        f fVar = this.f4424h;
        if (fVar.f4387c) {
            f fVar2 = this.f4425i;
            if (fVar2.f4387c) {
                if (fVar.f4394j && fVar2.f4394j && gVar2.f4394j) {
                    return;
                }
                boolean z4 = gVar2.f4394j;
                ArrayList arrayList = fVar.f4396l;
                ArrayList arrayList2 = fVar2.f4396l;
                if (!z4 && this.f4420d == 3) {
                    p.e eVar4 = this.f4418b;
                    if (eVar4.f4190r == 0 && !eVar4.z()) {
                        int i8 = ((f) arrayList.get(0)).f4391g + fVar.f4390f;
                        int i9 = ((f) arrayList2.get(0)).f4391g + fVar2.f4390f;
                        fVar.d(i8);
                        fVar2.d(i9);
                        gVar2.d(i9 - i8);
                        return;
                    }
                }
                if (!gVar2.f4394j && this.f4420d == 3 && this.f4417a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    int i10 = (((f) arrayList2.get(0)).f4391g + fVar2.f4390f) - (((f) arrayList.get(0)).f4391g + fVar.f4390f);
                    int i11 = gVar2.f4397m;
                    if (i10 < i11) {
                        gVar2.d(i10);
                    } else {
                        gVar2.d(i11);
                    }
                }
                if (gVar2.f4394j && arrayList.size() > 0 && arrayList2.size() > 0) {
                    f fVar3 = (f) arrayList.get(0);
                    f fVar4 = (f) arrayList2.get(0);
                    int i12 = fVar3.f4391g;
                    int i13 = fVar.f4390f + i12;
                    int i14 = fVar4.f4391g;
                    int i15 = fVar2.f4390f + i14;
                    float f8 = this.f4418b.f4167e0;
                    if (fVar3 == fVar4) {
                        f8 = 0.5f;
                    } else {
                        i12 = i13;
                        i14 = i15;
                    }
                    fVar.d((int) ((((i14 - i12) - gVar2.f4391g) * f8) + i12 + 0.5f));
                    fVar2.d(fVar.f4391g + gVar2.f4391g);
                }
            }
        }
    }

    @Override // q.o
    public final void d() {
        p.e eVar;
        p.e eVar2;
        p.e eVar3;
        p.e eVar4;
        p.e eVar5 = this.f4418b;
        boolean z4 = eVar5.f4158a;
        g gVar = this.f4421e;
        if (z4) {
            gVar.d(eVar5.l());
        }
        boolean z5 = gVar.f4394j;
        f fVar = this.f4425i;
        f fVar2 = this.f4424h;
        if (!z5) {
            p.e eVar6 = this.f4418b;
            this.f4420d = eVar6.f4188p0[1];
            if (eVar6.E) {
                this.f4402l = new a(this);
            }
            int i5 = this.f4420d;
            if (i5 != 3) {
                if (i5 == 4 && (eVar4 = this.f4418b.T) != null && eVar4.f4188p0[1] == 1) {
                    int l5 = (eVar4.l() - this.f4418b.J.e()) - this.f4418b.L.e();
                    o.b(fVar2, eVar4.f4166e.f4424h, this.f4418b.J.e());
                    o.b(fVar, eVar4.f4166e.f4425i, -this.f4418b.L.e());
                    gVar.d(l5);
                    return;
                } else if (i5 == 1) {
                    gVar.d(this.f4418b.l());
                }
            }
        } else if (this.f4420d == 4 && (eVar2 = (eVar = this.f4418b).T) != null && eVar2.f4188p0[1] == 1) {
            o.b(fVar2, eVar2.f4166e.f4424h, eVar.J.e());
            o.b(fVar, eVar2.f4166e.f4425i, -this.f4418b.L.e());
            return;
        }
        boolean z6 = gVar.f4394j;
        f fVar3 = this.f4401k;
        if (z6) {
            p.e eVar7 = this.f4418b;
            if (eVar7.f4158a) {
                p.d[] dVarArr = eVar7.Q;
                p.d dVar = dVarArr[2];
                p.d dVar2 = dVar.f4154f;
                if (dVar2 != null && dVarArr[3].f4154f != null) {
                    if (eVar7.z()) {
                        fVar2.f4390f = this.f4418b.Q[2].e();
                        fVar.f4390f = -this.f4418b.Q[3].e();
                    } else {
                        f h5 = o.h(this.f4418b.Q[2]);
                        if (h5 != null) {
                            o.b(fVar2, h5, this.f4418b.Q[2].e());
                        }
                        f h6 = o.h(this.f4418b.Q[3]);
                        if (h6 != null) {
                            o.b(fVar, h6, -this.f4418b.Q[3].e());
                        }
                        fVar2.f4386b = true;
                        fVar.f4386b = true;
                    }
                    p.e eVar8 = this.f4418b;
                    if (eVar8.E) {
                        o.b(fVar3, fVar2, eVar8.f4159a0);
                        return;
                    }
                    return;
                } else if (dVar2 != null) {
                    f h7 = o.h(dVar);
                    if (h7 != null) {
                        o.b(fVar2, h7, this.f4418b.Q[2].e());
                        o.b(fVar, fVar2, gVar.f4391g);
                        p.e eVar9 = this.f4418b;
                        if (eVar9.E) {
                            o.b(fVar3, fVar2, eVar9.f4159a0);
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    p.d dVar3 = dVarArr[3];
                    if (dVar3.f4154f != null) {
                        f h8 = o.h(dVar3);
                        if (h8 != null) {
                            o.b(fVar, h8, -this.f4418b.Q[3].e());
                            o.b(fVar2, fVar, -gVar.f4391g);
                        }
                        p.e eVar10 = this.f4418b;
                        if (eVar10.E) {
                            o.b(fVar3, fVar2, eVar10.f4159a0);
                            return;
                        }
                        return;
                    }
                    p.d dVar4 = dVarArr[4];
                    if (dVar4.f4154f != null) {
                        f h9 = o.h(dVar4);
                        if (h9 != null) {
                            o.b(fVar3, h9, 0);
                            o.b(fVar2, fVar3, -this.f4418b.f4159a0);
                            o.b(fVar, fVar2, gVar.f4391g);
                            return;
                        }
                        return;
                    } else if ((eVar7 instanceof p.j) || eVar7.T == null || eVar7.j(p.c.CENTER).f4154f != null) {
                        return;
                    } else {
                        p.e eVar11 = this.f4418b;
                        o.b(fVar2, eVar11.T.f4166e.f4424h, eVar11.t());
                        o.b(fVar, fVar2, gVar.f4391g);
                        p.e eVar12 = this.f4418b;
                        if (eVar12.E) {
                            o.b(fVar3, fVar2, eVar12.f4159a0);
                            return;
                        }
                        return;
                    }
                }
            }
        }
        ArrayList arrayList = gVar.f4396l;
        if (z6 || this.f4420d != 3) {
            gVar.b(this);
        } else {
            p.e eVar13 = this.f4418b;
            int i6 = eVar13.f4191s;
            ArrayList arrayList2 = gVar.f4395k;
            if (i6 == 2) {
                p.e eVar14 = eVar13.T;
                if (eVar14 != null) {
                    g gVar2 = eVar14.f4166e.f4421e;
                    arrayList.add(gVar2);
                    gVar2.f4395k.add(gVar);
                    gVar.f4386b = true;
                    arrayList2.add(fVar2);
                    arrayList2.add(fVar);
                }
            } else if (i6 == 3 && !eVar13.z()) {
                p.e eVar15 = this.f4418b;
                if (eVar15.f4190r != 3) {
                    g gVar3 = eVar15.f4164d.f4421e;
                    arrayList.add(gVar3);
                    gVar3.f4395k.add(gVar);
                    gVar.f4386b = true;
                    arrayList2.add(fVar2);
                    arrayList2.add(fVar);
                }
            }
        }
        p.e eVar16 = this.f4418b;
        p.d[] dVarArr2 = eVar16.Q;
        p.d dVar5 = dVarArr2[2];
        p.d dVar6 = dVar5.f4154f;
        if (dVar6 != null && dVarArr2[3].f4154f != null) {
            if (eVar16.z()) {
                fVar2.f4390f = this.f4418b.Q[2].e();
                fVar.f4390f = -this.f4418b.Q[3].e();
            } else {
                f h10 = o.h(this.f4418b.Q[2]);
                f h11 = o.h(this.f4418b.Q[3]);
                if (h10 != null) {
                    h10.b(this);
                }
                if (h11 != null) {
                    h11.b(this);
                }
                this.f4426j = 4;
            }
            if (this.f4418b.E) {
                c(fVar3, fVar2, 1, this.f4402l);
            }
        } else if (dVar6 != null) {
            f h12 = o.h(dVar5);
            if (h12 != null) {
                o.b(fVar2, h12, this.f4418b.Q[2].e());
                c(fVar, fVar2, 1, gVar);
                if (this.f4418b.E) {
                    c(fVar3, fVar2, 1, this.f4402l);
                }
                if (this.f4420d == 3) {
                    p.e eVar17 = this.f4418b;
                    if (eVar17.W > 0.0f) {
                        j jVar = eVar17.f4164d;
                        if (jVar.f4420d == 3) {
                            jVar.f4421e.f4395k.add(gVar);
                            arrayList.add(this.f4418b.f4164d.f4421e);
                            gVar.f4385a = this;
                        }
                    }
                }
            }
        } else {
            p.d dVar7 = dVarArr2[3];
            if (dVar7.f4154f != null) {
                f h13 = o.h(dVar7);
                if (h13 != null) {
                    o.b(fVar, h13, -this.f4418b.Q[3].e());
                    c(fVar2, fVar, -1, gVar);
                    if (this.f4418b.E) {
                        c(fVar3, fVar2, 1, this.f4402l);
                    }
                }
            } else {
                p.d dVar8 = dVarArr2[4];
                if (dVar8.f4154f != null) {
                    f h14 = o.h(dVar8);
                    if (h14 != null) {
                        o.b(fVar3, h14, 0);
                        c(fVar2, fVar3, -1, this.f4402l);
                        c(fVar, fVar2, 1, gVar);
                    }
                } else if (!(eVar16 instanceof p.j) && (eVar3 = eVar16.T) != null) {
                    o.b(fVar2, eVar3.f4166e.f4424h, eVar16.t());
                    c(fVar, fVar2, 1, gVar);
                    if (this.f4418b.E) {
                        c(fVar3, fVar2, 1, this.f4402l);
                    }
                    if (this.f4420d == 3) {
                        p.e eVar18 = this.f4418b;
                        if (eVar18.W > 0.0f) {
                            j jVar2 = eVar18.f4164d;
                            if (jVar2.f4420d == 3) {
                                jVar2.f4421e.f4395k.add(gVar);
                                arrayList.add(this.f4418b.f4164d.f4421e);
                                gVar.f4385a = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            gVar.f4387c = true;
        }
    }

    @Override // q.o
    public final void e() {
        f fVar = this.f4424h;
        if (fVar.f4394j) {
            this.f4418b.Z = fVar.f4391g;
        }
    }

    @Override // q.o
    public final void f() {
        this.f4419c = null;
        this.f4424h.c();
        this.f4425i.c();
        this.f4401k.c();
        this.f4421e.c();
        this.f4423g = false;
    }

    @Override // q.o
    public final boolean k() {
        return this.f4420d != 3 || this.f4418b.f4191s == 0;
    }

    public final void m() {
        this.f4423g = false;
        f fVar = this.f4424h;
        fVar.c();
        fVar.f4394j = false;
        f fVar2 = this.f4425i;
        fVar2.c();
        fVar2.f4394j = false;
        f fVar3 = this.f4401k;
        fVar3.c();
        fVar3.f4394j = false;
        this.f4421e.f4394j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f4418b.f4173h0;
    }
}
