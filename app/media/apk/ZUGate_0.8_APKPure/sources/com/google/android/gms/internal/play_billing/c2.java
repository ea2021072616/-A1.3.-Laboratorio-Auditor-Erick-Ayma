package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class c2 extends e2 {
    @Override // com.google.android.gms.internal.play_billing.e2
    public final double a(long j5, Object obj) {
        return Double.longBitsToDouble(this.f1858a.getLong(obj, j5));
    }

    @Override // com.google.android.gms.internal.play_billing.e2
    public final float b(long j5, Object obj) {
        return Float.intBitsToFloat(this.f1858a.getInt(obj, j5));
    }

    @Override // com.google.android.gms.internal.play_billing.e2
    public final void c(Object obj, long j5, boolean z4) {
        if (f2.f1866g) {
            f2.c(obj, j5, z4 ? (byte) 1 : (byte) 0);
        } else {
            f2.d(obj, j5, z4 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.e2
    public final void d(Object obj, long j5, byte b5) {
        if (f2.f1866g) {
            f2.c(obj, j5, b5);
        } else {
            f2.d(obj, j5, b5);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.e2
    public final void e(Object obj, long j5, double d5) {
        this.f1858a.putLong(obj, j5, Double.doubleToLongBits(d5));
    }

    @Override // com.google.android.gms.internal.play_billing.e2
    public final void f(Object obj, long j5, float f5) {
        this.f1858a.putInt(obj, j5, Float.floatToIntBits(f5));
    }

    @Override // com.google.android.gms.internal.play_billing.e2
    public final boolean g(long j5, Object obj) {
        return f2.f1866g ? f2.s(j5, obj) : f2.t(j5, obj);
    }
}
