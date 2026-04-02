package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.d0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.d1;
import androidx.recyclerview.widget.e0;
import androidx.recyclerview.widget.e1;
import androidx.recyclerview.widget.r0;
import androidx.recyclerview.widget.s0;
import androidx.recyclerview.widget.y0;
import com.github.appintro.R;
import com.google.android.material.carousel.CarouselLayoutManager;
import d3.a;
import d3.b;
import d3.c;
import d3.e;
import d3.f;
import d3.g;
import java.util.List;
/* loaded from: classes.dex */
public class CarouselLayoutManager extends r0 implements d1 {

    /* renamed from: p  reason: collision with root package name */
    public e f2076p;

    /* renamed from: q  reason: collision with root package name */
    public c f2077q;

    /* renamed from: r  reason: collision with root package name */
    public final a f2078r;

    /* JADX WARN: Type inference failed for: r1v1, types: [d3.a] */
    public CarouselLayoutManager() {
        g gVar = new g();
        new b();
        this.f2078r = new View.OnLayoutChangeListener(this) { // from class: d3.a

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ CarouselLayoutManager f2541b;

            {
                this.f2541b = this;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                int i13 = r2;
                CarouselLayoutManager carouselLayoutManager = this.f2541b;
                switch (i13) {
                    case 0:
                        carouselLayoutManager.getClass();
                        if (i5 == i9 && i6 == i10 && i7 == i11 && i8 == i12) {
                            return;
                        }
                        view.post(new androidx.activity.d(8, carouselLayoutManager));
                        return;
                    default:
                        carouselLayoutManager.getClass();
                        if (i5 == i9 && i6 == i10 && i7 == i11 && i8 == i12) {
                            return;
                        }
                        view.post(new androidx.activity.d(8, carouselLayoutManager));
                        return;
                }
            }
        };
        this.f2076p = gVar;
        n0();
        I0(0);
    }

    public static float E0(float f5, d0 d0Var) {
        f fVar = (f) d0Var.f306h;
        fVar.getClass();
        f fVar2 = (f) d0Var.f307i;
        fVar2.getClass();
        fVar.getClass();
        fVar2.getClass();
        return x2.a.a(0.0f, 0.0f, 0.0f, 0.0f, f5);
    }

    public static d0 F0(float f5, List list, boolean z4) {
        float f6 = Float.MAX_VALUE;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        float f7 = -3.4028235E38f;
        float f8 = Float.MAX_VALUE;
        float f9 = Float.MAX_VALUE;
        for (int i9 = 0; i9 < list.size(); i9++) {
            ((f) list.get(i9)).getClass();
            float abs = Math.abs(0.0f - f5);
            if (0.0f <= f5 && abs <= f6) {
                i5 = i9;
                f6 = abs;
            }
            if (0.0f > f5 && abs <= f8) {
                i7 = i9;
                f8 = abs;
            }
            if (0.0f <= f9) {
                i6 = i9;
                f9 = 0.0f;
            }
            if (0.0f > f7) {
                i8 = i9;
                f7 = 0.0f;
            }
        }
        if (i5 == -1) {
            i5 = i6;
        }
        if (i7 == -1) {
            i7 = i8;
        }
        return new d0((f) list.get(i5), (f) list.get(i7));
    }

    public final float C0(int i5) {
        c cVar = this.f2077q;
        switch (cVar.f2544b) {
            case 0:
                cVar.b();
                break;
            default:
                CarouselLayoutManager carouselLayoutManager = cVar.f2545c;
                if (!carouselLayoutManager.H0()) {
                    cVar.a();
                    break;
                } else {
                    switch (cVar.f2544b) {
                        case 0:
                            int i6 = carouselLayoutManager.f1509n;
                            carouselLayoutManager.F();
                            break;
                        default:
                            int i7 = carouselLayoutManager.f1509n;
                            break;
                    }
                }
        }
        throw null;
    }

    public final int D0() {
        return G0() ? this.f1509n : this.o;
    }

    public final boolean G0() {
        return this.f2077q.f2546a == 0;
    }

    public final boolean H0() {
        return G0() && C() == 1;
    }

