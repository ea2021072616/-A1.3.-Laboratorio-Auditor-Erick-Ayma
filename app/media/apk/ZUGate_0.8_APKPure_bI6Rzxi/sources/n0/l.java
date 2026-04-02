package n0;

import android.widget.PopupWindow;
/* loaded from: classes.dex */
public abstract class l {
    public static boolean a(PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }

    public static int b(PopupWindow popupWindow) {
        return popupWindow.getWindowLayoutType();
    }

    public static void c(PopupWindow popupWindow, boolean z4) {
        popupWindow.setOverlapAnchor(z4);
    }

    public static void d(PopupWindow popupWindow, int i5) {
        popupWindow.setWindowLayoutType(i5);
    }
}
