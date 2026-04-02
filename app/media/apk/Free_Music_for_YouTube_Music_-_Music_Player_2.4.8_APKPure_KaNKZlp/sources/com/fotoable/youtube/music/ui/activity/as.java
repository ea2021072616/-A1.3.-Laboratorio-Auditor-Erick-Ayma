package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: MyPlaylistActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class as implements MembersInjector<MyPlaylistActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3945a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f3946b;

    static {
        f3945a = !as.class.desiredAssertionStatus();
    }

    public as(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f3945a && provider == null) {
            throw new AssertionError();
        }
        this.f3946b = provider;
    }

    public static MembersInjector<MyPlaylistActivity> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new as(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(MyPlaylistActivity myPlaylistActivity) {
        if (myPlaylistActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        myPlaylistActivity.f3575a = this.f3946b.get();
    }
}
