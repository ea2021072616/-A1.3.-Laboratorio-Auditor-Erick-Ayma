package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final h0 f1309a;

    /* renamed from: e  reason: collision with root package name */
    public View f1313e;

    /* renamed from: d  reason: collision with root package name */
    public int f1312d = 0;

    /* renamed from: b  reason: collision with root package name */
    public final c f1310b = new c(0);

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f1311c = new ArrayList();

    public d(h0 h0Var) {
        this.f1309a = h0Var;
    }

    public final void a(View view, int i5, boolean z4) {
        h0 h0Var = this.f1309a;
        int c5 = i5 < 0 ? h0Var.c() : f(i5);
        this.f1310b.e(c5, z4);
        if (z4) {
            i(view);
        }
        h0Var.f1358a.addView(view, c5);
        RecyclerView.L(view);
    }

    public final void b(View view, int i5, ViewGroup.LayoutParams layoutParams, boolean z4) {
        h0 h0Var = this.f1309a;
        int c5 = i5 < 0 ? h0Var.c() : f(i5);
        this.f1310b.e(c5, z4);
        if (z4) {
            i(view);
        }
        h0Var.getClass();
        i1 L = RecyclerView.L(view);
        RecyclerView recyclerView = h0Var.f1358a;
        if (L != null) {
            if (!L.k() && !L.o()) {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(L);
                throw new IllegalArgumentException(androidx.appcompat.widget.b0.e(recyclerView, sb));
            }
            if (RecyclerView.G0) {
                Log.d("RecyclerView", "reAttach " + L);
            }
            L.f1385j &= -257;
        } else if (RecyclerView.F0) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            sb2.append(", index: ");
            sb2.append(c5);
            throw new IllegalArgumentException(androidx.appcompat.widget.b0.e(recyclerView, sb2));
        }
        recyclerView.attachViewToParent(view, c5, layoutParams);
    }

    public final void c(int i5) {
        int f5 = f(i5);
        this.f1310b.f(f5);
        h0 h0Var = this.f1309a;
        View childAt = h0Var.f1358a.getChildAt(f5);
        RecyclerView recyclerView = h0Var.f1358a;
        if (childAt != null) {
            i1 L = RecyclerView.L(childAt);
            if (L != null) {
                if (L.k() && !L.o()) {
                    StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                    sb.append(L);
                    throw new IllegalArgumentException(androidx.appcompat.widget.b0.e(recyclerView, sb));
                }
                if (RecyclerView.G0) {
                    Log.d("RecyclerView", "tmpDetach " + L);
                }
                L.b(256);
            }
        } else if (RecyclerView.F0) {
            StringBuilder sb2 = new StringBuilder("No view at offset ");
            sb2.append(f5);
            throw new IllegalArgumentException(androidx.appcompat.widget.b0.e(recyclerView, sb2));
        }
        recyclerView.detachViewFromParent(f5);
    }

    public final View d(int i5) {
        return this.f1309a.f1358a.getChildAt(f(i5));
    }

    public final int e() {
        return this.f1309a.c() - this.f1311c.size();
    }

    public final int f(int i5) {
        if (i5 < 0) {
            return -1;
        }
        int c5 = this.f1309a.c();
        int i6 = i5;
        while (i6 < c5) {
            c cVar = this.f1310b;
            int b5 = i5 - (i6 - cVar.b(i6));
            if (b5 == 0) {
                while (cVar.d(i6)) {
                    i6++;
                }
                return i6;
            }
            i6 += b5;
        }
        return -1;
    }

    public final View g(int i5) {
        return this.f1309a.f1358a.getChildAt(i5);
    }

    public final int h() {
        return this.f1309a.c();
    }

    public final void i(View view) {
        this.f1311c.add(view);
        h0 h0Var = this.f1309a;
        h0Var.getClass();
        i1 L = RecyclerView.L(view);
        if (L != null) {
            int i5 = L.f1391q;
            View view2 = L.f1376a;
            if (i5 != -1) {
                L.f1390p = i5;
            } else {
                WeakHashMap weakHashMap = h0.z0.f3233a;
                L.f1390p = view2.getImportantForAccessibility();
            }
            RecyclerView recyclerView = h0Var.f1358a;
            if (recyclerView.O()) {
                L.f1391q = 4;
                recyclerView.f1258z0.add(L);
                return;
            }
            WeakHashMap weakHashMap2 = h0.z0.f3233a;
            view2.setImportantForAccessibility(4);
        }
    }

    public final boolean j(View view) {
        return this.f1311c.contains(view);
    }

    public final void k(View view) {
        if (this.f1311c.remove(view)) {
            h0 h0Var = this.f1309a;
            h0Var.getClass();
            i1 L = RecyclerView.L(view);
            if (L != null) {
                int i5 = L.f1390p;
                RecyclerView recyclerView = h0Var.f1358a;
                if (recyclerView.O()) {
                    L.f1391q = i5;
                    recyclerView.f1258z0.add(L);
                } else {
                    WeakHashMap weakHashMap = h0.z0.f3233a;
                    L.f1376a.setImportantForAccessibility(i5);
                }
                L.f1390p = 0;
            }
        }
    }

    public final String toString() {
        return this.f1310b.toString() + ", hidden list:" + this.f1311c.size();
    }
}
