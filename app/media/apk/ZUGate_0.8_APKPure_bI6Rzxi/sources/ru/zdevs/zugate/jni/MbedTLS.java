package ru.zdevs.zugate.jni;

import dalvik.annotation.optimization.FastNative;
/* loaded from: classes.dex */
public abstract class MbedTLS {

    /* renamed from: a  reason: collision with root package name */
    public static int f4614a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static int f4615b;

    static {
        System.loadLibrary("mbedtls-2.25.0");
    }

    public static int a() {
        if (f4614a == -1) {
            f4614a = cGetSupportHW();
        }
        return f4614a;
    }

    public static void b(int i5) {
        f4615b = cSetHW(i5);
    }

    @FastNative
    private static native int cGetSupportHW();

    @FastNative
    private static native int cSetHW(int i5);
}
