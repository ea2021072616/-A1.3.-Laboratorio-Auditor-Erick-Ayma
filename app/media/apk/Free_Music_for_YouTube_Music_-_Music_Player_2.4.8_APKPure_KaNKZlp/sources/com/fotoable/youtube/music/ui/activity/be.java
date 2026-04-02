package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: RadioListActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class be implements MembersInjector<RadioListActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3971a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f3972b;

    static {
        f3971a = !be.class.desiredAssertionStatus();
    }

    public be(Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f3971a && provider == null) {
            throw new AssertionError();
        }
        this.f3972b = provider;
    }

    public static MembersInjector<RadioListActivity> a(Provider<com.fotoable.youtube.music.b.c> provider) {
        return new be(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(RadioListActivity radioListActivity) {
        if (radioListActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        radioListActivity.f3750b = this.f3972b.get();
    }
}
