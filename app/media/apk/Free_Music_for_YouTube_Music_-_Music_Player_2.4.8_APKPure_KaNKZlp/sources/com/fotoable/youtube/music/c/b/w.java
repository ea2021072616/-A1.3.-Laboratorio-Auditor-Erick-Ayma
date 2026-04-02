package com.fotoable.youtube.music.c.b;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* compiled from: ApplicationModule_ProvideGreenDAOHelperFactory.java */
/* loaded from: classes.dex */
public final class w implements Factory<com.fotoable.youtube.music.db.a> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2449a;

    /* renamed from: b  reason: collision with root package name */
    private final t f2450b;

    static {
        f2449a = !w.class.desiredAssertionStatus();
    }

    public w(t tVar) {
        if (!f2449a && tVar == null) {
            throw new AssertionError();
        }
        this.f2450b = tVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public com.fotoable.youtube.music.db.a get() {
        return (com.fotoable.youtube.music.db.a) Preconditions.checkNotNull(this.f2450b.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<com.fotoable.youtube.music.db.a> a(t tVar) {
        return new w(tVar);
    }
}
