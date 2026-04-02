package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;
/* loaded from: classes.dex */
public final class p1 extends ToggleButton {

    /* renamed from: g  reason: collision with root package name */
    public final s f483g;

    /* renamed from: h  reason: collision with root package name */
    public final e1 f484h;

    /* renamed from: i  reason: collision with root package name */
    public e0 f485i;

    public p1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842827);
        d3.a(this, getContext());
        s sVar = new s(this);
        this.f483g = sVar;
        sVar.e(attributeSet, 16842827);
        e1 e1Var = new e1(this);
        this.f484h = e1Var;
        e1Var.f(attributeSet, 16842827);
        getEmojiTextViewHelper().b(attributeSet, 16842827);
    }

    private e0 getEmojiTextViewHelper() {
        if (this.f485i == null) {
            this.f485i = new e0(this);
        }
        return this.f485i;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        s sVar = this.f483g;
        if (sVar != null) {
            sVar.a();
        }
        e1 e1Var = this.f484h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        s sVar = this.f483g;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        s sVar = this.f483g;
        if (sVar != null) {
            return sVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f484h.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f484h.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        s sVar = this.f483g;
        if (sVar != null) {
            sVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        s sVar = this.f483g;
        if (sVar != null) {
            sVar.g(i5);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        e1 e1Var = this.f484h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        e1 e1Var = this.f484h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z4) {
        getEmojiTextViewHelper().d(z4);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        s sVar = this.f483g;
        if (sVar != null) {
            sVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        s sVar = this.f483g;
        if (sVar != null) {
            sVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        e1 e1Var = this.f484h;
        e1Var.l(colorStateList);
        e1Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        e1 e1Var = this.f484h;
        e1Var.m(mode);
        e1Var.b();
    }
}
