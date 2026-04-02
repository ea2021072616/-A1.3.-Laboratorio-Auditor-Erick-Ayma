package p;

import java.util.ArrayList;
import q.m;
/* loaded from: classes.dex */
public final class h extends k {

    /* renamed from: a1  reason: collision with root package name */
    public e[] f4225a1;

    /* renamed from: s0  reason: collision with root package name */
    public int f4227s0 = 0;

    /* renamed from: t0  reason: collision with root package name */
    public int f4228t0 = 0;

    /* renamed from: u0  reason: collision with root package name */
    public int f4229u0 = 0;

    /* renamed from: v0  reason: collision with root package name */
    public int f4230v0 = 0;

    /* renamed from: w0  reason: collision with root package name */
    public int f4231w0 = 0;

    /* renamed from: x0  reason: collision with root package name */
    public int f4232x0 = 0;

    /* renamed from: y0  reason: collision with root package name */
    public boolean f4233y0 = false;

    /* renamed from: z0  reason: collision with root package name */
    public int f4234z0 = 0;
    public int A0 = 0;
    public final q.b B0 = new q.b();
    public m C0 = null;
    public int D0 = -1;
    public int E0 = -1;
    public int F0 = -1;
    public int G0 = -1;
    public int H0 = -1;
    public int I0 = -1;
    public float J0 = 0.5f;
    public float K0 = 0.5f;
    public float L0 = 0.5f;
    public float M0 = 0.5f;
    public float N0 = 0.5f;
    public float O0 = 0.5f;
    public int P0 = 0;
    public int Q0 = 0;
    public int R0 = 2;
    public int S0 = 2;
    public int T0 = 0;
    public int U0 = -1;
    public int V0 = 0;
    public final ArrayList W0 = new ArrayList();
    public e[] X0 = null;
    public e[] Y0 = null;
    public int[] Z0 = null;

    /* renamed from: b1  reason: collision with root package name */
    public int f4226b1 = 0;

    public final int S(int i5, e eVar) {
        if (eVar == null) {
            return 0;
        }
        int[] iArr = eVar.f4188p0;
        if (iArr[1] == 3) {
            int i6 = eVar.f4191s;
            if (i6 == 0) {
                return 0;
            }
            if (i6 == 2) {
                int i7 = (int) (eVar.f4198z * i5);
                if (i7 != eVar.l()) {
                    eVar.f4170g = true;
                    U(eVar, iArr[0], eVar.r(), 1, i7);
                }
                return i7;
            } else if (i6 == 1) {
                return eVar.l();
            } else {
                if (i6 == 3) {
                    return (int) ((eVar.r() * eVar.W) + 0.5f);
                }
            }
        }
        return eVar.l();
    }

    public final int T(int i5, e eVar) {
        if (eVar == null) {
            return 0;
        }
        int[] iArr = eVar.f4188p0;
        if (iArr[0] == 3) {
            int i6 = eVar.f4190r;
            if (i6 == 0) {
                return 0;
            }
            if (i6 == 2) {
                int i7 = (int) (eVar.f4195w * i5);
                if (i7 != eVar.r()) {
                    eVar.f4170g = true;
                    U(eVar, 1, i7, iArr[1], eVar.l());
                }
                return i7;
            } else if (i6 == 1) {
                return eVar.r();
            } else {
                if (i6 == 3) {
                    return (int) ((eVar.l() * eVar.W) + 0.5f);
                }
            }
        }
        return eVar.r();
    }

    public final void U(e eVar, int i5, int i6, int i7, int i8) {
        m mVar;
        e eVar2;
        while (true) {
            mVar = this.C0;
            if (mVar != null || (eVar2 = this.T) == null) {
                break;
            }
            this.C0 = ((f) eVar2).f4202u0;
        }
        q.b bVar = this.B0;
        bVar.f4365a = i5;
        bVar.f4366b = i7;
        bVar.f4367c = i6;
        bVar.f4368d = i8;
        mVar.b(eVar, bVar);
        eVar.O(bVar.f4369e);
        eVar.L(bVar.f4370f);
        eVar.E = bVar.f4372h;
        int i9 = bVar.f4371g;
        eVar.f4159a0 = i9;
        eVar.E = i9 > 0;
    }

