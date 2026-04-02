package c;

import java.io.IOException;
/* compiled from: ForwardingSink.java */
/* loaded from: classes.dex */
public abstract class g implements r {
    private final r delegate;

    public g(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = rVar;
    }

    public final r delegate() {
        return this.delegate;
    }

    @Override // c.r
    public void write(c cVar, long j) throws IOException {
        this.delegate.write(cVar, j);
    }

    @Override // c.r, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // c.r
    public t timeout() {
        return this.delegate.timeout();
    }

    @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
