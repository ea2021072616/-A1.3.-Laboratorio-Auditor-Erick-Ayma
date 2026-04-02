package com.fotoable.youtube.music.locker.view.shimmer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.fotoable.youtube.music.R;
/* loaded from: classes.dex */
public class ShimmerFrameLayout extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private static final PorterDuffXfermode f2824c = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    /* renamed from: a  reason: collision with root package name */
    protected ValueAnimator f2825a;

    /* renamed from: b  reason: collision with root package name */
    protected Bitmap f2826b;
    private Paint d;
    private Paint e;
    private a f;
    private d g;
    private Bitmap h;
    private Bitmap i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private ViewTreeObserver.OnGlobalLayoutListener r;

    /* loaded from: classes.dex */
    public enum b {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    /* loaded from: classes.dex */
    public enum c {
        LINEAR,
        RADIAL
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public b f2831a;

        /* renamed from: b  reason: collision with root package name */
        public float f2832b;

        /* renamed from: c  reason: collision with root package name */
        public float f2833c;
        public int d;
        public int e;
        public float f;
        public float g;
        public float h;
        public c i;

        private a() {
        }

        public int a(int i) {
            return this.d > 0 ? this.d : (int) (i * this.g);
        }

        public int b(int i) {
            return this.e > 0 ? this.e : (int) (i * this.h);
        }

        public int[] a() {
            switch (this.i) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] b() {
            switch (this.i) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.f, 1.0f), Math.min(this.f + this.f2833c, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.f) - this.f2833c) / 2.0f, 0.0f), Math.max((1.0f - this.f) / 2.0f, 0.0f), Math.min((this.f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f + 1.0f) + this.f2833c) / 2.0f, 1.0f)};
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f2840a;

        /* renamed from: b  reason: collision with root package name */
        public int f2841b;

        /* renamed from: c  reason: collision with root package name */
        public int f2842c;
        public int d;

        private d() {
        }

        public void a(int i, int i2, int i3, int i4) {
            this.f2840a = i;
            this.f2841b = i2;
            this.f2842c = i3;
            this.d = i4;
        }
    }

    public ShimmerFrameLayout(Context context) {
        this(context, null, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.f = new a();
        this.d = new Paint();
        this.e = new Paint();
        this.e.setAntiAlias(true);
        this.e.setDither(true);
        this.e.setFilterBitmap(true);
        this.e.setXfermode(f2824c);
        a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
            try {
                if (obtainStyledAttributes.hasValue(1)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(1, false));
                }
                if (obtainStyledAttributes.hasValue(2)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(2, 0.0f));
                }
                if (obtainStyledAttributes.hasValue(0)) {
                    setDuration(obtainStyledAttributes.getInt(0, 0));
                }
                if (obtainStyledAttributes.hasValue(3)) {
                    setRepeatCount(obtainStyledAttributes.getInt(3, 0));
                }
                if (obtainStyledAttributes.hasValue(4)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(4, 0));
                }
                if (obtainStyledAttributes.hasValue(5)) {
                    setRepeatMode(obtainStyledAttributes.getInt(5, 0));
                }
                if (obtainStyledAttributes.hasValue(6)) {
                    switch (obtainStyledAttributes.getInt(6, 0)) {
                        case 90:
                            this.f.f2831a = b.CW_90;
                            break;
                        case 180:
                            this.f.f2831a = b.CW_180;
                            break;
                        case 270:
                            this.f.f2831a = b.CW_270;
                            break;
                        default:
                            this.f.f2831a = b.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(13)) {
                    switch (obtainStyledAttributes.getInt(13, 0)) {
                        case 1:
                            this.f.i = c.RADIAL;
                            break;
                        default:
                            this.f.i = c.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(7)) {
                    this.f.f2833c = obtainStyledAttributes.getFloat(7, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(8)) {
                    this.f.d = obtainStyledAttributes.getDimensionPixelSize(8, 0);
                }
                if (obtainStyledAttributes.hasValue(9)) {
                    this.f.e = obtainStyledAttributes.getDimensionPixelSize(9, 0);
                }
                if (obtainStyledAttributes.hasValue(10)) {
                    this.f.f = obtainStyledAttributes.getFloat(10, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(11)) {
                    this.f.g = obtainStyledAttributes.getFloat(11, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(12)) {
                    this.f.h = obtainStyledAttributes.getFloat(12, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(14)) {
                    this.f.f2832b = obtainStyledAttributes.getFloat(14, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void a() {
        setAutoStart(false);
        setDuration(1000);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.f.f2831a = b.CW_0;
        this.f.i = c.LINEAR;
        this.f.f2833c = 0.5f;
        this.f.d = 0;
        this.f.e = 0;
        this.f.f = 0.0f;
        this.f.g = 1.0f;
        this.f.h = 1.0f;
        this.f.f2832b = 20.0f;
        this.g = new d();
        setBaseAlpha(0.3f);
        g();
    }

    public void setAutoStart(boolean z) {
        this.j = z;
        g();
    }

    public float getBaseAlpha() {
        return this.d.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.d.setAlpha((int) (a(0.0f, 1.0f, f) * 255.0f));
        g();
    }

    public int getDuration() {
        return this.k;
    }

    public void setDuration(int i) {
        this.k = i;
        g();
    }

    public int getRepeatCount() {
        return this.l;
    }

    public void setRepeatCount(int i) {
        this.l = i;
        g();
    }

    public int getRepeatDelay() {
        return this.m;
    }

    public void setRepeatDelay(int i) {
        this.m = i;
        g();
    }

    public int getRepeatMode() {
        return this.n;
    }

    public void setRepeatMode(int i) {
        this.n = i;
        g();
    }

    public c getMaskShape() {
        return this.f.i;
    }

    public void setMaskShape(c cVar) {
        this.f.i = cVar;
        g();
    }

    public b getAngle() {
        return this.f.f2831a;
    }

    public void setAngle(b bVar) {
        this.f.f2831a = bVar;
        g();
    }

    public float getDropoff() {
        return this.f.f2833c;
    }

    public void setDropoff(float f) {
        this.f.f2833c = f;
        g();
    }

    public int getFixedWidth() {
        return this.f.d;
    }

    public void setFixedWidth(int i) {
        this.f.d = i;
        g();
    }

    public int getFixedHeight() {
        return this.f.e;
    }

    public void setFixedHeight(int i) {
        this.f.e = i;
        g();
    }

    public float getIntensity() {
        return this.f.f;
    }

    public void setIntensity(float f) {
        this.f.f = f;
        g();
    }

    public float getRelativeWidth() {
        return this.f.g;
    }

    public void setRelativeWidth(int i) {
        this.f.g = i;
        g();
    }

    public float getRelativeHeight() {
        return this.f.h;
    }

    public void setRelativeHeight(int i) {
        this.f.h = i;
        g();
    }

    public float getTilt() {
        return this.f.f2832b;
    }

    public void setTilt(float f) {
        this.f.f2832b = f;
        g();
    }

    public void b() {
        if (!this.q) {
            getShimmerAnimation().start();
            this.q = true;
        }
    }

    public void c() {
        if (this.f2825a != null) {
            this.f2825a.end();
            this.f2825a.removeAllUpdateListeners();
            this.f2825a.cancel();
        }
        this.f2825a = null;
        this.q = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.o != i) {
            this.o = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.p != i) {
            this.p = i;
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.r == null) {
            this.r = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.r);
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        return new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.fotoable.youtube.music.locker.view.shimmer.ShimmerFrameLayout.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                boolean z = ShimmerFrameLayout.this.q;
                ShimmerFrameLayout.this.g();
                if (ShimmerFrameLayout.this.j || z) {
                    ShimmerFrameLayout.this.b();
                }
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        c();
        if (this.r != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.r);
            this.r = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.q || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            a(canvas);
        }
    }

    private static float a(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean a(Canvas canvas) {
        Bitmap d2 = d();
        Bitmap e = e();
        if (d2 == null || e == null) {
            return false;
        }
        b(new Canvas(d2));
        canvas.drawBitmap(d2, 0.0f, 0.0f, this.d);
        c(new Canvas(e));
        canvas.drawBitmap(e, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap d() {
        if (this.i == null) {
            this.i = f();
        }
        return this.i;
    }

    private Bitmap e() {
        if (this.h == null) {
            this.h = f();
        }
        return this.h;
    }

    private Bitmap f() {
        int width = getWidth();
        int height = getHeight();
        try {
            return a(width, height);
        } catch (OutOfMemoryError e) {
            StringBuilder sb = new StringBuilder("ShimmerFrameLayout failed to create working bitmap");
            sb.append(" (width = ");
            sb.append(width);
            sb.append(", height = ");
            sb.append(height);
            sb.append(")\n\n");
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
            Log.d("ShimmerFrameLayout", sb.toString());
            return null;
        }
    }

    private void b(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    private void c(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap != null) {
            canvas.clipRect(this.o, this.p, this.o + maskBitmap.getWidth(), this.p + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.o, this.p, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        c();
        h();
        i();
    }

    private void h() {
        if (this.f2826b != null) {
            this.f2826b.recycle();
            this.f2826b = null;
        }
    }

    private void i() {
        if (this.i != null) {
            this.i.recycle();
            this.i = null;
        }
        if (this.h != null) {
            this.h.recycle();
            this.h = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.f2826b != null) {
            return this.f2826b;
        }
        int a2 = this.f.a(getWidth());
        int b2 = this.f.b(getHeight());
        this.f2826b = a(a2, b2);
        Canvas canvas = new Canvas(this.f2826b);
        switch (this.f.i) {
            case RADIAL:
                radialGradient = new RadialGradient(a2 / 2, b2 / 2, (float) (Math.max(a2, b2) / Math.sqrt(2.0d)), this.f.a(), this.f.b(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.f.f2831a) {
                    case CW_90:
                        i = b2;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = a2;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = b2;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = a2;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient(i4, i3, i2, i, this.f.a(), this.f.b(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.f.f2832b, a2 / 2, b2 / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(a2, b2))) / 2;
        canvas.drawRect(-sqrt, -sqrt, a2 + sqrt, sqrt + b2, paint);
        return this.f2826b;
    }

    private Animator getShimmerAnimation() {
        if (this.f2825a != null) {
            return this.f2825a;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.f2829a[this.f.i.ordinal()];
        switch (this.f.f2831a) {
            case CW_90:
                this.g.a(0, -height, 0, height);
                break;
            case CW_180:
                this.g.a(width, 0, -width, 0);
                break;
            case CW_270:
                this.g.a(0, height, 0, -height);
                break;
            default:
                this.g.a(-width, 0, width, 0);
                break;
        }
        this.f2825a = ValueAnimator.ofFloat(0.0f, 1.0f + (this.m / this.k));
        this.f2825a.setDuration(this.k + this.m);
        this.f2825a.setRepeatCount(this.l);
        this.f2825a.setRepeatMode(this.n);
        this.f2825a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fotoable.youtube.music.locker.view.shimmer.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.g.f2840a * (1.0f - max)) + (ShimmerFrameLayout.this.g.f2842c * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.g.d) + (ShimmerFrameLayout.this.g.f2841b * (1.0f - max))));
            }
        });
        return this.f2825a;
    }

    protected static Bitmap a(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }
}
