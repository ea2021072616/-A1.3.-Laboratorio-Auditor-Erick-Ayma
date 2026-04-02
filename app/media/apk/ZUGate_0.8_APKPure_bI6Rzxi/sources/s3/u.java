package s3;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.j0;
import androidx.appcompat.widget.o2;
import com.github.appintro.R;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public final class u extends androidx.appcompat.widget.r {

    /* renamed from: k  reason: collision with root package name */
    public final o2 f4954k;

    /* renamed from: l  reason: collision with root package name */
    public final AccessibilityManager f4955l;

    /* renamed from: m  reason: collision with root package name */
    public final Rect f4956m;

    /* renamed from: n  reason: collision with root package name */
    public final int f4957n;
    public final float o;

    /* renamed from: p  reason: collision with root package name */
    public ColorStateList f4958p;

    /* renamed from: q  reason: collision with root package name */
    public int f4959q;

    /* renamed from: r  reason: collision with root package name */
    public ColorStateList f4960r;

    public u(Context context, AttributeSet attributeSet) {
        super(p2.a.b0(context, attributeSet, R.attr.autoCompleteTextViewStyle, 0), attributeSet);
        this.f4956m = new Rect();
        Context context2 = getContext();
        TypedArray D = b4.j.D(context2, attributeSet, w2.a.f5394i, R.attr.autoCompleteTextViewStyle, 2131952412, new int[0]);
        if (D.hasValue(0) && D.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.f4957n = D.getResourceId(3, R.layout.mtrl_auto_complete_simple_item);
        this.o = D.getDimensionPixelOffset(1, R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        if (D.hasValue(2)) {
            this.f4958p = ColorStateList.valueOf(D.getColor(2, 0));
        }
        this.f4959q = D.getColor(4, 0);
        this.f4960r = p2.a.v(context2, D, 5);
        this.f4955l = (AccessibilityManager) context2.getSystemService("accessibility");
        o2 o2Var = new o2(context2, null, R.attr.listPopupWindowStyle, 0);
        this.f4954k = o2Var;
        o2Var.E = true;
        j0 j0Var = o2Var.F;
        j0Var.setFocusable(true);
        o2Var.f463u = this;
        j0Var.setInputMethodMode(2);
        o2Var.o(getAdapter());
        o2Var.f464v = new s(this);
        if (D.hasValue(6)) {
            setSimpleItems(D.getResourceId(6, 0));
        }
        D.recycle();
    }

    public static void a(u uVar, Object obj) {
        uVar.setText(uVar.convertSelectionToString(obj), false);
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final boolean c() {
        boolean z4;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f4955l;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            return true;
        }
        if (accessibilityManager != null && accessibilityManager.isEnabled() && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16)) != null) {
            for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                    z4 = true;
                    break;
                }
            }
        }
        z4 = false;
        return z4;
    }

    @Override // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        if (c()) {
            this.f4954k.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f4958p;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout b5 = b();
        return (b5 == null || !b5.K) ? super.getHint() : b5.getHint();
    }

    public float getPopupElevation() {
        return this.o;
    }

    public int getSimpleItemSelectedColor() {
        return this.f4959q;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f4960r;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout b5 = b();
        if (b5 != null && b5.K && super.getHint() == null) {
            String str = Build.MANUFACTURER;
            if ((str != null ? str.toLowerCase(Locale.ENGLISH) : "").equals("meizu")) {
                setHint("");
            }
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4954k.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (View.MeasureSpec.getMode(i5) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout b5 = b();
            int i7 = 0;
            if (adapter != null && b5 != null) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                o2 o2Var = this.f4954k;
                int min = Math.min(adapter.getCount(), Math.max(0, !o2Var.a() ? -1 : o2Var.f452i.getSelectedItemPosition()) + 15);
                View view = null;
                int i8 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i7) {
                        view = null;
                        i7 = itemViewType;
                    }
                    view = adapter.getView(max, view, b5);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i8 = Math.max(i8, view.getMeasuredWidth());
                }
                Drawable h5 = o2Var.h();
                if (h5 != null) {
                    Rect rect = this.f4956m;
                    h5.getPadding(rect);
                    i8 += rect.left + rect.right;
                }
                i7 = b5.getEndIconView().getMeasuredWidth() + i8;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i7), View.MeasureSpec.getSize(i5)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        if (c()) {
            return;
        }
        super.onWindowFocusChanged(z4);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t5) {
        super.setAdapter(t5);
        this.f4954k.o(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        o2 o2Var = this.f4954k;
        if (o2Var != null) {
            o2Var.m(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i5) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i5));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f4958p = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof p3.g) {
            ((p3.g) dropDownBackground).j(this.f4958p);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f4954k.f465w = getOnItemSelectedListener();
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i5) {
        super.setRawInputType(i5);
        TextInputLayout b5 = b();
        if (b5 != null) {
            b5.s();
        }
    }

    public void setSimpleItemSelectedColor(int i5) {
        this.f4959q = i5;
        if (getAdapter() instanceof t) {
            ((t) getAdapter()).a();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f4960r = colorStateList;
        if (getAdapter() instanceof t) {
            ((t) getAdapter()).a();
        }
    }

    public void setSimpleItems(int i5) {
        setSimpleItems(getResources().getStringArray(i5));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        if (c()) {
            this.f4954k.f();
        } else {
            super.showDropDown();
        }
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new t(this, getContext(), this.f4957n, strArr));
    }
}
