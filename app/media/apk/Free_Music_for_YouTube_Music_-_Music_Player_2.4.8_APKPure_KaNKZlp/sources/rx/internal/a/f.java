package rx.internal.a;

import rx.f;
/* compiled from: OnSubscribeDefer.java */
/* loaded from: classes2.dex */
public final class f<T> implements f.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.c.d<? extends rx.f<? extends T>> f5337a;

    public f(rx.c.d<? extends rx.f<? extends T>> dVar) {
        this.f5337a = dVar;
    }

    @Override // rx.c.b
    /* renamed from: a */
    public void call(rx.l<? super T> lVar) {
        try {
            this.f5337a.call().a(rx.d.e.a((rx.l) lVar));
        } catch (Throwable th) {
            rx.b.b.a(th, lVar);
        }
    }
}
