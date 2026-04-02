package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class o1 {
    public static void d(View view, List list) {
        boolean z4;
        boolean z5;
        int size = list.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                z4 = false;
                break;
            } else if (list.get(i5) == view) {
                z4 = true;
                break;
            } else {
                i5++;
            }
        }
        if (z4) {
            return;
        }
        WeakHashMap weakHashMap = h0.z0.f3233a;
        if (h0.o0.k(view) != null) {
            list.add(view);
        }
        for (int i6 = size; i6 < list.size(); i6++) {
            View view2 = (View) list.get(i6);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = viewGroup.getChildAt(i7);
                    int i8 = 0;
                    while (true) {
                        if (i8 >= size) {
                            z5 = false;
                            break;
                        } else if (list.get(i8) == childAt) {
                            z5 = true;
                            break;
                        } else {
                            i8++;
                        }
                    }
                    if (!z5 && h0.o0.k(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    public static void g(Rect rect, View view) {
        WeakHashMap weakHashMap = h0.z0.f3233a;
        if (view.isAttachedToWindow()) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset(iArr[0], iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public static boolean h(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void a(View view, Object obj);

    public abstract void b(Object obj, ArrayList arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public abstract Object f(Object obj);

    public abstract Object i(Object obj, Object obj2, Object obj3);

    public abstract Object j(Object obj, Object obj2);

    public abstract void k(Object obj, View view, ArrayList arrayList);

    public abstract void l(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2);

    public abstract void m(View view, Object obj);

    public abstract void n(Object obj, Rect rect);

    public abstract void o(Object obj, d0.c cVar, e0.a aVar);

    public abstract void p(Object obj, View view, ArrayList arrayList);

    public abstract void q(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract Object r(Object obj);
}
