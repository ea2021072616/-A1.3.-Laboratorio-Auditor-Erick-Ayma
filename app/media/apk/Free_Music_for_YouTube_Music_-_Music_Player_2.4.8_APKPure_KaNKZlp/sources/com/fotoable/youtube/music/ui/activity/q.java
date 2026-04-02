package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: CommunityPostImagePreviewActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class q implements MembersInjector<CommunityPostImagePreviewActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4010a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f4011b;

    static {
        f4010a = !q.class.desiredAssertionStatus();
    }

    public q(Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f4010a && provider == null) {
            throw new AssertionError();
        }
        this.f4011b = provider;
    }

    public static MembersInjector<CommunityPostImagePreviewActivity> a(Provider<com.fotoable.youtube.music.b.c> provider) {
        return new q(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(CommunityPostImagePreviewActivity communityPostImagePreviewActivity) {
        if (communityPostImagePreviewActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        communityPostImagePreviewActivity.f3271a = this.f4011b.get();
    }
}
