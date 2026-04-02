package r3;

import android.view.View;
import h0.h2;
import h0.x;
/* loaded from: classes.dex */
public final class h implements x {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ l f4501g;

    public /* synthetic */ h(l lVar) {
        this.f4501g = lVar;
    }

    @Override // h0.x
    public final h2 a(View view, h2 h2Var) {
        int b5 = h2Var.b();
        l lVar = this.f4501g;
        lVar.f4532m = b5;
        lVar.f4533n = h2Var.c();
        lVar.o = h2Var.d();
        lVar.e();
        return h2Var;
    }

    public final void b(View view) {
        if (view.getParent() != null) {
            view.setVisibility(8);
        }
        this.f4501g.a(0);
    }
}
