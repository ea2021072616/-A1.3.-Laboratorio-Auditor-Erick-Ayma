package com.facebook.ads.internal.view.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
@TargetApi(19)
/* loaded from: classes.dex */
public class b extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1586a = Color.argb(26, 0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    private static final int f1587b = Color.rgb(88, (int) IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 255);

    /* renamed from: c  reason: collision with root package name */
    private Rect f1588c;
    private Paint d;

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        setIndeterminate(false);
        setMax(100);
        setProgressDrawable(b());
        this.f1588c = new Rect();
        this.d = new Paint();
        this.d.setStyle(Paint.Style.FILL);
        this.d.setColor(f1586a);
    }

    private Drawable b() {
        return new LayerDrawable(new Drawable[]{new ColorDrawable(0), new ClipDrawable(new ColorDrawable(f1587b), 3, 1)});
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        canvas.drawRect(this.f1588c, this.d);
        super.onDraw(canvas);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f1588c.set(0, 0, getMeasuredWidth(), 2);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        super.setProgress(i == 100 ? 0 : Math.max(i, 5));
    }
}
