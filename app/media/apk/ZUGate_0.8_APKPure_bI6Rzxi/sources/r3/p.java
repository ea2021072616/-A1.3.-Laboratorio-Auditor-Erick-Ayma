package r3;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public final class p implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f4542a;

    public p(r rVar) {
        this.f4542a = rVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        r rVar = this.f4542a;
        q qVar = (q) message.obj;
        synchronized (rVar.f4547a) {
            if (rVar.f4549c == qVar || rVar.f4550d == qVar) {
                rVar.a(qVar, 2);
            }
        }
        return true;
    }
}
