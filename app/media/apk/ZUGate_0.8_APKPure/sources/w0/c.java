package w0;

import androidx.lifecycle.r0;
import androidx.lifecycle.t0;
/* loaded from: classes.dex */
public final class c implements t0 {

    /* renamed from: g  reason: collision with root package name */
    public final f[] f5294g;

    public c(f... fVarArr) {
        e4.e.f(fVarArr, "initializers");
        this.f5294g = fVarArr;
    }

    @Override // androidx.lifecycle.t0
    public final r0 c(Class cls, e eVar) {
        f[] fVarArr;
        r0 r0Var = null;
        for (f fVar : this.f5294g) {
            if (e4.e.a(fVar.f5295a, cls)) {
                Object c5 = fVar.f5296b.c(eVar);
                r0Var = c5 instanceof r0 ? (r0) c5 : null;
            }
        }
        if (r0Var != null) {
            return r0Var;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(cls.getName()));
    }
}
