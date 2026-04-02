package p;

import androidx.appcompat.widget.b0;
/* loaded from: classes.dex */
public final class a extends k {

    /* renamed from: s0  reason: collision with root package name */
    public int f4120s0 = 0;

    /* renamed from: t0  reason: collision with root package name */
    public boolean f4121t0 = true;

    /* renamed from: u0  reason: collision with root package name */
    public int f4122u0 = 0;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f4123v0 = false;

    @Override // p.e
    public final boolean B() {
        return this.f4123v0;
    }

    @Override // p.e
    public final boolean C() {
        return this.f4123v0;
    }

    public final boolean S() {
        int i5;
        int i6;
        int i7;
        boolean z4 = true;
        int i8 = 0;
        while (true) {
            i5 = this.f4242r0;
            if (i8 >= i5) {
                break;
            }
            e eVar = this.f4241q0[i8];
            if ((this.f4121t0 || eVar.d()) && ((((i6 = this.f4120s0) == 0 || i6 == 1) && !eVar.B()) || (((i7 = this.f4120s0) == 2 || i7 == 3) && !eVar.C()))) {
                z4 = false;
            }
            i8++;
        }
        if (!z4 || i5 <= 0) {
            return false;
        }
        int i9 = 0;
        boolean z5 = false;
        for (int i10 = 0; i10 < this.f4242r0; i10++) {
            e eVar2 = this.f4241q0[i10];
            if (this.f4121t0 || eVar2.d()) {
                c cVar = c.BOTTOM;
                c cVar2 = c.TOP;
                c cVar3 = c.RIGHT;
                c cVar4 = c.LEFT;
                if (!z5) {
                    int i11 = this.f4120s0;
                    if (i11 == 0) {
                        i9 = eVar2.j(cVar4).d();
                    } else if (i11 == 1) {
                        i9 = eVar2.j(cVar3).d();
                    } else if (i11 == 2) {
                        i9 = eVar2.j(cVar2).d();
                    } else if (i11 == 3) {
                        i9 = eVar2.j(cVar).d();
                    }
                    z5 = true;
                }
                int i12 = this.f4120s0;
                if (i12 == 0) {
                    i9 = Math.min(i9, eVar2.j(cVar4).d());
                } else if (i12 == 1) {
                    i9 = Math.max(i9, eVar2.j(cVar3).d());
                } else if (i12 == 2) {
                    i9 = Math.min(i9, eVar2.j(cVar2).d());
                } else if (i12 == 3) {
                    i9 = Math.max(i9, eVar2.j(cVar).d());
                }
            }
        }
        int i13 = i9 + this.f4122u0;
        int i14 = this.f4120s0;
        if (i14 == 0 || i14 == 1) {
            J(i13, i13);
        } else {
            K(i13, i13);
        }
        this.f4123v0 = true;
        return true;
    }

    public final int T() {
        int i5 = this.f4120s0;
        if (i5 == 0 || i5 == 1) {
            return 0;
        }
        return (i5 == 2 || i5 == 3) ? 1 : -1;
    }

