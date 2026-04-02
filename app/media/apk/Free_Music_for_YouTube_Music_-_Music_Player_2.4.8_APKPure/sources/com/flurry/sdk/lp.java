package com.flurry.sdk;

import android.location.Criteria;
import android.location.Location;
/* loaded from: classes.dex */
public final class lp extends lq {

    /* renamed from: a  reason: collision with root package name */
    public static final Integer f2170a = 230;

    /* renamed from: b  reason: collision with root package name */
    public static final Integer f2171b = 6;

    /* renamed from: c  reason: collision with root package name */
    public static final Integer f2172c = 5;
    public static final Integer d = 0;
    public static final String e = null;
    public static final Boolean f = true;
    public static final Boolean g = true;
    public static final String h = null;
    public static final Boolean i = true;
    public static final Criteria j = null;
    public static final Location k = null;
    public static final Long l = 10000L;
    public static final Boolean m = true;
    public static final Long n = null;
    public static final Byte o = (byte) -1;
    public static final Boolean p = false;
    public static final String q = null;
    public static final Boolean r = true;
    private static lp s;

    private lp() {
        a("AgentVersion", f2170a);
        a("ReleaseMajorVersion", f2171b);
        a("ReleaseMinorVersion", f2172c);
        a("ReleasePatchVersion", d);
        a("ReleaseBetaVersion", "");
        a("VersionName", e);
        a("CaptureUncaughtExceptions", f);
        a("UseHttps", g);
        a("ReportUrl", h);
        a("ReportLocation", i);
        a("ExplicitLocation", k);
        a("ContinueSessionMillis", l);
        a("LogEvents", m);
        a("Age", n);
        a("Gender", o);
        a("UserId", "");
        a("ProtonEnabled", p);
        a("ProtonConfigUrl", q);
        a("analyticsEnabled", r);
    }

    public static synchronized lp a() {
        lp lpVar;
        synchronized (lp.class) {
            if (s == null) {
                s = new lp();
            }
            lpVar = s;
        }
        return lpVar;
    }
}
