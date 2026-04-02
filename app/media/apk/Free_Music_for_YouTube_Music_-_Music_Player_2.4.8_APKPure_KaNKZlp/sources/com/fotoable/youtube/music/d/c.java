package com.fotoable.youtube.music.d;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;
/* compiled from: ArtistsPresenter_Factory.java */
/* loaded from: classes.dex */
public final class c implements Factory<a> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2530a;

    /* renamed from: b  reason: collision with root package name */
    private final MembersInjector<a> f2531b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f2532c;

    static {
        f2530a = !c.class.desiredAssertionStatus();
    }

    public c(MembersInjector<a> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f2530a && membersInjector == null) {
            throw new AssertionError();
        }
        this.f2531b = membersInjector;
        if (!f2530a && provider == null) {
            throw new AssertionError();
        }
        this.f2532c = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public a get() {
        return (a) MembersInjectors.injectMembers(this.f2531b, new a(this.f2532c.get()));
    }

    public static Factory<a> a(MembersInjector<a> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider) {
        return new c(membersInjector, provider);
    }
}
