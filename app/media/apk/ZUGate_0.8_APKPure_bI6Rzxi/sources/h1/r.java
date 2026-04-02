package h1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import androidx.appcompat.widget.d0;
import com.google.android.gms.internal.play_billing.c3;
import com.google.android.gms.internal.play_billing.d3;
import com.google.android.gms.internal.play_billing.g3;
import com.google.android.gms.internal.play_billing.i3;
import com.google.android.gms.internal.play_billing.j3;
import com.google.android.gms.internal.play_billing.k3;
import com.google.android.gms.internal.play_billing.y2;
import d.w0;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public final class r implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3312a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f3313b = false;

    /* renamed from: c  reason: collision with root package name */
    public b f3314c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f3315d;

    public /* synthetic */ r(a aVar, b bVar) {
        this.f3315d = aVar;
        this.f3314c = bVar;
    }

    public final void a(g gVar) {
        synchronized (this.f3312a) {
            b bVar = this.f3314c;
            if (bVar != null) {
                bVar.b(gVar);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        k3 i3Var;
        com.google.android.gms.internal.play_billing.s.d("BillingClient", "Billing service connected.");
        a aVar = this.f3315d;
        int i5 = j3.f1900a;
        if (iBinder == null) {
            i3Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
            i3Var = queryLocalInterface instanceof k3 ? (k3) queryLocalInterface : new i3(iBinder);
        }
        aVar.f3247g = i3Var;
        Callable callable = new Callable() { // from class: h1.q
            /* JADX WARN: Removed duplicated region for block: B:100:0x0191  */
            /* JADX WARN: Removed duplicated region for block: B:106:0x01c2  */
            /* JADX WARN: Removed duplicated region for block: B:109:0x01ce  */
            /* JADX WARN: Removed duplicated region for block: B:110:0x01dd  */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object call() {
                /*
                    Method dump skipped, instructions count: 591
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: h1.q.call():java.lang.Object");
            }
        };
        androidx.activity.j jVar = new androidx.activity.j(15, this);
        a aVar2 = this.f3315d;
        if (aVar2.h(callable, 30000L, jVar, aVar2.d()) == null) {
            a aVar3 = this.f3315d;
            g f5 = aVar3.f();
            aVar3.i(s.a(25, 6, f5));
            a(f5);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.s.e("BillingClient", "Billing service disconnected.");
        t tVar = this.f3315d.f3246f;
        g3 n5 = g3.n();
        d0 d0Var = (d0) tVar;
        d0Var.getClass();
        if (n5 != null) {
            try {
                c3 q5 = d3.q();
                q5.c();
                d3.n((d3) q5.f1903c, (y2) d0Var.f306h);
                q5.c();
                d3.m((d3) q5.f1903c, n5);
                ((w0) d0Var.f307i).a((d3) q5.a());
            } catch (Throwable th) {
                com.google.android.gms.internal.play_billing.s.f("BillingLogger", "Unable to log.", th);
            }
        }
        this.f3315d.f3247g = null;
        this.f3315d.f3241a = 0;
        synchronized (this.f3312a) {
            b bVar = this.f3314c;
            if (bVar != null) {
                bVar.e();
            }
        }
    }
}
