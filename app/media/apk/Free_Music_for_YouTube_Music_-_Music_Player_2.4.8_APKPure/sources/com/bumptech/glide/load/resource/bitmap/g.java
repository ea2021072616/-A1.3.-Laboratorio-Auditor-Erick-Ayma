package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
/* compiled from: FileDescriptorBitmapDataLoadProvider.java */
/* loaded from: classes.dex */
public class g implements com.bumptech.glide.f.b<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.e<File, Bitmap> f924a;

    /* renamed from: b  reason: collision with root package name */
    private final h f925b;

    /* renamed from: c  reason: collision with root package name */
    private final b f926c = new b();
    private final com.bumptech.glide.load.b<ParcelFileDescriptor> d = com.bumptech.glide.load.resource.a.b();

    public g(com.bumptech.glide.load.b.a.c cVar, com.bumptech.glide.load.a aVar) {
        this.f924a = new com.bumptech.glide.load.resource.b.c(new p(cVar, aVar));
        this.f925b = new h(cVar, aVar);
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.e<File, Bitmap> a() {
        return this.f924a;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.e<ParcelFileDescriptor, Bitmap> b() {
        return this.f925b;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.b<ParcelFileDescriptor> c() {
        return this.d;
    }

    @Override // com.bumptech.glide.f.b
    public com.bumptech.glide.load.f<Bitmap> d() {
        return this.f926c;
    }
}
