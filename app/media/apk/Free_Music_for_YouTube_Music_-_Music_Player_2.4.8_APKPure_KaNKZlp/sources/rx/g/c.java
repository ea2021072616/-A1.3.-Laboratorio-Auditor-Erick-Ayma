package rx.g;

import rx.m;
/* compiled from: MultipleAssignmentSubscription.java */
/* loaded from: classes2.dex */
public final class c implements m {

    /* renamed from: a  reason: collision with root package name */
    final rx.internal.d.a f5309a = new rx.internal.d.a();

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f5309a.isUnsubscribed();
    }

    @Override // rx.m
    public void unsubscribe() {
        this.f5309a.unsubscribe();
    }

    public void a(m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.f5309a.b(mVar);
    }
}
