package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class v extends CheckedTextView {

    /* renamed from: g  reason: collision with root package name */
    public final w f544g;

    /* renamed from: h  reason: collision with root package name */
    public final s f545h;

    /* renamed from: i  reason: collision with root package name */
    public final e1 f546i;

    /* renamed from: j  reason: collision with root package name */
    public e0 f547j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        e3.a(context);
        d3.a(this, getContext());
        e1 e1Var = new e1(this);
        this.f546i = e1Var;
        e1Var.f(attributeSet, R.attr.checkedTextViewStyle);
        e1Var.b();
        s sVar = new s(this);
        this.f545h = sVar;
        sVar.e(attributeSet, R.attr.checkedTextViewStyle);
        w wVar = new w(this, 0);
        this.f544g = wVar;
        wVar.c(attributeSet, R.attr.checkedTextViewStyle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.checkedTextViewStyle);
    }

    private e0 getEmojiTextViewHelper() {
        if (this.f547j == null) {
            this.f547j = new e0(this);
        }
        return this.f547j;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        e1 e1Var = this.f546i;
        if (e1Var != null) {
            e1Var.b();
        }
        s sVar = this.f545h;
        if (sVar != null) {
            sVar.a();
        }
        w wVar = this.f544g;
        if (wVar != null) {
            wVar.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return b4.j.e0(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        s sVar = this.f545h;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        s sVar = this.f545h;
        if (sVar != null) {
            return sVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        w wVar = this.f544g;
        if (wVar != null) {
            return wVar.f564b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        w wVar = this.f544g;
        if (wVar != null) {
            return wVar.f565c;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f546i.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f546i.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        p2.a.L(this, editorInfo, onCreateInputConnection);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        s sVar = this.f545h;
        if (sVar != null) {
            sVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        s sVar = this.f545h;
        if (sVar != null) {
            sVar.g(i5);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        w wVar = this.f544g;
        if (wVar != null) {
            if (wVar.f568f) {
                wVar.f568f = false;
                return;
            }
            wVar.f568f = true;
            wVar.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        e1 e1Var = this.f546i;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        e1 e1Var = this.f546i;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(b4.j.f0(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z4) {
        getEmojiTextViewHelper().d(z4);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        s sVar = this.f545h;
        if (sVar != null) {
            sVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        s sVar = this.f545h;
        if (sVar != null) {
            sVar.j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        w wVar = this.f544g;
        if (wVar != null) {
            wVar.f564b = colorStateList;
            wVar.f566d = true;
            wVar.b();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        w wVar = this.f544g;
        if (wVar != null) {
            wVar.f565c = mode;
            wVar.f567e = true;
            wVar.b();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        e1 e1Var = this.f546i;
        e1Var.l(colorStateList);
        e1Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        e1 e1Var = this.f546i;
        e1Var.m(mode);
        e1Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        e1 e1Var = this.f546i;
        if (e1Var != null) {
            e1Var.g(context, i5);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i5) {
        setCheckMarkDrawable(p2.a.x(getContext(), i5));
    }
}
