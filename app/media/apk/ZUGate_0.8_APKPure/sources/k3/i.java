package k3;

import android.content.res.Resources;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.github.appintro.R;
import h0.z0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class i extends a {

    /* renamed from: g  reason: collision with root package name */
    public final float f3657g;

    /* renamed from: h  reason: collision with root package name */
    public final float f3658h;

    /* renamed from: i  reason: collision with root package name */
    public final float f3659i;

    public i(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f3657g = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.f3658h = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.f3659i = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    public final void a(float f5, int i5, boolean z4) {
        float interpolation = this.f3640a.getInterpolation(f5);
        WeakHashMap weakHashMap = z0.f3233a;
        View view = this.f3641b;
        boolean z5 = (Gravity.getAbsoluteGravity(i5, view.getLayoutDirection()) & 3) == 3;
        boolean z6 = z4 == z5;
        int width = view.getWidth();
        int height = view.getHeight();
        float f6 = width;
        if (f6 > 0.0f) {
            float f7 = height;
            if (f7 <= 0.0f) {
                return;
            }
            float f8 = this.f3657g / f6;
            float f9 = this.f3658h / f6;
            float f10 = this.f3659i / f7;
            if (z5) {
                f6 = 0.0f;
            }
            view.setPivotX(f6);
            if (!z6) {
                f9 = -f8;
            }
            LinearInterpolator linearInterpolator = x2.a.f5484a;
            float f11 = ((f9 - 0.0f) * interpolation) + 0.0f;
            float f12 = f11 + 1.0f;
            view.setScaleX(f12);
            float f13 = 1.0f - (((f10 - 0.0f) * interpolation) + 0.0f);
            view.setScaleY(f13);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                    View childAt = viewGroup.getChildAt(i6);
                    childAt.setPivotX(z5 ? childAt.getWidth() + (width - childAt.getRight()) : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f14 = z6 ? 1.0f - f11 : 1.0f;
                    float f15 = f13 != 0.0f ? (f12 / f13) * f14 : 1.0f;
                    childAt.setScaleX(f14);
                    childAt.setScaleY(f15);
                }
            }
        }
    }
}
