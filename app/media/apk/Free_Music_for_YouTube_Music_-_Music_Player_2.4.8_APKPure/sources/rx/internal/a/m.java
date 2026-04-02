package rx.internal.a;

import rx.f;
/* compiled from: OnSubscribeThrow.java */
/* loaded from: classes2.dex */
public final class m<T> implements f.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Throwable f5378a;

    public m(Throwable th) {
        this.f5378a = th;
    }

    @Override // rx.c.b
    /* renamed from: a */
    public void call(rx.l<? super T> lVar) {
        lVar.onError(this.f5378a);
    }
}
