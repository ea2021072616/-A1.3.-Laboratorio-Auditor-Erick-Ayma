package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: MyMusicFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class at implements MembersInjector<MyMusicFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4786a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4787b;

    static {
        f4786a = !at.class.desiredAssertionStatus();
    }

    public at(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f4786a && provider == null) {
            throw new AssertionError();
        }
        this.f4787b = provider;
    }

    public static MembersInjector<MyMusicFragment> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new at(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(MyMusicFragment myMusicFragment) {
        if (myMusicFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        myMusicFragment.f4658b = this.f4787b.get();
    }
}
