package rx.internal.a;

import rx.f;
/* compiled from: OperatorCast.java */
/* loaded from: classes2.dex */
public class q<T, R> implements f.b<R, T> {

    /* renamed from: a  reason: collision with root package name */
    final Class<R> f5395a;

    @Override // rx.c.e
    public /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((rx.l) ((rx.l) obj));
    }

    public q(Class<R> cls) {
        this.f5395a = cls;
    }

    public rx.l<? super T> a(rx.l<? super R> lVar) {
        a aVar = new a(lVar, this.f5395a);
        lVar.add(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorCast.java */
    /* loaded from: classes2.dex */
    public static final class a<T, R> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super R> f5396a;

        /* renamed from: b  reason: collision with root package name */
        final Class<R> f5397b;

        /* renamed from: c  reason: collision with root package name */
        boolean f5398c;

        public a(rx.l<? super R> lVar, Class<R> cls) {
            this.f5396a = lVar;
            this.f5397b = cls;
        }

        @Override // rx.g
        public void onNext(T t) {
            try {
                this.f5396a.onNext(this.f5397b.cast(t));
            } catch (Throwable th) {
                rx.b.b.b(th);
                unsubscribe();
                onError(rx.b.g.a(th, t));
            }
        }

        @Override // rx.g
        public void onError(Throwable th) {
            if (this.f5398c) {
                rx.e.c.a(th);
                return;
            }
            this.f5398c = true;
            this.f5396a.onError(th);
        }

        @Override // rx.g
        public void onCompleted() {
            if (!this.f5398c) {
                this.f5396a.onCompleted();
            }
        }

        @Override // rx.l
        public void setProducer(rx.h hVar) {
            this.f5396a.setProducer(hVar);
        }
    }
}
