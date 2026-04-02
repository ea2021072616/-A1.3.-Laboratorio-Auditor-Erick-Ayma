package com.fotoable.youtube.music.c.b;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* compiled from: ApplicationModule_ProvideContextFactory.java */
/* loaded from: classes.dex */
public final class v implements Factory<Context> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2447a;

    /* renamed from: b  reason: collision with root package name */
    private final t f2448b;

    static {
        f2447a = !v.class.desiredAssertionStatus();
    }

    public v(t tVar) {
        if (!f2447a && tVar == null) {
            throw new AssertionError();
        }
        this.f2448b = tVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public Context get() {
        return (Context) Preconditions.checkNotNull(this.f2448b.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Context> a(t tVar) {
        return new v(tVar);
    }
}
