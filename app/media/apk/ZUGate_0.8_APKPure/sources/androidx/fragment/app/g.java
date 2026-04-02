package androidx.fragment.app;

import android.accounts.Account;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.play_billing.d3;
import d2.k;
import h0.h;
import java.util.HashMap;
import java.util.logging.Logger;
import x1.i;
import y1.g;
/* loaded from: classes.dex */
public final class g implements d0.b {

    /* renamed from: g  reason: collision with root package name */
    public Object f889g;

    /* renamed from: h  reason: collision with root package name */
    public Object f890h;

    /* renamed from: i  reason: collision with root package name */
    public Object f891i;

    /* renamed from: j  reason: collision with root package name */
    public Object f892j;

    /* renamed from: k  reason: collision with root package name */
    public Object f893k;

    public g(int i5) {
        if (i5 != 4) {
            return;
        }
        this.f893k = t2.a.f5026a;
    }

    public final l2.c a() {
        return new l2.c((Account) this.f889g, (l.c) this.f890h, (String) this.f891i, (String) this.f892j, (t2.a) this.f893k);
    }

    public final void b(u1.a aVar) {
        final h0.h hVar = new h0.h(8);
        x1.n nVar = (x1.n) this.f893k;
        g gVar = new g(1);
        x1.i iVar = (x1.i) this.f889g;
        if (iVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        gVar.f889g = iVar;
        gVar.f891i = aVar;
        String str = (String) this.f890h;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        gVar.f890h = str;
        z0.d dVar = (z0.d) this.f892j;
        if (dVar == null) {
            throw new NullPointerException("Null transformer");
        }
        gVar.f892j = dVar;
        u1.b bVar = (u1.b) this.f891i;
        if (bVar == null) {
            throw new NullPointerException("Null encoding");
        }
        gVar.f893k = bVar;
        if (!"".isEmpty()) {
            throw new IllegalStateException("Missing required properties:".concat(""));
        }
        x1.i iVar2 = (x1.i) gVar.f889g;
        u1.a aVar2 = (u1.a) gVar.f891i;
        x1.o oVar = (x1.o) nVar;
        oVar.getClass();
        aVar2.getClass();
        u1.c cVar = u1.c.DEFAULT;
        iVar2.getClass();
        d.e a5 = x1.i.a();
        a5.o(iVar2.f5461a);
        a5.p(cVar);
        a5.f2322i = iVar2.f5462b;
        final x1.i b5 = a5.b();
        androidx.appcompat.widget.x xVar = new androidx.appcompat.widget.x(2);
        xVar.f575f = new HashMap();
        xVar.f573d = Long.valueOf(((f2.b) oVar.f5474a).a());
        xVar.f574e = Long.valueOf(((f2.b) oVar.f5475b).a());
        xVar.j((String) gVar.f890h);
        ((z0.d) gVar.f892j).getClass();
        xVar.h(new x1.l((u1.b) gVar.f893k, ((d3) aVar2.f5130a).b()));
        xVar.f571b = null;
        final x1.h c5 = xVar.c();
        final b2.b bVar2 = (b2.b) oVar.f5476c;
        bVar2.getClass();
        bVar2.f1625b.execute(new Runnable() { // from class: b2.a
            @Override // java.lang.Runnable
            public final void run() {
                i iVar3 = b5;
                h hVar2 = hVar;
                x1.h hVar3 = c5;
                b bVar3 = b.this;
                bVar3.getClass();
                Logger logger = b.f1623f;
                try {
                    g a6 = bVar3.f1626c.a(iVar3.f5461a);
                    if (a6 == null) {
                        String format = String.format("Transport backend '%s' is not registered", iVar3.f5461a);
                        logger.warning(format);
                        new IllegalArgumentException(format);
                        hVar2.getClass();
                    } else {
                        ((k) bVar3.f1628e).J(new e1.h(bVar3, iVar3, ((v1.d) a6).a(hVar3), 1));
                        hVar2.getClass();
                    }
                } catch (Exception e5) {
                    logger.warning("Error scheduling event " + e5.getMessage());
                    hVar2.getClass();
                }
            }
        });
    }

    @Override // d0.b
    public final void c() {
        ((View) this.f889g).clearAnimation();
        ((ViewGroup) this.f890h).endViewTransition((View) this.f889g);
        ((k) this.f891i).a();
        if (w0.I(2)) {
            Log.v("FragmentManager", "Animation from operation " + ((s1) this.f892j) + " has been cancelled.");
        }
    }

    public g(x1.i iVar, u1.b bVar, z0.d dVar, x1.n nVar) {
        this.f889g = iVar;
        this.f890h = "PLAY_BILLING_LIBRARY";
        this.f891i = bVar;
        this.f892j = dVar;
        this.f893k = nVar;
    }

    public g(View view, ViewGroup viewGroup, k kVar, n nVar, s1 s1Var) {
        this.f893k = nVar;
        this.f889g = view;
        this.f890h = viewGroup;
        this.f891i = kVar;
        this.f892j = s1Var;
    }
}
