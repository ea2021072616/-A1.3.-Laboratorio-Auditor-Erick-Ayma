package com.bumptech.glide.load.b;

import android.util.Log;
/* compiled from: EngineRunnable.java */
/* loaded from: classes.dex */
class i implements com.bumptech.glide.load.b.c.b, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.k f852a;

    /* renamed from: b  reason: collision with root package name */
    private final a f853b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a<?, ?, ?> f854c;
    private b d = b.CACHE;
    private volatile boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineRunnable.java */
    /* loaded from: classes.dex */
    public interface a extends com.bumptech.glide.g.e {
        void b(i iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EngineRunnable.java */
    /* loaded from: classes.dex */
    public enum b {
        CACHE,
        SOURCE
    }

    public i(a aVar, com.bumptech.glide.load.b.a<?, ?, ?> aVar2, com.bumptech.glide.k kVar) {
        this.f853b = aVar;
        this.f854c = aVar2;
        this.f852a = kVar;
    }

    public void a() {
        this.e = true;
        this.f854c.d();
    }

    @Override // java.lang.Runnable
    public void run() {
        k<?> kVar;
        Exception exc = null;
        if (!this.e) {
            try {
                kVar = d();
            } catch (Exception e) {
                if (Log.isLoggable("EngineRunnable", 2)) {
                    Log.v("EngineRunnable", "Exception decoding", e);
                }
                exc = e;
                kVar = null;
            }
            if (this.e) {
                if (kVar != null) {
                    kVar.d();
                }
            } else if (kVar == null) {
                a(exc);
            } else {
                a(kVar);
            }
        }
    }

    private boolean c() {
        return this.d == b.CACHE;
    }

    private void a(k kVar) {
        this.f853b.a(kVar);
    }

    private void a(Exception exc) {
        if (c()) {
            this.d = b.SOURCE;
            this.f853b.b(this);
            return;
        }
        this.f853b.a(exc);
    }

    private k<?> d() throws Exception {
        return c() ? e() : f();
    }

    private k<?> e() throws Exception {
        k<?> kVar;
        try {
            kVar = this.f854c.a();
        } catch (Exception e) {
            if (Log.isLoggable("EngineRunnable", 3)) {
                Log.d("EngineRunnable", "Exception decoding result from cache: " + e);
            }
            kVar = null;
        }
        if (kVar == null) {
            return this.f854c.b();
        }
        return kVar;
    }

    private k<?> f() throws Exception {
        return this.f854c.c();
    }

    @Override // com.bumptech.glide.load.b.c.b
    public int b() {
        return this.f852a.ordinal();
    }
}
