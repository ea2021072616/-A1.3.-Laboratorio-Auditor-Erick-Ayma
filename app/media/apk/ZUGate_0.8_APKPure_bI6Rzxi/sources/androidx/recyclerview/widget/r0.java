package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class r0 {

    /* renamed from: a  reason: collision with root package name */
    public d f1496a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f1497b;

    /* renamed from: c  reason: collision with root package name */
    public final u1 f1498c;

    /* renamed from: d  reason: collision with root package name */
    public final u1 f1499d;

    /* renamed from: e  reason: collision with root package name */
    public a0 f1500e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1501f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1502g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1503h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f1504i;

    /* renamed from: j  reason: collision with root package name */
    public int f1505j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1506k;

    /* renamed from: l  reason: collision with root package name */
    public int f1507l;

    /* renamed from: m  reason: collision with root package name */
    public int f1508m;

    /* renamed from: n  reason: collision with root package name */
    public int f1509n;
    public int o;

    public r0() {
        p0 p0Var = new p0(this, 0);
        p0 p0Var2 = new p0(this, 1);
        this.f1498c = new u1(p0Var);
        this.f1499d = new u1(p0Var2);
        this.f1501f = false;
        this.f1502g = false;
        this.f1503h = true;
        this.f1504i = true;
    }

    public static int A(View view) {
        Rect rect = ((s0) view.getLayoutParams()).f1521b;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public static int H(View view) {
        return ((s0) view.getLayoutParams()).a();
    }

    public static q0 I(Context context, AttributeSet attributeSet, int i5, int i6) {
        q0 q0Var = new q0();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a1.a.f2a, i5, i6);
        q0Var.f1482a = obtainStyledAttributes.getInt(0, 1);
        q0Var.f1483b = obtainStyledAttributes.getInt(10, 1);
        q0Var.f1484c = obtainStyledAttributes.getBoolean(9, false);
        q0Var.f1485d = obtainStyledAttributes.getBoolean(11, false);
        obtainStyledAttributes.recycle();
        return q0Var;
    }

    public static boolean M(int i5, int i6, int i7) {
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        if (i7 <= 0 || i5 == i7) {
            if (mode == Integer.MIN_VALUE) {
                return size >= i5;
            } else if (mode != 0) {
                return mode == 1073741824 && size == i5;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void N(View view, int i5, int i6, int i7, int i8) {
        s0 s0Var = (s0) view.getLayoutParams();
        Rect rect = s0Var.f1521b;
        view.layout(i5 + rect.left + ((ViewGroup.MarginLayoutParams) s0Var).leftMargin, i6 + rect.top + ((ViewGroup.MarginLayoutParams) s0Var).topMargin, (i7 - rect.right) - ((ViewGroup.MarginLayoutParams) s0Var).rightMargin, (i8 - rect.bottom) - ((ViewGroup.MarginLayoutParams) s0Var).bottomMargin);
    }

    public static int g(int i5, int i6, int i7) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i6, i7) : size : Math.min(size, Math.max(i6, i7));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        if (r6 == 1073741824) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int w(boolean r4, int r5, int r6, int r7, int r8) {
        /*
            int r5 = r5 - r7
            r7 = 0
            int r5 = java.lang.Math.max(r7, r5)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r4 == 0) goto L1a
            if (r8 < 0) goto L11
            goto L1c
        L11:
            if (r8 != r1) goto L2f
            if (r6 == r2) goto L20
            if (r6 == 0) goto L2f
            if (r6 == r3) goto L20
            goto L2f
        L1a:
            if (r8 < 0) goto L1e
        L1c:
            r6 = r3
            goto L31
        L1e:
            if (r8 != r1) goto L22
        L20:
            r8 = r5
            goto L31
        L22:
            if (r8 != r0) goto L2f
            if (r6 == r2) goto L2c
            if (r6 != r3) goto L29
            goto L2c
        L29:
            r8 = r5
            r6 = r7
            goto L31
        L2c:
            r8 = r5
            r6 = r2
            goto L31
        L2f:
            r6 = r7
            r8 = r6
        L31:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.r0.w(boolean, int, int, int, int):int");
    }

    public static int z(View view) {
        Rect rect = ((s0) view.getLayoutParams()).f1521b;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public final void A0(a0 a0Var) {
        a0 a0Var2 = this.f1500e;
        if (a0Var2 != null && a0Var != a0Var2 && a0Var2.f1278e) {
            a0Var2.i();
        }
        this.f1500e = a0Var;
        RecyclerView recyclerView = this.f1497b;
        h1 h1Var = recyclerView.f1227j0;
        h1Var.f1365h.removeCallbacks(h1Var);
        h1Var.f1361d.abortAnimation();
        if (a0Var.f1281h) {
            Log.w("RecyclerView", "An instance of " + a0Var.getClass().getSimpleName() + " was started more than once. Each instance of" + a0Var.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        a0Var.f1275b = recyclerView;
        a0Var.f1276c = this;
        int i5 = a0Var.f1274a;
        if (i5 == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        recyclerView.f1233m0.f1322a = i5;
        a0Var.f1278e = true;
        a0Var.f1277d = true;
        a0Var.f1279f = recyclerView.f1245t.q(i5);
        a0Var.f1275b.f1227j0.b();
        a0Var.f1281h = true;
    }

    public final int B() {
        RecyclerView recyclerView = this.f1497b;
        i0 adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.a();
        }
        return 0;
    }

    public boolean B0() {
        return false;
    }

    public final int C() {
        RecyclerView recyclerView = this.f1497b;
        WeakHashMap weakHashMap = h0.z0.f3233a;
        return recyclerView.getLayoutDirection();
    }

    public final int D() {
        RecyclerView recyclerView = this.f1497b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int E() {
        RecyclerView recyclerView = this.f1497b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int F() {
        RecyclerView recyclerView = this.f1497b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int G() {
        RecyclerView recyclerView = this.f1497b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int J(y0 y0Var, e1 e1Var) {
        return -1;
    }

    public final void K(View view, Rect rect) {
        Matrix matrix;
        Rect rect2 = ((s0) view.getLayoutParams()).f1521b;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.f1497b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.f1497b.f1241r;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public abstract boolean L();

    public void O(int i5) {
        RecyclerView recyclerView = this.f1497b;
        if (recyclerView != null) {
            int e5 = recyclerView.f1230l.e();
            for (int i6 = 0; i6 < e5; i6++) {
                recyclerView.f1230l.d(i6).offsetLeftAndRight(i5);
            }
        }
    }

    public void P(int i5) {
        RecyclerView recyclerView = this.f1497b;
        if (recyclerView != null) {
            int e5 = recyclerView.f1230l.e();
            for (int i6 = 0; i6 < e5; i6++) {
                recyclerView.f1230l.d(i6).offsetTopAndBottom(i5);
            }
        }
    }

    public void Q() {
    }

    public void R(RecyclerView recyclerView) {
    }

    public abstract void S(RecyclerView recyclerView);

    public abstract View T(View view, int i5, y0 y0Var, e1 e1Var);

    public void U(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f1497b;
        y0 y0Var = recyclerView.f1224i;
        e1 e1Var = recyclerView.f1233m0;
        if (recyclerView == null || accessibilityEvent == null) {
            return;
        }
        boolean z4 = true;
        if (!recyclerView.canScrollVertically(1) && !this.f1497b.canScrollVertically(-1) && !this.f1497b.canScrollHorizontally(-1) && !this.f1497b.canScrollHorizontally(1)) {
            z4 = false;
        }
        accessibilityEvent.setScrollable(z4);
        i0 i0Var = this.f1497b.f1243s;
        if (i0Var != null) {
            accessibilityEvent.setItemCount(i0Var.a());
        }
    }

    public void V(y0 y0Var, e1 e1Var, i0.j jVar) {
        boolean canScrollVertically = this.f1497b.canScrollVertically(-1);
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f3375a;
        if (canScrollVertically || this.f1497b.canScrollHorizontally(-1)) {
            jVar.a(8192);
            accessibilityNodeInfo.setScrollable(true);
        }
        if (this.f1497b.canScrollVertically(1) || this.f1497b.canScrollHorizontally(1)) {
            jVar.a(4096);
            accessibilityNodeInfo.setScrollable(true);
        }
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(J(y0Var, e1Var), x(y0Var, e1Var), false, 0));
    }

    public final void W(View view, i0.j jVar) {
        i1 L = RecyclerView.L(view);
        if (L == null || L.i() || this.f1496a.j(L.f1376a)) {
            return;
        }
        RecyclerView recyclerView = this.f1497b;
        X(recyclerView.f1224i, recyclerView.f1233m0, view, jVar);
    }

    public void X(y0 y0Var, e1 e1Var, View view, i0.j jVar) {
    }

    public void Y(int i5, int i6) {
    }

    public void Z() {
    }

    public void a0(int i5, int i6) {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.view.View r8, int r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.r0.b(android.view.View, int, boolean):void");
    }

    public void b0(int i5, int i6) {
    }

    public void c(String str) {
        RecyclerView recyclerView = this.f1497b;
        if (recyclerView != null) {
            recyclerView.k(str);
        }
    }

    public void c0(int i5, int i6) {
    }

    public abstract boolean d();

    public abstract void d0(y0 y0Var, e1 e1Var);

    public abstract boolean e();

    public abstract void e0(e1 e1Var);

    public boolean f(s0 s0Var) {
        return s0Var != null;
    }

    public void f0(Parcelable parcelable) {
    }

    public Parcelable g0() {
        return null;
    }

    public void h(int i5, int i6, e1 e1Var, r rVar) {
    }

    public void h0(int i5) {
    }

    public void i(int i5, r rVar) {
    }

    public final void i0(y0 y0Var) {
        int v5 = v();
        while (true) {
            v5--;
            if (v5 < 0) {
                return;
            }
            if (!RecyclerView.L(u(v5)).o()) {
                View u3 = u(v5);
                l0(v5);
                y0Var.i(u3);
            }
        }
    }

    public abstract int j(e1 e1Var);

    public final void j0(y0 y0Var) {
        ArrayList arrayList;
        int size = y0Var.f1576a.size();
        int i5 = size - 1;
        while (true) {
            arrayList = y0Var.f1576a;
            if (i5 < 0) {
                break;
            }
            View view = ((i1) arrayList.get(i5)).f1376a;
            i1 L = RecyclerView.L(view);
            if (!L.o()) {
                L.n(false);
                if (L.k()) {
                    this.f1497b.removeDetachedView(view, false);
                }
                n0 n0Var = this.f1497b.R;
                if (n0Var != null) {
                    n0Var.d(L);
                }
                L.n(true);
                i1 L2 = RecyclerView.L(view);
                L2.f1389n = null;
                L2.o = false;
                L2.f1385j &= -33;
                y0Var.j(L2);
            }
            i5--;
        }
        arrayList.clear();
        ArrayList arrayList2 = y0Var.f1577b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.f1497b.invalidate();
        }
    }

    public abstract int k(e1 e1Var);

    public final void k0(View view, y0 y0Var) {
        d dVar = this.f1496a;
        h0 h0Var = dVar.f1309a;
        int i5 = dVar.f1312d;
        if (i5 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i5 == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            dVar.f1312d = 1;
            dVar.f1313e = view;
            int indexOfChild = h0Var.f1358a.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (dVar.f1310b.f(indexOfChild)) {
                    dVar.k(view);
                }
                h0Var.i(indexOfChild);
            }
            dVar.f1312d = 0;
            dVar.f1313e = null;
            y0Var.i(view);
        } catch (Throwable th) {
            dVar.f1312d = 0;
            dVar.f1313e = null;
            throw th;
        }
    }

    public abstract int l(e1 e1Var);

    public final void l0(int i5) {
        if (u(i5) != null) {
            d dVar = this.f1496a;
            h0 h0Var = dVar.f1309a;
            int i6 = dVar.f1312d;
            if (i6 == 1) {
                throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
            }
            if (i6 == 2) {
                throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
            }
            try {
                int f5 = dVar.f(i5);
                View childAt = h0Var.f1358a.getChildAt(f5);
                if (childAt != null) {
                    dVar.f1312d = 1;
                    dVar.f1313e = childAt;
                    if (dVar.f1310b.f(f5)) {
                        dVar.k(childAt);
                    }
                    h0Var.i(f5);
                }
            } finally {
                dVar.f1312d = 0;
                dVar.f1313e = null;
            }
        }
    }

    public abstract int m(e1 e1Var);

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a9, code lost:
        if (r10 == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.E()
            int r1 = r8.G()
            int r2 = r8.f1509n
            int r3 = r8.F()
            int r2 = r2 - r3
            int r3 = r8.o
            int r4 = r8.D()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            int r3 = r8.C()
            r7 = 1
            if (r3 != r7) goto L5c
            if (r2 == 0) goto L57
            goto L64
        L57:
            int r2 = java.lang.Math.max(r6, r10)
            goto L64
        L5c:
            if (r6 == 0) goto L5f
            goto L63
        L5f:
            int r6 = java.lang.Math.min(r4, r2)
        L63:
            r2 = r6
        L64:
            if (r1 == 0) goto L67
            goto L6b
        L67:
            int r1 = java.lang.Math.min(r5, r11)
        L6b:
            if (r13 == 0) goto Lab
            android.view.View r10 = r9.getFocusedChild()
            if (r10 != 0) goto L74
            goto La8
        L74:
            int r11 = r8.E()
            int r13 = r8.G()
            int r3 = r8.f1509n
            int r4 = r8.F()
            int r3 = r3 - r4
            int r4 = r8.o
            int r5 = r8.D()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.f1497b
            android.graphics.Rect r5 = r5.f1237p
            r8.y(r5, r10)
            int r10 = r5.left
            int r10 = r10 - r2
            if (r10 >= r3) goto La8
            int r10 = r5.right
            int r10 = r10 - r2
            if (r10 <= r11) goto La8
            int r10 = r5.top
            int r10 = r10 - r1
            if (r10 >= r4) goto La8
            int r10 = r5.bottom
            int r10 = r10 - r1
            if (r10 > r13) goto La6
            goto La8
        La6:
            r10 = r7
            goto La9
        La8:
            r10 = r0
        La9:
            if (r10 == 0) goto Lb0
        Lab:
            if (r2 != 0) goto Lb1
            if (r1 == 0) goto Lb0
            goto Lb1
        Lb0:
            return r0
        Lb1:
            if (r12 == 0) goto Lb7
            r9.scrollBy(r2, r1)
            goto Lba
        Lb7:
            r9.h0(r2, r1, r0)
        Lba:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.r0.m0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public abstract int n(e1 e1Var);

    public final void n0() {
        RecyclerView recyclerView = this.f1497b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public abstract int o(e1 e1Var);

    public abstract int o0(int i5, y0 y0Var, e1 e1Var);

    public final void p(y0 y0Var) {
        int v5 = v();
        while (true) {
            v5--;
            if (v5 < 0) {
                return;
            }
            View u3 = u(v5);
            i1 L = RecyclerView.L(u3);
            if (L.o()) {
                if (RecyclerView.G0) {
                    Log.d("RecyclerView", "ignoring view " + L);
                }
            } else if (!L.g() || L.i() || this.f1497b.f1243s.f1373h) {
                u(v5);
                this.f1496a.c(v5);
                y0Var.k(u3);
                this.f1497b.f1232m.l(L);
            } else {
                l0(v5);
                y0Var.j(L);
            }
        }
    }

    public abstract void p0(int i5);

    public View q(int i5) {
        int v5 = v();
        for (int i6 = 0; i6 < v5; i6++) {
            View u3 = u(i6);
            i1 L = RecyclerView.L(u3);
            if (L != null && L.c() == i5 && !L.o() && (this.f1497b.f1233m0.f1328g || !L.i())) {
                return u3;
            }
        }
        return null;
    }

    public abstract int q0(int i5, y0 y0Var, e1 e1Var);

    public abstract s0 r();

    public final void r0(RecyclerView recyclerView) {
        s0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public s0 s(Context context, AttributeSet attributeSet) {
        return new s0(context, attributeSet);
    }

    public final void s0(int i5, int i6) {
        this.f1509n = View.MeasureSpec.getSize(i5);
        int mode = View.MeasureSpec.getMode(i5);
        this.f1507l = mode;
        if (mode == 0 && !RecyclerView.J0) {
            this.f1509n = 0;
        }
        this.o = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i6);
        this.f1508m = mode2;
        if (mode2 != 0 || RecyclerView.J0) {
            return;
        }
        this.o = 0;
    }

    public s0 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof s0 ? new s0((s0) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new s0((ViewGroup.MarginLayoutParams) layoutParams) : new s0(layoutParams);
    }

    public void t0(Rect rect, int i5, int i6) {
        int F = F() + E() + rect.width();
        int D = D() + G() + rect.height();
        RecyclerView recyclerView = this.f1497b;
        WeakHashMap weakHashMap = h0.z0.f3233a;
        this.f1497b.setMeasuredDimension(g(i5, F, recyclerView.getMinimumWidth()), g(i6, D, this.f1497b.getMinimumHeight()));
    }

    public final View u(int i5) {
        d dVar = this.f1496a;
        if (dVar != null) {
            return dVar.d(i5);
        }
        return null;
    }

    public final void u0(int i5, int i6) {
        int v5 = v();
        if (v5 == 0) {
            this.f1497b.q(i5, i6);
            return;
        }
        int i7 = Integer.MIN_VALUE;
        int i8 = Integer.MAX_VALUE;
        int i9 = Integer.MIN_VALUE;
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < v5; i11++) {
            View u3 = u(i11);
            Rect rect = this.f1497b.f1237p;
            y(rect, u3);
            int i12 = rect.left;
            if (i12 < i10) {
                i10 = i12;
            }
            int i13 = rect.right;
            if (i13 > i7) {
                i7 = i13;
            }
            int i14 = rect.top;
            if (i14 < i8) {
                i8 = i14;
            }
            int i15 = rect.bottom;
            if (i15 > i9) {
                i9 = i15;
            }
        }
        this.f1497b.f1237p.set(i10, i8, i7, i9);
        t0(this.f1497b.f1237p, i5, i6);
    }

    public final int v() {
        d dVar = this.f1496a;
        if (dVar != null) {
            return dVar.e();
        }
        return 0;
    }

    public final void v0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f1497b = null;
            this.f1496a = null;
            this.f1509n = 0;
            this.o = 0;
        } else {
            this.f1497b = recyclerView;
            this.f1496a = recyclerView.f1230l;
            this.f1509n = recyclerView.getWidth();
            this.o = recyclerView.getHeight();
        }
        this.f1507l = 1073741824;
        this.f1508m = 1073741824;
    }

    public final boolean w0(View view, int i5, int i6, s0 s0Var) {
        return (!view.isLayoutRequested() && this.f1503h && M(view.getWidth(), i5, ((ViewGroup.MarginLayoutParams) s0Var).width) && M(view.getHeight(), i6, ((ViewGroup.MarginLayoutParams) s0Var).height)) ? false : true;
    }

    public int x(y0 y0Var, e1 e1Var) {
        return -1;
    }

    public boolean x0() {
        return false;
    }

    public void y(Rect rect, View view) {
        RecyclerView.M(rect, view);
    }

    public final boolean y0(View view, int i5, int i6, s0 s0Var) {
        return (this.f1503h && M(view.getMeasuredWidth(), i5, ((ViewGroup.MarginLayoutParams) s0Var).width) && M(view.getMeasuredHeight(), i6, ((ViewGroup.MarginLayoutParams) s0Var).height)) ? false : true;
    }

    public abstract void z0(RecyclerView recyclerView, int i5);
}
