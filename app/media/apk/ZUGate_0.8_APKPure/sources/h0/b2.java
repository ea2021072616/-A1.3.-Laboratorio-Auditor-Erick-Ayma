package h0;

import android.view.WindowInsets;
/* loaded from: classes.dex */
public class b2 extends a2 {

    /* renamed from: m  reason: collision with root package name */
    public z.c f3108m;

    public b2(h2 h2Var, WindowInsets windowInsets) {
        super(h2Var, windowInsets);
        this.f3108m = null;
    }

    @Override // h0.f2
    public h2 b() {
        return h2.i(null, this.f3099c.consumeStableInsets());
    }

    @Override // h0.f2
    public h2 c() {
        return h2.i(null, this.f3099c.consumeSystemWindowInsets());
    }

    @Override // h0.f2
    public final z.c h() {
        if (this.f3108m == null) {
            WindowInsets windowInsets = this.f3099c;
            this.f3108m = z.c.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f3108m;
    }

    @Override // h0.f2
    public boolean m() {
        return this.f3099c.isConsumed();
    }

    @Override // h0.f2
    public void q(z.c cVar) {
        this.f3108m = cVar;
    }
}
