package rx.internal.c;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.i;
/* compiled from: TrampolineScheduler.java */
/* loaded from: classes2.dex */
public final class n extends rx.i {

    /* renamed from: a  reason: collision with root package name */
    public static final n f5559a = new n();

    @Override // rx.i
    public i.a createWorker() {
        return new a();
    }

    private n() {
    }

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes2.dex */
    static final class a extends i.a implements rx.m {

        /* renamed from: a  reason: collision with root package name */
        final AtomicInteger f5560a = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        final PriorityBlockingQueue<b> f5561b = new PriorityBlockingQueue<>();

        /* renamed from: c  reason: collision with root package name */
        private final rx.g.a f5562c = new rx.g.a();
        private final AtomicInteger d = new AtomicInteger();

        a() {
        }

        @Override // rx.i.a
        public rx.m a(rx.c.a aVar) {
            return a(aVar, m_());
        }

        @Override // rx.i.a
        public rx.m a(rx.c.a aVar, long j, TimeUnit timeUnit) {
            long m_ = m_() + timeUnit.toMillis(j);
            return a(new m(aVar, this, m_), m_);
        }

        private rx.m a(rx.c.a aVar, long j) {
            if (this.f5562c.isUnsubscribed()) {
                return rx.g.e.a();
            }
            final b bVar = new b(aVar, Long.valueOf(j), this.f5560a.incrementAndGet());
            this.f5561b.add(bVar);
            if (this.d.getAndIncrement() == 0) {
                do {
                    b poll = this.f5561b.poll();
                    if (poll != null) {
                        poll.f5565a.a();
                    }
                } while (this.d.decrementAndGet() > 0);
                return rx.g.e.a();
            }
            return rx.g.e.a(new rx.c.a() { // from class: rx.internal.c.n.a.1
                @Override // rx.c.a
                public void a() {
                    a.this.f5561b.remove(bVar);
                }
            });
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f5562c.unsubscribe();
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f5562c.isUnsubscribed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes2.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        final rx.c.a f5565a;

        /* renamed from: b  reason: collision with root package name */
        final Long f5566b;

        /* renamed from: c  reason: collision with root package name */
        final int f5567c;

        b(rx.c.a aVar, Long l, int i) {
            this.f5565a = aVar;
            this.f5566b = l;
            this.f5567c = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int compareTo = this.f5566b.compareTo(bVar.f5566b);
            if (compareTo == 0) {
                return n.a(this.f5567c, bVar.f5567c);
            }
            return compareTo;
        }
    }

    static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }
}
