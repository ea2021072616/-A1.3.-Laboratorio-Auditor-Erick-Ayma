package e1;

import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class b0 {
    public static int a(ViewGroup viewGroup, int i5) {
        return viewGroup.getChildDrawingOrder(i5);
    }

    public static void b(ViewGroup viewGroup, boolean z4) {
        viewGroup.suppressLayout(z4);
    }
}
