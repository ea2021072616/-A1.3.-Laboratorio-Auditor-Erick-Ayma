package h0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import com.github.appintro.R;
/* loaded from: classes.dex */
public abstract class o0 {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static h2 b(View view, h2 h2Var, Rect rect) {
        WindowInsets h5 = h2Var.h();
        if (h5 != null) {
            return h2.i(view, view.computeSystemWindowInsets(h5, rect));
        }
        rect.setEmpty();
        return h2Var;
    }

    public static boolean c(View view, float f5, float f6, boolean z4) {
        return view.dispatchNestedFling(f5, f6, z4);
    }

    public static boolean d(View view, float f5, float f6) {
        return view.dispatchNestedPreFling(f5, f6);
    }

    public static boolean e(View view, int i5, int i6, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i5, i6, iArr, iArr2);
    }

    public static boolean f(View view, int i5, int i6, int i7, int i8, int[] iArr) {
        return view.dispatchNestedScroll(i5, i6, i7, i8, iArr);
    }

    public static ColorStateList g(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode h(View view) {
        return view.getBackgroundTintMode();
    }

    public static float i(View view) {
        return view.getElevation();
    }

    public static h2 j(View view) {
        if (v1.f3218d && view.isAttachedToWindow()) {
            try {
                Object obj = v1.f3215a.get(view.getRootView());
                if (obj != null) {
                    Rect rect = (Rect) v1.f3216b.get(obj);
                    Rect rect2 = (Rect) v1.f3217c.get(obj);
                    if (rect != null && rect2 != null) {
                        int i5 = Build.VERSION.SDK_INT;
                        z1 y1Var = i5 >= 30 ? new y1() : i5 >= 29 ? new x1() : new w1();
                        y1Var.e(z.c.b(rect.left, rect.top, rect.right, rect.bottom));
                        y1Var.g(z.c.b(rect2.left, rect2.top, rect2.right, rect2.bottom));
                        h2 b5 = y1Var.b();
                        b5.f3144a.p(b5);
                        b5.f3144a.d(view.getRootView());
                        return b5;
                    }
                }
            } catch (IllegalAccessException e5) {
                Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e5.getMessage(), e5);
            }
        }
        return null;
    }

    public static String k(View view) {
        return view.getTransitionName();
    }

    public static float l(View view) {
        return view.getTranslationZ();
    }

    public static float m(View view) {
        return view.getZ();
    }

    public static boolean n(View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean o(View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean p(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void q(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void r(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void s(View view, float f5) {
        view.setElevation(f5);
    }

    public static void t(View view, boolean z4) {
        view.setNestedScrollingEnabled(z4);
    }

    public static void u(View view, x xVar) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, xVar);
        }
        if (xVar == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new n0(view, xVar));
        }
    }

    public static void v(View view, String str) {
        view.setTransitionName(str);
    }

    public static void w(View view, float f5) {
        view.setTranslationZ(f5);
    }

    public static void x(View view, float f5) {
        view.setZ(f5);
    }

    public static boolean y(View view, int i5) {
        return view.startNestedScroll(i5);
    }

    public static void z(View view) {
        view.stopNestedScroll();
    }
}
