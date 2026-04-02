package e1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class m0 extends AnimatorListenerAdapter implements p {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f2625a;

    /* renamed from: b  reason: collision with root package name */
    public final View f2626b;

    /* renamed from: c  reason: collision with root package name */
    public final View f2627c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2628d = true;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ g f2629e;

    public m0(g gVar, ViewGroup viewGroup, View view, View view2) {
        this.f2629e = gVar;
        this.f2625a = viewGroup;
        this.f2626b = view;
        this.f2627c = view2;
    }

    @Override // e1.p
    public final void a(r rVar) {
    }

    @Override // e1.p
    public final void c() {
    }

    @Override // e1.p
    public final void d(r rVar) {
        if (this.f2628d) {
            g();
        }
    }

    @Override // e1.p
    public final void e() {
    }

    @Override // e1.p
    public final void f(r rVar) {
        rVar.z(this);
    }

    public final void g() {
        this.f2627c.setTag(R.id.save_overlay_view, null);
        this.f2625a.getOverlay().remove(this.f2626b);
        this.f2628d = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        g();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        this.f2625a.getOverlay().remove(this.f2626b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        View view = this.f2626b;
        if (view.getParent() == null) {
            this.f2625a.getOverlay().add(view);
        } else {
            this.f2629e.d();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z4) {
        if (z4) {
            View view = this.f2627c;
            View view2 = this.f2626b;
            view.setTag(R.id.save_overlay_view, view2);
            this.f2625a.getOverlay().add(view2);
            this.f2628d = true;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z4) {
        if (z4) {
            return;
        }
        g();
    }
}
