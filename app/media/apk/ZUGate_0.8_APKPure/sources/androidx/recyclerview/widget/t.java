package androidx.recyclerview.widget;

import android.os.Trace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class t implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public static final ThreadLocal f1524f = new ThreadLocal();

    /* renamed from: g  reason: collision with root package name */
    public static final u.g f1525g = new u.g(2);

    /* renamed from: c  reason: collision with root package name */
    public long f1527c;

    /* renamed from: d  reason: collision with root package name */
    public long f1528d;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f1526b = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f1529e = new ArrayList();

    public static i1 c(RecyclerView recyclerView, int i5, long j5) {
        boolean z4;
        int h5 = recyclerView.f1230l.h();
        int i6 = 0;
        while (true) {
            if (i6 >= h5) {
                z4 = false;
                break;
            }
            i1 L = RecyclerView.L(recyclerView.f1230l.g(i6));
            if (L.f1378c == i5 && !L.g()) {
                z4 = true;
                break;
            }
            i6++;
        }
        if (z4) {
            return null;
        }
        y0 y0Var = recyclerView.f1224i;
        try {
            recyclerView.S();
            i1 l5 = y0Var.l(i5, j5);
            if (l5 != null) {
                if (!l5.f() || l5.g()) {
                    y0Var.a(l5, false);
                } else {
                    y0Var.i(l5.f1376a);
                }
            }
            return l5;
        } finally {
            recyclerView.T(false);
        }
    }

    public final void a(RecyclerView recyclerView, int i5, int i6) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.F0 && !this.f1526b.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.f1527c == 0) {
                this.f1527c = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        r rVar = recyclerView.f1231l0;
        rVar.f1492a = i5;
        rVar.f1493b = i6;
    }

    public final void b(long j5) {
        s sVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        s sVar2;
        ArrayList arrayList = this.f1526b;
        int size = arrayList.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList.get(i6);
            if (recyclerView3.getWindowVisibility() == 0) {
                r rVar = recyclerView3.f1231l0;
                rVar.b(recyclerView3, false);
                i5 += rVar.f1495d;
            }
        }
        ArrayList arrayList2 = this.f1529e;
        arrayList2.ensureCapacity(i5);
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            RecyclerView recyclerView4 = (RecyclerView) arrayList.get(i8);
            if (recyclerView4.getWindowVisibility() == 0) {
                r rVar2 = recyclerView4.f1231l0;
                int abs = Math.abs(rVar2.f1493b) + Math.abs(rVar2.f1492a);
                for (int i9 = 0; i9 < rVar2.f1495d * 2; i9 += 2) {
                    if (i7 >= arrayList2.size()) {
                        sVar2 = new s();
                        arrayList2.add(sVar2);
                    } else {
                        sVar2 = (s) arrayList2.get(i7);
                    }
                    int[] iArr = rVar2.f1494c;
                    int i10 = iArr[i9 + 1];
                    sVar2.f1515a = i10 <= abs;
                    sVar2.f1516b = abs;
                    sVar2.f1517c = i10;
                    sVar2.f1518d = recyclerView4;
                    sVar2.f1519e = iArr[i9];
                    i7++;
                }
            }
        }
        Collections.sort(arrayList2, f1525g);
        for (int i11 = 0; i11 < arrayList2.size() && (recyclerView = (sVar = (s) arrayList2.get(i11)).f1518d) != null; i11++) {
            i1 c5 = c(recyclerView, sVar.f1519e, sVar.f1515a ? Long.MAX_VALUE : j5);
            if (c5 != null && c5.f1377b != null && c5.f() && !c5.g() && (recyclerView2 = (RecyclerView) c5.f1377b.get()) != null) {
                if (recyclerView2.I && recyclerView2.f1230l.h() != 0) {
                    n0 n0Var = recyclerView2.R;
                    if (n0Var != null) {
                        n0Var.e();
                    }
                    r0 r0Var = recyclerView2.f1245t;
                    y0 y0Var = recyclerView2.f1224i;
                    if (r0Var != null) {
                        r0Var.i0(y0Var);
                        recyclerView2.f1245t.j0(y0Var);
                    }
                    y0Var.f1576a.clear();
                    y0Var.g();
                }
                r rVar3 = recyclerView2.f1231l0;
                rVar3.b(recyclerView2, true);
                if (rVar3.f1495d != 0) {
                    try {
                        int i12 = d0.j.f2506a;
                        Trace.beginSection("RV Nested Prefetch");
                        e1 e1Var = recyclerView2.f1233m0;
                        i0 i0Var = recyclerView2.f1243s;
                        e1Var.f1325d = 1;
                        e1Var.f1326e = i0Var.a();
                        e1Var.f1328g = false;
                        e1Var.f1329h = false;
                        e1Var.f1330i = false;
                        for (int i13 = 0; i13 < rVar3.f1495d * 2; i13 += 2) {
                            c(recyclerView2, rVar3.f1494c[i13], j5);
                        }
                        Trace.endSection();
                        sVar.f1515a = false;
                        sVar.f1516b = 0;
                        sVar.f1517c = 0;
                        sVar.f1518d = null;
                        sVar.f1519e = 0;
                    } catch (Throwable th) {
                        int i14 = d0.j.f2506a;
                        Trace.endSection();
                        throw th;
                    }
                }
            }
            sVar.f1515a = false;
            sVar.f1516b = 0;
            sVar.f1517c = 0;
            sVar.f1518d = null;
            sVar.f1519e = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i5 = d0.j.f2506a;
            Trace.beginSection("RV Prefetch");
            ArrayList arrayList = this.f1526b;
            if (arrayList.isEmpty()) {
                this.f1527c = 0L;
                Trace.endSection();
                return;
            }
            int size = arrayList.size();
            long j5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                RecyclerView recyclerView = (RecyclerView) arrayList.get(i6);
                if (recyclerView.getWindowVisibility() == 0) {
                    j5 = Math.max(recyclerView.getDrawingTime(), j5);
                }
            }
            if (j5 == 0) {
                this.f1527c = 0L;
                Trace.endSection();
                return;
            }
            b(TimeUnit.MILLISECONDS.toNanos(j5) + this.f1528d);
            this.f1527c = 0L;
            Trace.endSection();
        } catch (Throwable th) {
            this.f1527c = 0L;
            int i7 = d0.j.f2506a;
            Trace.endSection();
            throw th;
        }
    }
}
