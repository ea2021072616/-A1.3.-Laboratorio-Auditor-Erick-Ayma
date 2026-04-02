package rx.internal.a;

import java.util.concurrent.TimeUnit;
import rx.f;
import rx.i;
/* compiled from: OnSubscribeTimerOnce.java */
/* loaded from: classes2.dex */
public final class n implements f.a<Long> {

    /* renamed from: a  reason: collision with root package name */
    final long f5379a;

    /* renamed from: b  reason: collision with root package name */
    final TimeUnit f5380b;

    /* renamed from: c  reason: collision with root package name */
    final rx.i f5381c;

    public n(long j, TimeUnit timeUnit, rx.i iVar) {
        this.f5379a = j;
        this.f5380b = timeUnit;
        this.f5381c = iVar;
    }

    @Override // rx.c.b
    /* renamed from: a */
    public void call(final rx.l<? super Long> lVar) {
        i.a createWorker = this.f5381c.createWorker();
        lVar.add(createWorker);
        createWorker.a(new rx.c.a() { // from class: rx.internal.a.n.1
            @Override // rx.c.a
            public void a() {
                try {
                    lVar.onNext(0L);
                    lVar.onCompleted();
                } catch (Throwable th) {
                    rx.b.b.a(th, lVar);
                }
            }
        }, this.f5379a, this.f5380b);
    }
}
