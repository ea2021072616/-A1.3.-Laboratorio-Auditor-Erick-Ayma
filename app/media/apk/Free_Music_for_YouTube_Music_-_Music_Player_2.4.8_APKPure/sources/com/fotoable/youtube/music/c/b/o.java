package com.fotoable.youtube.music.c.b;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
/* compiled from: ApiModule_ProvideMusicOfficialManagerFactory.java */
/* loaded from: classes.dex */
public final class o implements Factory<com.fotoable.youtube.music.b.e> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2431a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2432b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.d.e> f2433c;

    static {
        f2431a = !o.class.desiredAssertionStatus();
    }

    public o(c cVar, Provider<com.fotoable.youtube.music.b.d.e> provider) {
        if (!f2431a && cVar == null) {
            throw new AssertionError();
        }
        this.f2432b = cVar;
        if (!f2431a && provider == null) {
            throw new AssertionError();
        }
        this.f2433c = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public com.fotoable.youtube.music.b.e get() {
        return (com.fotoable.youtube.music.b.e) Preconditions.checkNotNull(this.f2432b.a(this.f2433c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<com.fotoable.youtube.music.b.e> a(c cVar, Provider<com.fotoable.youtube.music.b.d.e> provider) {
        return new o(cVar, provider);
    }
}
