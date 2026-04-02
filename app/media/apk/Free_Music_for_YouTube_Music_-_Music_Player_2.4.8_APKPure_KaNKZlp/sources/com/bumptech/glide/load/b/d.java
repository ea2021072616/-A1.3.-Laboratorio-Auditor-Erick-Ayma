package com.bumptech.glide.load.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.b.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/* compiled from: EngineJob.java */
/* loaded from: classes.dex */
class d implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f840a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Handler f841b = new Handler(Looper.getMainLooper(), new b());

    /* renamed from: c  reason: collision with root package name */
    private final List<com.bumptech.glide.g.e> f842c;
    private final a d;
    private final e e;
    private final com.bumptech.glide.load.c f;
    private final ExecutorService g;
    private final ExecutorService h;
    private final boolean i;
    private boolean j;
    private k<?> k;
    private boolean l;
    private Exception m;
    private boolean n;
    private Set<com.bumptech.glide.g.e> o;
    private i p;
    private h<?> q;
    private volatile Future<?> r;

    public d(com.bumptech.glide.load.c cVar, ExecutorService executorService, ExecutorService executorService2, boolean z, e eVar) {
        this(cVar, executorService, executorService2, z, eVar, f840a);
    }

    public d(com.bumptech.glide.load.c cVar, ExecutorService executorService, ExecutorService executorService2, boolean z, e eVar, a aVar) {
        this.f842c = new ArrayList();
        this.f = cVar;
        this.g = executorService;
        this.h = executorService2;
        this.i = z;
        this.e = eVar;
        this.d = aVar;
    }

    public void a(i iVar) {
        this.p = iVar;
        this.r = this.g.submit(iVar);
    }

    @Override // com.bumptech.glide.load.b.i.a
    public void b(i iVar) {
        this.r = this.h.submit(iVar);
    }

    public void a(com.bumptech.glide.g.e eVar) {
        com.bumptech.glide.i.h.a();
        if (this.l) {
            eVar.a(this.q);
        } else if (this.n) {
            eVar.a(this.m);
        } else {
            this.f842c.add(eVar);
        }
    }

    public void b(com.bumptech.glide.g.e eVar) {
        com.bumptech.glide.i.h.a();
        if (this.l || this.n) {
            c(eVar);
            return;
        }
        this.f842c.remove(eVar);
        if (this.f842c.isEmpty()) {
            a();
        }
    }

    private void c(com.bumptech.glide.g.e eVar) {
        if (this.o == null) {
            this.o = new HashSet();
        }
        this.o.add(eVar);
    }

    private boolean d(com.bumptech.glide.g.e eVar) {
        return this.o != null && this.o.contains(eVar);
    }

    void a() {
        if (!this.n && !this.l && !this.j) {
            this.p.a();
            Future<?> future = this.r;
            if (future != null) {
                future.cancel(true);
            }
            this.j = true;
            this.e.a(this, this.f);
        }
    }

    @Override // com.bumptech.glide.g.e
    public void a(k<?> kVar) {
        this.k = kVar;
        f841b.obtainMessage(1, this).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.j) {
            this.k.d();
        } else if (this.f842c.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else {
            this.q = this.d.a(this.k, this.i);
            this.l = true;
            this.q.e();
            this.e.a(this.f, this.q);
            for (com.bumptech.glide.g.e eVar : this.f842c) {
                if (!d(eVar)) {
                    this.q.e();
                    eVar.a(this.q);
                }
            }
            this.q.f();
        }
    }

    @Override // com.bumptech.glide.g.e
    public void a(Exception exc) {
        this.m = exc;
        f841b.obtainMessage(2, this).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!this.j) {
            if (this.f842c.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            this.n = true;
            this.e.a(this.f, (h<?>) null);
            for (com.bumptech.glide.g.e eVar : this.f842c) {
                if (!d(eVar)) {
                    eVar.a(this.m);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public <R> h<R> a(k<R> kVar, boolean z) {
            return new h<>(kVar, z);
        }
    }

    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    private static class b implements Handler.Callback {
        private b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (1 == message.what || 2 == message.what) {
                d dVar = (d) message.obj;
                if (1 == message.what) {
                    dVar.b();
                } else {
                    dVar.c();
                }
                return true;
            }
            return false;
        }
    }
}
