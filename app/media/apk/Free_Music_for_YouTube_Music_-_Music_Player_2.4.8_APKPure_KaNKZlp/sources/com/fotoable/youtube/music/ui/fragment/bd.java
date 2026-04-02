package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: SearchAlbumsFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class bd implements MembersInjector<SearchAlbumsFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4803a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4804b;

    static {
        f4803a = !bd.class.desiredAssertionStatus();
    }

    public bd(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f4803a && provider == null) {
            throw new AssertionError();
        }
        this.f4804b = provider;
    }

    public static MembersInjector<SearchAlbumsFragment> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new bd(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(SearchAlbumsFragment searchAlbumsFragment) {
        if (searchAlbumsFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        searchAlbumsFragment.f4729b = this.f4804b.get();
    }
}
