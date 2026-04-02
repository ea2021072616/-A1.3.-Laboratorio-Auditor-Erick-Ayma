package k1;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import p3.f;
import p3.g;
/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3539a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f3540b;

    public /* synthetic */ b(int i5, Object obj) {
        this.f3539a = i5;
        this.f3540b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i5 = this.f3539a;
        Object obj = this.f3540b;
        switch (i5) {
            case 0:
                ((c) obj).postInvalidate();
                return;
            case 1:
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                g gVar = ((BottomSheetBehavior) obj).f2034i;
                if (gVar != null) {
                    f fVar = gVar.f4294g;
                    if (fVar.f4283j != floatValue) {
                        fVar.f4283j = floatValue;
                        gVar.f4298k = true;
                        gVar.invalidateSelf();
                        return;
                    }
                    return;
                }
                return;
            default:
                ((TextInputLayout) obj).B0.k(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
        }
    }
}
