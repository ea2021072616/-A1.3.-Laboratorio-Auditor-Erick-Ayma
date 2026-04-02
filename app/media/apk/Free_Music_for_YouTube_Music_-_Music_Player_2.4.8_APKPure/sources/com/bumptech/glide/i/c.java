package com.bumptech.glide.i;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
/* compiled from: ExceptionCatchingInputStream.java */
/* loaded from: classes.dex */
public class c extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final Queue<c> f723a = h.a(0);

    /* renamed from: b  reason: collision with root package name */
    private InputStream f724b;

    /* renamed from: c  reason: collision with root package name */
    private IOException f725c;

    public static c a(InputStream inputStream) {
        c poll;
        synchronized (f723a) {
            poll = f723a.poll();
        }
        if (poll == null) {
            poll = new c();
        }
        poll.b(inputStream);
        return poll;
    }

    c() {
    }

    void b(InputStream inputStream) {
        this.f724b = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f724b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f724b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f724b.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f724b.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f724b.read(bArr);
        } catch (IOException e) {
            this.f725c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.f724b.read(bArr, i, i2);
        } catch (IOException e) {
            this.f725c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f724b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return this.f724b.skip(j);
        } catch (IOException e) {
            this.f725c = e;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f724b.read();
        } catch (IOException e) {
            this.f725c = e;
            return -1;
        }
    }

    public IOException a() {
        return this.f725c;
    }

    public void b() {
        this.f725c = null;
        this.f724b = null;
        synchronized (f723a) {
            f723a.offer(this);
        }
    }
}
