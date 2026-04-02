package rx.internal.a;

import rx.f;
import rx.internal.a.z;
import rx.j;
/* compiled from: SingleLiftObservableOperator.java */
/* loaded from: classes2.dex */
public final class aa<T, R> implements j.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final j.a<T> f5312a;

    /* renamed from: b  reason: collision with root package name */
    final f.b<? extends R, ? super T> f5313b;

    @Override // rx.c.b
    /* renamed from: a */
    public void call(rx.k<? super R> kVar) {
        z.a aVar = new z.a(kVar);
        kVar.a((rx.m) aVar);
        try {
            rx.l<? super T> a2 = rx.e.c.b(this.f5313b).a(aVar);
            rx.k a3 = a(a2);
            a2.onStart();
            this.f5312a.call(a3);
        } catch (Throwable th) {
            rx.b.b.a(th, kVar);
        }
    }

    public static <T> rx.k<T> a(rx.l<T> lVar) {
        a aVar = new a(lVar);
        lVar.add(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleLiftObservableOperator.java */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.k<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f5314a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(rx.l<? super T> lVar) {
            this.f5314a = lVar;
        }

        @Override // rx.k
        public void a(T t) {
            this.f5314a.setProducer(new rx.internal.b.c(this.f5314a, t));
        }

        @Override // rx.k
        public void a(Throwable th) {
            this.f5314a.onError(th);
        }
    }
}
