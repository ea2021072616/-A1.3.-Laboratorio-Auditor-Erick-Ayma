package rx.internal.a;

import java.util.NoSuchElementException;
import rx.j;
/* compiled from: OnSubscribeSingle.java */
/* loaded from: classes2.dex */
public class l<T> implements j.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.f<T> f5374a;

    public l(rx.f<T> fVar) {
        this.f5374a = fVar;
    }

    @Override // rx.c.b
    /* renamed from: a */
    public void call(final rx.k<? super T> kVar) {
        rx.l<T> lVar = new rx.l<T>() { // from class: rx.internal.a.l.1

            /* renamed from: c  reason: collision with root package name */
            private boolean f5377c;
            private boolean d;
            private T e;

            @Override // rx.l
            public void onStart() {
                request(2L);
            }

            @Override // rx.g
            public void onCompleted() {
                if (!this.f5377c) {
                    if (this.d) {
                        kVar.a((rx.k) this.e);
                    } else {
                        kVar.a((Throwable) new NoSuchElementException("Observable emitted no items"));
                    }
                }
            }

            @Override // rx.g
            public void onError(Throwable th) {
                kVar.a(th);
                unsubscribe();
            }

            @Override // rx.g
            public void onNext(T t) {
                if (this.d) {
                    this.f5377c = true;
                    kVar.a((Throwable) new IllegalArgumentException("Observable emitted too many elements"));
                    unsubscribe();
                    return;
                }
                this.d = true;
                this.e = t;
            }
        };
        kVar.a((rx.m) lVar);
        this.f5374a.a((rx.l) lVar);
    }

    public static <T> l<T> a(rx.f<T> fVar) {
        return new l<>(fVar);
    }
}
