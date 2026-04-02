package com.fotoable.youtube.music.d;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;
/* compiled from: MyFavoritePresenter_Factory.java */
/* loaded from: classes.dex */
public final class af implements Factory<ad> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2472a;

    /* renamed from: b  reason: collision with root package name */
    private final MembersInjector<ad> f2473b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f2474c;

    static {
        f2472a = !af.class.desiredAssertionStatus();
    }

    public af(MembersInjector<ad> membersInjector, Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f2472a && membersInjector == null) {
            throw new AssertionError();
        }
        this.f2473b = membersInjector;
        if (!f2472a && provider == null) {
            throw new AssertionError();
        }
        this.f2474c = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public ad get() {
        return (ad) MembersInjectors.injectMembers(this.f2473b, new ad(this.f2474c.get()));
    }

    public static Factory<ad> a(MembersInjector<ad> membersInjector, Provider<com.fotoable.youtube.music.db.a> provider) {
        return new af(membersInjector, provider);
    }
}
