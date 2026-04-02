package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public final class c0 extends d0 {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f1301d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c0(r0 r0Var, int i5) {
        super(r0Var);
        this.f1301d = i5;
    }

    @Override // androidx.recyclerview.widget.d0
    public final int b(View view) {
        int bottom;
        int i5;
        int i6 = this.f1301d;
        r0 r0Var = this.f1314a;
        switch (i6) {
            case 0:
                r0Var.getClass();
                bottom = view.getRight() + ((s0) view.getLayoutParams()).f1521b.right;
                i5 = ((ViewGroup.MarginLayoutParams) ((s0) view.getLayoutParams())).rightMargin;
                break;
            default:
                r0Var.getClass();
                bottom = view.getBottom() + ((s0) view.getLayoutParams()).f1521b.bottom;
                i5 = ((ViewGroup.MarginLayoutParams) ((s0) view.getLayoutParams())).bottomMargin;
                break;
        }
        return bottom + i5;
    }

    @Override // androidx.recyclerview.widget.d0
    public final int c(View view) {
        int z4;
        int i5;
        int i6 = this.f1301d;
        r0 r0Var = this.f1314a;
        switch (i6) {
            case 0:
                s0 s0Var = (s0) view.getLayoutParams();
                r0Var.getClass();
                z4 = r0.A(view) + ((ViewGroup.MarginLayoutParams) s0Var).leftMargin;
                i5 = ((ViewGroup.MarginLayoutParams) s0Var).rightMargin;
                break;
            default:
                s0 s0Var2 = (s0) view.getLayoutParams();
                r0Var.getClass();
                z4 = r0.z(view) + ((ViewGroup.MarginLayoutParams) s0Var2).topMargin;
                i5 = ((ViewGroup.MarginLayoutParams) s0Var2).bottomMargin;
                break;
        }
        return z4 + i5;
    }

    @Override // androidx.recyclerview.widget.d0
    public final int d(View view) {
        int top;
        int i5;
        int i6 = this.f1301d;
        r0 r0Var = this.f1314a;
        switch (i6) {
            case 0:
                r0Var.getClass();
                top = view.getLeft() - ((s0) view.getLayoutParams()).f1521b.left;
                i5 = ((ViewGroup.MarginLayoutParams) ((s0) view.getLayoutParams())).leftMargin;
                break;
            default:
                r0Var.getClass();
                top = view.getTop() - ((s0) view.getLayoutParams()).f1521b.top;
                i5 = ((ViewGroup.MarginLayoutParams) ((s0) view.getLayoutParams())).topMargin;
                break;
        }
        return top - i5;
    }

    @Override // androidx.recyclerview.widget.d0
    public final int e() {
        int i5 = this.f1301d;
        r0 r0Var = this.f1314a;
        switch (i5) {
            case 0:
                return r0Var.f1509n;
            default:
                return r0Var.o;
        }
    }

    @Override // androidx.recyclerview.widget.d0
    public final int f() {
        int i5;
        int D;
        int i6 = this.f1301d;
        r0 r0Var = this.f1314a;
        switch (i6) {
            case 0:
                i5 = r0Var.f1509n;
                D = r0Var.F();
                break;
            default:
                i5 = r0Var.o;
                D = r0Var.D();
                break;
        }
        return i5 - D;
    }

    @Override // androidx.recyclerview.widget.d0
    public final int g() {
        int i5 = this.f1301d;
        r0 r0Var = this.f1314a;
        switch (i5) {
            case 0:
                return r0Var.f1507l;
            default:
                return r0Var.f1508m;
        }
    }

    @Override // androidx.recyclerview.widget.d0
    public final int h() {
        int i5 = this.f1301d;
        r0 r0Var = this.f1314a;
        switch (i5) {
            case 0:
                return r0Var.E();
            default:
                return r0Var.G();
        }
    }

    @Override // androidx.recyclerview.widget.d0
    public final int i() {
        int G;
        int D;
        int i5 = this.f1301d;
        r0 r0Var = this.f1314a;
        switch (i5) {
            case 0:
                G = r0Var.f1509n - r0Var.E();
                D = r0Var.F();
                break;
            default:
                G = r0Var.o - r0Var.G();
                D = r0Var.D();
                break;
        }
        return G - D;
    }

    @Override // androidx.recyclerview.widget.d0
    public final int j(View view) {
        int i5 = this.f1301d;
        Rect rect = this.f1316c;
        r0 r0Var = this.f1314a;
        switch (i5) {
            case 0:
                r0Var.K(view, rect);
                return rect.right;
            default:
                r0Var.K(view, rect);
                return rect.bottom;
        }
    }

    @Override // androidx.recyclerview.widget.d0
    public final int k(View view) {
        int i5 = this.f1301d;
        Rect rect = this.f1316c;
        r0 r0Var = this.f1314a;
        switch (i5) {
            case 0:
                r0Var.K(view, rect);
                return rect.left;
            default:
                r0Var.K(view, rect);
                return rect.top;
        }
    }

    @Override // androidx.recyclerview.widget.d0
    public final void l(int i5) {
        int i6 = this.f1301d;
        r0 r0Var = this.f1314a;
        switch (i6) {
            case 0:
                r0Var.O(i5);
                return;
            default:
                r0Var.P(i5);
                return;
        }
    }

    public final int m(View view) {
        int A;
        int i5;
        int i6 = this.f1301d;
        r0 r0Var = this.f1314a;
        switch (i6) {
            case 0:
                s0 s0Var = (s0) view.getLayoutParams();
                r0Var.getClass();
                A = r0.z(view) + ((ViewGroup.MarginLayoutParams) s0Var).topMargin;
                i5 = ((ViewGroup.MarginLayoutParams) s0Var).bottomMargin;
                break;
            default:
                s0 s0Var2 = (s0) view.getLayoutParams();
                r0Var.getClass();
                A = r0.A(view) + ((ViewGroup.MarginLayoutParams) s0Var2).leftMargin;
                i5 = ((ViewGroup.MarginLayoutParams) s0Var2).rightMargin;
                break;
        }
        return A + i5;
    }
}
