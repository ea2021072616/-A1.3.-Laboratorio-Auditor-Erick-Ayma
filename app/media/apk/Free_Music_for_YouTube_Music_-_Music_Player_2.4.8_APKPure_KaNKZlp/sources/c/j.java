package c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* compiled from: GzipSource.java */
/* loaded from: classes.dex */
public final class j implements s {

    /* renamed from: b  reason: collision with root package name */
    private final e f293b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f294c;
    private final k d;

    /* renamed from: a  reason: collision with root package name */
    private int f292a = 0;
    private final CRC32 e = new CRC32();

    public j(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f294c = new Inflater(true);
        this.f293b = l.a(sVar);
        this.d = new k(this.f293b, this.f294c);
    }

    @Override // c.s
    public long read(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f292a == 0) {
            a();
            this.f292a = 1;
        }
        if (this.f292a == 1) {
            long j2 = cVar.f285b;
            long read = this.d.read(cVar, j);
            if (read != -1) {
                a(cVar, j2, read);
                return read;
            }
            this.f292a = 2;
        }
        if (this.f292a == 2) {
            b();
            this.f292a = 3;
            if (!this.f293b.f()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void a() throws IOException {
        this.f293b.a(10L);
        byte c2 = this.f293b.b().c(3L);
        boolean z = ((c2 >> 1) & 1) == 1;
        if (z) {
            a(this.f293b.b(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f293b.j());
        this.f293b.h(8L);
        if (((c2 >> 2) & 1) == 1) {
            this.f293b.a(2L);
            if (z) {
                a(this.f293b.b(), 0L, 2L);
            }
            short m = this.f293b.b().m();
            this.f293b.a(m);
            if (z) {
                a(this.f293b.b(), 0L, m);
            }
            this.f293b.h(m);
        }
        if (((c2 >> 3) & 1) == 1) {
            long a2 = this.f293b.a((byte) 0);
            if (a2 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.f293b.b(), 0L, 1 + a2);
            }
            this.f293b.h(1 + a2);
        }
        if (((c2 >> 4) & 1) == 1) {
            long a3 = this.f293b.a((byte) 0);
            if (a3 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.f293b.b(), 0L, 1 + a3);
            }
            this.f293b.h(1 + a3);
        }
        if (z) {
            a("FHCRC", this.f293b.m(), (short) this.e.getValue());
            this.e.reset();
        }
    }

    private void b() throws IOException {
        a("CRC", this.f293b.n(), (int) this.e.getValue());
        a("ISIZE", this.f293b.n(), (int) this.f294c.getBytesWritten());
    }

    @Override // c.s
    public t timeout() {
        return this.f293b.timeout();
    }

    @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
    }

    private void a(c cVar, long j, long j2) {
        int i;
        o oVar = cVar.f284a;
        while (j >= oVar.f313c - oVar.f312b) {
            j -= oVar.f313c - oVar.f312b;
            oVar = oVar.f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(oVar.f313c - i, j2);
            this.e.update(oVar.f311a, (int) (oVar.f312b + j), min);
            j2 -= min;
            oVar = oVar.f;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
