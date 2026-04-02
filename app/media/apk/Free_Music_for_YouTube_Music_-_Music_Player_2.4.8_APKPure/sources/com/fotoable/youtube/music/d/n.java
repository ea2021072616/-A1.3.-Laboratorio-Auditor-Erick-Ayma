package com.fotoable.youtube.music.d;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;
/* compiled from: CommunityPresenter_Factory.java */
/* loaded from: classes.dex */
public final class n implements Factory<l> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2563a;

    /* renamed from: b  reason: collision with root package name */
    private final MembersInjector<l> f2564b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f2565c;
    private final Provider<com.fotoable.youtube.music.db.a> d;

    static {
        f2563a = !n.class.desiredAssertionStatus();
    }

    public n(MembersInjector<l> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider, Provider<com.fotoable.youtube.music.db.a> provider2) {
        if (!f2563a && membersInjector == null) {
            throw new AssertionError();
        }
        this.f2564b = membersInjector;
        if (!f2563a && provider == null) {
            throw new AssertionError();
        }
        this.f2565c = provider;
        if (!f2563a && provider2 == null) {
            throw new AssertionError();
        }
        this.d = provider2;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public l get() {
        return (l) MembersInjectors.injectMembers(this.f2564b, new l(this.f2565c.get(), this.d.get()));
    }

    public static Factory<l> a(MembersInjector<l> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider, Provider<com.fotoable.youtube.music.db.a> provider2) {
        return new n(membersInjector, provider, provider2);
    }
}
