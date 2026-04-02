package com.fotoable.youtube.music.d;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;
/* compiled from: MySubscriptionPresenter_Factory.java */
/* loaded from: classes.dex */
public final class an implements Factory<al> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2495a;

    /* renamed from: b  reason: collision with root package name */
    private final MembersInjector<al> f2496b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f2497c;

    static {
        f2495a = !an.class.desiredAssertionStatus();
    }

    public an(MembersInjector<al> membersInjector, Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f2495a && membersInjector == null) {
            throw new AssertionError();
        }
        this.f2496b = membersInjector;
        if (!f2495a && provider == null) {
            throw new AssertionError();
        }
        this.f2497c = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public al get() {
        return (al) MembersInjectors.injectMembers(this.f2496b, new al(this.f2497c.get()));
    }

    public static Factory<al> a(MembersInjector<al> membersInjector, Provider<com.fotoable.youtube.music.db.a> provider) {
        return new an(membersInjector, provider);
    }
}
