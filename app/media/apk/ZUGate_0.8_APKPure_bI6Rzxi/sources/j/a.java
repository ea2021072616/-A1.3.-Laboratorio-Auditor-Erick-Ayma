package j;

import java.util.HashMap;
/* loaded from: classes.dex */
public final class a extends g {

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f3418f = new HashMap();

    @Override // j.g
    public final c e(Object obj) {
        return (c) this.f3418f.get(obj);
    }

    @Override // j.g
    public final Object f(Object obj) {
        Object f5 = super.f(obj);
        this.f3418f.remove(obj);
        return f5;
    }

    public final Object g(Object obj, Object obj2) {
        c e5 = e(obj);
        if (e5 != null) {
            return e5.f3421c;
        }
        HashMap hashMap = this.f3418f;
        c cVar = new c(obj, obj2);
        this.f3432e++;
        c cVar2 = this.f3430c;
        if (cVar2 == null) {
            this.f3429b = cVar;
            this.f3430c = cVar;
        } else {
            cVar2.f3422d = cVar;
            cVar.f3423e = cVar2;
            this.f3430c = cVar;
        }
        hashMap.put(obj, cVar);
        return null;
    }
}
