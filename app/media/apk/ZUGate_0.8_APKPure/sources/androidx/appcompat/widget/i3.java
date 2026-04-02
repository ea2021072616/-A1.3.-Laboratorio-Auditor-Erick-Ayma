package androidx.appcompat.widget;

import android.view.MenuItem;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class i3 implements q, h.m {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Toolbar f391g;

    public /* synthetic */ i3(Toolbar toolbar) {
        this.f391g = toolbar;
    }

    @Override // h.m
    public final void c(h.o oVar) {
        Toolbar toolbar = this.f391g;
        n nVar = toolbar.f249g.f207z;
        if (!(nVar != null && nVar.j())) {
            Iterator it = toolbar.M.f3195b.iterator();
            while (it.hasNext()) {
                ((androidx.fragment.app.p0) ((h0.s) it.next())).f966a.s(oVar);
            }
        }
        h.m mVar = toolbar.U;
        if (mVar != null) {
            mVar.c(oVar);
        }
    }

    @Override // h.m
    public final boolean d(h.o oVar, MenuItem menuItem) {
        h.m mVar = this.f391g.U;
        return mVar != null && mVar.d(oVar, menuItem);
    }
}
