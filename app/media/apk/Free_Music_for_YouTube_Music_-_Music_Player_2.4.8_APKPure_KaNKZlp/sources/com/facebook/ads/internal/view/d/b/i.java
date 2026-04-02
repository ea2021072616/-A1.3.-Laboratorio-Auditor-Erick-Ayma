package com.facebook.ads.internal.view.d.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.facebook.ads.internal.g.q;
import com.facebook.ads.internal.g.r;
import com.facebook.ads.internal.g.s;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class i extends View implements m {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f1680a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f1681b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f1682c;
    private final RectF d;
    private com.facebook.ads.internal.view.n e;
    private int f;
    private final AtomicInteger g;
    private final com.facebook.ads.internal.view.d.a.o h;
    private final com.facebook.ads.internal.view.d.a.c i;

    public i(Context context, int i, int i2) {
        super(context);
        this.g = new AtomicInteger(0);
        this.h = new com.facebook.ads.internal.view.d.a.o() { // from class: com.facebook.ads.internal.view.d.b.i.1
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.n nVar) {
                i.this.g.set((i.this.f * 1000) - i.this.e.getCurrentPosition());
                i.this.postInvalidate();
            }
        };
        this.i = new com.facebook.ads.internal.view.d.a.c() { // from class: com.facebook.ads.internal.view.d.b.i.2
            @Override // com.facebook.ads.internal.g.s
            public void a(com.facebook.ads.internal.view.d.a.b bVar) {
                i.this.f = 0;
            }
        };
        float f = getResources().getDisplayMetrics().density;
        this.f = i;
        this.f1680a = new Paint();
        this.f1680a.setStyle(Paint.Style.FILL);
        this.f1680a.setColor(i2);
        this.f1681b = new Paint();
        this.f1681b.setColor(-3355444);
        this.f1681b.setStyle(Paint.Style.FILL);
        this.f1681b.setStrokeWidth(1.0f * f);
        this.f1681b.setAntiAlias(true);
        this.f1682c = new Paint();
        this.f1682c.setColor(-10066330);
        this.f1682c.setStyle(Paint.Style.STROKE);
        this.f1682c.setStrokeWidth(f * 2.0f);
        this.f1682c.setAntiAlias(true);
        this.d = new RectF();
    }

    @Override // com.facebook.ads.internal.view.d.b.m
    public void a(com.facebook.ads.internal.view.n nVar) {
        this.e = nVar;
        this.e.getEventBus().a((r<s, q>) this.h);
        this.e.getEventBus().a((r<s, q>) this.i);
    }

    public boolean a() {
        if (this.e == null) {
            return false;
        }
        return this.f <= 0 || this.g.get() < 0;
    }

    public int getSkipSeconds() {
        return this.f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        int i = min / 2;
        canvas.drawCircle(getPaddingLeft() + i, (min / 2) + getPaddingTop(), i, this.f1681b);
        if (this.g.get() <= 0) {
            int i2 = min / 3;
            int i3 = min / 3;
            canvas.drawLine(getPaddingLeft() + i2, getPaddingTop() + i3, (i2 * 2) + getPaddingLeft(), (i3 * 2) + getPaddingTop(), this.f1682c);
            canvas.drawLine((i2 * 2) + getPaddingLeft(), getPaddingTop() + i3, getPaddingLeft() + i2, (i3 * 2) + getPaddingTop(), this.f1682c);
        } else {
            this.d.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            canvas.drawArc(this.d, -90.0f, (-(this.g.get() * 360)) / (this.f * 1000), true, this.f1680a);
        }
        super.onDraw(canvas);
    }
}
