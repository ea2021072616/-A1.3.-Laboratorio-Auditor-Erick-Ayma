package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
/* loaded from: classes.dex */
public class u extends CheckBox implements n0.s {

    /* renamed from: g  reason: collision with root package name */
    public final w f540g;

    /* renamed from: h  reason: collision with root package name */
    public final s f541h;

    /* renamed from: i  reason: collision with root package name */
    public final e1 f542i;

    /* renamed from: j  reason: collision with root package name */
    public e0 f543j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        e3.a(context);
        d3.a(this, getContext());
        w wVar = new w(this, 1);
        this.f540g = wVar;
        wVar.c(attributeSet, i5);
        s sVar = new s(this);
        this.f541h = sVar;
        sVar.e(attributeSet, i5);
        e1 e1Var = new e1(this);
        this.f542i = e1Var;
        e1Var.f(attributeSet, i5);
        getEmojiTextViewHelper().b(attributeSet, i5);
    }

    private e0 getEmojiTextViewHelper() {
        if (this.f543j == null) {
            this.f543j = new e0(this);
        }
        return this.f543j;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        s sVar = this.f541h;
        if (sVar != null) {
            sVar.a();
        }
        e1 e1Var = this.f542i;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        s sVar = this.f541h;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        s sVar = this.f541h;
        if (sVar != null) {
            return sVar.d();
        }
        return null;
    }

    @Override // n0.s
    public ColorStateList getSupportButtonTintList() {
        w wVar = this.f540g;
        if (wVar != null) {
            return wVar.f564b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        w wVar = this.f540g;
        if (wVar != null) {
            return wVar.f565c;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f542i.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f542i.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        s sVar = this.f541h;
        if (sVar != null) {
            sVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        s sVar = this.f541h;
        if (sVar != null) {
            sVar.g(i5);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        w wVar = this.f540g;
        if (wVar != null) {
            if (wVar.f568f) {
                wVar.f568f = false;
                return;
            }
            wVar.f568f = true;
            wVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        e1 e1Var = this.f542i;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        e1 e1Var = this.f542i;
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
        s sVar = this.f541h;
        if (sVar != null) {
            sVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        s sVar = this.f541h;
        if (sVar != null) {
            sVar.j(mode);
        }
    }

    @Override // n0.s
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        w wVar = this.f540g;
        if (wVar != null) {
            wVar.f564b = colorStateList;
            wVar.f566d = true;
            wVar.a();
        }
    }

    @Override // n0.s
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        w wVar = this.f540g;
        if (wVar != null) {
            wVar.f565c = mode;
            wVar.f567e = true;
            wVar.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        e1 e1Var = this.f542i;
        e1Var.l(colorStateList);
        e1Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        e1 e1Var = this.f542i;
        e1Var.m(mode);
        e1Var.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i5) {
        setButtonDrawable(p2.a.x(getContext(), i5));
    }
}
