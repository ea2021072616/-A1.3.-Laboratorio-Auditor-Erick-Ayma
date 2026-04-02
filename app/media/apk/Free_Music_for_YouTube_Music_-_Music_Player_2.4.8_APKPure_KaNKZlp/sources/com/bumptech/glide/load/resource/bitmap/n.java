package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.flurry.android.Constants;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: RecyclableBufferedInputStream.java */
/* loaded from: classes.dex */
public class n extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f942a;

    /* renamed from: b  reason: collision with root package name */
    private int f943b;

    /* renamed from: c  reason: collision with root package name */
    private int f944c;
    private int d;
    private int e;

    public n(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.d = -1;
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("buffer is null or empty");
        }
        this.f942a = bArr;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f942a == null || inputStream == null) {
            throw b();
        }
        return inputStream.available() + (this.f943b - this.e);
    }

    private static IOException b() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.f944c = this.f942a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f942a = null;
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        if (this.d == -1 || this.e - this.d >= this.f944c) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.d = -1;
                this.e = 0;
                this.f943b = read;
                return read;
            }
            return read;
        }
        if (this.d == 0 && this.f944c > bArr.length && this.f943b == bArr.length) {
            int length = bArr.length * 2;
            if (length > this.f944c) {
                length = this.f944c;
            }
            if (Log.isLoggable("BufferedIs", 3)) {
                Log.d("BufferedIs", "allocate buffer of length: " + length);
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f942a = bArr2;
            bArr = bArr2;
        } else if (this.d > 0) {
            System.arraycopy(bArr, this.d, bArr, 0, bArr.length - this.d);
        }
        this.e -= this.d;
        this.d = 0;
        this.f943b = 0;
        int read2 = inputStream.read(bArr, this.e, bArr.length - this.e);
        this.f943b = read2 <= 0 ? this.e : this.e + read2;
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f944c = Math.max(this.f944c, i);
        this.d = this.e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            byte[] bArr = this.f942a;
            InputStream inputStream = this.in;
            if (bArr == null || inputStream == null) {
                throw b();
            }
            if (this.e < this.f943b || a(inputStream, bArr) != -1) {
                if (bArr != this.f942a && (bArr = this.f942a) == null) {
                    throw b();
                }
                if (this.f943b - this.e > 0) {
                    int i2 = this.e;
                    this.e = i2 + 1;
                    i = bArr[i2] & Constants.UNKNOWN;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0090 A[Catch: all -> 0x000b, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0006, B:7:0x000a, B:15:0x0013, B:17:0x0017, B:18:0x001b, B:19:0x001c, B:21:0x0022, B:24:0x002a, B:26:0x0036, B:30:0x0044, B:31:0x0047, B:33:0x004b, B:35:0x004e, B:38:0x0056, B:54:0x0085, B:58:0x0090, B:40:0x005b, B:43:0x0063, B:44:0x0066, B:46:0x006a, B:48:0x006e, B:49:0x0072, B:50:0x0073, B:53:0x007b, B:57:0x008a, B:29:0x003e), top: B:62:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0088 A[SYNTHETIC] */
    @Override // java.io.FilterInputStream, java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized int read(byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            r0 = -1
            monitor-enter(r6)
            byte[] r2 = r6.f942a     // Catch: java.lang.Throwable -> Lb
            if (r2 != 0) goto Le
            java.io.IOException r0 = b()     // Catch: java.lang.Throwable -> Lb
            throw r0     // Catch: java.lang.Throwable -> Lb
        Lb:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        Le:
            if (r9 != 0) goto L13
            r0 = 0
        L11:
            monitor-exit(r6)
            return r0
        L13:
            java.io.InputStream r4 = r6.in     // Catch: java.lang.Throwable -> Lb
            if (r4 != 0) goto L1c
            java.io.IOException r0 = b()     // Catch: java.lang.Throwable -> Lb
            throw r0     // Catch: java.lang.Throwable -> Lb
        L1c:
            int r1 = r6.e     // Catch: java.lang.Throwable -> Lb
            int r3 = r6.f943b     // Catch: java.lang.Throwable -> Lb
            if (r1 >= r3) goto L59
            int r1 = r6.f943b     // Catch: java.lang.Throwable -> Lb
            int r3 = r6.e     // Catch: java.lang.Throwable -> Lb
            int r1 = r1 - r3
            if (r1 < r9) goto L3e
            r1 = r9
        L2a:
            int r3 = r6.e     // Catch: java.lang.Throwable -> Lb
            java.lang.System.arraycopy(r2, r3, r7, r8, r1)     // Catch: java.lang.Throwable -> Lb
            int r3 = r6.e     // Catch: java.lang.Throwable -> Lb
            int r3 = r3 + r1
            r6.e = r3     // Catch: java.lang.Throwable -> Lb
            if (r1 == r9) goto L3c
            int r3 = r4.available()     // Catch: java.lang.Throwable -> Lb
            if (r3 != 0) goto L44
        L3c:
            r0 = r1
            goto L11
        L3e:
            int r1 = r6.f943b     // Catch: java.lang.Throwable -> Lb
            int r3 = r6.e     // Catch: java.lang.Throwable -> Lb
            int r1 = r1 - r3
            goto L2a
        L44:
            int r8 = r8 + r1
            int r3 = r9 - r1
        L47:
            int r1 = r6.d     // Catch: java.lang.Throwable -> Lb
            if (r1 != r0) goto L5b
            int r1 = r2.length     // Catch: java.lang.Throwable -> Lb
            if (r3 < r1) goto L5b
            int r1 = r4.read(r7, r8, r3)     // Catch: java.lang.Throwable -> Lb
            if (r1 != r0) goto L85
            if (r3 == r9) goto L11
            int r0 = r9 - r3
            goto L11
        L59:
            r3 = r9
            goto L47
        L5b:
            int r1 = r6.a(r4, r2)     // Catch: java.lang.Throwable -> Lb
            if (r1 != r0) goto L66
            if (r3 == r9) goto L11
            int r0 = r9 - r3
            goto L11
        L66:
            byte[] r1 = r6.f942a     // Catch: java.lang.Throwable -> Lb
            if (r2 == r1) goto L73
            byte[] r2 = r6.f942a     // Catch: java.lang.Throwable -> Lb
            if (r2 != 0) goto L73
            java.io.IOException r0 = b()     // Catch: java.lang.Throwable -> Lb
            throw r0     // Catch: java.lang.Throwable -> Lb
        L73:
            int r1 = r6.f943b     // Catch: java.lang.Throwable -> Lb
            int r5 = r6.e     // Catch: java.lang.Throwable -> Lb
            int r1 = r1 - r5
            if (r1 < r3) goto L8a
            r1 = r3
        L7b:
            int r5 = r6.e     // Catch: java.lang.Throwable -> Lb
            java.lang.System.arraycopy(r2, r5, r7, r8, r1)     // Catch: java.lang.Throwable -> Lb
            int r5 = r6.e     // Catch: java.lang.Throwable -> Lb
            int r5 = r5 + r1
            r6.e = r5     // Catch: java.lang.Throwable -> Lb
        L85:
            int r3 = r3 - r1
            if (r3 != 0) goto L90
            r0 = r9
            goto L11
        L8a:
            int r1 = r6.f943b     // Catch: java.lang.Throwable -> Lb
            int r5 = r6.e     // Catch: java.lang.Throwable -> Lb
            int r1 = r1 - r5
            goto L7b
        L90:
            int r5 = r4.available()     // Catch: java.lang.Throwable -> Lb
            if (r5 != 0) goto L9a
            int r0 = r9 - r3
            goto L11
        L9a:
            int r8 = r8 + r1
            goto L47
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.n.read(byte[], int, int):int");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f942a == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.d) {
            throw new a("Mark has been invalidated");
        }
        this.e = this.d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        byte[] bArr = this.f942a;
        InputStream inputStream = this.in;
        if (bArr == null) {
            throw b();
        }
        if (j < 1) {
            j = 0;
        } else if (inputStream == null) {
            throw b();
        } else {
            if (this.f943b - this.e >= j) {
                this.e = (int) (this.e + j);
            } else {
                long j2 = this.f943b - this.e;
                this.e = this.f943b;
                if (this.d != -1 && j <= this.f944c) {
                    if (a(inputStream, bArr) == -1) {
                        j = j2;
                    } else if (this.f943b - this.e >= j - j2) {
                        this.e = (int) ((j - j2) + this.e);
                    } else {
                        j = (j2 + this.f943b) - this.e;
                        this.e = this.f943b;
                    }
                } else {
                    j = j2 + inputStream.skip(j - j2);
                }
            }
        }
        return j;
    }

    /* compiled from: RecyclableBufferedInputStream.java */
    /* loaded from: classes.dex */
    public static class a extends RuntimeException {
        private static final long serialVersionUID = -4338378848813561757L;

        public a(String str) {
            super(str);
        }
    }
}
