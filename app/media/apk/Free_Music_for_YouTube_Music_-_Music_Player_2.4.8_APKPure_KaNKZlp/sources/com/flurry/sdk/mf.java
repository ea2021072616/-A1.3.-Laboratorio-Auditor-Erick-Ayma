package com.flurry.sdk;
/* loaded from: classes.dex */
public class mf {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2197a = mf.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2198b;

    public static synchronized void a() {
        synchronized (mf.class) {
            if (!f2198b) {
                ko.a(jk.class);
                try {
                    ko.a(hr.class);
                } catch (NoClassDefFoundError e) {
                    km.a(3, f2197a, "Analytics module not available");
                }
                try {
                    ko.a(md.class);
                } catch (NoClassDefFoundError e2) {
                    km.a(3, f2197a, "Crash module not available");
                }
                try {
                    ko.a((Class<? extends kp>) Class.forName("com.flurry.sdk.i"));
                } catch (ClassNotFoundException | NoClassDefFoundError e3) {
                    km.a(3, f2197a, "Ads module not available");
                }
                f2198b = true;
            }
        }
    }
}
