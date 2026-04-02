package c;

import com.google.android.exoplayer2.C;
import com.pili.pldroid.player.AVOptions;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* compiled from: Timeout.java */
/* loaded from: classes.dex */
public class t {
    public static final t NONE = new t() { // from class: c.t.1
        @Override // c.t
        public t timeout(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // c.t
        public t deadlineNanoTime(long j) {
            return this;
        }

        @Override // c.t
        public void throwIfReached() throws IOException {
        }
    };
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public t timeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.timeoutNanos = timeUnit.toNanos(j);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public t deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }

    public final t deadline(long j, TimeUnit timeUnit) {
        if (j <= 0) {
            throw new IllegalArgumentException("duration <= 0: " + j);
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j));
    }

    public t clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public t clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public final void waitUntilNotified(Object obj) throws InterruptedIOException {
        long j = 0;
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            if (!hasDeadline && timeoutNanos == 0) {
                obj.wait();
                return;
            }
            long nanoTime = System.nanoTime();
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - nanoTime;
            }
            if (timeoutNanos > 0) {
                long j2 = timeoutNanos / C.MICROS_PER_SECOND;
                obj.wait(j2, (int) (timeoutNanos - (j2 * C.MICROS_PER_SECOND)));
                j = System.nanoTime() - nanoTime;
            }
            if (j >= timeoutNanos) {
                throw new InterruptedIOException(AVOptions.KEY_PREPARE_TIMEOUT);
            }
        } catch (InterruptedException e) {
            throw new InterruptedIOException("interrupted");
        }
    }
}
