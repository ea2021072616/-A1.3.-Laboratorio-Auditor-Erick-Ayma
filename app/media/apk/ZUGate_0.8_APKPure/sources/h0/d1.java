package h0;

import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class d1 {
    public static int a(ViewGroup viewGroup) {
        return viewGroup.getNestedScrollAxes();
    }

    public static boolean b(ViewGroup viewGroup) {
        return viewGroup.isTransitionGroup();
    }

    public static void c(ViewGroup viewGroup, boolean z4) {
        viewGroup.setTransitionGroup(z4);
    }
}
