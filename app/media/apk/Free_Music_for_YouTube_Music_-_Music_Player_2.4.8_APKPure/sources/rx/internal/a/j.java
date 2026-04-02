package rx.internal.a;

import rx.f;
/* compiled from: OnSubscribeMap.java */
/* loaded from: classes2.dex */
public final class j<T, R> implements f.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final rx.f<T> f5350a;

    /* renamed from: b  reason: collision with root package name */
    final rx.c.e<? super T, ? extends R> f5351b;

    public j(rx.f<T> fVar, rx.c.e<? super T, ? extends R> eVar) {
        this.f5350a = fVar;
        this.f5351b = eVar;
    }

    @Override // rx.c.b
    /* renamed from: a */
    public void call(rx.l<? super R> lVar) {
        a aVar = new a(lVar, this.f5351b);
        lVar.add(aVar);
        this.f5350a.a((rx.l) aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeMap.java */
    /* loaded from: classes2.dex */
    public static final class a<T, R> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super R> f5352a;

        /* renamed from: b  reason: collision with root package name */
        final rx.c.e<? super T, ? extends R> f5353b;

        /* renamed from: c  reason: collision with root package name */
        boolean f5354c;

        public a(rx.l<? super R> lVar, rx.c.e<? super T, ? extends R> eVar) {
            this.f5352a = lVar;
            this.f5353b = eVar;
        }

        @Override // rx.g
        public void onNext(T t) {
            try {
                this.f5352a.onNext(this.f5353b.a(t));
            } catch (Throwable th) {
                rx.b.b.b(th);
                unsubscribe();
                onError(rx.b.g.a(th, t));
            }
        }

        @Override // rx.g
        public void onError(Throwable th) {
            if (this.f5354c) {
                rx.e.c.a(th);
                return;
            }
            this.f5354c = true;
            this.f5352a.onError(th);
        }

        @Override // rx.g
        public void onCompleted() {
            if (!this.f5354c) {
                this.f5352a.onCompleted();
            }
        }

        @Override // rx.l
        public void setProducer(rx.h hVar) {
            this.f5352a.setProducer(hVar);
        }
    }
}
