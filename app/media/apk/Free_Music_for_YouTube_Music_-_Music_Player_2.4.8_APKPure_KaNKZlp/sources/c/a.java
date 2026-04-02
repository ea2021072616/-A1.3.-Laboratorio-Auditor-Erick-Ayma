package c;

import com.google.android.exoplayer2.C;
import com.pili.pldroid.player.AVOptions;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* compiled from: AsyncTimeout.java */
/* loaded from: classes.dex */
public class a extends t {
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static a head;
    private boolean inQueue;
    private a next;
    private long timeoutAt;

    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            this.inQueue = true;
            scheduleTimeout(this, timeoutNanos, hasDeadline);
        }
    }

    private static synchronized void scheduleTimeout(a aVar, long j, boolean z) {
        synchronized (a.class) {
            if (head == null) {
                head = new a();
                new C0012a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.timeoutAt = Math.min(j, aVar.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (j != 0) {
                aVar.timeoutAt = nanoTime + j;
            } else if (z) {
                aVar.timeoutAt = aVar.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long remainingNanos = aVar.remainingNanos(nanoTime);
            a aVar2 = head;
            while (aVar2.next != null && remainingNanos >= aVar2.next.remainingNanos(nanoTime)) {
                aVar2 = aVar2.next;
            }
            aVar.next = aVar2.next;
            aVar2.next = aVar;
            if (aVar2 == head) {
                a.class.notify();
            }
        }
    }

    public final boolean exit() {
        if (this.inQueue) {
            this.inQueue = false;
            return cancelScheduledTimeout(this);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
        r0.next = r3.next;
        r3.next = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized boolean cancelScheduledTimeout(c.a r3) {
        /*
            java.lang.Class<c.a> r1 = c.a.class
            monitor-enter(r1)
            c.a r0 = c.a.head     // Catch: java.lang.Throwable -> L1a
        L5:
            if (r0 == 0) goto L18
            c.a r2 = r0.next     // Catch: java.lang.Throwable -> L1a
            if (r2 != r3) goto L15
            c.a r2 = r3.next     // Catch: java.lang.Throwable -> L1a
            r0.next = r2     // Catch: java.lang.Throwable -> L1a
            r0 = 0
            r3.next = r0     // Catch: java.lang.Throwable -> L1a
            r0 = 0
        L13:
            monitor-exit(r1)
            return r0
        L15:
            c.a r0 = r0.next     // Catch: java.lang.Throwable -> L1a
            goto L5
        L18:
            r0 = 1
            goto L13
        L1a:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.cancelScheduledTimeout(c.a):boolean");
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    protected void timedOut() {
    }

    public final r sink(final r rVar) {
        return new r() { // from class: c.a.1
            @Override // c.r
            public void write(c cVar, long j) throws IOException {
                u.a(cVar.f285b, 0L, j);
                long j2 = j;
                while (j2 > 0) {
                    o oVar = cVar.f284a;
                    long j3 = 0;
                    while (true) {
                        if (j3 >= 65536) {
                            break;
                        }
                        long j4 = (cVar.f284a.f313c - cVar.f284a.f312b) + j3;
                        if (j4 >= j2) {
                            j3 = j2;
                            break;
                        } else {
                            oVar = oVar.f;
                            j3 = j4;
                        }
                    }
                    a.this.enter();
                    try {
                        try {
                            rVar.write(cVar, j3);
                            j2 -= j3;
                            a.this.exit(true);
                        } catch (IOException e) {
                            throw a.this.exit(e);
                        }
                    } catch (Throwable th) {
                        a.this.exit(false);
                        throw th;
                    }
                }
            }

            @Override // c.r, java.io.Flushable
            public void flush() throws IOException {
                a.this.enter();
                try {
                    try {
                        rVar.flush();
                        a.this.exit(true);
                    } catch (IOException e) {
                        throw a.this.exit(e);
                    }
                } catch (Throwable th) {
                    a.this.exit(false);
                    throw th;
                }
            }

            @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                a.this.enter();
                try {
                    try {
                        rVar.close();
                        a.this.exit(true);
                    } catch (IOException e) {
                        throw a.this.exit(e);
                    }
                } catch (Throwable th) {
                    a.this.exit(false);
                    throw th;
                }
            }

            @Override // c.r
            public t timeout() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + rVar + ")";
            }
        };
    }

    public final s source(final s sVar) {
        return new s() { // from class: c.a.2
            @Override // c.s
            public long read(c cVar, long j) throws IOException {
                a.this.enter();
                try {
                    try {
                        long read = sVar.read(cVar, j);
                        a.this.exit(true);
                        return read;
                    } catch (IOException e) {
                        throw a.this.exit(e);
                    }
                } catch (Throwable th) {
                    a.this.exit(false);
                    throw th;
                }
            }

            @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    try {
                        sVar.close();
                        a.this.exit(true);
                    } catch (IOException e) {
                        throw a.this.exit(e);
                    }
                } catch (Throwable th) {
                    a.this.exit(false);
                    throw th;
                }
            }

            @Override // c.s
            public t timeout() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + sVar + ")";
            }
        };
    }

    final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    final IOException exit(IOException iOException) throws IOException {
        return !exit() ? iOException : newTimeoutException(iOException);
    }

    protected IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException(AVOptions.KEY_PREPARE_TIMEOUT);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncTimeout.java */
    /* renamed from: c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0012a extends Thread {
        public C0012a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x001d, code lost:
            r0.timedOut();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<c.a> r1 = c.a.class
                monitor-enter(r1)     // Catch: java.lang.InterruptedException -> Le
                c.a r0 = c.a.awaitTimeout()     // Catch: java.lang.Throwable -> Lb
                if (r0 != 0) goto L10
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb
                goto L0
            Lb:
                r0 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb
                throw r0     // Catch: java.lang.InterruptedException -> Le
            Le:
                r0 = move-exception
                goto L0
            L10:
                c.a r2 = c.a.access$000()     // Catch: java.lang.Throwable -> Lb
                if (r0 != r2) goto L1c
                r0 = 0
                c.a.access$002(r0)     // Catch: java.lang.Throwable -> Lb
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb
                return
            L1c:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb
                r0.timedOut()     // Catch: java.lang.InterruptedException -> Le
                goto L0
            */
            throw new UnsupportedOperationException("Method not decompiled: c.a.C0012a.run():void");
        }
    }

    static a awaitTimeout() throws InterruptedException {
        a aVar = head.next;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long remainingNanos = aVar.remainingNanos(System.nanoTime());
        if (remainingNanos > 0) {
            long j = remainingNanos / C.MICROS_PER_SECOND;
            a.class.wait(j, (int) (remainingNanos - (C.MICROS_PER_SECOND * j)));
            return null;
        }
        head.next = aVar.next;
        aVar.next = null;
        return aVar;
    }
}
