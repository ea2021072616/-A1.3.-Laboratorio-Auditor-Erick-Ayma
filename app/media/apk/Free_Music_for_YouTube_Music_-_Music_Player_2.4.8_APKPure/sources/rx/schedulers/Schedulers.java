package rx.schedulers;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.e.c;
import rx.e.f;
import rx.e.g;
import rx.i;
import rx.internal.c.d;
import rx.internal.c.k;
import rx.internal.c.n;
/* loaded from: classes2.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> d = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    private final i f5630a;

    /* renamed from: b  reason: collision with root package name */
    private final i f5631b;

    /* renamed from: c  reason: collision with root package name */
    private final i f5632c;

    private static Schedulers c() {
        Schedulers schedulers;
        while (true) {
            schedulers = d.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (d.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.b();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        g f = f.a().f();
        i d2 = f.d();
        if (d2 != null) {
            this.f5630a = d2;
        } else {
            this.f5630a = g.a();
        }
        i e = f.e();
        if (e != null) {
            this.f5631b = e;
        } else {
            this.f5631b = g.b();
        }
        i f2 = f.f();
        if (f2 != null) {
            this.f5632c = f2;
        } else {
            this.f5632c = g.c();
        }
    }

    public static i immediate() {
        return rx.internal.c.f.f5521a;
    }

    public static i trampoline() {
        return n.f5559a;
    }

    public static i newThread() {
        return c.c(c().f5632c);
    }

    public static i computation() {
        return c.a(c().f5630a);
    }

    public static i io() {
        return c.b(c().f5631b);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static i from(Executor executor) {
        return new rx.internal.c.c(executor);
    }

    public static void reset() {
        Schedulers andSet = d.getAndSet(null);
        if (andSet != null) {
            andSet.b();
        }
    }

    public static void start() {
        Schedulers c2 = c();
        c2.a();
        synchronized (c2) {
            d.f5516a.a();
        }
    }

    public static void shutdown() {
        Schedulers c2 = c();
        c2.b();
        synchronized (c2) {
            d.f5516a.b();
        }
    }

    synchronized void a() {
        if (this.f5630a instanceof k) {
            ((k) this.f5630a).a();
        }
        if (this.f5631b instanceof k) {
            ((k) this.f5631b).a();
        }
        if (this.f5632c instanceof k) {
            ((k) this.f5632c).a();
        }
    }

    synchronized void b() {
        if (this.f5630a instanceof k) {
            ((k) this.f5630a).b();
        }
        if (this.f5631b instanceof k) {
            ((k) this.f5631b).b();
        }
        if (this.f5632c instanceof k) {
            ((k) this.f5632c).b();
        }
    }
}
