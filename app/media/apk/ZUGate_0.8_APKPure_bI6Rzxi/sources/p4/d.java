package p4;

import e4.e;
/* loaded from: classes.dex */
public abstract class d extends c {
    /* JADX WARN: Removed duplicated region for block: B:49:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090 A[EDGE_INSN: B:56:0x0090->B:48:0x0090 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int I0(java.lang.CharSequence r10, java.lang.String r11, int r12, boolean r13) {
        /*
            java.lang.String r0 = "string"
            e4.e.f(r11, r0)
            if (r13 != 0) goto L14
            boolean r0 = r10 instanceof java.lang.String
            if (r0 != 0) goto Lc
            goto L14
        Lc:
            java.lang.String r10 = (java.lang.String) r10
            int r10 = r10.indexOf(r11, r12)
            goto L97
        L14:
            int r0 = r10.length()
            m4.c r1 = new m4.c
            r2 = 0
            if (r12 >= 0) goto L1e
            r12 = r2
        L1e:
            int r3 = r10.length()
            if (r0 <= r3) goto L25
            r0 = r3
        L25:
            r1.<init>(r12, r0)
            boolean r0 = r10 instanceof java.lang.String
            int r3 = r1.f3988d
            int r1 = r1.f3987c
            if (r0 == 0) goto L55
            if (r3 <= 0) goto L34
            if (r12 <= r1) goto L38
        L34:
            if (r3 >= 0) goto L96
            if (r1 > r12) goto L96
        L38:
            r7 = r10
            java.lang.String r7 = (java.lang.String) r7
            int r9 = r11.length()
            if (r13 != 0) goto L46
            boolean r0 = r11.regionMatches(r2, r7, r12, r9)
            goto L4e
        L46:
            r6 = 0
            r4 = r11
            r5 = r13
            r8 = r12
            boolean r0 = r4.regionMatches(r5, r6, r7, r8, r9)
        L4e:
            if (r0 == 0) goto L51
            goto L90
        L51:
            if (r12 == r1) goto L96
            int r12 = r12 + r3
            goto L38
        L55:
            if (r3 <= 0) goto L59
            if (r12 <= r1) goto L5d
        L59:
            if (r3 >= 0) goto L96
            if (r1 > r12) goto L96
        L5d:
            int r0 = r11.length()
            if (r12 < 0) goto L8d
            int r4 = r11.length()
            int r4 = r4 - r0
            if (r4 < 0) goto L8d
            int r4 = r10.length()
            int r4 = r4 - r0
            if (r12 <= r4) goto L72
            goto L8d
        L72:
            r4 = r2
        L73:
            if (r4 >= r0) goto L8b
            int r5 = r2 + r4
            char r5 = r11.charAt(r5)
            int r6 = r12 + r4
            char r6 = r10.charAt(r6)
            boolean r5 = e4.e.i(r5, r6, r13)
            if (r5 != 0) goto L88
            goto L8d
        L88:
            int r4 = r4 + 1
            goto L73
        L8b:
            r0 = 1
            goto L8e
        L8d:
            r0 = r2
        L8e:
            if (r0 == 0) goto L92
        L90:
            r10 = r12
            goto L97
        L92:
            if (r12 == r1) goto L96
            int r12 = r12 + r3
            goto L5d
        L96:
            r10 = -1
        L97:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.d.I0(java.lang.CharSequence, java.lang.String, int, boolean):int");
    }

    public static String J0(String str, String str2) {
        e.f(str2, "delimiter");
        int I0 = I0(str, str2, 0, false);
        if (I0 == -1) {
            return str;
        }
        String substring = str.substring(str2.length() + I0, str.length());
        e.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static String K0(String str) {
        e.f(str, "<this>");
        e.f(str, "missingDelimiterValue");
        int lastIndexOf = str.lastIndexOf(46, str.length() - 1);
        if (lastIndexOf == -1) {
            return str;
        }
        String substring = str.substring(lastIndexOf + 1, str.length());
        e.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}
