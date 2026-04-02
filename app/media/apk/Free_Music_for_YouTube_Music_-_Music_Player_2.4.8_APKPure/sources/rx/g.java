package rx;
/* compiled from: Observer.java */
/* loaded from: classes2.dex */
public interface g<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
