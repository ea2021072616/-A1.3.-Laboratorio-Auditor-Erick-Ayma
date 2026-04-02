package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
/* loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1336a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i1 f1337b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f1338c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1339d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k f1340e;

    public f(k kVar, i1 i1Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1340e = kVar;
        this.f1337b = i1Var;
        this.f1339d = viewPropertyAnimator;
        this.f1338c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f1336a) {
            case 1:
                this.f1338c.setAlpha(1.0f);
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i5 = this.f1336a;
        i1 i1Var = this.f1337b;
        k kVar = this.f1340e;
        ViewPropertyAnimator viewPropertyAnimator = this.f1339d;
        switch (i5) {
            case 0:
                viewPropertyAnimator.setListener(null);
                this.f1338c.setAlpha(1.0f);
                kVar.c(i1Var);
                kVar.f1411q.remove(i1Var);
                kVar.i();
                return;
            default:
                viewPropertyAnimator.setListener(null);
                kVar.c(i1Var);
                kVar.o.remove(i1Var);
                kVar.i();
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i5 = this.f1336a;
        k kVar = this.f1340e;
        switch (i5) {
            case 0:
                kVar.getClass();
                return;
            default:
                kVar.getClass();
                return;
        }
    }

    public f(k kVar, i1 i1Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f1340e = kVar;
        this.f1337b = i1Var;
        this.f1338c = view;
        this.f1339d = viewPropertyAnimator;
    }
}
