package com.fotoable.youtube.music.c.b;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* compiled from: DialogModule_ProvideContextFactory.java */
/* loaded from: classes.dex */
public final class y implements Factory<Context> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2452a;

    /* renamed from: b  reason: collision with root package name */
    private final x f2453b;

    static {
        f2452a = !y.class.desiredAssertionStatus();
    }

    public y(x xVar) {
        if (!f2452a && xVar == null) {
            throw new AssertionError();
        }
        this.f2453b = xVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public Context get() {
        return (Context) Preconditions.checkNotNull(this.f2453b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Context> a(x xVar) {
        return new y(xVar);
    }
}
