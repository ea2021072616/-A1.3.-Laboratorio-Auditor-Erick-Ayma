package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.t;
import b4.j;
import c3.a;
import c3.b;
import c3.c;
import com.github.appintro.R;
import h0.z0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import p3.u;
import w1.h;
/* loaded from: classes.dex */
public class MaterialButton extends t implements Checkable, u {

    /* renamed from: x  reason: collision with root package name */
    public static final int[] f2051x = {16842911};

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f2052y = {16842912};

    /* renamed from: j  reason: collision with root package name */
    public final c f2053j;

    /* renamed from: k  reason: collision with root package name */
    public final LinkedHashSet f2054k;

    /* renamed from: l  reason: collision with root package name */
    public a f2055l;

    /* renamed from: m  reason: collision with root package name */
    public PorterDuff.Mode f2056m;

    /* renamed from: n  reason: collision with root package name */
    public ColorStateList f2057n;
    public Drawable o;

    /* renamed from: p  reason: collision with root package name */
    public String f2058p;

    /* renamed from: q  reason: collision with root package name */
    public int f2059q;

    /* renamed from: r  reason: collision with root package name */
    public int f2060r;

    /* renamed from: s  reason: collision with root package name */
    public int f2061s;

    /* renamed from: t  reason: collision with root package name */
    public int f2062t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f2063u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f2064v;

