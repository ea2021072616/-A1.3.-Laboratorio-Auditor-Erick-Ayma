package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.k;
/* compiled from: GifBitmapWrapperTransformation.java */
/* loaded from: classes.dex */
public class f implements com.bumptech.glide.load.g<a> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.g<Bitmap> f996a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.g<com.bumptech.glide.load.resource.c.b> f997b;

    public f(com.bumptech.glide.load.b.a.c cVar, com.bumptech.glide.load.g<Bitmap> gVar) {
        this(gVar, new com.bumptech.glide.load.resource.c.e(gVar, cVar));
    }

    f(com.bumptech.glide.load.g<Bitmap> gVar, com.bumptech.glide.load.g<com.bumptech.glide.load.resource.c.b> gVar2) {
        this.f996a = gVar;
        this.f997b = gVar2;
    }

    @Override // com.bumptech.glide.load.g
    public k<a> transform(k<a> kVar, int i, int i2) {
        k<Bitmap> b2 = kVar.b().b();
        k<com.bumptech.glide.load.resource.c.b> c2 = kVar.b().c();
        if (b2 != null && this.f996a != null) {
            k<Bitmap> transform = this.f996a.transform(b2, i, i2);
            if (!b2.equals(transform)) {
                return new b(new a(transform, kVar.b().c()));
            }
            return kVar;
        } else if (c2 != null && this.f997b != null) {
            k<com.bumptech.glide.load.resource.c.b> transform2 = this.f997b.transform(c2, i, i2);
            if (!c2.equals(transform2)) {
                return new b(new a(kVar.b().b(), transform2));
            }
            return kVar;
        } else {
            return kVar;
        }
    }

    @Override // com.bumptech.glide.load.g
    public String getId() {
        return this.f996a.getId();
    }
}
