package org.phprpc.util;

import com.flurry.android.Constants;
/* loaded from: classes2.dex */
public final class XXTEA {
    private static final int delta = -1640531527;

    private XXTEA() {
    }

    private static final int MX(int i, int i2, int i3, int i4, int i5, int[] iArr) {
        return (((i3 >>> 5) ^ (i2 << 2)) + ((i2 >>> 3) ^ (i3 << 4))) ^ ((i ^ i2) + (iArr[(i4 & 3) ^ i5] ^ i3));
    }

    public static final byte[] encrypt(byte[] bArr, byte[] bArr2) {
        return bArr.length == 0 ? bArr : toByteArray(encrypt(toIntArray(bArr, true), toIntArray(bArr2, false)), false);
    }

    public static final byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return bArr.length == 0 ? bArr : toByteArray(decrypt(toIntArray(bArr, false), toIntArray(bArr2, false)), true);
    }

    private static final int[] encrypt(int[] iArr, int[] iArr2) {
        int[] iArr3;
        int length = iArr.length - 1;
        if (length >= 1) {
            if (iArr2.length < 4) {
                iArr3 = new int[4];
                System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            } else {
                iArr3 = iArr2;
            }
            int i = iArr[length];
            int i2 = iArr[0];
            int i3 = (52 / (length + 1)) + 6;
            int i4 = 0;
            while (true) {
                int i5 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                int i6 = delta + i4;
                int i7 = (i6 >>> 2) & 3;
                int i8 = 0;
                while (i8 < length) {
                    i = iArr[i8] + MX(i6, iArr[i8 + 1], i, i8, i7, iArr3);
                    iArr[i8] = i;
                    i8++;
                }
                i = iArr[length] + MX(i6, iArr[0], i, i8, i7, iArr3);
                iArr[length] = i;
                i4 = i6;
                i3 = i5;
            }
        }
        return iArr;
    }

    private static final int[] decrypt(int[] iArr, int[] iArr2) {
        int[] iArr3;
        int length = iArr.length - 1;
        if (length >= 1) {
            if (iArr2.length < 4) {
                iArr3 = new int[4];
                System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            } else {
                iArr3 = iArr2;
            }
            int i = iArr[length];
            int i2 = iArr[0];
            for (int i3 = ((52 / (length + 1)) + 6) * delta; i3 != 0; i3 -= delta) {
                int i4 = (i3 >>> 2) & 3;
                int i5 = length;
                while (i5 > 0) {
                    i2 = iArr[i5] - MX(i3, i2, iArr[i5 - 1], i5, i4, iArr3);
                    iArr[i5] = i2;
                    i5--;
                }
                i2 = iArr[0] - MX(i3, i2, iArr[length], i5, i4, iArr3);
                iArr[0] = i2;
            }
        }
        return iArr;
    }

    private static final int[] toIntArray(byte[] bArr, boolean z) {
        int[] iArr;
        int length = (bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1;
        if (z) {
            iArr = new int[length + 1];
            iArr[length] = bArr.length;
        } else {
            iArr = new int[length];
        }
        int length2 = bArr.length;
        for (int i = 0; i < length2; i++) {
            int i2 = i >>> 2;
            iArr[i2] = iArr[i2] | ((bArr[i] & Constants.UNKNOWN) << ((i & 3) << 3));
        }
        return iArr;
    }

    private static final byte[] toByteArray(int[] iArr, boolean z) {
        int i;
        int length = iArr.length << 2;
        if (z) {
            i = iArr[iArr.length - 1];
            if (i > length) {
                return null;
            }
        } else {
            i = length;
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((iArr[i2 >>> 2] >>> ((i2 & 3) << 3)) & 255);
        }
        return bArr;
    }
}
