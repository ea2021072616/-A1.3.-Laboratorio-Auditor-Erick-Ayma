package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: ClassifiedMusicFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class c implements MembersInjector<ClassifiedMusicFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4817a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.d.i> f4818b;

    static {
        f4817a = !c.class.desiredAssertionStatus();
    }

    public c(Provider<com.fotoable.youtube.music.d.i> provider) {
        if (!f4817a && provider == null) {
            throw new AssertionError();
        }
        this.f4818b = provider;
    }

    public static MembersInjector<ClassifiedMusicFragment> a(Provider<com.fotoable.youtube.music.d.i> provider) {
        return new c(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(ClassifiedMusicFragment classifiedMusicFragment) {
        if (classifiedMusicFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        classifiedMusicFragment.f4498b = this.f4818b.get();
    }
}
