package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class z2 extends l0 {
    private static final z2 zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        z2 z2Var = new z2();
        zzb = z2Var;
        l0.h(z2.class, z2Var);
    }

    @Override // com.google.android.gms.internal.play_billing.l0
    public final Object l(int i5) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 == 2) {
                return new s1(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
            } else if (i6 != 3) {
                if (i6 != 4) {
                    if (i6 != 5) {
                        return null;
                    }
                    return zzb;
                }
                return new u2(0);
            } else {
                return new z2();
            }
        }
        return (byte) 1;
    }
}
