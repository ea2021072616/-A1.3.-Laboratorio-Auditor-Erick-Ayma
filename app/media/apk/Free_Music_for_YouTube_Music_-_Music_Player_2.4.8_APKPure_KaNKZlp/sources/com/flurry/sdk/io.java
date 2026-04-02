package com.flurry.sdk;

import com.flurry.sdk.ip;
import com.flurry.sdk.ks;
import com.flurry.sdk.ku;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class io extends kx<ip> {

    /* renamed from: a  reason: collision with root package name */
    public static long f1868a;
    private static final String e = io.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r2v26, types: [byte[], RequestObjectType] */
    @Override // com.flurry.sdk.kx
    public final /* synthetic */ void a(ip ipVar) {
        final ip ipVar2 = ipVar;
        km.a(3, e, "Sending next pulse report to " + ipVar2.l + " at: " + ipVar2.r);
        jk.a();
        long d = jk.d();
        if (d == 0) {
            d = f1868a;
        }
        jk.a();
        long g = jk.g();
        if (g == 0) {
            g = System.currentTimeMillis() - d;
        }
        final iq iqVar = new iq(ipVar2, d, g, ipVar2.p);
        ks ksVar = new ks();
        ksVar.g = ipVar2.r;
        ksVar.u = DefaultOggSeeker.MATCH_BYTE_RANGE;
        if (ipVar2.d.equals(iw.POST)) {
            ksVar.f2080c = new lc();
            if (ipVar2.k != null) {
                ksVar.f2079b = ipVar2.k.getBytes();
            }
            ksVar.h = ku.a.kPost;
        } else {
            ksVar.h = ku.a.kGet;
        }
        ksVar.i = ipVar2.i * 1000;
        ksVar.j = ipVar2.j * 1000;
        ksVar.m = true;
        ksVar.r = true;
        ksVar.s = (ipVar2.i + ipVar2.j) * 1000;
        Map<String, String> map = ipVar2.e;
        if (map != null) {
            for (String str : ipVar2.e.keySet()) {
                ksVar.a(str, map.get(str));
            }
        }
        ksVar.k = false;
        ksVar.f2078a = new ks.a<byte[], String>() { // from class: com.flurry.sdk.io.2
            @Override // com.flurry.sdk.ks.a
            public final /* synthetic */ void a(ks<byte[], String> ksVar2, String str2) {
                boolean z = false;
                String str3 = str2;
                km.a(3, io.e, "Pulse report to " + ipVar2.l + " for " + ipVar2.g.f1899c + ", HTTP status code is: " + ksVar2.q);
                int i = ksVar2.q;
                iq iqVar2 = iqVar;
                int i2 = (int) ksVar2.o;
                if (i2 < 0) {
                    if (iqVar2.k <= 0) {
                        iqVar2.k = 0L;
                    }
                } else {
                    iqVar2.k = i2 + iqVar2.k;
                }
                iqVar.e = i;
                if (ksVar2.b()) {
                    if (i >= 200 && i < 300) {
                        io.b(io.this, iqVar, ipVar2);
                        return;
                    } else if (i >= 300 && i < 400) {
                        io.a(io.this, iqVar, ipVar2, ksVar2);
                        return;
                    } else {
                        km.a(3, io.e, ipVar2.g.f1899c + " report failed sending to : " + ipVar2.l);
                        io.a(io.this, iqVar, ipVar2, str3);
                        return;
                    }
                }
                Exception exc = ksVar2.p;
                boolean z2 = ksVar2.p != null && (ksVar2.p instanceof SocketTimeoutException);
                if (ksVar2.t || z2) {
                    z = true;
                }
                if (z) {
                    if (ksVar2.c()) {
                        km.a(3, io.e, "Timeout occured when trying to connect to: " + ipVar2.l + ". Exception: " + ksVar2.p.getMessage());
                    } else {
                        km.a(3, io.e, "Manually managed http request timeout occured for: " + ipVar2.l);
                    }
                    io.a(io.this, iqVar, ipVar2);
                    return;
                }
                km.a(3, io.e, "Error occured when trying to connect to: " + ipVar2.l + ". Exception: " + exc.getMessage());
                io.a(io.this, iqVar, ipVar2, str3);
            }
        };
        jw.a().a((Object) this, (io) ksVar);
    }

    public io() {
        kx.f2095b = 30000L;
        this.d = kx.f2095b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.flurry.sdk.kx
    public final kf<List<ip>> a() {
        return new kf<>(jy.a().f2022a.getFileStreamPath(".yflurryanpulsecallbackreporter"), ".yflurryanpulsecallbackreporter", 2, new lj<List<ip>>() { // from class: com.flurry.sdk.io.1
            @Override // com.flurry.sdk.lj
            public final lg<List<ip>> a(int i) {
                return new lf(new ip.a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.flurry.sdk.kx
    public final synchronized void a(List<ip> list) {
        is.c();
        List<it> d = is.d();
        if (d != null && d.size() != 0) {
            km.a(3, e, "Restoring " + d.size() + " from report queue.");
            for (it itVar : d) {
                is.c().b(itVar);
            }
            is.c();
            for (it itVar2 : is.b()) {
                for (ip ipVar : itVar2.a()) {
                    if (!ipVar.m) {
                        km.a(3, e, "Callback for " + ipVar.g.f1899c + " to " + ipVar.l + " not completed.  Adding to reporter queue.");
                        list.add(ipVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.flurry.sdk.kx
    public final synchronized void b(List<ip> list) {
        is.c().a();
    }

    static /* synthetic */ void a(io ioVar, iq iqVar, ip ipVar) {
        is.c().b(iqVar);
        ioVar.c((io) ipVar);
    }

    static /* synthetic */ void a(io ioVar, iq iqVar, ip ipVar, String str) {
        boolean b2 = is.c().b(iqVar, str);
        km.a(3, e, "Failed report retrying: " + b2);
        if (b2) {
            ioVar.d(ipVar);
        } else {
            ioVar.c((io) ipVar);
        }
    }

    static /* synthetic */ void b(io ioVar, iq iqVar, ip ipVar) {
        km.a(3, e, ipVar.g.f1899c + " report sent successfully to : " + ipVar.l);
        is.c().a(iqVar);
        ioVar.c((io) ipVar);
    }

    static /* synthetic */ void a(io ioVar, iq iqVar, ip ipVar, ks ksVar) {
        String str = null;
        List<String> a2 = ksVar.a("Location");
        if (a2 != null && a2.size() > 0) {
            str = mc.b(a2.get(0), ipVar.q);
        }
        boolean a3 = is.c().a(iqVar, str);
        if (a3) {
            km.a(3, e, "Received redirect url. Retrying: " + str);
        } else {
            km.a(3, e, "Received redirect url. Retrying: false");
        }
        if (!a3) {
            ioVar.c((io) ipVar);
            return;
        }
        ipVar.r = str;
        ksVar.g = str;
        if (ksVar.f != null && ksVar.f.f2038a.containsKey("Location")) {
            ksVar.f.b("Location");
        }
        jw.a().a((Object) ioVar, (io) ksVar);
    }
}
