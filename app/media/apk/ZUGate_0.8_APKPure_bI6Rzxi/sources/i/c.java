package i;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class c implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3353a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f3354b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f3355c;

    public c() {
        this.f3353a = 1;
        this.f3355c = Executors.defaultThreadFactory();
        this.f3354b = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger = this.f3354b;
        switch (this.f3353a) {
            case 0:
                Thread thread = new Thread(runnable);
                thread.setName("arch_disk_io_" + atomicInteger.getAndIncrement());
                return thread;
            default:
                Thread newThread = ((ThreadFactory) this.f3355c).newThread(runnable);
                int andIncrement = atomicInteger.getAndIncrement();
                newThread.setName("PlayBillingLibrary-" + andIncrement);
                return newThread;
        }
    }

    public c(e eVar) {
        this.f3353a = 0;
        this.f3355c = eVar;
        this.f3354b = new AtomicInteger(0);
    }
}
