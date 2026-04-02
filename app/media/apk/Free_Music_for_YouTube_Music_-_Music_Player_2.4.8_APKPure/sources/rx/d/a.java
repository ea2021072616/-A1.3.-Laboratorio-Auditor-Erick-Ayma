package rx.d;

import rx.b.f;
import rx.g;
/* compiled from: Observers.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final g<Object> f5250a = new g<Object>() { // from class: rx.d.a.1
        @Override // rx.g
        public final void onCompleted() {
        }

        @Override // rx.g
        public final void onError(Throwable th) {
            throw new f(th);
        }

        @Override // rx.g
        public final void onNext(Object obj) {
        }
    };

    public static <T> g<T> a() {
        return (g<T>) f5250a;
    }
}
