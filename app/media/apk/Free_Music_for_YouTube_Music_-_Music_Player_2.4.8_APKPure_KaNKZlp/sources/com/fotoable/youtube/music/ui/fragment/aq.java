package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: LocalSongsFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class aq implements MembersInjector<LocalSongsFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4782a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4783b;

    static {
        f4782a = !aq.class.desiredAssertionStatus();
    }

    public aq(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f4782a && provider == null) {
            throw new AssertionError();
        }
        this.f4783b = provider;
    }

    public static MembersInjector<LocalSongsFragment> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new aq(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(LocalSongsFragment localSongsFragment) {
        if (localSongsFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        localSongsFragment.f4646b = this.f4783b.get();
    }
}
