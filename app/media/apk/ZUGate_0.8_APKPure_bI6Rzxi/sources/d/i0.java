package d;

import android.content.Context;
import android.location.Location;
import android.os.PowerManager;
import android.util.Log;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class i0 extends k0 {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f2363c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n0 f2364d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f2365e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(n0 n0Var, e eVar) {
        super(n0Var);
        this.f2364d = n0Var;
        this.f2365e = eVar;
    }

    @Override // d.k0
    public final int b() {
        boolean z4;
        long j5;
        int i5 = this.f2363c;
        Object obj = this.f2365e;
        switch (i5) {
            case 0:
                return d0.a((PowerManager) obj) ? 2 : 1;
            default:
                e eVar = (e) obj;
                z0 z0Var = (z0) eVar.f2323j;
                if (z0Var.f2497b > System.currentTimeMillis()) {
                    z4 = z0Var.f2496a;
                } else {
                    Location l5 = p2.a.k((Context) eVar.f2321h, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? eVar.l("network") : null;
                    Location l6 = p2.a.k((Context) eVar.f2321h, "android.permission.ACCESS_FINE_LOCATION") == 0 ? eVar.l("gps") : null;
                    if (l6 == null || l5 == null ? l6 != null : l6.getTime() > l5.getTime()) {
                        l5 = l6;
                    }
                    if (l5 != null) {
                        z0 z0Var2 = (z0) eVar.f2323j;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (y0.f2490d == null) {
                            y0.f2490d = new y0();
                        }
                        y0 y0Var = y0.f2490d;
                        y0Var.a(currentTimeMillis - 86400000, l5.getLatitude(), l5.getLongitude());
                        y0Var.a(currentTimeMillis, l5.getLatitude(), l5.getLongitude());
                        r6 = y0Var.f2493c == 1;
                        long j6 = y0Var.f2492b;
                        long j7 = y0Var.f2491a;
                        y0Var.a(currentTimeMillis + 86400000, l5.getLatitude(), l5.getLongitude());
                        long j8 = y0Var.f2492b;
                        if (j6 == -1 || j7 == -1) {
                            j5 = currentTimeMillis + 43200000;
                        } else {
                            j5 = (currentTimeMillis > j7 ? j8 + 0 : currentTimeMillis > j6 ? j7 + 0 : j6 + 0) + 60000;
                        }
                        z0Var2.f2496a = r6;
                        z0Var2.f2497b = j5;
                        z4 = z0Var.f2496a;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i6 = Calendar.getInstance().get(11);
                        if (i6 < 6 || i6 >= 22) {
                            r6 = true;
                        }
                        z4 = r6;
                    }
                }
                return z4 ? 2 : 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(n0 n0Var, Context context) {
        super(n0Var);
        this.f2364d = n0Var;
        this.f2365e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
