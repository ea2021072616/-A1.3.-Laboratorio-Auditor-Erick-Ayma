package e1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public final class l0 extends AnimatorListenerAdapter implements p {

    /* renamed from: a  reason: collision with root package name */
    public final View f2619a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2620b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f2621c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2623e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2624f = false;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2622d = true;

    public l0(View view, int i5) {
        this.f2619a = view;
        this.f2620b = i5;
        this.f2621c = (ViewGroup) view.getParent();
        g(true);
    }

    @Override // e1.p
    public final void a(r rVar) {
    }

    @Override // e1.p
    public final void c() {
        g(false);
        if (this.f2624f) {
            return;
        }
        c0.b(this.f2619a, this.f2620b);
    }

    @Override // e1.p
    public final void d(r rVar) {
    }

    @Override // e1.p
    public final void e() {
        g(true);
        if (this.f2624f) {
            return;
        }
        c0.b(this.f2619a, 0);
    }

    @Override // e1.p
    public final void f(r rVar) {
        rVar.z(this);
    }

    public final void g(boolean z4) {
        ViewGroup viewGroup;
        if (!this.f2622d || this.f2623e == z4 || (viewGroup = this.f2621c) == null) {
            return;
        }
        this.f2623e = z4;
        com.google.android.gms.internal.play_billing.i0.S(viewGroup, z4);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f2624f = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f2624f) {
            c0.b(this.f2619a, this.f2620b);
            ViewGroup viewGroup = this.f2621c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        g(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z4) {
        if (z4) {
            c0.b(this.f2619a, 0);
            ViewGroup viewGroup = this.f2621c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z4) {
        if (z4) {
            return;
        }
        if (!this.f2624f) {
            c0.b(this.f2619a, this.f2620b);
            ViewGroup viewGroup = this.f2621c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        g(false);
    }
}
