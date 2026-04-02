package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.k;
import java.io.OutputStream;
/* compiled from: GifBitmapWrapperResourceEncoder.java */
/* loaded from: classes.dex */
public class d implements com.bumptech.glide.load.f<a> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.f<Bitmap> f992a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.f<com.bumptech.glide.load.resource.c.b> f993b;

    /* renamed from: c  reason: collision with root package name */
    private String f994c;

    public d(com.bumptech.glide.load.f<Bitmap> fVar, com.bumptech.glide.load.f<com.bumptech.glide.load.resource.c.b> fVar2) {
        this.f992a = fVar;
        this.f993b = fVar2;
    }

    @Override // com.bumptech.glide.load.b
    public boolean a(k<a> kVar, OutputStream outputStream) {
        a b2 = kVar.b();
        k<Bitmap> b3 = b2.b();
        return b3 != null ? this.f992a.a(b3, outputStream) : this.f993b.a(b2.c(), outputStream);
    }

    @Override // com.bumptech.glide.load.b
    public String a() {
        if (this.f994c == null) {
            this.f994c = this.f992a.a() + this.f993b.a();
        }
        return this.f994c;
    }
}
