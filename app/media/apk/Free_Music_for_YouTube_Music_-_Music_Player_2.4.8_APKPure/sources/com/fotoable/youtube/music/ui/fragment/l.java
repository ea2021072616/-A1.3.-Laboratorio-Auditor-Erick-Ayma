package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: GlobalMusicFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class l implements MembersInjector<GlobalMusicFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4834a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.d.w> f4835b;

    static {
        f4834a = !l.class.desiredAssertionStatus();
    }

    public l(Provider<com.fotoable.youtube.music.d.w> provider) {
        if (!f4834a && provider == null) {
            throw new AssertionError();
        }
        this.f4835b = provider;
    }

    public static MembersInjector<GlobalMusicFragment> a(Provider<com.fotoable.youtube.music.d.w> provider) {
        return new l(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(GlobalMusicFragment globalMusicFragment) {
        if (globalMusicFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        globalMusicFragment.f4577b = this.f4835b.get();
    }
}
