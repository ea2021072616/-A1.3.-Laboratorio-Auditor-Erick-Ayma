package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: MyFavoriteActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class ar implements MembersInjector<MyFavoriteActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3942a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f3943b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.d.ad> f3944c;

    static {
        f3942a = !ar.class.desiredAssertionStatus();
    }

    public ar(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.d.ad> provider2) {
        if (!f3942a && provider == null) {
            throw new AssertionError();
        }
        this.f3943b = provider;
        if (!f3942a && provider2 == null) {
            throw new AssertionError();
        }
        this.f3944c = provider2;
    }

    public static MembersInjector<MyFavoriteActivity> a(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.d.ad> provider2) {
        return new ar(provider, provider2);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(MyFavoriteActivity myFavoriteActivity) {
        if (myFavoriteActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        myFavoriteActivity.f3564a = this.f3943b.get();
        myFavoriteActivity.f = this.f3944c.get();
    }
}
