package com.fotoable.youtube.music.locker.view.shimmer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.fotoable.youtube.music.locker.view.shimmer.a;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public class ShimmerTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private a f2843a;

    public ShimmerTextView(Context context) {
        super(context);
        this.f2843a = new a(this, getPaint(), null);
        this.f2843a.a(getCurrentTextColor());
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2843a = new a(this, getPaint(), attributeSet);
        this.f2843a.a(getCurrentTextColor());
    }

    public ShimmerTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2843a = new a(this, getPaint(), attributeSet);
        this.f2843a.a(getCurrentTextColor());
    }

    public float getGradientX() {
        return this.f2843a.a();
    }

    public void setGradientX(float f) {
        this.f2843a.a(f);
    }

    public void setShimmering(boolean z) {
        this.f2843a.a(z);
    }

    public void setAnimationSetupCallback(a.InterfaceC0059a interfaceC0059a) {
        this.f2843a.a(interfaceC0059a);
    }

    public int getPrimaryColor() {
        return this.f2843a.b();
    }

    public void setPrimaryColor(int i) {
        this.f2843a.a(i);
    }

    public int getReflectionColor() {
        return this.f2843a.c();
    }

    public void setReflectionColor(int i) {
        this.f2843a.b(i);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        if (this.f2843a != null) {
            this.f2843a.a(getCurrentTextColor());
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        if (this.f2843a != null) {
            this.f2843a.a(getCurrentTextColor());
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f2843a != null) {
            this.f2843a.d();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if (this.f2843a != null) {
                this.f2843a.e();
            }
            super.onDraw(canvas);
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
        }
    }
}
