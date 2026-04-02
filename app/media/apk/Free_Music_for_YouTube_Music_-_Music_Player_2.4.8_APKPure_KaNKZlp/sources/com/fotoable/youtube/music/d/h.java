package com.fotoable.youtube.music.d;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;
/* compiled from: ClassifiedMusicDetailsPresenter_Factory.java */
/* loaded from: classes.dex */
public final class h implements Factory<d> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2546a;

    /* renamed from: b  reason: collision with root package name */
    private final MembersInjector<d> f2547b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f2548c;
    private final Provider<com.fotoable.youtube.music.db.a> d;

    static {
        f2546a = !h.class.desiredAssertionStatus();
    }

    public h(MembersInjector<d> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider, Provider<com.fotoable.youtube.music.db.a> provider2) {
        if (!f2546a && membersInjector == null) {
            throw new AssertionError();
        }
        this.f2547b = membersInjector;
        if (!f2546a && provider == null) {
            throw new AssertionError();
        }
        this.f2548c = provider;
        if (!f2546a && provider2 == null) {
            throw new AssertionError();
        }
        this.d = provider2;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public d get() {
        return (d) MembersInjectors.injectMembers(this.f2547b, new d(this.f2548c.get(), this.d.get()));
    }

    public static Factory<d> a(MembersInjector<d> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider, Provider<com.fotoable.youtube.music.db.a> provider2) {
        return new h(membersInjector, provider, provider2);
    }
}
