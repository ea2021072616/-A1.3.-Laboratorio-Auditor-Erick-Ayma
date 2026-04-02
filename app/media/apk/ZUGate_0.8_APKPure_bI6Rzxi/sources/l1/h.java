package l1;

import android.graphics.Paint;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public final class h extends a {
    public final int I;
    public final boolean D = true;
    public final boolean E = true;
    public final float F = 10.0f;
    public final float G = 10.0f;
    public final int H = 1;
    public final float J = Float.POSITIVE_INFINITY;

    public h(int i5) {
        this.I = i5;
        this.f3732c = 0.0f;
    }

    @Override // l1.a
    public final void a(float f5, float f6) {
        if (Math.abs(f6 - f5) == 0.0f) {
            f6 += 1.0f;
            f5 -= 1.0f;
        }
        float abs = Math.abs(f6 - f5);
        float f7 = this.f3729z ? this.B : f5 - ((abs / 100.0f) * this.G);
        this.B = f7;
        float f8 = ((abs / 100.0f) * this.F) + f6;
        this.A = f8;
        this.C = Math.abs(f7 - f8);
    }

    public final float c(Paint paint) {
        paint.setTextSize(this.f3733d);
        String b5 = b();
        DisplayMetrics displayMetrics = t1.g.f5003a;
        float measureText = (this.f3731b * 2.0f) + ((int) paint.measureText(b5));
        float f5 = this.J;
        if (f5 > 0.0f && f5 != Float.POSITIVE_INFINITY) {
            f5 = t1.g.c(f5);
        }
        if (f5 <= 0.0d) {
            f5 = measureText;
        }
        return Math.max(0.0f, Math.min(measureText, f5));
    }
}
