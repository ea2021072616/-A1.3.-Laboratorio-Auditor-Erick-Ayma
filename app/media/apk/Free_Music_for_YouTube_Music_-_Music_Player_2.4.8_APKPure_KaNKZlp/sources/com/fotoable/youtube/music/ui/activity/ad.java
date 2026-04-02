package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: HomeListActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class ad implements MembersInjector<HomeListActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3919a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f3920b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f3921c;

    static {
        f3919a = !ad.class.desiredAssertionStatus();
    }

    public ad(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.b.c> provider2) {
        if (!f3919a && provider == null) {
            throw new AssertionError();
        }
        this.f3920b = provider;
        if (!f3919a && provider2 == null) {
            throw new AssertionError();
        }
        this.f3921c = provider2;
    }

    public static MembersInjector<HomeListActivity> a(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.b.c> provider2) {
        return new ad(provider, provider2);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(HomeListActivity homeListActivity) {
        if (homeListActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        homeListActivity.f3364b = this.f3920b.get();
        homeListActivity.f3365c = this.f3921c.get();
    }
}
