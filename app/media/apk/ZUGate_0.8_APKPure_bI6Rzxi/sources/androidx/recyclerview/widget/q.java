package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class q extends o0 implements u0 {
    public static final int[] C = {16842919};
    public static final int[] D = new int[0];
    public int A;
    public final m B;

    /* renamed from: a  reason: collision with root package name */
    public final int f1457a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1458b;

    /* renamed from: c  reason: collision with root package name */
    public final StateListDrawable f1459c;

    /* renamed from: d  reason: collision with root package name */
    public final Drawable f1460d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1461e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1462f;

    /* renamed from: g  reason: collision with root package name */
    public final StateListDrawable f1463g;

    /* renamed from: h  reason: collision with root package name */
    public final Drawable f1464h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1465i;

    /* renamed from: j  reason: collision with root package name */
    public final int f1466j;

    /* renamed from: k  reason: collision with root package name */
    public int f1467k;

    /* renamed from: l  reason: collision with root package name */
    public int f1468l;

    /* renamed from: m  reason: collision with root package name */
    public float f1469m;

    /* renamed from: n  reason: collision with root package name */
    public int f1470n;
    public int o;

    /* renamed from: p  reason: collision with root package name */
    public float f1471p;

    /* renamed from: s  reason: collision with root package name */
    public RecyclerView f1474s;

    /* renamed from: z  reason: collision with root package name */
    public final ValueAnimator f1481z;

    /* renamed from: q  reason: collision with root package name */
    public int f1472q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f1473r = 0;

    /* renamed from: t  reason: collision with root package name */
    public boolean f1475t = false;

    /* renamed from: u  reason: collision with root package name */
    public boolean f1476u = false;

    /* renamed from: v  reason: collision with root package name */
    public int f1477v = 0;

    /* renamed from: w  reason: collision with root package name */
    public int f1478w = 0;

    /* renamed from: x  reason: collision with root package name */
    public final int[] f1479x = new int[2];

    /* renamed from: y  reason: collision with root package name */
    public final int[] f1480y = new int[2];

    public q(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i5, int i6, int i7) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f1481z = ofFloat;
        this.A = 0;
        m mVar = new m(0, this);
        this.B = mVar;
        n nVar = new n(this);
        this.f1459c = stateListDrawable;
        this.f1460d = drawable;
        this.f1463g = stateListDrawable2;
        this.f1464h = drawable2;
        this.f1461e = Math.max(i5, stateListDrawable.getIntrinsicWidth());
        this.f1462f = Math.max(i5, drawable.getIntrinsicWidth());
        this.f1465i = Math.max(i5, stateListDrawable2.getIntrinsicWidth());
        this.f1466j = Math.max(i5, drawable2.getIntrinsicWidth());
        this.f1457a = i6;
        this.f1458b = i7;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new o(this));
        ofFloat.addUpdateListener(new p(this));
        RecyclerView recyclerView2 = this.f1474s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            r0 r0Var = recyclerView2.f1245t;
            if (r0Var != null) {
                r0Var.c("Cannot remove item decoration during a scroll  or layout");
            }
            ArrayList arrayList = recyclerView2.f1249v;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2);
            }
            recyclerView2.Q();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.f1474s;
            recyclerView3.f1251w.remove(this);
            if (recyclerView3.f1253x == this) {
                recyclerView3.f1253x = null;
            }
            ArrayList arrayList2 = this.f1474s.f1236o0;
            if (arrayList2 != null) {
                arrayList2.remove(nVar);
            }
            this.f1474s.removeCallbacks(mVar);
        }
        this.f1474s = recyclerView;
        if (recyclerView != null) {
            recyclerView.i(this);
            this.f1474s.f1251w.add(this);
            this.f1474s.j(nVar);
        }
    }

    @Override // androidx.recyclerview.widget.o0
    public final void c(Canvas canvas, RecyclerView recyclerView) {
        if (this.f1472q != this.f1474s.getWidth() || this.f1473r != this.f1474s.getHeight()) {
            this.f1472q = this.f1474s.getWidth();
            this.f1473r = this.f1474s.getHeight();
            f(0);
        } else if (this.A != 0) {
            if (this.f1475t) {
                int i5 = this.f1472q;
                int i6 = this.f1461e;
                int i7 = i5 - i6;
                int i8 = this.f1468l;
                int i9 = this.f1467k;
                int i10 = i8 - (i9 / 2);
                StateListDrawable stateListDrawable = this.f1459c;
                stateListDrawable.setBounds(0, 0, i6, i9);
                int i11 = this.f1473r;
                int i12 = this.f1462f;
                Drawable drawable = this.f1460d;
                drawable.setBounds(0, 0, i12, i11);
                RecyclerView recyclerView2 = this.f1474s;
                WeakHashMap weakHashMap = h0.z0.f3233a;
                if (recyclerView2.getLayoutDirection() == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i6, i10);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i6, -i10);
                } else {
                    canvas.translate(i7, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i10);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i7, -i10);
                }
            }
            if (this.f1476u) {
                int i13 = this.f1473r;
                int i14 = this.f1465i;
                int i15 = i13 - i14;
                int i16 = this.o;
                int i17 = this.f1470n;
                int i18 = i16 - (i17 / 2);
                StateListDrawable stateListDrawable2 = this.f1463g;
                stateListDrawable2.setBounds(0, 0, i17, i14);
                int i19 = this.f1472q;
                int i20 = this.f1466j;
                Drawable drawable2 = this.f1464h;
                drawable2.setBounds(0, 0, i19, i20);
                canvas.translate(0.0f, i15);
                drawable2.draw(canvas);
                canvas.translate(i18, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i18, -i15);
            }
        }
    }

    public final boolean d(float f5, float f6) {
        if (f6 >= this.f1473r - this.f1465i) {
            int i5 = this.o;
            int i6 = this.f1470n;
            if (f5 >= i5 - (i6 / 2) && f5 <= (i6 / 2) + i5) {
                return true;
            }
        }
        return false;
    }

    public final boolean e(float f5, float f6) {
        RecyclerView recyclerView = this.f1474s;
        WeakHashMap weakHashMap = h0.z0.f3233a;
        boolean z4 = recyclerView.getLayoutDirection() == 1;
        int i5 = this.f1461e;
        if (z4) {
            if (f5 > i5) {
                return false;
            }
        } else if (f5 < this.f1472q - i5) {
            return false;
        }
        int i6 = this.f1468l;
        int i7 = this.f1467k / 2;
        return f6 >= ((float) (i6 - i7)) && f6 <= ((float) (i7 + i6));
    }

    public final void f(int i5) {
        m mVar = this.B;
        StateListDrawable stateListDrawable = this.f1459c;
        if (i5 == 2 && this.f1477v != 2) {
            stateListDrawable.setState(C);
            this.f1474s.removeCallbacks(mVar);
        }
        if (i5 == 0) {
            this.f1474s.invalidate();
        } else {
            g();
        }
        if (this.f1477v == 2 && i5 != 2) {
            stateListDrawable.setState(D);
            this.f1474s.removeCallbacks(mVar);
            this.f1474s.postDelayed(mVar, 1200);
        } else if (i5 == 1) {
            this.f1474s.removeCallbacks(mVar);
            this.f1474s.postDelayed(mVar, 1500);
        }
        this.f1477v = i5;
    }

    public final void g() {
        int i5 = this.A;
        ValueAnimator valueAnimator = this.f1481z;
        if (i5 != 0) {
            if (i5 != 3) {
                return;
            }
            valueAnimator.cancel();
        }
        this.A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}
