package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: UserInfoActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class bm implements MembersInjector<UserInfoActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3983a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f3984b;

    static {
        f3983a = !bm.class.desiredAssertionStatus();
    }

    public bm(Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f3983a && provider == null) {
            throw new AssertionError();
        }
        this.f3984b = provider;
    }

    public static MembersInjector<UserInfoActivity> a(Provider<com.fotoable.youtube.music.b.c> provider) {
        return new bm(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(UserInfoActivity userInfoActivity) {
        if (userInfoActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        userInfoActivity.f3860a = this.f3984b.get();
    }
}
