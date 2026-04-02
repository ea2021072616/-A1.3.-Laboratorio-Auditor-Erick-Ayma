package d;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class w implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final Object f2468b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayDeque f2469c = new ArrayDeque();

    /* renamed from: d  reason: collision with root package name */
    public final Executor f2470d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f2471e;

    public w(x xVar) {
        this.f2470d = xVar;
    }

    public final void b() {
        synchronized (this.f2468b) {
            Runnable runnable = (Runnable) this.f2469c.poll();
            this.f2471e = runnable;
            if (runnable != null) {
                this.f2470d.execute(runnable);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f2468b) {
            this.f2469c.add(new v(this, 0, runnable));
            if (this.f2471e == null) {
                b();
            }
        }
    }
}
