package retrofit2.adapter.rxjava;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.b.b;
import rx.f;
import rx.l;
/* loaded from: classes2.dex */
final class CallEnqueueOnSubscribe<T> implements f.a<Response<T>> {
    private final Call<T> originalCall;

    @Override // rx.c.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l) ((l) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallEnqueueOnSubscribe(Call<T> call) {
        this.originalCall = call;
    }

    public void call(l<? super Response<T>> lVar) {
        Call<T> mo10clone = this.originalCall.mo10clone();
        final CallArbiter callArbiter = new CallArbiter(mo10clone, lVar);
        lVar.add(callArbiter);
        lVar.setProducer(callArbiter);
        mo10clone.enqueue(new Callback<T>() { // from class: retrofit2.adapter.rxjava.CallEnqueueOnSubscribe.1
            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                callArbiter.emitResponse(response);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable th) {
                b.b(th);
                callArbiter.emitError(th);
            }
        });
    }
}
