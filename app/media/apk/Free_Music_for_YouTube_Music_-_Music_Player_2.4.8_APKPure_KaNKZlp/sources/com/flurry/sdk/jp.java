package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.flurry.sdk.lq;
@SuppressLint({"MissingPermission"})
/* loaded from: classes.dex */
public class jp implements lq.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1991a = jp.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static int f1992b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static int f1993c = -1;
    private static int d = -1;
    private static jp e;
    private boolean f;
    private Location g;
    private Location k;
    private long h = 0;
    private boolean l = false;
    private int m = 0;
    private kh<ls> n = new kh<ls>() { // from class: com.flurry.sdk.jp.1
        @Override // com.flurry.sdk.kh
        public final /* synthetic */ void a(ls lsVar) {
            if (jp.this.h <= 0 || jp.this.h >= System.currentTimeMillis()) {
                return;
            }
            km.a(4, jp.f1991a, "No location received in 90 seconds , stopping LocationManager");
            jp.this.i();
        }
    };
    private LocationManager i = (LocationManager) jy.a().f2022a.getSystemService(PlaceFields.LOCATION);
    private a j = new a();

    static /* synthetic */ int c(jp jpVar) {
        int i = jpVar.m + 1;
        jpVar.m = i;
        return i;
    }

    private jp() {
        lp a2 = lp.a();
        this.f = ((Boolean) a2.a("ReportLocation")).booleanValue();
        a2.a("ReportLocation", (lq.a) this);
        km.a(4, f1991a, "initSettings, ReportLocation = " + this.f);
        this.g = (Location) a2.a("ExplicitLocation");
        a2.a("ExplicitLocation", (lq.a) this);
        km.a(4, f1991a, "initSettings, ExplicitLocation = " + this.g);
    }

    public static synchronized jp a() {
        jp jpVar;
        synchronized (jp.class) {
            if (e == null) {
                e = new jp();
            }
            jpVar = e;
        }
        return jpVar;
    }

    public static int b() {
        return f1992b;
    }

    public static int c() {
        return f1993c;
    }

    public static int d() {
        return d;
    }

    public final synchronized void e() {
        km.a(4, f1991a, "Location update requested");
        if (this.m < 3 && !this.l && this.f && this.g == null) {
            Context context = jy.a().f2022a;
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                this.m = 0;
                String str = null;
                if (!a(context)) {
                    if (b(context)) {
                        str = "network";
                    }
                } else {
                    str = "passive";
                }
                if (!TextUtils.isEmpty(str)) {
                    this.i.requestLocationUpdates(str, 10000L, 0.0f, this.j, Looper.getMainLooper());
                }
                this.k = a(str);
                this.h = System.currentTimeMillis() + 90000;
                km.a(4, f1991a, "Register location timer");
                lt.a().a(this.n);
                this.l = true;
                km.a(4, f1991a, "LocationProvider started");
            }
        }
    }

    private static boolean a(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private static boolean b(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    private Location a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.i.getLastKnownLocation(str);
    }

    public final synchronized void f() {
        km.a(4, f1991a, "Stop update location requested");
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.l) {
            this.i.removeUpdates(this.j);
            this.m = 0;
            this.h = 0L;
            km.a(4, f1991a, "Unregister location timer");
            lt.a().b(this.n);
            this.l = false;
            km.a(4, f1991a, "LocationProvider stopped");
        }
    }

    public final Location g() {
        String str;
        Location location = null;
        if (this.g != null) {
            return this.g;
        }
        if (this.f) {
            Context context = jy.a().f2022a;
            if (!a(context) && !b(context)) {
                return null;
            }
            if (a(context)) {
                str = "passive";
            } else {
                str = b(context) ? "network" : null;
            }
            if (str != null) {
                Location a2 = a(str);
                if (a2 != null) {
                    this.k = a2;
                }
                location = this.k;
            }
        }
        km.a(4, f1991a, "getLocation() = " + location);
        return location;
    }

    @Override // com.flurry.sdk.lq.a
    public final void a(String str, Object obj) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case -864112343:
                if (str.equals("ReportLocation")) {
                    c2 = 0;
                    break;
                }
                break;
            case -300729815:
                if (str.equals("ExplicitLocation")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.f = ((Boolean) obj).booleanValue();
                km.a(4, f1991a, "onSettingUpdate, ReportLocation = " + this.f);
                return;
            case 1:
                this.g = (Location) obj;
                km.a(4, f1991a, "onSettingUpdate, ExplicitLocation = " + this.g);
                return;
            default:
                km.a(6, f1991a, "LocationProvider internal error! Had to be LocationCriteria, ReportLocation or ExplicitLocation key.");
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements LocationListener {
        public a() {
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            if (location != null) {
                jp.this.k = location;
            }
            if (jp.c(jp.this) >= 3) {
                km.a(4, jp.f1991a, "Max location reports reached, stopping");
                jp.this.i();
            }
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }
    }
}
