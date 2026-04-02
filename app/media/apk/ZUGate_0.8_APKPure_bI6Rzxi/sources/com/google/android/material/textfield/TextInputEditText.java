package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.a0;
import b4.j;
import com.github.appintro.R;
import java.util.Locale;
import p2.a;
/* loaded from: classes.dex */
public class TextInputEditText extends a0 {

    /* renamed from: m  reason: collision with root package name */
    public final Rect f2199m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2200n;

    public TextInputEditText(Context context, AttributeSet attributeSet) {
        super(a.b0(context, attributeSet, R.attr.editTextStyle, 0), attributeSet, 0);
        this.f2199m = new Rect();
        TypedArray D = j.D(context, attributeSet, w2.a.f5410z, R.attr.editTextStyle, 2131952486, new int[0]);
        setTextInputLayoutFocusedRectEnabled(D.getBoolean(0, false));
        D.recycle();
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!(textInputLayout != null && this.f2200n) || rect == null) {
            return;
        }
        Rect rect2 = this.f2199m;
        textInputLayout.getFocusedRect(rect2);
        rect.bottom = rect2.bottom;
    }

    @Override // android.view.View
    public final boolean getGlobalVisibleRect(Rect rect, Point point) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f2200n) {
            boolean globalVisibleRect = textInputLayout.getGlobalVisibleRect(rect, point);
            if (globalVisibleRect && point != null) {
                point.offset(-getScrollX(), -getScrollY());
            }
            return globalVisibleRect;
        }
        return super.getGlobalVisibleRect(rect, point);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !textInputLayout.K) ? super.getHint() : textInputLayout.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.K && super.getHint() == null) {
            String str = Build.MANUFACTURER;
            if ((str != null ? str.toLowerCase(Locale.ENGLISH) : "").equals("meizu")) {
                setHint("");
            }
        }
    }

    @Override // androidx.appcompat.widget.a0, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        getTextInputLayout();
    }

    @Override // android.view.View
    public final boolean requestRectangleOnScreen(Rect rect) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!(textInputLayout != null && this.f2200n) || rect == null) {
            return super.requestRectangleOnScreen(rect);
        }
        int height = textInputLayout.getHeight() - getHeight();
        int i5 = rect.left;
        int i6 = rect.top;
        int i7 = rect.right;
        int i8 = rect.bottom + height;
        Rect rect2 = this.f2199m;
        rect2.set(i5, i6, i7, i8);
        return super.requestRectangleOnScreen(rect2);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z4) {
        this.f2200n = z4;
    }
}
