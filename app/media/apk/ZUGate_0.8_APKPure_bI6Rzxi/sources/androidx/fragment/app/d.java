package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f853a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f854b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f855c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ s1 f856d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k f857e;

    public d(ViewGroup viewGroup, View view, boolean z4, s1 s1Var, k kVar) {
        this.f853a = viewGroup;
        this.f854b = view;
        this.f855c = z4;
        this.f856d = s1Var;
        this.f857e = kVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.f853a;
        View view = this.f854b;
        viewGroup.endViewTransition(view);
        boolean z4 = this.f855c;
        s1 s1Var = this.f856d;
        if (z4) {
            androidx.appcompat.widget.b0.a(s1Var.f999a, view);
        }
        this.f857e.a();
        if (w0.I(2)) {
            Log.v("FragmentManager", "Animator from operation " + s1Var + " has ended.");
        }
    }
}
