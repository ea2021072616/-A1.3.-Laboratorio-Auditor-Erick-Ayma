package com.fotoable.youtube.music.c.b;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: ApiModule_ProvideGsonConverterFactoryFactory.java */
/* loaded from: classes.dex */
public final class k implements Factory<GsonConverterFactory> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2422a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2423b;

    static {
        f2422a = !k.class.desiredAssertionStatus();
    }

    public k(c cVar) {
        if (!f2422a && cVar == null) {
            throw new AssertionError();
        }
        this.f2423b = cVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public GsonConverterFactory get() {
        return (GsonConverterFactory) Preconditions.checkNotNull(this.f2423b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<GsonConverterFactory> a(c cVar) {
        return new k(cVar);
    }
}
