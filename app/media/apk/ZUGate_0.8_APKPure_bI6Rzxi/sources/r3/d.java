package r3;

import android.animation.ValueAnimator;
/* loaded from: classes.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f4497a;

    public d(l lVar, int i5) {
        this.f4497a = lVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        v0.b bVar = l.f4514u;
        this.f4497a.f4528i.setTranslationY(intValue);
    }
}
