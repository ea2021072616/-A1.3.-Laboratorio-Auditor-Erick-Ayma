package com.fotoable.youtube.music.c.b;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: ApiModule_ProvideYoutubeOfficialApiServiceFactory.java */
/* loaded from: classes.dex */
public final class s implements Factory<com.fotoable.youtube.music.b.d.e> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2441a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2442b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<String> f2443c;
    private final Provider<OkHttpClient> d;
    private final Provider<GsonConverterFactory> e;
    private final Provider<RxJavaCallAdapterFactory> f;

    static {
        f2441a = !s.class.desiredAssertionStatus();
    }

    public s(c cVar, Provider<String> provider, Provider<OkHttpClient> provider2, Provider<GsonConverterFactory> provider3, Provider<RxJavaCallAdapterFactory> provider4) {
        if (!f2441a && cVar == null) {
            throw new AssertionError();
        }
        this.f2442b = cVar;
        if (!f2441a && provider == null) {
            throw new AssertionError();
        }
        this.f2443c = provider;
        if (!f2441a && provider2 == null) {
            throw new AssertionError();
        }
        this.d = provider2;
        if (!f2441a && provider3 == null) {
            throw new AssertionError();
        }
        this.e = provider3;
        if (!f2441a && provider4 == null) {
            throw new AssertionError();
        }
        this.f = provider4;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public com.fotoable.youtube.music.b.d.e get() {
        return (com.fotoable.youtube.music.b.d.e) Preconditions.checkNotNull(this.f2442b.c(this.f2443c.get(), this.d.get(), this.e.get(), this.f.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<com.fotoable.youtube.music.b.d.e> a(c cVar, Provider<String> provider, Provider<OkHttpClient> provider2, Provider<GsonConverterFactory> provider3, Provider<RxJavaCallAdapterFactory> provider4) {
        return new s(cVar, provider, provider2, provider3, provider4);
    }
}
