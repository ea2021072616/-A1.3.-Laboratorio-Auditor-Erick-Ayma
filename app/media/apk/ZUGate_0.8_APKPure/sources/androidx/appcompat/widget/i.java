package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public final class i extends h.y {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f376m = 0;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ n f377n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(n nVar, Context context, h.o oVar, m mVar) {
        super(context, oVar, mVar, true);
        this.f377n = nVar;
        this.f3084g = 8388613;
        d.u0 u0Var = nVar.C;
        this.f3086i = u0Var;
        h.w wVar = this.f3087j;
        if (wVar != null) {
            wVar.c(u0Var);
        }
    }

    @Override // h.y
    public final void c() {
        int i5 = this.f376m;
        n nVar = this.f377n;
        switch (i5) {
            case 0:
                nVar.f432z = null;
                super.c();
                return;
            default:
                h.o oVar = nVar.f416i;
                if (oVar != null) {
                    oVar.c(true);
                }
                nVar.f431y = null;
                super.c();
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(n nVar, Context context, h.g0 g0Var, View view) {
        super(context, g0Var, view, false);
        this.f377n = nVar;
        if (!g0Var.G.f()) {
            View view2 = nVar.o;
            this.f3083f = view2 == null ? (View) nVar.f421n : view2;
        }
        d.u0 u0Var = nVar.C;
        this.f3086i = u0Var;
        h.w wVar = this.f3087j;
        if (wVar != null) {
            wVar.c(u0Var);
        }
    }
}
