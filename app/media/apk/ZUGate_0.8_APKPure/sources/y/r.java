package y;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: k  reason: collision with root package name */
    public static final r f5571k;

    /* renamed from: a  reason: collision with root package name */
    public final float f5572a;

    /* renamed from: b  reason: collision with root package name */
    public final float f5573b;

    /* renamed from: c  reason: collision with root package name */
    public final float f5574c;

    /* renamed from: d  reason: collision with root package name */
    public final float f5575d;

    /* renamed from: e  reason: collision with root package name */
    public final float f5576e;

    /* renamed from: f  reason: collision with root package name */
    public final float f5577f;

    /* renamed from: g  reason: collision with root package name */
    public final float[] f5578g;

    /* renamed from: h  reason: collision with root package name */
    public final float f5579h;

    /* renamed from: i  reason: collision with root package name */
    public final float f5580i;

    /* renamed from: j  reason: collision with root package name */
    public final float f5581j;

    static {
        float f5;
        float f6;
        float[] fArr = e4.e.f2717l;
        float i02 = (float) ((e4.e.i0() * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = e4.e.f2715j;
        float f7 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f8 = fArr[1];
        float f9 = fArr3[1] * f8;
        float f10 = fArr[2];
        float f11 = (fArr3[2] * f10) + f9 + (fArr3[0] * f7);
        float[] fArr4 = fArr2[1];
        float f12 = (fArr4[2] * f10) + (fArr4[1] * f8) + (fArr4[0] * f7);
        float[] fArr5 = fArr2[2];
        float f13 = (f10 * fArr5[2]) + (f8 * fArr5[1]) + (f7 * fArr5[0]);
        if (1.0f >= 0.9d) {
            f5 = 0.100000046f;
            f6 = 0.59f;
        } else {
            f5 = 0.12999998f;
            f6 = 0.525f;
        }
        float f14 = f5 + f6;
        float exp = (1.0f - (((float) Math.exp(((-i02) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d5 = exp;
        if (d5 > 1.0d) {
            exp = 1.0f;
        } else if (d5 < 0.0d) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f11) * exp) + 1.0f) - exp, (((100.0f / f12) * exp) + 1.0f) - exp, (((100.0f / f13) * exp) + 1.0f) - exp};
        float f15 = 1.0f / ((5.0f * i02) + 1.0f);
        float f16 = f15 * f15 * f15 * f15;
        float f17 = 1.0f - f16;
        float cbrt = (0.1f * f17 * f17 * ((float) Math.cbrt(i02 * 5.0d))) + (f16 * i02);
        float i03 = e4.e.i0() / fArr[1];
        double d6 = i03;
        float sqrt = ((float) Math.sqrt(d6)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d6, 0.2d));
        float pow2 = (float) Math.pow(((fArr6[2] * cbrt) * f13) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * cbrt) * f11) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * cbrt) * f12) / 100.0d, 0.42d), pow2};
        float f18 = fArr7[0];
        float f19 = fArr7[1];
        f5571k = new r(i03, ((((400.0f * pow2) / (pow2 + 27.13f)) * 0.05f) + (((f18 * 400.0f) / (f18 + 27.13f)) * 2.0f) + ((f19 * 400.0f) / (f19 + 27.13f))) * pow, pow, pow, f14, 1.0f, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    public r(float f5, float f6, float f7, float f8, float f9, float f10, float[] fArr, float f11, float f12, float f13) {
        this.f5577f = f5;
        this.f5572a = f6;
        this.f5573b = f7;
        this.f5574c = f8;
        this.f5575d = f9;
        this.f5576e = f10;
        this.f5578g = fArr;
        this.f5579h = f11;
        this.f5580i = f12;
        this.f5581j = f13;
    }
}
