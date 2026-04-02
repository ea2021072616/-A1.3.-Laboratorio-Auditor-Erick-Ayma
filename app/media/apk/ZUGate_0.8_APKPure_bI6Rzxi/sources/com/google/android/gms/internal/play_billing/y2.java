package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class y2 extends l0 {
    private static final y2 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private int zzg;

    static {
        y2 y2Var = new y2();
        zzb = y2Var;
        l0.h(y2.class, y2Var);
    }

    public static /* synthetic */ void m(y2 y2Var, String str) {
        str.getClass();
        y2Var.zzd |= 1;
        y2Var.zze = str;
    }

    public static /* synthetic */ void n(y2 y2Var, String str) {
        str.getClass();
        y2Var.zzd |= 2;
        y2Var.zzf = str;
    }

    public static /* synthetic */ void o(y2 y2Var, int i5) {
        y2Var.zzd |= 4;
        y2Var.zzg = i5;
    }

    public static x2 p() {
        return (x2) ((k0) zzb.l(5));
    }

    @Override // com.google.android.gms.internal.play_billing.l0
    public final Object l(int i5) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 == 2) {
                return new s1(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
            } else if (i6 != 3) {
                if (i6 != 4) {
                    if (i6 != 5) {
                        return null;
                    }
                    return zzb;
                }
                return new x2();
            } else {
                return new y2();
            }
        }
        return (byte) 1;
    }
}
