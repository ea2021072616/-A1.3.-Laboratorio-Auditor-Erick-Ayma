package q;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final p.f f4377a;

    /* renamed from: d  reason: collision with root package name */
    public final p.f f4380d;

    /* renamed from: f  reason: collision with root package name */
    public m f4382f;

    /* renamed from: g  reason: collision with root package name */
    public final b f4383g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f4384h;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4378b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4379c = true;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f4381e = new ArrayList();

    public e(p.f fVar) {
        new ArrayList();
        this.f4382f = null;
        this.f4383g = new b();
        this.f4384h = new ArrayList();
        this.f4377a = fVar;
        this.f4380d = fVar;
    }

    public final void a(f fVar, int i5, int i6, ArrayList arrayList, k kVar) {
        o oVar = fVar.f4388d;
        if (oVar.f4419c == null) {
            p.f fVar2 = this.f4377a;
            if (oVar == fVar2.f4164d || oVar == fVar2.f4166e) {
                return;
            }
            if (kVar == null) {
                kVar = new k(oVar);
                arrayList.add(kVar);
            }
            oVar.f4419c = kVar;
            kVar.f4400b.add(oVar);
            f fVar3 = oVar.f4424h;
            Iterator it = fVar3.f4395k.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar instanceof f) {
                    a((f) dVar, i5, 0, arrayList, kVar);
                }
            }
            f fVar4 = oVar.f4425i;
            Iterator it2 = fVar4.f4395k.iterator();
            while (it2.hasNext()) {
                d dVar2 = (d) it2.next();
                if (dVar2 instanceof f) {
                    a((f) dVar2, i5, 1, arrayList, kVar);
                }
            }
            if (i5 == 1 && (oVar instanceof l)) {
                Iterator it3 = ((l) oVar).f4401k.f4395k.iterator();
                while (it3.hasNext()) {
                    d dVar3 = (d) it3.next();
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i5, 2, arrayList, kVar);
                    }
                }
            }
            Iterator it4 = fVar3.f4396l.iterator();
            while (it4.hasNext()) {
                a((f) it4.next(), i5, 0, arrayList, kVar);
            }
            Iterator it5 = fVar4.f4396l.iterator();
            while (it5.hasNext()) {
                a((f) it5.next(), i5, 1, arrayList, kVar);
            }
            if (i5 == 1 && (oVar instanceof l)) {
                Iterator it6 = ((l) oVar).f4401k.f4396l.iterator();
                while (it6.hasNext()) {
                    a((f) it6.next(), i5, 2, arrayList, kVar);
                }
            }
        }
    }

    public final void b(p.f fVar) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Iterator it = fVar.f4243q0.iterator();
        while (it.hasNext()) {
            p.e eVar = (p.e) it.next();
            int[] iArr = eVar.f4188p0;
            int i10 = iArr[0];
            int i11 = iArr[1];
            if (eVar.f4171g0 == 8) {
                eVar.f4158a = true;
            } else {
                float f5 = eVar.f4195w;
                if (f5 < 1.0f && i10 == 3) {
                    eVar.f4190r = 2;
                }
                float f6 = eVar.f4198z;
                if (f6 < 1.0f && i11 == 3) {
                    eVar.f4191s = 2;
                }
                if (eVar.W > 0.0f) {
                    if (i10 == 3 && (i11 == 2 || i11 == 1)) {
                        eVar.f4190r = 3;
                    } else if (i11 == 3 && (i10 == 2 || i10 == 1)) {
                        eVar.f4191s = 3;
                    } else if (i10 == 3 && i11 == 3) {
                        if (eVar.f4190r == 0) {
                            eVar.f4190r = 3;
                        }
                        if (eVar.f4191s == 0) {
                            eVar.f4191s = 3;
                        }
                    }
                }
                p.d dVar = eVar.K;
                p.d dVar2 = eVar.I;
                if (i10 == 3 && eVar.f4190r == 1 && (dVar2.f4154f == null || dVar.f4154f == null)) {
                    i10 = 2;
                }
                p.d dVar3 = eVar.L;
                p.d dVar4 = eVar.J;
                int i12 = (i11 == 3 && eVar.f4191s == 1 && (dVar4.f4154f == null || dVar3.f4154f == null)) ? 2 : i11;
                j jVar = eVar.f4164d;
                jVar.f4420d = i10;
                int i13 = eVar.f4190r;
                jVar.f4417a = i13;
                l lVar = eVar.f4166e;
                lVar.f4420d = i12;
                int i14 = eVar.f4191s;
                lVar.f4417a = i14;
                if ((i10 == 4 || i10 == 1 || i10 == 2) && (i12 == 4 || i12 == 1 || i12 == 2)) {
                    int r5 = eVar.r();
                    if (i10 == 4) {
                        i5 = (fVar.r() - dVar2.f4155g) - dVar.f4155g;
                        i10 = 1;
                    } else {
                        i5 = r5;
                    }
                    int l5 = eVar.l();
                    if (i12 == 4) {
                        i6 = (fVar.l() - dVar4.f4155g) - dVar3.f4155g;
                        i7 = 1;
                    } else {
                        i6 = l5;
                        i7 = i12;
                    }
                    f(eVar, i10, i5, i7, i6);
                    eVar.f4164d.f4421e.d(eVar.r());
                    eVar.f4166e.f4421e.d(eVar.l());
                    eVar.f4158a = true;
                } else {
                    int[] iArr2 = fVar.f4188p0;
                    p.d[] dVarArr = eVar.Q;
                    if (i10 != 3 || (i12 != 2 && i12 != 1)) {
                        i8 = 3;
                    } else if (i13 == 3) {
                        if (i12 == 2) {
                            f(eVar, 2, 0, 2, 0);
                        }
                        int l6 = eVar.l();
                        f(eVar, 1, (int) ((l6 * eVar.W) + 0.5f), 1, l6);
                        eVar.f4164d.f4421e.d(eVar.r());
                        eVar.f4166e.f4421e.d(eVar.l());
                        eVar.f4158a = true;
                    } else if (i13 == 1) {
                        f(eVar, 2, 0, i12, 0);
                        eVar.f4164d.f4421e.f4397m = eVar.r();
                    } else if (i13 == 2) {
                        int i15 = iArr2[0];
                        if (i15 == 1 || i15 == 4) {
                            f(eVar, 1, (int) ((f5 * fVar.r()) + 0.5f), i12, eVar.l());
                            eVar.f4164d.f4421e.d(eVar.r());
                            eVar.f4166e.f4421e.d(eVar.l());
                            eVar.f4158a = true;
                        } else {
                            i8 = 3;
                        }
                    } else if (dVarArr[0].f4154f == null || dVarArr[1].f4154f == null) {
                        f(eVar, 2, 0, i12, 0);
                        eVar.f4164d.f4421e.d(eVar.r());
                        eVar.f4166e.f4421e.d(eVar.l());
                        eVar.f4158a = true;
                    } else {
                        i8 = 3;
                    }
                    if (i12 != i8 || (i10 != 2 && i10 != 1)) {
                        i9 = i8;
                    } else if (i14 == i8) {
                        if (i10 == 2) {
                            f(eVar, 2, 0, 2, 0);
                        }
                        int r6 = eVar.r();
                        float f7 = eVar.W;
                        if (eVar.X == -1) {
                            f7 = 1.0f / f7;
                        }
                        f(eVar, 1, r6, 1, (int) ((r6 * f7) + 0.5f));
                        eVar.f4164d.f4421e.d(eVar.r());
                        eVar.f4166e.f4421e.d(eVar.l());
                        eVar.f4158a = true;
                    } else if (i14 == 1) {
                        f(eVar, i10, 0, 2, 0);
                        eVar.f4166e.f4421e.f4397m = eVar.l();
                    } else if (i14 == 2) {
                        int i16 = iArr2[1];
                        if (i16 == 1 || i16 == 4) {
                            f(eVar, i10, eVar.r(), 1, (int) ((f6 * fVar.l()) + 0.5f));
                            eVar.f4164d.f4421e.d(eVar.r());
                            eVar.f4166e.f4421e.d(eVar.l());
                            eVar.f4158a = true;
                        } else {
                            i9 = 3;
                        }
                    } else if (dVarArr[2].f4154f == null || dVarArr[3].f4154f == null) {
                        f(eVar, 2, 0, i12, 0);
                        eVar.f4164d.f4421e.d(eVar.r());
                        eVar.f4166e.f4421e.d(eVar.l());
                        eVar.f4158a = true;
                    } else {
                        i9 = 3;
                    }
                    if (i10 == i9 && i12 == i9) {
                        if (i13 == 1 || i14 == 1) {
                            f(eVar, 2, 0, 2, 0);
                            eVar.f4164d.f4421e.f4397m = eVar.r();
                            eVar.f4166e.f4421e.f4397m = eVar.l();
                        } else if (i14 == 2 && i13 == 2 && iArr2[0] == 1 && iArr2[1] == 1) {
                            f(eVar, 1, (int) ((f5 * fVar.r()) + 0.5f), 1, (int) ((f6 * fVar.l()) + 0.5f));
                            eVar.f4164d.f4421e.d(eVar.r());
                            eVar.f4166e.f4421e.d(eVar.l());
                            eVar.f4158a = true;
                        }
                    }
                }
            }
        }
    }

    public final void c() {
        ArrayList arrayList = this.f4381e;
        arrayList.clear();
        p.f fVar = this.f4380d;
        fVar.f4164d.f();
        fVar.f4166e.f();
        arrayList.add(fVar.f4164d);
        arrayList.add(fVar.f4166e);
        Iterator it = fVar.f4243q0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            p.e eVar = (p.e) it.next();
            if (eVar instanceof p.i) {
                arrayList.add(new h(eVar));
            } else {
                if (eVar.y()) {
                    if (eVar.f4160b == null) {
                        eVar.f4160b = new c(0, eVar);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f4160b);
                } else {
                    arrayList.add(eVar.f4164d);
                }
                if (eVar.z()) {
                    if (eVar.f4162c == null) {
                        eVar.f4162c = new c(1, eVar);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f4162c);
                } else {
                    arrayList.add(eVar.f4166e);
                }
                if (eVar instanceof p.k) {
                    arrayList.add(new i(eVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((o) it2.next()).f();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            o oVar = (o) it3.next();
            if (oVar.f4418b != fVar) {
                oVar.d();
            }
        }
        ArrayList arrayList2 = this.f4384h;
        arrayList2.clear();
        p.f fVar2 = this.f4377a;
        e(fVar2.f4164d, 0, arrayList2);
        e(fVar2.f4166e, 1, arrayList2);
        this.f4378b = false;
    }

    public final int d(p.f fVar, int i5) {
        int i6;
        long j5;
        long j6;
        ArrayList arrayList;
        long j7;
        float f5;
        p.f fVar2 = fVar;
        ArrayList arrayList2 = this.f4384h;
        int size = arrayList2.size();
        int i7 = 0;
        long j8 = 0;
        while (i7 < size) {
            o oVar = ((k) arrayList2.get(i7)).f4399a;
            if (!(oVar instanceof c) ? !(i5 != 0 ? (oVar instanceof l) : (oVar instanceof j)) : ((c) oVar).f4422f != i5) {
                f fVar3 = (i5 == 0 ? fVar2.f4164d : fVar2.f4166e).f4424h;
                f fVar4 = (i5 == 0 ? fVar2.f4164d : fVar2.f4166e).f4425i;
                boolean contains = oVar.f4424h.f4396l.contains(fVar3);
                f fVar5 = oVar.f4425i;
                boolean contains2 = fVar5.f4396l.contains(fVar4);
                long j9 = oVar.j();
                f fVar6 = oVar.f4424h;
                if (contains && contains2) {
                    long b5 = k.b(fVar6, 0L);
                    ArrayList arrayList3 = arrayList2;
                    i6 = size;
                    long a5 = k.a(fVar5, 0L);
                    long j10 = b5 - j9;
                    int i8 = fVar5.f4390f;
                    j7 = j8;
                    arrayList = arrayList3;
                    if (j10 >= (-i8)) {
                        j10 += i8;
                    }
                    long j11 = fVar6.f4390f;
                    long j12 = ((-a5) - j9) - j11;
                    if (j12 >= j11) {
                        j12 -= j11;
                    }
                    p.e eVar = oVar.f4418b;
                    if (i5 == 0) {
                        f5 = eVar.f4165d0;
                    } else if (i5 == 1) {
                        f5 = eVar.f4167e0;
                    } else {
                        eVar.getClass();
                        f5 = -1.0f;
                    }
                    float f6 = (float) (f5 > 0.0f ? (((float) j10) / (1.0f - f5)) + (((float) j12) / f5) : 0L);
                    j6 = (fVar6.f4390f + ((((f6 * f5) + 0.5f) + j9) + (((1.0f - f5) * f6) + 0.5f))) - fVar5.f4390f;
                } else {
                    i6 = size;
                    j7 = j8;
                    arrayList = arrayList2;
                    j6 = contains ? Math.max(k.b(fVar6, fVar6.f4390f), fVar6.f4390f + j9) : contains2 ? Math.max(-k.a(fVar5, fVar5.f4390f), (-fVar5.f4390f) + j9) : (oVar.j() + fVar6.f4390f) - fVar5.f4390f;
                }
                j5 = j7;
            } else {
                i6 = size;
                j5 = j8;
                j6 = 0;
                arrayList = arrayList2;
            }
            i7++;
            arrayList2 = arrayList;
            size = i6;
            j8 = Math.max(j5, j6);
            fVar2 = fVar;
        }
        return (int) j8;
    }

    public final void e(o oVar, int i5, ArrayList arrayList) {
        f fVar;
        Iterator it = oVar.f4424h.f4395k.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            fVar = oVar.f4425i;
            if (!hasNext) {
                break;
            }
            d dVar = (d) it.next();
            if (dVar instanceof f) {
                a((f) dVar, i5, 0, arrayList, null);
            } else if (dVar instanceof o) {
                a(((o) dVar).f4424h, i5, 0, arrayList, null);
            }
        }
        Iterator it2 = fVar.f4395k.iterator();
        while (it2.hasNext()) {
            d dVar2 = (d) it2.next();
            if (dVar2 instanceof f) {
                a((f) dVar2, i5, 1, arrayList, null);
            } else if (dVar2 instanceof o) {
                a(((o) dVar2).f4425i, i5, 1, arrayList, null);
            }
        }
        if (i5 == 1) {
            Iterator it3 = ((l) oVar).f4401k.f4395k.iterator();
            while (it3.hasNext()) {
                d dVar3 = (d) it3.next();
                if (dVar3 instanceof f) {
                    a((f) dVar3, i5, 2, arrayList, null);
                }
            }
        }
    }

    public final void f(p.e eVar, int i5, int i6, int i7, int i8) {
        b bVar = this.f4383g;
        bVar.f4365a = i5;
        bVar.f4366b = i7;
        bVar.f4367c = i6;
        bVar.f4368d = i8;
        this.f4382f.b(eVar, bVar);
        eVar.O(bVar.f4369e);
        eVar.L(bVar.f4370f);
        eVar.E = bVar.f4372h;
        int i9 = bVar.f4371g;
        eVar.f4159a0 = i9;
        eVar.E = i9 > 0;
    }

    public final void g() {
        a aVar;
        Iterator it = this.f4377a.f4243q0.iterator();
        while (it.hasNext()) {
            p.e eVar = (p.e) it.next();
            if (!eVar.f4158a) {
                int[] iArr = eVar.f4188p0;
                boolean z4 = false;
                int i5 = iArr[0];
                int i6 = iArr[1];
                int i7 = eVar.f4190r;
                int i8 = eVar.f4191s;
                boolean z5 = i5 == 2 || (i5 == 3 && i7 == 1);
                if (i6 == 2 || (i6 == 3 && i8 == 1)) {
                    z4 = true;
                }
                g gVar = eVar.f4164d.f4421e;
                boolean z6 = gVar.f4394j;
                g gVar2 = eVar.f4166e.f4421e;
                boolean z7 = gVar2.f4394j;
                if (z6 && z7) {
                    f(eVar, 1, gVar.f4391g, 1, gVar2.f4391g);
                    eVar.f4158a = true;
                } else if (z6 && z4) {
                    f(eVar, 1, gVar.f4391g, 2, gVar2.f4391g);
                    if (i6 == 3) {
                        eVar.f4166e.f4421e.f4397m = eVar.l();
                    } else {
                        eVar.f4166e.f4421e.d(eVar.l());
                        eVar.f4158a = true;
                    }
                } else if (z7 && z5) {
                    f(eVar, 2, gVar.f4391g, 1, gVar2.f4391g);
                    if (i5 == 3) {
                        eVar.f4164d.f4421e.f4397m = eVar.r();
                    } else {
                        eVar.f4164d.f4421e.d(eVar.r());
                        eVar.f4158a = true;
                    }
                }
                if (eVar.f4158a && (aVar = eVar.f4166e.f4402l) != null) {
                    aVar.d(eVar.f4159a0);
                }
            }
        }
    }
}
