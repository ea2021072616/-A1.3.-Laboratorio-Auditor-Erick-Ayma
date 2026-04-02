package d;

import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.c2;
import androidx.appcompat.widget.q1;
import h0.h2;
/* loaded from: classes.dex */
public final class a0 implements h0.x, c2, q1, c, h.z {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f2279g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ n0 f2280h;

    public /* synthetic */ a0(n0 n0Var, int i5) {
        this.f2279g = i5;
        this.f2280h = n0Var;
    }

    @Override // h0.x
    public final h2 a(View view, h2 h2Var) {
        int e5 = h2Var.e();
        int L = this.f2280h.L(h2Var, null);
        if (e5 != L) {
            h2Var = h2Var.g(h2Var.c(), L, h2Var.d(), h2Var.b());
        }
        return h0.z0.i(view, h2Var);
    }

    @Override // h.z
    public final void b(h.o oVar, boolean z4) {
        m0 m0Var;
        int i5 = this.f2279g;
        n0 n0Var = this.f2280h;
        switch (i5) {
            case 4:
                n0Var.t(oVar);
                return;
            default:
                h.o k5 = oVar.k();
                int i6 = 0;
                boolean z5 = k5 != oVar;
                if (z5) {
                    oVar = k5;
                }
                m0[] m0VarArr = n0Var.R;
                int length = m0VarArr != null ? m0VarArr.length : 0;
                while (true) {
                    if (i6 >= length) {
                        m0Var = null;
                    } else {
                        m0Var = m0VarArr[i6];
                        if (m0Var == null || m0Var.f2406h != oVar) {
                            i6++;
                        }
                    }
                }
                if (m0Var != null) {
                    if (!z5) {
                        n0Var.u(m0Var, z4);
                        return;
                    }
                    n0Var.s(m0Var.f2399a, m0Var, k5);
                    n0Var.u(m0Var, true);
                    return;
                }
                return;
        }
    }

    @Override // h.z
    public final boolean h(h.o oVar) {
        Window.Callback C;
        int i5 = this.f2279g;
        n0 n0Var = this.f2280h;
        switch (i5) {
            case 4:
                Window.Callback C2 = n0Var.C();
                if (C2 != null) {
                    C2.onMenuOpened(108, oVar);
                }
                return true;
            default:
                if (oVar == oVar.k() && n0Var.L && (C = n0Var.C()) != null && !n0Var.W) {
                    C.onMenuOpened(108, oVar);
                }
                return true;
        }
    }
}
