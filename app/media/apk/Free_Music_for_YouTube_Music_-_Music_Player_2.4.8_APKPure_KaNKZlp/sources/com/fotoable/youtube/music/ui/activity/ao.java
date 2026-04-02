package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: MusicRecognitionHistoryActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class ao implements MembersInjector<MusicRecognitionHistoryActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3938a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f3939b;

    static {
        f3938a = !ao.class.desiredAssertionStatus();
    }

    public ao(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f3938a && provider == null) {
            throw new AssertionError();
        }
        this.f3939b = provider;
    }

    public static MembersInjector<MusicRecognitionHistoryActivity> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new ao(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(MusicRecognitionHistoryActivity musicRecognitionHistoryActivity) {
        if (musicRecognitionHistoryActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        musicRecognitionHistoryActivity.f3553a = this.f3939b.get();
    }
}
