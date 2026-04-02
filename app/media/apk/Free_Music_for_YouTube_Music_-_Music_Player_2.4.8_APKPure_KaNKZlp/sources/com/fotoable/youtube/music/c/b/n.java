package com.fotoable.youtube.music.c.b;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* compiled from: ApiModule_ProvideMusicCommunityBaseUrlFactory.java */
/* loaded from: classes.dex */
public final class n implements Factory<String> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2429a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2430b;

    static {
        f2429a = !n.class.desiredAssertionStatus();
    }

    public n(c cVar) {
        if (!f2429a && cVar == null) {
            throw new AssertionError();
        }
        this.f2430b = cVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public String get() {
        return (String) Preconditions.checkNotNull(this.f2430b.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<String> a(c cVar) {
        return new n(cVar);
    }
}
