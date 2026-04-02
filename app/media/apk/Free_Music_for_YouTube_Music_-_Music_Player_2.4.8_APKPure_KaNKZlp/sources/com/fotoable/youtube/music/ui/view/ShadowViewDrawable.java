package com.fotoable.youtube.music.ui.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class ShadowViewDrawable extends Drawable {
    private RectF drawRect;
    private int height;

    /* renamed from: rx  reason: collision with root package name */
    private float f4851rx;
    private float ry;
    private int shadowOffset;
    private ShadowProperty shadowProperty;
    private int width;
    private RectF bounds = new RectF();
    private PorterDuffXfermode srcOut = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
    private Paint paint = new Paint();

    public ShadowViewDrawable(ShadowProperty shadowProperty, int i, float f, float f2) {
        this.shadowProperty = shadowProperty;
        this.shadowOffset = this.shadowProperty.getShadowOffset();
        this.f4851rx = f;
        this.ry = f2;
        this.paint.setAntiAlias(true);
        this.paint.setFilterBitmap(true);
        this.paint.setDither(true);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(i);
        this.paint.setShadowLayer(shadowProperty.getShadowRadius(), shadowProperty.getShadowDx(), shadowProperty.getShadowDy(), shadowProperty.getShadowColor());
        this.drawRect = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (rect.right - rect.left > 0 && rect.bottom - rect.top > 0) {
            this.bounds.left = rect.left;
            this.bounds.right = rect.right;
            this.bounds.top = rect.top;
            this.bounds.bottom = rect.bottom;
            this.width = (int) (this.bounds.right - this.bounds.left);
            this.height = (int) (this.bounds.bottom - this.bounds.top);
            int shadowSide = this.shadowProperty.getShadowSide();
            this.drawRect = new RectF((shadowSide & 1) == 1 ? this.shadowOffset : 0, (shadowSide & 16) == 16 ? this.shadowOffset : 0, this.width - ((shadowSide & 256) == 256 ? this.shadowOffset : 0), this.height - ((shadowSide & 4096) == 4096 ? this.shadowOffset : 0));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.paint.setXfermode(null);
        canvas.drawRoundRect(this.drawRect, this.f4851rx, this.ry, this.paint);
        this.paint.setXfermode(this.srcOut);
        canvas.drawRoundRect(this.drawRect, this.f4851rx, this.ry, this.paint);
    }

    public ShadowViewDrawable setColor(int i) {
        this.paint.setColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }
}
