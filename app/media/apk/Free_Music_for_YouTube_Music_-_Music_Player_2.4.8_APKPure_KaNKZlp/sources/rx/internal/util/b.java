package rx.internal.util;

import rx.l;
/* compiled from: ActionSubscriber.java */
/* loaded from: classes2.dex */
public final class b<T> extends l<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.c.b<? super T> f5583a;

    /* renamed from: b  reason: collision with root package name */
    final rx.c.b<Throwable> f5584b;

    /* renamed from: c  reason: collision with root package name */
    final rx.c.a f5585c;

    public b(rx.c.b<? super T> bVar, rx.c.b<Throwable> bVar2, rx.c.a aVar) {
        this.f5583a = bVar;
        this.f5584b = bVar2;
        this.f5585c = aVar;
    }

    @Override // rx.g
    public void onNext(T t) {
        this.f5583a.call(t);
    }

    @Override // rx.g
    public void onError(Throwable th) {
        this.f5584b.call(th);
    }

    @Override // rx.g
    public void onCompleted() {
        this.f5585c.a();
    }
}
