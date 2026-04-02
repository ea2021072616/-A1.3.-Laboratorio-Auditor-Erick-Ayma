package com.fotoable.youtube.music.c.b;

import com.fotoable.youtube.music.MusicApplication;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* compiled from: ApplicationModule_ProvideApplicationContextFactory.java */
/* loaded from: classes.dex */
public final class u implements Factory<MusicApplication> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2445a;

    /* renamed from: b  reason: collision with root package name */
    private final t f2446b;

    static {
        f2445a = !u.class.desiredAssertionStatus();
    }

    public u(t tVar) {
        if (!f2445a && tVar == null) {
            throw new AssertionError();
        }
        this.f2446b = tVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public MusicApplication get() {
        return (MusicApplication) Preconditions.checkNotNull(this.f2446b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<MusicApplication> a(t tVar) {
        return new u(tVar);
    }
}
