package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;
@Deprecated
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements r {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1090a;

    /* renamed from: b  reason: collision with root package name */
    public final b f1091b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1090a = obj;
        this.f1091b = d.f1100c.b(obj.getClass());
    }

    @Override // androidx.lifecycle.r
    public final void b(t tVar, m mVar) {
        HashMap hashMap = this.f1091b.f1096a;
        Object obj = this.f1090a;
        b.a((List) hashMap.get(mVar), tVar, mVar, obj);
        b.a((List) hashMap.get(m.ON_ANY), tVar, mVar, obj);
    }
}
