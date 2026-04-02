package com.fotoable.youtube.music.c.b;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;
/* compiled from: ApiModule_ProvideBaseClientFactory.java */
/* loaded from: classes.dex */
public final class d implements Factory<OkHttpClient> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2404a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2405b;

    static {
        f2404a = !d.class.desiredAssertionStatus();
    }

    public d(c cVar) {
        if (!f2404a && cVar == null) {
            throw new AssertionError();
        }
        this.f2405b = cVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public OkHttpClient get() {
        return (OkHttpClient) Preconditions.checkNotNull(this.f2405b.h(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<OkHttpClient> a(c cVar) {
        return new d(cVar);
    }
}
