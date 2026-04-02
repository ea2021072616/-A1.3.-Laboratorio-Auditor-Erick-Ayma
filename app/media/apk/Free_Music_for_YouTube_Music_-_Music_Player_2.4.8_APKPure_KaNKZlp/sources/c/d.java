package c;

import java.io.IOException;
/* compiled from: BufferedSink.java */
/* loaded from: classes.dex */
public interface d extends r {
    long a(s sVar) throws IOException;

    c b();

    d b(f fVar) throws IOException;

    d b(String str) throws IOException;

    d c(byte[] bArr) throws IOException;

    d c(byte[] bArr, int i, int i2) throws IOException;

    d e() throws IOException;

    @Override // c.r, java.io.Flushable
    void flush() throws IOException;

    d g(int i) throws IOException;

    d h(int i) throws IOException;

    d i(int i) throws IOException;

    d l(long j) throws IOException;

    d m(long j) throws IOException;

    d n(long j) throws IOException;

    d y() throws IOException;
}
