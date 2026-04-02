package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: SearchArtistsFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class be implements MembersInjector<SearchArtistsFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4805a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4806b;

    static {
        f4805a = !be.class.desiredAssertionStatus();
    }

    public be(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f4805a && provider == null) {
            throw new AssertionError();
        }
        this.f4806b = provider;
    }

    public static MembersInjector<SearchArtistsFragment> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new be(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(SearchArtistsFragment searchArtistsFragment) {
        if (searchArtistsFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        searchArtistsFragment.f4731b = this.f4806b.get();
    }
}
