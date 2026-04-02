package com.bumptech.glide.load.resource.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.l;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GifFrameLoader.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final b f967a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.b.a f968b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f969c;
    private boolean d;
    private boolean e;
    private com.bumptech.glide.e<com.bumptech.glide.b.a, com.bumptech.glide.b.a, Bitmap, Bitmap> f;
    private a g;
    private boolean h;

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public interface b {
        void b(int i);
    }

    public f(Context context, b bVar, com.bumptech.glide.b.a aVar, int i, int i2) {
        this(bVar, aVar, null, a(context, aVar, i, i2, com.bumptech.glide.i.b(context).a()));
    }

    f(b bVar, com.bumptech.glide.b.a aVar, Handler handler, com.bumptech.glide.e<com.bumptech.glide.b.a, com.bumptech.glide.b.a, Bitmap, Bitmap> eVar) {
        this.d = false;
        this.e = false;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f967a = bVar;
        this.f968b = aVar;
        this.f969c = handler;
        this.f = eVar;
    }

    public void a(com.bumptech.glide.load.g<Bitmap> gVar) {
        if (gVar == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.f = this.f.b(gVar);
    }

    public void a() {
        if (!this.d) {
            this.d = true;
            this.h = false;
            e();
        }
    }

    public void b() {
        this.d = false;
    }

    public void c() {
        b();
        if (this.g != null) {
            com.bumptech.glide.i.a(this.g);
            this.g = null;
        }
        this.h = true;
    }

    public Bitmap d() {
        if (this.g != null) {
            return this.g.a();
        }
        return null;
    }

    private void e() {
        if (this.d && !this.e) {
            this.e = true;
            this.f968b.a();
            this.f.b(new d()).a((com.bumptech.glide.e<com.bumptech.glide.b.a, com.bumptech.glide.b.a, Bitmap, Bitmap>) new a(this.f969c, this.f968b.d(), SystemClock.uptimeMillis() + this.f968b.b()));
        }
    }

    void a(a aVar) {
        if (this.h) {
            this.f969c.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        a aVar2 = this.g;
        this.g = aVar;
        this.f967a.b(aVar.f971b);
        if (aVar2 != null) {
            this.f969c.obtainMessage(2, aVar2).sendToTarget();
        }
        this.e = false;
        e();
    }

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    private class c implements Handler.Callback {
        private c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                f.this.a((a) message.obj);
                return true;
            }
            if (message.what == 2) {
                com.bumptech.glide.i.a((a) message.obj);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public static class a extends com.bumptech.glide.g.b.g<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f970a;

        /* renamed from: b  reason: collision with root package name */
        private final int f971b;

        /* renamed from: c  reason: collision with root package name */
        private final long f972c;
        private Bitmap d;

        public a(Handler handler, int i, long j) {
            this.f970a = handler;
            this.f971b = i;
            this.f972c = j;
        }

        public Bitmap a() {
            return this.d;
        }

        @Override // com.bumptech.glide.g.b.j
        /* renamed from: a */
        public void onResourceReady(Bitmap bitmap, com.bumptech.glide.g.a.c<? super Bitmap> cVar) {
            this.d = bitmap;
            this.f970a.sendMessageAtTime(this.f970a.obtainMessage(1, this), this.f972c);
        }
    }

    private static com.bumptech.glide.e<com.bumptech.glide.b.a, com.bumptech.glide.b.a, Bitmap, Bitmap> a(Context context, com.bumptech.glide.b.a aVar, int i, int i2, com.bumptech.glide.load.b.a.c cVar) {
        h hVar = new h(cVar);
        g gVar = new g();
        return com.bumptech.glide.i.c(context).a(gVar, com.bumptech.glide.b.a.class).a((l.b) aVar).a(Bitmap.class).b(com.bumptech.glide.load.resource.a.b()).b((com.bumptech.glide.load.e) hVar).b(true).b(com.bumptech.glide.load.b.b.NONE).b(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public static class d implements com.bumptech.glide.load.c {

        /* renamed from: a  reason: collision with root package name */
        private final UUID f974a;

        public d() {
            this(UUID.randomUUID());
        }

        d(UUID uuid) {
            this.f974a = uuid;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return ((d) obj).f974a.equals(this.f974a);
            }
            return false;
        }

        public int hashCode() {
            return this.f974a.hashCode();
        }

        @Override // com.bumptech.glide.load.c
        public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
            throw new UnsupportedOperationException("Not implemented");
        }
    }
}
