package c;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
/* compiled from: Sink.java */
/* loaded from: classes.dex */
public interface r extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    t timeout();

    void write(c cVar, long j) throws IOException;
}
