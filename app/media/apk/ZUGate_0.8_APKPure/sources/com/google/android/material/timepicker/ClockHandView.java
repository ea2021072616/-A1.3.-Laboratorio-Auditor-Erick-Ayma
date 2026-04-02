package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.github.appintro.R;
import h0.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ClockHandView extends View {

    /* renamed from: g  reason: collision with root package name */
    public final ValueAnimator f2249g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2250h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f2251i;

    /* renamed from: j  reason: collision with root package name */
    public final int f2252j;

    /* renamed from: k  reason: collision with root package name */
    public final float f2253k;

    /* renamed from: l  reason: collision with root package name */
    public final Paint f2254l;

    /* renamed from: m  reason: collision with root package name */
    public final RectF f2255m;

    /* renamed from: n  reason: collision with root package name */
    public final int f2256n;
    public float o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2257p;

    /* renamed from: q  reason: collision with root package name */
    public double f2258q;

    /* renamed from: r  reason: collision with root package name */
    public int f2259r;

    /* renamed from: s  reason: collision with root package name */
    public int f2260s;

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        this.f2249g = new ValueAnimator();
        this.f2251i = new ArrayList();
        Paint paint = new Paint();
        this.f2254l = paint;
        this.f2255m = new RectF();
        this.f2260s = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w2.a.f5390e, R.attr.materialClockStyle, 2131952772);
        p2.a.Q(context, R.attr.motionDurationLong2, 200);
        p2.a.R(context, R.attr.motionEasingEmphasizedInterpolator, x2.a.f5485b);
        this.f2259r = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f2252j = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        Resources resources = getResources();
        this.f2256n = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f2253k = resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        b(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap weakHashMap = z0.f3233a;
        setImportantForAccessibility(2);
        obtainStyledAttributes.recycle();
    }

    public final int a(int i5) {
        return i5 == 2 ? Math.round(this.f2259r * 0.66f) : this.f2259r;
    }

    public final void b(float f5) {
        ValueAnimator valueAnimator = this.f2249g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        c(f5);
    }

    public final void c(float f5) {
        float f6 = f5 % 360.0f;
        this.o = f6;
        this.f2258q = Math.toRadians(f6 - 90.0f);
        float a5 = a(this.f2260s);
        float cos = (((float) Math.cos(this.f2258q)) * a5) + (getWidth() / 2);
        float sin = (a5 * ((float) Math.sin(this.f2258q))) + (getHeight() / 2);
        float f7 = this.f2252j;
        this.f2255m.set(cos - f7, sin - f7, cos + f7, sin + f7);
        Iterator it = this.f2251i.iterator();
        while (it.hasNext()) {
            ClockFaceView clockFaceView = (ClockFaceView) ((d) it.next());
            if (Math.abs(clockFaceView.M - f6) > 0.001f) {
                clockFaceView.M = f6;
                clockFaceView.n();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int a5;
        int i5;
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f5 = width;
        float a6 = a(this.f2260s);
        float f6 = height;
        Paint paint = this.f2254l;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) Math.cos(this.f2258q)) * a6) + f5, (a6 * ((float) Math.sin(this.f2258q))) + f6, this.f2252j, paint);
        double sin = Math.sin(this.f2258q);
        paint.setStrokeWidth(this.f2256n);
        canvas.drawLine(f5, f6, width + ((int) (Math.cos(this.f2258q) * r12)), height + ((int) (r12 * sin)), paint);
        canvas.drawCircle(f5, f6, this.f2253k, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        if (this.f2249g.isRunning()) {
            return;
        }
        b(this.o);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z4;
        boolean z5;
        int actionMasked = motionEvent.getActionMasked();
        float x5 = motionEvent.getX();
        float y5 = motionEvent.getY();
        boolean z6 = false;
        if (actionMasked == 0) {
            this.f2257p = false;
            z4 = true;
            z5 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z5 = this.f2257p;
            if (this.f2250h) {
                this.f2260s = ((float) Math.hypot((double) (x5 - ((float) (getWidth() / 2))), (double) (y5 - ((float) (getHeight() / 2))))) <= ((float) a(2)) + TypedValue.applyDimension(1, (float) 12, getContext().getResources().getDisplayMetrics()) ? 2 : 1;
            }
            z4 = false;
        } else {
            z5 = false;
            z4 = false;
        }
        boolean z7 = this.f2257p;
        int degrees = ((int) Math.toDegrees(Math.atan2(y5 - (getHeight() / 2), x5 - (getWidth() / 2)))) + 90;
        if (degrees < 0) {
            degrees += 360;
        }
        float f5 = degrees;
        boolean z8 = this.o != f5;
        if (!z4 || !z8) {
            if (z8 || z5) {
                b(f5);
            }
            this.f2257p = z7 | z6;
            return true;
        }
        z6 = true;
        this.f2257p = z7 | z6;
        return true;
    }
}
