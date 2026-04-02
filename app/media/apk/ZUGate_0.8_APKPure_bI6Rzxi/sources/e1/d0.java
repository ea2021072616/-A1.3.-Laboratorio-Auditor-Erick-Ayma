package e1;

import android.view.View;
/* loaded from: classes.dex */
public abstract class d0 {
    public static float a(View view) {
        float transitionAlpha;
        transitionAlpha = view.getTransitionAlpha();
        return transitionAlpha;
    }

    public static void b(View view, float f5) {
        view.setTransitionAlpha(f5);
    }
}
