package android.a.b;

import android.a.b.g;
/* compiled from: FullLifecycleObserverAdapter.java */
/* loaded from: classes.dex */
class d implements f {

    /* renamed from: a  reason: collision with root package name */
    private final c f61a;

    @Override // android.a.b.f
    public void a(h hVar, g.a aVar) {
        switch (aVar) {
            case ON_CREATE:
                this.f61a.a(hVar);
                return;
            case ON_START:
                this.f61a.b(hVar);
                return;
            case ON_RESUME:
                this.f61a.c(hVar);
                return;
            case ON_PAUSE:
                this.f61a.d(hVar);
                return;
            case ON_STOP:
                this.f61a.e(hVar);
                return;
            case ON_DESTROY:
                this.f61a.f(hVar);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
