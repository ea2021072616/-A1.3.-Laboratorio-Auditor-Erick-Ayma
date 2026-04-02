package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.github.appintro.R;
import java.util.WeakHashMap;
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements r1, h0.u, h0.v {
    public static final int[] I = {R.attr.actionBarSize, 16842841};
    public static final h0.h2 J;
    public static final Rect K;
    public f A;
    public OverScroller B;
    public ViewPropertyAnimator C;
    public final d D;
    public final e E;
    public final e F;
    public final h0.w G;
    public final h H;

    /* renamed from: g  reason: collision with root package name */
    public int f184g;

    /* renamed from: h  reason: collision with root package name */
    public int f185h;

    /* renamed from: i  reason: collision with root package name */
    public ContentFrameLayout f186i;

    /* renamed from: j  reason: collision with root package name */
    public ActionBarContainer f187j;

    /* renamed from: k  reason: collision with root package name */
    public s1 f188k;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f189l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f190m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f191n;
    public boolean o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f192p;

    /* renamed from: q  reason: collision with root package name */
    public int f193q;

    /* renamed from: r  reason: collision with root package name */
    public int f194r;

    /* renamed from: s  reason: collision with root package name */
    public final Rect f195s;

    /* renamed from: t  reason: collision with root package name */
    public final Rect f196t;

    /* renamed from: u  reason: collision with root package name */
    public final Rect f197u;

    /* renamed from: v  reason: collision with root package name */
    public final Rect f198v;

    /* renamed from: w  reason: collision with root package name */
    public h0.h2 f199w;

    /* renamed from: x  reason: collision with root package name */
    public h0.h2 f200x;

    /* renamed from: y  reason: collision with root package name */
    public h0.h2 f201y;

    /* renamed from: z  reason: collision with root package name */
    public h0.h2 f202z;

    static {
        int i5 = Build.VERSION.SDK_INT;
        h0.z1 y1Var = i5 >= 30 ? new h0.y1() : i5 >= 29 ? new h0.x1() : new h0.w1();
        y1Var.g(z.c.b(0, 1, 0, 1));
        J = y1Var.b();
        K = new Rect();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f185h = 0;
        this.f195s = new Rect();
        this.f196t = new Rect();
        this.f197u = new Rect();
        this.f198v = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        h0.h2 h2Var = h0.h2.f3143b;
        this.f199w = h2Var;
        this.f200x = h2Var;
        this.f201y = h2Var;
        this.f202z = h2Var;
        this.D = new d(0, this);
        this.E = new e(this, 0);
        this.F = new e(this, 1);
        i(context);
        this.G = new h0.w();
        h hVar = new h(context);
        this.H = hVar;
        addView(hVar);
    }

    public static boolean g(FrameLayout frameLayout, Rect rect, boolean z4) {
        boolean z5;
        g gVar = (g) frameLayout.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin;
        int i6 = rect.left;
        if (i5 != i6) {
            ((ViewGroup.MarginLayoutParams) gVar).leftMargin = i6;
            z5 = true;
        } else {
            z5 = false;
        }
        int i7 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        int i8 = rect.top;
        if (i7 != i8) {
            ((ViewGroup.MarginLayoutParams) gVar).topMargin = i8;
            z5 = true;
        }
        int i9 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
        int i10 = rect.right;
        if (i9 != i10) {
            ((ViewGroup.MarginLayoutParams) gVar).rightMargin = i10;
            z5 = true;
        }
        if (z4) {
            int i11 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
            int i12 = rect.bottom;
            if (i11 != i12) {
                ((ViewGroup.MarginLayoutParams) gVar).bottomMargin = i12;
                return true;
            }
        }
        return z5;
    }

    @Override // h0.u
    public final void a(View view, View view2, int i5, int i6) {
        if (i6 == 0) {
            onNestedScrollAccepted(view, view2, i5);
        }
    }

    @Override // h0.u
    public final void b(View view, int i5) {
        if (i5 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // h0.u
    public final void c(View view, int i5, int i6, int[] iArr, int i7) {
        if (i7 == 0) {
            onNestedPreScroll(view, i5, i6, iArr);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g;
    }

    @Override // h0.v
    public final void d(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        e(view, i5, i6, i7, i8, i9);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i5;
        super.draw(canvas);
        if (this.f189l != null) {
            if (this.f187j.getVisibility() == 0) {
                i5 = (int) (this.f187j.getTranslationY() + this.f187j.getBottom() + 0.5f);
            } else {
                i5 = 0;
            }
            this.f189l.setBounds(0, i5, getWidth(), this.f189l.getIntrinsicHeight() + i5);
            this.f189l.draw(canvas);
        }
    }

    @Override // h0.u
    public final void e(View view, int i5, int i6, int i7, int i8, int i9) {
        if (i9 == 0) {
            onNestedScroll(view, i5, i6, i7, i8);
        }
    }

    @Override // h0.u
    public final boolean f(View view, View view2, int i5, int i6) {
        return i6 == 0 && onStartNestedScroll(view, view2, i5);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f187j;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        h0.w wVar = this.G;
        return wVar.f3220b | wVar.f3219a;
    }

    public CharSequence getTitle() {
        k();
        return ((p3) this.f188k).f486a.getTitle();
    }

    public final void h() {
        removeCallbacks(this.E);
        removeCallbacks(this.F);
        ViewPropertyAnimator viewPropertyAnimator = this.C;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void i(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(I);
        this.f184g = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f189l = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.B = new OverScroller(context);
    }

    public final void j(int i5) {
        k();
        if (i5 == 2) {
            ((p3) this.f188k).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i5 == 5) {
            ((p3) this.f188k).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i5 != 109) {
        } else {
            setOverlayMode(true);
        }
    }

    public final void k() {
        s1 wrapper;
        if (this.f186i == null) {
            this.f186i = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f187j = (ActionBarContainer) findViewById(R.id.action_bar_container);
            View findViewById = findViewById(R.id.action_bar);
            if (findViewById instanceof s1) {
                wrapper = (s1) findViewById;
            } else if (!(findViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById.getClass().getSimpleName()));
            } else {
                wrapper = ((Toolbar) findViewById).getWrapper();
            }
            this.f188k = wrapper;
        }
    }

    public final void l(h.o oVar, d.a0 a0Var) {
        k();
        p3 p3Var = (p3) this.f188k;
        n nVar = p3Var.f498m;
        Toolbar toolbar = p3Var.f486a;
        if (nVar == null) {
            p3Var.f498m = new n(toolbar.getContext());
        }
        n nVar2 = p3Var.f498m;
        nVar2.f418k = a0Var;
        if (oVar == null && toolbar.f249g == null) {
            return;
        }
        toolbar.e();
        h.o oVar2 = toolbar.f249g.f203v;
        if (oVar2 == oVar) {
            return;
        }
        if (oVar2 != null) {
            oVar2.r(toolbar.R);
            oVar2.r(toolbar.S);
        }
        if (toolbar.S == null) {
            toolbar.S = new k3(toolbar);
        }
        nVar2.f429w = true;
        if (oVar != null) {
            oVar.b(nVar2, toolbar.f257p);
            oVar.b(toolbar.S, toolbar.f257p);
        } else {
            nVar2.d(toolbar.f257p, null);
            toolbar.S.d(toolbar.f257p, null);
            nVar2.h();
            toolbar.S.h();
        }
        toolbar.f249g.setPopupTheme(toolbar.f258q);
        toolbar.f249g.setPresenter(nVar2);
        toolbar.R = nVar2;
        toolbar.s();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        k();
        h0.h2 i5 = h0.h2.i(this, windowInsets);
        boolean g5 = g(this.f187j, new Rect(i5.c(), i5.e(), i5.d(), i5.b()), false);
        WeakHashMap weakHashMap = h0.z0.f3233a;
        Rect rect = this.f195s;
        h0.o0.b(this, i5, rect);
        int i6 = rect.left;
        int i7 = rect.top;
        int i8 = rect.right;
        int i9 = rect.bottom;
        h0.f2 f2Var = i5.f3144a;
        h0.h2 l5 = f2Var.l(i6, i7, i8, i9);
        this.f199w = l5;
        boolean z4 = true;
        if (!this.f200x.equals(l5)) {
            this.f200x = this.f199w;
            g5 = true;
        }
        Rect rect2 = this.f196t;
        if (rect2.equals(rect)) {
            z4 = g5;
        } else {
            rect2.set(rect);
        }
        if (z4) {
            requestLayout();
        }
        return f2Var.a().f3144a.c().f3144a.b().h();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(getContext());
        WeakHashMap weakHashMap = h0.z0.f3233a;
        h0.m0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i10 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin + paddingLeft;
                int i11 = ((ViewGroup.MarginLayoutParams) gVar).topMargin + paddingTop;
                childAt.layout(i10, i11, measuredWidth + i10, measuredHeight + i11);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ff  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f5, float f6, boolean z4) {
        if (this.o && z4) {
            this.B.fling(0, 0, 0, (int) f6, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (this.B.getFinalY() > this.f187j.getHeight()) {
                h();
                this.F.run();
            } else {
                h();
                this.E.run();
            }
            this.f192p = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f5, float f6) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i5, int i6, int i7, int i8) {
        int i9 = this.f193q + i6;
        this.f193q = i9;
        setActionBarHideOffset(i9);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i5) {
        d.c1 c1Var;
        g.l lVar;
        this.G.f3219a = i5;
        this.f193q = getActionBarHideOffset();
        h();
        f fVar = this.A;
        if (fVar == null || (lVar = (c1Var = (d.c1) fVar).f2311s) == null) {
            return;
        }
        lVar.a();
        c1Var.f2311s = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i5) {
        if ((i5 & 2) == 0 || this.f187j.getVisibility() != 0) {
            return false;
        }
        return this.o;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.o || this.f192p) {
            return;
        }
        if (this.f193q <= this.f187j.getHeight()) {
            h();
            postDelayed(this.E, 600L);
            return;
        }
        h();
        postDelayed(this.F, 600L);
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i5) {
        super.onWindowSystemUiVisibilityChanged(i5);
        k();
        int i6 = this.f194r ^ i5;
        this.f194r = i5;
        boolean z4 = (i5 & 4) == 0;
        boolean z5 = (i5 & 256) != 0;
        f fVar = this.A;
        if (fVar != null) {
            ((d.c1) fVar).o = !z5;
            if (z4 || !z5) {
                d.c1 c1Var = (d.c1) fVar;
                if (c1Var.f2308p) {
                    c1Var.f2308p = false;
                    c1Var.t(true);
                }
            } else {
                d.c1 c1Var2 = (d.c1) fVar;
                if (!c1Var2.f2308p) {
                    c1Var2.f2308p = true;
                    c1Var2.t(true);
                }
            }
        }
        if ((i6 & 256) == 0 || this.A == null) {
            return;
        }
        WeakHashMap weakHashMap = h0.z0.f3233a;
        h0.m0.c(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i5) {
        super.onWindowVisibilityChanged(i5);
        this.f185h = i5;
        f fVar = this.A;
        if (fVar != null) {
            ((d.c1) fVar).f2307n = i5;
        }
    }

    public void setActionBarHideOffset(int i5) {
        h();
        this.f187j.setTranslationY(-Math.max(0, Math.min(i5, this.f187j.getHeight())));
    }

    public void setActionBarVisibilityCallback(f fVar) {
        this.A = fVar;
        if (getWindowToken() != null) {
            ((d.c1) this.A).f2307n = this.f185h;
            int i5 = this.f194r;
            if (i5 != 0) {
                onWindowSystemUiVisibilityChanged(i5);
                WeakHashMap weakHashMap = h0.z0.f3233a;
                h0.m0.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z4) {
        this.f191n = z4;
    }

    public void setHideOnContentScrollEnabled(boolean z4) {
        if (z4 != this.o) {
            this.o = z4;
            if (z4) {
                return;
            }
            h();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i5) {
        k();
        p3 p3Var = (p3) this.f188k;
        p3Var.f489d = i5 != 0 ? p2.a.x(p3Var.a(), i5) : null;
        p3Var.c();
    }

    public void setLogo(int i5) {
        k();
        p3 p3Var = (p3) this.f188k;
        p3Var.f490e = i5 != 0 ? p2.a.x(p3Var.a(), i5) : null;
        p3Var.c();
    }

    public void setOverlayMode(boolean z4) {
        this.f190m = z4;
    }

    public void setShowingForActionMode(boolean z4) {
    }

    public void setUiOptions(int i5) {
    }

    @Override // androidx.appcompat.widget.r1
    public void setWindowCallback(Window.Callback callback) {
        k();
        ((p3) this.f188k).f496k = callback;
    }

    @Override // androidx.appcompat.widget.r1
    public void setWindowTitle(CharSequence charSequence) {
        k();
        p3 p3Var = (p3) this.f188k;
        if (p3Var.f492g) {
            return;
        }
        p3Var.f493h = charSequence;
        if ((p3Var.f487b & 8) != 0) {
            Toolbar toolbar = p3Var.f486a;
            toolbar.setTitle(charSequence);
            if (p3Var.f492g) {
                h0.z0.o(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new g(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        k();
        p3 p3Var = (p3) this.f188k;
        p3Var.f489d = drawable;
        p3Var.c();
    }
}
