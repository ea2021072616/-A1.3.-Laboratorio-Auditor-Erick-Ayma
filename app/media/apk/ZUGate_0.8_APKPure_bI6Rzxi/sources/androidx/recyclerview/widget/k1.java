package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
/* loaded from: classes.dex */
public class k1 extends h0.b {

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f1413d;

    /* renamed from: e  reason: collision with root package name */
    public final j1 f1414e;

    public k1(RecyclerView recyclerView) {
        this.f1413d = recyclerView;
        h0.b j5 = j();
        if (j5 == null || !(j5 instanceof j1)) {
            this.f1414e = new j1(this);
        } else {
            this.f1414e = (j1) j5;
        }
    }

    @Override // h0.b
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = this.f1413d;
            if (!recyclerView.A || recyclerView.I || recyclerView.f1228k.g()) {
                return;
            }
            RecyclerView recyclerView2 = (RecyclerView) view;
            if (recyclerView2.getLayoutManager() != null) {
                recyclerView2.getLayoutManager().U(accessibilityEvent);
            }
        }
    }

    @Override // h0.b
    public final void d(View view, i0.j jVar) {
        this.f3105a.onInitializeAccessibilityNodeInfo(view, jVar.f3375a);
        RecyclerView recyclerView = this.f1413d;
        if ((!recyclerView.A || recyclerView.I || recyclerView.f1228k.g()) || recyclerView.getLayoutManager() == null) {
            return;
        }
        r0 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f1497b;
        layoutManager.V(recyclerView2.f1224i, recyclerView2.f1233m0, jVar);
    }

    @Override // h0.b
    public final boolean g(View view, int i5, Bundle bundle) {
        int G;
        int E;
        if (super.g(view, i5, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.f1413d;
        if ((!recyclerView.A || recyclerView.I || recyclerView.f1228k.g()) || recyclerView.getLayoutManager() == null) {
            return false;
        }
        r0 layoutManager = recyclerView.getLayoutManager();
        y0 y0Var = layoutManager.f1497b.f1224i;
        int i6 = layoutManager.o;
        int i7 = layoutManager.f1509n;
        Rect rect = new Rect();
        if (layoutManager.f1497b.getMatrix().isIdentity() && layoutManager.f1497b.getGlobalVisibleRect(rect)) {
            i6 = rect.height();
            i7 = rect.width();
        }
        if (i5 == 4096) {
            G = layoutManager.f1497b.canScrollVertically(1) ? (i6 - layoutManager.G()) - layoutManager.D() : 0;
            if (layoutManager.f1497b.canScrollHorizontally(1)) {
                E = (i7 - layoutManager.E()) - layoutManager.F();
            }
            E = 0;
        } else if (i5 != 8192) {
            G = 0;
            E = 0;
        } else {
            G = layoutManager.f1497b.canScrollVertically(-1) ? -((i6 - layoutManager.G()) - layoutManager.D()) : 0;
            if (layoutManager.f1497b.canScrollHorizontally(-1)) {
                E = -((i7 - layoutManager.E()) - layoutManager.F());
            }
            E = 0;
        }
        if (G == 0 && E == 0) {
            return false;
        }
        layoutManager.f1497b.h0(E, G, true);
        return true;
    }

    public h0.b j() {
        return this.f1414e;
    }
}
