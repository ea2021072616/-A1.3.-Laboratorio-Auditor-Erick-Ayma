package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
/* loaded from: classes.dex */
public class a0 {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f1275b;

    /* renamed from: c  reason: collision with root package name */
    public r0 f1276c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1277d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1278e;

    /* renamed from: f  reason: collision with root package name */
    public View f1279f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1281h;

    /* renamed from: k  reason: collision with root package name */
    public PointF f1284k;

    /* renamed from: l  reason: collision with root package name */
    public final DisplayMetrics f1285l;

    /* renamed from: n  reason: collision with root package name */
    public float f1287n;

    /* renamed from: a  reason: collision with root package name */
    public int f1274a = -1;

    /* renamed from: g  reason: collision with root package name */
    public final c1 f1280g = new c1();

    /* renamed from: i  reason: collision with root package name */
    public final LinearInterpolator f1282i = new LinearInterpolator();

    /* renamed from: j  reason: collision with root package name */
    public final DecelerateInterpolator f1283j = new DecelerateInterpolator();

    /* renamed from: m  reason: collision with root package name */
    public boolean f1286m = false;
    public int o = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f1288p = 0;

    public a0(Context context) {
        this.f1285l = context.getResources().getDisplayMetrics();
    }

    public static int a(int i5, int i6, int i7, int i8, int i9) {
        if (i9 != -1) {
            if (i9 != 0) {
                if (i9 == 1) {
                    return i8 - i6;
                }
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            }
            int i10 = i7 - i5;
            if (i10 > 0) {
                return i10;
            }
            int i11 = i8 - i6;
            if (i11 < 0) {
                return i11;
            }
            return 0;
        }
        return i7 - i5;
    }

    public int b(View view, int i5) {
        r0 r0Var = this.f1276c;
        if (r0Var == null || !r0Var.d()) {
            return 0;
        }
        s0 s0Var = (s0) view.getLayoutParams();
        return a((view.getLeft() - ((s0) view.getLayoutParams()).f1521b.left) - ((ViewGroup.MarginLayoutParams) s0Var).leftMargin, view.getRight() + ((s0) view.getLayoutParams()).f1521b.right + ((ViewGroup.MarginLayoutParams) s0Var).rightMargin, r0Var.E(), r0Var.f1509n - r0Var.F(), i5);
    }

    public int c(View view, int i5) {
        r0 r0Var = this.f1276c;
        if (r0Var == null || !r0Var.e()) {
            return 0;
        }
        s0 s0Var = (s0) view.getLayoutParams();
        return a((view.getTop() - ((s0) view.getLayoutParams()).f1521b.top) - ((ViewGroup.MarginLayoutParams) s0Var).topMargin, view.getBottom() + ((s0) view.getLayoutParams()).f1521b.bottom + ((ViewGroup.MarginLayoutParams) s0Var).bottomMargin, r0Var.G(), r0Var.o - r0Var.D(), i5);
    }

    public float d(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int e(int i5) {
        float abs = Math.abs(i5);
        if (!this.f1286m) {
            this.f1287n = d(this.f1285l);
            this.f1286m = true;
        }
        return (int) Math.ceil(abs * this.f1287n);
    }

    public PointF f(int i5) {
        r0 r0Var = this.f1276c;
        if (r0Var instanceof d1) {
            return ((d1) r0Var).a(i5);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + d1.class.getCanonicalName());
        return null;
    }

    public final void g(int i5, int i6) {
        float f5;
        PointF f6;
        RecyclerView recyclerView = this.f1275b;
        if (this.f1274a == -1 || recyclerView == null) {
            i();
        }
        if (this.f1277d && this.f1279f == null && this.f1276c != null && (f6 = f(this.f1274a)) != null) {
            float f7 = f6.x;
            if (f7 != 0.0f || f6.y != 0.0f) {
                recyclerView.e0((int) Math.signum(f7), (int) Math.signum(f6.y), null);
            }
        }
        this.f1277d = false;
        View view = this.f1279f;
        c1 c1Var = this.f1280g;
        if (view != null) {
            this.f1275b.getClass();
            i1 L = RecyclerView.L(view);
            if ((L != null ? L.c() : -1) == this.f1274a) {
                h(this.f1279f, recyclerView.f1233m0, c1Var);
                c1Var.a(recyclerView);
                i();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.f1279f = null;
            }
        }
        if (this.f1278e) {
            e1 e1Var = recyclerView.f1233m0;
            if (this.f1275b.f1245t.v() == 0) {
                i();
            } else {
                int i7 = this.o;
                int i8 = i7 - i5;
                if (i7 * i8 <= 0) {
                    i8 = 0;
                }
                this.o = i8;
                int i9 = this.f1288p;
                int i10 = i9 - i6;
                if (i9 * i10 <= 0) {
                    i10 = 0;
                }
                this.f1288p = i10;
                if (i8 == 0 && i10 == 0) {
                    PointF f8 = f(this.f1274a);
                    if (f8 != null) {
                        if (f8.x != 0.0f || f8.y != 0.0f) {
                            float f9 = f8.y;
                            float sqrt = (float) Math.sqrt((f9 * f9) + (f5 * f5));
                            float f10 = f8.x / sqrt;
                            f8.x = f10;
                            float f11 = f8.y / sqrt;
                            f8.y = f11;
                            this.f1284k = f8;
                            this.o = (int) (f10 * 10000.0f);
                            this.f1288p = (int) (f11 * 10000.0f);
                            int e5 = e(10000);
                            LinearInterpolator linearInterpolator = this.f1282i;
                            c1Var.f1302a = (int) (this.o * 1.2f);
                            c1Var.f1303b = (int) (this.f1288p * 1.2f);
                            c1Var.f1304c = (int) (e5 * 1.2f);
                            c1Var.f1306e = linearInterpolator;
                            c1Var.f1307f = true;
                        }
                    }
                    c1Var.f1305d = this.f1274a;
                    i();
                }
            }
            boolean z4 = c1Var.f1305d >= 0;
            c1Var.a(recyclerView);
            if (z4 && this.f1278e) {
                this.f1277d = true;
                recyclerView.f1227j0.b();
            }
        }
    }

    public void h(View view, e1 e1Var, c1 c1Var) {
        int i5;
        int i6;
        PointF pointF = this.f1284k;
        int i7 = -1;
        int b5 = b(view, (pointF == null || pointF.x == 0.0f) ? 0 : i6 > 0 ? 1 : -1);
        PointF pointF2 = this.f1284k;
        if (pointF2 == null || pointF2.y == 0.0f) {
            i7 = 0;
        } else if (i5 > 0) {
            i7 = 1;
        }
        int c5 = c(view, i7);
        int ceil = (int) Math.ceil(e((int) Math.sqrt((c5 * c5) + (b5 * b5))) / 0.3356d);
        if (ceil > 0) {
            DecelerateInterpolator decelerateInterpolator = this.f1283j;
            c1Var.f1302a = -b5;
            c1Var.f1303b = -c5;
            c1Var.f1304c = ceil;
            c1Var.f1306e = decelerateInterpolator;
            c1Var.f1307f = true;
        }
    }

    public final void i() {
        if (this.f1278e) {
            this.f1278e = false;
            this.f1288p = 0;
            this.o = 0;
            this.f1284k = null;
            this.f1275b.f1233m0.f1322a = -1;
            this.f1279f = null;
            this.f1274a = -1;
            this.f1277d = false;
            r0 r0Var = this.f1276c;
            if (r0Var.f1500e == this) {
                r0Var.f1500e = null;
            }
            this.f1276c = null;
            this.f1275b = null;
        }
    }
}
