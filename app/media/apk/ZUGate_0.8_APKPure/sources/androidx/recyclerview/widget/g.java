package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
/* loaded from: classes.dex */
public final class g extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i1 f1345a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1346b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f1347c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f1348d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1349e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ k f1350f;

    public g(k kVar, i1 i1Var, int i5, View view, int i6, ViewPropertyAnimator viewPropertyAnimator) {
        this.f1350f = kVar;
        this.f1345a = i1Var;
        this.f1346b = i5;
        this.f1347c = view;
        this.f1348d = i6;
        this.f1349e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i5 = this.f1346b;
        View view = this.f1347c;
        if (i5 != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f1348d != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f1349e.setListener(null);
        k kVar = this.f1350f;
        i1 i1Var = this.f1345a;
        kVar.c(i1Var);
        kVar.f1410p.remove(i1Var);
        kVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f1350f.getClass();
    }
}
