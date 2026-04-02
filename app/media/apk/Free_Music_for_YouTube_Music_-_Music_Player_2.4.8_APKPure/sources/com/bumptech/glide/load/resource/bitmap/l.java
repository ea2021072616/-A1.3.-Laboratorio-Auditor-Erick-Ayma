package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: ImageVideoBitmapDecoder.java */
/* loaded from: classes.dex */
public class l implements com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.e<InputStream, Bitmap> f937a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.e<ParcelFileDescriptor, Bitmap> f938b;

    public l(com.bumptech.glide.load.e<InputStream, Bitmap> eVar, com.bumptech.glide.load.e<ParcelFileDescriptor, Bitmap> eVar2) {
        this.f937a = eVar;
        this.f938b = eVar2;
    }

    @Override // com.bumptech.glide.load.e
    public com.bumptech.glide.load.b.k<Bitmap> a(com.bumptech.glide.load.c.g gVar, int i, int i2) throws IOException {
        com.bumptech.glide.load.b.k<Bitmap> a2;
        ParcelFileDescriptor b2;
        InputStream a3 = gVar.a();
        if (a3 != null) {
            try {
                a2 = this.f937a.a(a3, i, i2);
            } catch (IOException e) {
                if (Log.isLoggable("ImageVideoDecoder", 2)) {
                    Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", e);
                }
            }
            if (a2 != null && (b2 = gVar.b()) != null) {
                return this.f938b.a(b2, i, i2);
            }
        }
        a2 = null;
        return a2 != null ? a2 : a2;
    }

    @Override // com.bumptech.glide.load.e
    public String a() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
