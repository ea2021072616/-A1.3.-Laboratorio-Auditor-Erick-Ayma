package com.fotoable.youtube.music.c.b;

import com.fotoable.youtube.music.base.BaseActivity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* compiled from: FragmentModule_ActivityFactory.java */
/* loaded from: classes.dex */
public final class aa implements Factory<BaseActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2386a;

    /* renamed from: b  reason: collision with root package name */
    private final z f2387b;

    static {
        f2386a = !aa.class.desiredAssertionStatus();
    }

    public aa(z zVar) {
        if (!f2386a && zVar == null) {
            throw new AssertionError();
        }
        this.f2387b = zVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public BaseActivity get() {
        return (BaseActivity) Preconditions.checkNotNull(this.f2387b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<BaseActivity> a(z zVar) {
        return new aa(zVar);
    }
}