    @Override // p.e
    public final void c(n.d dVar, boolean z4) {
        boolean z5;
        int i5;
        int i6;
        d[] dVarArr = this.Q;
        d dVar2 = this.I;
        dVarArr[0] = dVar2;
        int i7 = 2;
        d dVar3 = this.J;
        dVarArr[2] = dVar3;
        d dVar4 = this.K;
        dVarArr[1] = dVar4;
        d dVar5 = this.L;
        dVarArr[3] = dVar5;
        for (d dVar6 : dVarArr) {
            dVar6.f4157i = dVar.k(dVar6);
        }
        int i8 = this.f4120s0;
        if (i8 < 0 || i8 >= 4) {
            return;
        }
        d dVar7 = dVarArr[i8];
        if (!this.f4123v0) {
            S();
        }
        if (this.f4123v0) {
            this.f4123v0 = false;
            int i9 = this.f4120s0;
            if (i9 == 0 || i9 == 1) {
                dVar.d(dVar2.f4157i, this.Y);
                dVar.d(dVar4.f4157i, this.Y);
                return;
            } else if (i9 == 2 || i9 == 3) {
                dVar.d(dVar3.f4157i, this.Z);
                dVar.d(dVar5.f4157i, this.Z);
                return;
            } else {
                return;
            }
        }
        for (int i10 = 0; i10 < this.f4242r0; i10++) {
            e eVar = this.f4241q0[i10];
            if ((this.f4121t0 || eVar.d()) && ((((i6 = this.f4120s0) == 0 || i6 == 1) && eVar.f4188p0[0] == 3 && eVar.I.f4154f != null && eVar.K.f4154f != null) || ((i6 == 2 || i6 == 3) && eVar.f4188p0[1] == 3 && eVar.J.f4154f != null && eVar.L.f4154f != null))) {
                z5 = true;
                break;
            }
        }
        z5 = false;
        boolean z6 = dVar2.g() || dVar4.g();
        boolean z7 = dVar3.g() || dVar5.g();
        int i11 = !(!z5 && (((i5 = this.f4120s0) == 0 && z6) || ((i5 == 2 && z7) || ((i5 == 1 && z6) || (i5 == 3 && z7))))) ? 4 : 5;
        int i12 = 0;
        while (i12 < this.f4242r0) {
            e eVar2 = this.f4241q0[i12];
            if (this.f4121t0 || eVar2.d()) {
                n.i k5 = dVar.k(eVar2.Q[this.f4120s0]);
                int i13 = this.f4120s0;
                d dVar8 = eVar2.Q[i13];
                dVar8.f4157i = k5;
                d dVar9 = dVar8.f4154f;
                int i14 = (dVar9 == null || dVar9.f4152d != this) ? 0 : dVar8.f4155g + 0;
                if (i13 == 0 || i13 == i7) {
                    n.c l5 = dVar.l();
                    n.i m5 = dVar.m();
                    m5.f4036e = 0;
                    l5.c(dVar7.f4157i, k5, m5, this.f4122u0 - i14);
                    dVar.c(l5);
                } else {
                    n.c l6 = dVar.l();
                    n.i m6 = dVar.m();
                    m6.f4036e = 0;
                    l6.b(dVar7.f4157i, k5, m6, this.f4122u0 + i14);
                    dVar.c(l6);
                }
                dVar.e(dVar7.f4157i, k5, this.f4122u0 + i14, i11);
            }
            i12++;
            i7 = 2;
        }
        int i15 = this.f4120s0;
        if (i15 == 0) {
            dVar.e(dVar4.f4157i, dVar2.f4157i, 0, 8);
            dVar.e(dVar2.f4157i, this.T.K.f4157i, 0, 4);
            dVar.e(dVar2.f4157i, this.T.I.f4157i, 0, 0);
        } else if (i15 == 1) {
            dVar.e(dVar2.f4157i, dVar4.f4157i, 0, 8);
            dVar.e(dVar2.f4157i, this.T.I.f4157i, 0, 4);
            dVar.e(dVar2.f4157i, this.T.K.f4157i, 0, 0);
        } else if (i15 == 2) {
            dVar.e(dVar5.f4157i, dVar3.f4157i, 0, 8);
            dVar.e(dVar3.f4157i, this.T.L.f4157i, 0, 4);
            dVar.e(dVar3.f4157i, this.T.J.f4157i, 0, 0);
        } else if (i15 == 3) {
            dVar.e(dVar3.f4157i, dVar5.f4157i, 0, 8);
            dVar.e(dVar3.f4157i, this.T.J.f4157i, 0, 4);
            dVar.e(dVar3.f4157i, this.T.L.f4157i, 0, 0);
        }
    }

    @Override // p.e
    public final boolean d() {
        return true;
    }

    @Override // p.e
    public final String toString() {
        String i5 = b0.i(new StringBuilder("[Barrier] "), this.f4173h0, " {");
        for (int i6 = 0; i6 < this.f4242r0; i6++) {
            e eVar = this.f4241q0[i6];
            if (i6 > 0) {
                i5 = b0.h(i5, ", ");
            }
            i5 = i5 + eVar.f4173h0;
        }
        return b0.h(i5, "}");
    }
}
