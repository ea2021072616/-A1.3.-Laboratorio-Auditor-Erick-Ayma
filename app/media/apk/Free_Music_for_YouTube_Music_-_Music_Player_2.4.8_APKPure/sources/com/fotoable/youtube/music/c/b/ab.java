package com.fotoable.youtube.music.c.b;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* compiled from: FragmentModule_FragmentFactory.java */
/* loaded from: classes.dex */
public final class ab implements Factory<com.fotoable.youtube.music.base.i> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2388a;

    /* renamed from: b  reason: collision with root package name */
    private final z f2389b;

    static {
        f2388a = !ab.class.desiredAssertionStatus();
    }

    public ab(z zVar) {
        if (!f2388a && zVar == null) {
            throw new AssertionError();
        }
        this.f2389b = zVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public com.fotoable.youtube.music.base.i get() {
        return (com.fotoable.youtube.music.base.i) Preconditions.checkNotNull(this.f2389b.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<com.fotoable.youtube.music.base.i> a(z zVar) {
        return new ab(zVar);
    }
}
