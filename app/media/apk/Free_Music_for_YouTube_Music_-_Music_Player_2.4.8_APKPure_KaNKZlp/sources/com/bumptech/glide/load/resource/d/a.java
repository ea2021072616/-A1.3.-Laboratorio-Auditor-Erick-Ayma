package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.k;
/* compiled from: GifBitmapWrapper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final k<com.bumptech.glide.load.resource.c.b> f986a;

    /* renamed from: b  reason: collision with root package name */
    private final k<Bitmap> f987b;

    public a(k<Bitmap> kVar, k<com.bumptech.glide.load.resource.c.b> kVar2) {
        if (kVar != null && kVar2 != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        }
        if (kVar == null && kVar2 == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        }
        this.f987b = kVar;
        this.f986a = kVar2;
    }

    public int a() {
        return this.f987b != null ? this.f987b.c() : this.f986a.c();
    }

    public k<Bitmap> b() {
        return this.f987b;
    }

    public k<com.bumptech.glide.load.resource.c.b> c() {
        return this.f986a;
    }
}
