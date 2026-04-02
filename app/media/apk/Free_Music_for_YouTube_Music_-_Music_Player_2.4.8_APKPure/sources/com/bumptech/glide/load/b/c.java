package com.bumptech.glide.load.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import com.bumptech.glide.load.b.a;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.b.b.h;
import com.bumptech.glide.load.b.h;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
/* compiled from: Engine.java */
/* loaded from: classes.dex */
public class c implements h.a, com.bumptech.glide.load.b.e, h.a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<com.bumptech.glide.load.c, com.bumptech.glide.load.b.d> f818a;

    /* renamed from: b  reason: collision with root package name */
    private final g f819b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.b.b.h f820c;
    private final a d;
    private final Map<com.bumptech.glide.load.c, WeakReference<h<?>>> e;
    private final l f;
    private final b g;
    private ReferenceQueue<h<?>> h;

    /* compiled from: Engine.java */
    /* renamed from: com.bumptech.glide.load.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0028c {

        /* renamed from: a  reason: collision with root package name */
        private final com.bumptech.glide.load.b.d f835a;

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.g.e f836b;

        public C0028c(com.bumptech.glide.g.e eVar, com.bumptech.glide.load.b.d dVar) {
            this.f836b = eVar;
            this.f835a = dVar;
        }

        public void a() {
            this.f835a.b(this.f836b);
        }
    }

    public c(com.bumptech.glide.load.b.b.h hVar, a.InterfaceC0026a interfaceC0026a, ExecutorService executorService, ExecutorService executorService2) {
        this(hVar, interfaceC0026a, executorService, executorService2, null, null, null, null, null);
    }

    c(com.bumptech.glide.load.b.b.h hVar, a.InterfaceC0026a interfaceC0026a, ExecutorService executorService, ExecutorService executorService2, Map<com.bumptech.glide.load.c, com.bumptech.glide.load.b.d> map, g gVar, Map<com.bumptech.glide.load.c, WeakReference<h<?>>> map2, a aVar, l lVar) {
        this.f820c = hVar;
        this.g = new b(interfaceC0026a);
        this.e = map2 == null ? new HashMap<>() : map2;
        this.f819b = gVar == null ? new g() : gVar;
        this.f818a = map == null ? new HashMap<>() : map;
        this.d = aVar == null ? new a(executorService, executorService2, this) : aVar;
        this.f = lVar == null ? new l() : lVar;
        hVar.a(this);
    }

    public <T, Z, R> C0028c a(com.bumptech.glide.load.c cVar, int i, int i2, com.bumptech.glide.load.a.c<T> cVar2, com.bumptech.glide.f.b<T, Z> bVar, com.bumptech.glide.load.g<Z> gVar, com.bumptech.glide.load.resource.e.c<Z, R> cVar3, com.bumptech.glide.k kVar, boolean z, com.bumptech.glide.load.b.b bVar2, com.bumptech.glide.g.e eVar) {
        com.bumptech.glide.i.h.a();
        long a2 = com.bumptech.glide.i.d.a();
        f a3 = this.f819b.a(cVar2.b(), cVar, i, i2, bVar.a(), bVar.b(), gVar, bVar.d(), cVar3, bVar.c());
        h<?> b2 = b(a3, z);
        if (b2 != null) {
            eVar.a(b2);
            if (Log.isLoggable("Engine", 2)) {
                a("Loaded resource from cache", a2, a3);
            }
            return null;
        }
        h<?> a4 = a(a3, z);
        if (a4 != null) {
            eVar.a(a4);
            if (Log.isLoggable("Engine", 2)) {
                a("Loaded resource from active resources", a2, a3);
            }
            return null;
        }
        com.bumptech.glide.load.b.d dVar = this.f818a.get(a3);
        if (dVar != null) {
            dVar.a(eVar);
            if (Log.isLoggable("Engine", 2)) {
                a("Added to existing load", a2, a3);
            }
            return new C0028c(eVar, dVar);
        }
        com.bumptech.glide.load.b.d a5 = this.d.a(a3, z);
        i iVar = new i(a5, new com.bumptech.glide.load.b.a(a3, i, i2, cVar2, bVar, gVar, cVar3, this.g, bVar2, kVar), kVar);
        this.f818a.put(a3, a5);
        a5.a(eVar);
        a5.a(iVar);
        if (Log.isLoggable("Engine", 2)) {
            a("Started new load", a2, a3);
        }
        return new C0028c(eVar, a5);
    }

    private static void a(String str, long j, com.bumptech.glide.load.c cVar) {
        Log.v("Engine", str + " in " + com.bumptech.glide.i.d.a(j) + "ms, key: " + cVar);
    }

    private h<?> a(com.bumptech.glide.load.c cVar, boolean z) {
        h<?> hVar;
        if (z) {
            WeakReference<h<?>> weakReference = this.e.get(cVar);
            if (weakReference != null) {
                hVar = weakReference.get();
                if (hVar != null) {
                    hVar.e();
                } else {
                    this.e.remove(cVar);
                }
            } else {
                hVar = null;
            }
            return hVar;
        }
        return null;
    }

    private h<?> b(com.bumptech.glide.load.c cVar, boolean z) {
        if (!z) {
            return null;
        }
        h<?> a2 = a(cVar);
        if (a2 != null) {
            a2.e();
            this.e.put(cVar, new e(cVar, a2, b()));
            return a2;
        }
        return a2;
    }

    private h<?> a(com.bumptech.glide.load.c cVar) {
        k<?> a2 = this.f820c.a(cVar);
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof h) {
            return (h) a2;
        }
        return new h<>(a2, true);
    }

    public void a(k kVar) {
        com.bumptech.glide.i.h.a();
        if (kVar instanceof h) {
            ((h) kVar).f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @Override // com.bumptech.glide.load.b.e
    public void a(com.bumptech.glide.load.c cVar, h<?> hVar) {
        com.bumptech.glide.i.h.a();
        if (hVar != null) {
            hVar.a(cVar, this);
            if (hVar.a()) {
                this.e.put(cVar, new e(cVar, hVar, b()));
            }
        }
        this.f818a.remove(cVar);
    }

    @Override // com.bumptech.glide.load.b.e
    public void a(com.bumptech.glide.load.b.d dVar, com.bumptech.glide.load.c cVar) {
        com.bumptech.glide.i.h.a();
        if (dVar.equals(this.f818a.get(cVar))) {
            this.f818a.remove(cVar);
        }
    }

    @Override // com.bumptech.glide.load.b.b.h.a
    public void b(k<?> kVar) {
        com.bumptech.glide.i.h.a();
        this.f.a(kVar);
    }

    @Override // com.bumptech.glide.load.b.h.a
    public void b(com.bumptech.glide.load.c cVar, h hVar) {
        com.bumptech.glide.i.h.a();
        this.e.remove(cVar);
        if (hVar.a()) {
            this.f820c.b(cVar, hVar);
        } else {
            this.f.a(hVar);
        }
    }

    public void a() {
        this.g.a().a();
    }

    private ReferenceQueue<h<?>> b() {
        if (this.h == null) {
            this.h = new ReferenceQueue<>();
            Looper.myQueue().addIdleHandler(new d(this.e, this.h));
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class b implements a.InterfaceC0024a {

        /* renamed from: a  reason: collision with root package name */
        private final a.InterfaceC0026a f833a;

        /* renamed from: b  reason: collision with root package name */
        private volatile com.bumptech.glide.load.b.b.a f834b;

        public b(a.InterfaceC0026a interfaceC0026a) {
            this.f833a = interfaceC0026a;
        }

        @Override // com.bumptech.glide.load.b.a.InterfaceC0024a
        public com.bumptech.glide.load.b.b.a a() {
            if (this.f834b == null) {
                synchronized (this) {
                    if (this.f834b == null) {
                        this.f834b = this.f833a.a();
                    }
                    if (this.f834b == null) {
                        this.f834b = new com.bumptech.glide.load.b.b.b();
                    }
                }
            }
            return this.f834b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class e extends WeakReference<h<?>> {

        /* renamed from: a  reason: collision with root package name */
        private final com.bumptech.glide.load.c f839a;

        public e(com.bumptech.glide.load.c cVar, h<?> hVar, ReferenceQueue<? super h<?>> referenceQueue) {
            super(hVar, referenceQueue);
            this.f839a = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class d implements MessageQueue.IdleHandler {

        /* renamed from: a  reason: collision with root package name */
        private final Map<com.bumptech.glide.load.c, WeakReference<h<?>>> f837a;

        /* renamed from: b  reason: collision with root package name */
        private final ReferenceQueue<h<?>> f838b;

        public d(Map<com.bumptech.glide.load.c, WeakReference<h<?>>> map, ReferenceQueue<h<?>> referenceQueue) {
            this.f837a = map;
            this.f838b = referenceQueue;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            e eVar = (e) this.f838b.poll();
            if (eVar != null) {
                this.f837a.remove(eVar.f839a);
                return true;
            }
            return true;
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final ExecutorService f823a;

        /* renamed from: b  reason: collision with root package name */
        private final ExecutorService f824b;

        /* renamed from: c  reason: collision with root package name */
        private final com.bumptech.glide.load.b.e f825c;

        public a(ExecutorService executorService, ExecutorService executorService2, com.bumptech.glide.load.b.e eVar) {
            this.f823a = executorService;
            this.f824b = executorService2;
            this.f825c = eVar;
        }

        public com.bumptech.glide.load.b.d a(com.bumptech.glide.load.c cVar, boolean z) {
            return new com.bumptech.glide.load.b.d(cVar, this.f823a, this.f824b, z, this.f825c);
        }
    }
}
