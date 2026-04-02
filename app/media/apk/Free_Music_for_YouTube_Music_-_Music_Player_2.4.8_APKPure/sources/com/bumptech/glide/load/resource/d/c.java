package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.n;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: GifBitmapWrapperResourceDecoder.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, com.bumptech.glide.load.resource.d.a> {

    /* renamed from: a  reason: collision with root package name */
    private static final b f989a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final a f990b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, Bitmap> f991c;
    private final com.bumptech.glide.load.e<InputStream, com.bumptech.glide.load.resource.c.b> d;
    private final com.bumptech.glide.load.b.a.c e;
    private final b f;
    private final a g;
    private String h;

    public c(com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, Bitmap> eVar, com.bumptech.glide.load.e<InputStream, com.bumptech.glide.load.resource.c.b> eVar2, com.bumptech.glide.load.b.a.c cVar) {
        this(eVar, eVar2, cVar, f989a, f990b);
    }

    c(com.bumptech.glide.load.e<com.bumptech.glide.load.c.g, Bitmap> eVar, com.bumptech.glide.load.e<InputStream, com.bumptech.glide.load.resource.c.b> eVar2, com.bumptech.glide.load.b.a.c cVar, b bVar, a aVar) {
        this.f991c = eVar;
        this.d = eVar2;
        this.e = cVar;
        this.f = bVar;
        this.g = aVar;
    }

    @Override // com.bumptech.glide.load.e
    public k<com.bumptech.glide.load.resource.d.a> a(com.bumptech.glide.load.c.g gVar, int i, int i2) throws IOException {
        com.bumptech.glide.i.a a2 = com.bumptech.glide.i.a.a();
        byte[] b2 = a2.b();
        try {
            com.bumptech.glide.load.resource.d.a a3 = a(gVar, i, i2, b2);
            if (a3 != null) {
                return new com.bumptech.glide.load.resource.d.b(a3);
            }
            return null;
        } finally {
            a2.a(b2);
        }
    }

    private com.bumptech.glide.load.resource.d.a a(com.bumptech.glide.load.c.g gVar, int i, int i2, byte[] bArr) throws IOException {
        if (gVar.a() != null) {
            return b(gVar, i, i2, bArr);
        }
        return b(gVar, i, i2);
    }

    private com.bumptech.glide.load.resource.d.a b(com.bumptech.glide.load.c.g gVar, int i, int i2, byte[] bArr) throws IOException {
        InputStream a2 = this.g.a(gVar.a(), bArr);
        a2.mark(2048);
        ImageHeaderParser.ImageType a3 = this.f.a(a2);
        a2.reset();
        com.bumptech.glide.load.resource.d.a aVar = null;
        if (a3 == ImageHeaderParser.ImageType.GIF) {
            aVar = a(a2, i, i2);
        }
        if (aVar == null) {
            return b(new com.bumptech.glide.load.c.g(a2, gVar.b()), i, i2);
        }
        return aVar;
    }

    private com.bumptech.glide.load.resource.d.a a(InputStream inputStream, int i, int i2) throws IOException {
        k<com.bumptech.glide.load.resource.c.b> a2 = this.d.a(inputStream, i, i2);
        if (a2 != null) {
            com.bumptech.glide.load.resource.c.b b2 = a2.b();
            if (b2.e() > 1) {
                return new com.bumptech.glide.load.resource.d.a(null, a2);
            }
            return new com.bumptech.glide.load.resource.d.a(new com.bumptech.glide.load.resource.bitmap.c(b2.b(), this.e), null);
        }
        return null;
    }

    private com.bumptech.glide.load.resource.d.a b(com.bumptech.glide.load.c.g gVar, int i, int i2) throws IOException {
        k<Bitmap> a2 = this.f991c.a(gVar, i, i2);
        if (a2 != null) {
            return new com.bumptech.glide.load.resource.d.a(a2, null);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.e
    public String a() {
        if (this.h == null) {
            this.h = this.d.a() + this.f991c.a();
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifBitmapWrapperResourceDecoder.java */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public InputStream a(InputStream inputStream, byte[] bArr) {
            return new n(inputStream, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifBitmapWrapperResourceDecoder.java */
    /* loaded from: classes.dex */
    public static class b {
        b() {
        }

        public ImageHeaderParser.ImageType a(InputStream inputStream) throws IOException {
            return new ImageHeaderParser(inputStream).b();
        }
    }
}
