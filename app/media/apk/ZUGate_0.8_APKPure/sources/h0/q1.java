package h0;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import com.github.appintro.R;
import java.util.List;
/* loaded from: classes.dex */
public final class q1 extends t1 {

    /* renamed from: e  reason: collision with root package name */
    public static final PathInterpolator f3197e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

    /* renamed from: f  reason: collision with root package name */
    public static final v0.a f3198f = new v0.a();

    /* renamed from: g  reason: collision with root package name */
    public static final DecelerateInterpolator f3199g = new DecelerateInterpolator();

    public static void e(View view) {
        b3.g j5 = j(view);
        if (j5 != null) {
            j5.f1648b.setTranslationY(0.0f);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                e(viewGroup.getChildAt(i5));
            }
        }
    }

    public static void f(View view, WindowInsets windowInsets, boolean z4) {
        b3.g j5 = j(view);
        if (j5 != null) {
            j5.f1647a = windowInsets;
            if (!z4) {
                View view2 = j5.f1648b;
                int[] iArr = j5.f1651e;
                view2.getLocationOnScreen(iArr);
                z4 = true;
                j5.f1649c = iArr[1];
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                f(viewGroup.getChildAt(i5), windowInsets, z4);
            }
        }
    }

    public static void g(View view, h2 h2Var, List list) {
        b3.g j5 = j(view);
        if (j5 != null) {
            j5.a(h2Var, list);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                g(viewGroup.getChildAt(i5), h2Var, list);
            }
        }
    }

    public static void h(View view, androidx.appcompat.widget.d0 d0Var) {
        b3.g j5 = j(view);
        if (j5 != null) {
            View view2 = j5.f1648b;
            int[] iArr = j5.f1651e;
            view2.getLocationOnScreen(iArr);
            int i5 = j5.f1649c - iArr[1];
            j5.f1650d = i5;
            view2.setTranslationY(i5);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                h(viewGroup.getChildAt(i6), d0Var);
            }
        }
    }

    public static WindowInsets i(View view, WindowInsets windowInsets) {
        return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    public static b3.g j(View view) {
        Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
        if (tag instanceof p1) {
            return ((p1) tag).f3192a;
        }
        return null;
    }
}
