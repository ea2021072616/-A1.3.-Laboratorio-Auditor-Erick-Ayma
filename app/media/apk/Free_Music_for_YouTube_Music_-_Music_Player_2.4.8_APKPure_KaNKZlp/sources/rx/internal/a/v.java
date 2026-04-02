package rx.internal.a;

import rx.f;
/* compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* loaded from: classes2.dex */
public final class v<T> implements f.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.c.e<? super Throwable, ? extends rx.f<? extends T>> f5435a;

    @Override // rx.c.e
    public /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((rx.l) ((rx.l) obj));
    }

    public static <T> v<T> a(final rx.c.e<? super Throwable, ? extends T> eVar) {
        return new v<>(new rx.c.e<Throwable, rx.f<? extends T>>() { // from class: rx.internal.a.v.1
            @Override // rx.c.e
            public rx.f<? extends T> a(Throwable th) {
                return rx.f.a(rx.c.e.this.a(th));
            }
        });
    }

    public v(rx.c.e<? super Throwable, ? extends rx.f<? extends T>> eVar) {
        this.f5435a = eVar;
    }

    public rx.l<? super T> a(final rx.l<? super T> lVar) {
        final rx.internal.b.a aVar = new rx.internal.b.a();
        final rx.g.d dVar = new rx.g.d();
        rx.l lVar2 = (rx.l<T>) new rx.l<T>() { // from class: rx.internal.a.v.2

            /* renamed from: a  reason: collision with root package name */
            long f5437a;
            private boolean f;

            @Override // rx.g
            public void onCompleted() {
                if (!this.f) {
                    this.f = true;
                    lVar.onCompleted();
                }
            }

            @Override // rx.g
            public void onError(Throwable th) {
                if (this.f) {
                    rx.b.b.b(th);
                    rx.e.c.a(th);
                    return;
                }
                this.f = true;
                try {
                    unsubscribe();
                    rx.l<T> lVar3 = new rx.l<T>() { // from class: rx.internal.a.v.2.1
                        @Override // rx.g
                        public void onNext(T t) {
                            lVar.onNext(t);
                        }

                        @Override // rx.g
                        public void onError(Throwable th2) {
                            lVar.onError(th2);
                        }

                        @Override // rx.g
                        public void onCompleted() {
                            lVar.onCompleted();
                        }

                        @Override // rx.l
                        public void setProducer(rx.h hVar) {
                            aVar.a(hVar);
                        }
                    };
                    dVar.a(lVar3);
                    long j = this.f5437a;
                    if (j != 0) {
                        aVar.a(j);
                    }
                    v.this.f5435a.a(th).a((rx.l<? super Object>) lVar3);
                } catch (Throwable th2) {
                    rx.b.b.a(th2, lVar);
                }
            }

            @Override // rx.g
            public void onNext(T t) {
                if (!this.f) {
                    this.f5437a++;
                    lVar.onNext(t);
                }
            }

            @Override // rx.l
            public void setProducer(rx.h hVar) {
                aVar.a(hVar);
            }
        };
        dVar.a(lVar2);
        lVar.add(dVar);
        lVar.setProducer(aVar);
        return lVar2;
    }
}
