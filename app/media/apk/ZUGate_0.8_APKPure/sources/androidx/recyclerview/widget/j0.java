package androidx.recyclerview.widget;

import android.database.Observable;
/* loaded from: classes.dex */
public final class j0 extends Observable {
    public final boolean a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            RecyclerView recyclerView = ((a1) ((Observable) this).mObservers.get(size)).f1289a;
            recyclerView.k(null);
            recyclerView.f1233m0.f1327f = true;
            recyclerView.X(true);
            if (!recyclerView.f1228k.g()) {
                recyclerView.requestLayout();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(int r8, int r9, java.lang.Object r10) {
        /*
            r7 = this;
            java.util.ArrayList r0 = r7.mObservers
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L40
            java.util.ArrayList r2 = r7.mObservers
            java.lang.Object r2 = r2.get(r0)
            androidx.recyclerview.widget.a1 r2 = (androidx.recyclerview.widget.a1) r2
            androidx.recyclerview.widget.RecyclerView r3 = r2.f1289a
            r4 = 0
            r3.k(r4)
            androidx.recyclerview.widget.b r3 = r3.f1228k
            if (r9 >= r1) goto L20
            r3.getClass()
            goto L37
        L20:
            java.util.ArrayList r4 = r3.f1291b
            r5 = 4
            androidx.recyclerview.widget.a r6 = r3.h(r10, r5, r8, r9)
            r4.add(r6)
            int r6 = r3.f1295f
            r5 = r5 | r6
            r3.f1295f = r5
            int r3 = r4.size()
            if (r3 != r1) goto L37
            r3 = r1
            goto L38
        L37:
            r3 = 0
        L38:
            if (r3 == 0) goto L3d
            r2.a()
        L3d:
            int r0 = r0 + (-1)
            goto L8
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.j0.c(int, int, java.lang.Object):void");
    }
}
