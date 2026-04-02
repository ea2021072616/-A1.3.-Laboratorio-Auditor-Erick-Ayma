package r3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: e  reason: collision with root package name */
    public static r f4546e;

    /* renamed from: a  reason: collision with root package name */
    public final Object f4547a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final Handler f4548b = new Handler(Looper.getMainLooper(), new p(this));

    /* renamed from: c  reason: collision with root package name */
    public q f4549c;

    /* renamed from: d  reason: collision with root package name */
    public q f4550d;

    public static r b() {
        if (f4546e == null) {
            f4546e = new r();
        }
        return f4546e;
    }

    public final boolean a(q qVar, int i5) {
        i iVar = (i) qVar.f4543a.get();
        if (iVar != null) {
            this.f4548b.removeCallbacksAndMessages(qVar);
            Handler handler = l.f4517x;
            handler.sendMessage(handler.obtainMessage(1, i5, 0, iVar.f4502a));
            return true;
        }
        return false;
    }

    public final boolean c(i iVar) {
        q qVar = this.f4549c;
        if (qVar != null) {
            return iVar != null && qVar.f4543a.get() == iVar;
        }
        return false;
    }

    public final void d(q qVar) {
        int i5 = qVar.f4544b;
        if (i5 == -2) {
            return;
        }
        if (i5 <= 0) {
            i5 = i5 == -1 ? 1500 : 2750;
        }
        Handler handler = this.f4548b;
        handler.removeCallbacksAndMessages(qVar);
        handler.sendMessageDelayed(Message.obtain(handler, 0, qVar), i5);
    }

    public final void e() {
        q qVar = this.f4550d;
        if (qVar != null) {
            this.f4549c = qVar;
            this.f4550d = null;
            i iVar = (i) qVar.f4543a.get();
            if (iVar == null) {
                this.f4549c = null;
                return;
            }
            Handler handler = l.f4517x;
            handler.sendMessage(handler.obtainMessage(0, iVar.f4502a));
        }
    }
}
