package com.bumptech.glide.load.resource.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.b.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
/* compiled from: GifResourceDecoder.java */
/* loaded from: classes.dex */
public class i implements com.bumptech.glide.load.e<InputStream, com.bumptech.glide.load.resource.c.b> {

    /* renamed from: a  reason: collision with root package name */
    private static final b f977a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final a f978b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final Context f979c;
    private final b d;
    private final com.bumptech.glide.load.b.a.c e;
    private final a f;
    private final com.bumptech.glide.load.resource.c.a g;

    public i(Context context, com.bumptech.glide.load.b.a.c cVar) {
        this(context, cVar, f977a, f978b);
    }

    i(Context context, com.bumptech.glide.load.b.a.c cVar, b bVar, a aVar) {
        this.f979c = context;
        this.e = cVar;
        this.f = aVar;
        this.g = new com.bumptech.glide.load.resource.c.a(cVar);
        this.d = bVar;
    }

    @Override // com.bumptech.glide.load.e
    public d a(InputStream inputStream, int i, int i2) {
        byte[] a2 = a(inputStream);
        com.bumptech.glide.b.d a3 = this.d.a(a2);
        com.bumptech.glide.b.a a4 = this.f.a(this.g);
        try {
            return a(a2, i, i2, a3, a4);
        } finally {
            this.d.a(a3);
            this.f.a(a4);
        }
    }

    private d a(byte[] bArr, int i, int i2, com.bumptech.glide.b.d dVar, com.bumptech.glide.b.a aVar) {
        Bitmap a2;
        com.bumptech.glide.b.c b2 = dVar.b();
        if (b2.a() <= 0 || b2.b() != 0 || (a2 = a(aVar, b2, bArr)) == null) {
            return null;
        }
        return new d(new com.bumptech.glide.load.resource.c.b(this.f979c, this.g, this.e, com.bumptech.glide.load.resource.d.a(), i, i2, b2, bArr, a2));
    }

    private Bitmap a(com.bumptech.glide.b.a aVar, com.bumptech.glide.b.c cVar, byte[] bArr) {
        aVar.a(cVar, bArr);
        aVar.a();
        return aVar.f();
    }

    @Override // com.bumptech.glide.load.e
    public String a() {
        return "";
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e) {
            Log.w("GifResourceDecoder", "Error reading data from stream", e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifResourceDecoder.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<com.bumptech.glide.b.a> f980a = com.bumptech.glide.i.h.a(0);

        a() {
        }

        public synchronized com.bumptech.glide.b.a a(a.InterfaceC0020a interfaceC0020a) {
            com.bumptech.glide.b.a poll;
            poll = this.f980a.poll();
            if (poll == null) {
                poll = new com.bumptech.glide.b.a(interfaceC0020a);
            }
            return poll;
        }

        public synchronized void a(com.bumptech.glide.b.a aVar) {
            aVar.g();
            this.f980a.offer(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifResourceDecoder.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<com.bumptech.glide.b.d> f981a = com.bumptech.glide.i.h.a(0);

        b() {
        }

        public synchronized com.bumptech.glide.b.d a(byte[] bArr) {
            com.bumptech.glide.b.d poll;
            poll = this.f981a.poll();
            if (poll == null) {
                poll = new com.bumptech.glide.b.d();
            }
            return poll.a(bArr);
        }

        public synchronized void a(com.bumptech.glide.b.d dVar) {
            dVar.a();
            this.f981a.offer(dVar);
        }
    }
}
