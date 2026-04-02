package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class j0 implements View.OnAttachStateChangeListener {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f927g = 1;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ d1 f928h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f929i;

    public j0(k0 k0Var, d1 d1Var) {
        this.f929i = k0Var;
        this.f928h = d1Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i5 = this.f927g;
        Object obj = this.f929i;
        switch (i5) {
            case 0:
                d1 d1Var = this.f928h;
                Fragment fragment = d1Var.f860c;
                d1Var.j();
                t1.g((ViewGroup) fragment.mView.getParent(), ((k0) obj).f935g).e();
                return;
            default:
                View view2 = (View) obj;
                view2.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap = h0.z0.f3233a;
                h0.m0.c(view2);
                return;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }

    public j0(d1 d1Var, View view) {
        this.f928h = d1Var;
        this.f929i = view;
    }
}
