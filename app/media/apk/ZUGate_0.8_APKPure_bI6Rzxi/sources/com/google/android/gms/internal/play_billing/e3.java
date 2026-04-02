package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class e3 extends l0 {
    private static final e3 zzb;
    private int zzd;
    private int zzf;
    private r0 zze = r1.f1943e;
    private String zzg = "";

    static {
        e3 e3Var = new e3();
        zzb = e3Var;
        l0.h(e3.class, e3Var);
    }

    public static /* synthetic */ e3 m() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.l0
    public final Object l(int i5) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 == 2) {
                return new s1(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002င\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
            } else if (i6 != 3) {
                if (i6 != 4) {
                    if (i6 != 5) {
                        return null;
                    }
                    return zzb;
                }
                return new u2((androidx.appcompat.widget.b0) null);
            } else {
                return new e3();
            }
        }
        return (byte) 1;
    }
}
