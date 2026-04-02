package q3;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.b0;
import b4.j;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes.dex */
public final class d extends j {

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f4463x;

    public d(SideSheetBehavior sideSheetBehavior) {
        this.f4463x = sideSheetBehavior;
    }

    @Override // b4.j
    public final void H(int i5) {
        if (i5 == 1) {
            SideSheetBehavior sideSheetBehavior = this.f4463x;
            if (sideSheetBehavior.f2178g) {
                sideSheetBehavior.x(1);
            }
        }
    }

    @Override // b4.j
    public final void I(View view, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        SideSheetBehavior sideSheetBehavior = this.f4463x;
        WeakReference weakReference = sideSheetBehavior.f2187q;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
            a aVar = sideSheetBehavior.f2172a;
            int left = view.getLeft();
            int right = view.getRight();
            int i7 = aVar.f4455u;
            SideSheetBehavior sideSheetBehavior2 = aVar.f4456v;
            switch (i7) {
                case 0:
                    if (left <= sideSheetBehavior2.f2184m) {
                        marginLayoutParams.leftMargin = right;
                        break;
                    }
                    break;
                default:
                    int i8 = sideSheetBehavior2.f2184m;
                    if (left <= i8) {
                        marginLayoutParams.rightMargin = i8 - left;
                        break;
                    }
                    break;
            }
            view2.setLayoutParams(marginLayoutParams);
        }
        LinkedHashSet linkedHashSet = sideSheetBehavior.f2192v;
        if (linkedHashSet.isEmpty()) {
            return;
        }
        sideSheetBehavior.f2172a.d0(i5);
        Iterator it = linkedHashSet.iterator();
        if (it.hasNext()) {
            b0.n(it.next());
            throw null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r0.f2172a.k0(r4) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        if ((java.lang.Math.abs(r5) > java.lang.Math.abs(r6)) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
        if (java.lang.Math.abs(r5 - r0.f2172a.f0()) < java.lang.Math.abs(r5 - r0.f2172a.g0())) goto L22;
     */
    @Override // b4.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J(android.view.View r4, float r5, float r6) {
        /*
            r3 = this;
            com.google.android.material.sidesheet.SideSheetBehavior r0 = r3.f4463x
            q3.a r1 = r0.f2172a
            boolean r1 = r1.j0(r5)
            r2 = 1
            if (r1 == 0) goto Lc
            goto L58
        Lc:
            q3.a r1 = r0.f2172a
            boolean r1 = r1.m0(r4, r5)
            if (r1 == 0) goto L25
            q3.a r1 = r0.f2172a
            boolean r5 = r1.l0(r5, r6)
            if (r5 != 0) goto L5a
            q3.a r5 = r0.f2172a
            boolean r5 = r5.k0(r4)
            if (r5 == 0) goto L58
            goto L5a
        L25:
            r1 = 0
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 == 0) goto L3b
            float r5 = java.lang.Math.abs(r5)
            float r6 = java.lang.Math.abs(r6)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L38
            r5 = r2
            goto L39
        L38:
            r5 = 0
        L39:
            if (r5 != 0) goto L5a
        L3b:
            int r5 = r4.getLeft()
            q3.a r6 = r0.f2172a
            int r6 = r6.f0()
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            q3.a r1 = r0.f2172a
            int r1 = r1.g0()
            int r5 = r5 - r1
            int r5 = java.lang.Math.abs(r5)
            if (r6 >= r5) goto L5a
        L58:
            r5 = 3
            goto L5b
        L5a:
            r5 = 5
        L5b:
            r0.y(r4, r5, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.d.J(android.view.View, float, float):void");
    }

    @Override // b4.j
    public final boolean d0(View view, int i5) {
        WeakReference weakReference;
        SideSheetBehavior sideSheetBehavior = this.f4463x;
        return (sideSheetBehavior.f2179h == 1 || (weakReference = sideSheetBehavior.f2186p) == null || weakReference.get() != view) ? false : true;
    }

    @Override // b4.j
    public final int h(View view, int i5) {
        int f02;
        int i6;
        SideSheetBehavior sideSheetBehavior = this.f4463x;
        a aVar = sideSheetBehavior.f2172a;
        switch (aVar.f4455u) {
            case 0:
                f02 = -aVar.f4456v.f2183l;
                break;
            default:
                f02 = aVar.f0();
                break;
        }
        a aVar2 = sideSheetBehavior.f2172a;
        int i7 = aVar2.f4455u;
        SideSheetBehavior sideSheetBehavior2 = aVar2.f4456v;
        switch (i7) {
            case 0:
                i6 = sideSheetBehavior2.o;
                break;
            default:
                i6 = sideSheetBehavior2.f2184m;
                break;
        }
        return m0.a.a(i5, f02, i6);
    }

    @Override // b4.j
    public final int i(View view, int i5) {
        return view.getTop();
    }

    @Override // b4.j
    public final int z(View view) {
        SideSheetBehavior sideSheetBehavior = this.f4463x;
        return sideSheetBehavior.f2183l + sideSheetBehavior.o;
    }
}
