package androidx.lifecycle;
/* loaded from: classes.dex */
public final class SavedStateHandleController implements r {

    /* renamed from: a  reason: collision with root package name */
    public final String f1093a;

    /* renamed from: b  reason: collision with root package name */
    public final m0 f1094b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1095c;

    public SavedStateHandleController(String str, m0 m0Var) {
        this.f1093a = str;
        this.f1094b = m0Var;
    }

    @Override // androidx.lifecycle.r
    public final void b(t tVar, m mVar) {
        if (mVar == m.ON_DESTROY) {
            this.f1095c = false;
            tVar.getLifecycle().b(this);
        }
    }

    public final void c(o oVar, b1.d dVar) {
        e4.e.f(dVar, "registry");
        e4.e.f(oVar, "lifecycle");
        if (!(!this.f1095c)) {
            throw new IllegalStateException("Already attached to lifecycleOwner".toString());
        }
        this.f1095c = true;
        oVar.a(this);
        dVar.c(this.f1093a, this.f1094b.f1123e);
    }
}
