package com.flurry.sdk;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.flurry.sdk.it;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class is {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1887a = is.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static int f1888b;

    /* renamed from: c  reason: collision with root package name */
    public static int f1889c;
    public static AtomicInteger d;
    static kf<List<it>> e;
    private static is f;
    private static Map<Integer, it> g;
    private final AtomicInteger h;
    private long i;
    private kh<jq> j = new kh<jq>() { // from class: com.flurry.sdk.is.1
        @Override // com.flurry.sdk.kh
        public final /* synthetic */ void a(jq jqVar) {
            jq jqVar2 = jqVar;
            km.a(4, is.f1887a, "onNetworkStateChanged : isNetworkEnable = " + jqVar2.f1996a);
            if (!jqVar2.f1996a) {
                return;
            }
            jy.a().b(new Runnable() { // from class: com.flurry.sdk.is.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    iu.a().b();
                }
            });
        }
    };

    private is() {
        g = new HashMap();
        this.h = new AtomicInteger(0);
        d = new AtomicInteger(0);
        if (f1889c == 0) {
            f1889c = 600000;
        }
        if (f1888b == 0) {
            f1888b = 15;
        }
        this.i = jy.a().f2022a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getLong("timeToSendNextPulseReport", 0L);
        if (e == null) {
            f();
        }
        ki.a().a("com.flurry.android.sdk.NetworkStateEvent", this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        e = new kf<>(jy.a().f2022a.getFileStreamPath(".yflurryanongoingpulsecallbackreporter"), ".yflurryanongoingpulsecallbackreporter", 2, new lj<List<it>>() { // from class: com.flurry.sdk.is.2
            @Override // com.flurry.sdk.lj
            public final lg<List<it>> a(int i) {
                return new lf(new it.a());
            }
        });
    }

    public static void a(int i) {
        f1888b = i;
    }

    public static void b(int i) {
        f1889c = i;
    }

    public final synchronized void a(it itVar) {
        if (itVar == null) {
            km.a(3, f1887a, "Must add valid PulseCallbackAsyncReportInfo");
        } else {
            km.a(3, f1887a, "Adding and sending " + itVar.f1899c + " report to PulseCallbackManager.");
            if (itVar.a().size() != 0) {
                if (this.i == 0) {
                    this.i = System.currentTimeMillis() + f1889c;
                    jy.a().b(new Runnable() { // from class: com.flurry.sdk.is.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            is.this.g();
                        }
                    });
                }
                int h = h();
                itVar.f1898b = h;
                g.put(Integer.valueOf(h), itVar);
                for (ip ipVar : itVar.a()) {
                    hr.a().f1803c.b((io) ipVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SharedPreferences.Editor edit = jy.a().f2022a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        edit.putLong("timeToSendNextPulseReport", this.i);
        edit.apply();
    }

    private synchronized int h() {
        return this.h.incrementAndGet();
    }

    public final synchronized void b(it itVar) {
        if (itVar == null) {
            km.a(3, f1887a, "Must add valid PulseCallbackAsyncReportInfo");
        } else {
            if (this.i == 0) {
                this.i = System.currentTimeMillis() + f1889c;
                jy.a().b(new Runnable() { // from class: com.flurry.sdk.is.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        is.this.g();
                    }
                });
            }
            int h = h();
            itVar.f1898b = h;
            g.put(Integer.valueOf(h), itVar);
            for (ip ipVar : itVar.a()) {
                Iterator<iq> it = ipVar.f.iterator();
                while (it.hasNext()) {
                    it.next();
                    d.incrementAndGet();
                    if (j()) {
                        km.a(3, f1887a, "Max Callback Attempts threshold reached. Sending callback logging reports");
                        l();
                    }
                }
            }
            if (k()) {
                km.a(3, f1887a, "Time threshold reached. Sending callback logging reports");
                l();
            }
            km.a(3, f1887a, "Restoring " + itVar.f1899c + " report to PulseCallbackManager. Number of stored completed callbacks: " + d.get());
        }
    }

    public final synchronized void a(final iq iqVar) {
        km.a(3, f1887a, iqVar.l.g.f1899c + " report sent successfully to " + iqVar.l.l);
        iqVar.f = ir.COMPLETE;
        iqVar.g = "";
        c(iqVar);
        if (km.c() <= 3 && km.d()) {
            jy.a().a(new Runnable() { // from class: com.flurry.sdk.is.5
                @Override // java.lang.Runnable
                public final void run() {
                    Toast.makeText(jy.a().f2022a, "PulseCallbackReportInfo HTTP Response Code: " + iqVar.e + " for url: " + iqVar.l.r, 1).show();
                }
            });
        }
    }

    private void c(iq iqVar) {
        iqVar.d = true;
        iqVar.a();
        d.incrementAndGet();
        iqVar.l.c();
        km.a(3, f1887a, iqVar.l.g.f1899c + " report to " + iqVar.l.l + " finalized.");
        a();
        i();
    }

    public final void a() {
        jy.a().b(new Runnable() { // from class: com.flurry.sdk.is.6
            @Override // java.lang.Runnable
            public final void run() {
                is.c();
                List<it> b2 = is.b();
                if (is.e == null) {
                    is.f();
                }
                is.e.a(b2);
            }
        });
    }

    private void i() {
        if (j() || k()) {
            km.a(3, f1887a, "Threshold reached. Sending callback logging reports");
            l();
        }
    }

    public static List<it> b() {
        return new ArrayList(g.values());
    }

    public static synchronized is c() {
        is isVar;
        synchronized (is.class) {
            if (f == null) {
                f = new is();
            }
            isVar = f;
        }
        return isVar;
    }

    private static boolean j() {
        return d.intValue() >= f1888b;
    }

    private boolean k() {
        return System.currentTimeMillis() > this.i;
    }

    private void l() {
        for (it itVar : b()) {
            boolean z = false;
            for (ip ipVar : itVar.a()) {
                Iterator<iq> it = ipVar.f.iterator();
                while (it.hasNext()) {
                    iq next = it.next();
                    if (next.j) {
                        it.remove();
                    } else if (!next.f.equals(ir.PENDING_COMPLETION)) {
                        next.j = true;
                        z = true;
                    }
                }
            }
            if (z) {
                iu.a().a(itVar);
            }
        }
        iu.a().b();
        this.i = System.currentTimeMillis() + f1889c;
        g();
        for (it itVar2 : b()) {
            if (itVar2.b()) {
                c(itVar2.f1898b);
            } else {
                for (ip ipVar2 : itVar2.a()) {
                    if (ipVar2.m) {
                        itVar2.d.remove(Long.valueOf(ipVar2.f1873a));
                    } else {
                        Iterator<iq> it2 = ipVar2.f.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().j) {
                                it2.remove();
                            }
                        }
                    }
                }
            }
        }
        d = new AtomicInteger(0);
        a();
    }

    private synchronized void c(int i) {
        km.a(3, f1887a, "Removing report " + i + " from PulseCallbackManager");
        g.remove(Integer.valueOf(i));
    }

    public final synchronized boolean a(iq iqVar, String str) {
        boolean z = true;
        synchronized (this) {
            iqVar.h++;
            iqVar.i = System.currentTimeMillis();
            if ((iqVar.h > iqVar.l.f1875c) || TextUtils.isEmpty(str)) {
                km.a(3, f1887a, "Maximum number of redirects attempted. Aborting: " + iqVar.l.g.f1899c + " report to " + iqVar.l.l);
                iqVar.f = ir.INVALID_RESPONSE;
                iqVar.g = "";
                c(iqVar);
                z = false;
            } else {
                km.a(3, f1887a, "Report to " + iqVar.l.l + " redirecting to url: " + str);
                iqVar.l.r = str;
                a();
            }
        }
        return z;
    }

    public final synchronized void b(iq iqVar) {
        km.a(3, f1887a, "Maximum number of attempts reached. Aborting: " + iqVar.l.g.f1899c);
        iqVar.f = ir.TIMEOUT;
        iqVar.i = System.currentTimeMillis();
        iqVar.g = "";
        c(iqVar);
    }

    public final synchronized boolean b(iq iqVar, String str) {
        boolean z = false;
        synchronized (this) {
            iqVar.f = ir.INVALID_RESPONSE;
            iqVar.i = System.currentTimeMillis();
            if (str == null) {
                str = "";
            }
            iqVar.g = str;
            ip ipVar = iqVar.l;
            if (ipVar.p >= ipVar.f1874b) {
                km.a(3, f1887a, "Maximum number of attempts reached. Aborting: " + iqVar.l.g.f1899c + " report to " + iqVar.l.l);
                c(iqVar);
            } else if (!mc.h(iqVar.l.r)) {
                km.a(3, f1887a, "Url: " + iqVar.l.r + " is invalid.");
                c(iqVar);
            } else {
                km.a(3, f1887a, "Retrying callback to " + iqVar.l.g.f1899c + " in: " + (iqVar.l.h / 1000) + " seconds.");
                iqVar.a();
                d.incrementAndGet();
                a();
                i();
                z = true;
            }
        }
        return z;
    }

    public static List<it> d() {
        if (e == null) {
            f();
        }
        return e.a();
    }
}
