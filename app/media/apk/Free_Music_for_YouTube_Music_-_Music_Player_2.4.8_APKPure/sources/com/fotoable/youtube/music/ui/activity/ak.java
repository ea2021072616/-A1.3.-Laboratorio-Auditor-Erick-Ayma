package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: LocalPlayListDetailActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class ak implements MembersInjector<LocalPlayListDetailActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3930a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f3931b;

    static {
        f3930a = !ak.class.desiredAssertionStatus();
    }

    public ak(Provider<com.fotoable.youtube.music.db.a> provider) {
        if (!f3930a && provider == null) {
            throw new AssertionError();
        }
        this.f3931b = provider;
    }

    public static MembersInjector<LocalPlayListDetailActivity> a(Provider<com.fotoable.youtube.music.db.a> provider) {
        return new ak(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(LocalPlayListDetailActivity localPlayListDetailActivity) {
        if (localPlayListDetailActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        localPlayListDetailActivity.f3441a = this.f3931b.get();
    }
}
