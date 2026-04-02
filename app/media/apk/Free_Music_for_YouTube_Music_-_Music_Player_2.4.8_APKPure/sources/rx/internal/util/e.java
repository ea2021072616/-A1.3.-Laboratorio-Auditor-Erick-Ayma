package rx.internal.util;

import rx.l;
/* compiled from: ObserverSubscriber.java */
/* loaded from: classes2.dex */
public final class e<T> extends l<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.g<? super T> f5594a;

    public e(rx.g<? super T> gVar) {
        this.f5594a = gVar;
    }

    @Override // rx.g
    public void onNext(T t) {
        this.f5594a.onNext(t);
    }

    @Override // rx.g
    public void onError(Throwable th) {
        this.f5594a.onError(th);
    }

    @Override // rx.g
    public void onCompleted() {
        this.f5594a.onCompleted();
    }
}
