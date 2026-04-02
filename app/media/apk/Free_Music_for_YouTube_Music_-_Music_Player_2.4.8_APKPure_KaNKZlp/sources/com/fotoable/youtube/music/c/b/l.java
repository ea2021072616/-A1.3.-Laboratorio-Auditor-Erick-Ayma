package com.fotoable.youtube.music.c.b;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
/* compiled from: ApiModule_ProvideMusicApiManagerFactory.java */
/* loaded from: classes.dex */
public final class l implements Factory<com.fotoable.youtube.music.b.c> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2424a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2425b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.d.d> f2426c;
    private final Provider<com.fotoable.youtube.music.b.d.c> d;
    private final Provider<com.fotoable.youtube.music.b.d.b> e;

    static {
        f2424a = !l.class.desiredAssertionStatus();
    }

    public l(c cVar, Provider<com.fotoable.youtube.music.b.d.d> provider, Provider<com.fotoable.youtube.music.b.d.c> provider2, Provider<com.fotoable.youtube.music.b.d.b> provider3) {
        if (!f2424a && cVar == null) {
            throw new AssertionError();
        }
        this.f2425b = cVar;
        if (!f2424a && provider == null) {
            throw new AssertionError();
        }
        this.f2426c = provider;
        if (!f2424a && provider2 == null) {
            throw new AssertionError();
        }
        this.d = provider2;
        if (!f2424a && provider3 == null) {
            throw new AssertionError();
        }
        this.e = provider3;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public com.fotoable.youtube.music.b.c get() {
        return (com.fotoable.youtube.music.b.c) Preconditions.checkNotNull(this.f2425b.a(this.f2426c.get(), this.d.get(), this.e.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<com.fotoable.youtube.music.b.c> a(c cVar, Provider<com.fotoable.youtube.music.b.d.d> provider, Provider<com.fotoable.youtube.music.b.d.c> provider2, Provider<com.fotoable.youtube.music.b.d.b> provider3) {
        return new l(cVar, provider, provider2, provider3);
    }
}
