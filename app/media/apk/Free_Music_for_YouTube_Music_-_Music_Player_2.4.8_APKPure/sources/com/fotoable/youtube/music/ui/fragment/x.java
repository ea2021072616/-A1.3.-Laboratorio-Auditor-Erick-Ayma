package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: LocalArtistsFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class x implements MembersInjector<LocalArtistsFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4847a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4848b;

    static {
        f4847a = !x.class.desiredAssertionStatus();
    }

    public x(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f4847a && provider == null) {
            throw new AssertionError();
        }
        this.f4848b = provider;
    }

    public static MembersInjector<LocalArtistsFragment> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new x(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(LocalArtistsFragment localArtistsFragment) {
        if (localArtistsFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        localArtistsFragment.f4604b = this.f4848b.get();
    }
}
