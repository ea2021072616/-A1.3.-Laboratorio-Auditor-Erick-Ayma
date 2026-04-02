package com.fotoable.youtube.music.c.b;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* compiled from: ApiModule_ProvideMusicBaseUrlFactory.java */
/* loaded from: classes.dex */
public final class m implements Factory<String> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2427a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2428b;

    static {
        f2427a = !m.class.desiredAssertionStatus();
    }

    public m(c cVar) {
        if (!f2427a && cVar == null) {
            throw new AssertionError();
        }
        this.f2428b = cVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public String get() {
        return (String) Preconditions.checkNotNull(this.f2428b.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<String> a(c cVar) {
        return new m(cVar);
    }
}
