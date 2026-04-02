package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.k;
/* compiled from: GifBitmapWrapperResource.java */
/* loaded from: classes.dex */
public class b implements k<a> {

    /* renamed from: a  reason: collision with root package name */
    private final a f988a;

    public b(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.f988a = aVar;
    }

    @Override // com.bumptech.glide.load.b.k
    /* renamed from: a */
    public a b() {
        return this.f988a;
    }

    @Override // com.bumptech.glide.load.b.k
    public int c() {
        return this.f988a.a();
    }

    @Override // com.bumptech.glide.load.b.k
    public void d() {
        k<Bitmap> b2 = this.f988a.b();
        if (b2 != null) {
            b2.d();
        }
        k<com.bumptech.glide.load.resource.c.b> c2 = this.f988a.c();
        if (c2 != null) {
            c2.d();
        }
    }
}
