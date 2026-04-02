package com.makeramen.roundedimageview;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.util.HashSet;
/* compiled from: RoundedDrawable.java */
/* loaded from: classes2.dex */
public class a extends Drawable {
    private final Bitmap d;
    private final Paint e;
    private final int f;
    private final int g;
    private final Paint i;

    /* renamed from: a  reason: collision with root package name */
    private final RectF f4997a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f4998b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final RectF f4999c = new RectF();
    private final RectF h = new RectF();
    private final Matrix j = new Matrix();
    private final RectF k = new RectF();
    private Shader.TileMode l = Shader.TileMode.CLAMP;
    private Shader.TileMode m = Shader.TileMode.CLAMP;
    private boolean n = true;
    private float o = 0.0f;
    private final boolean[] p = {true, true, true, true};
    private boolean q = false;
    private float r = 0.0f;
    private ColorStateList s = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
    private ImageView.ScaleType t = ImageView.ScaleType.FIT_CENTER;

    public a(Bitmap bitmap) {
        this.d = bitmap;
        this.f = bitmap.getWidth();
        this.g = bitmap.getHeight();
        this.f4999c.set(0.0f, 0.0f, this.f, this.g);
        this.e = new Paint();
        this.e.setStyle(Paint.Style.FILL);
        this.e.setAntiAlias(true);
        this.i = new Paint();
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setAntiAlias(true);
        this.i.setColor(this.s.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        this.i.setStrokeWidth(this.r);
    }

    public static a a(Bitmap bitmap) {
        if (bitmap != null) {
            return new a(bitmap);
        }
        return null;
    }

    public static Drawable a(Drawable drawable) {
        if (drawable != null && !(drawable instanceof a)) {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), a(layerDrawable.getDrawable(i)));
                }
                return layerDrawable;
            }
            Bitmap b2 = b(drawable);
            if (b2 != null) {
                return new a(b2);
            }
            return drawable;
        }
        return drawable;
    }

    public static Bitmap b(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            ThrowableExtension.printStackTrace(e);
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.s.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.s.getColorForState(iArr, 0);
        if (this.i.getColor() != colorForState) {
            this.i.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RoundedDrawable.java */
    /* renamed from: com.makeramen.roundedimageview.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5000a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f5000a[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5000a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5000a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5000a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5000a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5000a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5000a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    private void a() {
        float min;
        float width;
        float f;
        float f2 = 0.0f;
        switch (AnonymousClass1.f5000a[this.t.ordinal()]) {
            case 1:
                this.h.set(this.f4997a);
                this.h.inset(this.r / 2.0f, this.r / 2.0f);
                this.j.reset();
                this.j.setTranslate((int) (((this.h.width() - this.f) * 0.5f) + 0.5f), (int) (((this.h.height() - this.g) * 0.5f) + 0.5f));
                break;
            case 2:
                this.h.set(this.f4997a);
                this.h.inset(this.r / 2.0f, this.r / 2.0f);
                this.j.reset();
                if (this.f * this.h.height() > this.h.width() * this.g) {
                    width = this.h.height() / this.g;
                    f = (this.h.width() - (this.f * width)) * 0.5f;
                } else {
                    width = this.h.width() / this.f;
                    f = 0.0f;
                    f2 = (this.h.height() - (this.g * width)) * 0.5f;
                }
                this.j.setScale(width, width);
                this.j.postTranslate(((int) (f + 0.5f)) + (this.r / 2.0f), ((int) (f2 + 0.5f)) + (this.r / 2.0f));
                break;
            case 3:
                this.j.reset();
                if (this.f <= this.f4997a.width() && this.g <= this.f4997a.height()) {
                    min = 1.0f;
                } else {
                    min = Math.min(this.f4997a.width() / this.f, this.f4997a.height() / this.g);
                }
                this.j.setScale(min, min);
                this.j.postTranslate((int) (((this.f4997a.width() - (this.f * min)) * 0.5f) + 0.5f), (int) (((this.f4997a.height() - (this.g * min)) * 0.5f) + 0.5f));
                this.h.set(this.f4999c);
                this.j.mapRect(this.h);
                this.h.inset(this.r / 2.0f, this.r / 2.0f);
                this.j.setRectToRect(this.f4999c, this.h, Matrix.ScaleToFit.FILL);
                break;
            case 4:
            default:
                this.h.set(this.f4999c);
                this.j.setRectToRect(this.f4999c, this.f4997a, Matrix.ScaleToFit.CENTER);
                this.j.mapRect(this.h);
                this.h.inset(this.r / 2.0f, this.r / 2.0f);
                this.j.setRectToRect(this.f4999c, this.h, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.h.set(this.f4999c);
                this.j.setRectToRect(this.f4999c, this.f4997a, Matrix.ScaleToFit.END);
                this.j.mapRect(this.h);
                this.h.inset(this.r / 2.0f, this.r / 2.0f);
                this.j.setRectToRect(this.f4999c, this.h, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.h.set(this.f4999c);
                this.j.setRectToRect(this.f4999c, this.f4997a, Matrix.ScaleToFit.START);
                this.j.mapRect(this.h);
                this.h.inset(this.r / 2.0f, this.r / 2.0f);
                this.j.setRectToRect(this.f4999c, this.h, Matrix.ScaleToFit.FILL);
                break;
            case 7:
                this.h.set(this.f4997a);
                this.h.inset(this.r / 2.0f, this.r / 2.0f);
                this.j.reset();
                this.j.setRectToRect(this.f4999c, this.h, Matrix.ScaleToFit.FILL);
                break;
        }
        this.f4998b.set(this.h);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.f4997a.set(rect);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.n) {
            BitmapShader bitmapShader = new BitmapShader(this.d, this.l, this.m);
            if (this.l == Shader.TileMode.CLAMP && this.m == Shader.TileMode.CLAMP) {
                bitmapShader.setLocalMatrix(this.j);
            }
            this.e.setShader(bitmapShader);
            this.n = false;
        }
        if (this.q) {
            if (this.r > 0.0f) {
                canvas.drawOval(this.f4998b, this.e);
                canvas.drawOval(this.h, this.i);
                return;
            }
            canvas.drawOval(this.f4998b, this.e);
        } else if (a(this.p)) {
            float f = this.o;
            if (this.r > 0.0f) {
                canvas.drawRoundRect(this.f4998b, f, f, this.e);
                canvas.drawRoundRect(this.h, f, f, this.i);
                a(canvas);
                b(canvas);
                return;
            }
            canvas.drawRoundRect(this.f4998b, f, f, this.e);
            a(canvas);
        } else {
            canvas.drawRect(this.f4998b, this.e);
            if (this.r > 0.0f) {
                canvas.drawRect(this.h, this.i);
            }
        }
    }

    private void a(Canvas canvas) {
        if (!b(this.p) && this.o != 0.0f) {
            float f = this.f4998b.left;
            float f2 = this.f4998b.top;
            float width = this.f4998b.width() + f;
            float height = this.f4998b.height() + f2;
            float f3 = this.o;
            if (!this.p[0]) {
                this.k.set(f, f2, f + f3, f2 + f3);
                canvas.drawRect(this.k, this.e);
            }
            if (!this.p[1]) {
                this.k.set(width - f3, f2, width, f3);
                canvas.drawRect(this.k, this.e);
            }
            if (!this.p[2]) {
                this.k.set(width - f3, height - f3, width, height);
                canvas.drawRect(this.k, this.e);
            }
            if (!this.p[3]) {
                this.k.set(f, height - f3, f3 + f, height);
                canvas.drawRect(this.k, this.e);
            }
        }
    }

    private void b(Canvas canvas) {
        if (!b(this.p) && this.o != 0.0f) {
            float f = this.f4998b.left;
            float f2 = this.f4998b.top;
            float width = f + this.f4998b.width();
            float height = f2 + this.f4998b.height();
            float f3 = this.o;
            float f4 = this.r / 2.0f;
            if (!this.p[0]) {
                canvas.drawLine(f - f4, f2, f + f3, f2, this.i);
                canvas.drawLine(f, f2 - f4, f, f2 + f3, this.i);
            }
            if (!this.p[1]) {
                canvas.drawLine((width - f3) - f4, f2, width, f2, this.i);
                canvas.drawLine(width, f2 - f4, width, f2 + f3, this.i);
            }
            if (!this.p[2]) {
                canvas.drawLine((width - f3) - f4, height, width + f4, height, this.i);
                canvas.drawLine(width, height - f3, width, height, this.i);
            }
            if (!this.p[3]) {
                canvas.drawLine(f - f4, height, f + f3, height, this.i);
                canvas.drawLine(f, height - f3, f, height, this.i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.e.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.e.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.g;
    }

    public a a(float f, float f2, float f3, float f4) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f));
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
        }
        if (!hashSet.isEmpty()) {
            float floatValue = ((Float) hashSet.iterator().next()).floatValue();
            if (Float.isInfinite(floatValue) || Float.isNaN(floatValue) || floatValue < 0.0f) {
                throw new IllegalArgumentException("Invalid radius value: " + floatValue);
            }
            this.o = floatValue;
        } else {
            this.o = 0.0f;
        }
        this.p[0] = f > 0.0f;
        this.p[1] = f2 > 0.0f;
        this.p[2] = f3 > 0.0f;
        this.p[3] = f4 > 0.0f;
        return this;
    }

    public a a(float f) {
        this.r = f;
        this.i.setStrokeWidth(this.r);
        return this;
    }

    public a a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.s = colorStateList;
        this.i.setColor(this.s.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        return this;
    }

    public a a(boolean z) {
        this.q = z;
        return this;
    }

    public a a(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.t != scaleType) {
            this.t = scaleType;
            a();
        }
        return this;
    }

    public a a(Shader.TileMode tileMode) {
        if (this.l != tileMode) {
            this.l = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    public a b(Shader.TileMode tileMode) {
        if (this.m != tileMode) {
            this.m = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean a(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }
}
