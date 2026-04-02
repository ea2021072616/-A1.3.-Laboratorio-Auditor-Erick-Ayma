package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class i1 extends TextView {

    /* renamed from: g  reason: collision with root package name */
    public final s f382g;

    /* renamed from: h  reason: collision with root package name */
    public final e1 f383h;

    /* renamed from: i  reason: collision with root package name */
    public final d0 f384i;

    /* renamed from: j  reason: collision with root package name */
    public e0 f385j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f386k;

    /* renamed from: l  reason: collision with root package name */
    public d.u0 f387l;

    /* renamed from: m  reason: collision with root package name */
    public Future f388m;

    public i1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    private e0 getEmojiTextViewHelper() {
        if (this.f385j == null) {
            this.f385j = new e0(this);
        }
        return this.f385j;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        s sVar = this.f382g;
        if (sVar != null) {
            sVar.a();
        }
        e1 e1Var = this.f383h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (v3.f562c) {
            return super.getAutoSizeMaxTextSize();
        }
        e1 e1Var = this.f383h;
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
        e1 e1Var = this.f383h;
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
        e1 e1Var = this.f383h;
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
        e1 e1Var = this.f383h;
        return e1Var != null ? e1Var.f329i.f444f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (v3.f562c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        e1 e1Var = this.f383h;
        if (e1Var != null) {
            return e1Var.f329i.f439a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return b4.j.e0(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public f1 getSuperCaller() {
        if (this.f387l == null) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 34) {
                this.f387l = new h1(this);
            } else if (i5 >= 28) {
                this.f387l = new g1(this);
            } else {
                this.f387l = new d.u0(6, this);
            }
        }
        return this.f387l;
    }

    public ColorStateList getSupportBackgroundTintList() {
        s sVar = this.f382g;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        s sVar = this.f382g;
        if (sVar != null) {
            return sVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f383h.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f383h.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future future = this.f388m;
        if (future != null) {
            try {
                this.f388m = null;
                b0.n(future.get());
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                b4.j.y(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        d0 d0Var;
        if (Build.VERSION.SDK_INT >= 28 || (d0Var = this.f384i) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) d0Var.f307i;
        return textClassifier == null ? y0.a((TextView) d0Var.f306h) : textClassifier;
    }

    public f0.d getTextMetricsParamsCompat() {
        return b4.j.y(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f383h.getClass();
        e1.h(this, onCreateInputConnection, editorInfo);
        p2.a.L(this, editorInfo, onCreateInputConnection);
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 30 || i5 >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        e1 e1Var = this.f383h;
        if (e1Var == null || v3.f562c) {
            return;
        }
        e1Var.f329i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i5, int i6) {
        Future future = this.f388m;
        if (future != null) {
            try {
                this.f388m = null;
                b0.n(future.get());
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                b4.j.y(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i5, i6);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        super.onTextChanged(charSequence, i5, i6, i7);
        boolean z4 = false;
        e1 e1Var = this.f383h;
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
        e1 e1Var = this.f383h;
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
        e1 e1Var = this.f383h;
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
        e1 e1Var = this.f383h;
        if (e1Var != null) {
            e1Var.k(i5);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        s sVar = this.f382g;
        if (sVar != null) {
            sVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        s sVar = this.f382g;
        if (sVar != null) {
            sVar.g(i5);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        e1 e1Var = this.f383h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        e1 e1Var = this.f383h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        e1 e1Var = this.f383h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        e1 e1Var = this.f383h;
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

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i5) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().p(i5);
        } else {
            b4.j.X(this, i5);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i5) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().o(i5);
        } else {
            b4.j.Y(this, i5);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i5) {
        b4.j.Z(this, i5);
    }

    public void setPrecomputedText(f0.e eVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        b4.j.y(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        s sVar = this.f382g;
        if (sVar != null) {
            sVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        s sVar = this.f382g;
        if (sVar != null) {
            sVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        e1 e1Var = this.f383h;
        e1Var.l(colorStateList);
        e1Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        e1 e1Var = this.f383h;
        e1Var.m(mode);
        e1Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        e1 e1Var = this.f383h;
        if (e1Var != null) {
            e1Var.g(context, i5);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        d0 d0Var;
        if (Build.VERSION.SDK_INT >= 28 || (d0Var = this.f384i) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            d0Var.f307i = textClassifier;
        }
    }

    public void setTextFuture(Future<f0.e> future) {
        this.f388m = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(f0.d dVar) {
        int i5;
        TextDirectionHeuristic textDirectionHeuristic = dVar.f2734b;
        if (textDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_RTL && textDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
                i5 = 2;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
                i5 = 3;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
                i5 = 4;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
                i5 = 5;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                i5 = 6;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                i5 = 7;
            }
            setTextDirection(i5);
            getPaint().set(dVar.f2733a);
            n0.m.e(this, dVar.f2735c);
            n0.m.h(this, dVar.f2736d);
        }
        i5 = 1;
        setTextDirection(i5);
        getPaint().set(dVar.f2733a);
        n0.m.e(this, dVar.f2735c);
        n0.m.h(this, dVar.f2736d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i5, float f5) {
        boolean z4 = v3.f562c;
        if (z4) {
            super.setTextSize(i5, f5);
            return;
        }
        e1 e1Var = this.f383h;
        if (e1Var == null || z4) {
            return;
        }
        o1 o1Var = e1Var.f329i;
        if (o1Var.i() && o1Var.f439a != 0) {
            return;
        }
        o1Var.f(i5, f5);
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i5) {
        Typeface typeface2;
        if (this.f386k) {
            return;
        }
        if (typeface == null || i5 <= 0) {
            typeface2 = null;
        } else {
            Context context = getContext();
            d.u0 u0Var = z.g.f5756a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typeface2 = Typeface.create(typeface, i5);
        }
        this.f386k = true;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        try {
            super.setTypeface(typeface, i5);
        } finally {
            this.f386k = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        e3.a(context);
        this.f386k = false;
        this.f387l = null;
        d3.a(this, getContext());
        s sVar = new s(this);
        this.f382g = sVar;
        sVar.e(attributeSet, i5);
        e1 e1Var = new e1(this);
        this.f383h = e1Var;
        e1Var.f(attributeSet, i5);
        e1Var.b();
        this.f384i = new d0((TextView) this);
        getEmojiTextViewHelper().b(attributeSet, i5);
    }

    public final void setLineHeight(int i5, float f5) {
        if (Build.VERSION.SDK_INT >= 34) {
            getSuperCaller().s(i5, f5);
        } else {
            b4.j.a0(this, i5, f5);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i5, int i6, int i7, int i8) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i5 != 0 ? p2.a.x(context, i5) : null, i6 != 0 ? p2.a.x(context, i6) : null, i7 != 0 ? p2.a.x(context, i7) : null, i8 != 0 ? p2.a.x(context, i8) : null);
        e1 e1Var = this.f383h;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i5, int i6, int i7, int i8) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i5 != 0 ? p2.a.x(context, i5) : null, i6 != 0 ? p2.a.x(context, i6) : null, i7 != 0 ? p2.a.x(context, i7) : null, i8 != 0 ? p2.a.x(context, i8) : null);
        e1 e1Var = this.f383h;
        if (e1Var != null) {
            e1Var.b();
        }
    }
}
