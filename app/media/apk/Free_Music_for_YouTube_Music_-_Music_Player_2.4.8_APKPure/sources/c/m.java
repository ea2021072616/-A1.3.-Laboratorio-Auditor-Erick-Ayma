package c;

import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealBufferedSink.java */
/* loaded from: classes.dex */
public final class m implements d {

    /* renamed from: a  reason: collision with root package name */
    public final c f304a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final r f305b;

    /* renamed from: c  reason: collision with root package name */
    boolean f306c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.f305b = rVar;
    }

    @Override // c.d, c.e
    public c b() {
        return this.f304a;
    }

    @Override // c.r
    public void write(c cVar, long j) throws IOException {
        if (this.f306c) {
            throw new IllegalStateException("closed");
        }
        this.f304a.write(cVar, j);
        y();
    }

    @Override // c.d
    public d b(f fVar) throws IOException {
        if (this.f306c) {
            throw new IllegalStateException("closed");
        }
        this.f304a.b(fVar);
        return y();
    }

    @Override // c.d
    public d b(String str) throws IOException {
        if (this.f306c) {
            throw new IllegalStateException("closed");
        }
        this.f304a.b(str);
        return y();
    }

    @Override // c.d
    public d c(byte[] bArr) throws IOException {
        if (this.f306c) {
            throw new IllegalStateException("closed");
        }
        this.f304a.c(bArr);
        return y();
    }

    @Override // c.d
    public d c(byte[] bArr, int i, int i2) throws IOException {
        if (this.f306c) {
            throw new IllegalStateException("closed");
        }
        this.f304a.c(bArr, i, i2);
        return y();
    }

    @Override // c.d
    public long a(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = sVar.read(this.f304a, 8192L);
            if (read != -1) {
                j += read;
                y();
            } else {
                return j;
            }
        }
    }

    @Override // c.d
    public d i(int i) throws IOException {
        if (this.f306c) {
            throw new IllegalStateException("closed");
        }
        this.f304a.i(i);
        return y();
    }

    @Override // c.d
    public d h(int i) throws IOException {
        if (this.f306c) {
            throw new IllegalStateException("closed");
        }
        this.f304a.h(i);
        return y();
    }

    @Override // c.d
    public d g(int i) throws IOException {
        if (this.f306c) {
            throw new IllegalStateException("closed");
        }
        this.f304a.g(i);
        return y();
    }

    @Override // c.d
    public d n(long j) throws IOException {
        if (this.f306c) {
            throw new IllegalStateException("closed");
        }
        this.f304a.n(j);
        return y();
    }

    @Override // c.d
    public d m(long j) throws IOException {
        if (this.f306c) {
            throw new IllegalStateException("closed");
        }
        this.f304a.m(j);
        return y();
    }

    @Override // c.d
    public d l(long j) throws IOException {
        if (this.f306c) {
            throw new IllegalStateException("closed");
        }
        this.f304a.l(j);
        return y();
    }

    @Override // c.d
    public d y() throws IOException {
        if (this.f306c) {
            throw new IllegalStateException("closed");
        }
        long h = this.f304a.h();
        if (h > 0) {
            this.f305b.write(this.f304a, h);
        }
        return this;
    }

    @Override // c.d
    public d e() throws IOException {
        if (this.f306c) {
            throw new IllegalStateException("closed");
        }
        long a2 = this.f304a.a();
        if (a2 > 0) {
            this.f305b.write(this.f304a, a2);
        }
        return this;
    }

    @Override // c.d, c.r, java.io.Flushable
    public void flush() throws IOException {
        if (this.f306c) {
            throw new IllegalStateException("closed");
        }
        if (this.f304a.f285b > 0) {
            this.f305b.write(this.f304a, this.f304a.f285b);
        }
        this.f305b.flush();
    }

    @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f306c) {
            Throwable th = null;
            try {
                if (this.f304a.f285b > 0) {
                    this.f305b.write(this.f304a, this.f304a.f285b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f305b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f306c = true;
            if (th != null) {
                u.a(th);
            }
        }
    }

    @Override // c.r
    public t timeout() {
        return this.f305b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f305b + ")";
    }
}
