package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class n extends t1 {
    public static void j(s1 s1Var) {
        androidx.appcompat.widget.b0.a(s1Var.f999a, s1Var.f1001c.mView);
    }

    public static void k(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (h0.d1.b(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt.getVisibility() == 0) {
                k(arrayList, childAt);
            }
        }
    }

    public static void l(l.b bVar, View view) {
        WeakHashMap weakHashMap = h0.z0.f3233a;
        String k5 = h0.o0.k(view);
        if (k5 != null) {
            bVar.put(k5, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = viewGroup.getChildAt(i5);
                if (childAt.getVisibility() == 0) {
                    l(bVar, childAt);
                }
            }
        }
    }

    public static void m(l.b bVar, Collection collection) {
        Iterator it = ((l.g) bVar.entrySet()).iterator();
        while (it.hasNext()) {
            WeakHashMap weakHashMap = h0.z0.f3233a;
            if (!collection.contains(h0.o0.k((View) ((Map.Entry) it.next()).getValue()))) {
                it.remove();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x06ea  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x07a8  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0861 A[LOOP:7: B:275:0x085b->B:277:0x0861, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0875  */
    /* JADX WARN: Removed duplicated region for block: B:364:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.t1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.util.ArrayList r39, boolean r40) {
        /*
            Method dump skipped, instructions count: 2195
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.n.b(java.util.ArrayList, boolean):void");
    }
}
