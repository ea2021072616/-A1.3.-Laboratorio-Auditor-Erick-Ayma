package com.fotoable.youtube.music.d;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;
/* compiled from: MyRecentlyWatchedPresenter_Factory.java */
/* loaded from: classes.dex */
public final class ak implements Factory<ag> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2486a;

    /* renamed from: b  reason: collision with root package name */
    private final MembersInjector<ag> f2487b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f2488c;

    static {
        f2486a = !ak.class.desiredAssertionStatus();
    }

    public ak(MembersInjector<ag> membersInjector, Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f2486a && membersInjector == null) {
            throw new AssertionError();
        }
        this.f2487b = membersInjector;
        if (!f2486a && provider == null) {
            throw new AssertionError();
        }
        this.f2488c = provider;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public ag get() {
        return (ag) MembersInjectors.injectMembers(this.f2487b, new ag(this.f2488c.get()));
    }

    public static Factory<ag> a(MembersInjector<ag> membersInjector, Provider<com.fotoable.youtube.music.db.a> provider) {
        return new ak(membersInjector, provider);
    }
}
