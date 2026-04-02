package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.google.android.material.carousel.CarouselLayoutManager;
/* loaded from: classes.dex */
public final class e0 extends a0 {

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f1320q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Object f1321r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(Object obj, Context context, int i5) {
        super(context);
        this.f1320q = i5;
        this.f1321r = obj;
    }

    @Override // androidx.recyclerview.widget.a0
    public final int b(View view, int i5) {
        switch (this.f1320q) {
            case 1:
                ((CarouselLayoutManager) this.f1321r).getClass();
                return 0;
            default:
                return super.b(view, i5);
        }
    }

    @Override // androidx.recyclerview.widget.a0
    public final int c(View view, int i5) {
        switch (this.f1320q) {
            case 1:
                ((CarouselLayoutManager) this.f1321r).getClass();
                return 0;
            default:
                return super.c(view, i5);
        }
    }

    @Override // androidx.recyclerview.widget.a0
    public final float d(DisplayMetrics displayMetrics) {
        int i5;
        switch (this.f1320q) {
            case 0:
                i5 = displayMetrics.densityDpi;
                break;
            case 1:
            default:
                return 25.0f / displayMetrics.densityDpi;
            case androidx.viewpager.widget.l.SCROLL_STATE_SETTLING /* 2 */:
                i5 = displayMetrics.densityDpi;
                break;
        }
        return 100.0f / i5;
    }

    @Override // androidx.recyclerview.widget.a0
    public final int e(int i5) {
        switch (this.f1320q) {
            case 0:
                return Math.min(100, super.e(i5));
            default:
                return super.e(i5);
        }
    }

    @Override // androidx.recyclerview.widget.a0
    public final PointF f(int i5) {
        switch (this.f1320q) {
            case 1:
                ((CarouselLayoutManager) this.f1321r).getClass();
                return null;
            default:
                return super.f(i5);
        }
    }

    @Override // androidx.recyclerview.widget.a0
    public final void h(View view, e1 e1Var, c1 c1Var) {
        switch (this.f1320q) {
            case 0:
                f0 f0Var = (f0) this.f1321r;
                int[] a5 = f0Var.a(f0Var.f1341a.getLayoutManager(), view);
                int i5 = a5[0];
                int i6 = a5[1];
                int ceil = (int) Math.ceil(e(Math.max(Math.abs(i5), Math.abs(i6))) / 0.3356d);
                if (ceil > 0) {
                    DecelerateInterpolator decelerateInterpolator = this.f1283j;
                    c1Var.f1302a = i5;
                    c1Var.f1303b = i6;
                    c1Var.f1304c = ceil;
                    c1Var.f1306e = decelerateInterpolator;
                    c1Var.f1307f = true;
                    return;
                }
                return;
            default:
                super.h(view, e1Var, c1Var);
                return;
        }
    }
}
