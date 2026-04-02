package r3;

import android.animation.ValueAnimator;
/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4493a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f4494b;

    public /* synthetic */ b(l lVar, int i5) {
        this.f4493a = i5;
        this.f4494b = lVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i5 = this.f4493a;
        l lVar = this.f4494b;
        switch (i5) {
            case 0:
                lVar.f4528i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
            default:
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                lVar.f4528i.setScaleX(floatValue);
                lVar.f4528i.setScaleY(floatValue);
                return;
        }
    }
}
