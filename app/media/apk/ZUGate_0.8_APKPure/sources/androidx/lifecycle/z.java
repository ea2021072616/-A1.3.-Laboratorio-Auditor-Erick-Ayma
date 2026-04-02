package androidx.lifecycle;

import java.util.Map;
/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: k  reason: collision with root package name */
    public static final Object f1164k = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Object f1165a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final j.g f1166b = new j.g();

    /* renamed from: c  reason: collision with root package name */
    public int f1167c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1168d;

    /* renamed from: e  reason: collision with root package name */
    public volatile Object f1169e;

    /* renamed from: f  reason: collision with root package name */
    public volatile Object f1170f;

    /* renamed from: g  reason: collision with root package name */
    public int f1171g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1172h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1173i;

    /* renamed from: j  reason: collision with root package name */
    public final androidx.activity.j f1174j;

    public z() {
        Object obj = f1164k;
        this.f1170f = obj;
        this.f1174j = new androidx.activity.j(9, this);
        this.f1169e = obj;
        this.f1171g = -1;
    }

    public static void a(String str) {
        if (i.b.c0().d0()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public final void b(y yVar) {
        if (yVar.f1161b) {
            if (!yVar.f()) {
                yVar.c(false);
                return;
            }
            int i5 = yVar.f1162c;
            int i6 = this.f1171g;
            if (i5 >= i6) {
                return;
            }
            yVar.f1162c = i6;
            yVar.f1160a.b(this.f1169e);
        }
    }

    public final void c(y yVar) {
        if (this.f1172h) {
            this.f1173i = true;
            return;
        }
        this.f1172h = true;
        do {
            this.f1173i = false;
            if (yVar == null) {
                j.g gVar = this.f1166b;
                gVar.getClass();
                j.d dVar = new j.d(gVar);
                gVar.f3431d.put(dVar, Boolean.FALSE);
                while (dVar.hasNext()) {
                    b((y) ((Map.Entry) dVar.next()).getValue());
                    if (this.f1173i) {
                        break;
                    }
                }
            } else {
                b(yVar);
                yVar = null;
            }
        } while (this.f1173i);
        this.f1172h = false;
    }

    public final void d(t tVar, b0 b0Var) {
        Object obj;
        a("observe");
        if (((v) tVar.getLifecycle()).f1151c == n.DESTROYED) {
            return;
        }
        LiveData$LifecycleBoundObserver liveData$LifecycleBoundObserver = new LiveData$LifecycleBoundObserver(this, tVar, b0Var);
        j.g gVar = this.f1166b;
        j.c e5 = gVar.e(b0Var);
        if (e5 != null) {
            obj = e5.f3421c;
        } else {
            j.c cVar = new j.c(b0Var, liveData$LifecycleBoundObserver);
            gVar.f3432e++;
            j.c cVar2 = gVar.f3430c;
            if (cVar2 == null) {
                gVar.f3429b = cVar;
                gVar.f3430c = cVar;
            } else {
                cVar2.f3422d = cVar;
                cVar.f3423e = cVar2;
                gVar.f3430c = cVar;
            }
            obj = null;
        }
        y yVar = (y) obj;
        if (yVar != null && !yVar.e(tVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (yVar != null) {
            return;
        }
        tVar.getLifecycle().a(liveData$LifecycleBoundObserver);
    }

    public final void e(androidx.fragment.app.v vVar) {
        Object obj;
        a("observeForever");
        x xVar = new x(this, vVar);
        j.g gVar = this.f1166b;
        j.c e5 = gVar.e(vVar);
        if (e5 != null) {
            obj = e5.f3421c;
        } else {
            j.c cVar = new j.c(vVar, xVar);
            gVar.f3432e++;
            j.c cVar2 = gVar.f3430c;
            if (cVar2 == null) {
                gVar.f3429b = cVar;
                gVar.f3430c = cVar;
            } else {
                cVar2.f3422d = cVar;
                cVar.f3423e = cVar2;
                gVar.f3430c = cVar;
            }
            obj = null;
        }
        y yVar = (y) obj;
        if (yVar instanceof LiveData$LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (yVar != null) {
            return;
        }
        xVar.c(true);
    }

    public abstract void f(Object obj);
}
