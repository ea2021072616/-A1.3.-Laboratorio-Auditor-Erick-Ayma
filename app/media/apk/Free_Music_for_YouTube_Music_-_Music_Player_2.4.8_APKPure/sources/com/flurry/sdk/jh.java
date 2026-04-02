package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.flurry.android.FlurryEventRecordStatus;
import com.flurry.sdk.jf;
import com.flurry.sdk.ll;
import com.flurry.sdk.lq;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class jh implements lq.a {

    /* renamed from: a  reason: collision with root package name */
    static final String f1944a = jh.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    static int f1945b = 100;

    /* renamed from: c  reason: collision with root package name */
    static int f1946c = 10;
    static int d = 1000;
    static int e = 160000;
    static int f = 50;
    private String A;
    WeakReference<lk> g;
    File h;
    kf<List<jf>> i;
    public boolean j;
    boolean k;
    String l;
    byte m;
    Long n;
    private long z;
    private final AtomicInteger q = new AtomicInteger(0);
    private final AtomicInteger r = new AtomicInteger(0);
    private final List<jf> s = new ArrayList();
    private final Map<String, List<String>> t = new HashMap();
    private final Map<String, String> u = new HashMap();
    private final Map<String, jb> v = new HashMap();
    private final List<jc> w = new ArrayList();
    private final List<ja> x = new ArrayList();
    private final hs y = new hs();
    private int B = -1;
    private boolean C = true;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    boolean o = true;
    final kh<jm> p = new kh<jm>() { // from class: com.flurry.sdk.jh.1
        @Override // com.flurry.sdk.kh
        public final /* synthetic */ void a(jm jmVar) {
            jy.a().b(new ma() { // from class: com.flurry.sdk.jh.1.1
                @Override // com.flurry.sdk.ma
                public final void a() {
                    jh jhVar = jh.this;
                    jk.a();
                    jhVar.a(true, jk.d());
                }
            });
        }
    };
    private final kh<ll> G = new kh<ll>() { // from class: com.flurry.sdk.jh.10
        @Override // com.flurry.sdk.kh
        public final /* synthetic */ void a(ll llVar) {
            ll llVar2 = llVar;
            if (jh.this.g == null || llVar2.f2153b == jh.this.g.get()) {
                switch (AnonymousClass9.f1972a[llVar2.f2154c - 1]) {
                    case 1:
                        final jh jhVar = jh.this;
                        lk lkVar = llVar2.f2153b;
                        Context context = llVar2.f2152a.get();
                        jhVar.g = new WeakReference<>(lkVar);
                        lp a2 = lp.a();
                        jhVar.k = ((Boolean) a2.a("LogEvents")).booleanValue();
                        a2.a("LogEvents", (lq.a) jhVar);
                        km.a(4, jh.f1944a, "initSettings, LogEvents = " + jhVar.k);
                        jhVar.l = (String) a2.a("UserId");
                        a2.a("UserId", (lq.a) jhVar);
                        km.a(4, jh.f1944a, "initSettings, UserId = " + jhVar.l);
                        jhVar.m = ((Byte) a2.a("Gender")).byteValue();
                        a2.a("Gender", (lq.a) jhVar);
                        km.a(4, jh.f1944a, "initSettings, Gender = " + ((int) jhVar.m));
                        jhVar.n = (Long) a2.a("Age");
                        a2.a("Age", (lq.a) jhVar);
                        km.a(4, jh.f1944a, "initSettings, BirthDate = " + jhVar.n);
                        jhVar.o = ((Boolean) a2.a("analyticsEnabled")).booleanValue();
                        a2.a("analyticsEnabled", (lq.a) jhVar);
                        km.a(4, jh.f1944a, "initSettings, AnalyticsEnabled = " + jhVar.o);
                        jhVar.h = context.getFileStreamPath(".flurryagent." + Integer.toString(jy.a().d.hashCode(), 16));
                        jhVar.i = new kf<>(context.getFileStreamPath(".yflurryreport." + Long.toString(ly.i(jy.a().d), 16)), ".yflurryreport.", 1, new lj<List<jf>>() { // from class: com.flurry.sdk.jh.11
                            @Override // com.flurry.sdk.lj
                            public final lg<List<jf>> a(int i) {
                                return new lf(new jf.a());
                            }
                        });
                        jhVar.a(context);
                        jhVar.a(true);
                        if (hr.a().f1801a != null) {
                            jy.a().b(new ma() { // from class: com.flurry.sdk.jh.12
                                @Override // com.flurry.sdk.ma
                                public final void a() {
                                    hr.a().f1801a.a();
                                }
                            });
                        }
                        jy.a().b(new ma() { // from class: com.flurry.sdk.jh.13
                            @Override // com.flurry.sdk.ma
                            public final void a() {
                                jh.this.e();
                            }
                        });
                        jy.a().b(new ma() { // from class: com.flurry.sdk.jh.14
                            @Override // com.flurry.sdk.ma
                            public final void a() {
                                jh.d(jh.this);
                            }
                        });
                        if (jl.a().b()) {
                            jy.a().b(new ma() { // from class: com.flurry.sdk.jh.15
                                @Override // com.flurry.sdk.ma
                                public final void a() {
                                    jh jhVar2 = jh.this;
                                    jk.a();
                                    jhVar2.a(true, jk.d());
                                }
                            });
                            return;
                        } else {
                            ki.a().a("com.flurry.android.sdk.IdProviderFinishedEvent", jhVar.p);
                            return;
                        }
                    case 2:
                        jh jhVar2 = jh.this;
                        llVar2.f2152a.get();
                        jhVar2.b();
                        return;
                    case 3:
                        jh jhVar3 = jh.this;
                        llVar2.f2152a.get();
                        jhVar3.c();
                        return;
                    case 4:
                        ki.a().b("com.flurry.android.sdk.FlurrySessionEvent", jh.this.G);
                        jh.this.a(llVar2.d);
                        return;
                    default:
                        return;
                }
            }
        }
    };

    /* renamed from: com.flurry.sdk.jh$9  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass9 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1972a = new int[ll.a.a().length];

        static {
            try {
                f1972a[ll.a.f2155a - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1972a[ll.a.f2157c - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1972a[ll.a.d - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1972a[ll.a.e - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public jh() {
        ki.a().a("com.flurry.android.sdk.FlurrySessionEvent", this.G);
    }

    final void a(Context context) {
        Bundle extras;
        if ((context instanceof Activity) && (extras = ((Activity) context).getIntent().getExtras()) != null) {
            km.a(3, f1944a, "Launch Options Bundle is present " + extras.toString());
            for (String str : extras.keySet()) {
                if (str != null) {
                    Object obj = extras.get(str);
                    String obj2 = obj != null ? obj.toString() : "null";
                    this.t.put(str, Collections.singletonList(obj2));
                    km.a(3, f1944a, "Launch options Key: " + str + ". Its value: " + obj2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c3  */
    @android.annotation.TargetApi(18)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void a(boolean r11) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.jh.a(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        km.a(4, f1944a, "Loading persistent session report data.");
        List<jf> a2 = this.i.a();
        if (a2 != null) {
            this.s.addAll(a2);
        } else if (this.h.exists()) {
            km.a(4, f1944a, "Legacy persistent agent data found, converting.");
            ji a3 = hu.a(this.h);
            if (a3 != null) {
                boolean z = a3.f1974b;
                long j = a3.f1975c;
                if (j <= 0) {
                    jk.a();
                    j = jk.d();
                }
                this.j = z;
                this.z = j;
                f();
                List unmodifiableList = Collections.unmodifiableList(a3.f1973a);
                if (unmodifiableList != null) {
                    this.s.addAll(unmodifiableList);
                }
            }
            this.h.delete();
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, long j) {
        byte[] bArr;
        if (!this.o) {
            km.a(3, f1944a, "Analytics disabled, not sending agent report.");
        } else if (z || !this.s.isEmpty()) {
            km.a(3, f1944a, "generating agent report");
            try {
                bArr = new jd(jy.a().d, ju.a().g(), this.j, jl.a().c(), this.z, j, this.s, Collections.unmodifiableMap(jl.a().f1980a), this.y.a(), this.t, ka.a().b(), System.currentTimeMillis()).f1928a;
            } catch (Exception e2) {
                km.e(f1944a, "Exception while generating report: " + e2);
                bArr = null;
            }
            if (bArr == null) {
                km.e(f1944a, "Error generating report");
            } else {
                km.a(3, f1944a, "generated report of size " + bArr.length + " with " + this.s.size() + " reports.");
                hr.a().f1802b.b(bArr, jy.a().d, new StringBuilder().append(jz.b()).toString());
            }
            this.s.clear();
            this.i.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        SharedPreferences.Editor edit = jy.a().f2022a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        edit.putBoolean("com.flurry.sdk.previous_successful_report", this.j);
        edit.putLong("com.flurry.sdk.initial_run_time", this.z);
        edit.putString("com.flurry.sdk.api_key", jy.a().d);
        edit.apply();
    }

    public final synchronized void a() {
        km.a(4, f1944a, "Saving persistent agent data.");
        this.i.a(this.s);
    }

    public final synchronized void b() {
        this.B = lw.d();
        if (hr.a().f1803c != null) {
            jy.a().b(new ma() { // from class: com.flurry.sdk.jh.16
                @Override // com.flurry.sdk.ma
                public final void a() {
                    hr.a().f1803c.c();
                }
            });
        }
        if (this.o && hr.a().f1801a != null) {
            jy.a().b(new ma() { // from class: com.flurry.sdk.jh.17
                @Override // com.flurry.sdk.ma
                public final void a() {
                    hr.a().f1801a.b();
                }
            });
        }
    }

    public final synchronized void c() {
        a(true, false);
    }

    private synchronized void a(boolean z, boolean z2) {
        a(false);
        jk.a();
        final long d2 = jk.d();
        jk.a();
        final long f2 = jk.f();
        jk.a();
        final long j = 0;
        jx c2 = jk.c();
        if (c2 != null) {
            j = c2.f;
        }
        jk.a();
        final int h = jk.h() - 1;
        if (z && this.o && hr.a().f1801a != null) {
            jy.a().b(new ma() { // from class: com.flurry.sdk.jh.2
                @Override // com.flurry.sdk.ma
                public final void a() {
                    hr.a().f1801a.a(d2);
                }
            });
        }
        jy.a().b(new ma() { // from class: com.flurry.sdk.jh.3
            @Override // com.flurry.sdk.ma
            public final void a() {
                jh.this.f();
            }
        });
        if (jl.a().b()) {
            jy.a().b(new ma() { // from class: com.flurry.sdk.jh.4
                @Override // com.flurry.sdk.ma
                public final void a() {
                    jf a2 = jh.this.a(d2, f2, j, h);
                    jh.this.s.clear();
                    jh.this.s.add(a2);
                    jh.this.a();
                }
            });
        }
        if (z2) {
            jk.a();
            b(jk.f());
            if (jl.a().b()) {
                jy.a().b(new ma() { // from class: com.flurry.sdk.jh.5
                    @Override // com.flurry.sdk.ma
                    public final void a() {
                        jh.this.a(false, d2);
                    }
                });
            }
        }
    }

    final synchronized jf a(long j, long j2, long j3, int i) {
        jf jfVar;
        jg jgVar = new jg();
        jgVar.f1941a = ju.a().g();
        jgVar.f1942b = j;
        jgVar.f1943c = j2;
        jgVar.d = j3;
        jgVar.e = this.u;
        jk.a();
        jx c2 = jk.c();
        jgVar.f = c2 != null ? c2.d() : null;
        jk.a();
        jx c3 = jk.c();
        jgVar.g = c3 != null ? c3.e() : null;
        jk.a();
        jx c4 = jk.c();
        jgVar.h = c4 != null ? c4.f() : null;
        jo.a();
        jgVar.i = jo.b();
        jo.a();
        jgVar.j = TimeZone.getDefault().getID();
        jgVar.k = i;
        jgVar.l = this.B != -1 ? this.B : lw.d();
        jgVar.m = this.l == null ? "" : this.l;
        jgVar.n = jp.a().g();
        jgVar.o = this.F;
        jgVar.p = this.m;
        jgVar.q = this.n;
        jgVar.r = this.v;
        jgVar.s = this.w;
        jgVar.t = this.C;
        jgVar.v = this.x;
        jgVar.u = this.E;
        try {
            jfVar = new jf(jgVar);
        } catch (IOException e2) {
            km.a(5, f1944a, "Error creating analytics session report: " + e2);
            jfVar = null;
        }
        if (jfVar == null) {
            km.e(f1944a, "New session report wasn't created");
        }
        return jfVar;
    }

    private synchronized void b(long j) {
        for (jc jcVar : this.w) {
            if (jcVar.f1925b && !jcVar.f1926c) {
                jcVar.a(j);
            }
        }
    }

    public final synchronized void a(final long j) {
        ki.a().a(this.p);
        jk.a();
        b(jk.f());
        jy.a().b(new ma() { // from class: com.flurry.sdk.jh.6
            @Override // com.flurry.sdk.ma
            public final void a() {
                if (jh.this.o && hr.a().f1801a != null) {
                    hr.a().f1801a.c();
                }
                if (hr.a().f1803c != null) {
                    jy.a().b(new ma() { // from class: com.flurry.sdk.jh.6.1
                        @Override // com.flurry.sdk.ma
                        public final void a() {
                            hr.a().f1803c.f2096c = true;
                        }
                    });
                }
            }
        });
        if (jl.a().b()) {
            jy.a().b(new ma() { // from class: com.flurry.sdk.jh.7
                @Override // com.flurry.sdk.ma
                public final void a() {
                    jh.this.a(false, j);
                }
            });
        }
        lp.a().b("Gender", this);
        lp.a().b("UserId", this);
        lp.a().b("Age", this);
        lp.a().b("LogEvents", this);
    }

    @Override // com.flurry.sdk.lq.a
    public final void a(String str, Object obj) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1752163738:
                if (str.equals("UserId")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1720015653:
                if (str.equals("analyticsEnabled")) {
                    c2 = 4;
                    break;
                }
                break;
            case -738063011:
                if (str.equals("LogEvents")) {
                    c2 = 0;
                    break;
                }
                break;
            case 65759:
                if (str.equals("Age")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2129321697:
                if (str.equals("Gender")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.k = ((Boolean) obj).booleanValue();
                km.a(4, f1944a, "onSettingUpdate, LogEvents = " + this.k);
                return;
            case 1:
                this.l = (String) obj;
                km.a(4, f1944a, "onSettingUpdate, UserId = " + this.l);
                return;
            case 2:
                this.m = ((Byte) obj).byteValue();
                km.a(4, f1944a, "onSettingUpdate, Gender = " + ((int) this.m));
                return;
            case 3:
                this.n = (Long) obj;
                km.a(4, f1944a, "onSettingUpdate, Birthdate = " + this.n);
                return;
            case 4:
                this.o = ((Boolean) obj).booleanValue();
                km.a(4, f1944a, "onSettingUpdate, AnalyticsEnabled = " + this.o);
                return;
            default:
                km.a(6, f1944a, "onSettingUpdate internal error!");
                return;
        }
    }

    public final synchronized void d() {
        this.F++;
    }

    public final synchronized FlurryEventRecordStatus a(String str, String str2, Map<String, String> map) {
        FlurryEventRecordStatus flurryEventRecordStatus;
        flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (map != null && !TextUtils.isEmpty(str2)) {
            map.put("\ue8ffsid+Tumblr", str2);
            flurryEventRecordStatus = a(str, map, false);
            km.a(5, f1944a, "logEvent status for syndication:" + flurryEventRecordStatus);
        }
        return flurryEventRecordStatus;
    }

    public final synchronized FlurryEventRecordStatus a(String str, Map<String, String> map, boolean z) {
        FlurryEventRecordStatus flurryEventRecordStatus;
        FlurryEventRecordStatus flurryEventRecordStatus2 = FlurryEventRecordStatus.kFlurryEventRecorded;
        if (!this.o) {
            flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventAnalyticsDisabled;
            km.e(f1944a, "Analytics has been disabled, not logging event.");
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            jk.a();
            long e2 = elapsedRealtime - jk.e();
            final String b2 = ly.b(str);
            if (b2.length() == 0) {
                flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventFailed;
            } else {
                jb jbVar = this.v.get(b2);
                if (jbVar == null) {
                    if (this.v.size() < f1945b) {
                        jb jbVar2 = new jb();
                        jbVar2.f1923a = 1;
                        this.v.put(b2, jbVar2);
                        km.e(f1944a, "Event count started: " + b2);
                        flurryEventRecordStatus = flurryEventRecordStatus2;
                    } else {
                        km.e(f1944a, "Too many different events. Event not counted: " + b2);
                        flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventUniqueCountExceeded;
                    }
                } else {
                    jbVar.f1923a++;
                    km.e(f1944a, "Event count incremented: " + b2);
                    flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventRecorded;
                }
                if (this.k && this.w.size() < d && this.D < e) {
                    final Map<String, String> emptyMap = map == null ? Collections.emptyMap() : map;
                    if (emptyMap.size() + 0 > f1946c) {
                        km.e(f1944a, "MaxEventParams exceeded: " + (emptyMap.size() + 0));
                        flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventParamsCountExceeded;
                    } else {
                        jc jcVar = new jc(this.q.incrementAndGet(), b2, emptyMap, e2, z);
                        if (jcVar.b().length + this.D <= e) {
                            this.w.add(jcVar);
                            this.D = jcVar.b().length + this.D;
                            flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventRecorded;
                            if (this.o && hr.a().f1801a != null) {
                                jy.a().b(new Runnable() { // from class: com.flurry.sdk.jh.8
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        hr.a().f1801a.a(b2, emptyMap);
                                    }
                                });
                            }
                        } else {
                            this.D = e;
                            this.C = false;
                            km.e(f1944a, "Event Log size exceeded. No more event details logged.");
                            flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventLogCountExceeded;
                        }
                    }
                } else {
                    this.C = false;
                }
                if (b2.equals("Flurry.purchase")) {
                    a(false, true);
                }
            }
        }
        return flurryEventRecordStatus;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        r2 = android.os.SystemClock.elapsedRealtime();
        com.flurry.sdk.jk.a();
        r2 = r2 - com.flurry.sdk.jk.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (r10 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r10.size() <= 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
        if (r8.D >= com.flurry.sdk.jh.e) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        r1 = r8.D - r0.b().length;
        r4 = new java.util.HashMap(r0.a());
        r0.a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
        if ((r0.b().length + r1) > com.flurry.sdk.jh.e) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
        if (r0.a().size() <= com.flurry.sdk.jh.f1946c) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
        com.flurry.sdk.km.e(com.flurry.sdk.jh.f1944a, "MaxEventParams exceeded on endEvent: " + r0.a().size());
        r0.b(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008e, code lost:
        r0.a(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0095, code lost:
        r8.D = r1 + r0.b().length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
        r0.b(r4);
        r8.C = false;
        r8.D = com.flurry.sdk.jh.e;
        com.flurry.sdk.km.e(com.flurry.sdk.jh.f1944a, "Event Log size exceeded. No more event details logged.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void a(java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            r8 = this;
            r2 = 0
            monitor-enter(r8)
            java.util.List<com.flurry.sdk.jc> r0 = r8.w     // Catch: java.lang.Throwable -> L9e
            java.util.Iterator r3 = r0.iterator()     // Catch: java.lang.Throwable -> L9e
        L8:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L91
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L9e
            com.flurry.sdk.jc r0 = (com.flurry.sdk.jc) r0     // Catch: java.lang.Throwable -> L9e
            boolean r1 = r0.f1925b     // Catch: java.lang.Throwable -> L9e
            if (r1 == 0) goto L93
            long r4 = r0.d     // Catch: java.lang.Throwable -> L9e
            r6 = 0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L93
            java.lang.String r1 = r0.f1924a     // Catch: java.lang.Throwable -> L9e
            boolean r1 = r1.equals(r9)     // Catch: java.lang.Throwable -> L9e
            if (r1 == 0) goto L93
            r1 = 1
        L29:
            if (r1 == 0) goto L8
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L9e
            com.flurry.sdk.jk.a()     // Catch: java.lang.Throwable -> L9e
            long r4 = com.flurry.sdk.jk.e()     // Catch: java.lang.Throwable -> L9e
            long r2 = r2 - r4
            if (r10 == 0) goto L8e
            int r1 = r10.size()     // Catch: java.lang.Throwable -> L9e
            if (r1 <= 0) goto L8e
            int r1 = r8.D     // Catch: java.lang.Throwable -> L9e
            int r4 = com.flurry.sdk.jh.e     // Catch: java.lang.Throwable -> L9e
            if (r1 >= r4) goto L8e
            int r1 = r8.D     // Catch: java.lang.Throwable -> L9e
            byte[] r4 = r0.b()     // Catch: java.lang.Throwable -> L9e
            int r4 = r4.length     // Catch: java.lang.Throwable -> L9e
            int r1 = r1 - r4
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> L9e
            java.util.Map r5 = r0.a()     // Catch: java.lang.Throwable -> L9e
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L9e
            r0.a(r10)     // Catch: java.lang.Throwable -> L9e
            byte[] r5 = r0.b()     // Catch: java.lang.Throwable -> L9e
            int r5 = r5.length     // Catch: java.lang.Throwable -> L9e
            int r5 = r5 + r1
            int r6 = com.flurry.sdk.jh.e     // Catch: java.lang.Throwable -> L9e
            if (r5 > r6) goto La1
            java.util.Map r5 = r0.a()     // Catch: java.lang.Throwable -> L9e
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L9e
            int r6 = com.flurry.sdk.jh.f1946c     // Catch: java.lang.Throwable -> L9e
            if (r5 <= r6) goto L95
            java.lang.String r1 = com.flurry.sdk.jh.f1944a     // Catch: java.lang.Throwable -> L9e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            java.lang.String r6 = "MaxEventParams exceeded on endEvent: "
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L9e
            java.util.Map r6 = r0.a()     // Catch: java.lang.Throwable -> L9e
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L9e
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L9e
            com.flurry.sdk.km.e(r1, r5)     // Catch: java.lang.Throwable -> L9e
            r0.b(r4)     // Catch: java.lang.Throwable -> L9e
        L8e:
            r0.a(r2)     // Catch: java.lang.Throwable -> L9e
        L91:
            monitor-exit(r8)
            return
        L93:
            r1 = r2
            goto L29
        L95:
            byte[] r4 = r0.b()     // Catch: java.lang.Throwable -> L9e
            int r4 = r4.length     // Catch: java.lang.Throwable -> L9e
            int r1 = r1 + r4
            r8.D = r1     // Catch: java.lang.Throwable -> L9e
            goto L8e
        L9e:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        La1:
            r0.b(r4)     // Catch: java.lang.Throwable -> L9e
            r1 = 0
            r8.C = r1     // Catch: java.lang.Throwable -> L9e
            int r1 = com.flurry.sdk.jh.e     // Catch: java.lang.Throwable -> L9e
            r8.D = r1     // Catch: java.lang.Throwable -> L9e
            java.lang.String r1 = com.flurry.sdk.jh.f1944a     // Catch: java.lang.Throwable -> L9e
            java.lang.String r4 = "Event Log size exceeded. No more event details logged."
            com.flurry.sdk.km.e(r1, r4)     // Catch: java.lang.Throwable -> L9e
            goto L8e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.jh.a(java.lang.String, java.util.Map):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d A[Catch: all -> 0x0099, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0004, B:8:0x000d, B:10:0x001d, B:16:0x005a, B:18:0x0062, B:20:0x006e, B:22:0x0078, B:28:0x00a0), top: B:30:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void a(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.Throwable r13) {
        /*
            r9 = this;
            r0 = 0
            monitor-enter(r9)
            if (r10 == 0) goto L55
            java.lang.String r1 = "uncaught"
            boolean r1 = r1.equals(r10)     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto L55
            r1 = 1
        Ld:
            int r2 = r9.E     // Catch: java.lang.Throwable -> L99
            int r2 = r2 + 1
            r9.E = r2     // Catch: java.lang.Throwable -> L99
            java.util.List<com.flurry.sdk.ja> r2 = r9.x     // Catch: java.lang.Throwable -> L99
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L99
            int r3 = com.flurry.sdk.jh.f     // Catch: java.lang.Throwable -> L99
            if (r2 >= r3) goto L57
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L99
            java.lang.Long r2 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L99
            com.flurry.sdk.ja r0 = new com.flurry.sdk.ja     // Catch: java.lang.Throwable -> L99
            java.util.concurrent.atomic.AtomicInteger r1 = r9.r     // Catch: java.lang.Throwable -> L99
            int r1 = r1.incrementAndGet()     // Catch: java.lang.Throwable -> L99
            long r2 = r2.longValue()     // Catch: java.lang.Throwable -> L99
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r0.<init>(r1, r2, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L99
            java.util.List<com.flurry.sdk.ja> r1 = r9.x     // Catch: java.lang.Throwable -> L99
            r1.add(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.String r1 = com.flurry.sdk.jh.f1944a     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = "Error logged: "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = r0.f1920a     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L99
            com.flurry.sdk.km.e(r1, r0)     // Catch: java.lang.Throwable -> L99
        L53:
            monitor-exit(r9)
            return
        L55:
            r1 = r0
            goto Ld
        L57:
            if (r1 == 0) goto La0
            r8 = r0
        L5a:
            java.util.List<com.flurry.sdk.ja> r0 = r9.x     // Catch: java.lang.Throwable -> L99
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L99
            if (r8 >= r0) goto L53
            java.util.List<com.flurry.sdk.ja> r0 = r9.x     // Catch: java.lang.Throwable -> L99
            java.lang.Object r0 = r0.get(r8)     // Catch: java.lang.Throwable -> L99
            com.flurry.sdk.ja r0 = (com.flurry.sdk.ja) r0     // Catch: java.lang.Throwable -> L99
            java.lang.String r1 = r0.f1920a     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto L9c
            java.lang.String r1 = "uncaught"
            java.lang.String r0 = r0.f1920a     // Catch: java.lang.Throwable -> L99
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Throwable -> L99
            if (r0 != 0) goto L9c
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L99
            java.lang.Long r2 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L99
            com.flurry.sdk.ja r0 = new com.flurry.sdk.ja     // Catch: java.lang.Throwable -> L99
            java.util.concurrent.atomic.AtomicInteger r1 = r9.r     // Catch: java.lang.Throwable -> L99
            int r1 = r1.incrementAndGet()     // Catch: java.lang.Throwable -> L99
            long r2 = r2.longValue()     // Catch: java.lang.Throwable -> L99
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r0.<init>(r1, r2, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L99
            java.util.List<com.flurry.sdk.ja> r1 = r9.x     // Catch: java.lang.Throwable -> L99
            r1.set(r8, r0)     // Catch: java.lang.Throwable -> L99
            goto L53
        L99:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        L9c:
            int r0 = r8 + 1
            r8 = r0
            goto L5a
        La0:
            java.lang.String r0 = com.flurry.sdk.jh.f1944a     // Catch: java.lang.Throwable -> L99
            java.lang.String r1 = "Max errors logged. No more errors logged."
            com.flurry.sdk.km.e(r0, r1)     // Catch: java.lang.Throwable -> L99
            goto L53
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.jh.a(java.lang.String, java.lang.String, java.lang.String, java.lang.Throwable):void");
    }

    static /* synthetic */ void d(jh jhVar) {
        SharedPreferences sharedPreferences = jy.a().f2022a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
        jhVar.j = sharedPreferences.getBoolean("com.flurry.sdk.previous_successful_report", false);
        jk.a();
        jhVar.z = sharedPreferences.getLong("com.flurry.sdk.initial_run_time", jk.d());
        jhVar.A = sharedPreferences.getString("com.flurry.sdk.api_key", "");
        if (TextUtils.isEmpty(jhVar.A) && jhVar.z > 0) {
            jhVar.A = jy.a().d;
        } else if (jhVar.A.equals(jy.a().d)) {
        } else {
            jk.a();
            jhVar.z = jk.d();
        }
    }
}
