package b3;

import android.view.View;
import android.view.WindowInsets;
import h0.h2;
import h0.u1;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public WindowInsets f1647a;

    /* renamed from: b  reason: collision with root package name */
    public final View f1648b;

    /* renamed from: c  reason: collision with root package name */
    public int f1649c;

    /* renamed from: d  reason: collision with root package name */
    public int f1650d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f1651e = new int[2];

    public g(View view) {
        this.f1648b = view;
    }

    public final void a(h2 h2Var, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            u1 u1Var = (u1) it.next();
            if ((u1Var.f3214a.c() & 8) != 0) {
                this.f1648b.setTranslationY(x2.a.b(this.f1650d, u1Var.f3214a.b(), 0));
                return;
            }
        }
    }
}
