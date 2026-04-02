package h0;

import android.view.View;
import android.view.WindowInsetsController;
/* loaded from: classes.dex */
public abstract class u0 {
    public static int a(View view) {
        return view.getImportantForContentCapture();
    }

    public static CharSequence b(View view) {
        return view.getStateDescription();
    }

    public static n2 c(View view) {
        WindowInsetsController windowInsetsController = view.getWindowInsetsController();
        if (windowInsetsController != null) {
            return new n2(windowInsetsController);
        }
        return null;
    }

    public static boolean d(View view) {
        return view.isImportantForContentCapture();
    }

    public static void e(View view, int i5) {
        view.setImportantForContentCapture(i5);
    }

    public static void f(View view, CharSequence charSequence) {
        view.setStateDescription(charSequence);
    }
}
