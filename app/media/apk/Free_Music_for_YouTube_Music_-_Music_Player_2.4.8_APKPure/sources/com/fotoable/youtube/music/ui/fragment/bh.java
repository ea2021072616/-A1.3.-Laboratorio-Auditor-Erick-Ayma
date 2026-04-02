package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: SearchSongsFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class bh implements MembersInjector<SearchSongsFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4810a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.e> f4811b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4812c;

    static {
        f4810a = !bh.class.desiredAssertionStatus();
    }

    public bh(Provider<com.fotoable.youtube.music.b.e> provider, Provider<com.fotoable.youtube.music.db.a> provider2) {
        if (!f4810a && provider == null) {
            throw new AssertionError();
        }
        this.f4811b = provider;
        if (!f4810a && provider2 == null) {
            throw new AssertionError();
        }
        this.f4812c = provider2;
    }

    public static MembersInjector<SearchSongsFragment> a(Provider<com.fotoable.youtube.music.b.e> provider, Provider<com.fotoable.youtube.music.db.a> provider2) {
        return new bh(provider, provider2);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(SearchSongsFragment searchSongsFragment) {
        if (searchSongsFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        searchSongsFragment.f4740b = this.f4811b.get();
        searchSongsFragment.f4741c = this.f4812c.get();
    }
}
