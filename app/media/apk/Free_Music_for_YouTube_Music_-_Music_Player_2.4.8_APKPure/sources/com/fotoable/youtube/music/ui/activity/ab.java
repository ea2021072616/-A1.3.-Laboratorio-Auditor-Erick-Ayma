package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: GlobalMusicDetailsActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class ab implements MembersInjector<GlobalMusicDetailsActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3915a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.d.r> f3916b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f3917c;

    static {
        f3915a = !ab.class.desiredAssertionStatus();
    }

    public ab(Provider<com.fotoable.youtube.music.d.r> provider, Provider<com.fotoable.youtube.music.b.c> provider2) {
        if (!f3915a && provider == null) {
            throw new AssertionError();
        }
        this.f3916b = provider;
        if (!f3915a && provider2 == null) {
            throw new AssertionError();
        }
        this.f3917c = provider2;
    }

    public static MembersInjector<GlobalMusicDetailsActivity> a(Provider<com.fotoable.youtube.music.d.r> provider, Provider<com.fotoable.youtube.music.b.c> provider2) {
        return new ab(provider, provider2);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(GlobalMusicDetailsActivity globalMusicDetailsActivity) {
        if (globalMusicDetailsActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        globalMusicDetailsActivity.f3343a = this.f3916b.get();
        globalMusicDetailsActivity.f3344b = this.f3917c.get();
    }
}
