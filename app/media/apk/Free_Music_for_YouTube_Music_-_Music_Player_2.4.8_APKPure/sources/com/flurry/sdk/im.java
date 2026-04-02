package com.flurry.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import b.a.a.a.a.b.a;
import com.flurry.sdk.ik;
import com.flurry.sdk.it;
import com.flurry.sdk.ks;
import com.flurry.sdk.ku;
import com.flurry.sdk.lq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class im implements lq.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1847a = im.class.getSimpleName();
    private kf<ik> g;
    private kf<List<it>> h;
    private boolean i;
    private String j;
    private boolean k;
    private boolean l;
    private long n;
    private boolean o;
    private hz p;
    private boolean q;

    /* renamed from: b  reason: collision with root package name */
    private final kq<hy> f1848b = new kq<>("proton config request", new iy());

    /* renamed from: c  reason: collision with root package name */
    private final kq<hz> f1849c = new kq<>("proton config response", new iz());
    private final il d = new il();
    private final kd<String, ic> e = new kd<>();
    private final List<it> f = new ArrayList();
    private long m = 10000;
    private final Runnable r = new ma() { // from class: com.flurry.sdk.im.1
        @Override // com.flurry.sdk.ma
        public final void a() {
            im.this.e();
        }
    };
    private final kh<jm> s = new kh<jm>() { // from class: com.flurry.sdk.im.4
        @Override // com.flurry.sdk.kh
        public final /* bridge */ /* synthetic */ void a(jm jmVar) {
            im.this.e();
        }
    };
    private final kh<jn> t = new kh<jn>() { // from class: com.flurry.sdk.im.5
        @Override // com.flurry.sdk.kh
        public final /* bridge */ /* synthetic */ void a(jn jnVar) {
            im.this.e();
        }
    };
    private final kh<jq> u = new kh<jq>() { // from class: com.flurry.sdk.im.6
        @Override // com.flurry.sdk.kh
        public final /* bridge */ /* synthetic */ void a(jq jqVar) {
            if (jqVar.f1996a) {
                im.this.e();
            }
        }
    };

    static /* synthetic */ boolean g(im imVar) {
        imVar.q = true;
        return true;
    }

    public im() {
        this.k = true;
        lp a2 = lp.a();
        this.i = ((Boolean) a2.a("ProtonEnabled")).booleanValue();
        a2.a("ProtonEnabled", (lq.a) this);
        km.a(4, f1847a, "initSettings, protonEnabled = " + this.i);
        this.j = (String) a2.a("ProtonConfigUrl");
        a2.a("ProtonConfigUrl", (lq.a) this);
        km.a(4, f1847a, "initSettings, protonConfigUrl = " + this.j);
        this.k = ((Boolean) a2.a("analyticsEnabled")).booleanValue();
        a2.a("analyticsEnabled", (lq.a) this);
        km.a(4, f1847a, "initSettings, AnalyticsEnabled = " + this.k);
        ki.a().a("com.flurry.android.sdk.IdProviderFinishedEvent", this.s);
        ki.a().a("com.flurry.android.sdk.IdProviderUpdatedAdvertisingId", this.t);
        ki.a().a("com.flurry.android.sdk.NetworkStateEvent", this.u);
        Context context = jy.a().f2022a;
        this.g = new kf<>(context.getFileStreamPath(".yflurryprotonconfig." + Long.toString(ly.i(jy.a().d), 16)), ".yflurryprotonconfig.", 1, new lj<ik>() { // from class: com.flurry.sdk.im.7
            @Override // com.flurry.sdk.lj
            public final lg<ik> a(int i) {
                return new ik.a();
            }
        });
        this.h = new kf<>(context.getFileStreamPath(".yflurryprotonreport." + Long.toString(ly.i(jy.a().d), 16)), ".yflurryprotonreport.", 1, new lj<List<it>>() { // from class: com.flurry.sdk.im.8
            @Override // com.flurry.sdk.lj
            public final lg<List<it>> a(int i) {
                return new lf(new it.a());
            }
        });
        jy.a().b(new ma() { // from class: com.flurry.sdk.im.9
            @Override // com.flurry.sdk.ma
            public final void a() {
                im.this.l();
            }
        });
        jy.a().b(new ma() { // from class: com.flurry.sdk.im.10
            @Override // com.flurry.sdk.ma
            public final void a() {
                im.this.m();
            }
        });
    }

    @Override // com.flurry.sdk.lq.a
    public final void a(String str, Object obj) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1720015653:
                if (str.equals("analyticsEnabled")) {
                    c2 = 2;
                    break;
                }
                break;
            case 640941243:
                if (str.equals("ProtonEnabled")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1591403975:
                if (str.equals("ProtonConfigUrl")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.i = ((Boolean) obj).booleanValue();
                km.a(4, f1847a, "onSettingUpdate, protonEnabled = " + this.i);
                return;
            case 1:
                this.j = (String) obj;
                km.a(4, f1847a, "onSettingUpdate, protonConfigUrl = " + this.j);
                return;
            case 2:
                this.k = ((Boolean) obj).booleanValue();
                km.a(4, f1847a, "onSettingUpdate, AnalyticsEnabled = " + this.k);
                return;
            default:
                km.a(6, f1847a, "onSettingUpdate internal error!");
                return;
        }
    }

    public final synchronized void a() {
        if (this.i) {
            ly.b();
            jk.a();
            io.f1868a = jk.d();
            this.q = false;
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v1, types: [byte[], RequestObjectType] */
    public synchronized void e() {
        if (this.i) {
            ly.b();
            if (this.l && jl.a().b()) {
                final long currentTimeMillis = System.currentTimeMillis();
                final boolean z = !jl.a().c();
                if (this.p != null) {
                    if (this.o != z) {
                        km.a(3, f1847a, "Limit ad tracking value has changed, purging");
                        this.p = null;
                    } else if (System.currentTimeMillis() < this.n + (this.p.f1822b * 1000)) {
                        km.a(3, f1847a, "Cached Proton config valid, no need to refresh");
                        if (!this.q) {
                            this.q = true;
                            b("flurry.session_start", (Map<String, String>) null);
                        }
                    } else if (System.currentTimeMillis() >= this.n + (this.p.f1823c * 1000)) {
                        km.a(3, f1847a, "Cached Proton config expired, purging");
                        this.p = null;
                        this.e.a();
                    }
                }
                jw.a().a(this);
                km.a(3, f1847a, "Requesting proton config");
                ?? f = f();
                if (f != 0) {
                    ks ksVar = new ks();
                    ksVar.g = TextUtils.isEmpty(this.j) ? "https://proton.flurry.com/sdk/v1/config" : this.j;
                    ksVar.u = 5000;
                    ksVar.h = ku.a.kPost;
                    String num = Integer.toString(kq.a((byte[]) f));
                    ksVar.a("Content-Type", "application/x-flurry;version=2");
                    ksVar.a(a.HEADER_ACCEPT, "application/x-flurry;version=2");
                    ksVar.a("FM-Checksum", num);
                    ksVar.f2080c = new lc();
                    ksVar.d = new lc();
                    ksVar.f2079b = f;
                    ksVar.f2078a = new ks.a<byte[], byte[]>() { // from class: com.flurry.sdk.im.11
                        @Override // com.flurry.sdk.ks.a
                        public final /* synthetic */ void a(ks<byte[], byte[]> ksVar2, byte[] bArr) {
                            long j;
                            hz hzVar;
                            final byte[] bArr2 = bArr;
                            int i = ksVar2.q;
                            km.a(3, im.f1847a, "Proton config request: HTTP status code is:" + i);
                            if (i == 400 || i == 406 || i == 412 || i == 415) {
                                im.this.m = 10000L;
                                return;
                            }
                            if (ksVar2.b() && bArr2 != null) {
                                jy.a().b(new ma() { // from class: com.flurry.sdk.im.11.1
                                    @Override // com.flurry.sdk.ma
                                    public final void a() {
                                        im.this.a(currentTimeMillis, z, bArr2);
                                    }
                                });
                                try {
                                    hzVar = (hz) im.this.f1849c.b(bArr2);
                                } catch (Exception e) {
                                    km.a(5, im.f1847a, "Failed to decode proton config response: " + e);
                                    hzVar = null;
                                }
                                r1 = im.b(hzVar) ? hzVar : null;
                                if (r1 != null) {
                                    im.this.m = 10000L;
                                    im.this.n = currentTimeMillis;
                                    im.this.o = z;
                                    im.this.p = r1;
                                    im.this.g();
                                    if (!im.this.q) {
                                        im.g(im.this);
                                        im.this.b("flurry.session_start", (Map<String, String>) null);
                                    }
                                    im.this.h();
                                }
                            }
                            if (r1 == null) {
                                long j2 = im.this.m << 1;
                                if (i == 429) {
                                    List<String> a2 = ksVar2.a("Retry-After");
                                    if (!a2.isEmpty()) {
                                        String str = a2.get(0);
                                        km.a(3, im.f1847a, "Server returned retry time: " + str);
                                        try {
                                            j = Long.parseLong(str) * 1000;
                                        } catch (NumberFormatException e2) {
                                            km.a(3, im.f1847a, "Server returned nonsensical retry time");
                                        }
                                        im.this.m = j;
                                        km.a(3, im.f1847a, "Proton config request failed, backing off: " + im.this.m + "ms");
                                        jy.a().a(im.this.r, im.this.m);
                                    }
                                }
                                j = j2;
                                im.this.m = j;
                                km.a(3, im.f1847a, "Proton config request failed, backing off: " + im.this.m + "ms");
                                jy.a().a(im.this.r, im.this.m);
                            }
                        }
                    };
                    jw.a().a((Object) this, (im) ksVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(String str, Map<String, String> map) {
        ix ixVar;
        boolean z;
        km.a(3, f1847a, "Event triggered: " + str);
        if (!this.k) {
            km.e(f1847a, "Analytics and pulse have been disabled.");
        } else if (this.p == null) {
            km.a(3, f1847a, "Config response is empty. No events to fire.");
        } else {
            ly.b();
            if (!TextUtils.isEmpty(str)) {
                List<ic> a2 = this.e.a((kd<String, ic>) str);
                if (a2 == null) {
                    km.a(3, f1847a, "No events to fire. Returning.");
                } else if (a2.size() == 0) {
                    km.a(3, f1847a, "No events to fire. Returning.");
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean z2 = map != null;
                    char c2 = 65535;
                    switch (str.hashCode()) {
                        case 645204782:
                            if (str.equals("flurry.session_end")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1371447545:
                            if (str.equals("flurry.app_install")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1579613685:
                            if (str.equals("flurry.session_start")) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            ixVar = ix.SESSION_START;
                            break;
                        case 1:
                            ixVar = ix.SESSION_END;
                            break;
                        case 2:
                            ixVar = ix.INSTALL;
                            break;
                        default:
                            ixVar = ix.APPLICATION_EVENT;
                            break;
                    }
                    HashMap hashMap = new HashMap();
                    for (ic icVar : a2) {
                        boolean z3 = false;
                        if (icVar instanceof id) {
                            km.a(4, f1847a, "Event contains triggers.");
                            String[] strArr = ((id) icVar).d;
                            if (strArr == null) {
                                km.a(4, f1847a, "Template does not contain trigger values. Firing.");
                                z3 = true;
                            } else if (strArr.length == 0) {
                                km.a(4, f1847a, "Template does not contain trigger values. Firing.");
                                z3 = true;
                            } else if (map == null) {
                                km.a(4, f1847a, "Publisher has not passed in params list. Not firing.");
                            }
                            String str2 = map.get(((id) icVar).f1829c);
                            if (str2 == null) {
                                km.a(4, f1847a, "Publisher params has no value associated with proton key. Not firing.");
                            } else {
                                int length = strArr.length;
                                int i = 0;
                                while (true) {
                                    if (i >= length) {
                                        z = z3;
                                    } else if (!strArr[i].equals(str2)) {
                                        i++;
                                    } else {
                                        z = true;
                                    }
                                }
                                if (!z) {
                                    km.a(4, f1847a, "Publisher params list does not match proton param values. Not firing.");
                                } else {
                                    km.a(4, f1847a, "Publisher params match proton values. Firing.");
                                }
                            }
                        }
                        hw hwVar = icVar.f1828b;
                        if (hwVar == null) {
                            km.a(3, f1847a, "Template is empty. Not firing current event.");
                        } else {
                            km.a(3, f1847a, "Creating callback report for partner: " + hwVar.f1813b);
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("event_name", str);
                            hashMap2.put("event_time_millis", String.valueOf(currentTimeMillis));
                            String a3 = this.d.a(hwVar.e, hashMap2);
                            String str3 = null;
                            if (hwVar.f != null) {
                                str3 = this.d.a(hwVar.f, hashMap2);
                            }
                            hashMap.put(Long.valueOf(hwVar.f1812a), new ip(hwVar.f1813b, hwVar.f1812a, a3, System.currentTimeMillis() + 259200000, this.p.e.f1816b, hwVar.g, hwVar.d, hwVar.j, hwVar.i, hwVar.h, str3));
                        }
                    }
                    if (hashMap.size() != 0) {
                        jk.a();
                        long d = jk.d();
                        jk.a();
                        it itVar = new it(str, z2, d, jk.g(), ixVar, hashMap);
                        if ("flurry.session_end".equals(str)) {
                            km.a(3, f1847a, "Storing Pulse callbacks for event: " + str);
                            this.f.add(itVar);
                        } else {
                            km.a(3, f1847a, "Firing Pulse callbacks for event: " + str);
                            is.c().a(itVar);
                        }
                    }
                }
            }
        }
    }

    private byte[] f() {
        try {
            hy hyVar = new hy();
            hyVar.f1818a = jy.a().d;
            hyVar.f1819b = lv.a(jy.a().f2022a);
            hyVar.f1820c = lv.b(jy.a().f2022a);
            hyVar.d = jz.b();
            hyVar.e = 3;
            ju.a();
            hyVar.f = ju.b();
            hyVar.g = !jl.a().c();
            hyVar.h = new ib();
            hyVar.h.f1826a = new hv();
            hyVar.h.f1826a.f1809a = Build.MODEL;
            hyVar.h.f1826a.f1810b = Build.BRAND;
            hyVar.h.f1826a.f1811c = Build.ID;
            hyVar.h.f1826a.d = Build.DEVICE;
            hyVar.h.f1826a.e = Build.PRODUCT;
            hyVar.h.f1826a.f = Build.VERSION.RELEASE;
            hyVar.i = new ArrayList();
            for (Map.Entry entry : Collections.unmodifiableMap(jl.a().f1980a).entrySet()) {
                ia iaVar = new ia();
                iaVar.f1824a = ((jt) entry.getKey()).f2008c;
                if (((jt) entry.getKey()).d) {
                    iaVar.f1825b = new String((byte[]) entry.getValue());
                } else {
                    iaVar.f1825b = ly.b((byte[]) entry.getValue());
                }
                hyVar.i.add(iaVar);
            }
            Location g = jp.a().g();
            if (g != null) {
                int d = jp.d();
                hyVar.j = new Cif();
                hyVar.j.f1833a = new ie();
                hyVar.j.f1833a.f1830a = ly.a(g.getLatitude(), d);
                hyVar.j.f1833a.f1831b = ly.a(g.getLongitude(), d);
                hyVar.j.f1833a.f1832c = (float) ly.a(g.getAccuracy(), d);
            }
            String str = (String) lp.a().a("UserId");
            if (!str.equals("")) {
                hyVar.k = new ii();
                hyVar.k.f1838a = str;
            }
            return this.f1848b.a((kq<hy>) hyVar);
        } catch (Exception e) {
            km.a(5, f1847a, "Proton config request failed with exception: " + e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(long j, boolean z, byte[] bArr) {
        if (bArr != null) {
            km.a(4, f1847a, "Saving proton config response");
            ik ikVar = new ik();
            ikVar.f1841a = j;
            ikVar.f1842b = z;
            ikVar.f1843c = bArr;
            this.g.a(ikVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(hz hzVar) {
        boolean z;
        boolean z2;
        if (hzVar == null) {
            return false;
        }
        hx hxVar = hzVar.e;
        if (hxVar != null && hxVar.f1815a != null) {
            for (int i = 0; i < hxVar.f1815a.size(); i++) {
                hw hwVar = hxVar.f1815a.get(i);
                if (hwVar != null) {
                    if (!hwVar.f1813b.equals("") && hwVar.f1812a != -1 && !hwVar.e.equals("")) {
                        List<ic> list = hwVar.f1814c;
                        if (list != null) {
                            for (ic icVar : list) {
                                if (icVar.f1827a.equals("")) {
                                    km.a(3, f1847a, "An event is missing a name");
                                    z2 = false;
                                    break;
                                } else if ((icVar instanceof id) && ((id) icVar).f1829c.equals("")) {
                                    km.a(3, f1847a, "An event trigger is missing a param name");
                                    z2 = false;
                                    break;
                                }
                            }
                        }
                        z2 = true;
                        if (!z2) {
                        }
                    }
                    km.a(3, f1847a, "A callback template is missing required values");
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z && (hzVar.e == null || hzVar.e.e == null || !hzVar.e.e.equals(""))) {
            return true;
        }
        km.a(3, f1847a, "Config response is missing required values.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        List<hw> list;
        List<ic> list2;
        if (this.p != null) {
            km.a(5, f1847a, "Processing config response");
            is.a(this.p.e.f1817c);
            is.b(this.p.e.d * 1000);
            iu a2 = iu.a();
            String str = this.p.e.e;
            if (str != null && !str.endsWith(".do")) {
                km.a(5, iu.f1903a, "overriding analytics agent report URL without an endpoint, are you sure?");
            }
            a2.f1905b = str;
            if (this.i) {
                lp.a().a("analyticsEnabled", Boolean.valueOf(this.p.f.f1840b));
            }
            this.e.a();
            hx hxVar = this.p.e;
            if (hxVar != null && (list = hxVar.f1815a) != null) {
                for (hw hwVar : list) {
                    if (hwVar != null && (list2 = hwVar.f1814c) != null) {
                        for (ic icVar : list2) {
                            if (icVar != null && !TextUtils.isEmpty(icVar.f1827a)) {
                                icVar.f1828b = hwVar;
                                this.e.a((kd<String, ic>) icVar.f1827a, (String) icVar);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h() {
        if (this.i) {
            ly.b();
            SharedPreferences sharedPreferences = jy.a().f2022a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
            if (sharedPreferences.getBoolean("com.flurry.android.flurryAppInstall", true)) {
                b("flurry.app_install", (Map<String, String>) null);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("com.flurry.android.flurryAppInstall", false);
                edit.apply();
            }
        }
    }

    public final synchronized void b() {
        if (this.i) {
            ly.b();
            jk.a();
            b(jk.d());
            i();
        }
    }

    private synchronized void b(long j) {
        Iterator<it> it = this.f.iterator();
        while (it.hasNext()) {
            if (j == it.next().f1897a) {
                it.remove();
            }
        }
    }

    private synchronized void i() {
        if (!this.k) {
            km.e(f1847a, "Analytics disabled, not sending pulse reports.");
        } else {
            km.a(4, f1847a, "Sending " + this.f.size() + " queued reports.");
            for (it itVar : this.f) {
                km.a(3, f1847a, "Firing Pulse callbacks for event: " + itVar.f1899c);
                is.c().a(itVar);
            }
            j();
        }
    }

    private synchronized void j() {
        this.f.clear();
        this.h.b();
    }

    public final synchronized void a(long j) {
        if (this.i) {
            ly.b();
            b(j);
            b("flurry.session_end", (Map<String, String>) null);
            jy.a().b(new ma() { // from class: com.flurry.sdk.im.2
                @Override // com.flurry.sdk.ma
                public final void a() {
                    im.this.k();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k() {
        km.a(4, f1847a, "Saving queued report data.");
        this.h.a(this.f);
    }

    public final synchronized void c() {
        if (this.i) {
            ly.b();
            i();
        }
    }

    public final synchronized void a(String str, Map<String, String> map) {
        if (this.i) {
            ly.b();
            b(str, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l() {
        hz hzVar;
        ik a2 = this.g.a();
        if (a2 != null) {
            try {
                hzVar = this.f1849c.b(a2.f1843c);
            } catch (Exception e) {
                km.a(5, f1847a, "Failed to decode saved proton config response: " + e);
                this.g.b();
                hzVar = null;
            }
            if (!b(hzVar)) {
                hzVar = null;
            }
            if (hzVar != null) {
                km.a(4, f1847a, "Loaded saved proton config response");
                this.m = 10000L;
                this.n = a2.f1841a;
                this.o = a2.f1842b;
                this.p = hzVar;
                g();
            }
        }
        this.l = true;
        jy.a().b(new ma() { // from class: com.flurry.sdk.im.3
            @Override // com.flurry.sdk.ma
            public final void a() {
                im.this.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m() {
        km.a(4, f1847a, "Loading queued report data.");
        List<it> a2 = this.h.a();
        if (a2 != null) {
            this.f.addAll(a2);
        }
    }
}
