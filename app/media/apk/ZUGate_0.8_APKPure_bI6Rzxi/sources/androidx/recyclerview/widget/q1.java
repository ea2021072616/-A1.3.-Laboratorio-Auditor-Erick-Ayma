package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class q1 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1486a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public int f1487b = Integer.MIN_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public int f1488c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f1489d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final int f1490e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f1491f;

    public q1(StaggeredGridLayoutManager staggeredGridLayoutManager, int i5) {
        this.f1491f = staggeredGridLayoutManager;
        this.f1490e = i5;
    }

    public static n1 h(View view) {
        return (n1) view.getLayoutParams();
    }

    public final void a() {
        ArrayList arrayList = this.f1486a;
        View view = (View) arrayList.get(arrayList.size() - 1);
        n1 h5 = h(view);
        this.f1488c = this.f1491f.f1261r.b(view);
        h5.getClass();
    }

    public final void b() {
        this.f1486a.clear();
        this.f1487b = Integer.MIN_VALUE;
        this.f1488c = Integer.MIN_VALUE;
        this.f1489d = 0;
    }

    public final int c() {
        boolean z4 = this.f1491f.f1266w;
        ArrayList arrayList = this.f1486a;
        return z4 ? e(arrayList.size() - 1, -1) : e(0, arrayList.size());
    }

    public final int d() {
        boolean z4 = this.f1491f.f1266w;
        ArrayList arrayList = this.f1486a;
        return z4 ? e(0, arrayList.size()) : e(arrayList.size() - 1, -1);
    }

    public final int e(int i5, int i6) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f1491f;
        int h5 = staggeredGridLayoutManager.f1261r.h();
        int f5 = staggeredGridLayoutManager.f1261r.f();
        int i7 = i6 > i5 ? 1 : -1;
        while (i5 != i6) {
            View view = (View) this.f1486a.get(i5);
            int d5 = staggeredGridLayoutManager.f1261r.d(view);
            int b5 = staggeredGridLayoutManager.f1261r.b(view);
            boolean z4 = d5 <= f5;
            boolean z5 = b5 >= h5;
            if (z4 && z5 && (d5 < h5 || b5 > f5)) {
                return r0.H(view);
            }
            i5 += i7;
        }
        return -1;
    }

    public final int f(int i5) {
        int i6 = this.f1488c;
        if (i6 != Integer.MIN_VALUE) {
            return i6;
        }
        if (this.f1486a.size() == 0) {
            return i5;
        }
        a();
        return this.f1488c;
    }

    public final View g(int i5, int i6) {
        ArrayList arrayList = this.f1486a;
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f1491f;
        View view = null;
        if (i6 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.f1266w && r0.H(view2) >= i5) || ((!staggeredGridLayoutManager.f1266w && r0.H(view2) <= i5) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
        } else {
            int size2 = arrayList.size();
            int i7 = 0;
            while (i7 < size2) {
                View view3 = (View) arrayList.get(i7);
                if ((staggeredGridLayoutManager.f1266w && r0.H(view3) <= i5) || ((!staggeredGridLayoutManager.f1266w && r0.H(view3) >= i5) || !view3.hasFocusable())) {
                    break;
                }
                i7++;
                view = view3;
            }
        }
        return view;
    }

    public final int i(int i5) {
        int i6 = this.f1487b;
        if (i6 != Integer.MIN_VALUE) {
            return i6;
        }
        ArrayList arrayList = this.f1486a;
        if (arrayList.size() == 0) {
            return i5;
        }
        View view = (View) arrayList.get(0);
        n1 h5 = h(view);
        this.f1487b = this.f1491f.f1261r.d(view);
        h5.getClass();
        return this.f1487b;
    }
}
