package androidx.fragment.app;

import android.util.Log;
import android.view.View;
/* loaded from: classes.dex */
public final class v implements k.a, androidx.lifecycle.b0, d0.b {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f1016g;

    public /* synthetic */ v(Object obj) {
        this.f1016g = obj;
    }

    @Override // k.a
    public final Object a(Object obj) {
        Fragment fragment = (Fragment) this.f1016g;
        i0 i0Var = fragment.mHost;
        return i0Var instanceof androidx.activity.result.i ? ((androidx.activity.result.i) i0Var).getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
    }

    @Override // androidx.lifecycle.b0
    public final void b(Object obj) {
        if (((androidx.lifecycle.t) obj) != null) {
            r rVar = (r) this.f1016g;
            if (rVar.f985n) {
                View requireView = rVar.requireView();
                if (requireView.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                if (rVar.f988r != null) {
                    if (w0.I(3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + rVar.f988r);
                    }
                    rVar.f988r.setContentView(requireView);
                }
            }
        }
    }

    @Override // d0.b
    public final void c() {
        ((s1) this.f1016g).a();
    }
}
