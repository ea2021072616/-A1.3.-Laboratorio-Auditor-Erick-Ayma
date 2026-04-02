package com.fotoable.youtube.music.c.b;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: ApiModule_ProvideCountryApiServiceFactory.java */
/* loaded from: classes.dex */
public final class i implements Factory<com.fotoable.youtube.music.b.d.c> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2417a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2418b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<String> f2419c;
    private final Provider<OkHttpClient> d;
    private final Provider<GsonConverterFactory> e;
    private final Provider<RxJavaCallAdapterFactory> f;

    static {
        f2417a = !i.class.desiredAssertionStatus();
    }

    public i(c cVar, Provider<String> provider, Provider<OkHttpClient> provider2, Provider<GsonConverterFactory> provider3, Provider<RxJavaCallAdapterFactory> provider4) {
        if (!f2417a && cVar == null) {
            throw new AssertionError();
        }
        this.f2418b = cVar;
        if (!f2417a && provider == null) {
            throw new AssertionError();
        }
        this.f2419c = provider;
        if (!f2417a && provider2 == null) {
            throw new AssertionError();
        }
        this.d = provider2;
        if (!f2417a && provider3 == null) {
            throw new AssertionError();
        }
        this.e = provider3;
        if (!f2417a && provider4 == null) {
            throw new AssertionError();
        }
        this.f = provider4;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public com.fotoable.youtube.music.b.d.c get() {
        return (com.fotoable.youtube.music.b.d.c) Preconditions.checkNotNull(this.f2418b.d(this.f2419c.get(), this.d.get(), this.e.get(), this.f.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<com.fotoable.youtube.music.b.d.c> a(c cVar, Provider<String> provider, Provider<OkHttpClient> provider2, Provider<GsonConverterFactory> provider3, Provider<RxJavaCallAdapterFactory> provider4) {
        return new i(cVar, provider, provider2, provider3, provider4);
    }
}
