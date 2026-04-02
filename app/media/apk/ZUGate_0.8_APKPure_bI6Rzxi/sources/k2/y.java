package k2;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.appcompat.widget.d0;
import com.google.android.gms.common.api.Status;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import l2.h0;
/* loaded from: classes.dex */
public final class y extends s {

    /* renamed from: b  reason: collision with root package name */
    public final h1.e f3636b;

    /* renamed from: c  reason: collision with root package name */
    public final v2.c f3637c;

    /* renamed from: d  reason: collision with root package name */
    public final z0.d f3638d;

    public y(h1.e eVar, v2.c cVar, z0.d dVar) {
        super(2);
        this.f3637c = cVar;
        this.f3636b = eVar;
        this.f3638d = dVar;
        if (eVar.f3271b) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // k2.s
    public final boolean a(o oVar) {
        return this.f3636b.f3271b;
    }

    @Override // k2.s
    public final i2.c[] b(o oVar) {
        return (i2.c[]) this.f3636b.f3273d;
    }

    @Override // k2.s
    public final void c(Status status) {
        this.f3638d.getClass();
        this.f3637c.a(status.f1827d != null ? new j2.h(status) : new j2.c(status));
    }

    @Override // k2.s
    public final void d(RuntimeException runtimeException) {
        this.f3637c.a(runtimeException);
    }

    @Override // k2.s
    public final void e(o oVar) {
        v2.c cVar = this.f3637c;
        try {
            this.f3636b.b(oVar.f3598b, cVar);
        } catch (DeadObjectException e5) {
            throw e5;
        } catch (RemoteException e6) {
            c(s.g(e6));
        } catch (RuntimeException e7) {
            cVar.a(e7);
        }
    }

    @Override // k2.s
    public final void f(d0 d0Var, boolean z4) {
        Boolean valueOf = Boolean.valueOf(z4);
        v2.c cVar = this.f3637c;
        ((Map) d0Var.f307i).put(cVar, valueOf);
        v2.g gVar = cVar.f5205a;
        d0 d0Var2 = new d0(d0Var, cVar, 18);
        gVar.getClass();
        v2.e eVar = new v2.e(v2.d.f5206a, d0Var2);
        h0 h0Var = gVar.f5211b;
        synchronized (h0Var.f3851b) {
            if (((Queue) h0Var.f3852c) == null) {
                h0Var.f3852c = new ArrayDeque();
            }
            ((Queue) h0Var.f3852c).add(eVar);
        }
        synchronized (gVar.f5210a) {
            if (gVar.f5212c) {
                gVar.f5211b.a(gVar);
            }
        }
    }
}
