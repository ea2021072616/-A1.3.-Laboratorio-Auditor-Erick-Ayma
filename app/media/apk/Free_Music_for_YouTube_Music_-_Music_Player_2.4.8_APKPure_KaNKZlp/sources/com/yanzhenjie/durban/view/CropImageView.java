package com.yanzhenjie.durban.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.yanzhenjie.durban.R;
import com.yanzhenjie.durban.a.c;
import com.yanzhenjie.durban.d.h;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class CropImageView extends TransformImageView {
    private final RectF i;
    private final Matrix j;
    private float k;
    private float l;
    private c m;
    private Runnable n;
    private Runnable o;
    private float p;
    private float q;
    private int r;
    private int s;
    private long t;

    public CropImageView(Context context) {
        this(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new RectF();
        this.j = new Matrix();
        this.l = 10.0f;
        this.o = null;
        this.r = 0;
        this.s = 0;
        this.t = 500L;
    }

    public void a(@NonNull Bitmap.CompressFormat compressFormat, int i, @Nullable com.yanzhenjie.durban.a.a aVar) {
        a();
        setImageToWrapCropBounds(false);
        new com.yanzhenjie.durban.c.a(getContext(), getViewBitmap(), new com.yanzhenjie.durban.model.c(this.i, h.b(this.f5187a), getCurrentScale(), getCurrentAngle()), new com.yanzhenjie.durban.model.a(this.r, this.s, compressFormat, i, getImagePath(), getOutputDirectory(), getExifInfo()), aVar).execute(new Void[0]);
    }

    public float getMaxScale() {
        return this.p;
    }

    public float getMinScale() {
        return this.q;
    }

    public float getTargetAspectRatio() {
        return this.k;
    }

    public void setCropRect(RectF rectF) {
        this.k = rectF.width() / rectF.height();
        this.i.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        g();
        b();
    }

    public void setTargetAspectRatio(float f) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.k = f;
            return;
        }
        if (f == 0.0f) {
            this.k = drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
        } else {
            this.k = f;
        }
        if (this.m != null) {
            this.m.a(this.k);
        }
    }

    @Nullable
    public c getCropBoundsChangeListener() {
        return this.m;
    }

    public void setCropBoundsChangeListener(@Nullable c cVar) {
        this.m = cVar;
    }

    public void setMaxResultImageSizeX(@IntRange(from = 10) int i) {
        this.r = i;
    }

    public void setMaxResultImageSizeY(@IntRange(from = 10) int i) {
        this.s = i;
    }

    public void setImageToWrapCropBoundsAnimDuration(@IntRange(from = 100) long j) {
        if (j > 0) {
            this.t = j;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxScaleMultiplier(float f) {
        this.l = f;
    }

    public void a(float f) {
        a(f, this.i.centerX(), this.i.centerY());
    }

    public void a(float f, float f2, float f3) {
        if (f >= getMinScale()) {
            c(f / getCurrentScale(), f2, f3);
        }
    }

    public void b(float f) {
        b(f, this.i.centerX(), this.i.centerY());
    }

    public void b(float f, float f2, float f3) {
        if (f <= getMaxScale()) {
            c(f / getCurrentScale(), f2, f3);
        }
    }

    @Override // com.yanzhenjie.durban.view.TransformImageView
    public void c(float f, float f2, float f3) {
        if (f > 1.0f && getCurrentScale() * f <= getMaxScale()) {
            super.c(f, f2, f3);
        } else if (f < 1.0f && getCurrentScale() * f >= getMinScale()) {
            super.c(f, f2, f3);
        }
    }

    public void c(float f) {
        d(f, this.i.centerX(), this.i.centerY());
    }

    public void a() {
        removeCallbacks(this.n);
        removeCallbacks(this.o);
    }

    public void b() {
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean z) {
        if (this.h && !d()) {
            float f = this.f5188b[0];
            float f2 = this.f5188b[1];
            float currentScale = getCurrentScale();
            float centerX = this.i.centerX() - f;
            float centerY = this.i.centerY() - f2;
            float f3 = 0.0f;
            this.j.reset();
            this.j.setTranslate(centerX, centerY);
            float[] copyOf = Arrays.copyOf(this.f5187a, this.f5187a.length);
            this.j.mapPoints(copyOf);
            boolean a2 = a(copyOf);
            if (a2) {
                float[] f4 = f();
                centerX = -(f4[0] + f4[2]);
                centerY = -(f4[3] + f4[1]);
            } else {
                RectF rectF = new RectF(this.i);
                this.j.reset();
                this.j.setRotate(getCurrentAngle());
                this.j.mapRect(rectF);
                float[] a3 = h.a(this.f5187a);
                f3 = (Math.max(rectF.width() / a3[0], rectF.height() / a3[1]) * currentScale) - currentScale;
            }
            if (z) {
                a aVar = new a(this, this.t, f, f2, centerX, centerY, currentScale, f3, a2);
                this.n = aVar;
                post(aVar);
                return;
            }
            a(centerX, centerY);
            if (!a2) {
                b(currentScale + f3, this.i.centerX(), this.i.centerY());
            }
        }
    }

    private float[] f() {
        this.j.reset();
        this.j.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(this.f5187a, this.f5187a.length);
        float[] a2 = h.a(this.i);
        this.j.mapPoints(copyOf);
        this.j.mapPoints(a2);
        RectF b2 = h.b(copyOf);
        RectF b3 = h.b(a2);
        float f = b2.left - b3.left;
        float f2 = b2.top - b3.top;
        float f3 = b2.right - b3.right;
        float f4 = b2.bottom - b3.bottom;
        float[] fArr = new float[4];
        if (f <= 0.0f) {
            f = 0.0f;
        }
        fArr[0] = f;
        fArr[1] = f2 > 0.0f ? f2 : 0.0f;
        fArr[2] = f3 < 0.0f ? f3 : 0.0f;
        fArr[3] = f4 < 0.0f ? f4 : 0.0f;
        this.j.reset();
        this.j.setRotate(getCurrentAngle());
        this.j.mapPoints(fArr);
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yanzhenjie.durban.view.TransformImageView
    public void c() {
        int i;
        int i2;
        int i3;
        super.c();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = drawable.getIntrinsicWidth();
            float intrinsicHeight = drawable.getIntrinsicHeight();
            if (this.k == 0.0f) {
                this.k = intrinsicWidth / intrinsicHeight;
            }
            int i4 = (int) (this.d / this.k);
            if (i4 > this.e) {
                this.i.set((this.d - ((int) (this.e * this.k))) / 2, 0.0f, i2 + i3, this.e);
            } else {
                this.i.set(0.0f, (this.e - i4) / 2, this.d, i4 + i);
            }
            b(intrinsicWidth, intrinsicHeight);
            c(intrinsicWidth, intrinsicHeight);
            if (this.m != null) {
                this.m.a(this.k);
            }
            if (this.f != null) {
                this.f.b(getCurrentScale());
                this.f.a(getCurrentAngle());
            }
        }
    }

    protected boolean d() {
        return a(this.f5187a);
    }

    protected boolean a(float[] fArr) {
        this.j.reset();
        this.j.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.j.mapPoints(copyOf);
        float[] a2 = h.a(this.i);
        this.j.mapPoints(a2);
        return h.b(copyOf).contains(h.b(a2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(float f, float f2, float f3, long j) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        float currentScale = getCurrentScale();
        b bVar = new b(this, j, currentScale, f - currentScale, f2, f3);
        this.o = bVar;
        post(bVar);
    }

    private void g() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            b(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    private void b(float f, float f2) {
        this.q = Math.min(Math.min(this.i.width() / f, this.i.width() / f2), Math.min(this.i.height() / f2, this.i.height() / f));
        this.p = this.q * this.l;
    }

    private void c(float f, float f2) {
        float width = this.i.width();
        float height = this.i.height();
        float max = Math.max(this.i.width() / f, this.i.height() / f2);
        float f3 = ((width - (f * max)) / 2.0f) + this.i.left;
        float f4 = ((height - (f2 * max)) / 2.0f) + this.i.top;
        this.f5189c.reset();
        this.f5189c.postScale(max, max);
        this.f5189c.postTranslate(f3, f4);
        setImageMatrix(this.f5189c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(R.styleable.durban_CropView_durban_aspect_ratio_x, 0.0f));
        float abs2 = Math.abs(typedArray.getFloat(R.styleable.durban_CropView_durban_aspect_ratio_y, 0.0f));
        if (abs == 0.0f || abs2 == 0.0f) {
            this.k = 0.0f;
        } else {
            this.k = abs / abs2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<CropImageView> f5171a;

        /* renamed from: b  reason: collision with root package name */
        private final long f5172b;

        /* renamed from: c  reason: collision with root package name */
        private final long f5173c = System.currentTimeMillis();
        private final float d;
        private final float e;
        private final float f;
        private final float g;
        private final float h;
        private final float i;
        private final boolean j;

        public a(CropImageView cropImageView, long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
            this.f5171a = new WeakReference<>(cropImageView);
            this.f5172b = j;
            this.d = f;
            this.e = f2;
            this.f = f3;
            this.g = f4;
            this.h = f5;
            this.i = f6;
            this.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.f5171a.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.f5172b, System.currentTimeMillis() - this.f5173c);
                float a2 = com.yanzhenjie.durban.d.b.a(min, 0.0f, this.f, (float) this.f5172b);
                float a3 = com.yanzhenjie.durban.d.b.a(min, 0.0f, this.g, (float) this.f5172b);
                float b2 = com.yanzhenjie.durban.d.b.b(min, 0.0f, this.i, (float) this.f5172b);
                if (min < ((float) this.f5172b)) {
                    cropImageView.a(a2 - (cropImageView.f5188b[0] - this.d), a3 - (cropImageView.f5188b[1] - this.e));
                    if (!this.j) {
                        cropImageView.b(this.h + b2, cropImageView.i.centerX(), cropImageView.i.centerY());
                    }
                    if (!cropImageView.d()) {
                        cropImageView.post(this);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<CropImageView> f5174a;

        /* renamed from: b  reason: collision with root package name */
        private final long f5175b;

        /* renamed from: c  reason: collision with root package name */
        private final long f5176c = System.currentTimeMillis();
        private final float d;
        private final float e;
        private final float f;
        private final float g;

        public b(CropImageView cropImageView, long j, float f, float f2, float f3, float f4) {
            this.f5174a = new WeakReference<>(cropImageView);
            this.f5175b = j;
            this.d = f;
            this.e = f2;
            this.f = f3;
            this.g = f4;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.f5174a.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.f5175b, System.currentTimeMillis() - this.f5176c);
                float b2 = com.yanzhenjie.durban.d.b.b(min, 0.0f, this.e, (float) this.f5175b);
                if (min < ((float) this.f5175b)) {
                    cropImageView.b(this.d + b2, this.f, this.g);
                    cropImageView.post(this);
                    return;
                }
                cropImageView.b();
            }
        }
    }
}
