package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class m2 extends l0 {
    private static final m2 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;

    static {
        m2 m2Var = new m2();
        zzb = m2Var;
        l0.h(m2.class, m2Var);
    }

    public static /* synthetic */ void m(m2 m2Var, int i5) {
        m2Var.zzg = i5 - 1;
        m2Var.zzd |= 1;
    }

    public static l2 n() {
        return (l2) ((k0) zzb.l(5));
    }

    @Override // com.google.android.gms.internal.play_billing.l0
    public final Object l(int i5) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 == 2) {
                return new s1(zzb, "\u0001\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", k2.f1905a, b3.class, h3.class});
            } else if (i6 != 3) {
                if (i6 != 4) {
                    if (i6 != 5) {
                        return null;
                    }
                    return zzb;
                }
                return new l2();
            } else {
                return new m2();
            }
        }
        return (byte) 1;
    }
}
