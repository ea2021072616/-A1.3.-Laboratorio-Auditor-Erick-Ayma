package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
/* loaded from: classes.dex */
public class ActionMenuView extends g2 implements h.n, h.c0 {
    public h.z A;
    public h.m B;
    public boolean C;
    public int D;
    public final int E;
    public final int F;
    public q G;

    /* renamed from: v  reason: collision with root package name */
    public h.o f203v;

    /* renamed from: w  reason: collision with root package name */
    public Context f204w;

    /* renamed from: x  reason: collision with root package name */
    public int f205x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f206y;

    /* renamed from: z  reason: collision with root package name */
    public n f207z;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f5 = context.getResources().getDisplayMetrics().density;
        this.E = (int) (56.0f * f5);
        this.F = (int) (f5 * 4.0f);
        this.f204w = context;
        this.f205x = 0;
    }

    public static p j(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            p pVar = new p();
            ((LinearLayout.LayoutParams) pVar).gravity = 16;
            return pVar;
        }
        p pVar2 = layoutParams instanceof p ? new p((p) layoutParams) : new p(layoutParams);
        if (((LinearLayout.LayoutParams) pVar2).gravity <= 0) {
            ((LinearLayout.LayoutParams) pVar2).gravity = 16;
        }
        return pVar2;
    }

    @Override // h.c0
    public final void a(h.o oVar) {
        this.f203v = oVar;
    }

    @Override // h.n
    public final boolean b(h.q qVar) {
        return this.f203v.q(qVar, null, 0);
    }

    @Override // androidx.appcompat.widget.g2, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof p;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.g2
    public final f2 f() {
        p pVar = new p();
        ((LinearLayout.LayoutParams) pVar).gravity = 16;
        return pVar;
    }

    @Override // androidx.appcompat.widget.g2
    public final f2 g(AttributeSet attributeSet) {
        return new p(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.g2, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        p pVar = new p();
        ((LinearLayout.LayoutParams) pVar).gravity = 16;
        return pVar;
    }

    @Override // androidx.appcompat.widget.g2, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return j(layoutParams);
    }

    public Menu getMenu() {
        if (this.f203v == null) {
            Context context = getContext();
            h.o oVar = new h.o(context);
            this.f203v = oVar;
            oVar.f3029k = new d.u0(5, this);
            n nVar = new n(context);
            this.f207z = nVar;
            nVar.f424r = true;
            nVar.f425s = true;
            h.z zVar = this.A;
            if (zVar == null) {
                zVar = new p3.e(6);
            }
            nVar.f418k = zVar;
            this.f203v.b(nVar, this.f204w);
            n nVar2 = this.f207z;
            nVar2.f421n = this;
            this.f203v = nVar2.f416i;
        }
        return this.f203v;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        n nVar = this.f207z;
        m mVar = nVar.o;
        if (mVar != null) {
            return mVar.getDrawable();
        }
        if (nVar.f423q) {
            return nVar.f422p;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f205x;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.g2
    public final /* bridge */ /* synthetic */ f2 h(ViewGroup.LayoutParams layoutParams) {
        return j(layoutParams);
    }

    public final boolean k(int i5) {
        boolean z4 = false;
        if (i5 == 0) {
            return false;
        }
        View childAt = getChildAt(i5 - 1);
        View childAt2 = getChildAt(i5);
        if (i5 < getChildCount() && (childAt instanceof o)) {
            z4 = false | ((o) childAt).a();
        }
        return (i5 <= 0 || !(childAt2 instanceof o)) ? z4 : z4 | ((o) childAt2).b();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n nVar = this.f207z;
        if (nVar != null) {
            nVar.h();
            if (this.f207z.j()) {
                this.f207z.f();
                this.f207z.l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n nVar = this.f207z;
        if (nVar != null) {
            nVar.f();
            i iVar = nVar.f432z;
            if (iVar == null || !iVar.b()) {
                return;
            }
            iVar.f3087j.dismiss();
        }
    }

    @Override // androidx.appcompat.widget.g2, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int width;
        int i9;
        if (!this.C) {
            super.onLayout(z4, i5, i6, i7, i8);
            return;
        }
        int childCount = getChildCount();
        int i10 = (i8 - i6) / 2;
        int dividerWidth = getDividerWidth();
        int i11 = i7 - i5;
        int paddingRight = (i11 - getPaddingRight()) - getPaddingLeft();
        boolean z5 = v3.f560a;
        boolean z6 = getLayoutDirection() == 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                p pVar = (p) childAt.getLayoutParams();
                if (pVar.f471a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (k(i14)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z6) {
                        i9 = getPaddingLeft() + ((LinearLayout.LayoutParams) pVar).leftMargin;
                        width = i9 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) pVar).rightMargin;
                        i9 = width - measuredWidth;
                    }
                    int i15 = i10 - (measuredHeight / 2);
                    childAt.layout(i9, i15, width, measuredHeight + i15);
                    paddingRight -= measuredWidth;
                    i12 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) pVar).leftMargin) + ((LinearLayout.LayoutParams) pVar).rightMargin;
                    k(i14);
                    i13++;
                }
            }
        }
        if (childCount == 1 && i12 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i16 = (i11 / 2) - (measuredWidth2 / 2);
            int i17 = i10 - (measuredHeight2 / 2);
            childAt2.layout(i16, i17, measuredWidth2 + i16, measuredHeight2 + i17);
            return;
        }
        int i18 = i13 - (i12 ^ 1);
        int max = Math.max(0, i18 > 0 ? paddingRight / i18 : 0);
        if (z6) {
            int width2 = getWidth() - getPaddingRight();
            for (int i19 = 0; i19 < childCount; i19++) {
                View childAt3 = getChildAt(i19);
                p pVar2 = (p) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !pVar2.f471a) {
                    int i20 = width2 - ((LinearLayout.LayoutParams) pVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i21 = i10 - (measuredHeight3 / 2);
                    childAt3.layout(i20 - measuredWidth3, i21, i20, measuredHeight3 + i21);
                    width2 = i20 - ((measuredWidth3 + ((LinearLayout.LayoutParams) pVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i22 = 0; i22 < childCount; i22++) {
            View childAt4 = getChildAt(i22);
            p pVar3 = (p) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !pVar3.f471a) {
                int i23 = paddingLeft + ((LinearLayout.LayoutParams) pVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i24 = i10 - (measuredHeight4 / 2);
                childAt4.layout(i23, i24, i23 + measuredWidth4, measuredHeight4 + i24);
                paddingLeft = measuredWidth4 + ((LinearLayout.LayoutParams) pVar3).rightMargin + max + i23;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v36 */
    @Override // androidx.appcompat.widget.g2, android.view.View
    public final void onMeasure(int i5, int i6) {
        int i7;
        boolean z4;
        int i8;
        boolean z5;
        int i9;
        int i10;
        int i11;
        ?? r42;
        int i12;
        int i13;
        int i14;
        h.o oVar;
        boolean z6 = this.C;
        boolean z7 = View.MeasureSpec.getMode(i5) == 1073741824;
        this.C = z7;
        if (z6 != z7) {
            this.D = 0;
        }
        int size = View.MeasureSpec.getSize(i5);
        if (this.C && (oVar = this.f203v) != null && size != this.D) {
            this.D = size;
            oVar.p(true);
        }
        int childCount = getChildCount();
        if (!this.C || childCount <= 0) {
            for (int i15 = 0; i15 < childCount; i15++) {
                p pVar = (p) getChildAt(i15).getLayoutParams();
                ((LinearLayout.LayoutParams) pVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) pVar).leftMargin = 0;
            }
            super.onMeasure(i5, i6);
            return;
        }
        int mode = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i5);
        int size3 = View.MeasureSpec.getSize(i6);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, paddingBottom, -2);
        int i16 = size2 - paddingRight;
        int i17 = this.E;
        int i18 = i16 / i17;
        int i19 = i16 % i17;
        if (i18 == 0) {
            setMeasuredDimension(i16, 0);
            return;
        }
        int i20 = (i19 / i18) + i17;
        int childCount2 = getChildCount();
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        boolean z8 = false;
        int i25 = 0;
        long j5 = 0;
        while (true) {
            i7 = this.F;
            if (i24 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i24);
            int i26 = size3;
            int i27 = i16;
            if (childAt.getVisibility() == 8) {
                i12 = mode;
                i13 = paddingBottom;
            } else {
                boolean z9 = childAt instanceof ActionMenuItemView;
                int i28 = i22 + 1;
                if (z9) {
                    childAt.setPadding(i7, 0, i7, 0);
                }
                p pVar2 = (p) childAt.getLayoutParams();
                pVar2.f476f = false;
                pVar2.f473c = 0;
                pVar2.f472b = 0;
                pVar2.f474d = false;
                ((LinearLayout.LayoutParams) pVar2).leftMargin = 0;
                ((LinearLayout.LayoutParams) pVar2).rightMargin = 0;
                pVar2.f475e = z9 && ((ActionMenuItemView) childAt).m();
                int i29 = pVar2.f471a ? 1 : i18;
                p pVar3 = (p) childAt.getLayoutParams();
                i12 = mode;
                i13 = paddingBottom;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z9 ? (ActionMenuItemView) childAt : null;
                boolean z10 = actionMenuItemView != null && actionMenuItemView.m();
                if (i29 <= 0 || (z10 && i29 < 2)) {
                    i14 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i29 * i20, Integer.MIN_VALUE), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i14 = measuredWidth / i20;
                    if (measuredWidth % i20 != 0) {
                        i14++;
                    }
                    if (z10 && i14 < 2) {
                        i14 = 2;
                    }
                }
                pVar3.f474d = !pVar3.f471a && z10;
                pVar3.f472b = i14;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i20 * i14, 1073741824), makeMeasureSpec);
                i23 = Math.max(i23, i14);
                if (pVar2.f474d) {
                    i25++;
                }
                if (pVar2.f471a) {
                    z8 = true;
                }
                i18 -= i14;
                i21 = Math.max(i21, childAt.getMeasuredHeight());
                if (i14 == 1) {
                    j5 |= 1 << i24;
                }
                i22 = i28;
            }
            i24++;
            size3 = i26;
            i16 = i27;
            paddingBottom = i13;
            mode = i12;
        }
        int i30 = mode;
        int i31 = i16;
        int i32 = size3;
        boolean z11 = z8 && i22 == 2;
        boolean z12 = false;
        while (i25 > 0 && i18 > 0) {
            int i33 = Integer.MAX_VALUE;
            int i34 = 0;
            int i35 = 0;
            long j6 = 0;
            while (i35 < childCount2) {
                p pVar4 = (p) getChildAt(i35).getLayoutParams();
                boolean z13 = z12;
                if (pVar4.f474d) {
                    int i36 = pVar4.f472b;
                    if (i36 < i33) {
                        j6 = 1 << i35;
                        i33 = i36;
                        i34 = 1;
                    } else if (i36 == i33) {
                        j6 |= 1 << i35;
                        i34++;
                    }
                }
                i35++;
                z12 = z13;
            }
            z4 = z12;
            j5 |= j6;
            if (i34 > i18) {
                break;
            }
            int i37 = i33 + 1;
            int i38 = 0;
            while (i38 < childCount2) {
                View childAt2 = getChildAt(i38);
                p pVar5 = (p) childAt2.getLayoutParams();
                int i39 = i21;
                int i40 = childMeasureSpec;
                int i41 = childCount2;
                long j7 = 1 << i38;
                if ((j6 & j7) != 0) {
                    if (z11 && pVar5.f475e) {
                        r42 = 1;
                        r42 = 1;
                        if (i18 == 1) {
                            childAt2.setPadding(i7 + i20, 0, i7, 0);
                        }
                    } else {
                        r42 = 1;
                    }
                    pVar5.f472b += r42;
                    pVar5.f476f = r42;
                    i18--;
                } else if (pVar5.f472b == i37) {
                    j5 |= j7;
                }
                i38++;
                childMeasureSpec = i40;
                i21 = i39;
                childCount2 = i41;
            }
            z12 = true;
        }
        z4 = z12;
        int i42 = i21;
        int i43 = childMeasureSpec;
        int i44 = childCount2;
        boolean z14 = !z8 && i22 == 1;
        if (i18 <= 0 || j5 == 0 || (i18 >= i22 - 1 && !z14 && i23 <= 1)) {
            i8 = i44;
            z5 = z4;
        } else {
            float bitCount = Long.bitCount(j5);
            if (!z14) {
                if ((j5 & 1) != 0 && !((p) getChildAt(0).getLayoutParams()).f475e) {
                    bitCount -= 0.5f;
                }
                int i45 = i44 - 1;
                if ((j5 & (1 << i45)) != 0 && !((p) getChildAt(i45).getLayoutParams()).f475e) {
                    bitCount -= 0.5f;
                }
            }
            int i46 = bitCount > 0.0f ? (int) ((i18 * i20) / bitCount) : 0;
            boolean z15 = z4;
            i8 = i44;
            for (int i47 = 0; i47 < i8; i47++) {
                if ((j5 & (1 << i47)) != 0) {
                    View childAt3 = getChildAt(i47);
                    p pVar6 = (p) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        pVar6.f473c = i46;
                        pVar6.f476f = true;
                        if (i47 == 0 && !pVar6.f475e) {
                            ((LinearLayout.LayoutParams) pVar6).leftMargin = (-i46) / 2;
                        }
                        z15 = true;
                    } else {
                        if (pVar6.f471a) {
                            pVar6.f473c = i46;
                            pVar6.f476f = true;
                            ((LinearLayout.LayoutParams) pVar6).rightMargin = (-i46) / 2;
                            z15 = true;
                        } else {
                            if (i47 != 0) {
                                ((LinearLayout.LayoutParams) pVar6).leftMargin = i46 / 2;
                            }
                            if (i47 != i8 - 1) {
                                ((LinearLayout.LayoutParams) pVar6).rightMargin = i46 / 2;
                            }
                        }
                    }
                }
            }
            z5 = z15;
        }
        if (z5) {
            int i48 = 0;
            while (i48 < i8) {
                View childAt4 = getChildAt(i48);
                p pVar7 = (p) childAt4.getLayoutParams();
                if (pVar7.f476f) {
                    i11 = i43;
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((pVar7.f472b * i20) + pVar7.f473c, 1073741824), i11);
                } else {
                    i11 = i43;
                }
                i48++;
                i43 = i11;
            }
        }
        if (i30 != 1073741824) {
            i10 = i31;
            i9 = i42;
        } else {
            i9 = i32;
            i10 = i31;
        }
        setMeasuredDimension(i10, i9);
    }

    public void setExpandedActionViewsExclusive(boolean z4) {
        this.f207z.f429w = z4;
    }

    public void setOnMenuItemClickListener(q qVar) {
        this.G = qVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        n nVar = this.f207z;
        m mVar = nVar.o;
        if (mVar != null) {
            mVar.setImageDrawable(drawable);
            return;
        }
        nVar.f423q = true;
        nVar.f422p = drawable;
    }

    public void setOverflowReserved(boolean z4) {
        this.f206y = z4;
    }

    public void setPopupTheme(int i5) {
        if (this.f205x != i5) {
            this.f205x = i5;
            if (i5 == 0) {
                this.f204w = getContext();
            } else {
                this.f204w = new ContextThemeWrapper(getContext(), i5);
            }
        }
    }

    public void setPresenter(n nVar) {
        this.f207z = nVar;
        nVar.f421n = this;
        this.f203v = nVar.f416i;
    }

    @Override // androidx.appcompat.widget.g2, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new p(getContext(), attributeSet);
    }
}
