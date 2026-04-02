package androidx.lifecycle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LiveData$LifecycleBoundObserver extends y implements r {

    /* renamed from: e  reason: collision with root package name */
    public final t f1088e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ z f1089f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveData$LifecycleBoundObserver(z zVar, t tVar, b0 b0Var) {
        super(zVar, b0Var);
        this.f1089f = zVar;
        this.f1088e = tVar;
    }

    @Override // androidx.lifecycle.r
    public final void b(t tVar, m mVar) {
        t tVar2 = this.f1088e;
        n nVar = ((v) tVar2.getLifecycle()).f1151c;
        if (nVar != n.DESTROYED) {
            n nVar2 = null;
            while (nVar2 != nVar) {
                c(f());
                nVar2 = nVar;
                nVar = ((v) tVar2.getLifecycle()).f1151c;
            }
            return;
        }
        z zVar = this.f1089f;
        zVar.getClass();
        z.a("removeObserver");
        y yVar = (y) zVar.f1166b.f(this.f1160a);
        if (yVar == null) {
            return;
        }
        yVar.d();
        yVar.c(false);
    }

    @Override // androidx.lifecycle.y
    public final void d() {
        this.f1088e.getLifecycle().b(this);
    }

    @Override // androidx.lifecycle.y
    public final boolean e(t tVar) {
        return this.f1088e == tVar;
    }

    @Override // androidx.lifecycle.y
    public final boolean f() {
        return ((v) this.f1088e.getLifecycle()).f1151c.a(n.STARTED);
    }
}
