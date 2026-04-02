package rx.d;

import java.util.Arrays;
import rx.b.h;
import rx.e.f;
import rx.l;
/* compiled from: SafeSubscriber.java */
/* loaded from: classes2.dex */
public class b<T> extends l<T> {

    /* renamed from: a  reason: collision with root package name */
    boolean f5254a;

    /* renamed from: b  reason: collision with root package name */
    private final l<? super T> f5255b;

    public b(l<? super T> lVar) {
        super(lVar);
        this.f5255b = lVar;
    }

    @Override // rx.g
    public void onCompleted() {
        h hVar;
        if (!this.f5254a) {
            this.f5254a = true;
            try {
                this.f5255b.onCompleted();
                try {
                    unsubscribe();
                } finally {
                }
            } catch (Throwable th) {
                try {
                    rx.b.b.b(th);
                    rx.e.c.a(th);
                    throw new rx.b.d(th.getMessage(), th);
                } catch (Throwable th2) {
                    try {
                        unsubscribe();
                        throw th2;
                    } finally {
                    }
                }
            }
        }
    }

    @Override // rx.g
    public void onError(Throwable th) {
        rx.b.b.b(th);
        if (!this.f5254a) {
            this.f5254a = true;
            a(th);
        }
    }

    @Override // rx.g
    public void onNext(T t) {
        try {
            if (!this.f5254a) {
                this.f5255b.onNext(t);
            }
        } catch (Throwable th) {
            rx.b.b.a(th, this);
        }
    }

    protected void a(Throwable th) {
        f.a().b().a(th);
        try {
            this.f5255b.onError(th);
            try {
                unsubscribe();
            } catch (Throwable th2) {
                rx.e.c.a(th2);
                throw new rx.b.e(th2);
            }
        } catch (rx.b.f e) {
            try {
                unsubscribe();
                throw e;
            } catch (Throwable th3) {
                rx.e.c.a(th3);
                throw new rx.b.f("Observer.onError not implemented and error while unsubscribing.", new rx.b.a(Arrays.asList(th, th3)));
            }
        } catch (Throwable th4) {
            rx.e.c.a(th4);
            try {
                unsubscribe();
                throw new rx.b.e("Error occurred when trying to propagate error to Observer.onError", new rx.b.a(Arrays.asList(th, th4)));
            } catch (Throwable th5) {
                rx.e.c.a(th5);
                throw new rx.b.e("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new rx.b.a(Arrays.asList(th, th4, th5)));
            }
        }
    }
}
