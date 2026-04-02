package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class g0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1351b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f1352c;

    public /* synthetic */ g0(RecyclerView recyclerView, int i5) {
        this.f1351b = i5;
        this.f1352c = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z4;
        int i5 = this.f1351b;
        RecyclerView recyclerView = this.f1352c;
        switch (i5) {
            case 0:
                if (!recyclerView.A || recyclerView.isLayoutRequested()) {
                    return;
                }
                if (!recyclerView.f1255y) {
                    recyclerView.requestLayout();
                    return;
                } else if (recyclerView.D) {
                    recyclerView.C = true;
                    return;
                } else {
                    recyclerView.p();
                    return;
                }
            default:
                n0 n0Var = recyclerView.R;
                if (n0Var != null) {
                    k kVar = (k) n0Var;
                    ArrayList arrayList = kVar.f1403h;
                    boolean z5 = !arrayList.isEmpty();
                    ArrayList arrayList2 = kVar.f1405j;
                    boolean z6 = !arrayList2.isEmpty();
                    ArrayList arrayList3 = kVar.f1406k;
                    boolean z7 = !arrayList3.isEmpty();
                    ArrayList arrayList4 = kVar.f1404i;
                    boolean z8 = !arrayList4.isEmpty();
                    if (z5 || z6 || z8 || z7) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            boolean hasNext = it.hasNext();
                            long j5 = kVar.f1434d;
                            if (hasNext) {
                                i1 i1Var = (i1) it.next();
                                View view = i1Var.f1376a;
                                ViewPropertyAnimator animate = view.animate();
                                kVar.f1411q.add(i1Var);
                                animate.setDuration(j5).alpha(0.0f).setListener(new f(kVar, i1Var, animate, view)).start();
                                it = it;
                            } else {
                                arrayList.clear();
                                if (z6) {
                                    ArrayList arrayList5 = new ArrayList();
                                    arrayList5.addAll(arrayList2);
                                    kVar.f1408m.add(arrayList5);
                                    arrayList2.clear();
                                    e eVar = new e(kVar, arrayList5, 0);
                                    if (z5) {
                                        View view2 = ((j) arrayList5.get(0)).f1394a.f1376a;
                                        WeakHashMap weakHashMap = h0.z0.f3233a;
                                        view2.postOnAnimationDelayed(eVar, j5);
                                    } else {
                                        eVar.run();
                                    }
                                }
                                if (z7) {
                                    ArrayList arrayList6 = new ArrayList();
                                    arrayList6.addAll(arrayList3);
                                    kVar.f1409n.add(arrayList6);
                                    arrayList3.clear();
                                    e eVar2 = new e(kVar, arrayList6, 1);
                                    if (z5) {
                                        View view3 = ((i) arrayList6.get(0)).f1366a.f1376a;
                                        WeakHashMap weakHashMap2 = h0.z0.f3233a;
                                        view3.postOnAnimationDelayed(eVar2, j5);
                                    } else {
                                        eVar2.run();
                                    }
                                }
                                if (z8) {
                                    ArrayList arrayList7 = new ArrayList();
                                    arrayList7.addAll(arrayList4);
                                    kVar.f1407l.add(arrayList7);
                                    arrayList4.clear();
                                    e eVar3 = new e(kVar, arrayList7, 2);
                                    if (z5 || z6 || z7) {
                                        if (!z5) {
                                            j5 = 0;
                                        }
                                        long max = Math.max(z6 ? kVar.f1435e : 0L, z7 ? kVar.f1436f : 0L) + j5;
                                        z4 = false;
                                        View view4 = ((i1) arrayList7.get(0)).f1376a;
                                        WeakHashMap weakHashMap3 = h0.z0.f3233a;
                                        view4.postOnAnimationDelayed(eVar3, max);
                                        recyclerView.f1244s0 = z4;
                                        return;
                                    }
                                    eVar3.run();
                                }
                            }
                        }
                    }
                }
                z4 = false;
                recyclerView.f1244s0 = z4;
                return;
        }
    }
}
