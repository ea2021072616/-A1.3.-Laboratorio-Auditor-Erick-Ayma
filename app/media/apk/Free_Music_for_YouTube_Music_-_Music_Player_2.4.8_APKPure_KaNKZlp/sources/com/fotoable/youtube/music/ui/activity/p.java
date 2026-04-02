package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: CommunityPostDetailActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class p implements MembersInjector<CommunityPostDetailActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4007a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4008b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f4009c;

    static {
        f4007a = !p.class.desiredAssertionStatus();
    }

    public p(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.b.c> provider2) {
        if (!f4007a && provider == null) {
            throw new AssertionError();
        }
        this.f4008b = provider;
        if (!f4007a && provider2 == null) {
            throw new AssertionError();
        }
        this.f4009c = provider2;
    }

    public static MembersInjector<CommunityPostDetailActivity> a(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.b.c> provider2) {
        return new p(provider, provider2);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(CommunityPostDetailActivity communityPostDetailActivity) {
        if (communityPostDetailActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        communityPostDetailActivity.w = this.f4008b.get();
        communityPostDetailActivity.x = this.f4009c.get();
    }
}
