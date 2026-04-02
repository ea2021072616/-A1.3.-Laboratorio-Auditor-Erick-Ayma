package x2;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final LinearInterpolator f5484a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final v0.b f5485b = new v0.b();

    /* renamed from: c  reason: collision with root package name */
    public static final v0.a f5486c = new v0.a();

    /* renamed from: d  reason: collision with root package name */
    public static final v0.c f5487d = new v0.c();

    static {
        new DecelerateInterpolator();
    }

    public static float a(float f5, float f6, float f7, float f8, float f9) {
        if (f9 <= f7) {
            return f5;
        }
        if (f9 >= f8) {
            return f6;
        }
        return ((f6 - f5) * ((f9 - f7) / (f8 - f7))) + f5;
    }

    public static int b(int i5, float f5, int i6) {
        return Math.round(f5 * (i6 - i5)) + i5;
    }
}
