package p3;

import com.google.android.gms.internal.play_billing.i0;
/* loaded from: classes.dex */
public final class d extends i0 {
    @Override // com.google.android.gms.internal.play_billing.i0
    public final void x(float f5, float f6, t tVar) {
        tVar.d(f6 * f5, 180.0f, 90.0f);
        double d5 = f6;
        double d6 = f5;
        tVar.c((float) (Math.sin(Math.toRadians(90.0f)) * d5 * d6), (float) (Math.sin(Math.toRadians(0.0f)) * d5 * d6));
    }
}
