package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
/* compiled from: CenterCrop.java */
/* loaded from: classes.dex */
public class e extends d {
    public e(Context context) {
        super(context);
    }

    public e(com.bumptech.glide.load.b.a.c cVar) {
        super(cVar);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.d
    protected Bitmap transform(com.bumptech.glide.load.b.a.c cVar, Bitmap bitmap, int i, int i2) {
        Bitmap a2 = cVar.a(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        Bitmap a3 = q.a(a2, bitmap, i, i2);
        if (a2 != null && a2 != a3 && !cVar.a(a2)) {
            a2.recycle();
        }
        return a3;
    }

    @Override // com.bumptech.glide.load.g
    public String getId() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }
}
