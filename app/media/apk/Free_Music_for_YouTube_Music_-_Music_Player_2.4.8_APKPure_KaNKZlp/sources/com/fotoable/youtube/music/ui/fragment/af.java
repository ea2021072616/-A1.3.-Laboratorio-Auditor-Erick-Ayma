package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: LocalFavoriteFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class af implements MembersInjector<LocalFavoriteFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4768a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4769b;

    static {
        f4768a = !af.class.desiredAssertionStatus();
    }

    public af(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f4768a && provider == null) {
            throw new AssertionError();
        }
        this.f4769b = provider;
    }

    public static MembersInjector<LocalFavoriteFragment> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new af(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(LocalFavoriteFragment localFavoriteFragment) {
        if (localFavoriteFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        localFavoriteFragment.f4622b = this.f4769b.get();
    }
}
