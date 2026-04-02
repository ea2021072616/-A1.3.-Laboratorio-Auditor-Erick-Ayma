package com.acrcloud.rec.engine;
/* loaded from: classes.dex */
public class ACRCloudRecognizeEngine {

    /* renamed from: a  reason: collision with root package name */
    private long f363a = 0;

    private native void native_engine_finalizer(long j);

    private native long native_engine_init(String str);

    private native a[] native_engine_recognize(long j, byte[] bArr, int i, int i2);

    private static native byte[] native_gen_fp(byte[] bArr, int i, String str, String str2);

    private static native byte[] native_gen_hum_fp(byte[] bArr, int i);

    private static native byte[] native_nice_enc(byte[] bArr, int i, byte[] bArr2, int i2);

    static {
        try {
            System.loadLibrary("ACRCloudEngine");
        } catch (Exception e) {
            System.err.println("ACRCloudEngine loadLibrary error!");
        }
    }

    public boolean a(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        this.f363a = native_engine_init(str);
        return this.f363a != 0;
    }

    public void a() {
        if (this.f363a != 0) {
            native_engine_finalizer(this.f363a);
        }
    }

    public a[] a(byte[] bArr, int i) {
        if (bArr == null || i <= 0) {
            return null;
        }
        return native_engine_recognize(this.f363a, bArr, i, 0);
    }

    public a[] b(byte[] bArr, int i) {
        if (bArr == null || i <= 0) {
            return null;
        }
        return native_engine_recognize(this.f363a, bArr, i, 1);
    }

    public static byte[] a(byte[] bArr, int i, String str, String str2) {
        if (bArr == null || i <= 0) {
            return null;
        }
        return native_gen_fp(bArr, i, str, str2);
    }

    public static byte[] c(byte[] bArr, int i) {
        if (bArr == null || i <= 0) {
            return null;
        }
        return native_gen_fp(bArr, i, null, null);
    }

    public static byte[] d(byte[] bArr, int i) {
        if (bArr == null || i <= 0) {
            return null;
        }
        return native_gen_hum_fp(bArr, i);
    }

    public static String a(String str, String str2) {
        if (str == null || "".equals(str)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte[] bytes2 = str2.getBytes();
        byte[] native_nice_enc = native_nice_enc(bytes, bytes.length, bytes2, bytes2.length);
        if (native_nice_enc != null) {
            return new String(native_nice_enc);
        }
        return null;
    }
}
