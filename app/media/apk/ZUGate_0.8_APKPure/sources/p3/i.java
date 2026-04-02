package p3;

import com.google.android.gms.internal.play_billing.i0;
/* loaded from: classes.dex */
public final class i extends i0 {
    @Override // com.google.android.gms.internal.play_billing.i0
    public final void x(float f5, float f6, t tVar) {
        tVar.d(f6 * f5, 180.0f, 90.0f);
        float f7 = f6 * 2.0f * f5;
        p pVar = new p(0.0f, 0.0f, f7, f7);
        pVar.f4350f = 180.0f;
        pVar.f4351g = 90.0f;
        tVar.f4363g.add(pVar);
        n nVar = new n(pVar);
        tVar.a(180.0f);
        tVar.f4364h.add(nVar);
        tVar.f4361e = 270.0f;
        float f8 = (f7 + 0.0f) * 0.5f;
        float f9 = (f7 - 0.0f) / 2.0f;
        double d5 = 270.0f;
        tVar.f4359c = (((float) Math.cos(Math.toRadians(d5))) * f9) + f8;
        tVar.f4360d = (f9 * ((float) Math.sin(Math.toRadians(d5)))) + f8;
    }
}
