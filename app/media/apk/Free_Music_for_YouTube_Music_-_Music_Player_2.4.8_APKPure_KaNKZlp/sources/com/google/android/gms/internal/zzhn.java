package com.google.android.gms.internal;

import com.flurry.android.Constants;
import com.google.android.exoplayer2.C;
import java.io.UnsupportedEncodingException;
@zzzt
/* loaded from: classes.dex */
public final class zzhn {
    /* JADX WARN: Code restructure failed: missing block: B:49:0x007a, code lost:
        if (((r9 >= 65382 && r9 <= 65437) || (r9 >= 65441 && r9 <= 65500)) != false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] zzc(@android.support.annotation.Nullable java.lang.String r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhn.zzc(java.lang.String, boolean):java.lang.String[]");
    }

    public static int zzz(String str) {
        byte[] bytes;
        int i;
        int i2 = 0;
        try {
            bytes = str.getBytes(C.UTF8_NAME);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        int length = bytes.length;
        int i3 = (length & (-4)) + 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = ((bytes[i4] & Constants.UNKNOWN) | ((bytes[i4 + 1] & Constants.UNKNOWN) << 8) | ((bytes[i4 + 2] & Constants.UNKNOWN) << 16) | (bytes[i4 + 3] << 24)) * (-862048943);
            int i7 = i5 ^ (((i6 >>> 17) | (i6 << 15)) * 461845907);
            i4 += 4;
            i5 = (-430675100) + (((i7 >>> 19) | (i7 << 13)) * 5);
        }
        switch (length & 3) {
            case 3:
                i2 = (bytes[i3 + 2] & Constants.UNKNOWN) << 16;
            case 2:
                i2 |= (bytes[i3 + 1] & Constants.UNKNOWN) << 8;
            case 1:
                int i8 = ((bytes[i3] & Constants.UNKNOWN) | i2) * (-862048943);
                i = (((i8 >>> 17) | (i8 << 15)) * 461845907) ^ i5;
                break;
            default:
                i = i5;
                break;
        }
        int i9 = i ^ length;
        int i10 = (i9 ^ (i9 >>> 16)) * (-2048144789);
        int i11 = (i10 ^ (i10 >>> 13)) * (-1028477387);
        return i11 ^ (i11 >>> 16);
    }
}
