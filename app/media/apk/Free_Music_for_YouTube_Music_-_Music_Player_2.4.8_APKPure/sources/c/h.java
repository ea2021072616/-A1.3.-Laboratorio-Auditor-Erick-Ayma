package c;

import java.io.IOException;
/* compiled from: ForwardingSource.java */
/* loaded from: classes.dex */
public abstract class h implements s {
    private final s delegate;

    public h(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = sVar;
    }

    public final s delegate() {
        return this.delegate;
    }

    @Override // c.s
    public long read(c cVar, long j) throws IOException {
        return this.delegate.read(cVar, j);
    }

    @Override // c.s
    public t timeout() {
        return this.delegate.timeout();
    }

    @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
