package rx.internal.c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: GenericScheduledExecutorService.java */
/* loaded from: classes2.dex */
public final class d implements k {

    /* renamed from: a  reason: collision with root package name */
    public static final d f5516a;

    /* renamed from: b  reason: collision with root package name */
    private static final ScheduledExecutorService[] f5517b = new ScheduledExecutorService[0];

    /* renamed from: c  reason: collision with root package name */
    private static final ScheduledExecutorService f5518c = Executors.newScheduledThreadPool(0);
    private static int e;
    private final AtomicReference<ScheduledExecutorService[]> d = new AtomicReference<>(f5517b);

    static {
        f5518c.shutdown();
        f5516a = new d();
    }

    private d() {
        a();
    }

    @Override // rx.internal.c.k
    public void a() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 4) {
            availableProcessors /= 2;
        }
        int i = availableProcessors <= 8 ? availableProcessors : 8;
        ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[i];
        for (int i2 = 0; i2 < i; i2++) {
            scheduledExecutorServiceArr[i2] = e.b();
        }
        if (this.d.compareAndSet(f5517b, scheduledExecutorServiceArr)) {
            for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
                if (!h.b(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                    h.a((ScheduledThreadPoolExecutor) scheduledExecutorService);
                }
            }
            return;
        }
        for (ScheduledExecutorService scheduledExecutorService2 : scheduledExecutorServiceArr) {
            scheduledExecutorService2.shutdownNow();
        }
    }

    @Override // rx.internal.c.k
    public void b() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        do {
            scheduledExecutorServiceArr = this.d.get();
            if (scheduledExecutorServiceArr == f5517b) {
                return;
            }
        } while (!this.d.compareAndSet(scheduledExecutorServiceArr, f5517b));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            h.a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService c() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = f5516a.d.get();
        if (scheduledExecutorServiceArr == f5517b) {
            return f5518c;
        }
        int i = e + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        e = i;
        return scheduledExecutorServiceArr[i];
    }
}
