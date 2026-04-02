package com.bumptech.glide;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.d.c;
import com.bumptech.glide.d.m;
/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public class l implements com.bumptech.glide.d.h {

    /* renamed from: a  reason: collision with root package name */
    private final Context f743a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.d.g f744b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.d.l f745c;
    private final m d;
    private final i e;
    private final c f;
    private a g;

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    public interface a {
        <T> void a(e<T, ?, ?, ?> eVar);
    }

    public l(Context context, com.bumptech.glide.d.g gVar, com.bumptech.glide.d.l lVar) {
        this(context, gVar, lVar, new m(), new com.bumptech.glide.d.d());
    }

    l(Context context, final com.bumptech.glide.d.g gVar, com.bumptech.glide.d.l lVar, m mVar, com.bumptech.glide.d.d dVar) {
        this.f743a = context.getApplicationContext();
        this.f744b = gVar;
        this.f745c = lVar;
        this.d = mVar;
        this.e = i.b(context);
        this.f = new c();
        com.bumptech.glide.d.c a2 = dVar.a(context, new d(mVar));
        if (com.bumptech.glide.i.h.d()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bumptech.glide.l.1
                @Override // java.lang.Runnable
                public void run() {
                    gVar.a(l.this);
                }
            });
        } else {
            gVar.a(this);
        }
        gVar.a(a2);
    }

    public void a(int i) {
        this.e.a(i);
    }

    public void a() {
        this.e.h();
    }

    public void b() {
        com.bumptech.glide.i.h.a();
        this.d.a();
    }

    public void c() {
        com.bumptech.glide.i.h.a();
        this.d.b();
    }

    @Override // com.bumptech.glide.d.h
    public void onStart() {
        c();
    }

    @Override // com.bumptech.glide.d.h
    public void onStop() {
        b();
    }

    @Override // com.bumptech.glide.d.h
    public void onDestroy() {
        this.d.c();
    }

    public <A, T> b<A, T> a(com.bumptech.glide.load.c.l<A, T> lVar, Class<T> cls) {
        return new b<>(lVar, cls);
    }

    public com.bumptech.glide.d<String> a(String str) {
        return (com.bumptech.glide.d) d().a((com.bumptech.glide.d<String>) str);
    }

    public com.bumptech.glide.d<String> d() {
        return a(String.class);
    }

    public com.bumptech.glide.d<Uri> a(Uri uri) {
        return (com.bumptech.glide.d) e().a((com.bumptech.glide.d<Uri>) uri);
    }

    public com.bumptech.glide.d<Uri> e() {
        return a(Uri.class);
    }

    public com.bumptech.glide.d<Integer> a(Integer num) {
        return (com.bumptech.glide.d) f().a((com.bumptech.glide.d<Integer>) num);
    }

    public com.bumptech.glide.d<Integer> f() {
        return (com.bumptech.glide.d) a(Integer.class).b(com.bumptech.glide.h.a.a(this.f743a));
    }

    private <T> com.bumptech.glide.d<T> a(Class<T> cls) {
        com.bumptech.glide.load.c.l a2 = i.a(cls, this.f743a);
        com.bumptech.glide.load.c.l b2 = i.b(cls, this.f743a);
        if (cls != null && a2 == null && b2 == null) {
            throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for which there is a registered ModelLoader, if you are using a custom model, you must first call Glide#register with a ModelLoaderFactory for your custom model class");
        }
        return (com.bumptech.glide.d) this.f.a(new com.bumptech.glide.d(cls, a2, b2, this.f743a, this.e, this.d, this.f744b, this.f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> Class<T> b(T t) {
        if (t != null) {
            return (Class<T>) t.getClass();
        }
        return null;
    }

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    public final class b<A, T> {

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.load.c.l<A, T> f749b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<T> f750c;

        b(com.bumptech.glide.load.c.l<A, T> lVar, Class<T> cls) {
            this.f749b = lVar;
            this.f750c = cls;
        }

        public b<A, T>.a a(A a2) {
            return new a(a2);
        }

        /* compiled from: RequestManager.java */
        /* loaded from: classes.dex */
        public final class a {

            /* renamed from: b  reason: collision with root package name */
            private final A f752b;

            /* renamed from: c  reason: collision with root package name */
            private final Class<A> f753c;
            private final boolean d = true;

            a(A a2) {
                this.f752b = a2;
                this.f753c = l.b(a2);
            }

            public <Z> f<A, T, Z> a(Class<Z> cls) {
                f<A, T, Z> fVar = (f) l.this.f.a(new f(l.this.f743a, l.this.e, this.f753c, b.this.f749b, b.this.f750c, cls, l.this.d, l.this.f744b, l.this.f));
                if (this.d) {
                    fVar.b((f<A, T, Z>) this.f752b);
                }
                return fVar;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    public class c {
        c() {
        }

        public <A, X extends e<A, ?, ?, ?>> X a(X x) {
            if (l.this.g != null) {
                l.this.g.a(x);
            }
            return x;
        }
    }

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    private static class d implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final m f755a;

        public d(m mVar) {
            this.f755a = mVar;
        }

        @Override // com.bumptech.glide.d.c.a
        public void a(boolean z) {
            if (z) {
                this.f755a.d();
            }
        }
    }
}
