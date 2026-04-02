package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f1358a;

    public /* synthetic */ h0(RecyclerView recyclerView) {
        this.f1358a = recyclerView;
    }

    public final void a(a aVar) {
        int i5 = aVar.f1270a;
        RecyclerView recyclerView = this.f1358a;
        if (i5 == 1) {
            recyclerView.f1245t.Y(aVar.f1271b, aVar.f1273d);
        } else if (i5 == 2) {
            recyclerView.f1245t.b0(aVar.f1271b, aVar.f1273d);
        } else if (i5 == 4) {
            recyclerView.f1245t.c0(aVar.f1271b, aVar.f1273d);
        } else if (i5 != 8) {
        } else {
            recyclerView.f1245t.a0(aVar.f1271b, aVar.f1273d);
        }
    }

    public final i1 b(int i5) {
        RecyclerView recyclerView = this.f1358a;
        int h5 = recyclerView.f1230l.h();
        int i6 = 0;
        i1 i1Var = null;
        while (true) {
            if (i6 >= h5) {
                break;
            }
            i1 L = RecyclerView.L(recyclerView.f1230l.g(i6));
            if (L != null && !L.i() && L.f1378c == i5) {
                if (!recyclerView.f1230l.j(L.f1376a)) {
                    i1Var = L;
                    break;
                }
                i1Var = L;
            }
            i6++;
        }
        if (i1Var == null) {
            return null;
        }
        if (recyclerView.f1230l.j(i1Var.f1376a)) {
            if (RecyclerView.G0) {
                Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
            }
            return null;
        }
        return i1Var;
    }

    public final int c() {
        return this.f1358a.getChildCount();
    }

    public final void d(int i5, int i6, Object obj) {
        int i7;
        int i8;
        RecyclerView recyclerView = this.f1358a;
        int h5 = recyclerView.f1230l.h();
        int i9 = i6 + i5;
        for (int i10 = 0; i10 < h5; i10++) {
            View g5 = recyclerView.f1230l.g(i10);
            i1 L = RecyclerView.L(g5);
            if (L != null && !L.o() && (i8 = L.f1378c) >= i5 && i8 < i9) {
                L.b(2);
                L.a(obj);
                ((s0) g5.getLayoutParams()).f1522c = true;
            }
        }
        y0 y0Var = recyclerView.f1224i;
        ArrayList arrayList = y0Var.f1578c;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                recyclerView.f1240q0 = true;
                return;
            }
            i1 i1Var = (i1) arrayList.get(size);
            if (i1Var != null && (i7 = i1Var.f1378c) >= i5 && i7 < i9) {
                i1Var.b(2);
                y0Var.h(size);
            }
        }
    }

    public final void e(int i5, int i6) {
        RecyclerView recyclerView = this.f1358a;
        int h5 = recyclerView.f1230l.h();
        for (int i7 = 0; i7 < h5; i7++) {
            i1 L = RecyclerView.L(recyclerView.f1230l.g(i7));
            if (L != null && !L.o() && L.f1378c >= i5) {
                if (RecyclerView.G0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + i7 + " holder " + L + " now at position " + (L.f1378c + i6));
                }
                L.l(i6, false);
                recyclerView.f1233m0.f1327f = true;
            }
        }
        ArrayList arrayList = recyclerView.f1224i.f1578c;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            i1 i1Var = (i1) arrayList.get(i8);
            if (i1Var != null && i1Var.f1378c >= i5) {
                if (RecyclerView.G0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + i8 + " holder " + i1Var + " now at position " + (i1Var.f1378c + i6));
                }
                i1Var.l(i6, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.f1238p0 = true;
    }

    public final void f(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        RecyclerView recyclerView = this.f1358a;
        int h5 = recyclerView.f1230l.h();
        if (i5 < i6) {
            i8 = i5;
            i7 = i6;
            i9 = -1;
        } else {
            i7 = i5;
            i8 = i6;
            i9 = 1;
        }
        boolean z4 = false;
        for (int i15 = 0; i15 < h5; i15++) {
            i1 L = RecyclerView.L(recyclerView.f1230l.g(i15));
            if (L != null && (i14 = L.f1378c) >= i8 && i14 <= i7) {
                if (RecyclerView.G0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + i15 + " holder " + L);
                }
                if (L.f1378c == i5) {
                    L.l(i6 - i5, false);
                } else {
                    L.l(i9, false);
                }
                recyclerView.f1233m0.f1327f = true;
            }
        }
        y0 y0Var = recyclerView.f1224i;
        y0Var.getClass();
        if (i5 < i6) {
            i11 = i5;
            i10 = i6;
            i12 = -1;
        } else {
            i10 = i5;
            i11 = i6;
            i12 = 1;
        }
        ArrayList arrayList = y0Var.f1578c;
        int size = arrayList.size();
        int i16 = 0;
        while (i16 < size) {
            i1 i1Var = (i1) arrayList.get(i16);
            if (i1Var != null && (i13 = i1Var.f1378c) >= i11 && i13 <= i10) {
                if (i13 == i5) {
                    i1Var.l(i6 - i5, z4);
                } else {
                    i1Var.l(i12, z4);
                }
                if (RecyclerView.G0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + i16 + " holder " + i1Var);
                }
            }
            i16++;
            z4 = false;
        }
        recyclerView.requestLayout();
        recyclerView.f1238p0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(androidx.recyclerview.widget.i1 r9, androidx.recyclerview.widget.m0 r10, androidx.recyclerview.widget.m0 r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r8.f1358a
            r0.getClass()
            r1 = 0
            r9.n(r1)
            androidx.recyclerview.widget.n0 r1 = r0.R
            r2 = r1
            androidx.recyclerview.widget.k r2 = (androidx.recyclerview.widget.k) r2
            if (r10 == 0) goto L29
            r2.getClass()
            int r4 = r10.f1419a
            int r6 = r11.f1419a
            if (r4 != r6) goto L1f
            int r1 = r10.f1420b
            int r3 = r11.f1420b
            if (r1 == r3) goto L29
        L1f:
            int r5 = r10.f1420b
            int r7 = r11.f1420b
            r3 = r9
            boolean r9 = r2.g(r3, r4, r5, r6, r7)
            goto L38
        L29:
            r2.l(r9)
            android.view.View r10 = r9.f1376a
            r11 = 0
            r10.setAlpha(r11)
            java.util.ArrayList r10 = r2.f1404i
            r10.add(r9)
            r9 = 1
        L38:
            if (r9 == 0) goto L3d
            r0.V()
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.h0.g(androidx.recyclerview.widget.i1, androidx.recyclerview.widget.m0, androidx.recyclerview.widget.m0):void");
    }

    public final void h(i1 i1Var, m0 m0Var, m0 m0Var2) {
        boolean z4;
        RecyclerView recyclerView = this.f1358a;
        recyclerView.f1224i.m(i1Var);
        recyclerView.h(i1Var);
        i1Var.n(false);
        k kVar = (k) recyclerView.R;
        kVar.getClass();
        int i5 = m0Var.f1419a;
        int i6 = m0Var.f1420b;
        View view = i1Var.f1376a;
        int left = m0Var2 == null ? view.getLeft() : m0Var2.f1419a;
        int top = m0Var2 == null ? view.getTop() : m0Var2.f1420b;
        if (i1Var.i() || (i5 == left && i6 == top)) {
            kVar.l(i1Var);
            kVar.f1403h.add(i1Var);
            z4 = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            z4 = kVar.g(i1Var, i5, i6, left, top);
        }
        if (z4) {
            recyclerView.V();
        }
    }

    public final void i(int i5) {
        RecyclerView recyclerView = this.f1358a;
        View childAt = recyclerView.getChildAt(i5);
        if (childAt != null) {
            RecyclerView.L(childAt);
            i0 i0Var = recyclerView.f1243s;
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i5);
    }
}
