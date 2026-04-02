package d;

import android.content.Context;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.gms.internal.play_billing.d3;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
/* loaded from: classes.dex */
public final class w0 implements h.z {

    /* renamed from: g  reason: collision with root package name */
    public boolean f2472g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f2473h;

    public w0(Context context) {
        try {
            x1.o.b(context);
            this.f2473h = x1.o.a().c(v1.a.f5188e).m(new u1.b("proto"), new z0.d(6, null));
        } catch (Throwable unused) {
            this.f2472g = true;
        }
    }

    public final void a(d3 d3Var) {
        if (this.f2472g) {
            com.google.android.gms.internal.play_billing.s.e("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            ((androidx.fragment.app.g) this.f2473h).b(new u1.a(d3Var));
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.s.e("BillingLogger", "logging failed.");
        }
    }

    @Override // h.z
    public final void b(h.o oVar, boolean z4) {
        androidx.appcompat.widget.n nVar;
        if (this.f2472g) {
            return;
        }
        this.f2472g = true;
        x0 x0Var = (x0) this.f2473h;
        ActionMenuView actionMenuView = x0Var.f2474a.f486a.f249g;
        if (actionMenuView != null && (nVar = actionMenuView.f207z) != null) {
            nVar.f();
            androidx.appcompat.widget.i iVar = nVar.f432z;
            if (iVar != null && iVar.b()) {
                iVar.f3087j.dismiss();
            }
        }
        x0Var.f2475b.onPanelClosed(108, oVar);
        this.f2472g = false;
    }

    @Override // h.z
    public final boolean h(h.o oVar) {
        ((x0) this.f2473h).f2475b.onMenuOpened(108, oVar);
        return true;
    }

    public w0(x0 x0Var) {
        this.f2473h = x0Var;
    }

    public w0(BottomSheetBehavior bottomSheetBehavior, boolean z4) {
        this.f2473h = bottomSheetBehavior;
        this.f2472g = z4;
    }
}
