package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: ClassifiedMusicDetailsActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class d implements MembersInjector<ClassifiedMusicDetailsActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3993a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.d.d> f3994b;

    static {
        f3993a = !d.class.desiredAssertionStatus();
    }

    public d(Provider<com.fotoable.youtube.music.d.d> provider) {
        if (!f3993a && provider == null) {
            throw new AssertionError();
        }
        this.f3994b = provider;
    }

    public static MembersInjector<ClassifiedMusicDetailsActivity> a(Provider<com.fotoable.youtube.music.d.d> provider) {
        return new d(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(ClassifiedMusicDetailsActivity classifiedMusicDetailsActivity) {
        if (classifiedMusicDetailsActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        classifiedMusicDetailsActivity.f3196a = this.f3994b.get();
    }
}
