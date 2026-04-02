package e1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: classes.dex */
public final class n extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f2630a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f2631b;

    public /* synthetic */ n(Object obj, l.b bVar) {
        this.f2631b = obj;
        this.f2630a = bVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ((l.b) this.f2630a).remove(animator);
        ((r) this.f2631b).o.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        ((r) this.f2631b).o.add(animator);
    }
}
