package h1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.widget.d0;
import com.google.android.gms.internal.play_billing.j2;
import com.google.android.gms.internal.play_billing.k0;
import com.google.android.gms.internal.play_billing.k3;
import com.google.android.gms.internal.play_billing.m2;
import com.google.android.gms.internal.play_billing.x2;
import com.google.android.gms.internal.play_billing.y2;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public volatile int f3241a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3242b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f3243c;

    /* renamed from: d  reason: collision with root package name */
    public volatile x f3244d;

    /* renamed from: e  reason: collision with root package name */
    public Context f3245e;

    /* renamed from: f  reason: collision with root package name */
    public t f3246f;

    /* renamed from: g  reason: collision with root package name */
    public volatile k3 f3247g;

    /* renamed from: h  reason: collision with root package name */
    public volatile r f3248h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3249i;

    /* renamed from: j  reason: collision with root package name */
    public int f3250j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3251k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f3252l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f3253m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3254n;
    public boolean o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f3255p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f3256q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f3257r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f3258s;

    /* renamed from: t  reason: collision with root package name */
    public h f3259t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f3260u;

    /* renamed from: v  reason: collision with root package name */
    public ExecutorService f3261v;

    public a(h hVar, Context context, y4.i iVar) {
        String g5 = g();
        this.f3241a = 0;
        this.f3243c = new Handler(Looper.getMainLooper());
        this.f3250j = 0;
        this.f3242b = g5;
        this.f3245e = context.getApplicationContext();
        x2 p5 = y2.p();
        p5.c();
        y2.m((y2) p5.f1903c, g5);
        String packageName = this.f3245e.getPackageName();
        p5.c();
        y2.n((y2) p5.f1903c, packageName);
        this.f3246f = new d0(this.f3245e, (y2) p5.a());
        if (iVar == null) {
            com.google.android.gms.internal.play_billing.s.e("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.f3244d = new x(this.f3245e, iVar, this.f3246f);
        this.f3259t = hVar;
        this.f3260u = false;
        this.f3245e.getPackageName();
    }

    public static String g() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return "7.0.0";
        }
    }

    public final void a() {
        j(s.b(12));
        try {
            try {
                if (this.f3244d != null) {
                    x xVar = this.f3244d;
                    w wVar = xVar.f3342d;
                    Context context = xVar.f3339a;
                    synchronized (wVar) {
                        if (wVar.f3336a) {
                            context.unregisterReceiver(wVar);
                            wVar.f3336a = false;
                        } else {
                            com.google.android.gms.internal.play_billing.s.e("BillingBroadcastManager", "Receiver is not registered.");
                        }
                    }
                    w wVar2 = xVar.f3343e;
                    synchronized (wVar2) {
                        if (wVar2.f3336a) {
                            context.unregisterReceiver(wVar2);
                            wVar2.f3336a = false;
                        } else {
                            com.google.android.gms.internal.play_billing.s.e("BillingBroadcastManager", "Receiver is not registered.");
                        }
                    }
                }
                if (this.f3248h != null) {
                    r rVar = this.f3248h;
                    synchronized (rVar.f3312a) {
                        rVar.f3314c = null;
                        rVar.f3313b = true;
                    }
                }
                if (this.f3248h != null && this.f3247g != null) {
                    com.google.android.gms.internal.play_billing.s.d("BillingClient", "Unbinding from service.");
                    this.f3245e.unbindService(this.f3248h);
                    this.f3248h = null;
                }
                this.f3247g = null;
                ExecutorService executorService = this.f3261v;
                if (executorService != null) {
                    executorService.shutdownNow();
                    this.f3261v = null;
                }
            } catch (Exception e5) {
                com.google.android.gms.internal.play_billing.s.f("BillingClient", "There was an exception while ending connection!", e5);
            }
            this.f3241a = 3;
        } catch (Throwable th) {
            this.f3241a = 3;
            throw th;
        }
    }

    public final boolean b() {
        return (this.f3241a != 2 || this.f3247g == null || this.f3248h == null) ? false : true;
    }

    public final void c(b bVar) {
        if (b()) {
            com.google.android.gms.internal.play_billing.s.d("BillingClient", "Service connection is valid. No need to re-initialize.");
            j(s.b(6));
            bVar.b(u.f3326i);
            return;
        }
        int i5 = 1;
        if (this.f3241a == 1) {
            com.google.android.gms.internal.play_billing.s.e("BillingClient", "Client is already in the process of connecting to billing service.");
            g gVar = u.f3321d;
            i(s.a(37, 6, gVar));
            bVar.b(gVar);
        } else if (this.f3241a == 3) {
            com.google.android.gms.internal.play_billing.s.e("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            g gVar2 = u.f3327j;
            i(s.a(38, 6, gVar2));
            bVar.b(gVar2);
        } else {
            this.f3241a = 1;
            com.google.android.gms.internal.play_billing.s.d("BillingClient", "Starting in-app billing setup.");
            this.f3248h = new r(this, bVar);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            List<ResolveInfo> queryIntentServices = this.f3245e.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                i5 = 41;
            } else {
                ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                if (serviceInfo != null) {
                    String str = serviceInfo.packageName;
                    String str2 = serviceInfo.name;
                    if (!"com.android.vending".equals(str) || str2 == null) {
                        com.google.android.gms.internal.play_billing.s.e("BillingClient", "The device doesn't have valid Play Store.");
                        i5 = 40;
                    } else {
                        ComponentName componentName = new ComponentName(str, str2);
                        Intent intent2 = new Intent(intent);
                        intent2.setComponent(componentName);
                        intent2.putExtra("playBillingLibraryVersion", this.f3242b);
                        if (this.f3245e.bindService(intent2, this.f3248h, 1)) {
                            com.google.android.gms.internal.play_billing.s.d("BillingClient", "Service was bonded successfully.");
                            return;
                        } else {
                            com.google.android.gms.internal.play_billing.s.e("BillingClient", "Connection to Billing service is blocked.");
                            i5 = 39;
                        }
                    }
                }
            }
            this.f3241a = 0;
            com.google.android.gms.internal.play_billing.s.d("BillingClient", "Billing service unavailable on device.");
            g gVar3 = u.f3320c;
            i(s.a(i5, 6, gVar3));
            bVar.b(gVar3);
        }
    }

    public final Handler d() {
        return Looper.myLooper() == null ? this.f3243c : new Handler(Looper.myLooper());
    }

    public final void e(g gVar) {
        if (Thread.interrupted()) {
            return;
        }
        this.f3243c.post(new androidx.appcompat.widget.k(this, gVar, 7));
    }

    public final g f() {
        return (this.f3241a == 0 || this.f3241a == 3) ? u.f3327j : u.f3325h;
    }

    public final Future h(Callable callable, long j5, Runnable runnable, Handler handler) {
        if (this.f3261v == null) {
            this.f3261v = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.s.f1952a, new i.c());
        }
        try {
            Future submit = this.f3261v.submit(callable);
            handler.postDelayed(new androidx.appcompat.widget.k(submit, runnable, 9), (long) (j5 * 0.95d));
            return submit;
        } catch (Exception e5) {
            com.google.android.gms.internal.play_billing.s.f("BillingClient", "Async task throws exception!", e5);
            return null;
        }
    }

    public final void i(j2 j2Var) {
        t tVar = this.f3246f;
        int i5 = this.f3250j;
        d0 d0Var = (d0) tVar;
        d0Var.getClass();
        try {
            y2 y2Var = (y2) d0Var.f306h;
            k0 k0Var = (k0) y2Var.l(5);
            if (!k0Var.f1902b.equals(y2Var)) {
                if (!k0Var.f1903c.k()) {
                    k0Var.d();
                }
                k0.e(k0Var.f1903c, y2Var);
            }
            x2 x2Var = (x2) k0Var;
            x2Var.c();
            y2.o((y2) x2Var.f1903c, i5);
            d0Var.f306h = (y2) x2Var.a();
            d0Var.r(j2Var);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.s.f("BillingLogger", "Unable to log.", th);
        }
    }

    public final void j(m2 m2Var) {
        t tVar = this.f3246f;
        int i5 = this.f3250j;
        d0 d0Var = (d0) tVar;
        d0Var.getClass();
        try {
            y2 y2Var = (y2) d0Var.f306h;
            k0 k0Var = (k0) y2Var.l(5);
            if (!k0Var.f1902b.equals(y2Var)) {
                if (!k0Var.f1903c.k()) {
                    k0Var.d();
                }
                k0.e(k0Var.f1903c, y2Var);
            }
            x2 x2Var = (x2) k0Var;
            x2Var.c();
            y2.o((y2) x2Var.f1903c, i5);
            d0Var.f306h = (y2) x2Var.a();
            d0Var.s(m2Var);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.s.f("BillingLogger", "Unable to log.", th);
        }
    }
}
