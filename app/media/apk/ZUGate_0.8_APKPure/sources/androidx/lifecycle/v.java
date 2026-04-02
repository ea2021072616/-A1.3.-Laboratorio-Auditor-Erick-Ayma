package androidx.lifecycle;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class v extends o {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1149a;

    /* renamed from: b  reason: collision with root package name */
    public j.a f1150b;

    /* renamed from: c  reason: collision with root package name */
    public n f1151c;

    /* renamed from: d  reason: collision with root package name */
    public final WeakReference f1152d;

    /* renamed from: e  reason: collision with root package name */
    public int f1153e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1154f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1155g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f1156h;

    public v(t tVar) {
        e4.e.f(tVar, "provider");
        this.f1149a = true;
        this.f1150b = new j.a();
        this.f1151c = n.INITIALIZED;
        this.f1156h = new ArrayList();
        this.f1152d = new WeakReference(tVar);
    }

    @Override // androidx.lifecycle.o
    public final void a(s sVar) {
        t tVar;
        e4.e.f(sVar, "observer");
        d("addObserver");
        n nVar = this.f1151c;
        n nVar2 = n.DESTROYED;
        if (nVar != nVar2) {
            nVar2 = n.INITIALIZED;
        }
        u uVar = new u(sVar, nVar2);
        if (((u) this.f1150b.g(sVar, uVar)) == null && (tVar = (t) this.f1152d.get()) != null) {
            boolean z4 = this.f1153e != 0 || this.f1154f;
            n c5 = c(sVar);
            this.f1153e++;
            while (uVar.f1147a.compareTo(c5) < 0 && this.f1150b.f3418f.containsKey(sVar)) {
                n nVar3 = uVar.f1147a;
                ArrayList arrayList = this.f1156h;
                arrayList.add(nVar3);
                k kVar = m.Companion;
                n nVar4 = uVar.f1147a;
                kVar.getClass();
                m b5 = k.b(nVar4);
                if (b5 == null) {
                    throw new IllegalStateException("no event up from " + uVar.f1147a);
                }
                uVar.a(tVar, b5);
                arrayList.remove(arrayList.size() - 1);
                c5 = c(sVar);
            }
            if (!z4) {
                h();
            }
            this.f1153e--;
        }
    }

    @Override // androidx.lifecycle.o
    public final void b(s sVar) {
        e4.e.f(sVar, "observer");
        d("removeObserver");
        this.f1150b.f(sVar);
    }

    public final n c(s sVar) {
        u uVar;
        j.a aVar = this.f1150b;
        j.c cVar = aVar.f3418f.containsKey(sVar) ? ((j.c) aVar.f3418f.get(sVar)).f3423e : null;
        n nVar = (cVar == null || (uVar = (u) cVar.f3421c) == null) ? null : uVar.f1147a;
        ArrayList arrayList = this.f1156h;
        n nVar2 = arrayList.isEmpty() ^ true ? (n) arrayList.get(arrayList.size() - 1) : null;
        n nVar3 = this.f1151c;
        e4.e.f(nVar3, "state1");
        if (nVar == null || nVar.compareTo(nVar3) >= 0) {
            nVar = nVar3;
        }
        return (nVar2 == null || nVar2.compareTo(nVar) >= 0) ? nVar : nVar2;
    }

    public final void d(String str) {
        if (!this.f1149a || i.b.c0().d0()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    public final void e(m mVar) {
        e4.e.f(mVar, "event");
        d("handleLifecycleEvent");
        f(mVar.a());
    }

    public final void f(n nVar) {
        n nVar2 = this.f1151c;
        if (nVar2 == nVar) {
            return;
        }
        n nVar3 = n.INITIALIZED;
        n nVar4 = n.DESTROYED;
        if (!((nVar2 == nVar3 && nVar == nVar4) ? false : true)) {
            throw new IllegalStateException(("no event down from " + this.f1151c + " in component " + this.f1152d.get()).toString());
        }
        this.f1151c = nVar;
        if (this.f1154f || this.f1153e != 0) {
            this.f1155g = true;
            return;
        }
        this.f1154f = true;
        h();
        this.f1154f = false;
        if (this.f1151c == nVar4) {
            this.f1150b = new j.a();
        }
    }

    public final void g() {
        n nVar = n.CREATED;
        d("setCurrentState");
        f(nVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0163 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.v.h():void");
    }
}
