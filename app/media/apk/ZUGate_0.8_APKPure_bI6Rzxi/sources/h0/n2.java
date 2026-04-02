package h0;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
/* loaded from: classes.dex */
public final class n2 {

    /* renamed from: a  reason: collision with root package name */
    public final p3.e f3183a;

    public n2(WindowInsetsController windowInsetsController) {
        this.f3183a = new m2(windowInsetsController, new d.u0(windowInsetsController));
    }

    public n2(Window window, View view) {
        d.u0 u0Var = new d.u0(view);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f3183a = new m2(window, u0Var);
        } else {
            this.f3183a = new k2(window, u0Var);
        }
    }
}
