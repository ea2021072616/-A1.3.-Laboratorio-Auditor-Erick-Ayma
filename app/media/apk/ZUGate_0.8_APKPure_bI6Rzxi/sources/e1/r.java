package e1;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import h0.o0;
import h0.z0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class r implements Cloneable {

    /* renamed from: l  reason: collision with root package name */
    public ArrayList f2661l;

    /* renamed from: m  reason: collision with root package name */
    public ArrayList f2662m;

    /* renamed from: n  reason: collision with root package name */
    public p[] f2663n;

    /* renamed from: w  reason: collision with root package name */
    public p2.a f2671w;

    /* renamed from: y  reason: collision with root package name */
    public static final Animator[] f2649y = new Animator[0];

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f2650z = {2, 1, 3, 4};
    public static final z0.d A = new z0.d(5);
    public static final ThreadLocal B = new ThreadLocal();

    /* renamed from: b  reason: collision with root package name */
    public final String f2651b = getClass().getName();

    /* renamed from: c  reason: collision with root package name */
    public long f2652c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f2653d = -1;

    /* renamed from: e  reason: collision with root package name */
    public TimeInterpolator f2654e = null;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList f2655f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f2656g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public g.f f2657h = new g.f(6);

    /* renamed from: i  reason: collision with root package name */
    public g.f f2658i = new g.f(6);

    /* renamed from: j  reason: collision with root package name */
    public x f2659j = null;

    /* renamed from: k  reason: collision with root package name */
    public final int[] f2660k = f2650z;
    public final ArrayList o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public Animator[] f2664p = f2649y;

    /* renamed from: q  reason: collision with root package name */
    public int f2665q = 0;

    /* renamed from: r  reason: collision with root package name */
    public boolean f2666r = false;

    /* renamed from: s  reason: collision with root package name */
    public boolean f2667s = false;

    /* renamed from: t  reason: collision with root package name */
    public r f2668t = null;

    /* renamed from: u  reason: collision with root package name */
    public ArrayList f2669u = null;

    /* renamed from: v  reason: collision with root package name */
    public ArrayList f2670v = new ArrayList();

    /* renamed from: x  reason: collision with root package name */
    public z0.d f2672x = A;

    public static void c(g.f fVar, View view, a0 a0Var) {
        ((l.b) fVar.f2877a).put(view, a0Var);
        int id = view.getId();
        if (id >= 0) {
            SparseArray sparseArray = (SparseArray) fVar.f2878b;
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = z0.f3233a;
        String k5 = o0.k(view);
        if (k5 != null) {
            if (((l.b) fVar.f2880d).containsKey(k5)) {
                ((l.b) fVar.f2880d).put(k5, null);
            } else {
                ((l.b) fVar.f2880d).put(k5, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                l.d dVar = (l.d) fVar.f2879c;
                if (dVar.f3677b) {
                    dVar.c();
                }
                if (b4.j.c(dVar.f3678c, dVar.f3680e, itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    ((l.d) fVar.f2879c).e(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) ((l.d) fVar.f2879c).d(itemIdAtPosition, null);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    ((l.d) fVar.f2879c).e(itemIdAtPosition, null);
                }
            }
        }
    }

    public static l.b q() {
        ThreadLocal threadLocal = B;
        l.b bVar = (l.b) threadLocal.get();
        if (bVar == null) {
            l.b bVar2 = new l.b();
            threadLocal.set(bVar2);
            return bVar2;
        }
        return bVar;
    }

    public static boolean w(a0 a0Var, a0 a0Var2, String str) {
        Object obj = a0Var.f2585a.get(str);
        Object obj2 = a0Var2.f2585a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(View view) {
        this.f2656g.remove(view);
    }

    public void B(ViewGroup viewGroup) {
        if (this.f2666r) {
            if (!this.f2667s) {
                ArrayList arrayList = this.o;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f2664p);
                this.f2664p = f2649y;
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    Animator animator = animatorArr[size];
                    animatorArr[size] = null;
                    animator.resume();
                }
                this.f2664p = animatorArr;
                x(this, q.f2648e);
            }
            this.f2666r = false;
        }
    }

    public void C() {
        J();
        l.b q5 = q();
        Iterator it = this.f2670v.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (q5.containsKey(animator)) {
                J();
                if (animator != null) {
                    animator.addListener(new n(this, q5));
                    long j5 = this.f2653d;
                    if (j5 >= 0) {
                        animator.setDuration(j5);
                    }
                    long j6 = this.f2652c;
                    if (j6 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j6);
                    }
                    TimeInterpolator timeInterpolator = this.f2654e;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new androidx.appcompat.widget.d(1, this));
                    animator.start();
                }
            }
        }
        this.f2670v.clear();
        n();
    }

    public void D(long j5) {
        this.f2653d = j5;
    }

    public void E(p2.a aVar) {
        this.f2671w = aVar;
    }

    public void F(TimeInterpolator timeInterpolator) {
        this.f2654e = timeInterpolator;
    }

    public void G(z0.d dVar) {
        if (dVar == null) {
            this.f2672x = A;
        } else {
            this.f2672x = dVar;
        }
    }

    public void H() {
    }

    public void I(long j5) {
        this.f2652c = j5;
    }

    public final void J() {
        if (this.f2665q == 0) {
            x(this, q.f2644a);
            this.f2667s = false;
        }
        this.f2665q++;
    }

    public String K(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.f2653d != -1) {
            sb.append("dur(");
            sb.append(this.f2653d);
            sb.append(") ");
        }
        if (this.f2652c != -1) {
            sb.append("dly(");
            sb.append(this.f2652c);
            sb.append(") ");
        }
        if (this.f2654e != null) {
            sb.append("interp(");
            sb.append(this.f2654e);
            sb.append(") ");
        }
        ArrayList arrayList = this.f2655f;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f2656g;
        if (size > 0 || arrayList2.size() > 0) {
            sb.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    if (i5 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList.get(i5));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                    if (i6 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList2.get(i6));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public void a(p pVar) {
        if (this.f2669u == null) {
            this.f2669u = new ArrayList();
        }
        this.f2669u.add(pVar);
    }

    public void b(View view) {
        this.f2656g.add(view);
    }

    public void d() {
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f2664p);
        this.f2664p = f2649y;
        while (true) {
            size--;
            if (size < 0) {
                this.f2664p = animatorArr;
                x(this, q.f2646c);
                return;
            }
            Animator animator = animatorArr[size];
            animatorArr[size] = null;
            animator.cancel();
        }
    }

    public abstract void e(a0 a0Var);

    public final void f(View view, boolean z4) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            a0 a0Var = new a0(view);
            if (z4) {
                h(a0Var);
            } else {
                e(a0Var);
            }
            a0Var.f2587c.add(this);
            g(a0Var);
            if (z4) {
                c(this.f2657h, view, a0Var);
            } else {
                c(this.f2658i, view, a0Var);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                f(viewGroup.getChildAt(i5), z4);
            }
        }
    }

    public void g(a0 a0Var) {
    }

    public abstract void h(a0 a0Var);

    public final void i(ViewGroup viewGroup, boolean z4) {
        j(z4);
        ArrayList arrayList = this.f2655f;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f2656g;
        if (size <= 0 && arrayList2.size() <= 0) {
            f(viewGroup, z4);
            return;
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            View findViewById = viewGroup.findViewById(((Integer) arrayList.get(i5)).intValue());
            if (findViewById != null) {
                a0 a0Var = new a0(findViewById);
                if (z4) {
                    h(a0Var);
                } else {
                    e(a0Var);
                }
                a0Var.f2587c.add(this);
                g(a0Var);
                if (z4) {
                    c(this.f2657h, findViewById, a0Var);
                } else {
                    c(this.f2658i, findViewById, a0Var);
                }
            }
        }
        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
            View view = (View) arrayList2.get(i6);
            a0 a0Var2 = new a0(view);
            if (z4) {
                h(a0Var2);
            } else {
                e(a0Var2);
            }
            a0Var2.f2587c.add(this);
            g(a0Var2);
            if (z4) {
                c(this.f2657h, view, a0Var2);
            } else {
                c(this.f2658i, view, a0Var2);
            }
        }
    }

    public final void j(boolean z4) {
        if (z4) {
            ((l.b) this.f2657h.f2877a).clear();
            ((SparseArray) this.f2657h.f2878b).clear();
            ((l.d) this.f2657h.f2879c).a();
            return;
        }
        ((l.b) this.f2658i.f2877a).clear();
        ((SparseArray) this.f2658i.f2878b).clear();
        ((l.d) this.f2658i.f2879c).a();
    }

    @Override // 
    /* renamed from: k */
    public r clone() {
        try {
            r rVar = (r) super.clone();
            rVar.f2670v = new ArrayList();
            rVar.f2657h = new g.f(6);
            rVar.f2658i = new g.f(6);
            rVar.f2661l = null;
            rVar.f2662m = null;
            rVar.f2668t = this;
            rVar.f2669u = null;
            return rVar;
        } catch (CloneNotSupportedException e5) {
            throw new RuntimeException(e5);
        }
    }

    public Animator l(ViewGroup viewGroup, a0 a0Var, a0 a0Var2) {
        return null;
    }

    public void m(ViewGroup viewGroup, g.f fVar, g.f fVar2, ArrayList arrayList, ArrayList arrayList2) {
        View view;
        Animator animator;
        a0 a0Var;
        int i5;
        Animator animator2;
        a0 a0Var2;
        l.b q5 = q();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        p().getClass();
        int i6 = 0;
        while (i6 < size) {
            a0 a0Var3 = (a0) arrayList.get(i6);
            a0 a0Var4 = (a0) arrayList2.get(i6);
            if (a0Var3 != null && !a0Var3.f2587c.contains(this)) {
                a0Var3 = null;
            }
            if (a0Var4 != null && !a0Var4.f2587c.contains(this)) {
                a0Var4 = null;
            }
            if (a0Var3 != null || a0Var4 != null) {
                if (a0Var3 == null || a0Var4 == null || u(a0Var3, a0Var4)) {
                    Animator l5 = l(viewGroup, a0Var3, a0Var4);
                    if (l5 != null) {
                        if (a0Var4 != null) {
                            String[] r5 = r();
                            View view2 = a0Var4.f2586b;
                            if (r5 != null && r5.length > 0) {
                                a0Var2 = new a0(view2);
                                a0 a0Var5 = (a0) ((l.b) fVar2.f2877a).getOrDefault(view2, null);
                                if (a0Var5 != null) {
                                    int i7 = 0;
                                    while (i7 < r5.length) {
                                        HashMap hashMap = a0Var2.f2585a;
                                        Animator animator3 = l5;
                                        String str = r5[i7];
                                        hashMap.put(str, a0Var5.f2585a.get(str));
                                        i7++;
                                        l5 = animator3;
                                        r5 = r5;
                                    }
                                }
                                Animator animator4 = l5;
                                int i8 = q5.f3705d;
                                int i9 = 0;
                                while (true) {
                                    if (i9 >= i8) {
                                        animator2 = animator4;
                                        break;
                                    }
                                    o oVar = (o) q5.getOrDefault((Animator) q5.h(i9), null);
                                    if (oVar.f2640c != null && oVar.f2638a == view2 && oVar.f2639b.equals(this.f2651b) && oVar.f2640c.equals(a0Var2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i9++;
                                }
                            } else {
                                animator2 = l5;
                                a0Var2 = null;
                            }
                            animator = animator2;
                            view = view2;
                            a0Var = a0Var2;
                        } else {
                            view = a0Var3.f2586b;
                            animator = l5;
                            a0Var = null;
                        }
                        if (animator != null) {
                            i5 = size;
                            q5.put(animator, new o(view, this.f2651b, this, viewGroup.getWindowId(), a0Var, animator));
                            this.f2670v.add(animator);
                            i6++;
                            size = i5;
                        }
                    }
                    i5 = size;
                    i6++;
                    size = i5;
                }
            }
            i5 = size;
            i6++;
            size = i5;
        }
        if (sparseIntArray.size() != 0) {
            for (int i10 = 0; i10 < sparseIntArray.size(); i10++) {
                o oVar2 = (o) q5.getOrDefault((Animator) this.f2670v.get(sparseIntArray.keyAt(i10)), null);
                oVar2.f2643f.setStartDelay(oVar2.f2643f.getStartDelay() + (sparseIntArray.valueAt(i10) - Long.MAX_VALUE));
            }
        }
    }

    public final void n() {
        int i5 = this.f2665q - 1;
        this.f2665q = i5;
        if (i5 != 0) {
            return;
        }
        x(this, q.f2645b);
        int i6 = 0;
        while (true) {
            l.d dVar = (l.d) this.f2657h.f2879c;
            if (dVar.f3677b) {
                dVar.c();
            }
            if (i6 >= dVar.f3680e) {
                break;
            }
            View view = (View) ((l.d) this.f2657h.f2879c).f(i6);
            if (view != null) {
                view.setHasTransientState(false);
            }
            i6++;
        }
        int i7 = 0;
        while (true) {
            l.d dVar2 = (l.d) this.f2658i.f2879c;
            if (dVar2.f3677b) {
                dVar2.c();
            }
            if (i7 >= dVar2.f3680e) {
                this.f2667s = true;
                return;
            }
            View view2 = (View) ((l.d) this.f2658i.f2879c).f(i7);
            if (view2 != null) {
                view2.setHasTransientState(false);
            }
            i7++;
        }
    }

    public final a0 o(View view, boolean z4) {
        x xVar = this.f2659j;
        if (xVar != null) {
            return xVar.o(view, z4);
        }
        ArrayList arrayList = z4 ? this.f2661l : this.f2662m;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                i5 = -1;
                break;
            }
            a0 a0Var = (a0) arrayList.get(i5);
            if (a0Var == null) {
                return null;
            }
            if (a0Var.f2586b == view) {
                break;
            }
            i5++;
        }
        if (i5 >= 0) {
            return (a0) (z4 ? this.f2662m : this.f2661l).get(i5);
        }
        return null;
    }

    public final r p() {
        x xVar = this.f2659j;
        return xVar != null ? xVar.p() : this;
    }

    public String[] r() {
        return null;
    }

    public final a0 s(View view, boolean z4) {
        x xVar = this.f2659j;
        if (xVar != null) {
            return xVar.s(view, z4);
        }
        return (a0) ((l.b) (z4 ? this.f2657h : this.f2658i).f2877a).getOrDefault(view, null);
    }

    public boolean t() {
        return !this.o.isEmpty();
    }

    public final String toString() {
        return K("");
    }

    public boolean u(a0 a0Var, a0 a0Var2) {
        if (a0Var == null || a0Var2 == null) {
            return false;
        }
        String[] r5 = r();
        if (r5 == null) {
            for (String str : a0Var.f2585a.keySet()) {
                if (w(a0Var, a0Var2, str)) {
                }
            }
            return false;
        }
        for (String str2 : r5) {
            if (!w(a0Var, a0Var2, str2)) {
            }
        }
        return false;
        return true;
    }

    public final boolean v(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f2655f;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f2656g;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public final void x(r rVar, h0.h hVar) {
        r rVar2 = this.f2668t;
        if (rVar2 != null) {
            rVar2.x(rVar, hVar);
        }
        ArrayList arrayList = this.f2669u;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.f2669u.size();
        p[] pVarArr = this.f2663n;
        if (pVarArr == null) {
            pVarArr = new p[size];
        }
        this.f2663n = null;
        p[] pVarArr2 = (p[]) this.f2669u.toArray(pVarArr);
        for (int i5 = 0; i5 < size; i5++) {
            p pVar = pVarArr2[i5];
            switch (hVar.f3137g) {
                case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                    pVar.b(rVar);
                    break;
                case 3:
                    pVar.f(rVar);
                    break;
                case 4:
                    pVar.d(rVar);
                    break;
                case 5:
                    pVar.c();
                    break;
                default:
                    pVar.e();
                    break;
            }
            pVarArr2[i5] = null;
        }
        this.f2663n = pVarArr2;
    }

    public void y(View view) {
        if (this.f2667s) {
            return;
        }
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f2664p);
        this.f2664p = f2649y;
        for (int i5 = size - 1; i5 >= 0; i5--) {
            Animator animator = animatorArr[i5];
            animatorArr[i5] = null;
            animator.pause();
        }
        this.f2664p = animatorArr;
        x(this, q.f2647d);
        this.f2666r = true;
    }

    public r z(p pVar) {
        r rVar;
        ArrayList arrayList = this.f2669u;
        if (arrayList == null) {
            return this;
        }
        if (!arrayList.remove(pVar) && (rVar = this.f2668t) != null) {
            rVar.z(pVar);
        }
        if (this.f2669u.size() == 0) {
            this.f2669u = null;
        }
        return this;
    }
}
