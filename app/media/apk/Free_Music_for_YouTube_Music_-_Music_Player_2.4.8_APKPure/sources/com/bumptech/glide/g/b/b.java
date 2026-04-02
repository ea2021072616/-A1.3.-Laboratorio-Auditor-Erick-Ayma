package com.bumptech.glide.g.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
/* compiled from: BitmapImageViewTarget.java */
/* loaded from: classes.dex */
public class b extends e<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.g.b.e
    public void a(Bitmap bitmap) {
        ((ImageView) this.f705a).setImageBitmap(bitmap);
    }
}
