package n2;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.internal.play_billing.i0;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import k2.t;
import k2.v;
import k2.y;
import l2.h0;
import l2.i;
import l2.k;
import v2.g;
/* loaded from: classes.dex */
public final class d extends j2.e {

    /* renamed from: i  reason: collision with root package name */
    public static final d.e f4087i = new d.e(new c(0), new z0.d(17));

    public d(Context context) {
        super(context, f4087i, j2.d.f3440b);
    }

    public final g b(k kVar) {
        t tVar;
        h1.e eVar = new h1.e(0);
        i2.c[] cVarArr = {i0.f1889f};
        eVar.f3274e = cVarArr;
        eVar.f3271b = false;
        eVar.f3273d = new b(kVar);
        h1.e eVar2 = new h1.e(eVar, cVarArr, false, eVar.f3272c);
        v2.c cVar = new v2.c();
        k2.d dVar = this.f3449h;
        dVar.getClass();
        int i5 = eVar2.f3272c;
        final r2.d dVar2 = dVar.f3589m;
        g gVar = cVar.f5205a;
        if (i5 != 0) {
            k2.a aVar = this.f3446e;
            if (dVar.a()) {
                i.d().getClass();
                tVar = new t(dVar, i5, aVar, System.currentTimeMillis(), SystemClock.elapsedRealtime());
            } else {
                tVar = null;
            }
            if (tVar != null) {
                dVar2.getClass();
                Executor executor = new Executor() { // from class: k2.k
                    @Override // java.util.concurrent.Executor
                    public final void execute(Runnable runnable) {
                        dVar2.post(runnable);
                    }
                };
                gVar.getClass();
                v2.e eVar3 = new v2.e(executor, tVar);
                h0 h0Var = gVar.f5211b;
                synchronized (h0Var.f3851b) {
                    if (((Queue) h0Var.f3852c) == null) {
                        h0Var.f3852c = new ArrayDeque();
                    }
                    ((Queue) h0Var.f3852c).add(eVar3);
                }
                synchronized (gVar.f5210a) {
                    if (gVar.f5212c) {
                        gVar.f5211b.a(gVar);
                    }
                }
            }
        }
        dVar2.sendMessage(dVar2.obtainMessage(4, new v(new y(eVar2, cVar, this.f3448g), dVar.f3585i.get(), this)));
        return gVar;
    }
}
