package org.phprpc.util;

import com.flurry.android.Constants;
import java.io.ByteArrayOutputStream;
/* loaded from: classes2.dex */
public final class Base64 {
    private static final char[] base64EncodeChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] base64DecodeChars = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    private Base64() {
    }

    public static final String encode(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length % 3;
        int length2 = bArr.length - length;
        int i = 0;
        while (i < length2) {
            int i2 = i + 1;
            int i3 = i2 + 1;
            int i4 = ((bArr[i2] & Constants.UNKNOWN) << 8) | ((bArr[i] & Constants.UNKNOWN) << 16);
            i = i3 + 1;
            int i5 = i4 | (bArr[i3] & Constants.UNKNOWN);
            stringBuffer.append(base64EncodeChars[i5 >> 18]);
            stringBuffer.append(base64EncodeChars[(i5 >> 12) & 63]);
            stringBuffer.append(base64EncodeChars[(i5 >> 6) & 63]);
            stringBuffer.append(base64EncodeChars[i5 & 63]);
        }
        if (length == 1) {
            int i6 = i + 1;
            int i7 = bArr[i] & Constants.UNKNOWN;
            stringBuffer.append(base64EncodeChars[i7 >> 2]);
            stringBuffer.append(base64EncodeChars[(i7 & 3) << 4]);
            stringBuffer.append("==");
        } else if (length == 2) {
            int i8 = i + 1;
            int i9 = i8 + 1;
            int i10 = ((bArr[i] & Constants.UNKNOWN) << 8) | (bArr[i8] & Constants.UNKNOWN);
            stringBuffer.append(base64EncodeChars[i10 >> 10]);
            stringBuffer.append(base64EncodeChars[(i10 >> 4) & 63]);
            stringBuffer.append(base64EncodeChars[(i10 & 15) << 2]);
            stringBuffer.append("=");
        }
        return stringBuffer.toString();
    }

    public static final byte[] decode(String str) {
        int i;
        byte b2;
        int i2;
        byte b3;
        int i3;
        byte b4;
        byte b5;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        int i4 = 0;
        while (i4 < length) {
            while (true) {
                i = i4 + 1;
                b2 = base64DecodeChars[bytes[i4]];
                if (i >= length || b2 != -1) {
                    break;
                }
                i4 = i;
            }
            if (b2 != -1) {
                while (true) {
                    i2 = i + 1;
                    b3 = base64DecodeChars[bytes[i]];
                    if (i2 >= length || b3 != -1) {
                        break;
                    }
                    i = i2;
                }
                if (b3 == -1) {
                    break;
                }
                byteArrayOutputStream.write((b2 << 2) | ((b3 & 48) >>> 4));
                while (true) {
                    i3 = i2 + 1;
                    byte b6 = bytes[i2];
                    if (b6 == 61) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    b4 = base64DecodeChars[b6];
                    if (i3 >= length || b4 != -1) {
                        break;
                    }
                    i2 = i3;
                }
                if (b4 == -1) {
                    break;
                }
                byteArrayOutputStream.write(((b3 & 15) << 4) | ((b4 & 60) >>> 2));
                while (true) {
                    i4 = i3 + 1;
                    byte b7 = bytes[i3];
                    if (b7 == 61) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    b5 = base64DecodeChars[b7];
                    if (i4 >= length || b5 != -1) {
                        break;
                    }
                    i3 = i4;
                }
                if (b5 == -1) {
                    break;
                }
                byteArrayOutputStream.write(b5 | ((b4 & 3) << 6));
            } else {
                break;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
