package rx.internal.a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.f;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
/* compiled from: OnSubscribeCreate.java */
/* loaded from: classes2.dex */
public final class e<T> implements f.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.c.b<rx.d<T>> f5329a;

    /* renamed from: b  reason: collision with root package name */
    final d.a f5330b;

    @Override // rx.c.b
    /* renamed from: a */
    public void call(rx.l<? super T> lVar) {
        a c0111e;
        switch (this.f5330b) {
            case NONE:
                c0111e = new g(lVar);
                break;
            case ERROR:
                c0111e = new d(lVar);
                break;
            case DROP:
                c0111e = new c(lVar);
                break;
            case LATEST:
                c0111e = new C0111e(lVar);
                break;
            default:
                c0111e = new b(lVar, rx.internal.util.g.f5597b);
                break;
        }
        lVar.add(c0111e);
        lVar.setProducer(c0111e);
        this.f5329a.call(c0111e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: classes2.dex */
    public static abstract class a<T> extends AtomicLong implements rx.d<T>, rx.h, rx.m {
        private static final long serialVersionUID = 7326289992464377023L;

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f5332a;

        /* renamed from: b  reason: collision with root package name */
        final rx.g.d f5333b = new rx.g.d();

        public a(rx.l<? super T> lVar) {
            this.f5332a = lVar;
        }

        @Override // rx.g
        public void onCompleted() {
            if (!this.f5332a.isUnsubscribed()) {
                try {
                    this.f5332a.onCompleted();
                } finally {
                    this.f5333b.unsubscribe();
                }
            }
        }

        @Override // rx.g
        public void onError(Throwable th) {
            if (!this.f5332a.isUnsubscribed()) {
                try {
                    this.f5332a.onError(th);
                } finally {
                    this.f5333b.unsubscribe();
                }
            }
        }

        @Override // rx.m
        public final void unsubscribe() {
            this.f5333b.unsubscribe();
            a();
        }

        void a() {
        }

        @Override // rx.m
        public final boolean isUnsubscribed() {
            return this.f5333b.isUnsubscribed();
        }

        @Override // rx.h
        public final void request(long j) {
            if (rx.internal.a.a.a(j)) {
                rx.internal.a.a.a(this, j);
                b();
            }
        }

        void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: classes2.dex */
    public static final class g<T> extends a<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public g(rx.l<? super T> lVar) {
            super(lVar);
        }

        @Override // rx.g
        public void onNext(T t) {
            long j;
            if (!this.f5332a.isUnsubscribed()) {
                this.f5332a.onNext(t);
                do {
                    j = get();
                    if (j == 0) {
                        return;
                    }
                } while (!compareAndSet(j, j - 1));
            }
        }
    }

    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: classes2.dex */
    static abstract class f<T> extends a<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        abstract void c();

        public f(rx.l<? super T> lVar) {
            super(lVar);
        }

        public void onNext(T t) {
            if (!this.f5332a.isUnsubscribed()) {
                if (get() != 0) {
                    this.f5332a.onNext(t);
                    rx.internal.a.a.b(this, 1L);
                    return;
                }
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: classes2.dex */
    public static final class c<T> extends f<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public c(rx.l<? super T> lVar) {
            super(lVar);
        }

        @Override // rx.internal.a.e.f
        void c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: classes2.dex */
    public static final class d<T> extends f<T> {
        private static final long serialVersionUID = 338953216916120960L;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5335c;

        public d(rx.l<? super T> lVar) {
            super(lVar);
        }

        @Override // rx.internal.a.e.f, rx.g
        public void onNext(T t) {
            if (!this.f5335c) {
                super.onNext(t);
            }
        }

        @Override // rx.internal.a.e.a, rx.g
        public void onCompleted() {
            if (!this.f5335c) {
                this.f5335c = true;
                super.onCompleted();
            }
        }

        @Override // rx.internal.a.e.a, rx.g
        public void onError(Throwable th) {
            if (this.f5335c) {
                rx.e.c.a(th);
                return;
            }
            this.f5335c = true;
            super.onError(th);
        }

        @Override // rx.internal.a.e.f
        void c() {
            onError(new rx.b.c("create: could not emit value due to lack of requests"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: classes2.dex */
    public static final class b<T> extends a<T> {
        private static final long serialVersionUID = 2427151001689639875L;

        /* renamed from: c  reason: collision with root package name */
        final Queue<Object> f5334c;
        Throwable d;
        volatile boolean e;
        final AtomicInteger f;

        public b(rx.l<? super T> lVar, int i) {
            super(lVar);
            this.f5334c = UnsafeAccess.isUnsafeAvailable() ? new SpscUnboundedArrayQueue<>(i) : new rx.internal.util.a.e<>(i);
            this.f = new AtomicInteger();
        }

        @Override // rx.g
        public void onNext(T t) {
            this.f5334c.offer(rx.internal.a.d.a(t));
            c();
        }

        @Override // rx.internal.a.e.a, rx.g
        public void onError(Throwable th) {
            this.d = th;
            this.e = true;
            c();
        }

        @Override // rx.internal.a.e.a, rx.g
        public void onCompleted() {
            this.e = true;
            c();
        }

        @Override // rx.internal.a.e.a
        void b() {
            c();
        }

        @Override // rx.internal.a.e.a
        void a() {
            if (this.f.getAndIncrement() == 0) {
                this.f5334c.clear();
            }
        }

        void c() {
            if (this.f.getAndIncrement() == 0) {
                rx.l<? super T> lVar = this.f5332a;
                Queue<Object> queue = this.f5334c;
                int i = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (lVar.isUnsubscribed()) {
                            queue.clear();
                            return;
                        }
                        boolean z = this.e;
                        Object poll = queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.d;
                            if (th != null) {
                                super.onError(th);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            lVar.onNext((Object) rx.internal.a.d.c(poll));
                            j2 = 1 + j2;
                        }
                    }
                    if (j2 == j) {
                        if (lVar.isUnsubscribed()) {
                            queue.clear();
                            return;
                        }
                        boolean z3 = this.e;
                        boolean isEmpty = queue.isEmpty();
                        if (z3 && isEmpty) {
                            Throwable th2 = this.d;
                            if (th2 != null) {
                                super.onError(th2);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        rx.internal.a.a.b(this, j2);
                    }
                    i = this.f.addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: rx.internal.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0111e<T> extends a<T> {
        private static final long serialVersionUID = 4023437720691792495L;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<Object> f5336c;
        Throwable d;
        volatile boolean e;
        final AtomicInteger f;

        public C0111e(rx.l<? super T> lVar) {
            super(lVar);
            this.f5336c = new AtomicReference<>();
            this.f = new AtomicInteger();
        }

        @Override // rx.g
        public void onNext(T t) {
            this.f5336c.set(rx.internal.a.d.a(t));
            c();
        }

        @Override // rx.internal.a.e.a, rx.g
        public void onError(Throwable th) {
            this.d = th;
            this.e = true;
            c();
        }

        @Override // rx.internal.a.e.a, rx.g
        public void onCompleted() {
            this.e = true;
            c();
        }

        @Override // rx.internal.a.e.a
        void b() {
            c();
        }

        @Override // rx.internal.a.e.a
        void a() {
            if (this.f.getAndIncrement() == 0) {
                this.f5336c.lazySet(null);
            }
        }

        void c() {
            if (this.f.getAndIncrement() == 0) {
                rx.l<? super T> lVar = this.f5332a;
                AtomicReference<Object> atomicReference = this.f5336c;
                int i = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (lVar.isUnsubscribed()) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean z = this.e;
                        Object andSet = atomicReference.getAndSet(null);
                        boolean z2 = andSet == null;
                        if (z && z2) {
                            Throwable th = this.d;
                            if (th != null) {
                                super.onError(th);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            lVar.onNext((Object) rx.internal.a.d.c(andSet));
                            j2++;
                        }
                    }
                    if (j2 == j) {
                        if (lVar.isUnsubscribed()) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean z3 = this.e;
                        boolean z4 = atomicReference.get() == null;
                        if (z3 && z4) {
                            Throwable th2 = this.d;
                            if (th2 != null) {
                                super.onError(th2);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        rx.internal.a.a.b(this, j2);
                    }
                    i = this.f.addAndGet(-i);
                } while (i != 0);
            }
        }
    }
}
