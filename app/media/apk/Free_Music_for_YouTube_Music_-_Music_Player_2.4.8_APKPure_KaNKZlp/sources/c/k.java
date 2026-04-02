package c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* compiled from: InflaterSource.java */
/* loaded from: classes.dex */
public final class k implements s {

    /* renamed from: a  reason: collision with root package name */
    private final e f295a;

    /* renamed from: b  reason: collision with root package name */
    private final Inflater f296b;

    /* renamed from: c  reason: collision with root package name */
    private int f297c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f295a = eVar;
        this.f296b = inflater;
    }

    @Override // c.s
    public long read(c cVar, long j) throws IOException {
        boolean a2;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            a2 = a();
            try {
                o e = cVar.e(1);
                int inflate = this.f296b.inflate(e.f311a, e.f313c, 8192 - e.f313c);
                if (inflate > 0) {
                    e.f313c += inflate;
                    cVar.f285b += inflate;
                    return inflate;
                } else if (this.f296b.finished() || this.f296b.needsDictionary()) {
                    b();
                    if (e.f312b == e.f313c) {
                        cVar.f284a = e.a();
                        p.a(e);
                    }
                    return -1L;
                }
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        } while (!a2);
        throw new EOFException("source exhausted prematurely");
    }

    public boolean a() throws IOException {
        if (this.f296b.needsInput()) {
            b();
            if (this.f296b.getRemaining() != 0) {
                throw new IllegalStateException("?");
            }
            if (this.f295a.f()) {
                return true;
            }
            o oVar = this.f295a.b().f284a;
            this.f297c = oVar.f313c - oVar.f312b;
            this.f296b.setInput(oVar.f311a, oVar.f312b, this.f297c);
            return false;
        }
        return false;
    }

    private void b() throws IOException {
        if (this.f297c != 0) {
            int remaining = this.f297c - this.f296b.getRemaining();
            this.f297c -= remaining;
            this.f295a.h(remaining);
        }
    }

    @Override // c.s
    public t timeout() {
        return this.f295a.timeout();
    }

    @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.d) {
            this.f296b.end();
            this.d = true;
            this.f295a.close();
        }
    }
}
