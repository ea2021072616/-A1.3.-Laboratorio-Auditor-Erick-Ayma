package rx.internal.b;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.h;
import rx.l;
/* compiled from: SingleProducer.java */
/* loaded from: classes2.dex */
public final class c<T> extends AtomicBoolean implements h {
    private static final long serialVersionUID = -3353584923995471404L;

    /* renamed from: a  reason: collision with root package name */
    final l<? super T> f5477a;

    /* renamed from: b  reason: collision with root package name */
    final T f5478b;

    public c(l<? super T> lVar, T t) {
        this.f5477a = lVar;
        this.f5478b = t;
    }

    @Override // rx.h
    public void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j != 0 && compareAndSet(false, true)) {
            l<? super T> lVar = this.f5477a;
            if (!lVar.isUnsubscribed()) {
                Object obj = (T) this.f5478b;
                try {
                    lVar.onNext(obj);
                    if (!lVar.isUnsubscribed()) {
                        lVar.onCompleted();
                    }
                } catch (Throwable th) {
                    rx.b.b.a(th, lVar, obj);
                }
            }
        }
    }
}
