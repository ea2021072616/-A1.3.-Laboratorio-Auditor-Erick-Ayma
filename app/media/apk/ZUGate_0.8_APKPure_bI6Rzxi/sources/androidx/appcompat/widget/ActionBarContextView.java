package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.appintro.R;
/* loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {

    /* renamed from: g  reason: collision with root package name */
    public final a f165g;

    /* renamed from: h  reason: collision with root package name */
    public final Context f166h;

    /* renamed from: i  reason: collision with root package name */
    public ActionMenuView f167i;

    /* renamed from: j  reason: collision with root package name */
    public n f168j;

    /* renamed from: k  reason: collision with root package name */
    public int f169k;

    /* renamed from: l  reason: collision with root package name */
    public h0.k1 f170l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f171m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f172n;
    public CharSequence o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f173p;

    /* renamed from: q  reason: collision with root package name */
    public View f174q;

    /* renamed from: r  reason: collision with root package name */
    public View f175r;

    /* renamed from: s  reason: collision with root package name */
    public View f176s;

    /* renamed from: t  reason: collision with root package name */
    public LinearLayout f177t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f178u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f179v;

    /* renamed from: w  reason: collision with root package name */
    public final int f180w;

    /* renamed from: x  reason: collision with root package name */
    public final int f181x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f182y;

    /* renamed from: z  reason: collision with root package name */
    public final int f183z;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.actionModeStyle);
        int resourceId;
        this.f165g = new a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f166h = context;
        } else {
            this.f166h = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.f1687d, R.attr.actionModeStyle, 0);
        setBackground((!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) ? obtainStyledAttributes.getDrawable(0) : p2.a.x(context, resourceId));
        this.f180w = obtainStyledAttributes.getResourceId(5, 0);
        this.f181x = obtainStyledAttributes.getResourceId(4, 0);
        this.f169k = obtainStyledAttributes.getLayoutDimension(3, 0);
        this.f183z = obtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }

    public static int f(View view, int i5, int i6) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), i6);
        return Math.max(0, (i5 - view.getMeasuredWidth()) - 0);
    }

    public static int j(View view, boolean z4, int i5, int i6, int i7) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i8 = ((i7 - measuredHeight) / 2) + i6;
        if (z4) {
            view.layout(i5 - measuredWidth, i8, i5, measuredHeight + i8);
        } else {
            view.layout(i5, i8, i5 + measuredWidth, measuredHeight + i8);
        }
        return z4 ? -measuredWidth : measuredWidth;
    }

    public final void c(g.b bVar) {
        View view = this.f174q;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f183z, (ViewGroup) this, false);
            this.f174q = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f174q);
        }
        View findViewById = this.f174q.findViewById(R.id.action_mode_close_button);
        this.f175r = findViewById;
        findViewById.setOnClickListener(new c(this, bVar));
        h.o e5 = bVar.e();
        n nVar = this.f168j;
        if (nVar != null) {
            nVar.f();
            i iVar = nVar.f432z;
            if (iVar != null && iVar.b()) {
                iVar.f3087j.dismiss();
            }
        }
        n nVar2 = new n(getContext());
        this.f168j = nVar2;
        nVar2.f424r = true;
        nVar2.f425s = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        e5.b(this.f168j, this.f166h);
        n nVar3 = this.f168j;
        h.c0 c0Var = nVar3.f421n;
        if (c0Var == null) {
            h.c0 c0Var2 = (h.c0) nVar3.f417j.inflate(nVar3.f419l, (ViewGroup) this, false);
            nVar3.f421n = c0Var2;
            c0Var2.a(nVar3.f416i);
            nVar3.h();
        }
        h.c0 c0Var3 = nVar3.f421n;
        if (c0Var != c0Var3) {
            ((ActionMenuView) c0Var3).setPresenter(nVar3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) c0Var3;
        this.f167i = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f167i, layoutParams);
    }

    public final void d() {
        if (this.f177t == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f177t = linearLayout;
            this.f178u = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f179v = (TextView) this.f177t.findViewById(R.id.action_bar_subtitle);
            int i5 = this.f180w;
            if (i5 != 0) {
                this.f178u.setTextAppearance(getContext(), i5);
            }
            int i6 = this.f181x;
            if (i6 != 0) {
                this.f179v.setTextAppearance(getContext(), i6);
            }
        }
        this.f178u.setText(this.o);
        this.f179v.setText(this.f173p);
        boolean z4 = !TextUtils.isEmpty(this.o);
        boolean z5 = !TextUtils.isEmpty(this.f173p);
        int i7 = 0;
        this.f179v.setVisibility(z5 ? 0 : 8);
        LinearLayout linearLayout2 = this.f177t;
        if (!z4 && !z5) {
            i7 = 8;
        }
        linearLayout2.setVisibility(i7);
        if (this.f177t.getParent() == null) {
            addView(this.f177t);
        }
    }

    public final void e() {
        removeAllViews();
        this.f176s = null;
        this.f167i = null;
        this.f168j = null;
        View view = this.f175r;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.View
    /* renamed from: g */
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, c.a.f1684a, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
        n nVar = this.f168j;
        if (nVar != null) {
            Configuration configuration2 = nVar.f415h.getResources().getConfiguration();
            int i5 = configuration2.screenWidthDp;
            int i6 = configuration2.screenHeightDp;
            nVar.f428v = (configuration2.smallestScreenWidthDp > 600 || i5 > 600 || (i5 > 960 && i6 > 720) || (i5 > 720 && i6 > 960)) ? 5 : (i5 >= 500 || (i5 > 640 && i6 > 480) || (i5 > 480 && i6 > 640)) ? 4 : i5 >= 360 ? 3 : 2;
            h.o oVar = nVar.f416i;
            if (oVar != null) {
                oVar.p(true);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.f170l != null ? this.f165g.f273b : getVisibility();
    }

    public int getContentHeight() {
        return this.f169k;
    }

    public CharSequence getSubtitle() {
        return this.f173p;
    }

    public CharSequence getTitle() {
        return this.o;
    }

    @Override // android.view.View
    /* renamed from: h */
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f172n = false;
        }
        if (!this.f172n) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f172n = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f172n = false;
        }
        return true;
    }

    @Override // android.view.View
    /* renamed from: i */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f171m = false;
        }
        if (!this.f171m) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f171m = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f171m = false;
        }
        return true;
    }

    @Override // android.view.View
    /* renamed from: k */
    public final void setVisibility(int i5) {
        if (i5 != getVisibility()) {
            h0.k1 k1Var = this.f170l;
            if (k1Var != null) {
                k1Var.b();
            }
            super.setVisibility(i5);
        }
    }

    public final h0.k1 l(long j5, int i5) {
        h0.k1 k1Var = this.f170l;
        if (k1Var != null) {
            k1Var.b();
        }
        a aVar = this.f165g;
        if (i5 != 0) {
            h0.k1 a5 = h0.z0.a(this);
            a5.a(0.0f);
            a5.c(j5);
            ((ActionBarContextView) aVar.f274c).f170l = a5;
            aVar.f273b = i5;
            a5.d(aVar);
            return a5;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        h0.k1 a6 = h0.z0.a(this);
        a6.a(1.0f);
        a6.c(j5);
        ((ActionBarContextView) aVar.f274c).f170l = a6;
        aVar.f273b = i5;
        a6.d(aVar);
        return a6;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n nVar = this.f168j;
        if (nVar != null) {
            nVar.f();
            i iVar = this.f168j.f432z;
            if (iVar == null || !iVar.b()) {
                return;
            }
            iVar.f3087j.dismiss();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        boolean z5 = v3.f560a;
        boolean z6 = getLayoutDirection() == 1;
        int paddingRight = z6 ? (i7 - i5) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i8 - i6) - getPaddingTop()) - getPaddingBottom();
        View view = this.f174q;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f174q.getLayoutParams();
            int i9 = z6 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i10 = z6 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i11 = z6 ? paddingRight - i9 : paddingRight + i9;
            int j5 = j(this.f174q, z6, i11, paddingTop, paddingTop2) + i11;
            paddingRight = z6 ? j5 - i10 : j5 + i10;
        }
        LinearLayout linearLayout = this.f177t;
        if (linearLayout != null && this.f176s == null && linearLayout.getVisibility() != 8) {
            paddingRight += j(this.f177t, z6, paddingRight, paddingTop, paddingTop2);
        }
        View view2 = this.f176s;
        if (view2 != null) {
            j(view2, z6, paddingRight, paddingTop, paddingTop2);
        }
        int paddingLeft = z6 ? getPaddingLeft() : (i7 - i5) - getPaddingRight();
        ActionMenuView actionMenuView = this.f167i;
        if (actionMenuView != null) {
            j(actionMenuView, !z6, paddingLeft, paddingTop, paddingTop2);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        if (View.MeasureSpec.getMode(i5) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i6) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i5);
        int i7 = this.f169k;
        if (i7 <= 0) {
            i7 = View.MeasureSpec.getSize(i6);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i8 = i7 - paddingBottom;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE);
        View view = this.f174q;
        if (view != null) {
            int f5 = f(view, paddingLeft, makeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f174q.getLayoutParams();
            paddingLeft = f5 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f167i;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = f(this.f167i, paddingLeft, makeMeasureSpec);
        }
        LinearLayout linearLayout = this.f177t;
        if (linearLayout != null && this.f176s == null) {
            if (this.f182y) {
                this.f177t.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.f177t.getMeasuredWidth();
                boolean z4 = measuredWidth <= paddingLeft;
                if (z4) {
                    paddingLeft -= measuredWidth;
                }
                this.f177t.setVisibility(z4 ? 0 : 8);
            } else {
                paddingLeft = f(linearLayout, paddingLeft, makeMeasureSpec);
            }
        }
        View view2 = this.f176s;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i9 = layoutParams.width;
            int i10 = i9 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i9 >= 0) {
                paddingLeft = Math.min(i9, paddingLeft);
            }
            int i11 = layoutParams.height;
            int i12 = i11 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i11 >= 0) {
                i8 = Math.min(i11, i8);
            }
            this.f176s.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i10), View.MeasureSpec.makeMeasureSpec(i8, i12));
        }
        if (this.f169k > 0) {
            setMeasuredDimension(size, i7);
            return;
        }
        int childCount = getChildCount();
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            int measuredHeight = getChildAt(i14).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i13) {
                i13 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i13);
    }

    public void setContentHeight(int i5) {
        this.f169k = i5;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f176s;
        if (view2 != null) {
            removeView(view2);
        }
        this.f176s = view;
        if (view != null && (linearLayout = this.f177t) != null) {
            removeView(linearLayout);
            this.f177t = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f173p = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.o = charSequence;
        d();
        h0.z0.o(this, charSequence);
    }

    public void setTitleOptional(boolean z4) {
        if (z4 != this.f182y) {
            requestLayout();
        }
        this.f182y = z4;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
