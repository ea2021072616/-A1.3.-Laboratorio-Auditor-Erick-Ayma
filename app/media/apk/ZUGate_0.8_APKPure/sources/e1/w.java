package e1;
/* loaded from: classes.dex */
public final class w extends s {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2681a;

    /* renamed from: b  reason: collision with root package name */
    public final x f2682b;

    public w(x xVar, int i5) {
        this.f2681a = i5;
        if (i5 != 1) {
            this.f2682b = xVar;
        } else {
            this.f2682b = xVar;
        }
    }

    @Override // e1.s, e1.p
    public final void a(r rVar) {
        switch (this.f2681a) {
            case 1:
                x xVar = this.f2682b;
                if (xVar.F) {
                    return;
                }
                xVar.J();
                xVar.F = true;
                return;
            default:
                return;
        }
    }

    @Override // e1.s, e1.p
    public final void d(r rVar) {
        switch (this.f2681a) {
            case 0:
                x xVar = this.f2682b;
                xVar.C.remove(rVar);
                if (xVar.t()) {
                    return;
                }
                xVar.x(xVar, q.f2646c);
                xVar.f2667s = true;
                xVar.x(xVar, q.f2645b);
                return;
            default:
                return;
        }
    }

    @Override // e1.p
    public final void f(r rVar) {
        switch (this.f2681a) {
            case 1:
                x xVar = this.f2682b;
                int i5 = xVar.E - 1;
                xVar.E = i5;
                if (i5 == 0) {
                    xVar.F = false;
                    xVar.n();
                }
                rVar.z(this);
                return;
            default:
                return;
        }
    }
}
