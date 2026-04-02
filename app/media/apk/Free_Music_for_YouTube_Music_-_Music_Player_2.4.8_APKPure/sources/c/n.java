package c;

import com.flurry.android.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSource.java */
/* loaded from: classes.dex */
public final class n implements e {

    /* renamed from: a  reason: collision with root package name */
    public final c f307a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final s f308b;

    /* renamed from: c  reason: collision with root package name */
    boolean f309c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(s sVar) {
        if (sVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f308b = sVar;
    }

    @Override // c.e
    public c b() {
        return this.f307a;
    }

    @Override // c.s
    public long read(c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f309c) {
            throw new IllegalStateException("closed");
        }
        if (this.f307a.f285b == 0 && this.f308b.read(this.f307a, 8192L) == -1) {
            return -1L;
        }
        return this.f307a.read(cVar, Math.min(j, this.f307a.f285b));
    }

    @Override // c.e
    public boolean f() throws IOException {
        if (this.f309c) {
            throw new IllegalStateException("closed");
        }
        return this.f307a.f() && this.f308b.read(this.f307a, 8192L) == -1;
    }

    @Override // c.e
    public void a(long j) throws IOException {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    @Override // c.e
    public boolean b(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f309c) {
            throw new IllegalStateException("closed");
        }
        while (this.f307a.f285b < j) {
            if (this.f308b.read(this.f307a, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // c.e
    public byte i() throws IOException {
        a(1L);
        return this.f307a.i();
    }

    @Override // c.e
    public f d(long j) throws IOException {
        a(j);
        return this.f307a.d(j);
    }

    @Override // c.e
    public byte[] u() throws IOException {
        this.f307a.a(this.f308b);
        return this.f307a.u();
    }

    @Override // c.e
    public byte[] g(long j) throws IOException {
        a(j);
        return this.f307a.g(j);
    }

    @Override // c.e
    public void a(byte[] bArr) throws IOException {
        try {
            a(bArr.length);
            this.f307a.a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f307a.f285b > 0) {
                int a2 = this.f307a.a(bArr, i, (int) this.f307a.f285b);
                if (a2 == -1) {
                    throw new AssertionError();
                }
                i += a2;
            }
            throw e;
        }
    }

    @Override // c.e
    public int a(byte[] bArr, int i, int i2) throws IOException {
        u.a(bArr.length, i, i2);
        if (this.f307a.f285b == 0 && this.f308b.read(this.f307a, 8192L) == -1) {
            return -1;
        }
        return this.f307a.a(bArr, i, (int) Math.min(i2, this.f307a.f285b));
    }

    @Override // c.e
    public void a(c cVar, long j) throws IOException {
        try {
            a(j);
            this.f307a.a(cVar, j);
        } catch (EOFException e) {
            cVar.a((s) this.f307a);
            throw e;
        }
    }

    @Override // c.e
    public long a(r rVar) throws IOException {
        if (rVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.f308b.read(this.f307a, 8192L) != -1) {
            long h = this.f307a.h();
            if (h > 0) {
                j += h;
                rVar.write(this.f307a, h);
            }
        }
        if (this.f307a.a() > 0) {
            long a2 = j + this.f307a.a();
            rVar.write(this.f307a, this.f307a.a());
            return a2;
        }
        return j;
    }

    @Override // c.e
    public String a(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f307a.a(this.f308b);
        return this.f307a.a(charset);
    }

    @Override // c.e
    public String s() throws IOException {
        long a2 = a((byte) 10);
        if (a2 == -1) {
            c cVar = new c();
            this.f307a.a(cVar, 0L, Math.min(32L, this.f307a.a()));
            throw new EOFException("\\n not found: size=" + this.f307a.a() + " content=" + cVar.q().f() + "…");
        }
        return this.f307a.f(a2);
    }

    @Override // c.e
    public short j() throws IOException {
        a(2L);
        return this.f307a.j();
    }

    @Override // c.e
    public short m() throws IOException {
        a(2L);
        return this.f307a.m();
    }

    @Override // c.e
    public int k() throws IOException {
        a(4L);
        return this.f307a.k();
    }

    @Override // c.e
    public int n() throws IOException {
        a(4L);
        return this.f307a.n();
    }

    @Override // c.e
    public long l() throws IOException {
        a(8L);
        return this.f307a.l();
    }

    @Override // c.e
    public long o() throws IOException {
        a(1L);
        for (int i = 0; b(i + 1); i++) {
            byte c2 = this.f307a.c(i);
            if ((c2 < 48 || c2 > 57) && (i != 0 || c2 != 45)) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(c2)));
                }
                return this.f307a.o();
            }
        }
        return this.f307a.o();
    }

    @Override // c.e
    public long p() throws IOException {
        a(1L);
        for (int i = 0; b(i + 1); i++) {
            byte c2 = this.f307a.c(i);
            if ((c2 < 48 || c2 > 57) && ((c2 < 97 || c2 > 102) && (c2 < 65 || c2 > 70))) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(c2)));
                }
                return this.f307a.p();
            }
        }
        return this.f307a.p();
    }

    @Override // c.e
    public void h(long j) throws IOException {
        if (this.f309c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f307a.f285b == 0 && this.f308b.read(this.f307a, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f307a.a());
            this.f307a.h(min);
            j -= min;
        }
    }

    @Override // c.e
    public long a(byte b2) throws IOException {
        return a(b2, 0L);
    }

    public long a(byte b2, long j) throws IOException {
        if (this.f309c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long a2 = this.f307a.a(b2, j);
            if (a2 == -1) {
                long j2 = this.f307a.f285b;
                if (this.f308b.read(this.f307a, 8192L) == -1) {
                    return -1L;
                }
                j = Math.max(j, j2);
            } else {
                return a2;
            }
        }
    }

    @Override // c.e
    public boolean a(long j, f fVar) throws IOException {
        return a(j, fVar, 0, fVar.h());
    }

    public boolean a(long j, f fVar, int i, int i2) throws IOException {
        if (this.f309c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || fVar.h() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!b(1 + j2) || this.f307a.c(j2) != fVar.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // c.e
    public InputStream g() {
        return new InputStream() { // from class: c.n.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (n.this.f309c) {
                    throw new IOException("closed");
                }
                if (n.this.f307a.f285b == 0 && n.this.f308b.read(n.this.f307a, 8192L) == -1) {
                    return -1;
                }
                return n.this.f307a.i() & Constants.UNKNOWN;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (n.this.f309c) {
                    throw new IOException("closed");
                }
                u.a(bArr.length, i, i2);
                if (n.this.f307a.f285b == 0 && n.this.f308b.read(n.this.f307a, 8192L) == -1) {
                    return -1;
                }
                return n.this.f307a.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (n.this.f309c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(n.this.f307a.f285b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                n.this.close();
            }

            public String toString() {
                return n.this + ".inputStream()";
            }
        };
    }

    @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f309c) {
            this.f309c = true;
            this.f308b.close();
            this.f307a.v();
        }
    }

    @Override // c.s
    public t timeout() {
        return this.f308b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f308b + ")";
    }
}
