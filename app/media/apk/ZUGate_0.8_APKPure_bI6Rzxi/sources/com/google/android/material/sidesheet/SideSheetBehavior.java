package com.google.android.material.sidesheet;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.appcompat.widget.b0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;
import h0.z0;
import h1.e;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import k3.b;
import k3.h;
import k3.i;
import p3.g;
import p3.j;
import q0.d;
import u.a;
/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends a implements b {

    /* renamed from: a  reason: collision with root package name */
    public q3.a f2172a;

    /* renamed from: b  reason: collision with root package name */
    public g f2173b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f2174c;

    /* renamed from: d  reason: collision with root package name */
    public final j f2175d;

    /* renamed from: e  reason: collision with root package name */
    public final e f2176e;

    /* renamed from: f  reason: collision with root package name */
    public final float f2177f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2178g;

    /* renamed from: h  reason: collision with root package name */
    public int f2179h;

    /* renamed from: i  reason: collision with root package name */
    public d f2180i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2181j;

    /* renamed from: k  reason: collision with root package name */
    public final float f2182k;

    /* renamed from: l  reason: collision with root package name */
    public int f2183l;

    /* renamed from: m  reason: collision with root package name */
    public int f2184m;

    /* renamed from: n  reason: collision with root package name */
    public int f2185n;
    public int o;

    /* renamed from: p  reason: collision with root package name */
    public WeakReference f2186p;

    /* renamed from: q  reason: collision with root package name */
    public WeakReference f2187q;

    /* renamed from: r  reason: collision with root package name */
    public int f2188r;

    /* renamed from: s  reason: collision with root package name */
    public VelocityTracker f2189s;

    /* renamed from: t  reason: collision with root package name */
    public i f2190t;

    /* renamed from: u  reason: collision with root package name */
    public int f2191u;

    /* renamed from: v  reason: collision with root package name */
    public final LinkedHashSet f2192v;

    /* renamed from: w  reason: collision with root package name */
    public final q3.d f2193w;

    public SideSheetBehavior() {
        this.f2176e = new e(this);
        this.f2178g = true;
        this.f2179h = 5;
        this.f2182k = 0.1f;
        this.f2188r = -1;
        this.f2192v = new LinkedHashSet();
        this.f2193w = new q3.d(this);
    }

    @Override // k3.b
    public final void a() {
        int i5;
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        boolean z4;
        i iVar = this.f2190t;
        if (iVar == null) {
            return;
        }
        androidx.activity.b bVar = iVar.f3645f;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
        iVar.f3645f = null;
        int i6 = 5;
        if (bVar == null || Build.VERSION.SDK_INT < 34) {
            w(5);
            return;
        }
        q3.a aVar = this.f2172a;
        if (aVar != null) {
            switch (aVar.f4455u) {
                case 0:
                    z4 = true;
                    break;
                default:
                    z4 = false;
                    break;
            }
            if (z4) {
                i6 = 3;
            }
        }
        androidx.appcompat.widget.d dVar = new androidx.appcompat.widget.d(8, this);
        WeakReference weakReference = this.f2187q;
        final View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null) {
            final int e02 = this.f2172a.e0(marginLayoutParams);
            animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: q3.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    a aVar2 = SideSheetBehavior.this.f2172a;
                    int b5 = x2.a.b(e02, valueAnimator.getAnimatedFraction(), 0);
                    int i7 = aVar2.f4455u;
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                    switch (i7) {
                        case 0:
                            marginLayoutParams2.leftMargin = b5;
                            break;
                        default:
                            marginLayoutParams2.rightMargin = b5;
                            break;
                    }
                    view.requestLayout();
                }
            };
        }
        boolean z5 = bVar.f48d == 0;
        WeakHashMap weakHashMap = z0.f3233a;
        View view2 = iVar.f3641b;
        boolean z6 = (Gravity.getAbsoluteGravity(i6, view2.getLayoutDirection()) & 3) == 3;
        float scaleX = view2.getScaleX() * view2.getWidth();
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            i5 = z6 ? marginLayoutParams2.leftMargin : marginLayoutParams2.rightMargin;
        } else {
            i5 = 0;
        }
        float f5 = scaleX + i5;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (z6) {
            f5 = -f5;
        }
        fArr[0] = f5;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, property, fArr);
        if (animatorUpdateListener != null) {
            ofFloat.addUpdateListener(animatorUpdateListener);
        }
        ofFloat.setInterpolator(new v0.b());
        ofFloat.setDuration(x2.a.b(iVar.f3642c, bVar.f47c, iVar.f3643d));
        ofFloat.addListener(new h(iVar, z5, i6));
        ofFloat.addListener(dVar);
        ofFloat.start();
    }

    @Override // k3.b
    public final void b(androidx.activity.b bVar) {
        i iVar = this.f2190t;
        if (iVar == null) {
            return;
        }
        iVar.f3645f = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002b  */
    @Override // k3.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(androidx.activity.b r7) {
        /*
            r6 = this;
            k3.i r0 = r6.f2190t
            if (r0 != 0) goto L5
            return
        L5:
            q3.a r1 = r6.f2172a
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L18
            int r1 = r1.f4455u
            switch(r1) {
                case 0: goto L12;
                default: goto L10;
            }
        L10:
            r1 = r2
            goto L13
        L12:
            r1 = r3
        L13:
            if (r1 != 0) goto L16
            goto L18
        L16:
            r1 = 3
            goto L19
        L18:
            r1 = 5
        L19:
            androidx.activity.b r4 = r0.f3645f
            if (r4 != 0) goto L24
            java.lang.String r4 = "MaterialBackHelper"
            java.lang.String r5 = "Must call startBackProgress() before updateBackProgress()"
            android.util.Log.w(r4, r5)
        L24:
            androidx.activity.b r4 = r0.f3645f
            r0.f3645f = r7
            if (r4 != 0) goto L2b
            goto L35
        L2b:
            int r4 = r7.f48d
            if (r4 != 0) goto L30
            r2 = r3
        L30:
            float r7 = r7.f47c
            r0.a(r7, r1, r2)
        L35:
            java.lang.ref.WeakReference r7 = r6.f2186p
            if (r7 == 0) goto L7d
            java.lang.Object r7 = r7.get()
            if (r7 != 0) goto L40
            goto L7d
        L40:
            java.lang.ref.WeakReference r7 = r6.f2186p
            java.lang.Object r7 = r7.get()
            android.view.View r7 = (android.view.View) r7
            java.lang.ref.WeakReference r0 = r6.f2187q
            if (r0 == 0) goto L53
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            goto L54
        L53:
            r0 = 0
        L54:
            if (r0 != 0) goto L57
            goto L7d
        L57:
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            if (r1 != 0) goto L60
            goto L7d
        L60:
            int r2 = r6.f2183l
            float r2 = (float) r2
            float r7 = r7.getScaleX()
            float r7 = r7 * r2
            int r2 = r6.o
            float r2 = (float) r2
            float r7 = r7 + r2
            int r7 = (int) r7
            q3.a r2 = r6.f2172a
            int r2 = r2.f4455u
            switch(r2) {
                case 0: goto L75;
                default: goto L74;
            }
        L74:
            goto L78
        L75:
            r1.leftMargin = r7
            goto L7a
        L78:
            r1.rightMargin = r7
        L7a:
            r0.requestLayout()
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.c(androidx.activity.b):void");
    }

    @Override // k3.b
    public final void d() {
        i iVar = this.f2190t;
        if (iVar == null) {
            return;
        }
        if (iVar.f3645f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        androidx.activity.b bVar = iVar.f3645f;
        iVar.f3645f = null;
        if (bVar == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        View view = iVar.f3641b;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, View.SCALE_Y, 1.0f));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i5), View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(iVar.f3644e);
        animatorSet.start();
    }

    @Override // u.a
    public final void g(u.d dVar) {
        this.f2186p = null;
        this.f2180i = null;
        this.f2190t = null;
    }

    @Override // u.a
    public final void i() {
        this.f2186p = null;
        this.f2180i = null;
        this.f2190t = null;
    }

    @Override // u.a
    public final boolean j(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        d dVar;
        VelocityTracker velocityTracker;
        if (!((view.isShown() || z0.e(view) != null) && this.f2178g)) {
            this.f2181j = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.f2189s) != null) {
            velocityTracker.recycle();
            this.f2189s = null;
        }
        if (this.f2189s == null) {
            this.f2189s = VelocityTracker.obtain();
        }
        this.f2189s.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f2191u = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f2181j) {
            this.f2181j = false;
            return false;
        }
        return (this.f2181j || (dVar = this.f2180i) == null || !dVar.r(motionEvent)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0094, code lost:
        if (r5 != r0) goto L71;
     */
    @Override // u.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(androidx.coordinatorlayout.widget.CoordinatorLayout r8, android.view.View r9, int r10) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.k(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    @Override // u.a
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i5, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i7, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + 0, marginLayoutParams.height));
        return true;
    }

    @Override // u.a
    public final void q(View view, Parcelable parcelable) {
        int i5 = ((q3.e) parcelable).f4464d;
        this.f2179h = (i5 == 1 || i5 == 2) ? 5 : 5;
    }

    @Override // u.a
    public final Parcelable r(View view) {
        return new q3.e(View.BaseSavedState.EMPTY_STATE, this);
    }

    @Override // u.a
    public final boolean u(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        boolean z4 = false;
        if (view.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            int i5 = this.f2179h;
            if (i5 == 1 && actionMasked == 0) {
                return true;
            }
            d dVar = this.f2180i;
            if (dVar != null && (this.f2178g || i5 == 1)) {
                dVar.k(motionEvent);
            }
            if (actionMasked == 0 && (velocityTracker = this.f2189s) != null) {
                velocityTracker.recycle();
                this.f2189s = null;
            }
            if (this.f2189s == null) {
                this.f2189s = VelocityTracker.obtain();
            }
            this.f2189s.addMovement(motionEvent);
            d dVar2 = this.f2180i;
            if ((dVar2 != null && (this.f2178g || this.f2179h == 1)) && actionMasked == 2 && !this.f2181j) {
                if ((dVar2 != null && (this.f2178g || this.f2179h == 1)) && Math.abs(this.f2191u - motionEvent.getX()) > this.f2180i.f4435b) {
                    z4 = true;
                }
                if (z4) {
                    this.f2180i.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
                }
            }
            return !this.f2181j;
        }
        return false;
    }

    public final u.d v() {
        View view;
        WeakReference weakReference = this.f2186p;
        if (weakReference == null || (view = (View) weakReference.get()) == null || !(view.getLayoutParams() instanceof u.d)) {
            return null;
        }
        return (u.d) view.getLayoutParams();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
        if (r1.isAttachedToWindow() != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(int r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 == r0) goto L43
            r1 = 2
            if (r5 != r1) goto L7
            goto L43
        L7:
            java.lang.ref.WeakReference r1 = r4.f2186p
            if (r1 == 0) goto L3f
            java.lang.Object r1 = r1.get()
            if (r1 != 0) goto L12
            goto L3f
        L12:
            java.lang.ref.WeakReference r1 = r4.f2186p
            java.lang.Object r1 = r1.get()
            android.view.View r1 = (android.view.View) r1
            y.m r2 = new y.m
            r2.<init>(r5, r0, r4)
            android.view.ViewParent r5 = r1.getParent()
            if (r5 == 0) goto L34
            boolean r5 = r5.isLayoutRequested()
            if (r5 == 0) goto L34
            java.util.WeakHashMap r5 = h0.z0.f3233a
            boolean r5 = r1.isAttachedToWindow()
            if (r5 == 0) goto L34
            goto L35
        L34:
            r0 = 0
        L35:
            if (r0 == 0) goto L3b
            r1.post(r2)
            goto L42
        L3b:
            r2.run()
            goto L42
        L3f:
            r4.x(r5)
        L42:
            return
        L43:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "STATE_"
            r2.<init>(r3)
            if (r5 != r0) goto L51
            java.lang.String r5 = "DRAGGING"
            goto L53
        L51:
            java.lang.String r5 = "SETTLING"
        L53:
            java.lang.String r0 = " should not be set externally."
            java.lang.String r5 = androidx.appcompat.widget.b0.i(r2, r5, r0)
            r1.<init>(r5)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.w(int):void");
    }

    public final void x(int i5) {
        View view;
        if (this.f2179h == i5) {
            return;
        }
        this.f2179h = i5;
        WeakReference weakReference = this.f2186p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i6 = this.f2179h == 5 ? 4 : 0;
        if (view.getVisibility() != i6) {
            view.setVisibility(i6);
        }
        Iterator it = this.f2192v.iterator();
        if (it.hasNext()) {
            b0.n(it.next());
            throw null;
        } else {
            z();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        if (r1.q(r0, r4.getTop()) != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
        if (r4 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
        r2 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(android.view.View r4, int r5, boolean r6) {
        /*
            r3 = this;
            r0 = 3
            if (r5 == r0) goto L19
            r0 = 5
            if (r5 != r0) goto Ld
            q3.a r0 = r3.f2172a
            int r0 = r0.g0()
            goto L1f
        Ld:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Invalid state to get outer edge offset: "
            java.lang.String r5 = androidx.appcompat.widget.b0.f(r6, r5)
            r4.<init>(r5)
            throw r4
        L19:
            q3.a r0 = r3.f2172a
            int r0 = r0.f0()
        L1f:
            q0.d r1 = r3.f2180i
            r2 = 0
            if (r1 == 0) goto L4e
            if (r6 == 0) goto L31
            int r4 = r4.getTop()
            boolean r4 = r1.q(r0, r4)
            if (r4 == 0) goto L4e
            goto L4d
        L31:
            int r6 = r4.getTop()
            r1.f4450r = r4
            r4 = -1
            r1.f4436c = r4
            boolean r4 = r1.i(r0, r6, r2, r2)
            if (r4 != 0) goto L4b
            int r6 = r1.f4434a
            if (r6 != 0) goto L4b
            android.view.View r6 = r1.f4450r
            if (r6 == 0) goto L4b
            r6 = 0
            r1.f4450r = r6
        L4b:
            if (r4 == 0) goto L4e
        L4d:
            r2 = 1
        L4e:
            if (r2 == 0) goto L5a
            r4 = 2
            r3.x(r4)
            h1.e r4 = r3.f2176e
            r4.a(r5)
            goto L5d
        L5a:
            r3.x(r5)
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.y(android.view.View, int, boolean):void");
    }

    public final void z() {
        View view;
        WeakReference weakReference = this.f2186p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        z0.k(view, 262144);
        z0.h(view, 0);
        z0.k(view, 1048576);
        z0.h(view, 0);
        if (this.f2179h != 5) {
            z0.l(view, i0.e.f3367j, new q3.b(5, this));
        }
        if (this.f2179h != 3) {
            z0.l(view, i0.e.f3365h, new q3.b(3, this));
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(0);
        this.f2176e = new e(this);
        this.f2178g = true;
        this.f2179h = 5;
        this.f2182k = 0.1f;
        this.f2188r = -1;
        this.f2192v = new LinkedHashSet();
        this.f2193w = new q3.d(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w2.a.f5407w);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f2174c = p2.a.v(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.f2175d = new j(j.b(context, attributeSet, 0, 2131952629));
        }
        if (obtainStyledAttributes.hasValue(5)) {
            int resourceId = obtainStyledAttributes.getResourceId(5, -1);
            this.f2188r = resourceId;
            WeakReference weakReference = this.f2187q;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f2187q = null;
            WeakReference weakReference2 = this.f2186p;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1) {
                    WeakHashMap weakHashMap = z0.f3233a;
                    if (view.isLaidOut()) {
                        view.requestLayout();
                    }
                }
            }
        }
        j jVar = this.f2175d;
        if (jVar != null) {
            g gVar = new g(jVar);
            this.f2173b = gVar;
            gVar.h(context);
            ColorStateList colorStateList = this.f2174c;
            if (colorStateList != null) {
                this.f2173b.j(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.f2173b.setTint(typedValue.data);
            }
        }
        this.f2177f = obtainStyledAttributes.getDimension(2, -1.0f);
        this.f2178g = obtainStyledAttributes.getBoolean(4, true);
        obtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
