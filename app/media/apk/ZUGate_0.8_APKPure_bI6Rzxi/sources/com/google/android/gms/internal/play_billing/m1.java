package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class m1 implements t1 {

    /* renamed from: a  reason: collision with root package name */
    public final j1 f1927a;

    /* renamed from: b  reason: collision with root package name */
    public final x1 f1928b;

    /* renamed from: c  reason: collision with root package name */
    public final f0 f1929c;

    public m1(x1 x1Var, f0 f0Var, j1 j1Var) {
        this.f1928b = x1Var;
        this.f1929c = f0Var;
        this.f1927a = j1Var;
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final l0 a() {
        j1 j1Var = this.f1927a;
        return j1Var instanceof l0 ? (l0) ((l0) j1Var).l(4) : ((k0) ((l0) j1Var).l(5)).b();
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final void b(Object obj) {
        this.f1928b.getClass();
        x1.c(obj);
        this.f1929c.getClass();
        androidx.appcompat.widget.b0.n(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final void c(Object obj, d0 d0Var) {
        this.f1929c.getClass();
        androidx.appcompat.widget.b0.n(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final void d(Object obj, byte[] bArr, int i5, int i6, v vVar) {
        l0 l0Var = (l0) obj;
        if (l0Var.zzc == w1.f1985f) {
            l0Var.zzc = w1.b();
        }
        androidx.appcompat.widget.b0.n(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final int e(Object obj) {
        this.f1928b.getClass();
        w1 w1Var = ((l0) obj).zzc;
        int i5 = w1Var.f1989d;
        if (i5 == -1) {
            int i6 = 0;
            for (int i7 = 0; i7 < w1Var.f1986a; i7++) {
                int u02 = b0.u0(8);
                int u03 = b0.u0(w1Var.f1987b[i7] >>> 3) + b0.u0(16);
                int u04 = b0.u0(24);
                int i8 = ((z) w1Var.f1988c[i7]).i();
                i6 += u02 + u02 + u03 + b0.u0(i8) + i8 + u04;
            }
            w1Var.f1989d = i6;
            return i6;
        }
        return i5;
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final void f(Object obj, Object obj2) {
        u1.u(this.f1928b, obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final boolean g(Object obj, Object obj2) {
        this.f1928b.getClass();
        return ((l0) obj).zzc.equals(((l0) obj2).zzc);
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final boolean h(Object obj) {
        this.f1929c.getClass();
        androidx.appcompat.widget.b0.n(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.t1
    public final int i(Object obj) {
        this.f1928b.getClass();
        return ((l0) obj).zzc.hashCode();
    }
}
