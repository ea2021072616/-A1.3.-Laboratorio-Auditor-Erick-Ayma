package d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class b0 extends com.google.android.gms.internal.play_billing.i0 {

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f2283l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f2284m;

    public /* synthetic */ b0(int i5, Object obj) {
        this.f2283l = i5;
        this.f2284m = obj;
    }

    @Override // h0.l1
    public final void a() {
        int i5 = this.f2283l;
        Object obj = this.f2284m;
        switch (i5) {
            case 0:
                z zVar = (z) obj;
                zVar.f2495c.B.setAlpha(1.0f);
                n0 n0Var = zVar.f2495c;
                n0Var.E.d(null);
                n0Var.E = null;
                return;
            case 1:
                n0 n0Var2 = (n0) obj;
                n0Var2.B.setAlpha(1.0f);
                n0Var2.E.d(null);
                n0Var2.E = null;
                return;
            default:
                c0 c0Var = (c0) obj;
                c0Var.f2291b.B.setVisibility(8);
                n0 n0Var3 = c0Var.f2291b;
                PopupWindow popupWindow = n0Var3.C;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (n0Var3.B.getParent() instanceof View) {
                    WeakHashMap weakHashMap = h0.z0.f3233a;
                    h0.m0.c((View) n0Var3.B.getParent());
                }
                n0Var3.B.e();
                n0Var3.E.d(null);
                n0Var3.E = null;
                ViewGroup viewGroup = n0Var3.G;
                WeakHashMap weakHashMap2 = h0.z0.f3233a;
                h0.m0.c(viewGroup);
                return;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.i0, h0.l1
    public final void c() {
        int i5 = this.f2283l;
        Object obj = this.f2284m;
        switch (i5) {
            case 0:
                ((z) obj).f2495c.B.setVisibility(0);
                return;
            case 1:
                n0 n0Var = (n0) obj;
                n0Var.B.setVisibility(0);
                if (n0Var.B.getParent() instanceof View) {
                    WeakHashMap weakHashMap = h0.z0.f3233a;
                    h0.m0.c((View) n0Var.B.getParent());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
