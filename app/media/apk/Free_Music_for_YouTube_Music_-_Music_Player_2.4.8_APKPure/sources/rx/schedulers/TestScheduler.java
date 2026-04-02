package rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.g.e;
import rx.i;
import rx.internal.c.i;
import rx.m;
/* loaded from: classes2.dex */
public class TestScheduler extends i {

    /* renamed from: b  reason: collision with root package name */
    static long f5633b;

    /* renamed from: a  reason: collision with root package name */
    final Queue<c> f5634a = new PriorityQueue(11, new a());

    /* renamed from: c  reason: collision with root package name */
    long f5635c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final long f5642a;

        /* renamed from: b  reason: collision with root package name */
        final rx.c.a f5643b;

        /* renamed from: c  reason: collision with root package name */
        final i.a f5644c;
        private final long d;

        c(i.a aVar, long j, rx.c.a aVar2) {
            long j2 = TestScheduler.f5633b;
            TestScheduler.f5633b = 1 + j2;
            this.d = j2;
            this.f5642a = j;
            this.f5643b = aVar2;
            this.f5644c = aVar;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.f5642a), this.f5643b.toString());
        }
    }

    /* loaded from: classes2.dex */
    static final class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            if (cVar.f5642a == cVar2.f5642a) {
                if (cVar.d < cVar2.d) {
                    return -1;
                }
                return cVar.d > cVar2.d ? 1 : 0;
            } else if (cVar.f5642a >= cVar2.f5642a) {
                return cVar.f5642a > cVar2.f5642a ? 1 : 0;
            } else {
                return -1;
            }
        }
    }

    @Override // rx.i
    public long now() {
        return TimeUnit.NANOSECONDS.toMillis(this.f5635c);
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(this.f5635c + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j, TimeUnit timeUnit) {
        a(timeUnit.toNanos(j));
    }

    public void triggerActions() {
        a(this.f5635c);
    }

    private void a(long j) {
        while (!this.f5634a.isEmpty()) {
            c peek = this.f5634a.peek();
            if (peek.f5642a > j) {
                break;
            }
            this.f5635c = peek.f5642a == 0 ? this.f5635c : peek.f5642a;
            this.f5634a.remove();
            if (!peek.f5644c.isUnsubscribed()) {
                peek.f5643b.a();
            }
        }
        this.f5635c = j;
    }

    @Override // rx.i
    public i.a createWorker() {
        return new b();
    }

    /* loaded from: classes2.dex */
    final class b extends i.a implements i.a {

        /* renamed from: b  reason: collision with root package name */
        private final rx.g.a f5637b = new rx.g.a();

        b() {
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f5637b.unsubscribe();
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f5637b.isUnsubscribed();
        }

        @Override // rx.i.a
        public m a(rx.c.a aVar, long j, TimeUnit timeUnit) {
            final c cVar = new c(this, TestScheduler.this.f5635c + timeUnit.toNanos(j), aVar);
            TestScheduler.this.f5634a.add(cVar);
            return e.a(new rx.c.a() { // from class: rx.schedulers.TestScheduler.b.1
                @Override // rx.c.a
                public void a() {
                    TestScheduler.this.f5634a.remove(cVar);
                }
            });
        }

        @Override // rx.i.a
        public m a(rx.c.a aVar) {
            final c cVar = new c(this, 0L, aVar);
            TestScheduler.this.f5634a.add(cVar);
            return e.a(new rx.c.a() { // from class: rx.schedulers.TestScheduler.b.2
                @Override // rx.c.a
                public void a() {
                    TestScheduler.this.f5634a.remove(cVar);
                }
            });
        }

        @Override // rx.i.a
        public m a(rx.c.a aVar, long j, long j2, TimeUnit timeUnit) {
            return rx.internal.c.i.a(this, aVar, j, j2, timeUnit, this);
        }

        @Override // rx.i.a
        public long m_() {
            return TestScheduler.this.now();
        }

        @Override // rx.internal.c.i.a
        public long b() {
            return TestScheduler.this.f5635c;
        }
    }
}
