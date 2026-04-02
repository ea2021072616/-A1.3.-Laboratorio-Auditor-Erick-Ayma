package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public abstract class v1 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f549a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f550b = new int[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Rect f551c = new Rect();

    public static void a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 29 || i5 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f549a);
        } else {
            drawable.setState(f550b);
        }
        drawable.setState(state);
    }

    public static Rect b(Drawable drawable) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 29) {
            Insets a5 = u1.a(drawable);
            i5 = a5.left;
            i6 = a5.top;
            i7 = a5.right;
            i8 = a5.bottom;
            return new Rect(i5, i6, i7, i8);
        }
        if (drawable instanceof a0.g) {
            ((a0.h) ((a0.g) drawable)).getClass();
            drawable = null;
        }
        if (i9 >= 29) {
            boolean z4 = t1.f534a;
        } else if (t1.f534a) {
            try {
                Object invoke = t1.f535b.invoke(drawable, new Object[0]);
                if (invoke != null) {
                    return new Rect(t1.f536c.getInt(invoke), t1.f537d.getInt(invoke), t1.f538e.getInt(invoke), t1.f539f.getInt(invoke));
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return f551c;
    }

    public static PorterDuff.Mode c(int i5, PorterDuff.Mode mode) {
        if (i5 != 3) {
            if (i5 != 5) {
                if (i5 != 9) {
                    switch (i5) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}
