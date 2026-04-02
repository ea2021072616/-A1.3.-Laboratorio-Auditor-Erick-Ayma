package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
/* compiled from: BitmapResource.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.b.k<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f919a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a.c f920b;

    public static c a(Bitmap bitmap, com.bumptech.glide.load.b.a.c cVar) {
        if (bitmap == null) {
            return null;
        }
        return new c(bitmap, cVar);
    }

    public c(Bitmap bitmap, com.bumptech.glide.load.b.a.c cVar) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (cVar == null) {
            throw new NullPointerException("BitmapPool must not be null");
        }
        this.f919a = bitmap;
        this.f920b = cVar;
    }

    @Override // com.bumptech.glide.load.b.k
    /* renamed from: a */
    public Bitmap b() {
        return this.f919a;
    }

    @Override // com.bumptech.glide.load.b.k
    public int c() {
        return com.bumptech.glide.i.h.a(this.f919a);
    }

    @Override // com.bumptech.glide.load.b.k
    public void d() {
        if (!this.f920b.a(this.f919a)) {
            this.f919a.recycle();
        }
    }
}
