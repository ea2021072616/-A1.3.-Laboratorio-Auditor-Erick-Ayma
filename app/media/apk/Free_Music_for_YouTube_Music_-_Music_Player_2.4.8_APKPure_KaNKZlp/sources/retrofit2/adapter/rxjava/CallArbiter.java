package retrofit2.adapter.rxjava;

import java.util.concurrent.atomic.AtomicInteger;
import retrofit2.Call;
import retrofit2.Response;
import rx.b.a;
import rx.b.b;
import rx.e.f;
import rx.h;
import rx.l;
import rx.m;
/* loaded from: classes2.dex */
final class CallArbiter<T> extends AtomicInteger implements h, m {
    private static final int STATE_HAS_RESPONSE = 2;
    private static final int STATE_REQUESTED = 1;
    private static final int STATE_TERMINATED = 3;
    private static final int STATE_WAITING = 0;
    private final Call<T> call;
    private volatile Response<T> response;
    private final l<? super Response<T>> subscriber;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallArbiter(Call<T> call, l<? super Response<T>> lVar) {
        super(0);
        this.call = call;
        this.subscriber = lVar;
    }

    @Override // rx.m
    public void unsubscribe() {
        this.call.cancel();
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.call.isCanceled();
    }

    @Override // rx.h
    public void request(long j) {
        if (j == 0) {
            return;
        }
        while (true) {
            int i = get();
            switch (i) {
                case 0:
                    if (!compareAndSet(0, 1)) {
                        break;
                    } else {
                        return;
                    }
                case 1:
                case 3:
                    return;
                case 2:
                    if (!compareAndSet(2, 3)) {
                        break;
                    } else {
                        deliverResponse(this.response);
                        return;
                    }
                default:
                    throw new IllegalStateException("Unknown state: " + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emitResponse(Response<T> response) {
        while (true) {
            int i = get();
            switch (i) {
                case 0:
                    this.response = response;
                    if (!compareAndSet(0, 2)) {
                        break;
                    } else {
                        return;
                    }
                case 1:
                    if (!compareAndSet(1, 3)) {
                        break;
                    } else {
                        deliverResponse(response);
                        return;
                    }
                case 2:
                case 3:
                    throw new AssertionError();
                default:
                    throw new IllegalStateException("Unknown state: " + i);
            }
        }
    }

    private void deliverResponse(Response<T> response) {
        try {
            if (!isUnsubscribed()) {
                this.subscriber.onNext(response);
            }
            try {
                this.subscriber.onCompleted();
            } catch (Throwable th) {
                b.b(th);
                f.a().b().a(th);
            }
        } catch (Throwable th2) {
            b.b(th2);
            try {
                this.subscriber.onError(th2);
            } catch (Throwable th3) {
                b.b(th3);
                f.a().b().a((Throwable) new a(th2, th3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emitError(Throwable th) {
        set(3);
        if (!isUnsubscribed()) {
            try {
                this.subscriber.onError(th);
            } catch (Throwable th2) {
                b.b(th2);
                f.a().b().a((Throwable) new a(th, th2));
            }
        }
    }
}
