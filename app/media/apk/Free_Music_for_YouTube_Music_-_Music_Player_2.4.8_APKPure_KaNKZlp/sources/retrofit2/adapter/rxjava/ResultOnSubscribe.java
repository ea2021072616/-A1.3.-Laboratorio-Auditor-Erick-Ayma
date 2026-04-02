package retrofit2.adapter.rxjava;

import retrofit2.Response;
import rx.b.a;
import rx.b.b;
import rx.f;
import rx.l;
/* loaded from: classes2.dex */
final class ResultOnSubscribe<T> implements f.a<Result<T>> {
    private final f.a<Response<T>> upstream;

    @Override // rx.c.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l) ((l) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultOnSubscribe(f.a<Response<T>> aVar) {
        this.upstream = aVar;
    }

    public void call(l<? super Result<T>> lVar) {
        this.upstream.call(new ResultSubscriber(lVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ResultSubscriber<R> extends l<Response<R>> {
        private final l<? super Result<R>> subscriber;

        @Override // rx.g
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Response) ((Response) obj));
        }

        ResultSubscriber(l<? super Result<R>> lVar) {
            super(lVar);
            this.subscriber = lVar;
        }

        public void onNext(Response<R> response) {
            this.subscriber.onNext(Result.response(response));
        }

        @Override // rx.g
        public void onError(Throwable th) {
            try {
                this.subscriber.onNext(Result.error(th));
                this.subscriber.onCompleted();
            } catch (Throwable th2) {
                try {
                    this.subscriber.onError(th2);
                } catch (Throwable th3) {
                    b.b(th3);
                    rx.e.f.a().b().a((Throwable) new a(th2, th3));
                }
            }
        }

        @Override // rx.g
        public void onCompleted() {
            this.subscriber.onCompleted();
        }
    }
}
