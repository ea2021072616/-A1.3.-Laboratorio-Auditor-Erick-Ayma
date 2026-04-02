package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: SearchActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class bf implements MembersInjector<SearchActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3973a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f3974b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.a> f3975c;
    private final Provider<com.fotoable.youtube.music.b.e> d;

    static {
        f3973a = !bf.class.desiredAssertionStatus();
    }

    public bf(Provider<com.fotoable.youtube.music.b.c> provider, Provider<com.fotoable.youtube.music.b.a> provider2, Provider<com.fotoable.youtube.music.b.e> provider3) {
        if (!f3973a && provider == null) {
            throw new AssertionError();
        }
        this.f3974b = provider;
        if (!f3973a && provider2 == null) {
            throw new AssertionError();
        }
        this.f3975c = provider2;
        if (!f3973a && provider3 == null) {
            throw new AssertionError();
        }
        this.d = provider3;
    }

    public static MembersInjector<SearchActivity> a(Provider<com.fotoable.youtube.music.b.c> provider, Provider<com.fotoable.youtube.music.b.a> provider2, Provider<com.fotoable.youtube.music.b.e> provider3) {
        return new bf(provider, provider2, provider3);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(SearchActivity searchActivity) {
        if (searchActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        searchActivity.f3761b = this.f3974b.get();
        searchActivity.f3762c = this.f3975c.get();
        searchActivity.d = this.d.get();
    }
}
