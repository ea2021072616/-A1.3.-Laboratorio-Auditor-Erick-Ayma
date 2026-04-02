package com.fotoable.youtube.music.service;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: MainService_MembersInjector.java */
/* loaded from: classes.dex */
public final class a implements MembersInjector<MainService> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3164a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f3165b;

    static {
        f3164a = !a.class.desiredAssertionStatus();
    }

    public a(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f3164a && provider == null) {
            throw new AssertionError();
        }
        this.f3165b = provider;
    }

    public static MembersInjector<MainService> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new a(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(MainService mainService) {
        if (mainService == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        mainService.f3157a = this.f3165b.get();
    }
}
