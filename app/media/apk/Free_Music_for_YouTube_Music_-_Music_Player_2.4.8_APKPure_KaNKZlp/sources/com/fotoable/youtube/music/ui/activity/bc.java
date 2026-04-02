package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: Radio1Activity_MembersInjector.java */
/* loaded from: classes.dex */
public final class bc implements MembersInjector<Radio1Activity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3968a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.b.c> f3969b;

    static {
        f3968a = !bc.class.desiredAssertionStatus();
    }

    public bc(Provider<com.fotoable.youtube.music.b.c> provider) {
        if (!f3968a && provider == null) {
            throw new AssertionError();
        }
        this.f3969b = provider;
    }

    public static MembersInjector<Radio1Activity> a(Provider<com.fotoable.youtube.music.b.c> provider) {
        return new bc(provider);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(Radio1Activity radio1Activity) {
        if (radio1Activity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        radio1Activity.f3722a = this.f3969b.get();
    }
}
