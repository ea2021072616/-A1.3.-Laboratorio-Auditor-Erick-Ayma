package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.Closeable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class ch {
    private static DisplayMetrics d;

    /* renamed from: a  reason: collision with root package name */
    private static final PathMeasure f517a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    private static final Path f518b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private static final Path f519c = new Path();
    private static final float[] e = new float[4];
    private static final float f = (float) Math.sqrt(2.0d);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            path.cubicTo(pointF.x + pointF3.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context) {
        if (d == null) {
            d = new DisplayMetrics();
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(d);
        return d.widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Context context) {
        if (d == null) {
            d = new DisplayMetrics();
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(d);
        return d.heightPixels;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(Matrix matrix) {
        e[0] = 0.0f;
        e[1] = 0.0f;
        e[2] = f;
        e[3] = f;
        matrix.mapPoints(e);
        return ((float) Math.hypot(e[2] - e[0], e[3] - e[1])) / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Path path, @Nullable cg cgVar) {
        if (cgVar != null) {
            a(path, cgVar.c().b().floatValue() / 100.0f, cgVar.d().b().floatValue() / 100.0f, cgVar.f().b().floatValue() / 360.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Path path, float f2, float f3, float f4) {
        f517a.setPath(path, false);
        float length = f517a.getLength();
        if (length != 0.0f && Math.abs((f3 - f2) - 1.0f) >= 0.01d) {
            float f5 = length * f2;
            float f6 = length * f3;
            float min = Math.min(f5, f6);
            float max = Math.max(f5, f6);
            float f7 = f4 * length;
            float f8 = min + f7;
            float f9 = max + f7;
            if (f8 >= length && f9 >= length) {
                f8 = bd.a(f8, length);
                f9 = bd.a(f9, length);
            }
            if (f8 < 0.0f) {
                f8 = bd.a(f8, length);
            }
            if (f9 < 0.0f) {
                f9 = bd.a(f9, length);
            }
            if (f8 == f9) {
                path.reset();
                return;
            }
            if (f8 >= f9) {
                f8 -= length;
            }
            f518b.reset();
            f517a.getSegment(f8, f9, f518b, true);
            if (f9 > length) {
                f519c.reset();
                f517a.getSegment(0.0f, f9 % length, f519c, true);
                f518b.addPath(f519c);
            } else if (f8 < 0.0f) {
                f519c.reset();
                f517a.getSegment(f8 + length, length, f519c, true);
                f518b.addPath(f519c);
            }
            path.set(f518b);
        }
    }
}
