package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
/* loaded from: classes.dex */
public final class h extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1353a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f1354b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1355c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f1356d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k f1357e;

    public /* synthetic */ h(k kVar, i iVar, ViewPropertyAnimator viewPropertyAnimator, View view, int i5) {
        this.f1353a = i5;
        this.f1357e = kVar;
        this.f1354b = iVar;
        this.f1355c = viewPropertyAnimator;
        this.f1356d = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i5 = this.f1353a;
        k kVar = this.f1357e;
        i iVar = this.f1354b;
        View view = this.f1356d;
        ViewPropertyAnimator viewPropertyAnimator = this.f1355c;
        switch (i5) {
            case 0:
                viewPropertyAnimator.setListener(null);
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                kVar.c(iVar.f1366a);
                kVar.f1412r.remove(iVar.f1366a);
                kVar.i();
                return;
            default:
                viewPropertyAnimator.setListener(null);
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                kVar.c(iVar.f1367b);
                kVar.f1412r.remove(iVar.f1367b);
                kVar.i();
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i5 = this.f1353a;
        k kVar = this.f1357e;
        i iVar = this.f1354b;
        switch (i5) {
            case 0:
                i1 i1Var = iVar.f1366a;
                kVar.getClass();
                return;
            default:
                i1 i1Var2 = iVar.f1367b;
                kVar.getClass();
                return;
        }
    }
}
