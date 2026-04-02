package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
/* loaded from: classes.dex */
public class t extends Button {

    /* renamed from: g  reason: collision with root package name */
    public final s f529g;

    /* renamed from: h  reason: collision with root package name */
    public final e1 f530h;

    /* renamed from: i  reason: collision with root package name */
    public e0 f531i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        e3.a(context);
        d3.a(this, getContext());
        s sVar = new s(this);
        this.f529g = sVar;
        sVar.e(attributeSet, i5);
        e1 e1Var = new e1(this);
        this.f530h = e1Var;
        e1Var.f(attributeSet, i5);
        e1Var.b();
        getEmojiTextViewHelper().b(attributeSet, i5);
    }

    private e0 getEmojiTextViewHelper() {
        if (this.f531i == null) {
            this.f531i = new e0(this);
        }
        return this.f531i;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        s sVar = this.f529g;
        if (sVar != null) {
            sVar.a();
        }
        e1 e1Var = this.f530h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (v3.f562c) {
            return super.getAutoSizeMaxTextSize();
        }
        e1 e1Var = this.f530h;
        if (e1Var != null) {
            return Math.round(e1Var.f329i.f443e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (v3.f562c) {
            return super.getAutoSizeMinTextSize();
        }
        e1 e1Var = this.f530h;
        if (e1Var != null) {
            return Math.round(e1Var.f329i.f442d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (v3.f562c) {
            return super.getAutoSizeStepGranularity();
        }
        e1 e1Var = this.f530h;
        if (e1Var != null) {
            return Math.round(e1Var.f329i.f441c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (v3.f562c) {
            return super.getAutoSizeTextAvailableSizes();
        }
        e1 e1Var = this.f530h;
        return e1Var != null ? e1Var.f329i.f444f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (v3.f562c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        e1 e1Var = this.f530h;
        if (e1Var != null) {
            return e1Var.f329i.f439a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return b4.j.e0(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        s sVar = this.f529g;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        s sVar = this.f529g;
        if (sVar != null) {
            return sVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f530h.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f530h.e();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        e1 e1Var = this.f530h;
        if (e1Var == null || v3.f562c) {
            return;
        }
        e1Var.f329i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        super.onTextChanged(charSequence, i5, i6, i7);
        boolean z4 = false;
        e1 e1Var = this.f530h;
        if (e1Var != null && !v3.f562c) {
            o1 o1Var = e1Var.f329i;
            if (o1Var.i() && o1Var.f439a != 0) {
                z4 = true;
            }
        }
        if (z4) {
            e1Var.f329i.a();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i5, int i6, int i7, int i8) {
        if (v3.f562c) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i5, i6, i7, i8);
            return;
        }
        e1 e1Var = this.f530h;
        if (e1Var != null) {
            e1Var.i(i5, i6, i7, i8);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i5) {
        if (v3.f562c) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i5);
            return;
        }
        e1 e1Var = this.f530h;
        if (e1Var != null) {
            e1Var.j(iArr, i5);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i5) {
        if (v3.f562c) {
            super.setAutoSizeTextTypeWithDefaults(i5);
            return;
        }
        e1 e1Var = this.f530h;
        if (e1Var != null) {
            e1Var.k(i5);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        s sVar = this.f529g;
        if (sVar != null) {
            sVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        s sVar = this.f529g;
        if (sVar != null) {
            sVar.g(i5);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(b4.j.f0(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z4) {
        getEmojiTextViewHelper().d(z4);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z4) {
        e1 e1Var = this.f530h;
        if (e1Var != null) {
            e1Var.f321a.setAllCaps(z4);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        s sVar = this.f529g;
        if (sVar != null) {
            sVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        s sVar = this.f529g;
        if (sVar != null) {
            sVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        e1 e1Var = this.f530h;
        e1Var.l(colorStateList);
        e1Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        e1 e1Var = this.f530h;
        e1Var.m(mode);
        e1Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        e1 e1Var = this.f530h;
        if (e1Var != null) {
            e1Var.g(context, i5);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i5, float f5) {
        boolean z4 = v3.f562c;
        if (z4) {
            super.setTextSize(i5, f5);
            return;
        }
        e1 e1Var = this.f530h;
        if (e1Var == null || z4) {
            return;
        }
        o1 o1Var = e1Var.f329i;
        if (o1Var.i() && o1Var.f439a != 0) {
            return;
        }
        o1Var.f(i5, f5);
    }
}
