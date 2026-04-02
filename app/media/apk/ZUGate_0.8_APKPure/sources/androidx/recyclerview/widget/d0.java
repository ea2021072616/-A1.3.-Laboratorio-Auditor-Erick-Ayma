package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public abstract class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final r0 f1314a;

    /* renamed from: b  reason: collision with root package name */
    public int f1315b = Integer.MIN_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f1316c = new Rect();

    public d0(r0 r0Var) {
        this.f1314a = r0Var;
    }

    public static c0 a(r0 r0Var, int i5) {
        if (i5 != 0) {
            if (i5 == 1) {
                return new c0(r0Var, 1);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return new c0(r0Var, 0);
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j(View view);

    public abstract int k(View view);

    public abstract void l(int i5);
}
