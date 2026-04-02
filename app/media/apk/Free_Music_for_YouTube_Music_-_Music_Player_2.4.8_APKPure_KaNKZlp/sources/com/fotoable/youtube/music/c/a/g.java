package com.fotoable.youtube.music.c.a;

import android.app.Service;
import android.content.Context;
import com.fotoable.youtube.music.c.b.ac;
import com.fotoable.youtube.music.c.b.ad;
import com.fotoable.youtube.music.c.b.ae;
import com.fotoable.youtube.music.service.MainService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
/* compiled from: DaggerServiceComponent.java */
/* loaded from: classes.dex */
public final class g implements k {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2369a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<Service> f2370b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<Context> f2371c;
    private Provider<com.fotoable.youtube.music.db.a> d;
    private MembersInjector<MainService> e;

    static {
        f2369a = !g.class.desiredAssertionStatus();
    }

    private g(a aVar) {
        if (!f2369a && aVar == null) {
            throw new AssertionError();
        }
        a(aVar);
    }

    public static a a() {
        return new a();
    }

    private void a(final a aVar) {
        this.f2370b = DoubleCheck.provider(ae.a(aVar.f2375a));
        this.f2371c = DoubleCheck.provider(ad.a(aVar.f2375a));
        this.d = new Factory<com.fotoable.youtube.music.db.a>() { // from class: com.fotoable.youtube.music.c.a.g.1

            /* renamed from: c  reason: collision with root package name */
            private final b f2374c;

            {
                this.f2374c = aVar.f2376b;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public com.fotoable.youtube.music.db.a get() {
                return (com.fotoable.youtube.music.db.a) Preconditions.checkNotNull(this.f2374c.d(), "Cannot return null from a non-@Nullable component method");
            }
        };
        this.e = com.fotoable.youtube.music.service.a.a(this.d);
    }

    @Override // com.fotoable.youtube.music.c.a.k
    public void a(MainService mainService) {
        this.e.injectMembers(mainService);
    }

    /* compiled from: DaggerServiceComponent.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private ac f2375a;

        /* renamed from: b  reason: collision with root package name */
        private b f2376b;

        private a() {
        }

        public k a() {
            if (this.f2375a == null) {
                throw new IllegalStateException(ac.class.getCanonicalName() + " must be set");
            }
            if (this.f2376b == null) {
                throw new IllegalStateException(b.class.getCanonicalName() + " must be set");
            }
            return new g(this);
        }

        public a a(ac acVar) {
            this.f2375a = (ac) Preconditions.checkNotNull(acVar);
            return this;
        }

        public a a(b bVar) {
            this.f2376b = (b) Preconditions.checkNotNull(bVar);
            return this;
        }
    }
}
