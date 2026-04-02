package com.google.android.gms.internal.play_billing;

import java.io.IOException;
/* loaded from: classes.dex */
public final class j2 extends l0 {
    private static final j2 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private p2 zzh;

    static {
        j2 j2Var = new j2();
        zzb = j2Var;
        l0.h(j2.class, j2Var);
    }

    public static j2 m(byte[] bArr, e0 e0Var) {
        l0 l0Var = zzb;
        int length = bArr.length;
        if (length != 0) {
            l0Var = (l0) l0Var.l(4);
            try {
                t1 a5 = q1.f1939c.a(l0Var.getClass());
                a5.d(l0Var, bArr, 0, length, new v(e0Var));
                a5.b(l0Var);
            } catch (u0 e5) {
                throw e5;
            } catch (v1 e6) {
                throw new u0(e6.getMessage());
            } catch (IOException e7) {
                if (e7.getCause() instanceof u0) {
                    throw ((u0) e7.getCause());
                }
                throw new u0(e7);
            } catch (IndexOutOfBoundsException unused) {
                throw u0.d();
            }
        }
        if (l0Var == null || l0.j(l0Var, true)) {
            return (j2) l0Var;
        }
        throw new u0(new v1().getMessage());
    }

    public static /* synthetic */ void n(j2 j2Var, p2 p2Var) {
        j2Var.zzh = p2Var;
        j2Var.zzd |= 2;
    }

    public static /* synthetic */ void o(j2 j2Var, int i5) {
        j2Var.zzg = i5 - 1;
        j2Var.zzd |= 1;
    }

    public static i2 p() {
        return (i2) ((k0) zzb.l(5));
    }

    @Override // com.google.android.gms.internal.play_billing.l0
    public final Object l(int i5) {
        int i6 = i5 - 1;
        if (i6 != 0) {
            if (i6 == 2) {
                return new s1(zzb, "\u0001\u0003\u0001\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", k2.f1905a, "zzh", b3.class});
            } else if (i6 != 3) {
                if (i6 != 4) {
                    if (i6 != 5) {
                        return null;
                    }
                    return zzb;
                }
                return new i2();
            } else {
                return new j2();
            }
        }
        return (byte) 1;
    }
}