    public final void I0(int i5) {
        c cVar;
        if (i5 != 0 && i5 != 1) {
            throw new IllegalArgumentException(b0.f("invalid orientation:", i5));
        }
        c(null);
        c cVar2 = this.f2077q;
        if (cVar2 == null || i5 != cVar2.f2546a) {
            if (i5 == 0) {
                cVar = new c(0, this, 1);
            } else if (i5 != 1) {
                throw new IllegalArgumentException("invalid orientation");
            } else {
                cVar = new c(1, this, 0);
            }
            this.f2077q = cVar;
            n0();
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public final boolean L() {
        return true;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void R(RecyclerView recyclerView) {
        e eVar = this.f2076p;
        Context context = recyclerView.getContext();
        float f5 = eVar.f2547a;
        if (f5 <= 0.0f) {
            f5 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        eVar.f2547a = f5;
        float f6 = eVar.f2548b;
        if (f6 <= 0.0f) {
            f6 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        eVar.f2548b = f6;
        n0();
        recyclerView.addOnLayoutChangeListener(this.f2078r);
    }

    @Override // androidx.recyclerview.widget.r0
    public final void S(RecyclerView recyclerView) {
        recyclerView.removeOnLayoutChangeListener(this.f2078r);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r9 == 1) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
        if (H0() != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
        if (r9 == 1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
        if (H0() != false) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0059  */
    @Override // androidx.recyclerview.widget.r0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View T(android.view.View r6, int r7, androidx.recyclerview.widget.y0 r8, androidx.recyclerview.widget.e1 r9) {
        /*
            r5 = this;
            int r9 = r5.v()
            r0 = 0
            if (r9 != 0) goto L8
            return r0
        L8:
            d3.c r9 = r5.f2077q
            int r9 = r9.f2546a
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1
            if (r7 == r3) goto L55
            r4 = 2
            if (r7 == r4) goto L53
            r4 = 17
            if (r7 == r4) goto L48
            r4 = 33
            if (r7 == r4) goto L45
            r4 = 66
            if (r7 == r4) goto L3c
            r4 = 130(0x82, float:1.82E-43)
            if (r7 == r4) goto L39
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r4 = "Unknown focus request:"
            r9.<init>(r4)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            java.lang.String r9 = "CarouselLayoutManager"
            android.util.Log.d(r9, r7)
            goto L51
        L39:
            if (r9 != r3) goto L51
            goto L53
        L3c:
            if (r9 != 0) goto L51
            boolean r7 = r5.H0()
            if (r7 == 0) goto L53
            goto L55
        L45:
            if (r9 != r3) goto L51
            goto L55
        L48:
            if (r9 != 0) goto L51
            boolean r7 = r5.H0()
            if (r7 == 0) goto L55
            goto L53
        L51:
            r7 = r2
            goto L56
        L53:
            r7 = r3
            goto L56
        L55:
            r7 = r1
        L56:
            if (r7 != r2) goto L59
            return r0
        L59:
            java.lang.String r9 = "All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup."
            r2 = 0
            if (r7 != r1) goto L94
            int r6 = androidx.recyclerview.widget.r0.H(r6)
            if (r6 != 0) goto L65
            return r0
        L65:
            android.view.View r6 = r5.u(r2)
            int r6 = androidx.recyclerview.widget.r0.H(r6)
            int r6 = r6 - r3
            if (r6 < 0) goto L83
            int r7 = r5.B()
            if (r6 < r7) goto L77
            goto L83
        L77:
            r5.C0(r6)
            r8.d(r6)
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            r6.<init>(r9)
            throw r6
        L83:
            boolean r6 = r5.H0()
            if (r6 == 0) goto L8f
            int r6 = r5.v()
            int r2 = r6 + (-1)
        L8f:
            android.view.View r6 = r5.u(r2)
            goto Ld4
        L94:
            int r6 = androidx.recyclerview.widget.r0.H(r6)
            int r7 = r5.B()
            int r7 = r7 - r3
            if (r6 != r7) goto La0
            return r0
        La0:
            int r6 = r5.v()
            int r6 = r6 - r3
            android.view.View r6 = r5.u(r6)
            int r6 = androidx.recyclerview.widget.r0.H(r6)
            int r6 = r6 + r3
            if (r6 < 0) goto Lc3
            int r7 = r5.B()
            if (r6 < r7) goto Lb7
            goto Lc3
        Lb7:
            r5.C0(r6)
            r8.d(r6)
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            r6.<init>(r9)
            throw r6
        Lc3:
            boolean r6 = r5.H0()
            if (r6 == 0) goto Lca
            goto Ld0
        Lca:
            int r6 = r5.v()
            int r2 = r6 + (-1)
        Ld0:
            android.view.View r6 = r5.u(r2)
        Ld4:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.T(android.view.View, int, androidx.recyclerview.widget.y0, androidx.recyclerview.widget.e1):android.view.View");
    }

    @Override // androidx.recyclerview.widget.r0
    public final void U(AccessibilityEvent accessibilityEvent) {
        super.U(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(r0.H(u(0)));
            accessibilityEvent.setToIndex(r0.H(u(v() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.r0
    public final void Y(int i5, int i6) {
        B();
    }

    @Override // androidx.recyclerview.widget.d1
    public final PointF a(int i5) {
        return null;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void b0(int i5, int i6) {
        B();
    }

    @Override // androidx.recyclerview.widget.r0
    public final boolean d() {
        return G0();
    }

    @Override // androidx.recyclerview.widget.r0
    public final void d0(y0 y0Var, e1 e1Var) {
        if (e1Var.b() <= 0 || D0() <= 0.0f) {
            i0(y0Var);
            return;
        }
        H0();
        y0Var.d(0);
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // androidx.recyclerview.widget.r0
    public final boolean e() {
        return !G0();
    }

    @Override // androidx.recyclerview.widget.r0
    public final void e0(e1 e1Var) {
        if (v() == 0) {
            return;
        }
        r0.H(u(0));
    }

    @Override // androidx.recyclerview.widget.r0
    public final int j(e1 e1Var) {
        v();
        return 0;
    }

    @Override // androidx.recyclerview.widget.r0
    public final int k(e1 e1Var) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.r0
    public final int l(e1 e1Var) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.r0
    public final int m(e1 e1Var) {
        v();
        return 0;
    }

    @Override // androidx.recyclerview.widget.r0
    public final boolean m0(RecyclerView recyclerView, View view, Rect rect, boolean z4, boolean z5) {
        return false;
    }

    @Override // androidx.recyclerview.widget.r0
    public final int n(e1 e1Var) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.r0
    public final int o(e1 e1Var) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.r0
    public final int o0(int i5, y0 y0Var, e1 e1Var) {
        if (!G0() || v() == 0 || i5 == 0) {
            return 0;
        }
        y0Var.d(0);
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // androidx.recyclerview.widget.r0
    public final void p0(int i5) {
    }

    @Override // androidx.recyclerview.widget.r0
    public final int q0(int i5, y0 y0Var, e1 e1Var) {
        if (!e() || v() == 0 || i5 == 0) {
            return 0;
        }
        y0Var.d(0);
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // androidx.recyclerview.widget.r0
    public final s0 r() {
        return new s0(-2, -2);
    }

    @Override // androidx.recyclerview.widget.r0
    public final void y(Rect rect, View view) {
        RecyclerView.M(rect, view);
        rect.centerY();
        if (G0()) {
            rect.centerX();
        }
        throw null;
    }

    @Override // androidx.recyclerview.widget.r0
    public final void z0(RecyclerView recyclerView, int i5) {
        e0 e0Var = new e0(this, recyclerView.getContext(), 1);
        e0Var.f1274a = i5;
        A0(e0Var);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [d3.a] */
    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i5, int i6) {
        new b();
        this.f2078r = new View.OnLayoutChangeListener(this) { // from class: d3.a

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ CarouselLayoutManager f2541b;

            {
                this.f2541b = this;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i52, int i62, int i7, int i8, int i9, int i10, int i11, int i12) {
                int i13 = r2;
                CarouselLayoutManager carouselLayoutManager = this.f2541b;
                switch (i13) {
                    case 0:
                        carouselLayoutManager.getClass();
                        if (i52 == i9 && i62 == i10 && i7 == i11 && i8 == i12) {
                            return;
                        }
                        view.post(new androidx.activity.d(8, carouselLayoutManager));
                        return;
                    default:
                        carouselLayoutManager.getClass();
                        if (i52 == i9 && i62 == i10 && i7 == i11 && i8 == i12) {
                            return;
                        }
                        view.post(new androidx.activity.d(8, carouselLayoutManager));
                        return;
                }
            }
        };
        this.f2076p = new g();
        n0();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w2.a.f5387b);
            obtainStyledAttributes.getInt(0, 0);
            n0();
            I0(obtainStyledAttributes.getInt(0, 0));
            obtainStyledAttributes.recycle();
        }
    }
}
