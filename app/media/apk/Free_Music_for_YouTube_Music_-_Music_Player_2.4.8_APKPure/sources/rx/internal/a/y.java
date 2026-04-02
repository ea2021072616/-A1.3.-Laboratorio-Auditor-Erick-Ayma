package rx.internal.a;

import java.util.concurrent.atomic.AtomicLong;
import rx.f;
/* compiled from: OperatorZip.java */
/* loaded from: classes2.dex */
public final class y<R> implements f.b<R, rx.f<?>[]> {

    /* renamed from: a  reason: collision with root package name */
    final rx.c.g<? extends R> f5458a;

    @Override // rx.c.e
    public /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((rx.l) ((rx.l) obj));
    }

    public y(rx.c.f fVar) {
        this.f5458a = rx.c.h.a(fVar);
    }

    public rx.l<? super rx.f[]> a(rx.l<? super R> lVar) {
        a aVar = new a(lVar, this.f5458a);
        b bVar = new b(aVar);
        c cVar = new c(lVar, aVar, bVar);
        lVar.add(cVar);
        lVar.setProducer(bVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorZip.java */
    /* loaded from: classes2.dex */
    public final class c extends rx.l<rx.f[]> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super R> f5465a;

        /* renamed from: b  reason: collision with root package name */
        final a<R> f5466b;

        /* renamed from: c  reason: collision with root package name */
        final b<R> f5467c;
        boolean d;

        public c(rx.l<? super R> lVar, a<R> aVar, b<R> bVar) {
            this.f5465a = lVar;
            this.f5466b = aVar;
            this.f5467c = bVar;
        }

        @Override // rx.g
        public void onCompleted() {
            if (!this.d) {
                this.f5465a.onCompleted();
            }
        }

        @Override // rx.g
        public void onError(Throwable th) {
            this.f5465a.onError(th);
        }

        @Override // rx.g
        /* renamed from: a */
        public void onNext(rx.f[] fVarArr) {
            if (fVarArr == null || fVarArr.length == 0) {
                this.f5465a.onCompleted();
                return;
            }
            this.d = true;
            this.f5466b.a(fVarArr, this.f5467c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorZip.java */
    /* loaded from: classes2.dex */
    public static final class b<R> extends AtomicLong implements rx.h {
        private static final long serialVersionUID = -1216676403723546796L;

        /* renamed from: a  reason: collision with root package name */
        final a<R> f5464a;

        public b(a<R> aVar) {
            this.f5464a = aVar;
        }

        @Override // rx.h
        public void request(long j) {
            rx.internal.a.a.a(this, j);
            this.f5464a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorZip.java */
    /* loaded from: classes2.dex */
    public static final class a<R> extends AtomicLong {

        /* renamed from: b  reason: collision with root package name */
        static final int f5459b = (int) (rx.internal.util.g.f5597b * 0.7d);
        private static final long serialVersionUID = 5995274816189928317L;

        /* renamed from: a  reason: collision with root package name */
        final rx.g<? super R> f5460a;

        /* renamed from: c  reason: collision with root package name */
        int f5461c;
        private final rx.c.g<? extends R> d;
        private final rx.g.b e = new rx.g.b();
        private volatile Object[] f;
        private AtomicLong g;

        public a(rx.l<? super R> lVar, rx.c.g<? extends R> gVar) {
            this.f5460a = lVar;
            this.d = gVar;
            lVar.add(this.e);
        }

        public void a(rx.f[] fVarArr, AtomicLong atomicLong) {
            Object[] objArr = new Object[fVarArr.length];
            for (int i = 0; i < fVarArr.length; i++) {
                C0115a c0115a = new C0115a();
                objArr[i] = c0115a;
                this.e.a(c0115a);
            }
            this.g = atomicLong;
            this.f = objArr;
            for (int i2 = 0; i2 < fVarArr.length; i2++) {
                fVarArr[i2].a((rx.l) ((C0115a) objArr[i2]));
            }
        }

        void a() {
            boolean z;
            Object[] objArr = this.f;
            if (objArr != null && getAndIncrement() == 0) {
                int length = objArr.length;
                rx.g<? super R> gVar = this.f5460a;
                AtomicLong atomicLong = this.g;
                while (true) {
                    Object[] objArr2 = new Object[length];
                    boolean z2 = true;
                    int i = 0;
                    while (i < length) {
                        rx.internal.util.g gVar2 = ((C0115a) objArr[i]).f5462a;
                        Object g = gVar2.g();
                        if (g == null) {
                            z = false;
                        } else if (gVar2.b(g)) {
                            gVar.onCompleted();
                            this.e.unsubscribe();
                            return;
                        } else {
                            objArr2[i] = gVar2.c(g);
                            z = z2;
                        }
                        i++;
                        z2 = z;
                    }
                    if (z2 && atomicLong.get() > 0) {
                        try {
                            gVar.onNext((R) this.d.a(objArr2));
                            atomicLong.decrementAndGet();
                            this.f5461c++;
                            for (Object obj : objArr) {
                                rx.internal.util.g gVar3 = ((C0115a) obj).f5462a;
                                gVar3.f();
                                if (gVar3.b(gVar3.g())) {
                                    gVar.onCompleted();
                                    this.e.unsubscribe();
                                    return;
                                }
                            }
                            if (this.f5461c > f5459b) {
                                for (Object obj2 : objArr) {
                                    ((C0115a) obj2).a(this.f5461c);
                                }
                                this.f5461c = 0;
                            }
                        } catch (Throwable th) {
                            rx.b.b.a(th, gVar, objArr2);
                            return;
                        }
                    } else if (decrementAndGet() <= 0) {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorZip.java */
        /* renamed from: rx.internal.a.y$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public final class C0115a extends rx.l {

            /* renamed from: a  reason: collision with root package name */
            final rx.internal.util.g f5462a = rx.internal.util.g.b();

            C0115a() {
            }

            @Override // rx.l
            public void onStart() {
                request(rx.internal.util.g.f5597b);
            }

            public void a(long j) {
                request(j);
            }

            @Override // rx.g
            public void onCompleted() {
                this.f5462a.d();
                a.this.a();
            }

            @Override // rx.g
            public void onError(Throwable th) {
                a.this.f5460a.onError(th);
            }

            @Override // rx.g
            public void onNext(Object obj) {
                try {
                    this.f5462a.a(obj);
                } catch (rx.b.c e) {
                    onError(e);
                }
                a.this.a();
            }
        }
    }
}
