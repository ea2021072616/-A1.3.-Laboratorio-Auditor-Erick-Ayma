package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class z0 extends a1 {
    @Override // com.google.android.gms.internal.play_billing.a1
    public final void a(long j5, Object obj) {
        t tVar = (t) ((r0) f2.j(j5, obj));
        if (tVar.f1959b) {
            tVar.f1959b = false;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.a1
    public final void b(long j5, Object obj, Object obj2) {
        r0 r0Var = (r0) f2.j(j5, obj);
        r0 r0Var2 = (r0) f2.j(j5, obj2);
        int size = r0Var.size();
        int size2 = r0Var2.size();
        if (size > 0 && size2 > 0) {
            if (!((t) r0Var).f1959b) {
                r0Var = r0Var.b(size2 + size);
            }
            r0Var.addAll(r0Var2);
        }
        if (size > 0) {
            r0Var2 = r0Var;
        }
        f2.r(j5, obj, r0Var2);
    }
}
