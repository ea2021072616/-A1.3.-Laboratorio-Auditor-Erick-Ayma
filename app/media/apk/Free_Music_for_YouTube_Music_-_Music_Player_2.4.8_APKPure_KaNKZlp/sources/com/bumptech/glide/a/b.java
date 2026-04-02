package com.bumptech.glide.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f617a;

    /* renamed from: b  reason: collision with root package name */
    private final Charset f618b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f619c;
    private int d;
    private int e;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f621a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f617a = inputStream;
        this.f618b = charset;
        this.f619c = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f617a) {
            if (this.f619c != null) {
                this.f619c = null;
                this.f617a.close();
            }
        }
    }

    public String a() throws IOException {
        int i;
        String byteArrayOutputStream;
        synchronized (this.f617a) {
            if (this.f619c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.d >= this.e) {
                c();
            }
            int i2 = this.d;
            while (true) {
                if (i2 != this.e) {
                    if (this.f619c[i2] != 10) {
                        i2++;
                    } else {
                        byteArrayOutputStream = new String(this.f619c, this.d, ((i2 == this.d || this.f619c[i2 + (-1)] != 13) ? i2 : i2 - 1) - this.d, this.f618b.name());
                        this.d = i2 + 1;
                    }
                } else {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream((this.e - this.d) + 80) { // from class: com.bumptech.glide.a.b.1
                        @Override // java.io.ByteArrayOutputStream
                        public String toString() {
                            try {
                                return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, b.this.f618b.name());
                            } catch (UnsupportedEncodingException e) {
                                throw new AssertionError(e);
                            }
                        }
                    };
                    loop1: while (true) {
                        byteArrayOutputStream2.write(this.f619c, this.d, this.e - this.d);
                        this.e = -1;
                        c();
                        i = this.d;
                        while (i != this.e) {
                            if (this.f619c[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                    if (i != this.d) {
                        byteArrayOutputStream2.write(this.f619c, this.d, i - this.d);
                    }
                    this.d = i + 1;
                    byteArrayOutputStream = byteArrayOutputStream2.toString();
                }
            }
            return byteArrayOutputStream;
        }
    }

    public boolean b() {
        return this.e == -1;
    }

    private void c() throws IOException {
        int read = this.f617a.read(this.f619c, 0, this.f619c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.d = 0;
        this.e = read;
    }
}
