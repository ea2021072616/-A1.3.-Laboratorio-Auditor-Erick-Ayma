package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1317b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1318c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k f1319d;

    public /* synthetic */ e(k kVar, ArrayList arrayList, int i5) {
        this.f1317b = i5;
        this.f1319d = kVar;
        this.f1318c = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j5;
        int i5 = this.f1317b;
        k kVar = this.f1319d;
        ArrayList arrayList = this.f1318c;
        switch (i5) {
            case 0:
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    j jVar = (j) it.next();
                    i1 i1Var = jVar.f1394a;
                    kVar.getClass();
                    View view = i1Var.f1376a;
                    int i6 = jVar.f1397d - jVar.f1395b;
                    int i7 = jVar.f1398e - jVar.f1396c;
                    if (i6 != 0) {
                        view.animate().translationX(0.0f);
                    }
                    if (i7 != 0) {
                        view.animate().translationY(0.0f);
                    }
                    ViewPropertyAnimator animate = view.animate();
                    kVar.f1410p.add(i1Var);
                    animate.setDuration(kVar.f1435e).setListener(new g(kVar, i1Var, i6, view, i7, animate)).start();
                }
                arrayList.clear();
                kVar.f1408m.remove(arrayList);
                return;
            case 1:
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    i iVar = (i) it2.next();
                    kVar.getClass();
                    i1 i1Var2 = iVar.f1366a;
                    View view2 = i1Var2 == null ? null : i1Var2.f1376a;
                    i1 i1Var3 = iVar.f1367b;
                    View view3 = i1Var3 != null ? i1Var3.f1376a : null;
                    ArrayList arrayList2 = kVar.f1412r;
                    long j6 = kVar.f1436f;
                    if (view2 != null) {
                        ViewPropertyAnimator duration = view2.animate().setDuration(j6);
                        arrayList2.add(iVar.f1366a);
                        duration.translationX(iVar.f1370e - iVar.f1368c);
                        duration.translationY(iVar.f1371f - iVar.f1369d);
                        j5 = j6;
                        duration.alpha(0.0f).setListener(new h(kVar, iVar, duration, view2, 0)).start();
                    } else {
                        j5 = j6;
                    }
                    if (view3 != null) {
                        ViewPropertyAnimator animate2 = view3.animate();
                        arrayList2.add(iVar.f1367b);
                        animate2.translationX(0.0f).translationY(0.0f).setDuration(j5).alpha(1.0f).setListener(new h(kVar, iVar, animate2, view3, 1)).start();
                    }
                }
                arrayList.clear();
                kVar.f1409n.remove(arrayList);
                return;
            default:
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    i1 i1Var4 = (i1) it3.next();
                    kVar.getClass();
                    View view4 = i1Var4.f1376a;
                    ViewPropertyAnimator animate3 = view4.animate();
                    kVar.o.add(i1Var4);
                    animate3.alpha(1.0f).setDuration(kVar.f1433c).setListener(new f(kVar, i1Var4, view4, animate3)).start();
                }
                arrayList.clear();
                kVar.f1407l.remove(arrayList);
                return;
        }
    }
}
