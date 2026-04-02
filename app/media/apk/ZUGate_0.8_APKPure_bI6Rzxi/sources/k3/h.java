package k3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: classes.dex */
public final class h extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f3654a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3655b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ i f3656c;

    public h(i iVar, boolean z4, int i5) {
        this.f3656c = iVar;
        this.f3654a = z4;
        this.f3655b = i5;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        i iVar = this.f3656c;
        iVar.f3641b.setTranslationX(0.0f);
        iVar.a(0.0f, this.f3655b, this.f3654a);
    }
}
