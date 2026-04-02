package h1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.widget.d0;
import com.google.android.gms.internal.play_billing.e0;
import com.google.android.gms.internal.play_billing.i0;
import com.google.android.gms.internal.play_billing.j2;
/* loaded from: classes.dex */
public final class w extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3336a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f3337b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ x f3338c;

    public w(x xVar, boolean z4) {
        this.f3338c = xVar;
        this.f3337b = z4;
    }

    public final synchronized void a(Context context, IntentFilter intentFilter) {
        if (this.f3336a) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(this, intentFilter, true != this.f3337b ? 4 : 2);
        } else {
            context.registerReceiver(this, intentFilter);
        }
        this.f3336a = true;
    }

    public final void b(Bundle bundle, g gVar, int i5) {
        e0 e0Var;
        if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") == null) {
            ((d0) this.f3338c.f3341c).r(s.a(23, i5, gVar));
            return;
        }
        try {
            t tVar = this.f3338c.f3341c;
            byte[] byteArray = bundle.getByteArray("FAILURE_LOGGING_PAYLOAD");
            e0 e0Var2 = e0.f1855a;
            if (e0Var2 == null) {
                synchronized (e0.class) {
                    e0Var = e0.f1855a;
                    if (e0Var == null) {
                        e0Var = i0.Z();
                        e0.f1855a = e0Var;
                    }
                }
                e0Var2 = e0Var;
            }
            ((d0) tVar).r(j2.m(byteArray, e0Var2));
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.s.e("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010e  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onReceive(android.content.Context r10, android.content.Intent r11) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.w.onReceive(android.content.Context, android.content.Intent):void");
    }
}
