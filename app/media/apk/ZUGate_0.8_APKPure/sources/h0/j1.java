package h0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* loaded from: classes.dex */
public final class j1 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3159a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f3160b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f3161c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f3162d;

    public /* synthetic */ j1(Object obj, Object obj2, Object obj3, int i5) {
        this.f3159a = i5;
        this.f3162d = obj;
        this.f3161c = obj2;
        this.f3160b = obj3;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f3159a) {
            case 0:
                ((l1) this.f3161c).b();
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i5 = this.f3159a;
        Object obj = this.f3161c;
        switch (i5) {
            case 0:
                ((l1) obj).a();
                return;
            default:
                ((u1) obj).f3214a.d(1.0f);
                q1.e((View) this.f3160b);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f3159a) {
            case 0:
                ((l1) this.f3161c).c();
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }
}
