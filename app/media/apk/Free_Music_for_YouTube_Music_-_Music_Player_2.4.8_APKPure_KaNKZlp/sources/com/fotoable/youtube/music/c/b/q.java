package com.fotoable.youtube.music.c.b;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
/* compiled from: ApiModule_ProvideRxJavaCallAdapterFactoryFactory.java */
/* loaded from: classes.dex */
public final class q implements Factory<RxJavaCallAdapterFactory> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2436a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2437b;

    static {
        f2436a = !q.class.desiredAssertionStatus();
    }

    public q(c cVar) {
        if (!f2436a && cVar == null) {
            throw new AssertionError();
        }
        this.f2437b = cVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public RxJavaCallAdapterFactory get() {
        return (RxJavaCallAdapterFactory) Preconditions.checkNotNull(this.f2437b.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<RxJavaCallAdapterFactory> a(c cVar) {
        return new q(cVar);
    }
}
