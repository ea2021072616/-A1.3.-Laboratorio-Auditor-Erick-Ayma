package h0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class p1 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final b3.g f3192a;

    /* renamed from: b  reason: collision with root package name */
    public h2 f3193b;

    public p1(View view, b3.g gVar) {
        h2 h2Var;
        this.f3192a = gVar;
        WeakHashMap weakHashMap = z0.f3233a;
        h2 a5 = p0.a(view);
        if (a5 != null) {
            int i5 = Build.VERSION.SDK_INT;
            h2Var = (i5 >= 30 ? new y1(a5) : i5 >= 29 ? new x1(a5) : new w1(a5)).b();
        } else {
            h2Var = null;
        }
        this.f3193b = h2Var;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        if (!view.isLaidOut()) {
            this.f3193b = h2.i(view, windowInsets);
            return q1.i(view, windowInsets);
        }
        h2 i5 = h2.i(view, windowInsets);
        if (this.f3193b == null) {
            WeakHashMap weakHashMap = z0.f3233a;
            this.f3193b = p0.a(view);
        }
        if (this.f3193b == null) {
            this.f3193b = i5;
            return q1.i(view, windowInsets);
        }
        b3.g j5 = q1.j(view);
        if (j5 == null || !Objects.equals(j5.f1647a, windowInsets)) {
            h2 h2Var = this.f3193b;
            int i6 = 0;
            for (int i7 = 1; i7 <= 256; i7 <<= 1) {
                if (!i5.a(i7).equals(h2Var.a(i7))) {
                    i6 |= i7;
                }
            }
            if (i6 == 0) {
                return q1.i(view, windowInsets);
            }
            h2 h2Var2 = this.f3193b;
            u1 u1Var = new u1(i6, (i6 & 8) != 0 ? i5.a(8).f5752d > h2Var2.a(8).f5752d ? q1.f3197e : q1.f3198f : q1.f3199g, 160L);
            t1 t1Var = u1Var.f3214a;
            t1Var.d(0.0f);
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(t1Var.a());
            z.c a5 = i5.a(i6);
            z.c a6 = h2Var2.a(i6);
            int min = Math.min(a5.f5749a, a6.f5749a);
            int i8 = a5.f5750b;
            int i9 = a6.f5750b;
            int min2 = Math.min(i8, i9);
            int i10 = a5.f5751c;
            int i11 = a6.f5751c;
            int min3 = Math.min(i10, i11);
            int i12 = a5.f5752d;
            int i13 = i6;
            int i14 = a6.f5752d;
            androidx.appcompat.widget.d0 d0Var = new androidx.appcompat.widget.d0(z.c.b(min, min2, min3, Math.min(i12, i14)), 4, z.c.b(Math.max(a5.f5749a, a6.f5749a), Math.max(i8, i9), Math.max(i10, i11), Math.max(i12, i14)));
            q1.f(view, windowInsets, false);
            duration.addUpdateListener(new n1(u1Var, i5, h2Var2, i13, view));
            duration.addListener(new j1(this, u1Var, view, 1));
            a0.a(view, new o1(view, u1Var, d0Var, duration));
            this.f3193b = i5;
            return q1.i(view, windowInsets);
        }
        return q1.i(view, windowInsets);
    }
}
