package com.fotoable.youtube.music.ui.activity;

import dagger.MembersInjector;
import javax.inject.Provider;
/* compiled from: MySubscriptionActivity_MembersInjector.java */
/* loaded from: classes.dex */
public final class aw implements MembersInjector<MySubscriptionActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3954a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.db.a> f3955b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<com.fotoable.youtube.music.d.al> f3956c;

    static {
        f3954a = !aw.class.desiredAssertionStatus();
    }

    public aw(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.d.al> provider2) {
        if (!f3954a && provider == null) {
            throw new AssertionError();
        }
        this.f3955b = provider;
        if (!f3954a && provider2 == null) {
            throw new AssertionError();
        }
        this.f3956c = provider2;
    }

    public static MembersInjector<MySubscriptionActivity> a(Provider<com.fotoable.youtube.music.db.a> provider, Provider<com.fotoable.youtube.music.d.al> provider2) {
        return new aw(provider, provider2);
    }

    @Override // dagger.MembersInjector
    /* renamed from: a */
    public void injectMembers(MySubscriptionActivity mySubscriptionActivity) {
        if (mySubscriptionActivity == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        mySubscriptionActivity.f3619a = this.f3955b.get();
        mySubscriptionActivity.f3621c = this.f3956c.get();
    }
}
