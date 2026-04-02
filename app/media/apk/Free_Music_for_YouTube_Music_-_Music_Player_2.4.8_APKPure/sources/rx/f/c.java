package rx.f;

import rx.f;
import rx.l;
/* compiled from: SerializedSubject.java */
/* loaded from: classes2.dex */
public class c<T, R> extends d<T, R> {

    /* renamed from: b  reason: collision with root package name */
    private final rx.d.c<T> f5291b;

    /* renamed from: c  reason: collision with root package name */
    private final d<T, R> f5292c;

    public c(final d<T, R> dVar) {
        super(new f.a<R>() { // from class: rx.f.c.1
            @Override // rx.c.b
            /* renamed from: a */
            public void call(l<? super R> lVar) {
                d.this.a((l) lVar);
            }
        });
        this.f5292c = dVar;
        this.f5291b = new rx.d.c<>(dVar);
    }

    @Override // rx.g
    public void onCompleted() {
        this.f5291b.onCompleted();
    }

    @Override // rx.g
    public void onError(Throwable th) {
        this.f5291b.onError(th);
    }

    @Override // rx.g
    public void onNext(T t) {
        this.f5291b.onNext(t);
    }
}
