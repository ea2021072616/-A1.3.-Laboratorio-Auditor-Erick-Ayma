package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.OutputStream;
/* compiled from: BitmapEncoder.java */
/* loaded from: classes.dex */
public class b implements com.bumptech.glide.load.f<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap.CompressFormat f917a;

    /* renamed from: b  reason: collision with root package name */
    private int f918b;

    public b() {
        this(null, 90);
    }

    public b(Bitmap.CompressFormat compressFormat, int i) {
        this.f917a = compressFormat;
        this.f918b = i;
    }

    @Override // com.bumptech.glide.load.b
    public boolean a(com.bumptech.glide.load.b.k<Bitmap> kVar, OutputStream outputStream) {
        Bitmap b2 = kVar.b();
        long a2 = com.bumptech.glide.i.d.a();
        Bitmap.CompressFormat a3 = a(b2);
        b2.compress(a3, this.f918b, outputStream);
        if (Log.isLoggable("BitmapEncoder", 2)) {
            Log.v("BitmapEncoder", "Compressed with type: " + a3 + " of size " + com.bumptech.glide.i.h.a(b2) + " in " + com.bumptech.glide.i.d.a(a2));
            return true;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.b
    public String a() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    private Bitmap.CompressFormat a(Bitmap bitmap) {
        if (this.f917a != null) {
            return this.f917a;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }
}
