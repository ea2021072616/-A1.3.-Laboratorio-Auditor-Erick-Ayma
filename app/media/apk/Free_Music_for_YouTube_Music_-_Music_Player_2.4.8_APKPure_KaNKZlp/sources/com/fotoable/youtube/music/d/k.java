package com.fotoable.youtube.music.d;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;
/* compiled from: ClassifiedMusicPresenter_Factory.java */
/* loaded from: classes.dex */
public final class k implements Factory<i> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2554a;

    /* renamed from: b  reason: collision with root package name */
    private final MembersInjector<i> f2555b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f2556c;

    static {
        f2554a = !k.class.desiredAssertionStatus();
    }

    public k(MembersInjector<i> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f2554a && membersInjector == null) {
            throw new AssertionError();
        }
        this.f2555b = membersInjector;
        if (!f2554a && provider == null) {
            throw new AssertionError();
        }
        this.f2556c = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public i get() {
        return (i) MembersInjectors.injectMembers(this.f2555b, new i(this.f2556c.get()));
    }

    public static Factory<i> a(MembersInjector<i> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider) {
        return new k(membersInjector, provider);
    }
}
