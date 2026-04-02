package p;

import com.google.android.gms.internal.play_billing.i0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import q.m;
import q.o;
/* loaded from: classes.dex */
public final class f extends l {

    /* renamed from: t0  reason: collision with root package name */
    public int f4201t0;

    /* renamed from: x0  reason: collision with root package name */
    public int f4205x0;

    /* renamed from: y0  reason: collision with root package name */
    public int f4206y0;

    /* renamed from: r0  reason: collision with root package name */
    public final d.e f4199r0 = new d.e(this);

    /* renamed from: s0  reason: collision with root package name */
    public final q.e f4200s0 = new q.e(this);

    /* renamed from: u0  reason: collision with root package name */
    public m f4202u0 = null;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f4203v0 = false;

    /* renamed from: w0  reason: collision with root package name */
    public final n.d f4204w0 = new n.d();

    /* renamed from: z0  reason: collision with root package name */
    public int f4207z0 = 0;
    public int A0 = 0;
    public b[] B0 = new b[4];
    public b[] C0 = new b[4];
    public int D0 = 257;
    public boolean E0 = false;
    public boolean F0 = false;
    public WeakReference G0 = null;
    public WeakReference H0 = null;
    public WeakReference I0 = null;
    public WeakReference J0 = null;
    public final HashSet K0 = new HashSet();
    public final q.b L0 = new q.b();

    public static void V(e eVar, m mVar, q.b bVar) {
        int i5;
        int i6;
        if (mVar == null) {
            return;
        }
        if (eVar.f4171g0 == 8 || (eVar instanceof i) || (eVar instanceof a)) {
            bVar.f4369e = 0;
            bVar.f4370f = 0;
            return;
        }
        int[] iArr = eVar.f4188p0;
        bVar.f4365a = iArr[0];
        bVar.f4366b = iArr[1];
        bVar.f4367c = eVar.r();
        bVar.f4368d = eVar.l();
        bVar.f4373i = false;
        bVar.f4374j = 0;
        boolean z4 = bVar.f4365a == 3;
        boolean z5 = bVar.f4366b == 3;
        boolean z6 = z4 && eVar.W > 0.0f;
        boolean z7 = z5 && eVar.W > 0.0f;
        if (z4 && eVar.u(0) && eVar.f4190r == 0 && !z6) {
            bVar.f4365a = 2;
            if (z5 && eVar.f4191s == 0) {
                bVar.f4365a = 1;
            }
            z4 = false;
        }
        if (z5 && eVar.u(1) && eVar.f4191s == 0 && !z7) {
            bVar.f4366b = 2;
            if (z4 && eVar.f4190r == 0) {
                bVar.f4366b = 1;
            }
            z5 = false;
        }
        if (eVar.B()) {
            bVar.f4365a = 1;
            z4 = false;
        }
        if (eVar.C()) {
            bVar.f4366b = 1;
            z5 = false;
        }
        int[] iArr2 = eVar.f4192t;
        if (z6) {
            if (iArr2[0] == 4) {
                bVar.f4365a = 1;
            } else if (!z5) {
                if (bVar.f4366b == 1) {
                    i6 = bVar.f4368d;
                } else {
                    bVar.f4365a = 2;
                    mVar.b(eVar, bVar);
                    i6 = bVar.f4370f;
                }
                bVar.f4365a = 1;
                bVar.f4367c = (int) (eVar.W * i6);
            }
        }
        if (z7) {
            if (iArr2[1] == 4) {
                bVar.f4366b = 1;
            } else if (!z4) {
                if (bVar.f4365a == 1) {
                    i5 = bVar.f4367c;
                } else {
                    bVar.f4366b = 2;
                    mVar.b(eVar, bVar);
                    i5 = bVar.f4369e;
                }
                bVar.f4366b = 1;
                if (eVar.X == -1) {
                    bVar.f4368d = (int) (i5 / eVar.W);
                } else {
                    bVar.f4368d = (int) (eVar.W * i5);
                }
            }
        }
        mVar.b(eVar, bVar);
        eVar.O(bVar.f4369e);
        eVar.L(bVar.f4370f);
        eVar.E = bVar.f4372h;
        int i7 = bVar.f4371g;
        eVar.f4159a0 = i7;
        eVar.E = i7 > 0;
        bVar.f4374j = 0;
    }

