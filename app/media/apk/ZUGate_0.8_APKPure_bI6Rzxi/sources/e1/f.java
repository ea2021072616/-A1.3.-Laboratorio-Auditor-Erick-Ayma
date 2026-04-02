package e1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter implements p {

    /* renamed from: a  reason: collision with root package name */
    public final View f2599a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2600b = false;

    public f(View view) {
        this.f2599a = view;
    }

    @Override // e1.p
    public final void a(r rVar) {
    }

    @Override // e1.p
    public final void b(r rVar) {
    }

    @Override // e1.p
    public final void c() {
        View view = this.f2599a;
        view.setTag(R.id.transition_pause_alpha, Float.valueOf(view.getVisibility() == 0 ? c0.f2590a.w(view) : 0.0f));
    }

    @Override // e1.p
    public final void d(r rVar) {
    }

    @Override // e1.p
    public final void e() {
        this.f2599a.setTag(R.id.transition_pause_alpha, null);
    }

    @Override // e1.p
    public final void f(r rVar) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        c0.f2590a.S(this.f2599a, 1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        onAnimationEnd(animator, false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.f2599a;
        if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
            this.f2600b = true;
            view.setLayerType(2, null);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z4) {
        boolean z5 = this.f2600b;
        View view = this.f2599a;
        if (z5) {
            view.setLayerType(0, null);
        }
        if (z4) {
            return;
        }
        j0 j0Var = c0.f2590a;
        j0Var.S(view, 1.0f);
        j0Var.getClass();
    }
}
