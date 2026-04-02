package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import com.github.appintro.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements h0.m {
    public int A;
    public int B;
    public final int C;
    public CharSequence D;
    public CharSequence E;
    public ColorStateList F;
    public ColorStateList G;
    public boolean H;
    public boolean I;
    public final ArrayList J;
    public final ArrayList K;
    public final int[] L;
    public final h0.q M;
    public ArrayList N;
    public m3 O;
    public final i3 P;
    public p3 Q;
    public n R;
    public k3 S;
    public h.z T;
    public h.m U;
    public boolean V;
    public OnBackInvokedCallback W;

    /* renamed from: a0  reason: collision with root package name */
    public OnBackInvokedDispatcher f246a0;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f247b0;

    /* renamed from: c0  reason: collision with root package name */
    public final androidx.activity.j f248c0;

    /* renamed from: g  reason: collision with root package name */
    public ActionMenuView f249g;

    /* renamed from: h  reason: collision with root package name */
    public i1 f250h;

    /* renamed from: i  reason: collision with root package name */
    public i1 f251i;

    /* renamed from: j  reason: collision with root package name */
    public f0 f252j;

    /* renamed from: k  reason: collision with root package name */
    public h0 f253k;

    /* renamed from: l  reason: collision with root package name */
    public final Drawable f254l;

    /* renamed from: m  reason: collision with root package name */
    public final CharSequence f255m;

    /* renamed from: n  reason: collision with root package name */
    public f0 f256n;
    public View o;

    /* renamed from: p  reason: collision with root package name */
    public Context f257p;

    /* renamed from: q  reason: collision with root package name */
    public int f258q;

    /* renamed from: r  reason: collision with root package name */
    public int f259r;

    /* renamed from: s  reason: collision with root package name */
    public int f260s;

    /* renamed from: t  reason: collision with root package name */
    public final int f261t;

    /* renamed from: u  reason: collision with root package name */
    public final int f262u;

    /* renamed from: v  reason: collision with root package name */
    public int f263v;

    /* renamed from: w  reason: collision with root package name */
    public int f264w;

    /* renamed from: x  reason: collision with root package name */
    public int f265x;

    /* renamed from: y  reason: collision with root package name */
    public int f266y;

    /* renamed from: z  reason: collision with root package name */
    public x2 f267z;

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static l3 g(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof l3 ? new l3((l3) layoutParams) : layoutParams instanceof d.a ? new l3((d.a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new l3((ViewGroup.MarginLayoutParams) layoutParams) : new l3(layoutParams);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i5 = 0; i5 < menu.size(); i5++) {
            arrayList.add(menu.getItem(i5));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new g.j(getContext());
    }

    public static int i(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int j(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(int i5, ArrayList arrayList) {
        boolean z4 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i5, getLayoutDirection());
        arrayList.clear();
        if (!z4) {
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                l3 l3Var = (l3) childAt.getLayoutParams();
                if (l3Var.f410b == 0 && r(childAt)) {
                    int i7 = l3Var.f2278a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i7, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i8 = childCount - 1; i8 >= 0; i8--) {
            View childAt2 = getChildAt(i8);
            l3 l3Var2 = (l3) childAt2.getLayoutParams();
            if (l3Var2.f410b == 0 && r(childAt2)) {
                int i9 = l3Var2.f2278a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i9, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    @Override // h0.m
    public final void addMenuProvider(h0.s sVar) {
        h0.q qVar = this.M;
        qVar.f3195b.add(sVar);
        qVar.f3194a.run();
    }

    public final void b(View view, boolean z4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        l3 l3Var = layoutParams == null ? new l3() : !checkLayoutParams(layoutParams) ? g(layoutParams) : (l3) layoutParams;
        l3Var.f410b = 1;
        if (!z4 || this.o == null) {
            addView(view, l3Var);
            return;
        }
        view.setLayoutParams(l3Var);
        this.K.add(view);
    }

    public final void c() {
        if (this.f256n == null) {
            f0 f0Var = new f0(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f256n = f0Var;
            f0Var.setImageDrawable(this.f254l);
            this.f256n.setContentDescription(this.f255m);
            l3 l3Var = new l3();
            l3Var.f2278a = (this.f261t & 112) | 8388611;
            l3Var.f410b = 2;
            this.f256n.setLayoutParams(l3Var);
            this.f256n.setOnClickListener(new d.d(1, this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof l3);
    }

    public final void d() {
        e();
        ActionMenuView actionMenuView = this.f249g;
        if (actionMenuView.f203v == null) {
            h.o oVar = (h.o) actionMenuView.getMenu();
            if (this.S == null) {
                this.S = new k3(this);
            }
            this.f249g.setExpandedActionViewsExclusive(true);
            oVar.b(this.S, this.f257p);
            s();
        }
    }

    public final void e() {
        if (this.f249g == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f249g = actionMenuView;
            actionMenuView.setPopupTheme(this.f258q);
            this.f249g.setOnMenuItemClickListener(this.P);
            ActionMenuView actionMenuView2 = this.f249g;
            h.z zVar = this.T;
            i3 i3Var = new i3(this);
            actionMenuView2.A = zVar;
            actionMenuView2.B = i3Var;
            l3 l3Var = new l3();
            l3Var.f2278a = (this.f261t & 112) | 8388613;
            this.f249g.setLayoutParams(l3Var);
            b(this.f249g, false);
        }
    }

    public final void f() {
        if (this.f252j == null) {
            this.f252j = new f0(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            l3 l3Var = new l3();
            l3Var.f2278a = (this.f261t & 112) | 8388611;
            this.f252j.setLayoutParams(l3Var);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new l3();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return g(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        f0 f0Var = this.f256n;
        if (f0Var != null) {
            return f0Var.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        f0 f0Var = this.f256n;
        if (f0Var != null) {
            return f0Var.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        x2 x2Var = this.f267z;
        if (x2Var != null) {
            return x2Var.f594g ? x2Var.f588a : x2Var.f589b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i5 = this.B;
        return i5 != Integer.MIN_VALUE ? i5 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        x2 x2Var = this.f267z;
        if (x2Var != null) {
            return x2Var.f588a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        x2 x2Var = this.f267z;
        if (x2Var != null) {
            return x2Var.f589b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        x2 x2Var = this.f267z;
        if (x2Var != null) {
            return x2Var.f594g ? x2Var.f589b : x2Var.f588a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i5 = this.A;
        return i5 != Integer.MIN_VALUE ? i5 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        h.o oVar;
        ActionMenuView actionMenuView = this.f249g;
        return actionMenuView != null && (oVar = actionMenuView.f203v) != null && oVar.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.B, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.A, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        h0 h0Var = this.f253k;
        if (h0Var != null) {
            return h0Var.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        h0 h0Var = this.f253k;
        if (h0Var != null) {
            return h0Var.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        d();
        return this.f249g.getMenu();
    }

    public View getNavButtonView() {
        return this.f252j;
    }

    public CharSequence getNavigationContentDescription() {
        f0 f0Var = this.f252j;
        if (f0Var != null) {
            return f0Var.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        f0 f0Var = this.f252j;
        if (f0Var != null) {
            return f0Var.getDrawable();
        }
        return null;
    }

    public n getOuterActionMenuPresenter() {
        return this.R;
    }

    public Drawable getOverflowIcon() {
        d();
        return this.f249g.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f257p;
    }

    public int getPopupTheme() {
        return this.f258q;
    }

    public CharSequence getSubtitle() {
        return this.E;
    }

    public final TextView getSubtitleTextView() {
        return this.f251i;
    }

    public CharSequence getTitle() {
        return this.D;
    }

    public int getTitleMarginBottom() {
        return this.f266y;
    }

    public int getTitleMarginEnd() {
        return this.f264w;
    }

    public int getTitleMarginStart() {
        return this.f263v;
    }

    public int getTitleMarginTop() {
        return this.f265x;
    }

    public final TextView getTitleTextView() {
        return this.f250h;
    }

    public s1 getWrapper() {
        if (this.Q == null) {
            this.Q = new p3(this, true);
        }
        return this.Q;
    }

    public final int h(View view, int i5) {
        l3 l3Var = (l3) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = i5 > 0 ? (measuredHeight - i5) / 2 : 0;
        int i7 = l3Var.f2278a & 112;
        if (i7 != 16 && i7 != 48 && i7 != 80) {
            i7 = this.C & 112;
        }
        if (i7 != 48) {
            if (i7 != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i8 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i9 = ((ViewGroup.MarginLayoutParams) l3Var).topMargin;
                if (i8 < i9) {
                    i8 = i9;
                } else {
                    int i10 = (((height - paddingBottom) - measuredHeight) - i8) - paddingTop;
                    int i11 = ((ViewGroup.MarginLayoutParams) l3Var).bottomMargin;
                    if (i10 < i11) {
                        i8 = Math.max(0, i8 - (i11 - i10));
                    }
                }
                return paddingTop + i8;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) l3Var).bottomMargin) - i6;
        }
        return getPaddingTop() - i6;
    }

    public void k(int i5) {
        getMenuInflater().inflate(i5, getMenu());
    }

    public final void l() {
        Iterator it = this.N.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        MenuInflater menuInflater = getMenuInflater();
        Iterator it2 = this.M.f3195b.iterator();
        while (it2.hasNext()) {
            ((androidx.fragment.app.p0) ((h0.s) it2.next())).f966a.j(menu, menuInflater);
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.N = currentMenuItems2;
    }

    public final boolean m(View view) {
        return view.getParent() == this || this.K.contains(view);
    }

    public final int n(View view, int i5, int i6, int[] iArr) {
        l3 l3Var = (l3) view.getLayoutParams();
        int i7 = ((ViewGroup.MarginLayoutParams) l3Var).leftMargin - iArr[0];
        int max = Math.max(0, i7) + i5;
        iArr[0] = Math.max(0, -i7);
        int h5 = h(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, h5, max + measuredWidth, view.getMeasuredHeight() + h5);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) l3Var).rightMargin + max;
    }

    public final int o(View view, int i5, int i6, int[] iArr) {
        l3 l3Var = (l3) view.getLayoutParams();
        int i7 = ((ViewGroup.MarginLayoutParams) l3Var).rightMargin - iArr[1];
        int max = i5 - Math.max(0, i7);
        iArr[1] = Math.max(0, -i7);
        int h5 = h(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, h5, max, view.getMeasuredHeight() + h5);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) l3Var).leftMargin);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f248c0);
        s();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.I = false;
        }
        if (!this.I) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.I = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.I = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0292 A[LOOP:0: B:102:0x0290->B:103:0x0292, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02ae A[LOOP:1: B:105:0x02ac->B:106:0x02ae, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02ce A[LOOP:2: B:108:0x02cc->B:109:0x02ce, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x031c A[LOOP:3: B:117:0x031a->B:118:0x031c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x021d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 813
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0293  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 664
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof o3)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o3 o3Var = (o3) parcelable;
        super.onRestoreInstanceState(o3Var.f4245b);
        ActionMenuView actionMenuView = this.f249g;
        h.o oVar = actionMenuView != null ? actionMenuView.f203v : null;
        int i5 = o3Var.f469d;
        if (i5 != 0 && this.S != null && oVar != null && (findItem = oVar.findItem(i5)) != null) {
            findItem.expandActionView();
        }
        if (o3Var.f470e) {
            androidx.activity.j jVar = this.f248c0;
            removeCallbacks(jVar);
            post(jVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        if (this.f267z == null) {
            this.f267z = new x2();
        }
        x2 x2Var = this.f267z;
        boolean z4 = i5 == 1;
        if (z4 == x2Var.f594g) {
            return;
        }
        x2Var.f594g = z4;
        if (!x2Var.f595h) {
            x2Var.f588a = x2Var.f592e;
            x2Var.f589b = x2Var.f593f;
        } else if (z4) {
            int i6 = x2Var.f591d;
            if (i6 == Integer.MIN_VALUE) {
                i6 = x2Var.f592e;
            }
            x2Var.f588a = i6;
            int i7 = x2Var.f590c;
            if (i7 == Integer.MIN_VALUE) {
                i7 = x2Var.f593f;
            }
            x2Var.f589b = i7;
        } else {
            int i8 = x2Var.f590c;
            if (i8 == Integer.MIN_VALUE) {
                i8 = x2Var.f592e;
            }
            x2Var.f588a = i8;
            int i9 = x2Var.f591d;
            if (i9 == Integer.MIN_VALUE) {
                i9 = x2Var.f593f;
            }
            x2Var.f589b = i9;
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        h.q qVar;
        o3 o3Var = new o3(super.onSaveInstanceState());
        k3 k3Var = this.S;
        if (k3Var != null && (qVar = k3Var.f400h) != null) {
            o3Var.f469d = qVar.f3047g;
        }
        ActionMenuView actionMenuView = this.f249g;
        boolean z4 = false;
        if (actionMenuView != null) {
            n nVar = actionMenuView.f207z;
            if (nVar != null && nVar.j()) {
                z4 = true;
            }
        }
        o3Var.f470e = z4;
        return o3Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.H = false;
        }
        if (!this.H) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.H = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.H = false;
        }
        return true;
    }

    public final int p(View view, int i5, int i6, int i7, int i8, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i9 = marginLayoutParams.leftMargin - iArr[0];
        int i10 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i10) + Math.max(0, i9);
        iArr[0] = Math.max(0, -i9);
        iArr[1] = Math.max(0, -i10);
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingRight() + getPaddingLeft() + max + i6, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i7, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final void q(View view, int i5, int i6, int i7, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i7, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + 0, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i8 >= 0) {
            if (mode != 0) {
                i8 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i8);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean r(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    @Override // h0.m
    public final void removeMenuProvider(h0.s sVar) {
        this.M.b(sVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a5 = j3.a(this);
            k3 k3Var = this.S;
            boolean z4 = false;
            if (((k3Var == null || k3Var.f400h == null) ? false : true) && a5 != null && isAttachedToWindow() && this.f247b0) {
                z4 = true;
            }
            if (z4 && this.f246a0 == null) {
                if (this.W == null) {
                    this.W = j3.b(new h3(this, 1));
                }
                j3.c(a5, this.W);
                this.f246a0 = a5;
            } else if (z4 || (onBackInvokedDispatcher = this.f246a0) == null) {
            } else {
                j3.d(onBackInvokedDispatcher, this.W);
                this.f246a0 = null;
            }
        }
    }

    public void setBackInvokedCallbackEnabled(boolean z4) {
        if (this.f247b0 != z4) {
            this.f247b0 = z4;
            s();
        }
    }

    public void setCollapseContentDescription(int i5) {
        setCollapseContentDescription(i5 != 0 ? getContext().getText(i5) : null);
    }

    public void setCollapseIcon(int i5) {
        setCollapseIcon(p2.a.x(getContext(), i5));
    }

    public void setCollapsible(boolean z4) {
        this.V = z4;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i5) {
        if (i5 < 0) {
            i5 = Integer.MIN_VALUE;
        }
        if (i5 != this.B) {
            this.B = i5;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i5) {
        if (i5 < 0) {
            i5 = Integer.MIN_VALUE;
        }
        if (i5 != this.A) {
            this.A = i5;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i5) {
        setLogo(p2.a.x(getContext(), i5));
    }

    public void setLogoDescription(int i5) {
        setLogoDescription(getContext().getText(i5));
    }

    public void setNavigationContentDescription(int i5) {
        setNavigationContentDescription(i5 != 0 ? getContext().getText(i5) : null);
    }

    public void setNavigationIcon(int i5) {
        setNavigationIcon(p2.a.x(getContext(), i5));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        f();
        this.f252j.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(m3 m3Var) {
        this.O = m3Var;
    }

    public void setOverflowIcon(Drawable drawable) {
        d();
        this.f249g.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i5) {
        if (this.f258q != i5) {
            this.f258q = i5;
            if (i5 == 0) {
                this.f257p = getContext();
            } else {
                this.f257p = new ContextThemeWrapper(getContext(), i5);
            }
        }
    }

    public void setSubtitle(int i5) {
        setSubtitle(getContext().getText(i5));
    }

    public void setSubtitleTextColor(int i5) {
        setSubtitleTextColor(ColorStateList.valueOf(i5));
    }

    public void setTitle(int i5) {
        setTitle(getContext().getText(i5));
    }

    public void setTitleMarginBottom(int i5) {
        this.f266y = i5;
        requestLayout();
    }

    public void setTitleMarginEnd(int i5) {
        this.f264w = i5;
        requestLayout();
    }

    public void setTitleMarginStart(int i5) {
        this.f263v = i5;
        requestLayout();
    }

    public void setTitleMarginTop(int i5) {
        this.f265x = i5;
        requestLayout();
    }

    public void setTitleTextColor(int i5) {
        setTitleTextColor(ColorStateList.valueOf(i5));
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.C = 8388627;
        this.J = new ArrayList();
        this.K = new ArrayList();
        this.L = new int[2];
        this.M = new h0.q(new h3(this, 0));
        this.N = new ArrayList();
        this.P = new i3(this);
        this.f248c0 = new androidx.activity.j(5, this);
        Context context2 = getContext();
        int[] iArr = c.a.f1706x;
        z2 m5 = z2.m(context2, attributeSet, iArr, R.attr.toolbarStyle);
        Object obj = m5.f606b;
        h0.z0.m(this, context, iArr, attributeSet, (TypedArray) obj, R.attr.toolbarStyle);
        this.f259r = m5.i(28, 0);
        this.f260s = m5.i(19, 0);
        this.C = ((TypedArray) obj).getInteger(0, 8388627);
        this.f261t = ((TypedArray) obj).getInteger(2, 48);
        int c5 = m5.c(22, 0);
        c5 = m5.l(27) ? m5.c(27, c5) : c5;
        this.f266y = c5;
        this.f265x = c5;
        this.f264w = c5;
        this.f263v = c5;
        int c6 = m5.c(25, -1);
        if (c6 >= 0) {
            this.f263v = c6;
        }
        int c7 = m5.c(24, -1);
        if (c7 >= 0) {
            this.f264w = c7;
        }
        int c8 = m5.c(26, -1);
        if (c8 >= 0) {
            this.f265x = c8;
        }
        int c9 = m5.c(23, -1);
        if (c9 >= 0) {
            this.f266y = c9;
        }
        this.f262u = m5.d(13, -1);
        int c10 = m5.c(9, Integer.MIN_VALUE);
        int c11 = m5.c(5, Integer.MIN_VALUE);
        int d5 = m5.d(7, 0);
        int d6 = m5.d(8, 0);
        if (this.f267z == null) {
            this.f267z = new x2();
        }
        x2 x2Var = this.f267z;
        x2Var.f595h = false;
        if (d5 != Integer.MIN_VALUE) {
            x2Var.f592e = d5;
            x2Var.f588a = d5;
        }
        if (d6 != Integer.MIN_VALUE) {
            x2Var.f593f = d6;
            x2Var.f589b = d6;
        }
        if (c10 != Integer.MIN_VALUE || c11 != Integer.MIN_VALUE) {
            x2Var.a(c10, c11);
        }
        this.A = m5.c(10, Integer.MIN_VALUE);
        this.B = m5.c(6, Integer.MIN_VALUE);
        this.f254l = m5.e(4);
        this.f255m = m5.k(3);
        CharSequence k5 = m5.k(21);
        if (!TextUtils.isEmpty(k5)) {
            setTitle(k5);
        }
        CharSequence k6 = m5.k(18);
        if (!TextUtils.isEmpty(k6)) {
            setSubtitle(k6);
        }
        this.f257p = getContext();
        setPopupTheme(m5.i(17, 0));
        Drawable e5 = m5.e(16);
        if (e5 != null) {
            setNavigationIcon(e5);
        }
        CharSequence k7 = m5.k(15);
        if (!TextUtils.isEmpty(k7)) {
            setNavigationContentDescription(k7);
        }
        Drawable e6 = m5.e(11);
        if (e6 != null) {
            setLogo(e6);
        }
        CharSequence k8 = m5.k(12);
        if (!TextUtils.isEmpty(k8)) {
            setLogoDescription(k8);
        }
        if (m5.l(29)) {
            setTitleTextColor(m5.b(29));
        }
        if (m5.l(20)) {
            setSubtitleTextColor(m5.b(20));
        }
        if (m5.l(14)) {
            k(m5.i(14, 0));
        }
        m5.n();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new l3(getContext(), attributeSet);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        f0 f0Var = this.f256n;
        if (f0Var != null) {
            f0Var.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f256n.setImageDrawable(drawable);
            return;
        }
        f0 f0Var = this.f256n;
        if (f0Var != null) {
            f0Var.setImageDrawable(this.f254l);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f253k == null) {
                this.f253k = new h0(getContext(), null, 0);
            }
            if (!m(this.f253k)) {
                b(this.f253k, true);
            }
        } else {
            h0 h0Var = this.f253k;
            if (h0Var != null && m(h0Var)) {
                removeView(this.f253k);
                this.K.remove(this.f253k);
            }
        }
        h0 h0Var2 = this.f253k;
        if (h0Var2 != null) {
            h0Var2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f253k == null) {
            this.f253k = new h0(getContext(), null, 0);
        }
        h0 h0Var = this.f253k;
        if (h0Var != null) {
            h0Var.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            f();
        }
        f0 f0Var = this.f252j;
        if (f0Var != null) {
            f0Var.setContentDescription(charSequence);
            q3.a(this.f252j, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            f();
            if (!m(this.f252j)) {
                b(this.f252j, true);
            }
        } else {
            f0 f0Var = this.f252j;
            if (f0Var != null && m(f0Var)) {
                removeView(this.f252j);
                this.K.remove(this.f252j);
            }
        }
        f0 f0Var2 = this.f252j;
        if (f0Var2 != null) {
            f0Var2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f251i == null) {
                Context context = getContext();
                i1 i1Var = new i1(context, null);
                this.f251i = i1Var;
                i1Var.setSingleLine();
                this.f251i.setEllipsize(TextUtils.TruncateAt.END);
                int i5 = this.f260s;
                if (i5 != 0) {
                    this.f251i.setTextAppearance(context, i5);
                }
                ColorStateList colorStateList = this.G;
                if (colorStateList != null) {
                    this.f251i.setTextColor(colorStateList);
                }
            }
            if (!m(this.f251i)) {
                b(this.f251i, true);
            }
        } else {
            i1 i1Var2 = this.f251i;
            if (i1Var2 != null && m(i1Var2)) {
                removeView(this.f251i);
                this.K.remove(this.f251i);
            }
        }
        i1 i1Var3 = this.f251i;
        if (i1Var3 != null) {
            i1Var3.setText(charSequence);
        }
        this.E = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.G = colorStateList;
        i1 i1Var = this.f251i;
        if (i1Var != null) {
            i1Var.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f250h == null) {
                Context context = getContext();
                i1 i1Var = new i1(context, null);
                this.f250h = i1Var;
                i1Var.setSingleLine();
                this.f250h.setEllipsize(TextUtils.TruncateAt.END);
                int i5 = this.f259r;
                if (i5 != 0) {
                    this.f250h.setTextAppearance(context, i5);
                }
                ColorStateList colorStateList = this.F;
                if (colorStateList != null) {
                    this.f250h.setTextColor(colorStateList);
                }
            }
            if (!m(this.f250h)) {
                b(this.f250h, true);
            }
        } else {
            i1 i1Var2 = this.f250h;
            if (i1Var2 != null && m(i1Var2)) {
                removeView(this.f250h);
                this.K.remove(this.f250h);
            }
        }
        i1 i1Var3 = this.f250h;
        if (i1Var3 != null) {
            i1Var3.setText(charSequence);
        }
        this.D = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.F = colorStateList;
        i1 i1Var = this.f250h;
        if (i1Var != null) {
            i1Var.setTextColor(colorStateList);
        }
    }
}
