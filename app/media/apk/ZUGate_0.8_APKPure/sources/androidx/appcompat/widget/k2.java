package androidx.appcompat.widget;

import android.graphics.Rect;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
public abstract class k2 {
    public static void a(PopupWindow popupWindow, Rect rect) {
        popupWindow.setEpicenterBounds(rect);
    }

    public static void b(PopupWindow popupWindow, boolean z4) {
        popupWindow.setIsClippedToScreen(z4);
    }
}
