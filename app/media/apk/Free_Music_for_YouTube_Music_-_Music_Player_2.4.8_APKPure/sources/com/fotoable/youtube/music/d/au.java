package com.fotoable.youtube.music.d;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;
/* compiled from: Top100Presenter_Factory.java */
/* loaded from: classes.dex */
public final class au implements Factory<as> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2526a;

    /* renamed from: b  reason: collision with root package name */
    private final MembersInjector<as> f2527b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f2528c;
    private final Provider<com.fotoable.youtube.music.db.a> d;

    static {
        f2526a = !au.class.desiredAssertionStatus();
    }

    public au(MembersInjector<as> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider, Provider<com.fotoable.youtube.music.db.a> provider2) {
        if (!f2526a && membersInjector == null) {
            throw new AssertionError();
        }
        this.f2527b = membersInjector;
        if (!f2526a && provider == null) {
            throw new AssertionError();
        }
        this.f2528c = provider;
        if (!f2526a && provider2 == null) {
            throw new AssertionError();
        }
        this.d = provider2;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public as get() {
        return (as) MembersInjectors.injectMembers(this.f2527b, new as(this.f2528c.get(), this.d.get()));
    }

    public static Factory<as> a(MembersInjector<as> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider, Provider<com.fotoable.youtube.music.db.a> provider2) {
        return new au(membersInjector, provider, provider2);
    }
}
