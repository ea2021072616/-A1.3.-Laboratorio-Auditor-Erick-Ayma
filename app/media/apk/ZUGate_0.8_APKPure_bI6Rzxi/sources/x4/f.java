package x4;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class f extends FilterInputStream {
    public f(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public final void finalize() {
        try {
            j();
        } catch (IOException unused) {
        }
    }

    public final void j() {
        ((FilterInputStream) this).in.close();
    }
}
