package com.bumptech.glide.load.resource.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Gravity;
import com.bumptech.glide.b.a;
import com.bumptech.glide.load.resource.c.f;
/* compiled from: GifDrawable.java */
/* loaded from: classes.dex */
public class b extends com.bumptech.glide.load.resource.a.b implements f.b {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f956a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f957b;

    /* renamed from: c  reason: collision with root package name */
    private final a f958c;
    private final com.bumptech.glide.b.a d;
    private final f e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private boolean l;

    public b(Context context, a.InterfaceC0020a interfaceC0020a, com.bumptech.glide.load.b.a.c cVar, com.bumptech.glide.load.g<Bitmap> gVar, int i, int i2, com.bumptech.glide.b.c cVar2, byte[] bArr, Bitmap bitmap) {
        this(new a(cVar2, bArr, context, gVar, i, i2, interfaceC0020a, cVar, bitmap));
    }

    public b(b bVar, Bitmap bitmap, com.bumptech.glide.load.g<Bitmap> gVar) {
        this(new a(bVar.f958c.f959a, bVar.f958c.f960b, bVar.f958c.f961c, gVar, bVar.f958c.e, bVar.f958c.f, bVar.f958c.g, bVar.f958c.h, bitmap));
    }

    b(a aVar) {
        this.f957b = new Rect();
        this.i = true;
        this.k = -1;
        if (aVar == null) {
            throw new NullPointerException("GifState must not be null");
        }
        this.f958c = aVar;
        this.d = new com.bumptech.glide.b.a(aVar.g);
        this.f956a = new Paint();
        this.d.a(aVar.f959a, aVar.f960b);
        this.e = new f(aVar.f961c, this, this.d, aVar.e, aVar.f);
        this.e.a(aVar.d);
    }

    public Bitmap b() {
        return this.f958c.i;
    }

    public com.bumptech.glide.load.g<Bitmap> c() {
        return this.f958c.d;
    }

    public byte[] d() {
        return this.f958c.f960b;
    }

    public int e() {
        return this.d.c();
    }

    private void g() {
        this.j = 0;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.g = true;
        g();
        if (this.i) {
            i();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.g = false;
        j();
        if (Build.VERSION.SDK_INT < 11) {
            h();
        }
    }

    private void h() {
        this.e.c();
        invalidateSelf();
    }

    private void i() {
        if (this.d.c() == 1) {
            invalidateSelf();
        } else if (!this.f) {
            this.f = true;
            this.e.a();
            invalidateSelf();
        }
    }

    private void j() {
        this.f = false;
        this.e.b();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        this.i = z;
        if (!z) {
            j();
        } else if (this.g) {
            i();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f958c.i.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f958c.i.getHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.h) {
            if (this.l) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.f957b);
                this.l = false;
            }
            Bitmap d = this.e.d();
            if (d == null) {
                d = this.f958c.i;
            }
            canvas.drawBitmap(d, (Rect) null, this.f957b, this.f956a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f956a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f956a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // com.bumptech.glide.load.resource.c.f.b
    @TargetApi(11)
    public void b(int i) {
        if (Build.VERSION.SDK_INT >= 11 && getCallback() == null) {
            stop();
            h();
            return;
        }
        invalidateSelf();
        if (i == this.d.c() - 1) {
            this.j++;
        }
        if (this.k != -1 && this.j >= this.k) {
            stop();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f958c;
    }

    public void f() {
        this.h = true;
        this.f958c.h.a(this.f958c.i);
        this.e.c();
        this.e.b();
    }

    @Override // com.bumptech.glide.load.resource.a.b
    public boolean a() {
        return true;
    }

    @Override // com.bumptech.glide.load.resource.a.b
    public void a(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i == 0) {
            this.k = this.d.e();
        } else {
            this.k = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifDrawable.java */
    /* loaded from: classes.dex */
    public static class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        com.bumptech.glide.b.c f959a;

        /* renamed from: b  reason: collision with root package name */
        byte[] f960b;

        /* renamed from: c  reason: collision with root package name */
        Context f961c;
        com.bumptech.glide.load.g<Bitmap> d;
        int e;
        int f;
        a.InterfaceC0020a g;
        com.bumptech.glide.load.b.a.c h;
        Bitmap i;

        public a(com.bumptech.glide.b.c cVar, byte[] bArr, Context context, com.bumptech.glide.load.g<Bitmap> gVar, int i, int i2, a.InterfaceC0020a interfaceC0020a, com.bumptech.glide.load.b.a.c cVar2, Bitmap bitmap) {
            if (bitmap == null) {
                throw new NullPointerException("The first frame of the GIF must not be null");
            }
            this.f959a = cVar;
            this.f960b = bArr;
            this.h = cVar2;
            this.i = bitmap;
            this.f961c = context.getApplicationContext();
            this.d = gVar;
            this.e = i;
            this.f = i2;
            this.g = interfaceC0020a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new b(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }
}
