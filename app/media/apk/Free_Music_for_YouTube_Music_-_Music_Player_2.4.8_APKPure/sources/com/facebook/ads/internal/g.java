package com.facebook.ads.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class g extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f1348a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f1349b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f1350c;
    private int d;
    private boolean e;

    public g(Context context) {
        this(context, 60, true);
    }

    public g(Context context, int i, boolean z) {
        super(context);
        this.d = i;
        this.e = z;
        if (z) {
            this.f1348a = new Paint();
            this.f1348a.setColor(-3355444);
            this.f1348a.setStyle(Paint.Style.STROKE);
            this.f1348a.setStrokeWidth(3.0f);
            this.f1348a.setAntiAlias(true);
            this.f1349b = new Paint();
            this.f1349b.setColor(-1287371708);
            this.f1349b.setStyle(Paint.Style.FILL);
            this.f1349b.setAntiAlias(true);
            this.f1350c = new Paint();
            this.f1350c.setColor(-1);
            this.f1350c.setStyle(Paint.Style.STROKE);
            this.f1350c.setStrokeWidth(6.0f);
            this.f1350c.setAntiAlias(true);
        }
        a();
    }

    private void a() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (this.d * displayMetrics.density), (int) (displayMetrics.density * this.d));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.e) {
            if (canvas.isHardwareAccelerated() && Build.VERSION.SDK_INT < 17) {
                setLayerType(1, null);
            }
            int min = Math.min(canvas.getWidth(), canvas.getHeight());
            int i = min / 2;
            int i2 = min / 2;
            int i3 = (i * 2) / 3;
            canvas.drawCircle(i, i2, i3, this.f1348a);
            canvas.drawCircle(i, i2, i3 - 2, this.f1349b);
            int i4 = min / 3;
            int i5 = min / 3;
            canvas.drawLine(i4, i5, i4 * 2, i5 * 2, this.f1350c);
            canvas.drawLine(i4 * 2, i5, i4, i5 * 2, this.f1350c);
        }
        super.onDraw(canvas);
    }
}
