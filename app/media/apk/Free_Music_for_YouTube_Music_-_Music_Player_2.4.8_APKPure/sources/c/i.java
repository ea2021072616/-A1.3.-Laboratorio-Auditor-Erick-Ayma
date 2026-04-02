package c;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* compiled from: ForwardingTimeout.java */
/* loaded from: classes.dex */
public class i extends t {

    /* renamed from: a  reason: collision with root package name */
    private t f291a;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f291a = tVar;
    }

    public final t a() {
        return this.f291a;
    }

    public final i a(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f291a = tVar;
        return this;
    }

    @Override // c.t
    public t timeout(long j, TimeUnit timeUnit) {
        return this.f291a.timeout(j, timeUnit);
    }

    @Override // c.t
    public long timeoutNanos() {
        return this.f291a.timeoutNanos();
    }

    @Override // c.t
    public boolean hasDeadline() {
        return this.f291a.hasDeadline();
    }

    @Override // c.t
    public long deadlineNanoTime() {
        return this.f291a.deadlineNanoTime();
    }

    @Override // c.t
    public t deadlineNanoTime(long j) {
        return this.f291a.deadlineNanoTime(j);
    }

    @Override // c.t
    public t clearTimeout() {
        return this.f291a.clearTimeout();
    }

    @Override // c.t
    public t clearDeadline() {
        return this.f291a.clearDeadline();
    }

    @Override // c.t
    public void throwIfReached() throws IOException {
        this.f291a.throwIfReached();
    }
}
