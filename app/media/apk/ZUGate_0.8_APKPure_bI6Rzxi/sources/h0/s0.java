package h0;

import android.view.View;
import com.github.appintro.R;
import java.util.Objects;
/* loaded from: classes.dex */
public abstract class s0 {
    public static void a(View view, x0 x0Var) {
        l.j jVar = (l.j) view.getTag(R.id.tag_unhandled_key_listeners);
        if (jVar == null) {
            jVar = new l.j();
            view.setTag(R.id.tag_unhandled_key_listeners, jVar);
        }
        Objects.requireNonNull(x0Var);
        View.OnUnhandledKeyEventListener r0Var = new r0();
        jVar.put(x0Var, r0Var);
        view.addOnUnhandledKeyEventListener(r0Var);
    }

    public static CharSequence b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    public static boolean c(View view) {
        return view.isAccessibilityHeading();
    }

    public static boolean d(View view) {
        return view.isScreenReaderFocusable();
    }

    public static void e(View view, x0 x0Var) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        l.j jVar = (l.j) view.getTag(R.id.tag_unhandled_key_listeners);
        if (jVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) jVar.getOrDefault(x0Var, null)) == null) {
            return;
        }
        view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
    }

    public static <T> T f(View view, int i5) {
        return (T) view.requireViewById(i5);
    }

    public static void g(View view, boolean z4) {
        view.setAccessibilityHeading(z4);
    }

    public static void h(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    public static void i(View view, k0.a aVar) {
        view.setAutofillId(null);
    }

    public static void j(View view, boolean z4) {
        view.setScreenReaderFocusable(z4);
    }
}
