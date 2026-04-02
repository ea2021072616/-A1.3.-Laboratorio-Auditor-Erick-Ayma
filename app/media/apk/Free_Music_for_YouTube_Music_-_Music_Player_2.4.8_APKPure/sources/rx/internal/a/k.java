package rx.internal.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.f;
import rx.i;
import rx.schedulers.Schedulers;
/* compiled from: OnSubscribeRedo.java */
/* loaded from: classes2.dex */
public final class k<T> implements f.a<T> {
    static final rx.c.e<rx.f<? extends rx.e<?>>, rx.f<?>> d = new rx.c.e<rx.f<? extends rx.e<?>>, rx.f<?>>() { // from class: rx.internal.a.k.1
        @Override // rx.c.e
        public rx.f<?> a(rx.f<? extends rx.e<?>> fVar) {
            return fVar.c(new rx.c.e<rx.e<?>, rx.e<?>>() { // from class: rx.internal.a.k.1.1
                @Override // rx.c.e
                public rx.e<?> a(rx.e<?> eVar) {
                    return rx.e.a((Object) null);
                }
            });
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final rx.f<T> f5355a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f5356b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f5357c;
    private final rx.c.e<? super rx.f<? extends rx.e<?>>, ? extends rx.f<?>> e;
    private final rx.i f;

    public static <T> rx.f<T> a(rx.f<T> fVar, rx.c.e<? super rx.f<? extends rx.e<?>>, ? extends rx.f<?>> eVar) {
        return rx.f.b((f.a) new k(fVar, eVar, true, false, Schedulers.trampoline()));
    }

    private k(rx.f<T> fVar, rx.c.e<? super rx.f<? extends rx.e<?>>, ? extends rx.f<?>> eVar, boolean z, boolean z2, rx.i iVar) {
        this.f5355a = fVar;
        this.e = eVar;
        this.f5356b = z;
        this.f5357c = z2;
        this.f = iVar;
    }

    @Override // rx.c.b
    /* renamed from: a */
    public void call(final rx.l<? super T> lVar) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final AtomicLong atomicLong = new AtomicLong();
        final i.a createWorker = this.f.createWorker();
        lVar.add(createWorker);
        final rx.g.d dVar = new rx.g.d();
        lVar.add(dVar);
        final rx.f.c<T, T> f = rx.f.a.e().f();
        f.b(rx.d.e.a());
        final rx.internal.b.a aVar = new rx.internal.b.a();
        final rx.c.a aVar2 = new rx.c.a() { // from class: rx.internal.a.k.2
            @Override // rx.c.a
            public void a() {
                if (!lVar.isUnsubscribed()) {
                    rx.l<T> lVar2 = new rx.l<T>() { // from class: rx.internal.a.k.2.1

                        /* renamed from: a  reason: collision with root package name */
                        boolean f5362a;

                        @Override // rx.g
                        public void onCompleted() {
                            if (!this.f5362a) {
                                this.f5362a = true;
                                unsubscribe();
                                f.onNext(rx.e.a());
                            }
                        }

                        @Override // rx.g
                        public void onError(Throwable th) {
                            if (!this.f5362a) {
                                this.f5362a = true;
                                unsubscribe();
                                f.onNext(rx.e.a(th));
                            }
                        }

                        @Override // rx.g
                        public void onNext(T t) {
                            if (!this.f5362a) {
                                lVar.onNext(t);
                                a();
                                aVar.a(1L);
                            }
                        }

                        private void a() {
                            long j;
                            do {
                                j = atomicLong.get();
                                if (j == Long.MAX_VALUE) {
                                    return;
                                }
                            } while (!atomicLong.compareAndSet(j, j - 1));
                        }

                        @Override // rx.l
                        public void setProducer(rx.h hVar) {
                            aVar.a(hVar);
                        }
                    };
                    dVar.a(lVar2);
                    k.this.f5355a.a((rx.l) lVar2);
                }
            }
        };
        final rx.f<?> a2 = this.e.a(f.a((f.b<? extends T, ? super T>) new f.b<rx.e<?>, rx.e<?>>() { // from class: rx.internal.a.k.3
            @Override // rx.c.e
            public rx.l<? super rx.e<?>> a(final rx.l<? super rx.e<?>> lVar2) {
                return new rx.l<rx.e<?>>(lVar2) { // from class: rx.internal.a.k.3.1
                    @Override // rx.g
                    public void onCompleted() {
                        lVar2.onCompleted();
                    }

                    @Override // rx.g
                    public void onError(Throwable th) {
                        lVar2.onError(th);
                    }

                    @Override // rx.g
                    /* renamed from: a */
                    public void onNext(rx.e<?> eVar) {
                        if (eVar.h() && k.this.f5356b) {
                            lVar2.onCompleted();
                        } else if (eVar.g() && k.this.f5357c) {
                            lVar2.onError(eVar.b());
                        } else {
                            lVar2.onNext(eVar);
                        }
                    }

                    @Override // rx.l
                    public void setProducer(rx.h hVar) {
                        hVar.request(Long.MAX_VALUE);
                    }
                };
            }
        }));
        createWorker.a(new rx.c.a() { // from class: rx.internal.a.k.4
            @Override // rx.c.a
            public void a() {
                a2.a((rx.l) new rx.l<Object>(lVar) { // from class: rx.internal.a.k.4.1
                    @Override // rx.g
                    public void onCompleted() {
                        lVar.onCompleted();
                    }

                    @Override // rx.g
                    public void onError(Throwable th) {
                        lVar.onError(th);
                    }

                    @Override // rx.g
                    public void onNext(Object obj) {
                        if (!lVar.isUnsubscribed()) {
                            if (atomicLong.get() > 0) {
                                createWorker.a(aVar2);
                            } else {
                                atomicBoolean.compareAndSet(false, true);
                            }
                        }
                    }

                    @Override // rx.l
                    public void setProducer(rx.h hVar) {
                        hVar.request(Long.MAX_VALUE);
                    }
                });
            }
        });
        lVar.setProducer(new rx.h() { // from class: rx.internal.a.k.5
            @Override // rx.h
            public void request(long j) {
                if (j > 0) {
                    a.a(atomicLong, j);
                    aVar.request(j);
                    if (atomicBoolean.compareAndSet(true, false)) {
                        createWorker.a(aVar2);
                    }
                }
            }
        });
    }
}
