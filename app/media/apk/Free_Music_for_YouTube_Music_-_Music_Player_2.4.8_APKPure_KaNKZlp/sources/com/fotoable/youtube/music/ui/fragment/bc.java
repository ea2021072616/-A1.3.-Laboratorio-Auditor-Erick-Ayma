package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: RankFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class bc implements MembersInjector<RankFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4801a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f4802b;

    static {
        f4801a = !bc.class.desiredAssertionStatus();
    }

    public bc(Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f4801a && provider == null) {
            throw new AssertionError();
        }
        this.f4802b = provider;
    }

    public static MembersInjector<RankFragment> a(Provider<com.fotoable.youtube.music.b.c> provider) {
        return new bc(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(RankFragment rankFragment) {
        if (rankFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        rankFragment.f4719b = this.f4802b.get();
    }
}
