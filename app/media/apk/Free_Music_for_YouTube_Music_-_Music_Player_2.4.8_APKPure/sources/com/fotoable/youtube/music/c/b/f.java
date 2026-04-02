package com.fotoable.youtube.music.c.b;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
/* compiled from: ApiModule_ProvideBingManagerFactory.java */
/* loaded from: classes.dex */
public final class f implements Factory<com.fotoable.youtube.music.b.a> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2409a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2410b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.d.a> f2411c;

    static {
        f2409a = !f.class.desiredAssertionStatus();
    }

    public f(c cVar, Provider<com.fotoable.youtube.music.b.d.a> provider) {
        if (!f2409a && cVar == null) {
            throw new AssertionError();
        }
        this.f2410b = cVar;
        if (!f2409a && provider == null) {
            throw new AssertionError();
        }
        this.f2411c = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public com.fotoable.youtube.music.b.a get() {
        return (com.fotoable.youtube.music.b.a) Preconditions.checkNotNull(this.f2410b.a(this.f2411c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<com.fotoable.youtube.music.b.a> a(c cVar, Provider<com.fotoable.youtube.music.b.d.a> provider) {
        return new f(cVar, provider);
    }
}
