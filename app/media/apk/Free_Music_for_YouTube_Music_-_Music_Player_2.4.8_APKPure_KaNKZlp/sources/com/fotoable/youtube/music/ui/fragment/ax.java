package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: PlayListFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class ax implements MembersInjector<PlayListFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4791a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f4792b;

    static {
        f4791a = !ax.class.desiredAssertionStatus();
    }

    public ax(Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f4791a && provider == null) {
            throw new AssertionError();
        }
        this.f4792b = provider;
    }

    public static MembersInjector<PlayListFragment> a(Provider<com.fotoable.youtube.music.b.c> provider) {
        return new ax(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(PlayListFragment playListFragment) {
        if (playListFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        playListFragment.f4676b = this.f4792b.get();
    }
}
