package p;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class i extends e {

    /* renamed from: q0  reason: collision with root package name */
    public float f4235q0 = -1.0f;

    /* renamed from: r0  reason: collision with root package name */
    public int f4236r0 = -1;

    /* renamed from: s0  reason: collision with root package name */
    public int f4237s0 = -1;

    /* renamed from: t0  reason: collision with root package name */
    public d f4238t0 = this.J;

    /* renamed from: u0  reason: collision with root package name */
    public int f4239u0 = 0;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f4240v0;

    public i() {
        this.R.clear();
        this.R.add(this.f4238t0);
        int length = this.Q.length;
        for (int i5 = 0; i5 < length; i5++) {
            this.Q[i5] = this.f4238t0;
        }
    }

    @Override // p.e
    public final boolean B() {
        return this.f4240v0;
    }

    @Override // p.e
    public final boolean C() {
        return this.f4240v0;
    }

    @Override // p.e
    public final void Q(n.d dVar, boolean z4) {
        if (this.T == null) {
            return;
        }
        d dVar2 = this.f4238t0;
        dVar.getClass();
        int n5 = n.d.n(dVar2);
        if (this.f4239u0 == 1) {
            this.Y = n5;
            this.Z = 0;
            L(this.T.l());
            O(0);
            return;
        }
        this.Y = 0;
        this.Z = n5;
        O(this.T.r());
        L(0);
    }

    public final void R(int i5) {
        this.f4238t0.l(i5);
        this.f4240v0 = true;
    }

    public final void S(int i5) {
        if (this.f4239u0 == i5) {
            return;
        }
        this.f4239u0 = i5;
        ArrayList arrayList = this.R;
        arrayList.clear();
        if (this.f4239u0 == 1) {
            this.f4238t0 = this.I;
        } else {
            this.f4238t0 = this.J;
        }
        arrayList.add(this.f4238t0);
        d[] dVarArr = this.Q;
        int length = dVarArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            dVarArr[i6] = this.f4238t0;
        }
    }

    @Override // p.e
    public final void c(n.d dVar, boolean z4) {
        f fVar = (f) this.T;
        if (fVar == null) {
            return;
        }
        Object j5 = fVar.j(c.LEFT);
        Object j6 = fVar.j(c.RIGHT);
        e eVar = this.T;
        boolean z5 = true;
        boolean z6 = eVar != null && eVar.f4188p0[0] == 2;
        if (this.f4239u0 == 0) {
            j5 = fVar.j(c.TOP);
            j6 = fVar.j(c.BOTTOM);
            e eVar2 = this.T;
            if (eVar2 == null || eVar2.f4188p0[1] != 2) {
                z5 = false;
            }
            z6 = z5;
        }
        if (this.f4240v0) {
            d dVar2 = this.f4238t0;
            if (dVar2.f4151c) {
                n.i k5 = dVar.k(dVar2);
                dVar.d(k5, this.f4238t0.d());
                if (this.f4236r0 != -1) {
                    if (z6) {
                        dVar.f(dVar.k(j6), k5, 0, 5);
                    }
                } else if (this.f4237s0 != -1 && z6) {
                    n.i k6 = dVar.k(j6);
                    dVar.f(k5, dVar.k(j5), 0, 5);
                    dVar.f(k6, k5, 0, 5);
                }
                this.f4240v0 = false;
                return;
            }
        }
        if (this.f4236r0 != -1) {
            n.i k7 = dVar.k(this.f4238t0);
            dVar.e(k7, dVar.k(j5), this.f4236r0, 8);
            if (z6) {
                dVar.f(dVar.k(j6), k7, 0, 5);
            }
        } else if (this.f4237s0 != -1) {
            n.i k8 = dVar.k(this.f4238t0);
            n.i k9 = dVar.k(j6);
            dVar.e(k8, k9, -this.f4237s0, 8);
            if (z6) {
                dVar.f(k8, dVar.k(j5), 0, 5);
                dVar.f(k9, k8, 0, 5);
            }
        } else if (this.f4235q0 != -1.0f) {
            n.i k10 = dVar.k(this.f4238t0);
            n.i k11 = dVar.k(j6);
            float f5 = this.f4235q0;
            n.c l5 = dVar.l();
            l5.f4006d.g(k10, -1.0f);
            l5.f4006d.g(k11, f5);
            dVar.c(l5);
        }
    }

    @Override // p.e
    public final boolean d() {
        return true;
    }

    @Override // p.e
    public final d j(c cVar) {
        int ordinal = cVar.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        return null;
                    }
                }
            }
            if (this.f4239u0 == 0) {
                return this.f4238t0;
            }
            return null;
        }
        if (this.f4239u0 == 1) {
            return this.f4238t0;
        }
        return null;
    }
}
