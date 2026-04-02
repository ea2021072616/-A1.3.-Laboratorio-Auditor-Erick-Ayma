package ru.zdevs.zugate.jni;

import ru.zdevs.zugate.jni.BlockDevice;
/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: b  reason: collision with root package name */
    public long f4616b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4617c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4618d;

    public a(long j5, int i5) {
        this.f4616b = j5;
        this.f4617c = i5;
    }

    @Override // ru.zdevs.zugate.jni.d
    public final boolean A(int i5, String str, String str2, String str3, StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            throw new BlockDevice.BlockException(-103, "Password is empty");
        }
        long cInitCryptSetup = BlockDevice.cInitCryptSetup(this.f4616b, i5, str, str2, str3);
        if (cInitCryptSetup == 0) {
            return false;
        }
        this.f4616b = cInitCryptSetup;
        return true;
    }

    @Override // ru.zdevs.zugate.jni.d
    public final boolean E() {
        return this.f4618d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (!j()) {
            long j5 = this.f4616b;
            this.f4616b = 0L;
            BlockDevice.cCloseBlock(j5);
        }
    }

    public final void finalize() {
        if (j()) {
            return;
        }
        close();
    }

    public final boolean j() {
        return this.f4616b == 0;
    }

    @Override // ru.zdevs.zugate.jni.d
    public final int q() {
        if (j()) {
            return 100;
        }
        return BlockDevice.cTypeBlock(this.f4616b);
    }

    @Override // ru.zdevs.zugate.jni.d
    public final String z(int i5) {
        if (j()) {
            return null;
        }
        return BlockDevice.cDumpCryptSetup(this.f4616b, i5);
    }
}
