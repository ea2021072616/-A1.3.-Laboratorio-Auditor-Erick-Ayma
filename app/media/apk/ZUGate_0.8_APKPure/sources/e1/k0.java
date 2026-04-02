package e1;

import android.graphics.Matrix;
import android.view.View;
/* loaded from: classes.dex */
public final class k0 extends j0 {
    @Override // e4.e
    public final void S(View view, float f5) {
        view.setTransitionAlpha(f5);
    }

    @Override // e1.j0, e4.e
    public final void T(View view, int i5) {
        view.setTransitionVisibility(i5);
    }

    @Override // e1.f0
    public final void k0(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // e1.f0
    public final void l0(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    @Override // e1.h0
    public final void m0(View view, int i5, int i6, int i7, int i8) {
        view.setLeftTopRightBottom(i5, i6, i7, i8);
    }

    @Override // e4.e
    public final float w(View view) {
        float transitionAlpha;
        transitionAlpha = view.getTransitionAlpha();
        return transitionAlpha;
    }
}
