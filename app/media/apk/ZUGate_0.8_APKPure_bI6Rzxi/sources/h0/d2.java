package h0;

import android.graphics.Insets;
import android.view.WindowInsets;
/* loaded from: classes.dex */
public class d2 extends c2 {

    /* renamed from: n  reason: collision with root package name */
    public z.c f3112n;
    public z.c o;

    /* renamed from: p  reason: collision with root package name */
    public z.c f3113p;

    public d2(h2 h2Var, WindowInsets windowInsets) {
        super(h2Var, windowInsets);
        this.f3112n = null;
        this.o = null;
        this.f3113p = null;
    }

    @Override // h0.f2
    public z.c g() {
        Insets mandatorySystemGestureInsets;
        if (this.o == null) {
            mandatorySystemGestureInsets = this.f3099c.getMandatorySystemGestureInsets();
            this.o = z.c.c(mandatorySystemGestureInsets);
        }
        return this.o;
    }

    @Override // h0.f2
    public z.c i() {
        Insets systemGestureInsets;
        if (this.f3112n == null) {
            systemGestureInsets = this.f3099c.getSystemGestureInsets();
            this.f3112n = z.c.c(systemGestureInsets);
        }
        return this.f3112n;
    }

    @Override // h0.f2
    public z.c k() {
        Insets tappableElementInsets;
        if (this.f3113p == null) {
            tappableElementInsets = this.f3099c.getTappableElementInsets();
            this.f3113p = z.c.c(tappableElementInsets);
        }
        return this.f3113p;
    }

    @Override // h0.a2, h0.f2
    public h2 l(int i5, int i6, int i7, int i8) {
        WindowInsets inset;
        inset = this.f3099c.inset(i5, i6, i7, i8);
        return h2.i(null, inset);
    }

    @Override // h0.b2, h0.f2
    public void q(z.c cVar) {
    }
}
