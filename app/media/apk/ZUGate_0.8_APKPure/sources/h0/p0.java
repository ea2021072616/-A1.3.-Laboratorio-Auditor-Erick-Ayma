package h0;

import android.view.View;
import android.view.WindowInsets;
/* loaded from: classes.dex */
public abstract class p0 {
    public static h2 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        h2 i5 = h2.i(null, rootWindowInsets);
        f2 f2Var = i5.f3144a;
        f2Var.p(i5);
        f2Var.d(view.getRootView());
        return i5;
    }

    public static int b(View view) {
        return view.getScrollIndicators();
    }

    public static void c(View view, int i5) {
        view.setScrollIndicators(i5);
    }

    public static void d(View view, int i5, int i6) {
        view.setScrollIndicators(i5, i6);
    }
}
