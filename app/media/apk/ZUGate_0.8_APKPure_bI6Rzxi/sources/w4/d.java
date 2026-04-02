package w4;

import ru.zdevs.zugate.jni.EncFS;
/* loaded from: classes.dex */
public final class d implements g {

    /* renamed from: b  reason: collision with root package name */
    public EncFS f5422b;

    /* renamed from: c  reason: collision with root package name */
    public long f5423c;

    public d(long j5, EncFS encFS) {
        this.f5423c = j5;
        this.f5422b = encFS;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        long j5 = this.f5423c;
        if (j5 != 0) {
            this.f5423c = 0L;
            EncFS.cClose(this.f5422b.f4596b, j5);
        }
        this.f5422b = null;
    }

    public final void finalize() {
        if (j()) {
            return;
        }
        close();
    }

    @Override // w4.g
    public final int h(int i5) {
        int cWriteFrom;
        if (j()) {
            return -1;
        }
        cWriteFrom = EncFS.cWriteFrom(this.f5423c, i5);
        return cWriteFrom;
    }

    public final boolean j() {
        return this.f5423c == 0;
    }

    @Override // w4.g
    public final int o(byte[] bArr, int i5) {
        int cWrite;
        if (j()) {
            return -1;
        }
        cWrite = EncFS.cWrite(this.f5423c, bArr, i5);
        return cWrite;
    }

    @Override // w4.g
    public final long r(long j5, int i5) {
        long cSeek;
        if (j()) {
            return -1L;
        }
        cSeek = EncFS.cSeek(this.f5423c, j5, i5);
        return cSeek;
    }

    @Override // w4.g
    public final int s(byte[] bArr, int i5) {
        int cRead;
        if (j()) {
            return -1;
        }
        cRead = EncFS.cRead(this.f5423c, bArr, i5);
        return cRead;
    }

    @Override // w4.g
    public final long y() {
        return -1L;
    }
}
