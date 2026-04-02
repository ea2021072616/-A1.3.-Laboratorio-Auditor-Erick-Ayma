package com.facebook.ads.internal.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Long> f1520a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, Long> f1521b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, String> f1522c = new ConcurrentHashMap();

    private static long a(String str, com.facebook.ads.internal.f.c cVar) {
        if (f1520a.containsKey(str)) {
            return f1520a.get(str).longValue();
        }
        switch (cVar) {
            case BANNER:
                return 15000L;
            case INTERSTITIAL:
            case NATIVE:
            default:
                return -1000L;
        }
    }

    public static void a(long j, com.facebook.ads.internal.f.f fVar) {
        f1520a.put(d(fVar), Long.valueOf(j));
    }

    public static void a(String str, com.facebook.ads.internal.f.f fVar) {
        f1522c.put(d(fVar), str);
    }

    public static boolean a(com.facebook.ads.internal.f.f fVar) {
        String d = d(fVar);
        if (f1521b.containsKey(d)) {
            return System.currentTimeMillis() - f1521b.get(d).longValue() < a(d, fVar.b());
        }
        return false;
    }

    public static void b(com.facebook.ads.internal.f.f fVar) {
        f1521b.put(d(fVar), Long.valueOf(System.currentTimeMillis()));
    }

    public static String c(com.facebook.ads.internal.f.f fVar) {
        return f1522c.get(d(fVar));
    }

    private static String d(com.facebook.ads.internal.f.f fVar) {
        Object[] objArr = new Object[6];
        objArr[0] = fVar.a();
        objArr[1] = fVar.b();
        objArr[2] = fVar.e;
        objArr[3] = Integer.valueOf(fVar.c() == null ? 0 : fVar.c().getHeight());
        objArr[4] = Integer.valueOf(fVar.c() != null ? fVar.c().getWidth() : 0);
        objArr[5] = Integer.valueOf(fVar.d());
        return String.format("%s:%s:%s:%d:%d:%d", objArr);
    }
}
