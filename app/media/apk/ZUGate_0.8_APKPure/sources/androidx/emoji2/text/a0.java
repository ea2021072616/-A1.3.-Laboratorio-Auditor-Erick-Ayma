package androidx.emoji2.text;

import android.util.SparseArray;
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f743a;

    /* renamed from: b  reason: collision with root package name */
    public d0 f744b;

    public a0(int i5) {
        this.f743a = new SparseArray(i5);
    }

    public final void a(d0 d0Var, int i5, int i6) {
        int a5 = d0Var.a(i5);
        SparseArray sparseArray = this.f743a;
        a0 a0Var = sparseArray == null ? null : (a0) sparseArray.get(a5);
        if (a0Var == null) {
            a0Var = new a0(1);
            sparseArray.put(d0Var.a(i5), a0Var);
        }
        if (i6 > i5) {
            a0Var.a(d0Var, i5 + 1, i6);
        } else {
            a0Var.f744b = d0Var;
        }
    }
}
