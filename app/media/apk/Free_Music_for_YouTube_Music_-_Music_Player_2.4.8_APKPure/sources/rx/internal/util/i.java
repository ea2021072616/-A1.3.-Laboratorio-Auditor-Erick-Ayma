package rx.internal.util;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.f;
import rx.i;
import rx.l;
import rx.m;
/* compiled from: ScalarSynchronousObservable.java */
/* loaded from: classes2.dex */
public final class i<T> extends rx.f<T> {

    /* renamed from: c  reason: collision with root package name */
    static final boolean f5602c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* renamed from: b  reason: collision with root package name */
    final T f5603b;

    static <T> rx.h a(l<? super T> lVar, T t) {
        return f5602c ? new rx.internal.b.c(lVar, t) : new d(lVar, t);
    }

    public static <T> i<T> b(T t) {
        return new i<>(t);
    }

    protected i(T t) {
        super(rx.e.c.a(new a(t)));
        this.f5603b = t;
    }

    public T e() {
        return this.f5603b;
    }

    public rx.f<T> d(final rx.i iVar) {
        rx.c.e<rx.c.a, m> eVar;
        if (iVar instanceof rx.internal.c.b) {
            final rx.internal.c.b bVar = (rx.internal.c.b) iVar;
            eVar = new rx.c.e<rx.c.a, m>() { // from class: rx.internal.util.i.1
                @Override // rx.c.e
                public m a(rx.c.a aVar) {
                    return bVar.a(aVar);
                }
            };
        } else {
            eVar = new rx.c.e<rx.c.a, m>() { // from class: rx.internal.util.i.2
                @Override // rx.c.e
                public m a(final rx.c.a aVar) {
                    final i.a createWorker = iVar.createWorker();
                    createWorker.a(new rx.c.a() { // from class: rx.internal.util.i.2.1
                        @Override // rx.c.a
                        public void a() {
                            try {
                                aVar.a();
                            } finally {
                                createWorker.unsubscribe();
                            }
                        }
                    });
                    return createWorker;
                }
            };
        }
        return b((f.a) new b(this.f5603b, eVar));
    }

    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes2.dex */
    static final class a<T> implements f.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final T f5613a;

        a(T t) {
            this.f5613a = t;
        }

        @Override // rx.c.b
        /* renamed from: a */
        public void call(l<? super T> lVar) {
            lVar.setProducer(i.a(lVar, this.f5613a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes2.dex */
    public static final class b<T> implements f.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final T f5614a;

        /* renamed from: b  reason: collision with root package name */
        final rx.c.e<rx.c.a, m> f5615b;

        b(T t, rx.c.e<rx.c.a, m> eVar) {
            this.f5614a = t;
            this.f5615b = eVar;
        }

        @Override // rx.c.b
        /* renamed from: a */
        public void call(l<? super T> lVar) {
            lVar.setProducer(new c(lVar, this.f5614a, this.f5615b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes2.dex */
    public static final class c<T> extends AtomicBoolean implements rx.c.a, rx.h {
        private static final long serialVersionUID = -2466317989629281651L;

        /* renamed from: a  reason: collision with root package name */
        final l<? super T> f5616a;

        /* renamed from: b  reason: collision with root package name */
        final T f5617b;

        /* renamed from: c  reason: collision with root package name */
        final rx.c.e<rx.c.a, m> f5618c;

        public c(l<? super T> lVar, T t, rx.c.e<rx.c.a, m> eVar) {
            this.f5616a = lVar;
            this.f5617b = t;
            this.f5618c = eVar;
        }

        @Override // rx.h
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
            if (j != 0 && compareAndSet(false, true)) {
                this.f5616a.add(this.f5618c.a(this));
            }
        }

        @Override // rx.c.a
        public void a() {
            l<? super T> lVar = this.f5616a;
            if (!lVar.isUnsubscribed()) {
                Object obj = (T) this.f5617b;
                try {
                    lVar.onNext(obj);
                    if (!lVar.isUnsubscribed()) {
                        lVar.onCompleted();
                    }
                } catch (Throwable th) {
                    rx.b.b.a(th, lVar, obj);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.f5617b + ", " + get() + "]";
        }
    }

    public <R> rx.f<R> f(final rx.c.e<? super T, ? extends rx.f<? extends R>> eVar) {
        return b((f.a) new f.a<R>() { // from class: rx.internal.util.i.3
            @Override // rx.c.b
            /* renamed from: a */
            public void call(l<? super R> lVar) {
                rx.f fVar = (rx.f) eVar.a(i.this.f5603b);
                if (fVar instanceof i) {
                    lVar.setProducer(i.a(lVar, ((i) fVar).f5603b));
                } else {
                    fVar.a((l) rx.d.e.a((l) lVar));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes2.dex */
    public static final class d<T> implements rx.h {

        /* renamed from: a  reason: collision with root package name */
        final l<? super T> f5619a;

        /* renamed from: b  reason: collision with root package name */
        final T f5620b;

        /* renamed from: c  reason: collision with root package name */
        boolean f5621c;

        public d(l<? super T> lVar, T t) {
            this.f5619a = lVar;
            this.f5620b = t;
        }

        @Override // rx.h
        public void request(long j) {
            if (!this.f5621c) {
                if (j < 0) {
                    throw new IllegalStateException("n >= required but it was " + j);
                }
                if (j != 0) {
                    this.f5621c = true;
                    l<? super T> lVar = this.f5619a;
                    if (!lVar.isUnsubscribed()) {
                        Object obj = (T) this.f5620b;
                        try {
                            lVar.onNext(obj);
                            if (!lVar.isUnsubscribed()) {
                                lVar.onCompleted();
                            }
                        } catch (Throwable th) {
                            rx.b.b.a(th, lVar, obj);
                        }
                    }
                }
            }
        }
    }
}
