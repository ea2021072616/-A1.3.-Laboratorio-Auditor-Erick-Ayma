package rx.internal.a;

import rx.f;
/* compiled from: OperatorAny.java */
/* loaded from: classes2.dex */
public final class p<T> implements f.b<Boolean, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.c.e<? super T, Boolean> f5390a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f5391b;

    public p(rx.c.e<? super T, Boolean> eVar, boolean z) {
        this.f5390a = eVar;
        this.f5391b = z;
    }

    @Override // rx.c.e
    public rx.l<? super T> a(final rx.l<? super Boolean> lVar) {
        final rx.internal.b.b bVar = new rx.internal.b.b(lVar);
        rx.l lVar2 = (rx.l<T>) new rx.l<T>() { // from class: rx.internal.a.p.1

            /* renamed from: a  reason: collision with root package name */
            boolean f5392a;

            /* renamed from: b  reason: collision with root package name */
            boolean f5393b;

            @Override // rx.g
            public void onNext(T t) {
                if (!this.f5393b) {
                    this.f5392a = true;
                    try {
                        if (p.this.f5390a.a(t).booleanValue()) {
                            this.f5393b = true;
                            bVar.a(Boolean.valueOf(!p.this.f5391b));
                            unsubscribe();
                        }
                    } catch (Throwable th) {
                        rx.b.b.a(th, this, t);
                    }
                }
            }

            @Override // rx.g
            public void onError(Throwable th) {
                if (!this.f5393b) {
                    this.f5393b = true;
                    lVar.onError(th);
                    return;
                }
                rx.e.c.a(th);
            }

            @Override // rx.g
            public void onCompleted() {
                if (!this.f5393b) {
                    this.f5393b = true;
                    if (this.f5392a) {
                        bVar.a(false);
                    } else {
                        bVar.a(Boolean.valueOf(p.this.f5391b));
                    }
                }
            }
        };
        lVar.add(lVar2);
        lVar.setProducer(bVar);
        return lVar2;
    }
}
