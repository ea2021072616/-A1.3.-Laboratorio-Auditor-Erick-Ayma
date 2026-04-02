package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1576a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f1577b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f1578c;

    /* renamed from: d  reason: collision with root package name */
    public final List f1579d;

    /* renamed from: e  reason: collision with root package name */
    public int f1580e;

    /* renamed from: f  reason: collision with root package name */
    public int f1581f;

    /* renamed from: g  reason: collision with root package name */
    public x0 f1582g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f1583h;

    public y0(RecyclerView recyclerView) {
        this.f1583h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f1576a = arrayList;
        this.f1577b = null;
        this.f1578c = new ArrayList();
        this.f1579d = Collections.unmodifiableList(arrayList);
        this.f1580e = 2;
        this.f1581f = 2;
    }

    public final void a(i1 i1Var, boolean z4) {
        RecyclerView.l(i1Var);
        RecyclerView recyclerView = this.f1583h;
        k1 k1Var = recyclerView.f1246t0;
        View view = i1Var.f1376a;
        if (k1Var != null) {
            h0.b j5 = k1Var.j();
            h0.z0.n(view, j5 instanceof j1 ? (h0.b) ((j1) j5).f1400e.remove(view) : null);
        }
        if (z4) {
            ArrayList arrayList = recyclerView.f1247u;
            if (arrayList.size() > 0) {
                androidx.appcompat.widget.b0.n(arrayList.get(0));
                throw null;
            }
            if (recyclerView.f1233m0 != null) {
                recyclerView.f1232m.m(i1Var);
            }
            if (RecyclerView.G0) {
                Log.d("RecyclerView", "dispatchViewRecycled: " + i1Var);
            }
        }
        i1Var.f1393s = null;
        i1Var.f1392r = null;
        x0 c5 = c();
        c5.getClass();
        int i5 = i1Var.f1381f;
        ArrayList arrayList2 = c5.a(i5).f1553a;
        if (((w0) c5.f1561a.get(i5)).f1554b <= arrayList2.size()) {
            b4.j.d(view);
        } else if (RecyclerView.F0 && arrayList2.contains(i1Var)) {
            throw new IllegalArgumentException("this scrap item already exists");
        } else {
            i1Var.m();
            arrayList2.add(i1Var);
        }
    }

    public final int b(int i5) {
        RecyclerView recyclerView = this.f1583h;
        if (i5 >= 0 && i5 < recyclerView.f1233m0.b()) {
            return !recyclerView.f1233m0.f1328g ? i5 : recyclerView.f1228k.f(i5, 0);
        }
        throw new IndexOutOfBoundsException("invalid position " + i5 + ". State item count is " + recyclerView.f1233m0.b() + recyclerView.B());
    }

    public final x0 c() {
        if (this.f1582g == null) {
            this.f1582g = new x0();
            e();
        }
        return this.f1582g;
    }

    public final View d(int i5) {
        return l(i5, Long.MAX_VALUE).f1376a;
    }

    public final void e() {
        if (this.f1582g != null) {
            RecyclerView recyclerView = this.f1583h;
            if (recyclerView.f1243s == null || !recyclerView.isAttachedToWindow()) {
                return;
            }
            x0 x0Var = this.f1582g;
            x0Var.f1563c.add(recyclerView.f1243s);
        }
    }

    public final void f(i0 i0Var, boolean z4) {
        x0 x0Var = this.f1582g;
        if (x0Var == null) {
            return;
        }
        Set set = x0Var.f1563c;
        set.remove(i0Var);
        if (set.size() != 0 || z4) {
            return;
        }
        int i5 = 0;
        while (true) {
            SparseArray sparseArray = x0Var.f1561a;
            if (i5 >= sparseArray.size()) {
                return;
            }
            ArrayList arrayList = ((w0) sparseArray.get(sparseArray.keyAt(i5))).f1553a;
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                b4.j.d(((i1) arrayList.get(i6)).f1376a);
            }
            i5++;
        }
    }

    public final void g() {
        ArrayList arrayList = this.f1578c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            h(size);
        }
        arrayList.clear();
        if (RecyclerView.L0) {
            r rVar = this.f1583h.f1231l0;
            int[] iArr = rVar.f1494c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            rVar.f1495d = 0;
        }
    }

    public final void h(int i5) {
        if (RecyclerView.G0) {
            Log.d("RecyclerView", "Recycling cached view at index " + i5);
        }
        ArrayList arrayList = this.f1578c;
        i1 i1Var = (i1) arrayList.get(i5);
        if (RecyclerView.G0) {
            Log.d("RecyclerView", "CachedViewHolder to be recycled: " + i1Var);
        }
        a(i1Var, true);
        arrayList.remove(i5);
    }

    public final void i(View view) {
        i1 L = RecyclerView.L(view);
        boolean k5 = L.k();
        RecyclerView recyclerView = this.f1583h;
        if (k5) {
            recyclerView.removeDetachedView(view, false);
        }
        if (L.j()) {
            L.f1389n.m(L);
        } else if (L.p()) {
            L.f1385j &= -33;
        }
        j(L);
        if (recyclerView.R == null || L.h()) {
            return;
        }
        recyclerView.R.d(L);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(androidx.recyclerview.widget.i1 r13) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.y0.j(androidx.recyclerview.widget.i1):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(android.view.View r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.i1 r6 = androidx.recyclerview.widget.RecyclerView.L(r6)
            int r0 = r6.f1385j
            r1 = r0 & 12
            r2 = 1
            r3 = 0
            if (r1 == 0) goto Le
            r1 = r2
            goto Lf
        Le:
            r1 = r3
        Lf:
            androidx.recyclerview.widget.RecyclerView r4 = r5.f1583h
            if (r1 != 0) goto L5e
            r0 = r0 & 2
            if (r0 == 0) goto L19
            r0 = r2
            goto L1a
        L19:
            r0 = r3
        L1a:
            if (r0 == 0) goto L5e
            androidx.recyclerview.widget.n0 r0 = r4.R
            if (r0 == 0) goto L45
            java.util.List r1 = r6.d()
            androidx.recyclerview.widget.k r0 = (androidx.recyclerview.widget.k) r0
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L3f
            boolean r0 = r0.f1402g
            if (r0 == 0) goto L39
            boolean r0 = r6.g()
            if (r0 == 0) goto L37
            goto L39
        L37:
            r0 = r3
            goto L3a
        L39:
            r0 = r2
        L3a:
            if (r0 == 0) goto L3d
            goto L3f
        L3d:
            r0 = r3
            goto L40
        L3f:
            r0 = r2
        L40:
            if (r0 == 0) goto L43
            goto L45
        L43:
            r0 = r3
            goto L46
        L45:
            r0 = r2
        L46:
            if (r0 == 0) goto L49
            goto L5e
        L49:
            java.util.ArrayList r0 = r5.f1577b
            if (r0 != 0) goto L54
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5.f1577b = r0
        L54:
            r6.f1389n = r5
            r6.o = r2
            java.util.ArrayList r0 = r5.f1577b
            r0.add(r6)
            goto L8b
        L5e:
            boolean r0 = r6.g()
            if (r0 == 0) goto L82
            boolean r0 = r6.i()
            if (r0 != 0) goto L82
            androidx.recyclerview.widget.i0 r0 = r4.f1243s
            boolean r0 = r0.f1373h
            if (r0 == 0) goto L71
            goto L82
        L71:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool."
            r0.<init>(r1)
            java.lang.String r0 = androidx.appcompat.widget.b0.e(r4, r0)
            r6.<init>(r0)
            throw r6
        L82:
            r6.f1389n = r5
            r6.o = r3
            java.util.ArrayList r0 = r5.f1576a
            r0.add(r6)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.y0.k(android.view.View):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:254:0x046d, code lost:
        if (r8.g() == false) goto L251;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0633  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x064a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.recyclerview.widget.i1 l(int r21, long r22) {
        /*
            Method dump skipped, instructions count: 1666
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.y0.l(int, long):androidx.recyclerview.widget.i1");
    }

    public final void m(i1 i1Var) {
        if (i1Var.o) {
            this.f1577b.remove(i1Var);
        } else {
            this.f1576a.remove(i1Var);
        }
        i1Var.f1389n = null;
        i1Var.o = false;
        i1Var.f1385j &= -33;
    }

    public final void n() {
        r0 r0Var = this.f1583h.f1245t;
        this.f1581f = this.f1580e + (r0Var != null ? r0Var.f1505j : 0);
        ArrayList arrayList = this.f1578c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f1581f; size--) {
            h(size);
        }
    }
}
