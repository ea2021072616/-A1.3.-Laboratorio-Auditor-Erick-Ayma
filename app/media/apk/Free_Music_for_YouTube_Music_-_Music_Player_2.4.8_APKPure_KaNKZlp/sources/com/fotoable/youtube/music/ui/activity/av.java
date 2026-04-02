package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: MyRecentlyWatchedActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class av implements MembersInjector<MyRecentlyWatchedActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3951a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f3952b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.d.ag> f3953c;

    static {
        f3951a = !av.class.desiredAssertionStatus();
    }

    public av(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.d.ag> provider2) {
        if (!f3951a && provider == null) {
            throw new AssertionError();
        }
        this.f3952b = provider;
        if (!f3951a && provider2 == null) {
            throw new AssertionError();
        }
        this.f3953c = provider2;
    }

    public static MembersInjector<MyRecentlyWatchedActivity> a(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.d.ag> provider2) {
        return new av(provider, provider2);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(MyRecentlyWatchedActivity myRecentlyWatchedActivity) {
        if (myRecentlyWatchedActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        myRecentlyWatchedActivity.f3605a = this.f3952b.get();
        myRecentlyWatchedActivity.d = this.f3953c.get();
    }
}
