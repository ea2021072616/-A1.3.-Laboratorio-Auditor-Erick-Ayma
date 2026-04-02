package com.fotoable.youtube.music.c.b;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* compiled from: ApiModule_ProvideBingUrlFactory.java */
/* loaded from: classes.dex */
public final class g implements Factory<String> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2412a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2413b;

    static {
        f2412a = !g.class.desiredAssertionStatus();
    }

    public g(c cVar) {
        if (!f2412a && cVar == null) {
            throw new AssertionError();
        }
        this.f2413b = cVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public String get() {
        return (String) Preconditions.checkNotNull(this.f2413b.g(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<String> a(c cVar) {
        return new g(cVar);
    }
}
