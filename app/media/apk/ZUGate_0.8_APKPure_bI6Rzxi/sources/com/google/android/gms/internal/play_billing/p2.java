package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class p2 extends l0 {
    private static final p2 zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private String zzf = "";
    private String zzh = "";

    static {
        p2 p2Var = new p2();
        zzb = p2Var;
        l0.h(p2.class, p2Var);
    }

    public static /* synthetic */ void m(p2 p2Var, int i5) {
        p2Var.zzd |= 1;
        p2Var.zze = i5;
    }

    public static /* synthetic */ void n(p2 p2Var, String str) {
        str.getClass();
        p2Var.zzd |= 2;
        p2Var.zzf = str;
    }

    public static /* synthetic */ void o(p2 p2Var, String str) {
        p2Var.zzd |= 8;
        p2Var.zzh = str;
    }

    public static /* synthetic */ void p(p2 p2Var, int i5) {
        p2Var.zzg = i5 - 1;
        p2Var.zzd |= 4;
    }

    public static n2 q() {
        return (n2) ((k0) zzb.l(5));
    }

    @Override // com.google.android.gms.internal.play_billing.l0
    public final Object l(int i5) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 == 2) {
                return new s1(zzb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004᠌\u0002\u0005ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", o2.f1938a, "zzh"});
            } else if (i6 != 3) {
                if (i6 != 4) {
                    if (i6 != 5) {
                        return null;
                    }
                    return zzb;
                }
                return new n2();
            } else {
                return new p2();
            }
        }
        return (byte) 1;
    }
}
