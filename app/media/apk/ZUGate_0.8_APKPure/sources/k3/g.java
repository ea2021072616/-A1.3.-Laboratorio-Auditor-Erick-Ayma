package k3;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.github.appintro.R;
/* loaded from: classes.dex */
public final class g extends a {

    /* renamed from: g  reason: collision with root package name */
    public final float f3652g;

    /* renamed from: h  reason: collision with root package name */
    public final float f3653h;

    public g(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f3652g = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.f3653h = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    public final AnimatorSet a() {
        AnimatorSet animatorSet = new AnimatorSet();
        View view = this.f3641b;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, View.SCALE_Y, 1.0f));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i5), View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new v0.b());
        return animatorSet;
    }

    public final void b(float f5) {
        float interpolation = this.f3640a.getInterpolation(f5);
        View view = this.f3641b;
        float width = view.getWidth();
        float height = view.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f6 = this.f3652g / width;
        LinearInterpolator linearInterpolator = x2.a.f5484a;
        float f7 = 1.0f - (((f6 - 0.0f) * interpolation) + 0.0f);
        float f8 = 1.0f - ((((this.f3653h / height) - 0.0f) * interpolation) + 0.0f);
        view.setScaleX(f7);
        view.setPivotY(height);
        view.setScaleY(f8);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                View childAt = viewGroup.getChildAt(i5);
                childAt.setPivotY(-childAt.getTop());
                childAt.setScaleY(f8 != 0.0f ? f7 / f8 : 1.0f);
            }
        }
    }
}
