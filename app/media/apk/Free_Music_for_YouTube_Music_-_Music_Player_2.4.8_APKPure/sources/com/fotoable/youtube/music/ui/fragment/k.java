package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: GenresFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class k implements MembersInjector<GenresFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4832a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.d.p> f4833b;

    static {
        f4832a = !k.class.desiredAssertionStatus();
    }

    public k(Provider<com.fotoable.youtube.music.d.p> provider) {
        if (!f4832a && provider == null) {
            throw new AssertionError();
        }
        this.f4833b = provider;
    }

    public static MembersInjector<GenresFragment> a(Provider<com.fotoable.youtube.music.d.p> provider) {
        return new k(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(GenresFragment genresFragment) {
        if (genresFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        genresFragment.f4569b = this.f4833b.get();
    }
}
