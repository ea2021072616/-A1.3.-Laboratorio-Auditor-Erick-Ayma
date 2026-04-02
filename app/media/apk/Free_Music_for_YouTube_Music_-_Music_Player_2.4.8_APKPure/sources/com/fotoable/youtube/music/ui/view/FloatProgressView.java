package com.fotoable.youtube.music.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class FloatProgressView extends View {
    private float currentProgress;
    private int height;
    private Paint paint;
    private float totalProgress;
    private int width;

    public FloatProgressView(Context context) {
        super(context);
        init();
    }

    public FloatProgressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth(2.0f * getResources().getDisplayMetrics().density);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
    }

    public void setCurrentProgress(float f) {
        this.currentProgress = f;
        invalidate();
    }

    public void setTotalProgress(float f) {
        this.totalProgress = f;
        this.currentProgress = 0.0f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.paint.setColor(-1);
        canvas.drawLine(0.0f, this.height / 2, (this.currentProgress / this.totalProgress) * this.width, this.height / 2, this.paint);
    }
}
