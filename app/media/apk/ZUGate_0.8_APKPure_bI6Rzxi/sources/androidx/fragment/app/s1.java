package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class s1 {

    /* renamed from: a  reason: collision with root package name */
    public int f999a;

    /* renamed from: b  reason: collision with root package name */
    public int f1000b;

    /* renamed from: c  reason: collision with root package name */
    public final Fragment f1001c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f1002d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet f1003e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1004f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1005g;

    /* renamed from: h  reason: collision with root package name */
    public final d1 f1006h;

    public s1(int i5, int i6, d1 d1Var, d0.c cVar) {
        Fragment fragment = d1Var.f860c;
        this.f1002d = new ArrayList();
        this.f1003e = new HashSet();
        this.f1004f = false;
        this.f1005g = false;
        this.f999a = i5;
        this.f1000b = i6;
        this.f1001c = fragment;
        cVar.b(new v(this));
        this.f1006h = d1Var;
    }

    public final void a() {
        if (this.f1004f) {
            return;
        }
        this.f1004f = true;
        HashSet hashSet = this.f1003e;
        if (hashSet.isEmpty()) {
            b();
            return;
        }
        Iterator it = new ArrayList(hashSet).iterator();
        while (it.hasNext()) {
            ((d0.c) it.next()).a();
        }
    }

    public final void b() {
        if (!this.f1005g) {
            if (w0.I(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f1005g = true;
            Iterator it = this.f1002d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        this.f1006h.j();
    }

    public final void c(int i5, int i6) {
        if (i6 == 0) {
            throw null;
        }
        int i7 = i6 - 1;
        Fragment fragment = this.f1001c;
        if (i7 == 0) {
            if (this.f999a != 1) {
                if (w0.I(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + androidx.appcompat.widget.b0.p(this.f999a) + " -> " + androidx.appcompat.widget.b0.p(i5) + ". ");
                }
                this.f999a = i5;
            }
        } else if (i7 == 1) {
            if (this.f999a == 1) {
                if (w0.I(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + androidx.appcompat.widget.b0.o(this.f1000b) + " to ADDING.");
                }
                this.f999a = 2;
                this.f1000b = 2;
            }
        } else if (i7 != 2) {
        } else {
            if (w0.I(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + androidx.appcompat.widget.b0.p(this.f999a) + " -> REMOVED. mLifecycleImpact  = " + androidx.appcompat.widget.b0.o(this.f1000b) + " to REMOVING.");
            }
            this.f999a = 1;
            this.f1000b = 3;
        }
    }

    public final void d() {
        int i5 = this.f1000b;
        d1 d1Var = this.f1006h;
        if (i5 != 2) {
            if (i5 == 3) {
                Fragment fragment = d1Var.f860c;
                View requireView = fragment.requireView();
                if (w0.I(2)) {
                    Log.v("FragmentManager", "Clearing focus " + requireView.findFocus() + " on view " + requireView + " for Fragment " + fragment);
                }
                requireView.clearFocus();
                return;
            }
            return;
        }
        Fragment fragment2 = d1Var.f860c;
        View findFocus = fragment2.mView.findFocus();
        if (findFocus != null) {
            fragment2.setFocusedView(findFocus);
            if (w0.I(2)) {
                Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment2);
            }
        }
        View requireView2 = this.f1001c.requireView();
        if (requireView2.getParent() == null) {
            d1Var.a();
            requireView2.setAlpha(0.0f);
        }
        if (requireView2.getAlpha() == 0.0f && requireView2.getVisibility() == 0) {
            requireView2.setVisibility(4);
        }
        requireView2.setAlpha(fragment2.getPostOnViewCreatedAlpha());
    }

    /* renamed from: e */
    public final String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + androidx.appcompat.widget.b0.p(this.f999a) + "} {mLifecycleImpact = " + androidx.appcompat.widget.b0.o(this.f1000b) + "} {mFragment = " + this.f1001c + "}";
    }
}
