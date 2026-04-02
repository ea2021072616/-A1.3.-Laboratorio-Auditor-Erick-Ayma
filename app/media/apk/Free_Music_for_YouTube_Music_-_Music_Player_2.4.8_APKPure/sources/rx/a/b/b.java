package rx.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import rx.b.f;
import rx.g.e;
import rx.i;
import rx.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LooperScheduler.java */
/* loaded from: classes2.dex */
public class b extends i {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f5225a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Looper looper) {
        this.f5225a = new Handler(looper);
    }

    @Override // rx.i
    public i.a createWorker() {
        return new a(this.f5225a);
    }

    /* compiled from: LooperScheduler.java */
    /* loaded from: classes2.dex */
    static class a extends i.a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f5226a;

        /* renamed from: b  reason: collision with root package name */
        private final rx.a.a.b f5227b = rx.a.a.a.a().b();

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f5228c;

        a(Handler handler) {
            this.f5226a = handler;
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f5228c = true;
            this.f5226a.removeCallbacksAndMessages(this);
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f5228c;
        }

        @Override // rx.i.a
        public m a(rx.c.a aVar, long j, TimeUnit timeUnit) {
            if (this.f5228c) {
                return e.a();
            }
            RunnableC0105b runnableC0105b = new RunnableC0105b(this.f5227b.a(aVar), this.f5226a);
            Message obtain = Message.obtain(this.f5226a, runnableC0105b);
            obtain.obj = this;
            this.f5226a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.f5228c) {
                this.f5226a.removeCallbacks(runnableC0105b);
                return e.a();
            }
            return runnableC0105b;
        }

        @Override // rx.i.a
        public m a(rx.c.a aVar) {
            return a(aVar, 0L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LooperScheduler.java */
    /* renamed from: rx.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class RunnableC0105b implements Runnable, m {

        /* renamed from: a  reason: collision with root package name */
        private final rx.c.a f5229a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f5230b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f5231c;

        RunnableC0105b(rx.c.a aVar, Handler handler) {
            this.f5229a = aVar;
            this.f5230b = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            try {
                this.f5229a.a();
            } catch (Throwable th) {
                if (th instanceof f) {
                    illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th);
                } else {
                    illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                }
                rx.e.f.a().b().a((Throwable) illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f5231c = true;
            this.f5230b.removeCallbacks(this);
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f5231c;
        }
    }
}
