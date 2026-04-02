package rx.internal.a;

import java.util.concurrent.TimeUnit;
import rx.f;
import rx.i;
/* compiled from: OnSubscribeTimerPeriodically.java */
/* loaded from: classes2.dex */
public final class o implements f.a<Long> {

    /* renamed from: a  reason: collision with root package name */
    final long f5384a;

    /* renamed from: b  reason: collision with root package name */
    final long f5385b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f5386c;
    final rx.i d;

    public o(long j, long j2, TimeUnit timeUnit, rx.i iVar) {
        this.f5384a = j;
        this.f5385b = j2;
        this.f5386c = timeUnit;
        this.d = iVar;
    }

    @Override // rx.c.b
    /* renamed from: a */
    public void call(final rx.l<? super Long> lVar) {
        final i.a createWorker = this.d.createWorker();
        lVar.add(createWorker);
        createWorker.a(new rx.c.a() { // from class: rx.internal.a.o.1

            /* renamed from: a  reason: collision with root package name */
            long f5387a;

            @Override // rx.c.a
            public void a() {
                try {
                    rx.l lVar2 = lVar;
                    long j = this.f5387a;
                    this.f5387a = 1 + j;
                    lVar2.onNext(Long.valueOf(j));
                } catch (Throwable th) {
                    try {
                        createWorker.unsubscribe();
                    } finally {
                        rx.b.b.a(th, lVar);
                    }
                }
            }
        }, this.f5384a, this.f5385b, this.f5386c);
    }
}
