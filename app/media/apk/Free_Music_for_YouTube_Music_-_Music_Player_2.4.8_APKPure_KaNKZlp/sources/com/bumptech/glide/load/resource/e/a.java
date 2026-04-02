package com.bumptech.glide.load.resource.e;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.resource.bitmap.j;
/* compiled from: GifBitmapWrapperDrawableTranscoder.java */
/* loaded from: classes.dex */
public class a implements c<com.bumptech.glide.load.resource.d.a, com.bumptech.glide.load.resource.a.b> {

    /* renamed from: a  reason: collision with root package name */
    private final c<Bitmap, j> f1001a;

    public a(c<Bitmap, j> cVar) {
        this.f1001a = cVar;
    }

    @Override // com.bumptech.glide.load.resource.e.c
    public k<com.bumptech.glide.load.resource.a.b> a(k<com.bumptech.glide.load.resource.d.a> kVar) {
        com.bumptech.glide.load.resource.d.a b2 = kVar.b();
        k<Bitmap> b3 = b2.b();
        if (b3 != null) {
            return this.f1001a.a(b3);
        }
        return b2.c();
    }

    @Override // com.bumptech.glide.load.resource.e.c
    public String a() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
