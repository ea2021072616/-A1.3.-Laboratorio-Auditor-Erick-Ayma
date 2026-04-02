package rx.internal.a;

import rx.f;
/* compiled from: OnSubscribeFilter.java */
/* loaded from: classes2.dex */
public final class h<T> implements f.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.f<T> f5343a;

    /* renamed from: b  reason: collision with root package name */
    final rx.c.e<? super T, Boolean> f5344b;

    public h(rx.f<T> fVar, rx.c.e<? super T, Boolean> eVar) {
        this.f5343a = fVar;
        this.f5344b = eVar;
    }

    @Override // rx.c.b
    /* renamed from: a */
    public void call(rx.l<? super T> lVar) {
        a aVar = new a(lVar, this.f5344b);
        lVar.add(aVar);
        this.f5343a.a((rx.l) aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFilter.java */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f5345a;

        /* renamed from: b  reason: collision with root package name */
        final rx.c.e<? super T, Boolean> f5346b;

        /* renamed from: c  reason: collision with root package name */
        boolean f5347c;

        public a(rx.l<? super T> lVar, rx.c.e<? super T, Boolean> eVar) {
            this.f5345a = lVar;
            this.f5346b = eVar;
            request(0L);
        }

        @Override // rx.g
        public void onNext(T t) {
            try {
                if (this.f5346b.a(t).booleanValue()) {
                    this.f5345a.onNext(t);
                } else {
                    request(1L);
                }
            } catch (Throwable th) {
                rx.b.b.b(th);
                unsubscribe();
                onError(rx.b.g.a(th, t));
            }
        }

        @Override // rx.g
        public void onError(Throwable th) {
            if (this.f5347c) {
                rx.e.c.a(th);
                return;
            }
            this.f5347c = true;
            this.f5345a.onError(th);
        }

        @Override // rx.g
        public void onCompleted() {
            if (!this.f5347c) {
                this.f5345a.onCompleted();
            }
        }

        @Override // rx.l
        public void setProducer(rx.h hVar) {
            super.setProducer(hVar);
            this.f5345a.setProducer(hVar);
        }
    }
}
