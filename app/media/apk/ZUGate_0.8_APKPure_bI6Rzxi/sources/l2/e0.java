package l2;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class e0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f3799a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public int f3800b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3801c;

    /* renamed from: d  reason: collision with root package name */
    public IBinder f3802d;

    /* renamed from: e  reason: collision with root package name */
    public final d0 f3803e;

    /* renamed from: f  reason: collision with root package name */
    public ComponentName f3804f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ g0 f3805g;

    public e0(g0 g0Var, d0 d0Var) {
        this.f3805g = g0Var;
        this.f3803e = d0Var;
    }

    public final void a(String str, Executor executor) {
        StrictMode.VmPolicy.Builder permitUnsafeIntentLaunch;
        this.f3800b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (Build.VERSION.SDK_INT >= 31) {
            permitUnsafeIntentLaunch = new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch();
            StrictMode.setVmPolicy(permitUnsafeIntentLaunch.build());
        }
        try {
            g0 g0Var = this.f3805g;
            o2.a aVar = g0Var.f3837d;
            Context context = g0Var.f3835b;
            boolean b5 = aVar.b(context, str, this.f3803e.a(context), this, executor);
            this.f3801c = b5;
            if (b5) {
                this.f3805g.f3836c.sendMessageDelayed(this.f3805g.f3836c.obtainMessage(1, this.f3803e), this.f3805g.f3839f);
            } else {
                this.f3800b = 2;
                try {
                    g0 g0Var2 = this.f3805g;
                    g0Var2.f3837d.a(g0Var2.f3835b, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f3805g.f3834a) {
            this.f3805g.f3836c.removeMessages(1, this.f3803e);
            this.f3802d = iBinder;
            this.f3804f = componentName;
            for (ServiceConnection serviceConnection : this.f3799a.values()) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.f3800b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f3805g.f3834a) {
            this.f3805g.f3836c.removeMessages(1, this.f3803e);
            this.f3802d = null;
            this.f3804f = componentName;
            for (ServiceConnection serviceConnection : this.f3799a.values()) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.f3800b = 2;
        }
    }
}
