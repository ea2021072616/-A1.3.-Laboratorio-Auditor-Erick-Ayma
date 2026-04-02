package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class h3 extends l0 {
    private static final h3 zzb;
    private int zzd;
    private int zze;

    static {
        h3 h3Var = new h3();
        zzb = h3Var;
        l0.h(h3.class, h3Var);
    }

    public static /* synthetic */ h3 m() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.l0
    public final Object l(int i5) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 == 2) {
                return new s1(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzd", "zze"});
            } else if (i6 != 3) {
                if (i6 != 4) {
                    if (i6 != 5) {
                        return null;
                    }
                    return zzb;
                }
                return new u2((t2) null);
            } else {
                return new h3();
            }
        }
        return (byte) 1;
    }
}
