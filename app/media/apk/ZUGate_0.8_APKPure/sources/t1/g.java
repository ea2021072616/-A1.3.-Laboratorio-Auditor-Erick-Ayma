package t1;

import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static DisplayMetrics f5003a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f5004b = 50;

    /* renamed from: c  reason: collision with root package name */
    public static int f5005c = 8000;

    /* renamed from: d  reason: collision with root package name */
    public static final Rect f5006d;

    /* renamed from: e  reason: collision with root package name */
    public static final Paint.FontMetrics f5007e;

    /* renamed from: f  reason: collision with root package name */
    public static final Rect f5008f;

    /* renamed from: g  reason: collision with root package name */
    public static final n1.b f5009g;

    /* renamed from: h  reason: collision with root package name */
    public static final Rect f5010h;

    /* renamed from: i  reason: collision with root package name */
    public static final Paint.FontMetrics f5011i;

    static {
        Double.longBitsToDouble(1L);
        Float.intBitsToFloat(1);
        f5006d = new Rect();
        f5007e = new Paint.FontMetrics();
        f5008f = new Rect();
        f5009g = new n1.b(1);
        new Rect();
        f5010h = new Rect();
        f5011i = new Paint.FontMetrics();
    }

    public static int a(Paint paint, String str) {
        Rect rect = f5006d;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static a b(Paint paint, String str) {
        a b5 = a.b(0.0f, 0.0f);
        Rect rect = f5008f;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        b5.f4982b = rect.width();
        b5.f4983c = rect.height();
        return b5;
    }

    public static float c(float f5) {
        DisplayMetrics displayMetrics = f5003a;
        if (displayMetrics == null) {
            Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
            return f5;
        }
        return f5 * displayMetrics.density;
    }

    public static float d(double d5) {
        if (Double.isInfinite(d5) || Double.isNaN(d5) || d5 == 0.0d) {
            return 0.0f;
        }
        float pow = (float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d5 < 0.0d ? -d5 : d5))));
        return ((float) Math.round(d5 * pow)) / pow;
    }
}
