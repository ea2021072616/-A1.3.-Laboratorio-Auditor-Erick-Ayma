package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public abstract class h2 {

    /* renamed from: a  reason: collision with root package name */
    public static final l2.i f1882a;

    static {
        if (f2.f1864e && f2.f1863d) {
            int i5 = u.f1960a;
        }
        f1882a = new l2.i();
    }

    public static /* bridge */ /* synthetic */ int a(byte[] bArr, int i5, int i6) {
        int i7 = i6 - i5;
        byte b5 = bArr[i5 - 1];
        if (i7 == 0) {
            if (b5 <= -12) {
                return b5;
            }
            return -1;
        } else if (i7 == 1) {
            byte b6 = bArr[i5];
            if (b5 > -12 || b6 > -65) {
                return -1;
            }
            return (b6 << 8) ^ b5;
        } else if (i7 == 2) {
            byte b7 = bArr[i5];
            byte b8 = bArr[i5 + 1];
            if (b5 > -12 || b7 > -65 || b8 > -65) {
                return -1;
            }
            return (b8 << 16) ^ ((b7 << 8) ^ b5);
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00fe, code lost:
        return r10 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b(java.lang.String r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.h2.b(java.lang.String, byte[], int, int):int");
    }

    public static int c(String str) {
        int length = str.length();
        int i5 = 0;
        int i6 = 0;
        while (i6 < length && str.charAt(i6) < 128) {
            i6++;
        }
        int i7 = length;
        while (true) {
            if (i6 >= length) {
                break;
            }
            char charAt = str.charAt(i6);
            if (charAt < 2048) {
                i7 += (127 - charAt) >>> 31;
                i6++;
            } else {
                int length2 = str.length();
                while (i6 < length2) {
                    char charAt2 = str.charAt(i6);
                    if (charAt2 < 2048) {
                        i5 += (127 - charAt2) >>> 31;
                    } else {
                        i5 += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i6) < 65536) {
                                throw new g2(i6, length2);
                            }
                            i6++;
                        }
                    }
                    i6++;
                }
                i7 += i5;
            }
        }
        if (i7 >= length) {
            return i7;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i7 + 4294967296L));
    }

    public static boolean d(byte[] bArr, int i5, int i6) {
        f1882a.getClass();
        return l2.i.e(bArr, i5, i6);
    }
}
