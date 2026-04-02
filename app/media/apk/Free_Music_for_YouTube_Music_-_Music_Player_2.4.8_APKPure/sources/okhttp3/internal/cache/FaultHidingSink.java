package okhttp3.internal.cache;

import c.c;
import c.g;
import c.r;
import java.io.IOException;
/* loaded from: classes2.dex */
class FaultHidingSink extends g {
    private boolean hasErrors;

    public FaultHidingSink(r rVar) {
        super(rVar);
    }

    @Override // c.g, c.r
    public void write(c cVar, long j) throws IOException {
        if (this.hasErrors) {
            cVar.h(j);
            return;
        }
        try {
            super.write(cVar, j);
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    @Override // c.g, c.r, java.io.Flushable
    public void flush() throws IOException {
        if (!this.hasErrors) {
            try {
                super.flush();
            } catch (IOException e) {
                this.hasErrors = true;
                onException(e);
            }
        }
    }

    @Override // c.g, c.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.hasErrors) {
            try {
                super.close();
            } catch (IOException e) {
                this.hasErrors = true;
                onException(e);
            }
        }
    }

    protected void onException(IOException iOException) {
    }
}
