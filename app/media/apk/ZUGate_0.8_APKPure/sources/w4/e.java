package w4;

import ru.zdevs.zugate.jni.FS;
/* loaded from: classes.dex */
public final class e implements g {

    /* renamed from: b  reason: collision with root package name */
    public final FS f5424b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5425c;

    /* renamed from: d  reason: collision with root package name */
    public long f5426d;

    public e(long j5, long j6, FS fs) {
        this.f5426d = j5;
        this.f5425c = j6;
        this.f5424b = fs;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        synchronized (this.f5424b) {
            long j5 = this.f5426d;
            if (j5 != 0) {
                this.f5426d = 0L;
                FS.cClose(this.f5424b.f4603c, j5);
            }
        }
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
        cWriteFrom = FS.cWriteFrom(this.f5426d, i5);
        return cWriteFrom;
    }

    public final boolean j() {
        return this.f5426d == 0;
    }

    @Override // w4.g
    public final int o(byte[] bArr, int i5) {
        int cWrite;
        if (j()) {
            return -1;
        }
        cWrite = FS.cWrite(this.f5426d, bArr, i5);
        return cWrite;
    }

    @Override // w4.g
    public final long r(long j5, int i5) {
        long cSeek;
        if (j()) {
            return -1L;
        }
        cSeek = FS.cSeek(this.f5426d, j5, i5);
        return cSeek;
    }

    @Override // w4.g
    public final int s(byte[] bArr, int i5) {
        int cRead;
        if (j()) {
            return -1;
        }
        cRead = FS.cRead(this.f5426d, bArr, i5);
        return cRead;
    }

    @Override // w4.g
    public final long y() {
        return this.f5425c;
    }
}
