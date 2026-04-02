package h0;

import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public abstract class c1 {
    public static int a(ViewConfiguration viewConfiguration, int i5, int i6, int i7) {
        return viewConfiguration.getScaledMaximumFlingVelocity(i5, i6, i7);
    }

    public static int b(ViewConfiguration viewConfiguration, int i5, int i6, int i7) {
        return viewConfiguration.getScaledMinimumFlingVelocity(i5, i6, i7);
    }
}
