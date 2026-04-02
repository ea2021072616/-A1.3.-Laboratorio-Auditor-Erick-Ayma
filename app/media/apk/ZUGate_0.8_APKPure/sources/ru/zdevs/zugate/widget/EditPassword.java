package ru.zdevs.zugate.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.a0;
import com.github.appintro.R;
import e4.e;
import y.i;
import y.q;
/* loaded from: classes.dex */
public class EditPassword extends a0 {

    /* renamed from: m  reason: collision with root package name */
    public boolean f4628m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f4629n;
    public Drawable o;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f4630p;

    public EditPassword(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setMaxLines(1);
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        ThreadLocal threadLocal = q.f5568a;
        this.f4630p = i.a(resources, R.drawable.ic_visibility_off_24, theme).mutate();
        this.o = i.a(resources, R.drawable.ic_visibility_24, context.getTheme()).mutate();
        int m5 = e.m(context, 16843818);
        this.f4630p.setColorFilter(m5, PorterDuff.Mode.SRC_IN);
        this.o.setColorFilter(m5, PorterDuff.Mode.SRC_IN);
        this.f4629n = getResources().getConfiguration().getLayoutDirection() == 1;
        setInputType(128);
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (this.f4628m) {
            setTransformationMethod(null);
        } else {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        setSelection(selectionStart, selectionEnd);
        c();
        setAutofillHints("password");
    }

    public final void c() {
        Drawable drawable = this.f4628m ? this.f4630p : this.o;
        boolean z4 = this.f4629n;
        Drawable drawable2 = z4 ? drawable : null;
        if (z4) {
            drawable = null;
        }
        setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, drawable, (Drawable) null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int right;
        if (motionEvent.getAction() == 1 && isEnabled()) {
            Rect bounds = this.o.getBounds();
            int x5 = (int) motionEvent.getX();
            if (this.f4629n) {
                right = bounds.width() + getLeft() + 50;
            } else {
                right = (getRight() - bounds.width()) - 50;
            }
            if (!this.f4629n ? x5 >= right : x5 <= right) {
                this.f4628m = !this.f4628m;
                int selectionStart = getSelectionStart();
                int selectionEnd = getSelectionEnd();
                if (this.f4628m) {
                    setTransformationMethod(null);
                } else {
                    setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                setSelection(selectionStart, selectionEnd);
                c();
                motionEvent.setAction(3);
                performClick();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean performClick() {
        return super.performClick();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        if (z4) {
            c();
        } else {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
