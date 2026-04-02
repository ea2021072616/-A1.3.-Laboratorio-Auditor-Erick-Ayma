package ru.zdevs.zugate.jni;

import androidx.annotation.Keep;
import dalvik.annotation.optimization.FastNative;
import java.util.Iterator;
import l.i;
import w4.f;
/* loaded from: classes.dex */
public class BlockDevice implements f {

    /* renamed from: b  reason: collision with root package name */
    public long f4591b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4592c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4593d;

    /* renamed from: e  reason: collision with root package name */
    public final i f4594e;

    /* loaded from: classes.dex */
    public static class BlockException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        public final int f4595b;

        @Keep
        public BlockException(int i5, String str) {
            super(str == null ? "" : str);
            this.f4595b = i5;
        }
    }

    static {
        System.loadLibrary("usb-1.0.27");
        System.loadLibrary("mbedtls-2.25.0");
        System.loadLibrary("bm-1.4");
    }

    public BlockDevice(long j5, boolean z4) {
        this.f4591b = j5;
        this.f4592c = z4;
        this.f4593d = cIsRO(j5) != 0;
        this.f4594e = new i();
    }

    public static native int cBenchmarkCryptSetup(String str, String str2, int i5);

    private static native void cClose(long j5);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int cCloseBlock(long j5);

    private static native void cDisconnect(long j5);

    public static native String cDumpCryptSetup(long j5, int i5);

    @FastNative
    private static native int cGetPartCount(long j5);

    private static native String cGetPartName(long j5, int i5);

    @FastNative
    private static native long cGetPartSize(long j5, int i5);

    private static native int cGetPartType(long j5, int i5);

    public static native long cInitCryptSetup(long j5, int i5, String str, String str2, String str3);

    private static native int cIsRO(long j5);

    public static native long cOpen(int i5, int i6, int i7, int i8, int i9);

    private static native long cOpenBlock(long j5, int i5);

    public static native int cTypeBlock(long j5);

    @Keep
    public static void init() {
    }

    @Override // w4.f
    public final d F(int i5) {
        synchronized (this) {
            if (!G() && i5 >= 0 && i5 < w()) {
                synchronized (this.f4594e) {
                    Iterator it = this.f4594e.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a aVar = (a) it.next();
                        if (aVar.f4617c == i5) {
                            if (!aVar.j()) {
                                return aVar;
                            }
                            this.f4594e.remove(aVar);
                        }
                    }
                    long cOpenBlock = cOpenBlock(this.f4591b, i5);
                    if (cOpenBlock == 0) {
                        return null;
                    }
                    a aVar2 = new a(cOpenBlock, i5);
                    synchronized (this.f4594e) {
                        this.f4594e.add(aVar2);
                    }
                    return aVar2;
                }
            }
            return null;
        }
    }

    public final boolean G() {
        return this.f4591b == 0;
    }

    @Override // w4.f
    public final synchronized void a() {
        long j5 = this.f4591b;
        if (j5 != 0) {
            this.f4591b = 0L;
            cDisconnect(j5);
        }
    }

    @Override // w4.f
    public final int b(int i5) {
        if (G()) {
            return -1;
        }
        return cGetPartType(this.f4591b, i5);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        long j5 = this.f4591b;
        if (j5 != 0) {
            this.f4591b = 0L;
            cClose(j5);
        }
    }

    @Override // w4.f
    public final long e(int i5) {
        return -1L;
    }

    public final void finalize() {
        if (G()) {
            return;
        }
        close();
    }

    @Override // w4.f
    public final String g(int i5) {
        String cGetPartName;
        if (G() || (cGetPartName = cGetPartName(this.f4591b, i5)) == null) {
            return null;
        }
        String trim = cGetPartName.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return trim;
    }

    @Override // w4.f
    public final boolean l() {
        return this.f4593d;
    }

    @Override // w4.f
    public final boolean m() {
        return this.f4592c;
    }

    @Override // w4.f
    public final long u(int i5) {
        if (G()) {
            return 0L;
        }
        return cGetPartSize(this.f4591b, i5);
    }

    @Override // w4.f
    public final int w() {
        if (G()) {
            return 0;
        }
        return cGetPartCount(this.f4591b);
    }
}
