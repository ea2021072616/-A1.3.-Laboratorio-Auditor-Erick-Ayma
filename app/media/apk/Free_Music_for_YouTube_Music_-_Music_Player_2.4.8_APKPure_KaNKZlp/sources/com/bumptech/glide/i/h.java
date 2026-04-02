package com.bumptech.glide.i;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import com.flurry.android.Constants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f733a = "0123456789abcdef".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f734b = new char[64];

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f735c = new char[40];

    public static String a(byte[] bArr) {
        String a2;
        synchronized (f734b) {
            a2 = a(bArr, f734b);
        }
        return a2;
    }

    private static String a(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & Constants.UNKNOWN;
            cArr[i * 2] = f733a[i2 >>> 4];
            cArr[(i * 2) + 1] = f733a[i2 & 15];
        }
        return new String(cArr);
    }

    @TargetApi(19)
    public static int a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException e) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static int a(int i, int i2, Bitmap.Config config) {
        return i * i2 * a(config);
    }

    private static int a(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        switch (AnonymousClass1.f736a[config.ordinal()]) {
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            default:
                return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Util.java */
    /* renamed from: com.bumptech.glide.i.h$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f736a = new int[Bitmap.Config.values().length];

        static {
            try {
                f736a[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f736a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f736a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f736a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static boolean a(int i, int i2) {
        return b(i) && b(i2);
    }

    private static boolean b(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static void a() {
        if (!c()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static void b() {
        if (!d()) {
            throw new IllegalArgumentException("YOu must call this method on a background thread");
        }
    }

    public static boolean c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean d() {
        return !c();
    }

    public static <T> Queue<T> a(int i) {
        return new ArrayDeque(i);
    }

    public static <T> List<T> a(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            arrayList.add(t);
        }
        return arrayList;
    }
}
