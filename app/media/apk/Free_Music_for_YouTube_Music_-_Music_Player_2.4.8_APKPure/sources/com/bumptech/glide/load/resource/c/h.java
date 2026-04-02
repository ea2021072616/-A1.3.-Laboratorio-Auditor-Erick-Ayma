package com.bumptech.glide.load.resource.c;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GifFrameResourceDecoder.java */
/* loaded from: classes.dex */
public class h implements com.bumptech.glide.load.e<com.bumptech.glide.b.a, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a.c f976a;

    public h(com.bumptech.glide.load.b.a.c cVar) {
        this.f976a = cVar;
    }

    @Override // com.bumptech.glide.load.e
    public k<Bitmap> a(com.bumptech.glide.b.a aVar, int i, int i2) {
        return com.bumptech.glide.load.resource.bitmap.c.a(aVar.f(), this.f976a);
    }

    @Override // com.bumptech.glide.load.e
    public String a() {
        return "GifFrameResourceDecoder.com.bumptech.glide.load.resource.gif";
    }
}
