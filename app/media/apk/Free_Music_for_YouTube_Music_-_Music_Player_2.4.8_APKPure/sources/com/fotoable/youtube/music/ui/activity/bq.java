package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: YoutubeCommentActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class bq implements MembersInjector<YoutubeCommentActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3988a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f3989b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f3990c;

    static {
        f3988a = !bq.class.desiredAssertionStatus();
    }

    public bq(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.b.c> provider2) {
        if (!f3988a && provider == null) {
            throw new AssertionError();
        }
        this.f3989b = provider;
        if (!f3988a && provider2 == null) {
            throw new AssertionError();
        }
        this.f3990c = provider2;
    }

    public static MembersInjector<YoutubeCommentActivity> a(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.b.c> provider2) {
        return new bq(provider, provider2);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(YoutubeCommentActivity youtubeCommentActivity) {
        if (youtubeCommentActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        youtubeCommentActivity.f = this.f3989b.get();
        youtubeCommentActivity.g = this.f3990c.get();
    }
}
