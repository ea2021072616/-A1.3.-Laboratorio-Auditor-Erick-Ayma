package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: SearchPlayListFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class bf implements MembersInjector<SearchPlayListFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4807a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.e> f4808b;

    static {
        f4807a = !bf.class.desiredAssertionStatus();
    }

    public bf(Provider<com.fotoable.youtube.music.b.e> provider) {
        if (!f4807a && provider == null) {
            throw new AssertionError();
        }
        this.f4808b = provider;
    }

    public static MembersInjector<SearchPlayListFragment> a(Provider<com.fotoable.youtube.music.b.e> provider) {
        return new bf(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(SearchPlayListFragment searchPlayListFragment) {
        if (searchPlayListFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        searchPlayListFragment.f4733b = this.f4808b.get();
    }
}
