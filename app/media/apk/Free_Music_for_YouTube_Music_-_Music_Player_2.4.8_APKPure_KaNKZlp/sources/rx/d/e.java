package rx.d;

import rx.g;
import rx.l;
/* compiled from: Subscribers.java */
/* loaded from: classes2.dex */
public final class e {
    public static <T> l<T> a() {
        return a(a.a());
    }

    public static <T> l<T> a(final g<? super T> gVar) {
        return new l<T>() { // from class: rx.d.e.1
            @Override // rx.g
            public void onCompleted() {
                g.this.onCompleted();
            }

            @Override // rx.g
            public void onError(Throwable th) {
                g.this.onError(th);
            }

            @Override // rx.g
            public void onNext(T t) {
                g.this.onNext(t);
            }
        };
    }

    public static <T> l<T> a(final l<? super T> lVar) {
        return new l<T>(lVar) { // from class: rx.d.e.2
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
    }
}
