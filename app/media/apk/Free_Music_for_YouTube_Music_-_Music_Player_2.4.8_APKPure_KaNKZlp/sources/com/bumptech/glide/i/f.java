package com.bumptech.glide.i;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: MarkEnforcingInputStream.java */
/* loaded from: classes.dex */
public class f extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private int f730a;

    public f(InputStream inputStream) {
        super(inputStream);
        this.f730a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        super.mark(i);
        this.f730a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int a2 = (int) a(i2);
        if (a2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a2);
        b(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.f730a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long a2 = a(j);
        if (a2 == -1) {
            return -1L;
        }
        long skip = super.skip(a2);
        b(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.f730a == Integer.MIN_VALUE ? super.available() : Math.min(this.f730a, super.available());
    }

    private long a(long j) {
        if (this.f730a == 0) {
            return -1L;
        }
        if (this.f730a != Integer.MIN_VALUE && j > this.f730a) {
            return this.f730a;
        }
        return j;
    }

    private void b(long j) {
        if (this.f730a != Integer.MIN_VALUE && j != -1) {
            this.f730a = (int) (this.f730a - j);
        }
    }
}
