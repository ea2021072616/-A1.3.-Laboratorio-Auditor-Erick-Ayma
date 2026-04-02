package n3;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f4089a = {16842910, 16842919};

    /* renamed from: b  reason: collision with root package name */
    public static final String f4090b = a.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f4089a, 0)) != 0) {
                Log.w(f4090b, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return colorStateList;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean b(int[] iArr) {
        boolean z4 = false;
        boolean z5 = false;
        for (int i5 : iArr) {
            if (i5 == 16842910) {
                z4 = true;
            } else if (i5 == 16842908 || i5 == 16842919 || i5 == 16843623) {
                z5 = true;
            }
        }
        return z4 && z5;
    }
}
