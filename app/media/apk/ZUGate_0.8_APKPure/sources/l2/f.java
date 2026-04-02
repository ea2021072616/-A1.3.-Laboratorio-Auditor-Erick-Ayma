package l2;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class f implements j2.b {

    /* renamed from: y  reason: collision with root package name */
    public static final i2.c[] f3806y = new i2.c[0];

    /* renamed from: a  reason: collision with root package name */
    public volatile String f3807a;

    /* renamed from: b  reason: collision with root package name */
    public h0 f3808b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f3809c;

    /* renamed from: d  reason: collision with root package name */
    public final g0 f3810d;

    /* renamed from: e  reason: collision with root package name */
    public final w f3811e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f3812f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f3813g;

    /* renamed from: h  reason: collision with root package name */
    public u f3814h;

    /* renamed from: i  reason: collision with root package name */
    public b f3815i;

    /* renamed from: j  reason: collision with root package name */
    public IInterface f3816j;

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f3817k;

    /* renamed from: l  reason: collision with root package name */
    public y f3818l;

    /* renamed from: m  reason: collision with root package name */
    public int f3819m;

    /* renamed from: n  reason: collision with root package name */
    public final androidx.recyclerview.widget.b0 f3820n;
    public final androidx.recyclerview.widget.b0 o;

    /* renamed from: p  reason: collision with root package name */
    public final int f3821p;

    /* renamed from: q  reason: collision with root package name */
    public final String f3822q;

    /* renamed from: r  reason: collision with root package name */
    public volatile String f3823r;

    /* renamed from: s  reason: collision with root package name */
    public i2.a f3824s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f3825t;

    /* renamed from: u  reason: collision with root package name */
    public volatile b0 f3826u;

    /* renamed from: v  reason: collision with root package name */
    public final AtomicInteger f3827v;

    /* renamed from: w  reason: collision with root package name */
    public final Set f3828w;

    /* renamed from: x  reason: collision with root package name */
    public final Account f3829x;

    public f(Context context, Looper looper, int i5, c cVar, k2.c cVar2, k2.h hVar) {
        synchronized (g0.f3831h) {
            if (g0.f3832i == null) {
                g0.f3832i = new g0(context.getApplicationContext(), context.getMainLooper());
            }
        }
        g0 g0Var = g0.f3832i;
        Object obj = i2.d.f3390b;
        com.google.android.gms.internal.play_billing.i0.j(cVar2);
        com.google.android.gms.internal.play_billing.i0.j(hVar);
        androidx.recyclerview.widget.b0 b0Var = new androidx.recyclerview.widget.b0(cVar2);
        androidx.recyclerview.widget.b0 b0Var2 = new androidx.recyclerview.widget.b0(hVar);
        String str = cVar.f3770e;
        this.f3807a = null;
        this.f3812f = new Object();
        this.f3813g = new Object();
        this.f3817k = new ArrayList();
        this.f3819m = 1;
        this.f3824s = null;
        this.f3825t = false;
        this.f3826u = null;
        this.f3827v = new AtomicInteger(0);
        if (context == null) {
            throw new NullPointerException("Context must not be null");
        }
        this.f3809c = context;
        if (looper == null) {
            throw new NullPointerException("Looper must not be null");
        }
        com.google.android.gms.internal.play_billing.i0.i(g0Var, "Supervisor must not be null");
        this.f3810d = g0Var;
        this.f3811e = new w(this, looper);
        this.f3821p = i5;
        this.f3820n = b0Var;
        this.o = b0Var2;
        this.f3822q = str;
        this.f3829x = cVar.f3766a;
        Set<Scope> set = cVar.f3768c;
        for (Scope scope : set) {
            if (!set.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f3828w = set;
    }

    public static /* bridge */ /* synthetic */ boolean r(f fVar, int i5, int i6, IInterface iInterface) {
        synchronized (fVar.f3812f) {
            if (fVar.f3819m != i5) {
                return false;
            }
            fVar.s(i6, iInterface);
            return true;
        }
    }

    @Override // j2.b
    public final void a() {
        this.f3827v.incrementAndGet();
        synchronized (this.f3817k) {
            try {
                int size = this.f3817k.size();
                for (int i5 = 0; i5 < size; i5++) {
                    s sVar = (s) this.f3817k.get(i5);
                    synchronized (sVar) {
                        sVar.f3886a = null;
                    }
                }
                this.f3817k.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f3813g) {
            this.f3814h = null;
        }
        s(1, null);
    }

    @Override // j2.b
    public final Set b() {
        return e() ? this.f3828w : Collections.emptySet();
    }

    @Override // j2.b
    public final void d(String str) {
        this.f3807a = str;
        a();
    }

    @Override // j2.b
    public /* bridge */ /* synthetic */ boolean e() {
        return false;
    }

    @Override // j2.b
    public final void h(g gVar, Set set) {
        Bundle k5 = k();
        String str = this.f3823r;
        int i5 = i2.e.f3392a;
        Scope[] scopeArr = e.f3784p;
        Bundle bundle = new Bundle();
        int i6 = this.f3821p;
        i2.c[] cVarArr = e.f3785q;
        e eVar = new e(6, i6, i5, null, null, scopeArr, bundle, null, cVarArr, cVarArr, true, 0, false, str);
        eVar.f3789e = this.f3809c.getPackageName();
        eVar.f3792h = k5;
        if (set != null) {
            eVar.f3791g = (Scope[]) set.toArray(new Scope[0]);
        }
        if (e()) {
            Account account = this.f3829x;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            eVar.f3793i = account;
            if (gVar != null) {
                eVar.f3790f = ((i0) gVar).f3860a;
            }
        }
        eVar.f3794j = f3806y;
        eVar.f3795k = j();
        try {
            synchronized (this.f3813g) {
                u uVar = this.f3814h;
                if (uVar != null) {
                    uVar.a(new x(this, this.f3827v.get()), eVar);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e5) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e5);
            int i7 = this.f3827v.get();
            w wVar = this.f3811e;
            wVar.sendMessage(wVar.obtainMessage(6, i7, 3));
        } catch (RemoteException e6) {
            e = e6;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i8 = this.f3827v.get();
            z zVar = new z(this, 8, null, null);
            w wVar2 = this.f3811e;
            wVar2.sendMessage(wVar2.obtainMessage(1, i8, -1, zVar));
        } catch (SecurityException e7) {
            throw e7;
        } catch (RuntimeException e8) {
            e = e8;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i82 = this.f3827v.get();
            z zVar2 = new z(this, 8, null, null);
            w wVar22 = this.f3811e;
            wVar22.sendMessage(wVar22.obtainMessage(1, i82, -1, zVar2));
        }
    }

    public abstract IInterface i(IBinder iBinder);

    public /* bridge */ /* synthetic */ i2.c[] j() {
        return f3806y;
    }

    public abstract Bundle k();

    public final IInterface l() {
        IInterface iInterface;
        synchronized (this.f3812f) {
            if (this.f3819m == 5) {
                throw new DeadObjectException();
            }
            if (!p()) {
                throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            }
            iInterface = this.f3816j;
            com.google.android.gms.internal.play_billing.i0.i(iInterface, "Client is connected but service is null");
        }
        return iInterface;
    }

    public abstract String m();

    public abstract String n();

    public boolean o() {
        return g() >= 211700000;
    }

    public final boolean p() {
        boolean z4;
        synchronized (this.f3812f) {
            z4 = this.f3819m == 4;
        }
        return z4;
    }

    public final boolean q() {
        boolean z4;
        synchronized (this.f3812f) {
            int i5 = this.f3819m;
            z4 = i5 == 2 || i5 == 3;
        }
        return z4;
    }

    public final void s(int i5, IInterface iInterface) {
        h0 h0Var;
        if (!((i5 == 4) == (iInterface != null))) {
            throw new IllegalArgumentException();
        }
        synchronized (this.f3812f) {
            this.f3819m = i5;
            this.f3816j = iInterface;
            if (i5 == 1) {
                y yVar = this.f3818l;
                if (yVar != null) {
                    g0 g0Var = this.f3810d;
                    String str = (String) this.f3808b.f3851b;
                    com.google.android.gms.internal.play_billing.i0.j(str);
                    String str2 = (String) this.f3808b.f3852c;
                    if (this.f3822q == null) {
                        this.f3809c.getClass();
                    }
                    g0Var.a(str, str2, yVar, this.f3808b.f3850a);
                    this.f3818l = null;
                }
            } else if (i5 == 2 || i5 == 3) {
                y yVar2 = this.f3818l;
                if (yVar2 != null && (h0Var = this.f3808b) != null) {
                    Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + ((String) h0Var.f3851b) + " on " + ((String) h0Var.f3852c));
                    g0 g0Var2 = this.f3810d;
                    String str3 = (String) this.f3808b.f3851b;
                    com.google.android.gms.internal.play_billing.i0.j(str3);
                    String str4 = (String) this.f3808b.f3852c;
                    if (this.f3822q == null) {
                        this.f3809c.getClass();
                    }
                    g0Var2.a(str3, str4, yVar2, this.f3808b.f3850a);
                    this.f3827v.incrementAndGet();
                }
                y yVar3 = new y(this, this.f3827v.get());
                this.f3818l = yVar3;
                h0 h0Var2 = new h0(n(), o());
                this.f3808b = h0Var2;
                if (h0Var2.f3850a && g() < 17895000) {
                    throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf((String) this.f3808b.f3851b)));
                }
                g0 g0Var3 = this.f3810d;
                String str5 = (String) this.f3808b.f3851b;
                com.google.android.gms.internal.play_billing.i0.j(str5);
                String str6 = (String) this.f3808b.f3852c;
                String str7 = this.f3822q;
                if (str7 == null) {
                    str7 = this.f3809c.getClass().getName();
                }
                if (!g0Var3.b(new d0(str5, str6, this.f3808b.f3850a), yVar3, str7)) {
                    h0 h0Var3 = this.f3808b;
                    Log.w("GmsClient", "unable to connect to service: " + ((String) h0Var3.f3851b) + " on " + ((String) h0Var3.f3852c));
                    int i6 = this.f3827v.get();
                    a0 a0Var = new a0(this, 16);
                    w wVar = this.f3811e;
                    wVar.sendMessage(wVar.obtainMessage(7, i6, -1, a0Var));
                }
            } else if (i5 == 4) {
                com.google.android.gms.internal.play_billing.i0.j(iInterface);
                System.currentTimeMillis();
            }
        }
    }
}
