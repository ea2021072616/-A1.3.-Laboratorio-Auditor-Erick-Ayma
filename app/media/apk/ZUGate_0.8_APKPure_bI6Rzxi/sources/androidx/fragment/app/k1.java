package androidx.fragment.app;

import android.transition.Transition;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class k1 implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f936a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f937b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f938c = null;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ArrayList f939d = null;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f940e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f941f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ m1 f942g;

    public k1(m1 m1Var, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.f942g = m1Var;
        this.f936a = obj;
        this.f937b = arrayList;
        this.f940e = obj2;
        this.f941f = arrayList2;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        m1 m1Var = this.f942g;
        Object obj = this.f936a;
        if (obj != null) {
            m1Var.t(obj, this.f937b, null);
        }
        Object obj2 = this.f938c;
        if (obj2 != null) {
            m1Var.t(obj2, this.f939d, null);
        }
        Object obj3 = this.f940e;
        if (obj3 != null) {
            m1Var.t(obj3, this.f941f, null);
        }
    }
}
