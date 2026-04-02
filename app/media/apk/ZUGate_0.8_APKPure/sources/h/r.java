package h;

import android.view.ActionProvider;
import d.u0;
/* loaded from: classes.dex */
public final class r implements ActionProvider.VisibilityListener {

    /* renamed from: a  reason: collision with root package name */
    public u0 f3066a;

    /* renamed from: b  reason: collision with root package name */
    public final ActionProvider f3067b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ v f3068c;

    public r(v vVar, ActionProvider actionProvider) {
        this.f3068c = vVar;
        this.f3067b = actionProvider;
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z4) {
        u0 u0Var = this.f3066a;
        if (u0Var != null) {
            o oVar = ((q) u0Var.f2463h).f3059t;
            oVar.f3032n = true;
            oVar.p(true);
        }
    }
}
