package h0;

import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public abstract class b1 {
    public static int a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHoverSlop();
    }

    public static boolean b(ViewConfiguration viewConfiguration) {
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
}
