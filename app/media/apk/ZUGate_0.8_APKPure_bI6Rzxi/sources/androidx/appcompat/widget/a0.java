package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import com.github.appintro.R;
/* loaded from: classes.dex */
public class a0 extends EditText implements h0.z {

    /* renamed from: g  reason: collision with root package name */
    public final s f275g;

    /* renamed from: h  reason: collision with root package name */
    public final e1 f276h;

    /* renamed from: i  reason: collision with root package name */
    public final d0 f277i;

    /* renamed from: j  reason: collision with root package name */
    public final n0.r f278j;

    /* renamed from: k  reason: collision with root package name */
    public final d0 f279k;

    /* renamed from: l  reason: collision with root package name */
    public z f280l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, R.attr.editTextStyle);
        e3.a(context);
        d3.a(this, getContext());
        s sVar = new s(this);
        this.f275g = sVar;
        sVar.e(attributeSet, R.attr.editTextStyle);
        e1 e1Var = new e1(this);
        this.f276h = e1Var;
        e1Var.f(attributeSet, R.attr.editTextStyle);
        e1Var.b();
        this.f277i = new d0((TextView) this);
        this.f278j = new n0.r();
        d0 d0Var = new d0((EditText) this);
        this.f279k = d0Var;
        d0Var.j(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener i6 = d0Var.i(keyListener);
            if (i6 == keyListener) {
                return;
            }
            super.setKeyListener(i6);
            super.setRawInputType(inputType);
            super.setFocusable(isFocusable);
            super.setClickable(isClickable);
            super.setLongClickable(isLongClickable);
        }
    }

    private z getSuperCaller() {
        if (this.f280l == null) {
            this.f280l = new z(this);
        }
        return this.f280l;
    }

    @Override // h0.z
    public final h0.g a(h0.g gVar) {
        return this.f278j.a(this, gVar);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        s sVar = this.f275g;
        if (sVar != null) {
            sVar.a();
        }
        e1 e1Var = this.f276h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return b4.j.e0(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        s sVar = this.f275g;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        s sVar = this.f275g;
        if (sVar != null) {
            return sVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f276h.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f276h.e();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        d0 d0Var;
        if (Build.VERSION.SDK_INT >= 28 || (d0Var = this.f277i) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) d0Var.f307i;
        return textClassifier == null ? y0.a((TextView) d0Var.f306h) : textClassifier;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] g5;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f276h.getClass();
        e1.h(this, onCreateInputConnection, editorInfo);
        p2.a.L(this, editorInfo, onCreateInputConnection);
        if (onCreateInputConnection != null && Build.VERSION.SDK_INT <= 30 && (g5 = h0.z0.g(this)) != null) {
            editorInfo.contentMimeTypes = g5;
            onCreateInputConnection = new m0.b(onCreateInputConnection, new w.g(1, this));
        }
        return this.f279k.l(onCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 30 || i5 >= 33) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean z4 = false;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && h0.z0.g(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                } else if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                z4 = n0.a(dragEvent, this, activity);
            }
        }
        if (z4) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.TextView
    public final boolean onTextContextMenuItem(int i5) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 31 && h0.z0.g(this) != null && (i5 == 16908322 || i5 == 16908337)) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                h0.d cVar = i6 >= 31 ? new h0.c(primaryClip, 1) : new h0.e(primaryClip, 1);
                cVar.d(i5 != 16908322 ? 1 : 0);
                h0.z0.j(this, cVar.a());
            }
            r2 = 1;
        }
        if (r2 != 0) {
            return true;
        }
        return super.onTextContextMenuItem(i5);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        s sVar = this.f275g;
        if (sVar != null) {
            sVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        s sVar = this.f275g;
        if (sVar != null) {
            sVar.g(i5);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        e1 e1Var = this.f276h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        e1 e1Var = this.f276h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(b4.j.f0(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z4) {
        ((p3.e) ((s0.b) this.f279k.f307i).f4806a).w(z4);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f279k.i(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        s sVar = this.f275g;
        if (sVar != null) {
            sVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        s sVar = this.f275g;
        if (sVar != null) {
            sVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        e1 e1Var = this.f276h;
        e1Var.l(colorStateList);
        e1Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        e1 e1Var = this.f276h;
        e1Var.m(mode);
        e1Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        e1 e1Var = this.f276h;
        if (e1Var != null) {
            e1Var.g(context, i5);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        d0 d0Var;
        if (Build.VERSION.SDK_INT >= 28 || (d0Var = this.f277i) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            d0Var.f307i = textClassifier;
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }
}
