package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class j1 extends h0.b {

    /* renamed from: d  reason: collision with root package name */
    public final k1 f1399d;

    /* renamed from: e  reason: collision with root package name */
    public final WeakHashMap f1400e = new WeakHashMap();

    public j1(k1 k1Var) {
        this.f1399d = k1Var;
    }

    @Override // h0.b
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        h0.b bVar = (h0.b) this.f1400e.get(view);
        return bVar != null ? bVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
    }

    @Override // h0.b
    public final b0 b(View view) {
        h0.b bVar = (h0.b) this.f1400e.get(view);
        return bVar != null ? bVar.b(view) : super.b(view);
    }

    @Override // h0.b
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        h0.b bVar = (h0.b) this.f1400e.get(view);
        if (bVar != null) {
            bVar.c(view, accessibilityEvent);
        } else {
            super.c(view, accessibilityEvent);
        }
    }

    @Override // h0.b
    public final void d(View view, i0.j jVar) {
        k1 k1Var = this.f1399d;
        RecyclerView recyclerView = k1Var.f1413d;
        boolean z4 = !recyclerView.A || recyclerView.I || recyclerView.f1228k.g();
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f3375a;
        View.AccessibilityDelegate accessibilityDelegate = this.f3105a;
        if (!z4) {
            RecyclerView recyclerView2 = k1Var.f1413d;
            if (recyclerView2.getLayoutManager() != null) {
                recyclerView2.getLayoutManager().W(view, jVar);
                h0.b bVar = (h0.b) this.f1400e.get(view);
                if (bVar != null) {
                    bVar.d(view, jVar);
                    return;
                } else {
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    return;
                }
            }
        }
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
    }

    @Override // h0.b
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        h0.b bVar = (h0.b) this.f1400e.get(view);
        if (bVar != null) {
            bVar.e(view, accessibilityEvent);
        } else {
            super.e(view, accessibilityEvent);
        }
    }

    @Override // h0.b
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        h0.b bVar = (h0.b) this.f1400e.get(viewGroup);
        return bVar != null ? bVar.f(viewGroup, view, accessibilityEvent) : super.f(viewGroup, view, accessibilityEvent);
    }

    @Override // h0.b
    public final boolean g(View view, int i5, Bundle bundle) {
        k1 k1Var = this.f1399d;
        RecyclerView recyclerView = k1Var.f1413d;
        if (!(!recyclerView.A || recyclerView.I || recyclerView.f1228k.g())) {
            RecyclerView recyclerView2 = k1Var.f1413d;
            if (recyclerView2.getLayoutManager() != null) {
                h0.b bVar = (h0.b) this.f1400e.get(view);
                if (bVar != null) {
                    if (bVar.g(view, i5, bundle)) {
                        return true;
                    }
                } else if (super.g(view, i5, bundle)) {
                    return true;
                }
                y0 y0Var = recyclerView2.getLayoutManager().f1497b.f1224i;
                return false;
            }
        }
        return super.g(view, i5, bundle);
    }

    @Override // h0.b
    public final void h(View view, int i5) {
        h0.b bVar = (h0.b) this.f1400e.get(view);
        if (bVar != null) {
            bVar.h(view, i5);
        } else {
            super.h(view, i5);
        }
    }

    @Override // h0.b
    public final void i(View view, AccessibilityEvent accessibilityEvent) {
        h0.b bVar = (h0.b) this.f1400e.get(view);
        if (bVar != null) {
            bVar.i(view, accessibilityEvent);
        } else {
            super.i(view, accessibilityEvent);
        }
    }
}
