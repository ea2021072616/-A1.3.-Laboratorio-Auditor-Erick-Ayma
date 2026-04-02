package e1;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.o1;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends o1 {
    @Override // androidx.fragment.app.o1
    public final void a(View view, Object obj) {
        ((r) obj).b(view);
    }

    @Override // androidx.fragment.app.o1
    public final void b(Object obj, ArrayList arrayList) {
        r rVar = (r) obj;
        if (rVar == null) {
            return;
        }
        int i5 = 0;
        if (rVar instanceof x) {
            x xVar = (x) rVar;
            int size = xVar.C.size();
            while (i5 < size) {
                b((i5 < 0 || i5 >= xVar.C.size()) ? null : (r) xVar.C.get(i5), arrayList);
                i5++;
            }
            return;
        }
        if (((o1.h(rVar.f2655f) && o1.h(null) && o1.h(null)) ? false : true) || !o1.h(rVar.f2656g)) {
            return;
        }
        int size2 = arrayList.size();
        while (i5 < size2) {
            rVar.b((View) arrayList.get(i5));
            i5++;
        }
    }

    @Override // androidx.fragment.app.o1
    public final void c(ViewGroup viewGroup, Object obj) {
        v.a(viewGroup, (r) obj);
    }

    @Override // androidx.fragment.app.o1
    public final boolean e(Object obj) {
        return obj instanceof r;
    }

    @Override // androidx.fragment.app.o1
    public final Object f(Object obj) {
        if (obj != null) {
            return ((r) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.o1
    public final Object i(Object obj, Object obj2, Object obj3) {
        r rVar = (r) obj;
        r rVar2 = (r) obj2;
        r rVar3 = (r) obj3;
        if (rVar != null && rVar2 != null) {
            x xVar = new x();
            xVar.L(rVar);
            xVar.L(rVar2);
            xVar.D = false;
            rVar = xVar;
        } else if (rVar == null) {
            rVar = rVar2 != null ? rVar2 : null;
        }
        if (rVar3 != null) {
            x xVar2 = new x();
            if (rVar != null) {
                xVar2.L(rVar);
            }
            xVar2.L(rVar3);
            return xVar2;
        }
        return rVar;
    }

    @Override // androidx.fragment.app.o1
    public final Object j(Object obj, Object obj2) {
        x xVar = new x();
        if (obj != null) {
            xVar.L((r) obj);
        }
        xVar.L((r) obj2);
        return xVar;
    }

    @Override // androidx.fragment.app.o1
    public final void k(Object obj, View view, ArrayList arrayList) {
        ((r) obj).a(new i(view, arrayList));
    }

    @Override // androidx.fragment.app.o1
    public final void l(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2) {
        ((r) obj).a(new j(this, obj2, arrayList, obj3, arrayList2));
    }

    @Override // androidx.fragment.app.o1
    public final void m(View view, Object obj) {
        if (view != null) {
            o1.g(new Rect(), view);
            ((r) obj).E(new androidx.biometric.u());
        }
    }

    @Override // androidx.fragment.app.o1
    public final void n(Object obj, Rect rect) {
        ((r) obj).E(new androidx.biometric.u());
    }

    @Override // androidx.fragment.app.o1
    public final void o(Object obj, d0.c cVar, e0.a aVar) {
        r rVar = (r) obj;
        cVar.b(new h(rVar, aVar));
        rVar.a(new k(aVar));
    }

    @Override // androidx.fragment.app.o1
    public final void p(Object obj, View view, ArrayList arrayList) {
        x xVar = (x) obj;
        ArrayList arrayList2 = xVar.f2656g;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            o1.d((View) arrayList.get(i5), arrayList2);
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(xVar, arrayList);
    }

    @Override // androidx.fragment.app.o1
    public final void q(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        x xVar = (x) obj;
        if (xVar != null) {
            ArrayList arrayList3 = xVar.f2656g;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            s(xVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.o1
    public final Object r(Object obj) {
        if (obj == null) {
            return null;
        }
        x xVar = new x();
        xVar.L((r) obj);
        return xVar;
    }

    public final void s(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        r rVar = (r) obj;
        int i5 = 0;
        if (rVar instanceof x) {
            x xVar = (x) rVar;
            int size = xVar.C.size();
            while (i5 < size) {
                s((i5 < 0 || i5 >= xVar.C.size()) ? null : (r) xVar.C.get(i5), arrayList, arrayList2);
                i5++;
            }
            return;
        }
        if ((o1.h(rVar.f2655f) && o1.h(null) && o1.h(null)) ? false : true) {
            return;
        }
        ArrayList arrayList3 = rVar.f2656g;
        if (arrayList3.size() != arrayList.size() || !arrayList3.containsAll(arrayList)) {
            return;
        }
        int size2 = arrayList2 == null ? 0 : arrayList2.size();
        while (i5 < size2) {
            rVar.b((View) arrayList2.get(i5));
            i5++;
        }
        int size3 = arrayList.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                return;
            }
            rVar.A((View) arrayList.get(size3));
        }
    }
}
