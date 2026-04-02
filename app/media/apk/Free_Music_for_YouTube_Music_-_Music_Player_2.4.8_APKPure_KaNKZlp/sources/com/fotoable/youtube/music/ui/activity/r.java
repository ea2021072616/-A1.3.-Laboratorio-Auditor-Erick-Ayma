package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: CountryActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class r implements MembersInjector<CountryActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4012a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f4013b;

    static {
        f4012a = !r.class.desiredAssertionStatus();
    }

    public r(Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f4012a && provider == null) {
            throw new AssertionError();
        }
        this.f4013b = provider;
    }

    public static MembersInjector<CountryActivity> a(Provider<com.fotoable.youtube.music.b.c> provider) {
        return new r(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(CountryActivity countryActivity) {
        if (countryActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        countryActivity.f3283a = this.f4013b.get();
    }
}
