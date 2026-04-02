package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;
/* compiled from: ImageVideoGifDrawableLoadProvider.java */
/* loaded from: classes.dex */
public class g implements com.bumptech.glide.f.b<com.bumptech.glide.load.c.g, a> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.e<File, a> f998a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, a> f999b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.f<a> f1000c;
    private final com.bumptech.glide.load.b<com.bumptech.glide.load.c.g> d;

    public g(com.bumptech.glide.f.b<com.bumptech.glide.load.c.g, Bitmap> bVar, com.bumptech.glide.f.b<InputStream, com.bumptech.glide.load.resource.c.b> bVar2, com.bumptech.glide.load.b.a.c cVar) {
        c cVar2 = new c(bVar.b(), bVar2.b(), cVar);
        this.f998a = new com.bumptech.glide.load.resource.b.c(new e(cVar2));
        this.f999b = cVar2;
        this.f1000c = new d(bVar.d(), bVar2.d());
        this.d = bVar.c();
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.e<File, a> a() {
        return this.f998a;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, a> b() {
        return this.f999b;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.b<com.bumptech.glide.load.c.g> c() {
        return this.d;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.f<a> d() {
        return this.f1000c;
    }
}
