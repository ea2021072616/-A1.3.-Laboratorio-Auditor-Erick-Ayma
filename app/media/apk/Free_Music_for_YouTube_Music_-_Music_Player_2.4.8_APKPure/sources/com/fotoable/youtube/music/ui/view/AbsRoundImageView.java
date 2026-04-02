package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.fotoable.youtube.music.R;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
/* loaded from: classes.dex */
public abstract class AbsRoundImageView extends ImageView {
    private static final PorterDuffXfermode xFermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    protected int borderColor;
    private Paint borderPaint;
    protected Path borderPath;
    protected float borderWidth;
    private Paint mBitmapPaint;
    protected Path roundPath;

    protected abstract void initBorderPath();

    protected abstract void initRoundPath();

    public AbsRoundImageView(Context context) {
        this(context, null, 0);
    }

    public AbsRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsRoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttrs(attributeSet);
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAttrs(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AbsRoundImageView);
            this.borderWidth = obtainStyledAttributes.getDimension(0, 0.0f);
            this.borderColor = obtainStyledAttributes.getColor(1, 0);
            obtainStyledAttributes.recycle();
        }
    }

    private void init() {
        this.mBitmapPaint = new Paint(1);
        this.roundPath = new Path();
        this.borderPath = new Path();
        this.borderPaint = new Paint(1);
        this.borderPaint.setStrokeWidth(this.borderWidth);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            initBorderPath();
            initRoundPath();
        }
    }

    protected Bitmap getRoundBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawPath(this.roundPath, paint);
        return createBitmap;
    }

    private void drawBorder(Canvas canvas) {
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setColor(this.borderColor);
        canvas.drawPath(this.borderPath, this.borderPaint);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        drawImage(canvas);
        drawBorder(canvas);
    }

    private void drawImage(Canvas canvas) {
        Bitmap createBitmap;
        Drawable drawable = getDrawable();
        if (!isInEditMode() && drawable != null) {
            try {
                if (drawable instanceof ColorDrawable) {
                    createBitmap = Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888);
                } else {
                    createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                }
                Canvas canvas2 = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas2.getWidth(), canvas2.getHeight());
                drawable.draw(canvas2);
                Bitmap roundBitmap = getRoundBitmap();
                this.mBitmapPaint.reset();
                this.mBitmapPaint.setFilterBitmap(false);
                this.mBitmapPaint.setXfermode(xFermode);
                canvas2.drawBitmap(roundBitmap, 0.0f, 0.0f, this.mBitmapPaint);
                this.mBitmapPaint.setXfermode(null);
                canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.mBitmapPaint);
            } catch (Exception e) {
                ThrowableExtension.printStackTrace(e);
            }
        }
    }
}
