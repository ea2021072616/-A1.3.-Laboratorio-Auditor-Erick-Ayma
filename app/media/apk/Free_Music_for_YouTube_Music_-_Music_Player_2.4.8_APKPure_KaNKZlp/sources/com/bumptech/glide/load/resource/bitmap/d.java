package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
/* compiled from: BitmapTransformation.java */
/* loaded from: classes.dex */
public abstract class d implements com.bumptech.glide.load.g<Bitmap> {
    private com.bumptech.glide.load.b.a.c bitmapPool;

    protected abstract Bitmap transform(com.bumptech.glide.load.b.a.c cVar, Bitmap bitmap, int i, int i2);

    public d(Context context) {
        this(com.bumptech.glide.i.b(context).a());
    }

    public d(com.bumptech.glide.load.b.a.c cVar) {
        this.bitmapPool = cVar;
    }

    @Override // com.bumptech.glide.load.g
    public final com.bumptech.glide.load.b.k<Bitmap> transform(com.bumptech.glide.load.b.k<Bitmap> kVar, int i, int i2) {
        if (!com.bumptech.glide.i.h.a(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        Bitmap b2 = kVar.b();
        if (i == Integer.MIN_VALUE) {
            i = b2.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = b2.getHeight();
        }
        Bitmap transform = transform(this.bitmapPool, b2, i, i2);
        if (!b2.equals(transform)) {
            return c.a(transform, this.bitmapPool);
        }
        return kVar;
    }
}
