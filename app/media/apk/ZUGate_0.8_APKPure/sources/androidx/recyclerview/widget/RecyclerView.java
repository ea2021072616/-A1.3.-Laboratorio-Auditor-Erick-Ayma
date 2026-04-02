package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.github.appintro.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup {
    public static boolean F0 = false;
    public static boolean G0 = false;
    public static final int[] H0 = {16843830};
    public static final float I0 = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final boolean J0 = true;
    public static final boolean K0 = true;
    public static final boolean L0 = true;
    public static final Class[] M0;
    public static final q0.c N0;
    public static final f1 O0;
    public boolean A;
    public final g0 A0;
    public int B;
    public boolean B0;
    public boolean C;
    public int C0;
    public boolean D;
    public int D0;
    public boolean E;
    public final h0 E0;
    public int F;
    public boolean G;
    public final AccessibilityManager H;
    public boolean I;
    public boolean J;
    public int K;
    public int L;
    public l0 M;
    public EdgeEffect N;
    public EdgeEffect O;
    public EdgeEffect P;
    public EdgeEffect Q;
    public n0 R;
    public int S;
    public int T;
    public VelocityTracker U;
    public int V;
    public int W;

    /* renamed from: a0  reason: collision with root package name */
    public int f1214a0;

    /* renamed from: b0  reason: collision with root package name */
    public int f1215b0;

    /* renamed from: c0  reason: collision with root package name */
    public int f1216c0;

    /* renamed from: d0  reason: collision with root package name */
    public t0 f1217d0;

    /* renamed from: e0  reason: collision with root package name */
    public final int f1218e0;

    /* renamed from: f0  reason: collision with root package name */
    public final int f1219f0;

    /* renamed from: g  reason: collision with root package name */
    public final float f1220g;

    /* renamed from: g0  reason: collision with root package name */
    public final float f1221g0;

    /* renamed from: h  reason: collision with root package name */
    public final a1 f1222h;

    /* renamed from: h0  reason: collision with root package name */
    public final float f1223h0;

    /* renamed from: i  reason: collision with root package name */
    public final y0 f1224i;

    /* renamed from: i0  reason: collision with root package name */
    public boolean f1225i0;

    /* renamed from: j  reason: collision with root package name */
    public b1 f1226j;

    /* renamed from: j0  reason: collision with root package name */
    public final h1 f1227j0;

    /* renamed from: k  reason: collision with root package name */
    public b f1228k;

    /* renamed from: k0  reason: collision with root package name */
    public t f1229k0;

    /* renamed from: l  reason: collision with root package name */
    public d f1230l;

    /* renamed from: l0  reason: collision with root package name */
    public final r f1231l0;

    /* renamed from: m  reason: collision with root package name */
    public final u1 f1232m;

    /* renamed from: m0  reason: collision with root package name */
    public final e1 f1233m0;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1234n;

    /* renamed from: n0  reason: collision with root package name */
    public v0 f1235n0;
    public final g0 o;

    /* renamed from: o0  reason: collision with root package name */
    public ArrayList f1236o0;

    /* renamed from: p  reason: collision with root package name */
    public final Rect f1237p;

    /* renamed from: p0  reason: collision with root package name */
    public boolean f1238p0;

    /* renamed from: q  reason: collision with root package name */
    public final Rect f1239q;

    /* renamed from: q0  reason: collision with root package name */
    public boolean f1240q0;

    /* renamed from: r  reason: collision with root package name */
    public final RectF f1241r;

    /* renamed from: r0  reason: collision with root package name */
    public final h0 f1242r0;

    /* renamed from: s  reason: collision with root package name */
    public i0 f1243s;

    /* renamed from: s0  reason: collision with root package name */
    public boolean f1244s0;

    /* renamed from: t  reason: collision with root package name */
    public r0 f1245t;

    /* renamed from: t0  reason: collision with root package name */
    public k1 f1246t0;

    /* renamed from: u  reason: collision with root package name */
    public final ArrayList f1247u;

    /* renamed from: u0  reason: collision with root package name */
    public final int[] f1248u0;

    /* renamed from: v  reason: collision with root package name */
    public final ArrayList f1249v;

    /* renamed from: v0  reason: collision with root package name */
    public h0.t f1250v0;

    /* renamed from: w  reason: collision with root package name */
    public final ArrayList f1251w;

    /* renamed from: w0  reason: collision with root package name */
    public final int[] f1252w0;

    /* renamed from: x  reason: collision with root package name */
    public u0 f1253x;

    /* renamed from: x0  reason: collision with root package name */
    public final int[] f1254x0;

    /* renamed from: y  reason: collision with root package name */
    public boolean f1255y;

    /* renamed from: y0  reason: collision with root package name */
    public final int[] f1256y0;

    /* renamed from: z  reason: collision with root package name */
    public boolean f1257z;

    /* renamed from: z0  reason: collision with root package name */
    public final ArrayList f1258z0;

    static {
        Class cls = Integer.TYPE;
        M0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        N0 = new q0.c(1);
        O0 = new f1();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    public static RecyclerView G(View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof RecyclerView) {
                return (RecyclerView) view;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                RecyclerView G = G(viewGroup.getChildAt(i5));
                if (G != null) {
                    return G;
                }
            }
            return null;
        }
        return null;
    }

    public static i1 L(View view) {
        if (view == null) {
            return null;
        }
        return ((s0) view.getLayoutParams()).f1520a;
    }

    public static void M(Rect rect, View view) {
        s0 s0Var = (s0) view.getLayoutParams();
        Rect rect2 = s0Var.f1521b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) s0Var).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) s0Var).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) s0Var).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) s0Var).bottomMargin);
    }

    private int a0(int i5, float f5) {
        float width = f5 / getWidth();
        float height = i5 / getHeight();
        EdgeEffect edgeEffect = this.O;
        float f6 = 0.0f;
        if (edgeEffect == null || com.google.android.gms.internal.play_billing.i0.y(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.Q;
            if (edgeEffect2 != null && com.google.android.gms.internal.play_billing.i0.y(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.Q.onRelease();
                } else {
                    float J = com.google.android.gms.internal.play_billing.i0.J(this.Q, height, 1.0f - width);
                    if (com.google.android.gms.internal.play_billing.i0.y(this.Q) == 0.0f) {
                        this.Q.onRelease();
                    }
                    f6 = J;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.O.onRelease();
            } else {
                float f7 = -com.google.android.gms.internal.play_billing.i0.J(this.O, -height, width);
                if (com.google.android.gms.internal.play_billing.i0.y(this.O) == 0.0f) {
                    this.O.onRelease();
                }
                f6 = f7;
            }
            invalidate();
        }
        return Math.round(f6 * getHeight());
    }

    private h0.t getScrollingChildHelper() {
        if (this.f1250v0 == null) {
            this.f1250v0 = new h0.t(this);
        }
        return this.f1250v0;
    }

    public static void l(i1 i1Var) {
        WeakReference weakReference = i1Var.f1377b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == i1Var.f1376a) {
                    return;
                }
                ViewParent parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            i1Var.f1377b = null;
        }
    }

    public static int o(int i5, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i6) {
        if (i5 > 0 && edgeEffect != null && com.google.android.gms.internal.play_billing.i0.y(edgeEffect) != 0.0f) {
            int round = Math.round(com.google.android.gms.internal.play_billing.i0.J(edgeEffect, ((-i5) * 4.0f) / i6, 0.5f) * ((-i6) / 4.0f));
            if (round != i5) {
                edgeEffect.finish();
            }
            return i5 - round;
        } else if (i5 >= 0 || edgeEffect2 == null || com.google.android.gms.internal.play_billing.i0.y(edgeEffect2) == 0.0f) {
            return i5;
        } else {
            float f5 = i6;
            int round2 = Math.round(com.google.android.gms.internal.play_billing.i0.J(edgeEffect2, (i5 * 4.0f) / f5, 0.5f) * (f5 / 4.0f));
            if (round2 != i5) {
                edgeEffect2.finish();
            }
            return i5 - round2;
        }
    }

    public static void setDebugAssertionsEnabled(boolean z4) {
        F0 = z4;
    }

    public static void setVerboseLoggingEnabled(boolean z4) {
        G0 = z4;
    }

    public final void A() {
        if (this.O != null) {
            return;
        }
        ((f1) this.M).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.O = edgeEffect;
        if (this.f1234n) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String B() {
        return " " + super.toString() + ", adapter:" + this.f1243s + ", layout:" + this.f1245t + ", context:" + getContext();
    }

    public final void C(e1 e1Var) {
        if (getScrollState() != 2) {
            e1Var.getClass();
            return;
        }
        OverScroller overScroller = this.f1227j0.f1361d;
        overScroller.getFinalX();
        overScroller.getCurrX();
        e1Var.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View D(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.D(android.view.View):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
        if (r7 == 2) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean E(android.view.MotionEvent r13) {
        /*
            r12 = this;
            int r0 = r13.getAction()
            java.util.ArrayList r1 = r12.f1251w
            int r2 = r1.size()
            r3 = 0
            r4 = r3
        Lc:
            if (r4 >= r2) goto L6c
            java.lang.Object r5 = r1.get(r4)
            androidx.recyclerview.widget.u0 r5 = (androidx.recyclerview.widget.u0) r5
            r6 = r5
            androidx.recyclerview.widget.q r6 = (androidx.recyclerview.widget.q) r6
            int r7 = r6.f1477v
            r8 = 1
            r9 = 2
            if (r7 != r8) goto L5c
            float r7 = r13.getX()
            float r10 = r13.getY()
            boolean r7 = r6.e(r7, r10)
            float r10 = r13.getX()
            float r11 = r13.getY()
            boolean r10 = r6.d(r10, r11)
            int r11 = r13.getAction()
            if (r11 != 0) goto L60
            if (r7 != 0) goto L3f
            if (r10 == 0) goto L60
        L3f:
            if (r10 == 0) goto L4c
            r6.f1478w = r8
            float r7 = r13.getX()
            int r7 = (int) r7
            float r7 = (float) r7
            r6.f1471p = r7
            goto L58
        L4c:
            if (r7 == 0) goto L58
            r6.f1478w = r9
            float r7 = r13.getY()
            int r7 = (int) r7
            float r7 = (float) r7
            r6.f1469m = r7
        L58:
            r6.f(r9)
            goto L5e
        L5c:
            if (r7 != r9) goto L60
        L5e:
            r6 = r8
            goto L61
        L60:
            r6 = r3
        L61:
            if (r6 == 0) goto L69
            r6 = 3
            if (r0 == r6) goto L69
            r12.f1253x = r5
            return r8
        L69:
            int r4 = r4 + 1
            goto Lc
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.E(android.view.MotionEvent):boolean");
    }

    public final void F(int[] iArr) {
        int e5 = this.f1230l.e();
        if (e5 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i5 = Integer.MAX_VALUE;
        int i6 = Integer.MIN_VALUE;
        for (int i7 = 0; i7 < e5; i7++) {
            i1 L = L(this.f1230l.d(i7));
            if (!L.o()) {
                int c5 = L.c();
                if (c5 < i5) {
                    i5 = c5;
                }
                if (c5 > i6) {
                    i6 = c5;
                }
            }
        }
        iArr[0] = i5;
        iArr[1] = i6;
    }

    public final i1 H(int i5) {
        i1 i1Var = null;
        if (this.I) {
            return null;
        }
        int h5 = this.f1230l.h();
        for (int i6 = 0; i6 < h5; i6++) {
            i1 L = L(this.f1230l.g(i6));
            if (L != null && !L.i() && I(L) == i5) {
                if (!this.f1230l.j(L.f1376a)) {
                    return L;
                }
                i1Var = L;
            }
        }
        return i1Var;
    }

    public final int I(i1 i1Var) {
        if (!((i1Var.f1385j & 524) != 0) && i1Var.f()) {
            b bVar = this.f1228k;
            int i5 = i1Var.f1378c;
            ArrayList arrayList = bVar.f1291b;
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                a aVar = (a) arrayList.get(i6);
                int i7 = aVar.f1270a;
                if (i7 != 1) {
                    if (i7 == 2) {
                        int i8 = aVar.f1271b;
                        if (i8 <= i5) {
                            int i9 = aVar.f1273d;
                            if (i8 + i9 <= i5) {
                                i5 -= i9;
                            }
                        } else {
                            continue;
                        }
                    } else if (i7 == 8) {
                        int i10 = aVar.f1271b;
                        if (i10 == i5) {
                            i5 = aVar.f1273d;
                        } else {
                            if (i10 < i5) {
                                i5--;
                            }
                            if (aVar.f1273d <= i5) {
                                i5++;
                            }
                        }
                    }
                } else if (aVar.f1271b <= i5) {
                    i5 += aVar.f1273d;
                }
            }
            return i5;
        }
        return -1;
    }

    public final long J(i1 i1Var) {
        return this.f1243s.f1373h ? i1Var.f1380e : i1Var.f1378c;
    }

    public final i1 K(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return L(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final Rect N(View view) {
        s0 s0Var = (s0) view.getLayoutParams();
        boolean z4 = s0Var.f1522c;
        Rect rect = s0Var.f1521b;
        if (z4) {
            if (this.f1233m0.f1328g && (s0Var.b() || s0Var.f1520a.g())) {
                return rect;
            }
            rect.set(0, 0, 0, 0);
            ArrayList arrayList = this.f1249v;
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                Rect rect2 = this.f1237p;
                rect2.set(0, 0, 0, 0);
                ((o0) arrayList.get(i5)).a(rect2, view, this);
                rect.left += rect2.left;
                rect.top += rect2.top;
                rect.right += rect2.right;
                rect.bottom += rect2.bottom;
            }
            s0Var.f1522c = false;
            return rect;
        }
        return rect;
    }

    public final boolean O() {
        return this.K > 0;
    }

    public final void P(int i5) {
        if (this.f1245t == null) {
            return;
        }
        setScrollState(2);
        this.f1245t.p0(i5);
        awakenScrollBars();
    }

    public final void Q() {
        int h5 = this.f1230l.h();
        for (int i5 = 0; i5 < h5; i5++) {
            ((s0) this.f1230l.g(i5).getLayoutParams()).f1522c = true;
        }
        ArrayList arrayList = this.f1224i.f1578c;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            s0 s0Var = (s0) ((i1) arrayList.get(i6)).f1376a.getLayoutParams();
            if (s0Var != null) {
                s0Var.f1522c = true;
            }
        }
    }

    public final void R(int i5, boolean z4, int i6) {
        int i7 = i5 + i6;
        int h5 = this.f1230l.h();
        for (int i8 = 0; i8 < h5; i8++) {
            i1 L = L(this.f1230l.g(i8));
            if (L != null && !L.o()) {
                int i9 = L.f1378c;
                e1 e1Var = this.f1233m0;
                if (i9 >= i7) {
                    if (G0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i8 + " holder " + L + " now at position " + (L.f1378c - i6));
                    }
                    L.l(-i6, z4);
                    e1Var.f1327f = true;
                } else if (i9 >= i5) {
                    if (G0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i8 + " holder " + L + " now REMOVED");
                    }
                    L.b(8);
                    L.l(-i6, z4);
                    L.f1378c = i5 - 1;
                    e1Var.f1327f = true;
                }
            }
        }
        y0 y0Var = this.f1224i;
        ArrayList arrayList = y0Var.f1578c;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                requestLayout();
                return;
            }
            i1 i1Var = (i1) arrayList.get(size);
            if (i1Var != null) {
                int i10 = i1Var.f1378c;
                if (i10 >= i7) {
                    if (G0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + size + " holder " + i1Var + " now at position " + (i1Var.f1378c - i6));
                    }
                    i1Var.l(-i6, z4);
                } else if (i10 >= i5) {
                    i1Var.b(8);
                    y0Var.h(size);
                }
            }
        }
    }

    public final void S() {
        this.K++;
    }

    public final void T(boolean z4) {
        int i5;
        boolean z5 = true;
        int i6 = this.K - 1;
        this.K = i6;
        if (i6 < 1) {
            if (F0 && i6 < 0) {
                throw new IllegalStateException(androidx.appcompat.widget.b0.e(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
            }
            this.K = 0;
            if (z4) {
                int i7 = this.F;
                this.F = 0;
                if (i7 != 0) {
                    AccessibilityManager accessibilityManager = this.H;
                    if ((accessibilityManager == null || !accessibilityManager.isEnabled()) ? false : false) {
                        AccessibilityEvent obtain = AccessibilityEvent.obtain();
                        obtain.setEventType(2048);
                        obtain.setContentChangeTypes(i7);
                        sendAccessibilityEventUnchecked(obtain);
                    }
                }
                ArrayList arrayList = this.f1258z0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    i1 i1Var = (i1) arrayList.get(size);
                    if (i1Var.f1376a.getParent() == this && !i1Var.o() && (i5 = i1Var.f1391q) != -1) {
                        WeakHashMap weakHashMap = h0.z0.f3233a;
                        i1Var.f1376a.setImportantForAccessibility(i5);
                        i1Var.f1391q = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void U(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.T) {
            int i5 = actionIndex == 0 ? 1 : 0;
            this.T = motionEvent.getPointerId(i5);
            int x5 = (int) (motionEvent.getX(i5) + 0.5f);
            this.f1214a0 = x5;
            this.V = x5;
            int y5 = (int) (motionEvent.getY(i5) + 0.5f);
            this.f1215b0 = y5;
            this.W = y5;
        }
    }

    public final void V() {
        if (this.f1244s0 || !this.f1255y) {
            return;
        }
        WeakHashMap weakHashMap = h0.z0.f3233a;
        postOnAnimation(this.A0);
        this.f1244s0 = true;
    }

    public final void W() {
        boolean z4;
        boolean z5 = false;
        if (this.I) {
            b bVar = this.f1228k;
            bVar.k(bVar.f1291b);
            bVar.k(bVar.f1292c);
            bVar.f1295f = 0;
            if (this.J) {
                this.f1245t.Z();
            }
        }
        if (this.R != null && this.f1245t.B0()) {
            this.f1228k.j();
        } else {
            this.f1228k.c();
        }
        boolean z6 = this.f1238p0 || this.f1240q0;
        boolean z7 = this.A && this.R != null && ((z4 = this.I) || z6 || this.f1245t.f1501f) && (!z4 || this.f1243s.f1373h);
        e1 e1Var = this.f1233m0;
        e1Var.f1331j = z7;
        if (z7 && z6 && !this.I) {
            if (this.R != null && this.f1245t.B0()) {
                z5 = true;
            }
        }
        e1Var.f1332k = z5;
    }

    public final void X(boolean z4) {
        this.J = z4 | this.J;
        this.I = true;
        int h5 = this.f1230l.h();
        for (int i5 = 0; i5 < h5; i5++) {
            i1 L = L(this.f1230l.g(i5));
            if (L != null && !L.o()) {
                L.b(6);
            }
        }
        Q();
        y0 y0Var = this.f1224i;
        ArrayList arrayList = y0Var.f1578c;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            i1 i1Var = (i1) arrayList.get(i6);
            if (i1Var != null) {
                i1Var.b(6);
                i1Var.a(null);
            }
        }
        i0 i0Var = y0Var.f1583h.f1243s;
        if (i0Var == null || !i0Var.f1373h) {
            y0Var.g();
        }
    }

    public final void Y(i1 i1Var, m0 m0Var) {
        int i5 = (i1Var.f1385j & (-8193)) | 0;
        i1Var.f1385j = i5;
        boolean z4 = this.f1233m0.f1329h;
        u1 u1Var = this.f1232m;
        if (z4) {
            if (((i5 & 2) != 0) && !i1Var.i() && !i1Var.o()) {
                ((l.d) u1Var.f1538c).e(J(i1Var), i1Var);
            }
        }
        u1Var.c(i1Var, m0Var);
    }

    public final int Z(int i5, float f5) {
        float height = f5 / getHeight();
        float width = i5 / getWidth();
        EdgeEffect edgeEffect = this.N;
        float f6 = 0.0f;
        if (edgeEffect == null || com.google.android.gms.internal.play_billing.i0.y(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.P;
            if (edgeEffect2 != null && com.google.android.gms.internal.play_billing.i0.y(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.P.onRelease();
                } else {
                    float J = com.google.android.gms.internal.play_billing.i0.J(this.P, width, height);
                    if (com.google.android.gms.internal.play_billing.i0.y(this.P) == 0.0f) {
                        this.P.onRelease();
                    }
                    f6 = J;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.N.onRelease();
            } else {
                float f7 = -com.google.android.gms.internal.play_billing.i0.J(this.N, -width, 1.0f - height);
                if (com.google.android.gms.internal.play_billing.i0.y(this.N) == 0.0f) {
                    this.N.onRelease();
                }
                f6 = f7;
            }
            invalidate();
        }
        return Math.round(f6 * getWidth());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i5, int i6) {
        r0 r0Var = this.f1245t;
        if (r0Var != null) {
            r0Var.getClass();
        }
        super.addFocusables(arrayList, i5, i6);
    }

    public final void b0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f1237p;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof s0) {
            s0 s0Var = (s0) layoutParams;
            if (!s0Var.f1522c) {
                int i5 = rect.left;
                Rect rect2 = s0Var.f1521b;
                rect.left = i5 - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.f1245t.m0(this, view, this.f1237p, !this.A, view2 == null);
    }

    public final void c0() {
        VelocityTracker velocityTracker = this.U;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z4 = false;
        k0(0);
        EdgeEffect edgeEffect = this.N;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z4 = this.N.isFinished();
        }
        EdgeEffect edgeEffect2 = this.O;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z4 |= this.O.isFinished();
        }
        EdgeEffect edgeEffect3 = this.P;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z4 |= this.P.isFinished();
        }
        EdgeEffect edgeEffect4 = this.Q;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z4 |= this.Q.isFinished();
        }
        if (z4) {
            WeakHashMap weakHashMap = h0.z0.f3233a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof s0) && this.f1245t.f((s0) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        r0 r0Var = this.f1245t;
        if (r0Var != null && r0Var.d()) {
            return this.f1245t.j(this.f1233m0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        r0 r0Var = this.f1245t;
        if (r0Var != null && r0Var.d()) {
            return this.f1245t.k(this.f1233m0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        r0 r0Var = this.f1245t;
        if (r0Var != null && r0Var.d()) {
            return this.f1245t.l(this.f1233m0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        r0 r0Var = this.f1245t;
        if (r0Var != null && r0Var.e()) {
            return this.f1245t.m(this.f1233m0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        r0 r0Var = this.f1245t;
        if (r0Var != null && r0Var.e()) {
            return this.f1245t.n(this.f1233m0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        r0 r0Var = this.f1245t;
        if (r0Var != null && r0Var.e()) {
            return this.f1245t.o(this.f1233m0);
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d0(int r19, int r20, android.view.MotionEvent r21, int r22) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.d0(int, int, android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f5, float f6, boolean z4) {
        return getScrollingChildHelper().a(f5, f6, z4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f5, float f6) {
        return getScrollingChildHelper().b(f5, f6);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i5, int i6, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i5, i6, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i5, int i6, int i7, int i8, int[] iArr) {
        return getScrollingChildHelper().e(i5, i6, i7, i8, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z4;
        super.draw(canvas);
        ArrayList arrayList = this.f1249v;
        int size = arrayList.size();
        boolean z5 = false;
        for (int i5 = 0; i5 < size; i5++) {
            ((o0) arrayList.get(i5)).c(canvas, this);
        }
        EdgeEffect edgeEffect = this.N;
        boolean z6 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z4 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f1234n ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.N;
            z4 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.O;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f1234n) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.O;
            z4 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.P;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f1234n ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.P;
            z4 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.Q;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f1234n) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.Q;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z5 = true;
            }
            z4 |= z5;
            canvas.restoreToCount(save4);
        }
        if (z4 || this.R == null || arrayList.size() <= 0 || !this.R.f()) {
            z6 = z4;
        }
        if (z6) {
            WeakHashMap weakHashMap = h0.z0.f3233a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j5) {
        return super.drawChild(canvas, view, j5);
    }

    public final void e0(int i5, int i6, int[] iArr) {
        i1 i1Var;
        i0();
        S();
        int i7 = d0.j.f2506a;
        Trace.beginSection("RV Scroll");
        e1 e1Var = this.f1233m0;
        C(e1Var);
        y0 y0Var = this.f1224i;
        int o02 = i5 != 0 ? this.f1245t.o0(i5, y0Var, e1Var) : 0;
        int q02 = i6 != 0 ? this.f1245t.q0(i6, y0Var, e1Var) : 0;
        Trace.endSection();
        int e5 = this.f1230l.e();
        for (int i8 = 0; i8 < e5; i8++) {
            View d5 = this.f1230l.d(i8);
            i1 K = K(d5);
            if (K != null && (i1Var = K.f1384i) != null) {
                int left = d5.getLeft();
                int top = d5.getTop();
                View view = i1Var.f1376a;
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        T(true);
        j0(false);
        if (iArr != null) {
            iArr[0] = o02;
            iArr[1] = q02;
        }
    }

    public final void f0(int i5) {
        a0 a0Var;
        if (this.D) {
            return;
        }
        setScrollState(0);
        h1 h1Var = this.f1227j0;
        h1Var.f1365h.removeCallbacks(h1Var);
        h1Var.f1361d.abortAnimation();
        r0 r0Var = this.f1245t;
        if (r0Var != null && (a0Var = r0Var.f1500e) != null) {
            a0Var.i();
        }
        r0 r0Var2 = this.f1245t;
        if (r0Var2 == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        r0Var2.p0(i5);
        awakenScrollBars();
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x015a, code lost:
        if (r4 > 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0171, code lost:
        if (r3 > 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0174, code lost:
        if (r4 < 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0177, code lost:
        if (r3 < 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x017f, code lost:
        if ((r3 * r2) <= 0) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0187, code lost:
        if ((r3 * r2) >= 0) goto L120;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0073  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r14, int r15) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final boolean g0(EdgeEffect edgeEffect, int i5, int i6) {
        if (i5 > 0) {
            return true;
        }
        float y5 = com.google.android.gms.internal.play_billing.i0.y(edgeEffect) * i6;
        float f5 = this.f1220g * 0.015f;
        double log = Math.log((Math.abs(-i5) * 0.35f) / f5);
        double d5 = I0;
        return ((float) (Math.exp((d5 / (d5 - 1.0d)) * log) * ((double) f5))) < y5;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        r0 r0Var = this.f1245t;
        if (r0Var != null) {
            return r0Var.r();
        }
        throw new IllegalStateException(androidx.appcompat.widget.b0.e(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        r0 r0Var = this.f1245t;
        if (r0Var != null) {
            return r0Var.s(getContext(), attributeSet);
        }
        throw new IllegalStateException(androidx.appcompat.widget.b0.e(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public i0 getAdapter() {
        return this.f1243s;
    }

    @Override // android.view.View
    public int getBaseline() {
        r0 r0Var = this.f1245t;
        if (r0Var != null) {
            r0Var.getClass();
            return -1;
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i5, int i6) {
        return super.getChildDrawingOrder(i5, i6);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f1234n;
    }

    public k1 getCompatAccessibilityDelegate() {
        return this.f1246t0;
    }

    public l0 getEdgeEffectFactory() {
        return this.M;
    }

    public n0 getItemAnimator() {
        return this.R;
    }

    public int getItemDecorationCount() {
        return this.f1249v.size();
    }

    public r0 getLayoutManager() {
        return this.f1245t;
    }

    public int getMaxFlingVelocity() {
        return this.f1219f0;
    }

    public int getMinFlingVelocity() {
        return this.f1218e0;
    }

    public long getNanoTime() {
        if (L0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public t0 getOnFlingListener() {
        return this.f1217d0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f1225i0;
    }

    public x0 getRecycledViewPool() {
        return this.f1224i.c();
    }

    public int getScrollState() {
        return this.S;
    }

    public final void h(i1 i1Var) {
        View view = i1Var.f1376a;
        boolean z4 = view.getParent() == this;
        this.f1224i.m(K(view));
        if (i1Var.k()) {
            this.f1230l.b(view, -1, view.getLayoutParams(), true);
        } else if (!z4) {
            this.f1230l.a(view, -1, true);
        } else {
            d dVar = this.f1230l;
            int indexOfChild = dVar.f1309a.f1358a.indexOfChild(view);
            if (indexOfChild >= 0) {
                dVar.f1310b.h(indexOfChild);
                dVar.i(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void h0(int i5, int i6, boolean z4) {
        r0 r0Var = this.f1245t;
        if (r0Var == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.D) {
        } else {
            if (!r0Var.d()) {
                i5 = 0;
            }
            if (!this.f1245t.e()) {
                i6 = 0;
            }
            if (i5 == 0 && i6 == 0) {
                return;
            }
            if (z4) {
                int i7 = i5 != 0 ? 1 : 0;
                if (i6 != 0) {
                    i7 |= 2;
                }
                getScrollingChildHelper().g(i7, 1);
            }
            this.f1227j0.c(i5, i6, Integer.MIN_VALUE, null);
        }
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0) != null;
    }

    public final void i(o0 o0Var) {
        r0 r0Var = this.f1245t;
        if (r0Var != null) {
            r0Var.c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.f1249v;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(o0Var);
        Q();
        requestLayout();
    }

    public final void i0() {
        int i5 = this.B + 1;
        this.B = i5;
        if (i5 != 1 || this.D) {
            return;
        }
        this.C = false;
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.f1255y;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.D;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f3208d;
    }

    public final void j(v0 v0Var) {
        if (this.f1236o0 == null) {
            this.f1236o0 = new ArrayList();
        }
        this.f1236o0.add(v0Var);
    }

    public final void j0(boolean z4) {
        if (this.B < 1) {
            if (F0) {
                throw new IllegalStateException(androidx.appcompat.widget.b0.e(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
            this.B = 1;
        }
        if (!z4 && !this.D) {
            this.C = false;
        }
        if (this.B == 1) {
            if (z4 && this.C && !this.D && this.f1245t != null && this.f1243s != null) {
                r();
            }
            if (!this.D) {
                this.C = false;
            }
        }
        this.B--;
    }

    public final void k(String str) {
        if (O()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(androidx.appcompat.widget.b0.e(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
        } else if (this.L > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(androidx.appcompat.widget.b0.e(this, new StringBuilder(""))));
        }
    }

    public final void k0(int i5) {
        getScrollingChildHelper().h(i5);
    }

    public final void m() {
        int h5 = this.f1230l.h();
        for (int i5 = 0; i5 < h5; i5++) {
            i1 L = L(this.f1230l.g(i5));
            if (!L.o()) {
                L.f1379d = -1;
                L.f1382g = -1;
            }
        }
        y0 y0Var = this.f1224i;
        ArrayList arrayList = y0Var.f1578c;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            i1 i1Var = (i1) arrayList.get(i6);
            i1Var.f1379d = -1;
            i1Var.f1382g = -1;
        }
        ArrayList arrayList2 = y0Var.f1576a;
        int size2 = arrayList2.size();
        for (int i7 = 0; i7 < size2; i7++) {
            i1 i1Var2 = (i1) arrayList2.get(i7);
            i1Var2.f1379d = -1;
            i1Var2.f1382g = -1;
        }
        ArrayList arrayList3 = y0Var.f1577b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i8 = 0; i8 < size3; i8++) {
                i1 i1Var3 = (i1) y0Var.f1577b.get(i8);
                i1Var3.f1379d = -1;
                i1Var3.f1382g = -1;
            }
        }
    }

    public final void n(int i5, int i6) {
        boolean z4;
        EdgeEffect edgeEffect = this.N;
        if (edgeEffect == null || edgeEffect.isFinished() || i5 <= 0) {
            z4 = false;
        } else {
            this.N.onRelease();
            z4 = this.N.isFinished();
        }
        EdgeEffect edgeEffect2 = this.P;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i5 < 0) {
            this.P.onRelease();
            z4 |= this.P.isFinished();
        }
        EdgeEffect edgeEffect3 = this.O;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i6 > 0) {
            this.O.onRelease();
            z4 |= this.O.isFinished();
        }
        EdgeEffect edgeEffect4 = this.Q;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i6 < 0) {
            this.Q.onRelease();
            z4 |= this.Q.isFinished();
        }
        if (z4) {
            WeakHashMap weakHashMap = h0.z0.f3233a;
            postInvalidateOnAnimation();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
        if (r1 >= 30.0f) goto L18;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.K = r0
            r1 = 1
            r5.f1255y = r1
            boolean r2 = r5.A
            if (r2 == 0) goto L15
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L15
            r2 = r1
            goto L16
        L15:
            r2 = r0
        L16:
            r5.A = r2
            androidx.recyclerview.widget.y0 r2 = r5.f1224i
            r2.e()
            androidx.recyclerview.widget.r0 r2 = r5.f1245t
            if (r2 == 0) goto L26
            r2.f1502g = r1
            r2.R(r5)
        L26:
            r5.f1244s0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.L0
            if (r0 == 0) goto L83
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.t.f1524f
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.t r1 = (androidx.recyclerview.widget.t) r1
            r5.f1229k0 = r1
            if (r1 != 0) goto L66
            androidx.recyclerview.widget.t r1 = new androidx.recyclerview.widget.t
            r1.<init>()
            r5.f1229k0 = r1
            java.util.WeakHashMap r1 = h0.z0.f3233a
            android.view.Display r1 = r5.getDisplay()
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L58
            if (r1 == 0) goto L58
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L58
            goto L5a
        L58:
            r1 = 1114636288(0x42700000, float:60.0)
        L5a:
            androidx.recyclerview.widget.t r2 = r5.f1229k0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f1528d = r3
            r0.set(r2)
        L66:
            androidx.recyclerview.widget.t r0 = r5.f1229k0
            r0.getClass()
            boolean r1 = androidx.recyclerview.widget.RecyclerView.F0
            java.util.ArrayList r0 = r0.f1526b
            if (r1 == 0) goto L80
            boolean r1 = r0.contains(r5)
            if (r1 != 0) goto L78
            goto L80
        L78:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "RecyclerView already present in worker list!"
            r0.<init>(r1)
            throw r0
        L80:
            r0.add(r5)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        y0 y0Var;
        t tVar;
        a0 a0Var;
        super.onDetachedFromWindow();
        n0 n0Var = this.R;
        if (n0Var != null) {
            n0Var.e();
        }
        setScrollState(0);
        h1 h1Var = this.f1227j0;
        h1Var.f1365h.removeCallbacks(h1Var);
        h1Var.f1361d.abortAnimation();
        r0 r0Var = this.f1245t;
        if (r0Var != null && (a0Var = r0Var.f1500e) != null) {
            a0Var.i();
        }
        this.f1255y = false;
        r0 r0Var2 = this.f1245t;
        if (r0Var2 != null) {
            r0Var2.f1502g = false;
            r0Var2.S(this);
        }
        this.f1258z0.clear();
        removeCallbacks(this.A0);
        this.f1232m.getClass();
        do {
        } while (t1.f1530d.a() != null);
        int i5 = 0;
        while (true) {
            y0Var = this.f1224i;
            ArrayList arrayList = y0Var.f1578c;
            if (i5 >= arrayList.size()) {
                break;
            }
            b4.j.d(((i1) arrayList.get(i5)).f1376a);
            i5++;
        }
        y0Var.f(y0Var.f1583h.f1243s, false);
        h0.f1 f1Var = new h0.f1(this);
        while (f1Var.hasNext()) {
            View view = (View) f1Var.next();
            o0.a aVar = (o0.a) view.getTag(R.id.pooling_container_listener_holder_tag);
            if (aVar == null) {
                aVar = new o0.a();
                view.setTag(R.id.pooling_container_listener_holder_tag, aVar);
            }
            ArrayList arrayList2 = aVar.f4091a;
            int r5 = e4.e.r(arrayList2);
            if (-1 < r5) {
                androidx.appcompat.widget.b0.n(arrayList2.get(r5));
                throw null;
            }
        }
        if (!L0 || (tVar = this.f1229k0) == null) {
            return;
        }
        boolean remove = tVar.f1526b.remove(this);
        if (F0 && !remove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
        this.f1229k0 = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f1249v;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((o0) arrayList.get(i5)).b(canvas, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r16) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z4;
        boolean z5;
        if (this.D) {
            return false;
        }
        this.f1253x = null;
        if (E(motionEvent)) {
            c0();
            setScrollState(0);
            return true;
        }
        r0 r0Var = this.f1245t;
        if (r0Var == null) {
            return false;
        }
        boolean d5 = r0Var.d();
        boolean e5 = this.f1245t.e();
        if (this.U == null) {
            this.U = VelocityTracker.obtain();
        }
        this.U.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.E) {
                this.E = false;
            }
            this.T = motionEvent.getPointerId(0);
            int x5 = (int) (motionEvent.getX() + 0.5f);
            this.f1214a0 = x5;
            this.V = x5;
            int y5 = (int) (motionEvent.getY() + 0.5f);
            this.f1215b0 = y5;
            this.W = y5;
            EdgeEffect edgeEffect = this.N;
            if (edgeEffect == null || com.google.android.gms.internal.play_billing.i0.y(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
                z4 = false;
            } else {
                com.google.android.gms.internal.play_billing.i0.J(this.N, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
                z4 = true;
            }
            EdgeEffect edgeEffect2 = this.P;
            boolean z6 = z4;
            if (edgeEffect2 != null) {
                z6 = z4;
                if (com.google.android.gms.internal.play_billing.i0.y(edgeEffect2) != 0.0f) {
                    z6 = z4;
                    if (!canScrollHorizontally(1)) {
                        com.google.android.gms.internal.play_billing.i0.J(this.P, 0.0f, motionEvent.getY() / getHeight());
                        z6 = true;
                    }
                }
            }
            EdgeEffect edgeEffect3 = this.O;
            boolean z7 = z6;
            if (edgeEffect3 != null) {
                z7 = z6;
                if (com.google.android.gms.internal.play_billing.i0.y(edgeEffect3) != 0.0f) {
                    z7 = z6;
                    if (!canScrollVertically(-1)) {
                        com.google.android.gms.internal.play_billing.i0.J(this.O, 0.0f, motionEvent.getX() / getWidth());
                        z7 = true;
                    }
                }
            }
            EdgeEffect edgeEffect4 = this.Q;
            boolean z8 = z7;
            if (edgeEffect4 != null) {
                z8 = z7;
                if (com.google.android.gms.internal.play_billing.i0.y(edgeEffect4) != 0.0f) {
                    z8 = z7;
                    if (!canScrollVertically(1)) {
                        com.google.android.gms.internal.play_billing.i0.J(this.Q, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
                        z8 = true;
                    }
                }
            }
            if (z8 || this.S == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                k0(1);
            }
            int[] iArr = this.f1254x0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i5 = d5;
            if (e5) {
                i5 = (d5 ? 1 : 0) | 2;
            }
            getScrollingChildHelper().g(i5, 0);
        } else if (actionMasked == 1) {
            this.U.clear();
            k0(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.T);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.T + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x6 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y6 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.S != 1) {
                int i6 = x6 - this.V;
                int i7 = y6 - this.W;
                if (!d5 || Math.abs(i6) <= this.f1216c0) {
                    z5 = false;
                } else {
                    this.f1214a0 = x6;
                    z5 = true;
                }
                if (e5 && Math.abs(i7) > this.f1216c0) {
                    this.f1215b0 = y6;
                    z5 = true;
                }
                if (z5) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            c0();
            setScrollState(0);
        } else if (actionMasked == 5) {
            this.T = motionEvent.getPointerId(actionIndex);
            int x7 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f1214a0 = x7;
            this.V = x7;
            int y7 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f1215b0 = y7;
            this.W = y7;
        } else if (actionMasked == 6) {
            U(motionEvent);
        }
        return this.S == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int i9 = d0.j.f2506a;
        Trace.beginSection("RV OnLayout");
        r();
        Trace.endSection();
        this.A = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        r0 r0Var = this.f1245t;
        if (r0Var == null) {
            q(i5, i6);
            return;
        }
        boolean L = r0Var.L();
        boolean z4 = false;
        e1 e1Var = this.f1233m0;
        if (L) {
            int mode = View.MeasureSpec.getMode(i5);
            int mode2 = View.MeasureSpec.getMode(i6);
            this.f1245t.f1497b.q(i5, i6);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z4 = true;
            }
            this.B0 = z4;
            if (z4 || this.f1243s == null) {
                return;
            }
            if (e1Var.f1325d == 1) {
                s();
            }
            this.f1245t.s0(i5, i6);
            e1Var.f1330i = true;
            t();
            this.f1245t.u0(i5, i6);
            if (this.f1245t.x0()) {
                this.f1245t.s0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                e1Var.f1330i = true;
                t();
                this.f1245t.u0(i5, i6);
            }
            this.C0 = getMeasuredWidth();
            this.D0 = getMeasuredHeight();
        } else if (this.f1257z) {
            this.f1245t.f1497b.q(i5, i6);
        } else {
            if (this.G) {
                i0();
                S();
                W();
                T(true);
                if (e1Var.f1332k) {
                    e1Var.f1328g = true;
                } else {
                    this.f1228k.c();
                    e1Var.f1328g = false;
                }
                this.G = false;
                j0(false);
            } else if (e1Var.f1332k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            i0 i0Var = this.f1243s;
            if (i0Var != null) {
                e1Var.f1326e = i0Var.a();
            } else {
                e1Var.f1326e = 0;
            }
            i0();
            this.f1245t.f1497b.q(i5, i6);
            j0(false);
            e1Var.f1328g = false;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i5, Rect rect) {
        if (O()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i5, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b1 b1Var = (b1) parcelable;
        this.f1226j = b1Var;
        super.onRestoreInstanceState(b1Var.f4245b);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        b1 b1Var = new b1(super.onSaveInstanceState());
        b1 b1Var2 = this.f1226j;
        if (b1Var2 != null) {
            b1Var.f1297d = b1Var2.f1297d;
        } else {
            r0 r0Var = this.f1245t;
            if (r0Var != null) {
                b1Var.f1297d = r0Var.g0();
            } else {
                b1Var.f1297d = null;
            }
        }
        return b1Var;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        if (i5 == i7 && i6 == i8) {
            return;
        }
        this.Q = null;
        this.O = null;
        this.P = null;
        this.N = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:317:0x0518, code lost:
        if (r8 != false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e2, code lost:
        if (r15 >= 0) goto L307;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0139, code lost:
        if (r12 >= 0) goto L320;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03da A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x058d  */
    /* JADX WARN: Type inference failed for: r4v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r25) {
        /*
            Method dump skipped, instructions count: 1431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        if (!this.A || this.I) {
            int i5 = d0.j.f2506a;
            Trace.beginSection("RV FullInvalidate");
            r();
            Trace.endSection();
        } else if (this.f1228k.g()) {
            b bVar = this.f1228k;
            int i6 = bVar.f1295f;
            boolean z4 = false;
            if ((4 & i6) != 0) {
                if (!((i6 & 11) != 0)) {
                    int i7 = d0.j.f2506a;
                    Trace.beginSection("RV PartialInvalidate");
                    i0();
                    S();
                    this.f1228k.j();
                    if (!this.C) {
                        int e5 = this.f1230l.e();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= e5) {
                                break;
                            }
                            i1 L = L(this.f1230l.d(i8));
                            if (L != null && !L.o()) {
                                if ((L.f1385j & 2) != 0) {
                                    z4 = true;
                                    break;
                                }
                            }
                            i8++;
                        }
                        if (z4) {
                            r();
                        } else {
                            this.f1228k.b();
                        }
                    }
                    j0(true);
                    T(true);
                    Trace.endSection();
                    return;
                }
            }
            if (bVar.g()) {
                int i9 = d0.j.f2506a;
                Trace.beginSection("RV FullInvalidate");
                r();
                Trace.endSection();
            }
        }
    }

    public final void q(int i5, int i6) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = h0.z0.f3233a;
        setMeasuredDimension(r0.g(i5, paddingRight, getMinimumWidth()), r0.g(i6, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:160:0x031f, code lost:
        if (r17.f1230l.j(getFocusedChild()) == false) goto L230;
     */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r() {
        /*
            Method dump skipped, instructions count: 989
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.r():void");
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z4) {
        i1 L = L(view);
        if (L != null) {
            if (L.k()) {
                L.f1385j &= -257;
            } else if (!L.o()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(L);
                throw new IllegalArgumentException(androidx.appcompat.widget.b0.e(this, sb));
            }
        } else if (F0) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            throw new IllegalArgumentException(androidx.appcompat.widget.b0.e(this, sb2));
        }
        view.clearAnimation();
        L(view);
        super.removeDetachedView(view, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        a0 a0Var = this.f1245t.f1500e;
        boolean z4 = true;
        if (!(a0Var != null && a0Var.f1278e) && !O()) {
            z4 = false;
        }
        if (!z4 && view2 != null) {
            b0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        return this.f1245t.m0(this, view, rect, z4, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
        ArrayList arrayList = this.f1251w;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((u0) arrayList.get(i5)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.B != 0 || this.D) {
            this.C = true;
        } else {
            super.requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0074 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instructions count: 513
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.s():void");
    }

    @Override // android.view.View
    public final void scrollBy(int i5, int i6) {
        r0 r0Var = this.f1245t;
        if (r0Var == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.D) {
        } else {
            boolean d5 = r0Var.d();
            boolean e5 = this.f1245t.e();
            if (d5 || e5) {
                if (!d5) {
                    i5 = 0;
                }
                if (!e5) {
                    i6 = 0;
                }
                d0(i5, i6, null, 0);
            }
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i5, int i6) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (O()) {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.F |= contentChangeTypes != 0 ? contentChangeTypes : 0;
            r1 = 1;
        }
        if (r1 != 0) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(k1 k1Var) {
        this.f1246t0 = k1Var;
        h0.z0.n(this, k1Var);
    }

    public void setAdapter(i0 i0Var) {
        setLayoutFrozen(false);
        i0 i0Var2 = this.f1243s;
        a1 a1Var = this.f1222h;
        if (i0Var2 != null) {
            i0Var2.f1372g.unregisterObserver(a1Var);
            this.f1243s.getClass();
        }
        n0 n0Var = this.R;
        if (n0Var != null) {
            n0Var.e();
        }
        r0 r0Var = this.f1245t;
        y0 y0Var = this.f1224i;
        if (r0Var != null) {
            r0Var.i0(y0Var);
            this.f1245t.j0(y0Var);
        }
        y0Var.f1576a.clear();
        y0Var.g();
        b bVar = this.f1228k;
        bVar.k(bVar.f1291b);
        bVar.k(bVar.f1292c);
        bVar.f1295f = 0;
        i0 i0Var3 = this.f1243s;
        this.f1243s = i0Var;
        if (i0Var != null) {
            i0Var.f1372g.registerObserver(a1Var);
        }
        r0 r0Var2 = this.f1245t;
        if (r0Var2 != null) {
            r0Var2.Q();
        }
        i0 i0Var4 = this.f1243s;
        y0Var.f1576a.clear();
        y0Var.g();
        y0Var.f(i0Var3, true);
        x0 c5 = y0Var.c();
        if (i0Var3 != null) {
            c5.f1562b--;
        }
        if (c5.f1562b == 0) {
            int i5 = 0;
            while (true) {
                SparseArray sparseArray = c5.f1561a;
                if (i5 >= sparseArray.size()) {
                    break;
                }
                w0 w0Var = (w0) sparseArray.valueAt(i5);
                Iterator it = w0Var.f1553a.iterator();
                while (it.hasNext()) {
                    b4.j.d(((i1) it.next()).f1376a);
                }
                w0Var.f1553a.clear();
                i5++;
            }
        }
        if (i0Var4 != null) {
            c5.f1562b++;
        }
        y0Var.e();
        this.f1233m0.f1327f = true;
        X(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(k0 k0Var) {
        if (k0Var == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z4) {
        if (z4 != this.f1234n) {
            this.Q = null;
            this.O = null;
            this.P = null;
            this.N = null;
        }
        this.f1234n = z4;
        super.setClipToPadding(z4);
        if (this.A) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(l0 l0Var) {
        l0Var.getClass();
        this.M = l0Var;
        this.Q = null;
        this.O = null;
        this.P = null;
        this.N = null;
    }

    public void setHasFixedSize(boolean z4) {
        this.f1257z = z4;
    }

    public void setItemAnimator(n0 n0Var) {
        n0 n0Var2 = this.R;
        if (n0Var2 != null) {
            n0Var2.e();
            this.R.f1431a = null;
        }
        this.R = n0Var;
        if (n0Var != null) {
            n0Var.f1431a = this.f1242r0;
        }
    }

    public void setItemViewCacheSize(int i5) {
        y0 y0Var = this.f1224i;
        y0Var.f1580e = i5;
        y0Var.n();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z4) {
        suppressLayout(z4);
    }

    public void setLayoutManager(r0 r0Var) {
        h0 h0Var;
        RecyclerView recyclerView;
        a0 a0Var;
        if (r0Var == this.f1245t) {
            return;
        }
        int i5 = 0;
        setScrollState(0);
        h1 h1Var = this.f1227j0;
        h1Var.f1365h.removeCallbacks(h1Var);
        h1Var.f1361d.abortAnimation();
        r0 r0Var2 = this.f1245t;
        if (r0Var2 != null && (a0Var = r0Var2.f1500e) != null) {
            a0Var.i();
        }
        r0 r0Var3 = this.f1245t;
        y0 y0Var = this.f1224i;
        if (r0Var3 != null) {
            n0 n0Var = this.R;
            if (n0Var != null) {
                n0Var.e();
            }
            this.f1245t.i0(y0Var);
            this.f1245t.j0(y0Var);
            y0Var.f1576a.clear();
            y0Var.g();
            if (this.f1255y) {
                r0 r0Var4 = this.f1245t;
                r0Var4.f1502g = false;
                r0Var4.S(this);
            }
            this.f1245t.v0(null);
            this.f1245t = null;
        } else {
            y0Var.f1576a.clear();
            y0Var.g();
        }
        d dVar = this.f1230l;
        dVar.f1310b.g();
        ArrayList arrayList = dVar.f1311c;
        int size = arrayList.size();
        while (true) {
            size--;
            h0Var = dVar.f1309a;
            if (size < 0) {
                break;
            }
            h0Var.getClass();
            i1 L = L((View) arrayList.get(size));
            if (L != null) {
                int i6 = L.f1390p;
                RecyclerView recyclerView2 = h0Var.f1358a;
                if (recyclerView2.O()) {
                    L.f1391q = i6;
                    recyclerView2.f1258z0.add(L);
                } else {
                    WeakHashMap weakHashMap = h0.z0.f3233a;
                    L.f1376a.setImportantForAccessibility(i6);
                }
                L.f1390p = 0;
            }
            arrayList.remove(size);
        }
        int c5 = h0Var.c();
        while (true) {
            recyclerView = h0Var.f1358a;
            if (i5 >= c5) {
                break;
            }
            View childAt = recyclerView.getChildAt(i5);
            recyclerView.getClass();
            L(childAt);
            i0 i0Var = recyclerView.f1243s;
            childAt.clearAnimation();
            i5++;
        }
        recyclerView.removeAllViews();
        this.f1245t = r0Var;
        if (r0Var != null) {
            if (r0Var.f1497b != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(r0Var);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(androidx.appcompat.widget.b0.e(r0Var.f1497b, sb));
            }
            r0Var.v0(this);
            if (this.f1255y) {
                r0 r0Var5 = this.f1245t;
                r0Var5.f1502g = true;
                r0Var5.R(this);
            }
        }
        y0Var.n();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z4) {
        h0.t scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f3208d) {
            WeakHashMap weakHashMap = h0.z0.f3233a;
            h0.o0.z(scrollingChildHelper.f3207c);
        }
        scrollingChildHelper.f3208d = z4;
    }

    public void setOnFlingListener(t0 t0Var) {
        this.f1217d0 = t0Var;
    }

    @Deprecated
    public void setOnScrollListener(v0 v0Var) {
        this.f1235n0 = v0Var;
    }

    public void setPreserveFocusAfterLayout(boolean z4) {
        this.f1225i0 = z4;
    }

    public void setRecycledViewPool(x0 x0Var) {
        x0 x0Var2;
        y0 y0Var = this.f1224i;
        RecyclerView recyclerView = y0Var.f1583h;
        y0Var.f(recyclerView.f1243s, false);
        if (y0Var.f1582g != null) {
            x0Var2.f1562b--;
        }
        y0Var.f1582g = x0Var;
        if (x0Var != null && recyclerView.getAdapter() != null) {
            y0Var.f1582g.f1562b++;
        }
        y0Var.e();
    }

    @Deprecated
    public void setRecyclerListener(z0 z0Var) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setScrollState(int i5) {
        a0 a0Var;
        if (i5 == this.S) {
            return;
        }
        if (G0) {
            Log.d("RecyclerView", "setting scroll state to " + i5 + " from " + this.S, new Exception());
        }
        this.S = i5;
        if (i5 != 2) {
            h1 h1Var = this.f1227j0;
            h1Var.f1365h.removeCallbacks(h1Var);
            h1Var.f1361d.abortAnimation();
            r0 r0Var = this.f1245t;
            if (r0Var != null && (a0Var = r0Var.f1500e) != null) {
                a0Var.i();
            }
        }
        r0 r0Var2 = this.f1245t;
        if (r0Var2 != null) {
            r0Var2.h0(i5);
        }
        v0 v0Var = this.f1235n0;
        if (v0Var != null) {
            v0Var.a(this, i5);
        }
        ArrayList arrayList = this.f1236o0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            ((v0) this.f1236o0.get(size)).a(this, i5);
        }
    }

    public void setScrollingTouchSlop(int i5) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i5 != 0) {
            if (i5 == 1) {
                this.f1216c0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i5 + "; using default value");
        }
        this.f1216c0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(g1 g1Var) {
        this.f1224i.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i5) {
        return getScrollingChildHelper().g(i5, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z4) {
        a0 a0Var;
        if (z4 != this.D) {
            k("Do not suppressLayout in layout or scroll");
            if (!z4) {
                this.D = false;
                if (this.C && this.f1245t != null && this.f1243s != null) {
                    requestLayout();
                }
                this.C = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.D = true;
            this.E = true;
            setScrollState(0);
            h1 h1Var = this.f1227j0;
            h1Var.f1365h.removeCallbacks(h1Var);
            h1Var.f1361d.abortAnimation();
            r0 r0Var = this.f1245t;
            if (r0Var == null || (a0Var = r0Var.f1500e) == null) {
                return;
            }
            a0Var.i();
        }
    }

    public final void t() {
        i0();
        S();
        e1 e1Var = this.f1233m0;
        e1Var.a(6);
        this.f1228k.c();
        e1Var.f1326e = this.f1243s.a();
        e1Var.f1324c = 0;
        if (this.f1226j != null) {
            i0 i0Var = this.f1243s;
            int b5 = n.h.b(i0Var.f1374i);
            if (b5 == 1 ? i0Var.a() > 0 : b5 != 2) {
                Parcelable parcelable = this.f1226j.f1297d;
                if (parcelable != null) {
                    this.f1245t.f0(parcelable);
                }
                this.f1226j = null;
            }
        }
        e1Var.f1328g = false;
        this.f1245t.d0(this.f1224i, e1Var);
        e1Var.f1327f = false;
        e1Var.f1331j = e1Var.f1331j && this.R != null;
        e1Var.f1325d = 4;
        T(true);
        j0(false);
    }

    public final boolean u(int i5, int i6, int[] iArr, int[] iArr2, int i7) {
        return getScrollingChildHelper().c(i5, i6, iArr, iArr2, i7);
    }

    public final void v(int i5, int i6, int i7, int i8, int[] iArr, int i9, int[] iArr2) {
        getScrollingChildHelper().e(i5, i6, i7, i8, iArr, i9, iArr2);
    }

    public final void w(int i5, int i6) {
        this.L++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i5, scrollY - i6);
        v0 v0Var = this.f1235n0;
        if (v0Var != null) {
            v0Var.b(this, i5, i6);
        }
        ArrayList arrayList = this.f1236o0;
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                ((v0) this.f1236o0.get(size)).b(this, i5, i6);
            }
        }
        this.L--;
    }

    public final void x() {
        if (this.Q != null) {
            return;
        }
        ((f1) this.M).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.Q = edgeEffect;
        if (this.f1234n) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void y() {
        if (this.N != null) {
            return;
        }
        ((f1) this.M).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.N = edgeEffect;
        if (this.f1234n) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void z() {
        if (this.P != null) {
            return;
        }
        ((f1) this.M).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.P = edgeEffect;
        if (this.f1234n) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        ClassLoader classLoader;
        Constructor constructor;
        Object[] objArr;
        this.f1222h = new a1(this);
        this.f1224i = new y0(this);
        this.f1232m = new u1(0);
        this.o = new g0(this, 0);
        this.f1237p = new Rect();
        this.f1239q = new Rect();
        this.f1241r = new RectF();
        this.f1247u = new ArrayList();
        this.f1249v = new ArrayList();
        this.f1251w = new ArrayList();
        this.B = 0;
        this.I = false;
        this.J = false;
        this.K = 0;
        this.L = 0;
        this.M = O0;
        this.R = new k();
        this.S = 0;
        this.T = -1;
        this.f1221g0 = Float.MIN_VALUE;
        this.f1223h0 = Float.MIN_VALUE;
        this.f1225i0 = true;
        this.f1227j0 = new h1(this);
        this.f1231l0 = L0 ? new r() : null;
        this.f1233m0 = new e1();
        this.f1238p0 = false;
        this.f1240q0 = false;
        h0 h0Var = new h0(this);
        this.f1242r0 = h0Var;
        this.f1244s0 = false;
        char c5 = 2;
        this.f1248u0 = new int[2];
        this.f1252w0 = new int[2];
        this.f1254x0 = new int[2];
        this.f1256y0 = new int[2];
        this.f1258z0 = new ArrayList();
        this.A0 = new g0(this, 1);
        this.C0 = 0;
        this.D0 = 0;
        this.E0 = new h0(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1216c0 = viewConfiguration.getScaledTouchSlop();
        this.f1221g0 = h0.a1.a(viewConfiguration);
        this.f1223h0 = h0.a1.b(viewConfiguration);
        this.f1218e0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1219f0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1220g = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.R.f1431a = h0Var;
        this.f1228k = new b(new h0(this));
        this.f1230l = new d(new h0(this));
        WeakHashMap weakHashMap = h0.z0.f3233a;
        if (h0.q0.c(this) == 0) {
            h0.q0.m(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.H = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new k1(this));
        int[] iArr = a1.a.f2a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, 0);
        h0.z0.m(this, context, iArr, attributeSet, obtainStyledAttributes, i5);
        String string = obtainStyledAttributes.getString(8);
        if (obtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f1234n = obtainStyledAttributes.getBoolean(1, true);
        int i6 = 4;
        if (obtainStyledAttributes.getBoolean(3, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) obtainStyledAttributes.getDrawable(6);
            Drawable drawable = obtainStyledAttributes.getDrawable(7);
            StateListDrawable stateListDrawable2 = (StateListDrawable) obtainStyledAttributes.getDrawable(4);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(5);
            if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
                Resources resources = getContext().getResources();
                new q(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
                i6 = 4;
                c5 = 2;
            } else {
                throw new IllegalArgumentException(androidx.appcompat.widget.b0.e(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
            }
        }
        obtainStyledAttributes.recycle();
        if (string != null) {
            String trim = string.trim();
            if (!trim.isEmpty()) {
                if (trim.charAt(0) == '.') {
                    trim = context.getPackageName() + trim;
                } else if (!trim.contains(".")) {
                    trim = RecyclerView.class.getPackage().getName() + '.' + trim;
                }
                String str = trim;
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(str, false, classLoader).asSubclass(r0.class);
                    try {
                        constructor = asSubclass.getConstructor(M0);
                        Object[] objArr2 = new Object[i6];
                        objArr2[0] = context;
                        objArr2[1] = attributeSet;
                        objArr2[c5] = Integer.valueOf(i5);
                        objArr2[3] = 0;
                        objArr = objArr2;
                    } catch (NoSuchMethodException e5) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        } catch (NoSuchMethodException e6) {
                            e6.initCause(e5);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e6);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((r0) constructor.newInstance(objArr));
                } catch (ClassCastException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e7);
                } catch (ClassNotFoundException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e8);
                } catch (IllegalAccessException e9) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e9);
                } catch (InstantiationException e10) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e10);
                } catch (InvocationTargetException e11) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e11);
                }
            }
        }
        int[] iArr2 = H0;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i5, 0);
        h0.z0.m(this, context, iArr2, attributeSet, obtainStyledAttributes2, i5);
        boolean z4 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z4);
        setTag(R.id.is_pooling_container_tag, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        r0 r0Var = this.f1245t;
        if (r0Var != null) {
            return r0Var.t(layoutParams);
        }
        throw new IllegalStateException(androidx.appcompat.widget.b0.e(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }
}
