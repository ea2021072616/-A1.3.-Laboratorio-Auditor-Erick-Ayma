package rx.internal.b;

import java.util.concurrent.atomic.AtomicInteger;
import rx.h;
import rx.l;
/* compiled from: SingleDelayedProducer.java */
/* loaded from: classes2.dex */
public final class b<T> extends AtomicInteger implements h {
    private static final long serialVersionUID = -2873467947112093874L;

    /* renamed from: a  reason: collision with root package name */
    final l<? super T> f5475a;

    /* renamed from: b  reason: collision with root package name */
    T f5476b;

    public b(l<? super T> lVar) {
        this.f5475a = lVar;
    }

    @Override // rx.h
    public void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j != 0) {
            do {
                int i = get();
                if (i != 0) {
                    if (i == 1 && compareAndSet(1, 3)) {
                        a(this.f5475a, this.f5476b);
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    public void a(T t) {
        do {
            int i = get();
            if (i == 0) {
                this.f5476b = t;
            } else if (i == 2 && compareAndSet(2, 3)) {
                a(this.f5475a, t);
                return;
            } else {
                return;
            }
        } while (!compareAndSet(0, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(l<? super T> lVar, T t) {
        if (!lVar.isUnsubscribed()) {
            try {
                lVar.onNext(t);
                if (!lVar.isUnsubscribed()) {
                    lVar.onCompleted();
                }
            } catch (Throwable th) {
                rx.b.b.a(th, lVar, t);
            }
        }
    }
}
