package androidx.fragment.app;

import android.transition.Transition;
/* loaded from: classes.dex */
public final class m extends l {

    /* renamed from: c  reason: collision with root package name */
    public final Object f948c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f949d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f950e;

    public m(s1 s1Var, d0.c cVar, boolean z4, boolean z5) {
        super(s1Var, cVar);
        int i5 = s1Var.f999a;
        Fragment fragment = s1Var.f1001c;
        if (i5 == 2) {
            this.f948c = z4 ? fragment.getReenterTransition() : fragment.getEnterTransition();
            this.f949d = z4 ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        } else {
            this.f948c = z4 ? fragment.getReturnTransition() : fragment.getExitTransition();
            this.f949d = true;
        }
        if (!z5) {
            this.f950e = null;
        } else if (z4) {
            this.f950e = fragment.getSharedElementReturnTransition();
        } else {
            this.f950e = fragment.getSharedElementEnterTransition();
        }
    }

    public final o1 c(Object obj) {
        if (obj == null) {
            return null;
        }
        m1 m1Var = h1.f913a;
        if (obj instanceof Transition) {
            return m1Var;
        }
        o1 o1Var = h1.f914b;
        if (o1Var == null || !o1Var.e(obj)) {
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f943a.f1001c + " is not a valid framework Transition or AndroidX Transition");
        }
        return o1Var;
    }
}
