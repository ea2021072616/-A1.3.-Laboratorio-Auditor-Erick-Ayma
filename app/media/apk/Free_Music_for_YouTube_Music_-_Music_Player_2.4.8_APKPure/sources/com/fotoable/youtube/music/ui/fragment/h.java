package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: CommunityFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class h implements MembersInjector<CommunityFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4824a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.d.l> f4825b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4826c;
    private final Provider<com.fotoable.youtube.music.b.c> d;

    static {
        f4824a = !h.class.desiredAssertionStatus();
    }

    public h(Provider<com.fotoable.youtube.music.d.l> provider, Provider<com.fotoable.youtube.music.db.a> provider2, Provider<com.fotoable.youtube.music.b.c> provider3) {
        if (!f4824a && provider == null) {
            throw new AssertionError();
        }
        this.f4825b = provider;
        if (!f4824a && provider2 == null) {
            throw new AssertionError();
        }
        this.f4826c = provider2;
        if (!f4824a && provider3 == null) {
            throw new AssertionError();
        }
        this.d = provider3;
    }

    public static MembersInjector<CommunityFragment> a(Provider<com.fotoable.youtube.music.d.l> provider, Provider<com.fotoable.youtube.music.db.a> provider2, Provider<com.fotoable.youtube.music.b.c> provider3) {
        return new h(provider, provider2, provider3);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(CommunityFragment communityFragment) {
        if (communityFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        communityFragment.f4506b = this.f4825b.get();
        communityFragment.f4507c = this.f4826c.get();
        communityFragment.d = this.d.get();
    }
}
