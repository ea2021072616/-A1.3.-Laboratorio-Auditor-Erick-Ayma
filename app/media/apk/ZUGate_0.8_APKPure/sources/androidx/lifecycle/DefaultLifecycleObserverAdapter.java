package androidx.lifecycle;
/* loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements r {

    /* renamed from: a  reason: collision with root package name */
    public final e f1084a;

    /* renamed from: b  reason: collision with root package name */
    public final r f1085b;

    public DefaultLifecycleObserverAdapter(e eVar, r rVar) {
        e4.e.f(eVar, "defaultLifecycleObserver");
        this.f1084a = eVar;
        this.f1085b = rVar;
    }

    @Override // androidx.lifecycle.r
    public final void b(t tVar, m mVar) {
        int i5 = f.f1103a[mVar.ordinal()];
        e eVar = this.f1084a;
        switch (i5) {
            case 1:
                eVar.getClass();
                break;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                eVar.getClass();
                break;
            case 3:
                eVar.a();
                break;
            case 4:
                eVar.getClass();
                break;
            case 5:
                eVar.getClass();
                break;
            case 6:
                eVar.getClass();
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        r rVar = this.f1085b;
        if (rVar != null) {
            rVar.b(tVar, mVar);
        }
    }
}
