package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.FloatRange;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MiscUtils.java */
/* loaded from: classes.dex */
public class bd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(bs bsVar, Path path) {
        path.reset();
        PointF a2 = bsVar.a();
        path.moveTo(a2.x, a2.y);
        PointF pointF = new PointF(a2.x, a2.y);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bsVar.c().size()) {
                break;
            }
            z zVar = bsVar.c().get(i2);
            PointF a3 = zVar.a();
            PointF b2 = zVar.b();
            PointF c2 = zVar.c();
            if (a3.equals(pointF) && b2.equals(c2)) {
                path.lineTo(c2.x, c2.y);
            } else {
                path.cubicTo(a3.x, a3.y, b2.x, b2.y, c2.x, c2.y);
            }
            pointF.set(c2.x, c2.y);
            i = i2 + 1;
        }
        if (bsVar.b()) {
            path.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return ((f2 - f) * f3) + f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double a(double d, double d2, @FloatRange(from = 0.0d, to = 1.0d) double d3) {
        return ((d2 - d) * d3) + d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (int) (i + ((i2 - i) * f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(float f, float f2) {
        return a((int) f, (int) f2);
    }

    static int a(int i, int i2) {
        return i - (b(i, i2) * i2);
    }

    private static int b(int i, int i2) {
        int i3 = i / i2;
        if ((i ^ i2) < 0 && i3 * i2 != i) {
            return i3 - 1;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }
}
