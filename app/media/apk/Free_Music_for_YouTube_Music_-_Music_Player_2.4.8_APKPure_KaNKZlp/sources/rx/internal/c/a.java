package rx.internal.c;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.i;
/* compiled from: CachedThreadScheduler.java */
/* loaded from: classes2.dex */
public final class a extends rx.i implements k {

    /* renamed from: b  reason: collision with root package name */
    static final C0116a f5480b;
    private static final long e;

    /* renamed from: c  reason: collision with root package name */
    final ThreadFactory f5481c;
    final AtomicReference<C0116a> d = new AtomicReference<>(f5480b);
    private static final TimeUnit f = TimeUnit.SECONDS;

    /* renamed from: a  reason: collision with root package name */
    static final c f5479a = new c(rx.internal.util.h.f5600a);

    static {
        f5479a.unsubscribe();
        f5480b = new C0116a(null, 0L, null);
        f5480b.d();
        e = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CachedThreadScheduler.java */
    /* renamed from: rx.internal.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0116a {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadFactory f5482a;

        /* renamed from: b  reason: collision with root package name */
        private final long f5483b;

        /* renamed from: c  reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f5484c;
        private final rx.g.b d;
        private final ScheduledExecutorService e;
        private final Future<?> f;

        C0116a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.f5482a = threadFactory;
            this.f5483b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f5484c = new ConcurrentLinkedQueue<>();
            this.d = new rx.g.b();
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new ThreadFactory() { // from class: rx.internal.c.a.a.1
                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable) {
                        Thread newThread = threadFactory.newThread(runnable);
                        newThread.setName(newThread.getName() + " (Evictor)");
                        return newThread;
                    }
                });
                h.b(newScheduledThreadPool);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(new Runnable() { // from class: rx.internal.c.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        C0116a.this.b();
                    }
                }, this.f5483b, this.f5483b, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.e = scheduledExecutorService;
            this.f = scheduledFuture;
        }

        c a() {
            if (this.d.isUnsubscribed()) {
                return a.f5479a;
            }
            while (!this.f5484c.isEmpty()) {
                c poll = this.f5484c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f5482a);
            this.d.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.a(c() + this.f5483b);
            this.f5484c.offer(cVar);
        }

        void b() {
            if (!this.f5484c.isEmpty()) {
                long c2 = c();
                Iterator<c> it = this.f5484c.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.b() <= c2) {
                        if (this.f5484c.remove(next)) {
                            this.d.b(next);
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        long c() {
            return System.nanoTime();
        }

        void d() {
            try {
                if (this.f != null) {
                    this.f.cancel(true);
                }
                if (this.e != null) {
                    this.e.shutdownNow();
                }
            } finally {
                this.d.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.f5481c = threadFactory;
        a();
    }

    @Override // rx.internal.c.k
    public void a() {
        C0116a c0116a = new C0116a(this.f5481c, e, f);
        if (!this.d.compareAndSet(f5480b, c0116a)) {
            c0116a.d();
        }
    }

    @Override // rx.internal.c.k
    public void b() {
        C0116a c0116a;
        do {
            c0116a = this.d.get();
            if (c0116a == f5480b) {
                return;
            }
        } while (!this.d.compareAndSet(c0116a, f5480b));
        c0116a.d();
    }

    @Override // rx.i
    public i.a createWorker() {
        return new b(this.d.get());
    }

    /* compiled from: CachedThreadScheduler.java */
    /* loaded from: classes2.dex */
    static final class b extends i.a implements rx.c.a {

        /* renamed from: c  reason: collision with root package name */
        private final C0116a f5490c;
        private final c d;

        /* renamed from: b  reason: collision with root package name */
        private final rx.g.b f5489b = new rx.g.b();

        /* renamed from: a  reason: collision with root package name */
        final AtomicBoolean f5488a = new AtomicBoolean();

        b(C0116a c0116a) {
            this.f5490c = c0116a;
            this.d = c0116a.a();
        }

        @Override // rx.m
        public void unsubscribe() {
            if (this.f5488a.compareAndSet(false, true)) {
                this.d.a(this);
            }
            this.f5489b.unsubscribe();
        }

        @Override // rx.c.a
        public void a() {
            this.f5490c.a(this.d);
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f5489b.isUnsubscribed();
        }

        @Override // rx.i.a
        public rx.m a(rx.c.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.i.a
        public rx.m a(final rx.c.a aVar, long j, TimeUnit timeUnit) {
            if (this.f5489b.isUnsubscribed()) {
                return rx.g.e.a();
            }
            j b2 = this.d.b(new rx.c.a() { // from class: rx.internal.c.a.b.1
                @Override // rx.c.a
                public void a() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.a();
                    }
                }
            }, j, timeUnit);
            this.f5489b.a(b2);
            b2.a(this.f5489b);
            return b2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CachedThreadScheduler.java */
    /* loaded from: classes2.dex */
    public static final class c extends h {

        /* renamed from: c  reason: collision with root package name */
        private long f5493c;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f5493c = 0L;
        }

        public long b() {
            return this.f5493c;
        }

        public void a(long j) {
            this.f5493c = j;
        }
    }
}
