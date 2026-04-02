package androidx.activity;

import androidx.fragment.app.o0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements androidx.lifecycle.r, c {

    /* renamed from: a  reason: collision with root package name */
    public final androidx.lifecycle.o f40a;

    /* renamed from: b  reason: collision with root package name */
    public final o0 f41b;

    /* renamed from: c  reason: collision with root package name */
    public x f42c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ z f43d;

    public OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(z zVar, androidx.lifecycle.o oVar, o0 o0Var) {
        e4.e.f(o0Var, "onBackPressedCallback");
        this.f43d = zVar;
        this.f40a = oVar;
        this.f41b = o0Var;
        oVar.a(this);
    }

    @Override // androidx.lifecycle.r
    public final void b(androidx.lifecycle.t tVar, androidx.lifecycle.m mVar) {
        if (mVar != androidx.lifecycle.m.ON_START) {
            if (mVar != androidx.lifecycle.m.ON_STOP) {
                if (mVar == androidx.lifecycle.m.ON_DESTROY) {
                    cancel();
                    return;
                }
                return;
            }
            x xVar = this.f42c;
            if (xVar != null) {
                xVar.cancel();
                return;
            }
            return;
        }
        z zVar = this.f43d;
        zVar.getClass();
        o0 o0Var = this.f41b;
        e4.e.f(o0Var, "onBackPressedCallback");
        zVar.f121b.e(o0Var);
        x xVar2 = new x(zVar, o0Var);
        o0Var.f962b.add(xVar2);
        zVar.d();
        o0Var.f963c = new y(1, zVar);
        this.f42c = xVar2;
    }

    @Override // androidx.activity.c
    public final void cancel() {
        this.f40a.b(this);
        o0 o0Var = this.f41b;
        o0Var.getClass();
        o0Var.f962b.remove(this);
        x xVar = this.f42c;
        if (xVar != null) {
            xVar.cancel();
        }
        this.f42c = null;
    }
}
