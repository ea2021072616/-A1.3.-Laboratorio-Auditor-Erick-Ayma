package com.fotoable.youtube.music.c.b;

import com.fotoable.youtube.music.base.BaseActivity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* compiled from: ActivityModule_ActivityFactory.java */
/* loaded from: classes.dex */
public final class b implements Factory<BaseActivity> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2398a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2399b;

    static {
        f2398a = !b.class.desiredAssertionStatus();
    }

    public b(a aVar) {
        if (!f2398a && aVar == null) {
            throw new AssertionError();
        }
        this.f2399b = aVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public BaseActivity get() {
        return (BaseActivity) Preconditions.checkNotNull(this.f2399b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<BaseActivity> a(a aVar) {
        return new b(aVar);
    }
}
