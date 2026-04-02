package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: RadioFragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class az implements MembersInjector<RadioFragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4795a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f4796b;

    static {
        f4795a = !az.class.desiredAssertionStatus();
    }

    public az(Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f4795a && provider == null) {
            throw new AssertionError();
        }
        this.f4796b = provider;
    }

    public static MembersInjector<RadioFragment> a(Provider<com.fotoable.youtube.music.b.c> provider) {
        return new az(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(RadioFragment radioFragment) {
        if (radioFragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        radioFragment.f4698b = this.f4796b.get();
    }
}
