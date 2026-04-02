package com.fotoable.youtube.music.c.a;

import android.content.Context;
import com.fotoable.youtube.music.c.b.af;
import com.fotoable.youtube.music.c.b.ag;
import com.fotoable.youtube.music.locker.view.MusicLockerView;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
/* compiled from: DaggerViewComponent.java */
/* loaded from: classes.dex */
public final class h implements l {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2377a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<Context> f2378b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<com.fotoable.youtube.music.db.a> f2379c;
    private MembersInjector<MusicLockerView> d;

    static {
        f2377a = !h.class.desiredAssertionStatus();
    }

    private h(a aVar) {
        if (!f2377a && aVar == null) {
            throw new AssertionError();
        }
        a(aVar);
    }

    public static a a() {
        return new a();
    }

    private void a(final a aVar) {
        this.f2378b = DoubleCheck.provider(ag.a(aVar.f2383a));
        this.f2379c = new Factory<com.fotoable.youtube.music.db.a>() { // from class: com.fotoable.youtube.music.c.a.h.1

            /* renamed from: c  reason: collision with root package name */
            private final b f2382c;

            {
                this.f2382c = aVar.f2384b;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public com.fotoable.youtube.music.db.a get() {
                return (com.fotoable.youtube.music.db.a) Preconditions.checkNotNull(this.f2382c.d(), "Cannot return null from a non-@Nullable component method");
            }
        };
        this.d = com.fotoable.youtube.music.locker.view.d.a(this.f2379c);
    }

    @Override // com.fotoable.youtube.music.c.a.l
    public void a(MusicLockerView musicLockerView) {
        this.d.injectMembers(musicLockerView);
    }

    /* compiled from: DaggerViewComponent.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private af f2383a;

        /* renamed from: b  reason: collision with root package name */
        private b f2384b;

        private a() {
        }

        public l a() {
            if (this.f2383a == null) {
                throw new IllegalStateException(af.class.getCanonicalName() + " must be set");
            }
            if (this.f2384b == null) {
                throw new IllegalStateException(b.class.getCanonicalName() + " must be set");
            }
            return new h(this);
        }

        public a a(af afVar) {
            this.f2383a = (af) Preconditions.checkNotNull(afVar);
            return this;
        }

        public a a(b bVar) {
            this.f2384b = (b) Preconditions.checkNotNull(bVar);
            return this;
        }
    }
}
