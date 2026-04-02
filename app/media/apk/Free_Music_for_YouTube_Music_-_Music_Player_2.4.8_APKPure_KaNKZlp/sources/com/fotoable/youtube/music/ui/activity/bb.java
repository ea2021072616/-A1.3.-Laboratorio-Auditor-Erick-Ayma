package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: PlayerActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class bb implements MembersInjector<PlayerActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3965a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f3966b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f3967c;

    static {
        f3965a = !bb.class.desiredAssertionStatus();
    }

    public bb(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.b.c> provider2) {
        if (!f3965a && provider == null) {
            throw new AssertionError();
        }
        this.f3966b = provider;
        if (!f3965a && provider2 == null) {
            throw new AssertionError();
        }
        this.f3967c = provider2;
    }

    public static MembersInjector<PlayerActivity> a(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.b.c> provider2) {
        return new bb(provider, provider2);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(PlayerActivity playerActivity) {
        if (playerActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        playerActivity.f3673a = this.f3966b.get();
        playerActivity.e = this.f3967c.get();
    }
}
