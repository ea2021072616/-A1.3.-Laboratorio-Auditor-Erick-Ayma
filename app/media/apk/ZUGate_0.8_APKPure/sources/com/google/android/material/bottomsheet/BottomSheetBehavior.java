package com.google.android.material.bottomsheet;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.d0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.m0;
import b3.c;
import com.github.appintro.R;
import d.m;
import d.w0;
import h0.o0;
import h0.p1;
import h0.q1;
import h0.r1;
import h0.z0;
import h1.e;
import j3.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import k3.b;
import k3.g;
import p3.f;
import p3.j;
import q0.d;
import u.a;
/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends a implements b {
    public final e A;
    public ValueAnimator B;
    public int C;
    public int D;
    public int E;
    public float F;
    public int G;
    public final float H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public d M;
    public boolean N;
    public int O;
    public boolean P;
    public final float Q;
    public int R;
    public int S;
    public int T;
    public WeakReference U;
    public WeakReference V;
    public final ArrayList W;
    public VelocityTracker X;
    public g Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public int f2021a;

    /* renamed from: a0  reason: collision with root package name */
    public int f2022a0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2023b;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f2024b0;

    /* renamed from: c  reason: collision with root package name */
    public final float f2025c;

    /* renamed from: c0  reason: collision with root package name */
    public HashMap f2026c0;

    /* renamed from: d  reason: collision with root package name */
    public int f2027d;

    /* renamed from: d0  reason: collision with root package name */
    public final SparseIntArray f2028d0;

    /* renamed from: e  reason: collision with root package name */
    public int f2029e;

    /* renamed from: e0  reason: collision with root package name */
    public final b3.b f2030e0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2031f;

    /* renamed from: g  reason: collision with root package name */
    public int f2032g;

    /* renamed from: h  reason: collision with root package name */
    public final int f2033h;

    /* renamed from: i  reason: collision with root package name */
    public p3.g f2034i;

    /* renamed from: j  reason: collision with root package name */
    public final ColorStateList f2035j;

    /* renamed from: k  reason: collision with root package name */
    public int f2036k;

    /* renamed from: l  reason: collision with root package name */
    public int f2037l;

    /* renamed from: m  reason: collision with root package name */
    public int f2038m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2039n;
    public final boolean o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f2040p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f2041q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f2042r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f2043s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f2044t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f2045u;

    /* renamed from: v  reason: collision with root package name */
    public int f2046v;

    /* renamed from: w  reason: collision with root package name */
    public int f2047w;

    /* renamed from: x  reason: collision with root package name */
    public final boolean f2048x;

    /* renamed from: y  reason: collision with root package name */
    public final j f2049y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f2050z;

    public BottomSheetBehavior() {
        this.f2021a = 0;
        this.f2023b = true;
        this.f2036k = -1;
        this.f2037l = -1;
        this.A = new e(this, 0);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = 4;
        this.Q = 0.1f;
        this.W = new ArrayList();
        this.f2022a0 = -1;
        this.f2028d0 = new SparseIntArray();
        this.f2030e0 = new b3.b(this);
    }

    public static BottomSheetBehavior A(FrameLayout frameLayout) {
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams instanceof u.d) {
            a aVar = ((u.d) layoutParams).f5096a;
            if (aVar instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) aVar;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public static View z(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        WeakHashMap weakHashMap = z0.f3233a;
        if (o0.p(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View z4 = z(viewGroup.getChildAt(i5));
                if (z4 != null) {
                    return z4;
                }
            }
        }
        return null;
    }

    public final int B(int i5, int i6, int i7, int i8) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, i6, i8);
        if (i7 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode != 1073741824) {
            if (size != 0) {
                i7 = Math.min(size, i7);
            }
            return View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i7), 1073741824);
    }

    public final int C() {
        if (this.f2023b) {
            return this.D;
        }
        return Math.max(this.C, this.f2042r ? 0 : this.f2047w);
    }

    public final int D(int i5) {
        if (i5 != 3) {
            if (i5 != 4) {
                if (i5 != 5) {
                    if (i5 == 6) {
                        return this.E;
                    }
                    throw new IllegalArgumentException(b0.f("Invalid state to get top offset: ", i5));
                }
                return this.T;
            }
            return this.G;
        }
        return C();
    }

    public final boolean E() {
        WeakReference weakReference = this.U;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        ((View) this.U.get()).getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    public final void F(boolean z4) {
        if (this.I != z4) {
            this.I = z4;
            if (!z4 && this.L == 5) {
                H(4);
            }
            L();
        }
    }

    public final void G(int i5) {
        boolean z4 = false;
        if (i5 == -1) {
            if (!this.f2031f) {
                this.f2031f = true;
                z4 = true;
            }
        } else if (this.f2031f || this.f2029e != i5) {
            this.f2031f = false;
            this.f2029e = Math.max(0, i5);
            z4 = true;
        }
        if (z4) {
            O();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:
        if (r5.isAttachedToWindow() != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(int r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 == r0) goto L71
            r1 = 2
            if (r5 != r1) goto L8
            goto L71
        L8:
            boolean r1 = r4.I
            r2 = 5
            if (r1 != 0) goto L23
            if (r5 != r2) goto L23
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Cannot set state: "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "BottomSheetBehavior"
            android.util.Log.w(r0, r5)
            return
        L23:
            r1 = 6
            if (r5 != r1) goto L34
            boolean r1 = r4.f2023b
            if (r1 == 0) goto L34
            int r1 = r4.D(r5)
            int r3 = r4.D
            if (r1 > r3) goto L34
            r1 = 3
            goto L35
        L34:
            r1 = r5
        L35:
            java.lang.ref.WeakReference r3 = r4.U
            if (r3 == 0) goto L6d
            java.lang.Object r3 = r3.get()
            if (r3 != 0) goto L40
            goto L6d
        L40:
            java.lang.ref.WeakReference r5 = r4.U
            java.lang.Object r5 = r5.get()
            android.view.View r5 = (android.view.View) r5
            androidx.activity.h r3 = new androidx.activity.h
            r3.<init>(r1, r2, r4, r5)
            android.view.ViewParent r1 = r5.getParent()
            if (r1 == 0) goto L62
            boolean r1 = r1.isLayoutRequested()
            if (r1 == 0) goto L62
            java.util.WeakHashMap r1 = h0.z0.f3233a
            boolean r1 = r5.isAttachedToWindow()
            if (r1 == 0) goto L62
            goto L63
        L62:
            r0 = 0
        L63:
            if (r0 == 0) goto L69
            r5.post(r3)
            goto L70
        L69:
            r3.run()
            goto L70
        L6d:
            r4.I(r5)
        L70:
            return
        L71:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "STATE_"
            r2.<init>(r3)
            if (r5 != r0) goto L7f
            java.lang.String r5 = "DRAGGING"
            goto L81
        L7f:
            java.lang.String r5 = "SETTLING"
        L81:
            java.lang.String r0 = " should not be set externally."
            java.lang.String r5 = androidx.appcompat.widget.b0.i(r2, r5, r0)
            r1.<init>(r5)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.H(int):void");
    }

    public final void I(int i5) {
        View view;
        if (this.L == i5) {
            return;
        }
        this.L = i5;
        WeakReference weakReference = this.U;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i6 = 0;
        if (i5 == 3) {
            N(true);
        } else if (i5 == 6 || i5 == 5 || i5 == 4) {
            N(false);
        }
        M(i5, true);
        while (true) {
            ArrayList arrayList = this.W;
            if (i6 >= arrayList.size()) {
                L();
                return;
            } else {
                ((c) arrayList.get(i6)).c(view, i5);
                i6++;
            }
        }
    }

    public final boolean J(View view, float f5) {
        if (this.J) {
            return true;
        }
        if (view.getTop() < this.G) {
            return false;
        }
        return Math.abs(((f5 * this.Q) + ((float) view.getTop())) - ((float) this.G)) / ((float) x()) > 0.5f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r5 != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (r1.q(r5.getLeft(), r0) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K(android.view.View r5, int r6, boolean r7) {
        /*
            r4 = this;
            int r0 = r4.D(r6)
            q0.d r1 = r4.M
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L34
            if (r7 == 0) goto L17
            int r5 = r5.getLeft()
            boolean r5 = r1.q(r5, r0)
            if (r5 == 0) goto L34
            goto L33
        L17:
            int r7 = r5.getLeft()
            r1.f4450r = r5
            r5 = -1
            r1.f4436c = r5
            boolean r5 = r1.i(r7, r0, r2, r2)
            if (r5 != 0) goto L31
            int r7 = r1.f4434a
            if (r7 != 0) goto L31
            android.view.View r7 = r1.f4450r
            if (r7 == 0) goto L31
            r7 = 0
            r1.f4450r = r7
        L31:
            if (r5 == 0) goto L34
        L33:
            r2 = r3
        L34:
            if (r2 == 0) goto L43
            r5 = 2
            r4.I(r5)
            r4.M(r6, r3)
            h1.e r5 = r4.A
            r5.a(r6)
            goto L46
        L43:
            r4.I(r6)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.K(android.view.View, int, boolean):void");
    }

    public final void L() {
        View view;
        int i5;
        WeakReference weakReference = this.U;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        z0.k(view, 524288);
        z0.h(view, 0);
        z0.k(view, 262144);
        z0.h(view, 0);
        z0.k(view, 1048576);
        z0.h(view, 0);
        SparseIntArray sparseIntArray = this.f2028d0;
        int i6 = sparseIntArray.get(0, -1);
        if (i6 != -1) {
            z0.k(view, i6);
            z0.h(view, 0);
            sparseIntArray.delete(0);
        }
        if (!this.f2023b && this.L != 6) {
            String string = view.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            m mVar = new m(6, this);
            ArrayList f5 = z0.f(view);
            int i7 = 0;
            while (true) {
                if (i7 >= f5.size()) {
                    int i8 = -1;
                    for (int i9 = 0; i9 < 32 && i8 == -1; i9++) {
                        int i10 = z0.f3236d[i9];
                        boolean z4 = true;
                        for (int i11 = 0; i11 < f5.size(); i11++) {
                            z4 &= ((i0.e) f5.get(i11)).a() != i10;
                        }
                        if (z4) {
                            i8 = i10;
                        }
                    }
                    i5 = i8;
                } else if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((i0.e) f5.get(i7)).f3370a).getLabel())) {
                    i5 = ((i0.e) f5.get(i7)).a();
                    break;
                } else {
                    i7++;
                }
            }
            if (i5 != -1) {
                i0.e eVar = new i0.e(null, i5, string, mVar, null);
                View.AccessibilityDelegate d5 = z0.d(view);
                h0.b bVar = d5 == null ? null : d5 instanceof h0.a ? ((h0.a) d5).f3090a : new h0.b(d5);
                if (bVar == null) {
                    bVar = new h0.b();
                }
                z0.n(view, bVar);
                z0.k(view, eVar.a());
                z0.f(view).add(eVar);
                z0.h(view, 0);
            }
            sparseIntArray.put(0, i5);
        }
        if (this.I && this.L != 5) {
            z0.l(view, i0.e.f3367j, new m(5, this));
        }
        int i12 = this.L;
        if (i12 == 3) {
            z0.l(view, i0.e.f3366i, new m(this.f2023b ? 4 : 6, this));
        } else if (i12 == 4) {
            z0.l(view, i0.e.f3365h, new m(this.f2023b ? 3 : 6, this));
        } else if (i12 == 6) {
            z0.l(view, i0.e.f3366i, new m(4, this));
            z0.l(view, i0.e.f3365h, new m(3, this));
        }
    }

    public final void M(int i5, boolean z4) {
        ValueAnimator valueAnimator;
        if (i5 == 2) {
            return;
        }
        boolean z5 = this.L == 3 && (this.f2048x || E());
        if (this.f2050z == z5 || this.f2034i == null) {
            return;
        }
        this.f2050z = z5;
        if (z4 && (valueAnimator = this.B) != null) {
            if (valueAnimator.isRunning()) {
                this.B.reverse();
                return;
            }
            this.B.setFloatValues(this.f2034i.f4294g.f4283j, z5 ? w() : 1.0f);
            this.B.start();
            return;
        }
        ValueAnimator valueAnimator2 = this.B;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.B.cancel();
        }
        p3.g gVar = this.f2034i;
        float w5 = this.f2050z ? w() : 1.0f;
        f fVar = gVar.f4294g;
        if (fVar.f4283j != w5) {
            fVar.f4283j = w5;
            gVar.f4298k = true;
            gVar.invalidateSelf();
        }
    }

    public final void N(boolean z4) {
        WeakReference weakReference = this.U;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z4) {
                if (this.f2026c0 != null) {
                    return;
                }
                this.f2026c0 = new HashMap(childCount);
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = coordinatorLayout.getChildAt(i5);
                if (childAt != this.U.get() && z4) {
                    this.f2026c0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z4) {
                return;
            }
            this.f2026c0 = null;
        }
    }

    public final void O() {
        View view;
        if (this.U != null) {
            v();
            if (this.L != 4 || (view = (View) this.U.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // k3.b
    public final void a() {
        g gVar = this.Y;
        if (gVar == null) {
            return;
        }
        androidx.activity.b bVar = gVar.f3645f;
        gVar.f3645f = null;
        if (bVar == null || Build.VERSION.SDK_INT < 34) {
            H(this.I ? 5 : 4);
            return;
        }
        boolean z4 = this.I;
        int i5 = gVar.f3643d;
        int i6 = gVar.f3642c;
        float f5 = bVar.f47c;
        if (!z4) {
            AnimatorSet a5 = gVar.a();
            a5.setDuration(x2.a.b(i6, f5, i5));
            a5.start();
            H(4);
            return;
        }
        androidx.appcompat.widget.d dVar = new androidx.appcompat.widget.d(5, this);
        View view = gVar.f3641b;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, view.getScaleY() * view.getHeight());
        ofFloat.setInterpolator(new v0.b());
        ofFloat.setDuration(x2.a.b(i6, f5, i5));
        ofFloat.addListener(new androidx.appcompat.widget.d(7, gVar));
        ofFloat.addListener(dVar);
        ofFloat.start();
    }

    @Override // k3.b
    public final void b(androidx.activity.b bVar) {
        g gVar = this.Y;
        if (gVar == null) {
            return;
        }
        gVar.f3645f = bVar;
    }

    @Override // k3.b
    public final void c(androidx.activity.b bVar) {
        g gVar = this.Y;
        if (gVar == null) {
            return;
        }
        if (gVar.f3645f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        androidx.activity.b bVar2 = gVar.f3645f;
        gVar.f3645f = bVar;
        if (bVar2 == null) {
            return;
        }
        gVar.b(bVar.f47c);
    }

    @Override // k3.b
    public final void d() {
        g gVar = this.Y;
        if (gVar == null) {
            return;
        }
        if (gVar.f3645f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        androidx.activity.b bVar = gVar.f3645f;
        gVar.f3645f = null;
        if (bVar == null) {
            return;
        }
        AnimatorSet a5 = gVar.a();
        a5.setDuration(gVar.f3644e);
        a5.start();
    }

    @Override // u.a
    public final void g(u.d dVar) {
        this.U = null;
        this.M = null;
        this.Y = null;
    }

    @Override // u.a
    public final void i() {
        this.U = null;
        this.M = null;
        this.Y = null;
    }

    @Override // u.a
    public final boolean j(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i5;
        d dVar;
        if (!view.isShown() || !this.K) {
            this.N = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.Z = -1;
            this.f2022a0 = -1;
            VelocityTracker velocityTracker = this.X;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.X = null;
            }
        }
        if (this.X == null) {
            this.X = VelocityTracker.obtain();
        }
        this.X.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x5 = (int) motionEvent.getX();
            this.f2022a0 = (int) motionEvent.getY();
            if (this.L != 2) {
                WeakReference weakReference = this.V;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.o(view2, x5, this.f2022a0)) {
                    this.Z = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f2024b0 = true;
                }
            }
            this.N = this.Z == -1 && !coordinatorLayout.o(view, x5, this.f2022a0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2024b0 = false;
            this.Z = -1;
            if (this.N) {
                this.N = false;
                return false;
            }
        }
        if (this.N || (dVar = this.M) == null || !dVar.r(motionEvent)) {
            WeakReference weakReference2 = this.V;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            return (actionMasked != 2 || view3 == null || this.N || this.L == 1 || coordinatorLayout.o(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.M == null || (i5 = this.f2022a0) == -1 || Math.abs(((float) i5) - motionEvent.getY()) <= ((float) this.M.f4435b)) ? false : true;
        }
        return true;
    }

    @Override // u.a
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, int i5) {
        WeakHashMap weakHashMap = z0.f3233a;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        int i6 = 0;
        if (this.U == null) {
            this.f2032g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            int i7 = Build.VERSION.SDK_INT;
            boolean z4 = (i7 < 29 || this.f2039n || this.f2031f) ? false : true;
            if (this.o || this.f2040p || this.f2041q || this.f2043s || this.f2044t || this.f2045u || z4) {
                o0.u(view, new d0(new w0(this, z4), 24, new m0(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom())));
                if (view.isAttachedToWindow()) {
                    h0.m0.c(view);
                } else {
                    view.addOnAttachStateChangeListener(new l());
                }
            }
            b3.g gVar = new b3.g(view);
            if (i7 >= 30) {
                view.setWindowInsetsAnimationCallback(new r1(gVar));
            } else {
                PathInterpolator pathInterpolator = q1.f3197e;
                Object tag = view.getTag(R.id.tag_on_apply_window_listener);
                View.OnApplyWindowInsetsListener p1Var = new p1(view, gVar);
                view.setTag(R.id.tag_window_insets_animation_callback, p1Var);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(p1Var);
                }
            }
            this.U = new WeakReference(view);
            this.Y = new g(view);
            Drawable drawable = this.f2034i;
            if (drawable != null) {
                view.setBackground(drawable);
                p3.g gVar2 = this.f2034i;
                float f5 = this.H;
                if (f5 == -1.0f) {
                    f5 = o0.i(view);
                }
                gVar2.i(f5);
            } else {
                ColorStateList colorStateList = this.f2035j;
                if (colorStateList != null) {
                    o0.q(view, colorStateList);
                }
            }
            L();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.M == null) {
            this.M = new d(coordinatorLayout.getContext(), coordinatorLayout, this.f2030e0);
        }
        int top = view.getTop();
        coordinatorLayout.q(view, i5);
        this.S = coordinatorLayout.getWidth();
        this.T = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.R = height;
        int i8 = this.T;
        int i9 = i8 - height;
        int i10 = this.f2047w;
        if (i9 < i10) {
            if (this.f2042r) {
                int i11 = this.f2037l;
                if (i11 != -1) {
                    i8 = Math.min(i8, i11);
                }
                this.R = i8;
            } else {
                int i12 = i8 - i10;
                int i13 = this.f2037l;
                if (i13 != -1) {
                    i12 = Math.min(i12, i13);
                }
                this.R = i12;
            }
        }
        this.D = Math.max(0, this.T - this.R);
        this.E = (int) ((1.0f - this.F) * this.T);
        v();
        int i14 = this.L;
        if (i14 == 3) {
            view.offsetTopAndBottom(C());
        } else if (i14 == 6) {
            view.offsetTopAndBottom(this.E);
        } else if (this.I && i14 == 5) {
            view.offsetTopAndBottom(this.T);
        } else if (i14 == 4) {
            view.offsetTopAndBottom(this.G);
        } else if (i14 == 1 || i14 == 2) {
            view.offsetTopAndBottom(top - view.getTop());
        }
        M(this.L, false);
        this.V = new WeakReference(z(view));
        while (true) {
            ArrayList arrayList = this.W;
            if (i6 >= arrayList.size()) {
                return true;
            }
            ((c) arrayList.get(i6)).a(view);
            i6++;
        }
    }

    @Override // u.a
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(B(i5, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, this.f2036k, marginLayoutParams.width), B(i7, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + 0, this.f2037l, marginLayoutParams.height));
        return true;
    }

    @Override // u.a
    public final boolean m(View view) {
        WeakReference weakReference = this.V;
        return (weakReference == null || view != weakReference.get() || this.L == 3) ? false : true;
    }

    @Override // u.a
    public final void n(View view, View view2, int i5, int[] iArr, int i6) {
        if (i6 == 1) {
            return;
        }
        WeakReference weakReference = this.V;
        if (view2 != (weakReference != null ? (View) weakReference.get() : null)) {
            return;
        }
        int top = view.getTop();
        int i7 = top - i5;
        if (i5 > 0) {
            if (i7 < C()) {
                int C = top - C();
                iArr[1] = C;
                WeakHashMap weakHashMap = z0.f3233a;
                view.offsetTopAndBottom(-C);
                I(3);
            } else if (!this.K) {
                return;
            } else {
                iArr[1] = i5;
                WeakHashMap weakHashMap2 = z0.f3233a;
                view.offsetTopAndBottom(-i5);
                I(1);
            }
        } else if (i5 < 0 && !view2.canScrollVertically(-1)) {
            int i8 = this.G;
            if (i7 > i8 && !this.I) {
                int i9 = top - i8;
                iArr[1] = i9;
                WeakHashMap weakHashMap3 = z0.f3233a;
                view.offsetTopAndBottom(-i9);
                I(4);
            } else if (!this.K) {
                return;
            } else {
                iArr[1] = i5;
                WeakHashMap weakHashMap4 = z0.f3233a;
                view.offsetTopAndBottom(-i5);
                I(1);
            }
        }
        y(view.getTop());
        this.O = i5;
        this.P = true;
    }

    @Override // u.a
    public final void o(CoordinatorLayout coordinatorLayout, View view, int i5, int i6, int i7, int[] iArr) {
    }

    @Override // u.a
    public final void q(View view, Parcelable parcelable) {
        b3.d dVar = (b3.d) parcelable;
        int i5 = this.f2021a;
        if (i5 != 0) {
            if (i5 == -1 || (i5 & 1) == 1) {
                this.f2029e = dVar.f1638e;
            }
            if (i5 == -1 || (i5 & 2) == 2) {
                this.f2023b = dVar.f1639f;
            }
            if (i5 == -1 || (i5 & 4) == 4) {
                this.I = dVar.f1640g;
            }
            if (i5 == -1 || (i5 & 8) == 8) {
                this.J = dVar.f1641h;
            }
        }
        int i6 = dVar.f1637d;
        if (i6 == 1 || i6 == 2) {
            this.L = 4;
        } else {
            this.L = i6;
        }
    }

    @Override // u.a
    public final Parcelable r(View view) {
        return new b3.d(View.BaseSavedState.EMPTY_STATE, this);
    }

    @Override // u.a
    public final boolean s(View view, int i5, int i6) {
        this.O = 0;
        this.P = false;
        return (i5 & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r3.getTop() <= r2.E) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006f, code lost:
        if (java.lang.Math.abs(r4 - r2.D) < java.lang.Math.abs(r4 - r2.G)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007e, code lost:
        if (r4 < java.lang.Math.abs(r4 - r2.G)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008e, code lost:
        if (java.lang.Math.abs(r4 - r5) < java.lang.Math.abs(r4 - r2.G)) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a9, code lost:
        if (java.lang.Math.abs(r4 - r2.E) < java.lang.Math.abs(r4 - r2.G)) goto L18;
     */
    @Override // u.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(android.view.View r3, android.view.View r4, int r5) {
        /*
            r2 = this;
            int r5 = r3.getTop()
            int r0 = r2.C()
            r1 = 3
            if (r5 != r0) goto Lf
            r2.I(r1)
            return
        Lf:
            java.lang.ref.WeakReference r5 = r2.V
            if (r5 == 0) goto Lb4
            java.lang.Object r5 = r5.get()
            if (r4 != r5) goto Lb4
            boolean r4 = r2.P
            if (r4 != 0) goto L1f
            goto Lb4
        L1f:
            int r4 = r2.O
            if (r4 <= 0) goto L33
            boolean r4 = r2.f2023b
            if (r4 == 0) goto L29
            goto Lae
        L29:
            int r4 = r3.getTop()
            int r5 = r2.E
            if (r4 <= r5) goto Lae
            goto Lab
        L33:
            boolean r4 = r2.I
            if (r4 == 0) goto L54
            android.view.VelocityTracker r4 = r2.X
            if (r4 != 0) goto L3d
            r4 = 0
            goto L4c
        L3d:
            r5 = 1000(0x3e8, float:1.401E-42)
            float r0 = r2.f2025c
            r4.computeCurrentVelocity(r5, r0)
            android.view.VelocityTracker r4 = r2.X
            int r5 = r2.Z
            float r4 = r4.getYVelocity(r5)
        L4c:
            boolean r4 = r2.J(r3, r4)
            if (r4 == 0) goto L54
            r1 = 5
            goto Lae
        L54:
            int r4 = r2.O
            if (r4 != 0) goto L91
            int r4 = r3.getTop()
            boolean r5 = r2.f2023b
            if (r5 == 0) goto L72
            int r5 = r2.D
            int r5 = r4 - r5
            int r5 = java.lang.Math.abs(r5)
            int r0 = r2.G
            int r4 = r4 - r0
            int r4 = java.lang.Math.abs(r4)
            if (r5 >= r4) goto Lad
            goto Lae
        L72:
            int r5 = r2.E
            if (r4 >= r5) goto L81
            int r5 = r2.G
            int r5 = r4 - r5
            int r5 = java.lang.Math.abs(r5)
            if (r4 >= r5) goto Lab
            goto Lae
        L81:
            int r5 = r4 - r5
            int r5 = java.lang.Math.abs(r5)
            int r0 = r2.G
            int r4 = r4 - r0
            int r4 = java.lang.Math.abs(r4)
            if (r5 >= r4) goto Lad
            goto Lab
        L91:
            boolean r4 = r2.f2023b
            if (r4 == 0) goto L96
            goto Lad
        L96:
            int r4 = r3.getTop()
            int r5 = r2.E
            int r5 = r4 - r5
            int r5 = java.lang.Math.abs(r5)
            int r0 = r2.G
            int r4 = r4 - r0
            int r4 = java.lang.Math.abs(r4)
            if (r5 >= r4) goto Lad
        Lab:
            r1 = 6
            goto Lae
        Lad:
            r1 = 4
        Lae:
            r4 = 0
            r2.K(r3, r1, r4)
            r2.P = r4
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.t(android.view.View, android.view.View, int):void");
    }

    @Override // u.a
    public final boolean u(View view, MotionEvent motionEvent) {
        boolean z4 = false;
        if (view.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            int i5 = this.L;
            if (i5 == 1 && actionMasked == 0) {
                return true;
            }
            d dVar = this.M;
            if (dVar != null && (this.K || i5 == 1)) {
                dVar.k(motionEvent);
            }
            if (actionMasked == 0) {
                this.Z = -1;
                this.f2022a0 = -1;
                VelocityTracker velocityTracker = this.X;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.X = null;
                }
            }
            if (this.X == null) {
                this.X = VelocityTracker.obtain();
            }
            this.X.addMovement(motionEvent);
            if (this.M != null && (this.K || this.L == 1)) {
                z4 = true;
            }
            if (z4 && actionMasked == 2 && !this.N) {
                float abs = Math.abs(this.f2022a0 - motionEvent.getY());
                d dVar2 = this.M;
                if (abs > dVar2.f4435b) {
                    dVar2.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
                }
            }
            return !this.N;
        }
        return false;
    }

    public final void v() {
        int x5 = x();
        if (this.f2023b) {
            this.G = Math.max(this.T - x5, this.D);
        } else {
            this.G = this.T - x5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float w() {
        /*
            r5 = this;
            p3.g r0 = r5.f2034i
            r1 = 0
            if (r0 == 0) goto L79
            java.lang.ref.WeakReference r0 = r5.U
            if (r0 == 0) goto L79
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L79
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r0 < r2) goto L79
            java.lang.ref.WeakReference r0 = r5.U
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r5.E()
            if (r2 == 0) goto L79
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 == 0) goto L79
            p3.g r2 = r5.f2034i
            p3.f r3 = r2.f4294g
            p3.j r3 = r3.f4274a
            p3.c r3 = r3.f4318e
            android.graphics.RectF r2 = r2.g()
            float r2 = r3.a(r2)
            android.view.RoundedCorner r3 = b3.a.i(r0)
            if (r3 == 0) goto L4e
            int r3 = b3.a.c(r3)
            float r3 = (float) r3
            int r4 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r4 <= 0) goto L4e
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L4e
            float r3 = r3 / r2
            goto L4f
        L4e:
            r3 = r1
        L4f:
            p3.g r2 = r5.f2034i
            p3.f r4 = r2.f4294g
            p3.j r4 = r4.f4274a
            p3.c r4 = r4.f4319f
            android.graphics.RectF r2 = r2.g()
            float r2 = r4.a(r2)
            android.view.RoundedCorner r0 = b3.a.n(r0)
            if (r0 == 0) goto L74
            int r0 = b3.a.c(r0)
            float r0 = (float) r0
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 <= 0) goto L74
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L74
            float r1 = r0 / r2
        L74:
            float r0 = java.lang.Math.max(r3, r1)
            return r0
        L79:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.w():float");
    }

    public final int x() {
        int i5;
        return this.f2031f ? Math.min(Math.max(this.f2032g, this.T - ((this.S * 9) / 16)), this.R) + this.f2046v : (this.f2039n || this.o || (i5 = this.f2038m) <= 0) ? this.f2029e + this.f2046v : Math.max(this.f2029e, i5 + this.f2033h);
    }

    public final void y(int i5) {
        View view = (View) this.U.get();
        if (view != null) {
            ArrayList arrayList = this.W;
            if (arrayList.isEmpty()) {
                return;
            }
            int i6 = this.G;
            if (i5 <= i6 && i6 != C()) {
                C();
            }
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                ((c) arrayList.get(i7)).b(view);
            }
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(0);
        int i5;
        this.f2021a = 0;
        this.f2023b = true;
        this.f2036k = -1;
        this.f2037l = -1;
        this.A = new e(this, 0);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = 4;
        this.Q = 0.1f;
        this.W = new ArrayList();
        this.f2022a0 = -1;
        this.f2028d0 = new SparseIntArray();
        this.f2030e0 = new b3.b(this);
        this.f2033h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w2.a.f5386a);
        int i6 = 3;
        if (obtainStyledAttributes.hasValue(3)) {
            this.f2035j = p2.a.v(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(21)) {
            this.f2049y = new j(j.b(context, attributeSet, R.attr.bottomSheetStyle, 2131952479));
        }
        j jVar = this.f2049y;
        if (jVar != null) {
            p3.g gVar = new p3.g(jVar);
            this.f2034i = gVar;
            gVar.h(context);
            ColorStateList colorStateList = this.f2035j;
            if (colorStateList != null) {
                this.f2034i.j(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.f2034i.setTint(typedValue.data);
            }
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(w(), 1.0f);
        this.B = ofFloat;
        ofFloat.setDuration(500L);
        this.B.addUpdateListener(new k1.b(1, this));
        this.H = obtainStyledAttributes.getDimension(2, -1.0f);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f2036k = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f2037l = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(9);
        if (peekValue != null && (i5 = peekValue.data) == -1) {
            G(i5);
        } else {
            G(obtainStyledAttributes.getDimensionPixelSize(9, -1));
        }
        F(obtainStyledAttributes.getBoolean(8, false));
        this.f2039n = obtainStyledAttributes.getBoolean(13, false);
        boolean z4 = obtainStyledAttributes.getBoolean(6, true);
        if (this.f2023b != z4) {
            this.f2023b = z4;
            if (this.U != null) {
                v();
            }
            I((this.f2023b && this.L == 6) ? i6 : this.L);
            M(this.L, true);
            L();
        }
        this.J = obtainStyledAttributes.getBoolean(12, false);
        this.K = obtainStyledAttributes.getBoolean(4, true);
        this.f2021a = obtainStyledAttributes.getInt(10, 0);
        float f5 = obtainStyledAttributes.getFloat(7, 0.5f);
        if (f5 > 0.0f && f5 < 1.0f) {
            this.F = f5;
            if (this.U != null) {
                this.E = (int) ((1.0f - f5) * this.T);
            }
            TypedValue peekValue2 = obtainStyledAttributes.peekValue(5);
            if (peekValue2 != null && peekValue2.type == 16) {
                int i7 = peekValue2.data;
                if (i7 >= 0) {
                    this.C = i7;
                    M(this.L, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
                if (dimensionPixelOffset >= 0) {
                    this.C = dimensionPixelOffset;
                    M(this.L, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.f2027d = obtainStyledAttributes.getInt(11, 500);
            this.o = obtainStyledAttributes.getBoolean(17, false);
            this.f2040p = obtainStyledAttributes.getBoolean(18, false);
            this.f2041q = obtainStyledAttributes.getBoolean(19, false);
            this.f2042r = obtainStyledAttributes.getBoolean(20, true);
            this.f2043s = obtainStyledAttributes.getBoolean(14, false);
            this.f2044t = obtainStyledAttributes.getBoolean(15, false);
            this.f2045u = obtainStyledAttributes.getBoolean(16, false);
            this.f2048x = obtainStyledAttributes.getBoolean(23, true);
            obtainStyledAttributes.recycle();
            this.f2025c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }
}
