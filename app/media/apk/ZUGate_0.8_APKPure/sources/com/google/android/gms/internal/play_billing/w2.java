package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class w2 extends l0 {
    private static final q0 zzb = new l2.i(null);
    private static final w2 zzd;
    private int zze;
    private int zzg;
    private p2 zzj;
    private boolean zzk;
    private boolean zzl;
    private String zzf = "";
    private p0 zzh = m0.f1924e;
    private r0 zzi = r1.f1943e;

    static {
        w2 w2Var = new w2();
        zzd = w2Var;
        l0.h(w2.class, w2Var);
    }

    @Override // com.google.android.gms.internal.play_billing.l0
    public final Object l(int i5) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 == 2) {
                return new s1(zzd, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ࠬ\u0004\u001b\u0005ဉ\u0002\u0006ဇ\u0003\u0007ဇ\u0004", new Object[]{"zze", "zzf", "zzg", v2.f1980a, "zzh", q2.f1942a, "zzi", e3.class, "zzj", "zzk", "zzl"});
            } else if (i6 != 3) {
                if (i6 != 4) {
                    if (i6 != 5) {
                        return null;
                    }
                    return zzd;
                }
                return new u2();
            } else {
                return new w2();
            }
        }
        return (byte) 1;
    }
}
