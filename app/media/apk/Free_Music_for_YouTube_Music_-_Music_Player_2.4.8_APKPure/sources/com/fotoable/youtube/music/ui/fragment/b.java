package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: CategoryPlaylistFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class b implements MembersInjector<CategoryPlaylistFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4797a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f4798b;

    static {
        f4797a = !b.class.desiredAssertionStatus();
    }

    public b(Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f4797a && provider == null) {
            throw new AssertionError();
        }
        this.f4798b = provider;
    }

    public static MembersInjector<CategoryPlaylistFragment> a(Provider<com.fotoable.youtube.music.b.c> provider) {
        return new b(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(CategoryPlaylistFragment categoryPlaylistFragment) {
        if (categoryPlaylistFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        categoryPlaylistFragment.f4491b = this.f4798b.get();
    }
}
