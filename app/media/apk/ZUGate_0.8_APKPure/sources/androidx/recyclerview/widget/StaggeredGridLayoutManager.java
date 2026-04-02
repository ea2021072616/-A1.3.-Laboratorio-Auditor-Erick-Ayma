package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends r0 implements d1 {
    public final u1 B;
    public final int C;
    public boolean D;
    public boolean E;
    public p1 F;
    public final Rect G;
    public final m1 H;
    public final boolean I;
    public int[] J;
    public final m K;

    /* renamed from: p  reason: collision with root package name */
    public int f1259p;

    /* renamed from: q  reason: collision with root package name */
    public q1[] f1260q;

    /* renamed from: r  reason: collision with root package name */
    public d0 f1261r;

    /* renamed from: s  reason: collision with root package name */
    public d0 f1262s;

    /* renamed from: t  reason: collision with root package name */
    public int f1263t;

    /* renamed from: u  reason: collision with root package name */
    public int f1264u;

    /* renamed from: v  reason: collision with root package name */
    public final v f1265v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f1266w;

    /* renamed from: y  reason: collision with root package name */
    public BitSet f1268y;

    /* renamed from: x  reason: collision with root package name */
    public boolean f1267x = false;

    /* renamed from: z  reason: collision with root package name */
    public int f1269z = -1;
    public int A = Integer.MIN_VALUE;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i5, int i6) {
        this.f1259p = -1;
        this.f1266w = false;
        u1 u1Var = new u1(1);
        this.B = u1Var;
        this.C = 2;
        this.G = new Rect();
        this.H = new m1(this);
        this.I = true;
        this.K = new m(1, this);
        q0 I = r0.I(context, attributeSet, i5, i6);
        int i7 = I.f1482a;
        if (i7 != 0 && i7 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        c(null);
        if (i7 != this.f1263t) {
            this.f1263t = i7;
            d0 d0Var = this.f1261r;
            this.f1261r = this.f1262s;
            this.f1262s = d0Var;
            n0();
        }
        int i8 = I.f1483b;
        c(null);
        if (i8 != this.f1259p) {
            u1Var.d();
            n0();
            this.f1259p = i8;
            this.f1268y = new BitSet(this.f1259p);
            this.f1260q = new q1[this.f1259p];
            for (int i9 = 0; i9 < this.f1259p; i9++) {
                this.f1260q[i9] = new q1(this, i9);
            }
            n0();
        }
        boolean z4 = I.f1484c;
        c(null);
        p1 p1Var = this.F;
        if (p1Var != null && p1Var.f1454i != z4) {
            p1Var.f1454i = z4;
        }
        this.f1266w = z4;
        n0();
        this.f1265v = new v();
        this.f1261r = d0.a(this, this.f1263t);
        this.f1262s = d0.a(this, 1 - this.f1263t);
    }

    public static int f1(int i5, int i6, int i7) {
        if (i6 == 0 && i7 == 0) {
            return i5;
        }
        int mode = View.MeasureSpec.getMode(i5);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i5) - i6) - i7), mode) : i5;
    }

    @Override // androidx.recyclerview.widget.r0
    public final boolean B0() {
        return this.F == null;
    }

    public final int C0(int i5) {
        if (v() == 0) {
            return this.f1267x ? 1 : -1;
        }
        return (i5 < M0()) != this.f1267x ? -1 : 1;
    }

    public final boolean D0() {
        int M0;
        if (v() != 0 && this.C != 0 && this.f1502g) {
            if (this.f1267x) {
                M0 = N0();
                M0();
            } else {
                M0 = M0();
                N0();
            }
            if (M0 == 0 && R0() != null) {
                this.B.d();
                this.f1501f = true;
                n0();
                return true;
            }
        }
        return false;
    }

    public final int E0(e1 e1Var) {
        if (v() == 0) {
            return 0;
        }
        d0 d0Var = this.f1261r;
        boolean z4 = this.I;
        return com.google.android.gms.internal.play_billing.i0.k(e1Var, d0Var, J0(!z4), I0(!z4), this, this.I);
    }

    public final int F0(e1 e1Var) {
        if (v() == 0) {
            return 0;
        }
        d0 d0Var = this.f1261r;
        boolean z4 = this.I;
        return com.google.android.gms.internal.play_billing.i0.l(e1Var, d0Var, J0(!z4), I0(!z4), this, this.I, this.f1267x);
    }

    public final int G0(e1 e1Var) {
        if (v() == 0) {
            return 0;
        }
        d0 d0Var = this.f1261r;
        boolean z4 = this.I;
        return com.google.android.gms.internal.play_billing.i0.m(e1Var, d0Var, J0(!z4), I0(!z4), this, this.I);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v19 */
    public final int H0(y0 y0Var, v vVar, e1 e1Var) {
        q1 q1Var;
        ?? r8;
        int i5;
        int c5;
        int h5;
        int c6;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        int i11 = 1;
        this.f1268y.set(0, this.f1259p, true);
        v vVar2 = this.f1265v;
        int i12 = vVar2.f1547i ? vVar.f1543e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : vVar.f1543e == 1 ? vVar.f1545g + vVar.f1540b : vVar.f1544f - vVar.f1540b;
        int i13 = vVar.f1543e;
        for (int i14 = 0; i14 < this.f1259p; i14++) {
            if (!this.f1260q[i14].f1486a.isEmpty()) {
                e1(this.f1260q[i14], i13, i12);
            }
        }
        int f5 = this.f1267x ? this.f1261r.f() : this.f1261r.h();
        boolean z4 = false;
        while (true) {
            int i15 = vVar.f1541c;
            if (((i15 < 0 || i15 >= e1Var.b()) ? i10 : i11) == 0 || (!vVar2.f1547i && this.f1268y.isEmpty())) {
                break;
            }
            View d5 = y0Var.d(vVar.f1541c);
            vVar.f1541c += vVar.f1542d;
            n1 n1Var = (n1) d5.getLayoutParams();
            int a5 = n1Var.a();
            u1 u1Var = this.B;
            int[] iArr = (int[]) u1Var.f1537b;
            int i16 = (iArr == null || a5 >= iArr.length) ? -1 : iArr[a5];
            if ((i16 == -1 ? i11 : i10) != 0) {
                if (V0(vVar.f1543e)) {
                    i9 = this.f1259p - i11;
                    i8 = -1;
                    i7 = -1;
                } else {
                    i7 = i11;
                    i8 = this.f1259p;
                    i9 = i10;
                }
                q1 q1Var2 = null;
                if (vVar.f1543e == i11) {
                    int h6 = this.f1261r.h();
                    int i17 = Integer.MAX_VALUE;
                    while (i9 != i8) {
                        q1 q1Var3 = this.f1260q[i9];
                        int f6 = q1Var3.f(h6);
                        if (f6 < i17) {
                            i17 = f6;
                            q1Var2 = q1Var3;
                        }
                        i9 += i7;
                    }
                } else {
                    int f7 = this.f1261r.f();
                    int i18 = Integer.MIN_VALUE;
                    while (i9 != i8) {
                        q1 q1Var4 = this.f1260q[i9];
                        int i19 = q1Var4.i(f7);
                        if (i19 > i18) {
                            q1Var2 = q1Var4;
                            i18 = i19;
                        }
                        i9 += i7;
                    }
                }
                q1Var = q1Var2;
                u1Var.e(a5);
                ((int[]) u1Var.f1537b)[a5] = q1Var.f1490e;
            } else {
                q1Var = this.f1260q[i16];
            }
            n1Var.f1437e = q1Var;
            if (vVar.f1543e == 1) {
                r8 = 0;
                b(d5, -1, false);
            } else {
                r8 = 0;
                b(d5, 0, false);
            }
            if (this.f1263t == 1) {
                T0(d5, r0.w(r8, this.f1264u, this.f1507l, r8, ((ViewGroup.MarginLayoutParams) n1Var).width), r0.w(true, this.o, this.f1508m, D() + G(), ((ViewGroup.MarginLayoutParams) n1Var).height), r8);
            } else {
                T0(d5, r0.w(true, this.f1509n, this.f1507l, F() + E(), ((ViewGroup.MarginLayoutParams) n1Var).width), r0.w(false, this.f1264u, this.f1508m, 0, ((ViewGroup.MarginLayoutParams) n1Var).height), false);
            }
            if (vVar.f1543e == 1) {
                c5 = q1Var.f(f5);
                i5 = this.f1261r.c(d5) + c5;
            } else {
                i5 = q1Var.i(f5);
                c5 = i5 - this.f1261r.c(d5);
            }
            if (vVar.f1543e == 1) {
                q1 q1Var5 = n1Var.f1437e;
                q1Var5.getClass();
                n1 n1Var2 = (n1) d5.getLayoutParams();
                n1Var2.f1437e = q1Var5;
                ArrayList arrayList = q1Var5.f1486a;
                arrayList.add(d5);
                q1Var5.f1488c = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    q1Var5.f1487b = Integer.MIN_VALUE;
                }
                if (n1Var2.c() || n1Var2.b()) {
                    q1Var5.f1489d = q1Var5.f1491f.f1261r.c(d5) + q1Var5.f1489d;
                }
            } else {
                q1 q1Var6 = n1Var.f1437e;
                q1Var6.getClass();
                n1 n1Var3 = (n1) d5.getLayoutParams();
                n1Var3.f1437e = q1Var6;
                ArrayList arrayList2 = q1Var6.f1486a;
                arrayList2.add(0, d5);
                q1Var6.f1487b = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    q1Var6.f1488c = Integer.MIN_VALUE;
                }
                if (n1Var3.c() || n1Var3.b()) {
                    q1Var6.f1489d = q1Var6.f1491f.f1261r.c(d5) + q1Var6.f1489d;
                }
            }
            if (S0() && this.f1263t == 1) {
                c6 = this.f1262s.f() - (((this.f1259p - 1) - q1Var.f1490e) * this.f1264u);
                h5 = c6 - this.f1262s.c(d5);
            } else {
                h5 = this.f1262s.h() + (q1Var.f1490e * this.f1264u);
                c6 = this.f1262s.c(d5) + h5;
            }
            if (this.f1263t == 1) {
                r0.N(d5, h5, c5, c6, i5);
            } else {
                r0.N(d5, c5, h5, i5, c6);
            }
            e1(q1Var, vVar2.f1543e, i12);
            X0(y0Var, vVar2);
            if (vVar2.f1546h && d5.hasFocusable()) {
                i6 = 0;
                this.f1268y.set(q1Var.f1490e, false);
            } else {
                i6 = 0;
            }
            i10 = i6;
            i11 = 1;
            z4 = true;
        }
        int i20 = i10;
        if (!z4) {
            X0(y0Var, vVar2);
        }
        int h7 = vVar2.f1543e == -1 ? this.f1261r.h() - P0(this.f1261r.h()) : O0(this.f1261r.f()) - this.f1261r.f();
        return h7 > 0 ? Math.min(vVar.f1540b, h7) : i20;
    }

    public final View I0(boolean z4) {
        int h5 = this.f1261r.h();
        int f5 = this.f1261r.f();
        View view = null;
        for (int v5 = v() - 1; v5 >= 0; v5--) {
            View u3 = u(v5);
            int d5 = this.f1261r.d(u3);
            int b5 = this.f1261r.b(u3);
            if (b5 > h5 && d5 < f5) {
                if (b5 <= f5 || !z4) {
                    return u3;
                }
                if (view == null) {
                    view = u3;
                }
            }
        }
        return view;
    }

    public final View J0(boolean z4) {
        int h5 = this.f1261r.h();
        int f5 = this.f1261r.f();
        int v5 = v();
        View view = null;
        for (int i5 = 0; i5 < v5; i5++) {
            View u3 = u(i5);
            int d5 = this.f1261r.d(u3);
            if (this.f1261r.b(u3) > h5 && d5 < f5) {
                if (d5 >= h5 || !z4) {
                    return u3;
                }
                if (view == null) {
                    view = u3;
                }
            }
        }
        return view;
    }

    public final void K0(y0 y0Var, e1 e1Var, boolean z4) {
        int f5;
        int O0 = O0(Integer.MIN_VALUE);
        if (O0 != Integer.MIN_VALUE && (f5 = this.f1261r.f() - O0) > 0) {
            int i5 = f5 - (-b1(-f5, y0Var, e1Var));
            if (!z4 || i5 <= 0) {
                return;
            }
            this.f1261r.l(i5);
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public final boolean L() {
        return this.C != 0;
    }

    public final void L0(y0 y0Var, e1 e1Var, boolean z4) {
        int h5;
        int P0 = P0(Integer.MAX_VALUE);
        if (P0 != Integer.MAX_VALUE && (h5 = P0 - this.f1261r.h()) > 0) {
            int b12 = h5 - b1(h5, y0Var, e1Var);
            if (!z4 || b12 <= 0) {
                return;
            }
            this.f1261r.l(-b12);
        }
    }

    public final int M0() {
        if (v() == 0) {
            return 0;
        }
        return r0.H(u(0));
    }

    public final int N0() {
        int v5 = v();
        if (v5 == 0) {
            return 0;
        }
        return r0.H(u(v5 - 1));
    }

    @Override // androidx.recyclerview.widget.r0
    public final void O(int i5) {
        super.O(i5);
        for (int i6 = 0; i6 < this.f1259p; i6++) {
            q1 q1Var = this.f1260q[i6];
            int i7 = q1Var.f1487b;
            if (i7 != Integer.MIN_VALUE) {
                q1Var.f1487b = i7 + i5;
            }
            int i8 = q1Var.f1488c;
            if (i8 != Integer.MIN_VALUE) {
                q1Var.f1488c = i8 + i5;
            }
        }
    }

    public final int O0(int i5) {
        int f5 = this.f1260q[0].f(i5);
        for (int i6 = 1; i6 < this.f1259p; i6++) {
            int f6 = this.f1260q[i6].f(i5);
            if (f6 > f5) {
                f5 = f6;
            }
        }
        return f5;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void P(int i5) {
        super.P(i5);
        for (int i6 = 0; i6 < this.f1259p; i6++) {
            q1 q1Var = this.f1260q[i6];
            int i7 = q1Var.f1487b;
            if (i7 != Integer.MIN_VALUE) {
                q1Var.f1487b = i7 + i5;
            }
            int i8 = q1Var.f1488c;
            if (i8 != Integer.MIN_VALUE) {
                q1Var.f1488c = i8 + i5;
            }
        }
    }

    public final int P0(int i5) {
        int i6 = this.f1260q[0].i(i5);
        for (int i7 = 1; i7 < this.f1259p; i7++) {
            int i8 = this.f1260q[i7].i(i5);
            if (i8 < i6) {
                i6 = i8;
            }
        }
        return i6;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void Q() {
        this.B.d();
        for (int i5 = 0; i5 < this.f1259p; i5++) {
            this.f1260q[i5].b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q0(int r8, int r9, int r10) {
        /*
            r7 = this;
            boolean r0 = r7.f1267x
            if (r0 == 0) goto L9
            int r0 = r7.N0()
            goto Ld
        L9:
            int r0 = r7.M0()
        Ld:
            r1 = 8
            if (r10 != r1) goto L1a
            if (r8 >= r9) goto L16
            int r2 = r9 + 1
            goto L1c
        L16:
            int r2 = r8 + 1
            r3 = r9
            goto L1d
        L1a:
            int r2 = r8 + r9
        L1c:
            r3 = r8
        L1d:
            androidx.recyclerview.widget.u1 r4 = r7.B
            r4.g(r3)
            r5 = 1
            if (r10 == r5) goto L36
            r6 = 2
            if (r10 == r6) goto L32
            if (r10 == r1) goto L2b
            goto L39
        L2b:
            r4.j(r8, r5)
            r4.i(r9, r5)
            goto L39
        L32:
            r4.j(r8, r9)
            goto L39
        L36:
            r4.i(r8, r9)
        L39:
            if (r2 > r0) goto L3c
            return
        L3c:
            boolean r8 = r7.f1267x
            if (r8 == 0) goto L45
            int r8 = r7.M0()
            goto L49
        L45:
            int r8 = r7.N0()
        L49:
            if (r3 > r8) goto L4e
            r7.n0()
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.Q0(int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d1, code lost:
        if (r10 == r11) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e3, code lost:
        if (r10 == r11) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e5, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e7, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View R0() {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.R0():android.view.View");
    }

    @Override // androidx.recyclerview.widget.r0
    public final void S(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1497b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.K);
        }
        for (int i5 = 0; i5 < this.f1259p; i5++) {
            this.f1260q[i5].b();
        }
        recyclerView.requestLayout();
    }

    public final boolean S0() {
        return C() == 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x004a, code lost:
        if (r8.f1263t == 1) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004f, code lost:
        if (r8.f1263t == 0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x005d, code lost:
        if (S0() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0069, code lost:
        if (S0() == false) goto L113;
     */
    @Override // androidx.recyclerview.widget.r0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View T(android.view.View r9, int r10, androidx.recyclerview.widget.y0 r11, androidx.recyclerview.widget.e1 r12) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.T(android.view.View, int, androidx.recyclerview.widget.y0, androidx.recyclerview.widget.e1):android.view.View");
    }

    public final void T0(View view, int i5, int i6, boolean z4) {
        RecyclerView recyclerView = this.f1497b;
        Rect rect = this.G;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.N(view));
        }
        n1 n1Var = (n1) view.getLayoutParams();
        int f12 = f1(i5, ((ViewGroup.MarginLayoutParams) n1Var).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) n1Var).rightMargin + rect.right);
        int f13 = f1(i6, ((ViewGroup.MarginLayoutParams) n1Var).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) n1Var).bottomMargin + rect.bottom);
        if (w0(view, f12, f13, n1Var)) {
            view.measure(f12, f13);
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public final void U(AccessibilityEvent accessibilityEvent) {
        super.U(accessibilityEvent);
        if (v() > 0) {
            View J0 = J0(false);
            View I0 = I0(false);
            if (J0 == null || I0 == null) {
                return;
            }
            int H = r0.H(J0);
            int H2 = r0.H(I0);
            if (H < H2) {
                accessibilityEvent.setFromIndex(H);
                accessibilityEvent.setToIndex(H2);
                return;
            }
            accessibilityEvent.setFromIndex(H2);
            accessibilityEvent.setToIndex(H);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:251:0x0408, code lost:
        if (D0() != false) goto L262;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U0(androidx.recyclerview.widget.y0 r17, androidx.recyclerview.widget.e1 r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 1062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.U0(androidx.recyclerview.widget.y0, androidx.recyclerview.widget.e1, boolean):void");
    }

    public final boolean V0(int i5) {
        if (this.f1263t == 0) {
            return (i5 == -1) != this.f1267x;
        }
        return ((i5 == -1) == this.f1267x) == S0();
    }

    public final void W0(int i5, e1 e1Var) {
        int M0;
        int i6;
        if (i5 > 0) {
            M0 = N0();
            i6 = 1;
        } else {
            M0 = M0();
            i6 = -1;
        }
        v vVar = this.f1265v;
        vVar.f1539a = true;
        d1(M0, e1Var);
        c1(i6);
        vVar.f1541c = M0 + vVar.f1542d;
        vVar.f1540b = Math.abs(i5);
    }

    public final void X0(y0 y0Var, v vVar) {
        if (!vVar.f1539a || vVar.f1547i) {
            return;
        }
        if (vVar.f1540b == 0) {
            if (vVar.f1543e == -1) {
                Y0(vVar.f1545g, y0Var);
                return;
            } else {
                Z0(vVar.f1544f, y0Var);
                return;
            }
        }
        int i5 = 1;
        if (vVar.f1543e == -1) {
            int i6 = vVar.f1544f;
            int i7 = this.f1260q[0].i(i6);
            while (i5 < this.f1259p) {
                int i8 = this.f1260q[i5].i(i6);
                if (i8 > i7) {
                    i7 = i8;
                }
                i5++;
            }
            int i9 = i6 - i7;
            Y0(i9 < 0 ? vVar.f1545g : vVar.f1545g - Math.min(i9, vVar.f1540b), y0Var);
            return;
        }
        int i10 = vVar.f1545g;
        int f5 = this.f1260q[0].f(i10);
        while (i5 < this.f1259p) {
            int f6 = this.f1260q[i5].f(i10);
            if (f6 < f5) {
                f5 = f6;
            }
            i5++;
        }
        int i11 = f5 - vVar.f1545g;
        Z0(i11 < 0 ? vVar.f1544f : Math.min(i11, vVar.f1540b) + vVar.f1544f, y0Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public final void Y(int i5, int i6) {
        Q0(i5, i6, 1);
    }

    public final void Y0(int i5, y0 y0Var) {
        for (int v5 = v() - 1; v5 >= 0; v5--) {
            View u3 = u(v5);
            if (this.f1261r.d(u3) < i5 || this.f1261r.k(u3) < i5) {
                return;
            }
            n1 n1Var = (n1) u3.getLayoutParams();
            n1Var.getClass();
            if (n1Var.f1437e.f1486a.size() == 1) {
                return;
            }
            q1 q1Var = n1Var.f1437e;
            ArrayList arrayList = q1Var.f1486a;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            n1 h5 = q1.h(view);
            h5.f1437e = null;
            if (h5.c() || h5.b()) {
                q1Var.f1489d -= q1Var.f1491f.f1261r.c(view);
            }
            if (size == 1) {
                q1Var.f1487b = Integer.MIN_VALUE;
            }
            q1Var.f1488c = Integer.MIN_VALUE;
            k0(u3, y0Var);
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public final void Z() {
        this.B.d();
        n0();
    }

    public final void Z0(int i5, y0 y0Var) {
        while (v() > 0) {
            View u3 = u(0);
            if (this.f1261r.b(u3) > i5 || this.f1261r.j(u3) > i5) {
                return;
            }
            n1 n1Var = (n1) u3.getLayoutParams();
            n1Var.getClass();
            if (n1Var.f1437e.f1486a.size() == 1) {
                return;
            }
            q1 q1Var = n1Var.f1437e;
            ArrayList arrayList = q1Var.f1486a;
            View view = (View) arrayList.remove(0);
            n1 h5 = q1.h(view);
            h5.f1437e = null;
            if (arrayList.size() == 0) {
                q1Var.f1488c = Integer.MIN_VALUE;
            }
            if (h5.c() || h5.b()) {
                q1Var.f1489d -= q1Var.f1491f.f1261r.c(view);
            }
            q1Var.f1487b = Integer.MIN_VALUE;
            k0(u3, y0Var);
        }
    }

    @Override // androidx.recyclerview.widget.d1
    public final PointF a(int i5) {
        int C0 = C0(i5);
        PointF pointF = new PointF();
        if (C0 == 0) {
            return null;
        }
        if (this.f1263t == 0) {
            pointF.x = C0;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = C0;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void a0(int i5, int i6) {
        Q0(i5, i6, 8);
    }

    public final void a1() {
        if (this.f1263t == 1 || !S0()) {
            this.f1267x = this.f1266w;
        } else {
            this.f1267x = !this.f1266w;
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public final void b0(int i5, int i6) {
        Q0(i5, i6, 2);
    }

    public final int b1(int i5, y0 y0Var, e1 e1Var) {
        if (v() == 0 || i5 == 0) {
            return 0;
        }
        W0(i5, e1Var);
        v vVar = this.f1265v;
        int H0 = H0(y0Var, vVar, e1Var);
        if (vVar.f1540b >= H0) {
            i5 = i5 < 0 ? -H0 : H0;
        }
        this.f1261r.l(-i5);
        this.D = this.f1267x;
        vVar.f1540b = 0;
        X0(y0Var, vVar);
        return i5;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void c(String str) {
        if (this.F == null) {
            super.c(str);
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public final void c0(int i5, int i6) {
        Q0(i5, i6, 4);
    }

    public final void c1(int i5) {
        v vVar = this.f1265v;
        vVar.f1543e = i5;
        vVar.f1542d = this.f1267x != (i5 == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.r0
    public final boolean d() {
        return this.f1263t == 0;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void d0(y0 y0Var, e1 e1Var) {
        U0(y0Var, e1Var, true);
    }

    public final void d1(int i5, e1 e1Var) {
        int i6;
        int i7;
        int i8;
        v vVar = this.f1265v;
        boolean z4 = false;
        vVar.f1540b = 0;
        vVar.f1541c = i5;
        a0 a0Var = this.f1500e;
        if (!(a0Var != null && a0Var.f1278e) || (i8 = e1Var.f1322a) == -1) {
            i6 = 0;
            i7 = 0;
        } else {
            if (this.f1267x == (i8 < i5)) {
                i6 = this.f1261r.i();
                i7 = 0;
            } else {
                i7 = this.f1261r.i();
                i6 = 0;
            }
        }
        RecyclerView recyclerView = this.f1497b;
        if (recyclerView != null && recyclerView.f1234n) {
            vVar.f1544f = this.f1261r.h() - i7;
            vVar.f1545g = this.f1261r.f() + i6;
        } else {
            vVar.f1545g = this.f1261r.e() + i6;
            vVar.f1544f = -i7;
        }
        vVar.f1546h = false;
        vVar.f1539a = true;
        if (this.f1261r.g() == 0 && this.f1261r.e() == 0) {
            z4 = true;
        }
        vVar.f1547i = z4;
    }

    @Override // androidx.recyclerview.widget.r0
    public final boolean e() {
        return this.f1263t == 1;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void e0(e1 e1Var) {
        this.f1269z = -1;
        this.A = Integer.MIN_VALUE;
        this.F = null;
        this.H.a();
    }

    public final void e1(q1 q1Var, int i5, int i6) {
        int i7 = q1Var.f1489d;
        int i8 = q1Var.f1490e;
        if (i5 != -1) {
            int i9 = q1Var.f1488c;
            if (i9 == Integer.MIN_VALUE) {
                q1Var.a();
                i9 = q1Var.f1488c;
            }
            if (i9 - i7 >= i6) {
                this.f1268y.set(i8, false);
                return;
            }
            return;
        }
        int i10 = q1Var.f1487b;
        if (i10 == Integer.MIN_VALUE) {
            View view = (View) q1Var.f1486a.get(0);
            n1 h5 = q1.h(view);
            q1Var.f1487b = q1Var.f1491f.f1261r.d(view);
            h5.getClass();
            i10 = q1Var.f1487b;
        }
        if (i10 + i7 <= i6) {
            this.f1268y.set(i8, false);
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public final boolean f(s0 s0Var) {
        return s0Var instanceof n1;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void f0(Parcelable parcelable) {
        if (parcelable instanceof p1) {
            p1 p1Var = (p1) parcelable;
            this.F = p1Var;
            if (this.f1269z != -1) {
                p1Var.f1450e = null;
                p1Var.f1449d = 0;
                p1Var.f1447b = -1;
                p1Var.f1448c = -1;
                p1Var.f1450e = null;
                p1Var.f1449d = 0;
                p1Var.f1451f = 0;
                p1Var.f1452g = null;
                p1Var.f1453h = null;
            }
            n0();
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public final Parcelable g0() {
        int i5;
        int h5;
        int[] iArr;
        p1 p1Var = this.F;
        if (p1Var != null) {
            return new p1(p1Var);
        }
        p1 p1Var2 = new p1();
        p1Var2.f1454i = this.f1266w;
        p1Var2.f1455j = this.D;
        p1Var2.f1456k = this.E;
        u1 u1Var = this.B;
        if (u1Var == null || (iArr = (int[]) u1Var.f1537b) == null) {
            p1Var2.f1451f = 0;
        } else {
            p1Var2.f1452g = iArr;
            p1Var2.f1451f = iArr.length;
            p1Var2.f1453h = (List) u1Var.f1538c;
        }
        if (v() > 0) {
            p1Var2.f1447b = this.D ? N0() : M0();
            View I0 = this.f1267x ? I0(true) : J0(true);
            p1Var2.f1448c = I0 != null ? r0.H(I0) : -1;
            int i6 = this.f1259p;
            p1Var2.f1449d = i6;
            p1Var2.f1450e = new int[i6];
            for (int i7 = 0; i7 < this.f1259p; i7++) {
                if (this.D) {
                    i5 = this.f1260q[i7].f(Integer.MIN_VALUE);
                    if (i5 != Integer.MIN_VALUE) {
                        h5 = this.f1261r.f();
                        i5 -= h5;
                        p1Var2.f1450e[i7] = i5;
                    } else {
                        p1Var2.f1450e[i7] = i5;
                    }
                } else {
                    i5 = this.f1260q[i7].i(Integer.MIN_VALUE);
                    if (i5 != Integer.MIN_VALUE) {
                        h5 = this.f1261r.h();
                        i5 -= h5;
                        p1Var2.f1450e[i7] = i5;
                    } else {
                        p1Var2.f1450e[i7] = i5;
                    }
                }
            }
        } else {
            p1Var2.f1447b = -1;
            p1Var2.f1448c = -1;
            p1Var2.f1449d = 0;
        }
        return p1Var2;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void h(int i5, int i6, e1 e1Var, r rVar) {
        v vVar;
        int f5;
        int i7;
        if (this.f1263t != 0) {
            i5 = i6;
        }
        if (v() == 0 || i5 == 0) {
            return;
        }
        W0(i5, e1Var);
        int[] iArr = this.J;
        if (iArr == null || iArr.length < this.f1259p) {
            this.J = new int[this.f1259p];
        }
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = this.f1259p;
            vVar = this.f1265v;
            if (i8 >= i10) {
                break;
            }
            if (vVar.f1542d == -1) {
                f5 = vVar.f1544f;
                i7 = this.f1260q[i8].i(f5);
            } else {
                f5 = this.f1260q[i8].f(vVar.f1545g);
                i7 = vVar.f1545g;
            }
            int i11 = f5 - i7;
            if (i11 >= 0) {
                this.J[i9] = i11;
                i9++;
            }
            i8++;
        }
        Arrays.sort(this.J, 0, i9);
        for (int i12 = 0; i12 < i9; i12++) {
            int i13 = vVar.f1541c;
            if (!(i13 >= 0 && i13 < e1Var.b())) {
                return;
            }
            rVar.a(vVar.f1541c, this.J[i12]);
            vVar.f1541c += vVar.f1542d;
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public final void h0(int i5) {
        if (i5 == 0) {
            D0();
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public final int j(e1 e1Var) {
        return E0(e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public final int k(e1 e1Var) {
        return F0(e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public final int l(e1 e1Var) {
        return G0(e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public final int m(e1 e1Var) {
        return E0(e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public final int n(e1 e1Var) {
        return F0(e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public final int o(e1 e1Var) {
        return G0(e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public final int o0(int i5, y0 y0Var, e1 e1Var) {
        return b1(i5, y0Var, e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public final void p0(int i5) {
        p1 p1Var = this.F;
        if (p1Var != null && p1Var.f1447b != i5) {
            p1Var.f1450e = null;
            p1Var.f1449d = 0;
            p1Var.f1447b = -1;
            p1Var.f1448c = -1;
        }
        this.f1269z = i5;
        this.A = Integer.MIN_VALUE;
        n0();
    }

    @Override // androidx.recyclerview.widget.r0
    public final int q0(int i5, y0 y0Var, e1 e1Var) {
        return b1(i5, y0Var, e1Var);
    }

    @Override // androidx.recyclerview.widget.r0
    public final s0 r() {
        return this.f1263t == 0 ? new n1(-2, -1) : new n1(-1, -2);
    }

    @Override // androidx.recyclerview.widget.r0
    public final s0 s(Context context, AttributeSet attributeSet) {
        return new n1(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.r0
    public final s0 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new n1((ViewGroup.MarginLayoutParams) layoutParams) : new n1(layoutParams);
    }

    @Override // androidx.recyclerview.widget.r0
    public final void t0(Rect rect, int i5, int i6) {
        int g5;
        int g6;
        int F = F() + E();
        int D = D() + G();
        if (this.f1263t == 1) {
            int height = rect.height() + D;
            RecyclerView recyclerView = this.f1497b;
            WeakHashMap weakHashMap = h0.z0.f3233a;
            g6 = r0.g(i6, height, recyclerView.getMinimumHeight());
            g5 = r0.g(i5, (this.f1264u * this.f1259p) + F, this.f1497b.getMinimumWidth());
        } else {
            int width = rect.width() + F;
            RecyclerView recyclerView2 = this.f1497b;
            WeakHashMap weakHashMap2 = h0.z0.f3233a;
            g5 = r0.g(i5, width, recyclerView2.getMinimumWidth());
            g6 = r0.g(i6, (this.f1264u * this.f1259p) + D, this.f1497b.getMinimumHeight());
        }
        this.f1497b.setMeasuredDimension(g5, g6);
    }

    @Override // androidx.recyclerview.widget.r0
    public final void z0(RecyclerView recyclerView, int i5) {
        a0 a0Var = new a0(recyclerView.getContext());
        a0Var.f1274a = i5;
        A0(a0Var);
    }
}
