package com.facebook.ads.internal.i.b.a;

import com.facebook.ads.internal.i.b.l;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class b implements com.facebook.ads.internal.i.b.a {

    /* renamed from: a  reason: collision with root package name */
    public File f1399a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1400b;

    /* renamed from: c  reason: collision with root package name */
    private RandomAccessFile f1401c;

    public b(File file, a aVar) {
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.f1400b = aVar;
            d.a(file.getParentFile());
            boolean exists = file.exists();
            this.f1399a = exists ? file : new File(file.getParentFile(), file.getName() + ".download");
            this.f1401c = new RandomAccessFile(this.f1399a, exists ? "r" : "rw");
        } catch (IOException e) {
            throw new l("Error using file " + file + " as disc cache", e);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.facebook.ads.internal.i.b.a
    public synchronized int a() {
        try {
        } catch (IOException e) {
            throw new l("Error reading length of file " + this.f1399a, e);
        }
        return (int) this.f1401c.length();
    }

    @Override // com.facebook.ads.internal.i.b.a
    public synchronized int a(byte[] bArr, long j, int i) {
        try {
            this.f1401c.seek(j);
        } catch (IOException e) {
            throw new l(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(a()), Integer.valueOf(bArr.length)), e);
        }
        return this.f1401c.read(bArr, 0, i);
    }

    @Override // com.facebook.ads.internal.i.b.a
    public synchronized void a(byte[] bArr, int i) {
        try {
            if (d()) {
                throw new l("Error append cache: cache file " + this.f1399a + " is completed!");
            }
            this.f1401c.seek(a());
            this.f1401c.write(bArr, 0, i);
        } catch (IOException e) {
            throw new l(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.f1401c, Integer.valueOf(bArr.length)), e);
        }
    }

    @Override // com.facebook.ads.internal.i.b.a
    public synchronized void b() {
        try {
            this.f1401c.close();
            this.f1400b.a(this.f1399a);
        } catch (IOException e) {
            throw new l("Error closing file " + this.f1399a, e);
        }
    }

    @Override // com.facebook.ads.internal.i.b.a
    public synchronized void c() {
        if (!d()) {
            b();
            File file = new File(this.f1399a.getParentFile(), this.f1399a.getName().substring(0, this.f1399a.getName().length() - ".download".length()));
            if (!this.f1399a.renameTo(file)) {
                throw new l("Error renaming file " + this.f1399a + " to " + file + " for completion!");
            }
            this.f1399a = file;
            try {
                this.f1401c = new RandomAccessFile(this.f1399a, "r");
            } catch (IOException e) {
                throw new l("Error opening " + this.f1399a + " as disc cache", e);
            }
        }
    }

    @Override // com.facebook.ads.internal.i.b.a
    public synchronized boolean d() {
        return !a(this.f1399a);
    }
}
