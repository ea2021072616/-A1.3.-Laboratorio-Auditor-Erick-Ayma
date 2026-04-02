package b3;

import android.view.View;
import b4.j;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class b extends j {

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f1636x;

    public b(BottomSheetBehavior bottomSheetBehavior) {
        this.f1636x = bottomSheetBehavior;
    }

    @Override // b4.j
    public final int A() {
        BottomSheetBehavior bottomSheetBehavior = this.f1636x;
        return bottomSheetBehavior.I ? bottomSheetBehavior.T : bottomSheetBehavior.G;
    }

    @Override // b4.j
    public final void H(int i5) {
        if (i5 == 1) {
            BottomSheetBehavior bottomSheetBehavior = this.f1636x;
            if (bottomSheetBehavior.K) {
                bottomSheetBehavior.I(1);
            }
        }
    }

    @Override // b4.j
    public final void I(View view, int i5, int i6) {
        this.f1636x.y(i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
        if (java.lang.Math.abs(r5.getTop() - r3.C()) < java.lang.Math.abs(r5.getTop() - r3.E)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0099, code lost:
        if (java.lang.Math.abs(r6 - r3.E) < java.lang.Math.abs(r6 - r3.G)) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b3, code lost:
        if (java.lang.Math.abs(r6 - r3.D) < java.lang.Math.abs(r6 - r3.G)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c2, code lost:
        if (r6 < java.lang.Math.abs(r6 - r3.G)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d3, code lost:
        if (java.lang.Math.abs(r6 - r7) < java.lang.Math.abs(r6 - r3.G)) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r6 > r3.E) goto L7;
     */
    @Override // b4.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J(android.view.View r5, float r6, float r7) {
        /*
            r4 = this;
            r0 = 0
            int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            r2 = 1
            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = r4.f1636x
            if (r1 >= 0) goto L1b
            boolean r6 = r3.f2023b
            if (r6 == 0) goto Le
            goto Lc4
        Le:
            int r6 = r5.getTop()
            java.lang.System.currentTimeMillis()
            int r7 = r3.E
            if (r6 <= r7) goto Lc4
            goto Ld5
        L1b:
            boolean r1 = r3.I
            if (r1 == 0) goto L70
            boolean r1 = r3.J(r5, r7)
            if (r1 == 0) goto L70
            float r6 = java.lang.Math.abs(r6)
            float r0 = java.lang.Math.abs(r7)
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 >= 0) goto L38
            int r6 = r3.f2027d
            float r6 = (float) r6
            int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r6 > 0) goto L4c
        L38:
            int r6 = r5.getTop()
            int r7 = r3.T
            int r0 = r3.C()
            int r0 = r0 + r7
            int r0 = r0 / 2
            if (r6 <= r0) goto L49
            r6 = r2
            goto L4a
        L49:
            r6 = 0
        L4a:
            if (r6 == 0) goto L4f
        L4c:
            r6 = 5
            goto Ld8
        L4f:
            boolean r6 = r3.f2023b
            if (r6 == 0) goto L55
            goto Lc4
        L55:
            int r6 = r5.getTop()
            int r7 = r3.C()
            int r6 = r6 - r7
            int r6 = java.lang.Math.abs(r6)
            int r7 = r5.getTop()
            int r0 = r3.E
            int r7 = r7 - r0
            int r7 = java.lang.Math.abs(r7)
            if (r6 >= r7) goto Ld5
            goto Lc4
        L70:
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 == 0) goto L9c
            float r6 = java.lang.Math.abs(r6)
            float r7 = java.lang.Math.abs(r7)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L81
            goto L9c
        L81:
            boolean r6 = r3.f2023b
            if (r6 == 0) goto L86
            goto Ld7
        L86:
            int r6 = r5.getTop()
            int r7 = r3.E
            int r7 = r6 - r7
            int r7 = java.lang.Math.abs(r7)
            int r0 = r3.G
            int r6 = r6 - r0
            int r6 = java.lang.Math.abs(r6)
            if (r7 >= r6) goto Ld7
            goto Ld5
        L9c:
            int r6 = r5.getTop()
            boolean r7 = r3.f2023b
            if (r7 == 0) goto Lb6
            int r7 = r3.D
            int r7 = r6 - r7
            int r7 = java.lang.Math.abs(r7)
            int r0 = r3.G
            int r6 = r6 - r0
            int r6 = java.lang.Math.abs(r6)
            if (r7 >= r6) goto Ld7
            goto Lc4
        Lb6:
            int r7 = r3.E
            if (r6 >= r7) goto Lc6
            int r7 = r3.G
            int r7 = r6 - r7
            int r7 = java.lang.Math.abs(r7)
            if (r6 >= r7) goto Ld5
        Lc4:
            r6 = 3
            goto Ld8
        Lc6:
            int r7 = r6 - r7
            int r7 = java.lang.Math.abs(r7)
            int r0 = r3.G
            int r6 = r6 - r0
            int r6 = java.lang.Math.abs(r6)
            if (r7 >= r6) goto Ld7
        Ld5:
            r6 = 6
            goto Ld8
        Ld7:
            r6 = 4
        Ld8:
            r3.getClass()
            r3.K(r5, r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.b.J(android.view.View, float, float):void");
    }

    @Override // b4.j
    public final boolean d0(View view, int i5) {
        BottomSheetBehavior bottomSheetBehavior = this.f1636x;
        int i6 = bottomSheetBehavior.L;
        if (i6 == 1 || bottomSheetBehavior.f2024b0) {
            return false;
        }
        if (i6 == 3 && bottomSheetBehavior.Z == i5) {
            WeakReference weakReference = bottomSheetBehavior.V;
            View view2 = weakReference != null ? (View) weakReference.get() : null;
            if (view2 != null && view2.canScrollVertically(-1)) {
                return false;
            }
        }
        System.currentTimeMillis();
        WeakReference weakReference2 = bottomSheetBehavior.U;
        return weakReference2 != null && weakReference2.get() == view;
    }

    @Override // b4.j
    public final int h(View view, int i5) {
        return view.getLeft();
    }

    @Override // b4.j
    public final int i(View view, int i5) {
        return m0.a.a(i5, this.f1636x.C(), A());
    }
}
