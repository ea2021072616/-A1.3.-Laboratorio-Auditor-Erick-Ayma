package v1;

import android.content.Context;
import android.net.ConnectivityManager;
import java.net.MalformedURLException;
import java.net.URL;
import w1.e;
import w1.f;
import w1.i;
import w1.j;
import w1.k;
import w1.l;
import w1.m;
import w1.o;
import w1.p;
import w1.r;
import w1.s;
import w1.t;
import w1.w;
import y1.g;
/* loaded from: classes.dex */
public final class d implements g {

    /* renamed from: a  reason: collision with root package name */
    public final n2.b f5197a;

    /* renamed from: b  reason: collision with root package name */
    public final ConnectivityManager f5198b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f5199c;

    /* renamed from: d  reason: collision with root package name */
    public final URL f5200d;

    /* renamed from: e  reason: collision with root package name */
    public final f2.a f5201e;

    /* renamed from: f  reason: collision with root package name */
    public final f2.a f5202f;

    /* renamed from: g  reason: collision with root package name */
    public final int f5203g;

    public d(Context context, f2.a aVar, f2.a aVar2) {
        x3.d dVar = new x3.d();
        w1.c cVar = w1.c.f5310a;
        dVar.a(p.class, cVar);
        dVar.a(j.class, cVar);
        f fVar = f.f5323a;
        dVar.a(t.class, fVar);
        dVar.a(m.class, fVar);
        w1.d dVar2 = w1.d.f5312a;
        dVar.a(r.class, dVar2);
        dVar.a(k.class, dVar2);
        w1.b bVar = w1.b.f5297a;
        dVar.a(w1.a.class, bVar);
        dVar.a(i.class, bVar);
        e eVar = e.f5315a;
        dVar.a(s.class, eVar);
        dVar.a(l.class, eVar);
        w1.g gVar = w1.g.f5331a;
        dVar.a(w.class, gVar);
        dVar.a(o.class, gVar);
        dVar.f5505d = true;
        this.f5197a = new n2.b(dVar);
        this.f5199c = context;
        this.f5198b = (ConnectivityManager) context.getSystemService("connectivity");
        String str = a.f5186c;
        try {
            this.f5200d = new URL(str);
            this.f5201e = aVar2;
            this.f5202f = aVar;
            this.f5203g = 130000;
        } catch (MalformedURLException e5) {
            throw new IllegalArgumentException("Invalid url: " + str, e5);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(1:3)(1:22)|4|(1:6)(7:17|(1:19)(1:20)|8|9|10|11|12)|7|8|9|10|11|12) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009e, code lost:
        if (((w1.u) w1.u.f5380b.get(r0)) != null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00eb, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ec, code lost:
        b4.j.n("CctTransportBackend", "Unable to find version code for package", r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final x1.h a(x1.h r6) {
        /*
            r5 = this;
            android.net.ConnectivityManager r0 = r5.f5198b
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            androidx.appcompat.widget.x r6 = r6.c()
            int r1 = android.os.Build.VERSION.SDK_INT
            java.util.Map r2 = r6.e()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "sdk-version"
            r2.put(r3, r1)
            java.lang.String r1 = "model"
            java.lang.String r2 = android.os.Build.MODEL
            r6.a(r1, r2)
            java.lang.String r1 = "hardware"
            java.lang.String r2 = android.os.Build.HARDWARE
            r6.a(r1, r2)
            java.lang.String r1 = "device"
            java.lang.String r2 = android.os.Build.DEVICE
            r6.a(r1, r2)
            java.lang.String r1 = "product"
            java.lang.String r2 = android.os.Build.PRODUCT
            r6.a(r1, r2)
            java.lang.String r1 = "os-uild"
            java.lang.String r2 = android.os.Build.ID
            r6.a(r1, r2)
            java.lang.String r1 = "manufacturer"
            java.lang.String r2 = android.os.Build.MANUFACTURER
            r6.a(r1, r2)
            java.lang.String r1 = "fingerprint"
            java.lang.String r2 = android.os.Build.FINGERPRINT
            r6.a(r1, r2)
            java.util.Calendar.getInstance()
            java.util.TimeZone r1 = java.util.TimeZone.getDefault()
            java.util.Calendar r2 = java.util.Calendar.getInstance()
            long r2 = r2.getTimeInMillis()
            int r1 = r1.getOffset(r2)
            int r1 = r1 / 1000
            long r1 = (long) r1
            java.util.Map r3 = r6.e()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "tz-offset"
            r3.put(r2, r1)
            r1 = -1
            if (r0 != 0) goto L74
            android.util.SparseArray r2 = w1.v.f5382b
            r2 = r1
            goto L78
        L74:
            int r2 = r0.getType()
        L78:
            java.util.Map r3 = r6.e()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r4 = "net-type"
            r3.put(r4, r2)
            r2 = 0
            if (r0 != 0) goto L8b
            android.util.SparseArray r0 = w1.u.f5380b
            goto La1
        L8b:
            int r0 = r0.getSubtype()
            if (r0 != r1) goto L96
            android.util.SparseArray r0 = w1.u.f5380b
            r0 = 100
            goto La2
        L96:
            android.util.SparseArray r3 = w1.u.f5380b
            java.lang.Object r3 = r3.get(r0)
            w1.u r3 = (w1.u) r3
            if (r3 == 0) goto La1
            goto La2
        La1:
            r0 = r2
        La2:
            java.util.Map r3 = r6.e()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r4 = "mobile-subtype"
            r3.put(r4, r0)
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r0 = r0.getCountry()
            java.lang.String r3 = "country"
            r6.a(r3, r0)
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r0 = r0.getLanguage()
            java.lang.String r3 = "locale"
            r6.a(r3, r0)
            android.content.Context r0 = r5.f5199c
            java.lang.String r3 = "phone"
            java.lang.Object r3 = r0.getSystemService(r3)
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3
            java.lang.String r3 = r3.getSimOperator()
            java.lang.String r4 = "mcc_mnc"
            r6.a(r4, r3)
            android.content.pm.PackageManager r3 = r0.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Leb
            java.lang.String r0 = r0.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Leb
            android.content.pm.PackageInfo r0 = r3.getPackageInfo(r0, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Leb
            int r1 = r0.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Leb
            goto Lf3
        Leb:
            r0 = move-exception
            java.lang.String r2 = "CctTransportBackend"
            java.lang.String r3 = "Unable to find version code for package"
            b4.j.n(r2, r3, r0)
        Lf3:
            java.lang.String r0 = java.lang.Integer.toString(r1)
            java.lang.String r1 = "application_build"
            r6.a(r1, r0)
            x1.h r6 = r6.c()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.d.a(x1.h):x1.h");
    }
}
