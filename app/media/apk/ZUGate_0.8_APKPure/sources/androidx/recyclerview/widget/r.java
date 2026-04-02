package androidx.recyclerview.widget;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public int f1492a;

    /* renamed from: b  reason: collision with root package name */
    public int f1493b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f1494c;

    /* renamed from: d  reason: collision with root package name */
    public int f1495d;

    public final void a(int i5, int i6) {
        if (i5 < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i7 = this.f1495d * 2;
        int[] iArr = this.f1494c;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.f1494c = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i7 >= iArr.length) {
            int[] iArr3 = new int[i7 * 2];
            this.f1494c = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = this.f1494c;
        iArr4[i7] = i5;
        iArr4[i7 + 1] = i6;
        this.f1495d++;
    }

    public final void b(RecyclerView recyclerView, boolean z4) {
        boolean z5 = false;
        this.f1495d = 0;
        int[] iArr = this.f1494c;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        r0 r0Var = recyclerView.f1245t;
        if (recyclerView.f1243s == null || r0Var == null || !r0Var.f1504i) {
            return;
        }
        if (!z4) {
            if (!((!recyclerView.A || recyclerView.I || recyclerView.f1228k.g()) ? true : true)) {
                r0Var.h(this.f1492a, this.f1493b, recyclerView.f1233m0, this);
            }
        } else if (!recyclerView.f1228k.g()) {
            r0Var.i(recyclerView.f1243s.a(), this);
        }
        int i5 = this.f1495d;
        if (i5 > r0Var.f1505j) {
            r0Var.f1505j = i5;
            r0Var.f1506k = z4;
            recyclerView.f1224i.n();
        }
    }
}
