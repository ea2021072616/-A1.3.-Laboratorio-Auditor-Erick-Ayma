package com.yanzhenjie.durban.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yanzhenjie.durban.R;
import com.yanzhenjie.durban.a.d;
import com.yanzhenjie.durban.d.h;
/* loaded from: classes.dex */
public class OverlayView extends View {
    private d A;
    private boolean B;

    /* renamed from: a  reason: collision with root package name */
    protected int f5184a;

    /* renamed from: b  reason: collision with root package name */
    protected int f5185b;

    /* renamed from: c  reason: collision with root package name */
    protected float[] f5186c;
    protected float[] d;
    private final RectF e;
    private final RectF f;
    private int g;
    private int h;
    private float i;
    private float[] j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private Path o;
    private Paint p;
    private Paint q;
    private Paint r;
    private Paint s;
    private int t;
    private float u;
    private float v;
    private int w;
    private int x;
    private int y;
    private int z;

    public OverlayView(Context context) {
        this(context, null);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new RectF();
        this.f = new RectF();
        this.j = null;
        this.o = new Path();
        this.p = new Paint(1);
        this.q = new Paint(1);
        this.r = new Paint(1);
        this.s = new Paint(1);
        this.t = 0;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1;
        a();
    }

    protected void a() {
        this.x = getResources().getDimensionPixelSize(R.dimen.durban_dp_30);
        this.y = getResources().getDimensionPixelSize(R.dimen.durban_dp_100);
        this.z = getResources().getDimensionPixelSize(R.dimen.durban_dp_10);
        if (Build.VERSION.SDK_INT < 18 && Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    public void setOverlayViewChangeListener(d dVar) {
        this.A = dVar;
    }

    @NonNull
    public RectF getCropViewRect() {
        return this.e;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z) {
        this.t = z ? 1 : 0;
    }

    public int getFreestyleCropMode() {
        return this.t;
    }

    public void setFreestyleCropMode(int i) {
        this.t = i;
        postInvalidate();
    }

    public void setCircleDimmedLayer(boolean z) {
        this.m = z;
    }

    public void setCropGridRowCount(@IntRange(from = 0) int i) {
        this.g = i;
        this.j = null;
    }

    public void setCropGridColumnCount(@IntRange(from = 0) int i) {
        this.h = i;
        this.j = null;
    }

    public void setShowCropFrame(boolean z) {
        this.k = z;
    }

    public void setShowCropGrid(boolean z) {
        this.l = z;
    }

    public void setDimmedColor(@ColorInt int i) {
        this.n = i;
    }

    public void setCropFrameStrokeWidth(@IntRange(from = 0) int i) {
        this.r.setStrokeWidth(i);
    }

    public void setCropGridStrokeWidth(@IntRange(from = 0) int i) {
        this.q.setStrokeWidth(i);
    }

    public void setCropFrameColor(@ColorInt int i) {
        this.r.setColor(i);
    }

    public void setCropGridColor(@ColorInt int i) {
        this.q.setColor(i);
    }

    public void setTargetAspectRatio(float f) {
        this.i = f;
        if (this.f5184a > 0) {
            b();
            postInvalidate();
            return;
        }
        this.B = true;
    }

    public void b() {
        int i = (int) (this.f5184a / this.i);
        if (i > this.f5185b) {
            int i2 = (int) (this.f5185b * this.i);
            int i3 = (this.f5184a - i2) / 2;
            this.e.set(getPaddingLeft() + i3, getPaddingTop(), i2 + getPaddingLeft() + i3, getPaddingTop() + this.f5185b);
        } else {
            int i4 = (this.f5185b - i) / 2;
            this.e.set(getPaddingLeft(), getPaddingTop() + i4, getPaddingLeft() + this.f5184a, i + getPaddingTop() + i4);
        }
        if (this.A != null) {
            this.A.a(this.e);
        }
        c();
    }

    private void c() {
        this.f5186c = h.a(this.e);
        this.d = h.b(this.e);
        this.j = null;
        this.o.reset();
        this.o.addCircle(this.e.centerX(), this.e.centerY(), Math.min(this.e.width(), this.e.height()) / 2.0f, Path.Direction.CW);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f5184a = (getWidth() - getPaddingRight()) - paddingLeft;
            this.f5185b = (getHeight() - getPaddingBottom()) - paddingTop;
            if (this.B) {
                this.B = false;
                setTargetAspectRatio(this.i);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.e.isEmpty() || this.t == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if ((motionEvent.getAction() & 255) == 0) {
            this.w = b(x, y);
            boolean z = this.w != -1;
            if (!z) {
                this.u = -1.0f;
                this.v = -1.0f;
                return z;
            } else if (this.u < 0.0f) {
                this.u = x;
                this.v = y;
                return z;
            } else {
                return z;
            }
        } else if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.w != -1) {
            float min = Math.min(Math.max(x, getPaddingLeft()), getWidth() - getPaddingRight());
            float min2 = Math.min(Math.max(y, getPaddingTop()), getHeight() - getPaddingBottom());
            a(min, min2);
            this.u = min;
            this.v = min2;
            return true;
        } else {
            if ((motionEvent.getAction() & 255) == 1) {
                this.u = -1.0f;
                this.v = -1.0f;
                this.w = -1;
                if (this.A != null) {
                    this.A.a(this.e);
                }
            }
            return false;
        }
    }

    private void a(float f, float f2) {
        this.f.set(this.e);
        switch (this.w) {
            case 0:
                this.f.set(f, f2, this.e.right, this.e.bottom);
                break;
            case 1:
                this.f.set(this.e.left, f2, f, this.e.bottom);
                break;
            case 2:
                this.f.set(this.e.left, this.e.top, f, f2);
                break;
            case 3:
                this.f.set(f, this.e.top, this.e.right, f2);
                break;
            case 4:
                this.f.offset(f - this.u, f2 - this.v);
                if (this.f.left > getLeft() && this.f.top > getTop() && this.f.right < getRight() && this.f.bottom < getBottom()) {
                    this.e.set(this.f);
                    c();
                    postInvalidate();
                    return;
                }
                return;
        }
        boolean z = this.f.height() >= ((float) this.y);
        boolean z2 = this.f.width() >= ((float) this.y);
        this.e.set(z2 ? this.f.left : this.e.left, z ? this.f.top : this.e.top, z2 ? this.f.right : this.e.right, z ? this.f.bottom : this.e.bottom);
        if (z || z2) {
            c();
            postInvalidate();
        }
    }

    private int b(float f, float f2) {
        int i;
        int i2 = -1;
        double d = this.x;
        int i3 = 0;
        while (i3 < 8) {
            double sqrt = Math.sqrt(Math.pow(f - this.f5186c[i3], 2.0d) + Math.pow(f2 - this.f5186c[i3 + 1], 2.0d));
            if (sqrt < d) {
                i = i3 / 2;
            } else {
                sqrt = d;
                i = i2;
            }
            i3 += 2;
            i2 = i;
            d = sqrt;
        }
        if (this.t == 1 && i2 < 0 && this.e.contains(f, f2)) {
            return 4;
        }
        return i2;
    }

    protected void a(@NonNull Canvas canvas) {
        canvas.save();
        if (this.m) {
            canvas.clipPath(this.o, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.e, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.n);
        canvas.restore();
        if (this.m) {
            canvas.drawCircle(this.e.centerX(), this.e.centerY(), Math.min(this.e.width(), this.e.height()) / 2.0f, this.p);
        }
    }

    protected void b(@NonNull Canvas canvas) {
        if (this.l) {
            if (this.j == null && !this.e.isEmpty()) {
                this.j = new float[(this.g * 4) + (this.h * 4)];
                int i = 0;
                for (int i2 = 0; i2 < this.g; i2++) {
                    int i3 = i + 1;
                    this.j[i] = this.e.left;
                    int i4 = i3 + 1;
                    this.j[i3] = (this.e.height() * ((i2 + 1.0f) / (this.g + 1))) + this.e.top;
                    int i5 = i4 + 1;
                    this.j[i4] = this.e.right;
                    i = i5 + 1;
                    this.j[i5] = (this.e.height() * ((i2 + 1.0f) / (this.g + 1))) + this.e.top;
                }
                for (int i6 = 0; i6 < this.h; i6++) {
                    int i7 = i + 1;
                    this.j[i] = (this.e.width() * ((i6 + 1.0f) / (this.h + 1))) + this.e.left;
                    int i8 = i7 + 1;
                    this.j[i7] = this.e.top;
                    int i9 = i8 + 1;
                    this.j[i8] = (this.e.width() * ((i6 + 1.0f) / (this.h + 1))) + this.e.left;
                    i = i9 + 1;
                    this.j[i9] = this.e.bottom;
                }
            }
            if (this.j != null) {
                canvas.drawLines(this.j, this.q);
            }
        }
        if (this.k) {
            canvas.drawRect(this.e, this.r);
        }
        if (this.t != 0) {
            canvas.save();
            this.f.set(this.e);
            this.f.inset(this.z, -this.z);
            canvas.clipRect(this.f, Region.Op.DIFFERENCE);
            this.f.set(this.e);
            this.f.inset(-this.z, this.z);
            canvas.clipRect(this.f, Region.Op.DIFFERENCE);
            canvas.drawRect(this.e, this.s);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull TypedArray typedArray) {
        this.m = typedArray.getBoolean(R.styleable.durban_CropView_durban_circle_dimmed_layer, false);
        this.n = typedArray.getColor(R.styleable.durban_CropView_durban_dimmed_color, ContextCompat.getColor(getContext(), R.color.durban_CropDimmed));
        this.p.setColor(this.n);
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setStrokeWidth(1.0f);
        b(typedArray);
        this.k = typedArray.getBoolean(R.styleable.durban_CropView_durban_show_frame, true);
        c(typedArray);
        this.l = typedArray.getBoolean(R.styleable.durban_CropView_durban_show_grid, true);
    }

    private void b(@NonNull TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.durban_CropView_durban_frame_stroke_size, getResources().getDimensionPixelSize(R.dimen.durban_dp_1));
        int color = typedArray.getColor(R.styleable.durban_CropView_durban_frame_color, ContextCompat.getColor(getContext(), R.color.durban_CropFrameLine));
        this.r.setStrokeWidth(dimensionPixelSize);
        this.r.setColor(color);
        this.r.setStyle(Paint.Style.STROKE);
        this.s.setStrokeWidth(dimensionPixelSize * 3);
        this.s.setColor(color);
        this.s.setStyle(Paint.Style.STROKE);
    }

    private void c(@NonNull TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.durban_CropView_durban_grid_stroke_size, getResources().getDimensionPixelSize(R.dimen.durban_dp_1));
        int color = typedArray.getColor(R.styleable.durban_CropView_durban_grid_color, ContextCompat.getColor(getContext(), R.color.durban_CropGridLine));
        this.q.setStrokeWidth(dimensionPixelSize);
        this.q.setColor(color);
        this.g = typedArray.getInt(R.styleable.durban_CropView_durban_grid_row_count, 2);
        this.h = typedArray.getInt(R.styleable.durban_CropView_durban_grid_column_count, 2);
    }
}
