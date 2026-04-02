package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: PlayListDetailsActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class ba implements MembersInjector<PlayListDetailsActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3962a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.e> f3963b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f3964c;
    private final Provider<com.fotoable.youtube.music.b.c> d;

    static {
        f3962a = !ba.class.desiredAssertionStatus();
    }

    public ba(Provider<com.fotoable.youtube.music.b.e> provider, Provider<com.fotoable.youtube.music.db.a> provider2, Provider<com.fotoable.youtube.music.b.c> provider3) {
        if (!f3962a && provider == null) {
            throw new AssertionError();
        }
        this.f3963b = provider;
        if (!f3962a && provider2 == null) {
            throw new AssertionError();
        }
        this.f3964c = provider2;
        if (!f3962a && provider3 == null) {
            throw new AssertionError();
        }
        this.d = provider3;
    }

    public static MembersInjector<PlayListDetailsActivity> a(Provider<com.fotoable.youtube.music.b.e> provider, Provider<com.fotoable.youtube.music.db.a> provider2, Provider<com.fotoable.youtube.music.b.c> provider3) {
        return new ba(provider, provider2, provider3);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(PlayListDetailsActivity playListDetailsActivity) {
        if (playListDetailsActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        playListDetailsActivity.f3628b = this.f3963b.get();
        playListDetailsActivity.f3629c = this.f3964c.get();
        playListDetailsActivity.d = this.d.get();
    }
}
