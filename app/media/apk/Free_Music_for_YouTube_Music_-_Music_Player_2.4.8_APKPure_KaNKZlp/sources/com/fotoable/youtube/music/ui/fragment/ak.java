package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: LocalPlayListFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class ak implements MembersInjector<LocalPlayListFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4775a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4776b;

    static {
        f4775a = !ak.class.desiredAssertionStatus();
    }

    public ak(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f4775a && provider == null) {
            throw new AssertionError();
        }
        this.f4776b = provider;
    }

    public static MembersInjector<LocalPlayListFragment> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new ak(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(LocalPlayListFragment localPlayListFragment) {
        if (localPlayListFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        localPlayListFragment.f4639b = this.f4776b.get();
    }
}
