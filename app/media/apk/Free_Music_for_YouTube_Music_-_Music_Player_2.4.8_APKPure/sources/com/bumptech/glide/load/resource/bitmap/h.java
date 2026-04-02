package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
/* compiled from: FileDescriptorBitmapDecoder.java */
/* loaded from: classes.dex */
public class h implements com.bumptech.glide.load.e<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final r f927a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a.c f928b;

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.load.a f929c;

    public h(com.bumptech.glide.load.b.a.c cVar, com.bumptech.glide.load.a aVar) {
        this(new r(), cVar, aVar);
    }

    public h(r rVar, com.bumptech.glide.load.b.a.c cVar, com.bumptech.glide.load.a aVar) {
        this.f927a = rVar;
        this.f928b = cVar;
        this.f929c = aVar;
    }

    @Override // com.bumptech.glide.load.e
    public com.bumptech.glide.load.b.k<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2) throws IOException {
        return c.a(this.f927a.a(parcelFileDescriptor, this.f928b, i, i2, this.f929c), this.f928b);
    }

    @Override // com.bumptech.glide.load.e
    public String a() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }
}
