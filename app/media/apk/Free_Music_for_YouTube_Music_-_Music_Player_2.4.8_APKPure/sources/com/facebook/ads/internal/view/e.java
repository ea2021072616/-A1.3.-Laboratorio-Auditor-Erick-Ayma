package com.facebook.ads.internal.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class e extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f1726a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f1727b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f1728c;
    private ImageView d;
    private ImageView e;
    private Bitmap f;
    private Bitmap g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private double n;
    private double o;

    public e(Context context) {
        super(context);
        d();
    }

    private int a(double d) {
        return (int) Math.round(getWidth() / d);
    }

    private void a() {
        if (getHeight() <= 0 || getWidth() <= 0) {
            return;
        }
        this.o = getMeasuredWidth() / getMeasuredHeight();
        this.n = this.f1726a.getWidth() / this.f1726a.getHeight();
        if (this.n > this.o) {
            b();
        } else {
            c();
        }
    }

    private int b(double d) {
        return (int) Math.round(getHeight() * d);
    }

    private void b() {
        this.j = a(this.n);
        this.k = getWidth();
        this.h = (int) Math.ceil((getHeight() - this.j) / 2.0f);
        if (this.f1727b == null) {
            return;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        this.i = (int) Math.floor((getHeight() - this.j) / 2.0f);
        float height = this.f1726a.getHeight() / this.j;
        int min = Math.min(Math.round(this.h * height), this.f1727b.getHeight());
        if (min > 0) {
            this.f = Bitmap.createBitmap(this.f1727b, 0, 0, this.f1727b.getWidth(), min, matrix, true);
            this.f1728c.setImageBitmap(this.f);
        }
        int min2 = Math.min(Math.round(this.i * height), this.f1727b.getHeight());
        if (min2 > 0) {
            this.g = Bitmap.createBitmap(this.f1727b, 0, this.f1727b.getHeight() - min2, this.f1727b.getWidth(), min2, matrix, true);
            this.e.setImageBitmap(this.g);
        }
    }

    private void c() {
        this.k = b(this.n);
        this.j = getHeight();
        this.l = (int) Math.ceil((getWidth() - this.k) / 2.0f);
        if (this.f1727b == null) {
            return;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        this.m = (int) Math.floor((getWidth() - this.k) / 2.0f);
        float width = this.f1726a.getWidth() / this.k;
        int min = Math.min(Math.round(this.l * width), this.f1727b.getWidth());
        if (min > 0) {
            this.f = Bitmap.createBitmap(this.f1727b, 0, 0, min, this.f1727b.getHeight(), matrix, true);
            this.f1728c.setImageBitmap(this.f);
        }
        int min2 = Math.min(Math.round(this.m * width), this.f1727b.getWidth());
        if (min2 > 0) {
            this.g = Bitmap.createBitmap(this.f1727b, this.f1727b.getWidth() - min2, 0, min2, this.f1727b.getHeight(), matrix, true);
            this.e.setImageBitmap(this.g);
        }
    }

    private void d() {
        getContext().getResources().getDisplayMetrics();
        setOrientation(1);
        this.f1728c = new ImageView(getContext());
        this.f1728c.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f1728c);
        this.d = new ImageView(getContext());
        this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.d.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.d);
        this.e = new ImageView(getContext());
        this.e.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.e);
    }

    private boolean e() {
        return ((this.h + this.j) + this.i == getMeasuredHeight() && (this.l + this.k) + this.m == getMeasuredWidth()) ? false : true;
    }

    public void a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 == null) {
            this.f1728c.setImageDrawable(null);
            this.e.setImageDrawable(null);
        }
        if (bitmap == null) {
            this.d.setImageDrawable(null);
            return;
        }
        this.d.setImageBitmap(Bitmap.createBitmap(bitmap));
        this.f1726a = bitmap;
        this.f1727b = bitmap2;
        a();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1726a == null) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        a(this.n);
        b(this.n);
        if (this.f == null || e()) {
            a();
        }
        if (this.n > this.o) {
            this.f1728c.layout(i, i2, i3, this.h);
            this.d.layout(i, this.h + i2, i3, this.h + this.j);
            this.e.layout(i, this.h + i2 + this.j, i3, i4);
            return;
        }
        this.f1728c.layout(i, i2, this.l, i4);
        this.d.layout(this.l + i, i2, this.l + this.k, i4);
        this.e.layout(this.l + i + this.k, i2, i3, i4);
    }
}
