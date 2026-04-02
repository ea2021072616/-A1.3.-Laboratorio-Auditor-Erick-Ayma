package com.fotoable.youtube.music.d;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;
/* compiled from: GenresPresenter_Factory.java */
/* loaded from: classes.dex */
public final class q implements Factory<p> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2573a;

    /* renamed from: b  reason: collision with root package name */
    private final MembersInjector<p> f2574b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f2575c;

    static {
        f2573a = !q.class.desiredAssertionStatus();
    }

    public q(MembersInjector<p> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f2573a && membersInjector == null) {
            throw new AssertionError();
        }
        this.f2574b = membersInjector;
        if (!f2573a && provider == null) {
            throw new AssertionError();
        }
        this.f2575c = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public p get() {
        return (p) MembersInjectors.injectMembers(this.f2574b, new p(this.f2575c.get()));
    }

    public static Factory<p> a(MembersInjector<p> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider) {
        return new q(membersInjector, provider);
    }
}
