package k2;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.appcompat.widget.d0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.play_billing.i0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
/* loaded from: classes.dex */
public final class o implements j2.f, j2.g {

    /* renamed from: b  reason: collision with root package name */
    public final l2.f f3598b;

    /* renamed from: c  reason: collision with root package name */
    public final a f3599c;

    /* renamed from: d  reason: collision with root package name */
    public final d0 f3600d;

    /* renamed from: g  reason: collision with root package name */
    public final int f3603g;

    /* renamed from: h  reason: collision with root package name */
    public final x f3604h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3605i;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ d f3608l;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList f3597a = new LinkedList();

    /* renamed from: e  reason: collision with root package name */
    public final HashSet f3601e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f3602f = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList f3606j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public i2.a f3607k = null;

    public o(d dVar, j2.e eVar) {
        this.f3608l = dVar;
        Looper looper = dVar.f3589m.getLooper();
        l2.c a5 = eVar.a().a();
        p2.a aVar = (p2.a) eVar.f3444c.f2321h;
        i0.j(aVar);
        l2.f f5 = aVar.f(eVar.f3442a, looper, a5, eVar.f3445d, this, this);
        String str = eVar.f3443b;
        if (str != null) {
            f5.f3823r = str;
        }
        this.f3598b = f5;
        this.f3599c = eVar.f3446e;
        this.f3600d = new d0(19);
        this.f3603g = eVar.f3447f;
        if (f5.e()) {
            this.f3604h = new x(dVar.f3581e, dVar.f3589m, eVar.a().a());
        } else {
            this.f3604h = null;
        }
    }

    @Override // k2.h
    public final void a(i2.a aVar) {
        o(aVar, null);
    }

    @Override // k2.c
    public final void b(int i5) {
        Looper myLooper = Looper.myLooper();
        d dVar = this.f3608l;
        if (myLooper == dVar.f3589m.getLooper()) {
            i(i5);
        } else {
            dVar.f3589m.post(new m(i5, 0, this));
        }
    }

    @Override // k2.c
    public final void c() {
        Looper myLooper = Looper.myLooper();
        d dVar = this.f3608l;
        if (myLooper == dVar.f3589m.getLooper()) {
            h();
        } else {
            dVar.f3589m.post(new w(1, this));
        }
    }

