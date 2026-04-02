package rx.d;

import rx.g;
import rx.l;
/* compiled from: SerializedSubscriber.java */
/* loaded from: classes2.dex */
public class d<T> extends l<T> {

    /* renamed from: a  reason: collision with root package name */
    private final g<T> f5261a;

    public d(l<? super T> lVar) {
        this(lVar, true);
    }

    public d(l<? super T> lVar, boolean z) {
        super(lVar, z);
        this.f5261a = new c(lVar);
    }

    @Override // rx.g
    public void onCompleted() {
        this.f5261a.onCompleted();
    }

    @Override // rx.g
    public void onError(Throwable th) {
        this.f5261a.onError(th);
    }

    @Override // rx.g
    public void onNext(T t) {
        this.f5261a.onNext(t);
    }
}
