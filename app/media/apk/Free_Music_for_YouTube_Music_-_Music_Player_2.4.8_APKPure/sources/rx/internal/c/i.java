package rx.internal.c;

import java.util.concurrent.TimeUnit;
import rx.i;
/* compiled from: SchedulePeriodicHelper.java */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final long f5528a = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: SchedulePeriodicHelper.java */
    /* loaded from: classes2.dex */
    public interface a {
        long b();
    }

    public static rx.m a(final i.a aVar, final rx.c.a aVar2, long j, long j2, TimeUnit timeUnit, final a aVar3) {
        final long nanos = timeUnit.toNanos(j2);
        final long b2 = aVar3 != null ? aVar3.b() : TimeUnit.MILLISECONDS.toNanos(aVar.m_());
        final long nanos2 = b2 + timeUnit.toNanos(j);
        rx.internal.d.a aVar4 = new rx.internal.d.a();
        final rx.internal.d.a aVar5 = new rx.internal.d.a(aVar4);
        aVar4.b(aVar.a(new rx.c.a() { // from class: rx.internal.c.i.1

            /* renamed from: a  reason: collision with root package name */
            long f5529a;

            /* renamed from: b  reason: collision with root package name */
            long f5530b;

            /* renamed from: c  reason: collision with root package name */
            long f5531c;

            {
                this.f5530b = b2;
                this.f5531c = nanos2;
            }

            @Override // rx.c.a
            public void a() {
                long j3;
                aVar2.a();
                if (!aVar5.isUnsubscribed()) {
                    long b3 = aVar3 != null ? aVar3.b() : TimeUnit.MILLISECONDS.toNanos(aVar.m_());
                    if (i.f5528a + b3 < this.f5530b || b3 >= this.f5530b + nanos + i.f5528a) {
                        j3 = nanos + b3;
                        long j4 = nanos;
                        long j5 = this.f5529a + 1;
                        this.f5529a = j5;
                        this.f5531c = j3 - (j4 * j5);
                    } else {
                        long j6 = this.f5531c;
                        long j7 = this.f5529a + 1;
                        this.f5529a = j7;
                        j3 = j6 + (j7 * nanos);
                    }
                    this.f5530b = b3;
                    aVar5.b(aVar.a(this, j3 - b3, TimeUnit.NANOSECONDS));
                }
            }
        }, j, timeUnit));
        return aVar5;
    }
}
