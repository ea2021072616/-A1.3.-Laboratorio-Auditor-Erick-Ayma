package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
/* loaded from: classes.dex */
public class LinearLayoutManager extends r0 implements d1 {
    public final w A;
    public final x B;
    public final int C;
    public final int[] D;

    /* renamed from: p  reason: collision with root package name */
    public int f1203p;

    /* renamed from: q  reason: collision with root package name */
    public y f1204q;

    /* renamed from: r  reason: collision with root package name */
    public c0 f1205r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f1206s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f1207t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f1208u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f1209v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f1210w;

    /* renamed from: x  reason: collision with root package name */
    public int f1211x;

    /* renamed from: y  reason: collision with root package name */
    public int f1212y;

    /* renamed from: z  reason: collision with root package name */
    public z f1213z;

    public LinearLayoutManager(int i5) {
        this.f1203p = 1;
        this.f1207t = false;
        this.f1208u = false;
        this.f1209v = false;
        this.f1210w = true;
        this.f1211x = -1;
        this.f1212y = Integer.MIN_VALUE;
        this.f1213z = null;
        this.A = new w();
        this.B = new x();
        this.C = 2;
        this.D = new int[2];
        c1(i5);
        c(null);
        if (this.f1207t) {
            this.f1207t = false;
            n0();
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public boolean B0() {
        return this.f1213z == null && this.f1206s == this.f1209v;
    }

    public void C0(e1 e1Var, int[] iArr) {
        int i5;
        int i6 = e1Var.f1322a != -1 ? this.f1205r.i() : 0;
        if (this.f1204q.f1569f == -1) {
            i5 = 0;
        } else {
            i5 = i6;
            i6 = 0;
        }
        iArr[0] = i6;
        iArr[1] = i5;
    }

    public void D0(e1 e1Var, y yVar, r rVar) {
        int i5 = yVar.f1567d;
        if (i5 < 0 || i5 >= e1Var.b()) {
            return;
        }
        rVar.a(i5, Math.max(0, yVar.f1570g));
    }

    public final int E0(e1 e1Var) {
        if (v() == 0) {
            return 0;
        }
        I0();
        c0 c0Var = this.f1205r;
        boolean z4 = !this.f1210w;
        return com.google.android.gms.internal.play_billing.i0.k(e1Var, c0Var, L0(z4), K0(z4), this, this.f1210w);
    }

    public final int F0(e1 e1Var) {
        if (v() == 0) {
            return 0;
        }
        I0();
        c0 c0Var = this.f1205r;
        boolean z4 = !this.f1210w;
        return com.google.android.gms.internal.play_billing.i0.l(e1Var, c0Var, L0(z4), K0(z4), this, this.f1210w, this.f1208u);
    }

    public final int G0(e1 e1Var) {
        if (v() == 0) {
            return 0;
        }
        I0();
        c0 c0Var = this.f1205r;
        boolean z4 = !this.f1210w;
        return com.google.android.gms.internal.play_billing.i0.m(e1Var, c0Var, L0(z4), K0(z4), this, this.f1210w);
    }

    public final int H0(int i5) {
        return i5 != 1 ? i5 != 2 ? i5 != 17 ? i5 != 33 ? i5 != 66 ? (i5 == 130 && this.f1203p == 1) ? 1 : Integer.MIN_VALUE : this.f1203p == 0 ? 1 : Integer.MIN_VALUE : this.f1203p == 1 ? -1 : Integer.MIN_VALUE : this.f1203p == 0 ? -1 : Integer.MIN_VALUE : (this.f1203p != 1 && V0()) ? -1 : 1 : (this.f1203p != 1 && V0()) ? 1 : -1;
    }

    public final void I0() {
        if (this.f1204q == null) {
            this.f1204q = new y();
        }
    }

    public final int J0(y0 y0Var, y yVar, e1 e1Var, boolean z4) {
        int i5 = yVar.f1566c;
        int i6 = yVar.f1570g;
        if (i6 != Integer.MIN_VALUE) {
            if (i5 < 0) {
                yVar.f1570g = i6 + i5;
            }
            Y0(y0Var, yVar);
        }
        int i7 = yVar.f1566c + yVar.f1571h;
        while (true) {
            if (!yVar.f1575l && i7 <= 0) {
                break;
            }
            int i8 = yVar.f1567d;
            if (!(i8 >= 0 && i8 < e1Var.b())) {
                break;
            }
            x xVar = this.B;
            xVar.f1557a = 0;
            xVar.f1558b = false;
            xVar.f1559c = false;
            xVar.f1560d = false;
            W0(y0Var, e1Var, yVar, xVar);
            if (!xVar.f1558b) {
                int i9 = yVar.f1565b;
                int i10 = xVar.f1557a;
                yVar.f1565b = (yVar.f1569f * i10) + i9;
                if (!xVar.f1559c || yVar.f1574k != null || !e1Var.f1328g) {
                    yVar.f1566c -= i10;
                    i7 -= i10;
                }
                int i11 = yVar.f1570g;
                if (i11 != Integer.MIN_VALUE) {
                    int i12 = i11 + i10;
                    yVar.f1570g = i12;
                    int i13 = yVar.f1566c;
                    if (i13 < 0) {
                        yVar.f1570g = i12 + i13;
                    }
                    Y0(y0Var, yVar);
                }
                if (z4 && xVar.f1560d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i5 - yVar.f1566c;
    }

    public final View K0(boolean z4) {
        return this.f1208u ? P0(0, v(), z4) : P0(v() - 1, -1, z4);
    }

    @Override // androidx.recyclerview.widget.r0
    public final boolean L() {
        return true;
    }

    public final View L0(boolean z4) {
        return this.f1208u ? P0(v() - 1, -1, z4) : P0(0, v(), z4);
    }

    public final int M0() {
        View P0 = P0(0, v(), false);
        if (P0 == null) {
            return -1;
        }
        return r0.H(P0);
    }

    public final int N0() {
        View P0 = P0(v() - 1, -1, false);
        if (P0 == null) {
            return -1;
        }
        return r0.H(P0);
    }

    public final View O0(int i5, int i6) {
        int i7;
        int i8;
        I0();
        if ((i6 > i5 ? (char) 1 : i6 < i5 ? (char) 65535 : (char) 0) == 0) {
            return u(i5);
        }
        if (this.f1205r.d(u(i5)) < this.f1205r.h()) {
            i7 = 16644;
            i8 = 16388;
        } else {
            i7 = 4161;
            i8 = 4097;
        }
        return this.f1203p == 0 ? this.f1498c.f(i5, i6, i7, i8) : this.f1499d.f(i5, i6, i7, i8);
    }

    public final View P0(int i5, int i6, boolean z4) {
        I0();
        int i7 = z4 ? 24579 : 320;
        return this.f1203p == 0 ? this.f1498c.f(i5, i6, i7, 320) : this.f1499d.f(i5, i6, i7, 320);
    }

    public View Q0(y0 y0Var, e1 e1Var, boolean z4, boolean z5) {
        int i5;
        int i6;
        int i7;
        I0();
        int v5 = v();
        if (z5) {
            i6 = v() - 1;
            i5 = -1;
            i7 = -1;
        } else {
            i5 = v5;
            i6 = 0;
            i7 = 1;
        }
        int b5 = e1Var.b();
        int h5 = this.f1205r.h();
        int f5 = this.f1205r.f();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i6 != i5) {
            View u3 = u(i6);
            int H = r0.H(u3);
            int d5 = this.f1205r.d(u3);
            int b6 = this.f1205r.b(u3);
            if (H >= 0 && H < b5) {
                if (!((s0) u3.getLayoutParams()).c()) {
                    boolean z6 = b6 <= h5 && d5 < h5;
                    boolean z7 = d5 >= f5 && b6 > f5;
                    if (!z6 && !z7) {
                        return u3;
                    }
                    if (z4) {
                        if (!z7) {
                            if (view != null) {
                            }
                            view = u3;
                        }
                        view2 = u3;
                    } else {
                        if (!z6) {
                            if (view != null) {
                            }
                            view = u3;
                        }
                        view2 = u3;
                    }
                } else if (view3 == null) {
                    view3 = u3;
                }
            }
            i6 += i7;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    public final int R0(int i5, y0 y0Var, e1 e1Var, boolean z4) {
        int f5;
        int f6 = this.f1205r.f() - i5;
        if (f6 > 0) {
            int i6 = -b1(-f6, y0Var, e1Var);
            int i7 = i5 + i6;
            if (!z4 || (f5 = this.f1205r.f() - i7) <= 0) {
                return i6;
            }
            this.f1205r.l(f5);
            return f5 + i6;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void S(RecyclerView recyclerView) {
    }

    public final int S0(int i5, y0 y0Var, e1 e1Var, boolean z4) {
        int h5;
        int h6 = i5 - this.f1205r.h();
        if (h6 > 0) {
            int i6 = -b1(h6, y0Var, e1Var);
            int i7 = i5 + i6;
            if (!z4 || (h5 = i7 - this.f1205r.h()) <= 0) {
                return i6;
            }
            this.f1205r.l(-h5);
            return i6 - h5;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.r0
    public View T(View view, int i5, y0 y0Var, e1 e1Var) {
        int H0;
        a1();
        if (v() == 0 || (H0 = H0(i5)) == Integer.MIN_VALUE) {
            return null;
        }
        I0();
        e1(H0, (int) (this.f1205r.i() * 0.33333334f), false, e1Var);
        y yVar = this.f1204q;
        yVar.f1570g = Integer.MIN_VALUE;
        yVar.f1564a = false;
        J0(y0Var, yVar, e1Var, true);
        View O0 = H0 == -1 ? this.f1208u ? O0(v() - 1, -1) : O0(0, v()) : this.f1208u ? O0(0, v()) : O0(v() - 1, -1);
        View U0 = H0 == -1 ? U0() : T0();
        if (U0.hasFocusable()) {
            if (O0 == null) {
                return null;
            }
            return U0;
        }
        return O0;
    }

    public final View T0() {
        return u(this.f1208u ? 0 : v() - 1);
    }

    @Override // androidx.recyclerview.widget.r0
    public final void U(AccessibilityEvent accessibilityEvent) {
        super.U(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(M0());
            accessibilityEvent.setToIndex(N0());
        }
    }

    public final View U0() {
        return u(this.f1208u ? v() - 1 : 0);
    }

    public final boolean V0() {
        return C() == 1;
    }

    public void W0(y0 y0Var, e1 e1Var, y yVar, x xVar) {
        int i5;
        int i6;
        int i7;
        int i8;
        View b5 = yVar.b(y0Var);
        if (b5 == null) {
            xVar.f1558b = true;
            return;
        }
        s0 s0Var = (s0) b5.getLayoutParams();
        if (yVar.f1574k == null) {
            if (this.f1208u == (yVar.f1569f == -1)) {
                b(b5, -1, false);
            } else {
                b(b5, 0, false);
            }
        } else {
            if (this.f1208u == (yVar.f1569f == -1)) {
                b(b5, -1, true);
            } else {
                b(b5, 0, true);
            }
        }
        s0 s0Var2 = (s0) b5.getLayoutParams();
        Rect N = this.f1497b.N(b5);
        int w5 = r0.w(d(), this.f1509n, this.f1507l, F() + E() + ((ViewGroup.MarginLayoutParams) s0Var2).leftMargin + ((ViewGroup.MarginLayoutParams) s0Var2).rightMargin + N.left + N.right + 0, ((ViewGroup.MarginLayoutParams) s0Var2).width);
        int w6 = r0.w(e(), this.o, this.f1508m, D() + G() + ((ViewGroup.MarginLayoutParams) s0Var2).topMargin + ((ViewGroup.MarginLayoutParams) s0Var2).bottomMargin + N.top + N.bottom + 0, ((ViewGroup.MarginLayoutParams) s0Var2).height);
        if (w0(b5, w5, w6, s0Var2)) {
            b5.measure(w5, w6);
        }
        xVar.f1557a = this.f1205r.c(b5);
        if (this.f1203p == 1) {
            if (V0()) {
                i8 = this.f1509n - F();
                i5 = i8 - this.f1205r.m(b5);
            } else {
                i5 = E();
                i8 = this.f1205r.m(b5) + i5;
            }
            if (yVar.f1569f == -1) {
                i6 = yVar.f1565b;
                i7 = i6 - xVar.f1557a;
            } else {
                i7 = yVar.f1565b;
                i6 = xVar.f1557a + i7;
            }
        } else {
            int G = G();
            int m5 = this.f1205r.m(b5) + G;
            if (yVar.f1569f == -1) {
                int i9 = yVar.f1565b;
                int i10 = i9 - xVar.f1557a;
                i8 = i9;
                i6 = m5;
                i5 = i10;
                i7 = G;
            } else {
                int i11 = yVar.f1565b;
                int i12 = xVar.f1557a + i11;
                i5 = i11;
                i6 = m5;
                i7 = G;
                i8 = i12;
            }
        }
        r0.N(b5, i5, i7, i8, i6);
        if (s0Var.c() || s0Var.b()) {
            xVar.f1559c = true;
        }
        xVar.f1560d = b5.hasFocusable();
    }

    public void X0(y0 y0Var, e1 e1Var, w wVar, int i5) {
    }

    public final void Y0(y0 y0Var, y yVar) {
        if (!yVar.f1564a || yVar.f1575l) {
            return;
        }
        int i5 = yVar.f1570g;
        int i6 = yVar.f1572i;
        if (yVar.f1569f == -1) {
            int v5 = v();
            if (i5 < 0) {
                return;
            }
            int e5 = (this.f1205r.e() - i5) + i6;
            if (this.f1208u) {
                for (int i7 = 0; i7 < v5; i7++) {
                    View u3 = u(i7);
                    if (this.f1205r.d(u3) < e5 || this.f1205r.k(u3) < e5) {
                        Z0(y0Var, 0, i7);
                        return;
                    }
                }
                return;
            }
            int i8 = v5 - 1;
            for (int i9 = i8; i9 >= 0; i9--) {
                View u5 = u(i9);
                if (this.f1205r.d(u5) < e5 || this.f1205r.k(u5) < e5) {
                    Z0(y0Var, i8, i9);
                    return;
                }
            }
        } else if (i5 >= 0) {
            int i10 = i5 - i6;
            int v6 = v();
            if (!this.f1208u) {
                for (int i11 = 0; i11 < v6; i11++) {
                    View u6 = u(i11);
                    if (this.f1205r.b(u6) > i10 || this.f1205r.j(u6) > i10) {
                        Z0(y0Var, 0, i11);
                        return;
                    }
                }
                return;
            }
            int i12 = v6 - 1;
            for (int i13 = i12; i13 >= 0; i13--) {
                View u7 = u(i13);
                if (this.f1205r.b(u7) > i10 || this.f1205r.j(u7) > i10) {
                    Z0(y0Var, i12, i13);
                    return;
                }
            }
        }
    }

    public final void Z0(y0 y0Var, int i5, int i6) {
        if (i5 == i6) {
            return;
        }
        if (i6 <= i5) {
            while (i5 > i6) {
                View u3 = u(i5);
                l0(i5);
                y0Var.i(u3);
                i5--;
            }
            return;
        }
        while (true) {
            i6--;
            if (i6 < i5) {
                return;
            }
            View u5 = u(i6);
            l0(i6);
            y0Var.i(u5);
        }
    }

    @Override // androidx.recyclerview.widget.d1
    public final PointF a(int i5) {
        if (v() == 0) {
            return null;
        }
        int i6 = (i5 < r0.H(u(0))) != this.f1208u ? -1 : 1;
        return this.f1203p == 0 ? new PointF(i6, 0.0f) : new PointF(0.0f, i6);
    }

    public final void a1() {
        if (this.f1203p == 1 || !V0()) {
            this.f1208u = this.f1207t;
        } else {
            this.f1208u = !this.f1207t;
        }
    }

    public final int b1(int i5, y0 y0Var, e1 e1Var) {
        if (v() == 0 || i5 == 0) {
            return 0;
        }
        I0();
        this.f1204q.f1564a = true;
        int i6 = i5 > 0 ? 1 : -1;
        int abs = Math.abs(i5);
        e1(i6, abs, true, e1Var);
        y yVar = this.f1204q;
        int J0 = J0(y0Var, yVar, e1Var, false) + yVar.f1570g;
        if (J0 < 0) {
            return 0;
        }
        if (abs > J0) {
            i5 = i6 * J0;
        }
        this.f1205r.l(-i5);
        this.f1204q.f1573j = i5;
        return i5;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void c(String str) {
        if (this.f1213z == null) {
            super.c(str);
        }
    }

    public final void c1(int i5) {
        if (i5 != 0 && i5 != 1) {
            throw new IllegalArgumentException(androidx.appcompat.widget.b0.f("invalid orientation:", i5));
        }
        c(null);
        if (i5 != this.f1203p || this.f1205r == null) {
            c0 a5 = d0.a(this, i5);
            this.f1205r = a5;
            this.A.f1548a = a5;
            this.f1203p = i5;
            n0();
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public final boolean d() {
        return this.f1203p == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0234  */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    @Override // androidx.recyclerview.widget.r0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d0(androidx.recyclerview.widget.y0 r18, androidx.recyclerview.widget.e1 r19) {
        /*
            Method dump skipped, instructions count: 1126
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.d0(androidx.recyclerview.widget.y0, androidx.recyclerview.widget.e1):void");
    }

    public void d1(boolean z4) {
        c(null);
        if (this.f1209v == z4) {
            return;
        }
        this.f1209v = z4;
        n0();
    }

    @Override // androidx.recyclerview.widget.r0
    public final boolean e() {
        return this.f1203p == 1;
    }

    @Override // androidx.recyclerview.widget.r0
    public void e0(e1 e1Var) {
        this.f1213z = null;
        this.f1211x = -1;
        this.f1212y = Integer.MIN_VALUE;
        this.A.d();
    }

    public final void e1(int i5, int i6, boolean z4, e1 e1Var) {
        int h5;
        int D;
        this.f1204q.f1575l = this.f1205r.g() == 0 && this.f1205r.e() == 0;
        this.f1204q.f1569f = i5;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        C0(e1Var, iArr);
        int max = Math.max(0, iArr[0]);
        int max2 = Math.max(0, iArr[1]);
        boolean z5 = i5 == 1;
        y yVar = this.f1204q;
        int i7 = z5 ? max2 : max;
        yVar.f1571h = i7;
        if (!z5) {
            max = max2;
        }
        yVar.f1572i = max;
        if (z5) {
            c0 c0Var = this.f1205r;
            int i8 = c0Var.f1301d;
            r0 r0Var = c0Var.f1314a;
            switch (i8) {
                case 0:
                    D = r0Var.F();
                    break;
                default:
                    D = r0Var.D();
                    break;
            }
            yVar.f1571h = D + i7;
            View T0 = T0();
            y yVar2 = this.f1204q;
            yVar2.f1568e = this.f1208u ? -1 : 1;
            int H = r0.H(T0);
            y yVar3 = this.f1204q;
            yVar2.f1567d = H + yVar3.f1568e;
            yVar3.f1565b = this.f1205r.b(T0);
            h5 = this.f1205r.b(T0) - this.f1205r.f();
        } else {
            View U0 = U0();
            y yVar4 = this.f1204q;
            yVar4.f1571h = this.f1205r.h() + yVar4.f1571h;
            y yVar5 = this.f1204q;
            yVar5.f1568e = this.f1208u ? 1 : -1;
            int H2 = r0.H(U0);
            y yVar6 = this.f1204q;
            yVar5.f1567d = H2 + yVar6.f1568e;
            yVar6.f1565b = this.f1205r.d(U0);
            h5 = (-this.f1205r.d(U0)) + this.f1205r.h();
        }
        y yVar7 = this.f1204q;
        yVar7.f1566c = i6;
        if (z4) {
            yVar7.f1566c = i6 - h5;
        }
        yVar7.f1570g = h5;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void f0(Parcelable parcelable) {
        if (parcelable instanceof z) {
            z zVar = (z) parcelable;
            this.f1213z = zVar;
            if (this.f1211x != -1) {
                zVar.f1584b = -1;
            }
            n0();
        }
    }

    public final void f1(int i5, int i6) {
        this.f1204q.f1566c = this.f1205r.f() - i6;
        y yVar = this.f1204q;
        yVar.f1568e = this.f1208u ? -1 : 1;
        yVar.f1567d = i5;
        yVar.f1569f = 1;
        yVar.f1565b = i6;
        yVar.f1570g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.r0
    public final Parcelable g0() {
        z zVar = this.f1213z;
        if (zVar != null) {
            return new z(zVar);
        }
        z zVar2 = new z();
        if (v() > 0) {
            I0();
            boolean z4 = this.f1206s ^ this.f1208u;
            zVar2.f1586d = z4;
            if (z4) {
                View T0 = T0();
                zVar2.f1585c = this.f1205r.f() - this.f1205r.b(T0);
                zVar2.f1584b = r0.H(T0);
            } else {
                View U0 = U0();
                zVar2.f1584b = r0.H(U0);
                zVar2.f1585c = this.f1205r.d(U0) - this.f1205r.h();
            }
        } else {
            zVar2.f1584b = -1;
        }
        return zVar2;
    }

    public final void g1(int i5, int i6) {
        this.f1204q.f1566c = i6 - this.f1205r.h();
        y yVar = this.f1204q;
        yVar.f1567d = i5;
        yVar.f1568e = this.f1208u ? 1 : -1;
        yVar.f1569f = -1;
        yVar.f1565b = i6;
        yVar.f1570g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void h(int i5, int i6, e1 e1Var, r rVar) {
        if (this.f1203p != 0) {
            i5 = i6;
        }
        if (v() == 0 || i5 == 0) {
            return;
        }
        I0();
        e1(i5 > 0 ? 1 : -1, Math.abs(i5), true, e1Var);
        D0(e1Var, this.f1204q, rVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0024  */
    @Override // androidx.recyclerview.widget.r0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(int r7, androidx.recyclerview.widget.r r8) {
        /*
            r6 = this;
            androidx.recyclerview.widget.z r0 = r6.f1213z
            r1 = 1
            r2 = -1
            r3 = 0
            if (r0 == 0) goto L13
            int r4 = r0.f1584b
            if (r4 < 0) goto Ld
            r5 = r1
            goto Le
        Ld:
            r5 = r3
        Le:
            if (r5 == 0) goto L13
            boolean r0 = r0.f1586d
            goto L22
        L13:
            r6.a1()
            boolean r0 = r6.f1208u
            int r4 = r6.f1211x
            if (r4 != r2) goto L22
            if (r0 == 0) goto L21
            int r4 = r7 + (-1)
            goto L22
        L21:
            r4 = r3
        L22:
            if (r0 == 0) goto L25
            r1 = r2
        L25:
            r0 = r3
        L26:
            int r2 = r6.C
            if (r0 >= r2) goto L35
            if (r4 < 0) goto L35
            if (r4 >= r7) goto L35
            r8.a(r4, r3)
            int r4 = r4 + r1
            int r0 = r0 + 1
            goto L26
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.i(int, androidx.recyclerview.widget.r):void");
    }

    @Override // androidx.recyclerview.widget.r0
    public final int j(e1 e1Var) {
        return E0(e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public int k(e1 e1Var) {
        return F0(e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public int l(e1 e1Var) {
        return G0(e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public final int m(e1 e1Var) {
        return E0(e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public int n(e1 e1Var) {
        return F0(e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public int o(e1 e1Var) {
        return G0(e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public int o0(int i5, y0 y0Var, e1 e1Var) {
        if (this.f1203p == 1) {
            return 0;
        }
        return b1(i5, y0Var, e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public final void p0(int i5) {
        this.f1211x = i5;
        this.f1212y = Integer.MIN_VALUE;
        z zVar = this.f1213z;
        if (zVar != null) {
            zVar.f1584b = -1;
        }
        n0();
    }

    @Override // androidx.recyclerview.widget.r0
    public final View q(int i5) {
        int v5 = v();
        if (v5 == 0) {
            return null;
        }
        int H = i5 - r0.H(u(0));
        if (H >= 0 && H < v5) {
            View u3 = u(H);
            if (r0.H(u3) == i5) {
                return u3;
            }
        }
        return super.q(i5);
    }

    @Override // androidx.recyclerview.widget.r0
    public int q0(int i5, y0 y0Var, e1 e1Var) {
        if (this.f1203p == 0) {
            return 0;
        }
        return b1(i5, y0Var, e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public s0 r() {
        return new s0(-2, -2);
    }

    @Override // androidx.recyclerview.widget.r0
    public final boolean x0() {
        boolean z4;
        if (this.f1508m == 1073741824 || this.f1507l == 1073741824) {
            return false;
        }
        int v5 = v();
        int i5 = 0;
        while (true) {
            if (i5 >= v5) {
                z4 = false;
                break;
            }
            ViewGroup.LayoutParams layoutParams = u(i5).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                z4 = true;
                break;
            }
            i5++;
        }
        return z4;
    }

    @Override // androidx.recyclerview.widget.r0
    public void z0(RecyclerView recyclerView, int i5) {
        a0 a0Var = new a0(recyclerView.getContext());
        a0Var.f1274a = i5;
        A0(a0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i5, int i6) {
        this.f1203p = 1;
        this.f1207t = false;
        this.f1208u = false;
        this.f1209v = false;
        this.f1210w = true;
        this.f1211x = -1;
        this.f1212y = Integer.MIN_VALUE;
        this.f1213z = null;
        this.A = new w();
        this.B = new x();
        this.C = 2;
        this.D = new int[2];
        q0 I = r0.I(context, attributeSet, i5, i6);
        c1(I.f1482a);
        boolean z4 = I.f1484c;
        c(null);
        if (z4 != this.f1207t) {
            this.f1207t = z4;
            n0();
        }
        d1(I.f1485d);
    }
}
