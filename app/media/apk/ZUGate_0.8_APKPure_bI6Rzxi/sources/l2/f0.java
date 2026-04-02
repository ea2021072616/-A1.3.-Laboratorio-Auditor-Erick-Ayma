package l2;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
/* loaded from: classes.dex */
public final class f0 implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0 f3830a;

    public /* synthetic */ f0(g0 g0Var) {
        this.f3830a = g0Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i5 = message.what;
        if (i5 == 0) {
            synchronized (this.f3830a.f3834a) {
                try {
                    d0 d0Var = (d0) message.obj;
                    e0 e0Var = (e0) this.f3830a.f3834a.get(d0Var);
                    if (e0Var != null && e0Var.f3799a.isEmpty()) {
                        if (e0Var.f3801c) {
                            e0Var.f3805g.f3836c.removeMessages(1, e0Var.f3803e);
                            g0 g0Var = e0Var.f3805g;
                            g0Var.f3837d.a(g0Var.f3835b, e0Var);
                            e0Var.f3801c = false;
                            e0Var.f3800b = 2;
                        }
                        this.f3830a.f3834a.remove(d0Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        } else if (i5 != 1) {
            return false;
        } else {
            synchronized (this.f3830a.f3834a) {
                d0 d0Var2 = (d0) message.obj;
                e0 e0Var2 = (e0) this.f3830a.f3834a.get(d0Var2);
                if (e0Var2 != null && e0Var2.f3800b == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(d0Var2)), new Exception());
                    ComponentName componentName = e0Var2.f3804f;
                    if (componentName == null) {
                        d0Var2.getClass();
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = d0Var2.f3782b;
                        com.google.android.gms.internal.play_billing.i0.j(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    e0Var2.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
    }
}
