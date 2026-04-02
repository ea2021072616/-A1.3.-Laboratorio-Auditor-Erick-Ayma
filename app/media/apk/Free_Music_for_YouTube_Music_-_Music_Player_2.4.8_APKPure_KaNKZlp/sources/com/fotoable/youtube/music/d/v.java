package com.fotoable.youtube.music.d;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;
/* compiled from: GlobalMusicDetailsPresenter_Factory.java */
/* loaded from: classes.dex */
public final class v implements Factory<r> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2589a;

    /* renamed from: b  reason: collision with root package name */
    private final MembersInjector<r> f2590b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f2591c;
    private final Provider<com.fotoable.youtube.music.db.a> d;

    static {
        f2589a = !v.class.desiredAssertionStatus();
    }

    public v(MembersInjector<r> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider, Provider<com.fotoable.youtube.music.db.a> provider2) {
        if (!f2589a && membersInjector == null) {
            throw new AssertionError();
        }
        this.f2590b = membersInjector;
        if (!f2589a && provider == null) {
            throw new AssertionError();
        }
        this.f2591c = provider;
        if (!f2589a && provider2 == null) {
            throw new AssertionError();
        }
        this.d = provider2;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public r get() {
        return (r) MembersInjectors.injectMembers(this.f2590b, new r(this.f2591c.get(), this.d.get()));
    }

    public static Factory<r> a(MembersInjector<r> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider, Provider<com.fotoable.youtube.music.db.a> provider2) {
        return new v(membersInjector, provider, provider2);
    }
}
