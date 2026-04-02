package retrofit2.adapter.rxjava;

import retrofit2.Call;
import retrofit2.Response;
import rx.b.b;
import rx.f;
import rx.l;
/* loaded from: classes2.dex */
final class CallExecuteOnSubscribe<T> implements f.a<Response<T>> {
    private final Call<T> originalCall;

    @Override // rx.c.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((l) ((l) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallExecuteOnSubscribe(Call<T> call) {
        this.originalCall = call;
    }

    public void call(l<? super Response<T>> lVar) {
        Call<T> mo10clone = this.originalCall.mo10clone();
        CallArbiter callArbiter = new CallArbiter(mo10clone, lVar);
        lVar.add(callArbiter);
        lVar.setProducer(callArbiter);
        try {
            callArbiter.emitResponse(mo10clone.execute());
        } catch (Throwable th) {
            b.b(th);
            callArbiter.emitError(th);
        }
    }
}
