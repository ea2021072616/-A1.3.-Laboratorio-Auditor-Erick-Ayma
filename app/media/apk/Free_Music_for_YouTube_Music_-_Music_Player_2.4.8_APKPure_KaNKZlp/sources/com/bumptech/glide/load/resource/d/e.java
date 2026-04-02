package com.bumptech.glide.load.resource.d;

import com.bumptech.glide.load.b.k;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: GifBitmapWrapperStreamResourceDecoder.java */
/* loaded from: classes.dex */
public class e implements com.bumptech.glide.load.e<InputStream, a> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, a> f995a;

    public e(com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, a> eVar) {
        this.f995a = eVar;
    }

    @Override // com.bumptech.glide.load.e
    public k<a> a(InputStream inputStream, int i, int i2) throws IOException {
        return this.f995a.a(new com.bumptech.glide.load.c.g(inputStream, null), i, i2);
    }

    @Override // com.bumptech.glide.load.e
    public String a() {
        return this.f995a.a();
    }
}
