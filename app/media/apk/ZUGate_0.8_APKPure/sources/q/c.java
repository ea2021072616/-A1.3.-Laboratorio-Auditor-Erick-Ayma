package q;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class c extends o {

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f4375k;

    /* renamed from: l  reason: collision with root package name */
    public int f4376l;

    public c(int i5, p.e eVar) {
        super(eVar);
        this.f4375k = new ArrayList();
        this.f4422f = i5;
        p.e eVar2 = this.f4418b;
        p.e n5 = eVar2.n(i5);
        while (n5 != null) {
            eVar2 = n5;
            n5 = n5.n(this.f4422f);
        }
        this.f4418b = eVar2;
        int i6 = this.f4422f;
        o oVar = i6 == 0 ? eVar2.f4164d : i6 == 1 ? eVar2.f4166e : null;
        ArrayList arrayList = this.f4375k;
        arrayList.add(oVar);
        p.e m5 = eVar2.m(this.f4422f);
        while (m5 != null) {
            int i7 = this.f4422f;
            arrayList.add(i7 == 0 ? m5.f4164d : i7 == 1 ? m5.f4166e : null);
            m5 = m5.m(this.f4422f);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            o oVar2 = (o) it.next();
            int i8 = this.f4422f;
            if (i8 == 0) {
                oVar2.f4418b.f4160b = this;
            } else if (i8 == 1) {
                oVar2.f4418b.f4162c = this;
            }
        }
        if ((this.f4422f == 0 && ((p.f) this.f4418b.T).f4203v0) && arrayList.size() > 1) {
            this.f4418b = ((o) arrayList.get(arrayList.size() - 1)).f4418b;
        }
        this.f4376l = this.f4422f == 0 ? this.f4418b.f4175i0 : this.f4418b.f4177j0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:271:0x03a5, code lost:
        r2 = r2 - r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00da  */
    @Override // q.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(q.d r27) {
        /*
            Method dump skipped, instructions count: 964
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.c.a(q.d):void");
    }

    @Override // q.o
    public final void d() {
        ArrayList arrayList = this.f4375k;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((o) it.next()).d();
        }
        int size = arrayList.size();
        if (size < 1) {
            return;
        }
        p.e eVar = ((o) arrayList.get(0)).f4418b;
        p.e eVar2 = ((o) arrayList.get(size - 1)).f4418b;
        int i5 = this.f4422f;
        f fVar = this.f4425i;
        f fVar2 = this.f4424h;
        if (i5 == 0) {
            p.d dVar = eVar.I;
            p.d dVar2 = eVar2.K;
            f i6 = o.i(dVar, 0);
            int e5 = dVar.e();
            p.e m5 = m();
            if (m5 != null) {
                e5 = m5.I.e();
            }
            if (i6 != null) {
                o.b(fVar2, i6, e5);
            }
            f i7 = o.i(dVar2, 0);
            int e6 = dVar2.e();
            p.e n5 = n();
            if (n5 != null) {
                e6 = n5.K.e();
            }
            if (i7 != null) {
                o.b(fVar, i7, -e6);
            }
        } else {
            p.d dVar3 = eVar.J;
            p.d dVar4 = eVar2.L;
            f i8 = o.i(dVar3, 1);
            int e7 = dVar3.e();
            p.e m6 = m();
            if (m6 != null) {
                e7 = m6.J.e();
            }
            if (i8 != null) {
                o.b(fVar2, i8, e7);
            }
            f i9 = o.i(dVar4, 1);
            int e8 = dVar4.e();
            p.e n6 = n();
            if (n6 != null) {
                e8 = n6.L.e();
            }
            if (i9 != null) {
                o.b(fVar, i9, -e8);
            }
        }
        fVar2.f4385a = this;
        fVar.f4385a = this;
    }

    @Override // q.o
    public final void e() {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f4375k;
            if (i5 >= arrayList.size()) {
                return;
            }
            ((o) arrayList.get(i5)).e();
            i5++;
        }
    }

    @Override // q.o
    public final void f() {
        this.f4419c = null;
        Iterator it = this.f4375k.iterator();
        while (it.hasNext()) {
            ((o) it.next()).f();
        }
    }

    @Override // q.o
    public final long j() {
        ArrayList arrayList = this.f4375k;
        int size = arrayList.size();
        long j5 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            o oVar = (o) arrayList.get(i5);
            j5 = oVar.f4425i.f4390f + oVar.j() + j5 + oVar.f4424h.f4390f;
        }
        return j5;
    }

    @Override // q.o
    public final boolean k() {
        ArrayList arrayList = this.f4375k;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!((o) arrayList.get(i5)).k()) {
                return false;
            }
        }
        return true;
    }

    public final p.e m() {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f4375k;
            if (i5 >= arrayList.size()) {
                return null;
            }
            p.e eVar = ((o) arrayList.get(i5)).f4418b;
            if (eVar.f4171g0 != 8) {
                return eVar;
            }
            i5++;
        }
    }

    public final p.e n() {
        ArrayList arrayList = this.f4375k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            p.e eVar = ((o) arrayList.get(size)).f4418b;
            if (eVar.f4171g0 != 8) {
                return eVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f4422f == 0 ? "horizontal : " : "vertical : ");
        Iterator it = this.f4375k.iterator();
        while (it.hasNext()) {
            sb.append("<");
            sb.append((o) it.next());
            sb.append("> ");
        }
        return sb.toString();
    }
}
