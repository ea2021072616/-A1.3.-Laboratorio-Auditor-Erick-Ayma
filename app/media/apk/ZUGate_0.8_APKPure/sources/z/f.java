package z;

import android.graphics.Path;
import android.util.Log;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public char f5754a;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f5755b;

    public f(char c5, float[] fArr) {
        this.f5754a = c5;
        this.f5755b = fArr;
    }

    public static void a(Path path, float f5, float f6, float f7, float f8, float f9, float f10, float f11, boolean z4, boolean z5) {
        double d5;
        double d6;
        double radians = Math.toRadians(f11);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d7 = f5;
        double d8 = f6;
        double d9 = (d8 * sin) + (d7 * cos);
        double d10 = d7;
        double d11 = f9;
        double d12 = d9 / d11;
        double d13 = f10;
        double d14 = ((d8 * cos) + ((-f5) * sin)) / d13;
        double d15 = d8;
        double d16 = f8;
        double d17 = ((d16 * sin) + (f7 * cos)) / d11;
        double d18 = ((d16 * cos) + ((-f7) * sin)) / d13;
        double d19 = d12 - d17;
        double d20 = d14 - d18;
        double d21 = (d12 + d17) / 2.0d;
        double d22 = (d14 + d18) / 2.0d;
        double d23 = (d20 * d20) + (d19 * d19);
        if (d23 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d24 = (1.0d / d23) - 0.25d;
        if (d24 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d23);
            float sqrt = (float) (Math.sqrt(d23) / 1.99999d);
            a(path, f5, f6, f7, f8, f9 * sqrt, f10 * sqrt, f11, z4, z5);
            return;
        }
        double sqrt2 = Math.sqrt(d24);
        double d25 = d19 * sqrt2;
        double d26 = sqrt2 * d20;
        if (z4 == z5) {
            d5 = d21 - d26;
            d6 = d22 + d25;
        } else {
            d5 = d21 + d26;
            d6 = d22 - d25;
        }
        double atan2 = Math.atan2(d14 - d6, d12 - d5);
        double atan22 = Math.atan2(d18 - d6, d17 - d5) - atan2;
        int i5 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
        if (z5 != (i5 >= 0)) {
            atan22 = i5 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        double d27 = d5 * d11;
        double d28 = d6 * d13;
        double d29 = (d27 * cos) - (d28 * sin);
        double d30 = (d28 * cos) + (d27 * sin);
        int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
        double cos2 = Math.cos(radians);
        double sin2 = Math.sin(radians);
        double cos3 = Math.cos(atan2);
        double sin3 = Math.sin(atan2);
        double d31 = -d11;
        double d32 = d31 * cos2;
        double d33 = d13 * sin2;
        double d34 = (d32 * sin3) - (d33 * cos3);
        double d35 = d31 * sin2;
        double d36 = d13 * cos2;
        double d37 = (cos3 * d36) + (sin3 * d35);
        double d38 = d36;
        double d39 = atan22 / ceil;
        int i6 = 0;
        while (i6 < ceil) {
            double d40 = atan2 + d39;
            double sin4 = Math.sin(d40);
            double cos4 = Math.cos(d40);
            double d41 = d39;
            double d42 = (((d11 * cos2) * cos4) + d29) - (d33 * sin4);
            double d43 = d38;
            double d44 = d29;
            double d45 = (d43 * sin4) + (d11 * sin2 * cos4) + d30;
            double d46 = (d32 * sin4) - (d33 * cos4);
            double d47 = (cos4 * d43) + (sin4 * d35);
            double d48 = d40 - atan2;
            double tan = Math.tan(d48 / 2.0d);
            double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d48)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d34 * sqrt3) + d10), (float) ((d37 * sqrt3) + d15), (float) (d42 - (sqrt3 * d46)), (float) (d45 - (sqrt3 * d47)), (float) d42, (float) d45);
            i6++;
            atan2 = d40;
            d35 = d35;
            cos2 = cos2;
            ceil = ceil;
            d37 = d47;
            d11 = d11;
            d34 = d46;
            d10 = d42;
            d15 = d45;
            d29 = d44;
            d39 = d41;
            d38 = d43;
        }
    }

    public static void b(f[] fVarArr, Path path) {
        int i5;
        int i6;
        char c5;
        f fVar;
        int i7;
        int i8;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        f[] fVarArr2 = fVarArr;
        float[] fArr = new float[6];
        int length = fVarArr2.length;
        int i9 = 0;
        int i10 = 0;
        char c6 = 'm';
        while (i10 < length) {
            f fVar2 = fVarArr2[i10];
            char c7 = fVar2.f5754a;
            float f23 = fArr[i9];
            float f24 = fArr[1];
            float f25 = fArr[2];
            float f26 = fArr[3];
            float f27 = fArr[4];
            float f28 = fArr[5];
            switch (c7) {
                case 'A':
                case 'a':
                    i5 = 7;
                    break;
                case 'C':
                case 'c':
                    i5 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i5 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i5 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f27, f28);
                    f23 = f27;
                    f25 = f23;
                    f24 = f28;
                    f26 = f24;
                default:
                    i5 = 2;
                    break;
            }
            float f29 = f27;
            float f30 = f28;
            float f31 = f23;
            float f32 = f24;
            int i11 = i9;
            while (true) {
                float[] fArr2 = fVar2.f5755b;
                if (i11 < fArr2.length) {
                    if (c7 != 'A') {
                        if (c7 == 'C') {
                            i6 = i11;
                            c5 = c7;
                            fVar = fVar2;
                            i7 = i10;
                            i8 = length;
                            int i12 = i6 + 2;
                            int i13 = i6 + 3;
                            int i14 = i6 + 4;
                            int i15 = i6 + 5;
                            path.cubicTo(fArr2[i6 + 0], fArr2[i6 + 1], fArr2[i12], fArr2[i13], fArr2[i14], fArr2[i15]);
                            float f33 = fArr2[i14];
                            f32 = fArr2[i15];
                            f31 = f33;
                            f25 = fArr2[i12];
                            f26 = fArr2[i13];
                        } else if (c7 == 'H') {
                            i6 = i11;
                            c5 = c7;
                            fVar = fVar2;
                            i7 = i10;
                            i8 = length;
                            int i16 = i6 + 0;
                            path.lineTo(fArr2[i16], f32);
                            f31 = fArr2[i16];
                        } else if (c7 == 'Q') {
                            i6 = i11;
                            c5 = c7;
                            fVar = fVar2;
                            i7 = i10;
                            i8 = length;
                            int i17 = i6 + 0;
                            float f34 = fArr2[i17];
                            int i18 = i6 + 1;
                            int i19 = i6 + 2;
                            int i20 = i6 + 3;
                            path.quadTo(f34, fArr2[i18], fArr2[i19], fArr2[i20]);
                            float f35 = fArr2[i17];
                            float f36 = fArr2[i18];
                            f31 = fArr2[i19];
                            f32 = fArr2[i20];
                            f25 = f35;
                            f26 = f36;
                        } else if (c7 == 'V') {
                            i6 = i11;
                            c5 = c7;
                            fVar = fVar2;
                            i7 = i10;
                            i8 = length;
                            int i21 = i6 + 0;
                            path.lineTo(f31, fArr2[i21]);
                            f32 = fArr2[i21];
                        } else if (c7 != 'a') {
                            if (c7 != 'c') {
                                if (c7 == 'h') {
                                    i6 = i11;
                                    c5 = c7;
                                    i8 = length;
                                    int i22 = i6 + 0;
                                    path.rLineTo(fArr2[i22], 0.0f);
                                    f31 += fArr2[i22];
                                } else if (c7 != 'q') {
                                    if (c7 != 'v') {
                                        if (c7 != 'L') {
                                            if (c7 == 'M') {
                                                i6 = i11;
                                                c5 = c7;
                                                i8 = length;
                                                f14 = fArr2[i6 + 0];
                                                f15 = fArr2[i6 + 1];
                                                if (i6 > 0) {
                                                    path.lineTo(f14, f15);
                                                } else {
                                                    path.moveTo(f14, f15);
                                                    f29 = f14;
                                                    f30 = f15;
                                                }
                                            } else if (c7 == 'S') {
                                                i6 = i11;
                                                c5 = c7;
                                                i8 = length;
                                                float f37 = f32;
                                                if (c6 == 'c' || c6 == 's' || c6 == 'C' || c6 == 'S') {
                                                    f16 = (f37 * 2.0f) - f26;
                                                    f17 = (f31 * 2.0f) - f25;
                                                } else {
                                                    f17 = f31;
                                                    f16 = f37;
                                                }
                                                int i23 = i6 + 0;
                                                int i24 = i6 + 1;
                                                int i25 = i6 + 2;
                                                int i26 = i6 + 3;
                                                path.cubicTo(f17, f16, fArr2[i23], fArr2[i24], fArr2[i25], fArr2[i26]);
                                                f6 = fArr2[i23];
                                                float f38 = fArr2[i24];
                                                f11 = fArr2[i25];
                                                f10 = fArr2[i26];
                                                f26 = f38;
                                                f31 = f11;
                                                f32 = f10;
                                                f25 = f6;
                                            } else if (c7 == 'T') {
                                                i6 = i11;
                                                c5 = c7;
                                                i8 = length;
                                                float f39 = f32;
                                                if (c6 == 'q' || c6 == 't' || c6 == 'Q' || c6 == 'T') {
                                                    f31 = (f31 * 2.0f) - f25;
                                                    f18 = (f39 * 2.0f) - f26;
                                                } else {
                                                    f18 = f39;
                                                }
                                                int i27 = i6 + 0;
                                                float f40 = fArr2[i27];
                                                int i28 = i6 + 1;
                                                path.quadTo(f31, f18, f40, fArr2[i28]);
                                                f26 = f18;
                                                fVar = fVar2;
                                                i7 = i10;
                                                f25 = f31;
                                                f31 = fArr2[i27];
                                                f32 = fArr2[i28];
                                            } else if (c7 == 'l') {
                                                i6 = i11;
                                                c5 = c7;
                                                i8 = length;
                                                f12 = f32;
                                                int i29 = i6 + 0;
                                                float f41 = fArr2[i29];
                                                int i30 = i6 + 1;
                                                path.rLineTo(f41, fArr2[i30]);
                                                f31 += fArr2[i29];
                                                f13 = fArr2[i30];
                                            } else if (c7 == 'm') {
                                                i6 = i11;
                                                c5 = c7;
                                                i8 = length;
                                                float f42 = fArr2[i6 + 0];
                                                f31 += f42;
                                                float f43 = fArr2[i6 + 1];
                                                f32 += f43;
                                                if (i6 > 0) {
                                                    path.rLineTo(f42, f43);
                                                } else {
                                                    path.rMoveTo(f42, f43);
                                                    f30 = f32;
                                                    f29 = f31;
                                                }
                                            } else if (c7 != 's') {
                                                if (c7 == 't') {
                                                    if (c6 == 'q' || c6 == 't' || c6 == 'Q' || c6 == 'T') {
                                                        f21 = f31 - f25;
                                                        f22 = f32 - f26;
                                                    } else {
                                                        f22 = 0.0f;
                                                        f21 = 0.0f;
                                                    }
                                                    int i31 = i11 + 0;
                                                    int i32 = i11 + 1;
                                                    path.rQuadTo(f21, f22, fArr2[i31], fArr2[i32]);
                                                    float f44 = f21 + f31;
                                                    float f45 = f22 + f32;
                                                    f31 += fArr2[i31];
                                                    f32 += fArr2[i32];
                                                    f26 = f45;
                                                    f25 = f44;
                                                }
                                                i6 = i11;
                                                c5 = c7;
                                                i8 = length;
                                            } else {
                                                if (c6 == 'c' || c6 == 's' || c6 == 'C' || c6 == 'S') {
                                                    f19 = f31 - f25;
                                                    f20 = f32 - f26;
                                                } else {
                                                    f19 = 0.0f;
                                                    f20 = 0.0f;
                                                }
                                                int i33 = i11 + 0;
                                                float f46 = fArr2[i33];
                                                int i34 = i11 + 1;
                                                float f47 = fArr2[i34];
                                                int i35 = i11 + 2;
                                                float f48 = fArr2[i35];
                                                int i36 = i11 + 3;
                                                float f49 = fArr2[i36];
                                                float f50 = f19;
                                                i6 = i11;
                                                i8 = length;
                                                f5 = f32;
                                                c5 = c7;
                                                path.rCubicTo(f50, f20, f46, f47, f48, f49);
                                                f6 = fArr2[i33] + f31;
                                                f7 = fArr2[i34] + f5;
                                                f8 = f31 + fArr2[i35];
                                                f9 = fArr2[i36];
                                            }
                                            f31 = f29;
                                            f32 = f30;
                                        } else {
                                            i6 = i11;
                                            c5 = c7;
                                            i8 = length;
                                            int i37 = i6 + 0;
                                            float f51 = fArr2[i37];
                                            int i38 = i6 + 1;
                                            path.lineTo(f51, fArr2[i38]);
                                            f14 = fArr2[i37];
                                            f15 = fArr2[i38];
                                        }
                                        f31 = f14;
                                        f32 = f15;
                                    } else {
                                        i6 = i11;
                                        c5 = c7;
                                        i8 = length;
                                        f12 = f32;
                                        int i39 = i6 + 0;
                                        path.rLineTo(0.0f, fArr2[i39]);
                                        f13 = fArr2[i39];
                                    }
                                    f32 = f12 + f13;
                                } else {
                                    i6 = i11;
                                    c5 = c7;
                                    i8 = length;
                                    f5 = f32;
                                    int i40 = i6 + 0;
                                    float f52 = fArr2[i40];
                                    int i41 = i6 + 1;
                                    int i42 = i6 + 2;
                                    int i43 = i6 + 3;
                                    path.rQuadTo(f52, fArr2[i41], fArr2[i42], fArr2[i43]);
                                    f6 = fArr2[i40] + f31;
                                    f7 = fArr2[i41] + f5;
                                    f8 = f31 + fArr2[i42];
                                    f9 = fArr2[i43];
                                }
                                fVar = fVar2;
                                i7 = i10;
                            } else {
                                i6 = i11;
                                c5 = c7;
                                i8 = length;
                                f5 = f32;
                                int i44 = i6 + 2;
                                int i45 = i6 + 3;
                                int i46 = i6 + 4;
                                int i47 = i6 + 5;
                                path.rCubicTo(fArr2[i6 + 0], fArr2[i6 + 1], fArr2[i44], fArr2[i45], fArr2[i46], fArr2[i47]);
                                f6 = fArr2[i44] + f31;
                                f7 = fArr2[i45] + f5;
                                f8 = f31 + fArr2[i46];
                                f9 = fArr2[i47];
                            }
                            f10 = f5 + f9;
                            f26 = f7;
                            f11 = f8;
                            f31 = f11;
                            f32 = f10;
                            f25 = f6;
                            fVar = fVar2;
                            i7 = i10;
                        } else {
                            i6 = i11;
                            c5 = c7;
                            i8 = length;
                            float f53 = f32;
                            int i48 = i6 + 5;
                            int i49 = i6 + 6;
                            fVar = fVar2;
                            i7 = i10;
                            a(path, f31, f53, fArr2[i48] + f31, fArr2[i49] + f53, fArr2[i6 + 0], fArr2[i6 + 1], fArr2[i6 + 2], fArr2[i6 + 3] != 0.0f, fArr2[i6 + 4] != 0.0f);
                            f31 += fArr2[i48];
                            f32 = f53 + fArr2[i49];
                        }
                        i11 = i6 + i5;
                        c6 = c5;
                        c7 = c6;
                        i10 = i7;
                        length = i8;
                        fVar2 = fVar;
                    } else {
                        i6 = i11;
                        c5 = c7;
                        fVar = fVar2;
                        i7 = i10;
                        i8 = length;
                        int i50 = i6 + 5;
                        int i51 = i6 + 6;
                        a(path, f31, f32, fArr2[i50], fArr2[i51], fArr2[i6 + 0], fArr2[i6 + 1], fArr2[i6 + 2], fArr2[i6 + 3] != 0.0f, fArr2[i6 + 4] != 0.0f);
                        f31 = fArr2[i50];
                        f32 = fArr2[i51];
                    }
                    f26 = f32;
                    f25 = f31;
                    i11 = i6 + i5;
                    c6 = c5;
                    c7 = c6;
                    i10 = i7;
                    length = i8;
                    fVar2 = fVar;
                }
            }
            fArr[0] = f31;
            fArr[1] = f32;
            fArr[2] = f25;
            fArr[3] = f26;
            fArr[4] = f29;
            fArr[5] = f30;
            c6 = fVar2.f5754a;
            i10++;
            i9 = 0;
            length = length;
            fVarArr2 = fVarArr;
        }
    }

    public f(f fVar) {
        this.f5754a = fVar.f5754a;
        float[] fArr = fVar.f5755b;
        this.f5755b = p2.a.m(fArr, fArr.length);
    }
}
