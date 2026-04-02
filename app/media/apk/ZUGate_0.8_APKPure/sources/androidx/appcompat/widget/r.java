package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.github.appintro.R;
/* loaded from: classes.dex */
public class r extends AutoCompleteTextView {

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f500j = {16843126};

    /* renamed from: g  reason: collision with root package name */
    public final s f501g;

    /* renamed from: h  reason: collision with root package name */
    public final e1 f502h;

    /* renamed from: i  reason: collision with root package name */
    public final d0 f503i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        e3.a(context);
        d3.a(this, getContext());
        z2 m5 = z2.m(getContext(), attributeSet, f500j, R.attr.autoCompleteTextViewStyle);
        if (m5.l(0)) {
            setDropDownBackgroundDrawable(m5.e(0));
        }
        m5.n();
        s sVar = new s(this);
        this.f501g = sVar;
        sVar.e(attributeSet, R.attr.autoCompleteTextViewStyle);
        e1 e1Var = new e1(this);
        this.f502h = e1Var;
        e1Var.f(attributeSet, R.attr.autoCompleteTextViewStyle);
        e1Var.b();
        d0 d0Var = new d0((EditText) this);
        this.f503i = d0Var;
        d0Var.j(attributeSet, R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener i5 = d0Var.i(keyListener);
            if (i5 == keyListener) {
                return;
            }
            super.setKeyListener(i5);
            super.setRawInputType(inputType);
            super.setFocusable(isFocusable);
            super.setClickable(isClickable);
            super.setLongClickable(isLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        s sVar = this.f501g;
        if (sVar != null) {
            sVar.a();
        }
        e1 e1Var = this.f502h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return b4.j.e0(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        s sVar = this.f501g;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        s sVar = this.f501g;
        if (sVar != null) {
            return sVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f502h.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f502h.e();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        p2.a.L(this, editorInfo, onCreateInputConnection);
        return this.f503i.l(onCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        s sVar = this.f501g;
        if (sVar != null) {
            sVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        s sVar = this.f501g;
        if (sVar != null) {
            sVar.g(i5);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        e1 e1Var = this.f502h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        e1 e1Var = this.f502h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(b4.j.f0(callback, this));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i5) {
        setDropDownBackgroundDrawable(p2.a.x(getContext(), i5));
    }

    public void setEmojiCompatEnabled(boolean z4) {
        ((p3.e) ((s0.b) this.f503i.f307i).f4806a).w(z4);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f503i.i(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        s sVar = this.f501g;
        if (sVar != null) {
            sVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        s sVar = this.f501g;
        if (sVar != null) {
            sVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        e1 e1Var = this.f502h;
        e1Var.l(colorStateList);
        e1Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        e1 e1Var = this.f502h;
        e1Var.m(mode);
        e1Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        e1 e1Var = this.f502h;
        if (e1Var != null) {
            e1Var.g(context, i5);
        }
    }
}
