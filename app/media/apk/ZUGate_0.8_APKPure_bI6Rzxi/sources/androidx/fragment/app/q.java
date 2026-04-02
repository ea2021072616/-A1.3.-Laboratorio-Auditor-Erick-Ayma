package androidx.fragment.app;

import android.app.Dialog;
import android.view.View;
/* loaded from: classes.dex */
public final class q extends g0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ g0 f972g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ r f973h;

    public q(r rVar, g0 g0Var) {
        this.f973h = rVar;
        this.f972g = g0Var;
    }

    @Override // androidx.fragment.app.g0
    public final View b(int i5) {
        g0 g0Var = this.f972g;
        if (g0Var.c()) {
            return g0Var.b(i5);
        }
        Dialog dialog = this.f973h.f988r;
        if (dialog != null) {
            return dialog.findViewById(i5);
        }
        return null;
    }

    @Override // androidx.fragment.app.g0
    public final boolean c() {
        return this.f972g.c() || this.f973h.f992v;
    }
}
