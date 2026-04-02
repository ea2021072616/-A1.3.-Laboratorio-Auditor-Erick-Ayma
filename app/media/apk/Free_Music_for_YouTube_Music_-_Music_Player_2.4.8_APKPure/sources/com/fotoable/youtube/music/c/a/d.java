package com.fotoable.youtube.music.c.a;

import android.content.Context;
import com.fotoable.youtube.music.MusicApplication;
import com.fotoable.youtube.music.base.BaseActivity;
import com.fotoable.youtube.music.c.b.m;
import com.fotoable.youtube.music.c.b.n;
import com.fotoable.youtube.music.c.b.o;
import com.fotoable.youtube.music.c.b.p;
import com.fotoable.youtube.music.c.b.q;
import com.fotoable.youtube.music.c.b.r;
import com.fotoable.youtube.music.c.b.s;
import com.fotoable.youtube.music.c.b.t;
import com.fotoable.youtube.music.c.b.u;
import com.fotoable.youtube.music.c.b.v;
import com.fotoable.youtube.music.c.b.w;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: DaggerApplicationComponent.java */
/* loaded from: classes.dex */
public final class d implements b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2342a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<String> f2343b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<OkHttpClient> f2344c;
    private Provider<GsonConverterFactory> d;
    private Provider<RxJavaCallAdapterFactory> e;
    private Provider<com.fotoable.youtube.music.b.d.d> f;
    private Provider<String> g;
    private Provider<com.fotoable.youtube.music.b.d.c> h;
    private Provider<String> i;
    private Provider<com.fotoable.youtube.music.b.d.b> j;
    private Provider<com.fotoable.youtube.music.b.c> k;
    private Provider<String> l;
    private Provider<com.fotoable.youtube.music.b.d.e> m;
    private Provider<com.fotoable.youtube.music.b.e> n;
    private Provider<String> o;
    private Provider<com.fotoable.youtube.music.b.d.a> p;
    private Provider<com.fotoable.youtube.music.b.a> q;
    private Provider<MusicApplication> r;
    private Provider<com.fotoable.youtube.music.db.a> s;
    private Provider<Context> t;

    static {
        f2342a = !d.class.desiredAssertionStatus();
    }

    private d(a aVar) {
        if (!f2342a && aVar == null) {
            throw new AssertionError();
        }
        a(aVar);
    }

    public static a e() {
        return new a();
    }

    private void a(a aVar) {
        this.f2343b = DoubleCheck.provider(m.a(aVar.f2345a));
        this.f2344c = DoubleCheck.provider(com.fotoable.youtube.music.c.b.d.a(aVar.f2345a));
        this.d = DoubleCheck.provider(com.fotoable.youtube.music.c.b.k.a(aVar.f2345a));
        this.e = DoubleCheck.provider(q.a(aVar.f2345a));
        this.f = DoubleCheck.provider(r.a(aVar.f2345a, this.f2343b, this.f2344c, this.d, this.e));
        this.g = DoubleCheck.provider(com.fotoable.youtube.music.c.b.j.a(aVar.f2345a));
        this.h = DoubleCheck.provider(com.fotoable.youtube.music.c.b.i.a(aVar.f2345a, this.g, this.f2344c, this.d, this.e));
        this.i = DoubleCheck.provider(n.a(aVar.f2345a));
        this.j = DoubleCheck.provider(com.fotoable.youtube.music.c.b.h.a(aVar.f2345a, this.i, this.f2344c, this.d, this.e));
        this.k = DoubleCheck.provider(com.fotoable.youtube.music.c.b.l.a(aVar.f2345a, this.f, this.h, this.j));
        this.l = DoubleCheck.provider(p.a(aVar.f2345a));
        this.m = DoubleCheck.provider(s.a(aVar.f2345a, this.l, this.f2344c, this.d, this.e));
        this.n = DoubleCheck.provider(o.a(aVar.f2345a, this.m));
        this.o = DoubleCheck.provider(com.fotoable.youtube.music.c.b.g.a(aVar.f2345a));
        this.p = DoubleCheck.provider(com.fotoable.youtube.music.c.b.e.a(aVar.f2345a, this.o, this.f2344c, this.d, this.e));
        this.q = DoubleCheck.provider(com.fotoable.youtube.music.c.b.f.a(aVar.f2345a, this.p));
        this.r = DoubleCheck.provider(u.a(aVar.f2346b));
        this.s = DoubleCheck.provider(w.a(aVar.f2346b));
        this.t = DoubleCheck.provider(v.a(aVar.f2346b));
    }

    @Override // com.fotoable.youtube.music.c.a.b
    public void a(BaseActivity baseActivity) {
        MembersInjectors.noOp().injectMembers(baseActivity);
    }

    @Override // com.fotoable.youtube.music.c.a.b
    public com.fotoable.youtube.music.b.c a() {
        return this.k.get();
    }

    @Override // com.fotoable.youtube.music.c.a.b
    public com.fotoable.youtube.music.b.e b() {
        return this.n.get();
    }

    @Override // com.fotoable.youtube.music.c.a.b
    public com.fotoable.youtube.music.b.a c() {
        return this.q.get();
    }

    @Override // com.fotoable.youtube.music.c.a.b
    public com.fotoable.youtube.music.db.a d() {
        return this.s.get();
    }

    /* compiled from: DaggerApplicationComponent.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private com.fotoable.youtube.music.c.b.c f2345a;

        /* renamed from: b  reason: collision with root package name */
        private t f2346b;

        private a() {
        }

        public b a() {
            if (this.f2345a == null) {
                throw new IllegalStateException(com.fotoable.youtube.music.c.b.c.class.getCanonicalName() + " must be set");
            }
            if (this.f2346b == null) {
                throw new IllegalStateException(t.class.getCanonicalName() + " must be set");
            }
            return new d(this);
        }

        public a a(t tVar) {
            this.f2346b = (t) Preconditions.checkNotNull(tVar);
            return this;
        }

        public a a(com.fotoable.youtube.music.c.b.c cVar) {
            this.f2345a = (com.fotoable.youtube.music.c.b.c) Preconditions.checkNotNull(cVar);
            return this;
        }
    }
}
