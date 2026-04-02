package rx.internal.a;

import rx.f;
import rx.i;
/* compiled from: OperatorSubscribeOn.java */
/* loaded from: classes2.dex */
public final class w<T> implements f.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.i f5441a;

    /* renamed from: b  reason: collision with root package name */
    final rx.f<T> f5442b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f5443c;

    public w(rx.f<T> fVar, rx.i iVar, boolean z) {
        this.f5441a = iVar;
        this.f5442b = fVar;
        this.f5443c = z;
    }

    @Override // rx.c.b
    /* renamed from: a */
    public void call(rx.l<? super T> lVar) {
        i.a createWorker = this.f5441a.createWorker();
        a aVar = new a(lVar, this.f5443c, createWorker, this.f5442b);
        lVar.add(aVar);
        lVar.add(createWorker);
        createWorker.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSubscribeOn.java */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.l<T> implements rx.c.a {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f5444a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f5445b;

        /* renamed from: c  reason: collision with root package name */
        final i.a f5446c;
        rx.f<T> d;
        Thread e;

        a(rx.l<? super T> lVar, boolean z, i.a aVar, rx.f<T> fVar) {
            this.f5444a = lVar;
            this.f5445b = z;
            this.f5446c = aVar;
            this.d = fVar;
        }

        @Override // rx.g
        public void onNext(T t) {
            this.f5444a.onNext(t);
        }

        @Override // rx.g
        public void onError(Throwable th) {
            try {
                this.f5444a.onError(th);
            } finally {
                this.f5446c.unsubscribe();
            }
        }

        @Override // rx.g
        public void onCompleted() {
            try {
                this.f5444a.onCompleted();
            } finally {
                this.f5446c.unsubscribe();
            }
        }

        @Override // rx.c.a
        public void a() {
            rx.f<T> fVar = this.d;
            this.d = null;
            this.e = Thread.currentThread();
            fVar.a((rx.l) this);
        }

        @Override // rx.l
        public void setProducer(final rx.h hVar) {
            this.f5444a.setProducer(new rx.h() { // from class: rx.internal.a.w.a.1
                @Override // rx.h
                public void request(final long j) {
                    if (a.this.e == Thread.currentThread() || !a.this.f5445b) {
                        hVar.request(j);
                    } else {
                        a.this.f5446c.a(new rx.c.a() { // from class: rx.internal.a.w.a.1.1
                            @Override // rx.c.a
                            public void a() {
                                hVar.request(j);
                            }
                        });
                    }
                }
            });
        }
    }
}
