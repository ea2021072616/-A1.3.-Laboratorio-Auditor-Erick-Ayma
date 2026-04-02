package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: MyPlaylistDetailActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class au implements MembersInjector<MyPlaylistDetailActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3949a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f3950b;

    static {
        f3949a = !au.class.desiredAssertionStatus();
    }

    public au(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f3949a && provider == null) {
            throw new AssertionError();
        }
        this.f3950b = provider;
    }

    public static MembersInjector<MyPlaylistDetailActivity> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new au(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(MyPlaylistDetailActivity myPlaylistDetailActivity) {
        if (myPlaylistDetailActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        myPlaylistDetailActivity.f3586a = this.f3950b.get();
    }
}
