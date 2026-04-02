package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: CommunityPostActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class h implements MembersInjector<CommunityPostActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3998a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f3999b;

    static {
        f3998a = !h.class.desiredAssertionStatus();
    }

    public h(Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f3998a && provider == null) {
            throw new AssertionError();
        }
        this.f3999b = provider;
    }

    public static MembersInjector<CommunityPostActivity> a(Provider<com.fotoable.youtube.music.b.c> provider) {
        return new h(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(CommunityPostActivity communityPostActivity) {
        if (communityPostActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        communityPostActivity.f3211a = this.f3999b.get();
    }
}
