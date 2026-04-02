package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.GridView;
import androidx.appcompat.widget.f3;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean E;
    public int F;
    public int[] G;
    public View[] H;
    public final SparseIntArray I;
    public final SparseIntArray J;
    public final f3 K;
    public final Rect L;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new f3(1);
        this.L = new Rect();
        n1(r0.I(context, attributeSet, i5, i6).f1483b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.r0
    public final boolean B0() {
        return this.f1213z == null && !this.E;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void D0(e1 e1Var, y yVar, r rVar) {
        int i5 = this.F;
        for (int i6 = 0; i6 < this.F; i6++) {
            int i7 = yVar.f1567d;
            if (!(i7 >= 0 && i7 < e1Var.b()) || i5 <= 0) {
                return;
            }
            rVar.a(yVar.f1567d, Math.max(0, yVar.f1570g));
            this.K.getClass();
            i5--;
            yVar.f1567d += yVar.f1568e;
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public final int J(y0 y0Var, e1 e1Var) {
        if (this.f1203p == 0) {
            return this.F;
        }
        if (e1Var.b() < 1) {
            return 0;
        }
        return j1(e1Var.b() - 1, y0Var, e1Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View Q0(y0 y0Var, e1 e1Var, boolean z4, boolean z5) {
        int i5;
        int i6;
        int v5 = v();
        int i7 = 1;
        if (z5) {
            i6 = v() - 1;
            i5 = -1;
            i7 = -1;
        } else {
            i5 = v5;
            i6 = 0;
        }
        int b5 = e1Var.b();
        I0();
        int h5 = this.f1205r.h();
        int f5 = this.f1205r.f();
        View view = null;
        View view2 = null;
        while (i6 != i5) {
            View u3 = u(i6);
            int H = r0.H(u3);
            if (H >= 0 && H < b5 && k1(H, y0Var, e1Var) == 0) {
                if (((s0) u3.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = u3;
                    }
                } else if (this.f1205r.d(u3) < f5 && this.f1205r.b(u3) >= h5) {
                    return u3;
                } else {
                    if (view == null) {
                        view = u3;
                    }
                }
            }
            i6 += i7;
        }
        return view != null ? view : view2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r22.f1496a.j(r3) != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e1, code lost:
        if (r13 == (r2 > r15)) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0111, code lost:
        if (r13 == (r2 > r9)) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011d  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.r0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View T(android.view.View r23, int r24, androidx.recyclerview.widget.y0 r25, androidx.recyclerview.widget.e1 r26) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.T(android.view.View, int, androidx.recyclerview.widget.y0, androidx.recyclerview.widget.e1):android.view.View");
    }

    @Override // androidx.recyclerview.widget.r0
    public final void V(y0 y0Var, e1 e1Var, i0.j jVar) {
        super.V(y0Var, e1Var, jVar);
        jVar.h(GridView.class.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b0  */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v26, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v42 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void W0(androidx.recyclerview.widget.y0 r19, androidx.recyclerview.widget.e1 r20, androidx.recyclerview.widget.y r21, androidx.recyclerview.widget.x r22) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.W0(androidx.recyclerview.widget.y0, androidx.recyclerview.widget.e1, androidx.recyclerview.widget.y, androidx.recyclerview.widget.x):void");
    }

    @Override // androidx.recyclerview.widget.r0
    public final void X(y0 y0Var, e1 e1Var, View view, i0.j jVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof u)) {
            W(view, jVar);
            return;
        }
        u uVar = (u) layoutParams;
        int j12 = j1(uVar.a(), y0Var, e1Var);
        int i5 = this.f1203p;
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f3375a;
        if (i5 == 0) {
            accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(uVar.f1534e, uVar.f1535f, j12, 1, false, false));
        } else {
            accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(j12, 1, uVar.f1534e, uVar.f1535f, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void X0(y0 y0Var, e1 e1Var, w wVar, int i5) {
        o1();
        if (e1Var.b() > 0 && !e1Var.f1328g) {
            boolean z4 = i5 == 1;
            int k12 = k1(wVar.f1549b, y0Var, e1Var);
            if (z4) {
                while (k12 > 0) {
                    int i6 = wVar.f1549b;
                    if (i6 <= 0) {
                        break;
                    }
                    int i7 = i6 - 1;
                    wVar.f1549b = i7;
                    k12 = k1(i7, y0Var, e1Var);
                }
            } else {
                int b5 = e1Var.b() - 1;
                int i8 = wVar.f1549b;
                while (i8 < b5) {
                    int i9 = i8 + 1;
                    int k13 = k1(i9, y0Var, e1Var);
                    if (k13 <= k12) {
                        break;
                    }
                    i8 = i9;
                    k12 = k13;
                }
                wVar.f1549b = i8;
            }
        }
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public final void Y(int i5, int i6) {
        f3 f3Var = this.K;
        f3Var.d();
        ((SparseIntArray) f3Var.f349d).clear();
    }

    @Override // androidx.recyclerview.widget.r0
    public final void Z() {
        f3 f3Var = this.K;
        f3Var.d();
        ((SparseIntArray) f3Var.f349d).clear();
    }

    @Override // androidx.recyclerview.widget.r0
    public final void a0(int i5, int i6) {
        f3 f3Var = this.K;
        f3Var.d();
        ((SparseIntArray) f3Var.f349d).clear();
    }

    @Override // androidx.recyclerview.widget.r0
    public final void b0(int i5, int i6) {
        f3 f3Var = this.K;
        f3Var.d();
        ((SparseIntArray) f3Var.f349d).clear();
    }

    @Override // androidx.recyclerview.widget.r0
    public final void c0(int i5, int i6) {
        f3 f3Var = this.K;
        f3Var.d();
        ((SparseIntArray) f3Var.f349d).clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.r0
    public final void d0(y0 y0Var, e1 e1Var) {
        boolean z4 = e1Var.f1328g;
        SparseIntArray sparseIntArray = this.J;
        SparseIntArray sparseIntArray2 = this.I;
        if (z4) {
            int v5 = v();
            for (int i5 = 0; i5 < v5; i5++) {
                u uVar = (u) u(i5).getLayoutParams();
                int a5 = uVar.a();
                sparseIntArray2.put(a5, uVar.f1535f);
                sparseIntArray.put(a5, uVar.f1534e);
            }
        }
        super.d0(y0Var, e1Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void d1(boolean z4) {
        if (z4) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.d1(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.r0
    public final void e0(e1 e1Var) {
        super.e0(e1Var);
        this.E = false;
    }

    @Override // androidx.recyclerview.widget.r0
    public final boolean f(s0 s0Var) {
        return s0Var instanceof u;
    }

    public final void h1(int i5) {
        int i6;
        int[] iArr = this.G;
        int i7 = this.F;
        if (iArr == null || iArr.length != i7 + 1 || iArr[iArr.length - 1] != i5) {
            iArr = new int[i7 + 1];
        }
        int i8 = 0;
        iArr[0] = 0;
        int i9 = i5 / i7;
        int i10 = i5 % i7;
        int i11 = 0;
        for (int i12 = 1; i12 <= i7; i12++) {
            i8 += i10;
            if (i8 <= 0 || i7 - i8 >= i10) {
                i6 = i9;
            } else {
                i6 = i9 + 1;
                i8 -= i7;
            }
            i11 += i6;
            iArr[i12] = i11;
        }
        this.G = iArr;
    }

    public final int i1(int i5, int i6) {
        if (this.f1203p != 1 || !V0()) {
            int[] iArr = this.G;
            return iArr[i6 + i5] - iArr[i5];
        }
        int[] iArr2 = this.G;
        int i7 = this.F;
        return iArr2[i7 - i5] - iArr2[(i7 - i5) - i6];
    }

    public final int j1(int i5, y0 y0Var, e1 e1Var) {
        boolean z4 = e1Var.f1328g;
        f3 f3Var = this.K;
        if (z4) {
            int b5 = y0Var.b(i5);
            if (b5 == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i5);
                return 0;
            }
            return f3Var.a(b5, this.F);
        }
        return f3Var.a(i5, this.F);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.r0
    public final int k(e1 e1Var) {
        return F0(e1Var);
    }

    public final int k1(int i5, y0 y0Var, e1 e1Var) {
        boolean z4 = e1Var.f1328g;
        f3 f3Var = this.K;
        if (z4) {
            int i6 = this.J.get(i5, -1);
            if (i6 != -1) {
                return i6;
            }
            int b5 = y0Var.b(i5);
            if (b5 == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i5);
                return 0;
            }
            return f3Var.b(b5, this.F);
        }
        return f3Var.b(i5, this.F);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.r0
    public final int l(e1 e1Var) {
        return G0(e1Var);
    }

    public final int l1(int i5, y0 y0Var, e1 e1Var) {
        boolean z4 = e1Var.f1328g;
        f3 f3Var = this.K;
        if (!z4) {
            f3Var.getClass();
            return 1;
        }
        int i6 = this.I.get(i5, -1);
        if (i6 != -1) {
            return i6;
        }
        if (y0Var.b(i5) != -1) {
            f3Var.getClass();
            return 1;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i5);
        return 1;
    }

    public final void m1(View view, int i5, boolean z4) {
        int i6;
        int i7;
        u uVar = (u) view.getLayoutParams();
        Rect rect = uVar.f1521b;
        int i8 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) uVar).topMargin + ((ViewGroup.MarginLayoutParams) uVar).bottomMargin;
        int i9 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) uVar).leftMargin + ((ViewGroup.MarginLayoutParams) uVar).rightMargin;
        int i12 = i1(uVar.f1534e, uVar.f1535f);
        if (this.f1203p == 1) {
            i7 = r0.w(false, i12, i5, i9, ((ViewGroup.MarginLayoutParams) uVar).width);
            i6 = r0.w(true, this.f1205r.i(), this.f1508m, i8, ((ViewGroup.MarginLayoutParams) uVar).height);
        } else {
            int w5 = r0.w(false, i12, i5, i8, ((ViewGroup.MarginLayoutParams) uVar).height);
            int w6 = r0.w(true, this.f1205r.i(), this.f1507l, i9, ((ViewGroup.MarginLayoutParams) uVar).width);
            i6 = w5;
            i7 = w6;
        }
        s0 s0Var = (s0) view.getLayoutParams();
        if (z4 ? y0(view, i7, i6, s0Var) : w0(view, i7, i6, s0Var)) {
            view.measure(i7, i6);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.r0
    public final int n(e1 e1Var) {
        return F0(e1Var);
    }

    public final void n1(int i5) {
        if (i5 == this.F) {
            return;
        }
        this.E = true;
        if (i5 < 1) {
            throw new IllegalArgumentException(androidx.appcompat.widget.b0.f("Span count should be at least 1. Provided ", i5));
        }
        this.F = i5;
        this.K.d();
        n0();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.r0
    public final int o(e1 e1Var) {
        return G0(e1Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.r0
    public final int o0(int i5, y0 y0Var, e1 e1Var) {
        o1();
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
        return super.o0(i5, y0Var, e1Var);
    }

    public final void o1() {
        int D;
        int G;
        if (this.f1203p == 1) {
            D = this.f1509n - F();
            G = E();
        } else {
            D = this.o - D();
            G = G();
        }
        h1(D - G);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.r0
    public final int q0(int i5, y0 y0Var, e1 e1Var) {
        o1();
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
        return super.q0(i5, y0Var, e1Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.r0
    public final s0 r() {
        return this.f1203p == 0 ? new u(-2, -1) : new u(-1, -2);
    }

    @Override // androidx.recyclerview.widget.r0
    public final s0 s(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.r0
    public final s0 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new u((ViewGroup.MarginLayoutParams) layoutParams) : new u(layoutParams);
    }

    @Override // androidx.recyclerview.widget.r0
    public final void t0(Rect rect, int i5, int i6) {
        int g5;
        int g6;
        if (this.G == null) {
            super.t0(rect, i5, i6);
        }
        int F = F() + E();
        int D = D() + G();
        if (this.f1203p == 1) {
            int height = rect.height() + D;
            RecyclerView recyclerView = this.f1497b;
            WeakHashMap weakHashMap = h0.z0.f3233a;
            g6 = r0.g(i6, height, recyclerView.getMinimumHeight());
            int[] iArr = this.G;
            g5 = r0.g(i5, iArr[iArr.length - 1] + F, this.f1497b.getMinimumWidth());
        } else {
            int width = rect.width() + F;
            RecyclerView recyclerView2 = this.f1497b;
            WeakHashMap weakHashMap2 = h0.z0.f3233a;
            g5 = r0.g(i5, width, recyclerView2.getMinimumWidth());
            int[] iArr2 = this.G;
            g6 = r0.g(i6, iArr2[iArr2.length - 1] + D, this.f1497b.getMinimumHeight());
        }
        this.f1497b.setMeasuredDimension(g5, g6);
    }

    @Override // androidx.recyclerview.widget.r0
    public final int x(y0 y0Var, e1 e1Var) {
        if (this.f1203p == 1) {
            return this.F;
        }
        if (e1Var.b() < 1) {
            return 0;
        }
        return j1(e1Var.b() - 1, y0Var, e1Var) + 1;
    }

    public GridLayoutManager(int i5) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new f3(1);
        this.L = new Rect();
        n1(i5);
    }
}