    @Override // p.l, p.e
    public final void D() {
        this.f4204w0.t();
        this.f4205x0 = 0;
        this.f4206y0 = 0;
        super.D();
    }

    @Override // p.e
    public final void P(boolean z4, boolean z5) {
        super.P(z4, z5);
        int size = this.f4243q0.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((e) this.f4243q0.get(i5)).P(z4, z5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:351:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0606 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x060e  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0631  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x064e  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x066d  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0683 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x06bf  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x07ac  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x07f3  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0810 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:499:0x081c A[LOOP:14: B:498:0x081a->B:499:0x081c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:511:0x0882  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x088e  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x08a1  */
    /* JADX WARN: Removed duplicated region for block: B:516:0x08aa  */
    /* JADX WARN: Removed duplicated region for block: B:518:0x08ae  */
    /* JADX WARN: Removed duplicated region for block: B:530:0x08df  */
    /* JADX WARN: Removed duplicated region for block: B:533:0x08e7  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x08f4  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x08e8 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // p.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R() {
        /*
            Method dump skipped, instructions count: 2304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.f.R():void");
    }

    public final void S(int i5, e eVar) {
        if (i5 == 0) {
            int i6 = this.f4207z0 + 1;
            b[] bVarArr = this.C0;
            if (i6 >= bVarArr.length) {
                this.C0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.C0;
            int i7 = this.f4207z0;
            bVarArr2[i7] = new b(eVar, 0, this.f4203v0);
            this.f4207z0 = i7 + 1;
        } else if (i5 == 1) {
            int i8 = this.A0 + 1;
            b[] bVarArr3 = this.B0;
            if (i8 >= bVarArr3.length) {
                this.B0 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length * 2);
            }
            b[] bVarArr4 = this.B0;
            int i9 = this.A0;
            bVarArr4[i9] = new b(eVar, 1, this.f4203v0);
            this.A0 = i9 + 1;
        }
    }

    public final void T(n.d dVar) {
        boolean z4;
        boolean W = W(64);
        c(dVar, W);
        int size = this.f4243q0.size();
        boolean z5 = false;
        for (int i5 = 0; i5 < size; i5++) {
            e eVar = (e) this.f4243q0.get(i5);
            boolean[] zArr = eVar.S;
            zArr[0] = false;
            zArr[1] = false;
            if (eVar instanceof a) {
                z5 = true;
            }
        }
        if (z5) {
            for (int i6 = 0; i6 < size; i6++) {
                e eVar2 = (e) this.f4243q0.get(i6);
                if (eVar2 instanceof a) {
                    a aVar = (a) eVar2;
                    for (int i7 = 0; i7 < aVar.f4242r0; i7++) {
                        e eVar3 = aVar.f4241q0[i7];
                        if (aVar.f4121t0 || eVar3.d()) {
                            int i8 = aVar.f4120s0;
                            if (i8 == 0 || i8 == 1) {
                                eVar3.S[0] = true;
                            } else if (i8 == 2 || i8 == 3) {
                                eVar3.S[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.K0;
        hashSet.clear();
        for (int i9 = 0; i9 < size; i9++) {
            e eVar4 = (e) this.f4243q0.get(i9);
            eVar4.getClass();
            if ((eVar4 instanceof h) || (eVar4 instanceof i)) {
                if (eVar4 instanceof h) {
                    hashSet.add(eVar4);
                } else {
                    eVar4.c(dVar, W);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h hVar = (h) ((e) it.next());
                int i10 = 0;
                while (true) {
                    if (i10 >= hVar.f4242r0) {
                        z4 = false;
                        continue;
                        break;
                    } else if (hashSet.contains(hVar.f4241q0[i10])) {
                        z4 = true;
                        continue;
                        break;
                    } else {
                        i10++;
                    }
                }
                if (z4) {
                    hVar.c(dVar, W);
                    hashSet.remove(hVar);
                    break;
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).c(dVar, W);
                }
                hashSet.clear();
            }
        }
        if (n.d.f4008p) {
            HashSet hashSet2 = new HashSet();
            for (int i11 = 0; i11 < size; i11++) {
                e eVar5 = (e) this.f4243q0.get(i11);
                eVar5.getClass();
                if (!((eVar5 instanceof h) || (eVar5 instanceof i))) {
                    hashSet2.add(eVar5);
                }
            }
            b(this, dVar, hashSet2, this.f4188p0[0] == 2 ? 0 : 1, false);
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                e eVar6 = (e) it3.next();
                i0.h(this, dVar, eVar6);
                eVar6.c(dVar, W);
            }
        } else {
            for (int i12 = 0; i12 < size; i12++) {
                e eVar7 = (e) this.f4243q0.get(i12);
                if (eVar7 instanceof f) {
                    int[] iArr = eVar7.f4188p0;
                    int i13 = iArr[0];
                    int i14 = iArr[1];
                    if (i13 == 2) {
                        eVar7.M(1);
                    }
                    if (i14 == 2) {
                        eVar7.N(1);
                    }
                    eVar7.c(dVar, W);
                    if (i13 == 2) {
                        eVar7.M(i13);
                    }
                    if (i14 == 2) {
                        eVar7.N(i14);
                    }
                } else {
                    i0.h(this, dVar, eVar7);
                    if (!((eVar7 instanceof h) || (eVar7 instanceof i))) {
                        eVar7.c(dVar, W);
                    }
                }
            }
        }
        if (this.f4207z0 > 0) {
            p2.a.a(this, dVar, null, 0);
        }
        if (this.A0 > 0) {
            p2.a.a(this, dVar, null, 1);
        }
    }

    public final boolean U(int i5, boolean z4) {
        boolean z5;
        boolean z6 = true;
        boolean z7 = z4 & true;
        q.e eVar = this.f4200s0;
        f fVar = eVar.f4377a;
        int k5 = fVar.k(0);
        int k6 = fVar.k(1);
        int s5 = fVar.s();
        int t5 = fVar.t();
        ArrayList arrayList = eVar.f4381e;
        if (z7 && (k5 == 2 || k6 == 2)) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o oVar = (o) it.next();
                if (oVar.f4422f == i5 && !oVar.k()) {
                    z7 = false;
                    break;
                }
            }
            if (i5 == 0) {
                if (z7 && k5 == 2) {
                    fVar.M(1);
                    fVar.O(eVar.d(fVar, 0));
                    fVar.f4164d.f4421e.d(fVar.r());
                }
            } else if (z7 && k6 == 2) {
                fVar.N(1);
                fVar.L(eVar.d(fVar, 1));
                fVar.f4166e.f4421e.d(fVar.l());
            }
        }
        int[] iArr = fVar.f4188p0;
        if (i5 == 0) {
            int i6 = iArr[0];
            if (i6 == 1 || i6 == 4) {
                int r5 = fVar.r() + s5;
                fVar.f4164d.f4425i.d(r5);
                fVar.f4164d.f4421e.d(r5 - s5);
                z5 = true;
            }
            z5 = false;
        } else {
            int i7 = iArr[1];
            if (i7 == 1 || i7 == 4) {
                int l5 = fVar.l() + t5;
                fVar.f4166e.f4425i.d(l5);
                fVar.f4166e.f4421e.d(l5 - t5);
                z5 = true;
            }
            z5 = false;
        }
        eVar.g();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            o oVar2 = (o) it2.next();
            if (oVar2.f4422f == i5 && (oVar2.f4418b != fVar || oVar2.f4423g)) {
                oVar2.e();
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            o oVar3 = (o) it3.next();
            if (oVar3.f4422f == i5 && (z5 || oVar3.f4418b != fVar)) {
                if (!oVar3.f4424h.f4394j || !oVar3.f4425i.f4394j || (!(oVar3 instanceof q.c) && !oVar3.f4421e.f4394j)) {
                    z6 = false;
                    break;
                }
            }
        }
        fVar.M(k5);
        fVar.N(k6);
        return z6;
    }

    public final boolean W(int i5) {
        return (this.D0 & i5) == i5;
    }

    @Override // p.e
    public final void o(StringBuilder sb) {
        sb.append(this.f4176j + ":{\n");
        StringBuilder sb2 = new StringBuilder("  actualWidth:");
        sb2.append(this.U);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("  actualHeight:" + this.V);
        sb.append("\n");
        Iterator it = this.f4243q0.iterator();
        while (it.hasNext()) {
            ((e) it.next()).o(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }
}
