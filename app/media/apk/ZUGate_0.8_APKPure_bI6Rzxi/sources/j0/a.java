package j0;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
/* loaded from: classes.dex */
public abstract class a {
    public static Interpolator a(float f5, float f6) {
        return new PathInterpolator(f5, f6);
    }

    public static Interpolator b(float f5, float f6, float f7, float f8) {
        return new PathInterpolator(f5, f6, f7, f8);
    }

    public static Interpolator c(Path path) {
        return new PathInterpolator(path);
    }
}
