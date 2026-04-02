package com.pili.pldroid.player.common;
/* compiled from: ViewMeasurer.java */
/* loaded from: classes2.dex */
public class a {

    /* compiled from: ViewMeasurer.java */
    /* renamed from: com.pili.pldroid.player.common.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0096a {

        /* renamed from: a  reason: collision with root package name */
        public final int f5021a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5022b;

        public C0096a(int i, int i2) {
            this.f5021a = i;
            this.f5022b = i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x007d, code lost:
        if (r1 > r2) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.pili.pldroid.player.common.a.C0096a a(int r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = 1073741824(0x40000000, float:2.0)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            int r3 = android.view.View.getDefaultSize(r11, r9)
            int r1 = android.view.View.getDefaultSize(r12, r10)
            if (r8 != 0) goto L14
            com.pili.pldroid.player.common.a$a r0 = new com.pili.pldroid.player.common.a$a
            r0.<init>(r11, r12)
        L13:
            return r0
        L14:
            if (r11 <= 0) goto L18
            if (r12 > 0) goto L1e
        L18:
            com.pili.pldroid.player.common.a$a r0 = new com.pili.pldroid.player.common.a$a
            r0.<init>(r3, r1)
            goto L13
        L1e:
            int r4 = android.view.View.MeasureSpec.getMode(r9)
            int r2 = android.view.View.MeasureSpec.getSize(r9)
            int r5 = android.view.View.MeasureSpec.getMode(r10)
            int r0 = android.view.View.MeasureSpec.getSize(r10)
            if (r4 != r7) goto L6b
            if (r5 != r7) goto L6b
            float r4 = (float) r2
            float r5 = (float) r0
            float r5 = r4 / r5
            switch(r8) {
                case 3: goto L49;
                case 4: goto L4d;
                default: goto L39;
            }
        L39:
            float r4 = (float) r11
            float r6 = (float) r12
            float r4 = r4 / r6
        L3c:
            switch(r8) {
                case 1: goto L51;
                case 2: goto L5e;
                case 3: goto L51;
                case 4: goto L51;
                default: goto L3f;
            }
        L3f:
            r0 = r1
            r1 = r3
        L41:
            r2 = r1
        L42:
            com.pili.pldroid.player.common.a$a r1 = new com.pili.pldroid.player.common.a$a
            r1.<init>(r2, r0)
            r0 = r1
            goto L13
        L49:
            r4 = 1071877689(0x3fe38e39, float:1.7777778)
            goto L3c
        L4d:
            r4 = 1068149419(0x3faaaaab, float:1.3333334)
            goto L3c
        L51:
            int r1 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r1 <= 0) goto L5a
            float r0 = (float) r2
            float r0 = r0 / r4
            int r0 = (int) r0
            r1 = r2
            goto L41
        L5a:
            float r1 = (float) r0
            float r1 = r1 * r4
            int r1 = (int) r1
            goto L41
        L5e:
            int r1 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r1 <= 0) goto L66
            float r1 = (float) r0
            float r1 = r1 * r4
            int r1 = (int) r1
            goto L41
        L66:
            float r0 = (float) r2
            float r0 = r0 / r4
            int r0 = (int) r0
            r1 = r2
            goto L41
        L6b:
            if (r4 != r7) goto L76
            int r1 = r2 * r12
            int r1 = r1 / r11
            if (r5 != r6) goto L74
            if (r1 > r0) goto L42
        L74:
            r0 = r1
            goto L42
        L76:
            if (r5 != r7) goto L81
            int r1 = r0 * r11
            int r1 = r1 / r12
            if (r4 != r6) goto L7f
            if (r1 > r2) goto L42
        L7f:
            r2 = r1
            goto L42
        L81:
            if (r5 != r6) goto L90
            if (r12 <= r0) goto L90
            int r1 = r0 * r11
            int r1 = r1 / r12
        L88:
            if (r4 != r6) goto L7f
            if (r1 <= r2) goto L7f
            int r0 = r2 * r12
            int r0 = r0 / r11
            goto L42
        L90:
            r0 = r12
            r1 = r11
            goto L88
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pili.pldroid.player.common.a.a(int, int, int, int, int):com.pili.pldroid.player.common.a$a");
    }
}
