package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: LocalCreatedPlaylistDetailActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class ai implements MembersInjector<LocalCreatedPlaylistDetailActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3927a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f3928b;

    static {
        f3927a = !ai.class.desiredAssertionStatus();
    }

    public ai(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f3927a && provider == null) {
            throw new AssertionError();
        }
        this.f3928b = provider;
    }

    public static MembersInjector<LocalCreatedPlaylistDetailActivity> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new ai(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(LocalCreatedPlaylistDetailActivity localCreatedPlaylistDetailActivity) {
        if (localCreatedPlaylistDetailActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        localCreatedPlaylistDetailActivity.f3416a = this.f3928b.get();
    }
}
