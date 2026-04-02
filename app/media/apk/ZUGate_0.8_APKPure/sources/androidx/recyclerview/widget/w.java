package androidx.recyclerview.widget;

import android.view.View;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public c0 f1548a;

    /* renamed from: b  reason: collision with root package name */
    public int f1549b;

    /* renamed from: c  reason: collision with root package name */
    public int f1550c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1551d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1552e;

    public w() {
        d();
    }

    public final void a() {
        this.f1550c = this.f1551d ? this.f1548a.f() : this.f1548a.h();
    }

    public final void b(View view, int i5) {
        if (this.f1551d) {
            int b5 = this.f1548a.b(view);
            c0 c0Var = this.f1548a;
            this.f1550c = (Integer.MIN_VALUE == c0Var.f1315b ? 0 : c0Var.i() - c0Var.f1315b) + b5;
        } else {
            this.f1550c = this.f1548a.d(view);
        }
        this.f1549b = i5;
    }

    public final void c(View view, int i5) {
        c0 c0Var = this.f1548a;
        int i6 = Integer.MIN_VALUE == c0Var.f1315b ? 0 : c0Var.i() - c0Var.f1315b;
        if (i6 >= 0) {
            b(view, i5);
            return;
        }
        this.f1549b = i5;
        if (!this.f1551d) {
            int d5 = this.f1548a.d(view);
            int h5 = d5 - this.f1548a.h();
            this.f1550c = d5;
            if (h5 > 0) {
                int f5 = (this.f1548a.f() - Math.min(0, (this.f1548a.f() - i6) - this.f1548a.b(view))) - (this.f1548a.c(view) + d5);
                if (f5 < 0) {
                    this.f1550c -= Math.min(h5, -f5);
                    return;
                }
                return;
            }
            return;
        }
        int f6 = (this.f1548a.f() - i6) - this.f1548a.b(view);
        this.f1550c = this.f1548a.f() - f6;
        if (f6 > 0) {
            int c5 = this.f1550c - this.f1548a.c(view);
            int h6 = this.f1548a.h();
            int min = c5 - (Math.min(this.f1548a.d(view) - h6, 0) + h6);
            if (min < 0) {
                this.f1550c = Math.min(f6, -min) + this.f1550c;
            }
        }
    }

    public final void d() {
        this.f1549b = -1;
        this.f1550c = Integer.MIN_VALUE;
        this.f1551d = false;
        this.f1552e = false;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.f1549b + ", mCoordinate=" + this.f1550c + ", mLayoutFromEnd=" + this.f1551d + ", mValid=" + this.f1552e + '}';
    }
}
