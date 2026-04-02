package s3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4866a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f4867b;

    public /* synthetic */ c(d dVar, int i5) {
        this.f4866a = i5;
        this.f4867b = dVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f4866a) {
            case 1:
                this.f4867b.f4916b.h(false);
                return;
            default:
                super.onAnimationEnd(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f4866a) {
            case 0:
                this.f4867b.f4916b.h(true);
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }
}
