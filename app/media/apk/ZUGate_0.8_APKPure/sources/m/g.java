package m;

import com.google.android.gms.internal.play_billing.i0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public abstract class g implements Future {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f3918e = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f3919f = Logger.getLogger(g.class.getName());

    /* renamed from: g  reason: collision with root package name */
    public static final i0 f3920g;

    /* renamed from: h  reason: collision with root package name */
    public static final Object f3921h;

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f3922b;

    /* renamed from: c  reason: collision with root package name */
    public volatile c f3923c;

    /* renamed from: d  reason: collision with root package name */
    public volatile f f3924d;

    static {
        i0 eVar;
        try {
            eVar = new d(AtomicReferenceFieldUpdater.newUpdater(f.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(f.class, f.class, "b"), AtomicReferenceFieldUpdater.newUpdater(g.class, f.class, "d"), AtomicReferenceFieldUpdater.newUpdater(g.class, c.class, "c"), AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "b"));
            th = null;
        } catch (Throwable th) {
            th = th;
            eVar = new e();
        }
        f3920g = eVar;
        if (th != null) {
            f3919f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f3921h = new Object();
    }

    public static void b(g gVar) {
        f fVar;
        c cVar;
        do {
            fVar = gVar.f3924d;
        } while (!f3920g.f(gVar, fVar, f.f3915c));
        while (fVar != null) {
            Thread thread = fVar.f3916a;
            if (thread != null) {
                fVar.f3916a = null;
                LockSupport.unpark(thread);
            }
            fVar = fVar.f3917b;
        }
        do {
            cVar = gVar.f3923c;
        } while (!f3920g.d(gVar, cVar));
        c cVar2 = null;
        while (cVar != null) {
            c cVar3 = cVar.f3910a;
            cVar.f3910a = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
        }
        while (cVar2 != null) {
            cVar2 = cVar2.f3910a;
            try {
                throw null;
                break;
            } catch (RuntimeException e5) {
                f3919f.log(Level.SEVERE, "RuntimeException while executing runnable null with executor null", (Throwable) e5);
            }
        }
    }

    public static Object c(Object obj) {
        if (obj instanceof a) {
            Throwable th = ((a) obj).f3908a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof b) {
            ((b) obj).getClass();
            throw new ExecutionException((Throwable) null);
        } else if (obj == f3921h) {
            return null;
        } else {
            return obj;
        }
    }

    public final void a(StringBuilder sb) {
        Object obj;
        boolean z4 = false;
        while (true) {
            try {
                try {
                    obj = get();
                    break;
                } catch (InterruptedException unused) {
                    z4 = true;
                } catch (Throwable th) {
                    if (z4) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                sb.append("CANCELLED");
                return;
            } catch (RuntimeException e5) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e5.getClass());
                sb.append(" thrown from get()]");
                return;
            } catch (ExecutionException e6) {
                sb.append("FAILURE, cause=[");
                sb.append(e6.getCause());
                sb.append("]");
                return;
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        sb.append(obj == this ? "this future" : String.valueOf(obj));
        sb.append("]");
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z4) {
        Object obj = this.f3922b;
        if ((obj == null) | false) {
            if (f3920g.e(this, obj, f3918e ? new a(new CancellationException("Future.cancel() was called."), z4) : z4 ? a.f3906b : a.f3907c)) {
                b(this);
                return true;
            }
        }
        return false;
    }

    public final void d(f fVar) {
        fVar.f3916a = null;
        while (true) {
            f fVar2 = this.f3924d;
            if (fVar2 == f.f3915c) {
                return;
            }
            f fVar3 = null;
            while (fVar2 != null) {
                f fVar4 = fVar2.f3917b;
                if (fVar2.f3916a != null) {
                    fVar3 = fVar2;
                } else if (fVar3 != null) {
                    fVar3.f3917b = fVar4;
                    if (fVar3.f3916a == null) {
                        break;
                    }
                } else if (!f3920g.f(this, fVar2, fVar4)) {
                    break;
                }
                fVar2 = fVar4;
            }
            return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00a4 -> B:56:0x00aa). Please submit an issue!!! */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(long r18, java.util.concurrent.TimeUnit r20) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.g.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f3922b instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (this.f3922b != null) & true;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f3922b instanceof a) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                } else {
                    str = null;
                }
            } catch (RuntimeException e5) {
                str = "Exception thrown from implementation: " + e5.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f3922b;
            if ((obj2 != null) & true) {
                return c(obj2);
            }
            f fVar = this.f3924d;
            f fVar2 = f.f3915c;
            if (fVar != fVar2) {
                f fVar3 = new f();
                do {
                    i0 i0Var = f3920g;
                    i0Var.K(fVar3, fVar);
                    if (i0Var.f(this, fVar, fVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f3922b;
                            } else {
                                d(fVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & true));
                        return c(obj);
                    }
                    fVar = this.f3924d;
                } while (fVar != fVar2);
                return c(this.f3922b);
            }
            return c(this.f3922b);
        }
        throw new InterruptedException();
    }
}
