package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class b3 extends l0 {
    private static final b3 zzb;
    private int zzd;
    private int zze;

    static {
        b3 b3Var = new b3();
        zzb = b3Var;
        l0.h(b3.class, b3Var);
    }

    public static /* synthetic */ b3 m() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.l0
    public final Object l(int i5) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 == 2) {
                return new s1(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", a3.f1837a});
            } else if (i6 != 3) {
                if (i6 != 4) {
                    if (i6 != 5) {
                        return null;
                    }
                    return zzb;
                }
                return new u2((Object) null);
            } else {
                return new b3();
            }
        }
        return (byte) 1;
    }
}
