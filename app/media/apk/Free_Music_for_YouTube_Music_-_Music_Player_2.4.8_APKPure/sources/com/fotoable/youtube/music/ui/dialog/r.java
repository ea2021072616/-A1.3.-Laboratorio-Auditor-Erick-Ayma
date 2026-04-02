package com.fotoable.youtube.music.ui.dialog;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: LocalMusicMenuDialog_MembersInjector.java */
/* loaded from: classes.dex */
public final class r implements MembersInjector<LocalMusicMenuDialog> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4470a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4471b;

    static {
        f4470a = !r.class.desiredAssertionStatus();
    }

    public r(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f4470a && provider == null) {
            throw new AssertionError();
        }
        this.f4471b = provider;
    }

    public static MembersInjector<LocalMusicMenuDialog> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new r(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(LocalMusicMenuDialog localMusicMenuDialog) {
        if (localMusicMenuDialog == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        localMusicMenuDialog.f4146b = this.f4471b.get();
    }
}
