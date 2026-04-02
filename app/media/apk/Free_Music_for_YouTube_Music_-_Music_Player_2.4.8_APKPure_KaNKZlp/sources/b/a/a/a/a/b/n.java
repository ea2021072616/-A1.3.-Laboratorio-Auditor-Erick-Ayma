package b.a.a.a.a.b;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: ExecutorUtils.java */
/* loaded from: classes.dex */
public final class n {
    public static ExecutorService a(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(c(str));
        a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static ScheduledExecutorService b(String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(c(str));
        a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static final ThreadFactory c(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1L);
        return new ThreadFactory() { // from class: b.a.a.a.a.b.n.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(final Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(new h() { // from class: b.a.a.a.a.b.n.1.1
                    @Override // b.a.a.a.a.b.h
                    public void onRun() {
                        runnable.run();
                    }
                });
                newThread.setName(str + atomicLong.getAndIncrement());
                return newThread;
            }
        };
    }

    private static final void a(String str, ExecutorService executorService) {
        a(str, executorService, 2L, TimeUnit.SECONDS);
    }

    public static final void a(final String str, final ExecutorService executorService, final long j, final TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new h() { // from class: b.a.a.a.a.b.n.2
            @Override // b.a.a.a.a.b.h
            public void onRun() {
                try {
                    b.a.a.a.c.h().a("Fabric", "Executing shutdown hook for " + str);
                    executorService.shutdown();
                    if (!executorService.awaitTermination(j, timeUnit)) {
                        b.a.a.a.c.h().a("Fabric", str + " did not shut down in the allocated time. Requesting immediate shutdown.");
                        executorService.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    b.a.a.a.c.h().a("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", str));
                    executorService.shutdownNow();
                }
            }
        }, "Crashlytics Shutdown Hook for " + str));
    }
}
