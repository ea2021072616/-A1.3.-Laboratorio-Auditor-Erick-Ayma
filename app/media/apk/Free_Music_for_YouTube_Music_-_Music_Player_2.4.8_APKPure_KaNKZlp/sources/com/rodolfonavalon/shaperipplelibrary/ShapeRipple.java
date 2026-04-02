package com.rodolfonavalon.shaperipplelibrary;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.common.ConnectionResult;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes2.dex */
public class ShapeRipple extends View {

    /* renamed from: a  reason: collision with root package name */
    static final String f5111a = ShapeRipple.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    static boolean f5112b = false;
    private static final int d = Color.parseColor("#FFF44336");
    private static final int e = Color.parseColor("#FFF44336");
    private static final int f = Color.parseColor("#00FFFFFF");
    private ValueAnimator A;
    private Interpolator B;
    private Random C;
    private com.rodolfonavalon.shaperipplelibrary.b.a D;
    private boolean E;
    private b F;

    /* renamed from: c  reason: collision with root package name */
    protected Paint f5113c;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private float l;
    private float m;
    private float n;
    private int o;
    private int p;
    private int q;
    private int r;
    private float s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private Deque<com.rodolfonavalon.shaperipplelibrary.a.a> y;
    private List<Integer> z;

    public ShapeRipple(Context context) {
        super(context);
        this.s = 0.0f;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        a(context, (AttributeSet) null);
    }

    public ShapeRipple(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = 0.0f;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        a(context, attributeSet);
    }

