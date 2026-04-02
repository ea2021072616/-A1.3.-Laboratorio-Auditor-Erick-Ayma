package h0;

import android.view.View;
import android.view.Window;
/* loaded from: classes.dex */
public abstract class i2 extends p3.e {

    /* renamed from: k  reason: collision with root package name */
    public final Window f3156k;

    /* renamed from: l  reason: collision with root package name */
    public final d.u0 f3157l;

    public i2(Window window, d.u0 u0Var) {
        super(8);
        this.f3156k = window;
        this.f3157l = u0Var;
    }

    public final void A(int i5) {
        View decorView = this.f3156k.getDecorView();
        decorView.setSystemUiVisibility((~i5) & decorView.getSystemUiVisibility());
    }

    @Override // p3.e
    public final void y() {
        for (int i5 = 1; i5 <= 256; i5 <<= 1) {
            if ((8 & i5) != 0) {
                if (i5 == 1) {
                    A(4);
                    this.f3156k.clearFlags(1024);
                } else if (i5 == 2) {
                    A(2);
                } else if (i5 == 8) {
                    ((p3.e) this.f3157l.f2463h).x();
                }
            }
        }
    }
}