    @Override // p.k, p.j
    public final void a() {
        for (int i5 = 0; i5 < this.f4242r0; i5++) {
            e eVar = this.f4241q0[i5];
            if (eVar != null) {
                eVar.F = true;
            }
        }
    }

    @Override // p.e
    public final void c(n.d dVar, boolean z4) {
        e eVar;
        float f5;
        int i5;
        super.c(dVar, z4);
        e eVar2 = this.T;
        boolean z5 = eVar2 != null && ((f) eVar2).f4203v0;
        int i6 = this.T0;
        ArrayList arrayList = this.W0;
        if (i6 != 0) {
            if (i6 == 1) {
                int size = arrayList.size();
                int i7 = 0;
                while (i7 < size) {
                    ((g) arrayList.get(i7)).b(i7, z5, i7 == size + (-1));
                    i7++;
                }
            } else if (i6 != 2) {
                if (i6 == 3) {
                    int size2 = arrayList.size();
                    int i8 = 0;
                    while (i8 < size2) {
                        ((g) arrayList.get(i8)).b(i8, z5, i8 == size2 + (-1));
                        i8++;
                    }
                }
            } else if (this.Z0 != null && this.Y0 != null && this.X0 != null) {
                for (int i9 = 0; i9 < this.f4226b1; i9++) {
                    this.f4225a1[i9].E();
                }
                int[] iArr = this.Z0;
                int i10 = iArr[0];
                int i11 = iArr[1];
                float f6 = this.J0;
                e eVar3 = null;
                int i12 = 0;
                while (i12 < i10) {
                    if (z5) {
                        i5 = (i10 - i12) - 1;
                        f5 = 1.0f - this.J0;
                    } else {
                        f5 = f6;
                        i5 = i12;
                    }
                    e eVar4 = this.Y0[i5];
                    if (eVar4 != null && eVar4.f4171g0 != 8) {
                        d dVar2 = eVar4.I;
                        if (i12 == 0) {
                            eVar4.g(dVar2, this.I, this.f4231w0);
                            eVar4.f4175i0 = this.D0;
                            eVar4.f4165d0 = f5;
                        }
                        if (i12 == i10 - 1) {
                            eVar4.g(eVar4.K, this.K, this.f4232x0);
                        }
                        if (i12 > 0 && eVar3 != null) {
                            int i13 = this.P0;
                            d dVar3 = eVar3.K;
                            eVar4.g(dVar2, dVar3, i13);
                            eVar3.g(dVar3, dVar2, 0);
                        }
                        eVar3 = eVar4;
                    }
                    i12++;
                    f6 = f5;
                }
                for (int i14 = 0; i14 < i11; i14++) {
                    e eVar5 = this.X0[i14];
                    if (eVar5 != null && eVar5.f4171g0 != 8) {
                        d dVar4 = eVar5.J;
                        if (i14 == 0) {
                            eVar5.g(dVar4, this.J, this.f4227s0);
                            eVar5.f4177j0 = this.E0;
                            eVar5.f4167e0 = this.K0;
                        }
                        if (i14 == i11 - 1) {
                            eVar5.g(eVar5.L, this.L, this.f4228t0);
                        }
                        if (i14 > 0 && eVar3 != null) {
                            int i15 = this.Q0;
                            d dVar5 = eVar3.L;
                            eVar5.g(dVar4, dVar5, i15);
                            eVar3.g(dVar5, dVar4, 0);
                        }
                        eVar3 = eVar5;
                    }
                }
                for (int i16 = 0; i16 < i10; i16++) {
                    for (int i17 = 0; i17 < i11; i17++) {
                        int i18 = (i17 * i10) + i16;
                        if (this.V0 == 1) {
                            i18 = (i16 * i11) + i17;
                        }
                        e[] eVarArr = this.f4225a1;
                        if (i18 < eVarArr.length && (eVar = eVarArr[i18]) != null && eVar.f4171g0 != 8) {
                            e eVar6 = this.Y0[i16];
                            e eVar7 = this.X0[i17];
                            if (eVar != eVar6) {
                                eVar.g(eVar.I, eVar6.I, 0);
                                eVar.g(eVar.K, eVar6.K, 0);
                            }
                            if (eVar != eVar7) {
                                eVar.g(eVar.J, eVar7.J, 0);
                                eVar.g(eVar.L, eVar7.L, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((g) arrayList.get(0)).b(0, z5, true);
        }
        this.f4233y0 = false;
    }
}
