package androidx.recyclerview.widget;

import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class h1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public int f1359b;

    /* renamed from: c  reason: collision with root package name */
    public int f1360c;

    /* renamed from: d  reason: collision with root package name */
    public OverScroller f1361d;

    /* renamed from: e  reason: collision with root package name */
    public Interpolator f1362e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1363f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1364g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f1365h;

    public h1(RecyclerView recyclerView) {
        this.f1365h = recyclerView;
        q0.c cVar = RecyclerView.N0;
        this.f1362e = cVar;
        this.f1363f = false;
        this.f1364g = false;
        this.f1361d = new OverScroller(recyclerView.getContext(), cVar);
    }

    public final void a(int i5, int i6) {
        RecyclerView recyclerView = this.f1365h;
        recyclerView.setScrollState(2);
        this.f1360c = 0;
        this.f1359b = 0;
        Interpolator interpolator = this.f1362e;
        q0.c cVar = RecyclerView.N0;
        if (interpolator != cVar) {
            this.f1362e = cVar;
            this.f1361d = new OverScroller(recyclerView.getContext(), cVar);
        }
        this.f1361d.fling(0, 0, i5, i6, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        b();
    }

    public final void b() {
        if (this.f1363f) {
            this.f1364g = true;
            return;
        }
        RecyclerView recyclerView = this.f1365h;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = h0.z0.f3233a;
        recyclerView.postOnAnimation(this);
    }

    public final void c(int i5, int i6, int i7, Interpolator interpolator) {
        RecyclerView recyclerView = this.f1365h;
        if (i7 == Integer.MIN_VALUE) {
            int abs = Math.abs(i5);
            int abs2 = Math.abs(i6);
            boolean z4 = abs > abs2;
            int width = z4 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z4) {
                abs = abs2;
            }
            i7 = Math.min((int) (((abs / width) + 1.0f) * 300.0f), 2000);
        }
        int i8 = i7;
        if (interpolator == null) {
            interpolator = RecyclerView.N0;
        }
        if (this.f1362e != interpolator) {
            this.f1362e = interpolator;
            this.f1361d = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f1360c = 0;
        this.f1359b = 0;
        recyclerView.setScrollState(2);
        this.f1361d.startScroll(0, 0, i5, i6, i8);
        b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean awakenScrollBars;
        RecyclerView recyclerView = this.f1365h;
        if (recyclerView.f1245t == null) {
            recyclerView.removeCallbacks(this);
            this.f1361d.abortAnimation();
            return;
        }
        this.f1364g = false;
        this.f1363f = true;
        recyclerView.p();
        OverScroller overScroller = this.f1361d;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i9 = currY - this.f1360c;
            this.f1359b = currX;
            this.f1360c = currY;
            int o = RecyclerView.o(currX - this.f1359b, recyclerView.N, recyclerView.P, recyclerView.getWidth());
            int o5 = RecyclerView.o(i9, recyclerView.O, recyclerView.Q, recyclerView.getHeight());
            int[] iArr = recyclerView.f1256y0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean u3 = recyclerView.u(o, o5, iArr, null, 1);
            int[] iArr2 = recyclerView.f1256y0;
            if (u3) {
                o -= iArr2[0];
                o5 -= iArr2[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.n(o, o5);
            }
            if (recyclerView.f1243s != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                recyclerView.e0(o, o5, iArr2);
                int i10 = iArr2[0];
                int i11 = iArr2[1];
                int i12 = o - i10;
                int i13 = o5 - i11;
                a0 a0Var = recyclerView.f1245t.f1500e;
                if (a0Var != null && !a0Var.f1277d && a0Var.f1278e) {
                    int b5 = recyclerView.f1233m0.b();
                    if (b5 == 0) {
                        a0Var.i();
                    } else if (a0Var.f1274a >= b5) {
                        a0Var.f1274a = b5 - 1;
                        a0Var.g(i10, i11);
                    } else {
                        a0Var.g(i10, i11);
                    }
                }
                i8 = i10;
                i5 = i12;
                i6 = i13;
                i7 = i11;
            } else {
                i5 = o;
                i6 = o5;
                i7 = 0;
                i8 = 0;
            }
            if (!recyclerView.f1249v.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.f1256y0;
            iArr3[0] = 0;
            iArr3[1] = 0;
            int i14 = i7;
            recyclerView.v(i8, i7, i5, i6, null, 1, iArr3);
            int i15 = i5 - iArr2[0];
            int i16 = i6 - iArr2[1];
            if (i8 != 0 || i14 != 0) {
                recyclerView.w(i8, i14);
            }
            awakenScrollBars = recyclerView.awakenScrollBars();
            if (!awakenScrollBars) {
                recyclerView.invalidate();
            }
            boolean z4 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i15 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i16 != 0));
            a0 a0Var2 = recyclerView.f1245t.f1500e;
            if ((a0Var2 != null && a0Var2.f1277d) || !z4) {
                b();
                t tVar = recyclerView.f1229k0;
                if (tVar != null) {
                    tVar.a(recyclerView, i8, i14);
                }
            } else {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i17 = i15 < 0 ? -currVelocity : i15 > 0 ? currVelocity : 0;
                    if (i16 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i16 <= 0) {
                        currVelocity = 0;
                    }
                    if (i17 < 0) {
                        recyclerView.y();
                        if (recyclerView.N.isFinished()) {
                            recyclerView.N.onAbsorb(-i17);
                        }
                    } else if (i17 > 0) {
                        recyclerView.z();
                        if (recyclerView.P.isFinished()) {
                            recyclerView.P.onAbsorb(i17);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.A();
                        if (recyclerView.O.isFinished()) {
                            recyclerView.O.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.x();
                        if (recyclerView.Q.isFinished()) {
                            recyclerView.Q.onAbsorb(currVelocity);
                        }
                    }
                    if (i17 != 0 || currVelocity != 0) {
                        WeakHashMap weakHashMap = h0.z0.f3233a;
                        recyclerView.postInvalidateOnAnimation();
                    }
                }
                if (RecyclerView.L0) {
                    r rVar = recyclerView.f1231l0;
                    int[] iArr4 = rVar.f1494c;
                    if (iArr4 != null) {
                        Arrays.fill(iArr4, -1);
                    }
                    rVar.f1495d = 0;
                }
            }
        }
        a0 a0Var3 = recyclerView.f1245t.f1500e;
        if (a0Var3 != null && a0Var3.f1277d) {
            a0Var3.g(0, 0);
        }
        this.f1363f = false;
        if (!this.f1364g) {
            recyclerView.setScrollState(0);
            recyclerView.k0(1);
            return;
        }
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap2 = h0.z0.f3233a;
        recyclerView.postOnAnimation(this);
    }
}
