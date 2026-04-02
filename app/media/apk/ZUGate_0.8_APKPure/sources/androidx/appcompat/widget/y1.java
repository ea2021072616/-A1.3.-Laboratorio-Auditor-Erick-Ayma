package androidx.appcompat.widget;

import android.widget.AbsListView;
/* loaded from: classes.dex */
public abstract class y1 {
    public static boolean a(AbsListView absListView) {
        return absListView.isSelectedChildViewEnabled();
    }

    public static void b(AbsListView absListView, boolean z4) {
        absListView.setSelectedChildViewEnabled(z4);
    }
}
