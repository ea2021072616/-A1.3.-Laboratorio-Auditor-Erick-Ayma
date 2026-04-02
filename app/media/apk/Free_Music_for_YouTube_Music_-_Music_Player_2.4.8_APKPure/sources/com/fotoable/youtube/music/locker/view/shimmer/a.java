package com.fotoable.youtube.music.locker.view.shimmer;

import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.fotoable.youtube.music.R;
/* compiled from: ShimmerViewHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private View f2844a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f2845b;

    /* renamed from: c  reason: collision with root package name */
    private float f2846c;
    private LinearGradient d;
    private Matrix e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private InterfaceC0059a j;

    /* compiled from: ShimmerViewHelper.java */
    /* renamed from: com.fotoable.youtube.music.locker.view.shimmer.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void a(View view);
    }

    public a(View view, Paint paint, AttributeSet attributeSet) {
        this.f2844a = view;
        this.f2845b = paint;
        a(attributeSet);
    }

    public float a() {
        return this.f2846c;
    }

    public void a(float f) {
        this.f2846c = f;
        this.f2844a.invalidate();
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void a(InterfaceC0059a interfaceC0059a) {
        this.j = interfaceC0059a;
    }

    public int b() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
        if (this.i) {
            f();
        }
    }

    public int c() {
        return this.g;
    }

    public void b(int i) {
        this.g = i;
        if (this.i) {
            f();
        }
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        this.g = -1;
        if (attributeSet != null && (obtainStyledAttributes = this.f2844a.getContext().obtainStyledAttributes(attributeSet, R.styleable.ShimmerView, 0, 0)) != null) {
            try {
                this.g = obtainStyledAttributes.getColor(0, -1);
            } catch (Exception e) {
                Log.e("ShimmerTextView", "Error while creating the view:", e);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.e = new Matrix();
    }

    private void f() {
        this.d = new LinearGradient(-this.f2844a.getWidth(), 0.0f, 0.0f, 0.0f, new int[]{this.f, this.g, this.f}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.f2845b.setShader(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        f();
        if (!this.i) {
            this.i = true;
            if (this.j != null) {
                this.j.a(this.f2844a);
            }
        }
    }

    public void e() {
        if (this.h) {
            if (this.f2845b.getShader() == null) {
                this.f2845b.setShader(this.d);
            }
            this.e.setTranslate(2.0f * this.f2846c, 0.0f);
            this.d.setLocalMatrix(this.e);
            return;
        }
        this.f2845b.setShader(null);
    }
}
