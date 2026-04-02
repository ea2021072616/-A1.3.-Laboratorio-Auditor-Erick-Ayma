package com.fotoable.youtube.music.c.b;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* compiled from: ViewModule_ProvideContextFactory.java */
/* loaded from: classes.dex */
public final class ag implements Factory<Context> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2396a;

    /* renamed from: b  reason: collision with root package name */
    private final af f2397b;

    static {
        f2396a = !ag.class.desiredAssertionStatus();
    }

    public ag(af afVar) {
        if (!f2396a && afVar == null) {
            throw new AssertionError();
        }
        this.f2397b = afVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public Context get() {
        return (Context) Preconditions.checkNotNull(this.f2397b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Context> a(af afVar) {
        return new ag(afVar);
    }
}
