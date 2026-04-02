package d;

import android.view.MenuItem;
import android.view.ViewGroup;
import h0.k1;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class c0 implements g.a {

    /* renamed from: a  reason: collision with root package name */
    public final g.a f2290a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n0 f2291b;

    public c0(n0 n0Var, g.a aVar) {
        this.f2291b = n0Var;
        this.f2290a = aVar;
    }

    @Override // g.a
    public final boolean a(g.b bVar, h.o oVar) {
        ViewGroup viewGroup = this.f2291b.G;
        WeakHashMap weakHashMap = h0.z0.f3233a;
        h0.m0.c(viewGroup);
        return this.f2290a.a(bVar, oVar);
    }

    @Override // g.a
    public final void b(g.b bVar) {
        this.f2290a.b(bVar);
        n0 n0Var = this.f2291b;
        if (n0Var.C != null) {
            n0Var.f2433r.getDecorView().removeCallbacks(n0Var.D);
        }
        if (n0Var.B != null) {
            k1 k1Var = n0Var.E;
            if (k1Var != null) {
                k1Var.b();
            }
            k1 a5 = h0.z0.a(n0Var.B);
            a5.a(0.0f);
            n0Var.E = a5;
            a5.d(new b0(2, this));
        }
        r rVar = n0Var.f2435t;
        if (rVar != null) {
            rVar.onSupportActionModeFinished(n0Var.A);
        }
        n0Var.A = null;
        ViewGroup viewGroup = n0Var.G;
        WeakHashMap weakHashMap = h0.z0.f3233a;
        h0.m0.c(viewGroup);
        n0Var.K();
    }

    @Override // g.a
    public final boolean c(g.b bVar, h.o oVar) {
        return this.f2290a.c(bVar, oVar);
    }

    @Override // g.a
    public final boolean d(g.b bVar, MenuItem menuItem) {
        return this.f2290a.d(bVar, menuItem);
    }
}
