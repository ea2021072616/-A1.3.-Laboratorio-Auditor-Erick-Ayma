package com.fotoable.youtube.music.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.renderscript.RSRuntimeException;
import com.bumptech.glide.i;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.g;
/* compiled from: BlurTransformation.java */
/* loaded from: classes.dex */
public class b implements g<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private static int f2736a = 25;

    /* renamed from: b  reason: collision with root package name */
    private static int f2737b = 1;

    /* renamed from: c  reason: collision with root package name */
    private Context f2738c;
    private com.bumptech.glide.load.b.a.c d;
    private int e;
    private int f;

    public b(Context context, int i, int i2) {
        this(context, i.b(context).a(), i, i2);
    }

    public b(Context context, com.bumptech.glide.load.b.a.c cVar, int i, int i2) {
        this.f2738c = context.getApplicationContext();
        this.d = cVar;
        this.e = i;
        this.f = i2;
    }

    @Override // com.bumptech.glide.load.g
    public k<Bitmap> transform(k<Bitmap> kVar, int i, int i2) {
        Bitmap a2;
        Bitmap b2 = kVar.b();
        int width = b2.getWidth();
        int height = b2.getHeight();
        int i3 = width / this.f;
        int i4 = height / this.f;
        Bitmap a3 = this.d.a(i3, i4, Bitmap.Config.ARGB_8888);
        if (a3 == null) {
            a3 = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(a3);
        canvas.scale(1.0f / this.f, 1.0f / this.f);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(b2, 0.0f, 0.0f, paint);
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                a2 = e.a(this.f2738c, a3, this.e);
            } catch (RSRuntimeException e) {
                a2 = c.a(a3, this.e, true);
            }
        } else {
            a2 = c.a(a3, this.e, true);
        }
        return com.bumptech.glide.load.resource.bitmap.c.a(a2, this.d);
    }

    @Override // com.bumptech.glide.load.g
    public String getId() {
        return "BlurTransformation(radius=" + this.e + ", sampling=" + this.f + ")";
    }
}
