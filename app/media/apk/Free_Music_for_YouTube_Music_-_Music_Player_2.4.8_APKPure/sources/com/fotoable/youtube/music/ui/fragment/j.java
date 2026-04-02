package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: FeaturedFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class j implements MembersInjector<FeaturedFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4829a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f4830b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4831c;

    static {
        f4829a = !j.class.desiredAssertionStatus();
    }

    public j(Provider<com.fotoable.youtube.music.b.c> provider, Provider<com.fotoable.youtube.music.db.a> provider2) {
        if (!f4829a && provider == null) {
            throw new AssertionError();
        }
        this.f4830b = provider;
        if (!f4829a && provider2 == null) {
            throw new AssertionError();
        }
        this.f4831c = provider2;
    }

    public static MembersInjector<FeaturedFragment> a(Provider<com.fotoable.youtube.music.b.c> provider, Provider<com.fotoable.youtube.music.db.a> provider2) {
        return new j(provider, provider2);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(FeaturedFragment featuredFragment) {
        if (featuredFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        featuredFragment.f4542c = this.f4830b.get();
        featuredFragment.d = this.f4831c.get();
    }
}
