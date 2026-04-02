package rx.internal.util;
/* compiled from: ActionObserver.java */
/* loaded from: classes2.dex */
public final class a<T> implements rx.g<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.c.b<? super T> f5570a;

    /* renamed from: b  reason: collision with root package name */
    final rx.c.b<? super Throwable> f5571b;

    /* renamed from: c  reason: collision with root package name */
    final rx.c.a f5572c;

    public a(rx.c.b<? super T> bVar, rx.c.b<? super Throwable> bVar2, rx.c.a aVar) {
        this.f5570a = bVar;
        this.f5571b = bVar2;
        this.f5572c = aVar;
    }

    @Override // rx.g
    public void onNext(T t) {
        this.f5570a.call(t);
    }

    @Override // rx.g
    public void onError(Throwable th) {
        this.f5571b.call(th);
    }

    @Override // rx.g
    public void onCompleted() {
        this.f5572c.a();
    }
}
