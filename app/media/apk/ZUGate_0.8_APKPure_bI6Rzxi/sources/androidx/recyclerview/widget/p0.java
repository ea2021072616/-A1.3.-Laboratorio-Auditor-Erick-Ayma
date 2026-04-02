package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public final class p0 implements s1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1445a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ r0 f1446b;

    public /* synthetic */ p0(r0 r0Var, int i5) {
        this.f1445a = i5;
        this.f1446b = r0Var;
    }

    public final int a(View view) {
        int bottom;
        int i5;
        int i6 = this.f1445a;
        r0 r0Var = this.f1446b;
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

    public final int b(View view) {
        int top;
        int i5;
        int i6 = this.f1445a;
        r0 r0Var = this.f1446b;
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

    public final int c() {
        int i5;
        int D;
        int i6 = this.f1445a;
        r0 r0Var = this.f1446b;
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
}
