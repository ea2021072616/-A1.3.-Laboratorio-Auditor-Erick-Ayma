package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
/* loaded from: classes.dex */
public final class p implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f1444a;

    public p(q qVar) {
        this.f1444a = qVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        q qVar = this.f1444a;
        qVar.f1459c.setAlpha(floatValue);
        qVar.f1460d.setAlpha(floatValue);
        qVar.f1474s.invalidate();
    }
}
