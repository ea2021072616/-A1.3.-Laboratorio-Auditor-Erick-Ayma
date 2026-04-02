package androidx.recyclerview.widget;

import android.view.View;
/* loaded from: classes.dex */
public final class f0 extends t0 {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f1341a;

    /* renamed from: b  reason: collision with root package name */
    public final l1 f1342b = new l1(this);

    /* renamed from: c  reason: collision with root package name */
    public c0 f1343c;

    /* renamed from: d  reason: collision with root package name */
    public c0 f1344d;

    public static int b(View view, d0 d0Var) {
        return ((d0Var.c(view) / 2) + d0Var.d(view)) - ((d0Var.i() / 2) + d0Var.h());
    }

    public static View c(r0 r0Var, d0 d0Var) {
        int v5 = r0Var.v();
        View view = null;
        if (v5 == 0) {
            return null;
        }
        int i5 = (d0Var.i() / 2) + d0Var.h();
        int i6 = Integer.MAX_VALUE;
        for (int i7 = 0; i7 < v5; i7++) {
            View u3 = r0Var.u(i7);
            int abs = Math.abs(((d0Var.c(u3) / 2) + d0Var.d(u3)) - i5);
            if (abs < i6) {
                view = u3;
                i6 = abs;
            }
        }
        return view;
    }

    public final int[] a(r0 r0Var, View view) {
        int[] iArr = new int[2];
        if (r0Var.d()) {
            iArr[0] = b(view, d(r0Var));
        } else {
            iArr[0] = 0;
        }
        if (r0Var.e()) {
            iArr[1] = b(view, e(r0Var));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public final d0 d(r0 r0Var) {
        c0 c0Var = this.f1344d;
        if (c0Var == null || c0Var.f1314a != r0Var) {
            this.f1344d = new c0(r0Var, 0);
        }
        return this.f1344d;
    }

    public final d0 e(r0 r0Var) {
        c0 c0Var = this.f1343c;
        if (c0Var == null || c0Var.f1314a != r0Var) {
            this.f1343c = new c0(r0Var, 1);
        }
        return this.f1343c;
    }

    public final void f() {
        r0 layoutManager;
        RecyclerView recyclerView = this.f1341a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        View c5 = layoutManager.e() ? c(layoutManager, e(layoutManager)) : layoutManager.d() ? c(layoutManager, d(layoutManager)) : null;
        if (c5 == null) {
            return;
        }
        int[] a5 = a(layoutManager, c5);
        int i5 = a5[0];
        if (i5 == 0 && a5[1] == 0) {
            return;
        }
        this.f1341a.h0(i5, a5[1], false);
    }
}
