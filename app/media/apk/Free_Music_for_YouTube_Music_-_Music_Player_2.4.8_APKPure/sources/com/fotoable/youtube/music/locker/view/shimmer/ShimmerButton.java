package com.fotoable.youtube.music.locker.view.shimmer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;
import com.fotoable.youtube.music.locker.view.shimmer.a;
/* loaded from: classes.dex */
public class ShimmerButton extends Button {

    /* renamed from: a  reason: collision with root package name */
    private a f2823a;

    public ShimmerButton(Context context) {
        super(context);
        this.f2823a = new a(this, getPaint(), null);
        this.f2823a.a(getCurrentTextColor());
    }

    public ShimmerButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2823a = new a(this, getPaint(), attributeSet);
        this.f2823a.a(getCurrentTextColor());
    }

    public ShimmerButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2823a = new a(this, getPaint(), attributeSet);
        this.f2823a.a(getCurrentTextColor());
    }

    public float getGradientX() {
        return this.f2823a.a();
    }

    public void setGradientX(float f) {
        this.f2823a.a(f);
    }

    public void setShimmering(boolean z) {
        this.f2823a.a(z);
    }

    public void setAnimationSetupCallback(a.InterfaceC0059a interfaceC0059a) {
        this.f2823a.a(interfaceC0059a);
    }

    public int getPrimaryColor() {
        return this.f2823a.b();
    }

    public void setPrimaryColor(int i) {
        this.f2823a.a(i);
    }

    public int getReflectionColor() {
        return this.f2823a.c();
    }

    public void setReflectionColor(int i) {
        this.f2823a.b(i);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        if (this.f2823a != null) {
            this.f2823a.a(getCurrentTextColor());
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        if (this.f2823a != null) {
            this.f2823a.a(getCurrentTextColor());
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f2823a != null) {
            this.f2823a.d();
        }
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"WrongCall"})
    public void onDraw(Canvas canvas) {
        if (this.f2823a != null) {
            this.f2823a.e();
        }
        super.onDraw(canvas);
    }
}
