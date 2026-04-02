package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public n f1147a;

    /* renamed from: b  reason: collision with root package name */
    public final r f1148b;

    public u(s sVar, n nVar) {
        r reflectiveGenericLifecycleObserver;
        e4.e.c(sVar);
        HashMap hashMap = w.f1158a;
        boolean z4 = sVar instanceof r;
        boolean z5 = sVar instanceof e;
        if (z4 && z5) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((e) sVar, (r) sVar);
        } else if (z5) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((e) sVar, null);
        } else if (z4) {
            reflectiveGenericLifecycleObserver = (r) sVar;
        } else {
            Class<?> cls = sVar.getClass();
            if (w.c(cls) == 2) {
                Object obj = w.f1159b.get(cls);
                e4.e.c(obj);
                List list = (List) obj;
                if (list.size() == 1) {
                    w.a((Constructor) list.get(0), sVar);
                    throw null;
                }
                int size = list.size();
                h[] hVarArr = new h[size];
                if (size > 0) {
                    w.a((Constructor) list.get(0), sVar);
                    throw null;
                }
                reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(hVarArr);
            } else {
                reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(sVar);
            }
        }
        this.f1148b = reflectiveGenericLifecycleObserver;
        this.f1147a = nVar;
    }

    public final void a(t tVar, m mVar) {
        n a5 = mVar.a();
        n nVar = this.f1147a;
        e4.e.f(nVar, "state1");
        if (a5.compareTo(nVar) < 0) {
            nVar = a5;
        }
        this.f1147a = nVar;
        this.f1148b.b(tVar, mVar);
        this.f1147a = a5;
    }
}
