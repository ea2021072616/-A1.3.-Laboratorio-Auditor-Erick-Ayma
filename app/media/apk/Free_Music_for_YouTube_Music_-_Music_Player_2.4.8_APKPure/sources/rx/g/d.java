package rx.g;

import rx.m;
/* compiled from: SerialSubscription.java */
/* loaded from: classes2.dex */
public final class d implements m {

    /* renamed from: a  reason: collision with root package name */
    final rx.internal.d.a f5310a = new rx.internal.d.a();

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f5310a.isUnsubscribed();
    }

    @Override // rx.m
    public void unsubscribe() {
        this.f5310a.unsubscribe();
    }

    public void a(m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.f5310a.a(mVar);
    }
}
