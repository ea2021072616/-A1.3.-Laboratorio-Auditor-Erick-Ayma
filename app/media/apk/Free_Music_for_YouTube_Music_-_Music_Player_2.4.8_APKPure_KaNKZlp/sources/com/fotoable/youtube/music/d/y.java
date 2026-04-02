package com.fotoable.youtube.music.d;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;
/* compiled from: GlobalMusicPresenter_Factory.java */
/* loaded from: classes.dex */
public final class y implements Factory<w> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2597a;

    /* renamed from: b  reason: collision with root package name */
    private final MembersInjector<w> f2598b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f2599c;

    static {
        f2597a = !y.class.desiredAssertionStatus();
    }

    public y(MembersInjector<w> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f2597a && membersInjector == null) {
            throw new AssertionError();
        }
        this.f2598b = membersInjector;
        if (!f2597a && provider == null) {
            throw new AssertionError();
        }
        this.f2599c = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public w get() {
        return (w) MembersInjectors.injectMembers(this.f2598b, new w(this.f2599c.get()));
    }

    public static Factory<w> a(MembersInjector<w> membersInjector, Provider<com.fotoable.youtube.music.b.c> provider) {
        return new y(membersInjector, provider);
    }
}
