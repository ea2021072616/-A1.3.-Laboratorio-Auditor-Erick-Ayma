package h0;

import android.view.WindowInsets;
/* loaded from: classes.dex */
public class x1 extends z1 {

    /* renamed from: c  reason: collision with root package name */
    public final WindowInsets.Builder f3228c;

    public x1() {
        this.f3228c = androidx.appcompat.widget.l1.g();
    }

    @Override // h0.z1
    public h2 b() {
        WindowInsets build;
        a();
        build = this.f3228c.build();
        h2 i5 = h2.i(null, build);
        i5.f3144a.o(this.f3240b);
        return i5;
    }

    @Override // h0.z1
    public void d(z.c cVar) {
        this.f3228c.setMandatorySystemGestureInsets(cVar.d());
    }

    @Override // h0.z1
    public void e(z.c cVar) {
        this.f3228c.setStableInsets(cVar.d());
    }

    @Override // h0.z1
    public void f(z.c cVar) {
        this.f3228c.setSystemGestureInsets(cVar.d());
    }

    @Override // h0.z1
    public void g(z.c cVar) {
        this.f3228c.setSystemWindowInsets(cVar.d());
    }

    @Override // h0.z1
    public void h(z.c cVar) {
        this.f3228c.setTappableElementInsets(cVar.d());
    }

    public x1(h2 h2Var) {
        super(h2Var);
        WindowInsets.Builder g5;
        WindowInsets h5 = h2Var.h();
        if (h5 != null) {
            g5 = androidx.appcompat.widget.l1.h(h5);
        } else {
            g5 = androidx.appcompat.widget.l1.g();
        }
        this.f3228c = g5;
    }
}
