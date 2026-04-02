package com.facebook.ads.internal.f;

import java.util.UUID;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1339a = g.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f1340b = false;

    /* renamed from: c  reason: collision with root package name */
    private static double f1341c;
    private static String d;

    public static void a() {
        if (f1340b) {
            return;
        }
        synchronized (f1339a) {
            if (!f1340b) {
                f1340b = true;
                f1341c = System.currentTimeMillis() / 1000.0d;
                d = UUID.randomUUID().toString();
            }
        }
    }

    public static double b() {
        return f1341c;
    }

    public static String c() {
        return d;
    }
}
