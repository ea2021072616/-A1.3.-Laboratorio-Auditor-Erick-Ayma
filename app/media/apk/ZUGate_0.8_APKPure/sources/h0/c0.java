package h0;

import android.graphics.Insets;
import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public abstract /* synthetic */ class c0 {
    public static /* synthetic */ WindowInsetsAnimation.Bounds h(Insets insets, Insets insets2) {
        return new WindowInsetsAnimation.Bounds(insets, insets2);
    }

    public static /* synthetic */ WindowInsetsAnimation i(int i5, Interpolator interpolator, long j5) {
        return new WindowInsetsAnimation(i5, interpolator, j5);
    }

    public static /* bridge */ /* synthetic */ WindowInsetsAnimation j(Object obj) {
        return (WindowInsetsAnimation) obj;
    }

    public static /* synthetic */ void m() {
    }
}
