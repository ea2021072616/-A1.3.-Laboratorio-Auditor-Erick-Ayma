package androidx.recyclerview.widget;

import android.view.View;
import java.util.List;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: b  reason: collision with root package name */
    public int f1565b;

    /* renamed from: c  reason: collision with root package name */
    public int f1566c;

    /* renamed from: d  reason: collision with root package name */
    public int f1567d;

    /* renamed from: e  reason: collision with root package name */
    public int f1568e;

    /* renamed from: f  reason: collision with root package name */
    public int f1569f;

    /* renamed from: g  reason: collision with root package name */
    public int f1570g;

    /* renamed from: j  reason: collision with root package name */
    public int f1573j;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1575l;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1564a = true;

    /* renamed from: h  reason: collision with root package name */
    public int f1571h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f1572i = 0;

    /* renamed from: k  reason: collision with root package name */
    public List f1574k = null;

    public final void a(View view) {
        int a5;
        int size = this.f1574k.size();
        View view2 = null;
        int i5 = Integer.MAX_VALUE;
        for (int i6 = 0; i6 < size; i6++) {
            View view3 = ((i1) this.f1574k.get(i6)).f1376a;
            s0 s0Var = (s0) view3.getLayoutParams();
            if (view3 != view && !s0Var.c() && (a5 = (s0Var.a() - this.f1567d) * this.f1568e) >= 0 && a5 < i5) {
                view2 = view3;
                if (a5 == 0) {
                    break;
                }
                i5 = a5;
            }
        }
        if (view2 == null) {
            this.f1567d = -1;
        } else {
            this.f1567d = ((s0) view2.getLayoutParams()).a();
        }
    }

    public final View b(y0 y0Var) {
        List list = this.f1574k;
        if (list == null) {
            View d5 = y0Var.d(this.f1567d);
            this.f1567d += this.f1568e;
            return d5;
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = ((i1) this.f1574k.get(i5)).f1376a;
            s0 s0Var = (s0) view.getLayoutParams();
            if (!s0Var.c() && this.f1567d == s0Var.a()) {
                a(view);
                return view;
            }
        }
        return null;
    }
}