    public final void d(i2.a aVar) {
        HashSet hashSet = this.f3601e;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
            return;
        }
        androidx.appcompat.widget.b0.n(it.next());
        if (b4.j.p(aVar, i2.a.f3379f)) {
            l2.f fVar = this.f3598b;
            if (!fVar.p() || fVar.f3808b == null) {
                throw new RuntimeException("Failed to connect when checking package");
            }
        }
        throw null;
    }

    public final void e(Status status) {
        i0.g(this.f3608l.f3589m);
        f(status, null, false);
    }

    public final void f(Status status, RuntimeException runtimeException, boolean z4) {
        i0.g(this.f3608l.f3589m);
        if ((status == null) == (runtimeException == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f3597a.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (!z4 || sVar.f3613a == 2) {
                if (status != null) {
                    sVar.c(status);
                } else {
                    sVar.d(runtimeException);
                }
                it.remove();
            }
        }
    }

    public final void g() {
        LinkedList linkedList = this.f3597a;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            s sVar = (s) arrayList.get(i5);
            if (!this.f3598b.p()) {
                return;
            }
            if (k(sVar)) {
                linkedList.remove(sVar);
            }
        }
    }

    public final void h() {
        d dVar = this.f3608l;
        i0.g(dVar.f3589m);
        this.f3607k = null;
        d(i2.a.f3379f);
        if (this.f3605i) {
            r2.d dVar2 = dVar.f3589m;
            a aVar = this.f3599c;
            dVar2.removeMessages(11, aVar);
            dVar.f3589m.removeMessages(9, aVar);
            this.f3605i = false;
        }
        Iterator it = this.f3602f.values().iterator();
        if (it.hasNext()) {
            androidx.appcompat.widget.b0.n(it.next());
            throw null;
        }
        g();
        j();
    }

    public final void i(int i5) {
        i0.g(this.f3608l.f3589m);
        this.f3607k = null;
        this.f3605i = true;
        String str = this.f3598b.f3807a;
        d0 d0Var = this.f3600d;
        d0Var.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i5 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i5 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        d0Var.q(true, new Status(20, sb.toString(), null, null));
        a aVar = this.f3599c;
        r2.d dVar = this.f3608l.f3589m;
        dVar.sendMessageDelayed(Message.obtain(dVar, 9, aVar), 5000L);
        a aVar2 = this.f3599c;
        r2.d dVar2 = this.f3608l.f3589m;
        dVar2.sendMessageDelayed(Message.obtain(dVar2, 11, aVar2), 120000L);
        ((SparseIntArray) this.f3608l.f3583g.f306h).clear();
        Iterator it = this.f3602f.values().iterator();
        if (it.hasNext()) {
            androidx.appcompat.widget.b0.n(it.next());
            throw null;
        }
    }

    public final void j() {
        d dVar = this.f3608l;
        r2.d dVar2 = dVar.f3589m;
        a aVar = this.f3599c;
        dVar2.removeMessages(12, aVar);
        r2.d dVar3 = dVar.f3589m;
        dVar3.sendMessageDelayed(dVar3.obtainMessage(12, aVar), dVar.f3577a);
    }

    public final boolean k(s sVar) {
        i2.c cVar;
        if (!(sVar instanceof s)) {
            l2.f fVar = this.f3598b;
            sVar.f(this.f3600d, fVar.e());
            try {
                sVar.e(this);
            } catch (DeadObjectException unused) {
                b(1);
                fVar.d("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        i2.c[] b5 = sVar.b(this);
        if (b5 != null && b5.length != 0) {
            l2.b0 b0Var = this.f3598b.f3826u;
            i2.c[] cVarArr = b0Var == null ? null : b0Var.f3763c;
            if (cVarArr == null) {
                cVarArr = new i2.c[0];
            }
            l.b bVar = new l.b(cVarArr.length);
            for (i2.c cVar2 : cVarArr) {
                bVar.put(cVar2.f3387b, Long.valueOf(cVar2.a()));
            }
            int length = b5.length;
            for (int i5 = 0; i5 < length; i5++) {
                cVar = b5[i5];
                Long l5 = (Long) bVar.getOrDefault(cVar.f3387b, null);
                if (l5 == null || l5.longValue() < cVar.a()) {
                    break;
                }
            }
        }
        cVar = null;
        if (cVar == null) {
            l2.f fVar2 = this.f3598b;
            sVar.f(this.f3600d, fVar2.e());
            try {
                sVar.e(this);
            } catch (DeadObjectException unused2) {
                b(1);
                fVar2.d("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        Log.w("GoogleApiManager", this.f3598b.getClass().getName() + " could not execute call because it requires feature (" + cVar.f3387b + ", " + cVar.a() + ").");
        if (!this.f3608l.f3590n || !sVar.a(this)) {
            sVar.d(new j2.i(cVar));
            return true;
        }
        p pVar = new p(this.f3599c, cVar);
        int indexOf = this.f3606j.indexOf(pVar);
        if (indexOf >= 0) {
            p pVar2 = (p) this.f3606j.get(indexOf);
            this.f3608l.f3589m.removeMessages(15, pVar2);
            r2.d dVar = this.f3608l.f3589m;
            dVar.sendMessageDelayed(Message.obtain(dVar, 15, pVar2), 5000L);
        } else {
            this.f3606j.add(pVar);
            r2.d dVar2 = this.f3608l.f3589m;
            dVar2.sendMessageDelayed(Message.obtain(dVar2, 15, pVar), 5000L);
            r2.d dVar3 = this.f3608l.f3589m;
            dVar3.sendMessageDelayed(Message.obtain(dVar3, 16, pVar), 120000L);
            i2.a aVar = new i2.a(2, null);
            if (!l(aVar)) {
                this.f3608l.b(aVar, this.f3603g);
            }
        }
        return false;
    }

    public final boolean l(i2.a aVar) {
        synchronized (d.f3575q) {
            this.f3608l.getClass();
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [t2.c, l2.f] */
    public final void m() {
        d dVar = this.f3608l;
        i0.g(dVar.f3589m);
        l2.f fVar = this.f3598b;
        if (fVar.p() || fVar.q()) {
            return;
        }
        try {
            int p5 = dVar.f3583g.p(dVar.f3581e, fVar);
            if (p5 != 0) {
                i2.a aVar = new i2.a(p5, null);
                String name = fVar.getClass().getName();
                String aVar2 = aVar.toString();
                Log.w("GoogleApiManager", "The service for " + name + " is not available: " + aVar2);
                o(aVar, null);
                return;
            }
            h1.c cVar = new h1.c(dVar, fVar, this.f3599c);
            if (fVar.e()) {
                x xVar = this.f3604h;
                i0.j(xVar);
                t2.c cVar2 = xVar.f3634f;
                if (cVar2 != null) {
                    cVar2.a();
                }
                Integer valueOf = Integer.valueOf(System.identityHashCode(xVar));
                l2.c cVar3 = xVar.f3633e;
                cVar3.f3772g = valueOf;
                n2.c cVar4 = xVar.f3631c;
                Context context = xVar.f3629a;
                Handler handler = xVar.f3630b;
                xVar.f3634f = cVar4.f(context, handler.getLooper(), cVar3, cVar3.f3771f, xVar, xVar);
                xVar.f3635g = cVar;
                Set set = xVar.f3632d;
                if (set == null || set.isEmpty()) {
                    handler.post(new w(0, xVar));
                } else {
                    xVar.f3634f.f();
                }
            }
            try {
                fVar.f3815i = cVar;
                fVar.s(2, null);
            } catch (SecurityException e5) {
                o(new i2.a(10), e5);
            }
        } catch (IllegalStateException e6) {
            o(new i2.a(10), e6);
        }
    }

    public final void n(s sVar) {
        i0.g(this.f3608l.f3589m);
        boolean p5 = this.f3598b.p();
        LinkedList linkedList = this.f3597a;
        if (p5) {
            if (k(sVar)) {
                j();
                return;
            } else {
                linkedList.add(sVar);
                return;
            }
        }
        linkedList.add(sVar);
        i2.a aVar = this.f3607k;
        if (aVar != null) {
            if ((aVar.f3381c == 0 || aVar.f3382d == null) ? false : true) {
                o(aVar, null);
                return;
            }
        }
        m();
    }

    public final void o(i2.a aVar, RuntimeException runtimeException) {
        t2.c cVar;
        i0.g(this.f3608l.f3589m);
        x xVar = this.f3604h;
        if (xVar != null && (cVar = xVar.f3634f) != null) {
            cVar.a();
        }
        i0.g(this.f3608l.f3589m);
        this.f3607k = null;
        ((SparseIntArray) this.f3608l.f3583g.f306h).clear();
        d(aVar);
        if ((this.f3598b instanceof n2.e) && aVar.f3381c != 24) {
            d dVar = this.f3608l;
            dVar.f3578b = true;
            r2.d dVar2 = dVar.f3589m;
            dVar2.sendMessageDelayed(dVar2.obtainMessage(19), 300000L);
        }
        if (aVar.f3381c == 4) {
            e(d.f3574p);
        } else if (this.f3597a.isEmpty()) {
            this.f3607k = aVar;
        } else if (runtimeException != null) {
            i0.g(this.f3608l.f3589m);
            f(null, runtimeException, false);
        } else if (!this.f3608l.f3590n) {
            e(d.c(this.f3599c, aVar));
        } else {
            f(d.c(this.f3599c, aVar), null, true);
            if (this.f3597a.isEmpty() || l(aVar) || this.f3608l.b(aVar, this.f3603g)) {
                return;
            }
            if (aVar.f3381c == 18) {
                this.f3605i = true;
            }
            if (!this.f3605i) {
                e(d.c(this.f3599c, aVar));
                return;
            }
            d dVar3 = this.f3608l;
            a aVar2 = this.f3599c;
            r2.d dVar4 = dVar3.f3589m;
            dVar4.sendMessageDelayed(Message.obtain(dVar4, 9, aVar2), 5000L);
        }
    }

    public final void p(i2.a aVar) {
        i0.g(this.f3608l.f3589m);
        l2.f fVar = this.f3598b;
        String name = fVar.getClass().getName();
        String valueOf = String.valueOf(aVar);
        fVar.d("onSignInFailed for " + name + " with " + valueOf);
        o(aVar, null);
    }

    public final void q() {
        g[] gVarArr;
        d dVar = this.f3608l;
        i0.g(dVar.f3589m);
        Status status = d.o;
        e(status);
        d0 d0Var = this.f3600d;
        d0Var.getClass();
        d0Var.q(false, status);
        for (g gVar : (g[]) this.f3602f.keySet().toArray(new g[0])) {
            n(new z(new v2.c()));
        }
        d(new i2.a(4));
        l2.f fVar = this.f3598b;
        if (fVar.p()) {
            n nVar = new n(this);
            fVar.getClass();
            dVar.f3589m.post(new w(2, nVar));
        }
    }
}
