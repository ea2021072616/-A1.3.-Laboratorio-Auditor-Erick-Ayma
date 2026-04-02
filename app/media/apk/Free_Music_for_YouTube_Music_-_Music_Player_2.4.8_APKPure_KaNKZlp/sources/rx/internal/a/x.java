package rx.internal.a;

import rx.f;
import rx.i;
/* compiled from: OperatorUnsubscribeOn.java */
/* loaded from: classes2.dex */
public class x<T> implements f.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.i f5451a;

    @Override // rx.c.e
    public /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((rx.l) ((rx.l) obj));
    }

    public x(rx.i iVar) {
        this.f5451a = iVar;
    }

    public rx.l<? super T> a(final rx.l<? super T> lVar) {
        final rx.l lVar2 = (rx.l<T>) new rx.l<T>() { // from class: rx.internal.a.x.1
            @Override // rx.g
            public void onCompleted() {
                lVar.onCompleted();
            }

            @Override // rx.g
            public void onError(Throwable th) {
                lVar.onError(th);
            }

            @Override // rx.g
            public void onNext(T t) {
                lVar.onNext(t);
            }
        };
        lVar.add(rx.g.e.a(new rx.c.a() { // from class: rx.internal.a.x.2
            @Override // rx.c.a
            public void a() {
                final i.a createWorker = x.this.f5451a.createWorker();
                createWorker.a(new rx.c.a() { // from class: rx.internal.a.x.2.1
                    @Override // rx.c.a
                    public void a() {
                        lVar2.unsubscribe();
                        createWorker.unsubscribe();
                    }
                });
            }
        }));
        return lVar2;
    }
}
