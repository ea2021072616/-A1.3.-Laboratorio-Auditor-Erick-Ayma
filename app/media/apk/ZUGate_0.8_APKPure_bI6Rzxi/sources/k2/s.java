package k2;

import android.os.RemoteException;
import androidx.appcompat.widget.d0;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    public final int f3613a;

    public s(int i5) {
        this.f3613a = i5;
    }

    public static Status g(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage(), null, null);
    }

    public abstract boolean a(o oVar);

    public abstract i2.c[] b(o oVar);

    public abstract void c(Status status);

    public abstract void d(RuntimeException runtimeException);

    public abstract void e(o oVar);

    public abstract void f(d0 d0Var, boolean z4);
}
