package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: MusicRecognitionActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class an implements MembersInjector<MusicRecognitionActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3935a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.e> f3936b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f3937c;

    static {
        f3935a = !an.class.desiredAssertionStatus();
    }

    public an(Provider<com.fotoable.youtube.music.b.e> provider, Provider<com.fotoable.youtube.music.db.a> provider2) {
        if (!f3935a && provider == null) {
            throw new AssertionError();
        }
        this.f3936b = provider;
        if (!f3935a && provider2 == null) {
            throw new AssertionError();
        }
        this.f3937c = provider2;
    }

    public static MembersInjector<MusicRecognitionActivity> a(Provider<com.fotoable.youtube.music.b.e> provider, Provider<com.fotoable.youtube.music.db.a> provider2) {
        return new an(provider, provider2);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(MusicRecognitionActivity musicRecognitionActivity) {
        if (musicRecognitionActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        musicRecognitionActivity.f3519b = this.f3936b.get();
        musicRecognitionActivity.f3520c = this.f3937c.get();
    }
}
