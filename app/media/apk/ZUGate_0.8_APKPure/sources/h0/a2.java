package h0;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
/* loaded from: classes.dex */
public abstract class a2 extends f2 {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f3094h = false;

    /* renamed from: i  reason: collision with root package name */
    public static Method f3095i;

    /* renamed from: j  reason: collision with root package name */
    public static Class f3096j;

    /* renamed from: k  reason: collision with root package name */
    public static Field f3097k;

    /* renamed from: l  reason: collision with root package name */
    public static Field f3098l;

    /* renamed from: c  reason: collision with root package name */
    public final WindowInsets f3099c;

    /* renamed from: d  reason: collision with root package name */
    public z.c[] f3100d;

    /* renamed from: e  reason: collision with root package name */
    public z.c f3101e;

    /* renamed from: f  reason: collision with root package name */
    public h2 f3102f;

    /* renamed from: g  reason: collision with root package name */
    public z.c f3103g;

    public a2(h2 h2Var, WindowInsets windowInsets) {
        super(h2Var);
        this.f3101e = null;
        this.f3099c = windowInsets;
    }

    @SuppressLint({"WrongConstant"})
    private z.c r(int i5, boolean z4) {
        z.c cVar = z.c.f5748e;
        for (int i6 = 1; i6 <= 256; i6 <<= 1) {
            if ((i5 & i6) != 0) {
                cVar = z.c.a(cVar, s(i6, z4));
            }
        }
        return cVar;
    }

    private z.c t() {
        h2 h2Var = this.f3102f;
        return h2Var != null ? h2Var.f3144a.h() : z.c.f5748e;
    }

    private z.c u(View view) {
        if (Build.VERSION.SDK_INT < 30) {
            if (!f3094h) {
                v();
            }
            Method method = f3095i;
            if (method != null && f3096j != null && f3097k != null) {
                try {
                    Object invoke = method.invoke(view, new Object[0]);
                    if (invoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f3097k.get(f3098l.get(invoke));
                    if (rect != null) {
                        return z.c.b(rect.left, rect.top, rect.right, rect.bottom);
                    }
                    return null;
                } catch (ReflectiveOperationException e5) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e5.getMessage(), e5);
                }
            }
            return null;
        }
        throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
    }

    @SuppressLint({"PrivateApi"})
    private static void v() {
        try {
            f3095i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f3096j = cls;
            f3097k = cls.getDeclaredField("mVisibleInsets");
            f3098l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f3097k.setAccessible(true);
            f3098l.setAccessible(true);
        } catch (ReflectiveOperationException e5) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e5.getMessage(), e5);
        }
        f3094h = true;
    }

    @Override // h0.f2
    public void d(View view) {
        z.c u3 = u(view);
        if (u3 == null) {
            u3 = z.c.f5748e;
        }
        w(u3);
    }

    @Override // h0.f2
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return Objects.equals(this.f3103g, ((a2) obj).f3103g);
        }
        return false;
    }

    @Override // h0.f2
    public z.c f(int i5) {
        return r(i5, false);
    }

    @Override // h0.f2
    public final z.c j() {
        if (this.f3101e == null) {
            WindowInsets windowInsets = this.f3099c;
            this.f3101e = z.c.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f3101e;
    }

    @Override // h0.f2
    public h2 l(int i5, int i6, int i7, int i8) {
        h2 i9 = h2.i(null, this.f3099c);
        int i10 = Build.VERSION.SDK_INT;
        z1 y1Var = i10 >= 30 ? new y1(i9) : i10 >= 29 ? new x1(i9) : new w1(i9);
        y1Var.g(h2.f(j(), i5, i6, i7, i8));
        y1Var.e(h2.f(h(), i5, i6, i7, i8));
        return y1Var.b();
    }

    @Override // h0.f2
    public boolean n() {
        return this.f3099c.isRound();
    }

    @Override // h0.f2
    public void o(z.c[] cVarArr) {
        this.f3100d = cVarArr;
    }

    @Override // h0.f2
    public void p(h2 h2Var) {
        this.f3102f = h2Var;
    }

    public z.c s(int i5, boolean z4) {
        z.c h5;
        int i6;
        if (i5 == 1) {
            return z4 ? z.c.b(0, Math.max(t().f5750b, j().f5750b), 0, 0) : z.c.b(0, j().f5750b, 0, 0);
        }
        if (i5 == 2) {
            if (z4) {
                z.c t5 = t();
                z.c h6 = h();
                return z.c.b(Math.max(t5.f5749a, h6.f5749a), 0, Math.max(t5.f5751c, h6.f5751c), Math.max(t5.f5752d, h6.f5752d));
            }
            z.c j5 = j();
            h2 h2Var = this.f3102f;
            h5 = h2Var != null ? h2Var.f3144a.h() : null;
            int i7 = j5.f5752d;
            if (h5 != null) {
                i7 = Math.min(i7, h5.f5752d);
            }
            return z.c.b(j5.f5749a, 0, j5.f5751c, i7);
        }
        z.c cVar = z.c.f5748e;
        if (i5 == 8) {
            z.c[] cVarArr = this.f3100d;
            h5 = cVarArr != null ? cVarArr[com.google.android.gms.internal.play_billing.i0.G(8)] : null;
            if (h5 != null) {
                return h5;
            }
            z.c j6 = j();
            z.c t6 = t();
            int i8 = j6.f5752d;
            if (i8 > t6.f5752d) {
                return z.c.b(0, 0, 0, i8);
            }
            z.c cVar2 = this.f3103g;
            return (cVar2 == null || cVar2.equals(cVar) || (i6 = this.f3103g.f5752d) <= t6.f5752d) ? cVar : z.c.b(0, 0, 0, i6);
        } else if (i5 != 16) {
            if (i5 != 32) {
                if (i5 != 64) {
                    if (i5 != 128) {
                        return cVar;
                    }
                    h2 h2Var2 = this.f3102f;
                    k e5 = h2Var2 != null ? h2Var2.f3144a.e() : e();
                    if (e5 != null) {
                        int i9 = Build.VERSION.SDK_INT;
                        DisplayCutout displayCutout = e5.f3163a;
                        return z.c.b(i9 >= 28 ? j.d(displayCutout) : 0, i9 >= 28 ? j.f(displayCutout) : 0, i9 >= 28 ? j.e(displayCutout) : 0, i9 >= 28 ? j.c(displayCutout) : 0);
                    }
                    return cVar;
                }
                return k();
            }
            return g();
        } else {
            return i();
        }
    }

    public void w(z.c cVar) {
        this.f3103g = cVar;
    }
}
