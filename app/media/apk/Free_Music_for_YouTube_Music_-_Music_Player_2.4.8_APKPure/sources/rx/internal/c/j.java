package rx.internal.c;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ScheduledAction.java */
/* loaded from: classes2.dex */
public final class j extends AtomicReference<Thread> implements Runnable, rx.m {
    private static final long serialVersionUID = -3962399486978279857L;

    /* renamed from: a  reason: collision with root package name */
    final rx.internal.util.j f5532a;

    /* renamed from: b  reason: collision with root package name */
    final rx.c.a f5533b;

    public j(rx.c.a aVar) {
        this.f5533b = aVar;
        this.f5532a = new rx.internal.util.j();
    }

    public j(rx.c.a aVar, rx.g.b bVar) {
        this.f5533b = aVar;
        this.f5532a = new rx.internal.util.j(new b(this, bVar));
    }

    public j(rx.c.a aVar, rx.internal.util.j jVar) {
        this.f5533b = aVar;
        this.f5532a = new rx.internal.util.j(new c(this, jVar));
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                lazySet(Thread.currentThread());
                this.f5533b.a();
                unsubscribe();
            } catch (rx.b.f e) {
                a(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e));
                unsubscribe();
            } catch (Throwable th) {
                a(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th));
                unsubscribe();
            }
        } catch (Throwable th2) {
            unsubscribe();
            throw th2;
        }
    }

    void a(Throwable th) {
        rx.e.c.a(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f5532a.isUnsubscribed();
    }

    @Override // rx.m
    public void unsubscribe() {
        if (!this.f5532a.isUnsubscribed()) {
            this.f5532a.unsubscribe();
        }
    }

    public void a(rx.m mVar) {
        this.f5532a.a(mVar);
    }

    public void a(Future<?> future) {
        this.f5532a.a(new a(future));
    }

    public void a(rx.g.b bVar) {
        this.f5532a.a(new b(this, bVar));
    }

    /* compiled from: ScheduledAction.java */
    /* loaded from: classes2.dex */
    final class a implements rx.m {

        /* renamed from: b  reason: collision with root package name */
        private final Future<?> f5535b;

        a(Future<?> future) {
            this.f5535b = future;
        }

        @Override // rx.m
        public void unsubscribe() {
            if (j.this.get() != Thread.currentThread()) {
                this.f5535b.cancel(true);
            } else {
                this.f5535b.cancel(false);
            }
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f5535b.isCancelled();
        }
    }

    /* compiled from: ScheduledAction.java */
    /* loaded from: classes2.dex */
    static final class b extends AtomicBoolean implements rx.m {
        private static final long serialVersionUID = 247232374289553518L;

        /* renamed from: a  reason: collision with root package name */
        final j f5536a;

        /* renamed from: b  reason: collision with root package name */
        final rx.g.b f5537b;

        public b(j jVar, rx.g.b bVar) {
            this.f5536a = jVar;
            this.f5537b = bVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f5536a.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f5537b.b(this.f5536a);
            }
        }
    }

    /* compiled from: ScheduledAction.java */
    /* loaded from: classes2.dex */
    static final class c extends AtomicBoolean implements rx.m {
        private static final long serialVersionUID = 247232374289553518L;

        /* renamed from: a  reason: collision with root package name */
        final j f5538a;

        /* renamed from: b  reason: collision with root package name */
        final rx.internal.util.j f5539b;

        public c(j jVar, rx.internal.util.j jVar2) {
            this.f5538a = jVar;
            this.f5539b = jVar2;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f5538a.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f5539b.b(this.f5538a);
            }
        }
    }
}
