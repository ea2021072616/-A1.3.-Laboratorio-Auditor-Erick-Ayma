package retrofit2.adapter.rxjava;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.f;
import rx.i;
import rx.j;
/* loaded from: classes2.dex */
public final class RxJavaCallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;
    private final i scheduler;

    public static RxJavaCallAdapterFactory create() {
        return new RxJavaCallAdapterFactory(null, false);
    }

    public static RxJavaCallAdapterFactory createAsync() {
        return new RxJavaCallAdapterFactory(null, true);
    }

    public static RxJavaCallAdapterFactory createWithScheduler(i iVar) {
        if (iVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        return new RxJavaCallAdapterFactory(iVar, false);
    }

    private RxJavaCallAdapterFactory(i iVar, boolean z) {
        this.scheduler = iVar;
        this.isAsync = z;
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Type type2;
        Class<?> rawType = getRawType(type);
        boolean z = rawType == j.class;
        boolean equals = "rx.Completable".equals(rawType.getCanonicalName());
        if (rawType != f.class && !z && !equals) {
            return null;
        }
        if (equals) {
            return new RxJavaCallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, true);
        }
        boolean z2 = false;
        boolean z3 = false;
        if (!(type instanceof ParameterizedType)) {
            String str = z ? "Single" : "Observable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type parameterUpperBound = getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType2 = getRawType(parameterUpperBound);
        if (rawType2 == Response.class) {
            if (!(parameterUpperBound instanceof ParameterizedType)) {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
            type2 = getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
        } else if (rawType2 == Result.class) {
            if (!(parameterUpperBound instanceof ParameterizedType)) {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            type2 = getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
            z2 = true;
        } else {
            z3 = true;
            type2 = parameterUpperBound;
        }
        return new RxJavaCallAdapter(type2, this.scheduler, this.isAsync, z2, z3, z, false);
    }
}
