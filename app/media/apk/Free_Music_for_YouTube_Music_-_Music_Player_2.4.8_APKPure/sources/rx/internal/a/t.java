package rx.internal.a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.f;
import rx.i;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
/* compiled from: OperatorObserveOn.java */
/* loaded from: classes2.dex */
public final class t<T> implements f.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.i f5421a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f5422b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5423c;

    @Override // rx.c.e
    public /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((rx.l) ((rx.l) obj));
    }

    public t(rx.i iVar, boolean z, int i) {
        this.f5421a = iVar;
        this.f5422b = z;
        this.f5423c = i <= 0 ? rx.internal.util.g.f5597b : i;
    }

    public rx.l<? super T> a(rx.l<? super T> lVar) {
        if (!(this.f5421a instanceof rx.internal.c.f) && !(this.f5421a instanceof rx.internal.c.n)) {
            a aVar = new a(this.f5421a, lVar, this.f5422b, this.f5423c);
            aVar.b();
            return aVar;
        }
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorObserveOn.java */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.l<T> implements rx.c.a {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f5424a;

        /* renamed from: b  reason: collision with root package name */
        final i.a f5425b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f5426c;
        final Queue<Object> d;
        final int e;
        volatile boolean f;
        final AtomicLong g = new AtomicLong();
        final AtomicLong h = new AtomicLong();
        Throwable i;
        long j;

        public a(rx.i iVar, rx.l<? super T> lVar, boolean z, int i) {
            this.f5424a = lVar;
            this.f5425b = iVar.createWorker();
            this.f5426c = z;
            i = i <= 0 ? rx.internal.util.g.f5597b : i;
            this.e = i - (i >> 2);
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.d = new SpscArrayQueue(i);
            } else {
                this.d = new rx.internal.util.a.c(i);
            }
            request(i);
        }

        void b() {
            rx.l<? super T> lVar = this.f5424a;
            lVar.setProducer(new rx.h() { // from class: rx.internal.a.t.a.1
                @Override // rx.h
                public void request(long j) {
                    if (j > 0) {
                        rx.internal.a.a.a(a.this.g, j);
                        a.this.c();
                    }
                }
            });
            lVar.add(this.f5425b);
            lVar.add(this);
        }

        @Override // rx.g
        public void onNext(T t) {
            if (!isUnsubscribed() && !this.f) {
                if (!this.d.offer(d.a(t))) {
                    onError(new rx.b.c());
                } else {
                    c();
                }
            }
        }

        @Override // rx.g
        public void onCompleted() {
            if (!isUnsubscribed() && !this.f) {
                this.f = true;
                c();
            }
        }

        @Override // rx.g
        public void onError(Throwable th) {
            if (isUnsubscribed() || this.f) {
                rx.e.c.a(th);
                return;
            }
            this.i = th;
            this.f = true;
            c();
        }

        protected void c() {
            if (this.h.getAndIncrement() == 0) {
                this.f5425b.a(this);
            }
        }

        @Override // rx.c.a
        public void a() {
            long j;
            long j2 = this.j;
            Queue<Object> queue = this.d;
            rx.l<? super T> lVar = this.f5424a;
            long j3 = 1;
            do {
                long j4 = this.g.get();
                while (j4 != j2) {
                    boolean z = this.f;
                    Object poll = queue.poll();
                    boolean z2 = poll == null;
                    if (!a(z, z2, lVar, queue)) {
                        if (z2) {
                            break;
                        }
                        lVar.onNext((Object) d.c(poll));
                        long j5 = j2 + 1;
                        if (j5 == this.e) {
                            j = rx.internal.a.a.b(this.g, j5);
                            request(j5);
                            j5 = 0;
                        } else {
                            j = j4;
                        }
                        j4 = j;
                        j2 = j5;
                    } else {
                        return;
                    }
                }
                if (j4 != j2 || !a(this.f, queue.isEmpty(), lVar, queue)) {
                    this.j = j2;
                    j3 = this.h.addAndGet(-j3);
                } else {
                    return;
                }
            } while (j3 != 0);
        }

        boolean a(boolean z, boolean z2, rx.l<? super T> lVar, Queue<Object> queue) {
            if (lVar.isUnsubscribed()) {
                queue.clear();
                return true;
            }
            if (z) {
                if (this.f5426c) {
                    if (z2) {
                        Throwable th = this.i;
                        try {
                            if (th != null) {
                                lVar.onError(th);
                            } else {
                                lVar.onCompleted();
                            }
                        } finally {
                        }
                    }
                } else {
                    Throwable th2 = this.i;
                    if (th2 != null) {
                        queue.clear();
                        try {
                            lVar.onError(th2);
                            return true;
                        } finally {
                        }
                    } else if (z2) {
                        try {
                            lVar.onCompleted();
                            return true;
                        } finally {
                        }
                    }
                }
            }
            return false;
        }
    }
}
