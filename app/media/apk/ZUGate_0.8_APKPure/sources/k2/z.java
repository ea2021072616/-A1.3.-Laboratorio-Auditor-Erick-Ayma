package k2;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.appcompat.widget.d0;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class z extends s {

    /* renamed from: b  reason: collision with root package name */
    public final v2.c f3639b;

    public z(v2.c cVar) {
        super(4);
        this.f3639b = cVar;
    }

    @Override // k2.s
    public final boolean a(o oVar) {
        androidx.appcompat.widget.b0.n(oVar.f3602f.get(null));
        return false;
    }

    @Override // k2.s
    public final i2.c[] b(o oVar) {
        androidx.appcompat.widget.b0.n(oVar.f3602f.get(null));
        return null;
    }

    @Override // k2.s
    public final void c(Status status) {
        this.f3639b.a(new j2.c(status));
    }

    @Override // k2.s
    public final void d(RuntimeException runtimeException) {
        this.f3639b.a(runtimeException);
    }

    @Override // k2.s
    public final void e(o oVar) {
        try {
            h(oVar);
        } catch (DeadObjectException e5) {
            c(s.g(e5));
            throw e5;
        } catch (RemoteException e6) {
            c(s.g(e6));
        } catch (RuntimeException e7) {
            this.f3639b.a(e7);
        }
    }

    @Override // k2.s
    public final /* bridge */ /* synthetic */ void f(d0 d0Var, boolean z4) {
    }

    public final void h(o oVar) {
        androidx.appcompat.widget.b0.n(oVar.f3602f.remove(null));
        v2.c cVar = this.f3639b;
        Boolean bool = Boolean.FALSE;
        v2.g gVar = cVar.f5205a;
        synchronized (gVar.f5210a) {
            if (gVar.f5212c) {
                return;
            }
            gVar.f5212c = true;
            gVar.f5213d = bool;
            gVar.f5211b.a(gVar);
        }
    }
}
