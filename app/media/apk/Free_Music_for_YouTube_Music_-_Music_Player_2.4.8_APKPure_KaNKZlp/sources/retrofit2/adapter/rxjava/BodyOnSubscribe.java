package retrofit2.adapter.rxjava;

import retrofit2.Response;
import rx.b.a;
import rx.b.b;
import rx.f;
import rx.l;
/* loaded from: classes2.dex */
final class BodyOnSubscribe<T> implements f.a<T> {
    private final f.a<Response<T>> upstream;

    @Override // rx.c.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l) ((l) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BodyOnSubscribe(f.a<Response<T>> aVar) {
        this.upstream = aVar;
    }

    public void call(l<? super T> lVar) {
        this.upstream.call(new BodySubscriber(lVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class BodySubscriber<R> extends l<Response<R>> {
        private final l<? super R> subscriber;
        private boolean subscriberTerminated;

        @Override // rx.g
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((Response) ((Response) obj));
        }

        BodySubscriber(l<? super R> lVar) {
            super(lVar);
            this.subscriber = lVar;
        }

        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.subscriber.onNext(response.body());
                return;
            }
            this.subscriberTerminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.subscriber.onError(httpException);
            } catch (Throwable th) {
                b.b(th);
                rx.e.f.a().b().a((Throwable) new a(httpException, th));
            }
        }

        @Override // rx.g
        public void onError(Throwable th) {
            if (!this.subscriberTerminated) {
                this.subscriber.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a Retrofit bug with the full stacktrace.");
            assertionError.initCause(th);
            rx.e.f.a().b().a((Throwable) assertionError);
        }

        @Override // rx.g
        public void onCompleted() {
            if (!this.subscriberTerminated) {
                this.subscriber.onCompleted();
            }
        }
    }
}
