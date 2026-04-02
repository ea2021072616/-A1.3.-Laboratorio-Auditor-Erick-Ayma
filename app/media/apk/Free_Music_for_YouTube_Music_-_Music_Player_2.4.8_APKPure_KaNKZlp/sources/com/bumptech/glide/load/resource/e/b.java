package com.bumptech.glide.load.resource.e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.resource.bitmap.j;
/* compiled from: GlideBitmapDrawableTranscoder.java */
/* loaded from: classes.dex */
public class b implements c<Bitmap, j> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1002a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a.c f1003b;

    public b(Resources resources, com.bumptech.glide.load.b.a.c cVar) {
        this.f1002a = resources;
        this.f1003b = cVar;
    }

    @Override // com.bumptech.glide.load.resource.e.c
    public k<j> a(k<Bitmap> kVar) {
        return new com.bumptech.glide.load.resource.bitmap.k(new j(this.f1002a, kVar.b()), this.f1003b);
    }

    @Override // com.bumptech.glide.load.resource.e.c
    public String a() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
