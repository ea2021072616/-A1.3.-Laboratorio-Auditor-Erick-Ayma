package h0;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
/* loaded from: classes.dex */
public final class m2 extends p3.e {

    /* renamed from: k  reason: collision with root package name */
    public final WindowInsetsController f3170k;

    /* renamed from: l  reason: collision with root package name */
    public final d.u0 f3171l;

    /* renamed from: m  reason: collision with root package name */
    public final Window f3172m;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public m2(android.view.Window r2, d.u0 r3) {
        /*
            r1 = this;
            android.view.WindowInsetsController r0 = h0.c0.l(r2)
            r1.<init>(r0, r3)
            r1.f3172m = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.m2.<init>(android.view.Window, d.u0):void");
    }

    @Override // p3.e
    public final boolean o() {
        int systemBarsAppearance;
        WindowInsetsController windowInsetsController = this.f3170k;
        windowInsetsController.setSystemBarsAppearance(0, 0);
        systemBarsAppearance = windowInsetsController.getSystemBarsAppearance();
        return (systemBarsAppearance & 8) != 0;
    }

    @Override // p3.e
    public final void u(boolean z4) {
        WindowInsetsController windowInsetsController = this.f3170k;
        Window window = this.f3172m;
        if (z4) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            windowInsetsController.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        windowInsetsController.setSystemBarsAppearance(0, 16);
    }

    @Override // p3.e
    public final void v(boolean z4) {
        WindowInsetsController windowInsetsController = this.f3170k;
        Window window = this.f3172m;
        if (z4) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            windowInsetsController.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        windowInsetsController.setSystemBarsAppearance(0, 8);
    }

    @Override // p3.e
    public final void y() {
        ((p3.e) this.f3171l.f2463h).x();
        this.f3170k.show(0);
    }

    public m2(WindowInsetsController windowInsetsController, d.u0 u0Var) {
        super(8);
        this.f3170k = windowInsetsController;
        this.f3171l = u0Var;
    }
}