    /* renamed from: w  reason: collision with root package name */
    public int f2065w;

    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(p2.a.b0(context, attributeSet, R.attr.materialButtonStyle, 2131952680), attributeSet, R.attr.materialButtonStyle);
        this.f2054k = new LinkedHashSet();
        this.f2063u = false;
        this.f2064v = false;
        Context context2 = getContext();
        TypedArray D = j.D(context2, attributeSet, w2.a.f5395j, R.attr.materialButtonStyle, 2131952680, new int[0]);
        this.f2062t = D.getDimensionPixelSize(12, 0);
        this.f2056m = p2.a.O(D.getInt(15, -1), PorterDuff.Mode.SRC_IN);
        this.f2057n = p2.a.v(getContext(), D, 14);
        this.o = p2.a.y(getContext(), D, 10);
        this.f2065w = D.getInteger(11, 1);
        this.f2059q = D.getDimensionPixelSize(13, 0);
        c cVar = new c(this, new p3.j(p3.j.b(context2, attributeSet, R.attr.materialButtonStyle, 2131952680)));
        this.f2053j = cVar;
        cVar.f1767c = D.getDimensionPixelOffset(1, 0);
        cVar.f1768d = D.getDimensionPixelOffset(2, 0);
        cVar.f1769e = D.getDimensionPixelOffset(3, 0);
        cVar.f1770f = D.getDimensionPixelOffset(4, 0);
        if (D.hasValue(8)) {
            int dimensionPixelSize = D.getDimensionPixelSize(8, -1);
            cVar.f1771g = dimensionPixelSize;
            p3.j jVar = cVar.f1766b;
            float f5 = dimensionPixelSize;
            jVar.getClass();
            h hVar = new h(jVar);
            hVar.f5338e = new p3.a(f5);
            hVar.f5339f = new p3.a(f5);
            hVar.f5340g = new p3.a(f5);
            hVar.f5341h = new p3.a(f5);
            cVar.c(new p3.j(hVar));
            cVar.f1779p = true;
        }
        cVar.f1772h = D.getDimensionPixelSize(20, 0);
        cVar.f1773i = p2.a.O(D.getInt(7, -1), PorterDuff.Mode.SRC_IN);
        cVar.f1774j = p2.a.v(getContext(), D, 6);
        cVar.f1775k = p2.a.v(getContext(), D, 19);
        cVar.f1776l = p2.a.v(getContext(), D, 16);
        cVar.f1780q = D.getBoolean(5, false);
        cVar.f1783t = D.getDimensionPixelSize(9, 0);
        cVar.f1781r = D.getBoolean(21, true);
        WeakHashMap weakHashMap = z0.f3233a;
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (D.hasValue(0)) {
            cVar.o = true;
            setSupportBackgroundTintList(cVar.f1774j);
            setSupportBackgroundTintMode(cVar.f1773i);
        } else {
            cVar.e();
        }
        setPaddingRelative(paddingStart + cVar.f1767c, paddingTop + cVar.f1769e, paddingEnd + cVar.f1768d, paddingBottom + cVar.f1770f);
        D.recycle();
        setCompoundDrawablePadding(this.f2062t);
        c(this.o != null);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f5 = 0.0f;
        for (int i5 = 0; i5 < lineCount; i5++) {
            f5 = Math.max(f5, getLayout().getLineWidth(i5));
        }
        return (int) Math.ceil(f5);
    }

    public final boolean a() {
        c cVar = this.f2053j;
        return (cVar == null || cVar.o) ? false : true;
    }

    public final void b() {
        int i5 = this.f2065w;
        boolean z4 = false;
        if (i5 == 1 || i5 == 2) {
            setCompoundDrawablesRelative(this.o, null, null, null);
            return;
        }
        if (i5 == 3 || i5 == 4) {
            setCompoundDrawablesRelative(null, null, this.o, null);
            return;
        }
        if (i5 == 16 || i5 == 32) {
            z4 = true;
        }
        if (z4) {
            setCompoundDrawablesRelative(null, this.o, null, null);
        }
    }

    public final void c(boolean z4) {
        Drawable drawable = this.o;
        boolean z5 = true;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.o = mutate;
            a0.a.h(mutate, this.f2057n);
            PorterDuff.Mode mode = this.f2056m;
            if (mode != null) {
                a0.a.i(this.o, mode);
            }
            int i5 = this.f2059q;
            if (i5 == 0) {
                i5 = this.o.getIntrinsicWidth();
            }
            int i6 = this.f2059q;
            if (i6 == 0) {
                i6 = this.o.getIntrinsicHeight();
            }
            Drawable drawable2 = this.o;
            int i7 = this.f2060r;
            int i8 = this.f2061s;
            drawable2.setBounds(i7, i8, i5 + i7, i6 + i8);
            this.o.setVisible(true, z4);
        }
        if (z4) {
            b();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i9 = this.f2065w;
        if (!(i9 == 1 || i9 == 2) || drawable3 == this.o) {
            if (!(i9 == 3 || i9 == 4) || drawable5 == this.o) {
                if (!(i9 == 16 || i9 == 32) || drawable4 == this.o) {
                    z5 = false;
                }
            }
        }
        if (z5) {
            b();
        }
    }

    public final void d(int i5, int i6) {
        if (this.o == null || getLayout() == null) {
            return;
        }
        int i7 = this.f2065w;
        if (!(i7 == 1 || i7 == 2)) {
            if (!(i7 == 3 || i7 == 4)) {
                if (i7 != 16 && i7 != 32) {
                    r3 = false;
                }
                if (r3) {
                    this.f2060r = 0;
                    if (i7 == 16) {
                        this.f2061s = 0;
                        c(false);
                        return;
                    }
                    int i8 = this.f2059q;
                    if (i8 == 0) {
                        i8 = this.o.getIntrinsicHeight();
                    }
                    int max = Math.max(0, (((((i6 - getTextHeight()) - getPaddingTop()) - i8) - this.f2062t) - getPaddingBottom()) / 2);
                    if (this.f2061s != max) {
                        this.f2061s = max;
                        c(false);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        this.f2061s = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i9 = this.f2065w;
        if (i9 == 1 || i9 == 3 || ((i9 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i9 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f2060r = 0;
            c(false);
            return;
        }
        int i10 = this.f2059q;
        if (i10 == 0) {
            i10 = this.o.getIntrinsicWidth();
        }
        int textLayoutWidth = i5 - getTextLayoutWidth();
        WeakHashMap weakHashMap = z0.f3233a;
        int paddingEnd = (((textLayoutWidth - getPaddingEnd()) - i10) - this.f2062t) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            paddingEnd /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.f2065w == 4)) {
            paddingEnd = -paddingEnd;
        }
        if (this.f2060r != paddingEnd) {
            this.f2060r = paddingEnd;
            c(false);
        }
    }

    public String getA11yClassName() {
        if (TextUtils.isEmpty(this.f2058p)) {
            c cVar = this.f2053j;
            return (cVar != null && cVar.f1780q ? CompoundButton.class : Button.class).getName();
        }
        return this.f2058p;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (a()) {
            return this.f2053j.f1771g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.o;
    }

    public int getIconGravity() {
        return this.f2065w;
    }

    public int getIconPadding() {
        return this.f2062t;
    }

    public int getIconSize() {
        return this.f2059q;
    }

    public ColorStateList getIconTint() {
        return this.f2057n;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f2056m;
    }

    public int getInsetBottom() {
        return this.f2053j.f1770f;
    }

    public int getInsetTop() {
        return this.f2053j.f1769e;
    }

    public ColorStateList getRippleColor() {
        if (a()) {
            return this.f2053j.f1776l;
        }
        return null;
    }

    public p3.j getShapeAppearanceModel() {
        if (a()) {
            return this.f2053j.f1766b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (a()) {
            return this.f2053j.f1775k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (a()) {
            return this.f2053j.f1772h;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.t
    public ColorStateList getSupportBackgroundTintList() {
        return a() ? this.f2053j.f1774j : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return a() ? this.f2053j.f1773i : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f2063u;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (a()) {
            p2.a.U(this, this.f2053j.b(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i5) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i5 + 2);
        c cVar = this.f2053j;
        if (cVar != null && cVar.f1780q) {
            View.mergeDrawableStates(onCreateDrawableState, f2051x);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f2052y);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.t, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.t, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        c cVar = this.f2053j;
        accessibilityNodeInfo.setCheckable(cVar != null && cVar.f1780q);
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.t, android.widget.TextView, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.f4245b);
        setChecked(bVar.f1764d);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f1764d = this.f2063u;
        return bVar;
    }

    @Override // androidx.appcompat.widget.t, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        super.onTextChanged(charSequence, i5, i6, i7);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.f2053j.f1781r) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.o != null) {
            if (this.o.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.f2058p = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i5) {
        if (!a()) {
            super.setBackgroundColor(i5);
            return;
        }
        c cVar = this.f2053j;
        if (cVar.b(false) != null) {
            cVar.b(false).setTint(i5);
        }
    }

    @Override // androidx.appcompat.widget.t, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!a()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
        } else {
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            c cVar = this.f2053j;
            cVar.o = true;
            ColorStateList colorStateList = cVar.f1774j;
            MaterialButton materialButton = cVar.f1765a;
            materialButton.setSupportBackgroundTintList(colorStateList);
            materialButton.setSupportBackgroundTintMode(cVar.f1773i);
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.t, android.view.View
    public void setBackgroundResource(int i5) {
        setBackgroundDrawable(i5 != 0 ? p2.a.x(getContext(), i5) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z4) {
        if (a()) {
            this.f2053j.f1780q = z4;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z4) {
        c cVar = this.f2053j;
        if ((cVar != null && cVar.f1780q) && isEnabled() && this.f2063u != z4) {
            this.f2063u = z4;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
                boolean z5 = this.f2063u;
                if (!materialButtonToggleGroup.f2072l) {
                    materialButtonToggleGroup.b(getId(), z5);
                }
            }
            if (this.f2064v) {
                return;
            }
            this.f2064v = true;
            Iterator it = this.f2054k.iterator();
            if (it.hasNext()) {
                b0.n(it.next());
                throw null;
            } else {
                this.f2064v = false;
            }
        }
    }

    public void setCornerRadius(int i5) {
        if (a()) {
            c cVar = this.f2053j;
            if (cVar.f1779p && cVar.f1771g == i5) {
                return;
            }
            cVar.f1771g = i5;
            cVar.f1779p = true;
            p3.j jVar = cVar.f1766b;
            float f5 = i5;
            jVar.getClass();
            h hVar = new h(jVar);
            hVar.f5338e = new p3.a(f5);
            hVar.f5339f = new p3.a(f5);
            hVar.f5340g = new p3.a(f5);
            hVar.f5341h = new p3.a(f5);
            cVar.c(new p3.j(hVar));
        }
    }

    public void setCornerRadiusResource(int i5) {
        if (a()) {
            setCornerRadius(getResources().getDimensionPixelSize(i5));
        }
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        super.setElevation(f5);
        if (a()) {
            this.f2053j.b(false).i(f5);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.o != drawable) {
            this.o = drawable;
            c(true);
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i5) {
        if (this.f2065w != i5) {
            this.f2065w = i5;
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i5) {
        if (this.f2062t != i5) {
            this.f2062t = i5;
            setCompoundDrawablePadding(i5);
        }
    }

    public void setIconResource(int i5) {
        setIcon(i5 != 0 ? p2.a.x(getContext(), i5) : null);
    }

    public void setIconSize(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f2059q != i5) {
            this.f2059q = i5;
            c(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f2057n != colorStateList) {
            this.f2057n = colorStateList;
            c(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f2056m != mode) {
            this.f2056m = mode;
            c(false);
        }
    }

    public void setIconTintResource(int i5) {
        setIconTint(p2.a.u(getContext(), i5));
    }

    public void setInsetBottom(int i5) {
        c cVar = this.f2053j;
        cVar.d(cVar.f1769e, i5);
    }

    public void setInsetTop(int i5) {
        c cVar = this.f2053j;
        cVar.d(i5, cVar.f1770f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(a aVar) {
        this.f2055l = aVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z4) {
        a aVar = this.f2055l;
        if (aVar != null) {
            ((MaterialButtonToggleGroup) ((n2.b) aVar).f4085g).invalidate();
        }
        super.setPressed(z4);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (a()) {
            c cVar = this.f2053j;
            if (cVar.f1776l != colorStateList) {
                cVar.f1776l = colorStateList;
                MaterialButton materialButton = cVar.f1765a;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(n3.a.a(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i5) {
        if (a()) {
            setRippleColor(p2.a.u(getContext(), i5));
        }
    }

    @Override // p3.u
    public void setShapeAppearanceModel(p3.j jVar) {
        if (!a()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f2053j.c(jVar);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z4) {
        if (a()) {
            c cVar = this.f2053j;
            cVar.f1778n = z4;
            cVar.f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (a()) {
            c cVar = this.f2053j;
            if (cVar.f1775k != colorStateList) {
                cVar.f1775k = colorStateList;
                cVar.f();
            }
        }
    }

    public void setStrokeColorResource(int i5) {
        if (a()) {
            setStrokeColor(p2.a.u(getContext(), i5));
        }
    }

    public void setStrokeWidth(int i5) {
        if (a()) {
            c cVar = this.f2053j;
            if (cVar.f1772h != i5) {
                cVar.f1772h = i5;
                cVar.f();
            }
        }
    }

    public void setStrokeWidthResource(int i5) {
        if (a()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i5));
        }
    }

    @Override // androidx.appcompat.widget.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!a()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        c cVar = this.f2053j;
        if (cVar.f1774j != colorStateList) {
            cVar.f1774j = colorStateList;
            if (cVar.b(false) != null) {
                a0.a.h(cVar.b(false), cVar.f1774j);
            }
        }
    }

    @Override // androidx.appcompat.widget.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!a()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        c cVar = this.f2053j;
        if (cVar.f1773i != mode) {
            cVar.f1773i = mode;
            if (cVar.b(false) == null || cVar.f1773i == null) {
                return;
            }
            a0.a.i(cVar.b(false), cVar.f1773i);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i5) {
        super.setTextAlignment(i5);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z4) {
        this.f2053j.f1781r = z4;
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f2063u);
    }
}
