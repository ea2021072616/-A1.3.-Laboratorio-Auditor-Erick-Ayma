package com.fotoable.youtube.music.util.a;

import com.flurry.android.Constants;
/* compiled from: PinyinUtils.java */
/* loaded from: classes.dex */
public final class e {
    public static String a(char c2) {
        if (b(c2)) {
            if (c2 == 12295) {
                return "LING";
            }
            return d.f4860b[c(c2)];
        }
        return String.valueOf(c2);
    }

    public static boolean b(char c2) {
        return (19968 <= c2 && c2 <= 40869 && c(c2) > 0) || 12295 == c2;
    }

    private static int c(char c2) {
        int i = c2 - 19968;
        if (i >= 0 && i < 7000) {
            return a(a.f4853a, a.f4854b, i);
        }
        if (7000 <= i && i < 14000) {
            return a(b.f4855a, b.f4856b, i - 7000);
        }
        return a(c.f4857a, c.f4858b, i - 14000);
    }

    private static short a(byte[] bArr, byte[] bArr2, int i) {
        short s = (short) (bArr2[i] & Constants.UNKNOWN);
        if ((bArr[i / 8] & d.f4859a[i % 8]) != 0) {
            return (short) (s | 256);
        }
        return s;
    }
}
