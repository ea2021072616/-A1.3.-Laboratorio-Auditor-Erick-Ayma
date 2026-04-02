package com.fotoable.youtube.music.c.b;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* compiled from: ApiModule_ProvideCountryUrlFactory.java */
/* loaded from: classes.dex */
public final class j implements Factory<String> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2420a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2421b;

    static {
        f2420a = !j.class.desiredAssertionStatus();
    }

    public j(c cVar) {
        if (!f2420a && cVar == null) {
            throw new AssertionError();
        }
        this.f2421b = cVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public String get() {
        return (String) Preconditions.checkNotNull(this.f2421b.f(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<String> a(c cVar) {
        return new j(cVar);
    }
}
