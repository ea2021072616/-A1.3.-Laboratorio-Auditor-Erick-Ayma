package com.fotoable.youtube.music.locker.view;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: MusicLockerView_MembersInjector.java */
/* loaded from: classes.dex */
public final class d implements MembersInjector<MusicLockerView> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2821a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f2822b;

    static {
        f2821a = !d.class.desiredAssertionStatus();
    }

    public d(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f2821a && provider == null) {
            throw new AssertionError();
        }
        this.f2822b = provider;
    }

    public static MembersInjector<MusicLockerView> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new d(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(MusicLockerView musicLockerView) {
        if (musicLockerView == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        musicLockerView.f2782a = this.f2822b.get();
    }
}
