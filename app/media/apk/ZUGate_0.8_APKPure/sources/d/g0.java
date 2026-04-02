package d;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;
/* loaded from: classes.dex */
public abstract class g0 {
    public static OnBackInvokedDispatcher a(Activity activity) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
        return onBackInvokedDispatcher;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.window.OnBackInvokedCallback, d.f0] */
    public static OnBackInvokedCallback b(Object obj, final n0 n0Var) {
        Objects.requireNonNull(n0Var);
        ?? r02 = new OnBackInvokedCallback() { // from class: d.f0
            public final void onBackInvoked() {
                n0.this.F();
            }
        };
        androidx.activity.o.f(obj).registerOnBackInvokedCallback(1000000, r02);
        return r02;
    }

    public static void c(Object obj, Object obj2) {
        androidx.activity.o.f(obj).unregisterOnBackInvokedCallback(androidx.activity.o.b(obj2));
    }
}
