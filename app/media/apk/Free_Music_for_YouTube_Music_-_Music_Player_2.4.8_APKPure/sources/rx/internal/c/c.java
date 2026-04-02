package rx.internal.c;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.i;
/* compiled from: ExecutorScheduler.java */
/* loaded from: classes2.dex */
public final class c extends rx.i {

    /* renamed from: a  reason: collision with root package name */
    final Executor f5507a;

    public c(Executor executor) {
        this.f5507a = executor;
    }

    @Override // rx.i
    public i.a createWorker() {
        return new a(this.f5507a);
    }

    /* compiled from: ExecutorScheduler.java */
    /* loaded from: classes2.dex */
    static final class a extends i.a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Executor f5508a;

        /* renamed from: c  reason: collision with root package name */
        final ConcurrentLinkedQueue<j> f5510c = new ConcurrentLinkedQueue<>();
        final AtomicInteger d = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        final rx.g.b f5509b = new rx.g.b();
        final ScheduledExecutorService e = d.c();

        public a(Executor executor) {
            this.f5508a = executor;
        }

        @Override // rx.i.a
        public rx.m a(rx.c.a aVar) {
            if (isUnsubscribed()) {
                return rx.g.e.a();
            }
            j jVar = new j(rx.e.c.a(aVar), this.f5509b);
            this.f5509b.a(jVar);
            this.f5510c.offer(jVar);
            if (this.d.getAndIncrement() == 0) {
                try {
                    this.f5508a.execute(this);
                    return jVar;
                } catch (RejectedExecutionException e) {
                    this.f5509b.b(jVar);
                    this.d.decrementAndGet();
                    rx.e.c.a(e);
                    throw e;
                }
            }
            return jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f5509b.isUnsubscribed()) {
                j poll = this.f5510c.poll();
                if (poll != null) {
                    if (!poll.isUnsubscribed()) {
                        if (!this.f5509b.isUnsubscribed()) {
                            poll.run();
                        } else {
                            this.f5510c.clear();
                            return;
                        }
                    }
                    if (this.d.decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f5510c.clear();
        }

        @Override // rx.i.a
        public rx.m a(rx.c.a aVar, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return a(aVar);
            }
            if (isUnsubscribed()) {
                return rx.g.e.a();
            }
            final rx.c.a a2 = rx.e.c.a(aVar);
            rx.g.c cVar = new rx.g.c();
            final rx.g.c cVar2 = new rx.g.c();
            cVar2.a(cVar);
            this.f5509b.a(cVar2);
            final rx.m a3 = rx.g.e.a(new rx.c.a() { // from class: rx.internal.c.c.a.1
                @Override // rx.c.a
                public void a() {
                    a.this.f5509b.b(cVar2);
                }
            });
            j jVar = new j(new rx.c.a() { // from class: rx.internal.c.c.a.2
                @Override // rx.c.a
                public void a() {
                    if (!cVar2.isUnsubscribed()) {
                        rx.m a4 = a.this.a(a2);
                        cVar2.a(a4);
                        if (a4.getClass() == j.class) {
                            ((j) a4).a(a3);
                        }
                    }
                }
            });
            cVar.a(jVar);
            try {
                jVar.a(this.e.schedule(jVar, j, timeUnit));
                return a3;
            } catch (RejectedExecutionException e) {
                rx.e.c.a(e);
                throw e;
            }
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f5509b.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f5509b.unsubscribe();
            this.f5510c.clear();
        }
    }
}
