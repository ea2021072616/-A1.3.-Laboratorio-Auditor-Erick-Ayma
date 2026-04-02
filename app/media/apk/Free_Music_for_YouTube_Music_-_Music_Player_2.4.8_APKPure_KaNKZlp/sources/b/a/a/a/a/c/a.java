package b.a.a.a.a.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: AsyncTask.java */
/* loaded from: classes.dex */
public abstract class a<Params, Progress, Result> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f139a = Runtime.getRuntime().availableProcessors();
    private static final int d = f139a + 1;
    private static final int e = (f139a * 2) + 1;
    private static final ThreadFactory f = new ThreadFactory() { // from class: b.a.a.a.a.c.a.1

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f142a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f142a.getAndIncrement());
        }
    };
    private static final BlockingQueue<Runnable> g = new LinkedBlockingQueue(128);

    /* renamed from: b  reason: collision with root package name */
    public static final Executor f140b = new ThreadPoolExecutor(d, e, 1, TimeUnit.SECONDS, g, f);

    /* renamed from: c  reason: collision with root package name */
    public static final Executor f141c = new c();
    private static final b h = new b();
    private static volatile Executor i = f141c;
    private volatile d l = d.PENDING;
    private final AtomicBoolean m = new AtomicBoolean();
    private final AtomicBoolean n = new AtomicBoolean();
    private final e<Params, Result> j = new e<Params, Result>() { // from class: b.a.a.a.a.c.a.2
        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            a.this.n.set(true);
            Process.setThreadPriority(10);
            return (Result) a.this.d(a.this.a((Object[]) this.f158b));
        }
    };
    private final FutureTask<Result> k = new FutureTask<Result>(this.j) { // from class: b.a.a.a.a.c.a.3
        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                a.this.c(get());
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (CancellationException e3) {
                a.this.c(null);
            } catch (ExecutionException e4) {
                throw new RuntimeException("An error occured while executing doInBackground()", e4.getCause());
            }
        }
    };

    /* compiled from: AsyncTask.java */
    /* loaded from: classes.dex */
    public enum d {
        PENDING,
        RUNNING,
        FINISHED
    }

    protected abstract Result a(Params... paramsArr);

    /* compiled from: AsyncTask.java */
    /* loaded from: classes.dex */
    private static class c implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final LinkedList<Runnable> f149a;

        /* renamed from: b  reason: collision with root package name */
        Runnable f150b;

        private c() {
            this.f149a = new LinkedList<>();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f149a.offer(new Runnable() { // from class: b.a.a.a.a.c.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        c.this.a();
                    }
                }
            });
            if (this.f150b == null) {
                a();
            }
        }

        protected synchronized void a() {
            Runnable poll = this.f149a.poll();
            this.f150b = poll;
            if (poll != null) {
                a.f140b.execute(this.f150b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Result result) {
        if (!this.n.get()) {
            d(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result d(Result result) {
        h.obtainMessage(1, new C0010a(this, result)).sendToTarget();
        return result;
    }

    public final d b() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    protected void a(Result result) {
    }

    protected void b(Progress... progressArr) {
    }

    protected void b(Result result) {
        c();
    }

    protected void c() {
    }

    public final boolean d() {
        return this.m.get();
    }

    public final boolean a(boolean z) {
        this.m.set(true);
        return this.k.cancel(z);
    }

    public final a<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.l != d.PENDING) {
            switch (this.l) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.l = d.RUNNING;
        a();
        this.j.f158b = paramsArr;
        executor.execute(this.k);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Result result) {
        if (d()) {
            b((a<Params, Progress, Result>) result);
        } else {
            a((a<Params, Progress, Result>) result);
        }
        this.l = d.FINISHED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncTask.java */
    /* loaded from: classes.dex */
    public static class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0010a c0010a = (C0010a) message.obj;
            switch (message.what) {
                case 1:
                    c0010a.f146a.e(c0010a.f147b[0]);
                    return;
                case 2:
                    c0010a.f146a.b((Object[]) c0010a.f147b);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: AsyncTask.java */
    /* loaded from: classes.dex */
    private static abstract class e<Params, Result> implements Callable<Result> {

        /* renamed from: b  reason: collision with root package name */
        Params[] f158b;

        private e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncTask.java */
    /* renamed from: b.a.a.a.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0010a<Data> {

        /* renamed from: a  reason: collision with root package name */
        final a f146a;

        /* renamed from: b  reason: collision with root package name */
        final Data[] f147b;

        C0010a(a aVar, Data... dataArr) {
            this.f146a = aVar;
            this.f147b = dataArr;
        }
    }
}
