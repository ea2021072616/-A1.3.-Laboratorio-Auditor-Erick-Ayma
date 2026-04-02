package h0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.Collections;
/* loaded from: classes.dex */
public final class n1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u1 f3178a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h2 f3179b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h2 f3180c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f3181d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ View f3182e;

    public n1(u1 u1Var, h2 h2Var, h2 h2Var2, int i5, View view) {
        this.f3178a = u1Var;
        this.f3179b = h2Var;
        this.f3180c = h2Var2;
        this.f3181d = i5;
        this.f3182e = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        u1 u1Var = this.f3178a;
        u1Var.f3214a.d(animatedFraction);
        float b5 = u1Var.f3214a.b();
        PathInterpolator pathInterpolator = q1.f3197e;
        int i5 = Build.VERSION.SDK_INT;
        h2 h2Var = this.f3179b;
        z1 y1Var = i5 >= 30 ? new y1(h2Var) : i5 >= 29 ? new x1(h2Var) : new w1(h2Var);
        for (int i6 = 1; i6 <= 256; i6 <<= 1) {
            if ((this.f3181d & i6) == 0) {
                y1Var.c(i6, h2Var.a(i6));
            } else {
                z.c a5 = h2Var.a(i6);
                z.c a6 = this.f3180c.a(i6);
                float f5 = 1.0f - b5;
                y1Var.c(i6, h2.f(a5, (int) (((a5.f5749a - a6.f5749a) * f5) + 0.5d), (int) (((a5.f5750b - a6.f5750b) * f5) + 0.5d), (int) (((a5.f5751c - a6.f5751c) * f5) + 0.5d), (int) (((a5.f5752d - a6.f5752d) * f5) + 0.5d)));
            }
        }
        q1.g(this.f3182e, y1Var.b(), Collections.singletonList(u1Var));
    }
}
