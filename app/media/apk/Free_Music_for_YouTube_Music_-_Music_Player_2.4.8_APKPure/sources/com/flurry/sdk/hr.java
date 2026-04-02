package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.FlurryEventRecordStatus;
import java.util.Map;
/* loaded from: classes.dex */
public class hr implements kp {
    private static final String d = hr.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public im f1801a;

    /* renamed from: b  reason: collision with root package name */
    public je f1802b;

    /* renamed from: c  reason: collision with root package name */
    public io f1803c;

    public static synchronized hr a() {
        hr hrVar;
        synchronized (hr.class) {
            hrVar = (hr) jy.a().a(hr.class);
        }
        return hrVar;
    }

    @Override // com.flurry.sdk.kp
    public final void a(Context context) {
        lk.a(jh.class);
        this.f1802b = new je();
        this.f1801a = new im();
        this.f1803c = new io();
        if (!ly.a(context, "android.permission.INTERNET")) {
            km.b(d, "Application must declare permission: android.permission.INTERNET");
        }
        if (ly.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return;
        }
        km.e(d, "It is highly recommended that the application declare permission: android.permission.ACCESS_NETWORK_STATE");
    }

    public static jh b() {
        lk b2 = lm.a().b();
        if (b2 == null) {
            return null;
        }
        return (jh) b2.b(jh.class);
    }

    public static FlurryEventRecordStatus a(String str, String str2, Map<String, String> map) {
        jh b2 = b();
        FlurryEventRecordStatus flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (b2 != null) {
            return b2.a(str, jj.a(str2), map);
        }
        return flurryEventRecordStatus;
    }

    public static void a(String str, String str2, Throwable th) {
        jh b2 = b();
        if (b2 != null) {
            b2.a(str, str2, th.getClass().getName(), th);
        }
    }
}
