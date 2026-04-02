package androidx.fragment.app;

import android.view.View;
/* loaded from: classes.dex */
public final class u extends g0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Fragment f1015g;

    public u(Fragment fragment) {
        this.f1015g = fragment;
    }

    @Override // androidx.fragment.app.g0
    public final View b(int i5) {
        Fragment fragment = this.f1015g;
        View view = fragment.mView;
        if (view != null) {
            return view.findViewById(i5);
        }
        throw new IllegalStateException(androidx.appcompat.widget.b0.g("Fragment ", fragment, " does not have a view"));
    }

    @Override // androidx.fragment.app.g0
    public final boolean c() {
        return this.f1015g.mView != null;
    }
}
