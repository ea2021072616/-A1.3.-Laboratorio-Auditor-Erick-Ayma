package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
/* compiled from: FitCenter.java */
/* loaded from: classes.dex */
public class i extends d {
    public i(com.bumptech.glide.load.b.a.c cVar) {
        super(cVar);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.d
    protected Bitmap transform(com.bumptech.glide.load.b.a.c cVar, Bitmap bitmap, int i, int i2) {
        return q.a(bitmap, cVar, i, i2);
    }

    @Override // com.bumptech.glide.load.g
    public String getId() {
        return "FitCenter.com.bumptech.glide.load.resource.bitmap";
    }
}