    public ShapeRipple(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.s = 0.0f;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f5113c = new Paint();
        this.f5113c.setAntiAlias(true);
        this.f5113c.setDither(true);
        this.f5113c.setStyle(Paint.Style.FILL);
        this.y = new LinkedList();
        this.C = new Random();
        this.D = new com.rodolfonavalon.shaperipplelibrary.b.b();
        this.D.a(context, this.f5113c);
        this.g = d;
        this.h = e;
        this.i = f;
        this.k = getResources().getDimensionPixelSize(R.dimen.default_stroke_width);
        this.z = com.rodolfonavalon.shaperipplelibrary.c.a.a(getContext());
        this.j = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
        this.n = 1.0f;
        this.B = new LinearInterpolator();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConnectingRipple, 0, 0);
            try {
                this.g = obtainStyledAttributes.getColor(R.styleable.ConnectingRipple_ripple_color, d);
                this.h = obtainStyledAttributes.getColor(R.styleable.ConnectingRipple_ripple_from_color, e);
                this.i = obtainStyledAttributes.getColor(R.styleable.ConnectingRipple_ripple_to_color, f);
                setRippleDuration(obtainStyledAttributes.getInteger(R.styleable.ConnectingRipple_ripple_duration, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED));
                this.t = obtainStyledAttributes.getBoolean(R.styleable.ConnectingRipple_enable_color_transition, true);
                this.u = obtainStyledAttributes.getBoolean(R.styleable.ConnectingRipple_enable_single_ripple, false);
                this.v = obtainStyledAttributes.getBoolean(R.styleable.ConnectingRipple_enable_random_position, false);
                this.m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ConnectingRipple_ripple_maximum_radius, 0);
                this.o = obtainStyledAttributes.getInteger(R.styleable.ConnectingRipple_ripple_count, 0);
                setEnableStrokeStyle(obtainStyledAttributes.getBoolean(R.styleable.ConnectingRipple_enable_stroke_style, false));
                setEnableRandomColor(obtainStyledAttributes.getBoolean(R.styleable.ConnectingRipple_enable_random_color, false));
                setRippleStrokeWidth(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ConnectingRipple_ripple_stroke_width, getResources().getDimensionPixelSize(R.dimen.default_stroke_width)));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        a(this.j);
        if (Build.VERSION.SDK_INT >= 14) {
            this.F = new b(this);
            this.F.a();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (com.rodolfonavalon.shaperipplelibrary.a.a aVar : this.y) {
            if (aVar.e()) {
                aVar.a().a(canvas, aVar.f(), aVar.g(), aVar.b(), aVar.h(), aVar.i(), this.f5113c);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.p = View.MeasureSpec.getSize(i);
        this.q = View.MeasureSpec.getSize(i2);
        a(this.D);
        this.D.a(this.p);
        this.D.b(this.q);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a();
    }

    private void a(com.rodolfonavalon.shaperipplelibrary.b.a aVar) {
        this.f5113c.setStrokeWidth(this.k);
        if (this.p != 0 || this.q != 0) {
            this.y.clear();
            this.r = this.m != 0.0f ? (int) this.m : (Math.min(this.p, this.q) / 2) - (this.k / 2);
            this.o = this.o > 0 ? this.o : this.r / this.k;
            this.l = 1.0f / this.o;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.o) {
                    com.rodolfonavalon.shaperipplelibrary.a.a aVar2 = new com.rodolfonavalon.shaperipplelibrary.a.a(aVar);
                    aVar2.b(this.v ? this.C.nextInt(this.p) : this.p / 2);
                    aVar2.c(this.v ? this.C.nextInt(this.q) : this.q / 2);
                    aVar2.b(-(this.l * i2));
                    aVar2.e(i2);
                    if (this.w) {
                        aVar2.a(this.z.get(this.C.nextInt(this.z.size())).intValue());
                    } else {
                        aVar2.a(this.g);
                    }
                    this.y.add(aVar2);
                    if (!this.u) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void e() {
        if (this.p == 0 && this.q == 0 && (this.y == null || this.y.size() == 0)) {
            a.b("The view dimensions was not calculated!!");
            return;
        }
        this.f5113c.setStrokeWidth(this.k);
        for (com.rodolfonavalon.shaperipplelibrary.a.a aVar : this.y) {
            if (this.w) {
                aVar.a(this.z.get(this.C.nextInt(this.z.size())).intValue());
            } else {
                aVar.a(this.g);
            }
            aVar.a(this.D);
        }
    }

    void a(int i) {
        this.A = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.A.setDuration(i);
        this.A.setRepeatMode(1);
        this.A.setRepeatCount(-1);
        this.A.setInterpolator(this.B);
        this.A.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.rodolfonavalon.shaperipplelibrary.ShapeRipple.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShapeRipple.this.a((Float) valueAnimator.getAnimatedValue());
            }
        });
        this.A.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Float f2) {
        float f3;
        if (this.y.size() == 0) {
            a.a("There are no ripple entries that was created!!");
            return;
        }
        float d2 = this.y.peekFirst().d() + Math.max(f2.floatValue() - this.s, 0.0f);
        if (d2 >= 1.0f) {
            com.rodolfonavalon.shaperipplelibrary.a.a pop = this.y.pop();
            pop.j();
            pop.a(this.w ? this.z.get(this.C.nextInt(this.z.size())).intValue() : this.g);
            this.y.addLast(pop);
            com.rodolfonavalon.shaperipplelibrary.a.a peekFirst = this.y.peekFirst();
            float max = Math.max(f2.floatValue() - this.s, 0.0f) + peekFirst.d();
            peekFirst.b(this.v ? this.C.nextInt(this.p) : this.p / 2);
            peekFirst.c(this.v ? this.C.nextInt(this.q) : this.q / 2);
            f3 = this.u ? 0.0f : max;
        } else {
            f3 = d2;
        }
        int i = 0;
        for (com.rodolfonavalon.shaperipplelibrary.a.a aVar : this.y) {
            aVar.e(i);
            float f4 = f3 - (this.l * i);
            if (f4 >= 0.0f) {
                aVar.a(true);
                if (i == 0) {
                    aVar.b(f3);
                } else {
                    aVar.b(f4);
                }
                aVar.d(this.t ? com.rodolfonavalon.shaperipplelibrary.c.a.a(f4, aVar.c(), this.i) : this.g);
                aVar.a(this.r * f4);
                i++;
            } else {
                aVar.a(false);
            }
        }
        this.s = f2.floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.A != null) {
            this.A.cancel();
            this.A.end();
            this.A.removeAllUpdateListeners();
            this.A.removeAllListeners();
            this.A = null;
        }
        if (this.y != null) {
            this.y.clear();
            invalidate();
        }
    }

    public void b() {
        a();
        a(this.D);
        a(this.j);
        this.E = false;
    }

    public void c() {
        a();
        this.E = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        if (this.E) {
            a.a("Restarted from stopped ripple!!");
        } else {
            b();
        }
    }

    public float getRippleMaximumRadius() {
        return this.r;
    }

    public int getRippleStrokeWidth() {
        return this.k;
    }

    public int getRippleColor() {
        return this.g;
    }

    public int getRippleFromColor() {
        return this.h;
    }

    public int getRippleToColor() {
        return this.i;
    }

    public int getRippleDuration() {
        return this.j;
    }

    public int getRippleCount() {
        return this.o;
    }

    public Interpolator getRippleInterpolator() {
        return this.B;
    }

    public com.rodolfonavalon.shaperipplelibrary.b.a getRippleShape() {
        return this.D;
    }

    public List<Integer> getRippleRandomColors() {
        return this.z;
    }

    public void setRippleMaximumRadius(float f2) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Ripple max radius must be greater than 0");
        }
        this.m = f2;
        requestLayout();
    }

    public void setEnableColorTransition(boolean z) {
        this.t = z;
    }

    public void setEnableSingleRipple(boolean z) {
        this.u = z;
        a(this.D);
    }

    public void setRippleStrokeWidth(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Ripple duration must be > 0");
        }
        this.k = i;
    }

    public void setRippleColor(int i) {
        a(i, true);
    }

    public void a(int i, boolean z) {
        this.g = i;
        if (z) {
            e();
        }
    }

    public void setRippleFromColor(int i) {
        b(i, true);
    }

    public void b(int i, boolean z) {
        this.h = i;
        if (z) {
            e();
        }
    }

    public void setRippleToColor(int i) {
        c(i, true);
    }

    public void c(int i, boolean z) {
        this.i = i;
        if (z) {
            e();
        }
    }

    public void setRippleDuration(int i) {
        if (this.j <= 0) {
            throw new IllegalArgumentException("Ripple duration must be > 0");
        }
        this.j = i;
        if (this.A != null) {
            this.A.setDuration(this.j);
        }
    }

    public void setEnableRandomPosition(boolean z) {
        this.v = z;
        a(this.D);
    }

    public void setRippleInterpolator(Interpolator interpolator) {
        if (interpolator == null) {
            throw new NullPointerException("Ripple interpolator in null");
        }
        this.B = interpolator;
    }

    public void setEnableRandomColor(boolean z) {
        this.w = z;
        e();
    }

    public void setRippleCount(int i) {
        if (i <= 0) {
            throw new NullPointerException("Invalid ripple count");
        }
        this.o = i;
        requestLayout();
    }

    public void setEnableStrokeStyle(boolean z) {
        this.x = z;
        if (z) {
            this.f5113c.setStyle(Paint.Style.STROKE);
        } else {
            this.f5113c.setStyle(Paint.Style.FILL);
        }
    }

    public void setRippleShape(com.rodolfonavalon.shaperipplelibrary.b.a aVar) {
        this.D = aVar;
        this.D.a(getContext(), this.f5113c);
        e();
    }

    public void setRippleRandomColors(List<Integer> list) {
        if (list == null) {
            throw new NullPointerException("List of colors cannot be null");
        }
        if (list.size() == 0) {
            throw new IllegalArgumentException("List of color cannot be empty");
        }
        this.z.clear();
        this.z = list;
        e();
    }
}
