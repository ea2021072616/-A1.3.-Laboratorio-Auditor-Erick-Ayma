package h0;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;
/* loaded from: classes.dex */
public final class e2 extends d2 {

    /* renamed from: q  reason: collision with root package name */
    public static final h2 f3125q;

    static {
        WindowInsets windowInsets;
        windowInsets = WindowInsets.CONSUMED;
        f3125q = h2.i(null, windowInsets);
    }

    public e2(h2 h2Var, WindowInsets windowInsets) {
        super(h2Var, windowInsets);
    }

    @Override // h0.a2, h0.f2
    public final void d(View view) {
    }

    @Override // h0.a2, h0.f2
    public z.c f(int i5) {
        Insets insets;
        insets = this.f3099c.getInsets(g2.a(i5));
        return z.c.c(insets);
    }
}
