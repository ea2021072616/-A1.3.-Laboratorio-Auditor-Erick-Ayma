package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
public final class f implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s1 f871a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f872b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f873c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k f874d;

    public f(View view, ViewGroup viewGroup, k kVar, s1 s1Var) {
        this.f871a = s1Var;
        this.f872b = viewGroup;
        this.f873c = view;
        this.f874d = kVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.f872b.post(new e(0, this));
        if (w0.I(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f871a + " has ended.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        if (w0.I(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f871a + " has reached onAnimationStart.");
        }
    }
}
