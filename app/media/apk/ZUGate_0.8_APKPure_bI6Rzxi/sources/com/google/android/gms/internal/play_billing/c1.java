package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class c1 implements i1 {

    /* renamed from: a  reason: collision with root package name */
    public final i1[] f1847a;

    public c1(i1... i1VarArr) {
        this.f1847a = i1VarArr;
    }

    @Override // com.google.android.gms.internal.play_billing.i1
    public final h1 a(Class cls) {
        for (int i5 = 0; i5 < 2; i5++) {
            i1 i1Var = this.f1847a[i5];
            if (i1Var.b(cls)) {
                return i1Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.play_billing.i1
    public final boolean b(Class cls) {
        for (int i5 = 0; i5 < 2; i5++) {
            if (this.f1847a[i5].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
