package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: MainActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class am implements MembersInjector<MainActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3933a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f3934b;

    static {
        f3933a = !am.class.desiredAssertionStatus();
    }

    public am(Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f3933a && provider == null) {
            throw new AssertionError();
        }
        this.f3934b = provider;
    }

    public static MembersInjector<MainActivity> a(Provider<com.fotoable.youtube.music.b.c> provider) {
        return new am(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(MainActivity mainActivity) {
        if (mainActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        mainActivity.f3469a = this.f3934b.get();
    }
}
