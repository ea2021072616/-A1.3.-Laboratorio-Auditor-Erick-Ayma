package com.yanzhenjie.durban.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
/* compiled from: FastBitmapDrawable.java */
/* loaded from: classes2.dex */
public class e extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f5151b;
    private int d;
    private int e;

    /* renamed from: a  reason: collision with root package name */
    private final Paint f5150a = new Paint(2);

    /* renamed from: c  reason: collision with root package name */
    private int f5152c = 255;

    public e(Bitmap bitmap) {
        a(bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f5151b != null && !this.f5151b.isRecycled()) {
            canvas.drawBitmap(this.f5151b, (Rect) null, getBounds(), this.f5150a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5150a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f5150a.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5152c;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f5152c = i;
        this.f5150a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.e;
    }

    public Bitmap a() {
        return this.f5151b;
    }

    public void a(Bitmap bitmap) {
        this.f5151b = bitmap;
        if (bitmap != null) {
            this.d = this.f5151b.getWidth();
            this.e = this.f5151b.getHeight();
            return;
        }
        this.e = 0;
        this.d = 0;
    }
}
