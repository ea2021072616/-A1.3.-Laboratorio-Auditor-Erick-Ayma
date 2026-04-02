package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;
/* compiled from: StreamBitmapDataLoadProvider.java */
/* loaded from: classes.dex */
public class o implements com.bumptech.glide.f.b<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final p f945a;
    private final com.bumptech.glide.load.resource.b.c<Bitmap> d;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.c.o f947c = new com.bumptech.glide.load.c.o();

    /* renamed from: b  reason: collision with root package name */
    private final b f946b = new b();

    public o(com.bumptech.glide.load.b.a.c cVar, com.bumptech.glide.load.a aVar) {
        this.f945a = new p(cVar, aVar);
        this.d = new com.bumptech.glide.load.resource.b.c<>(this.f945a);
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.e<File, Bitmap> a() {
        return this.d;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.e<InputStream, Bitmap> b() {
        return this.f945a;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.b<InputStream> c() {
        return this.f947c;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.f<Bitmap> d() {
        return this.f946b;
    }
}
