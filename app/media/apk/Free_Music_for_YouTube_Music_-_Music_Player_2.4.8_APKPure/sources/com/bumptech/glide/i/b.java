package com.bumptech.glide.i;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: ContentLengthInputStream.java */
/* loaded from: classes.dex */
public final class b extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final long f721a;

    /* renamed from: b  reason: collision with root package name */
    private int f722b;

    public static InputStream a(InputStream inputStream, long j) {
        return new b(inputStream, j);
    }

    b(InputStream inputStream, long j) {
        super(inputStream);
        this.f721a = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f721a - this.f722b, this.in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        return a(super.read());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return a(super.read(bArr, i, i2));
    }

    private int a(int i) throws IOException {
        if (i >= 0) {
            this.f722b += i;
        } else if (this.f721a - this.f722b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f721a + ", but read: " + this.f722b);
        }
        return i;
    }
}
