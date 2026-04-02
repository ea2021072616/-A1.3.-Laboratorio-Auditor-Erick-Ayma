package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.io.InputStream;
/* compiled from: StreamBitmapDecoder.java */
/* loaded from: classes.dex */
public class p implements com.bumptech.glide.load.e<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final f f948a;

    /* renamed from: b  reason: collision with root package name */
    private com.bumptech.glide.load.b.a.c f949b;

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.load.a f950c;
    private String d;

    public p(com.bumptech.glide.load.b.a.c cVar, com.bumptech.glide.load.a aVar) {
        this(f.f921a, cVar, aVar);
    }

    public p(f fVar, com.bumptech.glide.load.b.a.c cVar, com.bumptech.glide.load.a aVar) {
        this.f948a = fVar;
        this.f949b = cVar;
        this.f950c = aVar;
    }

    @Override // com.bumptech.glide.load.e
    public com.bumptech.glide.load.b.k<Bitmap> a(InputStream inputStream, int i, int i2) {
        return c.a(this.f948a.a(inputStream, this.f949b, i, i2, this.f950c), this.f949b);
    }

    @Override // com.bumptech.glide.load.e
    public String a() {
        if (this.d == null) {
            this.d = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.f948a.a() + this.f950c.name();
        }
        return this.d;
    }
}
