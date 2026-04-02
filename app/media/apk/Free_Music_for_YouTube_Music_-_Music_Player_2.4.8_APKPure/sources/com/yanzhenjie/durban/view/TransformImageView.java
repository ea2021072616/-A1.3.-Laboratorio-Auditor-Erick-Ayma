package com.yanzhenjie.durban.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.yanzhenjie.durban.d.e;
import com.yanzhenjie.durban.d.h;
import com.yanzhenjie.durban.model.b;
/* loaded from: classes2.dex */
public class TransformImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    protected final float[] f5187a;

    /* renamed from: b  reason: collision with root package name */
    protected final float[] f5188b;

    /* renamed from: c  reason: collision with root package name */
    protected Matrix f5189c;
    protected int d;
    protected int e;
    protected a f;
    protected boolean g;
    protected boolean h;
    private final float[] i;
    private float[] j;
    private float[] k;
    private int l;
    private String m;
    private String n;
    private b o;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void a(float f);

        void b();

        void b(float f);
    }

    public TransformImageView(Context context) {
        this(context, null);
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5187a = new float[8];
        this.f5188b = new float[2];
        this.i = new float[9];
        this.f5189c = new Matrix();
        this.g = false;
        this.h = false;
        this.l = 0;
        e();
    }

    public void setTransformImageListener(a aVar) {
        this.f = aVar;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setMaxBitmapSize(int i) {
        this.l = i;
    }

    public int getMaxBitmapSize() {
        if (this.l <= 0) {
            this.l = com.yanzhenjie.durban.d.a.a(getContext());
        }
        return this.l;
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new e(bitmap));
    }

    public String getImagePath() {
        return this.m;
    }

    public String getOutputDirectory() {
        return this.n;
    }

    public b getExifInfo() {
        return this.o;
    }

    public void setOutputDirectory(String str) {
        this.n = str;
    }

    public void setImagePath(@NonNull String str) throws Exception {
        this.m = str;
        int maxBitmapSize = getMaxBitmapSize();
        new com.yanzhenjie.durban.c.b(getContext(), maxBitmapSize, maxBitmapSize, new com.yanzhenjie.durban.a.b() { // from class: com.yanzhenjie.durban.view.TransformImageView.1
            @Override // com.yanzhenjie.durban.a.b
            public void a(@NonNull Bitmap bitmap, @NonNull b bVar) {
                TransformImageView.this.o = bVar;
                TransformImageView.this.g = true;
                TransformImageView.this.setImageBitmap(bitmap);
            }

            @Override // com.yanzhenjie.durban.a.b
            public void a() {
                if (TransformImageView.this.f != null) {
                    TransformImageView.this.f.b();
                }
            }
        }).execute(str);
    }

    public float getCurrentScale() {
        return a(this.f5189c);
    }

    public float a(@NonNull Matrix matrix) {
        return (float) Math.sqrt(Math.pow(a(matrix, 0), 2.0d) + Math.pow(a(matrix, 3), 2.0d));
    }

    public float getCurrentAngle() {
        return b(this.f5189c);
    }

    public float b(@NonNull Matrix matrix) {
        return (float) (-(Math.atan2(a(matrix, 1), a(matrix, 0)) * 57.29577951308232d));
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.f5189c.set(matrix);
        a();
    }

    @Nullable
    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof e)) {
            return null;
        }
        return ((e) getDrawable()).a();
    }

    public void a(float f, float f2) {
        if (f != 0.0f || f2 != 0.0f) {
            this.f5189c.postTranslate(f, f2);
            setImageMatrix(this.f5189c);
        }
    }

    public void c(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.f5189c.postScale(f, f, f2, f3);
            setImageMatrix(this.f5189c);
            if (this.f != null) {
                this.f.b(a(this.f5189c));
            }
        }
    }

    public void d(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.f5189c.postRotate(f, f2, f3);
            setImageMatrix(this.f5189c);
            if (this.f != null) {
                this.f.a(b(this.f5189c));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || (this.g && !this.h)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.d = (getWidth() - getPaddingRight()) - paddingLeft;
            this.e = (getHeight() - getPaddingBottom()) - paddingTop;
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = drawable.getIntrinsicWidth();
            float intrinsicHeight = drawable.getIntrinsicHeight();
            Log.d("TransformImageView", String.format("Image size: [%d:%d]", Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)));
            RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
            this.j = h.a(rectF);
            this.k = h.b(rectF);
            this.h = true;
            if (this.f != null) {
                this.f.a();
            }
        }
    }

    protected float a(@NonNull Matrix matrix, @IntRange(from = 0, to = 9) int i) {
        matrix.getValues(this.i);
        return this.i[i];
    }

    private void a() {
        this.f5189c.mapPoints(this.f5187a, this.j);
        this.f5189c.mapPoints(this.f5188b, this.k);
    }
}
