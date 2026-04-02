package com.bumptech.glide.g.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
/* compiled from: ImageViewTargetFactory.java */
/* loaded from: classes.dex */
public class f {
    public <Z> j<Z> a(ImageView imageView, Class<Z> cls) {
        if (com.bumptech.glide.load.resource.a.b.class.isAssignableFrom(cls)) {
            return new d(imageView);
        }
        if (Bitmap.class.equals(cls)) {
            return new b(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new c(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
