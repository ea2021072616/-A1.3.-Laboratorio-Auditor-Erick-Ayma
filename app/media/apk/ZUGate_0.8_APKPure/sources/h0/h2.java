package h0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class h2 {

    /* renamed from: b  reason: collision with root package name */
    public static final h2 f3143b;

    /* renamed from: a  reason: collision with root package name */
    public final f2 f3144a;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f3143b = e2.f3125q;
        } else {
            f3143b = f2.f3129b;
        }
    }

    public h2(WindowInsets windowInsets) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            this.f3144a = new e2(this, windowInsets);
        } else if (i5 >= 29) {
            this.f3144a = new d2(this, windowInsets);
        } else if (i5 >= 28) {
            this.f3144a = new c2(this, windowInsets);
        } else {
            this.f3144a = new b2(this, windowInsets);
        }
    }

    public static z.c f(z.c cVar, int i5, int i6, int i7, int i8) {
        int max = Math.max(0, cVar.f5749a - i5);
        int max2 = Math.max(0, cVar.f5750b - i6);
        int max3 = Math.max(0, cVar.f5751c - i7);
        int max4 = Math.max(0, cVar.f5752d - i8);
        return (max == i5 && max2 == i6 && max3 == i7 && max4 == i8) ? cVar : z.c.b(max, max2, max3, max4);
    }

    public static h2 i(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        h2 h2Var = new h2(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = z0.f3233a;
            h2 a5 = p0.a(view);
            f2 f2Var = h2Var.f3144a;
            f2Var.p(a5);
            f2Var.d(view.getRootView());
        }
        return h2Var;
    }

    public final z.c a(int i5) {
        return this.f3144a.f(i5);
    }

    public final int b() {
        return this.f3144a.j().f5752d;
    }

    public final int c() {
        return this.f3144a.j().f5749a;
    }

    public final int d() {
        return this.f3144a.j().f5751c;
    }

    public final int e() {
        return this.f3144a.j().f5750b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h2) {
            return Objects.equals(this.f3144a, ((h2) obj).f3144a);
        }
        return false;
    }

    public final h2 g(int i5, int i6, int i7, int i8) {
        int i9 = Build.VERSION.SDK_INT;
        z1 y1Var = i9 >= 30 ? new y1(this) : i9 >= 29 ? new x1(this) : new w1(this);
        y1Var.g(z.c.b(i5, i6, i7, i8));
        return y1Var.b();
    }

    public final WindowInsets h() {
        f2 f2Var = this.f3144a;
        if (f2Var instanceof a2) {
            return ((a2) f2Var).f3099c;
        }
        return null;
    }

    public final int hashCode() {
        f2 f2Var = this.f3144a;
        if (f2Var == null) {
            return 0;
        }
        return f2Var.hashCode();
    }

    public h2() {
        this.f3144a = new f2(this);
    }
}
