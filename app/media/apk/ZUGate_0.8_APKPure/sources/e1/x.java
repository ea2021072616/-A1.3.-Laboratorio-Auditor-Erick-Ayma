package e1;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class x extends r {
    public int E;
    public ArrayList C = new ArrayList();
    public boolean D = true;
    public boolean F = false;
    public int G = 0;

    @Override // e1.r
    public final void A(View view) {
        for (int i5 = 0; i5 < this.C.size(); i5++) {
            ((r) this.C.get(i5)).A(view);
        }
        this.f2656g.remove(view);
    }

    @Override // e1.r
    public final void B(ViewGroup viewGroup) {
        super.B(viewGroup);
        int size = this.C.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((r) this.C.get(i5)).B(viewGroup);
        }
    }

    @Override // e1.r
    public final void C() {
        if (this.C.isEmpty()) {
            J();
            n();
            return;
        }
        w wVar = new w(this, 1);
        Iterator it = this.C.iterator();
        while (it.hasNext()) {
            ((r) it.next()).a(wVar);
        }
        this.E = this.C.size();
        if (this.D) {
            Iterator it2 = this.C.iterator();
            while (it2.hasNext()) {
                ((r) it2.next()).C();
            }
            return;
        }
        for (int i5 = 1; i5 < this.C.size(); i5++) {
            ((r) this.C.get(i5 - 1)).a(new t(this, 1, (r) this.C.get(i5)));
        }
        r rVar = (r) this.C.get(0);
        if (rVar != null) {
            rVar.C();
        }
    }

    @Override // e1.r
    public final void D(long j5) {
        ArrayList arrayList;
        this.f2653d = j5;
        if (j5 < 0 || (arrayList = this.C) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((r) this.C.get(i5)).D(j5);
        }
    }

    @Override // e1.r
    public final void E(p2.a aVar) {
        this.f2671w = aVar;
        this.G |= 8;
        int size = this.C.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((r) this.C.get(i5)).E(aVar);
        }
    }

    @Override // e1.r
    public final void F(TimeInterpolator timeInterpolator) {
        this.G |= 1;
        ArrayList arrayList = this.C;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((r) this.C.get(i5)).F(timeInterpolator);
            }
        }
        this.f2654e = timeInterpolator;
    }

    @Override // e1.r
    public final void G(z0.d dVar) {
        super.G(dVar);
        this.G |= 4;
        if (this.C != null) {
            for (int i5 = 0; i5 < this.C.size(); i5++) {
                ((r) this.C.get(i5)).G(dVar);
            }
        }
    }

    @Override // e1.r
    public final void H() {
        this.G |= 2;
        int size = this.C.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((r) this.C.get(i5)).H();
        }
    }

    @Override // e1.r
    public final void I(long j5) {
        this.f2652c = j5;
    }

    @Override // e1.r
    public final String K(String str) {
        String K = super.K(str);
        for (int i5 = 0; i5 < this.C.size(); i5++) {
            StringBuilder sb = new StringBuilder();
            sb.append(K);
            sb.append("\n");
            sb.append(((r) this.C.get(i5)).K(str + "  "));
            K = sb.toString();
        }
        return K;
    }

    public final void L(r rVar) {
        this.C.add(rVar);
        rVar.f2659j = this;
        long j5 = this.f2653d;
        if (j5 >= 0) {
            rVar.D(j5);
        }
        if ((this.G & 1) != 0) {
            rVar.F(this.f2654e);
        }
        if ((this.G & 2) != 0) {
            rVar.H();
        }
        if ((this.G & 4) != 0) {
            rVar.G(this.f2672x);
        }
        if ((this.G & 8) != 0) {
            rVar.E(this.f2671w);
        }
    }

    @Override // e1.r
    public final void a(p pVar) {
        super.a(pVar);
    }

    @Override // e1.r
    public final void b(View view) {
        for (int i5 = 0; i5 < this.C.size(); i5++) {
            ((r) this.C.get(i5)).b(view);
        }
        this.f2656g.add(view);
    }

    @Override // e1.r
    public final void d() {
        super.d();
        int size = this.C.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((r) this.C.get(i5)).d();
        }
    }

    @Override // e1.r
    public final void e(a0 a0Var) {
        View view = a0Var.f2586b;
        if (v(view)) {
            Iterator it = this.C.iterator();
            while (it.hasNext()) {
                r rVar = (r) it.next();
                if (rVar.v(view)) {
                    rVar.e(a0Var);
                    a0Var.f2587c.add(rVar);
                }
            }
        }
    }

    @Override // e1.r
    public final void g(a0 a0Var) {
        int size = this.C.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((r) this.C.get(i5)).g(a0Var);
        }
    }

    @Override // e1.r
    public final void h(a0 a0Var) {
        View view = a0Var.f2586b;
        if (v(view)) {
            Iterator it = this.C.iterator();
            while (it.hasNext()) {
                r rVar = (r) it.next();
                if (rVar.v(view)) {
                    rVar.h(a0Var);
                    a0Var.f2587c.add(rVar);
                }
            }
        }
    }

    @Override // e1.r
    /* renamed from: k */
    public final r clone() {
        x xVar = (x) super.clone();
        xVar.C = new ArrayList();
        int size = this.C.size();
        for (int i5 = 0; i5 < size; i5++) {
            r clone = ((r) this.C.get(i5)).clone();
            xVar.C.add(clone);
            clone.f2659j = xVar;
        }
        return xVar;
    }

    @Override // e1.r
    public final void m(ViewGroup viewGroup, g.f fVar, g.f fVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j5 = this.f2652c;
        int size = this.C.size();
        for (int i5 = 0; i5 < size; i5++) {
            r rVar = (r) this.C.get(i5);
            if (j5 > 0 && (this.D || i5 == 0)) {
                long j6 = rVar.f2652c;
                if (j6 > 0) {
                    rVar.I(j6 + j5);
                } else {
                    rVar.I(j5);
                }
            }
            rVar.m(viewGroup, fVar, fVar2, arrayList, arrayList2);
        }
    }

    @Override // e1.r
    public final boolean t() {
        for (int i5 = 0; i5 < this.C.size(); i5++) {
            if (((r) this.C.get(i5)).t()) {
                return true;
            }
        }
        return false;
    }

    @Override // e1.r
    public final void y(View view) {
        super.y(view);
        int size = this.C.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((r) this.C.get(i5)).y(view);
        }
    }

    @Override // e1.r
    public final r z(p pVar) {
        super.z(pVar);
        return this;
    }
}
