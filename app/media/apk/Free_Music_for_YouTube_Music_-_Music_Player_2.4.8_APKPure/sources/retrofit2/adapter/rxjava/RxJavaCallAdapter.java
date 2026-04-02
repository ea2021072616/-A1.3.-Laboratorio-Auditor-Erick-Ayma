package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;
import rx.f;
import rx.i;
/* loaded from: classes2.dex */
final class RxJavaCallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final i scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxJavaCallAdapter(Type type, i iVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.responseType = type;
        this.scheduler = iVar;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isSingle = z4;
        this.isCompletable = z5;
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }

    @Override // retrofit2.CallAdapter
    public Object adapt(Call<R> call) {
        ResultOnSubscribe callExecuteOnSubscribe;
        if (this.isAsync) {
            callExecuteOnSubscribe = new CallEnqueueOnSubscribe(call);
        } else {
            callExecuteOnSubscribe = new CallExecuteOnSubscribe(call);
        }
        if (this.isResult) {
            callExecuteOnSubscribe = new ResultOnSubscribe(callExecuteOnSubscribe);
        } else if (this.isBody) {
            callExecuteOnSubscribe = new BodyOnSubscribe(callExecuteOnSubscribe);
        }
        f a2 = f.a(callExecuteOnSubscribe);
        if (this.scheduler != null) {
            a2 = a2.b(this.scheduler);
        }
        if (this.isSingle) {
            return a2.a();
        }
        if (this.isCompletable) {
            return CompletableHelper.toCompletable(a2);
        }
        return a2;
    }

    /* loaded from: classes2.dex */
    private static final class CompletableHelper {
        private CompletableHelper() {
        }

        static Object toCompletable(f<?> fVar) {
            return fVar.b();
        }
    }
}
