package com.fotoable.youtube.music.ui.fragment;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: Top100Fragment_MembersInjector.java */
/* loaded from: classes.dex */
public final class bj implements MembersInjector<Top100Fragment> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4814a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f4815b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.d.as> f4816c;

    static {
        f4814a = !bj.class.desiredAssertionStatus();
    }

    public bj(Provider<com.fotoable.youtube.music.b.c> provider, Provider<com.fotoable.youtube.music.d.as> provider2) {
        if (!f4814a && provider == null) {
            throw new AssertionError();
        }
        this.f4815b = provider;
        if (!f4814a && provider2 == null) {
            throw new AssertionError();
        }
        this.f4816c = provider2;
    }

    public static MembersInjector<Top100Fragment> a(Provider<com.fotoable.youtube.music.b.c> provider, Provider<com.fotoable.youtube.music.d.as> provider2) {
        return new bj(provider, provider2);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(Top100Fragment top100Fragment) {
        if (top100Fragment == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        top100Fragment.f4750b = this.f4815b.get();
        top100Fragment.f4751c = this.f4816c.get();
    }
}
