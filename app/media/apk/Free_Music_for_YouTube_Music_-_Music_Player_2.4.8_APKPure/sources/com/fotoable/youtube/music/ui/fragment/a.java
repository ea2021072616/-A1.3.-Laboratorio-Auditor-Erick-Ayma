package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: ArtistsFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class a implements MembersInjector<ArtistsFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4761a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.d.a> f4762b;

    static {
        f4761a = !a.class.desiredAssertionStatus();
    }

    public a(Provider<com.fotoable.youtube.music.d.a> provider) {
        if (!f4761a && provider == null) {
            throw new AssertionError();
        }
        this.f4762b = provider;
    }

    public static MembersInjector<ArtistsFragment> a(Provider<com.fotoable.youtube.music.d.a> provider) {
        return new a(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(ArtistsFragment artistsFragment) {
        if (artistsFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        artistsFragment.f4481b = this.f4762b.get();
    }
}
