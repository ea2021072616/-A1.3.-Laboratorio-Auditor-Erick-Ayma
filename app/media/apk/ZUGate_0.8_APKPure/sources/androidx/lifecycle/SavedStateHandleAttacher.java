package androidx.lifecycle;
/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements r {

    /* renamed from: a  reason: collision with root package name */
    public final n0 f1092a;

    public SavedStateHandleAttacher(n0 n0Var) {
        this.f1092a = n0Var;
    }

    @Override // androidx.lifecycle.r
    public final void b(t tVar, m mVar) {
        if (mVar == m.ON_CREATE) {
            tVar.getLifecycle().b(this);
            this.f1092a.b();
            return;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + mVar).toString());
    }
}
