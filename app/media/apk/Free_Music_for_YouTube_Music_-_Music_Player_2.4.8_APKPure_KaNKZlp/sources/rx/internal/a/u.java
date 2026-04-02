package rx.internal.a;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.f;
import rx.internal.util.c;
/* compiled from: OperatorOnBackpressureBuffer.java */
/* loaded from: classes2.dex */
public class u<T> implements f.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    private final Long f5428a = null;

    /* renamed from: b  reason: collision with root package name */
    private final rx.c.a f5429b = null;

    /* renamed from: c  reason: collision with root package name */
    private final a.d f5430c = rx.a.f5216b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureBuffer.java */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final u<?> f5434a = new u<>();
    }

    @Override // rx.c.e
    public /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((rx.l) ((rx.l) obj));
    }

    public static <T> u<T> a() {
        return (u<T>) b.f5434a;
    }

    u() {
    }

    public rx.l<? super T> a(rx.l<? super T> lVar) {
        a aVar = new a(lVar, this.f5428a, this.f5429b, this.f5430c);
        lVar.add(aVar);
        lVar.setProducer(aVar.c());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureBuffer.java */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.l<T> implements c.a {

        /* renamed from: b  reason: collision with root package name */
        private final AtomicLong f5432b;

        /* renamed from: c  reason: collision with root package name */
        private final rx.l<? super T> f5433c;
        private final rx.internal.util.c e;
        private final rx.c.a f;
        private final a.d g;

        /* renamed from: a  reason: collision with root package name */
        private final ConcurrentLinkedQueue<Object> f5431a = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean d = new AtomicBoolean(false);

        public a(rx.l<? super T> lVar, Long l, rx.c.a aVar, a.d dVar) {
            this.f5433c = lVar;
            this.f5432b = l != null ? new AtomicLong(l.longValue()) : null;
            this.f = aVar;
            this.e = new rx.internal.util.c(this);
            this.g = dVar;
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.g
        public void onCompleted() {
            if (!this.d.get()) {
                this.e.a();
            }
        }

        @Override // rx.g
        public void onError(Throwable th) {
            if (!this.d.get()) {
                this.e.a(th);
            }
        }

        @Override // rx.g
        public void onNext(T t) {
            if (d()) {
                this.f5431a.offer(d.a(t));
                this.e.b();
            }
        }

        @Override // rx.internal.util.c.a
        public boolean a(Object obj) {
            return d.a(this.f5433c, obj);
        }

        @Override // rx.internal.util.c.a
        public void a(Throwable th) {
            if (th != null) {
                this.f5433c.onError(th);
            } else {
                this.f5433c.onCompleted();
            }
        }

        @Override // rx.internal.util.c.a
        public Object a() {
            return this.f5431a.peek();
        }

        @Override // rx.internal.util.c.a
        public Object b() {
            Object poll = this.f5431a.poll();
            if (this.f5432b != null && poll != null) {
                this.f5432b.incrementAndGet();
            }
            return poll;
        }

        private boolean d() {
            long j;
            boolean z;
            if (this.f5432b == null) {
                return true;
            }
            do {
                j = this.f5432b.get();
                if (j <= 0) {
                    try {
                        z = this.g.a() && b() != null;
                    } catch (rx.b.c e) {
                        if (this.d.compareAndSet(false, true)) {
                            unsubscribe();
                            this.f5433c.onError(e);
                        }
                        z = false;
                    }
                    if (this.f != null) {
                        try {
                            this.f.a();
                        } catch (Throwable th) {
                            rx.b.b.b(th);
                            this.e.a(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.f5432b.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.h c() {
            return this.e;
        }
    }
}
