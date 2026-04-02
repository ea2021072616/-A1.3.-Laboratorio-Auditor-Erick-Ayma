package d;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class a1 extends com.google.android.gms.internal.play_billing.i0 {

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f2281l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ c1 f2282m;

    public /* synthetic */ a1(c1 c1Var, int i5) {
        this.f2281l = i5;
        this.f2282m = c1Var;
    }

    @Override // h0.l1
    public final void a() {
        View view;
        int i5 = this.f2281l;
        c1 c1Var = this.f2282m;
        switch (i5) {
            case 0:
                if (c1Var.o && (view = c1Var.f2300g) != null) {
                    view.setTranslationY(0.0f);
                    c1Var.f2297d.setTranslationY(0.0f);
                }
                c1Var.f2297d.setVisibility(8);
                c1Var.f2297d.setTransitioning(false);
                c1Var.f2311s = null;
                g.a aVar = c1Var.f2304k;
                if (aVar != null) {
                    aVar.b(c1Var.f2303j);
                    c1Var.f2303j = null;
                    c1Var.f2304k = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = c1Var.f2296c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = h0.z0.f3233a;
                    h0.m0.c(actionBarOverlayLayout);
                    return;
                }
                return;
            default:
                c1Var.f2311s = null;
                c1Var.f2297d.requestLayout();
                return;
        }
    }
}
