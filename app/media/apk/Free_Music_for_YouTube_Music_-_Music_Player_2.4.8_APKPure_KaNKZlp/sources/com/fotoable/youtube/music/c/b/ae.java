package com.fotoable.youtube.music.c.b;

import android.app.Service;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
/* compiled from: ServiceModule_ProvideServiceFactory.java */
/* loaded from: classes.dex */
public final class ae implements Factory<Service> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2393a;

    /* renamed from: b  reason: collision with root package name */
    private final ac f2394b;

    static {
        f2393a = !ae.class.desiredAssertionStatus();
    }

    public ae(ac acVar) {
        if (!f2393a && acVar == null) {
            throw new AssertionError();
        }
        this.f2394b = acVar;
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public Service get() {
        return (Service) Preconditions.checkNotNull(this.f2394b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Service> a(ac acVar) {
        return new ae(acVar);
    }
}
