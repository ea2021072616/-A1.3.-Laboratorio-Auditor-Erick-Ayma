package d;

import android.view.ViewGroup;
import h0.k1;
/* loaded from: classes.dex */
public final class z implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f2494b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n0 f2495c;

    public /* synthetic */ z(n0 n0Var, int i5) {
        this.f2494b = i5;
        this.f2495c = n0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        boolean z4 = true;
        int i5 = this.f2494b;
        n0 n0Var = this.f2495c;
        switch (i5) {
            case 0:
                if ((1 & n0Var.f2423f0) != 0) {
                    n0Var.x(0);
                }
                if ((n0Var.f2423f0 & 4096) != 0) {
                    n0Var.x(108);
                }
                n0Var.f2422e0 = false;
                n0Var.f2423f0 = 0;
                return;
            default:
                n0Var.C.showAtLocation(n0Var.B, 55, 0, 0);
                k1 k1Var = n0Var.E;
                if (k1Var != null) {
                    k1Var.b();
                }
                if (!n0Var.F || (viewGroup = n0Var.G) == null || !viewGroup.isLaidOut()) {
                    z4 = false;
                }
                if (!z4) {
                    n0Var.B.setAlpha(1.0f);
                    n0Var.B.setVisibility(0);
                    return;
                }
                n0Var.B.setAlpha(0.0f);
                k1 a5 = h0.z0.a(n0Var.B);
                a5.a(1.0f);
                n0Var.E = a5;
                a5.d(new b0(0, this));
                return;
        }
    }
}
