package d;

import android.content.IntentFilter;
/* loaded from: classes.dex */
public abstract class k0 {

    /* renamed from: a  reason: collision with root package name */
    public j0 f2370a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n0 f2371b;

    public k0(n0 n0Var) {
        this.f2371b = n0Var;
    }

    public final void a() {
        j0 j0Var = this.f2370a;
        if (j0Var != null) {
            try {
                this.f2371b.f2432q.unregisterReceiver(j0Var);
            } catch (IllegalArgumentException unused) {
            }
            this.f2370a = null;
        }
    }

    public abstract int b();

    public final void c() {
        IntentFilter intentFilter;
        a();
        switch (((i0) this).f2363c) {
            case 0:
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                break;
            default:
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.TIME_SET");
                intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter.addAction("android.intent.action.TIME_TICK");
                break;
        }
        if (intentFilter.countActions() == 0) {
            return;
        }
        if (this.f2370a == null) {
            this.f2370a = new j0(0, this);
        }
        this.f2371b.f2432q.registerReceiver(this.f2370a, intentFilter);
    }
}
