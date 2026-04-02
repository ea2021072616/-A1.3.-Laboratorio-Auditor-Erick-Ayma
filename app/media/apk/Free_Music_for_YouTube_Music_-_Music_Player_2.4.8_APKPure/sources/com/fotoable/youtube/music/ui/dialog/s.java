package com.fotoable.youtube.music.ui.dialog;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: MusicMenuDialog_MembersInjector.java */
/* loaded from: classes.dex */
public final class s implements MembersInjector<MusicMenuDialog> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4472a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f4473b;

    static {
        f4472a = !s.class.desiredAssertionStatus();
    }

    public s(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f4472a && provider == null) {
            throw new AssertionError();
        }
        this.f4473b = provider;
    }

    public static MembersInjector<MusicMenuDialog> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new s(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(MusicMenuDialog musicMenuDialog) {
        if (musicMenuDialog == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        musicMenuDialog.f4201b = this.f4473b.get();
    }
}
