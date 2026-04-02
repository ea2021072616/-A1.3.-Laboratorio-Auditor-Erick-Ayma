package androidx.fragment.app;

import android.transition.Transition;
/* loaded from: classes.dex */
public final class l1 implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f947a;

    public l1(e0.a aVar) {
        this.f947a = aVar;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        this.f947a.run();
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
    }
}
