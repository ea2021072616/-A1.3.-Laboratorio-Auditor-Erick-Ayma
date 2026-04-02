package rx.internal.c;

import rx.i;
/* compiled from: SleepingAction.java */
/* loaded from: classes2.dex */
class m implements rx.c.a {

    /* renamed from: a  reason: collision with root package name */
    private final rx.c.a f5556a;

    /* renamed from: b  reason: collision with root package name */
    private final i.a f5557b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5558c;

    public m(rx.c.a aVar, i.a aVar2, long j) {
        this.f5556a = aVar;
        this.f5557b = aVar2;
        this.f5558c = j;
    }

    @Override // rx.c.a
    public void a() {
        if (!this.f5557b.isUnsubscribed()) {
            long m_ = this.f5558c - this.f5557b.m_();
            if (m_ > 0) {
                try {
                    Thread.sleep(m_);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    rx.b.b.a(e);
                }
            }
            if (!this.f5557b.isUnsubscribed()) {
                this.f5556a.a();
            }
        }
    }
}
