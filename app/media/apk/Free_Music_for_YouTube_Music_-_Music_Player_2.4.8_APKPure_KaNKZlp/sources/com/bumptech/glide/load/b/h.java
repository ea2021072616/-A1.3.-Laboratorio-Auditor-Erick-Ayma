package com.bumptech.glide.load.b;

import android.os.Looper;
/* compiled from: EngineResource.java */
/* loaded from: classes.dex */
class h<Z> implements k<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final k<Z> f849a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f850b;

    /* renamed from: c  reason: collision with root package name */
    private a f851c;
    private com.bumptech.glide.load.c d;
    private int e;
    private boolean f;

    /* compiled from: EngineResource.java */
    /* loaded from: classes.dex */
    interface a {
        void b(com.bumptech.glide.load.c cVar, h<?> hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(k<Z> kVar, boolean z) {
        if (kVar == null) {
            throw new NullPointerException("Wrapped resource must not be null");
        }
        this.f849a = kVar;
        this.f850b = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bumptech.glide.load.c cVar, a aVar) {
        this.d = cVar;
        this.f851c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f850b;
    }

    @Override // com.bumptech.glide.load.b.k
    public Z b() {
        return this.f849a.b();
    }

    @Override // com.bumptech.glide.load.b.k
    public int c() {
        return this.f849a.c();
    }

    @Override // com.bumptech.glide.load.b.k
    public void d() {
        if (this.e > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f = true;
        this.f849a.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        this.e++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        int i = this.e - 1;
        this.e = i;
        if (i == 0) {
            this.f851c.b(this.d, this);
        }
    }
}
