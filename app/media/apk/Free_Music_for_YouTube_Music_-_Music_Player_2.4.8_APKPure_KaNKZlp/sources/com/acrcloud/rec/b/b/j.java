package com.acrcloud.rec.b.b;

import com.flurry.android.Constants;
/* compiled from: ACRCloudUtils.java */
/* loaded from: classes.dex */
public class j {
    public static double a(byte[] bArr, int i) {
        int i2;
        float f = 0.0f;
        int i3 = i >> 3;
        float f2 = 0.0f;
        for (int i4 = 0; i4 < i3; i4++) {
            short s = (short) (((short) (bArr[(i4 << 3) + 1] << 8)) | (bArr[i4 << 3] & Constants.UNKNOWN));
            f2 += i2 * i2;
            f += ((s >> 15) ^ s) - (s >> 15);
        }
        float f3 = f / i3;
        return Math.min(Math.log10(((f2 / i3) - (f3 * f3)) + 1.0f), 8.0d) / 8.0d;
    }
}
