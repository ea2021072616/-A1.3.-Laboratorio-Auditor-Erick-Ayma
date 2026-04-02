package h1;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3339a;

    /* renamed from: b  reason: collision with root package name */
    public final y4.i f3340b;

    /* renamed from: c  reason: collision with root package name */
    public final t f3341c;

    /* renamed from: d  reason: collision with root package name */
    public final w f3342d = new w(this, true);

    /* renamed from: e  reason: collision with root package name */
    public final w f3343e = new w(this, false);

    /* renamed from: f  reason: collision with root package name */
    public boolean f3344f;

    public x(Context context, y4.i iVar, t tVar) {
        this.f3339a = context;
        this.f3340b = iVar;
        this.f3341c = tVar;
    }

    public final void a(boolean z4) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f3344f = z4;
        this.f3343e.a(this.f3339a, intentFilter2);
        if (!this.f3344f) {
            this.f3342d.a(this.f3339a, intentFilter);
            return;
        }
        w wVar = this.f3342d;
        Context context = this.f3339a;
        synchronized (wVar) {
            if (!wVar.f3336a) {
                if (Build.VERSION.SDK_INT >= 33) {
                    context.registerReceiver(wVar, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != wVar.f3337b ? 4 : 2);
                } else {
                    context.registerReceiver(wVar, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                }
                wVar.f3336a = true;
            }
        }
    }
}
