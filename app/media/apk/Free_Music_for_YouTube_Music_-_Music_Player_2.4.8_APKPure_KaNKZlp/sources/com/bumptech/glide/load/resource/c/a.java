package com.bumptech.glide.load.resource.c;

import android.graphics.Bitmap;
import com.bumptech.glide.b.a;
/* compiled from: GifBitmapProvider.java */
/* loaded from: classes.dex */
class a implements a.InterfaceC0020a {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a.c f955a;

    public a(com.bumptech.glide.load.b.a.c cVar) {
        this.f955a = cVar;
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0020a
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f955a.b(i, i2, config);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0020a
    public void a(Bitmap bitmap) {
        if (!this.f955a.a(bitmap)) {
            bitmap.recycle();
        }
    }
}
