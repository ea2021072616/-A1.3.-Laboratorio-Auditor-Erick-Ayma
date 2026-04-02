package rx.internal.a;

import rx.f;
/* compiled from: EmptyObservableHolder.java */
/* loaded from: classes2.dex */
public enum c implements f.a<Object> {
    INSTANCE;
    

    /* renamed from: b  reason: collision with root package name */
    static final rx.f<Object> f5324b = rx.f.b((f.a) INSTANCE);

    public static <T> rx.f<T> a() {
        return (rx.f<T>) f5324b;
    }

    @Override // rx.c.b
    /* renamed from: a */
    public void call(rx.l<? super Object> lVar) {
        lVar.onCompleted();
    }
}
