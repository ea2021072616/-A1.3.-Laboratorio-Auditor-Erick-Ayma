package y;

import android.graphics.Color;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final float f5536a;

    /* renamed from: b  reason: collision with root package name */
    public final float f5537b;

    /* renamed from: c  reason: collision with root package name */
    public final float f5538c;

    /* renamed from: d  reason: collision with root package name */
    public final float f5539d;

    /* renamed from: e  reason: collision with root package name */
    public final float f5540e;

    /* renamed from: f  reason: collision with root package name */
    public final float f5541f;

    public a(float f5, float f6, float f7, float f8, float f9, float f10) {
        this.f5536a = f5;
        this.f5537b = f6;
        this.f5538c = f7;
        this.f5539d = f8;
        this.f5540e = f9;
        this.f5541f = f10;
    }

    public static a a(int i5) {
        float pow;
        r rVar = r.f5571k;
        float C = e4.e.C(Color.red(i5));
        float C2 = e4.e.C(Color.green(i5));
        float C3 = e4.e.C(Color.blue(i5));
        float[][] fArr = e4.e.f2718m;
        float[] fArr2 = fArr[0];
        float f5 = (fArr2[2] * C3) + (fArr2[1] * C2) + (fArr2[0] * C);
        float[] fArr3 = fArr[1];
        float f6 = (fArr3[2] * C3) + (fArr3[1] * C2) + (fArr3[0] * C);
        float[] fArr4 = fArr[2];
        float f7 = (C3 * fArr4[2]) + (C2 * fArr4[1]) + (C * fArr4[0]);
        float[][] fArr5 = e4.e.f2715j;
        float[] fArr6 = fArr5[0];
        float f8 = (fArr6[2] * f7) + (fArr6[1] * f6) + (fArr6[0] * f5);
        float[] fArr7 = fArr5[1];
        float f9 = fArr7[1] * f6;
        float f10 = fArr7[2] * f7;
        float[] fArr8 = fArr5[2];
        float f11 = f5 * fArr8[0];
        float f12 = f7 * fArr8[2];
        float[] fArr9 = rVar.f5578g;
        float f13 = fArr9[0] * f8;
        float f14 = fArr9[1] * (f10 + f9 + (fArr7[0] * f5));
        float f15 = fArr9[2] * (f12 + (f6 * fArr8[1]) + f11);
        float abs = Math.abs(f13);
        float f16 = rVar.f5579h;
        float pow2 = (float) Math.pow((abs * f16) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((Math.abs(f14) * f16) / 100.0d, 0.42d);
        float pow4 = (float) Math.pow((Math.abs(f15) * f16) / 100.0d, 0.42d);
        float signum = ((Math.signum(f13) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum2 = ((Math.signum(f14) * 400.0f) * pow3) / (pow3 + 27.13f);
        float signum3 = ((Math.signum(f15) * 400.0f) * pow4) / (pow4 + 27.13f);
        double d5 = signum3;
        float f17 = ((float) (((signum2 * (-12.0d)) + (signum * 11.0d)) + d5)) / 11.0f;
        float f18 = ((float) ((signum + signum2) - (d5 * 2.0d))) / 9.0f;
        float f19 = signum2 * 20.0f;
        float f20 = ((21.0f * signum3) + ((signum * 20.0f) + f19)) / 20.0f;
        float f21 = (((signum * 40.0f) + f19) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f18, f17)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f22 = atan2;
        float f23 = (3.1415927f * f22) / 180.0f;
        float f24 = f21 * rVar.f5573b;
        float f25 = rVar.f5572a;
        double d6 = f24 / f25;
        float f26 = rVar.f5581j;
        float f27 = rVar.f5575d;
        float pow5 = ((float) Math.pow(d6, f26 * f27)) * 100.0f;
        Math.sqrt(pow5 / 100.0f);
        float f28 = f25 + 4.0f;
        float sqrt = ((float) Math.sqrt(pow5 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, rVar.f5577f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) f22) < 20.14d ? 360.0f + f22 : f22) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * rVar.f5576e) * rVar.f5574c) * ((float) Math.sqrt((f18 * f18) + (f17 * f17)))) / (f20 + 0.305f), 0.9d));
        Math.sqrt((pow * f27) / f28);
        float f29 = (1.7f * pow5) / ((0.007f * pow5) + 1.0f);
        float log = ((float) Math.log((rVar.f5580i * sqrt * 0.0228f) + 1.0f)) * 43.85965f;
        double d7 = f23;
        return new a(f22, sqrt, pow5, f29, ((float) Math.cos(d7)) * log, log * ((float) Math.sin(d7)));
    }

    public static a b(float f5, float f6, float f7) {
        r rVar;
        double d5;
        float f8 = r.f5571k.f5575d;
        Math.sqrt(f5 / 100.0d);
        Math.sqrt(((f6 / ((float) Math.sqrt(d5))) * rVar.f5575d) / (rVar.f5572a + 4.0f));
        float f9 = (1.7f * f5) / ((0.007f * f5) + 1.0f);
        float log = ((float) Math.log((rVar.f5580i * f6 * 0.0228d) + 1.0d)) * 43.85965f;
        double d6 = (3.1415927f * f7) / 180.0f;
        return new a(f7, f6, f5, f9, log * ((float) Math.cos(d6)), log * ((float) Math.sin(d6)));
    }

    public final int c(r rVar) {
        float f5;
        float[] fArr;
        float f6 = this.f5537b;
        int i5 = (f6 > 0.0d ? 1 : (f6 == 0.0d ? 0 : -1));
        float f7 = this.f5538c;
        if (i5 != 0) {
            double d5 = f7;
            if (d5 != 0.0d) {
                f5 = f6 / ((float) Math.sqrt(d5 / 100.0d));
                float pow = (float) Math.pow(f5 / Math.pow(1.64d - Math.pow(0.29d, rVar.f5577f), 0.73d), 1.1111111111111112d);
                double d6 = (this.f5536a * 3.1415927f) / 180.0f;
                float pow2 = rVar.f5572a * ((float) Math.pow(f7 / 100.0d, (1.0d / rVar.f5575d) / rVar.f5581j));
                float cos = ((float) (Math.cos(2.0d + d6) + 3.8d)) * 0.25f * 3846.1538f * rVar.f5576e * rVar.f5574c;
                float f8 = pow2 / rVar.f5573b;
                float sin = (float) Math.sin(d6);
                float cos2 = (float) Math.cos(d6);
                float f9 = (((0.305f + f8) * 23.0f) * pow) / (((pow * 108.0f) * sin) + (((11.0f * pow) * cos2) + (cos * 23.0f)));
                float f10 = cos2 * f9;
                float f11 = f9 * sin;
                float f12 = f8 * 460.0f;
                float f13 = ((288.0f * f11) + ((451.0f * f10) + f12)) / 1403.0f;
                float f14 = ((f12 - (891.0f * f10)) - (261.0f * f11)) / 1403.0f;
                float f15 = ((f12 - (f10 * 220.0f)) - (f11 * 6300.0f)) / 1403.0f;
                float max = (float) Math.max(0.0d, (Math.abs(f13) * 27.13d) / (400.0d - Math.abs(f13)));
                float signum = Math.signum(f13);
                float f16 = 100.0f / rVar.f5579h;
                float pow3 = signum * f16 * ((float) Math.pow(max, 2.380952380952381d));
                float signum2 = Math.signum(f14) * f16 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f14) * 27.13d) / (400.0d - Math.abs(f14))), 2.380952380952381d));
                float[] fArr2 = rVar.f5578g;
                float f17 = pow3 / fArr2[0];
                float f18 = signum2 / fArr2[1];
                float signum3 = ((Math.signum(f15) * f16) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f15) * 27.13d) / (400.0d - Math.abs(f15))), 2.380952380952381d))) / fArr2[2];
                float[][] fArr3 = e4.e.f2716k;
                float[] fArr4 = fArr3[0];
                float f19 = (fArr4[2] * signum3) + (fArr4[1] * f18) + (fArr4[0] * f17);
                float[] fArr5 = fArr3[1];
                float f20 = fArr5[1] * f18;
                float f21 = fArr5[2] * signum3;
                float f22 = f17 * fArr3[2][0];
                return z.a.a(f19, f21 + f20 + (fArr5[0] * f17), (signum3 * fArr[2]) + (f18 * fArr[1]) + f22);
            }
        }
        f5 = 0.0f;
        float pow4 = (float) Math.pow(f5 / Math.pow(1.64d - Math.pow(0.29d, rVar.f5577f), 0.73d), 1.1111111111111112d);
        double d62 = (this.f5536a * 3.1415927f) / 180.0f;
        float pow22 = rVar.f5572a * ((float) Math.pow(f7 / 100.0d, (1.0d / rVar.f5575d) / rVar.f5581j));
        float cos3 = ((float) (Math.cos(2.0d + d62) + 3.8d)) * 0.25f * 3846.1538f * rVar.f5576e * rVar.f5574c;
        float f82 = pow22 / rVar.f5573b;
        float sin2 = (float) Math.sin(d62);
        float cos22 = (float) Math.cos(d62);
        float f92 = (((0.305f + f82) * 23.0f) * pow4) / (((pow4 * 108.0f) * sin2) + (((11.0f * pow4) * cos22) + (cos3 * 23.0f)));
        float f102 = cos22 * f92;
        float f112 = f92 * sin2;
        float f122 = f82 * 460.0f;
        float f132 = ((288.0f * f112) + ((451.0f * f102) + f122)) / 1403.0f;
        float f142 = ((f122 - (891.0f * f102)) - (261.0f * f112)) / 1403.0f;
        float f152 = ((f122 - (f102 * 220.0f)) - (f112 * 6300.0f)) / 1403.0f;
        float max2 = (float) Math.max(0.0d, (Math.abs(f132) * 27.13d) / (400.0d - Math.abs(f132)));
        float signum4 = Math.signum(f132);
        float f162 = 100.0f / rVar.f5579h;
        float pow32 = signum4 * f162 * ((float) Math.pow(max2, 2.380952380952381d));
        float signum22 = Math.signum(f142) * f162 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f142) * 27.13d) / (400.0d - Math.abs(f142))), 2.380952380952381d));
        float[] fArr22 = rVar.f5578g;
        float f172 = pow32 / fArr22[0];
        float f182 = signum22 / fArr22[1];
        float signum32 = ((Math.signum(f152) * f162) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f152) * 27.13d) / (400.0d - Math.abs(f152))), 2.380952380952381d))) / fArr22[2];
        float[][] fArr32 = e4.e.f2716k;
        float[] fArr42 = fArr32[0];
        float f192 = (fArr42[2] * signum32) + (fArr42[1] * f182) + (fArr42[0] * f172);
        float[] fArr52 = fArr32[1];
        float f202 = fArr52[1] * f182;
        float f212 = fArr52[2] * signum32;
        float f222 = f172 * fArr32[2][0];
        return z.a.a(f192, f212 + f202 + (fArr52[0] * f172), (signum32 * fArr[2]) + (f182 * fArr[1]) + f222);
    }
}
