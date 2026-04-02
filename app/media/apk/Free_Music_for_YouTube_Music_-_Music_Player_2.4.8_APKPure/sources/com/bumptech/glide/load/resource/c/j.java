package com.bumptech.glide.load.resource.c;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.b.a;
import com.bumptech.glide.load.b.k;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: GifResourceEncoder.java */
/* loaded from: classes.dex */
public class j implements com.bumptech.glide.load.f<b> {

    /* renamed from: a  reason: collision with root package name */
    private static final a f982a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final a.InterfaceC0020a f983b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a.c f984c;
    private final a d;

    public j(com.bumptech.glide.load.b.a.c cVar) {
        this(cVar, f982a);
    }

    j(com.bumptech.glide.load.b.a.c cVar, a aVar) {
        this.f984c = cVar;
        this.f983b = new com.bumptech.glide.load.resource.c.a(cVar);
        this.d = aVar;
    }

    @Override // com.bumptech.glide.load.b
    public boolean a(k<b> kVar, OutputStream outputStream) {
        long a2 = com.bumptech.glide.i.d.a();
        b b2 = kVar.b();
        com.bumptech.glide.load.g<Bitmap> c2 = b2.c();
        if (c2 instanceof com.bumptech.glide.load.resource.d) {
            return a(b2.d(), outputStream);
        }
        com.bumptech.glide.b.a a3 = a(b2.d());
        com.bumptech.glide.c.a b3 = this.d.b();
        if (b3.a(outputStream)) {
            for (int i = 0; i < a3.c(); i++) {
                k<Bitmap> a4 = a(a3.f(), c2, b2);
                try {
                    if (!b3.a(a4.b())) {
                        return false;
                    }
                    b3.a(a3.a(a3.d()));
                    a3.a();
                    a4.d();
                } finally {
                    a4.d();
                }
            }
            boolean a5 = b3.a();
            if (Log.isLoggable("GifEncoder", 2)) {
                Log.v("GifEncoder", "Encoded gif with " + a3.c() + " frames and " + b2.d().length + " bytes in " + com.bumptech.glide.i.d.a(a2) + " ms");
                return a5;
            }
            return a5;
        }
        return false;
    }

    private boolean a(byte[] bArr, OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("GifEncoder", 3)) {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", e);
            }
            return false;
        }
    }

    private com.bumptech.glide.b.a a(byte[] bArr) {
        com.bumptech.glide.b.d a2 = this.d.a();
        a2.a(bArr);
        com.bumptech.glide.b.c b2 = a2.b();
        com.bumptech.glide.b.a a3 = this.d.a(this.f983b);
        a3.a(b2, bArr);
        a3.a();
        return a3;
    }

    private k<Bitmap> a(Bitmap bitmap, com.bumptech.glide.load.g<Bitmap> gVar, b bVar) {
        k<Bitmap> a2 = this.d.a(bitmap, this.f984c);
        k<Bitmap> transform = gVar.transform(a2, bVar.getIntrinsicWidth(), bVar.getIntrinsicHeight());
        if (!a2.equals(transform)) {
            a2.d();
        }
        return transform;
    }

    @Override // com.bumptech.glide.load.b
    public String a() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifResourceEncoder.java */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public com.bumptech.glide.b.a a(a.InterfaceC0020a interfaceC0020a) {
            return new com.bumptech.glide.b.a(interfaceC0020a);
        }

        public com.bumptech.glide.b.d a() {
            return new com.bumptech.glide.b.d();
        }

        public com.bumptech.glide.c.a b() {
            return new com.bumptech.glide.c.a();
        }

        public k<Bitmap> a(Bitmap bitmap, com.bumptech.glide.load.b.a.c cVar) {
            return new com.bumptech.glide.load.resource.bitmap.c(bitmap, cVar);
        }
    }
}
