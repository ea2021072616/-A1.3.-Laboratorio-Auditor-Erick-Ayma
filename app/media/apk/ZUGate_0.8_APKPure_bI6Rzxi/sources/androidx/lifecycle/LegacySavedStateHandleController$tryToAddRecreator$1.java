package androidx.lifecycle;
/* loaded from: classes.dex */
public final class LegacySavedStateHandleController$tryToAddRecreator$1 implements r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f1086a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b1.d f1087b;

    public LegacySavedStateHandleController$tryToAddRecreator$1(o oVar, b1.d dVar) {
        this.f1086a = oVar;
        this.f1087b = dVar;
    }

    @Override // androidx.lifecycle.r
    public final void b(t tVar, m mVar) {
        if (mVar == m.ON_START) {
            this.f1086a.b(this);
            this.f1087b.d();
        }
    }
}
