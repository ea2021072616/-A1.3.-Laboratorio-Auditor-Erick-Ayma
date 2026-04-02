package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;
/* compiled from: ImageVideoDataLoadProvider.java */
/* loaded from: classes.dex */
public class m implements com.bumptech.glide.f.b<com.bumptech.glide.load.c.g, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final l f939a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.e<File, Bitmap> f940b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.f<Bitmap> f941c;
    private final com.bumptech.glide.load.c.h d;

    public m(com.bumptech.glide.f.b<InputStream, Bitmap> bVar, com.bumptech.glide.f.b<ParcelFileDescriptor, Bitmap> bVar2) {
        this.f941c = bVar.d();
        this.d = new com.bumptech.glide.load.c.h(bVar.c(), bVar2.c());
        this.f940b = bVar.a();
        this.f939a = new l(bVar.b(), bVar2.b());
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.e<File, Bitmap> a() {
        return this.f940b;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, Bitmap> b() {
        return this.f939a;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.b<com.bumptech.glide.load.c.g> c() {
        return this.d;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.f<Bitmap> d() {
        return this.f941c;
    }
}
