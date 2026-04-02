package com.fotoable.youtube.music.c.b;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* compiled from: ServiceModule_ProvideContextFactory.java */
/* loaded from: classes.dex */
public final class ad implements Factory<Context> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2391a;

    /* renamed from: b  reason: collision with root package name */
    private final ac f2392b;

    static {
        f2391a = !ad.class.desiredAssertionStatus();
    }

    public ad(ac acVar) {
        if (!f2391a && acVar == null) {
            throw new AssertionError();
        }
        this.f2392b = acVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public Context get() {
        return (Context) Preconditions.checkNotNull(this.f2392b.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Context> a(ac acVar) {
        return new ad(acVar);
    }
}
