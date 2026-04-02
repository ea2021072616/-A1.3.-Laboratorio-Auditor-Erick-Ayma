package androidx.recyclerview.widget;

import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class n0 {

    /* renamed from: a  reason: collision with root package name */
    public h0 f1431a = null;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f1432b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final long f1433c = 120;

    /* renamed from: d  reason: collision with root package name */
    public final long f1434d = 120;

    /* renamed from: e  reason: collision with root package name */
    public final long f1435e = 250;

    /* renamed from: f  reason: collision with root package name */
    public final long f1436f = 250;

    public static void b(i1 i1Var) {
        RecyclerView recyclerView;
        int i5 = i1Var.f1385j & 14;
        if (i1Var.g() || (i5 & 4) != 0 || (recyclerView = i1Var.f1392r) == null) {
            return;
        }
        recyclerView.I(i1Var);
    }

    public abstract boolean a(i1 i1Var, i1 i1Var2, m0 m0Var, m0 m0Var2);

    /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(androidx.recyclerview.widget.i1 r10) {
        /*
            r9 = this;
            androidx.recyclerview.widget.h0 r0 = r9.f1431a
            if (r0 == 0) goto Lb0
            r1 = 1
            r10.n(r1)
            androidx.recyclerview.widget.i1 r2 = r10.f1383h
            r3 = 0
            if (r2 == 0) goto L13
            androidx.recyclerview.widget.i1 r2 = r10.f1384i
            if (r2 != 0) goto L13
            r10.f1383h = r3
        L13:
            r10.f1384i = r3
            int r2 = r10.f1385j
            r2 = r2 & 16
            r3 = 0
            if (r2 == 0) goto L1e
            r2 = r1
            goto L1f
        L1e:
            r2 = r3
        L1f:
            if (r2 != 0) goto Lb0
            androidx.recyclerview.widget.RecyclerView r0 = r0.f1358a
            r0.i0()
            androidx.recyclerview.widget.d r2 = r0.f1230l
            androidx.recyclerview.widget.c r4 = r2.f1310b
            androidx.recyclerview.widget.h0 r5 = r2.f1309a
            int r6 = r2.f1312d
            android.view.View r7 = r10.f1376a
            if (r6 != r1) goto L3f
            android.view.View r1 = r2.f1313e
            if (r1 != r7) goto L37
            goto L65
        L37:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot call removeViewIfHidden within removeView(At) for a different view"
            r10.<init>(r0)
            throw r10
        L3f:
            r8 = 2
            if (r6 == r8) goto La8
            r2.f1312d = r8     // Catch: java.lang.Throwable -> La4
            androidx.recyclerview.widget.RecyclerView r6 = r5.f1358a     // Catch: java.lang.Throwable -> La4
            int r6 = r6.indexOfChild(r7)     // Catch: java.lang.Throwable -> La4
            r8 = -1
            if (r6 != r8) goto L51
            r2.k(r7)     // Catch: java.lang.Throwable -> La4
            goto L60
        L51:
            boolean r8 = r4.d(r6)     // Catch: java.lang.Throwable -> La4
            if (r8 == 0) goto L63
            r4.f(r6)     // Catch: java.lang.Throwable -> La4
            r2.k(r7)     // Catch: java.lang.Throwable -> La4
            r5.i(r6)     // Catch: java.lang.Throwable -> La4
        L60:
            r2.f1312d = r3
            goto L66
        L63:
            r2.f1312d = r3
        L65:
            r1 = r3
        L66:
            if (r1 == 0) goto L93
            androidx.recyclerview.widget.i1 r2 = androidx.recyclerview.widget.RecyclerView.L(r7)
            androidx.recyclerview.widget.y0 r4 = r0.f1224i
            r4.m(r2)
            r4.j(r2)
            boolean r2 = androidx.recyclerview.widget.RecyclerView.G0
            if (r2 == 0) goto L93
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "after removing animated view: "
            r2.<init>(r4)
            r2.append(r7)
            java.lang.String r4 = ", "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "RecyclerView"
            android.util.Log.d(r4, r2)
        L93:
            r2 = r1 ^ 1
            r0.j0(r2)
            if (r1 != 0) goto Lb0
            boolean r10 = r10.k()
            if (r10 == 0) goto Lb0
            r0.removeDetachedView(r7, r3)
            goto Lb0
        La4:
            r10 = move-exception
            r2.f1312d = r3
            throw r10
        La8:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot call removeViewIfHidden within removeViewIfHidden"
            r10.<init>(r0)
            throw r10
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.n0.c(androidx.recyclerview.widget.i1):void");
    }

    public abstract void d(i1 i1Var);

    public abstract void e();

    public abstract boolean f();
}
