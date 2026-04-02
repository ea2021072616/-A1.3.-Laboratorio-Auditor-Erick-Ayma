package p;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f4208a;

    /* renamed from: d  reason: collision with root package name */
    public d f4211d;

    /* renamed from: e  reason: collision with root package name */
    public d f4212e;

    /* renamed from: f  reason: collision with root package name */
    public d f4213f;

    /* renamed from: g  reason: collision with root package name */
    public d f4214g;

    /* renamed from: h  reason: collision with root package name */
    public int f4215h;

    /* renamed from: i  reason: collision with root package name */
    public int f4216i;

    /* renamed from: j  reason: collision with root package name */
    public int f4217j;

    /* renamed from: k  reason: collision with root package name */
    public int f4218k;

    /* renamed from: q  reason: collision with root package name */
    public int f4223q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ h f4224r;

    /* renamed from: b  reason: collision with root package name */
    public e f4209b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f4210c = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f4219l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f4220m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f4221n = 0;
    public int o = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f4222p = 0;

    public g(h hVar, int i5, d dVar, d dVar2, d dVar3, d dVar4, int i6) {
        this.f4224r = hVar;
        this.f4215h = 0;
        this.f4216i = 0;
        this.f4217j = 0;
        this.f4218k = 0;
        this.f4223q = 0;
        this.f4208a = i5;
        this.f4211d = dVar;
        this.f4212e = dVar2;
        this.f4213f = dVar3;
        this.f4214g = dVar4;
        this.f4215h = hVar.f4231w0;
        this.f4216i = hVar.f4227s0;
        this.f4217j = hVar.f4232x0;
        this.f4218k = hVar.f4228t0;
        this.f4223q = i6;
    }

    public final void a(e eVar) {
        int i5 = this.f4208a;
        h hVar = this.f4224r;
        if (i5 == 0) {
            int T = hVar.T(this.f4223q, eVar);
            if (eVar.f4188p0[0] == 3) {
                this.f4222p++;
                T = 0;
            }
            this.f4219l = T + (eVar.f4171g0 != 8 ? hVar.P0 : 0) + this.f4219l;
            int S = hVar.S(this.f4223q, eVar);
            if (this.f4209b == null || this.f4210c < S) {
                this.f4209b = eVar;
                this.f4210c = S;
                this.f4220m = S;
            }
        } else {
            int T2 = hVar.T(this.f4223q, eVar);
            int S2 = hVar.S(this.f4223q, eVar);
            if (eVar.f4188p0[1] == 3) {
                this.f4222p++;
                S2 = 0;
            }
            this.f4220m = S2 + (eVar.f4171g0 != 8 ? hVar.Q0 : 0) + this.f4220m;
            if (this.f4209b == null || this.f4210c < T2) {
                this.f4209b = eVar;
                this.f4210c = T2;
                this.f4219l = T2;
            }
        }
        this.o++;
    }

    public final void b(int i5, boolean z4, boolean z5) {
        h hVar;
        int i6;
        int i7;
        int i8;
        e eVar;
        int i9;
        char c5;
        int i10;
        float f5;
        float f6;
        int i11;
        float f7;
        int i12;
        int i13 = this.o;
        int i14 = 0;
        while (true) {
            hVar = this.f4224r;
            if (i14 >= i13 || (i12 = this.f4221n + i14) >= hVar.f4226b1) {
                break;
            }
            e eVar2 = hVar.f4225a1[i12];
            if (eVar2 != null) {
                eVar2.E();
            }
            i14++;
        }
        if (i13 == 0 || this.f4209b == null) {
            return;
        }
        boolean z6 = z5 && i5 == 0;
        int i15 = -1;
        int i16 = -1;
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = this.f4221n + (z4 ? (i13 - 1) - i17 : i17);
            if (i18 >= hVar.f4226b1) {
                break;
            }
            e eVar3 = hVar.f4225a1[i18];
            if (eVar3 != null && eVar3.f4171g0 == 0) {
                if (i15 == -1) {
                    i15 = i17;
                }
                i16 = i17;
            }
        }
        if (this.f4208a != 0) {
            e eVar4 = this.f4209b;
            eVar4.f4175i0 = hVar.D0;
            int i19 = this.f4215h;
            if (i5 > 0) {
                i19 += hVar.P0;
            }
            d dVar = eVar4.K;
            d dVar2 = eVar4.I;
            if (z4) {
                dVar.a(this.f4213f, i19);
                if (z5) {
                    dVar2.a(this.f4211d, this.f4217j);
                }
                if (i5 > 0) {
                    this.f4213f.f4152d.I.a(dVar, 0);
                }
            } else {
                dVar2.a(this.f4211d, i19);
                if (z5) {
                    dVar.a(this.f4213f, this.f4217j);
                }
                if (i5 > 0) {
                    this.f4211d.f4152d.K.a(dVar2, 0);
                }
            }
            int i20 = 0;
            e eVar5 = null;
            while (i20 < i13) {
                int i21 = this.f4221n + i20;
                if (i21 >= hVar.f4226b1) {
                    return;
                }
                e eVar6 = hVar.f4225a1[i21];
                if (eVar6 == null) {
                    eVar6 = eVar5;
                } else {
                    d dVar3 = eVar6.J;
                    if (i20 == 0) {
                        eVar6.g(dVar3, this.f4212e, this.f4216i);
                        int i22 = hVar.E0;
                        float f8 = hVar.K0;
                        if (this.f4221n == 0) {
                            i8 = hVar.G0;
                            i6 = i22;
                            i7 = -1;
                            if (i8 != -1) {
                                f8 = hVar.M0;
                                eVar6.f4177j0 = i8;
                                eVar6.f4167e0 = f8;
                            }
                        } else {
                            i6 = i22;
                            i7 = -1;
                        }
                        if (!z5 || (i8 = hVar.I0) == i7) {
                            i8 = i6;
                        } else {
                            f8 = hVar.O0;
                        }
                        eVar6.f4177j0 = i8;
                        eVar6.f4167e0 = f8;
                    }
                    if (i20 == i13 - 1) {
                        eVar6.g(eVar6.L, this.f4214g, this.f4218k);
                    }
                    if (eVar5 != null) {
                        int i23 = hVar.Q0;
                        d dVar4 = eVar5.L;
                        dVar3.a(dVar4, i23);
                        if (i20 == i15) {
                            int i24 = this.f4216i;
                            if (dVar3.h()) {
                                dVar3.f4156h = i24;
                            }
                        }
                        dVar4.a(dVar3, 0);
                        if (i20 == i16 + 1) {
                            int i25 = this.f4218k;
                            if (dVar4.h()) {
                                dVar4.f4156h = i25;
                            }
                        }
                    }
                    if (eVar6 != eVar4) {
                        d dVar5 = eVar6.K;
                        d dVar6 = eVar6.I;
                        if (z4) {
                            int i26 = hVar.R0;
                            if (i26 == 0) {
                                dVar5.a(dVar, 0);
                            } else if (i26 == 1) {
                                dVar6.a(dVar2, 0);
                            } else if (i26 == 2) {
                                dVar6.a(dVar2, 0);
                                dVar5.a(dVar, 0);
                            }
                            i20++;
                            eVar5 = eVar6;
                        } else {
                            int i27 = hVar.R0;
                            if (i27 == 0) {
                                dVar6.a(dVar2, 0);
                            } else if (i27 == 1) {
                                dVar5.a(dVar, 0);
                            } else if (i27 == 2) {
                                if (z6) {
                                    dVar6.a(this.f4211d, this.f4215h);
                                    dVar5.a(this.f4213f, this.f4217j);
                                } else {
                                    dVar6.a(dVar2, 0);
                                    dVar5.a(dVar, 0);
                                }
                            }
                            i20++;
                            eVar5 = eVar6;
                        }
                    }
                }
                i20++;
                eVar5 = eVar6;
            }
            return;
        }
        e eVar7 = this.f4209b;
        eVar7.f4177j0 = hVar.E0;
        int i28 = this.f4216i;
        if (i5 > 0) {
            i28 += hVar.Q0;
        }
        d dVar7 = this.f4212e;
        d dVar8 = eVar7.J;
        dVar8.a(dVar7, i28);
        d dVar9 = eVar7.L;
        if (z5) {
            dVar9.a(this.f4214g, this.f4218k);
        }
        if (i5 > 0) {
            this.f4212e.f4152d.L.a(dVar8, 0);
        }
        if (hVar.S0 == 3 && !eVar7.E) {
            for (int i29 = 0; i29 < i13; i29++) {
                int i30 = this.f4221n + (z4 ? (i13 - 1) - i29 : i29);
                if (i30 >= hVar.f4226b1) {
                    break;
                }
                eVar = hVar.f4225a1[i30];
                if (eVar.E) {
                    break;
                }
            }
        }
        eVar = eVar7;
        int i31 = 0;
        e eVar8 = null;
        while (i31 < i13) {
            int i32 = z4 ? (i13 - 1) - i31 : i31;
            int i33 = this.f4221n + i32;
            if (i33 >= hVar.f4226b1) {
                return;
            }
            e eVar9 = hVar.f4225a1[i33];
            if (eVar9 == null) {
                i9 = i13;
                c5 = 3;
            } else {
                d dVar10 = eVar9.I;
                if (i31 == 0) {
                    eVar9.g(dVar10, this.f4211d, this.f4215h);
                }
                if (i32 == 0) {
                    int i34 = hVar.D0;
                    if (z4) {
                        i10 = i34;
                        f5 = 1.0f - hVar.J0;
                    } else {
                        i10 = i34;
                        f5 = hVar.J0;
                    }
                    if (this.f4221n == 0) {
                        int i35 = hVar.F0;
                        f6 = f5;
                        if (i35 != -1) {
                            f7 = z4 ? 1.0f - hVar.L0 : hVar.L0;
                            i11 = i35;
                            eVar9.f4175i0 = i11;
                            eVar9.f4165d0 = f7;
                        }
                    } else {
                        f6 = f5;
                    }
                    if (!z5 || (i11 = hVar.H0) == -1) {
                        i11 = i10;
                        f7 = f6;
                    } else {
                        f7 = z4 ? 1.0f - hVar.N0 : hVar.N0;
                    }
                    eVar9.f4175i0 = i11;
                    eVar9.f4165d0 = f7;
                }
                if (i31 == i13 - 1) {
                    i9 = i13;
                    eVar9.g(eVar9.K, this.f4213f, this.f4217j);
                } else {
                    i9 = i13;
                }
                if (eVar8 != null) {
                    int i36 = hVar.P0;
                    d dVar11 = eVar8.K;
                    dVar10.a(dVar11, i36);
                    if (i31 == i15) {
                        int i37 = this.f4215h;
                        if (dVar10.h()) {
                            dVar10.f4156h = i37;
                        }
                    }
                    dVar11.a(dVar10, 0);
                    if (i31 == i16 + 1) {
                        int i38 = this.f4217j;
                        if (dVar11.h()) {
                            dVar11.f4156h = i38;
                        }
                    }
                }
                if (eVar9 != eVar7) {
                    int i39 = hVar.S0;
                    c5 = 3;
                    if (i39 == 3 && eVar.E && eVar9 != eVar && eVar9.E) {
                        eVar9.M.a(eVar.M, 0);
                    } else {
                        d dVar12 = eVar9.J;
                        if (i39 != 0) {
                            d dVar13 = eVar9.L;
                            if (i39 == 1) {
                                dVar13.a(dVar9, 0);
                            } else if (z6) {
                                dVar12.a(this.f4212e, this.f4216i);
                                dVar13.a(this.f4214g, this.f4218k);
                            } else {
                                dVar12.a(dVar8, 0);
                                dVar13.a(dVar9, 0);
                            }
                        } else {
                            dVar12.a(dVar8, 0);
                        }
                    }
                } else {
                    c5 = 3;
                }
                eVar8 = eVar9;
            }
            i31++;
            i13 = i9;
        }
    }

    public final int c() {
        return this.f4208a == 1 ? this.f4220m - this.f4224r.Q0 : this.f4220m;
    }

    public final int d() {
        return this.f4208a == 0 ? this.f4219l - this.f4224r.P0 : this.f4219l;
    }

    public final void e(int i5) {
        h hVar;
        int i6;
        int i7 = this.f4222p;
        if (i7 == 0) {
            return;
        }
        int i8 = this.o;
        int i9 = i5 / i7;
        int i10 = 0;
        while (true) {
            hVar = this.f4224r;
            if (i10 >= i8 || (i6 = this.f4221n + i10) >= hVar.f4226b1) {
                break;
            }
            e eVar = hVar.f4225a1[i6];
            if (this.f4208a == 0) {
                if (eVar != null) {
                    int[] iArr = eVar.f4188p0;
                    if (iArr[0] == 3 && eVar.f4190r == 0) {
                        hVar.U(eVar, 1, i9, iArr[1], eVar.l());
                    }
                }
            } else if (eVar != null) {
                int[] iArr2 = eVar.f4188p0;
                if (iArr2[1] == 3 && eVar.f4191s == 0) {
                    hVar.U(eVar, iArr2[0], eVar.r(), 1, i9);
                }
            }
            i10++;
        }
        this.f4219l = 0;
        this.f4220m = 0;
        this.f4209b = null;
        this.f4210c = 0;
        int i11 = this.o;
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.f4221n + i12;
            if (i13 >= hVar.f4226b1) {
                return;
            }
            e eVar2 = hVar.f4225a1[i13];
            if (this.f4208a == 0) {
                int r5 = eVar2.r();
                int i14 = hVar.P0;
                if (eVar2.f4171g0 == 8) {
                    i14 = 0;
                }
                this.f4219l = r5 + i14 + this.f4219l;
                int S = hVar.S(this.f4223q, eVar2);
                if (this.f4209b == null || this.f4210c < S) {
                    this.f4209b = eVar2;
                    this.f4210c = S;
                    this.f4220m = S;
                }
            } else {
                int T = hVar.T(this.f4223q, eVar2);
                int S2 = hVar.S(this.f4223q, eVar2);
                int i15 = hVar.Q0;
                if (eVar2.f4171g0 == 8) {
                    i15 = 0;
                }
                this.f4220m = S2 + i15 + this.f4220m;
                if (this.f4209b == null || this.f4210c < T) {
                    this.f4209b = eVar2;
                    this.f4210c = T;
                    this.f4219l = T;
                }
            }
        }
    }

    public final void f(int i5, d dVar, d dVar2, d dVar3, d dVar4, int i6, int i7, int i8, int i9, int i10) {
        this.f4208a = i5;
        this.f4211d = dVar;
        this.f4212e = dVar2;
        this.f4213f = dVar3;
        this.f4214g = dVar4;
        this.f4215h = i6;
        this.f4216i = i7;
        this.f4217j = i8;
        this.f4218k = i9;
        this.f4223q = i10;
    }
}
