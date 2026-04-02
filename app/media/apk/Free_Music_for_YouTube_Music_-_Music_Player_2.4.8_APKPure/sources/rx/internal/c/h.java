package rx.internal.c;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.i;
/* compiled from: NewThreadWorker.java */
/* loaded from: classes2.dex */
public class h extends i.a implements rx.m {
    private static final boolean d;
    private static volatile Object g;

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f5526a;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f5527c;
    private static final Object h = new Object();
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> e = new ConcurrentHashMap<>();
    private static final AtomicReference<ScheduledExecutorService> f = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    public static final int f5525b = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    static {
        boolean z = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int b2 = rx.internal.util.f.b();
        d = !z && (b2 == 0 || b2 >= 21);
    }

    public static void a(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            if (f.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new rx.internal.util.h("RxSchedulerPurge-"));
            if (f.compareAndSet(null, newScheduledThreadPool)) {
                newScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: rx.internal.c.h.1
                    @Override // java.lang.Runnable
                    public void run() {
                        h.c();
                    }
                }, f5525b, f5525b, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        e.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static void a(ScheduledExecutorService scheduledExecutorService) {
        e.remove(scheduledExecutorService);
    }

    static void c() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = e.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it.remove();
                }
            }
        } catch (Throwable th) {
            rx.b.b.b(th);
            rx.e.c.a(th);
        }
    }

    public static boolean b(ScheduledExecutorService scheduledExecutorService) {
        Method c2;
        if (d) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = g;
                if (obj == h) {
                    return false;
                }
                if (obj == null) {
                    c2 = c(scheduledExecutorService);
                    g = c2 != null ? c2 : h;
                } else {
                    c2 = (Method) obj;
                }
            } else {
                c2 = c(scheduledExecutorService);
            }
            if (c2 != null) {
                try {
                    c2.invoke(scheduledExecutorService, true);
                    return true;
                } catch (IllegalAccessException e2) {
                    rx.e.c.a(e2);
                } catch (IllegalArgumentException e3) {
                    rx.e.c.a(e3);
                } catch (InvocationTargetException e4) {
                    rx.e.c.a(e4);
                }
            }
        }
        return false;
    }

    static Method c(ScheduledExecutorService scheduledExecutorService) {
        Method[] methods;
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    public h(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!b(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            a((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.f5527c = newScheduledThreadPool;
    }

    @Override // rx.i.a
    public rx.m a(rx.c.a aVar) {
        return a(aVar, 0L, null);
    }

    @Override // rx.i.a
    public rx.m a(rx.c.a aVar, long j, TimeUnit timeUnit) {
        return this.f5526a ? rx.g.e.a() : b(aVar, j, timeUnit);
    }

    public j b(rx.c.a aVar, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        j jVar = new j(rx.e.c.a(aVar));
        if (j <= 0) {
            schedule = this.f5527c.submit(jVar);
        } else {
            schedule = this.f5527c.schedule(jVar, j, timeUnit);
        }
        jVar.a(schedule);
        return jVar;
    }

    public j a(rx.c.a aVar, long j, TimeUnit timeUnit, rx.g.b bVar) {
        Future<?> schedule;
        j jVar = new j(rx.e.c.a(aVar), bVar);
        bVar.a(jVar);
        if (j <= 0) {
            schedule = this.f5527c.submit(jVar);
        } else {
            schedule = this.f5527c.schedule(jVar, j, timeUnit);
        }
        jVar.a(schedule);
        return jVar;
    }

    public j a(rx.c.a aVar, long j, TimeUnit timeUnit, rx.internal.util.j jVar) {
        Future<?> schedule;
        j jVar2 = new j(rx.e.c.a(aVar), jVar);
        jVar.a(jVar2);
        if (j <= 0) {
            schedule = this.f5527c.submit(jVar2);
        } else {
            schedule = this.f5527c.schedule(jVar2, j, timeUnit);
        }
        jVar2.a(schedule);
        return jVar2;
    }

    @Override // rx.m
    public void unsubscribe() {
        this.f5526a = true;
        this.f5527c.shutdownNow();
        a(this.f5527c);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f5526a;
    }
}
