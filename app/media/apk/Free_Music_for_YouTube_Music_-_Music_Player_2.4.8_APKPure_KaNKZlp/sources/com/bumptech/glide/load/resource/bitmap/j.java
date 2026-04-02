package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
/* compiled from: GlideBitmapDrawable.java */
/* loaded from: classes.dex */
public class j extends com.bumptech.glide.load.resource.a.b {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f930a;

    /* renamed from: b  reason: collision with root package name */
    private int f931b;

    /* renamed from: c  reason: collision with root package name */
    private int f932c;
    private boolean d;
    private boolean e;
    private a f;

    public j(Resources resources, Bitmap bitmap) {
        this(resources, new a(bitmap));
    }

    j(Resources resources, a aVar) {
        int i;
        this.f930a = new Rect();
        if (aVar == null) {
            throw new NullPointerException("BitmapState must not be null");
        }
        this.f = aVar;
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
            i = i == 0 ? 160 : i;
            aVar.f934b = i;
        } else {
            i = aVar.f934b;
        }
        this.f931b = aVar.f933a.getScaledWidth(i);
        this.f932c = aVar.f933a.getScaledHeight(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f931b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f932c;
    }

    @Override // com.bumptech.glide.load.resource.a.b
    public boolean a() {
        return false;
    }

    @Override // com.bumptech.glide.load.resource.a.b
    public void a(int i) {
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.d = true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.d) {
            Gravity.apply(119, this.f931b, this.f932c, getBounds(), this.f930a);
            this.d = false;
        }
        canvas.drawBitmap(this.f.f933a, (Rect) null, this.f930a, this.f.f935c);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f.f935c.getAlpha() != i) {
            this.f.a(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f.a(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap = this.f.f933a;
        return (bitmap == null || bitmap.hasAlpha() || this.f.f935c.getAlpha() < 255) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.e && super.mutate() == this) {
            this.f = new a(this.f);
            this.e = true;
        }
        return this;
    }

    public Bitmap b() {
        return this.f.f933a;
    }

    /* compiled from: GlideBitmapDrawable.java */
    /* loaded from: classes.dex */
    static class a extends Drawable.ConstantState {
        private static final Paint d = new Paint(6);

        /* renamed from: a  reason: collision with root package name */
        final Bitmap f933a;

        /* renamed from: b  reason: collision with root package name */
        int f934b;

        /* renamed from: c  reason: collision with root package name */
        Paint f935c;

        public a(Bitmap bitmap) {
            this.f935c = d;
            this.f933a = bitmap;
        }

        a(a aVar) {
            this(aVar.f933a);
            this.f934b = aVar.f934b;
        }

        void a(ColorFilter colorFilter) {
            a();
            this.f935c.setColorFilter(colorFilter);
        }

        void a(int i) {
            a();
            this.f935c.setAlpha(i);
        }

        void a() {
            if (d == this.f935c) {
                this.f935c = new Paint(6);
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new j((Resources) null, this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new j(resources, this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }
}
