package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class d3 extends l0 {
    private static final d3 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private y2 zzg;
    private z2 zzh;

    static {
        d3 d3Var = new d3();
        zzb = d3Var;
        l0.h(d3.class, d3Var);
    }

    public static /* synthetic */ void m(d3 d3Var, g3 g3Var) {
        d3Var.zzf = g3Var;
        d3Var.zze = 4;
    }

    public static /* synthetic */ void n(d3 d3Var, y2 y2Var) {
        y2Var.getClass();
        d3Var.zzg = y2Var;
        d3Var.zzd |= 1;
    }

    public static /* synthetic */ void o(d3 d3Var, j2 j2Var) {
        d3Var.zzf = j2Var;
        d3Var.zze = 2;
    }

    public static /* synthetic */ void p(d3 d3Var, m2 m2Var) {
        d3Var.zzf = m2Var;
        d3Var.zze = 3;
    }

    public static c3 q() {
        return (c3) ((k0) zzb.l(5));
    }

    @Override // com.google.android.gms.internal.play_billing.l0
    public final Object l(int i5) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 == 2) {
                return new s1(zzb, "\u0001\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001", new Object[]{"zzf", "zze", "zzd", "zzg", j2.class, m2.class, g3.class, w2.class, "zzh"});
            } else if (i6 != 3) {
                if (i6 != 4) {
                    if (i6 != 5) {
                        return null;
                    }
                    return zzb;
                }
                return new c3();
            } else {
                return new d3();
            }
        }
        return (byte) 1;
    }
}
