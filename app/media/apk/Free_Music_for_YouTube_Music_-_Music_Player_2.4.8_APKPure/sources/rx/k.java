package rx;
/* compiled from: SingleSubscriber.java */
/* loaded from: classes2.dex */
public abstract class k<T> implements m {

    /* renamed from: a  reason: collision with root package name */
    private final rx.internal.util.j f5629a = new rx.internal.util.j();

    public abstract void a(T t);

    public abstract void a(Throwable th);

    public final void a(m mVar) {
        this.f5629a.a(mVar);
    }

    @Override // rx.m
    public final void unsubscribe() {
        this.f5629a.unsubscribe();
    }

    @Override // rx.m
    public final boolean isUnsubscribed() {
        return this.f5629a.isUnsubscribed();
    }
}
