package h0;
/* loaded from: classes.dex */
public abstract class z1 {

    /* renamed from: a  reason: collision with root package name */
    public final h2 f3239a;

    /* renamed from: b  reason: collision with root package name */
    public z.c[] f3240b;

    public z1() {
        this(new h2());
    }

    public final void a() {
        z.c[] cVarArr = this.f3240b;
        if (cVarArr != null) {
            z.c cVar = cVarArr[com.google.android.gms.internal.play_billing.i0.G(1)];
            z.c cVar2 = this.f3240b[com.google.android.gms.internal.play_billing.i0.G(2)];
            h2 h2Var = this.f3239a;
            if (cVar2 == null) {
                cVar2 = h2Var.a(2);
            }
            if (cVar == null) {
                cVar = h2Var.a(1);
            }
            g(z.c.a(cVar, cVar2));
            z.c cVar3 = this.f3240b[com.google.android.gms.internal.play_billing.i0.G(16)];
            if (cVar3 != null) {
                f(cVar3);
            }
            z.c cVar4 = this.f3240b[com.google.android.gms.internal.play_billing.i0.G(32)];
            if (cVar4 != null) {
                d(cVar4);
            }
            z.c cVar5 = this.f3240b[com.google.android.gms.internal.play_billing.i0.G(64)];
            if (cVar5 != null) {
                h(cVar5);
            }
        }
    }

    public abstract h2 b();

    public void c(int i5, z.c cVar) {
        if (this.f3240b == null) {
            this.f3240b = new z.c[9];
        }
        for (int i6 = 1; i6 <= 256; i6 <<= 1) {
            if ((i5 & i6) != 0) {
                this.f3240b[com.google.android.gms.internal.play_billing.i0.G(i6)] = cVar;
            }
        }
    }

    public void d(z.c cVar) {
    }

    public abstract void e(z.c cVar);

    public void f(z.c cVar) {
    }

    public abstract void g(z.c cVar);

    public void h(z.c cVar) {
    }

    public z1(h2 h2Var) {
        this.f3239a = h2Var;
    }
}
