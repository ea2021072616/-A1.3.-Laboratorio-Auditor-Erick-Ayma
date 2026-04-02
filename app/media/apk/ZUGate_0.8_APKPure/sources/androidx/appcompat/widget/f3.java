package androidx.appcompat.widget;

import android.util.SparseIntArray;
/* loaded from: classes.dex */
public final class f3 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f346a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f347b;

    /* renamed from: c  reason: collision with root package name */
    public Object f348c;

    /* renamed from: d  reason: collision with root package name */
    public Object f349d;

    public f3(int i5) {
        if (i5 != 1) {
            return;
        }
        this.f348c = new SparseIntArray();
        this.f349d = new SparseIntArray();
        this.f346a = false;
        this.f347b = false;
    }

    public final int a(int i5, int i6) {
        if (this.f347b) {
            int i7 = ((SparseIntArray) this.f349d).get(i5, -1);
            if (i7 != -1) {
                return i7;
            }
            int c5 = c(i5, i6);
            ((SparseIntArray) this.f349d).put(i5, c5);
            return c5;
        }
        return c(i5, i6);
    }

    public final int b(int i5, int i6) {
        if (this.f346a) {
            int i7 = ((SparseIntArray) this.f348c).get(i5, -1);
            if (i7 != -1) {
                return i7;
            }
            int i8 = i5 % i6;
            ((SparseIntArray) this.f348c).put(i5, i8);
            return i8;
        }
        return i5 % i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(int r9, int r10) {
        /*
            r8 = this;
            boolean r0 = r8.f347b
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L48
            java.lang.Object r0 = r8.f349d
            android.util.SparseIntArray r0 = (android.util.SparseIntArray) r0
            int r3 = r0.size()
            r4 = -1
            int r3 = r3 + r4
            r5 = r2
        L11:
            if (r5 > r3) goto L22
            int r6 = r5 + r3
            int r6 = r6 >>> r1
            int r7 = r0.keyAt(r6)
            if (r7 >= r9) goto L1f
            int r5 = r6 + 1
            goto L11
        L1f:
            int r3 = r6 + (-1)
            goto L11
        L22:
            int r5 = r5 + r4
            if (r5 < 0) goto L30
            int r3 = r0.size()
            if (r5 >= r3) goto L30
            int r0 = r0.keyAt(r5)
            goto L31
        L30:
            r0 = r4
        L31:
            if (r0 == r4) goto L48
            java.lang.Object r3 = r8.f349d
            android.util.SparseIntArray r3 = (android.util.SparseIntArray) r3
            int r3 = r3.get(r0)
            int r4 = r0 + 1
            int r0 = r8.b(r0, r10)
            int r0 = r0 + r1
            if (r0 != r10) goto L4b
            int r3 = r3 + 1
            r0 = r2
            goto L4b
        L48:
            r0 = r2
            r3 = r0
            r4 = r3
        L4b:
            if (r4 >= r9) goto L5d
            int r0 = r0 + 1
            if (r0 != r10) goto L55
            int r3 = r3 + 1
            r0 = r2
            goto L5a
        L55:
            if (r0 <= r10) goto L5a
            int r3 = r3 + 1
            r0 = r1
        L5a:
            int r4 = r4 + 1
            goto L4b
        L5d:
            int r0 = r0 + r1
            if (r0 <= r10) goto L62
            int r3 = r3 + 1
        L62:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.f3.c(int, int):int");
    }

    public final void d() {
        ((SparseIntArray) this.f348c).clear();
    }
}
