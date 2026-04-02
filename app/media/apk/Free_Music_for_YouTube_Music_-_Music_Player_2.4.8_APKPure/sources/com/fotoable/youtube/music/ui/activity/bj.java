package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: SplashActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class bj implements MembersInjector<SplashActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3979a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f3980b;

    static {
        f3979a = !bj.class.desiredAssertionStatus();
    }

    public bj(Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f3979a && provider == null) {
            throw new AssertionError();
        }
        this.f3980b = provider;
    }

    public static MembersInjector<SplashActivity> a(Provider<com.fotoable.youtube.music.b.c> provider) {
        return new bj(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(SplashActivity splashActivity) {
        if (splashActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        splashActivity.f3835a = this.f3980b.get();
    }
}
