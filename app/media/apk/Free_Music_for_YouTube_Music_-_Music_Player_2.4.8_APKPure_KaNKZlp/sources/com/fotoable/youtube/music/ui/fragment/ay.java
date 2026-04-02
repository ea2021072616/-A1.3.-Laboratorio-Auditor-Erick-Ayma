package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: RadioFavoriteFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class ay implements MembersInjector<RadioFavoriteFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4793a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4794b;

    static {
        f4793a = !ay.class.desiredAssertionStatus();
    }

    public ay(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f4793a && provider == null) {
            throw new AssertionError();
        }
        this.f4794b = provider;
    }

    public static MembersInjector<RadioFavoriteFragment> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new ay(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(RadioFavoriteFragment radioFavoriteFragment) {
        if (radioFavoriteFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        radioFavoriteFragment.f4686b = this.f4794b.get();
    }
}
