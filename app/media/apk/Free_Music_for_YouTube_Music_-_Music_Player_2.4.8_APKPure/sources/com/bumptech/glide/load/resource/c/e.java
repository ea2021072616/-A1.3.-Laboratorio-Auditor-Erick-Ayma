package com.bumptech.glide.load.resource.c;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.k;
/* compiled from: GifDrawableTransformation.java */
/* loaded from: classes.dex */
public class e implements com.bumptech.glide.load.g<b> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.g<Bitmap> f965a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a.c f966b;

    public e(com.bumptech.glide.load.g<Bitmap> gVar, com.bumptech.glide.load.b.a.c cVar) {
        this.f965a = gVar;
        this.f966b = cVar;
    }

    @Override // com.bumptech.glide.load.g
    public k<b> transform(k<b> kVar, int i, int i2) {
        b b2 = kVar.b();
        Bitmap b3 = kVar.b().b();
        Bitmap b4 = this.f965a.transform(new com.bumptech.glide.load.resource.bitmap.c(b3, this.f966b), i, i2).b();
        if (!b4.equals(b3)) {
            return new d(new b(b2, b4, this.f965a));
        }
        return kVar;
    }

    @Override // com.bumptech.glide.load.g
    public String getId() {
        return this.f965a.getId();
    }
}
