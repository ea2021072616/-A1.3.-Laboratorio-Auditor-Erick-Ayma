package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: FeaturedPlayListDetailsActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class y implements MembersInjector<FeaturedPlayListDetailsActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4022a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4023b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f4024c;

    static {
        f4022a = !y.class.desiredAssertionStatus();
    }

    public y(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.b.c> provider2) {
        if (!f4022a && provider == null) {
            throw new AssertionError();
        }
        this.f4023b = provider;
        if (!f4022a && provider2 == null) {
            throw new AssertionError();
        }
        this.f4024c = provider2;
    }

    public static MembersInjector<FeaturedPlayListDetailsActivity> a(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.b.c> provider2) {
        return new y(provider, provider2);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(FeaturedPlayListDetailsActivity featuredPlayListDetailsActivity) {
        if (featuredPlayListDetailsActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        featuredPlayListDetailsActivity.f3305b = this.f4023b.get();
        featuredPlayListDetailsActivity.f3306c = this.f4024c.get();
    }
}
