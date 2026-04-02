package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class CircleProgressView extends View {
    private static final String TAG = "CircleProgressView";
    private float currentProgress;
    private float density;
    private float height;
    float padding;
    private Paint paint;
    private float radius;
    private RectF rectF;
    protected float totalProgress;
    private float width;

    public CircleProgressView(Context context) {
        super(context);
        init(context);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.density = context.getResources().getDisplayMetrics().density;
        this.radius = 14.75f * this.density;
        this.padding = (1.5f * this.density) / 2.0f;
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(this.padding * 2.0f);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.rectF = new RectF(this.padding, this.padding, this.width - this.padding, this.height - this.padding);
        this.paint.setColor(Color.parseColor("#e3e3e3"));
        canvas.drawArc(this.rectF, -90.0f, 360.0f, false, this.paint);
        this.paint.setColor(Color.parseColor("#ff2d55"));
        canvas.drawArc(this.rectF, -90.0f, 360.0f * (this.currentProgress / this.totalProgress), false, this.paint);
    }

    public void setCurrentProgress(float f) {
        this.currentProgress = f;
        invalidate();
    }

    public void setTotalProgress(float f) {
        this.totalProgress = f;
        this.currentProgress = 0.0f;
        invalidate();
    }
}
