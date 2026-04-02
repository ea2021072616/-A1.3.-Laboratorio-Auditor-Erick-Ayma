package h0;

import android.os.Build;
import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public final class u1 {

    /* renamed from: a  reason: collision with root package name */
    public final t1 f3214a;

    public u1(int i5, Interpolator interpolator, long j5) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f3214a = new s1(c0.i(i5, interpolator, j5));
        } else {
            this.f3214a = new q1(i5, interpolator, j5);
        }
    }

    public u1(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f3214a = new s1(windowInsetsAnimation);
        }
    }
}
