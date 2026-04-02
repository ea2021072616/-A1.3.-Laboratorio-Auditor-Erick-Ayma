package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public abstract class k0 extends q {

    /* renamed from: b  reason: collision with root package name */
    public final l0 f1902b;

    /* renamed from: c  reason: collision with root package name */
    public l0 f1903c;

    public k0(l0 l0Var) {
        this.f1902b = l0Var;
        if (l0Var.k()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f1903c = (l0) l0Var.l(4);
    }

    public static void e(l0 l0Var, l0 l0Var2) {
        q1.f1939c.a(l0Var.getClass()).f(l0Var, l0Var2);
    }

    public final l0 a() {
        l0 b5 = b();
        b5.getClass();
        if (l0.j(b5, true)) {
            return b5;
        }
        throw new v1();
    }

    public final l0 b() {
        if (this.f1903c.k()) {
            l0 l0Var = this.f1903c;
            l0Var.getClass();
            q1.f1939c.a(l0Var.getClass()).b(l0Var);
            l0Var.g();
            return this.f1903c;
        }
        return this.f1903c;
    }

    public final void c() {
        if (this.f1903c.k()) {
            return;
        }
        d();
    }

    public final Object clone() {
        k0 k0Var = (k0) this.f1902b.l(5);
        k0Var.f1903c = b();
        return k0Var;
    }

    public final void d() {
        l0 l0Var = (l0) this.f1902b.l(4);
        e(l0Var, this.f1903c);
        this.f1903c = l0Var;
    }
}
