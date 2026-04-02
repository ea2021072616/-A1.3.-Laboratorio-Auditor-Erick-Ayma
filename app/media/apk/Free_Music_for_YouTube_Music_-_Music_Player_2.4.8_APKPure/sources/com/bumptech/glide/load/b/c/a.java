package com.bumptech.glide.load.b.c;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: FifoPriorityThreadPoolExecutor.java */
/* loaded from: classes.dex */
public class a extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f821a;

    /* renamed from: b  reason: collision with root package name */
    private final c f822b;

    /* compiled from: FifoPriorityThreadPoolExecutor.java */
    /* loaded from: classes.dex */
    public enum c {
        IGNORE,
        LOG { // from class: com.bumptech.glide.load.b.c.a.c.1
            @Override // com.bumptech.glide.load.b.c.a.c
            protected void a(Throwable th) {
                if (Log.isLoggable("PriorityExecutor", 6)) {
                    Log.e("PriorityExecutor", "Request threw uncaught throwable", th);
                }
            }
        },
        THROW { // from class: com.bumptech.glide.load.b.c.a.c.2
            @Override // com.bumptech.glide.load.b.c.a.c
            protected void a(Throwable th) {
                super.a(th);
                throw new RuntimeException(th);
            }
        };

        protected void a(Throwable th) {
        }
    }

    public a(int i) {
        this(i, c.LOG);
    }

    public a(int i, c cVar) {
        this(i, i, 0L, TimeUnit.MILLISECONDS, new ThreadFactoryC0027a(), cVar);
    }

    public a(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory, c cVar) {
        super(i, i2, j, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.f821a = new AtomicInteger();
        this.f822b = cVar;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new b(runnable, t, this.f821a.getAndIncrement());
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (future.isDone() && !future.isCancelled()) {
                try {
                    future.get();
                } catch (InterruptedException e) {
                    this.f822b.a(e);
                } catch (ExecutionException e2) {
                    this.f822b.a(e2);
                }
            }
        }
    }

    /* compiled from: FifoPriorityThreadPoolExecutor.java */
    /* renamed from: com.bumptech.glide.load.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ThreadFactoryC0027a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        int f826a = 0;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "fifo-pool-thread-" + this.f826a) { // from class: com.bumptech.glide.load.b.c.a.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    super.run();
                }
            };
            this.f826a++;
            return thread;
        }
    }

    /* compiled from: FifoPriorityThreadPoolExecutor.java */
    /* loaded from: classes.dex */
    static class b<T> extends FutureTask<T> implements Comparable<b<?>> {

        /* renamed from: a  reason: collision with root package name */
        private final int f828a;

        /* renamed from: b  reason: collision with root package name */
        private final int f829b;

        public b(Runnable runnable, T t, int i) {
            super(runnable, t);
            if (!(runnable instanceof com.bumptech.glide.load.b.c.b)) {
                throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
            }
            this.f828a = ((com.bumptech.glide.load.b.c.b) runnable).b();
            this.f829b = i;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f829b == bVar.f829b && this.f828a == bVar.f828a;
            }
            return false;
        }

        public int hashCode() {
            return (this.f828a * 31) + this.f829b;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b<?> bVar) {
            int i = this.f828a - bVar.f828a;
            if (i == 0) {
                return this.f829b - bVar.f829b;
            }
            return i;
        }
    }
}
