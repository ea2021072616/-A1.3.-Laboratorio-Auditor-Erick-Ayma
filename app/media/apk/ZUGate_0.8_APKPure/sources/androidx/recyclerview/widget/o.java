package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: classes.dex */
public final class o extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1438a = false;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q f1439b;

    public o(q qVar) {
        this.f1439b = qVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f1438a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f1438a) {
            this.f1438a = false;
            return;
        }
        q qVar = this.f1439b;
        if (((Float) qVar.f1481z.getAnimatedValue()).floatValue() == 0.0f) {
            qVar.A = 0;
            qVar.f(0);
            return;
        }
        qVar.A = 2;
        qVar.f1474s.invalidate();
    }
}
