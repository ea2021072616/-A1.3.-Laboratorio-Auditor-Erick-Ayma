package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: LocalMusicFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class ah implements MembersInjector<LocalMusicFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4771a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4772b;

    static {
        f4771a = !ah.class.desiredAssertionStatus();
    }

    public ah(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f4771a && provider == null) {
            throw new AssertionError();
        }
        this.f4772b = provider;
    }

    public static MembersInjector<LocalMusicFragment> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new ah(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(LocalMusicFragment localMusicFragment) {
        if (localMusicFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        localMusicFragment.f4629b = this.f4772b.get();
    }
}
