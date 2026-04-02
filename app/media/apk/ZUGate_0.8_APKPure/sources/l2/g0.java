package l2;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: h  reason: collision with root package name */
    public static final Object f3831h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public static g0 f3832i;

    /* renamed from: j  reason: collision with root package name */
    public static HandlerThread f3833j;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f3834a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Context f3835b;

    /* renamed from: c  reason: collision with root package name */
    public volatile r2.d f3836c;

    /* renamed from: d  reason: collision with root package name */
    public final o2.a f3837d;

    /* renamed from: e  reason: collision with root package name */
    public final long f3838e;

    /* renamed from: f  reason: collision with root package name */
    public final long f3839f;

    /* renamed from: g  reason: collision with root package name */
    public volatile Executor f3840g;

    public g0(Context context, Looper looper) {
        f0 f0Var = new f0(this);
        this.f3835b = context.getApplicationContext();
        this.f3836c = new r2.d(looper, f0Var, 1);
        if (o2.a.f4102c == null) {
            synchronized (o2.a.f4101b) {
                if (o2.a.f4102c == null) {
                    o2.a.f4102c = new o2.a();
                }
            }
        }
        o2.a aVar = o2.a.f4102c;
        com.google.android.gms.internal.play_billing.i0.j(aVar);
        this.f3837d = aVar;
        this.f3838e = 5000L;
        this.f3839f = 300000L;
        this.f3840g = null;
    }

    public final void a(String str, String str2, y yVar, boolean z4) {
        d0 d0Var = new d0(str, str2, z4);
        synchronized (this.f3834a) {
            e0 e0Var = (e0) this.f3834a.get(d0Var);
            if (e0Var == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: ".concat(d0Var.toString()));
            }
            if (!e0Var.f3799a.containsKey(yVar)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(d0Var.toString()));
            }
            e0Var.f3799a.remove(yVar);
            if (e0Var.f3799a.isEmpty()) {
                this.f3836c.sendMessageDelayed(this.f3836c.obtainMessage(0, d0Var), this.f3838e);
            }
        }
    }

    public final boolean b(d0 d0Var, y yVar, String str) {
        boolean z4;
        synchronized (this.f3834a) {
            try {
                e0 e0Var = (e0) this.f3834a.get(d0Var);
                Executor executor = this.f3840g;
                if (e0Var == null) {
                    e0Var = new e0(this, d0Var);
                    e0Var.f3799a.put(yVar, yVar);
                    e0Var.a(str, executor);
                    this.f3834a.put(d0Var, e0Var);
                } else {
                    this.f3836c.removeMessages(0, d0Var);
                    if (e0Var.f3799a.containsKey(yVar)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(d0Var.toString()));
                    }
                    e0Var.f3799a.put(yVar, yVar);
                    int i5 = e0Var.f3800b;
                    if (i5 == 1) {
                        yVar.onServiceConnected(e0Var.f3804f, e0Var.f3802d);
                    } else if (i5 == 2) {
                        e0Var.a(str, executor);
                    }
                }
                z4 = e0Var.f3801c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z4;
    }
}
