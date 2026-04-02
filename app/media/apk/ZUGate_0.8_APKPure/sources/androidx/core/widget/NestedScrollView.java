package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.github.appintro.R;
import com.google.android.gms.internal.play_billing.i0;
import d.l;
import d.u0;
import h0.i;
import h0.o0;
import h0.t;
import h0.v;
import h0.w;
import h0.z0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n0.e;
import n0.h;
import n0.j;
import n0.k;
/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements v {
    public static final float I = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final h J = new h();
    public static final int[] K = {16843130};
    public int A;
    public int B;
    public k C;
    public final w D;
    public final t E;
    public float F;
    public j G;
    public final i H;

    /* renamed from: g  reason: collision with root package name */
    public final float f721g;

    /* renamed from: h  reason: collision with root package name */
    public long f722h;

    /* renamed from: i  reason: collision with root package name */
    public final Rect f723i;

    /* renamed from: j  reason: collision with root package name */
    public OverScroller f724j;

    /* renamed from: k  reason: collision with root package name */
    public final EdgeEffect f725k;

    /* renamed from: l  reason: collision with root package name */
    public final EdgeEffect f726l;

    /* renamed from: m  reason: collision with root package name */
    public int f727m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f728n;
    public boolean o;

    /* renamed from: p  reason: collision with root package name */
    public View f729p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f730q;

    /* renamed from: r  reason: collision with root package name */
    public VelocityTracker f731r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f732s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f733t;

    /* renamed from: u  reason: collision with root package name */
    public int f734u;

    /* renamed from: v  reason: collision with root package name */
    public int f735v;

    /* renamed from: w  reason: collision with root package name */
    public int f736w;

    /* renamed from: x  reason: collision with root package name */
    public int f737x;

    /* renamed from: y  reason: collision with root package name */
    public final int[] f738y;

    /* renamed from: z  reason: collision with root package name */
    public final int[] f739z;

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.nestedScrollViewStyle);
        this.f723i = new Rect();
        this.f728n = true;
        this.o = false;
        this.f729p = null;
        this.f730q = false;
        this.f733t = true;
        this.f737x = -1;
        this.f738y = new int[2];
        this.f739z = new int[2];
        this.H = new i(getContext(), new u0(20, this));
        int i5 = Build.VERSION.SDK_INT;
        this.f725k = i5 >= 31 ? e.a(context, attributeSet) : new EdgeEffect(context);
        this.f726l = i5 >= 31 ? e.a(context, attributeSet) : new EdgeEffect(context);
        this.f721g = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f724j = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f734u = viewConfiguration.getScaledTouchSlop();
        this.f735v = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f736w = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, K, R.attr.nestedScrollViewStyle, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.D = new w();
        this.E = new t(this);
        setNestedScrollingEnabled(true);
        z0.n(this, J);
    }

    public static boolean l(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && l((View) parent, view2);
    }

    @Override // h0.u
    public final void a(View view, View view2, int i5, int i6) {
        w wVar = this.D;
        if (i6 == 1) {
            wVar.f3220b = i5;
        } else {
            wVar.f3219a = i5;
        }
        v(2, i6);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // h0.u
    public final void b(View view, int i5) {
        w wVar = this.D;
        if (i5 == 1) {
            wVar.f3220b = 0;
        } else {
            wVar.f3219a = 0;
        }
        x(i5);
    }

    @Override // h0.u
    public final void c(View view, int i5, int i6, int[] iArr, int i7) {
        this.E.c(i5, i6, iArr, null, i7);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void computeScroll() {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.computeScroll():void");
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    @Override // h0.v
    public final void d(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        n(i8, i9, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || i(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f5, float f6, boolean z4) {
        return this.E.a(f5, f6, z4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f5, float f6) {
        return this.E.b(f5, f6);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i5, int i6, int[] iArr, int[] iArr2) {
        return this.E.c(i5, i6, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i5, int i6, int i7, int i8, int[] iArr) {
        return this.E.e(i5, i6, i7, i8, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i5;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.f725k;
        int i6 = 0;
        if (!edgeEffect.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (n0.i.a(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                i5 = getPaddingLeft() + 0;
            } else {
                i5 = 0;
            }
            if (n0.i.a(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                min += getPaddingTop();
            }
            canvas.translate(i5, min);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect2 = this.f726l;
        if (edgeEffect2.isFinished()) {
            return;
        }
        int save2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int max = Math.max(getScrollRange(), scrollY) + height2;
        if (n0.i.a(this)) {
            width2 -= getPaddingRight() + getPaddingLeft();
            i6 = 0 + getPaddingLeft();
        }
        if (n0.i.a(this)) {
            height2 -= getPaddingBottom() + getPaddingTop();
            max -= getPaddingBottom();
        }
        canvas.translate(i6 - width2, max);
        canvas.rotate(180.0f, width2, 0.0f);
        edgeEffect2.setSize(width2, height2);
        if (edgeEffect2.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(save2);
    }

    @Override // h0.u
    public final void e(View view, int i5, int i6, int i7, int i8, int i9) {
        n(i8, i9, null);
    }

    @Override // h0.u
    public final boolean f(View view, View view2, int i5, int i6) {
        return (i5 & 2) != 0;
    }

    public final boolean g(int i5) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i5);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m(findNextFocus, maxScrollAmount, getHeight())) {
            if (i5 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i5 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i5 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            s(maxScrollAmount, 0, 1, true);
        } else {
            Rect rect = this.f723i;
            findNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findNextFocus, rect);
            s(h(rect), 0, 1, true);
            findNextFocus.requestFocus(i5);
        }
        if (findFocus != null && findFocus.isFocused() && (!m(findFocus, 0, getHeight()))) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        w wVar = this.D;
        return wVar.f3220b | wVar.f3219a;
    }

    public int getScrollRange() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        }
        return 0;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public float getVerticalScrollFactorCompat() {
        if (this.F == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.F = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.F;
    }

    public final int h(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i6 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i5 - verticalFadingEdgeLength : i5;
        int i7 = rect.bottom;
        if (i7 > i6 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i6) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i5);
        } else if (rect.top >= scrollY || i7 >= i6) {
            return 0;
        } else {
            return Math.max(rect.height() > height ? 0 - (i6 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.E.f(0) != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(android.view.KeyEvent r6) {
        /*
            r5 = this;
            android.graphics.Rect r0 = r5.f723i
            r0.setEmpty()
            int r0 = r5.getChildCount()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L33
            android.view.View r0 = r5.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r3 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r3 = (android.widget.FrameLayout.LayoutParams) r3
            int r0 = r0.getHeight()
            int r4 = r3.topMargin
            int r0 = r0 + r4
            int r3 = r3.bottomMargin
            int r0 = r0 + r3
            int r3 = r5.getHeight()
            int r4 = r5.getPaddingTop()
            int r3 = r3 - r4
            int r4 = r5.getPaddingBottom()
            int r3 = r3 - r4
            if (r0 <= r3) goto L33
            r0 = r1
            goto L34
        L33:
            r0 = r2
        L34:
            r3 = 130(0x82, float:1.82E-43)
            if (r0 != 0) goto L62
            boolean r0 = r5.isFocused()
            if (r0 == 0) goto L61
            int r6 = r6.getKeyCode()
            r0 = 4
            if (r6 == r0) goto L61
            android.view.View r6 = r5.findFocus()
            if (r6 != r5) goto L4c
            r6 = 0
        L4c:
            android.view.FocusFinder r0 = android.view.FocusFinder.getInstance()
            android.view.View r6 = r0.findNextFocus(r5, r6, r3)
            if (r6 == 0) goto L5f
            if (r6 == r5) goto L5f
            boolean r6 = r6.requestFocus(r3)
            if (r6 == 0) goto L5f
            goto L60
        L5f:
            r1 = r2
        L60:
            return r1
        L61:
            return r2
        L62:
            int r0 = r6.getAction()
            if (r0 != 0) goto Lc7
            int r0 = r6.getKeyCode()
            r1 = 19
            r4 = 33
            if (r0 == r1) goto Lb8
            r1 = 20
            if (r0 == r1) goto La8
            r1 = 62
            if (r0 == r1) goto L9d
            r6 = 92
            if (r0 == r6) goto L98
            r6 = 93
            if (r0 == r6) goto L93
            r6 = 122(0x7a, float:1.71E-43)
            if (r0 == r6) goto L8f
            r6 = 123(0x7b, float:1.72E-43)
            if (r0 == r6) goto L8b
            goto Lc7
        L8b:
            r5.q(r3)
            goto Lc7
        L8f:
            r5.q(r4)
            goto Lc7
        L93:
            boolean r2 = r5.k(r3)
            goto Lc7
        L98:
            boolean r2 = r5.k(r4)
            goto Lc7
        L9d:
            boolean r6 = r6.isShiftPressed()
            if (r6 == 0) goto La4
            r3 = r4
        La4:
            r5.q(r3)
            goto Lc7
        La8:
            boolean r6 = r6.isAltPressed()
            if (r6 == 0) goto Lb3
            boolean r2 = r5.k(r3)
            goto Lc7
        Lb3:
            boolean r2 = r5.g(r3)
            goto Lc7
        Lb8:
            boolean r6 = r6.isAltPressed()
            if (r6 == 0) goto Lc3
            boolean r2 = r5.k(r4)
            goto Lc7
        Lc3:
            boolean r2 = r5.g(r4)
        Lc7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.i(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.E.f3208d;
    }

    public final void j(int i5) {
        if (getChildCount() > 0) {
            this.f724j.fling(getScrollX(), getScrollY(), 0, i5, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            v(2, 1);
            this.B = getScrollY();
            postInvalidateOnAnimation();
        }
    }

    public final boolean k(int i5) {
        int childCount;
        boolean z4 = i5 == 130;
        int height = getHeight();
        Rect rect = this.f723i;
        rect.top = 0;
        rect.bottom = height;
        if (z4 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            rect.bottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.top = rect.bottom - height;
        }
        return r(i5, rect.top, rect.bottom);
    }

    public final boolean m(View view, int i5, int i6) {
        Rect rect = this.f723i;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i5 >= getScrollY() && rect.top - i5 <= getScrollY() + i6;
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i5, int i6) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i5, int i6, int i7, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final void n(int i5, int i6, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i5);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.E.d(scrollY2, i5 - scrollY2, i6, iArr);
    }

    public final void o(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f737x) {
            int i5 = actionIndex == 0 ? 1 : 0;
            this.f727m = (int) motionEvent.getY(i5);
            this.f737x = motionEvent.getPointerId(i5);
            VelocityTracker velocityTracker = this.f731r;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.o = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d8, code lost:
        if (r5 >= 0) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x012f, code lost:
        if (r4 >= 0) goto L135;
     */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02ce  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r29) {
        /*
            Method dump skipped, instructions count: 893
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0102  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int i9;
        super.onLayout(z4, i5, i6, i7, i8);
        int i10 = 0;
        this.f728n = false;
        View view = this.f729p;
        if (view != null && l(view, this)) {
            View view2 = this.f729p;
            Rect rect = this.f723i;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int h5 = h(rect);
            if (h5 != 0) {
                scrollBy(0, h5);
            }
        }
        this.f729p = null;
        if (!this.o) {
            if (this.C != null) {
                scrollTo(getScrollX(), this.C.f4071b);
                this.C = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i9 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                i9 = 0;
            }
            int paddingTop = ((i8 - i6) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < i9 && scrollY >= 0) {
                i10 = paddingTop + scrollY > i9 ? i9 - paddingTop : scrollY;
            }
            if (i10 != scrollY) {
                scrollTo(getScrollX(), i10);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.o = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.f732s && View.MeasureSpec.getMode(i6) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f5, float f6, boolean z4) {
        if (z4) {
            return false;
        }
        dispatchNestedFling(0.0f, f6, true);
        j((int) f6);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f5, float f6) {
        return dispatchNestedPreFling(f5, f6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
        c(view, i5, i6, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i5, int i6, int i7, int i8) {
        n(i8, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i5) {
        a(view, view2, i5, 0);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i5, int i6, boolean z4, boolean z5) {
        super.scrollTo(i5, i6);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i5, Rect rect) {
        if (i5 == 2) {
            i5 = 130;
        } else if (i5 == 1) {
            i5 = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i5) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i5);
        if (findNextFocus == null || (true ^ m(findNextFocus, 0, getHeight()))) {
            return false;
        }
        return findNextFocus.requestFocus(i5, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof k)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        k kVar = (k) parcelable;
        super.onRestoreInstanceState(kVar.getSuperState());
        this.C = kVar;
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        k kVar = new k(super.onSaveInstanceState());
        kVar.f4071b = getScrollY();
        return kVar;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i5, int i6, int i7, int i8) {
        super.onScrollChanged(i5, i6, i7, i8);
        j jVar = this.G;
        if (jVar != null) {
            d.e eVar = (d.e) jVar;
            l.c(this, (View) eVar.f2321h, (View) eVar.f2322i);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !m(findFocus, 0, i8)) {
            return;
        }
        Rect rect = this.f723i;
        findFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(findFocus, rect);
        int h5 = h(rect);
        if (h5 != 0) {
            if (this.f733t) {
                u(0, h5, false);
            } else {
                scrollBy(0, h5);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i5) {
        return f(view, view2, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        b(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a3  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r20) {
        /*
            Method dump skipped, instructions count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(int r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            int r0 = r9.getOverScrollMode()
            r9.computeHorizontalScrollRange()
            r9.computeHorizontalScrollExtent()
            r9.computeVerticalScrollRange()
            r9.computeVerticalScrollExtent()
            r1 = 1
            r0 = 0
            int r11 = r11 + r0
            int r12 = r12 + r10
            int r13 = r13 + r0
            if (r11 <= 0) goto L1a
        L17:
            r11 = r0
            r10 = r1
            goto L1e
        L1a:
            if (r11 >= 0) goto L1d
            goto L17
        L1d:
            r10 = r0
        L1e:
            if (r12 <= r13) goto L23
            r12 = r13
        L21:
            r13 = r1
            goto L28
        L23:
            if (r12 >= 0) goto L27
            r12 = r0
            goto L21
        L27:
            r13 = r0
        L28:
            if (r13 == 0) goto L45
            h0.t r2 = r9.E
            android.view.ViewParent r2 = r2.f(r1)
            if (r2 == 0) goto L34
            r2 = r1
            goto L35
        L34:
            r2 = r0
        L35:
            if (r2 != 0) goto L45
            android.widget.OverScroller r2 = r9.f724j
            r5 = 0
            r6 = 0
            r7 = 0
            int r8 = r9.getScrollRange()
            r3 = r11
            r4 = r12
            r2.springBack(r3, r4, r5, r6, r7, r8)
        L45:
            r9.onOverScrolled(r11, r12, r10, r13)
            if (r10 != 0) goto L4e
            if (r13 == 0) goto L4d
            goto L4e
        L4d:
            r1 = r0
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.p(int, int, int, int):boolean");
    }

    public final void q(int i5) {
        boolean z4 = i5 == 130;
        int height = getHeight();
        Rect rect = this.f723i;
        if (z4) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            int scrollY = getScrollY() - height;
            rect.top = scrollY;
            if (scrollY < 0) {
                rect.top = 0;
            }
        }
        int i6 = rect.top;
        int i7 = height + i6;
        rect.bottom = i7;
        r(i5, i6, i7);
    }

    public final boolean r(int i5, int i6, int i7) {
        boolean z4;
        int height = getHeight();
        int scrollY = getScrollY();
        int i8 = height + scrollY;
        boolean z5 = i5 == 33;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z6 = false;
        for (int i9 = 0; i9 < size; i9++) {
            View view2 = focusables.get(i9);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i6 < bottom && top < i7) {
                boolean z7 = i6 < top && bottom < i7;
                if (view == null) {
                    view = view2;
                    z6 = z7;
                } else {
                    boolean z8 = (z5 && top < view.getTop()) || (!z5 && bottom > view.getBottom());
                    if (z6) {
                        if (z7) {
                            if (!z8) {
                            }
                            view = view2;
                        }
                    } else if (z7) {
                        view = view2;
                        z6 = true;
                    } else {
                        if (!z8) {
                        }
                        view = view2;
                    }
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i6 < scrollY || i7 > i8) {
            s(z5 ? i6 - scrollY : i7 - i8, 0, 1, true);
            z4 = true;
        } else {
            z4 = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i5);
        }
        return z4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (this.f728n) {
            this.f729p = view2;
        } else {
            Rect rect = this.f723i;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int h5 = h(rect);
            if (h5 != 0) {
                scrollBy(0, h5);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int h5 = h(rect);
        boolean z5 = h5 != 0;
        if (z5) {
            if (z4) {
                scrollBy(0, h5);
            } else {
                u(0, h5, false);
            }
        }
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
        VelocityTracker velocityTracker;
        if (z4 && (velocityTracker = this.f731r) != null) {
            velocityTracker.recycle();
            this.f731r = null;
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f728n = true;
        super.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int s(int r21, int r22, int r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.s(int, int, int, boolean):int");
    }

    @Override // android.view.View
    public final void scrollTo(int i5, int i6) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i5 < 0) {
                i5 = 0;
            } else if (width + i5 > width2) {
                i5 = width2 - width;
            }
            if (height >= height2 || i6 < 0) {
                i6 = 0;
            } else if (height + i6 > height2) {
                i6 = height2 - height;
            }
            if (i5 == getScrollX() && i6 == getScrollY()) {
                return;
            }
            super.scrollTo(i5, i6);
        }
    }

    public void setFillViewport(boolean z4) {
        if (z4 != this.f732s) {
            this.f732s = z4;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z4) {
        t tVar = this.E;
        if (tVar.f3208d) {
            WeakHashMap weakHashMap = z0.f3233a;
            o0.z(tVar.f3207c);
        }
        tVar.f3208d = z4;
    }

    public void setOnScrollChangeListener(j jVar) {
        this.G = jVar;
    }

    public void setSmoothScrollingEnabled(boolean z4) {
        this.f733t = z4;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i5) {
        return v(i5, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        x(0);
    }

    public final boolean t(EdgeEffect edgeEffect, int i5) {
        if (i5 > 0) {
            return true;
        }
        float y5 = i0.y(edgeEffect) * getHeight();
        float f5 = this.f721g * 0.015f;
        double log = Math.log((Math.abs(-i5) * 0.35f) / f5);
        double d5 = I;
        return ((float) (Math.exp((d5 / (d5 - 1.0d)) * log) * ((double) f5))) < y5;
    }

    public final void u(int i5, int i6, boolean z4) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f722h > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            OverScroller overScroller = this.f724j;
            int scrollX = getScrollX();
            overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i6 + scrollY, Math.max(0, height - height2))) - scrollY, 250);
            if (z4) {
                v(2, 1);
            } else {
                x(1);
            }
            this.B = getScrollY();
            postInvalidateOnAnimation();
        } else {
            if (!this.f724j.isFinished()) {
                this.f724j.abortAnimation();
                x(1);
            }
            scrollBy(i5, i6);
        }
        this.f722h = AnimationUtils.currentAnimationTimeMillis();
    }

    public final boolean v(int i5, int i6) {
        return this.E.g(i5, i6);
    }

    public final boolean w(MotionEvent motionEvent) {
        boolean z4;
        EdgeEffect edgeEffect = this.f725k;
        if (i0.y(edgeEffect) != 0.0f) {
            i0.J(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z4 = true;
        } else {
            z4 = false;
        }
        EdgeEffect edgeEffect2 = this.f726l;
        if (i0.y(edgeEffect2) != 0.0f) {
            i0.J(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
            return true;
        }
        return z4;
    }

    public final void x(int i5) {
        this.E.h(i5);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i5) {
        if (getChildCount() <= 0) {
            super.addView(view, i5);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i5, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
