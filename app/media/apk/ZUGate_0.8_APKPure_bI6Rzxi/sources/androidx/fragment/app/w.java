package androidx.fragment.app;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final class w extends z {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k.a f1020a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f1021b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b.a f1022c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ androidx.activity.result.c f1023d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Fragment f1024e;

    public w(Fragment fragment, k.a aVar, AtomicReference atomicReference, b.a aVar2, androidx.activity.result.c cVar) {
        this.f1024e = fragment;
        this.f1020a = aVar;
        this.f1021b = atomicReference;
        this.f1022c = aVar2;
        this.f1023d = cVar;
    }

    @Override // androidx.fragment.app.z
    public final void a() {
        Fragment fragment = this.f1024e;
        this.f1021b.set(((androidx.activity.result.h) this.f1020a.a(null)).c(fragment.generateActivityResultKey(), fragment, this.f1022c, this.f1023d));
    }
}
