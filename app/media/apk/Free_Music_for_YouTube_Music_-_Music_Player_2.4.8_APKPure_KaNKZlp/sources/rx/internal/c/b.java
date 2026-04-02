package rx.internal.c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.i;
/* compiled from: EventLoopsScheduler.java */
/* loaded from: classes2.dex */
public final class b extends rx.i implements k {

    /* renamed from: a  reason: collision with root package name */
    static final int f5494a;

    /* renamed from: b  reason: collision with root package name */
    static final c f5495b;

    /* renamed from: c  reason: collision with root package name */
    static final C0117b f5496c;
    final ThreadFactory d;
    final AtomicReference<C0117b> e = new AtomicReference<>(f5496c);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f5494a = intValue;
        f5495b = new c(rx.internal.util.h.f5600a);
        f5495b.unsubscribe();
        f5496c = new C0117b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventLoopsScheduler.java */
    /* renamed from: rx.internal.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0117b {

        /* renamed from: a  reason: collision with root package name */
        final int f5504a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f5505b;

        /* renamed from: c  reason: collision with root package name */
        long f5506c;

        C0117b(ThreadFactory threadFactory, int i) {
            this.f5504a = i;
            this.f5505b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f5505b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.f5504a;
            if (i == 0) {
                return b.f5495b;
            }
            c[] cVarArr = this.f5505b;
            long j = this.f5506c;
            this.f5506c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.f5505b) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.d = threadFactory;
        a();
    }

    @Override // rx.i
    public i.a createWorker() {
        return new a(this.e.get().a());
    }

    @Override // rx.internal.c.k
    public void a() {
        C0117b c0117b = new C0117b(this.d, f5494a);
        if (!this.e.compareAndSet(f5496c, c0117b)) {
            c0117b.b();
        }
    }

    @Override // rx.internal.c.k
    public void b() {
        C0117b c0117b;
        do {
            c0117b = this.e.get();
            if (c0117b == f5496c) {
                return;
            }
        } while (!this.e.compareAndSet(c0117b, f5496c));
        c0117b.b();
    }

    public rx.m a(rx.c.a aVar) {
        return this.e.get().a().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* compiled from: EventLoopsScheduler.java */
    /* loaded from: classes2.dex */
    static final class a extends i.a {

        /* renamed from: a  reason: collision with root package name */
        private final rx.internal.util.j f5497a = new rx.internal.util.j();

        /* renamed from: b  reason: collision with root package name */
        private final rx.g.b f5498b = new rx.g.b();

        /* renamed from: c  reason: collision with root package name */
        private final rx.internal.util.j f5499c = new rx.internal.util.j(this.f5497a, this.f5498b);
        private final c d;

        a(c cVar) {
            this.d = cVar;
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f5499c.unsubscribe();
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f5499c.isUnsubscribed();
        }

        @Override // rx.i.a
        public rx.m a(final rx.c.a aVar) {
            return isUnsubscribed() ? rx.g.e.a() : this.d.a(new rx.c.a() { // from class: rx.internal.c.b.a.1
                @Override // rx.c.a
                public void a() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.a();
                    }
                }
            }, 0L, (TimeUnit) null, this.f5497a);
        }

        @Override // rx.i.a
        public rx.m a(final rx.c.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.g.e.a() : this.d.a(new rx.c.a() { // from class: rx.internal.c.b.a.2
                @Override // rx.c.a
                public void a() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.a();
                    }
                }
            }, j, timeUnit, this.f5498b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventLoopsScheduler.java */
    /* loaded from: classes2.dex */
    public static final class c extends h {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
