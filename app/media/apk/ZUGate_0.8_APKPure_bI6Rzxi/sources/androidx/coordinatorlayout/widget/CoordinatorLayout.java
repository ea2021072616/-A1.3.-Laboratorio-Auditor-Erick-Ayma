package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.github.appintro.R;
import d.u0;
import g.f;
import g0.b;
import h0.h2;
import h0.m0;
import h0.o0;
import h0.u;
import h0.v;
import h0.w;
import h0.z0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import l.j;
import t.a;
import u.c;
import u.d;
import u.e;
import u.g;
import u.h;
/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements u, v {
    public static final Class[] A;
    public static final ThreadLocal B;
    public static final g C;
    public static final b D;

    /* renamed from: z  reason: collision with root package name */
    public static final String f685z;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f686g;

    /* renamed from: h  reason: collision with root package name */
    public final f f687h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f688i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList f689j;

    /* renamed from: k  reason: collision with root package name */
    public final int[] f690k;

    /* renamed from: l  reason: collision with root package name */
    public final int[] f691l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f692m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f693n;
    public final int[] o;

    /* renamed from: p  reason: collision with root package name */
    public View f694p;

    /* renamed from: q  reason: collision with root package name */
    public View f695q;

    /* renamed from: r  reason: collision with root package name */
    public e f696r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f697s;

    /* renamed from: t  reason: collision with root package name */
    public h2 f698t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f699u;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f700v;

    /* renamed from: w  reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f701w;

    /* renamed from: x  reason: collision with root package name */
    public u0 f702x;

    /* renamed from: y  reason: collision with root package name */
    public final w f703y;

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f685z = r02 != null ? r02.getName() : null;
        C = new g(0);
        A = new Class[]{Context.class, AttributeSet.class};
        B = new ThreadLocal();
        D = new b();
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.coordinatorLayoutStyle);
        this.f686g = new ArrayList();
        this.f687h = new f(3);
        this.f688i = new ArrayList();
        this.f689j = new ArrayList();
        this.f690k = new int[2];
        this.f691l = new int[2];
        this.f703y = new w();
        int[] iArr = a.f4977a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.coordinatorLayoutStyle, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, R.attr.coordinatorLayoutStyle, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.o = intArray;
            float f5 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i5 = 0; i5 < length; i5++) {
                int[] iArr2 = this.o;
                iArr2[i5] = (int) (iArr2[i5] * f5);
            }
        }
        this.f700v = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        w();
        super.setOnHierarchyChangeListener(new c(this));
        WeakHashMap weakHashMap = z0.f3233a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static Rect g() {
        Rect rect = (Rect) D.a();
        return rect == null ? new Rect() : rect;
    }

    public static void l(int i5, Rect rect, Rect rect2, d dVar, int i6, int i7) {
        int i8 = dVar.f5098c;
        if (i8 == 0) {
            i8 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i8, i5);
        int i9 = dVar.f5099d;
        if ((i9 & 7) == 0) {
            i9 |= 8388611;
        }
        if ((i9 & 112) == 0) {
            i9 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i9, i5);
        int i10 = absoluteGravity & 7;
        int i11 = absoluteGravity & 112;
        int i12 = absoluteGravity2 & 7;
        int i13 = absoluteGravity2 & 112;
        int width = i12 != 1 ? i12 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i13 != 16 ? i13 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i10 == 1) {
            width -= i6 / 2;
        } else if (i10 != 5) {
            width -= i6;
        }
        if (i11 == 16) {
            height -= i7 / 2;
        } else if (i11 != 80) {
            height -= i7;
        }
        rect2.set(width, height, i6 + width, i7 + height);
    }

    public static d n(View view) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.f5097b) {
            u.b bVar = null;
            for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                bVar = (u.b) cls.getAnnotation(u.b.class);
                if (bVar != null) {
                    break;
                }
            }
            if (bVar != null) {
                try {
                    u.a aVar = (u.a) bVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    u.a aVar2 = dVar.f5096a;
                    if (aVar2 != aVar) {
                        if (aVar2 != null) {
                            aVar2.i();
                        }
                        dVar.f5096a = aVar;
                        dVar.f5097b = true;
                        if (aVar != null) {
                            aVar.g(dVar);
                        }
                    }
                } catch (Exception e5) {
                    Log.e("CoordinatorLayout", "Default behavior class " + bVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e5);
                }
            }
            dVar.f5097b = true;
        }
        return dVar;
    }

    public static void u(View view, int i5) {
        d dVar = (d) view.getLayoutParams();
        int i6 = dVar.f5104i;
        if (i6 != i5) {
            WeakHashMap weakHashMap = z0.f3233a;
            view.offsetLeftAndRight(i5 - i6);
            dVar.f5104i = i5;
        }
    }

    public static void v(View view, int i5) {
        d dVar = (d) view.getLayoutParams();
        int i6 = dVar.f5105j;
        if (i6 != i5) {
            WeakHashMap weakHashMap = z0.f3233a;
            view.offsetTopAndBottom(i5 - i6);
            dVar.f5105j = i5;
        }
    }

    @Override // h0.u
    public final void a(View view, View view2, int i5, int i6) {
        w wVar = this.f703y;
        if (i6 == 1) {
            wVar.f3220b = i5;
        } else {
            wVar.f3219a = i5;
        }
        this.f695q = view2;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            ((d) getChildAt(i7).getLayoutParams()).getClass();
        }
    }

    @Override // h0.u
    public final void b(View view, int i5) {
        w wVar = this.f703y;
        if (i5 == 1) {
            wVar.f3220b = 0;
        } else {
            wVar.f3219a = 0;
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.a(i5)) {
                u.a aVar = dVar.f5096a;
                if (aVar != null) {
                    aVar.t(childAt, view, i5);
                }
                if (i5 == 0) {
                    dVar.f5109n = false;
                } else if (i5 == 1) {
                    dVar.o = false;
                }
                dVar.getClass();
            }
        }
        this.f695q = null;
    }

    @Override // h0.u
    public final void c(View view, int i5, int i6, int[] iArr, int i7) {
        u.a aVar;
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        boolean z4 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(i7) && (aVar = dVar.f5096a) != null) {
                    int[] iArr2 = this.f690k;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    aVar.n(childAt, view, i6, iArr2, i7);
                    i8 = i5 > 0 ? Math.max(i8, iArr2[0]) : Math.min(i8, iArr2[0]);
                    i9 = i6 > 0 ? Math.max(i9, iArr2[1]) : Math.min(i9, iArr2[1]);
                    z4 = true;
                }
            }
        }
        iArr[0] = i8;
        iArr[1] = i9;
        if (z4) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    @Override // h0.v
    public final void d(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        u.a aVar;
        int childCount = getChildCount();
        boolean z4 = false;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(i9) && (aVar = dVar.f5096a) != null) {
                    int[] iArr2 = this.f690k;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    aVar.o(this, childAt, i6, i7, i8, iArr2);
                    i10 = i7 > 0 ? Math.max(i10, iArr2[0]) : Math.min(i10, iArr2[0]);
                    i11 = i8 > 0 ? Math.max(i11, iArr2[1]) : Math.min(i11, iArr2[1]);
                    z4 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i10;
        iArr[1] = iArr[1] + i11;
        if (z4) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j5) {
        u.a aVar = ((d) view.getLayoutParams()).f5096a;
        if (aVar != null) {
            aVar.getClass();
        }
        return super.drawChild(canvas, view, j5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f700v;
        boolean z4 = false;
        if (drawable != null && drawable.isStateful()) {
            z4 = false | drawable.setState(drawableState);
        }
        if (z4) {
            invalidate();
        }
    }

    @Override // h0.u
    public final void e(View view, int i5, int i6, int i7, int i8, int i9) {
        d(view, i5, i6, i7, i8, 0, this.f691l);
    }

    @Override // h0.u
    public final boolean f(View view, View view2, int i5, int i6) {
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                u.a aVar = dVar.f5096a;
                if (aVar != null) {
                    boolean s5 = aVar.s(childAt, i5, i6);
                    z4 |= s5;
                    if (i6 == 0) {
                        dVar.f5109n = s5;
                    } else if (i6 == 1) {
                        dVar.o = s5;
                    }
                } else if (i6 == 0) {
                    dVar.f5109n = false;
                } else if (i6 == 1) {
                    dVar.o = false;
                }
            }
        }
        return z4;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        s();
        return Collections.unmodifiableList(this.f686g);
    }

    public final h2 getLastWindowInsets() {
        return this.f698t;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        w wVar = this.f703y;
        return wVar.f3220b | wVar.f3219a;
    }

    public Drawable getStatusBarBackground() {
        return this.f700v;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final void h(d dVar, Rect rect, int i5, int i6) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i5) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i6) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin));
        rect.set(max, max2, i5 + max, i6 + max2);
    }

    public final void i(View view, Rect rect, boolean z4) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z4) {
            k(rect, view);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList j(View view) {
        f fVar = this.f687h;
        int i5 = ((j) fVar.f2880d).f3705d;
        ArrayList arrayList = null;
        for (int i6 = 0; i6 < i5; i6++) {
            ArrayList arrayList2 = (ArrayList) ((j) fVar.f2880d).j(i6);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(((j) fVar.f2880d).h(i6));
            }
        }
        ArrayList arrayList3 = this.f689j;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public final void k(Rect rect, View view) {
        ThreadLocal threadLocal = h.f5114a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = h.f5114a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        h.a(this, view, matrix);
        ThreadLocal threadLocal3 = h.f5115b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int m(int i5) {
        int[] iArr = this.o;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i5);
            return 0;
        } else if (i5 < 0 || i5 >= iArr.length) {
            Log.e("CoordinatorLayout", "Keyline index " + i5 + " out of range for " + this);
            return 0;
        } else {
            return iArr[i5];
        }
    }

    public final boolean o(View view, int i5, int i6) {
        b bVar = D;
        Rect g5 = g();
        k(g5, view);
        try {
            return g5.contains(i5, i6);
        } finally {
            g5.setEmpty();
            bVar.b(g5);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        t(false);
        if (this.f697s) {
            if (this.f696r == null) {
                this.f696r = new e(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f696r);
        }
        if (this.f698t == null) {
            WeakHashMap weakHashMap = z0.f3233a;
            if (getFitsSystemWindows()) {
                m0.c(this);
            }
        }
        this.f693n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        t(false);
        if (this.f697s && this.f696r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f696r);
        }
        View view = this.f695q;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f693n = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f699u || this.f700v == null) {
            return;
        }
        h2 h2Var = this.f698t;
        int e5 = h2Var != null ? h2Var.e() : 0;
        if (e5 > 0) {
            this.f700v.setBounds(0, 0, getWidth(), e5);
            this.f700v.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            t(true);
        }
        boolean r5 = r(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            t(true);
        }
        return r5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        u.a aVar;
        WeakHashMap weakHashMap = z0.f3233a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.f686g;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            View view = (View) arrayList.get(i9);
            if (view.getVisibility() != 8 && ((aVar = ((d) view.getLayoutParams()).f5096a) == null || !aVar.k(this, view, layoutDirection))) {
                q(view, layoutDirection);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0197, code lost:
        if (r0.l(r32, r19, r25, r20, r26) == false) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r33, int r34) {
        /*
            Method dump skipped, instructions count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f5, float f6, boolean z4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(0)) {
                    u.a aVar = dVar.f5096a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f5, float f6) {
        u.a aVar;
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(0) && (aVar = dVar.f5096a) != null) {
                    z4 |= aVar.m(view);
                }
            }
        }
        return z4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
        c(view, i5, i6, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i5, int i6, int i7, int i8) {
        e(view, i5, i6, i7, i8, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i5) {
        a(view, view2, i5, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof u.f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        u.f fVar = (u.f) parcelable;
        super.onRestoreInstanceState(fVar.f4245b);
        SparseArray sparseArray = fVar.f5112d;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int id = childAt.getId();
            u.a aVar = n(childAt).f5096a;
            if (id != -1 && aVar != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                aVar.q(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable r5;
        u.f fVar = new u.f(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int id = childAt.getId();
            u.a aVar = ((d) childAt.getLayoutParams()).f5096a;
            if (id != -1 && aVar != null && (r5 = aVar.r(childAt)) != null) {
                sparseArray.append(id, r5);
            }
        }
        fVar.f5112d = sparseArray;
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i5) {
        return f(view, view2, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        b(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f694p
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.r(r1, r4)
            if (r3 == 0) goto L29
            goto L16
        L15:
            r3 = r5
        L16:
            android.view.View r6 = r0.f694p
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            u.d r6 = (u.d) r6
            u.a r6 = r6.f5096a
            if (r6 == 0) goto L29
            android.view.View r7 = r0.f694p
            boolean r6 = r6.u(r7, r1)
            goto L2a
        L29:
            r6 = r5
        L2a:
            android.view.View r7 = r0.f694p
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L52
            r1 = 3
            if (r2 != r1) goto L55
        L52:
            r0.t(r5)
        L55:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02c1 A[EDGE_INSN: B:130:0x02c1->B:119:0x02c1 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(int r25) {
        /*
            Method dump skipped, instructions count: 732
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.p(int):void");
    }

    public final void q(View view, int i5) {
        Rect g5;
        Rect g6;
        d dVar = (d) view.getLayoutParams();
        View view2 = dVar.f5106k;
        int i6 = 0;
        if (view2 == null && dVar.f5101f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        b bVar = D;
        if (view2 != null) {
            g5 = g();
            g6 = g();
            try {
                k(g5, view2);
                d dVar2 = (d) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                l(i5, g5, g6, dVar2, measuredWidth, measuredHeight);
                h(dVar2, g6, measuredWidth, measuredHeight);
                view.layout(g6.left, g6.top, g6.right, g6.bottom);
                return;
            } finally {
                g5.setEmpty();
                bVar.b(g5);
                g6.setEmpty();
                bVar.b(g6);
            }
        }
        int i7 = dVar.f5100e;
        if (i7 < 0) {
            d dVar3 = (d) view.getLayoutParams();
            g5 = g();
            g5.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) dVar3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) dVar3).bottomMargin);
            if (this.f698t != null) {
                WeakHashMap weakHashMap = z0.f3233a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    g5.left = this.f698t.c() + g5.left;
                    g5.top = this.f698t.e() + g5.top;
                    g5.right -= this.f698t.d();
                    g5.bottom -= this.f698t.b();
                }
            }
            g6 = g();
            int i8 = dVar3.f5098c;
            if ((i8 & 7) == 0) {
                i8 |= 8388611;
            }
            if ((i8 & 112) == 0) {
                i8 |= 48;
            }
            Gravity.apply(i8, view.getMeasuredWidth(), view.getMeasuredHeight(), g5, g6, i5);
            view.layout(g6.left, g6.top, g6.right, g6.bottom);
            return;
        }
        d dVar4 = (d) view.getLayoutParams();
        int i9 = dVar4.f5098c;
        if (i9 == 0) {
            i9 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i9, i5);
        int i10 = absoluteGravity & 7;
        int i11 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i5 == 1) {
            i7 = width - i7;
        }
        int m5 = m(i7) - measuredWidth2;
        if (i10 == 1) {
            m5 += measuredWidth2 / 2;
        } else if (i10 == 5) {
            m5 += measuredWidth2;
        }
        if (i11 == 16) {
            i6 = 0 + (measuredHeight2 / 2);
        } else if (i11 == 80) {
            i6 = measuredHeight2 + 0;
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar4).leftMargin, Math.min(m5, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) dVar4).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar4).topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) dVar4).bottomMargin));
        view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
    }

    public final boolean r(MotionEvent motionEvent, int i5) {
        boolean z4;
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f688i;
        arrayList.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i6 = childCount - 1; i6 >= 0; i6--) {
            arrayList.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i6) : i6));
        }
        g gVar = C;
        if (gVar != null) {
            Collections.sort(arrayList, gVar);
        }
        int size = arrayList.size();
        MotionEvent motionEvent2 = null;
        boolean z5 = false;
        boolean z6 = false;
        for (int i7 = 0; i7 < size; i7++) {
            View view = (View) arrayList.get(i7);
            d dVar = (d) view.getLayoutParams();
            u.a aVar = dVar.f5096a;
            if (!(z5 || z6) || actionMasked == 0) {
                if (!z5 && aVar != null) {
                    if (i5 == 0) {
                        z5 = aVar.j(this, view, motionEvent);
                    } else if (i5 == 1) {
                        z5 = aVar.u(view, motionEvent);
                    }
                    if (z5) {
                        this.f694p = view;
                    }
                }
                if (dVar.f5096a == null) {
                    dVar.f5108m = false;
                }
                boolean z7 = dVar.f5108m;
                if (z7) {
                    z4 = true;
                } else {
                    z4 = z7 | false;
                    dVar.f5108m = z4;
                }
                z6 = z4 && !z7;
                if (z4 && !z6) {
                    break;
                }
            } else if (aVar != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i5 == 0) {
                    aVar.j(this, view, motionEvent2);
                } else if (i5 == 1) {
                    aVar.u(view, motionEvent2);
                }
            }
        }
        arrayList.clear();
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        u.a aVar = ((d) view.getLayoutParams()).f5096a;
        if (aVar != null) {
            aVar.p(this, view);
        }
        return super.requestChildRectangleOnScreen(view, rect, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
        super.requestDisallowInterceptTouchEvent(z4);
        if (!z4 || this.f692m) {
            return;
        }
        t(false);
        this.f692m = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
        if (r9 != false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x017c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instructions count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.s():void");
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z4) {
        super.setFitsSystemWindows(z4);
        w();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f701w = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f700v;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f700v = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.f700v.setState(getDrawableState());
                }
                Drawable drawable3 = this.f700v;
                WeakHashMap weakHashMap = z0.f3233a;
                a0.b.b(drawable3, getLayoutDirection());
                this.f700v.setVisible(getVisibility() == 0, false);
                this.f700v.setCallback(this);
            }
            WeakHashMap weakHashMap2 = z0.f3233a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i5) {
        setStatusBarBackground(new ColorDrawable(i5));
    }

    public void setStatusBarBackgroundResource(int i5) {
        setStatusBarBackground(i5 != 0 ? x.a.b(getContext(), i5) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
        boolean z4 = i5 == 0;
        Drawable drawable = this.f700v;
        if (drawable == null || drawable.isVisible() == z4) {
            return;
        }
        this.f700v.setVisible(z4, false);
    }

    public final void t(boolean z4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            u.a aVar = ((d) childAt.getLayoutParams()).f5096a;
            if (aVar != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z4) {
                    aVar.j(this, childAt, obtain);
                } else {
                    aVar.u(childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            ((d) getChildAt(i6).getLayoutParams()).f5108m = false;
        }
        this.f694p = null;
        this.f692m = false;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f700v;
    }

    public final void w() {
        WeakHashMap weakHashMap = z0.f3233a;
        if (!getFitsSystemWindows()) {
            o0.u(this, null);
            return;
        }
        if (this.f702x == null) {
            this.f702x = new u0(10, this);
        }
        o0.u(this, this.f702x);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof d) {
            return new d((d) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new d((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new d(layoutParams);
    }
}
