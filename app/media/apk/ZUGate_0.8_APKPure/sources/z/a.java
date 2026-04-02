package z;

import android.graphics.Color;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal f5747a = new ThreadLocal();

    public static int a(double d5, double d6, double d7) {
        double d8 = (((-0.4986d) * d7) + (((-1.5372d) * d6) + (3.2406d * d5))) / 100.0d;
        double d9 = ((0.0415d * d7) + ((1.8758d * d6) + ((-0.9689d) * d5))) / 100.0d;
        double d10 = ((1.057d * d7) + (((-0.204d) * d6) + (0.0557d * d5))) / 100.0d;
        double pow = d8 > 0.0031308d ? (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d : d8 * 12.92d;
        double pow2 = d9 > 0.0031308d ? (Math.pow(d9, 0.4166666666666667d) * 1.055d) - 0.055d : d9 * 12.92d;
        double pow3 = d10 > 0.0031308d ? (Math.pow(d10, 0.4166666666666667d) * 1.055d) - 0.055d : d10 * 12.92d;
        int round = (int) Math.round(pow * 255.0d);
        int min = round < 0 ? 0 : Math.min(round, 255);
        int round2 = (int) Math.round(pow2 * 255.0d);
        int min2 = round2 < 0 ? 0 : Math.min(round2, 255);
        int round3 = (int) Math.round(pow3 * 255.0d);
        return Color.rgb(min, min2, round3 >= 0 ? Math.min(round3, 255) : 0);
    }

    public static int b(int i5, int i6) {
        int i7;
        int i8;
        int alpha = Color.alpha(i6);
        int alpha2 = Color.alpha(i5);
        int i9 = 255 - alpha2;
        int i10 = 255 - (((255 - alpha) * i9) / 255);
        int red = Color.red(i5);
        int red2 = Color.red(i6);
        int i11 = 0;
        if (i10 == 0) {
            i7 = 0;
        } else {
            i7 = (((red2 * alpha) * i9) + ((red * 255) * alpha2)) / (i10 * 255);
        }
        int green = Color.green(i5);
        int green2 = Color.green(i6);
        if (i10 == 0) {
            i8 = 0;
        } else {
            i8 = (((green2 * alpha) * i9) + ((green * 255) * alpha2)) / (i10 * 255);
        }
        int blue = Color.blue(i5);
        int blue2 = Color.blue(i6);
        if (i10 != 0) {
            i11 = (((blue2 * alpha) * i9) + ((blue * 255) * alpha2)) / (i10 * 255);
        }
        return Color.argb(i10, i7, i8, i11);
    }

    public static int c(int i5, int i6) {
        if (i6 < 0 || i6 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i5 & 16777215) | (i6 << 24);
    }
}
