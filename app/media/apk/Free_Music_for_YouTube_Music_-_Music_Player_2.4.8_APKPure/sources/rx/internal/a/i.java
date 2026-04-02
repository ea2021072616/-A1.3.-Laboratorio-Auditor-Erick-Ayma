package rx.internal.a;

import rx.f;
/* compiled from: OnSubscribeLift.java */
/* loaded from: classes2.dex */
public final class i<T, R> implements f.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final f.a<T> f5348a;

    /* renamed from: b  reason: collision with root package name */
    final f.b<? extends R, ? super T> f5349b;

    public i(f.a<T> aVar, f.b<? extends R, ? super T> bVar) {
        this.f5348a = aVar;
        this.f5349b = bVar;
    }

    @Override // rx.c.b
    /* renamed from: a */
    public void call(rx.l<? super R> lVar) {
        try {
            rx.l<? super T> a2 = rx.e.c.a(this.f5349b).a(lVar);
            a2.onStart();
            this.f5348a.call(a2);
        } catch (Throwable th) {
            rx.b.b.b(th);
            lVar.onError(th);
        }
    }
}
